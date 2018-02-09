package my.remind.board4;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import my.remind.board4.dao.ContentDAO;
import my.remind.board4.vo.ContentVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ContentDAOTest {
	
	@Inject
	ContentDAO dao;
	
	@Test
	public void contentDAO() {
		System.out.println("[dao] " + dao);
	}
	
	@Test
	public void getContent() throws Exception {
		System.out.println("[content] " + dao.getContent(41));
	}
	
	@Test
	public void getContentes() throws Exception {
		List<ContentVO> contents = dao.getContents(1,1);
		System.out.println("[contents] " + contents.get(0));
	}
}
