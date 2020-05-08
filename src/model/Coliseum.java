package model;

import java.util.ArrayList;

public class Coliseum {
	
	private ArrayList<Long> numbers;
	private Number first = null;
	private NumberBST parent = null;
	
	public Coliseum() {
		numbers = new ArrayList<Long>();
	}
	
	public void addArrayList(long number) {
		numbers.add(number);
	}
	
	public void addLinkedListRecursive(long add) {
		if(first==null) {
			Number n = new Number(add); 
			first = n;
		}else {
			addLinkedListRecursive(first,add);
		}
	}
	
	private void addLinkedListRecursive(Number current, long add) {
		
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
	
	public void addBSTRecursive(long add) {
		NumberBST n = new NumberBST(add);
		
		if(parent==null) {
			parent = n;
		}else {
			addBSTRecursive(parent,n);
		}
	}
	
	private void addBSTRecursive(NumberBST current,NumberBST add) {
		
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
	
	public boolean searchArrayListRecursive(int p,long n) {
		
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
	
	public boolean searchLinkedListRecursive(long n) {
		boolean isHere = false;
		if(first!=null) {
			isHere=searchLinkedListRecursive(first,n);
		}
		return isHere;
	}
	
	private boolean searchLinkedListRecursive(Number current,long n) {
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
			System.out.println("entra");
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
	
	public boolean searchBSTRecursive(long n) {
		boolean isHere = false;
		
		if(parent!=null) {
			isHere = searchBSTRecursive(parent, n);
		}
		
		return isHere;
	}
	
	private boolean searchBSTRecursive(NumberBST current, long n) {
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Number getFirstNumber() {
		return first;
	}
	
	public void showNumberAdded() {
		Number current = first;
		
		while(current!=null) {
			System.out.println(current.getNumber());
			current = current.getNext();
		}
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
	
	
}
