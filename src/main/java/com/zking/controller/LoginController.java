package com.zking.controller;

import com.zking.model.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/changeLanguage")
    public String changeLanguage(HttpSession session){
        Locale local=(Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
        if (null==local){
            session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,Locale.US);
        }else {
            if ("CN".equals(local.getCountry())) {
                session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.US);
            } else {
                session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, Locale.CHINA);
            }
        }
        return "redirect:login";
    }

    @ModelAttribute
    public void tranData(Model model){
        User user=new User();
        model.addAttribute("user",user);
    }

    @RequestMapping("/doLogin")
    public String doLogin(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "login";
        }
        if (null!=user){
            if (user.getUsername().equals("admin")&&user.getPwd().equals("123")&&user.getEmail().equals("123@qq.com")){
                return "main";
            }
        }
        return "login";
    }

    @RequestMapping("/goUpload")
    public String goUpload(){
        return "upload";
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        File file=new File("C:\\Users\\Administrator\\Pictures\\风景"+filename);
        //开始文件上传
        multipartFile.transferTo(file);
        return null;
    }


    @RequestMapping("/download/{filename}")
    public ResponseEntity<byte[]> download(HttpServletResponse response, @PathVariable String filename) throws IOException {
        String filepath= "C:\\Users\\Administrator\\Pictures\\崩坏\\"+filename+".jpg";
        File file=new File(filepath);
        HttpHeaders headers=new HttpHeaders();
        headers.setContentDispositionFormData("attachment",filename+".jpg");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
    }

}
