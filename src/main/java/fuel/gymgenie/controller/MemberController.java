package fuel.gymgenie.controller;

import fuel.gymgenie.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public String listMembers(Model model) {
        model.addAttribute("title", "My Dynamic Title");
        model.addAttribute("members", memberService.getAllMembers());
        return "members";
    }
}