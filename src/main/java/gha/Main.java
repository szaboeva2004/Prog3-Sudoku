package main.java.gha;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import main.java.gha.views.MainFrame;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
        //MainFrame frame = new MainFrame();
    }
}
