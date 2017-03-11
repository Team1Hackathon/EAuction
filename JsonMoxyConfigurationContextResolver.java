package com.auction.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;

@Provider
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Singleton
public class JsonMoxyConfigurationContextResolver implements ContextResolver<MoxyJsonConfig> {

  private final MoxyJsonConfig config;

  public JsonMoxyConfigurationContextResolver() {
      final Map<String, String> namespacePrefixMapper = new HashMap<>();
      namespacePrefixMapper.put("http://honbglrhackathon10march2017.mybluemix.net/items", "xsi");
      
      config = new MoxyJsonConfig()
          .setNamespacePrefixMapper(namespacePrefixMapper)
          .setNamespaceSeparator(':')
//          .setAttributePrefix("")
//          .setValueWrapper("value")
//          .property(JAXBContextProperties.JSON_WRAPPER_AS_ARRAY_NAME, true)
          .setFormattedOutput(false)
          .setIncludeRoot(false)
          .setMarshalEmptyCollections(false);
      config.getAttributePrefix();
  }

  @Override
  public MoxyJsonConfig getContext(Class<?> objectType) {
      return config;
  }
}

