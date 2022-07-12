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
 * @since 2022-07-11
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@AllArgsConstructor
@TableName(value = "sys_menu", autoResultMap = true)
public class SysMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 父菜单ID，一级菜单为0
     */
    @TableField(value = "parent_id")
    private Long parentId;

    @TableField(value = "name")
    private String name;

    /**
     * 菜单URL
     */
    @TableField(value = "path")
    private String path;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    @TableField(value = "perms")
    private String perms;

    @TableField(value = "component")
    private String component;

    /**
     * 类型     0：目录   1：菜单   2：按钮
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 排序
     */
    @TableField(value = "orderNum")
    private Integer ordernum;

    /**
     * 状态
     */
    @TableField(value = "status")
    private String status;

}
