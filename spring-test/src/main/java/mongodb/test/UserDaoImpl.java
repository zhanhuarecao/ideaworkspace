package mongodb.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by zk on 2017/6/23.
 */
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    MongoOperations mongoOperations;

    public List<User> findAll(Map<String,Object> params, String collectionName) {
        //List<User> result = mongoTemplate.find(new Query(Criteria.where("id").lt(params.get("maxAge"))), User.class,collectionName);
        List<User> list = mongoTemplate.find(new Query(Criteria.where("id").gt(params.get("id"))), User.class,collectionName);

        User user = mongoOperations.findOne(new Query(Criteria.where("id").is(2)), User.class, "doctest");
        System.out.println(user);
       // List<User> list = mongoTemplate.findAll(User.class);
        return list;
    }
}
