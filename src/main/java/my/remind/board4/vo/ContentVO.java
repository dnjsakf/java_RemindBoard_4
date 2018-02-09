package my.remind.board4.vo;

public class ContentVO {

	private Integer boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardDate;
	private String boardContent;
	private Integer boardAvailable;
	
	public ContentVO() {
		
	}
	public ContentVO( String boardTitle, String boardWriter, String boardDate, String boardContent ) {
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
	}
	
	public Integer getBoardNo() {
		return boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public Integer getBoardAvailable() {
		return boardAvailable;
	}
	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setBoardAvailable(Integer boardAvailable) {
		this.boardAvailable = boardAvailable;
	}
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(boardNo + "/");
		sb.append(boardTitle + "/");
		sb.append(boardWriter + "/");
		sb.append(boardDate + "/");
		sb.append(boardContent.substring(0,2) + ".../");
		sb.append(boardAvailable);
		return sb.toString();
	}
}
