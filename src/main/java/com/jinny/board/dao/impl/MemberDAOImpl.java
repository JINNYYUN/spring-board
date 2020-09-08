package com.jinny.board.dao.impl;

import com.jinny.board.dao.MemberDAO;
import com.jinny.board.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    SqlSession sqlSession;

    String namespace = "Member.";

    @Override
    public MemberDTO findDuplicateEmail(String email){
        return sqlSession.selectOne(namespace + "checkEmail", email);
    }

    @Override
    public int insertNewMember(MemberDTO memberDTO){
        System.out.println("MemberDAOImpl" + memberDTO.getEmail()+ ", " +memberDTO.getPassword());
        return sqlSession.insert(namespace + "insertMember", memberDTO);
    }
}
