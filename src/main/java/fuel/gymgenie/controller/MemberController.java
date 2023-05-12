package fuel.gymgenie.controller;

import fuel.gymgenie.entity.Member;
import fuel.gymgenie.entity.Profile;
import fuel.gymgenie.service.MemberService;
import fuel.gymgenie.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final ProfileService profileService;

    @PostMapping("/signup")
    public String createMemberWithProfile(Model model, Member member, Profile profile, String password) {
        profile = profileService.saveProfile(profile);
        member.setProfile(profile);
        memberService.saveMember(member, password);
        return "redirect:/login";
    }

    @GetMapping("/member/dashboard")
    public String dashboard(Model model) {

        return "";
    }
}
