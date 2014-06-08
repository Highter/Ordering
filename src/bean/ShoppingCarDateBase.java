package bean;

public class ShoppingCarDateBase {
	private long id;
	private int Custom_id;
	private ShoppingCar Custom_car;
	public int getCustom_id() {
		return Custom_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setCustom_id(int custom_id) {
		Custom_id = custom_id;
	}
	public ShoppingCar getCustom_car() {
		return Custom_car;
	}
	public void setCustom_car(ShoppingCar custom_car) {
		Custom_car = custom_car;
	}
	public ShoppingCarDateBase() {
		super();
	}
	@Override
	public String toString() {
		return "ShoppingCarDateBase [id=" + id + ", Custom_id=" + Custom_id
				+ ", Custom_car=" + Custom_car + "]";
	}


}
