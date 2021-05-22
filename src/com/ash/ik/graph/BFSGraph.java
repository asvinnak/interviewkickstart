package com.ash.ik.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

    private int v; // No of Vertices
    private LinkedList<Integer> adj[]; // No of adjacent list

    BFSGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for(int i=0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public void BFS(int s) {

        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(" "+ s);

            //get edges of queue vertex
            Iterator<Integer> itr = adj[s].listIterator();

            while (itr.hasNext()) {
                int n = itr.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }






    }

    public static void main(String[] args) {

        BFSGraph o =new BFSGraph(4);

        o.addEdge(0, 1);
        o.addEdge(0, 2);
        o.addEdge(2, 0);
        o.addEdge(2, 3);
        o.addEdge(1, 2);
        o.addEdge(3, 3);

        o.BFS(2);


    }
}
