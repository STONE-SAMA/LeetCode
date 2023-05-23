package mid;

public class letcode1138 {
    /*
    字母板上的路径
    https://leetcode.cn/problems/alphabet-board-path/
     */
    public String alphabetBoardPath(String target) {
        int[] xy = {0,0};
        StringBuffer res = new StringBuffer();

        for (int i=0;i<target.length();i++){
            char c = target.charAt(i);
            boolean flag = true;
            int temp = (int)c-(int)'a';
            int x,y;
            if (temp<=4){
                x=0;
                y=temp;
            } else if (temp<=9) {
                x=1;
                y=temp-5;
            } else if (temp<=14) {
                x=2;
                y=temp-10;
            } else if (temp<=19) {
                x=3;
                y=temp-15;
            } else if (temp<=24) {
                x=4;
                y=temp-20;
            }else {
                x=5;
                y=0;
            }

            if (x==xy[0]&&y==xy[1]){
                res.append('!');
                flag=false;
            } else if (x==xy[0]) {
                int num = y-xy[1];
                if (num>0){
                    while (num!=0){
                        res.append('R');
                        num--;
                    }
                }else {
                    while (num!=0){
                        res.append('L');
                        num++;
                    }
                }
            } else if (y==xy[1]) {
                int num = x-xy[0];
                if (num>0){
                    while (num!=0){
                        res.append('D');
                        num--;
                    }
                }else {
                    while (num!=0){
                        res.append('U');
                        num++;
                    }
                }
            }else {
                if (x==5){
                    while (xy[0]!=4){
                        res.append('D');
                        xy[0]++;
                    }
                    while (xy[1]!=0){
                        res.append('L');
                        xy[1]--;
                    }
                    res.append('D');
                }else {
                    int raw = x-xy[0];
                    if (raw>0){
                        while (raw!=0){
                            res.append('D');
                            raw--;
                        }
                    }else {
                        while (raw!=0){
                            res.append('U');
                            raw++;
                        }
                    }
                    int col = y-xy[1];
                    if (col>0){
                        while (col!=0){
                            res.append('R');
                            col--;
                        }
                    }else {
                        while (col!=0){
                            res.append('L');
                            col++;
                        }
                    }
                }
            }
            if (flag){
                res.append('!');
            }

            xy[0] = x;
            xy[1] = y;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        letcode1138 l = new letcode1138();

        String res = l.alphabetBoardPath("leet");
        System.out.println(res);
    }
}
