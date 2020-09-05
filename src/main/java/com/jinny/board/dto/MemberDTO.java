package com.jinny.board.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String email;
    private String password;
    private String name;
    private int auth;
    private String regiDate; //회원가입 날짜
}
