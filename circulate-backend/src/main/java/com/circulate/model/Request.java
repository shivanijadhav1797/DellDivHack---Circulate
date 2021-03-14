package com.circulate.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * request
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-13T18:43:08.118Z[GMT]")


public class Request   {
    @JsonProperty("requestId")
    private BigInteger requestId = null;

    @JsonProperty("userName")
    private String userName = null;

    @JsonProperty("deviceType")
    private String deviceType = null;

    @JsonProperty("deviceCondition")
    private String deviceCondition = null;

    @JsonProperty("address")
    private String address = null;

    @JsonProperty("pickupDate")
    private LocalDate pickupDate = null;

    @JsonProperty("requestDate")
    private LocalDate requestDate = null;

    @JsonProperty("modelNo")
    private String modelNo = null;

    @JsonProperty("pointsEarned")
    private BigInteger pointsEarned = null;

    @JsonProperty("status")
    private String status = null;
    
    @JsonProperty("custId")
    private BigInteger custId = null;

    
    
    public BigInteger getCustId() {
		return custId;
	}

	public void setCustId(BigInteger custId) {
		this.custId = custId;
	}

	public Request requestId(BigInteger requestId) {
        this.requestId = requestId;
        return this;
    }

    /**
     * Get requestId
     * @return requestId
     **/
    @Schema(description = "")

    public BigInteger getRequestId() {
        return requestId;
    }

    public void setRequestId(BigInteger requestId) {
        this.requestId = requestId;
    }

    public Request userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * Get userName
     * @return userName
     **/
    @Schema(description = "")

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Request deviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    /**
     * Get deviceType
     * @return deviceType
     **/
    @Schema(description = "")

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Request deviceCondition(String deviceCondition) {
        this.deviceCondition = deviceCondition;
        return this;
    }

    /**
     * Get deviceCondition
     * @return deviceCondition
     **/
    @Schema(description = "")

    public String getDeviceCondition() {
        return deviceCondition;
    }

    public void setDeviceCondition(String deviceCondition) {
        this.deviceCondition = deviceCondition;
    }

    public Request address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     * @return address
     **/
    @Schema(description = "")

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Request pickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
        return this;
    }

    /**
     * Get pickupDate
     * @return pickupDate
     **/
    @Schema(description = "")

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Request requestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
        return this;
    }

    /**
     * Get requestDate
     * @return requestDate
     **/
    @Schema(description = "")

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public Request modelNo(String modelNo) {
        this.modelNo = modelNo;
        return this;
    }

    /**
     * Get modelNo
     * @return modelNo
     **/
    @Schema(description = "")

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public Request pointsEarned(BigInteger pointsEarned) {
        this.pointsEarned = pointsEarned;
        return this;
    }

    /**
     * Get pointsEarned
     * @return pointsEarned
     **/
    @Schema(description = "")

    public BigInteger getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(BigInteger pointsEarned) {
        this.pointsEarned = pointsEarned;
    }


    /**
     * Get status
     * @return status
     **/
    @Schema(description = "")

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Request status(String status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Request request = (Request) o;
        return Objects.equals(this.requestId, request.requestId) &&
                Objects.equals(this.userName, request.userName) &&
                Objects.equals(this.deviceType, request.deviceType) &&
                Objects.equals(this.deviceCondition, request.deviceCondition) &&
                Objects.equals(this.address, request.address) &&
                Objects.equals(this.pickupDate, request.pickupDate) &&
                Objects.equals(this.requestDate, request.requestDate) &&
                Objects.equals(this.modelNo, request.modelNo) &&
                Objects.equals(this.pointsEarned, request.pointsEarned) &&
        Objects.equals(this.pointsEarned, request.pointsEarned);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, userName, status, deviceType, deviceCondition, address, pickupDate, requestDate, modelNo, pointsEarned);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class request {\n");

        sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("    deviceType: ").append(toIndentedString(deviceType)).append("\n");
        sb.append("    deviceCondition: ").append(toIndentedString(deviceCondition)).append("\n");
        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    pickupDate: ").append(toIndentedString(pickupDate)).append("\n");
        sb.append("    requestDate: ").append(toIndentedString(requestDate)).append("\n");
        sb.append("    modelNo: ").append(toIndentedString(modelNo)).append("\n");
        sb.append("    pointsEarned: ").append(toIndentedString(pointsEarned)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
