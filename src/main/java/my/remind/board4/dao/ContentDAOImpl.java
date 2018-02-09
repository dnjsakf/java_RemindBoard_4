package my.remind.board4.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import my.remind.board4.vo.ContentVO;


@Repository
public class ContentDAOImpl implements ContentDAO {

	@Inject
	SqlSession sqlSession;
	
	private static final String NAMESPACE = "my.remind.board4.mapper.ContentMapper.";
	
	@Override
	public int getLastContentId() {
		return sqlSession.selectOne(NAMESPACE+"getLastContentId");
	}

	@Override
	public int existNextContent(int lastContentId) {
		return sqlSession.selectOne(NAMESPACE+"existNextcontent", lastContentId);
	}

	@Override
	public int existPrevContent(int firstContentId) {
		return sqlSession.selectOne(NAMESPACE+"eixstPrevContent", firstContentId);
	}

	@Override
	public ContentVO getContent(int contentId) {
		return sqlSession.selectOne(NAMESPACE+"getContent", contentId);
	}

	@Override
	public List<ContentVO> getContents(int page, int count) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("start", (page - 1) * count);
		condition.put("count", count);
		return sqlSession.selectList(NAMESPACE+"getContents", condition);
	}

	@Override
	public int updateContent(ContentVO content) {
		return sqlSession.update(NAMESPACE+"updateContent", content);
	}

	@Override
	public int insertContent(ContentVO content) {
		return sqlSession.insert(NAMESPACE+"insertContent", content);
	}

	@Override
	public int deleteContent(int contentId) {
		return sqlSession.delete(NAMESPACE+"deleteContent", contentId);
	}

}
