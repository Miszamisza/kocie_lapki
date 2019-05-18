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
    private String imageUrl;


    public AuthToken(
            String userId,
            String accessToken,
            Long expiresIn,
            String scope,
            String imageUrl
    ) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.imageUrl = imageUrl;
    }
}
