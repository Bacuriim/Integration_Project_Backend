package api;

import connection.DTO.MeterCategoryDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import service.MeterCategoryService;

import java.util.List;

@Controller
@RequestMapping(value ={"/Categories"} , produces = {"Application/json"})
public class MeterCategoryAPI {

		@Autowired
		private MeterCategoryService meterCategoryService;

		@PutMapping
		@ResponseBody
		public MeterCategoryDAO updateCategory(@PathVariable("line_id") Short id , @RequestBody MeterCategoryDAO meterCategoryDAO) {
				return  this.meterCategoryService.updateCategory(meterCategoryDAO , id);
		}

		@DeleteMapping({"/{category_id}"})
		@ResponseBody
		public String deleteCategory(@PathVariable("line_id") Short id , @RequestBody MeterCategoryDAO meterCategoryDAO) {
				return this.meterCategoryService.deleteCategory(meterCategoryDAO , id);
		}

		@GetMapping(value = "/{id}")
		@ResponseBody
		public MeterCategoryDAO getById(Short id) {
				return this.meterCategoryService.getById(id);
		}

		@GetMapping
		@ResponseBody
		public List<MeterCategoryDAO> getAll() {
				return this.meterCategoryService.getAll();
		}
}
