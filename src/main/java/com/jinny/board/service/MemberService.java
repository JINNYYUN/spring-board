package com.jinny.board.service;

import com.jinny.board.dto.MemberDTO;

public interface MemberService {
    int findDuplicateEmail(String email);
    int insertNewMember(MemberDTO memberDTO);
}
