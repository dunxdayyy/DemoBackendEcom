package demo.shop.back_end.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User extends SharedEntity{

    String firstName;
    String lastName;
    String mobileNumber;
    String email;
    String password;

    @OneToOne(mappedBy = "addresses", cascade = CascadeType.ALL, orphanRemoval = true)
            @JoinColumn(name = "address")
    Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<Address> shippingAddress;
}
