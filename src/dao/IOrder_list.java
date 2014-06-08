package dao;

import java.util.List;
import bean.Order_list;

public interface IOrder_list {

	// 增
	public long addOrder_list(Order_list order_list);

	// 删
	public boolean deleteOrder_list(long Order_ID);

	// 改
	public boolean updateOrder_list(long Order_ID);

	// 查
	public Order_list getOrder_list(long Order_ID);
	

	// 某个餐馆的所有订单列表
	public List<Order_list> getRestaurant_Order_lists(int Rest_ID);

	// 某个顾客的所有订单列表
	public List<Order_list> getCustom_Order_lists(int custom_ID);

	// 订单列表----------热门餐馆(订单多少)
	public List<Order_list> getOrder_lists();
}
