package dao;

import java.util.List;

import bean.DishStyle;

public interface IDishStyle {

	// 增
	public boolean addishStyle(DishStyle dishStyle);

	// 删
	public boolean deleteishStyle(int Dish_Style_ID);

	// 改
	public boolean updateishStyle(int Dish_Style_ID);

	// 查
	public DishStyle getDishStyle(int Dish_Style_ID);

	// 菜系列表
	public List<DishStyle> getDishStyles();
}
