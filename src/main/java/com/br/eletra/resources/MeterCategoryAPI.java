package com.br.eletra.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.repository.CategoryRepo;

import java.util.List;

@RestController
@RequestMapping(value="/api" , produces = {"Application/json"})
public class MeterCategoryAPI {

		@Autowired
		private CategoryRepo categoryRepo;

		@GetMapping("/Categories")
		@ResponseBody
		public List<MeterCategoryEntity> getCategoryEntityList() {
				return categoryRepo.findAll();
		}

		@GetMapping("/Categories/{CategoryName}")
		@ResponseBody
		public MeterCategoryEntity getCategoryEntity(@PathVariable(value="CategoryName") String CategoryName) {
				return categoryRepo.findByCategoryName(CategoryName);
		}

		@PostMapping("/Category")
		@ResponseBody
		public MeterCategoryEntity postCategoryEntity(@RequestBody MeterCategoryEntity meterCategoryEntity) {
				return categoryRepo.save(meterCategoryEntity);
		}

		@DeleteMapping("/Category/{CategoryName}")
		@ResponseBody
		public String deleteCategoryEntity(@PathVariable(value = "CategoryName") String CategoryName) {
				MeterCategoryEntity meterCategoryEntity = categoryRepo.findByCategoryName(CategoryName);
				categoryRepo.delete(meterCategoryEntity);
				return "Category deleted";
		}

		@PutMapping("/Category")
		@ResponseBody
		public String updateCategoryEntity(@RequestBody MeterCategoryEntity meterCategoryEntity) {
				categoryRepo.save(meterCategoryEntity);
				return "Category updated";
		}


}
