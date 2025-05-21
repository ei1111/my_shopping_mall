package com.web.member.service;

import com.web.member.domain.Member;
import com.web.member.form.MemberRequest;
import com.web.member.form.MemberResponse;
import com.web.member.repository.MemberRepository;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberRequest request) {
        memberRepository.save(Member.from(request));
    }

    public List<MemberResponse> findAll() {
        AtomicInteger index = new AtomicInteger(1);

        return memberRepository.findAll().stream()
                .map(member -> new MemberResponse(
                                index.getAndIncrement()
                                , member.getName()
                                , member.getCity()
                                , member.getStreet()
                                , member.getZipcode()
                        )
                ).toList();
    }
}
