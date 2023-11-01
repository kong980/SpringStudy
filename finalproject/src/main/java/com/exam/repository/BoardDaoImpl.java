package com.exam.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exam.domain.Board;
import com.exam.repository.BoardDao;

@Repository
public class BoardDaoImpl implements BoardDao {
	//DB가져다 쓰려면 root-contents에 sqlSessionFactory를 가져다 사용해야함
	//sqlSesssion 주입
	@Autowired
	private SqlSession sqlSession;
	
	//절대 수정되어서도 여러개 생성되어서도 안된다.
	private static final String NAMESPACE = "com.exam.mybatis.boardMapper";
	
	@Override
	public List<Board> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".getList");
	}

	@Override
	public Board read(int bNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", bNo);
	}

	@Override
	public int write(Board board) throws Exception {
		return sqlSession.insert(NAMESPACE + ".write", board); //board라는 파라미터를 전달
	}

	@Override
	public int update(Board board) throws Exception {
		return sqlSession.update(NAMESPACE + ".update", board);

	}

	@Override
	public int delete(int bNo) throws Exception {
		return sqlSession.delete(NAMESPACE + ".delete", bNo);
	}

}
