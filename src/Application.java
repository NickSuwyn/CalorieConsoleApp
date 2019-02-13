import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.FoodDao;
import entity.Food;

public class Application {
	
	static FoodDao foodDao = new FoodDao();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = "";
		while (!input.equals("exit")) {
			input = scanner.nextLine();
			
			try {
				if (input.equals("get")) {
					List<Food> foods = foodDao.getFood();
					for (Food food : foods) {
						System.out.println(food);
					}
				} else if (input.equals("create")) {
					System.out.print("Enter the name, calories, and category: ");
					String secondaryInput = scanner.nextLine();
					String[] splitInput = secondaryInput.split(" ");
					Food food = new Food(0, splitInput[0], Integer.parseInt(splitInput[1]), splitInput[2]);
					System.out.println(foodDao.createFood(food));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

}
