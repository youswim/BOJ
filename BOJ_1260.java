
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");



        int nodeCount = Integer.parseInt(str[0]);
        int lineCount = Integer.parseInt(str[1]);
        int startNode = Integer.parseInt(str[2]);

        Node[] nodes = new Node[nodeCount+1];
        for(int i=0; i<nodeCount+1; i++)
            nodes[i] = new Node(i);

        for(int i=0; i<lineCount; i++){
            str = br.readLine().split(" ");
            int s = Integer.parseInt(str[0]);
            int e = Integer.parseInt(str[1]);
            nodes[s].addSide(nodes[e]);
            nodes[e].addSide(nodes[s]);
        }

        for(Node n : nodes)
            n.neighbours.sort(new Com());

        DFS(nodes[startNode]);

        System.out.println();
        reset(nodes);

        BFS(nodes[startNode]);
    }

    static void reset(Node[] nodes){
        for(Node v : nodes)
            v.visited=false;
    }

    static void DFS(Node node){

        node.visited=true;
        System.out.printf("%d",node.info);
        List<Node> list = node.getSide();
        for(Node n : list){
            if(!n.visited) {
                System.out.print(" ");
                DFS(n);
            }
        }
    }

    static Queue<Node> queue = new LinkedList<>();
    static void BFS(Node node){
        node.visited = true;
        queue.add(node);
        System.out.print(node.info);

        while(!queue.isEmpty()){
            Node v = queue.remove();
            List<Node> neigh = v.neighbours;

            for(Node w : neigh){
                if(!w.visited){
                    System.out.print(" "+w.info);
                    w.visited = true;
                    queue.add(w);
                }
            }
        }

    }

}

class Com implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.info, o2.info);
    }
}

class Node {
    int info;
    boolean visited;
    List<Node> neighbours; //인접 목록

    Node(int info){ //생성자
        this.info = info;
        this.visited = false;
        this.neighbours = new ArrayList<>();
    }

    public void addSide(Node n) { //인접 목록 채우기
        this.neighbours.add(n);
    }

    public List<Node> getSide(){ //인접 목록 반환
        return neighbours;
    }

    public void setSide(List<Node> n) { // 인접 목록 세팅
        this.neighbours = n;
    }

    @Override
    public String toString() { //출력 오버라이딩
        return "" + info;
    }
}