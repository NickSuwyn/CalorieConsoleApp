package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Food;

public class FoodDao {
	
	private final String GET_FOOD = "SELECT * FROM foods";
	private final String CREATE_FOOD = "INSERT INTO foods(name, calories, category) VALUES (?, ?, ?)";
	Connection connection = ConnectionHandler.getConnection();
	
	public List<Food> getFood() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_FOOD);
		ResultSet rs = ps.executeQuery();
		List<Food> foods = new ArrayList<Food>();
		
		while(rs.next()) {
			foods.add(new Food(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
		}
		
		return foods;
	}
	
	public Food createFood(Food food) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_FOOD, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, food.getName());
		ps.setInt(2, food.getCalories());
		ps.setString(3, food.getCategory());
		ps.executeUpdate();
		
		ResultSet resultSet = ps.getGeneratedKeys();
		int id = 0;
		if (resultSet.next()) {
			id = resultSet.getInt(1);
		}
		
		food.setId(id);
		return food;
	}

}
