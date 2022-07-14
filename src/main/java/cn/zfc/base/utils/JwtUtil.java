package cn.zfc.base.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * token工具类
 *
 * @auther:zfc
 * @Date:2022-07-14 10:15:49
 **/
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "cn.jwt")
public class JwtUtil {
    // 过期时间数
    private long expire;
    // 秘钥
    private String secret;

    private String header;

    /**
     * 生成token
     *
     * @param username
     * @return
     */
    public String generateToken(String username) {
        Date date = new Date(); // 当前时间
        Date expireDate = new Date(date.getTime() + 1000 * expire); // 过期时间
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(username)
                .setIssuedAt(date)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public Claims getClaimsByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("验证码非法------>{}", e.getMessage());
            return null;
        }
    }

    /**
     * token 是否过期
     *
     * @param claims
     * @return
     */
    public boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }



}
