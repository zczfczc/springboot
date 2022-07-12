package cn.zfc.entity;


import cn.zfc.base.commons.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

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
@TableName(value = "sys_role", autoResultMap = true)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField(value = "name")
    private String name;

    @TableField(value = "code")
    private String code;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(value = "status")
    private String status;


}
