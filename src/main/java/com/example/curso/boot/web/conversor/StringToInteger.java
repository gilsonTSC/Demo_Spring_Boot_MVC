package com.example.curso.boot.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToInteger implements Converter<String, Integer>{

	@Override
	public Integer convert(String text) {
		text = text.trim(); // REMOVENDO OS ESPAÇOS EM BRANCO DO STRING.
		if(text.matches("[0-9]+")) { // APENAS DIGITO, NÃO IMPORTA A REPETIÇÃO DELES POR CAUSA DO + NO FINAL.
			return Integer.valueOf(text);
		}
		return null;
	}

}