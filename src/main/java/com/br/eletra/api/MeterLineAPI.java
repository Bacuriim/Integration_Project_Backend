package com.br.eletra.api;

import com.br.eletra.DAO.MeterLineDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.br.eletra.service.MeterLineService;

import java.util.List;

@Controller
@RequestMapping(value ={"/Lines"} , produces = {"Application/json"})
public class MeterLineAPI {

		@Autowired
		private MeterLineService meterLineService;

		@PutMapping
		@ResponseBody
		public MeterLineDAO updateLine(@PathVariable("id") String id , @RequestBody MeterLineDAO meterLineDAO) {
				return  this.meterLineService.updateLine(meterLineDAO , id);
		}

		@DeleteMapping({"/{id}"})
		@ResponseBody
		public String deleteLine(@PathVariable("id") String id , @RequestBody MeterLineDAO meterLineDAO) {
				return this.meterLineService.deleteLine(meterLineDAO , id);
		}

		@GetMapping(value = "/{id}")
		@ResponseBody
		public MeterLineDAO getById(String id) {
				return this.meterLineService.getById(id);
		}

		@GetMapping
		@ResponseBody
		public List<MeterLineDAO> getAll() {
				return this.meterLineService.getAll();
		}
}
