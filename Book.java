/*
 * EXERCISE 1.11 Book and Author Classes Again - An Array of Objects as an Instance Variable
 * In the earlier exercise, a book is written by one and only one author. In reality, a book can be written by one or more author.
 * Modify the Book class to support one or more authors by changing the instance variable authors to an Author array. Reuse the Author class written earlier.
Notes:
The constructors take an array of Author (i.e., Author[]), instead of an Author instance.
The toString() method shall return "book-name by n authors", where n is the number of authors.
A new method printAuthors() to print the names of all the authors.
You are required to:
Write the code for the Book class. You shall re-use the Author class written earlier.
Write a test program (called TestBook) to test the Book class.

EXERCISE 1.12
In the above exercise, the number of authors cannot be changed once a Book instance is constructed. Suppose that we wish to allow the user to add more authors (which is really unusual but presented here for academic purpose).
We shall remove the authors from the constructors, and add a new method called addAuthor() to add the given Author instance to this Book.
We also need to pre-allocate an Author array, with a fixed length (says 5 - a book is written by 1 to 5 authors), and use another instance variable numAuthors (int) to keep track of the actual number of authors.
You are required to:
Modify your Book class to support this new requirement.
Try writing a method called removeAuthorByName(authorName), that remove the author from this Book instance if authorName is present. The method shall return true if it succeeds.

 */

package exercise10;
import ex1.Author;

public class Book {
	private String name;
	private Author[] author = new Author[5];
	private int numAuthors = 0;
	double price;
	int qtyInStock;
	
	public Book (String name, Author[] author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public Book (String name, Author[] author, double price, int qtyInStock) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public Author[] getAuthors() {
		return this.author;
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
		String ret = "'" + this.name + "' by " + author.length + " author(s)";
		return ret;
	}
	
	public void addAuthor(Author author) {
	      this.getAuthors()[numAuthors] = author;
	      ++numAuthors;
	   }
	
	public void printAuthors() {
		for(int i = 0;i<this.getAuthors().length - 1;++i) {
			System.out.print(this.getAuthors()[i] + ", ");
		}
		System.out.print(this.getAuthors()[this.getAuthors().length - 1]);
	}
	
}
