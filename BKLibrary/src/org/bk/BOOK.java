package org.bk;
import java.io.Serializable;
import java.util.Date;
public class BOOK implements Serializable
{
private String isbn,title,author,publisher;
private float price;
private Long date;
public BOOK(String isbn, String title, String author, String publisher, float price, Long date) {
	super();
	this.isbn = isbn;
	this.title = title;
	this.author = author;
	this.publisher = publisher;
	this.price = price;
	this.date = date;
}
public BOOK() {
	super();
	// TODO Auto-generated constructor stub
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public Long getDate() {
	return date;
}
public void setDate(Long date) {
	this.date = date;
}
public void prtBK()
{
	String fmt="%-20s%-15s%-20s%-16s%-4.2f\t\t\t%5d\n";
	System.out.printf(fmt,this.title,
			this.author,this.publisher,this.isbn,this.price,this.date);
}
}
