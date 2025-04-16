package com.rei.members.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rei.members.models.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByFamilyId(Long familyId);
}

