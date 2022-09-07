package dev.thebrogrammers.repos;

import dev.thebrogrammers.entities.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends MongoRepository<AppUser, String> {

    @Query("{'username': '?0'}")
    AppUser findByUsername(String username);
}
