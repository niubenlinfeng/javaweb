package com.hzyc.niuben.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.hzyc.niuben.bean.DakaBean;
import com.hzyc.niuben.bean.UserBean;
import com.hzyc.niuben.service.UserService;
import com.hzyc.niuben.utils.Base64Coder;


@Controller
public class UserController {
	@Autowired
	private UserService us;
	
	
	@RequestMapping("selectALL.do")
	public void selectALL(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*//获得磁盘文件条目工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //获取文件需要上传到的路径  
        String path = request.getSession().getServletContext().getRealPath("/app_images");
        File file=new File(path);
        if(!file.exists()){
        	file.mkdirs();
        }
        factory.setRepository(new File(path));  
        //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室  
        factory.setSizeThreshold(1024*1024) ;  
        //高水平的API文件上传处理  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        try {  
            //可以上传多个文件  
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);
            System.out.println(list.size()+"@@@@@@");
            for(FileItem item : list){  
                //获取表单的属性名字  
                String name = item.getFieldName();  
                //如果获取的 表单信息是普通的 文本 信息  
                if(item.isFormField()){                     
                    //获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的  
                    String value = item.getString() ;  
                    request.setAttribute(name, value);  
                }else{  
                    //获取路径名  
                    String value = item.getName() ;  
                    //索引到最后一个反斜杠  
                    int start = value.lastIndexOf("\\");  
                    //截取 上传文件的 字符串名字，加1是 去掉反斜杠，  
                    String filename = value.substring(start+1);  
                    request.setAttribute(name, filename);  
                    //写到磁盘上  
                    item.write( new File(path,filename) );//第三方提供的  
                    System.out.println("上传成功："+filename);
                    response.getWriter().print(filename);//将路径返回给客户端
                }  
            }  
              
        } catch (Exception e) {  
        	System.out.println("上传失败");
        	response.getWriter().print("上传失败："+e.getMessage());
        }  
		//获得磁盘文件条目工厂。  
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        //获取文件上传需要保存的路径，upload文件夹需存在。  
        String path = request.getSession().getServletContext().getRealPath("/app_images");  
        //设置暂时存放文件的存储室，这个存储室可以和最终存储文件的文件夹不同。因为当文件很大的话会占用过多内存所以设置存储室。  
        factory.setRepository(new File(path));  
        //设置缓存的大小，当上传文件的容量超过缓存时，就放到暂时存储室。  
        factory.setSizeThreshold(1024*1024);  
        //上传处理工具类（高水平API上传处理？）  
        ServletFileUpload upload = new ServletFileUpload(factory);  

        try{  
            //调用 parseRequest（request）方法  获得上传文件 FileItem 的集合list 可实现多文件上传。  
            @SuppressWarnings("unchecked")
			List<FileItem> list = (List<FileItem>)upload.parseRequest(request);  
            for(FileItem item:list){  
                //获取表单属性名字。  
                String name = item.getFieldName();  
                //如果获取的表单信息是普通的文本信息。即通过页面表单形式传递来的字符串。  
                if(item.isFormField()){  
                    //获取用户具体输入的字符串，  
                    String value = item.getString();  
                    request.setAttribute(name, value);  
                }  
                //如果传入的是非简单字符串，而是图片，音频，视频等二进制文件。  
                else{   
                    //获取路径名  
                    String value = item.getName();  
                    //取到最后一个反斜杠。  
                    int start = value.lastIndexOf("\\");  
                    //截取上传文件的 字符串名字。+1是去掉反斜杠。  
                    String filename = value.substring(start+1);  
                    request.setAttribute(name, filename);  

                    第三方提供的方法直接写到文件中。 
                     * item.write(new File(path,filename));  
                    //收到写到接收的文件中。  
                    OutputStream out = new FileOutputStream(new File(path,filename));  
                    InputStream in = item.getInputStream();  

                    int length = 0;  
                    byte[] buf = new byte[1024];  
                    System.out.println("获取文件总量的容量:"+ item.getSize());  

                    while((length = in.read(buf))!=-1){  
                        out.write(buf,0,length);  
                    }  
                    in.close();  
                    out.close();  
                }  
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }  

		PrintWriter out = response.getWriter();
		imagebase = request.getParameter("imagebase");
		System.out.println("我是image:"+Base64.decodeBase64(imagebase));
		String path = request.getSession().getServletContext().getRealPath("/")+"app_images";
		File file = new File(path+"\\123.jpg");
		System.out.println(path+"\\123.jpg");
		FileOutputStream fout = new FileOutputStream(file);
        //将字节写入文件  
        fout.write(Base64.decodeBase64(imagebase));  
        fout.close();  
		
		if(file!=null){
			try{
				//1.磁盘文件项工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();
				//2.服务应用文件上传
				ServletFileUpload upload = new ServletFileUpload(factory);
				//3.文件项迭代器
				FileItemIterator iter = upload.getItemIterator(request);
				FileItemStream stream = iter.next();
				InputStream input = stream.openStream();
				//System.out.println(path);
				//File file = new File(path+"\\123.jpg");
				byte[] b= Base64Coder.decodeLines(file);
				System.out.println(b);
				String filepath= request.getSession().getServletContext().getRealPath("/")+"app_images";
				File file1=new File(filepath);
				if(!file1.exists())
					file1.mkdirs();
				FileOutputStream fos=new FileOutputStream(file1.getPath()+"/person_head"+(int)(Math.random()*100)+".jpg");				
				byte[] buffer = new byte[1024];
				buffer=b;
				int len = b.length;
					fos.write(buffer,0,len);
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		out.print("true");
		out.flush();
		out.close();
		//UserBean ub = us.selectALL();
	*/}
	@RequestMapping("login_app.do")
	public void login_app(String username,String password,HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserBean ub = null;
		username =request.getParameter("username");
		password = request.getParameter("password");
		try{
			ub = us.login_app(username);
			if(password.equals(ub.getPassword().toString())){
				out.print("true");
			}else{
				out.print("密码错误");
			}
		}catch(Exception e){
			out.print("用户名错误");
		}
	out.flush();
	out.close();
	}
	@RequestMapping("register_app.do")
	public void register_app(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserBean ub = new UserBean();
		String username =request.getParameter("username");
		String password = request.getParameter("password");
		ub.setPassword(password);
		ub.setUserName(username);
		ub.setUserBirth("1");
		ub.setUserHeight("1");
		ub.setUserImage("1");
		ub.setUserQQ("1");
		ub.setUserSex("1");
		ub.setUserState("1");
		ub.setUserTelphone("1");
		ub.setUserTrueName("1");
		ub.setUserWeibo("1");
		ub.setUserWeight("1");
		ub.setUserWeiXin("1");
		try{
			us.register_app(ub);
			out.print("true");
		}catch(Exception e){
			out.print("false");
		}
		
	out.flush();
	out.close();
	}
	@RequestMapping("updateUser.do")
	public void updateUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		UserBean ub = new UserBean();
		String trueName = request.getParameter("truenamea");
		String nicheng = request.getParameter("ncheng");
		String sex = request.getParameter("sexa");
		String height = request.getParameter("heighta");
		String weight = request.getParameter("weighta");
		String qq = request.getParameter("qqa");
		String imghead=request.getParameter("imghead");
		String weixinhao = request.getParameter("weixinhaoa");
		String telephone = request.getParameter("telephonea");
		ub.setPassword("1");
		ub.setUserName(nicheng);
		ub.setUserBirth("1");
		ub.setUserHeight(height);
		ub.setUserImage(imghead);
		ub.setUserQQ(qq);
		ub.setUserSex(sex);
		ub.setUserState("1");
		ub.setUserTelphone(telephone);
		ub.setUserTrueName(trueName);
		ub.setUserWeibo("1");
		ub.setUserWeight(weight);
		ub.setUserWeiXin(weixinhao);
		try{
			us.updateUser(ub);
			out.print("true");
		}catch(Exception e){
			out.print("false");
		}
		
	out.flush();
	out.close();
	}
	
	@RequestMapping("selectUser.do")
	public void selectUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String username =request.getParameter("userName");
	
		try{
			List<UserBean> dblist = us.selectUser(username);
		Gson gson = new Gson();
		String data = gson.toJson(dblist);
		response.getWriter().print(data);
		}catch(Exception e){
			response.getWriter().print("false");
		}
	out.flush();
	out.close();
	}
	@RequestMapping("selectUserImg.do")
	public void selectUserImg(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String username =request.getParameter("userName");
	
		try{
			List<UserBean> dblist = us.selectUser(username);
			if(dblist.get(0).getUserImage().equals("1")){
				response.getWriter().print("noImage");
			}else{
				response.getWriter().print(dblist.get(0).getUserImage().toString());
			}
		}catch(Exception e){
			response.getWriter().print("false");
		}
	out.flush();
	out.close();
	}
}
