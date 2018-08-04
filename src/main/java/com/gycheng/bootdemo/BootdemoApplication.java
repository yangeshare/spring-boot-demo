package com.gycheng.bootdemo;

import com.gycheng.bootdemo.bean.ConfigStatus;
import com.gycheng.bootdemo.util.DemoUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**SpringBootApplication注解：Spring Boot项目的核心注解，主要目的是开启自动配置
 * RestController注解：等价于@Controller+@ResponseBody的结合，使用这个注解的类里面的方法都以json格式输出
 *
 */

@RestController
@SpringBootApplication
@EnableConfigurationProperties({ConfigStatus.class})
@MapperScan("com.gycheng.bootdemo.domain.dao")
public class BootdemoApplication {

	@RequestMapping("/")
	public String index(){
		return configStatus.getCode() + DemoUtil.COLON_SPERATOR + configStatus.getMsg();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootdemoApplication.class, args);

		DemoServer.getInstance().startUp();
	}

	@Autowired
	private ConfigStatus configStatus;
}
