package com.example.curso.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curso.boot.dao.CargoDao;
import com.example.curso.boot.domain.Cargo;
import com.example.curso.boot.util.PaginacaoUtil;

@Service
public class CargoServiceImpl implements CargoService{

	@Autowired
	private CargoDao dao;
	
	@Override
	@Transactional
	public void salvar(Cargo cargo) {
		this.dao.save(cargo);
	}

	@Override
	@Transactional
	public void editar(Cargo cargo) {
		this.dao.update(cargo);
	}

	@Override
	@Transactional
	public void excluir(Long id) {
		this.dao.delete(id);
	}

	@Override
	public Cargo buscarPorId(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public List<Cargo> buscarTodos() {
		return this.dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		if(this.buscarPorId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public PaginacaoUtil<Cargo> buscarPorPagina(int pagina, String direcao) {
		return this.dao.buscaPaginada(pagina, direcao);
	}

}