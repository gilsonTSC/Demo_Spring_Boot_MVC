package com.example.curso.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.boot.dao.DepartamentoDao;
import com.example.curso.boot.domain.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{

	@Autowired
	private DepartamentoDao dao;
	
	@Override
	@Transactional
	public void salvar(Departamento departamento) {
		this.dao.save(departamento);
	}

	@Override
	@Transactional
	public void editar(Departamento departamento) {
		this.dao.update(departamento);
	}

	@Override
	@Transactional
	public void excluir(Long id) {
		this.dao.delete(id);
	}

	@Override
	public Departamento buscarPorId(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public List<Departamento> buscarTotos() {
		return this.dao.findAll();
	}

	@Override
	public boolean depertamentoTemCargos(Long id) {
		if(this.buscarPorId(id).getCargos().isEmpty()) {// SE A LISTA FOR VAZIA.
			return false;
		}
		return true;
	}

}