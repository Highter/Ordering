package dao;

import java.util.List;

import bean.Rest_message;

public interface IRest_message {

	// ��
	public boolean addRest_message(Rest_message rest_message);

	// ɾ
	public boolean deleteRest_message(int Message_ID);

	// ��
	public Rest_message getRest_message(int Message_ID);

	// ĳ���û������������б�
	public List<Rest_message> getCustom_Rest_messages(int custom_ID);

	// ĳ���͹ݵ����������б�
	public List<Rest_message> getRestaurant_messages(int Rest_ID);

	// �����б�
	public List<Rest_message> getRest_messages();

}
