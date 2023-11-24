package th.mfu.service;

import java.util.List;

import th.mfu.dto.DormDto;
import th.mfu.model.Dorm;

public interface DormService {
    Iterable<Dorm> getAllDorms();

    List<Dorm> findByKeyword(String keyword);

    List<Dorm> getDormsSortedByPriceLowToHigh();

    List<Dorm> getDormsSortedByPriceHighToLow();

    List<Dorm> getDormsSortedByNameAlphabetically();

    Dorm findById(Long dormId);

    List<Dorm> findDormByLandlordId(Long landlordId);

    Dorm save(DormDto dormDto);

    void updateDormInfo(Dorm originalDorm, DormDto updateDorm);
}
