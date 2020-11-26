package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTests {
    @Test
    public void creation(){
        User user = User.builder()
                .email("tester@example.com")
                .name("Tester")
                .level(3L)
                .build();

        assertThat(user.getName(), is("Tester"));
        assertThat(user.isAdmin(), is(true));
        assertThat(user.isActive(), is(true));

        user.deactviate();

        assertThat(user.isActive(), is(false));
    }
}