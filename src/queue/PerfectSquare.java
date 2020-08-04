package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author beny
 * @Create 2020-08-04-20:47
 */

public class PerfectSquare {
    /*
    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

        示例 1:
        输入: n = 12
        输出: 3
        解释: 12 = 4 + 4 + 4.

        示例 2:
        输入: n = 13
        输出: 2
        解释: 13 = 4 + 9.*/

    public static int numSquares(int n){
        Boolean[] visited = new Boolean[n+1];//记录广度搜索时，过滤重复的数值
        Arrays.fill(visited,false);
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.offer(n);
        //1、队列不为空时，证明n没有为0，还可以继续往下
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;//2、每一层就是一个平方数
            for(int i=0 ; i<size ; i++){
                int tmp = queue.poll();
                visited[tmp] = true;
                //3、遍历每一层的队列里面的数值，直到n为0
                for(int j=1 ; j*j<=n ; j++){
                    if(tmp-j*j==0){
                        return count;
                    }else if(tmp-j*j<0){
                        break;
                    }else{
                        if(!visited[tmp-j*j]){
                            queue.offer(tmp-j*j);
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入n：");
        int n = s.nextInt();
        System.out.println(numSquares(n));
    }
}
