package service;

import DAO.MeterModelDAO;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeterModelService {
		private static final Map<Short , MeterModelDAO> ModelService = new HashMap<>();

		public MeterModelDAO updateModel(MeterModelDAO meterModelDAO , Short id) {
				ModelService.put(id , meterModelDAO);
				return meterModelDAO;
		}

		public String deleteModel(MeterModelDAO meterModelDAO , Short id) {
				ModelService.remove(id);
				return "Meter Model has been removed!";
		}

		public MeterModelDAO getById(Short id) {
				return ModelService.get(id);
		}

		public List<MeterModelDAO> getAll() {
				return new ArrayList<>(ModelService.values());
		}

}