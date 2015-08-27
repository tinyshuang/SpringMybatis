package hxk.dao;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import hxk.model.User;

/**
 * @author hxk
 * @description
 *2015年8月24日  下午5:46:39
 */
@Repository
public class UserTemplateDao {
    @Resource
    private SqlSession sqlSession;
    
    public User get(String name){
	return sqlSession.selectOne("hxk.dao.UserDao.find",name);
    }
    
    
    /**
     * @description 批量插入
     * 在template里面注入多一个<constructor-arg index="1" value="BATCH" />属性	
     *2015年8月24日  下午6:51:48
     *返回类型:void
     */
    public void insertUsers(){
	User one  = new User("one", "123456", "0");
	User two  = new User("two", "123456", "0");
	User three  = new User("three", "123456", "0");
	List<User> users = Arrays.asList(one,two,three);
	for (User user : users) {
	    sqlSession.insert("hxk.dao.UserDao.save",user);
	}
    }

}
