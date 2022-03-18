package com.qep.measureprocessingservice.api;

import com.qep.measureprocessingservice.mappers.RequestMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;


@Controller
@RequestMapping(value = {"/measure"})
@CrossOrigin("*")
public class MeasureController {

    @Autowired
    MeasureService measureService;

    private static final Logger LOGGER = LogManager.getLogger(MeasureController.class);

    @PostMapping(value = "/cql/evaluate")
    @Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON})
    @Produces({javax.ws.rs.core.MediaType.APPLICATION_JSON})
    @ResponseBody
    public void evaluate(@RequestBody String requestMapper) {
        try {
            LOGGER.info("Request received in string cql");
            measureService.evaluateCql(requestMapper);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
