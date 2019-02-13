package entity;

public class Food {
	
	private int id;
	private String name;
	private int calories;
	private String category;
	
	public Food(int id, String name, int calories, String category) {
		this.id = id;
		this.name = name;
		this.calories = calories;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Id: " + id + " - Name: " + name + " - Calories: " + calories + " - Category: " + category;
	}
 }
