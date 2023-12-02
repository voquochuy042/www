package vn.edu.iuh.fit.dto;

import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import java.security.Principal;

public record AuthInfos(Principal principal, Authentication authentication) {
    @Override
    public String toString() {
        return "AuthInfos {principal="+ principal.getName() +", auth=" + StringUtils.collectionToDelimitedString(authentication.getAuthorities(), ", ") +"}";
    }
}
