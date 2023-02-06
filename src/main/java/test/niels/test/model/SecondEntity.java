package test.niels.test.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Where(clause = "deleted=false")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SecondEntity {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Boolean deleted;

}
