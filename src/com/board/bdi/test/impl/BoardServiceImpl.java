package com.board.bdi.test.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.board.bdi.test.BoardDAO;
import com.board.bdi.test.BoardService;

public class BoardServiceImpl implements com.board.bdi.test.BoardService {
	private BoardDAO bdao = new BoardDAOImpl();

	public static void main(String[] args) {
		BoardService bs = new BoardServiceImpl();
		Map<String, String> board = new HashMap<>();
		Map<String, String> rMap = bs.insertBoard(null);
		System.out.println(rMap);
	}

	@Override
	public Map<String, String> insertBoard(Map<String, String> board) {
		Map<String, String> rMap = new HashMap<>();
		int result = bdao.insertBoard(board);
		if (result == 1) {
			rMap.put("msg", "성공");
		} else {
			rMap.put("msg", "실패");
		}
		return rMap;
	}

	@Override
	public List<Map<String, String>> getBoardList(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> updateBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> deleteBoard(Map<String, String> board) {
		// TODO Auto-generated method stub
		return null;
	}
}
