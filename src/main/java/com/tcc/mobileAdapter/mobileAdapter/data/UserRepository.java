package com.tcc.mobileAdapter.mobileAdapter.data;

import com.tcc.mobileAdapter.mobileAdapter.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(final User user);

    User findByCpf(String cpf);

    Optional<User> findByUserName(String name);

}
