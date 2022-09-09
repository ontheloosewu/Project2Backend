package dev.thebrogrammers.daycare;

import dev.thebrogrammers.dtos.LoginCredentials;
import dev.thebrogrammers.entities.AppUser;
import dev.thebrogrammers.repos.AppUserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class AppUserRepoTests {

    @Autowired
    AppUserRepo appUserRepo;

    @Test
    void find_by_username_test(){
        AppUser sam = new AppUser(null, "appusertest", "pa$$word", "teacher");
        appUserRepo.save(sam);
        Assertions.assertEquals("teacher", appUserRepo.findByUsername("appusertest").getRole());
        appUserRepo.delete(appUserRepo.findByUsername("appusertest"));
    }
}
