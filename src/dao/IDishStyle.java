package dao;

import java.util.List;

import bean.DishStyle;

public interface IDishStyle {

	// ��
	public boolean addishStyle(DishStyle dishStyle);

	// ɾ
	public boolean deleteishStyle(int Dish_Style_ID);

	// ��
	public boolean updateishStyle(int Dish_Style_ID);

	// ��
	public DishStyle getDishStyle(int Dish_Style_ID);

	// ��ϵ�б�
	public List<DishStyle> getDishStyles();
}
