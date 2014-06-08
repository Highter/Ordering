package dao;

import java.util.List;

import bean.Order_item;

public interface IOrder_item {

	// 增
	public boolean addOrder_item(Order_item order_item);

	// 删
	public boolean deleteOrder_item(int item_ID);

	// 改
	public boolean updateOrder_item(int item_ID);

	// 查
	public Order_item getOrder_item(int item_ID);

	// 某个订单的所有订单明细表
	public List<Order_item> getOrder_list_Order_items(int Order_ID);

	// 某菜品的所有订单明细表
	public List<Order_item> getDishMenu_Order_items(int Dish_ID);

	// 所有订单明细表-----------热门菜式
	public List<Order_item> getOrder_items();

}
