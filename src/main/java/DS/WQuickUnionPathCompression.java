package DS;

public class WQuickUnionPathCompression extends WeightedQuickUnion {

    public WQuickUnionPathCompression(int n) {
        super(n);
    }

    @Override
    public int findRoot(int i) {
        while(i!=id[i]){
            id[i] = id[id[i]];//one way up the tree
            i=id[i];
        }
        return i;
    }
}
