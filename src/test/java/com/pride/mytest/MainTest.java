package com.pride.mytest;


import com.pride.domain.Custom;
import com.pride.mapper.CustomMapper;
import com.pride.mapper.TaskMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @Author: LifeTruth
 * @Date: 2019/5/17 14:34
 */

public class MainTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    Logger logger;


    @Before
    public void init() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
        logger = Logger.getLogger(this.getClass());
    }

    @After
    public void release() {
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void myTest1() {
        sqlSession = sqlSessionFactory.openSession();
        CustomMapper mapper = sqlSession.getMapper(CustomMapper.class);
        Custom custom = mapper.selectByPrimaryKey("001");
        System.out.println(custom);

    }

}
