class Solution {
    public String doc = "";
    Stack<Character> redost = new Stack<>();
    public void append(char X)
    {
        // append x into document
        doc += X;
        while (!redost.isEmpty()) redost.pop();
    }

    public void undo() {
         // undo last change
        if(!doc.isEmpty())
        {
            char last = doc.charAt(doc.length() - 1);
            doc = doc.substring(0, doc.length() - 1);
            redost.push(last);
        }
    }

    public void redo() {
        // redo changes
        if(!redost.isEmpty())
        {
            char ch = redost.pop();
            doc += ch;
        }
    }

    public String read()
        // read the document
    {
        return doc;
    }
}