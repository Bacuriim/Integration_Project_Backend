package service;

import connection.DTO.MeterCategoryDAO;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeterCategoryService {
		private static final Map<Short , MeterCategoryDAO> CategoryService = new HashMap<>();

		public MeterCategoryDAO updateCategory(MeterCategoryDAO meterCategoryDAO , Short id) {
				CategoryService.put(id , meterCategoryDAO);
				return meterCategoryDAO;
		}

		public String deleteCategory(MeterCategoryDAO meterCategoryDAO , Short id) {
				CategoryService.remove(id);
				return "Meter Category has been removed!";
		}

		public MeterCategoryDAO getById(Short id) {
				return CategoryService.get(id);
		}

		public List<MeterCategoryDAO> getAll() {
				return new ArrayList<>(CategoryService.values());
		}

}