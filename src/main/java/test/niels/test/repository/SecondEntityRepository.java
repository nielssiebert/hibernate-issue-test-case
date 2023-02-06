package test.niels.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.niels.test.model.SecondEntity;

@Repository
public interface SecondEntityRepository extends JpaRepository<SecondEntity, String> {
    
}
