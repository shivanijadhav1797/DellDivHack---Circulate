package com.circulate.api;

import com.circulate.model.Request;
import com.circulate.service.RequestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@CrossOrigin
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-07T11:46:35.995Z[GMT]")
@RestController
public class RequestApiController implements RequestApi {

    private static final Logger log = LoggerFactory.getLogger(RequestApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    RequestService requestService;

    @org.springframework.beans.factory.annotation.Autowired
    public RequestApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addRequest(@Parameter(in = ParameterIn.DEFAULT, description = "Request object that needs to be added.", required=true, schema=@Schema()) @Valid @RequestBody Request body) {
        try {
            return new ResponseEntity<Void>(requestService.addNewRequest(body), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred in addRequest method  --> " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<List<Request>> getRequestyUserId(@Parameter(in = ParameterIn.PATH, description = "User ID", required=true, schema=@Schema()) @PathVariable("userId") BigInteger userId) {
        try {
            return new ResponseEntity<List<Request>>(requestService.getRequestsByUserId(userId), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred in getEntitiesByUserId method for user ID: " + userId + " --> " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<List<Request>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateRequest(@Parameter(in = ParameterIn.DEFAULT, description = "Request object that needs to be updated.", required=true, schema=@Schema()) @Valid @RequestBody Request body) {
        try {
            return new ResponseEntity<Void>(requestService.updateExistingRequest(body), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception occurred in updateRequest method  --> " + e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
