package reflection;

import annotations.Idiot;

/**
 * author:oldmanw
 * create at:2018-05-03 11:01
 */

@Idiot
public class PojoClass {

    private String name = "hehe";

    private int age = 10;

    private String sex = "male";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private void shit(Integer num) {
        System.out.println("shit Number " + num + " stinks!");
    }
}
