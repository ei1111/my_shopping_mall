package com.web.member.domain;

import com.web.audit.BaseEntity;
import com.web.audit.BaseTimeEntity;
import com.web.member.form.MemberRequest;
import com.web.order.domain.Order;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    public String getCity() {
        return address.getCity();
    }

    public String getStreet() {
        return address.getStreet();
    }

    public String getZipcode() {
        return address.getZipcode();
    }

    private Member(MemberRequest request) {
        this.name = request.name();
        this.address = new Address(request);
    }

    public static Member from(MemberRequest request) {
        return new Member(request);
    }
}
