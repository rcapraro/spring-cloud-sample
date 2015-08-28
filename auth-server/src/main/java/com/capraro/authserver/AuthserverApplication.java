package com.capraro.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * Authorization server application.
 * <p>
 * Covers only the following grant types:
 * <ul>
 * <li>
 * password
 * </li>
 * <li>
 * client_credentials
 * </li>
 * </ul>
 *
 * @author capraro
 *         date 28/08/2015
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthserverApplication.class, args);
    }

    @Configuration
    @EnableAuthorizationServer
    protected static class OAuth2Config extends AuthorizationServerConfigurerAdapter {

        @Autowired
        private AuthenticationManager authenticationManager;

        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            /*KeyPair keyPair = new KeyStoreKeyFactory(
                    new ClassPathResource("keystore.jks"), "foobar".toCharArray())
                    .getKeyPair("test");
            converter.setKeyPair(keyPair);*/
            converter.setSigningKey("Sada");
            converter.setVerifierKey("Sada");
            return converter;
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                   .withClient("acme")
                   .secret("acmesecret")
                   .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                   .scopes("openid");
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints)
                throws Exception {
            endpoints.authenticationManager(authenticationManager).accessTokenConverter(jwtAccessTokenConverter());
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer)
                throws Exception {
            oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        }

    }

}
