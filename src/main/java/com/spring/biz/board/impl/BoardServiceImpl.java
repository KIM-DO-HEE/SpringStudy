package com.spring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;
import com.spring.biz.common.Log4jAdvice;
import com.spring.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;
	private Log4jAdvice log;

	public BoardServiceImpl() {
		log = new Log4jAdvice();
	}

	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLogging();
		if(vo.getSeq() == 0) {
			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
		}
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		//log.printLogging();
		return boardDAO.getBoardList(vo);
	}
	
	
}
