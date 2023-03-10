package projeto.spring.data.aula.dao;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projeto.spring.data.aula.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends JpaRepository<UsuarioSpringData, Long> {
	
	@Query(value = "SELECT p FROM UsuarioSpringData p WHERE p.nome LIKE %?1%")
	public List<UsuarioSpringData> buscaPorNome (String nome);
	
	@Lock(LockModeType.READ)
	@Query(value = "SELECT p FROM UsuarioSpringData p WHERE p.nome = :paramNome")
	public UsuarioSpringData buscaPorNomeParam (
			@Param("paramNome") String paraNome
			);
	
	default <S extends UsuarioSpringData> S saveAtual(S entity) {
		/*processa qualquer coisa*/
		return save(entity);
	}

	@Modifying
	@Transactional
	@Query("DELETE FROM UsuarioSpringData u WHERE u.nome = ?1")
	public void deletePorNome(String nome);
	
	@Modifying
	@Transactional
	@Query("UPDATE UsuarioSpringData u SET u.email = ?1 WHERE u.nome = ?2") 
	public void updateEmailPorNome(String email, String nome);
}
