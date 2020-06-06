import java.io.*;
import java.util.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{

	static void levelOrder(Node root){
      //Write your code here
       if(root==null)
       {
           return;
       }

       int a=getHeight(root);

       for(int i=0;i<=a;i++)
       {
           printElement(root,i+1);
       }

      
    }

    static int getHeight(Node root)
    {
        if(root==null)
        {
            return -1;
        }

        return max(getHeight(root.left),getHeight(root.right))+1;
    }

    static int max(int a , int b)
    {
        return a>b?a:b;
    }

    static void printElement(Node root,int level)
    {
        if(root==null)
        {
            return;
        }

        if(level==1)
        {
            System.out.print(root.data+" ");
        }

        printElement(root.left,level-1);
        printElement(root.right,level-1);
    }

	public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}
