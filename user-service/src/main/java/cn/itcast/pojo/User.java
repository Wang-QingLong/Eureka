package cn.itcast.pojo;

import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @version V1.0
 * @author: WangQingLong
 * @date: 2019/12/12 17:26
 * @description:
 */
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class User implements Serializable {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String userName; // 用户名

    private String password; // 密码

    private String name;// 姓名

    private Integer age;// 年龄

    private Integer sex;// 性别，1男性，2女性

    private Date birthday;// 出生日期

    private Date created;// 创建时间

    private Date updated;// 更新时间

    private String note;// 备注
}
