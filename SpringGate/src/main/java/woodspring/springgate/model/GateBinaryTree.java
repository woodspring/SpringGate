package woodspring.springgate.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import woodspring.springgate.entity.TreeNode;


@Component
public class GateBinaryTree {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	public TreeNode<Integer> flatTree = null;
	public TreeNode<Integer> sortedTree = null;
	
	public GateBinaryTree() {
		
	}
	
	public String buildFlatTree(List<Integer> intNumber) {
		if (intNumber == null || intNumber.isEmpty()) return "NULL";
		flatTree = null;
		for (Integer item : intNumber) {
			TreeNode<Integer> theNode = new TreeNode<Integer>(item);
			if (flatTree == null) {
				flatTree = theNode;
			} else {
				flatTree.insertSeq( flatTree, theNode);
			}
		}
		String flatTreeStr = flatTree.toString();
		logger.info( "FlatTree:["+ flatTreeStr.toString() +"]");
		return flatTreeStr;	
	}
	public String buildSortingTree(List<Integer> intNumber) {
		if (intNumber == null || intNumber.isEmpty()) return "NULL";
		sortedTree = null;
		for (Integer item: intNumber) {
			TreeNode<Integer> theNode = new TreeNode<Integer>(item);
			if ( sortedTree == null) {
				sortedTree = theNode;
			} else {
				sortedTree.insertSorting(sortedTree, sortedTree, theNode);
			}
		}
		String sortedTreeStr = sortedTree.toString();
		logger.info( "SortedTree:["+ sortedTreeStr.toString() +"]");
		return sortedTreeStr;	
	}

}
