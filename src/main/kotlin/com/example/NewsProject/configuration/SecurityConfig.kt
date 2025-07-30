package com.example.NewsProject.configuration

import com.example.NewsProject.security.AccountAuthenticationProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain


@Configuration
//@EnableWebSecurity
class SecurityConfig(
    private val accountAuthenticationProvider: AccountAuthenticationProvider
) {

    @Bean
    fun authenticationManager(): AuthenticationManager {
        return ProviderManager(listOf(accountAuthenticationProvider))
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
//                authorize(anyRequest, hasAuthority("ROLE_${AccountTypes.USER}"))
                authorize(anyRequest, authenticated)
            }
            httpBasic { }
            csrf { disable() }
        }
        return http.build()
    }
}