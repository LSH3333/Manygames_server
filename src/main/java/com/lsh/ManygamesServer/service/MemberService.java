package com.lsh.ManygamesServer.service;

import com.lsh.ManygamesServer.domain.Member;
import com.lsh.ManygamesServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private void save(Member member) {
        memberRepository.save(member);
    }

    /**
     * db 에 name 과 중복되는 경우 있는지 확인
     * @param name : 로그인 이름
     * @return : 중복있을시 true else false
     */
    public boolean checkNameDuplication(String name) {
        return memberRepository.findByName(name).isPresent();
    }

    /**
     * 회원가입
     * @param name : 로그인 이름
     * @param password : 비밀번호
     * @return : 회원가입 성공시 true, else false
     */
    public boolean register(String name, String password) {
        if(checkNameDuplication(name)) {
            return false;
        } else {
            Member member = new Member(name, password);
            save(member);
            return true;
        }
    }

    public Optional<Member> login(String name, String password) {
        return memberRepository.findByName(name)
                .filter(m -> m.getPassword().equals(password));
    }

}
