package fuel.gymgenie.controller;

import fuel.gymgenie.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AppController {
    private final MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signup")
    public String signupDisplay() {
        return "signup";
    }

    @GetMapping("/login")
    public String loginDisplay() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(HttpServletRequest req, String email, String password) {
        var member = memberService.findByEmail(email);
        if (!memberService.verifyPassword(member, password)) {
            return "redirect:/login";
        }

        var session = req.getSession();
        session.setAttribute("USER_ID", member.getId());
        session.setAttribute("USER_EMAIL", member.getEmail());
        session.setAttribute("USER_ROLE", member.getRole().getName());
        return switch (member.getRole().getName()) {
            case "Member" -> "redirect:/member/dashboard";
            case "Admin" -> "redirect:/admin/dashboard";
            default -> "redirect:/member/dashboard";
        };
    }
}
