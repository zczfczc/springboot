package cn.zfc.test;

import java.util.UUID;

/**
 * @auther:zfc
 * @Date:2022-07-14 21:10
 **/
public class Test1 {
    public static void main(String[] args) {
        String s = UUID.randomUUID().toString().replace("-","");
        System.out.println(s);
    }
}
