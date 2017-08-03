package com.zk.task.test;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zk on 2017/7/23.
 */

/*
* 编写一个普通的pojo类，然后加上@Component或@Service注解，
* 在spring.xml文件中配置这个定时任务
* */
@Component
public class TaskTest {


    /*
    * 编写定时器测试方法
    * */
    public void testJob(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = dateFormat.format(new Date());
        System.out.println("--------->定时任务执行中"+s);
    }
}
