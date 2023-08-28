package com.br.eletra.resources;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.LineRepo;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value ="API REST Meters")
@CrossOrigin(origins="*")
public class MeterLineAPI {

		@Autowired
		private LineRepo lineRepo;

		@GetMapping("/lines")
		@ResponseBody
		@ApiOperation(value="Return a list of meter lines")
		public List<MeterLineEntity> getLineEntityList() {
				return lineRepo.findAll();
		}

		@GetMapping("/lines/{line-name}")
		@ResponseBody
		@ApiOperation(value="Return a meter line")
		public MeterLineEntity getLineEntity(@PathVariable(value="line-name") String lineName) {
				return lineRepo.findByLineName(lineName);
		}

		@PostMapping("/line")
		@ResponseBody
		@ApiOperation(value="Return a new meter line")
		public MeterLineEntity postLineEntity(@RequestBody MeterLineEntity meterLineEntity) {
				return lineRepo.save(meterLineEntity);
		}

		@DeleteMapping("/line/{line-name}")
		@ResponseBody
		@ApiOperation(value="Delete a meter line")
		public String deleteLineEntity(@PathVariable(value = "line-name") String lineName) {
				MeterLineEntity meterLineEntity = lineRepo.findByLineName(lineName);
				lineRepo.delete(meterLineEntity);
				return "Line deleted";
		}

		@PutMapping("/line")
		@ResponseBody
		@ApiOperation(value="Update a meter line")
		public String updateLineEntity(@RequestBody MeterLineEntity meterLineEntity) {
				lineRepo.save(meterLineEntity);
				return "Line updated";
		}


}
