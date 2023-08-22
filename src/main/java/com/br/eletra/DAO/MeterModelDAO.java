package com.br.eletra.DAO;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.models.MeterModelEntity;

import org.hibernate.Session;

import java.util.List;

public class MeterModelDAO {
		private final Session session;

		public MeterModelDAO(Session session) {
				this.session = session;
		}

		public List<MeterModelEntity> getModelsForCategory(MeterCategoryEntity id) {
				return session.createQuery("FROM MeterModelEntity WHERE category_id = :id").setParameter("id", id).list();
		}
}
