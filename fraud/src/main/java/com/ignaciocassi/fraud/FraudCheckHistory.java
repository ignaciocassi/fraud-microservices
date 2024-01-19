package com.ignaciocassi.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraud_check_history_id_sequence",
            sequenceName = "fraud_check_history_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_check_history_id_sequence"
    )
    private Integer id;
    private LocalDateTime createdAt;
    private Integer customerId;
    private Boolean isFraudster;

}

