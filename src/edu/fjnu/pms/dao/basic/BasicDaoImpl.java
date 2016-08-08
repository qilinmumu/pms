/**
 * 
 */
package edu.fjnu.pms.dao.basic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.fjnu.pms.exception.DataAccessException;

/**
 * @author lzx
 *
 */
public class BasicDaoImpl implements BasicDaoInter {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * 通过id查找
	 * @param clazz	类的class属性
	 * @param id	数据库中的主键id
	 * @return	如果找到就返回对象，如果没找到返回null
	 * @author lzx
	 */
	public Object findById(Class clazz, Serializable id) {
		try {
			return this.getSession().get(clazz, id);
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * 往数据库中添加对象
	 * @param object 对象
	 * @author lzx
	 */
	public void add(Object object) {
		try {
			this.getSession().save(object);
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * 更新对象
	 * @param object 对象
	 * @author lzx
	 */
	public void update(Object object) {
		try {
			this.getSession().update(object);
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * 通过id删除数据库中的对象
	 * @param clazz	类的class属性
	 * @param id	对象的id
	 * @author lzx
	 */
	public void deleteById(Class clazz, Serializable id) {
		try {
			Session session = this.getSession();
			Object object = session.get(clazz, id);
			session.delete(object);
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * 使用hql语句查询
	 * @param hql	hql语句
	 * @param parameters	hql语句中的参数
	 * @return	如果查询成功返回list集合，存放查询结果对象，查询失败则返回空list
	 * @author lzx
	 */
	public List executeQuery(String hql, Object[] parameters) {
		try {
			//创建Query对象
			Query query = this.getSession().createQuery(hql);
			//判断是否有带参数,如果有参数需要设置参数
			if (parameters != null && parameters.length > 0) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
			}
			return query.list();
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * 使用hql语句分页查询
	 * @param hql	hql语句
	 * @param parameters	hql语句中的参数
	 * @param pageNow	当前页码，从第一页开始
	 * @param PagesSize	设置每页的记录数
	 * @return	如果查询成功返回list集合，存放查询结果对象，查询失败则返回空list
	 * @author lzx
	 */
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageNow, int pagesSize) {
		try {
			//创建Query对象
			Query query = this.getSession().createQuery(hql);
			//判断是否有带参数,如果有参数需要设置参数
			if (parameters != null && parameters.length > 0) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
			}
			//设置分页的参数
			return query.setFirstResult((pageNow - 1) * pagesSize)
						.setMaxResults(pagesSize)
						.list();
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * 更新(update)或删除(delete)
	 * @param hql	hql语句
	 * @param parameters	hql语句中的参数
	 * @return	受影响的行数
	 * @author lzx
	 */
	public int executeUpdate(String hql, Object[] parameters) {
		try {
			//创建Query对象
			Query query = this.getSession().createQuery(hql);
			//判断是否有带参数,如果有参数需要设置参数
			if (parameters != null && parameters.length > 0) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
			}
			return query.executeUpdate();
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * 查询唯一结果
	 * @param hql	hql语句
	 * @param parameters	hql语句中的参数
	 * @return	返回查询结果的对象，只有一行一列
	 * @author lzx
	 */
	public Object uniqueQuery(String hql, Object[] parameters) {
		try {
			//创建Query对象
			Query query = this.getSession().createQuery(hql);
			//判断是否有带参数,如果有参数需要设置参数
			if (parameters != null && parameters.length > 0) {
				for (int i = 0; i < parameters.length; i++) {
					query.setParameter(i, parameters[i]);
				}
			}
			return query.uniqueResult();
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	/**
	 * 根据每页记录数，查询页数
	 * @param hql	hql语句,格式：select count(*) from 类名 where 条件
	 * @param parameters	hql语句中的参数
	 * @param pageSize	每页记录数
	 * @return	返回页数
	 * @author lzx
	 */
	public int queryPageCount(String hql, Object[] parameters, int pageSize) {
		try {
			Object object = this.uniqueQuery(hql, parameters);
			int pageCount = Integer.parseInt(object.toString());
			return (pageCount - 1) / pageSize + 1;
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage());
		}
	}
	
}
