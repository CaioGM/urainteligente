package com.porto.ninjas.ws;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TesteJson {

	public static void main(String[] args) {
		JSONArray clienteLista;
		//Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		//Variaveis que irao armazenar os dados do arquivo JSON
		JSONObject cliente;

		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			clienteLista = (JSONArray) parser.parse(new FileReader(
					"clientes.json"));
			
			//Salva nas variaveis os dados retirados do arquivo
			cliente =  (JSONObject) clienteLista.get(0);
			String nome = (String) cliente.get("nome");
//			estado = (String) jsonObject.get("estado");
//			pais = (String) jsonObject.get("pais");

			System.out.printf(
					"Nome: ",
					nome.toCharArray());
		} 
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
