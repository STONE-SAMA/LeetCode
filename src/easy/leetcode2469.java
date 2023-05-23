package easy;

public class leetcode2469 {
    /*
    温度转换
    https://leetcode.cn/problems/convert-the-temperature/
     */
    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        double[] res = {kelvin, fahrenheit};
        return res;
    }
}
