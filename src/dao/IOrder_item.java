package dao;

import java.util.List;

import bean.Order_item;

public interface IOrder_item {

	// ��
	public boolean addOrder_item(Order_item order_item);

	// ɾ
	public boolean deleteOrder_item(int item_ID);

	// ��
	public boolean updateOrder_item(int item_ID);

	// ��
	public Order_item getOrder_item(int item_ID);

	// ĳ�����������ж�����ϸ��
	public List<Order_item> getOrder_list_Order_items(int Order_ID);

	// ĳ��Ʒ�����ж�����ϸ��
	public List<Order_item> getDishMenu_Order_items(int Dish_ID);

	// ���ж�����ϸ��-----------���Ų�ʽ
	public List<Order_item> getOrder_items();

}
