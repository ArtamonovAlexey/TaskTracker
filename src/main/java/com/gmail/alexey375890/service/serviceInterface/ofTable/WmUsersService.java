package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.model.WmUsers;

public interface WmUsersService {

    WmUsers save(Long userId);

    WmUsers get(Long userId);

    void delete(Long userId);
}
