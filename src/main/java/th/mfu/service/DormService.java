package th.mfu.service;

import java.util.List;

import th.mfu.model.Dorm;

public interface DormService {
    Iterable<Dorm> getAllDorms();

    List<Dorm> findByKeyword(String keyword);

    List<Dorm> getDormsSortedByPriceLowToHigh();

    List<Dorm> getDormsSortedByPriceHighToLow();

    List<Dorm> getDormsSortedByNameAlphabetically();

    Dorm findById(Long dormId);
}
