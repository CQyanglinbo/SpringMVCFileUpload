package online.shixun.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	@RequestMapping("upload/page")
	public String uploadPage(){
		System.out.println("hello");
		return "upload";
	}
	@RequestMapping(value="upload/do_upload",method=RequestMethod.POST)
	public String upload(MultipartFile file,HttpServletRequest request){
		System.out.println("hi");
		boolean mess=false;
		String url=request.getSession().getServletContext().getRealPath("upload");
		//判断文件是否存在，不存在就创建
		if(new File(url).exists()){
			new File(url);
		}
		//解决文件名冲突，随机生成字符串加入到文件名中
		StringBuffer fileName=new StringBuffer(UUID.randomUUID().toString());
		fileName.append(file.getOriginalFilename());
		//文件上传
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(url+File.separator+fileName));
			mess=true;
		} catch (IOException e) {
			e.printStackTrace();
			mess=false;
		}
		System.out.println("hh");
		if(mess){
			return "success";
		}else{
			return "upload";
		}	
	}
}
