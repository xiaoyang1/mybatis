package com.test1;

import com.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Test {
    public static void main(String[] args) throws IOException{

        SqlSessionFactory sessionFactory= MyBatisUtil.getFactory();
        //创建能执行映射文件中sql的sqlSession
        SqlSession sqlSession=sessionFactory.openSession();
        String statement ="CRUDMapper.getUser";
        //1  是你映射文件的参数需要
        Users user=sqlSession.selectOne(statement,1);

        System.out.println(user);
        sqlSession.close();

    }

}
