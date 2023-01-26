package projeto.spring.data.aula;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.dao.InterfaceTelefone;
import projeto.spring.data.aula.model.Telefone;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	@Test
	public void testeInsert() {
		
		UsuarioSpringData entity = new UsuarioSpringData();
		entity.setEmail("anab@gmail.com");
		entity.setIdade(18);
		entity.setLogin("teste 243");
		entity.setSenha("000");
		entity.setNome("Ana Bittencurt");
		
		interfaceSpringDataUser.save(entity);
	}

	@Test
	public void testeConsulta() {
		
		Optional<UsuarioSpringData> entity = interfaceSpringDataUser.findById(1L);
		
		System.out.println("Nome: " + entity.get().getNome()); 
		System.out.println("Idade: " + entity.get().getIdade());
		System.out.println("Email: " + entity.get().getEmail()); 
		System.out.println("Login: " + entity.get().getLogin()); 
		System.out.println("Senha: " + entity.get().getSenha()); 
		System.out.println("Id: " + entity.get().getId()); 
		
		for (Telefone telefone : entity.get().getTelefones()) {
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
			System.out.println(telefone.getId());
			System.out.println(telefone.getUsuarioSpringData().getNome());
			System.out.println("-----------------------------");
		}
	}
	
	@Test
	public void testeConsultaTodos() {
		
		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		
		for (UsuarioSpringData entity : lista) {
			System.out.println("Nome: " + entity.getNome()); 
			System.out.println("Idade: " + entity.getIdade());
			System.out.println("Email: " + entity.getEmail()); 
			System.out.println("Login: " + entity.getLogin()); 
			System.out.println("Senha: " + entity.getSenha()); 
			System.out.println("Id: " + entity.getId()); 
			System.out.println("==============================================");
		}
	}
	
	@Test
	public void testeUpdate() {
		
		Optional<UsuarioSpringData> entity = interfaceSpringDataUser.findById(3L);
		
		UsuarioSpringData data = entity.get();
		data.setNome("Ana Julia Mesquita");
		interfaceSpringDataUser.save(data);	
	}
	
	@Test
	public void testeDelete() {
		interfaceSpringDataUser.deleteById(5L);	
	}
	
	@Test
	public void testeConsultaNome() {
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("Luan Pinheiro da Silva");
			
			for (UsuarioSpringData entity : list) {
				System.out.println("Nome: " + entity.getNome()); 
				System.out.println("Idade: " + entity.getIdade());
				System.out.println("Email: " + entity.getEmail()); 
				System.out.println("Login: " + entity.getLogin()); 
				System.out.println("Senha: " + entity.getSenha()); 
				System.out.println("Id: " + entity.getId()); 
				System.out.println("==============================================");
			}
	}
	
	@Test
	public void testeConsultaNomeParam() {
		UsuarioSpringData list = interfaceSpringDataUser.buscaPorNomeParam("Luan Pinheiro da Silva");
			
				System.out.println("Nome: " + list.getNome()); 
				System.out.println("Idade: " + list.getIdade());
				System.out.println("Email: " + list.getEmail()); 
				System.out.println("Login: " + list.getLogin()); 
				System.out.println("Senha: " + list.getSenha()); 
				System.out.println("Id: " + list.getId()); 
				System.out.println("==============================================");			
	}

	@Test
	public void testeDeletePorNome() {
		interfaceSpringDataUser.deletePorNome("Ana Bittencurt");
	}
	
	@Test
	public void testeUpdateEmailPorNome() {
		interfaceSpringDataUser.updateEmailPorNome("ana@gmail.com", "Ana Julia Mesquita");
	}
	
	/*Teste de Telefone*/
	
	@Test
	public void testeInsertTelefone() {
		
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(4L);
		
		
		Telefone telefone = new Telefone();
		telefone.setTipo("Residencial");
		telefone.setNumero("32313066");
		telefone.setUsuarioSpringData(usuarioSpringData.get());
		
		interfaceTelefone.save(telefone);
	}
	
}
