package mbs.repository;


import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class RepositoryImpl extends Repository {


	@Override
	public void save(Serializable messageEntity) {
		session.save(messageEntity);
	}

	@Override
	public Serializable get(Long id,Class<? extends Serializable> class_) {
		Criteria criteria = session.createCriteria(class_);
		criteria.add(Restrictions.eq("id", id));
		return (Serializable) criteria.uniqueResult();
	}

	@Override
	public List<Serializable> getAll(Class<? extends Serializable> class_) {		
		return session.createCriteria(class_).list();
	}

}
