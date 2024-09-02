package sogeumppang.gachitajang_be.member.domain.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import sogeumppang.gachitajang_be.common.config.JpaConfig;
import sogeumppang.gachitajang_be.member.domain.entity.Member;
import sogeumppang.gachitajang_be.member.repository.MemberRepository;

@Slf4j
@DataJpaTest
@Import(JpaConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
//    @Rollback(value = false)
    void createMemberTest() {
        Member member = Member.builder()
                .userName("member")
                .nickname("member")
                .build();

        memberRepository.save(member);
    }
}