package com.ash.ik.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {

    int v;

    LinkedList<Integer> adj[];

    DFSGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

    }


    public void addEdge(int v, int e) {
        adj[v].add(e);
    }

    public void DFS() {
        boolean[] visited= new boolean[v];
        for(int i=0; i < v; i++) {
            if(!visited[i]) {
                DFSRecursive(i, visited);
            }
        }

    }


    public void DFSRecursive(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(" "+ v);

        Iterator itr = adj[v].listIterator();

        while (itr.hasNext()) {
            int n = (int) itr.next();
            if (!visited[n]) {
                DFSRecursive(n, visited);
            }
        }
    }


    public static void main(String[] args) {

        DFSGraph o = new DFSGraph(4);

        o.addEdge(0, 1);
        o.addEdge(0, 2);
        o.addEdge(2, 0);
        o.addEdge(2, 3);
        o.addEdge(1, 2);
        o.addEdge(3, 3);

        o.DFS();
    }
}
