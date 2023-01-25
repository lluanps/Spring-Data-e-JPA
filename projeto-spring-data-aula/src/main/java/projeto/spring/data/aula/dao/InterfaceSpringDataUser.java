package projeto.spring.data.aula.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projeto.spring.data.aula.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends JpaRepository<UsuarioSpringData, Long> {
	
	@Query(value = "SELECT p FROM UsuarioSpringData p WHERE p.nome LIKE %?1%")
	public List<UsuarioSpringData> buscaPorNome (String nome);
	
	@Query(value = "SELECT p FROM UsuarioSpringData p WHERE p.nome = :paramNome")
	public UsuarioSpringData buscaPorNomeParam (
			@Param("paramNome") String paraNome
			);

}
