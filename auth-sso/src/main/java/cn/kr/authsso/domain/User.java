package cn.kr.authsso.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
}