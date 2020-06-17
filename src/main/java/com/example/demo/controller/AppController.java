package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.*;

//controller para fazer a exibição da propriedade app.message do application.properties
@RestController
public class AppController {
	
	@Value("${app.message}")//faz a injeção de todos os valores com esta annotation com o início 'app.message'
	private String appMessage;
	
	//basta colocar direto o nome da variável
	@Value("${ENV_DB:NENHUMA}") //mapeando uma variável de ambiente do sistema e definindo um valor padrão para caso ela não seja encontrada
	private String dbEnvironmentVariable;
	
	
	@GetMapping("/") //para fazer a exibição direto do browser a partir do contexto '/'
	public String getAppMessage() {
		return appMessage;
	}

	@GetMapping("/envVariable")
	public String getEnvironmentVariable() {
		return "A seguinte variável de ambiente foi passada: " + dbEnvironmentVariable;
	}
}
