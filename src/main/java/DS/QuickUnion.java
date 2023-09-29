package DS;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.stream.IntStream;

@AllArgsConstructor
@ToString
public class QuickUnion {

    /*
            i   0   1   2   3   4   5   6   7   8   9
           arr  0   1   4   3   7   1   6   7   8   9
     */

    protected int[] id;

    public QuickUnion(int n) {
        this.id = new int[n];
        IntStream.range(0,n).forEach(i->id[i]=i);
    }

    public int findRoot(int i) {
        while(i!=id[i]) {
            i=id[i];
        }
        return i;
    }

    public void union(int i, int j) {
        int root_i=findRoot(i);
        int root_j=findRoot(j);
        id[root_i]=root_j;
    }

    public boolean isConnectedTo(int i, int j) {
        return findRoot(i)==findRoot(j);
    }

    public static void main(String[] args) {
        int arr[]={0, 1, 4, 3, 7, 1, 6, 7, 8, 9};
        QuickUnion quickUnion=new QuickUnion(arr);
        System.out.println(quickUnion.findRoot(2));
        quickUnion.union(3, 2);
        System.out.println(quickUnion.isConnectedTo(4, 3));
    }




}
