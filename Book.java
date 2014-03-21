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
 */
package exercise10;

public class Book {
	String name;
	Author[] author;
	double price;
	int qtyInStock;
	
	public Book (String name, Author[] author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public Book (String name, Author author, double price, int qtyInStock) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Author getAuthor() {
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
	//problem #2 Introduce new methods called getAuthorName(), getAuthorEmail(), getAuthorGender() in the Book class to return the name, email and gender of the author of the book.

	public String getAuthorName(){
		return this.author.name;
	}
	public String getAuthorEmail(){
		return this.author.email;
	}
	public char getAuthorGender(){
		return this.author.gender;
	}
	
	public String toString() {
		String ret = "'" + this.name + "' by " + author.length + " author(s)";
		return ret;
	}
	
	public void printAuthors() {
		
	}
	
}
