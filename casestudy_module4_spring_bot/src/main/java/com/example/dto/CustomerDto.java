package com.example.dto;

import com.example.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;

public class CustomerDto implements Validator {
    private int id;

    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String name;

    private String dateOfBirth;
    private int gender;
    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String idCard;
    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String phoneNumber;

    @Email
    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String email;
    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String dateOfBirth, int gender, String idCard, String phoneNumber, String email, String address, int status, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        String customerDtoName = customerDto.getName();
        String customerDtoPhone = customerDto.getPhoneNumber();
        String customerDtoIdCard = customerDto.getIdCard();

        if (!customerDtoName.matches("^([A-Z]{1}[a-z]{1,}\\s{1}){1,}([A-Z]{1}[a-z]{1,})+$")) {
            errors.rejectValue("name", "customerDtoName", "Kí tự đầu tiên của mỗi từ phải viết hoa");
        }
        if (!customerDtoPhone.matches("^(091|090|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}+$")) {
            errors.rejectValue("phoneNumber", "customerDtoPhone", "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }
        if (!customerDtoIdCard.matches("^\\d{9}+$")) {
            errors.rejectValue("idCard", "customerDtoIdCard", "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX");
        }

        LocalDate now = LocalDate.now();
        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.parse(customerDto.getDateOfBirth());
            if (Period.between(dateOfBirth, now).getYears() < 18 || Period.between(dateOfBirth, now).getYears() > 100) {
                errors.rejectValue("dateOfBirth", "dateOfBirth.err", "Tuổi nhập vào phải từ 18-120!");
            }
        } catch (Exception e) {
            errors.rejectValue("dateOfBirth", "dateOfBirth,err", "Vui lòng nhập lại!");
        }
    }
}
