package dao;

import java.util.List;
import bean.Order_list;

public interface IOrder_list {

	// ��
	public long addOrder_list(Order_list order_list);

	// ɾ
	public boolean deleteOrder_list(long Order_ID);

	// ��
	public boolean updateOrder_list(long Order_ID);

	// ��
	public Order_list getOrder_list(long Order_ID);
	

	// ĳ���͹ݵ����ж����б�
	public List<Order_list> getRestaurant_Order_lists(int Rest_ID);

	// ĳ���˿͵����ж����б�
	public List<Order_list> getCustom_Order_lists(int custom_ID);

	// �����б�----------���Ų͹�(��������)
	public List<Order_list> getOrder_lists();
}
