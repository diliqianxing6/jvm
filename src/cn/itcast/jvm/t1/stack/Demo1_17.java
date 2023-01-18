package cn.itcast.jvm.t1.stack;

import java.util.ArrayList;

/**
 * 局部变量的线程安全问题
 */
public class Demo1_17 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        new Thread(()->{
            m2(sb);
        }).start();
/*        new Thread(new Runnable() {
            @Override
            public void run() {
                m2(sb);
            }
        }).start();*/

        String a = "ac";
        System.out.println(strFc("ac"));
        System.out.println(a);

        Integer bint = 1;
        System.out.println(intFc(bint));
        System.out.println(bint);

        Student student = new Student();
        student.name = "zhangsan";
        System.out.println(studentFc(student).name);
        System.out.println(student.name);

        ArrayList<String> strList = new ArrayList<>();
        strList.add("wer");
        System.out.println("strList=="+listFc(strList).size());
        System.out.println("strList=="+strList.size());


    }

    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static void m2(StringBuilder sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        return sb;
    }

    public static String strFc(String a) {
        a = "bbb";
        return a;
    }

    public static Integer intFc(Integer bint) {
        bint = 2;
        return bint;
    }

    public static Student studentFc(Student student) {
        student.name = "lisi";
        return student;
    }

    public static ArrayList<String> listFc(ArrayList<String> strList) {
        strList.add("dfs");
        return strList;
    }
}
class Student{
    public String name;
}