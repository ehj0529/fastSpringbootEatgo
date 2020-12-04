package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Reservation;
import kr.co.fastcampus.eatgo.domain.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService( ReservationRepository reservationRepository ) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation( Long restaurantId, Long userId, String name, String date, String time, Integer partySize ) {
        //TODO
        Reservation reservation = Reservation.builder()
                .restaurantId(restaurantId)
                .userId(userId)
                .name(name)
                .date(date)
                .time(time)
                .partySize(partySize)
                .build();

        return reservationRepository.save(reservation);
    }
    //TODO
}
