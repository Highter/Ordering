package dao;

import java.util.List;

import bean.Restaurant;

public interface IRestaurant {

	// 增
	public boolean addRestaurant(Restaurant restaurant);

	// 删
	public boolean deleteRestaurant(int Rest_ID);

	// 改
	public boolean updateRestaurant(int Rest_ID);
	public boolean updateRestaurant(Restaurant rest);

	// 查
	public Restaurant getRestaurant(int Rest_ID);
	
	public Restaurant getRestaurantByCEO(int Rest_CEO_ID);
	public Restaurant getRestaurantByName(String name);
	// 某种菜系的餐馆列表
	public List<Restaurant> getDishStyle_Restaurants(int Dish_Style_ID);

	// 餐馆列表
	public List<Restaurant> getRestaurants();

	List<Restaurant> getHotRestaurants();
}
