package DAO;

import model.MeterCategoryEntity;
import model.MeterModelEntity;

import org.hibernate.Session;

import java.util.List;

public class MeterModelDAO {
		private final Session session;

		public MeterModelDAO(Session session) {
				this.session = session;
		}

		public List<MeterModelEntity> getModelsForCategory(MeterCategoryEntity category) {
				return session.createQuery("FROM MeterModelEntity WHERE category_id = :category").setParameter("category", category).list();
		}
}
