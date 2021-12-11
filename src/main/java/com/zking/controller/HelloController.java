package com.zking.controller;

import com.zking.model.Book;
import com.zking.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private IBookService bookService;

    @ModelAttribute
    public void list(Model model){
        Book book=new Book();
        List<Book> list = bookService.list(book);
        for (Book b : list) {
            model.addAttribute("list",list);
        }
    }

    @RequestMapping("/del")
    public String delh(int id){
        bookService.deleteByPrimaryKey(id);
        return "forward:/hello";
    }

    @RequestMapping("/do")
    public String textModel(Model model){
        model.addAttribute("mame","ko");
        return "/index";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
//    @GetMapping("/hello")
//    @PostMapping("/hello")
//    @ResponseBody
    public String hello(Book book){
        System.out.printf(book+"访问");
        return "index";
    }

    @RequestMapping("/goList")
    @ResponseBody
    public List<String> goList(){
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        return list;
    }

    @RequestMapping("/")
    public String index(){
        System.out.printf("首页");
        return "index";
    }



    @RequestMapping("/a/{name}")
    public String a(@PathVariable String name){
        System.out.printf("a要访问"+name);
        return "hello";
    }

    @ModelAttribute//非请求处理参数 (当前类被调用了，这个方法就会运行)
    public void B(Model model){
        model.addAttribute("b","ka");
    }

    @RequestMapping("/b")//请求处理方法
    public String b(HttpSession session){
        System.out.printf("调用B");
        session.setAttribute("s","session");
        return "hello";
    }

    @ModelAttribute
    public void C(Model model){
        Book book=new Book();
        book.setBookName("ka");
        book.setBookPrice(60f);
        book.setBookBrief("hello");
        Map<String,Object> map=new HashMap<>();
        map.put("1","游戏");
        map.put("2","运动");
        map.put("3","学习");
        List<String> list=new ArrayList<>();
        list.add("JAVA");
        list.add("C++");
        book.setCourses(list);
        List<String> list1=new ArrayList<>();
        list1.add("男");
        book.setSex(list1);
        model.addAttribute("c",book);
        model.addAttribute("m",map);
    }

}





