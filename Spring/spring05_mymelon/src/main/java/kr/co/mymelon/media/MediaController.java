package kr.co.mymelon.media;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.utility.UploadSaveManager;

@Controller
public class MediaController {
 
	@Autowired
	private MediaDAO dao;
	
	public MediaController() {
		System.out.println("mediacontroller 객체 생성됨");
	}
	
	//부모 글번호를 항상 가지고 다녀야 한다
	@RequestMapping("/media/list.do")
	public ModelAndView list(int mediagroupno) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("media/list");
		mav.addObject("list", dao.list(mediagroupno));
		mav.addObject("mediagroupno",mediagroupno);
		
		return mav;
	}
	
	@RequestMapping(value= "/media/create.do",  method = RequestMethod.GET)
	public ModelAndView createForm(int mediagroupno) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("media/createForm");
		mav.addObject("mediagroupno", mediagroupno);
		return mav;			
	}
	
	@RequestMapping(value= "/media/create.do",method = RequestMethod.POST)
	public ModelAndView createProc(MediaDTO dto, HttpServletRequest req) {
								  //string title,multipartfile posterMF,multipartfile filenameMF)
		ModelAndView mav=new ModelAndView(); 
		mav.setViewName("media/msgView");
		
		//////////////////////////////////////////////////////
		// 첨부된 파일 처리
		// 실제파일:storage 폴더에 저장
		// 저장된 파일 관련 정보는 media테이블에 저장
		
		// 파일 저장 폴더의 실제 물리적인 경로 가져오기
		ServletContext application=req.getServletContext();
		String basePath=application.getRealPath("/storage");
		
		MultipartFile posterMF=dto.getPosterMF();//파일 가져오기
		
		//storage 폴더에 저장하고 , 리네임된 파일명 반환
		String poster=UploadSaveManager.saveFileSpring30(posterMF, basePath);
		dto.setPoster(poster);//리네임된 파일명을 dto객체 담기
		
		MultipartFile filenameMF=dto.getFilenameMF();
		String filename=UploadSaveManager.saveFileSpring30(filenameMF, basePath);
		dto.setFilename(filename);
		dto.setFilesize(filenameMF.getSize());
		/////////////////
		int cnt=dao.create(dto);
		if (cnt==0) {

			String msg1 = "<p>음원 등록 실패</p>";
			String img = "<img src='../images/pepe1.png' width='300px'>";
			String link1 = "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2 = "<input type='button' value='그룹목록' onclick='location.href=\"list.do?mediagroupno="+dto.getMediagroupno()+"\"'>";
			
			mav.addObject("msg1",msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
			
		}else {
			String msg1 = "<p>음원 등록 성공</p>";
			String img = "<img src='../images/pepe2.png' width='300px'>";
			String link2 = "<input type='button' value='그룹목록' onclick='location.href=\"list.do?mediagroupno="+dto.getMediagroupno()+"\"'>";

			mav.addObject("msg1",msg1);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
			
		}
		return mav;
	}//create
	
	@RequestMapping(value="/media/read.do")
	public ModelAndView read(int mediano) {
		ModelAndView mav=new ModelAndView();
		MediaDTO dto=dao.read(mediano);
		
		if(dto!=null) {
			//비디오 태그인가 오디오 태그인가에 따라서 출력을 다르게 해준다
			//파일명을 가져와서 소문자로 변환
			//마지막 문자열을 기준 mp4,mp3구분
			
			String filename=dto.getFilename();
			filename=filename.toLowerCase();
			if(filename.endsWith(".mp3")) {
			mav.setViewName("media/readMP3");	
			
			}else if(filename.endsWith(".mp4")) {
			mav.setViewName("media/readMP4");
			}
		}
		mav.addObject("dto", dto);
		return mav;
	}//READ
	
	@RequestMapping(value="/media/delete.do",method = RequestMethod.GET)
	public ModelAndView deleteForm(int mediano) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("media/deleteForm");
		mav.addObject("mediano",mediano);
		return mav;
	}
	//delete
	
