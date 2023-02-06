package test.niels.test.model;

import org.hibernate.annotations.Where;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// @Where(clause = "deleted=false")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class JoinEntity {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Boolean deleted;

    @ManyToOne
    @JoinColumn(name = "first_entity_id", referencedColumnName = "id")
    private FirstEntity firstEntity;

    @ManyToOne
    @JoinColumn(name = "second_entity_id", referencedColumnName = "id")
    private SecondEntity secondEntity;

    private String reason;

    

}
