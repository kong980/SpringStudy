package com.exam.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.domain.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDaoImplTest {
	@Autowired
	private BoardDao boardDao;
	
	@Ignore @Test // 이 테스트는 건너뛴다는 말
	public void writeTest() throws Exception {
		Board dto = new Board("title1", "content1", "홍길동");
		assertTrue(boardDao.write(dto) == 1);
	}
	
	@Ignore @Test
	public void getListTest() throws Exception{
		List<Board> list = boardDao.getList();
		for(Board board : list) {
			System.out.println(board.getbNo());
			System.out.println(board.getbContent());
			System.out.println(board.getbRegdate());
			System.out.println(board.getbTitle());
			System.out.println(board.getbWriter());
			System.out.println();
		}
	}
	
	@Ignore @Test
	public void readTest() throws Exception{
		Board board = boardDao.read(1);
		System.out.println(board);
	}
	
	@Ignore @Test
	public void deleteTest() throws Exception{
		int board = boardDao.delete(3);
		System.out.println(board);
	}
	
	@Test
	public void updateTest() throws Exception{
		Board board = boardDao.read(2);
		board.setbContent("수정테스트1233");
		board.setbTitle("수정타이틀1234");
		
		int result = boardDao.update(board);
		Board board1 = new Board();
		board1 = boardDao.read(2);
		System.out.println(board1.getbContent());
		System.out.println(board1.getbTitle());
	}
}
