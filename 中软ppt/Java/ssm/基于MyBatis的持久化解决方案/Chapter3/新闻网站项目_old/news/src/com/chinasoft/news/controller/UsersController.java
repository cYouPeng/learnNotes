package com.chinasoft.news.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.chinasoft.news.entity.FirstTitle;
import com.chinasoft.news.entity.Users;
import com.chinasoft.news.service.UsersService;

@Controller
@RequestMapping("/users")
@SessionAttributes({"users"})
public class UsersController {
	
	@Resource
	private UsersService userService;
	
	@RequestMapping("/selectUsersByNameByPass")
	public String selectUsersByNameByPass(Users users,String authCode,Model model,HttpSession session){
		if(!session.getAttribute("strCode").equals(authCode)){
			model.addAttribute("errorMessage","验证码输入不正确！");
    		return "admin/login";
		}
		Users usersResult = userService.selectUsersByNameByPass(users);
		if(usersResult!=null){
    		model.addAttribute("users",usersResult);
    		return "admin/admin";
    	}else{
    		model.addAttribute("errorMessage","用户名或密码不正确！");
    		return "admin/login";
    	}
	}
	
	@RequestMapping("/upload")
    public String upload(@RequestParam(value = "file",required=false) MultipartFile file,HttpServletRequest request,Model model){
		//获取上传图片存储目录
		String path = request.getSession().getServletContext().getRealPath("upload"); 
		//获取文件名
        String fileName = file.getOriginalFilename();  
        
        //给上传图片取新名称，防止原图片名称中包含特殊字符
        //System.currentTimeMillis() 自1970年1月1日0时起的毫秒数, 后面加上原图片后缀名
        String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));  
        //在指定上传图片存储目录中创建新文件
        File targetFile = new File(path, newFileName);
        //如果找不到指定上传图片存储目录，就新创建此目录
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        //将上传后的文件路径传递到view
        model.addAttribute("fileUrl",newFileName);  
        return "/admin/upload";
    }
	
	@RequestMapping("/insertUsers")
	public String insertUsers(Users users){
		int result = userService.insertUsers(users);
		if(result>0){
			return "redirect:/admin/registerSuccess.jsp";
		}else{
			return "admin/error";
		}
	}
	
    //验证码
    @RequestMapping({"authCode"})
    public void getAuthCode(HttpServletResponse response,HttpSession session)throws IOException {
        int width = 63;
        int height = 37;
        Random random = new Random();
        //设置response头信息
        //禁止缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        //生成缓冲区image类
        BufferedImage image = new BufferedImage(width, height, 1);
        //产生image类的Graphics用于绘制操作
        Graphics g = image.getGraphics();
        //Graphics类的样式
        g.setColor(this.getRandColor(200, 250));
        g.setFont(new Font("Times New Roman",0,28));
        g.fillRect(0, 0, width, height);
        //绘制干扰线
        for(int i=0;i<40;i++){
            g.setColor(this.getRandColor(130, 200));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);
            g.drawLine(x, y, x + x1, y + y1);
        }

        //绘制字符
        String strCode = "";
        for(int i=0;i<4;i++){
            String rand = String.valueOf(random.nextInt(10));
            strCode = strCode + rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand, 13*i+6, 28);
        }
        //将字符保存到session中用于验证
        session.setAttribute("strCode", strCode);
        g.dispose();
        ImageIO.write(image, "JPEG", response.getOutputStream());
        response.getOutputStream().flush();

    }
    
    private Color getRandColor(int fc,int bc){
        Random random = new Random();
        if(fc>255)
            fc = 255;
        if(bc>255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r,g,b);
    }
}