@RequestMapping(value ="/media/delete.do",method = RequestMethod.POST)
	
	public ModelAndView deleteProc(int mediano,HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("media/msgView");
		
		//삭제하고자 하는 글 정보 가져오기
		//storge에서 삭제할 파일명 확인하기 위해서
		MediaDTO oldDTO=dao.read(mediano);
		
		int cnt = dao.delete(mediano);
		if (cnt == 0) {
			String msg1 = "<p>미디어 삭제 실패</p>";
			String img="<img src='../images/pepe1.png' width='300px'>";
			String link1= "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2= "<input type='button' value='그룹목록' onclick='location.href=\"list.do?mediagroupno="+oldDTO.getMediagroupno()+"\"'>";
			
			mav.addObject("msg1",msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2);
			
		} else {
			String msg1 = "<p>미디어 파일 삭제 완료 </p>";
			String img="<img src='../images/pepe2.png' width='300px'>";
			String link2= "<input type='button' value='그룹목록' onclick='location.href=\"list.do?mediagroupno="+oldDTO.getMediagroupno()+"\"'>";
				
			mav.addObject("msg1",msg1);
			mav.addObject("img", img);
			mav.addObject("link2", link2);
			
			//첨부된 파일 삭제
			ServletContext application=req.getServletContext();
			String basePath=application.getRealPath("/storage");
			UploadSaveManager.deleteFile(basePath,oldDTO.getPoster());
			UploadSaveManager.deleteFile(basePath, oldDTO.getFilename());
		}
		return mav;
		}//delete
		
		@RequestMapping(value="/media/update.do", method = RequestMethod.GET)
		public ModelAndView updateForm(int mediano) {
			ModelAndView mav=new ModelAndView();
			mav.setViewName("media/updateForm");
			MediaDTO dto=dao.read(mediano);
			mav.addObject("dto", dto);
			return mav;
		}//update
		
	 @RequestMapping(value="/media/update.do",method = RequestMethod.POST)
	 public ModelAndView updateProc(MediaDTO dto, HttpServletRequest req) {
		
		 MediaDTO oldDTO=dao.read(dto.getMediano());//기존 파일에 대한 정보 가져오기
		 ///////////
		 ServletContext application=req.getServletContext();
		 String basePath=application.getRealPath("/storage");
		 //파일을 수정할 것인가? 
		 //1.파일크기를 보고 파일이 들어온것인지 확인
		 
		 MultipartFile posterMF=dto.getPosterMF();
		 if (posterMF.getSize()>0) {
			 //새로운 파일이 첨부되었는가?
			 //기존 파일을 삭제하고 신규로 전송된 파일을 저장
			UploadSaveManager.deleteFile(basePath,oldDTO.getPoster());
			//신규로 전송된 파일 저장하기
			String poster=UploadSaveManager.saveFileSpring30(posterMF, basePath);
			dto.setPoster(poster);
		} else {
			//파일을 수정하지 않음
			dto.setPoster(oldDTO.getPoster());//기존에 저장한 파일명
			
		}
		 
		 
		 //2.
		 MultipartFile filenameMF=dto.getFilenameMF();
		 if (filenameMF.getSize()>0) {
			 //새로운 파일이 첨부되었는가?
			 //기존 파일을 삭제하고 신규로 전송된 파일을 저장
			UploadSaveManager.deleteFile(basePath,oldDTO.getFilename());
			//신규로 전송된 파일 저장하기
			String filename=UploadSaveManager.saveFileSpring30(filenameMF, basePath);
			dto.setFilename(filename);
			dto.setFilesize(filenameMF.getSize());
		} else {
			//파일을 수정하지 않음
			dto.setFilename(oldDTO.getFilename());
			dto.setFilesize(oldDTO.getFilesize());
		}
		 
		 //////
		 
		 ModelAndView mav=new ModelAndView();
		 		 		 
		 int cnt=dao.update(dto);
		 if (cnt==0) {
			mav.setViewName("media/msgView");
			String msg1 = "<p>파일 수정 실패</p>";
			String img="<img src='../images/pepe1.png' width='300px'>";
			String link1= "<input type='button' value='다시시도' onclick='javascript:history.back()'>";
			String link2= "<input type='button' value='그룹목록' onclick='location.href=\"list.do?mediagroupno="+oldDTO.getMediagroupno()+"\"'>";
			
			mav.addObject("msg1",msg1);
			mav.addObject("img", img);
			mav.addObject("link1", link1);
			mav.addObject("link2", link2); 
			 
		} else {
			mav.setViewName("redirect:/media/list.do?mediagroupno="+oldDTO.getMediagroupno());
		}
		 return mav;
	 }
		
		
	
	}
