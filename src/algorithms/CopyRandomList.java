package algorithms;

/**
 * author:oldmanw
 * create at:2018-04-26 15:11
 * https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class CopyRandomList {

    private RandomListNode clone(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        //把复制的节点放在原有节点后面：A->B->C 变成 A->A*->B->B*->C->C*
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        //创建复制节点的random链接
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //拆分链表
        RandomListNode cHead = head.next;
        cur = head;
        RandomListNode cur1 = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            if (cur1.next != null) cur1.next = cur1.next.next;
            cur = cur.next;
            cur1 = cur1.next;
        }

        return cHead;
    }

    public static void main(String[] args) {

    }

}

class RandomListNode {

    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
