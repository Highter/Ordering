/*订单明细表(*/
package bean;

import java.io.Serializable;

public class Order_item implements Serializable {

	private int item_ID; // bigInt 自动生成的代码 Primary key
	private Long order_ID; // Varchar 20 所属订单号 Not null
	private int Dish_ID; // BigInt 菜品ID一道菜 Not null
	private int Dish_number; // Int 菜品数量

	
	public Order_item(Long order_ID, int dish_ID, int dish_number) {
		super();
		this.order_ID = order_ID;
		Dish_ID = dish_ID;
		Dish_number = dish_number;
	}

	public Order_item(int item_ID, Long order_ID, int dish_ID, int dish_number) {
		super();
		this.item_ID = item_ID;
		this.order_ID = order_ID;
		Dish_ID = dish_ID;
		Dish_number = dish_number;
	}

	public Order_item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getItem_ID() {
		return item_ID;
	}

	public void setItem_ID(int item_ID) {
		this.item_ID = item_ID;
	}

	public Long getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(Long i) {
		this.order_ID = i;
	}

	public int getDish_ID() {
		return Dish_ID;
	}

	public void setDish_ID(int dish_ID) {
		Dish_ID = dish_ID;
	}

	public int getDish_number() {
		return Dish_number;
	}

	public void setDish_number(int dish_number) {
		Dish_number = dish_number;
	}

	@Override
	public String toString() {
		return "Order_item [item_ID=" + item_ID + ", order_ID=" + order_ID
				+ ", Dish_ID=" + Dish_ID + ", Dish_number=" + Dish_number + "]";
	}

}
