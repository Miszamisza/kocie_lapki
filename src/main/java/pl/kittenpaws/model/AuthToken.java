package pl.kittenpaws.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthToken {

    private String userId;
    private String accessToken;
    private String tokenType = "Bearer";
    private Long expiresIn;
    private String scope;


    public AuthToken(String userId, String accessToken, Long expiresIn, String scope) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
    }
}
