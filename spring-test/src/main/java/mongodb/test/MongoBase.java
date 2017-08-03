package mongodb.test;

import java.util.List;
import java.util.Map;

/**
 * Created by zk on 2017/6/23.
 */
public interface MongoBase<T> {
    //查找所有
    public List<T> findAll(Map<String,Object> params,String collectionName);
}
