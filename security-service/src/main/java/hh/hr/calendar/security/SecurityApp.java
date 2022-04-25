package hh.hr.calendar.security;

import hh.hr.calendar.security.config.SecurityConfig;
import ru.hh.nab.starter.NabApplication;


public class SecurityApp {
    public static void main(String[] args) {
        NabApplication.builder()
                .configureJersey().addAllowedPackages("hh.hr").bindToRoot()
                .build().run(SecurityConfig.class);
    }
}
