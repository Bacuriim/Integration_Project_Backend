package api;

import connection.DTO.MeterModelDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import service.MeterModelService;

import java.util.List;

@Controller
@RequestMapping(value ={"/Models"} , produces = {"Application/json"})
public class MeterModelAPI {

		@Autowired
		private MeterModelService meterModelService;

		@PutMapping
		@ResponseBody
		public MeterModelDAO updateModel(@PathVariable("id") Short id , @RequestBody MeterModelDAO meterModelDAO) {
				return  this.meterModelService.updateModel(meterModelDAO , id);
		}

		@DeleteMapping({"/{model_id}"})
		@ResponseBody
		public String deleteModel(@PathVariable("category_id") Short id , @RequestBody MeterModelDAO meterModelDAO) {
				return this.meterModelService.deleteModel(meterModelDAO , id);
		}

		@GetMapping(value = "/{id}")
		@ResponseBody
		public MeterModelDAO getById(Short id) {
				return this.meterModelService.getById(id);
		}

		@GetMapping
		@ResponseBody
		public List<MeterModelDAO> getAll() {
				return this.meterModelService.getAll();
		}
}