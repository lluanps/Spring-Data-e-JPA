package projeto.spring.data.aula;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import projeto.spring.data.aula.dao.InterfaceSpringDataUser;
import projeto.spring.data.aula.model.UsuarioSpringData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class AppSpringDataTeste {
	
	@Autowired
	private InterfaceSpringDataUser interfaceSpringDataUser;
	
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
		System.out.println("Iniciou spring com sucesso");
	}
	
	
}
