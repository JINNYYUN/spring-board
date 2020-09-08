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

    /**
     * 이메일 중복확인 처리(회원가입 시)
     * @param email
     * @return
     */
    public int findDuplicateEmail(String email) {
        MemberDTO memberDTO = memberDAO.findDuplicateEmail(email);
        //중복된 이메일인 경우
        if(memberDTO!=null){
            return 1;
        }
        //중복되지 않은 이메일인 경우
        else {
            return 0;
        }
    }

    public int insertNewMember(MemberDTO memberDTO){
        return memberDAO.insertNewMember(memberDTO);
    }
}
