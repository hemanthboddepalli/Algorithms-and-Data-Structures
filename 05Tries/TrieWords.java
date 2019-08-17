//TrieNode => {TrieNode[] children, boolean isEndWord, int value, 
//markAsLeaf(int val), unMarkAsLeaf()}
class TrieWords
{
  //Recursive Function to generate all words
  public static void getWords(TrieNode root, ArrayList < String > result, String str) 
  {
    if (root.isEndWord) {
      result.add(new String(str));
    }

    for (int i=0; i<root.children.length; i++) {
      if (root.children[i] != null) {
        char c = (char) (i + 'a');
        str = str + c;
        getWords(root.children[i], result, str);
        str = str.substring(0,str.length() - 1);
      }
    }
  }
  public static ArrayList < String > findWords(TrieNode root) 
  {
    ArrayList < String > result = new ArrayList < String > ();
    getWords(root, result, "");
    return result;
  }
}
