package cn.zfc.entity;

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
@TableName(value = "sys_role_menu", autoResultMap = true)
public class SysRoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField(value = "role_id")
    private Integer roleId;

    @TableField(value = "menu_id")
    private Integer menuId;


}
