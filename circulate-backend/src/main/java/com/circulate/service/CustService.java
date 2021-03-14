package com.circulate.service;

import java.math.BigInteger;
import java.util.Optional;

import com.circulate.dto.CustMaster;

public interface CustService {
	
	Optional<CustMaster> getCustomerByCustomerId(BigInteger custId);

}
