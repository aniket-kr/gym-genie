package fuel.gymgenie.service;

import fuel.gymgenie.entity.Member;
import fuel.gymgenie.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final RoleService roleService;

    public Member saveMember(Member member, String rawPassword) {
        member.setRole(roleService.findByName("Member"));
        member.setPasswordHash(BCrypt.hashpw(rawPassword, BCrypt.gensalt()));
        return memberRepository.save(member);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public boolean verifyPassword(Member member, String rawPassword) {
        return BCrypt.checkpw(rawPassword, member.getPasswordHash());
    }
}
