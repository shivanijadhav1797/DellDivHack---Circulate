package com.circulate.repository;

import com.circulate.dto.CustMaster;
import com.circulate.dto.ReqMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface CustMasterRepository extends JpaRepository<CustMaster, BigInteger> {

    @Query("SELECT c.fullNm FROM CustMaster c WHERE c.custId = :custId ")
    Optional<String> getCustomerNameFromCustId(@Param("custId") BigInteger custId);

}
