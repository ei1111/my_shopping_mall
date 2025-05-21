package com.web.member.form;

import com.web.member.domain.Address;
import java.util.concurrent.atomic.AtomicInteger;

public record MemberResponse(
        int id,
        String name,
        String city,
        String street,
        String zipcode
        ) {
}
