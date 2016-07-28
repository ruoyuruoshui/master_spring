package master_spring.chapter_3;

public class LECar {
	private String brand;
	private String color;
	private int maxSpeed;
	
	public LECar(){}
	
	public LECar(String brand, String color, int maxSpeed) {
		this.brand = brand;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	public String introduce() {
		return "Brand:" + brand + " Color:" + color + " MaxSpeed:" + maxSpeed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
}
