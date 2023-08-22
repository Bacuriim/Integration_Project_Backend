package com.br.eletra.DAO;

import com.br.eletra.models.MeterLineEntity;

import org.hibernate.Session;

import java.util.List;

public class MeterLineDAO {
		private final Session session;

		public MeterLineDAO(Session session) {
				this.session = session;
		}

		public List<MeterLineEntity> getAllMeterLines() {
			return session.createQuery("FROM MeterLineEntity").list();
		}

}