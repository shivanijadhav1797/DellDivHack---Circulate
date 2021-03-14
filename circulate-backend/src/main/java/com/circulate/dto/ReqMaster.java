package com.circulate.dto;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="TRAN_MASTER")
public class ReqMaster {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="tran_id")
    private BigInteger tranId;
    private String deviceTyp;
    private String deviceCdtn;
    private String address;
    private String modelId;
    private String requestDate;
    private String pickupDate;
    private BigInteger points;
    private String status;
    private BigInteger custId;


    /*@ManyToOne
    @JoinColumn(name = "custId")
    CustMaster custMaster;*/

    /*public CustMaster getCustMaster() {
        return custMaster;
    }

    public void setCustMaster(CustMaster custMaster) {
        this.custMaster = custMaster;
    }*/

    public BigInteger getTranId() {
        return tranId;
    }

    public void setTranId(BigInteger tranId) {
        this.tranId = tranId;
    }

    public String getDeviceTyp() {
        return deviceTyp;
    }

    public void setDeviceTyp(String deviceTyp) {
        this.deviceTyp = deviceTyp;
    }

    public String getDeviceCdtn() {
        return deviceCdtn;
    }

    public void setDeviceCdtn(String deviceCdtn) {
        this.deviceCdtn = deviceCdtn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public BigInteger getPoints() {
        return points;
    }

    public void setPoints(BigInteger points) {
        this.points = points;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getCustId() {
        return custId;
    }

    public void setCustId(BigInteger custId) {
        this.custId = custId;
    }


}