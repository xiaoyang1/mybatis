package com.testCRUD;

import com.test1.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/*
  基于注解的方式，必须先创建一个接口，使用注解指明方法要执行的SQL
  实现是动态产生的，不需要自己去实现
  同样需要注册，因为test的时候去通过这个去反射得到mapper类的
 */
public interface UserMapper {

    @Insert("insert into users(name,age,Birthday) values(#{name},#{age},#{Birthday})")
    public int addUser(Users user);
    @Delete("delete from users where id = #{id}")
    public int deleteById (int id);
    @Update("update users set name=#{name},age=#{age},birthday=#{Birthday} where id =#{id}")
    public int updateById(int id);
    @Select("select * from users where id =#{id}")
    public Users getById(int id);
    @Select(" select * from users ")
    public List<Users> getAll();
}
