package com.circulate.service.impl;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.circulate.dto.CustMaster;
import com.circulate.repository.CustMasterRepository;
import com.circulate.service.CustService;

@Service
public class CustServiceImpl implements CustService {

	private CustMasterRepository custRepository;

	public CustServiceImpl(CustMasterRepository custRepository) {
		super();
		this.custRepository = custRepository;
	}

	@Override
	public Optional<CustMaster> getCustomerByCustomerId(BigInteger custId) {
		return custRepository.findById(custId);
	}

}
