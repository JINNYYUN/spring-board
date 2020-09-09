package com.jinny.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String email;
    private String password;
    private String name;
    private int auth;
    private int marketing_agree;
}
