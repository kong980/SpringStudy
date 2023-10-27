package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.domain.Board;
import com.exam.repository.BoardDao;

//뚜렷한 목적이 있음
@Service
public class BoardServiceImpl implements BoardService {
	//주입받을 변수 선언 -> @Autowired이용해주면 따로 setter메소드를 만들어주지 않아도 자동 생성
	@Autowired
	private BoardDao boardDao;
		

	@Override
	public List<Board> getList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board read(int bNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(Board board) throws Exception {
		// BoardDaoImp dao = new BoardDaoImpl();
		// dao.write(board);
		
		//DB에 저장좀 시켜줘
		boardDao.write(board);
		

	}

	@Override
	public void update(Board board) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int bNo) throws Exception {
		// TODO Auto-generated method stub

	}

}
