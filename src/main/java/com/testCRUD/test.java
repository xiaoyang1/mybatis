package com.testCRUD;


import com.test1.Classes;
import com.test1.ConditionUser;
import com.test1.Users;
import com.util.MyBatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {
    private  static  SqlSessionFactory factory= null;
    private  static SqlSession session = null;
    static {

        try {
            factory = MyBatisUtil.getFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
         session= factory.openSession();
    }
    @Test
    public void testAdd(){

        //namespace + id
        String statement = "CRUDMapper.addUser";
        Date date=new Date();
        session.insert(statement,new Users(-1,"zhangdan",21,date));
        session.insert(statement,new Users(-1,"yangyang",22,date));
        //执行完以后要记得提交，否则是不会保存的。
        session.commit();
        session.close();
    }

    @Test
    public void  testUpdate(){
        String statement="CRUDMapper.updateUser";
        Date date=new Date();
        Users user=new Users(1,"shuaixuan",21,date);

        int result=session.update(statement,user);
        session.commit();
        session.close();
        System.out.println(result);
    }

    @Test
    public void testDelete(){
        String statement="CRUDMapper.deleteUser";
        int delete = session.delete(statement,2);
        System.out.println(delete);
        session.commit();
        session.close();
    }
    @Test
    public void testGet(){
        String statement ="CRUDMapper.getUser";
        Users user=session.selectOne(statement,1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testGetAll(){
        String statement = "CRUDMapper.getAll";
        List<Users> usersList =session.selectList(statement);
        session.close();
        for(Users user: usersList){
            System.out.println(user);
        }
    }

    @Test
    public void testAnnotationGetone(){
        //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
        UserMapper mapper=session.getMapper(UserMapper.class);
        Users user = mapper.getById(1);
        System.out.println(user);

        session.close();
    }

    @Test  //一对一关联表查询 嵌套结果
    public void testOne2One(){
        String statement = "ClassMapper.getClass";
        Classes classes=session.selectOne(statement,2);
        System.out.println(classes);
        session.close();
    }
    @Test  //一对一关联表查询 嵌套结果
    public void testOne2One2(){
        String statement = "ClassMapper.getClass2";
        Classes classes=session.selectOne(statement,3);
        System.out.println(classes);
        session.close();
    }

    @Test  //一对一关联表查询 嵌套结果
    public void testOne2More(){
        //String statement = "One2MoreMapper.getClass";
        String statement ="One2MoreMapper.getClass2";
        Classes classes=session.selectOne(statement,2);
        System.out.println(classes);
        session.close();
    }

    @Test
    public  void testDynamicSearch(){
        String statement ="DynamicMapper.getUser";
        String name ="j";
        ConditionUser parameter=new ConditionUser("%"+name+"%",13,18);
        List<Users> list=session.selectList(statement,parameter);
        System.out.println(list);

        session.close();
    }
    @Test
    public void testStoreProc(){
        String statement ="UserMapper.getUserCount";
        Map<String,Integer> parameterMap=new HashMap<String, Integer>();
        parameterMap.put("sexid",0);
        parameterMap.put("usercount",-1);
        session.selectOne(statement,parameterMap);
        int result=parameterMap.get("usercount");
        System.out.println(result);
    }
}
