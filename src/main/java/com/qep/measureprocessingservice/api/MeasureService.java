package com.qep.measureprocessingservice.api;

import com.qep.measureprocessingservice.execution.Executor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MeasureService {

    public ResponseEntity evaluateCql(String cqlRequest) {
        try {
            Executor executor = new Executor();
            executor.evaluateCql(cqlRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
