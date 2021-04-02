package com.tcc.mobileAdapter.mobileAdapter.data.internaluser;

import com.tcc.mobileAdapter.mobileAdapter.domain.InternalUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalUserMongoRepository extends MongoRepository<InternalUser, String>, InternalUserRepository{

}

