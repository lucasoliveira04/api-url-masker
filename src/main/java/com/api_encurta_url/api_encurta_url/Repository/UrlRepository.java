package com.api_encurta_url.api_encurta_url.Repository;

import com.api_encurta_url.api_encurta_url.Model.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
    Optional<UrlEntity> findByOriginalUrl(String originalUrl);

    Optional<UrlEntity> findByShortUrl(String shortenedUrl);
}