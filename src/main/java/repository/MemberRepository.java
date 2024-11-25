package repository;

import model.Member;

import java.util.Optional;

public interface MemberRepository extends BaseRepository<Member> {

    Optional<Member> findByNationalCode(String nationalCode);

}