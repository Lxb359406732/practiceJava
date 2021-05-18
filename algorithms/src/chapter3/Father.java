package chapter3;

class Father {
    int age;      // 年龄
    int hight;    // 身体高度

    public Father() {
        print();
        this.age=20;   //这里初始化 age 的值
    }

    public Father(int age) {
        this();      // 调用自己的第一个构造函数，下面的两个语句不执行的
        this.age = age;
        print();
    }

    public Father(int age, int hight) {
        this(age);   // 调用自己第二个构造函数  ，下面的两个语句不执行的
        this.hight = hight;
        print();
    }

    public void print() {
        System.out.println("I'am a " + age + "岁 " + hight + "尺高 tiger!");
    }
    public static void main(String[] args) {
        new Father(22,7);
    }
}