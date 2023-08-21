package service;

import DAO.MeterLineDAO;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeterLineService {
		private static final Map<Short , MeterLineDAO> lineService = new HashMap<>();

		public MeterLineDAO updateLine(MeterLineDAO meterLineDAO , Short id) {
				lineService.put(id , meterLineDAO);
				return meterLineDAO;
		}

		public String deleteLine(MeterLineDAO meterLineDAO , Short id) {
				lineService.remove(id);
				return "Meter Line has been removed!";
		}

		public MeterLineDAO getById(Short id) {
				return lineService.get(id);
		}

		public List<MeterLineDAO> getAll() {
				return new ArrayList<>(lineService.values());
		}

}
