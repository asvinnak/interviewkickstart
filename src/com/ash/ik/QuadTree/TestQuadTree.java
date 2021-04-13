package com.ash.ik.QuadTree;

import java.util.List;

public class TestQuadTree {

    public static void print(List<Point> result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void main(String[] args) {
        Region area = new Region(0, 0, 400, 400);
        QuadTree quadTree = new QuadTree(area);

        float[][] points = new float[][] { { 21, 25 }, { 55, 53 }, { 70, 318 }, { 98, 302 }, { 49, 229 }, { 135, 229 },
            { 224, 292 }, { 206, 321 }, { 197, 258 }, { 245, 238 } };

        for (int i = 0; i < points.length; i++) {
            Point point = new Point(points[i][0], points[i][1]);
            quadTree.addPoint(point);
        }

        Region searchArea = new Region(200, 200, 250, 250);
        print(quadTree.search(searchArea, null));

        searchArea = new Region(0, 0, 100, 100);
        print(quadTree.search(searchArea, null));
    }
}
