package shop.mtcoding.loginapp.user;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService us;
    private final HttpSession session;

    // http://localhost:8080/oauth/callback?code=3u9fk
    @GetMapping("/oauth/callback")
    public String oauthCallback(String code) {
        System.out.println("우와 콜백 됐다! : " + code);
        User sessionUser = us.카카오로그인(code);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/shop";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "join-form";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "login-form";
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
        us.회원가입(username, password, email);
        return "redirect:/login-form";
    }

    @PostMapping("/login")
    public String login(String username, String password, String email) {
        User sessionUser = us.로그인(username, password);
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/shop";
    }
}
