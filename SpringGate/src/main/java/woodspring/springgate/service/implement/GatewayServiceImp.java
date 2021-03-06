package woodspring.springgate.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import woodspring.springgate.model.GateBinaryTree;
import woodspring.springgate.model.HeapSort;
import woodspring.springgate.service.GateService;

@Service
public class GatewayServiceImp implements GateService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	GateBinaryTree binTree;
	
	@Autowired 
	HeapSort heapSort;

	@Override
	public String forBinaryTreeService(String theInts) {
		String[] intList = theInts.split("-");
		StringBuffer strBuff = new StringBuffer();
		List<Integer> integerList = new ArrayList<Integer>();
		for (String item: intList) {
			integerList.add( Integer.valueOf( item));
		}
		logger.info(" integerList:"+ integerList);
		strBuff.append("Complete binary tree: "+ binTree.buildFlatTree( integerList));
		strBuff.append("\n");
		strBuff.append("Sorted binary tree"+ binTree.buildSortingTree( integerList));
		logger.info(strBuff.toString());
		strBuff.append("\n");
		strBuff.append("Sorted binary tree"+ binTree.buildSortingTree( integerList));
		heapSort.resetArray( integerList);
		strBuff.append("\n");
		strBuff.append("HeapSort:"+ heapSort.resetArray( integerList).heapSorting().getList());
		logger.info( strBuff.toString());
		return strBuff.toString();
	}

}
