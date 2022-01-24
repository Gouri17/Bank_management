import java.io.*;
import java.util.Scanner;
import java.io.*;
 class Bank_account
{
String cname;
long  cid;
String cadd;
long cpno;
double amt,bal=0;
public void  create_account()
{
try
{
FileWriter f1=new FileWriter("file.txt",true);
Scanner a=new Scanner(System.in);
System.out.println(" \n***************************************ACCOUNT ENTRY*************************************\n");
Scanner in=new Scanner(System.in);
System.out.println("\n Enter account number:-");
cid=in.nextLong();
f1.write(" "+cid);
System.out.println("\n Enter customer name:-");
cname=in.next();
f1.write(" "+cname);
System.out.println("\n Enter customer address:-");
cadd=in.next();
f1.write(" "+cadd);
System.out.println("\n Enter customer mobile number:-");
cpno=in.nextInt(); 
f1.write(" "+cpno);
System.out.println("\nAccount Created Successfully.........");
f1.close();
}
catch(IOException e)
{}
}
public void search()throws IOException
{
 /*long sno;
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter account no to search:-");
 sno=sc.nextLong();
 if(cid==sno)
{
 System.out.println("Record Found....");
 show_details();
}
else
{
  System.out.println("Record not found......");
}
}*/
Scanner scanned=new Scanner(System.in);
System.out.println("Enter number to search ");
int cid=scanned.nextInt();
Scanner scannedFile=new Scanner("file.txt");
while(scannedFile.hasNext())
{
int search=scannedFile.nextInt();
if(search==cid)
{
System.out.println("found"+search);
}
else
{
System.out.println("record not found");
}
}
}
public void show_details()
{
System.out.println("**************************************ACCOUNT DETAILS***************************************\n");
try
{
FileReader f1=new FileReader("file.txt");
BufferedReader br=new BufferedReader(f1);
String s1;
//System.out.println("Customer Id\t Customer Name\tCustomer Address\tCustomer Mobile No.\tBalance");
while((s1=br.readLine())!=null)
{
System.out.print(" "+s1);
}
f1.close();
}
catch(IOException e)
{
}
}
/*int size;
try
{
InputStream f=new FileInputStream("file.txt");
size=f.available();
for(int i=0;i<size;i++)
{
 System.out.print((char)f.read());
}
f.close();
}
catch(IOException e)
{
}
}*/
}
 class Transcation extends Bank_account
{
double amt,withdraw_amt;
Scanner sc=new Scanner(System.in);
public void deposite()
{
try
{
FileWriter f1=new FileWriter("file.txt",true);
 System.out.println("Enter amount you want to deposti:-");
 amt=sc.nextDouble();
 bal=bal+amt;
  f1.write("\n"+bal);
 System.out.println("Successfully deposited :-"+amt+"RS");
f1.close();
}
catch(IOException e)
{
}
}
public void withdraw()
{
try
{
FileWriter f1=new FileWriter("file.txt",true);
 System.out.println("Enter amount you want to withdraw:-");
withdraw_amt=sc.nextDouble();
if(withdraw_amt>bal)
{
System.out.println("No enough money to withdraw......");
System.out.println("Enter enough amount of money to withdraw:- ");
}
else
{
bal=bal-withdraw_amt;
f1.write("\n"+bal);
 System.out.println("Successfully withdrawn:-"+withdraw_amt+"RS");
}
f1.close();
}
catch(IOException e)
{
}
}
}
class java_pro
{
public static void main(String args[]) 
{
int i=1,ch;
Transcation T=new Transcation();
Scanner sc=new Scanner(System.in);
do
{
System.out.println("\n*****************************************MENU*********************************************************\n");
System.out.println("1.Create New Account");
System.out.println("2.Show Details");
System.out.println("3.Search record");
System.out.println("4.Deposite ");
System.out.println("5.Withdraw");
System.out.println("6.Exit");
System.out.println("Enter Your choice...");
ch=sc.nextInt();
switch(ch)
{
case 1:
       T.create_account();
       break;
case 2:
       T.show_details();
       break;
case 3:
       T.search();
       break;
case 4:
       T.deposite();
       break;
case 5:
       T.withdraw();
       break;
case 6:
      System.exit(0);
      break;
default:
       System.out.println("invalid choice....");
}
i++;
}while(i<10);
}
}