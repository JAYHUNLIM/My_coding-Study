package kr.co.itwill.product;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/product")
public class ProductController {
	public ProductController() {
		System.out.println("----------ProductController() 생성");
	}


	//이미 생성된 객체 @Autowired
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping("/write")
	public String write() {
		return "product/write";
	}
	
	@RequestMapping("/insert")
	public String insert(@RequestParam Map<String, Object> map,
			@RequestParam MultipartFile img,
			HttpServletRequest req) {
	//자료형을 맞춰주면 파일을 불러 올수 있다. 매개변수의 유연함
	//사용자가 입력한 정보에 대해서 key, value값으로 나눠서 받음
		
	/*
		System.out.println(map);	
		System.out.println(map.get("product_name"));
		System.out.println(map.get("price"));
		System.out.println(map.get("description"));
	 												*/
		//주의사항: 파일업로드 할때 rename 되지 않고 원본 이름이 그대로 저장된다
		//업로드 폴더:/storage
		
		String filename="-";
		long filesize=0;
		if(img != null && !img.isEmpty()){
			//파일이 존재할 경우
			
			filename=img.getOriginalFilename();
			filesize=img.getSize();
			try {
				
				ServletContext application=req.getSession().getServletContext();
				String path=application.getRealPath("/storage");//실제 물리적 경로
				img.transferTo(new File(path+"\\"+filename));//파일 저장
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		map.put("filename", filename);
		map.put("filesize", filesize);
		
		productDAO.insert(map);
		return "redirect:/product/list";
	}//ins
	
	@RequestMapping("/list")
	public ModelAndView list() {
		//부모 ->자식 페이지
		ModelAndView mav=new ModelAndView();
		mav.setViewName("product/list");
		mav.addObject("list",productDAO.list());
		return mav;
	}//
	
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(defaultValue= "") String product_name) {
								//값이 안들어오면 기본값에 빈값을 넣어달라
		ModelAndView mav=new ModelAndView();
		mav.setViewName("product/list"); 
		mav.addObject("list",productDAO.search(product_name));
		mav.addObject("product_name", product_name);
		return mav;
	}
	
	
	///////detail
	/*	
		@RequestParam
	 	http://localhost:9095?aaa=bbb&ccc=ddd
	 	
	 	@PathVariable
	 	http://localhost:9095/bbb/dddd
	 	
	 	
	*/	

	//  ->http://localhost:9095/product/detail/1
	@RequestMapping("detail/{product_code}")//변수부분을 받아버리면 된다
	public  ModelAndView detail(@PathVariable int product_code) {
			ModelAndView mav=new ModelAndView();
			mav.setViewName("product/detail");
			mav.addObject("product",productDAO.detail(product_code));
			return mav;
	}
	
	//delete
	@RequestMapping("/delete")
	public String delete(int product_code,HttpServletRequest req) {
		String filename=productDAO.filename(product_code);	//삭제하고자 하는 파일명
		
		//첨부파일만 삭제
		if (filename != null && filename.equals("-")) {
			ServletContext application=req.getSession().getServletContext();
			String path=application.getRealPath("/storage");//실제 물리적 경로
			File file= new File(path+"\\"+filename);
			if (file.exists()) {
				file.delete();
			}
		}
		////////////////
		
		productDAO.delete(product_code);
		return "redirect:/product/list";
		
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam Map<String, Object> map,
			@RequestParam MultipartFile img,
			HttpServletRequest req) {
		
		//파일 삭제
		String filename="-";
		long filesize=0;
		if (img!=null && !img.isEmpty()) {
			//파일이 존재할 경우
			
			filename=img.getOriginalFilename();
			filesize=img.getSize();
			try {
				
				ServletContext application=req.getSession().getServletContext();
				String path=application.getRealPath("/storage");//실제 물리적 경로
				img.transferTo(new File(path+"\\"+filename));//파일 저장
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			
			/*
			 String product_code=map.get("product_code").toString();
			 product code->int 형변환
			
			*/
			
			int product_code=Integer.parseInt(map.get("product_code").toString());
			Map<String, Object> product=productDAO.detail(product_code);
			filename=product.get("FILENAME").toString();
			//filesize=(long)product.get("FILESIZE");
			filesize=Long.parseLong(product.get("FILESIZE").toString());
			
		}
		
		
		map.put("filename", filename);
		map.put("filesize", filesize);
		
		productDAO.update(map);
		return "redirect:/product/list";
		
		
	}
	
	
}


