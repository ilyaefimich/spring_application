package com.epam.spring;

import com.epam.spring.domain.entity.UserEntity;
import com.epam.spring.utils.InitializationTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUsers extends InitializationTest {

    @Before
    public void init() {
        initListOfUsers();
        initUsersFacade();
    }

    @Test
    public void testCreateUser() {
        UserEntity user1 = users.get(0);
        UserEntity user2 = (UserEntity) bookingService.getUserById(0);
        Assert.assertEquals(user1, user2);
    }

    @Test
    public void testUpdateUser() {
        UserEntity user = new UserEntity("updatedUser", "updatedUser@epam.com");
        user.setId(1);
        bookingService.updateUser(user);
        Assert.assertEquals(user.getName(), bookingService.getUserById(1).getName());
        Assert.assertEquals(user.getEmail(), bookingService.getUserById(1).getEmail());
    }

    @Test
    public void testDeleteUser() {
        bookingService.deleteUser(1);
        Assert.assertEquals(null, bookingService.getUserById(1));
    }

}
