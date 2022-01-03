package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value="name", required=false) String name, Model model){
        model.addAttribute("name", name);
        // viewResolver: 화면을 찾아서 컨트롤러와 연결
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // http body 부분에 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    @GetMapping("hello-api")
    @ResponseBody   // 기본이 JSON
    public Hello helloApi(@RequestParam("name")String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // viewResolver 대신 HttpMessageConverter 동작
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
