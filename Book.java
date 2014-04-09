/*
 * EXERCISE 1.11 Book and Author Classes Again - An Array of Objects as an Instance Variable
 * In the earlier exercise, a book is written by one and only one author. In reality, a book can be written by one or more author.
 * Modify the Book class to support one or more authors by changing the instance variable authors to an Author array.
 * Reuse the Author class written earlier.
Notes:
The constructors take an array of Author (i.e., Author[]), instead of an Author instance.
The toString() method shall return "book-name by n authors", where n is the number of authors.
A new method printAuthors() to print the names of all the authors.
You are required to:
Write the code for the Book class. You shall re-use the Author class written earlier.
Write a test program (called TestBook) to test the Book class.
 */

/*
 * EXERCISE 1.12
 * In the above exercise, the number of authors cannot be changed once a Book instance is constructed.
 * Suppose that we wish to allow the user to add more authors (which is really unusual but presented here for academic purpose).
We shall remove the authors from the constructors, and add a new method called addAuthor() to add the given Author instance to this Book.
We also need to pre-allocate an Author array, with a fixed length (says 5 - a book is written by 1 to 5 authors),
and use another instance variable numAuthors (int) to keep track of the actual number of authors.
You are required to:
Modify your Book class to support this new requirement.
 */

package exercise10;
import exercise10.Author;

public class Book {
	String name;
	private Author[] authors = new Author[5];
	private int numAuthors = 0;
	double price;
	int qtyInStock;
	
	public Book (String name, double price) {
		this.name = name;
		this.price = price;
	}
	public Book (String name, double price, int qtyInStock) {
		this.name = name;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}
	
	// exercise 12 addition below
	
	public void addAuthor(Author author) {
	      authors[numAuthors] = author;
	      ++numAuthors;
	 }
	
	// exercise 12 addition below
	public boolean removeAuthorByName(String authorName) {
		for(int i = 0;i<numAuthors;++i) {
			if(this.getAuthors()[i].getName() == authorName) {
				this.getAuthors()[i] = null;
				--numAuthors;
				return true;
			}
		}
		return false;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Author[] getAuthors() {
		return this.authors;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double newPrice) {
		this.price = newPrice;
		return;
	}
	
	public int getQtyInStock() {
		return this.qtyInStock;
	}
	
	public void setQtyInStock(int qty) {
		this.qtyInStock = qty;
	}
	
	public String toString() {
		String ret = "'" + this.name + "' by " + authors.length + " author(s)";
		return ret;
	}
	
	public void comma() {
		System.out.print(", ");
	}
	
	public void printAuthors() {
		for(int i = 0;i<this.getAuthors().length - 1;++i) {
			if(this.getAuthors()[i] != null) {
				System.out.print(this.getAuthors()[i]);
				if(this.getAuthors()[i + 1] != null) {
					comma();
				}
			} else {
				System.out.print("");
			}
		}
		if(this.getAuthors()[this.getAuthors().length -1] != null) {
			System.out.print(this.getAuthors()[this.getAuthors().length -1]);
		} else {
			System.out.print("");
		}
	}
	
}
