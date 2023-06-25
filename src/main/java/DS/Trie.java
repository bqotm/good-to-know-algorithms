package DS;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class Trie<T> {

    @Data
    @AllArgsConstructor
    private static class TrieNode<T> {

        private T value;
        private Map<T, TrieNode<T>> children;
        private boolean isEndOfWord;

        public TrieNode(T value) {
            this.value = value;
            children = new HashMap<>();
        }

        public TrieNode<T> getNext(T value) {
            return children.get(value);
        }

    }

    private TrieNode<T> root;

    /*
            *
          a      b     c
        l  s     a         h
       l    s    d           o
       *                        d
     */
    public void insert(T[] word) {
        TrieNode<T> current = root;
        int i = 0;
        for (T character : word) {
            Map<T, TrieNode<T>> children = current.getChildren();
            if (!children.containsKey(character)) {
                TrieNode<T> newOne = new TrieNode<>(character);
                if (i == word.length - 1) {
                    newOne.setEndOfWord(true);
                }
                children.put(character, newOne);
            }
            current = children.get(character);
            i++;
        }
    }

    public boolean search(T[] word) {
        TrieNode<T> current = root;
        int i = 0;
        for (T character : word) {
            Map<T, TrieNode<T>> children = current.getChildren();
            if (!children.containsKey(character))
                return false;
            current = children.get(character);
            System.out.println(current.value);
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(T[] prefix) {
        TrieNode<T> current = root;
        int i = 0;
        for (T character : prefix) {
            Map<T, TrieNode<T>> children = current.getChildren();
            if (!children.containsKey(character))
                return false;
            current = children.get(character);
        }
        return true;
    }


    public static void main(String[] args) {
        Trie<Character> trie = new Trie<>(new TrieNode<>('*'));
        Character[] all = new Character[]{'a', 'l', 'l'};
        Character[] ass = new Character[]{'a', 's', 's'};
        Character[] allow = new Character[]{'a', 'l', 'l', 'o', 'w'};
        Character[] best = new Character[]{'b', 'e', 's', 't'};
        Character[] bes = new Character[]{'b', 'e', 's'};
        trie.insert(all);
        trie.insert(ass);
        trie.insert(allow);
        trie.insert(best);
        System.out.println(trie.search(all));
        System.out.println(trie.startsWith(bes));
    }

}
