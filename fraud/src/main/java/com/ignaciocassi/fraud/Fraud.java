package com.ignaciocassi.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Fraud {
    @Id
    private Integer id;
    private Date createdAt;
    private Integer customerId;
    private Boolean isFraudster;
}
