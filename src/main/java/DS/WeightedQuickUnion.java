package DS;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class WeightedQuickUnion extends QuickUnion {

    private int size[];
    public Map<Integer, Integer> maxMap=new HashMap<>();

    public WeightedQuickUnion(int n) {
        super(n);
        this.size=new int[n];
        IntStream.range(0, n).forEach(i -> {
            size[i] = 1;
        });
    }

    @Override
    public int findRoot(int i) {
        return super.findRoot(i);
    }

    @Override
    public void union(int i, int j) {
        int root_i=findRoot(i);
        int root_j=findRoot(j);
        if(root_i==root_j)
            return;
        if(size[root_i]<size[root_j]) {
            this.id[root_i]=root_j;
            this.maxMap.put(root_j, Math.max(maxMap.getOrDefault(root_i,root_i), maxMap.getOrDefault(root_j,root_j)));
            size[root_j]+=size[root_i];
        } else {
            this.id[root_j]=root_i;
            this.maxMap.put(root_i, Math.max(maxMap.getOrDefault(root_i,root_i), maxMap.getOrDefault(root_j,root_j)));
            size[root_i]+=size[root_j];
        }
    }

    public int findMax(int i) {
        return this.maxMap.getOrDefault(findRoot(i),i);
    }
}
