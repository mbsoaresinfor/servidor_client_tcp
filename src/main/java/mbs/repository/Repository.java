package mbs.repository;

import java.io.Serializable;
import java.util.List;


public abstract class  Repository {

	protected org.hibernate.Session session;

	
	public abstract void save(Serializable obj);
	
	public abstract Serializable get(Long id,Class<? extends Serializable> class_);
	
	public abstract List<Serializable> getAll(Class<? extends Serializable> class_);
	
}
