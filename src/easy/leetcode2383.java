package easy;

public class leetcode2383 {
    /*
    赢得比赛需要的最少训练时长
    https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
     */
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int total = 0;
        for (int i = 0; i < energy.length; i++) {
            total += energy[i];
        }
        total++;
        int step = total > initialEnergy ? total - initialEnergy : 0;
        int flag = experience[0];
        int before = 0;
        for (int i = 0; i < experience.length; i++) {
            int temp = experience[i] - before;
            if (temp > flag) {
                flag = temp;
            }
            before += experience[i];
        }
        flag++;
        step += flag > initialExperience ? flag - initialExperience : 0;
        return step;
    }
}
