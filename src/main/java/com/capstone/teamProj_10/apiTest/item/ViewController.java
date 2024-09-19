package com.capstone.teamProj_10.apiTest.item;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage")
    public String mypage() {
        return "/mypage";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/cart")
    public String cart() {
        return "/cart";
    }

    @GetMapping("/pwchange")
    public String pwchange() {
        return "/pwchange";
    }
}