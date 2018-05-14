package poly;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements evaluate, add and multiply for polynomials.
 * 
 * @author runb-cs112
 *
 */
public class Polynomial {
	
	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param sc Scanner from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 * @return The polynomial linked list (front node) constructed from coefficients and
	 *         degrees read from scanner
	 */
	public static Node read(Scanner sc) 
	throws IOException {
		Node poly = null;
		while (sc.hasNextLine()) {
			Scanner scLine = new Scanner(sc.nextLine());
			poly = new Node(scLine.nextFloat(), scLine.nextInt(), poly);
			scLine.close();
		}
		return poly;
	}
	
	/**
	 * Returns the sum of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list
	 * @return A new polynomial which is the sum of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node add(Node poly1, Node poly2) {
		/** COMPLETE THIS METHOD **/

		//the sum of the two polynomials and the coeffs
		Node sumPoly = null;
		float total = 0;
		Node ptr1 = poly1;
		Node ptr2 = poly2;
		
		//Traverse through the node
		
	
//		if(ptr1.term.degree == 0 && ptr2.term.degree == 0) {
//			if(ptr1.term.coeff + ptr2.term.coeff !=0) {
//			sumPoly = new Node(ptr1.term.coeff + ptr2.term.coeff,ptr1.term.degree,sumPoly);
//			}
//			ptr1 = ptr1.next;
//			ptr2 = ptr2.next;
//			
//		}
//		else if(ptr1.term.degree == 0 && ptr2.term.degree != 0) {
//			if(ptr1.term.coeff + ptr2.term.coeff !=0) {
//			sumPoly = new Node(ptr1.term.coeff,ptr1.term.degree,sumPoly);
//		}
//			ptr1 = ptr1.next;
//			ptr2 = ptr2.next;
//		}
//		else if(ptr1.term.degree != 0 && ptr2.term.degree == 0) {
//			if(ptr1.term.coeff + ptr2.term.coeff !=0) {
//			sumPoly = new Node(ptr2.term.coeff,ptr2.term.degree,sumPoly);
//			}
//			ptr1 = ptr1.next;
//			ptr2 = ptr2.next;
//		}
		
