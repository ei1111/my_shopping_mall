package com.web.member.domain;

import com.web.member.form.MemberRequest;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {

    private String city;

    private String street;

    private String zipcode;


    public Address(MemberRequest request) {
        this.city = request.city();
        this.street = request.street();
        this.zipcode = request.zipcode();
    }
}
