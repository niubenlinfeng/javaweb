package com.hzyc.niuben;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,response);
	}

	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //设置编码  
		response.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		System.out.println(username);
        //获得磁盘文件条目工厂  
        DiskFileItemFactory factory = new DiskFileItemFactory(); 
        //获取文件需要上传到的路径  
        String path = request.getRealPath("/app_imagesText"); 
        String path1 = request.getRealPath("/app_images"); 
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
            System.out.println(list.size()+"%%%%");
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
                    filename=username+"_"+filename;
                    File file1 = new File(path,filename);
                    File file2 = new File(path1,filename);
                    //写到磁盘上  
                    item.write( file1);//第三方提供的  
                    System.out.println("上传成功："+filename);
                    
                    String pathall=zipWidthHeightImageFile(file1,file2,30,50,0.5f);
                    response.getWriter().print(filename);//将路径返回给客户端
                }  
            }  
              
        } catch (Exception e) {  
        	System.out.println("上传失败");
        	response.getWriter().print("上传失败："+e.getMessage());
        }  
		
	}
	 /**  
     * 按设置的宽度高度压缩图片文件<br> 先保存原文件，再压缩、上传  
     * @param oldFile  要进行压缩的文件全路径  
     * @param newFile  新文件  
     * @param width  宽度  
     * @param height 高度  
     * @param quality 质量  
     * @return 返回压缩后的文件的全路径  
     */    
    public static String zipWidthHeightImageFile(File oldFile,File newFile, int width, int height,float quality) {    
        if (oldFile == null) {    
            return null;    
        }    
        String newImage = null;    
        try {    
            /** 对服务器上的临时文件进行处理 */    
            Image srcFile = ImageIO.read(oldFile);    
              
            String srcImgPath = newFile.getAbsoluteFile().toString();  
            System.out.println(srcImgPath);  
            String subfix = "jpg";  
            subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".")+1,srcImgPath.length());  
  
            BufferedImage buffImg = null;   
            if(subfix.equals("png")){  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);  
            }else{  
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            }  
  
            Graphics2D graphics = buffImg.createGraphics();  
            graphics.setBackground(new Color(255,255,255));  
            graphics.setColor(new Color(255,255,255));  
            graphics.fillRect(0, 0, width, height);  
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);    
  
            ImageIO.write(buffImg, subfix, new File(srcImgPath));    
        } catch (FileNotFoundException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        }    
        return newImage;    
    }    

}