	while(ptr1 != null && ptr2 != null) {
		
		
		
	
		//Case one, both degrees  are the same
		if( (ptr1.term.degree == ptr2.term.degree) ) {
			if(ptr1.term.coeff + ptr2.term.coeff !=0) {
			sumPoly = new Node(ptr1.term.coeff+ptr2.term.coeff,ptr1.term.degree,sumPoly);
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
			
			
			}
		//Second case 1st degree higher
		else if((ptr1.term.degree < ptr2.term.degree) ) {
			if(ptr1.term.coeff + ptr2.term.coeff !=0) {
				sumPoly = new Node(ptr1.term.coeff,ptr1.term.degree, sumPoly);
			}
				ptr1 = ptr1.next;
				
			}
			
		//third case, 2nd degree higher
		else if( (ptr2 != null && ptr1 == null) || (ptr1.term.degree > ptr2.term.degree) ) {
			if(ptr1.term.coeff + ptr2.term.coeff !=0) {
				sumPoly = new Node(ptr2.term.coeff,ptr2.term.degree,sumPoly);
			}
				ptr2 = ptr2.next;
				
		}
		if( (ptr1 != null && ptr2 == null) ) {
			sumPoly = new Node(ptr1.term.coeff,ptr1.term.degree,sumPoly);
		}
		else if(ptr2 != null && ptr1 == null){
			sumPoly = new Node(ptr2.term.coeff,ptr2.term.degree,sumPoly);
		}
		
	
	
	
	
		}
	//flips the sumPoly
	Node reverse = null;
	Node sumPtr = sumPoly;
	Node n;
			while(sumPtr != null)
			{
				n = sumPtr.next;
				sumPtr.next = reverse;
				reverse = sumPtr;
				sumPtr = n;
			}
			sumPoly = reverse;
			
			
	
		
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		return sumPoly;
		
		
	}
	//helper method
//	private static Node sortByDegree(Node productPoly){
//	   
//		Node prevData = productPoly;
//	    Node current = productPoly.next;
//
//	    while (current != null){
//	    	//checks to see if the first degree is smaller then the next one 
//	        if (current.term.degree < prevData.term.degree){
//	            //stores that degree
//	        	int degree = current.term.degree;
//	            current.term.degree = prevData.term.degree;
//	            prevData.term.degree = degree;
//	            //takes the coefficient of current and stores into temp
//	            float coeff = current.term.coeff;
//	            current.term.coeff = prevData.term.coeff;
//	            prevData.term.coeff = coeff;
//
//	            prevData = productPoly;
//	            current = productPoly.next;
//	        }
//        
//
//	        prevData = prevData.next;
//	        current = current.next;
//	        
//	        
//	    }
//	   
//
//	    return productPoly;
//	}
	private static Node simplifyTerms(Node polyProduct) {
		Node ptr1 = polyProduct;
		Node ptr2 = null;
		if(ptr2 == null) {
			ptr2 = ptr1.next;
		}
		
		while(ptr1 != null && ptr2!= null) {
			if(ptr1.term.degree ==  ptr2.term.degree) {
				ptr1.term.coeff = ptr1.term.coeff+ptr2.term.coeff;
				ptr1.next = ptr2.next; // deleting pt2 node
				ptr2 =ptr2.next;
			
			} else {
				ptr1 = ptr1.next;
				ptr2 = ptr2.next;
			}
			
			
		}	
		
		




		return polyProduct;
	}


	
	/**
	 * Returns the product of two polynomials - DOES NOT change either of the input polynomials.
	 * The returned polynomial MUST have all new nodes. In other words, none of the nodes
	 * of the input polynomials can be in the result.
	 * 
	 * @param poly1 First input polynomial (front of polynomial linked list)
	 * @param poly2 Second input polynomial (front of polynomial linked list)
	 * @return A new polynomial which is the product of the input polynomials - the returned node
	 *         is the front of the result polynomial
	 */
	public static Node multiply(Node poly1, Node poly2) {
		/** COMPLETE THIS METHOD **/
		//Node for product
		
		Node ptr1 = poly1;
		Node ptr2 = poly2;
		Node productPoly = null;
		Node last = null;
	
		
		while(ptr1 != null) {
			//checks to see if poly2 has null
			if(ptr2 == null) {
				ptr2 = poly2;
			}
			while(ptr2 != null) {
				
			
				if(ptr1.term.coeff == 0 || ptr2.term.coeff == 0) {
					return null;
				}
				//Node for the product of the polynomials
				
				Node p = new Node((ptr1.term.coeff*ptr2.term.coeff),(ptr1.term.degree+ptr2.term.degree), null);
				
				//checks to see if last is not null and makes the next last node to the p node
				if(last != null) {
					last.next = p;
				}
				
				else {
					//same as for this
					productPoly = p;
				}
				//initializes last as p
				last = p;
				//goes on to the next data in poly2 
				ptr2 = ptr2.next;
				
			
			}
			//sames as poly2
			ptr1 = ptr1.next;	
			
			

		   
		}
//		sortByDegree(productPoly);
	simplifyTerms(productPoly);
		    
		    
		
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		return productPoly;
	}
		
	/**
	 * Evaluates a polynomial at a given value.
	 * 
	 * @param poly Polynomial (front of linked list) to be evaluated
	 * @param x Value at which evaluation is to be done
	 * @return Value of polynomial p at x
	 */
	public static float evaluate(Node poly, float x) {
		/** COMPLETE THIS METHOD **/
		float total = 0;
		
		if(poly == null || poly.term.degree == 0) {
			total += poly.term.coeff;
			poly = poly.next;
		}
		while(poly != null) {
			total += poly.term.coeff * (Math.pow(x,poly.term.degree));
			poly = poly.next;
		}
		
		
		// FOLLOWING LINE IS A PLACEHOLDER TO MAKE THIS METHOD COMPILE
		// CHANGE IT AS NEEDED FOR YOUR IMPLEMENTATION
		return total;
	}
	
	/**
	 * Returns string representation of a polynomial
	 * 
	 * @param poly Polynomial (front of linked list)
	 * @return String representation, in descending order of degrees
	 */
	public static String toString(Node poly) {
		if (poly == null) {
			return "0";
		} 
		
		String retval = poly.term.toString();
		for (Node current = poly.next ; current != null ;
		current = current.next) {
			retval = current.term.toString() + " + " + retval;
		}
		return retval;
	}	
}
