package com.ignaciocassi.validator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ignaciocassi.record.CustomerRecord;
import org.springframework.http.ResponseEntity;
import java.util.Map;

public class CustomerUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static CustomerRecord extractCustomerFromResponse(ResponseEntity<Object> response) {
        Map<String, Object> responseBody = mapper.convertValue(response.getBody(), Map.class);
        Map<String, Object> data = (Map<String, Object>) responseBody.get("data");
        return mapper.convertValue(data, CustomerRecord.class);
    }
}