package mcgill.cccs315.assignment4;

public class Edge<T> implements Comparable<Edge<T>>{

	Vertex <T> vertex;
	int weight;
	
	public Edge(){	
	}
	
	public Edge(Vertex<T> vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge<T> edge) {
		if (this.weight < edge.weight) 
            return -1; 
        if (this.weight > edge.weight) 
            return 1; 
        return 0;
	}
}
