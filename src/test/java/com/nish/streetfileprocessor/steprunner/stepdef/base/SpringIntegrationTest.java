package com.nish.streetfileprocessor.steprunner.stepdef.base;

import org.junit.After;
import org.junit.Before;

public class SpringIntegrationTest {
	
	private String profiles;

	@Before
	public void init() {
		this.profiles = System.getProperty("spring.profiles.active");
	}

	@After
	public void after() {
		if (this.profiles != null) {
			System.setProperty("spring.profiles.active", this.profiles);
		}
		else {
			System.clearProperty("spring.profiles.active");
		}
	}
}