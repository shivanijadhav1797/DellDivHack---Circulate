package com.circulate.dto;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.List;

@Entity
public class CustMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger custId;
    
    @JsonProperty("fullName")
    private String fullNm;
    
    @JsonProperty("points")
    private BigInteger points;

    @OneToMany
    @JoinColumn(name = "custId")
    List<ReqMaster> reqMaster;

    public BigInteger getCustId() {
        return custId;
    }

    public void setCustId(BigInteger custId) {
        this.custId = custId;
    }

    public String getFullNm() {
        return fullNm;
    }

    public void setFullNm(String fullNm) {
        this.fullNm = fullNm;
    }

    public BigInteger getPoints() {
        return points;
    }

    public void setPoints(BigInteger points) {
        this.points = points;
    }
}