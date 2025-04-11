import java.util.* ;


public class Trieproj{
    static void insert(trie root , String str){
        trie temp = root ;
        for(char ch : str.toCharArray()){
            int ind = ch -'a' ;
            if(temp.ch[ind] == null){
                temp.ch[ind] = new trie() ;
            }
            temp.wc ++;
            temp = temp.ch[ind] ;
        }
        temp.ended = true ;
    }

    static boolean search( trie root , String str){
        trie temp = root ;
        for(char ch : str.toCharArray()){
            int ind = ch -'a' ;
            if(temp.ch[ind] == null){
                temp.ch[ind] = new trie() ;
            }
            temp = temp.ch[ind] ;
        }
        return temp.ended  ;
    }
    static void prefix(trie root ,List<String> lst ,  String str){
        trie temp = root ;
        for(char ch : str.toCharArray()){
            int ind = ch -'a' ;
            if(temp.ch[ind] == null){
               return ;
            }
            temp = temp.ch[ind] ;
        }
        getWords(temp, lst, str);

    }
    static void getWords(trie root , List<String> lst,String cur ){

        if(root.ended){
            lst.add(cur) ;
        }
        for(int i =0;i<26;i++){
            if(root.ch[i] != null){
                char cur_char = (char) (i+'a') ;
                getWords(root.ch[i], lst, cur+cur_char);
            }
        }
        return ;
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in) ;
        trie root = new trie() ;
        System.out.println("Enter the no of Operations\n");;
        int t  = s.nextInt() ;
        System.out.println("format for input ");
        System.out.println("1  S -> input string "); 
        System.out.println("2 sp Search the word ");
        System.out.println("3 search for prefix");
        System.out.println("4 get all the words in the trie") ;
        System.out.println("5 : increase the no of the operations") ;
        while (t-- > 0) {
            int n = s.nextInt() ;
            if(n == 1){
                String str = s.next() ;
                insert(root , str) ;
                System.out.println("word insertd succesfully") ;
            }
            else if(n == 2){
                String str = s.next() ;
                if(search(root, str)){
                    System.out.println("found the word in the Trie") ;
                }
                else System.out.println("word not found in the Trie") ;
            }
            else if(n == 3){    
                String str = s.next() ;
                List<String> lst = new ArrayList<>() ;
                // String emp = "";
                prefix(root, lst, str) ;
                System.out.println("word with prefix are :"+ lst);
               

            }
            else if(n == 4){
                List<String> lst = new ArrayList<>() ;
                String emp = "" ;
                getWords(root, lst, emp) ;
                System.out.println("all words in the trie are : "+ lst);
            }
            else {
                int x = s.nextInt() ;
                t += x ;
            }
        }

    }
}
class trie{
    trie ch[] ;
    int wc ;
    boolean ended ;
    trie(){
       ch = new trie[26] ;   
       wc =  0;
       ended = false ;
    }
}
