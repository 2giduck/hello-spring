package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    // 스프링 컨테이너에 컨트롤러가 등록됨
    private final MemberService memberService;

    /**
     *
     * @Component 어노테이션이 있으면 스프링 빈으로 자동 등록
     * main의 하위 패키지들만 등록됨
     * 기본으로 싱글톤으로 등록함. 같은 스프링 빈이면 모두 같은 인스턴스
     */

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
