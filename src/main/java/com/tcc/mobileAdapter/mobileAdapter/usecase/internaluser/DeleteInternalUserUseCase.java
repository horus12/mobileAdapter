package com.tcc.mobileAdapter.mobileAdapter.usecase.internaluser;

import com.tcc.mobileAdapter.mobileAdapter.data.internaluser.InternalUserMongoRepository;
import com.tcc.mobileAdapter.mobileAdapter.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteInternalUserUseCase {
    private final InternalUserMongoRepository internalUserRepository;

    public void execute(String userId) throws BaseException {
        if (internalUserRepository.findById(userId).isEmpty())
            throw new BaseException("user_not_found");
        internalUserRepository.deleteById(userId);
    }
}
