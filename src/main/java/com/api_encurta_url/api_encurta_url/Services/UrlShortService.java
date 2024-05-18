package com.api_encurta_url.api_encurta_url.Services;

import com.api_encurta_url.api_encurta_url.Model.UrlEntity;
import com.api_encurta_url.api_encurta_url.Repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UrlShortService {

    private final UrlRepository urlRepository;

    public UrlShortService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String originalUrl) {
        Optional<UrlEntity> existingUrl = urlRepository.findByOriginalUrl(originalUrl);
        if (existingUrl.isPresent()) {
            return existingUrl.get().getShortUrl();
        }

        String shortCode = generateShortCode(originalUrl);

        UrlEntity url = new UrlEntity(originalUrl, shortCode);
        urlRepository.save(url);

        return shortCode;
    }

    public String getOriginalUrl(String shortenedUrl) {
        Optional<UrlEntity> url = urlRepository.findByShortUrl(shortenedUrl);
        if (url.isPresent()){
            return url.get().getOriginalUrl();
        }
        return null;
    }

    private String generateShortCode(String originalUrl) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(originalUrl.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString().substring(0, 8);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "default";
        }
    }
}
