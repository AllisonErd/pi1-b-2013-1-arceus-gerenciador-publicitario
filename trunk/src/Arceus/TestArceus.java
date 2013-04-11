package Arceus;

import Arceus.src.br.com.arceus.controll.BancoTest;
import Arceus.src.br.com.arceus.modelo.atributo.Endereco;
import Arceus.src.br.com.arceus.modelo.atributo.SexoType;
import Arceus.src.br.com.arceus.modelo.entidade.ClienteFisico;
import Arceus.src.br.com.arceus.modelo.*;

public class TestArceus {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	BancoTest bt = new BancoTest();
	ClienteFisico cf = new ClienteFisico(0, null, null, null, null, null, null, SexoType.M);
	Endereco ed = new Endereco();
	
	ed.setRua("asd");
	ed.setBairro("asd");
	ed.setCidade("Belo Jardim");
	ed.setCep("3214567");
	
	cf.setEndereco(ed);
	
	
	bt.setPessoa(cf);
	
	
	
	
	
	
	
	System.out.println(bt.getPessoa());
	}

}
