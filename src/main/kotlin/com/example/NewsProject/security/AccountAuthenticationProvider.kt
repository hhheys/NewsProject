package com.example.NewsProject.security

import com.example.NewsProject.service.AccountServiceImpl
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AccountAuthenticationProvider(
    private val accountServiceImpl: AccountServiceImpl,
    private val passwordEncoder: PasswordEncoder
) : AuthenticationProvider {
    override fun authenticate(authentication: Authentication): Authentication {
        val name = authentication.name ?: throw BadCredentialsException("Authorization token missing")
        val rawPassword = authentication.credentials.toString()

        val account = accountServiceImpl.findByName(name) ?: throw BadCredentialsException("Account not found")

        if (!passwordEncoder.matches(rawPassword, account.password)) {
            throw BadCredentialsException("Incorrect password")
        }

        val authorities = listOf(SimpleGrantedAuthority("ROLE_${account.accountType}"))
        return UsernamePasswordAuthenticationToken(
            account,
            account.password,
            authorities
        )
    }

    override fun supports(authentication: Class<*>): Boolean {
        return UsernamePasswordAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}