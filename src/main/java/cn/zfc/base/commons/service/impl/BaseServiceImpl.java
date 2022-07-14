package cn.zfc.base.commons.service.impl;

import cn.zfc.base.commons.service.BaseService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 *
 * @author zfc
 * @Date:2022-07-14 10:06
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
}
