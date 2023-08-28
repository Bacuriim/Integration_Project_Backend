package com.br.eletra.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.eletra.models.MeterModelEntity;
import com.br.eletra.repository.ModelRepo;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value ="API REST Meters")
@CrossOrigin(origins="*")
public class MeterModelAPI {

		@Autowired
		private ModelRepo modelRepo;

		@GetMapping("/models")
		@ResponseBody
		@ApiOperation(value="Return a list of meter models")
		public List<MeterModelEntity> getModelEntityList() {
				return modelRepo.findAll();
		}

		@GetMapping("/models/{model-name}")
		@ResponseBody
		@ApiOperation(value="Return a meter model")
		public MeterModelEntity getModelEntity(@PathVariable(value="model-name") String ModelName) {
				return modelRepo.findByModelName(ModelName);
		}

		@PostMapping("/model")
		@ResponseBody
		@ApiOperation(value="Return a new meter model")
		public MeterModelEntity postModelEntity(@RequestBody MeterModelEntity meterModelEntity) {
				return modelRepo.save(meterModelEntity);
		}

		@DeleteMapping("/model/{model-name}")
		@ResponseBody
		@ApiOperation(value="Delete a meter model")
		public String deleteModelEntity(@PathVariable(value = "model-name") String ModelName) {
				MeterModelEntity meterModelEntity = modelRepo.findByModelName(ModelName);
				modelRepo.delete(meterModelEntity);
				return "Model deleted";
		}

		@PutMapping("/model")
		@ResponseBody
		@ApiOperation(value="Update a meter model")
		public String updateModelEntity(@RequestBody MeterModelEntity meterModelEntity) {
				modelRepo.save(meterModelEntity);
				return "Model updated";
		}


}
