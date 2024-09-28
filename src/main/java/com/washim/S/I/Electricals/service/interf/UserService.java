package com.washim.S.I.Electricals.service.interf;

import com.washim.S.I.Electricals.dto.LoginRequest;
import com.washim.S.I.Electricals.dto.Response;
import com.washim.S.I.Electricals.dto.UserDto;
import com.washim.S.I.Electricals.entity.User;

public interface UserService {
    Response registerUser(UserDto registrationRequest);
    Response loginUser(LoginRequest loginRequest);
    Response getAllUsers();
    User getLoginUser();
    Response getUserInfoAndOrderHistory();
}
