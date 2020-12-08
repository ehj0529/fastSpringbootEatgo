package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Reservation;
import kr.co.fastcampus.eatgo.domain.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService( ReservationRepository reservationRepository ) {
        this.reservationRepository = reservationRepository;
    }


    public List<Reservation> getReservations( Long restaurantId ) {
        return reservationRepository.findAllByRestaurantId(restaurantId);
    }
}
