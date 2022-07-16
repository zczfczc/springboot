package cn.zfc.mapper;

import cn.zfc.entity.SysUser;
import cn.zfc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zfc
 * @since 2022-07-12
 */
@Repository
public interface UerMapper extends BaseMapper<User> {
}
