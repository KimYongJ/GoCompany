package com.pchr.entity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.pchr.dto.BoardDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@ToString
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id",nullable = false)
	private Long boardId;
	
	@Column(name = "board_title", nullable = false,length=255)
	private String boardTitle;

	@Column(name = "board_content", length=10000)
	private String boardContent;

	@Column(name = "registered_date", updatable = false)
	@CreatedDate
	private LocalDateTime registeredDate;

	@Column(name = "modified_date",insertable = false)
	@LastModifiedDate
	private LocalDateTime modifiedDate;

	@Column(name = "count",insertable = false)
	@ColumnDefault("0")
	private int count;
	
	@Column(name = "board_type")
	@ColumnDefault("0")
	private int boardType; // 0이 공지사항, 1이 게시판

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "emp_num", nullable = false)
	private Employee employee;

	public static BoardDTO toBoardDto(Board board) {
		//Builder
		BoardDTO boardDto = BoardDTO.builder()
				.boardId(board.getBoardId())
				.boardTitle(board.getBoardTitle())
				.count(board.getCount())
				.boardType(board.getBoardType())
				.boardContent(board.getBoardContent())
				.employee(board.getEmployee().toFKDTO(board.getEmployee()))
				.registeredDate(board.getRegisteredDate())
				.modifiedDate(board.getModifiedDate()).build();
		return boardDto;
	}

}
