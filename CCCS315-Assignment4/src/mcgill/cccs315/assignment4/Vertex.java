package mcgill.cccs315.assignment4;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {
	List<Vertex<T>> shortestPath = new LinkedList<>();
	
	T city; 
    Vertex(T city) {  this.city = city;}  // constructor 
    
    public String toString() { return (String) city; }
}
