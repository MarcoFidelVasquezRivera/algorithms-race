package model;

import java.util.ArrayList;

public class Coliseum {
////////////////////////////////////////////////////////////////////////////////////
//					ATTRIBUTES
////////////////////////////////////////////////////////////////////////////////////
	private ArrayList<Long> numbers;
	private Number first = null;
	private NumberBST parent = null;
	private Clock clock;
	private ArrayList<Circle> circles;
////////////////////////////////////////////////////////////////////////////////////
//					 METHODS
////////////////////////////////////////////////////////////////////////////////////
	public Coliseum() {
		numbers = new ArrayList<Long>();
		clock =  new Clock();
		circles = new ArrayList<Circle>();
	}
	
	public void addArrayList(long number) {
		numbers.add(number);
	}
	
	public void addLinkedListRecursive(long add) throws StackOverflowError {
		if(first==null) {
			Number n = new Number(add); 
			first = n;
		}else {
			addLinkedListRecursive(first,add);
		}
	}
	
	private void addLinkedListRecursive(Number current, long add) throws StackOverflowError{
		
		if(current.getNext()==null) {
			Number n = new Number(add);
			current.setNext(n);
			n.setPrev(current);
		}else {
			addLinkedListRecursive(current.getNext(),add);
		}
	}
	
	
	public void addLinkedListIterative(long add) {
		Number n = new Number(add); 	
		if(first==null) {
			first = n;
			
		}else if(first.getNext()==null){
			first.setNext(n);
			n.setPrev(first);
			
		}else {
			Number current = first;
			boolean flag = true;
			while(current!=null && flag) {
				
				if(current.getNext()==null) {
					current.setNext(n);
					n.setPrev(current);
					flag = false;
					
				}else {
					current = current.getNext();
				}
			}
		}
		
	}
	
	public void addBSTRecursive(long add) throws StackOverflowError {
		NumberBST n = new NumberBST(add);
		
		if(parent==null) {
			parent = n;
		}else {
			addBSTRecursive(parent,n);
		}
	}
	
	private void addBSTRecursive(NumberBST current,NumberBST add) throws StackOverflowError {
		
		if(add.getNumber()>current.getNumber()) {
			if(current.getRight()!=null) {
				addBSTRecursive(current.getRight(),add);
			}else {
				current.setRight(add);
				add.setParent(current);
			}
			
		}else if(add.getNumber()<=current.getNumber()) {
			if(current.getLeft()!=null) {
				addBSTRecursive(current.getLeft(),add);
			}else {
				current.setLeft(add);
				add.setParent(current);
			}
		}
	}
	
