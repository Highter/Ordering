package dao;

import java.util.List;

import bean.ShoppingCar;
import bean.ShoppingCarDateBase;

public interface IShopCar {
	public  long addShopCar(ShoppingCarDateBase shopcar);
	public List<ShoppingCar> getShopCars(int custom_id);
	public boolean deleteShopCar(int custom_id);
}
