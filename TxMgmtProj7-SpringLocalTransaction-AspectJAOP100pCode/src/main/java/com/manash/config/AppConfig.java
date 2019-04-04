package com.manash.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={Persistance_Beans.class,Service_Beans.class,TxMgmt_Beans.class})
public class AppConfig {

}
