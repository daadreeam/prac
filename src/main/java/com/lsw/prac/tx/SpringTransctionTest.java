package com.lsw.prac.tx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import java.util.Date;

public class SpringTransctionTest {

    public static void main(String[] args) {
        Configuration configuration = new Configuration(new Environment(
                "myid",
                new ManagedTransactionFactory(),
                new PooledDataSource(
                        "com.mysql.jdbc.Driver",
                        "jdbc:mysql://localhost:3306/practice_pro",
                        "root",
                        "lsw"

                )
        ));
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        User o = (User) sqlSession.selectOne("select * from user where id = 1");
//        System.out.println("o = " + o);
        sqlSession.close();
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class User {

        private Long id;
        private String name;
        private String phone;
        private Date createTime;
        private Date updateTime;

    }




}
