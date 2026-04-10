package com.example.schedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * JPA Auditing 활성화를 위한 설정 클래스
 */
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
