import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    int idx = -1; //Initialisation with -1 appears frequently across DSA problems involving indexing.

    public Node buildTree(int nodes[]){
        
        idx++;
        
        if(nodes[idx]==-1){
            return null;
        }

        Node newNode = new Node(nodes[idx]);

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public static void inorder(Node root){

        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void levelorder(Node root){

        if(root==null){
            System.out.println("Tree is empty!");
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            Node current = q.poll();
            System.out.print(current.data+" ");

            if(current.left!=null){
                q.add(current.left);
            }

            if(current.right!=null){
                q.add(current.right);
            }
        }

    }

    public int height(Node root){
        if(root==null){
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);
        
        int total = Math.max(leftH,rightH)+1;

        return total;

    }

    public int diameter(Node root){ //O(n2) approach, since we are calculating diameter and height separately

        if(root==null){
            return 0;
        }

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = height(root.left)+height(root.right)+1;

        return Math.max(diam3,Math.max(diam1,diam2));
    }

    public int diam=0;
    public int diameterOpt(Node root){ //O(n) approach, since we are only calculating height and using it to calculate diameter

        if(root==null){
            return 0;
        }

        int Lheight = diameterOpt(root.left); //We are actually calculating height in this step
        int Rheight = diameterOpt(root.right);

        diam = Math.max(diam,(Lheight+Rheight));

        return Math.max(Lheight,Rheight)+1; //Maximum Height including current node to be given to the parent node

        /*While writing return statements, always think about what you want to return to the parent ie what is useful to the parent
         * in this case returning diameter to the parent doesnt help in the calculation, we only require the max height.
         */
    }



    public static void main(String[] args){

        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree = new BinaryTree();

        Node node = tree.buildTree(nodes);

        //inorder(node);
        levelorder(node);


    }
}