	public void addBSTIterative(long add) {
		boolean flag = true;
		NumberBST n = new NumberBST(add);
		
		if(parent==null) {
			parent = n;
		}else {
			NumberBST current = parent;
			
			while(current!=null && flag) {
				//System.out.println("entra");

				if(n.getNumber()>current.getNumber()) {
					if(current.getRight()!=null) {
						current = current.getRight();
					}else {
						current.setRight(n);
						n.setParent(current);
						flag = false;
					}
					
				}else if(n.getNumber()<=current.getNumber()) {
					if(current.getLeft()!=null) {
						current = current.getLeft();
					}else {
						current.setLeft(n);
						n.setParent(current);
						flag = false;
					}
				}
			}
		}
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
// a partir de aquí están los metodos para Consultar un numero
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean searchArrayListIterative(long n) {
		boolean isHere = false;
		for(int i=0;i<numbers.size() && !isHere ;i++) {
			if(numbers.get(i)==n) {
				isHere = true;
			}
		}
		return isHere;
	}
	
	public boolean searchArrayListRecursive(int p,long n) throws StackOverflowError {
		
		if(p>numbers.size()-1) {
			return false;
		}
		else if(numbers.get(p)==n) {
			return true;
		}else {
			return searchArrayListRecursive(p+1,n);
		}
	}
	
	public boolean searchLinkedListIterative(long n) {
		boolean isHere = false;
		
		if(first!=null) {
			Number current = first;
			boolean flag = true;
			
			while(current!=null && flag) {
				if(current.getNumber()==n) {
					isHere=true;
					flag=false;
				}
				current = current.getNext();
			}
		}
		return isHere;
	}
	
	public boolean searchLinkedListRecursive(long n) throws StackOverflowError {
		boolean isHere = false;
		if(first!=null) {
			isHere=searchLinkedListRecursive(first,n);
		}
		return isHere;
	}
	
	private boolean searchLinkedListRecursive(Number current,long n) throws StackOverflowError{
		if(current.getNumber()==n) {
			return true;
		}else {
			if(current.getNext()==null) {
				return false;
			}else {
				return searchLinkedListRecursive(current.getNext(),n);
				
			}
		}
	}
	
	public boolean searchBSTIterative(long n) {

		boolean isHere = false;

		if(parent != null) {
			NumberBST current = parent;
			boolean flag = true;
			
			while(current!=null && flag) {
			
				if(current.getNumber()==n) {
					isHere = true;
					flag = false;	
					
				}
				else {
					if(current.getNumber()<n) {
						current = current.getRight();
					}else {
						current = current.getLeft();
					}
				}
			}
		}
		
		return isHere;
	}
	
	public boolean searchBSTRecursive(long n) throws StackOverflowError {

		boolean isHere = false;
		
		if(parent!=null) {
			isHere = searchBSTRecursive(parent, n);
		}
		
		return isHere;
	}
	
	private boolean searchBSTRecursive(NumberBST current, long n) throws StackOverflowError {
		
		if(current.getNumber()==n) {
			return true;
		}else {
			if(current.getNumber()<n && current.getRight()!=null) {
				return searchBSTRecursive(current.getRight(), n);
					
			}else if(current.getNumber()>n && current.getLeft()!=null) {
				return searchBSTRecursive(current.getLeft(), n);
			}else {
				return false;
			}
			
		}
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//a partir de aquí están los metodos para eliminar un numero
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public boolean deleteArrayListIterative(long n) {
		boolean deleted = false;
		boolean flag = true;
		
		for(int i=0;i< numbers.size() && flag;i++) {
			if(numbers.get(i)==n) {
				numbers.remove(i);
				deleted = true;
				flag = false;
			}
		}
		
		return deleted;
	}
	
	public boolean deleteArrayListRecursive(long n) throws StackOverflowError {
		boolean deleted = false;
		
		if(!numbers.isEmpty()) {
			deleted = deleteArrayListRecursive(0,n);
		}
				
		return deleted;
	}
	
	private boolean deleteArrayListRecursive(int p,long n) throws StackOverflowError {
		
		if(p<numbers.size()) {
			if(numbers.get(p)==n) {
				numbers.remove(p);
				return true;
			}else {
				return deleteArrayListRecursive(p+1,n);
			}
		}else {
			return false;
		}
		
	}
	
	public boolean deleteLinkedListIterative(long n) {
		boolean deleted = false;
		
		if(first!=null) {
			if(first.getNumber()==n){
				Number next = first.getNext();
				next.setPrev(null);
				first = next;
				deleted = true;
			}else {
				Number current = first;
				boolean flag = true;
				
				while(current!=null && flag) {
					
					if(current.getNumber()==n) {
						if(current.getNext()==null) {
							Number prev = current.getPrev();
							prev.setNext(null);
						}else {
							Number prev = current.getPrev();
							Number next = current.getNext();
							prev.setNext(next);
							next.setPrev(prev);
						}
						deleted = true;
						flag = false;
					}else {
						current = current.getNext();
					}
				}	
			}
		}
		return deleted;
	}
	
	public boolean deleteLinkedListRecursive(long n) throws StackOverflowError {
		boolean deleted = false;
		
		if(first!=null) {
			if(first.getNumber()==n) {
				Number next = first.getNext();
				next.setPrev(null);
				first = next;
				deleted = true;
			}else {
				deleted = deleteLinkedListRecursive(first.getNext(), n);
			}
		}
		
		return deleted;
	}
	
	private boolean deleteLinkedListRecursive(Number c,long n) throws StackOverflowError {
		if(c.getNumber()==n) {
			if(c.getNext()==null) {
				Number prev = c.getPrev();
				prev.setNext(null);
			
			}else {
				Number next = c.getNext();
				Number prev = c.getPrev();
				prev.setNext(next);
				next.setPrev(prev);
			}
			return true;
		}else {
			if(c.getNext()==null) {
				return false;
			}else {
				return deleteLinkedListRecursive(c.getNext(), n);
			}
		}
		
	}
	
	
	public boolean deleteBSTIterative(long n) {
		boolean deleted = false;

		if(parent!=null) {
			NumberBST current = parent;
			boolean flag = true;

			while(current!=null && flag) {
				if(current.getNumber()==n) {

					if(current.getLeft()==null && current.getRight()==null) {
						deleteBSTLeaf(current);
						
					}else if(current.getLeft()==null || current.getRight()==null) {
						deleteBSTWithOneChild(current);

					}else {
						deleteBSTWithTwoChindren(current);

					}
					deleted = true;
					flag = false;
				}
				if(current.getNumber()<n) {
					current = current.getRight();
				}else {
					current = current.getLeft();
				}
			}
		}
		return deleted;
	}
	
	private NumberBST searchMaxNumberIterative(NumberBST current) {
		
		while(current!=null) {
			if(current.getRight()!=null) {
				current = current.getRight();
			}else {
				return current;
			}
		}
		return null;
	}
	
	private void deleteBSTLeaf(NumberBST toDelete) {
		if(toDelete==parent){
			parent = null;	
		}else{
			NumberBST p = toDelete.getparent();
			if(p.getLeft()==toDelete) {
				p.setLeft(null);
			}else {
				p.setRight(null);
			}
		}
	}
	
	private void deleteBSTWithOneChild(NumberBST toDelete) {
		if(toDelete.getLeft()==null) {
			NumberBST p = toDelete.getparent();
			NumberBST rChild = toDelete.getRight();
			if(toDelete==parent){
				parent = rChild;
			}else{
				if(p.getLeft()==toDelete) {
					p.setLeft(rChild);
				}else {
					p.setRight(rChild);
				}	
			}
			rChild.setParent(p);

		}else if(toDelete.getRight()==null) {

			NumberBST p = toDelete.getparent();
			NumberBST lChild = toDelete.getLeft();
			if(toDelete==parent){
				parent = lChild;
			}else{
				if(p.getLeft()==toDelete) {
					p.setLeft(lChild);
				}else {
					p.setRight(lChild);
				}	
			}
			lChild.setParent(p);
		}
	}
	
	public void deleteBSTWithTwoChindren(NumberBST toDelete) {
		NumberBST max = searchMaxNumberIterative(toDelete.getLeft());
		if(max.getLeft()==null && max.getRight()==null) {
			deleteBSTLeaf(max);
		}else {
			deleteBSTWithOneChild(max);
		}

		NumberBST leftChild = toDelete.getLeft();
		NumberBST rightChild = toDelete.getRight();
		NumberBST currentParent = toDelete.getparent();
		max.setLeft(leftChild);
		max.setRight(rightChild);
		max.setParent(currentParent);

		if(rightChild!=null) {
			rightChild.setParent(max);
		}
		if(leftChild!=null) {
			leftChild.setParent(max);
		}
		if(currentParent!=null) {
			if(currentParent.getLeft()==toDelete) {
				currentParent.setLeft(max);
			}else {
				currentParent.setRight(max);
			}
		}
		max.setParent(currentParent);
		if(toDelete==parent) {
			parent = max;
		}
	}
	
	public boolean deleteBSTRecursive(long n) throws StackOverflowError {
		boolean deleted = false;

		if(parent!=null) {
			deleted = deleteBSTRecursive(parent, n);
		}
		return deleted;
	}
	
	private boolean deleteBSTRecursive(NumberBST current,long n) throws StackOverflowError {
		if(current!=null) {
			if(current.getNumber()==n) {
				if(current.getLeft()==null && current.getRight()==null) {
					deleteBSTLeaf(current);
				}else if(current.getLeft()==null || current.getRight()==null) {
					deleteBSTWithOneChild(current);
				}else {
					deleteBSTWithTwoChindren(current);
				}
				return true;
			}
			if(current.getNumber()<n) {
				return deleteBSTRecursive(current.getRight(),n);
			}else {
				return deleteBSTRecursive(current.getLeft(),n);
			}
		}
		return false;
	}
	
	public String runClock() {
		clock.run();
		
		return clock.toString();
	}
	
	public void initClock() {
		clock.setInitTime();
	}
	
	public void reset() {
		first = null;
		parent = null;
		numbers = new ArrayList<Long>();
	}
	
	public void addCircle(double radius) {
		circles.add(new Circle(radius));
	}
	
	public void calculateCirclesRadius() {
		for(int i=0;i<circles.size();i++) {
			circles.get(i).calculateNewRadius();
		}
	}
	
	public ArrayList<Circle> getCircles() {
		return circles;
	}
	
	
	
	
	
	public Number getFirstNumber() {
		return first;
	}
	
	public void showNumberAdded() {
		String message = ""; 
		Number current = first;
		
		while(current!=null) {
			message = message+";"+current.getNumber();
			current = current.getNext();
		}
		System.out.println(message);
	}
	
	public void showBST() {
		showBST(parent);
	}
	
	private void showBST(NumberBST n) {	
		if(n.getLeft()!=null) {
			showBST(n.getLeft());
		}
		System.out.println(n.getNumber());
		
		if(n.getRight()!=null) {
			showBST(n.getRight());
		}
	}
	
	public void showArrayList() {
		String message = "";
		for(int i=0;i<numbers.size();i++) {
			message = message+","+numbers.get(i);
		}
		System.out.println(message);
	}
	
	
}
