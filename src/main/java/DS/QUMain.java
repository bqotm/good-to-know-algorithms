package DS;

public class QUMain {


    public static void main(String[] args) {
        WeightedQuickUnion weightedQuickUnion=new WeightedQuickUnion(10);
        weightedQuickUnion.union(0, 1);
        weightedQuickUnion.union(5, 6);
        System.out.println(weightedQuickUnion.findMax(1));
        weightedQuickUnion.union(1,5);
        System.out.println(weightedQuickUnion.findMax(0));
        weightedQuickUnion.union(0,7);
        System.out.println(weightedQuickUnion.findMax(7));
        System.out.println(weightedQuickUnion.findMax(1));
        weightedQuickUnion.maxMap.forEach((k,v) -> {
            System.out.println(k+" "+v);
        });
        System.out.println(weightedQuickUnion.findMax(5));
    }

}
