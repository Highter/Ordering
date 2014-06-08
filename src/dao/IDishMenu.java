package dao;

import java.util.List;

import bean.DishMenu;

public interface IDishMenu {

	// 增
	public boolean addDishMenu(DishMenu dishMenu);

	// 删
	public boolean deleteDishMenu(int Dish_ID);

	// 改
	public boolean updateDishMenu(int Dish_ID);
	public boolean updateDishMenu(DishMenu menu);
	// 查
	public DishMenu getDishMenu(int Dish_ID);
	public DishMenu getDishMenu(String DishName);
	// 某个餐馆的菜单列表
	public List<DishMenu> getRestaurant_DishMenus(int Rest_ID);

	public List<DishMenu> getDishMenuByOrder();
	// 某个菜系的菜单列表
	public List<DishMenu> getDishStyle_DishMenus(int Dish_Style_ID);

	// 菜单列表
	public List<DishMenu> getDishMenus();
}
