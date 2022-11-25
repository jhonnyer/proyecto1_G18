package com.unab.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({@PropertySource({"classpath:textos.properties", "classpath:mysql.properties"})})
public class FilesPropertiesConfig {

}
