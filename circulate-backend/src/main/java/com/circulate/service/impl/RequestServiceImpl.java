package com.circulate.service.impl;

import com.circulate.constant.ExceptionConstants;
import com.circulate.dto.CustMaster;
import com.circulate.dto.ReqMaster;
import com.circulate.exception.CirculateException;
import com.circulate.model.Request;
import com.circulate.repository.CustMasterRepository;
import com.circulate.repository.ReqMasterRepository;
import com.circulate.service.RequestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	ReqMasterRepository reqMasterRepository;

	@Autowired
	CustMasterRepository custMasterRepository;

	public static final Logger logger = LogManager.getLogger(RequestServiceImpl.class);

	@Override
	public Void addNewRequest(Request request) throws Exception {
		Optional<ReqMaster> reqMaster = reqMasterRepository.getRequestByModelNo(request.getModelNo());
		if (reqMaster.isPresent()) {
			throw new CirculateException(ExceptionConstants.ENTITY_ALREADY_EXISTS);
		}
		request.setStatus("PENDING");
		request.setPointsEarned(BigInteger.ZERO);

		reqMasterRepository.save(setJsonToDtoData(request, false));
		logger.info("addNewEntity :: Data added successfully for ID : " + request.getRequestId());
		return null;
	}

	@Override
	public Void updateExistingRequest(Request request) throws Exception {
		Optional<ReqMaster> reqMaster = reqMasterRepository.findById(request.getRequestId());
		Optional<CustMaster> custMaster = custMasterRepository.findById(request.getCustId());
		if (reqMaster.isPresent() && custMaster.isPresent()) {
			CustMaster custBeanToUpdate = custMaster.get();
			custBeanToUpdate.setPoints(custBeanToUpdate.getPoints().add(request.getPointsEarned()));
			reqMasterRepository.save(setJsonToDtoData(request, true));
			custMasterRepository.save(custBeanToUpdate);
		}
		return null;
	}

	@Override
	public List<Request> getRequestsByUserId(BigInteger custId) {
		Optional<List<ReqMaster>> reqMasterList = reqMasterRepository.getRequestByCustId(custId);
		Optional<String> customerName = custMasterRepository.getCustomerNameFromCustId(custId);
		if (reqMasterList.isPresent()) {
			logger.info("getRequestByUserId :: Data fetched successfully for ID : " + custId);
			List<Request> requestListResponse = new ArrayList<>();
			for (ReqMaster entityMaster : reqMasterList.get()) {
				requestListResponse.add(setDtoToJsonData(entityMaster, customerName.get()));
			}
			return requestListResponse;
		}
		logger.info("getEntitiesByUserId :: Returning NULL from getEntitiesByUserId method");
		return null;
	}

	private Request setDtoToJsonData(ReqMaster reqMaster, String customerName) {
		Request req = new Request();
		req.setRequestId(reqMaster.getTranId());
		req.setUserName(customerName);
		req.setRequestDate(LocalDate.parse(reqMaster.getRequestDate()));
		req.setAddress(reqMaster.getAddress());
		req.setDeviceType(reqMaster.getDeviceTyp());
		req.setDeviceCondition(reqMaster.getDeviceCdtn());
		req.setPickupDate(LocalDate.parse(reqMaster.getPickupDate()));
		req.setModelNo(reqMaster.getModelId());
		req.setPointsEarned(reqMaster.getPoints());
		req.setStatus(reqMaster.getStatus());
		req.setCustId(reqMaster.getCustId());
		return req;
	}

	private ReqMaster setJsonToDtoData(Request request, boolean isUpdateTransaction) {
		ReqMaster req = new ReqMaster();
		if (isUpdateTransaction)
			req.setTranId(request.getRequestId());
		
		req.setRequestDate(isUpdateTransaction ? request.getRequestDate().toString() : LocalDate.now().toString());
		req.setAddress(request.getAddress());
		req.setDeviceTyp(request.getDeviceType());
		req.setDeviceCdtn(request.getDeviceCondition());
		req.setPickupDate(request.getPickupDate().toString());
		req.setModelId(request.getModelNo());
		req.setPoints(request.getPointsEarned());
		req.setStatus(request.getStatus());
		req.setCustId(request.getCustId());
		return req;
	}

}
