package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    @Test
    public void create() throws Exception {

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb25zb24ifQ.3U3aY7n8II62ceEbSPaX30vI54ib0zbvw6TYGJ_lJcY";

        Long userId =1004L;
        String name = "Jonson";
        String date ="2020-12-24";
        String time ="20:00";
        Integer partySize = 20 ;


        mvc.perform(post("/restaurants/369/reservations")
                .header("Authorization","Bearer "+token)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"date\":\"2020-12-24\",\"time\":\"20:00\",\"partySize\":20}"))
                .andExpect(status().isCreated())
        ;
        verify(reservationService).addReservation(eq(369L), eq(userId), eq(name), eq(date), eq(time), eq(partySize));


    }

}