package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    /**
     *
     * 자바 코드로 빈 등록하기
     * 생성자 주입을 권장함
     *
     */

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
