package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class UserServiceTests {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void getUsers(){

        List<User> mockUsers = userService.getUsers();
        mockUsers.add(User.builder()
                .email("tester@example.com")
                .name("tester")
                .level(3L)
                .build());

        given(userRepository.findAll()).willReturn(mockUsers);

        User user = mockUsers.get(0);
        assertThat(user.getName(), is("tester"));
    }

    @Test
    public void addUser(){
        String email ="admin@exmaple.com";
        String name ="Administrator";
        Long level = 100L;
        User mockUser = User.builder()
                .email(email)
                .name(name)
                .level(level)
                .build();

        given(userRepository.save(any())).willReturn(mockUser);

        User user = userService.addUser(email, name);

        assertThat(user.getName(), is(name));
    }

    @Test
    public  void  updateUser(){
        Long id = 1004L;
        String email ="admin@exmaple.com";
        String name ="SuperUser";
        Long level = 100L;

        User mockUser = User.builder().id(id).email(email).name("Administrator").level(1L).build(); ;
        given(userRepository.findById(id)).willReturn(Optional.of(mockUser));

        User user = userService.updateUser(id, email, name, level);

        verify(userRepository).findById(eq(id));

        assertThat(user.getName(), is("SuperUser"));
        assertThat(user.isAdmin(), is(true));
    }

    @Test
    public void deactivateUser(){
        Long id = 1004L;

        User mockUser = User.builder().id(id).email("admin@exmaple.com").name("Administrator").level(100L).build(); ;
        given(userRepository.findById(id)).willReturn(Optional.of(mockUser));

        User user = userService.deactivateUser(1004L);
        verify(userRepository).findById(1004L);
        assertThat(user.isAdmin(), is(false));
        assertThat(user.isActive(), is(false));
    }

}