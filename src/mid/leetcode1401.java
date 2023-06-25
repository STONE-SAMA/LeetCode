package mid;

public class leetcode1401 {
    /**
     * 圆和矩形是否有重叠
     * https://leetcode.cn/problems/circle-and-rectangle-overlapping/
     * @param radius
     * @param xCenter
     * @param yCenter
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        /* 圆心在矩形内部 */
        if (x1 <= xCenter && xCenter <= x2 && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
        /* 圆心在矩形上部 */
        if (x1 <= xCenter && xCenter <= x2 && y2 <= yCenter && yCenter <= y2 + radius) {
            return true;
        }
        /* 圆心在矩形下部 */
        if (x1 <= xCenter && xCenter <= x2 && y1 - radius <= yCenter && yCenter <= y1) {
            return true;
        }
        /* 圆心在矩形左部 */
        if (x1 - radius <= xCenter && xCenter <= x1 && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
        /* 圆心在矩形右部 */
        if (x2 <= xCenter && xCenter <= x2 + radius && y1 <= yCenter && yCenter <= y2) {
            return true;
        }
        /* 矩形左上角 */
        if (calculate_distance(xCenter, yCenter, x1, y2) <= radius * radius)  {
            return true;
        }
        /* 矩形左下角 */
        if (calculate_distance(xCenter, yCenter, x1, y1) <= radius * radius) {
            return true;
        }
        /* 矩形右上角 */
        if (calculate_distance(xCenter, yCenter, x2, y2) <= radius * radius) {
            return true;
        }
        /* 矩形右下角 */
        if (calculate_distance(xCenter, yCenter, x1, y2) <= radius * radius) {
            return true;
        }
        return false;
    }

    private int calculate_distance(int x1, int y1, int x2, int y2){
        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
    }
}
