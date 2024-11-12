package org.wrn.train.member;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan("org.wrn")
@MapperScan("org.wrn.train.member.mapper")
public class MemberApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(MemberApplication.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MemberApplication.class);
        Environment environment = app.run(args).getEnvironment();
        LOGGER.info("member 启动成功");
        LOGGER.info("测试地址: \thttp://127.0.0.1:{}{}/hello", environment.getProperty("server.port"), environment.getProperty("server.servlet.context-path"));
    }
}
