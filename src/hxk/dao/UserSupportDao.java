package hxk.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import hxk.model.User;

/**
 * @author hxk
 * @description
 * mybatis的Dao的第三种实现方式..继承SqlSessionDaoSupport
 *2015年8月24日  下午7:00:49
 */
public class UserSupportDao extends SqlSessionDaoSupport{
    public List<User> get(){
	return getSqlSession().selectList("hxk.dao.UserDao.findAll");
    }
    
    public User find(String name){
	return getSqlSession().selectOne("hxk.dao.UserDao.find", name);
    }
    
}
