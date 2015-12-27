package springsimpleauthwrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationProviderEx implements AuthenticationProvider {

    @Autowired
    private MyAuthService myAuthService;

    public Authentication authenticate(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if( !myAuthService.check(username, password) ) {
            throw new BadCredentialsException("Bad username or password.");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for(String role : myAuthService.roles(username)) {
            authorities.add(new SimpleGrantedAuthority(role));
        }

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    public boolean supports(Class<?> clazz) {
        return UsernamePasswordAuthenticationToken.class.equals(clazz);
    }

}