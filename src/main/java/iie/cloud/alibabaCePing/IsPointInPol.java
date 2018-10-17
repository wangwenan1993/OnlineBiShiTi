package iie.cloud.alibabaCePing;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wagnwenan on 2018/9/7.
 */
public class IsPointInPol {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ss = in.nextLine().trim();
        String[] p_str = ss.split(",");
        Point2D.Double point = new Point2D.Double(Double.valueOf(p_str[0]), Double.valueOf(p_str[1]));
        List<Point2D.Double> polygon =  new ArrayList<>();
        ss = in.nextLine().trim();
        String[] poly_str = ss.split(",");
        for(int i = 0; i < poly_str.length; i++) {
            polygon.add(new Point2D.Double(Double.valueOf(poly_str[i++]), Double.valueOf(poly_str[i])));
        }
//        for(Point2D.Double p: polygon) {
//            System.out.println(p.x + " " + p.y);
//        }
//        System.out.println(polygon.size());
        checkWithJdkGeneralPath(point, polygon);
    }

    private static void checkWithJdkGeneralPath(Point2D.Double point, List<Point2D.Double> polygon) {

        List<Point2D.Double> c_poly = new ArrayList<>(polygon);

        GeneralPath p = new GeneralPath();

        Point2D.Double first = polygon.get(0);
        p.moveTo(first.x, first.y);
        polygon.remove(0);
        for (Point2D.Double d : polygon) {
            p.lineTo(d.x, d.y);
        }

        p.lineTo(first.x, first.y);

        p.closePath();

        boolean is_contain = p.contains(point);

        double min_dis = Double.MAX_VALUE;
        if(c_poly.size() == 1) min_dis = distance(point.x, point.y, c_poly.get(0).x, c_poly.get(0).y);
        else {
            for (int i = 1; i < c_poly.size(); i++) {
                double tmp = pointToLine(c_poly.get(i-1).x, c_poly.get(i-1).y, c_poly.get(i).x, c_poly.get(i).x, point.x, point.y);
                min_dis = tmp < min_dis ? tmp : min_dis;
            }
        }

        if(is_contain || min_dis == 0.0) {
            System.out.println("yes,0");
        } else {

            System.out.println("no," + Math.ceil(min_dis));
        }
    }

    public static double pointToLine(double x1, double y1, double x2, double y2, double x0,
                               double y0) {
        double space = 0;
        double a, b, c;
        a = distance(x1, y1, x2, y2);
        b = distance(x1, y1, x0, y0);
        c = distance(x2, y2, x0, y0);
        if (c <= 0.000001 || b <= 0.000001) {
            space = 0;
            return space;
        }
        if (a <= 0.000001) {
            space = b;
            return space;
        }
        if (c * c >= a * a + b * b) {
            space = b;
            return space;
        }
        if (b * b >= a * a + c * c) {
            space = c;
            return space;
        }
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        space = 2 * s / a;
        return space;
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
