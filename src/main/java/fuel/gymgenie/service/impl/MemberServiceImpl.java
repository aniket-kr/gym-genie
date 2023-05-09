package fuel.gymgenie.service.impl;

import fuel.gymgenie.entity.Member;
import fuel.gymgenie.repository.MemberRepository;
import fuel.gymgenie.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        super();
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
