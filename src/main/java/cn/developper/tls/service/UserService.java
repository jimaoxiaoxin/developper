package cn.developper.tls.service;

import cn.developper.tls.entity.User;

public interface UserService {
    /**
     * 保存用户
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    void removeUser(Long id);

    /**
     * 更新用户
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 根据id获取用户
     * @param user
     * @return
     */
    User getUserById(Long id);

    User findByUsername(String username);
}
