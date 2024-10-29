package top.soft.bookonline.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;

    private String account;

    private String password;

    private String nickname;

    private String avatar;

    private String address;

    @Getter
    @Setter
    private LocalDateTime createTime;

    public String getFormattedCreateTime() {
        if (createTime == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        return createTime.format(formatter);
    }
}
