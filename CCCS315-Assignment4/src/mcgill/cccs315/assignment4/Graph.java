package mcgill.cccs315.assignment4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;
import java.util.Set;

public class Graph<T> {

	Map<Vertex<T>, List<Edge<T>>> adjVertices;
	Map<Vertex<T>, Integer> distance;
	Set<Vertex<T>> settled;
	PriorityQueue<Edge<T>> pq;
	int numberV = 0; // Number of vertices
	List<Edge<T>> list;

	//Graph(T graph) {this.graph = graph;} // constructor

	Graph() {
		adjVertices = new HashMap<>();
	}

	public Vertex<T> createVertex(T city) {
		Vertex<T> v = new Vertex<>(city);
		numberV = numberV + 1;
		list = new ArrayList<>();
		// List<Edge<T>> list = new ArrayList<>();
		adjVertices.putIfAbsent(v, list);
		return v;
	}

	public void createEdge(Vertex<T> from, Vertex<T> to, int weight) {
		Edge<T> e1 = new Edge<>(to, weight);
		adjVertices.get(from).add(e1);
		Edge<T> e2 = new Edge<>(from, weight);
		adjVertices.get(to).add(e2);
	}

	public void print() {

		for (Entry<Vertex<T>, List<Edge<T>>> entry : adjVertices.entrySet()) {
			System.out.println(entry.getKey().toString() + ":");
			for (int i = 0; i < entry.getValue().size(); i++) {
				System.out.println("     " + entry.getValue().get(i).vertex + "   " + entry.getValue().get(i).weight);
			}
			System.out.println("");
		}
		// adjVertices.forEach((key, value) -> System.out.println(key + ":" + "\n" +
		// value));
	}

	public void printShortestPath(Vertex<T> from, Vertex<T> to) {
		System.out.println("Shortest path from " + from.toString() + " " + to.toString());
		dijkstra(adjVertices, from);
		
		for (int i = 0; i < distance.size(); i++) 
            System.out.println(from.toString() + " to " + i + " is "
                               + distance.get(to));
	}

	public void dijkstra(Map<Vertex<T>, List<Edge<T>>> adjVertices, Vertex<T> source) {

		distance = new HashMap<>();
		settled = new HashSet<>();
		pq = new PriorityQueue<Edge<T>>(numberV, new Edge<T>());
		//pq = new PriorityQueue<Edge<T>>(numberV);
		
		for (Entry<Vertex<T>, List<Edge<T>>> entry : adjVertices.entrySet()) {
			distance.putIfAbsent(entry.getKey(), Integer.MAX_VALUE);
		}

		pq.add(new Edge<T>(source, 0));

		// Distance to the source is 0
		distance.replace(source, 0);

		while (settled.size() != numberV) {

			// remove the minimum distance node
			// from the priority queue
			Vertex<T> u = pq.remove().vertex;
			// adding the node whose distance is
			// finalized
			settled.add(u);

			vertexNeighbours(u);
		}
	}

	// Function to process all the neighbors
	// of the passed node
	private void vertexNeighbours(Vertex<T> u) {
		
		int edgeDistance = -1;
		int newDistance = -1;

		// All the neighbors of u
		for (int i = 0; i < adjVertices.get(u).size(); i++) {
			Edge<T> v = adjVertices.get(u).get(i);

			// If current node hasn't already been processed
			if (!settled.contains(v.vertex)) {
				edgeDistance = v.weight;
				newDistance = distance.get(u) + edgeDistance;

				// If new distance is cheaper in cost
				if (newDistance < distance.get(v.vertex));
				distance.replace(v.vertex, newDistance);

				// Add the current node to the queue
				pq.add(new Edge<T>(v.vertex, distance.get(v.vertex)));
			}
		}
	}
}
