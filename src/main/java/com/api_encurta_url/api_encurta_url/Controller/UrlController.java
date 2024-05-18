package com.api_encurta_url.api_encurta_url.Controller;

import com.api_encurta_url.api_encurta_url.Services.UrlShortService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

@RestController
@RequestMapping("/url")
public class UrlController {

    private final UrlShortService urlShortService;

    public UrlController(UrlShortService urlShortService) {
        this.urlShortService = urlShortService;
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody String url) {
        return urlShortService.shortenUrl(url);
    }

    @GetMapping("/{url}")
    public String redirectToOriginalUrl(@PathVariable String url) {
        return urlShortService.getOriginalUrl(url);
    }
}
