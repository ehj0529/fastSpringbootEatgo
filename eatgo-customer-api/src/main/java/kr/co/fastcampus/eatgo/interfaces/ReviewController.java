package kr.co.fastcampus.eatgo.interfaces;

import io.jsonwebtoken.Claims;
import kr.co.fastcampus.eatgo.application.ReviewService;
import kr.co.fastcampus.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> create( Authentication authentication
                                    , @PathVariable("restaurantId") Long restaurantId
                                    , @Valid @RequestBody Review resource ) throws URISyntaxException
    {
        Claims claims = (Claims) authentication.getPrincipal(); //JWT 로 생성한 Token 에서 name 을 꺼내서 사용
        String name = claims.get("name",String.class);

        Review review = reviewService.addReview(restaurantId,
                                                name,
                                                resource.getScore(),
                                                resource.getDescription());
        String url = "/restaurants/"+restaurantId+"/reviews/"+review.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
