package com.ash.ik.QuadTree;

import java.util.ArrayList;
import java.util.List;

public class QuadTree {

    public static final int MAX_POINTS = 3;

    private Region area;

    private List<QuadTree> quadTrees = new ArrayList<>();

    private List<Point> points = new ArrayList<>();

    public QuadTree(Region area) {
        this.area = area;
    }

    public boolean addPoint(Point point) {
        if (this.area.containsPoint(point)) {
            if (this.points.size() < MAX_POINTS) {
                addPoint(point);
                return true;
            } else {
                if (this.quadTrees.size() == 0) {
                    createQuardrants();
                }
                return addPointToOneQuadrant(point);
            }
        }
        return false;
    }

    private boolean addPointToOneQuadrant(Point point) {
        boolean isPointAdded;
        for (int i = 0; i < 4; i++) {
            isPointAdded = this.quadTrees.get(i).addPoint(point);
            if (isPointAdded) {
                return true;
            }
        }
        return false;
    }

    private void createQuardrants() {
        Region region;
        for (int i = 0; i < 4; i++) {
            region = this.area.getQuardrant(i);
            quadTrees.add(new QuadTree(region));
        }
    }

    public List<Point> search(Region searchRegion, List<Point> matches) {
        if(matches == null) {
            matches = new ArrayList<>();
        }

        if(!this.area.doesOverlap(searchRegion)) {
            return matches;
        } else {
            for(Point point: points) {
                if(searchRegion.containsPoint(point)) {
                    matches.add(point);
                }
            }
            if(this.quadTrees.size() > 0) {
                for(int i=0; i<4; i++) {
                    quadTrees.get(i).search(searchRegion, matches);
                }
            }
        }
        return matches;
    }
}
