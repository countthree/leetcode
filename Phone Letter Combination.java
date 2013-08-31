public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char []a = digits.toCharArray();

        ArrayList<String> res = new ArrayList<String>();
    
            
        HashMap<Character, Character[]> map = new HashMap<Character, Character[]>();
        
        Character []two = {'a', 'b', 'c'};
        map.put('2', two);
        
        Character []three = {'d', 'e', 'f'};
        map.put('3', three);
        
        Character []four = {'g', 'h', 'i'};
        map.put('4', four);
        
        Character []five = {'j', 'k', 'l'};
        map.put('5', five);
        
        Character []six = {'m', 'n', 'o'};
        map.put('6', six);
        
        Character []seven = {'p', 'q', 'r', 's'};
        map.put('7', seven);
        
        Character []eight = {'t', 'u', 'v'};
        map.put('8', eight);
        
        Character []nine = {'w', 'x', 'y', 'z'};
        map.put('9', nine);
        
        char []builder = new char[a.length];
        
        phoneHelper(a, 0, builder, res, map);
        
        return res;
    }
    
    public void phoneHelper(char []a, int index, char[]builder, ArrayList<String> res, HashMap<Character, Character[]> map) {
        if (index == a.length) {
            res.add(new String(builder));
            return;
        }
        
        Character []letters = map.get(a[index]);
        
        for (Character letter : letters) {
            builder[index] = letter;
            phoneHelper(a, index+1, builder, res, map);
        }
    }
}