package test.niels.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import test.niels.test.model.FirstEntity;
import test.niels.test.repository.FirstEntityRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class FirstEntityService {

    private final FirstEntityRepository firstEntityRepository;

    public FirstEntity findFirstEntity(final String id) {

        Optional<FirstEntity> fOptional = firstEntityRepository.findById(id);

        if(fOptional.isPresent()) {
            FirstEntity entity = fOptional.get();
            log.info(entity.toString());
            entity.getCustomName();
            entity.getJoins();
            return entity;
        }

        return FirstEntity.builder().deleted(false).id("12asdf3").build();
    }

    public List<FirstEntity> findAll() {
        return firstEntityRepository.findAll();
    }

    public FirstEntity saveFirstEntity(FirstEntity firstEntity) {
        return firstEntityRepository.save(firstEntity);
    }
}
