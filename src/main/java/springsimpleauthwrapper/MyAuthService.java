package springsimpleauthwrapper;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MyAuthService {

   public boolean check(String username, String password) {
      if( "user1".equals(username) ) {
         return "password1".equals(password);
      }
      else if( "user2".equals(username) ) {
         return "password2".equals(password);
      }
      return false;
   }

   public List<String> roles(String username) {

      if( "user1".equals(username) ) {
         return Arrays.asList("ROLE_USER", "ROLE_ADMIN");
      }
      else if ( "user2".equals(username) ) {
         return Arrays.asList("ROLE_USER");
      }
      else {
         return Arrays.asList(new String []{});
      }

   }

}
