package com.zk.task.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zk on 2017/7/23.
 * 注解式的定时任务
 */
@Component
public class TaskTest2 {

    @Scheduled(cron = "0/30 * * * * ?")
    public void testJob(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s = dateFormat.format(new Date());
        System.out.println("--------->通过注解实现的定时任务执行中"+s);
    }
}
