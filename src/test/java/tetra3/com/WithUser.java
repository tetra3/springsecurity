package tetra3.com;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.test.context.support.WithMockUser;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(username = "jaehyun", roles = "USER")
public @interface WithUser {

}
