package kr.co.mymelon.mediagroup;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MediagroupCont {
	// 이미 만들어진 객체를 끌어다 쓰는 경우 사용
	// mediadao 끌어다가 사용
	@Autowired
	private MediaGroupDAO dao;

	public MediagroupCont() {
		System.out.println("MediagroupCont()객체 생성됨");

	}

	// 미디어 그룹 쓰기 페이지 호출
	// http://localhost:9095/mediagroup/create.do
	@RequestMapping(value = "mediagroup/create.do", method = RequestMethod.GET)
	public String createForm() {
		return "mediagroup/createForm";
		// WEB-INF/views/mediagroup/createForm.jsp
	}

	@RequestMapping(value = "mediagroup/create.do", method = RequestMethod.POST)
	public ModelAndView createProc(@ModelAttribute MediagroupDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		int cnt = dao.create(dto);
		//int cnt=0;
		
		if (cnt == 0) {
			mav.setViewName("mediagroup/msgView");
			String msg1 = "<p>미디어 그룹 등록 실패</p>";
			String img="<img src='../images/pepe1.png' width='300px'>";
			String link1= "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2= "<input type='button' value='그룹목록' onclick='location.href=\"list.do\"'>";
			
			mav.addObject("msg1",msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
			
		} else {
			// 성공하면 리스트 페이지로 이동
			// redirect 명령어로 호출해서 이동
			mav.setViewName("redirect:/mediagroup/list.do");
		}
		return mav;
	}
/*
 1.페이징 없는 목록
	@RequestMapping(value = "mediagroup/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mediagroup/list");
		List<MediagroupDTO> list = dao.list();
		
		//총 글 갯수
		int totalRowcount=dao.totalRowcount();
		
		mav.addObject("list", list);
		mav.addObject("count", totalRowcount);
		return mav;
	}
*/
	//2.페이징 있는 목록
	@RequestMapping("mediagroup/list.do")
	public ModelAndView list(HttpServletRequest req) {
        ModelAndView mav=new ModelAndView();
        mav.setViewName("mediagroup/list");
       
        int totalRowCount=dao.totalRowCount(); //총 글갯수
        
        //페이징
        int numPerPage   = 5;    // 한 페이지당 레코드 갯수
        int pagePerBlock = 10;   // 페이지 리스트
       
        String pageNum=req.getParameter("pageNum");
        if(pageNum==null){
              pageNum="1";
        }
        int currentPage=Integer.parseInt(pageNum);
        int startRow   =(currentPage-1)*numPerPage+1;
        int endRow     =currentPage*numPerPage;
       
        //페이지 수
        double totcnt = (double)totalRowCount/numPerPage;
        int totalPage = (int)Math.ceil(totcnt);
         
        double d_page = (double)currentPage/pagePerBlock;
        int Pages     = (int)Math.ceil(d_page)-1;
        int startPage = Pages*pagePerBlock;
        int endPage   = startPage+pagePerBlock+1;
        
        List list=null;     
        if(totalRowCount>0){           
              list=dao.list2(startRow, endRow);          
        } else {           
              list=Collections.EMPTY_LIST;           
        }//if end
         
        //int number=0;
        //number=totalRowCount-(currentPage-1)*numPerPage;
         
        //mav.addObject("number",    number);
        mav.addObject("pageNum",   currentPage);
        //mav.addObject("startRow",  startRow);
        //mav.addObject("endRow",    endRow);
        mav.addObject("count",     totalRowCount);
       //mav.addObject("pageSize",  pagePerBlock);
        mav.addObject("totalPage", totalPage);
        mav.addObject("startPage", startPage);
        mav.addObject("endPage",   endPage);
        mav.addObject("list", list);
        return mav;
    }//list() end
        
        
	
	@RequestMapping(value="mediagroup/delete.do",method = RequestMethod.GET)
	public ModelAndView deleteForm(int mediagroupno) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("mediagroup/deleteForm");
		mav.addObject("mediagroupno", mediagroupno);
		return mav;
	}
	
	@RequestMapping(value ="mediagroup/delete.do",method = RequestMethod.POST)
	
	public ModelAndView deleteProc(int mediagroupno) {
		ModelAndView mav = new ModelAndView();
		
		int cnt = dao.delete(mediagroupno);
		if (cnt == 0) {
			mav.setViewName("mediagroup/msgView");
			String msg1 = "<p>미디어 그룹 삭제 실패</p>";
			String img="<img src='../images/pepe1.png' width='300px'>";
			String link1= "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2= "<input type='button' value='그룹목록' onclick='location.href=\"list.do\"'>";
			
			mav.addObject("msg1",msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
			
		} else {
			// 성공하면 리스트 페이지로 이동
			// redirect 명령어로 호출해서 이동
			mav.setViewName("redirect:/mediagroup/list.do");
		}
		
		return mav;
	}
	
	@RequestMapping(value="mediagroup/update.do",method = RequestMethod.GET)
	public ModelAndView updateForm(int mediagroupno) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("mediagroup/updateForm");
		mav.addObject("dto", dao.read(mediagroupno));
		
		return mav;
	}
	
	@RequestMapping(value="mediagroup/update.do",method = RequestMethod.POST)
	public ModelAndView updateProc(MediagroupDTO dto) {
		ModelAndView mav=new ModelAndView();
		int cnt= dao.update(dto);
		if (cnt == 0) {
			mav.setViewName("mediagroup/msgView");
			String msg1 = "<p>미디어 그룹 수정 실패</p>";
			String img="<img src='../images/pepe1.png' width='300px'>";
			String link1= "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2= "<input type='button' value='그룹목록' onclick='location.href=\"list.do\"'>";
			
			mav.addObject("msg1",msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
			
		} else {
			// 성공하면 리스트 페이지로 이동
			// redirect 명령어로 호출해서 이동
			mav.setViewName("redirect:/mediagroup/list.do");
		}
		
		return mav;
	}
}
