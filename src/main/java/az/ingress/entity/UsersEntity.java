package az.ingress.entity;

import liquibase.repackaged.org.apache.commons.lang3.builder.ToStringExclude;
import lombok.*;



import javax.persistence.*;
import java.util.*;


import static javax.persistence.CascadeType.ALL;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@Builder
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "users",
            cascade = {ALL}
           )

@ToStringExclude
    private List<OrdersEntity> orders;

    @OneToOne(
            cascade = ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id",referencedColumnName = "id")

@ToStringExclude
    private ProfileEntity profile;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(orders, that.orders) && Objects.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, orders, profile);
    }
}
