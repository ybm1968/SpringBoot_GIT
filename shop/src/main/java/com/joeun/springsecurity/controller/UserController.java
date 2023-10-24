package com.joeun.springsecurity.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.springsecurity.dto.Users;
import com.joeun.springsecurity.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    /**
     * 사용자 페이지
     * @return
     */
    // 회원권한(ROLE_USER)을 가진 사용자만 접근 허용
    // @PreAuthorize("hasRole('ROLE_USER')")
    // @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    // @Secured("ROLE_USER")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(value={"/", ""})
    public String index() {
        // int result = 10 / 0;
        // log.info(result + "");
        return "user/index";
    }

    @GetMapping(value="/update")
    public String update(Model model, Principal principal) throws Exception {
        String loginId = principal != null ? principal.getName() : null;

        Users user = userService.selectById(loginId);

        model.addAttribute("user", user);

        return "/user/update";
    }

    @PostMapping(value="/update")
    public String updatePro(Users user, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int result = userService.update(user);
        log.info(user.toString());

        if( result == 0 ) {
            return "redirect:/user/update";
        }

        // HttpSession session = request.getSession();
        // session.invalidate();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(request, response, authentication);
        Cookie cookie = new Cookie("remember-me", "");     // 쿠키에 아이디 등록
        cookie.setMaxAge(0);                                  // 유효기간  : X
        cookie.setPath("/");        
        response.addCookie(cookie);
        return "redirect:/login";
    }
    
    

    
    
    
}
