package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.UserService;
import kr.co.fastcampus.eatgo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list(){
        List<User> users = userService.getUsers();
        return users;
    }

    // user create ->  회원가입.
    @PostMapping("/users")
    public ResponseEntity<?> create(
            @RequestBody User resource
    ) throws URISyntaxException {

        String email= resource.getEmail();
        String name =  resource.getName();

        User user = userService.addUser(email, name);

        String url="/users/"+user.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }

    // user 수정 update
    @PatchMapping("/users/{id}")
    public String update(
            @PathVariable("id") Long id,
            @RequestBody User resource
    ){
        String email = resource.getEmail();
        String name = resource.getName();
        Long level = resource.getLevel();

        userService.updateUser(id, email, name, level);

        return "{}";
    }

    // user 삭제 delete -> level 0으로 변경
    @DeleteMapping("/users/{id}")
    public String delete(
            @PathVariable("id") Long id
    ){
        userService.deactivateUser(id);
        return "{}";
    }
    // 1: customer , 2. restaurant owner, 3, admin

}
