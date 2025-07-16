public class CustomTrie{

    public static class Trie{

        static class Node {
            Node[] letter = new Node[26];
            boolean eow;


            public Node() {
                for (int i=0; i<26; i++) {
                    letter[i] = null;
                }
            }
        }

        public Node root = new Node();

        public void insert(String word){

            Node curr = root;
            for(int i=0; i<word.length(); i++){

                int idx = word.charAt(i) - 'a';

                if(curr.letter[idx] == null){
                    curr.letter[idx] = new Node();
                }

                if(i==word.length()-1){
                    curr.letter[idx].eow = true;
                }

                curr = curr.letter[idx];
            }
        }

        public boolean search (String key){

            Node curr = root;
            for(int i=0; i<key.length(); i++){

                int idx = key.charAt(i) - 'a';

                if(curr.letter[idx] == null){
                    return false;
                }

                if(i==key.length()-1 && root.letter[idx].eow == false){
                    return false;
                }

                root = root.letter[idx];
            }
            return true;
        }

        /*Word Break: 
        Given a string s and a dictionary of words wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words. */

        public boolean wordBreak(String key){

            if(key.length()==0){
                return true;
            }

            for(int i = 1; i<=key.length(); i++){

                String firstPart = key.substring(0,i);
                String secPart = key.substring(i);

                if(search(firstPart) && wordBreak(secPart)){

                    return true;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix){
            
            Node curr = root;
            for(int i=0; i<prefix.length(); i++){
                int idx = prefix.charAt(i) - 'a';

                if(curr.letter[idx] == null){
                    return false;
                }

                curr = curr.letter[idx];
            }
            return true;

        }
        //Constant Unique Substrings - Microsoft Interview question - the catch here is that we have to detect and discard repeated substrings
        /* We first extract all suffixes and then extract prefixes of those suffixes and store them in a trie */

        public int countNode(Node root){

            if(root == null){
                return 0;
            }

            int count = 0;
            for(int i=0; i<26; i++){
                if(root.letter[i]!=null){
                    count+= countNode(root.letter[i]);
                }
            }
            
            return count+1;
        }

        /* Find the longest string in words such that every prefix of it is also in words
         * Hint - Find a trie branch that has all letters marked as the eow.
         */

         public static String ans = "";

         public static void longestWord(Node root, StringBuilder temp){
            
            if(root == null){
                return;
            }

            for(int i=0; i<26; i++){
                if(root.letter[i]!=null && root.letter[i].eow == true){
                    temp.append((char)(i+'a'));
                    if(temp.length()>ans.length()){
                        ans = temp.toString();
                    }
                    longestWord(root.letter[i],temp);

                    temp.deleteCharAt(temp.length()-1);
                }
            }

         }
    }

    public static void main(String[] args) {
        
        Trie trie = new Trie();

       // String str = "ababa";

        //String words[] = {"the", "a", "there", "their", "any", "thee"};
        String longword[] = {"a","banana","app","appl","ap","apply","apple"};
        for(String word: longword){
            trie.insert(word);
        }
        trie.longestWord(trie.root, new StringBuilder(""));
        System.out.println(trie.ans);
        /*for (String word : words) {
           trie.insert(word);
           System.out.println("inserted " + word);
        }*/


       //System.out.println("thee -> " + trie.search("thee"));
       //System.out.println("thor -> " + trie.search("thor"));

       /* Loop to extract all suffix for substring count problem */

       /* for(int i=0; i<str.length(); i++){
            
            String suffix = str.substring(i);
            System.out.println(suffix);
            trie.insert(suffix);
        }

        System.out.println((int)trie.countNode(trie.root)); */

    }
}