package com.exp.product.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import com.exp.entity.TbGoods;
import com.framework.BaseDao;

@Repository
public class ProductDaoImpl extends BaseDao<TbGoods, String> {

	public void searchAll() {

		Session session = null;
		session = super.getSession();
		System.out.println(session == null);
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		try {
			fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SearchFactory sf = fullTextSession.getSearchFactory();
		QueryBuilder qb = sf.buildQueryBuilder().forEntity(TbGoods.class).get();
		org.apache.lucene.search.Query luceneQuery = qb.keyword().onFields("goodsName","introduce").matching("散热器")
				.createQuery();
		Query hibQuery = fullTextSession.createFullTextQuery(luceneQuery);
		List list = hibQuery.list();
		//assertNotNull(list);
		for (Object obj : list) {
			TbGoods book = (TbGoods) obj;
			System.out.println(book.getGoodsName());
		}
	}
}
