package com.github.phillipkruger.membership;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

/**
 * Activate JAX-RS. 
 * All REST Endpoints available under /api
 * 
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */

@ApplicationPath("/api")
@OpenAPIDefinition(info = @Info(
        title = "Membership service", 
        version = "1.0.0", 
        contact = @Contact(
                name = "Phillip Kruger", 
                email = "phillip.kruger@phillip-kruger.com",
                url = "http://www.phillip-kruger.com")
        ),
        servers = {
            @Server(url = "/membership",description = "localhost"),
            @Server(url = "http://yellow:8080/membership",description = "Yellow Pi")        
        }
)
@SecurityScheme(securitySchemeName = "Authorization",
        description = "The JWT from User service",
        in = SecuritySchemeIn.HEADER, 
        type = SecuritySchemeType.HTTP, 
        scheme = "bearer", 
        bearerFormat = "JWT")
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"user", "admin"})
public class ApplicationConfig extends Application {

}
