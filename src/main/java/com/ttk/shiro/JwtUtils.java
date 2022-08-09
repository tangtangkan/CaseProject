package com.ttk.shiro;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
// 读取application.yml文件markerhub.jwt的内容到java类
@ConfigurationProperties(prefix = "markerhub.jwt")
@Data
public class JwtUtils {

    // 加密秘钥
    private String secret;

    // token有效时长
    private long expire;

    // token
    private String header;

    /**
     * 生成jwt token
     * @param issuer    jwt签发人
     * @param uid    需要加密的数据
     * @return
     */
    public String generateToken(String issuer, Long uid) {

        // 签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 生成Jwt的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // 生成秘钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // 设置JWT所存储的信息
        JwtBuilder builder = Jwts.builder()
                .setSubject(uid.toString())
                .setId(UUID.randomUUID().toString())        // jwt唯一标识
                .setIssuer(issuer)                          // 签发人
                .setIssuedAt(now)                           // 签发时间
                .signWith(signatureAlgorithm, signingKey);  // 签名算法和秘钥

        // 设置过期时间
        if (expire >= 0) {
            long expMillis = nowMillis + expire;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // 构建JWT并将其序列化为紧凑的URL安全字符串
        return builder.compact();
    }

    // 获取jwt的信息
    public Claims getClaimByToken(String token) {
        System.out.println("getClaimByToken+++++++++++++++++");
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secret)).parseClaimsJws(token).getBody();
    }

    /**
     * token是否过期
     *
     * @return true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        System.out.println("isTokenExpired+++++++++++++++++");
        return expiration.before(new Date());
    }
}
