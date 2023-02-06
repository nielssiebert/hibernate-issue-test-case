package test.niels.test.model;

import java.util.Set;

import org.hibernate.annotations.Where;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
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
public class FirstEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private Boolean deleted;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "firstEntity", cascade = CascadeType.ALL)
    // @OneToMany(fetch = FetchType.EAGER)
    // @JoinColumn(name = "id")
    private Set<JoinEntity> joins;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CustomName> customName;

    
}
