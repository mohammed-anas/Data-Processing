package com.datastreaming.users.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/** Author: Mohammed Anas Date: 04/04/2025 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String title;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String postcode;
    private String latitude;
    private String longitude;
    private String timezoneOffset;
    private String timezoneDescription;
    private String email;
    private String uuid;
    private String username;
    private String password;
    private String salt;
    private String md5;
    private String sha1;
    private String sha256;
    private Date dob;
    private int age;
    private Date registeredDate;
    private int registeredAge;
    private String phone;
    private String cell;
    private String idName;
    private String idValue;
    private String pictureLarge;
    private String pictureMedium;
    private String pictureThumbnail;
    private String nat;
}


