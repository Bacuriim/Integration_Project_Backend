package com.br.eletra.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.eletra.models.MeterModelEntity;
import com.br.eletra.repository.ModelRepo;

import java.util.List;

@RestController
@RequestMapping(value="/api" , produces = {"Application/json"})
public class MeterModelAPI {

		@Autowired
		private ModelRepo modelRepo;

		@GetMapping("/Models")
		@ResponseBody
		public List<MeterModelEntity> getModelEntityList() {
				return modelRepo.findAll();
		}

		@GetMapping("/Models/{ModelName}")
		@ResponseBody
		public MeterModelEntity getModelEntity(@PathVariable(value="ModelName") String ModelName) {
				return modelRepo.findByModelName(ModelName);
		}

		@PostMapping("/Model")
		@ResponseBody
		public MeterModelEntity postModelEntity(@RequestBody MeterModelEntity meterModelEntity) {
				return modelRepo.save(meterModelEntity);
		}

		@DeleteMapping("/Model/{ModelName}")
		@ResponseBody
		public String deleteModelEntity(@PathVariable(value = "ModelName") String ModelName) {
				MeterModelEntity meterModelEntity = modelRepo.findByModelName(ModelName);
				modelRepo.delete(meterModelEntity);
				return "Model deleted";
		}

		@PutMapping("/Model")
		@ResponseBody
		public String updateModelEntity(@RequestBody MeterModelEntity meterModelEntity) {
				modelRepo.save(meterModelEntity);
				return "Model updated";
		}


}
