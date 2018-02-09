package my.remind.board4;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import my.remind.board4.dao.ContentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SqlSessionTest {

	@Inject
	SqlSessionFactory factory;
	
	@Inject
	SqlSession sqlSession;
	
	@Inject
	ContentDAO dao;
	
	@Test	
	public void sqlSessionFactory() {
		System.out.println("[factory] "+ factory);
	}
	
	@Test
	public void sqlSession() {
		System.out.println("[sqlSession] " + sqlSession);
	}
	
	@Test
	public void contentDAO() {
		System.out.println("[dao] " + dao);
	}
}
