package cn.zfc.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import cn.zfc.base.commons.Result.R;
import cn.zfc.base.commons.constant.Constant;
import cn.zfc.base.utils.RedisUtil;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
/**
 * @auther:zfc
 * @Date:2022-07-14 15:45
 **/
@Slf4j
@RestController
@RequestMapping("/auth/login")
public class LoginController {
    @Autowired
    private Producer producer;
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/captcha")
    public R captcha() throws Exception {
        String key = UUID.randomUUID().toString();
        String code = producer.createText();
        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ImageIO.write(image, "jpg", outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Image = "data:image/jpeg;base64," + encoder.encode(outputStream.toByteArray());

        redisUtil.hset(Constant.CAPTCHA_KEY,key,code,120);

        return R.success(MapUtil.builder().put("key",key).put("base64Image",base64Image).build());
    }

}
