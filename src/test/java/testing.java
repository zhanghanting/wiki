import com.pride.config.SpringConfig;
import com.pride.domain.Corder;
import com.pride.domain.Custom;
import com.pride.mapper.CorderMapper;
import com.pride.mapper.CustomMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class testing {

    @Autowired
    SqlSessionFactoryBean sqlSessionFactoryBean;


    @Test
    public void test1() throws Exception {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CorderMapper mapper = sqlSession.getMapper(CorderMapper.class);
        Corder corder = mapper.selectByPrimaryKey("000001");
        System.out.println(corder);

    }

    @Autowired
    CustomMapper customMapper;
    @Test
    public void test2()
    {
        Custom custom = customMapper.selectByPrimaryKey("001");
        System.out.println(custom);
    }
}
