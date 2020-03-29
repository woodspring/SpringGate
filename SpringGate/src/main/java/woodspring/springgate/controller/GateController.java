package woodspring.springgate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import woodspring.springgate.service.GateService;

@RestController
public class GateController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	GateService gateService;
	
	@GetMapping("/binTree/{numberList}")
	public String binaryTreeService(@PathVariable(value = "numberList") String numberList) {
		logger.info("GateController, binaryTreeService-----"+ numberList );
		String retStr = gateService.forBinaryTreeService( numberList);
		return retStr;
	}

}
