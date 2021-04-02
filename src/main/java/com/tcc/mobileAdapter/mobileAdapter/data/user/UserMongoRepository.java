package com.tcc.mobileAdapter.mobileAdapter.data.user;

import com.tcc.mobileAdapter.mobileAdapter.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String>, UserRepository {
}
