package trie;

import java.util.*;

public class SearchSuggestionSystem {


    TrieNode  root = new TrieNode();


    void buildTrie(String[] products){
        TrieNode curr = root;
        for(int i = 0; i < products.length; i++){
            for(int j = 0; j < products[i].length(); j++){
                if(curr.get(products[i].charAt(j)) == null){
                    curr.put(products[i].charAt(j));
                }
                curr = curr.get(products[i].charAt(j));
            }
            curr.setEnd();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        buildTrie(products);
        for(int i = 0; i < searchWord.length(); i++){
            tempList = new ArrayList<>();
            searchWithPrefix(searchWord.substring(0, i + 1));
            result.add(tempList);
        }
        return result;
    }

    void searchWithPrefix(String prefix){
        TrieNode curr = root;
        List<Character> list = new ArrayList<>();
        for(int i = 0; i< prefix.length(); i++){
            if(curr.get(prefix.charAt(i)) == null){
                return;
            }else{
                list.add(prefix.charAt(i));
                curr = curr.get(prefix.charAt(i));
            }
        }
        tempList = new ArrayList<>();
        System.out.println(list);
        dfs(curr, list);
    }

    List<String> tempList = new ArrayList<>();

    void dfs(TrieNode node, List<Character> list){
        if(tempList.size() == 3){
            return;
        }

        if(node.isEnd()){
            StringBuilder sb = new StringBuilder();
            for(Character ch : list){
                sb.append(ch);
            }
            tempList.add(sb.toString());
        }

        for(int i = 0; i < 26; i++){
            if(node.links[i] != null){
                list.add((char)(i + 'a'));
                dfs(node.links[i], list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SearchSuggestionSystem obj = new SearchSuggestionSystem();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        obj.suggestedProducts(products, searchWord);
    }
}


class TrieNode{
    TrieNode[] links;
    boolean isEnd;

    TrieNode(){
        this.links = new TrieNode[26];
        this.isEnd = false;
    }

    TrieNode get(char ch){
        return links[ch - 'a'];
    }

    void put(char ch){
        TrieNode newNode = new TrieNode();
        links[ch - 'a'] = newNode;
    }

    boolean isEnd(){
        return isEnd;
    }

    void setEnd(){
        isEnd = true;
    }

}