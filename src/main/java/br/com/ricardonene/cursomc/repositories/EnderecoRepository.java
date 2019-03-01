package br.com.ricardonene.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ricardonene.cursomc.domain.Endereco;
import br.com.ricardonene.cursomc.domain.Produto;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
