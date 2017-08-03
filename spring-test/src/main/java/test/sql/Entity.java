package test.sql;

/**
 * Created by zk on 2017/7/7.
 */
public class Entity {
    public static final String code = "7778";
    private static final String version = "10";
    private String name;
    private String age;

    public static String getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
