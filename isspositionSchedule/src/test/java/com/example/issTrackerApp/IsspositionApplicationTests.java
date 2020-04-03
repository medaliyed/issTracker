package com.example.issTrackerApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
@SpringBootTest
class IsspositionApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void addingNewPosition() throws Exception{
		Class.forName("org.h2.Driver");
        DBI dbi = new DBI("jdbc:h2:mem:ali");
        handle = dbi.open();

	}

}
