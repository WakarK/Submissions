import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int N,type;
        Scanner in=new Scanner(System.in);
        N=in.nextInt();
        Stack stack=new Stack();
        for(int i=0;i<N;i++)
            {
            type=in.nextInt();
            if(type==1){
                int num=in.nextInt();
                stack.push(num);
            }
            else if(type==2){
                stack.pop();
            }
            else if(type==3){
                System.out.println(Stack.max(stack));
            }
        }
    }
}

 class Stack{
    
    private static  int n=1;
    private static int a[]=new int[n];
    public static void push(int x){
        if(n==a.length) resize(2*a.length);
        a[n++]=x;
    }
    public static void pop(){
        if(a.length==0) throw new NoSuchElementException("Stack underflow");
        int x=a[n-1];
        a[n-1]=0;
        n--;
        if(n>0 && n==a.length/4) resize(a.length/2);
    }
    public static int max(Stack st){
        int maximum=1;
        for(int j=0;j<n;j++){
            if(st.a[j]>maximum) maximum=st.a[j];
        }
        return maximum;
    }
    private static void resize(int capacity) {
        assert capacity >= n;
        int temp[] =  new int[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    } 
}