package mbs.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mbs.entity.MessageEntity;

public class RepositoryProxy extends Repository {

	private RepositoryImpl repositoryImpl;
	
	public RepositoryProxy() {
		this.repositoryImpl = new RepositoryImpl();
	}

	@Override
	public void save(Serializable object) {
		Transaction transaction = null;
		try {
			Session session = mbs.repository.HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			repositoryImpl.session = session;		
			repositoryImpl.save(object);
	 	   transaction.commit();
		}catch(Throwable t) {
			if(transaction != null ) {
				transaction.rollback();
				throw new RuntimeException("Error ao salvar "+ object.getClass().getSimpleName());
			}
		}finally {
			if(session != null) {
				session.close();
			}
		}
           
	}

	@Override
	public Serializable get(Long id,Class<? extends Serializable> class_) {		
		Serializable ret = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = mbs.repository.HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			repositoryImpl.session = session;		
			ret = repositoryImpl.get(id,class_);
	 	   transaction.commit();
		}catch(Throwable t) {
			if(transaction != null ) {
				transaction.rollback();
				throw new RuntimeException("Error ao buscar "+ class_.getSimpleName());
			}
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		return ret;
	}

	@Override
	public List<Serializable> getAll(Class<? extends Serializable> class_) {
	
		List<Serializable> ret = null;
		Transaction transaction = null;
		Session session = null;
		try {
			session = mbs.repository.HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			repositoryImpl.session = session;		
			ret = repositoryImpl.getAll(class_);
	 	   transaction.commit();
		}catch(Throwable t) {
			if(transaction != null ) {
				transaction.rollback();
				throw new RuntimeException("Error ao buscar "+ class_.getSimpleName());
			}
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		return ret;

	}

}
