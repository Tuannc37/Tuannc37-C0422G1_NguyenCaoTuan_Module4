package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    @NotBlank(message = "Vui lòng nhập thông tin!")
    @Pattern(regexp = "[A-Za-z ]+",message = "Sai định dạng")
    @Size(min = 5, max = 45,message = "Có độ dài tối thiểu 5,Tối đa 45 kí tự!!")
    private String firstname;

    @NotBlank(message = "Vui lòng nhập thông tin!")
    @Pattern(regexp = "[A-Za-z ]+",message = "Sai định dạng")
    @Size(min = 5, max = 45,message = "Có độ dài tối thiểu 5,Tối đa 45 kí tự!!")
    private String lastName;

    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String tel;

    @Min(value = 18,message = "Số tuổi phải lớn hơn 18")
    private int age;

    @Email(message = "Email nhập không đúng !!!")
    @NotBlank(message = "Vui lòng nhập thông tin!")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstname, String lastName, String tel, int age, String email) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.tel = tel;
        this.age = age;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String number = userDto.getTel();
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("tel",
                    "create.tel",
                    "Số điiẹn thoại có 10 of 11 số!");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("tel",
                    "create.tel",
                    "Số điệ thoại bắt đầu từ số 0");
        }

        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("tel",
                "create.tel",
                "Số điiẹn thoại không đúng định dạng");
        }
    }
}
