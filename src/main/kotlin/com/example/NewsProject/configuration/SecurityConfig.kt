package com.example.NewsProject.configuration

import com.example.NewsProject.consts.AccountTypes
import com.example.NewsProject.security.AccountAuthenticationManager
import com.example.NewsProject.service.AccountServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
//@EnableWebSecurity
class SecurityConfig(
    private val accountServiceImpl: AccountServiceImpl
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authenticationManager(): AuthenticationManager{
        return AccountAuthenticationManager(passwordEncoder(), accountServiceImpl)
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
//                authorize(anyRequest, hasAuthority("ROLE_${AccountTypes.USER}"))
                authorize(anyRequest, authenticated)
            }
            httpBasic { }
            csrf { disable() } // Recommend to disable for RESTApi
        }
        return http.build()
    }

//    @Bean
//    fun userDetailsService(): UserDetailsService = UserDetailsService {
//
//    }
}