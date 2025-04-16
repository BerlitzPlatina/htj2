package com.rei.members.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.rei.members.models.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
    private Integer id;
    private String username;
    private List<MemberDTO> children;

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.username = member.getUser().getUsername();
        this.children =
                member.getChildren().stream().map(MemberDTO::new).collect(Collectors.toList());
    }

    // Getters and Setters
}
