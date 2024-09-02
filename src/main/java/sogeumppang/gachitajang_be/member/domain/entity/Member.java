package sogeumppang.gachitajang_be.member.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import sogeumppang.gachitajang_be.common.entity.BaseEntity;

import java.util.UUID;

@Entity
@Getter
@SQLDelete(sql = "UPDATE member SET is_deleted = true where member_id = ?")
@SQLRestriction("is_deleted = false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NotNull
    private String uuid;

    @NotNull
    private String userName;

    @NotNull
    private String nickname;

    private String refreshToken;

    private void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    @Builder
    public Member(String userName, String nickname, String refreshToken) {
        this.userName = userName;
        this.nickname = nickname;
        this.uuid = UUID.randomUUID().toString();
        this.refreshToken = refreshToken;
    }

}
