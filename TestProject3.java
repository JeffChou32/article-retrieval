package articles;
import java.io.*;
import java.util.Scanner;

public class TestProject3 {

    BufferedReader reader;
    HashTableBuilder table;
    Scanner input = new Scanner(System.in);
    
	public static void main(String[] args) {
		TestProject3 test = new TestProject3("datafile.txt");
		test.menu();
	}
	
	public TestProject3(String filename) {
	    try {
	        reader = new BufferedReader(new FileReader(filename));
	        int tableSize = getKeywordsCount();
	        table = new HashTableBuilder(tableSize);
	        reader = new BufferedReader(new FileReader(filename));
	        while (readFileContents());
	    }
	    catch(IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public boolean readFileContents() {
	    if (reader == null) {
	        System.out.println("Error: You  must open the file first.");
	        return false;
	    }
	    else {
	        try {
	            String data = reader.readLine();
	            if (data == null) return false;
	            int id = Integer.parseInt(data);
	            String title = reader.readLine();
	            String author = reader.readLine();
	            
	            Article article = new Article(id, title, author);
	            
	            String keyword;
	            int numKeys = Integer.parseInt(reader.readLine());
	            for (int i=0; i<numKeys; i++) {
	                keyword = reader.readLine();
	                table.insert(keyword, article);
	            }
	            reader.readLine();
	        }
	        catch(NumberFormatException e) {
	            System.out.println("Error: Number is expected!");
	            return false;
	        }
	        catch(Exception e) {
	            System.out.println("Error: Fatal error has occured: " + e);
	            return false;
	        }
	    }
	    return true;
	}
	
	private int getKeywordsCount() {
	    int keyCount = 0;
	    if (reader == null) {
	        System.out.println("Error: You  must open the file first.");
	        return keyCount;
	    }
	    while (true) {
	        try {
	            String data;
	            data = reader.readLine();
	            if (data == null) break;
	            reader.readLine();
	            reader.readLine();
	            int numKeys = Integer.parseInt(reader.readLine());
	            keyCount += numKeys;
	            for (int i=0; i<numKeys; i++)
	                reader.readLine();
	            reader.readLine();
	        }
	        catch(NumberFormatException e) {
	            e.printStackTrace();
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	    return keyCount;
	}
	
	private void menu() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Print the entire hash table");
            System.out.println("2. Search for a key");
            System.out.println("3. Exit");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    printHashTable();
                    break;
                case "2":
                    searchKeyword();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    private void printHashTable() {
        for (int i = 0; i < table.tableSize; i++) {
            if (table.hashTable[i] != null) {
                System.out.println(table.hashTable[i].keyword + "\n" + table.hashTable[i].list);
            }
        }
    }
    
    private void searchKeyword() {
        System.out.print("Enter keyword to search: ");
        String keyword = input.nextLine();
        boolean found = table.search(keyword);
        
        if (found) {
            int index = table.getIndex(keyword);
            System.out.println(table.hashTable[index].keyword + "\n" + table.hashTable[index].list);
        }
        else
            System.out.println("Keyword not found.");
    }
}
