package articles;
class HashTableBuilder {
    Element [] hashTable;
    int tableSize;
    
    public HashTableBuilder(int numKeyWords) {
        tableSize = nextPrime(numKeyWords * 2);
        hashTable = new Element[tableSize];
    }
    
    void insert(String keyword, Article articleRecord) {
        int index = getNextQuadProbeIndex(keyword);
        if (hashTable[index] == null) {
            hashTable[index] = new Element(keyword);
        } 
        hashTable[index].list.addFirst(articleRecord);
    }
    
    private int getNextQuadProbeIndex(String keyword) {
        int probe = 1;
        int key = convertStringToInt(keyword);
        int index = key % tableSize;
        while (hashTable[index] != null && !hashTable[index].keyword.equals(keyword)) {
            System.out.printf("%s conflicts with %s at index: %d\n", keyword, hashTable[index].keyword, index);
            index = ((key % tableSize) + (int) Math.pow(probe++, 2)) % tableSize;
        }
        return index; 
    }
    
    private int convertStringToInt(String keyword) {
        int sum = 0;
        for (int i=0; i < keyword.length(); i++)
            sum += (int) keyword.charAt(i);
        return sum;
    }
    
    private int nextPrime(int num) {
        num++;
        for (int i=2; i < num; i++) {
            if (num % i == 0) {
                num++;
                i = 2;
            }
            else 
                continue;
        }
        return num;
    }
    
    public boolean search(String keyword) {
        int probe = 1;
        int key = convertStringToInt(keyword);
        int index = key % tableSize;
        while (hashTable[index] != null && !hashTable[index].keyword.equals(keyword)) {
            index = ((key % tableSize) + (int) Math.pow(probe++, 2)) % tableSize;
        }
        if (hashTable[index] != null && hashTable[index].keyword.equals(keyword)) {
            return true;
        }
        return false;
    }
    
    public int getIndex(String keyword) {
        return getNextQuadProbeIndex(keyword);
    }
}