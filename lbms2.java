import java.util.Calendar;
import java.util.*;
import java.util.Date;
import java.util.Scanner;
import java.time.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class CV129
{
	static Scanner sc=new Scanner(System.in);
	private String std_name;
	private int std_id;
	private String std_deg;
	private String std_psw;

	static String def = "\u001B[0m";
		static String magneta = "\u001B[35m";
		static String green = "\u001B[32m";
		static String yellow = "\u001B[33m";
		static String red = "\u001B[31m";
		static String skblue = "\u001B[36m";
		static String blink = "\u001B[5m";
		static String blue = "\u001B[34m";

	CV129()
	{
	}
	CV129(String n, int i, String d,String p)
	{
		this.std_name=n;
		this.std_id=i;
		this.std_deg=d;
		this.std_psw=p;
	}
    public String getName()
    {
        return std_name;
    }
    public int getId()
    {
        return std_id;
    }
    public String getDegree()
    {
        return std_deg;
    }
    public String getPassword()
    {
        return std_psw;
    }
	public static void sound2()
	{
		for (int i = 0; i < 1; ++i) {
			java.awt.Toolkit.getDefaultToolkit().beep();
			try {
				Thread.sleep(1000); // introduce delay
			} catch (InterruptedException e) {
			}
		}
	}
	public static void displayStudent(CV129 obj)
	{
		System.out.println();
		System.out.print("\t\t\t\t\t");
		System.out.print(green+"Hi "+obj.getName()+"("+obj.getId()+")"+" from "+obj.getDegree()+def);
		sound2();
		System.out.println();
		System.out.println();
	}

}
class Book
{
	static Scanner sc=new Scanner(System.in);
	static String def = "\u001B[0m";
	static String red = "\u001B[31m";
	
	private int bookNo;
	private String gnere;
	private String book;
	private String author;
	private double price;
    	public boolean isAvailable;
    	public Date issuedDate;
    	public Date returnDate;
	public Book()
	{
	}
	public Book(int n, String g,String b,String a,double p,boolean t ,Date i,Date r)
	{
		this.bookNo=n;
		this.gnere=g;
		this.book=b;
		this.author=a;
		this.price=p;
        	this.isAvailable=t;
       		this.issuedDate=i;
        	this.returnDate=r;
	}
    public int getBookNo()
    {
        return bookNo;
    }
    public String getGnere()
    {
        return gnere;
    }
    public String getBook()
    {
        return book;
    }
    public String getAuthor()
    {
        return author;
    }
    public double getPrice()
    {
        return price;
    }
   
	static void displayBook(Book obj)
	{	
		System.out.print("\t\t\t\t\t ");
		System.out.println(red+obj.getBookNo()+"."+obj.getBook()+" by "+obj.getAuthor()+" for "+obj.getPrice()+"(INR)"+def);
	}
			
}

class LibraryManagementSystem
{
	static Scanner sc = new Scanner(System.in);

		static String def = "\u001B[0m";
		static String purpe = "\u001B[35m";
		static String green = "\u001B[32m";
		static String yellow = "\u001B[33m";
		static String red = "\u001B[31m";
		static String skblue = "\u001B[36m";
		static String blink = "\u001B[5m";
		static String blue = "\u001B[34m";

		//user experience starts form here

		static{
		System.out.print(blink);
		System.out.println();
		System.out.println();
		System.out.println(yellow + "\t\t\t\t\t**************************************************************************************");
		System.out.print(yellow + "\t\t\t\t\t****************************");
		System.out.print(red+" WELCOME TO CVCORP LIBRARY ");
		System.out.print(yellow + " ******************************\n");
		System.out.println(yellow+ "\t\t\t\t\t**************************************************************************************");
		System.out.print(def);
		}

