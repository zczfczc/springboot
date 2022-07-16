package cn.zfc.test;

import cn.zfc.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * @auther:zfc
 * @Date:2022-07-14 21:10
 **/
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class Test1 {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void  Test(){
        String password = bCryptPasswordEncoder.encode("123456");
        boolean matches = bCryptPasswordEncoder.matches("123456", password);
        System.out.println("结果：" + password);
        System.out.println("抛弃：" + matches);

    }

}
