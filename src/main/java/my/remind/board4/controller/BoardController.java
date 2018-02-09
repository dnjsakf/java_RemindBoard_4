package my.remind.board4.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import my.remind.board4.dao.ContentDAO;
import my.remind.board4.vo.ContentVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	ContentDAO dao;
	
	private final int DEFAULT_COUNT = 10;
	private final int DEFAULT_PAGE = 1;
	
	private int last_page = DEFAULT_PAGE;
	
	
	/**
	 * Content List
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getContents( @RequestParam("page") int page, Model model ) throws Exception {
		if( page < 0 ) {
			page = DEFAULT_PAGE;
		}
		this.last_page = page;
		
		model.addAttribute("contents", dao.getContents(page, DEFAULT_COUNT));
		return "board/ContentApp";
	}
	
	
	/**
	 * ContentViewApp.jsp
	 * 		├─ view: ContentView.jsp
	 * 		├─ insert: ContentInsert.jsp
	 * 		├─ update: ContentUpdate.jsp
	 * 		└─ delete: ContentDelete.jsp
	 */
	
	/**
	 * Content View
	 */
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String getContent( @RequestParam("no") int contentId, RedirectAttributes rttr, Model model) throws Exception {
		if( contentId < 0) {
			rttr.addFlashAttribute("page", last_page);
			return "redirect:/board/list";
		}
		model.addAttribute("mode", "view");
		model.addAttribute("content", dao.getContent(contentId));
		return "board/ContentViewApp";
	}
	
	/**
	 * Content Insert
	 */
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertContent(RedirectAttributes rttr, Model model) {
		model.addAttribute("mode", "insert");
		rttr.addFlashAttribute("page", last_page);
		return "board/ContentViewApp";
	}
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String doInsertContent( @ModelAttribute ContentVO content, RedirectAttributes rttr) throws Exception {
		System.out.println("[content]" + content);
		
		if( content == null ) {
			rttr.addFlashAttribute("page", last_page);
			return "redirect:/board/list";
		}

		int result = -1;
		int nextContentId = dao.getLastContentId() + 1;
		
		content.setBoardNo( nextContentId );

		result = dao.insertContent(content);
		
		// 실패
		if( result < 0 ) {
			rttr.addFlashAttribute("page", last_page);
			return "redirect:/board/list";
		}
		
		// 성공
		rttr.addFlashAttribute("page", last_page);
		return "redirect:/board/view?no="+nextContentId;
	}
	
	/**
	 * Content Update
	 */
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateContent( @RequestParam("no") int contentId, Model model) {
		/**
		 * TODO: Invalid Check
		 */
		model.addAttribute("mode", "update");
		model.addAttribute("content", dao.getContent(contentId));
		
		return "board/ContentViewApp";
	}
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String doUpdateContent( @RequestAttribute ContentVO content, RedirectAttributes rttr ) {
		if( content == null ) {
			rttr.addFlashAttribute("content", content);
			return "redirect:/board/update";
		}
		
		DateFormat df = DateFormat.getDateTimeInstance();
		content.setBoardDate( df.format(new Date()) );
		
		dao.updateContent( content );
		
		return "redirect:/board/view?no=" + content.getBoardNo();
	}
	
	/**
	 * Content Delete
	 */
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String doDeleteContent( @RequestAttribute ContentVO content ) {
		int contentId = content.getBoardNo();
		int result = dao.deleteContent( contentId );
		//실패
		if( result < 0 ) {
			return "redirect:/board/view?no="+contentId;
		}
		// 성공
		return "redirect:/board/list?page="+last_page;
	}
}
