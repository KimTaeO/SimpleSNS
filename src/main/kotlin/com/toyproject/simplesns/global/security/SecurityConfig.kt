package com.toyproject.simplesns.global.security

import com.toyproject.simplesns.global.security.config.FilterConfig
import com.toyproject.simplesns.global.security.jwt.JwtProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsUtils

@Component
class SecurityConfig(
    private val jwtProvider: JwtProvider,
    private val objectMapper: ObjectMapper
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .cors().and().csrf()
            .disable()
            .formLogin().disable()
            .httpBasic().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()
            .authorizeRequests()
            .requestMatchers(RequestMatcher { request ->
                CorsUtils.isPreFlightRequest(request)
            }).permitAll()


            .antMatchers(HttpMethod.POST, "/auth/**").permitAll()
            .anyRequest().permitAll()

            .and()
            .exceptionHandling()
            .accessDeniedHandler(CustomAccessDeniedHandler(objectMapper))
            .authenticationEntryPoint(CustomAuthenticationEntryPoint(objectMapper))

            .and()
            .apply(FilterConfig(jwtProvider))

            .and()
            .build()

    @Bean
    fun passwordEncoder(): PasswordEncoder =
        BCryptPasswordEncoder()
}