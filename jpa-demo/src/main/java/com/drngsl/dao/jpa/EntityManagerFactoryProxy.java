package com.drngsl.dao.jpa;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerFactoryProxy {

	private static ThreadLocal<EntityManager> emThreadLocal = new ThreadLocal<EntityManager>();
	private static EntityManagerFactory emf;

	public void setEmf(EntityManagerFactory emf) {
		EntityManagerFactoryProxy.emf = emf;
	}

	public static EntityManagerFactory getEmf() {
		return emf;
	}

	public EntityManager getEntityManager() {
		return emThreadLocal.get();
	}

	public void setEntityManager(EntityManager em) {
		emThreadLocal.set(em);
	}

	/**
	 * 创建查询条件
	 *
	 * @param name
	 *            字段名称
	 * @param values
	 *            字段值
	 */
	public String createInCondition(String name, Collection<String> values) {
		if (values == null || values.size() == 0) {
			return "1<>1";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(name + " in(");
		for (String id : values) {
			sb.append("'" + id + "',");
		}
		String hsqlCondition = sb.substring(0, sb.length() - 1) + ")";
		return hsqlCondition;
	}
}
