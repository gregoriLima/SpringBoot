package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import lombok.*;

@Configuration //indica que é um arquivo de configuração lido na subida da aplicação

//para mapear as propriedades que tem chaves em comum com esta classe
@ConfigurationProperties ("spring.datasource") //indica tudo com o prefixo de spring.datasource é mapeado para dentro do conjunto

@Getter
@Setter//annotation do lombok que indica que as propriedades irão receber automaticamente os getters e setters em tempo de compilação
public class DBConfiguration {
	
	//mapeando as propriedades do arquivo de configuração
		private String driverClassName; //o Java faz a tradução do CamelCase para o formato com "-" da propriedade
		private String url;
		private String password;
		
		
		//é necessário ter os get and setters, pois se não o spring não lê estas propriedades
		//se não for feito, os valores das variáveis são apresentados com seus valores de inicialização padrão
		
		//para não ficar gerando getters and setters deixando o código poluido
		//foi utilizado o projeto lombok como dependência em pom.xml, que através de annotations
		//em tempo de compilação, as propriedades já são gerados os getteres e setters
		
		
		//declarando os métodos que farão os mapeamentos da propriedades
		//para dentro do sistema e que vai subir ao definir o tipo de profile que se quer
		
		@Profile("dev")
		@Bean //dizendo que este método é instanciado como um bean, 
				//para que este conteúdo seja mostrado logo na subida do sistema
		public String testDatabaseConnection() {
		
			System.out.println("DB connection for DEV");
			System.out.println(driverClassName); //nome do tipo do DB
			System.out.println(url);
			
			return "DB Connection to H2_TEST - Test isntance";
		}

		
		@Profile("prod")//indica que o arquivo utilizado é o application-prod.properties
		@Bean //dizendo que este método é instanciado como um bean, 
				//para que este conteúdo seja mostrado logo na subida do sistema
		public String prodDatabaseConnection() {
		
			System.out.println("DB connection for PRODUCTION - MYSQL");
			System.out.println(driverClassName); //nome do tipo do DB
			System.out.println(url);
			
			return "DB Connection for MYSQL_PROD - PROD instance";
		}

}
