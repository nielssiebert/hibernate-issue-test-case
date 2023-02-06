package test.niels.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.niels.test.model.JoinEntity;

@Repository
public interface JoinEntityRepository extends JpaRepository<JoinEntity, String> {
    
}
