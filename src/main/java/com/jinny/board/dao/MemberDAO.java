package com.jinny.board.dao;

import com.jinny.board.dto.MemberDTO;

public interface MemberDAO {

    MemberDTO findDuplicateEmail(String email);
    int insertNewMember(MemberDTO memberDTO);
}
