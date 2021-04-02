package com.tcc.mobileAdapter.mobileAdapter.data.internaluser;

import com.tcc.mobileAdapter.mobileAdapter.domain.InternalUser;

public interface InternalUserRepository {

    InternalUser save(final InternalUser user);

    InternalUser findByEmail(String email);
}