    public static String addDate(int n)
    {
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, n);
        return dateFormat.format(cal.getTime());
    }
    public static void fine(int x,double price){
		if(x>15){
			x=x-15;
			double cost=x+(price/10);
			System.out.println(yellow  "\t\t\t\t\t The cost of the Return : "+def+red+cost+"(INR)"+def+"\n\n");
			
		}
		System.out.println(green + "\t\t\t\t\t**********Thanks for Returning**********"+def);
		sound();
	}
	public static void m1(Book obj){
		if(obj.isAvailable)
                {
                	obj.isAvailable=false;
                        Date today=new Date();
                        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/YYYY");
                        System.out.println();
                        System.out.println(green + "\t\t\t\t\t You have Issued "+obj.getBook()+" on "+ dateForm.format(today)+" Return before "+addDate(15)+def);
			sound();
                }
                else
		{
			System.out.println("\n");
                        System.out.println(red + "\t\t\t\t\t Sorry!!! The book is Not Available Right Now."+def);
		}
        }
	public static void sound()
	{
		
		for (int i = 0; i < 1; ++i) {
			java.awt.Toolkit.getDefaultToolkit().beep();
			try {
				Thread.sleep(1000); // introduce delay
			} catch (InterruptedException e) {
			}
		}
	}
	
	public static void returnThisBook(Book obj){
		System.out.println();
		System.out.print(yellow + "\t\t\t\t\t How many Days From Issued Date : "+def);
                int x=sc.nextInt();
                System.out.println();
                fine(x,obj.getPrice());
	}
	public static void selectBook(Book obj){
		System.out.println();
                System.out.println(green + "\t\t\t\t\t You selected-" +obj.getBook()+def);
		sound();
                System.out.print(skblue + "\n");
		boolean j=true;
		while(j){
                System.out.println(" \t\t\t\t\t 1.Take this Book");
                System.out.println(" \t\t\t\t\t 2.Return this Book \n"+def);
                System.out.print("\t\t\t\t\t");
						
                int e=sc.nextInt();
                switch(e)
                {
                      case 1:m1(obj);
				j=false;
				break;
                      case 2:returnThisBook(obj);
				j=false;
                                break;
		      default:System.out.println(red + "\t\t\t\t\t Invalid Input"+def);
				continue;
                 }}
	}
	public static void StudentDetails(CV129 st){
		Book B=new Book();
        	Book bb1 = new Book(1, "Biography", "Steve Jobs: The Exclusive Biography", "Steve Jobs", 438.0,true,null,null);
		Book bb2 = new Book(2, "Biography", "Einstein: His Life and Universe", "Walter Isaacson", 440.0,true,null,null);
		Book bb3 = new Book(3, "Biography", "A Century Is Not Enough", "Sourav Ganguly, Gautam Bhattacharya", 525.0,true,null,null);
		Book bb4 = new Book(4, "Biography", "Becoming", "Michelle Obama", 518.0,true,null,null);
		Book bb5 = new Book(5, "Biography", "Ratan N. Tata: A Life", "Dr. Thomas Mathew", 1499.0,true,null,null);
		Book bb6 = new Book(6, "Biography", "The Real Yogi", "Gana", 499.0,true,null,null);
		Book bb7 = new Book(7, "Biography", "The Immortal Life of Henrietta Lacks", "Rebecca Skloot", 422.0,true,null,null);
		Book bb8 = new Book(8, "Biography", "Team of Rivals: The Political Genius of Abraham Lincoln", "Doris Kearns Goodwin", 497.0,true,null,null);
		Book bb9 = new Book(9, "Biography", "Napoleon: A Life", "Andrew Roberts", 2483.0,true,null,null);
		Book bb10 = new Book(10, "Biography", "The Life of Mahatma Gandhi", "Louis Fischer", 380.0,true,null,null);

		Book bf1=new Book(1, "Fiction", "Crime And Punishment", "Fyodor Dostoyevsky", 279.0,true,null,null);
		Book bf2=new Book(2, "Fiction", "Silent Parade", "Keigo", 419.0,true,null,null);
		Book bf3=new Book(3, "Fiction", "The Picture of Dorian Gray", "Oscar Wilde", 299.0,true,null,null);
		Book bf4=new Book(4, "Fiction", "As Good As Dead", "Holly Jackson", 399.0,true,null,null);
		Book bf5=new Book(5, "Fiction", "A Thousand Kisses Deep", "Novoneel Chakraborty", 199.0,true,null,null);
		Book bf6=new Book(6, "Fiction", "Heart On The Edge", "Novoneel Chakraborty", 189.0,true,null,null);
		Book bf7=new Book(7, "Fiction", "Angels And Demons", "Dan Brown", 599.0,true,null,null);
		Book bf8=new Book(8, "Fiction", "The Da Vinci Code", "Dan Brown", 389.0,true,null,null);
		Book bf9=new Book(9, "Fiction", "Murder Of Roger Ackroyd", "Agatha Christie", 369.0,true,null,null);
		Book bf10=new Book(10, "Fiction", "The Bullet That Missed", "Richard Osman", 499.0,true,null,null);

		Book bh1 = new Book(1, "History", "Discovery of India", "Jawahar Lal Nehru", 559.0,true,null,null);
		Book bh2 = new Book(2, "History", "Freedom at Midnight", "Dominique Lapierre & Larry Collins", 564.0,true,null,null);
		Book bh3 = new Book(3, "History", "The Argumentative Indian", "Amartya Sen", 509.0,true,null,null);
		Book bh4 = new Book(4, "History", "India after Gandhi", "Ramachandra Guha", 657.0,true,null,null);
		Book bh5 = new Book(5, "History", "The Wonder that was India", "A L Basham", 442.0,true,null,null);
		Book bh6 = new Book(6, "History", "The Last Mughal", "William Dalrymple", 499.89,true,null,null);
		Book bh7 = new Book(7, "History", "From Plassey to Partition and After", "Sekhar Bandhopadhyay", 428.0,true,null,null);
		Book bh8 = new Book(8, "History", "The Great Partition", "Yasmin Khan", 1588.0,true,null,null);
		Book bh9 = new Book(9, "History", "India: A History", "John Keay", 640.0,true,null,null);
		Book bh10 = new Book(10, "History", "Ages of Nandas & Mauryas", "K. A. N. Sastri", 545.0,true,null,null);

		Book bp1 = new Book(1, "Poetry", "ACTUALLY ... I MET THEM: A MEMOIR", "GULZAR", 500.0,true,null,null);
		Book bp2 = new Book(2, "Poetry", "ONE HUNDRED POEMS OF KABIR", "RABINDRANATH TAGORE", 175.0,true,null,null);
		Book bp3 = new Book(3, "Poetry", "LOVE: POEMS, EPIGRAMS & APHORISMS", "ATTICUS", 800.0,true,null,null);
		Book bp4 = new Book(4, "Poetry", "THE TRUTH ABOUT MAGIC", "ATTICUS", 1370.0,true,null,null);
		Book bp5 = new Book(5, "Poetry", "AND STILL I RISE", "MAYA ANGELOU", 800.0,true,null,null);
		Book bp6 = new Book(6, "Poetry", "LEAVES OF GRASS", "WALT WHITMAN", 500.0,true,null,null);
		Book bp7 = new Book(7, "Poetry", "THE LIFE TREE", "A.P.J ABDUL KALAM", 300.0,true,null,null);
		Book bp8 = new Book(8, "Poetry", "SOFT SCIENCE", "FRANNY CHOI", 1300.0,true,null,null);
		Book bp9 = new Book(9, "Poetry", "ROBERT FROST'S", "ROBERT FROST", 600.0,true,null,null);
		Book bp10 = new Book(10, "Poetry", "THE PICTURE BRIDE", "LEE GEUM-YI", 510.0,true,null,null);

        	Book bsd1 = new Book (1,"Self Development","The Secret Garden","Frances Hodgson Burnett",130.0,true,null,null);
        	Book bsd2 = new Book(2,"Self Development","Power of Your Subconscious Mind","Murphy Joseph",145.0,true,null,null);
       		Book bsd3 = new Book(3,"Self Development","Public Speaking for Beginners","Wills Cameron",1558.0,true,null,null);
        	Book bsd4 = new Book(4,"Self Development","Three Men in a Boat","Jerome Jerome",118.0,true,null,null);
        	Book bsd5 = new Book(5,"Self Development","The Origin of Species","Darwin Charles",180.0,true,null,null);
        	Book bsd6 = new Book(6,"Self Development","The Great Gatsby","The Great Gatsby",119.0,true,null,null);
        	Book bsd7 = new Book(7,"Self Development","Thoughts to Inspire","Vivekanand Swami",200.0,true,null,null);
        	Book bsd8 = new Book(8,"Self Development","The Psychology of Money","Housel Morgan",689.0,true,null,null);
        	Book bsd9 = new Book(9,"Self Development","Confessions of a Thug","Taylor Philip Meadows",135.0,true,null,null);
        	Book bsd10 = new Book(10,"Self Development","Atomic Habits","Clear James",184.0,true, null,null);



		System.out.println();
		boolean y=true;
		while(y){
 		System.out.println(yellow + "\t\t\t\t\tEnter password"+def);
		System.out.println();
		System.out.print("\t\t\t\t\t");
		if(st.getPassword().equals(sc.next()))
		{
			    y=false;
			    st.displayStudent(st);
				boolean x=true;
			    System.out.println();
			    while(x){
			    System.out.println(yellow + "\t\t\t\t\t Choose One Option \n" + def);
			    System.out.println(skblue + " \t\t\t\t\t 1.Books list."+def);
        		    System.out.println(red + "\t\t\t\t\t 2.Exit."+def+"\n");
				System.out.print("\t\t\t\t\t");
                            int b=sc.nextInt();
			
                            switch(b)
                            {
                                case 1:
				    boolean z=true;
				    while(z){
                                    System.out.println(yellow + "\n \t\t\t\t\t Select Gnere" +def);
                                    System.out.println();
				    x=false;
				    System.out.print(skblue);
                                    System.out.println("\t\t\t\t\t 1.Biography");
                                    System.out.println("\t\t\t\t\t 2.Fiction");
                                    System.out.println("\t\t\t\t\t 3.History");
                                    System.out.println("\t\t\t\t\t 4.Poetry");
                                    System.out.println("\t\t\t\t\t 5.Self-Development");
					System.out.print(def);
					System.out.print("\n \t\t\t\t\t");
                                    int c=sc.nextInt();
					System.out.println();
                                    switch(c)
                                    {
                                        case 1:
					    z=false;
						boolean e=true;
						while(e){
                                            B.displayBook(bb1);
                                            B.displayBook(bb2);
                                            B.displayBook(bb3);
                                            B.displayBook(bb4);
                                            B.displayBook(bb5);
                                            B.displayBook(bb6);
                                            B.displayBook(bb7);
                                            B.displayBook(bb8);
                                            B.displayBook(bb9);
                                            B.displayBook(bb10);
                                            System.out.println();
                                            System.out.print(yellow + "\n \t\t\t\t\t Select a Book Number \n"+def);
						System.out.print("\n \t\t\t\t\t ");
                                            int d=sc.nextInt();
                                            switch(d)
                                            {
                                                case 1:selectBook(bb1);
                                                    e=false;
                                                    break;
                                                case 2:selectBook(bb2);
                                                     e=false;
                                                    break;
                                                case 3:
                                                    selectBook(bb3);
							 e=false;
							break;
                                                case 4:
                                                    selectBook(bb4);
							 e=false;
                                                    break;
                                                case 5:
                                                    selectBook(bb5);
							 e=false;
                                                    break;
                                                case 6:
                                                    selectBook(bb6);
							 e=false;
                                                    break;
                                                case 7:
                                                    selectBook(bb7);
							 e=false;
                                                    break;
                                                case 8:
                                                    selectBook(bb8);
							 e=false;
                                                    break;
                                                case 9:
                                                    selectBook(bb9);
							 e=false;
                                                    break;
                                                case 10:
                                                    selectBook(bb10);
								 e=false;
                                            		break;
						default:System.out.println(red + "\t\t\t\t\t Invalid Book number"+def);
							continue;
						}}
						break;
                                        case 2:
					    z=false;
						boolean f=true;
						while(f){
                                            B.displayBook(bf1);
                                            B.displayBook(bf2);
                                            B.displayBook(bf3);
                                            B.displayBook(bf4);
                                            B.displayBook(bf5);
                                            B.displayBook(bf6);
                                            B.displayBook(bf7);
                                            B.displayBook(bf8);
                                            B.displayBook(bf9);
                                            B.displayBook(bf10);
                                            System.out.println();
                                            System.out.println(yellow + "\t\t\t\t\t Select a Book Number"+def);
                                            System.out.println();
					    System.out.print("\n \t\t\t\t\t ");
                                            int o=sc.nextInt();
                                            switch(o)
                                            {
                                                case 1:
                                                    selectBook(bf1);
							f=false;
                                                    break;
                                                case 2:
                                                    selectBook(bf2);
							f=false;
                                                    break;
                                                case 3:
                                                    selectBook(bf3);
							f=false;
                                                    break;
                                                case 4:
                                                    selectBook(bf4);
							f=false;
							break;
                                                case 5:
                                                    selectBook(bf5);
							f=false;
                                                    break;
                                                case 6:
                                                    selectBook(bf6);
							f=false;
                                                    break;
                                                case 7:
                                                    selectBook(bf7);
							f=false;
                                                    break;
                                                case 8:
                                                    selectBook(bf8);
							f=false;
                                                    break;
                                                case 9:
                                                    selectBook(bf9);
							f=false;
							break;
                                                case 10:
                                                    selectBook(bf10);
							f=false;
                                           		 break;
						default:System.out.println(red + "\t\t\t\t\t Invalid Book number"+def);
							continue;
						}}break;
                                        case 3:
					    z=false;
						boolean g=true;
							while(g){
                                            B.displayBook(bh1);
                                            B.displayBook(bh2);
                                            B.displayBook(bh3);
                                            B.displayBook(bh4);
                                            B.displayBook(bh5);
                                            B.displayBook(bh6);
                                            B.displayBook(bh7);
                                            B.displayBook(bh8);
                                            B.displayBook(bh9);
                                            B.displayBook(bh10);
                                            System.out.println();
                                            System.out.println(yellow + "\t\t\t\t\t Select a Book Number"+def);
                                            System.out.println();
						System.out.print("\n \t\t\t\t\t ");
                                            int aa=sc.nextInt();
                                            switch(aa)
                                            {
                                                case 1:
                                                    selectBook(bh1);
							g=false;
                                                    break;
                                                case 2:
                                                    selectBook(bh2);
							g=false;
                                                    break;
                                                case 3:
                                                    selectBook(bh3);
							g=false;
                                                    break;
                                                case 4:
                                                    selectBook(bh4);
							g=false;
                                                    break;
                                                case 5:
                                                    selectBook(bh5);
							g=false;
                                                    break;
                                                case 6:
                                                    selectBook(bh6);
							g=false;
                                                    break;
                                                case 7:
                                                    selectBook(bh7);
							g=false;
                                                    break;
                                                case 8:
                                                    selectBook(bh8);
							g=false;
                                                    break;
                                                case 9:
                                             	    selectBook(bh9);
							g=false;
                                                    break;
                                                case 10:
                                                    selectBook(bh10);
							g=false;
                                           		 break;
						default:System.out.println(red + "\t\t\t\t\t Invalid Book number"+def);
							continue;
						}}break;
                                        case 4:
					    z=false;
						boolean h=true;
						while(h){
                                            B.displayBook(bp1);
                                            B.displayBook(bp2);
                                            B.displayBook(bp3);
                                            B.displayBook(bp4);
                                            B.displayBook(bp5);
                                            B.displayBook(bp6);
                                            B.displayBook(bp7);
                                            B.displayBook(bp8);
                                            B.displayBook(bp9);
                                            B.displayBook(bp10);
                                            System.out.println();
                                            System.out.println(yellow + "\t\t\t\t\t Select a Book Number");
                                            System.out.println();
						System.out.print("\n \t\t\t\t\t ");
                                            int al=sc.nextInt();
                                            switch(al)
                                            {
                                                case 1:
                                                   selectBook(bp1);
							h=false;
							break;
                                                case 2:
                                                    selectBook(bp2);
							h=false;
							break;
                                                case 3:
                                                    selectBook(bp3);
							h=false;
							break;
                                                case 4:
                                                    selectBook(bp4);
							h=false;
							break;
                                                case 5:
                                                    selectBook(bp5);
							h=false;
							break;
                                                case 6:
                                                    selectBook(bp6);
							h=false;
							break;
                                                case 7:
                                                    selectBook(bp7);
							h=false;
							break;
                                                case 8:
                                                    selectBook(bp8);
							h=false;
							break;
                                                case 9:
                                                    selectBook(bp9);
							h=false;
							break;
                                                case 10:
                                                    selectBook(bp10);
							h=false;
							break;
						default:System.out.println(red + "\t\t\t\t\t Invalid Book number"+def);
							continue;
						}}break;
                                        case 5:
					    z=false;
						h=true;
						while(h){
                                            B.displayBook(bsd1);
                                            B.displayBook(bsd2);
                                            B.displayBook(bsd3);
                                            B.displayBook(bsd4);
                                            B.displayBook(bsd5);
                                            B.displayBook(bsd6);
                                            B.displayBook(bsd7);
                                            B.displayBook(bsd8);
                                            B.displayBook(bsd9);
                                            B.displayBook(bsd9);
                                            B.displayBook(bsd10);
                                            System.out.println();
                                            System.out.println(yellow + "\t\t\t\t\t Select a Book Number"+def);
                                            System.out.println();
						System.out.print("\n \t\t\t\t\t ");
                                            int aw=sc.nextInt();
                                            switch(aw)
                                            {
                                                case 1:
                                                    selectBook(bsd1);
							h=false;
							break;
                                                case 2:
                                                    selectBook(bsd2);
							h=false;
							break;
                                                case 3:
                                                    selectBook(bsd3);
							h=false;
							break;
                                                case 4:
                                                    selectBook(bsd4);
							h=false;
							break;
                                                case 5:
                                                    selectBook(bsd5);
							h=false;
							break;
                                                case 6:
                                                    selectBook(bsd6);
							h=false;
							break;
                                                case 7:
                                                    selectBook(bsd7);
							h=false;
							break;
                                                case 8:
                                                    selectBook(bsd8);
							h=false;
							break;
                                                case 9:
                                                    selectBook(bsd9);
							h=false;
							break;
                                                case 10:
                                                    selectBook(bsd10);
							h=false;
							break;  
						default:System.out.println(red+ "\t\t\t\t\t Invalid Book number"+def);
							continue;
						} } break;                                

                                        default:System.out.println(red+ "\t\t\t\t\t Invalid Option."+def);
					continue;
					}
                                    }
					System.out.print(yellow);
					System.out.printf("%n%40s Would you like to select another book(Y/N) : ","");
					System.out.print(def);
					System.out.printf("%n%n%40s","");
					char k=sc.next().charAt(0);
					switch(k){
						case 'y':
						case 'Y':x=true;
								break;
						case 'n':
						case 'N':	System.out.printf("%n%n%40s","");
								System.out.println(green+"Bye Bye !!!"+def);
								System.exit(0);
							
					}
					System.out.println();  
					break;
				case 2:System.out.println(green+"\t\t\t\t\t System exiting successfully"+def);
					System.exit(0);
					break;
				default:System.out.println(red + "\t\t\t\t\t Wrong input"+def);   
					continue;                               
                            }}}
			    else{
				System.out.println (red + "\n \t\t\t\t\t Wrong Password Try Another Time !!! \n"+def);
				continue;}}
						
	}
	public static void main (String[] args)
	{
		CV129 CV=new CV129();
		System.out.println(purpe+"\n\n\n\t\t\t\t\tEnter your Name"+def);
		System.out.print("\t\t\t\t\t");
		String Name=sc.next();
		System.out.println(purpe+"\n\n\t\t\t\t\tEnter your id"+def);
		System.out.print("\t\t\t\t\t");
		int Id=sc.nextInt();
		System.out.println(purpe+"\n\n\t\t\t\t\tEnter your Branch"+def);
		System.out.print("\t\t\t\t\t");
		String Branch=sc.next();
		System.out.println(purpe+"\n\n\t\t\t\t\tEnter your Password"+def);
		System.out.print("\t\t\t\t\t");
		String Password=sc.next();
		
		CV129 std=new CV129(Name,Id,Branch,Password);

 		//user experience starts form here
		System.out.print(green);
		System.out.println();
		System.out.println();
			boolean i=true;
			while(i){
		System.out.println("\t\t\t\t\tAre you a student?- Reply with Yes or No as y/n");
		System.out.println("\t\t\t\t\t");
		System.out.print(def);
		System.out.print("\t\t\t\t\t");
		char student = sc.next().charAt(0);                                              

		switch (student) 
		{
 			case 'y':i=false;
				System.out.print(yellow);
				System.out.println();
				boolean t=true;
				while(t){
				System.out.println(" \t\t\t\t\tEnter your Student ID ");
				System.out.println();
				System.out.print(def);
				System.out.print("\t\t\t\t\t");
				int a=sc.nextInt();

				if(a==std.getId()){
					StudentDetails(std);
					t=false;
				}
				else{
					System.out.print("Invalid ID");
					continue;
				}}
				break;
			case 'n':System.out.println();
				System.out.print(red+ "\t\t\t\t\t Sorry!!! Not Accessible."+def+"\n");
				continue;
			default:System.out.println();
				System.out.println(red + " \t\t\t\t\t Invalid entry"+def+"\n");
				continue;
                        
              	}}
		
	}
}