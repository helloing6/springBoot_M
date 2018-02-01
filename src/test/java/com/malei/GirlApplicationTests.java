package com.malei;

import com.malei.service.TestService;
import com.malei.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlApplicationTests {

	@Autowired
	private TestService mTestService;

	@Test
	public void contextLoads() {
		mTestService.test4();
	}

}
