package th.mfu.service.Impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.dto.DormDto;
import th.mfu.model.Dorm;
import th.mfu.repository.DormRepository;
import th.mfu.service.DormService;

@Service
public class DormServiceImpl implements DormService{

    private Long dormId = 11L;

    @Autowired
    private DormRepository dormRepository;

    @Override
    public Iterable<Dorm> getAllDorms() {
        return dormRepository.findAll();
    }

    @Override
    public List<Dorm> findByKeyword(String keyword) {
        List<Dorm> searchResults = new ArrayList<>();
        for (Dorm dorm : dormRepository.findAll()) {
            //you can add dorm description here
            if (dorm.getDormName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(dorm);
            }
        }
        return searchResults;
    }

    @Override
    public List<Dorm> getDormsSortedByPriceLowToHigh() {
        List<Dorm> sortedDorms = new ArrayList<>();
        dormRepository.findAll().forEach(sortedDorms::add); 
        sortedDorms.sort(Comparator.comparing(Dorm::getPrice));
        return sortedDorms;
    }

    @Override
    public List<Dorm> getDormsSortedByPriceHighToLow() {
        List<Dorm> sortedDorms = new ArrayList<>();
        dormRepository.findAll().forEach(sortedDorms::add); 
        sortedDorms.sort(Comparator.comparing(Dorm::getPrice).reversed());
        return sortedDorms;
    }

    @Override
    public List<Dorm> getDormsSortedByNameAlphabetically() {
        List<Dorm> sortedDorms = new ArrayList<>();
        dormRepository.findAll().forEach(sortedDorms::add); 
        sortedDorms.sort(Comparator.comparing(Dorm::getDormName));
        return sortedDorms;
    }

    @Override
    public Dorm findById(Long dormId) {
        Dorm dorm = dormRepository.findById(dormId).get();
        return dorm;
    }

    @Override
    public List<Dorm> findDormByLandlordId(Long landlordId) {
        return dormRepository.findDormsByLandlordId(landlordId);
    }

    @Override
    public Dorm save(DormDto dormDto) {
        Dorm dorm = new Dorm(dormId,dormDto.getDormName(),dormDto.getDormDesc(),dormDto.getPrice(),dormDto.getBedroom(),dormDto.getBathroom(),
                    dormDto.getImg1(),dormDto.getImg2(),dormDto.getImg3(),dormDto.getImg4(),dormDto.getCity(),dormDto.getAmenities(),
                    dormDto.getLatitude(),dormDto.getLongitude(),dormDto.getLandlord());
        dormId++;
        return dormRepository.save(dorm);
    }
    
}
