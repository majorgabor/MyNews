
package hu.elte.mynews.annotation;

import hu.elte.mynews.entity.User;
import hu.elte.mynews.service.UserService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    
    @Autowired
    private UserService userService;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<User.Role> routeRoles = getRoles((HandlerMethod) handler);
        User user = userService.getCurrentUser();

        // when there are no restrictions, we let the user through
        if (routeRoles.isEmpty() || routeRoles.contains(User.Role.GUEST)) {
            return true;
        }
        // check role
        if (user != null && routeRoles.contains(user.getRole())) {
            return true;
        }
        response.setStatus(401);
        return false;
    }

    private List<User.Role> getRoles(HandlerMethod handler) {
        Role role = handler.getMethodAnnotation(Role.class);
        return role == null ? Collections.emptyList() : Arrays.asList(role.value());
    }
}
