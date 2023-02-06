package test.niels.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.niels.test.model.FirstEntity;

@Repository
public interface FirstEntityRepository extends JpaRepository<FirstEntity, String> {
    
}
