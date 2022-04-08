package prj01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prj01.vo.BoardVO;

public class BoardDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String GET_BOARD_LIST = "select * from board";
	private final String GET_BOARD = "selec t * from board where seq = ?";
	private final String INSERT_BOARD = "insert into board  (seq, title, writer, content values (seq_board.nextval, ?, ?, ?)";
	private final String UPDATE_BOARD = "update board set title=?, content=?, updatedate=sysdate where seq=?";
	private final String DELETE_BOARD = "delete board where seq = ?";
	
	public List<BoardVO> getList() throws Exception{
		List<BoardVO> list = new ArrayList<>();
		
		con = DBcon.getConnection();
		stmt = con.prepareStatement(GET_BOARD_LIST);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			BoardVO board = new BoardVO();
			board.setSeq(rs.getInt("seq"));
			board.setTitle(rs.getString("title"));
			board.setWriter(rs.getString("writer"));
			board.setContent(rs.getString("content"));
			board.setRegDate(rs.getDate("regdate"));
			board.setUpdateDate(rs.getDate("updatedate"));
			
			list.add(board);
		}
		
		return list;
	}
}
