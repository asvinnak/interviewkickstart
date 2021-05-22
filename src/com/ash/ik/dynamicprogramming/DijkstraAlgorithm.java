package com.ash.ik.dynamicprogramming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Node implements Comparator<Node> {

        int distance;

        int vertex;

        Node(int v, int d) {
            distance = d;
            vertex = v;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.distance < o2.distance) {
                return -1;
            } else if (o1.distance > o2.distance) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public void findShortestPaths(List<List<Node>> adjs, int source, int vertexes) {

        int[] distances = new int[vertexes];
        boolean[] visited = new boolean[vertexes];

            PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < vertexes; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(source, 0));
        distances[source] = 0;
        visited[source] = true;

        while (!pq.isEmpty()) {

            int currentVertex = pq.remove().vertex;
            visited[currentVertex] = true;

            //get neibours
            List<Node> neibours = adjs.get(currentVertex);
            for (Node neibour : neibours) {
                if (!visited[neibour.vertex]) {
                    int edgeDistance = neibour.distance;

                    int newDistance = distances[currentVertex] + edgeDistance;

                    if (newDistance < distances[neibour.vertex]) {
                        distances[neibour.vertex] = newDistance;
                    }
                }
                pq.add(new Node(neibour.vertex, distances[neibour.vertex]));
            }
        }

        for (int i = 0; i < vertexes; i++) {
            System.out.println(source + " to vertex " + i + " is " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int source = 0;
        int vertexes = 6;

        List<List<Node>> adjs = new ArrayList<>(vertexes);

        for (int i = 0; i < vertexes; i++) {
            adjs.add(new ArrayList<>());
        }

        adjs.get(0).add(new Node(1, 5));
        adjs.get(0).add(new Node(3, 9));
        adjs.get(0).add(new Node(4, 3));
        adjs.get(1).add(new Node(2, 2));
        adjs.get(2).add(new Node(3, 3));
        adjs.get(4).add(new Node(5, 2));
        adjs.get(5).add(new Node(3, 2));

        DijkstraAlgorithm o = new DijkstraAlgorithm();

        o.findShortestPaths(adjs, source, vertexes);
    }
}
