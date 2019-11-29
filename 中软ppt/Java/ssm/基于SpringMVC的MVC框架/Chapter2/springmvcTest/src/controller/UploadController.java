package controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ssm")
public class UploadController {

	@RequestMapping("/upload.do")
	public String upload(Model model,MultipartFile myFile,HttpServletRequest request) throws Exception {
		//获取上传图片存储目录
	    String path = request.getSession().getServletContext().getRealPath("upload");  
	    //获取文件名并生成新文件名)
	    String fileName = myFile.getOriginalFilename();  
	    String newFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));  
	    //在指定上传图片存储目录中创建新文件
	    File targetFile = new File(path, newFileName);  
	    //如果找不到指定上传图片存储目录，就新创建此目录
	    if(!targetFile.exists()){  
	        targetFile.mkdirs();  
	    }  
	    //将文件写入硬盘（myFile在内存中）
	    try {  
	    	myFile.transferTo(targetFile);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    //将上传后的文件路径传递到view
	    model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+newFileName);  
	    return "upload";  
	}
}
