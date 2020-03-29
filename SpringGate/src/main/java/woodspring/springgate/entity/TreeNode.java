package woodspring.springgate.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeNode<T extends Comparable<T>> {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	T value;
	private TreeNode<T> left = null, right = null;
	
	public TreeNode() {
		this.value = null;
		this.left = null; 
		this.right = null;
	}
	public TreeNode(T theValue) {
		this.value = theValue;
		this.left = null; 
		this.right = null;

	}
	
	public boolean insertSeq( TreeNode<T> currNode, TreeNode<T> theNode) {
		if  (theNode == null) return true;
		logger.info("in currNode:"+ currNode.value+" theNode:"+ theNode.value()+"-----------------------");
		if (currNode.left() ==null) {
			logger.info("in 1 currNode:"+ currNode.value+" theNode:"+ theNode.value()+"-----------------------");
			currNode.setLeft(theNode);
		} else if (currNode.right() == null) {
logger.info("in 2 currNode:"+ currNode.value+" theNode:"+ theNode.value()+"-----------------------");			
			currNode.setRight(theNode);
		} else if (currNode.left() != null && currNode.right() != null) {
			int leftNum = currNode.countNode( currNode.left(), 0);
			int rightNum = currNode.countNode( currNode.right(), 0);
			logger.info("theNode:"+theNode+" value:" + currNode.value()+" leftNum:" + leftNum+" rightNum:"+ rightNum);
			if ( (leftNum == rightNum)) { //|| (((leftNum - rightNum) %2) != 0) ) {
				logger.info("Here theNode:"+theNode+" value:" + currNode.value()+" leftNum:" + leftNum+" rightNum:"+ rightNum);
			 currNode.insertSeq( currNode.left(), theNode);
			} else {
				
				int base = 2;
				boolean isLeft = true;
				for (int ind=2; ind < 10; ind++) {
					base = base*2;
					if ( leftNum == ( base-1)) {
						isLeft = false;
						break;
					}
				}
				if ( isLeft) {
					logger.info("COMPLEX-1- base:"+base+" theNode:"+theNode+" value:" + currNode.value()+" leftNum:" + leftNum+" rightNum:"+ rightNum);
					currNode.insertSeq(currNode.left(), theNode);
				}	else {
					logger.info("COMPLEX-2- base:"+base+ " theNode:"+theNode+" value:" + currNode.value()+" leftNum:" + leftNum+" rightNum:"+ rightNum);
					currNode.insertSeq(currNode.right(), theNode);
				}
//				
//				int diff = leftNum - rightNum;
//				logger.info("COMPLEX diff:"+ diff+" theNode:"+theNode+" value:" + currNode.value()+" leftNum:" + leftNum+" rightNum:"+ rightNum);
//				double comp = ( Math.log10(diff) / Math.log10(2));
//				if ( (comp %1) == 0) {
//					logger.info("COMPLEX-1- comp:"+comp+" diff:"+ diff+" theNode:"+theNode+" value:" + currNode.value()+" leftNum:" + leftNum+" rightNum:"+ rightNum);
//					currNode.insertSeq(currNode.right(), theNode);
//				}
//				else {
//					logger.info("COMPLEX-2- comp:"+comp+ " diff:"+ diff+" theNode:"+theNode+" value:" + currNode.value()+" leftNum:" + leftNum+" rightNum:"+ rightNum);
//					currNode.insertSeq(currNode.left(), theNode);
//				}
			}
		} else {
			logger.info("WHAT is the value: theNode:"+ theNode.value()+" currNode:"+currNode.value());
		}
//		if ( currNode == null) {
//			currNode = theNode;
//			return true;
//		} else if ( insertSeq( currNode.left(), theNode))) {
//			return true;
//		} if ( insertSeq( currNode.right(), theNode)) )


			
			
			
//			
//			if (currNode.left() == null) 
//			currNode.setLeft( theNode);
//		else if (currNode.right() == null)
//			currNode.setRight(theNode);
//		else if (currNode.left() != null) { 
//			 currNode.insertSeq( currNode.left(), theNode);
//		  //	return;
//		 } else if ( currNode.right() != null) {
//			 currNode.insertSeq( currNode.right(), theNode);
//		 }
//		
//		
		
		//else
//		 if ( currNode.left() == null) 
//			 currNode.setLeft( theNode);
//		 else 
			 //currNode.setRight( theNode);
//		 else { 
//			 currNode.setLeft(theNode);
//			 return;
//		 }
//		 if ( currNode.right() != null)  
//			 currNode.insertSeq( currNode.right(), theNode);
//		 else {
//			 currNode.setRight( theNode);
//		 }
		 return false;
	}
	
	public int countNode(TreeNode<T> currNode, int count) {
		int retInt =0;
		if (currNode == null) {
			logger.info("countNode-00, currNode:null, count:"+count);
			return 0;
		}
		logger.info("countNode-0, currNode:"+ currNode.value() + "count:"+count);
		//if ( currNode.left() != null) {
			retInt = 1 +  currNode.countNode(currNode.left(), ++count);
		logger.info("countNode-1, currNode:"+ currNode.value()+" retInt:"+retInt+" count:"+count);
		//}
		retInt += currNode.countNode( currNode.right(), ++count);
		logger.info("countNode-2, currNode:"+ currNode.value()+" retInt:"+retInt+" count:"+count);
		return retInt;
	}
	public void insertSorting(TreeNode<T> parent, TreeNode<T> currNode, TreeNode<T> theNode) {
		if (theNode == null) return;
		if (currNode == null) {
			logger.info("insertSorting-00, parent:"+parent.value()+"currNode:null, theNode:"+ theNode.value());
			if (parent.value().compareTo( theNode.value()) > 0)
				parent.setLeft(theNode);
			else 
				parent.setRight( theNode);
			return;
		}
		int compared = currNode.value().compareTo( theNode.value());
		if ( compared > 0) {
			logger.info("insertSorting-1, compare:"+ compared+" currNode:"+ currNode.value()+" theNode:"+ theNode.value());
			currNode.insertSorting( currNode, currNode.left(),theNode);
		} else if ( compared < 0 ) {
			logger.info("insertSorting-2, compare:"+ compared+" currNode:"+ currNode.value()+" theNode:"+ theNode.value());
			
			currNode.insertSorting( currNode, currNode.right(), theNode);
		}
		return ;
	}
	
	public TreeNode<T> left() {
		return this.left;
	}
	public void setLeft(TreeNode<T> theNode) {
		this.left = theNode;
	}
	public TreeNode<T> right() {
		return this.right;
	}
	public void setRight(TreeNode<T> theNode) {
		this.right = theNode;
	}
	
	public T value() {
		return this.value;
	}
	
	
	
	
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append(( left() == null) ? "" : left().toString());
		strBuff.append(" "+ ((Integer)this.value).toString());
		strBuff.append(( this.right == null) ? "" : this.right.toString());
		return strBuff.toString();		
	}
	
	
}
