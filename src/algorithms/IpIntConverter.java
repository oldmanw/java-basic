package algorithms;

/**
 * author:oldmanw
 * create at:2018-05-03 21:03
 * 实现ip地址和整形数的相互转换
 */
public class IpIntConverter {

    /**
     * 整数转换为ip地址
     * @param ip
     * @return
     */
    public static String ip2str(long ip) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(ip >>> 24)).append(".");
        sb.append(String.valueOf((ip & 0xFFFFFF) >>> 16)).append(".");
        sb.append(String.valueOf((ip & 0xFFFF) >>> 8)).append(".");
        sb.append(String.valueOf(ip & 0xFF));
        return sb.toString();
    }

    /**
     * ip地址转换为整数(必须要使用long，否则会造成溢出)
     * @param ip 字符串类型的ip地址
     * @return
     */
    public static long str2ip(String ip) {
        //必须要转义！！
        String[] ips = ip.split("\\.");
        if (ips.length != 4) throw new IllegalArgumentException("ip address error!");
        for (String str :ips) {
            if (Integer.valueOf(str) > 255 || Integer.valueOf(str) < 0)
                throw new IllegalArgumentException("ip address error!");
        }
        long res = 0;
        for (String str : ips) {
            res += Integer.valueOf(str);
            res = res << 8;
        }
        //在循环中多移位了一次要移回去
        res = res >>> 8;
        return res;
    }

    public static void main(String[] args) {
        String ip = "255.168.73.131";
//        System.out.println(str2ip(ip));
        System.out.println(ip2str(str2ip(ip)));
    }

}
