package com.keke.controller;

import com.keke.domain.CourseRes;
import com.keke.domain.Teacher;
import com.keke.service.AdminService;
import com.keke.service.CourseResService;
import com.keke.util.Layui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/resource")
public class ResourceController {
    /*static String fileLocation = "/courseRes/";//图片资源访问路径
    存储预返回页面的结果对象
    private Map<String, Object> result = new HashMap<>();
    注入业务对象*/
    @Autowired
    private CourseResService courseResService;

    private String url;

    @RequestMapping(value="/uploadFile",produces="application/json;charset=UTF-8")
    public String uploadFile(@RequestParam("fileName") MultipartFile file, @RequestParam("cno") String cno, HttpServletRequest request) {

        System.out.print("上传文件==="+"\n");
        //判断文件是否为空
        if (file.isEmpty()) {
            return "上传文件不可为空";
        }
        String fileName = file.getOriginalFilename();
        System.out.print("上传的文件名为: "+fileName+"\n");
        String path = "/Users/uu/Documents/MyProjects/upload/" +fileName;
        System.out.print("保存文件绝对路径"+path+"\n");
        File dest = new File(path);
        if (dest.exists()) {
            return "文件已经存在";
        }
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存文件路径" + path + "\n");
            //url="http://你自己的域名/项目名/images/"+fileName;//正式项目
            Teacher teacher = (Teacher) request.getSession().getAttribute("session_type");
            url = "http://localhost:8080/courseRes/" + fileName;//本地运行项目
            CourseRes courseRes = new CourseRes();
            courseRes.setFileurl(url);
            courseRes.setName(fileName);
            courseRes.setTno(teacher.getTno());
            courseRes.setCno(cno);
            courseResService.insertUrl(courseRes);
            System.out.print("保存的完整url===="+url+"\n");
        } catch (IOException e) {
            return "teacher/updatecourse";
        }

        return "teacher/updatecourse";
    }



        /*获取提交文件名称
        String filename = courseFile.getSubmittedFileName();
        //定义上传文件存放的路径
        String path = request.getSession().getServletContext().getRealPath(fileLocation);//此处为tomcat下的路径，服务重启路径会变化
        System.out.println(path);
        //返回保存的url，根据url可以进行文件查看或者下载
        String filePath = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() //端口 https443端口无需添加
                + fileLocation + filename;

        String fileurl = filePath;//根路径+文件名
        CourseRes courseRes = new CourseRes();
        courseRes.setCno(cno);
        courseRes.setTno(tno);
        courseRes.setName(name);
        courseRes.setFileurl(fileurl);
        courseResService.insertUrl(courseRes);
        //adminService.addFood(new Food(name, prices, description, pictureFileURL));

        //写入文件
        try {
            courseFile.write(filename);
            return Layui.data2(200,"添加成功！");
            //result.put("Result", "添加成功");
        } catch (IOException e) {
            e.printStackTrace();
            //result.put("Result", "添加失败");
            return Layui.data2(100,"添加失败！");
        }*/
}
