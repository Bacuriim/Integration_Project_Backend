package com.br.eletra.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.eletra.models.MeterLineEntity;
import com.br.eletra.repository.LineRepo;

import java.util.List;

@RestController
@RequestMapping(value="/api" , produces = {"Application/json"})
public class MeterLineAPI {

		@Autowired
		private LineRepo lineRepo;

		@GetMapping("/Lines")
		@ResponseBody
		public List<MeterLineEntity> getLineEntityList() {
				return lineRepo.findAll();
		}

		@GetMapping("/Lines/{lineName}")
		@ResponseBody
		public MeterLineEntity getLineEntity(@PathVariable(value="lineName") String lineName) {
				return lineRepo.findByLineName(lineName);
		}

		@PostMapping("/Line")
		@ResponseBody
		public MeterLineEntity postLineEntity(@RequestBody MeterLineEntity meterLineEntity) {
				return lineRepo.save(meterLineEntity);
		}

		@DeleteMapping("/Line/{lineName}")
		@ResponseBody
		public String deleteLineEntity(@PathVariable(value = "lineName") String lineName) {
				MeterLineEntity meterLineEntity = lineRepo.findByLineName(lineName);
				lineRepo.delete(meterLineEntity);
				return "Line deleted";
		}

		@PutMapping("/Line")
		@ResponseBody
		public String updateLineEntity(@RequestBody MeterLineEntity meterLineEntity) {
				lineRepo.save(meterLineEntity);
				return "Line updated";
		}


}
