package woodspring.springgate.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HeapSort {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	private List<Integer> vArray = new ArrayList<Integer>();
	
	public HeapSort( ) {
		this.vArray = new ArrayList<Integer>();
	}
	public HeapSort( List<Integer> theArray) {
		this.vArray = theArray;
	}
	public HeapSort resetArray( List<Integer> theArray) {
		this.vArray = theArray;
		return this;
	}
	
	public HeapSort heapSorting() {
		int listSize = vArray.size();
		for ( int ind = ( listSize -1) /2; ind >= 0; ind--) {
			heapify( listSize, ind);
		}
		logger.info("heapified array:"+ vArray.toString());
		
		for ( int ind = listSize-1; ind >=0; ind--) {
			swap(ind, 0);
			heapify(ind, 0);
		}
		return this;
	}

	private void heapify(int upper, int level) {
		int currNode = level;
		int leftChild = 2*level+1;
		int rightChild = 2*(level+1);
		if ((leftChild < upper) && (vArray.get(leftChild) > vArray.get(currNode)) )
			currNode = leftChild;
		if ((rightChild < upper) && ( vArray.get(rightChild) > vArray.get(currNode))) 
			currNode = rightChild;
		if ( currNode != level) {
			swap( currNode, level);
			heapify( upper, currNode);
		}
	
	}
	
	private void swap(int index, int sInd) {
		int tmp = vArray.get(index);
		vArray.set( index,  vArray.get( sInd));
		vArray.set( sInd,  tmp);
	}
	public List<Integer> getList() {
		return vArray;
	}
	
}
