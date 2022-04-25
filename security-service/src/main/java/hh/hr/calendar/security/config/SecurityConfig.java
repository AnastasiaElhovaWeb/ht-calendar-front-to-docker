package hh.hr.calendar.security.config;

import hh.hr.calendar.domain.repository.ManagerRepository;
import hh.hr.calendar.security.endpoint.RegistrationResource;
import hh.hr.calendar.security.service.SecurityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.common.properties.FileSettings;
import ru.hh.nab.datasource.DataSourceFactory;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.hibernate.NabHibernateProdConfig;
import ru.hh.nab.starter.NabProdConfig;

import javax.sql.DataSource;

@Configuration
@Import({
        NabProdConfig.class,
        RegistrationResource.class,
        SecurityService.class,
        NabHibernateProdConfig.class,
        ManagerRepository.class
})
public class SecurityConfig {

    @Bean
    public DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings fileSettings) {
        return dataSourceFactory.create("master", false, fileSettings);
    }

    @Bean
    public MappingConfig mappingConfig() {
        MappingConfig mappingConfig = new MappingConfig();
        mappingConfig.addPackagesToScan("hh.hr.calendar.domain.entity");
        return mappingConfig;
    }
}
