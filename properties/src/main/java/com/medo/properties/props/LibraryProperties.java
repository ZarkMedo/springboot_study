package com.medo.properties.props;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: LibraryProperties
 * @Auther: medo
 * @Date: 2020-03-04 12:21
 * @Description: TODO
 **/

@Getter
@Setter
@ToString
@Component
// 使用properties注解必须是容器里的实例
@ConfigurationProperties(prefix = "library")
public class LibraryProperties {
    private String name;
    private List<Books> movies;
    private String msg;

    @Getter
    @Setter
    @ToString
    public static class Books {
        private String name;
        private String description;
    }

}
