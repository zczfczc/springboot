package cn.zfc.entity;

import java.time.LocalDateTime;
import cn.zfc.base.commons.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zfc
 * @since 2022-07-12
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@TableName(value = "sys_user", autoResultMap = true)
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField(value = "username")
    private String username;

    @TableField(value = "last_login")
    private String password;

    @TableField(value = "avatar")
    private String avatar;

    @TableField(value = "email")
    private String email;

    @TableField(value = "city")
    private String city;

    @TableField(value = "last_login")
    private LocalDateTime lastLogin;

    @TableField(value = "status")
    private String status;


}
