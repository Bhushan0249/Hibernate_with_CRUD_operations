package Hibernate.CRUD;

import java.util.Scanner;

public class CRUD_calling extends CRUD_code {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		while (true) {

			System.out.println("               +--------------------+           ");
			System.out.println("               |  1  INSERT DATA    |           ");
			System.out.println("               |  2  UPDATE DATA    |           ");
			System.out.println("               |  3  READ DATA      |           ");
			System.out.println("               |  4  DELETE DATA    |           ");
			System.out.println("               |  5  view all DATA  |           ");
			System.out.println("               |  0  exit program   |           ");
			System.out.println("               +--------------------+  Devloper by bhushan      ");

			switch (s.nextInt()) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				read();
				break;
			case 4:
				delete();
				break;
			case 5:
				viewAll();
				break;
			case 0:
				Exits();
				s.close();
				return;
			default:
				System.out.println("DEFAULT VALUE PLEASE CHECK THE VALUE..");
			}
		}

	}

}
