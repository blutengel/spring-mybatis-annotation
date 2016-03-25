package com.example.persistence;

import com.example.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zb1209144 on 2016/3/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Transactional
public class UserMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserDao userDao;        // 在MapperScanner配置时，会调用此mapper接口生成mapper实例，所以在启动时已经能够使用此bean了

    @Test
    public void testFindAllUsers() throws Exception {
        logger.warn(userDao.toString());
        logger.warn(userDao.findAllUsers().toString());
    }
}