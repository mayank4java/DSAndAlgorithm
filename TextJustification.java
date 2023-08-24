class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int eachLineCount = maxWidth;

        for(int i = -1 ; i < words.length-1; ) {
            
            StringBuilder sb = new StringBuilder();

            while(eachLineCount >= 0 && i < words.length-1) {
                i++;
                eachLineCount = eachLineCount - words[i].length();
                
                if(eachLineCount == 0) {
                    sb.append(words[i]);
                    break;
                } else if (eachLineCount < 0) {
                    --i;
                    break;
                } else {
                    sb.append(words[i]).append(" ");
                    eachLineCount = eachLineCount - 1 ;
                }
            }
            
            if(i >= words.length-1) {
                result.add(transform(sb.toString(), maxWidth, true));
            } else {
                result.add(transform(sb.toString(), maxWidth, false));
            } 
            eachLineCount = maxWidth;
        }
        return result;
    }

    private String transform(String str, int maxWidth, boolean isLastOne) {
        
        if(isLastOne) {
            int len = str.length();
            return str + getSpaces(maxWidth - len);
        }
        
        String[] st = str.split(" ");  
        int count = str.replaceAll("\\s","").length();
        int numberOfWords = st.length;

        int remains = maxWidth - count;

        if(remains == 0) {
            return str; // only one word.
        } else if(numberOfWords == 1) {
             int len = str.length();
            return str + getSpaces(maxWidth - len);
        } 
        else {
            int extract = remains % (numberOfWords-1);
            int divisor =  remains / (numberOfWords-1);
             System.out.println("divisor ::" + divisor + "extract ::" + extract  + "numberOfWords ::" + numberOfWords + "remains ::" + remains  );
            return createString(st, numberOfWords-1, divisor, extract);
        }
    }

    private String createString(String[] st, int places, int sizOfSpaces, int extract) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        

        for( ; i < places; i++) {
            sb.append(st[i]);
                if(extract > 0) {
                    extract--;
                    sb.append(getSpaces(sizOfSpaces + 1));
                } else {
                    sb.append(getSpaces(sizOfSpaces));
                }
        }
        sb.append(st[i]);
        return sb.toString();
    }

    private String getSpaces(int count) {
            StringBuilder sb = new StringBuilder();
            while(count > 0) {
                count--;
                sb.append(" ");
            }
            return sb.toString();
    }
}