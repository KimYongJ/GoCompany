package com.pchr.dto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.pchr.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardDTO {

	private Long boardId;
	
	@Size(max = 255,message = "게시글 제목은 255자 이내로 입력해주세요.")
	@NotBlank(message = "게시글 제목을 입력해주세요.")
	private String boardTitle;
	
	@Size(max = 10000,message = "게시글 내용은 10,000자 이내로 입력해주세요.")
	@NotBlank(message = "게시글 내용을 입력해주세요.")
	private String boardContent;

	private LocalDateTime registeredDate;

	private LocalDateTime modifiedDate;

	private int count;
	
	private int boardType;

	private EmployeeDTO employee;

	private List<CommentDTO> comments = new ArrayList<CommentDTO>();

	// DTO -> Entity 빌더 (Insert)
	public  Board toBoard(BoardDTO boardDto) {
		Board board = Board.builder()
				.boardId(boardDto.getBoardId())
				.boardTitle(boardDto.getBoardTitle())
				.boardContent(boardDto.getBoardContent())
				.count(boardDto.getCount())
				.boardType(boardDto.getBoardType())
				.employee(boardDto.getEmployee().toFKManager(boardDto.getEmployee()))
				.build();
		System.out.println(board.getCount());
		return board;
	}

	
	// DTO -> Entity 빌더 (Update)
	public Board toUpdateBoard(BoardDTO boardDto) {

		Board board = Board.builder().boardId(boardDto.getBoardId())
				.boardTitle(boardDto.getBoardTitle())
				.boardContent(boardDto.getBoardContent())
				.count(boardDto.getCount())
				.boardType(boardDto.getBoardType())
				.employee(boardDto.getEmployee()
				.toFKManager(boardDto.getEmployee()))
				.build();
		return board;
	}
	
	//댓글에 대한 Board 빌더
	public Board toFKBoard(BoardDTO boardDto) {
		Board board = Board.builder().boardId(boardDto.getBoardId()).build();
		
		return board;
	}
}
