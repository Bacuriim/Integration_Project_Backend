package com.br.eletra.controller;

import com.br.eletra.services.MeterCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.eletra.models.MeterCategoryEntity;
import com.br.eletra.repository.CategoryRepo;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value ="API REST Meters")
@CrossOrigin(origins="*")
public class MeterCategoryController {

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private MeterCategoryService meterCategoryService;

	@GetMapping("/categories")
	@ResponseBody
	@ApiOperation(value="Return a list of meter categories")
	public List<MeterCategoryEntity> getCategoryEntityList() {
		return categoryRepo.findAll();
	}

	@GetMapping("/categories/{line-name}")
	@ResponseBody
	@ApiOperation(value="Return a meter category")
	public List<MeterCategoryEntity> getCategoriesByLine(@PathVariable(value="line-name") String lineName) {
		List<MeterCategoryEntity> list = meterCategoryService.getCategoriesByLineName(lineName);
		return list;
	}

	@PostMapping("/category")
	@ResponseBody
	@ApiOperation(value="Return a new meter category")
	public MeterCategoryEntity postCategoryEntity(@RequestBody MeterCategoryEntity meterCategoryEntity) {
		return categoryRepo.save(meterCategoryEntity);
	}

	@DeleteMapping("/category/{category-name}")
	@ResponseBody
	@ApiOperation(value="Delete a meter category")
	public String deleteCategoryEntity(@PathVariable(value = "category-name") String categoryName) {
		MeterCategoryEntity meterCategoryEntity = categoryRepo.findByCategoryName(categoryName);
		categoryRepo.delete(meterCategoryEntity);
		return "Category deleted";
	}

	@PutMapping("/category")
	@ResponseBody
	@ApiOperation(value="Update a meter category")
	public String updateCategoryEntity(@RequestBody MeterCategoryEntity meterCategoryEntity) {
		categoryRepo.save(meterCategoryEntity);
		return "Category updated";
	}
}
