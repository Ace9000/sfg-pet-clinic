package guru.springframework.sfgpetclinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }

    @Column(name = "name")
    private String name;
    @Override
    public String toString() {
        return name;
    }
}
