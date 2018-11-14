package com.keranjangkita.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "confexample")
public class ConfigurationExample {

    // example using regex
    //@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")

    @NotBlank
    private String someParam;
    private InnerClass innerClass;

    public InnerClass getInnerClass() {
        return innerClass;
    }

    public void setInnerClass(InnerClass innerClass) {
        this.innerClass = innerClass;
    }

    public String getSomeParam() {
        return someParam;
    }

    public void setSomeParam(String someParam) {
        this.someParam = someParam;
    }

    public static class InnerClass {

        @Length(max = 10, min = 1)
        private String innerParam;

        public String getInnerParam() {
            return innerParam;
        }

        public void setInnerParam(String innerParam) {
            this.innerParam = innerParam;
        }
    }
}
