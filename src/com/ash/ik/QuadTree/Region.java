package com.ash.ik.QuadTree;

public class Region {

    private float x1;
    private float x2;
    private float y1;
    private float y2;

    public Region(float x1, float x2, float y1, float y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public boolean containsPoint(Point point) {
        return  point.getX() >= x1 &&
                point.getY() >= y1 &&
                point.getX() < x2  &&
                point.getY() < y2;
    }

    public boolean doesOverlap(Region area) {
        if(area.x2 < x1) {
            return false;
        }
        if(area.y2 < y1) {
            return false;
        }
        if(area.x1 > x2) {
            return false;
        }
        if(area.y1 > y2) {
            return false;
        }
        return true;
    }

    public Region getQuardrant(int quadrantIndex) {
        float quadrantHight = (this.y2 - this.y1)/2;
        float quadrantWidth = (this.x2 - this.x1)/2;

        //0= SW 1=NW 2=NE 3=SE

        switch(quadrantIndex) {
            case 0:
                return new Region(x1, y1, x1+quadrantWidth, y1+quadrantHight);
            case 1:
                return new Region(x1, y1 + quadrantWidth, x1+quadrantHight, y2);
            case 3:
                return new Region(x1+quadrantWidth, y1+quadrantHight, x2, y2);
            case 4:
                return new Region(x1+ quadrantWidth, y1, x2, y1 + quadrantHight);
        }

        return null;
    }

    public float getX1() {
        return x1;
    }

    public void setX1(float x1) {
        this.x1 = x1;
    }

    public float getX2() {
        return x2;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public float getY1() {
        return y1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public float getY2() {
        return y2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }
}
