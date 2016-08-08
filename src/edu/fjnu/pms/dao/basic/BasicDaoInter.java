/**
 * 
 */
package edu.fjnu.pms.dao.basic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

/**
 * Hibernate数据库常用方法声明
 * @author lzx
 *
 */
public interface BasicDaoInter {
	/**
	 * 通过id查找
	 * @param clazz	类的class属性
	 * @param id	对象的id
	 * @return	如果找到就返回对象，如果没找到返回null
	 * @author lzx
	 */
	public Object findById(Class clazz, Serializable id);
	
	/**
	 * 往数据库中添加对象
	 * @param object 对象
	 * @author lzx
	 */
	public void add(Object object);
	
	/**
	 * 更新对象
	 * @param object 对象
	 * @author lzx
	 */
	public void update(Object object);
	
	/**
	 * 通过id删除数据库中的对象
	 * @param clazz	类的class属性
	 * @param id	对象的id
	 * @author lzx
	 */
	public void deleteById(Class clazz, Serializable id);
	
	/**
	 * 使用hql语句查询
	 * @param hql	hql语句
	 * @param parameters	hql语句中的参数
	 * @return	如果查询成功返回list集合，存放查询结果对象，查询失败则返回空list
	 * @author lzx
	 */
	public List executeQuery(String hql, Object[] parameters);
	
	/**
	 * 使用hql语句分页查询
	 * @param hql	hql语句
	 * @param parameters	hql语句中的参数
	 * @param pageNow	当前页码，从第一页开始
	 * @param pagesSize	设置每页的记录数
	 * @return	如果查询成功返回list集合，存放查询结果对象，查询失败则返回空list
	 * @author lzx
	 */
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageNow, int pagesSize);
	
	/**
	 * 更新(update)或删除(delete)
	 * @param hql	hql语句
	 * @param parameters	hql语句中的参数
	 * @return	受影响的行数
	 * @author lzx
	 */
	public int executeUpdate(String hql, Object[] parameters);
	
	/**
	 * 查询唯一结果
	 * @param hql	hql语句
	 * @param parameters	hql语句中的参数
	 * @return	返回查询结果的对象，只有一行一列
	 * @author lzx
	 */
	public Object uniqueQuery(String hql, Object[] parameters);
	
	/**
	 * 根据每页记录数，查询页数
	 * @param hql	hql语句,格式：select count(*) from 类名 where 条件
	 * @param parameters	hql语句中的参数
	 * @param pageSize	每页记录数
	 * @return	返回页数
	 * @author lzx
	 */
	public int queryPageCount(String hql, Object[] parameters, int pageSize);
}
