package ru.volnenko.cloud.am.controller;

import com.sun.istack.NotNull;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractController {

    @NotNull
    private static String host = "0.0.0.0";

    @NotNull
    private static String port = "8080";

    @NotNull
    public static final JacksonJaxbJsonProvider JSON_PROVIDER = new JacksonJaxbJsonProvider();

    @NotNull
    public static final List<Object> PROVIDERS = Arrays.asList(JSON_PROVIDER);

    public abstract String url();

    public void publish() {
        final String url = "http://" + host + ":" + port + this.url();
        final JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setProviders(PROVIDERS);
        factoryBean.setResourceProvider(new SingletonResourceProvider(this));
        factoryBean.setAddress(url);
        factoryBean.create();
    }

}
