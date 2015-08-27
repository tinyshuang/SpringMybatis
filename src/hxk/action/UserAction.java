package hxk.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hxk.dao.UserDao;
import hxk.dao.UserSupportDao;
import hxk.dao.UserTemplateDao;
import hxk.model.User;

/**
 * @author hxk
 * @description 简单的Action的Demo..实现了增删改查..
 *2015年8月24日  下午1:51:15
 */
@Controller
@RequestMapping("/user/")
public class UserAction {
    //spring-mybatis会帮我们注入好一个dao
    //我们的dao层现在分为两个部分,一个是dao的接口声明,一个是mapper里面实现dao
    @Resource
    private UserDao userDao;
    
    
    @Resource
    private UserTemplateDao userTemplateDao;
    
    @Resource
    private UserSupportDao userSupportDao;
    
    @RequestMapping("save")
    public @ResponseBody String save(){
	User user = new User("tinys", "123456", "0");
	userDao.save(user);
	return "save ok";
    }
    
    @RequestMapping("update")
    public @ResponseBody String update(){
	User user = new User("tinys", "123456", "1");
	userDao.update(user);
	return "update ok";
    }
    
    @RequestMapping("delete")
    public @ResponseBody String delete(){
	userDao.delete("tinys");
	return "delete ok";
    }
    
    @RequestMapping("find")
    public @ResponseBody String find(){
	User user = userDao.find("tinys");
	return user.getName() + user.getPwd() + user.getRole();
    }
    
    @RequestMapping("get")
    public @ResponseBody String get(){
	User user = userTemplateDao.get("tinys");
	return user.getName() + user.getPwd() + user.getRole();
    }
    
    @RequestMapping("insert")
    public @ResponseBody String insertAll(){
	userTemplateDao.insertUsers();
	return "ok";
    }
    
    @RequestMapping("getAll")
    public @ResponseBody String getALl(){
	List<User> users = userSupportDao.get();
	for (User user : users) {
	    System.out.println(user.getName());
	}
	return "ok";
    }
    
}
