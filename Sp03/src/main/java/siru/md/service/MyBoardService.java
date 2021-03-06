package siru.md.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import siru.md.domain.Board;
import siru.md.domain.BoardListResult;
import siru.md.domain.Files;
import siru.md.domain.MyBoardVo;
import siru.md.domain.PagingVo;

public interface MyBoardService {
	List<Board> selectPerPageS(MyBoardVo myBoardVo);
	Board getBoard(long seq);
	List<Files> getFiles(long seq);
	BoardListResult getBoardListResultByKeyword(String keyword, int page, int pageSize);
	long selectCount();
	void write(Board board);
	void writeTest(Board board, ArrayList<MultipartFile> files);
	void edit(Board board);
	void remove(long seq);
	void removeFile(String fname);
	
}
