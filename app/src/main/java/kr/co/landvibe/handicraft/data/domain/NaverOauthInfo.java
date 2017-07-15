package kr.co.landvibe.handicraft.data.domain;


import io.realm.RealmObject;

public class NaverOauthInfo extends RealmObject{

    private String accessToken;
    private String refreshToken;
    private long expiresAt;
    private String tokenType;

    public NaverOauthInfo(){}

    public NaverOauthInfo(String accessToken, String refreshToken, long expiresAt, String tokenType) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expiresAt = expiresAt;
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}