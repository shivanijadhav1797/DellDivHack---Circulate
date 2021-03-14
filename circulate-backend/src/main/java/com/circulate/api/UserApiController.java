package com.circulate.api;

import java.math.BigInteger;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.circulate.dto.CustMaster;
import com.circulate.service.CustService;

@RestController
public class UserApiController implements UserApi {

	private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

	private CustService custService;

	public UserApiController(CustService custService) {
		super();
		this.custService = custService;
	}

	@Override
	public ResponseEntity<CustMaster> getCustomerByUserId(@PathVariable("custId") BigInteger customerId) {

		Optional<CustMaster> customerDetails = custService.getCustomerByCustomerId(customerId);

		if (!customerDetails.isPresent())
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(customerDetails.get());
	}

}
