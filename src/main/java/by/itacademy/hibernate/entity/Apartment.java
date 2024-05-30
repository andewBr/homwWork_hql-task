package by.itacademy.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String address;

    private Integer size;

    @OneToMany(mappedBy = "apartments")
    private List<User> users =  new ArrayList<>();

}
