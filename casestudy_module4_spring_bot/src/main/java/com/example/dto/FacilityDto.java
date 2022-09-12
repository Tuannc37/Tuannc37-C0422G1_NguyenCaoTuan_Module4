package com.example.dto;

import com.example.model.facility.FacilityType;
import com.example.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private Integer id;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^([A-Z0-9])[a-z0-9]+((\\s[A-Z0-9])[a-z0-9]+)+$", message = "Tên dịch vụ được phép chứa số.Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String name;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Diện tích phải là số dương")
    private Integer area;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Giá phải là số dương")
    private Double cost;

    @NotNull(message = "Không được để trống")
    @Min(value = 0, message = "Số người phải là số dương")
    private Integer maxPeople;

    @NotNull(message = "Không được để trống")
    private String standardRoom;
    private String descriptionOtherConvenience;

    @Min(value = 0, message = "Diện tích phải là số dương")
    private Double poolArea;

    @Min(value = 0, message = "Số tầng phải là số dương")
    private Integer numberOfFloors;
    private String facilityFree;
    private RentType rentType;

    private FacilityType facilityType;

    public FacilityDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
