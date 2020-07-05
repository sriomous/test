package org.bk;
import java.util.*;
import java.io.*;
public class BKStore {
private Vector books = new Vector();
private final String fileName="mydata.data";
public void prt(String message)
{
	System.out.println(message);
}
public void menuInfo()
{
	int i;
	StringBuffer buf = new StringBuffer();
	for(i=0;i<60;i++)buf.append('*');
	prt(buf.toString()+"\n");
	prt("1 Print Listings\n");
	prt("2 Add a Book\n");
	prt("3 Search a Book\n");
	prt("4 Delete a Book\n");
	prt("5 Save Data\n");
	prt("6 Load Local Data\n");
	prt("7 Quit\n");
	prt("Please enter a choice=>\n");
	prt(buf.toString()+"\n\n\n");
}
public void menu()
{
	int op;
	Scanner ops=new Scanner(System.in);
	this.menuInfo();
	while(true)
	{
		op=ops.nextInt();
		if(op==7) 
		{
			prt("Good Bye\n");break;
		}
		switch(op)
		{
		case 1:this.prtListings();break;
		case 2:this.addNewBook();break;
		case 3:this.searchABook();break;
		case 4:this.deleteABook();break;
		case 5:this.save(this.fileName);break;
		case 6:this.loadData(this.fileName);break;
		case 7:break;
		}
		this.menuInfo();
	}
	
}
//Add a new book
public void addNewBook()
{
	String tit,aut,pub,isbn;
	float px;
	Date dt;
	long dtx;
	Scanner input = new Scanner(System.in);
	prt("Enter title\n");
	tit=input.nextLine();
	prt("Enter author\n");
	aut=input.nextLine();
	prt("Enter publisher\n");
	pub=input.nextLine();
	prt("Enter isbn\n");
	isbn=input.nextLine();
	prt("Enter price\n");
	px=input.nextFloat();
	prt("Enter Date Like 20000120\n");
	dtx = input.nextInt();
	BOOK bk = new BOOK(isbn,tit,aut,pub,px,dtx);
	this.books.add(bk);
}
public void prtListings()
{
	Iterator ptr=this.books.iterator();
	while(ptr.hasNext())
	{
		BOOK bk = (BOOK)ptr.next();
		bk.prtBK();
	}
}
//Save data
public void save(String fileName)
{
	try
	{
		FileOutputStream fos = new FileOutputStream(fileName,false);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this.books);
		oos.flush();
		fos.close();
		oos.close();
		
	}catch(Exception ex){ex.printStackTrace();}
}
//Load old data from the data file
public void loadData(String fileName)
{
	try
	{
		FileInputStream fos = new FileInputStream(fileName);
		ObjectInputStream oos = new ObjectInputStream(fos);
		Vector oldData=(Vector)oos.readObject();
		Iterator ptr=oldData.iterator();
		while(ptr.hasNext())
		{
			BOOK bk = (BOOK)ptr.next();
			this.books.add(bk);
		}
		
		fos.close();
		oos.close();
		
	}catch(Exception ex){ex.printStackTrace();}
}
//Search a book
public void searchABook()
{
	String isbn;
	boolean isFound=false;
	Scanner input = new Scanner(System.in);
	prt("Enter isbn:\n");
	isbn=input.nextLine();
	Iterator ptr = this.books.iterator();
	while(ptr.hasNext())
	{
		BOOK bk=(BOOK)ptr.next();
		if(bk.getIsbn().equalsIgnoreCase(isbn))
		{
			prt("Found:\n");
			bk.prtBK();
			isFound=true;
			break;
		}
	}
	if(!isFound)prt("Not found\n");
}
//Delete a book
public void deleteABook()
{
	String isbn;
	boolean isFound=false;
	Scanner input = new Scanner(System.in);
	prt("Enter isbn:\n");
	isbn=input.nextLine();
	Iterator ptr = this.books.iterator();
	while(ptr.hasNext())
	{
		BOOK bk=(BOOK)ptr.next();
		if(bk.getIsbn().equalsIgnoreCase(isbn))
		{
			prt("Deletd:\n");
			bk.prtBK();
			isFound=true;
			this.books.remove(bk);
			break;
		}
	}
	if(!isFound)prt("Not found\n");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to use the library management system!");
		new BKStore().menu();
	}

}
