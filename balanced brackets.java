import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length;char ch,ch2;
        
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            length=s.length();
            char first=s.charAt(0);
            char last=s.charAt(s.length()-1);
            if(first=='}' || first ==']' || first==')'){
                System.out.println("NO");
                continue;
            }
            if(last=='{' || last=='(' || last=='['){
                System.out.println("NO");
                continue;
            }
            boolean flag=true;
            if((length%2)!=0){
                System.out.println("NO");
                continue;
            }
            Stack stack=new Stack();
            for (int i=0;i<length;i++){
                ch=s.charAt(i);
                if(ch=='{' || ch=='[' || ch=='('){
                    stack.push(ch);
                }
                else if(ch=='}' || ch==']'|| ch==')'){
                    ch2=stack.pop();
                    if(ch=='}'){
                        if(ch2!='{'){
                            System.out.println("NO");
                            flag=false;
                            stack.n=1;
                            break;
                        }
                    }
                    else if(ch==']'){
                        if(ch2!='['){
                            System.out.println("NO");
                            flag=false;
                            stack.n=1;
                            break;
                        }
                    }
                    else if(ch==')'){
                        if(ch2!='('){
                            System.out.println("NO");
                            flag=false;
                            stack.n=1;
                            break;
                        }
                    }
                }
            }
            
            if(flag && stack.sizeof()==1)
            System.out.println("YES");
        }
    }
}

class Stack{
    
     static  int n=1;
     static char a[]=new char[n];
    public static void push(char x){
        if(n==a.length) resize(2*a.length);
        a[n++]=x;
       
    }
    public static char pop(){
        if(a.length==0) throw new NoSuchElementException("Stack underflow");
        char x=a[n-1];
        a[n-1]=Character.MIN_VALUE;
        n--;
        if(n>0 && n==a.length/4) resize(a.length/2);
        return x;
    }
    
    private static void resize(int capacity) {
        assert capacity >= n;
        char temp[] =  new char[capacity];
        for (int j = 0; j < n; j++) {
            temp[j] = a[j];
        }
        a = temp;
    }
    public static int sizeof(){
        return n;
    }
}
