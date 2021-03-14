package com.circulate.repository;

import com.circulate.dto.ReqMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReqMasterRepository extends JpaRepository<ReqMaster, BigInteger> {

    @Query("SELECT r FROM ReqMaster r WHERE r.custId = :custId ORDER BY requestDate DESC")
    Optional<List<ReqMaster>> getRequestByCustId(@Param("custId") BigInteger custId);

    @Query("SELECT r FROM ReqMaster r WHERE r.modelId = :modelNo")
    Optional<ReqMaster> getRequestByModelNo(@Param("modelNo") String modelNo);


}
