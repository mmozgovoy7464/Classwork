package Objects;
import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
public class Bookshelf {
	
	public static void main(String[] args) {
		Person author1 = new Person("Noah", "Webster");
		Person author2 = new Person("Andrew", "Burgess");
		Person author3 = new Person("Philip", "K.", "Dick");
		Book book1 = new Book("Dictionary", 1001, author1);
		Book book2 = new Book("A Clockwork Orange", 749, author2);
		Book book3 = new Book("Do Androids Dream of Electric Sheep?", 500, author3);
		book2.setJacketColor(Color.orange);
		Book book5 = new Book("Minority Report", 589, author3);
		ArrayList<Person> libraryCardHolders = new ArrayList<Person>();
		libraryCardHolders.add(new Person ("Mark", "Mozgovoy"));
		libraryCardHolders.add(new Person ("Kevin", "Ramos"));
		libraryCardHolders.add(new Person ("Maxwell", "Sulavko"));
		libraryCardHolders.add(new Person ("Sing", "Hung", "Wat"));
		ArrayList<Book> shelf = new ArrayList<Book>();
		shelf.add(book1);
		shelf.add(book2);
		shelf.add(book3);
		shelf.add(new Book("The Man in the High Castle", 1234, author3));
		shelf.add(0,book5);
		book1.setDescription(1);
		book3.setDescription(2);
		
		book1.setJacketColor(Color.red);
		book3.setJacketColor(Color.blue);
		shelf.get(3).setJacketColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		book5.setJacketColor(Color.yellow);
		
		Collections.sort(shelf, new Comparator<Book>() {//anonymous inner class.
		    public int compare(Book a, Book b) {

		        //return a.getNumberOfPages() - b.getNumberOfPages();
//		    	String aLast = a.getAuthor().getLastName();
//		    	String bLast = b.getAuthor().getLastName();
//		        return aLast.compareTo(bLast);
		    	return b.getHeight() - a.getHeight();
		    }

		});
		
//		Library lib = new Library(shelf);//use "books" or "shelf" whatever your ArrayList is 
//
//		lib.setSize(new Dimension(500,500));
//
//		lib.setVisible(true);
//
//		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Library lib = new Library(shelf, libraryCardHolders);//use "books" or "shelf" whatever your ArrayList is 

		lib.setSize(new Dimension(500,500));

		lib.setVisible(true);

		lib.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sortByAuthor(true, shelf);
		printAll(shelf);
	}
	
	public static void sortByAuthor(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {//anonymous inner class.
		    public int compare(Book a, Book b) {
		    	String aLast = a.getAuthor().getLastName();
		    	String bLast = b.getAuthor().getLastName();
		    	if(ascending){
		    		return bLast.compareTo(aLast);
		    	}
		        return aLast.compareTo(bLast);
		    	
		    }

		});
	}
	public static void sortByPageNumber(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {//anonymous inner class.
		    public int compare(Book a, Book b) {
		    	if(ascending){
		    		return b.getNumberOfPages() - a.getNumberOfPages();
		    	}
		    	return a.getNumberOfPages() - b.getNumberOfPages();
		    	
		    }

		});
	}
	public static void sortByHeight(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {//anonymous inner class.
		    public int compare(Book a, Book b) {
		    	if(ascending){
		    		return b.getHeight() - a.getHeight();
		    	}
		    	return a.getHeight() - b.getHeight();
		    }

		});
	}
	public static void sortByTitle(final boolean ascending, ArrayList<Book> shelf){
		Collections.sort(shelf, new Comparator<Book>() {//anonymous inner class.
		    public int compare(Book a, Book b) {
		    	String aTitle = a.getTitle();
		    	String bTitle = b.getTitle();
		    	if(ascending){
		    		return bTitle.compareTo(aTitle);
		    	}
		        return aTitle.compareTo(bTitle);
		    	
		    }

		});
	}
	private static void printAll(ArrayList list){
		for(int i = 0; i < list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
	public void hideMethod(){
//		
//		
////		System.out.println(book1);
////		System.out.println(book2);
////		System.out.println(book3);
////		System.out.println(book4);
//		
//		ArrayList<Book> shelf = new ArrayList<Book>();
//		/**
//		*	<Book> or <?> is a generic type. It tells the constructor 
//		*	what is in the ArrayList. We use generics to save ourselves the trouble of type-casting.
//		*	new ArrayList<?>()
//		*	default length is 10, but it does not matter, it adjusts the length as you add or subtract objects to it.
//		*	NOTE: ArrayList is indexed. (Item 0 is always at index 0, etc...) Because it is indexed, you can iterate through it.
//		*	You cannot make an ArrayList of primitives. (no int, boolean etc...)
//		*	If you wish to make an ArrayList of ints, use the wrapper class.
//		*	int is Integer, double is Double, etc...
//		*/
//		//adding stuff to ArrayList. (remember, for arrays, we did array[0]=book1;)
//		shelf.add(book1);//this does not specify index. Book1 is automatically index 0.
//		shelf.add(book2);
//		shelf.add(book3);
//		shelf.add(new Book("The Man in the High Castle", 1234, author3));
//		
//		//to get something from an ArrayList. (recall something from array System.out.println(array[0]))
//		//System.out.println("The first book on the shelf is " + shelf.get(0));//LOSE POINTS IF YOU DO THIS WRONG.
//		
//		//iterate through an ArrayList.
////		for(Book b:shelf){
////			System.out.println(b);
////		}
//		System.out.println("");
//		//adding objects at specified indices.
//		Book book5 = new Book("Minority Report", 589, author3);
//		shelf.add(0, book5);
//		//shelf.remove(book1);
//		//task: remove all books with the word "The" in the title.
////		for(int i = 0; i < shelf.size(); i++){
////			while(i<shelf.size() && shelf.get(i).getTitle().indexOf("The") > -1){
////				shelf.remove(i);
////			}
////		}
//		ArrayList<Book> creepyBooks = new ArrayList<Book>();
//		for(int i =0; i < shelf.size(); i++){
//			if(shelf.get(i).getAuthor().toString().equals("Philip K. Dick")){
//				creepyBooks.add(shelf.get(i));
//				shelf.get(i).setOnFire();
//			}
//		}
//		//to get the length of Arraylist, we call arraylist.size();
//		//standard for loop that does the same thing.
//		for(int i = 0; i < shelf.size(); i++){
//			System.out.println(shelf.get(i));
//		}
//		
//		//identify whether or not an object is in the list.
//		//getting index of an object.
//		if(shelf.contains(book2)){
//			System.out.println(book2.getTitle() + " is book #" + (shelf.indexOf(book2)+1) + " on the shelf.");
//		}
//		book2.setJacketColor(Color.orange);
//		book3.setOnFire();
//		System.out.println("");
//		printAll(creepyBooks);
//		System.out.println("");
//		printAll(shelf);
//	}
//	
//	private static void printAll(ArrayList list){
//		for(int i = 0; i < list.size(); i++){
//			System.out.println(list.get(i));
//		}
//	}
	}
}