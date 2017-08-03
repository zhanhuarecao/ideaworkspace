package test.sql;
import java.io.*;
import org.apache.tools.ant.*;
import org.apache.tools.ant.taskdefs.*;
import org.apache.tools.ant.types.*;

/**
 * Created by zk on 2017/6/22.
 */
public class AntExecSql {

   /*     <dependency>
      <groupId>org.apache.ant</groupId>
      <artifactId>ant</artifactId>
      <version>1.9.4</version>
    </dependency>*/
    public static void main(String[] args) {
        SQLExec sqlExec = new SQLExec();
//设置数据库参数
        sqlExec.setDriver("com.mysql.jdbc.Driver");
        sqlExec.setUrl("jdbc:mysql://192.168.95.133:3306/mybatis");
        sqlExec.setUserid("root");
        sqlExec.setPassword("123456");
//要执行的脚本
        sqlExec.setSrc(new File("F:\\ideaworkspace\\spring-test\\src\\a.sql"));
//有出错的语句该如何处理
        sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(
                SQLExec.OnError.class, "abort")));
        sqlExec.setPrint(true); //设置是否输出
//输出到文件 sql.out 中；不设置该属性，默认输出到控制台
        sqlExec.setOutput(new File("F:\\ideaworkspace\\spring-test\\src\\.out"));
        sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错
        sqlExec.execute();
    }
}
