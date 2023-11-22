package th.mfu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.mfu.model.Dorm;
import th.mfu.repository.DormRepository;
import th.mfu.service.DormService;

@Service
public class DormServiceImpl implements DormService{

    @Autowired
    private DormRepository dormRepository;

    @Override
    public List<Dorm> getAllDorms() {
        return dormRepository.findAll();
    }
    
}
