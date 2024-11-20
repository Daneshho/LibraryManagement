package service;

import model.Member;
import model.dto.MemberDto;

public interface MemberService extends BaseService<Member> {

    MemberDto findByNationalCode(String nationalCode);

    MemberDto findById(Long id);

}
