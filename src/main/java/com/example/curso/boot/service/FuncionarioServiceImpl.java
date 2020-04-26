package com.example.curso.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.boot.dao.FuncionarioDao;
import com.example.curso.boot.domain.Funcionario;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	@Autowired
	private FuncionarioDao dao;
	
	@Override
	@Transactional
	public void salvar(Funcionario funcionario) {
		this.dao.save(funcionario);
	}

	@Override
	@Transactional
	public void editar(Funcionario funcionario) {
		this.dao.update(funcionario);
	}

	@Override
	@Transactional
	public void excluir(Long id) {
		this.dao.delete(id);
	}

	@Override
	public Funcionario buscarPorId(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public List<Funcionario> buscarTodos() {
		return this.dao.findAll();
	}

	@Override
	public List<Funcionario> buscarPorNome(String nome) {
		return this.dao.findByNome(nome);
	}

}