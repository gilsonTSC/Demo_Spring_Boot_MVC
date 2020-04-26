package com.example.curso.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

	public List<Funcionario> findByNome(String nome) {

		return createQuery("select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);
	}
	
}