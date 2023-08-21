package DAO;

import model.MeterCategoryEntity;
import model.MeterLineEntity;

import org.hibernate.Session;

import java.util.List;

public class MeterCategoryDAO {
		private final Session session;

		public MeterCategoryDAO(Session session) {
				this.session = session;
		}

		public List<MeterCategoryEntity> getCategoriesForLine(MeterLineEntity line) {
				return session.createQuery("FROM MeterCategoryEntity WHERE line_id = :line").setParameter("line", line).list();
		}
}