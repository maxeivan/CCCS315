package mcgill.cccs315.assignment4;

public class TestGraph {

	public static void main(String[] args) {
		Graph<String> G = new Graph<>();
		Vertex<String> van = G.createVertex("Vancouver");
		Vertex<String> edm = G.createVertex("Edmonton");
		Vertex<String> win = G.createVertex("Winnipeg");
		Vertex<String> tor = G.createVertex("Toronto");
		Vertex<String> ott = G.createVertex("Ottawa");
		Vertex<String> mon = G.createVertex("Montreal");
		Vertex<String> kel = G.createVertex("Kelowna");
		
		G.createEdge(kel, edm, 2);
		G.createEdge(van, mon, 5);
		G.createEdge(win, tor, 3);
		G.createEdge(ott, mon, 1);
		G.createEdge(van, tor, 5);
		G.createEdge(ott, win, 2);
		
		G.print();
		System.out.println("--------");
		G.printShortestPath(mon, win);
		System.out.println("--------");
		G.printShortestPath(mon, edm);
	}
}
