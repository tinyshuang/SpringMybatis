# SpringMybatis

项目说明 : 
==============================================================
	这是一个spring-mybatis整合的项目...使用spring-mvc做控制器..使用了三种dao的实现方式..


###定义 : MyBatis 是支持定制化 SQL、存储过程以及高级映射的优秀的持久层框架。

###优点 : MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。


Mybatis官方文档 : 
http://mybatis.github.io/mybatis-3/zh/index.html

Mybatis-spring官方文档 : 
http://mybatis.github.io/spring/zh/index.html

Dao的分类 :  

*⑴使用接口映射mapper的方式.*    

 方式 : 简单,易用..接口声明的方法就是mapper里面id的属性值..

*⑵Template方式*    

	方式 : 
		在spring的配置文件中注入如下模板类,然后直接注入调用  
		
			` <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		  		<constructor-arg index="0" ref="sqlSessionFactory" />
			</bean>`

*⑶UserSupportDao方式*   

	方式 :
		直接继承该类...然后调用getSqlSession()再去调用相应的类就行
