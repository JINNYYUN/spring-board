package com.jinny.board.dao.impl;

import com.jinny.board.dao.MemberDAO;
import com.jinny.board.dto.MemberDTO;
import org.apache.ibatis.javassist.compiler.ast.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    SqlSession sqlSession;

    String namespace = "Member.";

    @Override
    public int insertNewMember(MemberDTO memberDTO){
        return sqlSession.insert(namespace + "insertMember", memberDTO);
    }
}
