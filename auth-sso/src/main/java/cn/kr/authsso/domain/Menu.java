package cn.kr.authsso.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 菜单实体
 * @author Administrator
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable{

    private Integer id;


    private String name;


    private String url;


    private String group;


    private Integer userId;
}