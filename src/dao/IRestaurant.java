package dao;

import java.util.List;

import bean.Restaurant;

public interface IRestaurant {

	// ��
	public boolean addRestaurant(Restaurant restaurant);

	// ɾ
	public boolean deleteRestaurant(int Rest_ID);

	// ��
	public boolean updateRestaurant(int Rest_ID);
	public boolean updateRestaurant(Restaurant rest);

	// ��
	public Restaurant getRestaurant(int Rest_ID);
	
	public Restaurant getRestaurantByCEO(int Rest_CEO_ID);
	public Restaurant getRestaurantByName(String name);
	// ĳ�ֲ�ϵ�Ĳ͹��б�
	public List<Restaurant> getDishStyle_Restaurants(int Dish_Style_ID);

	// �͹��б�
	public List<Restaurant> getRestaurants();

	List<Restaurant> getHotRestaurants();
}
