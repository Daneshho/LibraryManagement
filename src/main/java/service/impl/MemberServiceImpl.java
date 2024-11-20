package service.impl;

import exception.RequestFailedException;
import model.Member;
import model.dto.MemberDto;
import repository.impl.MemberRepositoryImpl;
import service.MemberService;
import util.ApplicationContext;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    MemberRepositoryImpl memberRepository = ApplicationContext.getMemberRepository();

    @Override
    public MemberDto findByNationalCode(String nationalCode) {
        MemberDto memberDto = null;
        try {
            Optional<Member> optionalMember = memberRepository.findByNationalCode(nationalCode);
            if (optionalMember.isPresent()) {
                memberDto = new MemberDto();
                memberDto.setNationalCode(optionalMember.get().getNationalCode());
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return memberDto;
    }

    @Override
    public void save(Member object) {
        try {
            memberRepository.save(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Long object) {
        try {
            memberRepository.delete(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Member object) {
        try {
            memberRepository.update(object);
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public MemberDto findById(Long id) {
        MemberDto memberDto = null;
        try {
            Optional<Member> optionalMember = memberRepository.findById(id);
            if (optionalMember.isPresent()) {
                memberDto = new MemberDto();
                memberDto.setNationalCode(optionalMember.get().getNationalCode());
            }
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return memberDto;
    }

    @Override
    public List<Member> getAll() {
        try {
            memberRepository.getAll();
        } catch (RequestFailedException e) {
            System.out.println(e.getMessage());
        }
        return memberRepository.getAll();
    }
}
