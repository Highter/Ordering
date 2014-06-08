package dao;

import java.util.List;

import bean.DishMenu;

public interface IDishMenu {

	// ��
	public boolean addDishMenu(DishMenu dishMenu);

	// ɾ
	public boolean deleteDishMenu(int Dish_ID);

	// ��
	public boolean updateDishMenu(int Dish_ID);
	public boolean updateDishMenu(DishMenu menu);
	// ��
	public DishMenu getDishMenu(int Dish_ID);
	public DishMenu getDishMenu(String DishName);
	// ĳ���͹ݵĲ˵��б�
	public List<DishMenu> getRestaurant_DishMenus(int Rest_ID);

	public List<DishMenu> getDishMenuByOrder();
	// ĳ����ϵ�Ĳ˵��б�
	public List<DishMenu> getDishStyle_DishMenus(int Dish_Style_ID);

	// �˵��б�
	public List<DishMenu> getDishMenus();
}
