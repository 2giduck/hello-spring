package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // hello.html로 연결
        // 문자를 반환하면 뷰 리졸버(viewResolver)가 화면을 찾아서 처리
        // resources:templates/ + {viewName} + .html
        // spring-boot-devtools 라이브러리 추가하면 재시작 없이 바꾼 html바로 볼 수 있음
    }
}
