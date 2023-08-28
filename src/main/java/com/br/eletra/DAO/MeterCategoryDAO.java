package com.br.eletra.DAO;

import com.br.eletra.models.MeterCategoryEntity;
import org.hibernate.Session;

import java.util.List;

public class MeterCategoryDAO {
		private final Session session;

		public MeterCategoryDAO(Session session) {
				this.session = session;
		}

		public List<MeterCategoryEntity> getCategoriesForLine(Short id) {
				return session.createQuery("FROM MeterCategoryEntity WHERE line_id = :id").setParameter("id", id).list();
		}
}