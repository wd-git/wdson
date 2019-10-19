package wdson.me.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import wdson.me.board.commons.paging.PageMaker;
import wdson.me.board.commons.paging.Paging;
import wdson.me.board.domain.BoardVO;
import wdson.me.board.service.BoardService;
 
@Controller
//@RequestMapping("/board/") // url요청이  /board/로 시작하는 것은 여기서 처리한다. ex) board/abc , board/123 board/create
public class BoardController {
    @Inject
    private BoardService service;
    
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String main() throws Exception{
    	return "home";
    }
    
    @RequestMapping(value="/create",method=RequestMethod.GET)
    public String createGET(BoardVO board, Model model) throws Exception{
        System.out.println("/board/create 입니다. GET방식");
        
        return "/board/create";
    }
    
    @RequestMapping(value="/create",method=RequestMethod.POST )
    public String createPOST(BoardVO board, Model model) throws Exception{
        System.out.println("/board/create POST방식 입니다.");
        System.out.println(board.toString());
        
        service.create(board);
        model.addAttribute("result", "성공");
        
        return "/board/sucess";
    }
    
    @RequestMapping(value="/write", method=RequestMethod.GET)
    public String writeGET() {
    	
    	return "/board/write";
    }
    
    @RequestMapping(value="/write", method=RequestMethod.POST)
    public String writePOST(BoardVO boardVo, RedirectAttributes redirectAttributes) throws Exception {
    	service.create(boardVo);
    	redirectAttributes.addFlashAttribute("msg", "regSuccess");
    	
    	return "redirect:/list"; 
    }
    
//    @RequestMapping(value="/list", method=RequestMethod.GET)
//    public String list(Model model) throws Exception {
//    	System.out.println(service.listAll());
//    	
//    	model.addAttribute("boards", service.listAll());
//    	
//    	
//    	return "/board/list"; 
//    }
    
    @RequestMapping(value="/list", method = RequestMethod.GET) 
    public String listPaging(Model model, Paging paging, HttpSession hsr ) throws Exception {
    	
    	PageMaker pageMaker = new PageMaker();
    	pageMaker.setPaging(paging);
    	pageMaker.setTotalCount(service.countBoards(paging));
    	
    	//test
    	System.out.println( " @@@@ msg : " + hsr.getAttribute("msg"));
    	
    	model.addAttribute("boards", service.listPaging(paging));
    	model.addAttribute("pageMaker", pageMaker);
    	
    	return "/board/list";
    }
    
    // 조회 페이지 이동
    @RequestMapping(value="/read", method=RequestMethod.GET)
    public String read(@RequestParam("b_no") int b_no, Model model) throws Exception {
    	model.addAttribute("board", service.read(b_no));
    	
    	return "/board/read";
    	
    }
    
    // goModify
    @RequestMapping(value="/modify", method=RequestMethod.GET)
    public String modifyGET(@RequestParam("b_no") int b_no, Model model) throws Exception {
    	model.addAttribute("board", service.read(b_no));
		
    	return "/board/modify";
    	
    }
    
    // doModify
    @RequestMapping(value="/modify", method=RequestMethod.POST)
    public String modifyPOST(BoardVO boardVo, RedirectAttributes redirectAttributes) throws Exception {
    	service.update(boardVo);
    	
    	redirectAttributes.addFlashAttribute("msg", "modSuccess");
		
    	return "redirect:/list";
    }
    
    // delete
    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public String remove(@RequestParam("b_no") int b_no, RedirectAttributes redirectAttributes) {
    	
    	redirectAttributes.addFlashAttribute("msg", "delSuccess");
    	
    	
    	return "redirect:/list";
    }
    
   
}
