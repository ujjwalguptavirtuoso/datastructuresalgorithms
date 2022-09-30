package leetcode;

import java.util.*;

public class SearchSuggestionSystem {

    public static void main(String[] args) {
        String [] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        List<List<String>> result = suggestedProducts(products, searchWord);
        System.out.println(result);

    }

    static public List<List<String>> suggestedProducts(String[] products, String searchWord) {

    TrieNode root = new TrieNode();
    buildTrie(root, products);

    List<List<String>> result = new ArrayList<>();
    TrieNode curr = root;
        for(int i = 0 ; i < searchWord.length(); i++){
        List<String> possibleWithThisPrefixWords = new ArrayList<>();
        System.out.println(i);
        curr = curr.get(searchWord.charAt(i));
        dfsToFindWords(curr, possibleWithThisPrefixWords);
        System.out.println(possibleWithThisPrefixWords);
        result.add(possibleWithThisPrefixWords);
    }
        return result;
}

   static void dfsToFindWords(TrieNode root, List<String> words){
        TrieNode curr = root;

        if(curr == null){
            return;
        }

        if(curr!= null && curr.isWord()){
            words.add(curr.word);
        }

        for(char ch = 'a'; ch <= 'z'; ch++){
            if(curr.get(ch) != null){
                curr = curr.get(ch);
                dfsToFindWords(curr, words);
            }
        }
    }

   static void buildTrie(TrieNode root, String [] products){
        for(String product : products){
            TrieNode curr = root;
            for(int i = 0; i < product.length(); i++){
                if(curr.get(product.charAt(i)) == null){
                    curr.put(product.charAt(i));
                }
                curr = curr.get(product.charAt(i));
            }
            curr.setWord(product);
        }
    }
}

class TrieNode{
    TrieNode[] links;
    String word;

    public TrieNode(){
        this.links = new TrieNode[26];
        this.word = null;
    }

    TrieNode get(char ch){
        return this.links[ch - 'a'];
    }

    void put(char ch){
        this.links[ch - 'a'] = new TrieNode();
    }

    void setWord(String word){
        this.word = word;
    }

    boolean isWord(){
        return this.word != null;
    }
}
