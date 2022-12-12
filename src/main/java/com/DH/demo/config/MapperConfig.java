package com.DH.demo.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper getModelMapper (){

        return new ModelMapper();
    }

    public static <S, T> List<T> mapList(ModelMapper modelMapper, List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public static <S, T> T map(ModelMapper modelMapper, S element, Class<T> targetClass) {
        return modelMapper.map(element, targetClass);
    }
}
