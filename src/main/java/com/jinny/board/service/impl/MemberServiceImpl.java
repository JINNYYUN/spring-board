package com.jinny.board.service.impl;

import com.jinny.board.dao.MemberDAO;
import com.jinny.board.dto.MemberDTO;
import com.jinny.board.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDAO memberDAO;

    public int insertNewMember(MemberDTO memberDTO){
        return memberDAO.insertNewMember(memberDTO);
    }
}
