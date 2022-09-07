package dev.thebrogrammers.daycare;

import dev.thebrogrammers.entities.AppUser;
import dev.thebrogrammers.repos.AppUserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class DaycareApplicationTests {

	@Autowired
	AppUserRepo appUserRepo;
	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	void create_teacher()
	{
		AppUser sam = new AppUser(null, "sam54", "pa$$word", "teacher");
		appUserRepo.save(sam);
		Assertions.assertNotNull(sam.getId());
	}



}
