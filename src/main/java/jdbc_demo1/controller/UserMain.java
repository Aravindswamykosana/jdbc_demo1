package jdbc_demo1.controller;

import java.sql.SQLException;
import java.util.Scanner;

import jdbc_demo1.dao.UserCrud;
import jdbc_demo1.dto.User;

public class UserMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserCrud crud=new UserCrud();
		Scanner sc=new Scanner(System.in);
		boolean b=true;
		do {
			System.out.println("1:insert\n2:update\n3:exit");
			System.out.println("enter the option:");
			int opt=sc.nextInt();
			switch(opt) {
			case 1:
				System.out.println("enter the id:");
				int id=sc.nextInt();
				System.out.println("enter the name:");
				String name=sc.next();
				System.out.println("enter the phone:");
				long ph=sc.nextLong();
				System.out.println("enter the email:");
				String email=sc.next();
				System.out.println("enter the pwd:");
				String pwd=sc.next();
				User u=new User(id,name,ph,email,pwd);
				crud.saveData(u);
				crud.fetchUser(ph, email);
				System.out.println("data inserted..");
				break;
			case 2:
				System.out.println("enter the name:");
				String name1=sc.next();
				System.out.println("enter the pwd:");
				String pwd1=sc.next();
				System.out.println("enter the phone:");
				long ph1=sc.nextLong();
				System.out.println("enter the email:");
				String email1=sc.next();
				User u1=new User(name1,pwd1,ph1,email1);
				crud.updateUser(u1);
				crud.fetchUser(ph1,email1);
				System.out.println("data updated....!");
				break;
			case 3:
				b=false;
				System.out.println("Tnx for using.....!");
				break;
			}
		}while(b);
	}
}
