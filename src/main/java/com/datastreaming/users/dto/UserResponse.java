package com.datastreaming.users.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/** Author: Mohammed Anas Date: 06/04/2025 */

@Data
@Builder
public class UserResponse {
    @JsonProperty("results")
    private List<Result> results;  // Lombok should generate the getter for this

    @JsonProperty("info")
    private Info info;

    // Nested static classes for Result, Name, Location, etc.
    @Data
    @Builder
    public static class Result {
        @JsonProperty("gender")
        private String gender;

        @JsonProperty("name")
        private Name name;

        @JsonProperty("location")
        private Location location;

        @JsonProperty("email")
        private String email;

        @JsonProperty("login")
        private Login login;

        @JsonProperty("dob")
        private Dob dob;

        @JsonProperty("registered")
        private Registered registered;

        @JsonProperty("phone")
        private String phone;

        @JsonProperty("cell")
        private String cell;

        @JsonProperty("id")
        private Id id;

        @JsonProperty("picture")
        private Picture picture;

        @JsonProperty("nat")
        private String nat;
    }

    @Data
    @Builder
    public static class Name {
        @JsonProperty("title")
        private String title;

        @JsonProperty("first")
        private String first;

        @JsonProperty("last")
        private String last;
    }

    @Data
    @Builder
    public static class Location {
        @JsonProperty("street")
        private Street street;

        @JsonProperty("city")
        private String city;

        @JsonProperty("state")
        private String state;

        @JsonProperty("country")
        private String country;

        @JsonProperty("postcode")
        private String postcode;

        @JsonProperty("coordinates")
        private Coordinates coordinates;

        @JsonProperty("timezone")
        private Timezone timezone;
    }

    @Data
    @Builder
    public static class Street {
        @JsonProperty("number")
        private int number;

        @JsonProperty("name")
        private String name;
    }

    @Data
    @Builder
    public static class Coordinates {
        @JsonProperty("latitude")
        private String latitude;

        @JsonProperty("longitude")
        private String longitude;
    }

    @Data
    @Builder
    public static class Timezone {
        @JsonProperty("offset")
        private String offset;

        @JsonProperty("description")
        private String description;
    }

    @Data
    @Builder
    public static class Login {
        @JsonProperty("uuid")
        private String uuid;

        @JsonProperty("username")
        private String username;

        @JsonProperty("password")
        private String password;

        @JsonProperty("salt")
        private String salt;

        @JsonProperty("md5")
        private String md5;

        @JsonProperty("sha1")
        private String sha1;

        @JsonProperty("sha256")
        private String sha256;
    }

    @Data
    @Builder
    public static class Dob {
        @JsonProperty("date")
        private String date;

        @JsonProperty("age")
        private int age;
    }

    @Data
    @Builder
    public static class Registered {
        @JsonProperty("date")
        private String date;

        @JsonProperty("age")
        private int age;
    }

    @Data
    @Builder
    public static class Id {
        @JsonProperty("name")
        private String name;

        @JsonProperty("value")
        private String value;
    }

    @Data
    @Builder
    public static class Picture {
        @JsonProperty("large")
        private String large;

        @JsonProperty("medium")
        private String medium;

        @JsonProperty("thumbnail")
        private String thumbnail;
    }

    @Data
    @Builder
    public static class Info {
        @JsonProperty("seed")
        private String seed;

        @JsonProperty("results")
        private int results;

        @JsonProperty("page")
        private int page;

        @JsonProperty("version")
        private String version;
    }

    // Manual getter for results if Lombok isn't generating it correctly.
    public List<Result> getResults() {
        return results;
    }
}
