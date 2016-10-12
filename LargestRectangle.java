import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int left,right,total,area;
        int height[]=new int[N];
        int maxarea=0;
        for(int i=0;i<N;i++){
            height[i]=in.nextInt();
        }
        for(int i=0;i<N;i++){
            int j;
            for(j=i+1;j<N;j++){
                if(height[j]<height[i]){
                    break;
                }
            }
            right=j-i;
            for(j=i-1;j>=0;j--){
                if(height[j]<height[i]){
                    break;
                }
            }
            left=i-j;
            total=left+right-1;
            area=total*height[i];
            if(area>maxarea){
                maxarea=area;
            }
        }
        System.out.println(maxarea);
    }
}