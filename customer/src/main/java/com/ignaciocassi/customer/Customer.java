package com.ignaciocassi.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "customer_id_sequence")
    @SequenceGenerator(name = "customer_id_sequence",
            sequenceName = "customer_id_sequence")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}
