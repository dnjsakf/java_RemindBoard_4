package my.remind.board4.dao;

import java.util.List;

import my.remind.board4.vo.ContentVO;

public interface ContentDAO {
	public int getLastContentId();
	
	public int existNextContent(int lastContentId);
	public int existPrevContent(int firstContentId);
	
	public ContentVO getContent(int contentId);
	public List<ContentVO> getContents(int page, int count);

	public int updateContent(ContentVO content);
	public int insertContent(ContentVO content);
	public int deleteContent(int contentId);
}
