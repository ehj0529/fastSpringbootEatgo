package kr.co.fastcampus.eatgo.utils;

import io.jsonwebtoken.Claims;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class JwtUtilTests {

    private static final String SECRET ="12345678901234567890123456789012";
    private  JwtUtil jwtUtil;

    @Before
    public void setUp() {
        jwtUtil = new JwtUtil(SECRET);
    }
    @Test
    public void createToken(){

        String token = jwtUtil.createToken(1004L, "Jonson", null);
        //String token = jwtUtil.createToken(2020L, "Owner", 1004L);

        assertThat(token, containsString("."));
        //assertThat(token, containsString("....."));
    }

    @Test
    public void getClaims(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb25zb24ifQ.3U3aY7n8II62ceEbSPaX30vI54ib0zbvw6TYGJ_lJcY";
        Claims claims = jwtUtil.getClaims(token);

        assertThat(claims.get("name"), is("Jonson"));
        assertThat(claims.get("userId",Long.class), is(1004L));
    }
}