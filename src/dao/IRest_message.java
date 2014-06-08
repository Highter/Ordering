package dao;

import java.util.List;

import bean.Rest_message;

public interface IRest_message {

	// 增
	public boolean addRest_message(Rest_message rest_message);

	// 删
	public boolean deleteRest_message(int Message_ID);

	// 查
	public Rest_message getRest_message(int Message_ID);

	// 某个用户的所有留言列表
	public List<Rest_message> getCustom_Rest_messages(int custom_ID);

	// 某个餐馆的所有留言列表
	public List<Rest_message> getRestaurant_messages(int Rest_ID);

	// 留言列表
	public List<Rest_message> getRest_messages();

}
