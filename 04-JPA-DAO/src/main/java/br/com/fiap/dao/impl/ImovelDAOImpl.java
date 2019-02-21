package br.com.fiap.dao.impl;

import javax.naming.CommunicationException;
import javax.persistence.EntityManager;

import br.com.fiap.dao.ImovelDAO;
import br.com.fiap.entity.Imovel;

public class ImovelDAOImpl implements ImovelDAO {

	private EntityManager em;

	public ImovelDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Imovel imovel) {
		em.persist(imovel);
	}

	// NUNCA DE COMMIT NI FIND
	public Imovel consultar(int codigo) {
		return em.find(Imovel.class, codigo);
	}

	public void atualizar(Imovel imovel) {
		em.merge(imovel);
	}

	public void remover(int codigo) {
		Imovel imovel = consultar(codigo);
		em.remove(codigo);
	}

	public void commit() throws CommunicationException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommunicationException();
		}

	}

}