package com.circulate.service;

import com.circulate.model.Request;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface RequestService {

    public Void addNewRequest(Request request) throws Exception;
    public Void updateExistingRequest(Request request) throws Exception;
    public List<Request> getRequestsByUserId(BigInteger userId) throws Exception;

}
