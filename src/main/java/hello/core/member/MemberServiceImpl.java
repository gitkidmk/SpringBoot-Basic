package hello.core.member;

public class MemberServiceImpl implements MemberService{
    // TODO: why final?
    // 인터페이스에 대한 구현체가 하나인 경우에는 Impl이라고 명시
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
