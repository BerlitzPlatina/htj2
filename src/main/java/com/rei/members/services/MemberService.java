package com.rei.members.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.rei.members.dto.MemberDTO;
import com.rei.members.models.Member;
import com.rei.members.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDTO> getFamilyTree(Long familyId) {
        List<Member> members = memberRepository.findByFamilyId(familyId);
        List<Member> rootMembers =
                members.stream().filter(m -> m.getParent() == null).collect(Collectors.toList());
        return rootMembers.stream().map(MemberDTO::new).collect(Collectors.toList());
    }
}
