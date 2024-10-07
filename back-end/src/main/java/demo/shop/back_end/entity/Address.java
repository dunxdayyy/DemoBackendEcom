package demo.shop.back_end.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "addresses")
public class Address extends SharedEntity{

    String street;
    String buildingName;
    String city;
    String state;
    String country;
    String pinCode;

    @OneToOne(mappedBy = "addresses")
    User user;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
            @JsonBackReference
    User shippingAddress;

}
