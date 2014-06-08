package bean;

public class ShoppingCar {
	

	@Override
	public String toString() {
		return "ShoppingCar [dishId=" + dishId + ", dishName=" + dishName
				+ ", price=" + price + ", restName=" + restName + ", count="
				+ count + ", photo=" + photo + ", remark=" + remark + "]";
	}
	private int dishId;
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	private String dishName;
	private int price;
	private String restName;
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	private String photo;
	private String remark;
	public ShoppingCar() {
		super();
	}
	public ShoppingCar(String dishName, int price, String restName,
			String photo, String remark) {
		super();
		this.dishName = dishName;
		this.price = price;
		this.restName = restName;
		this.photo = photo;
		this.remark = remark;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
