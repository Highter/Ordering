package bean;

import java.io.Serializable;
import java.util.List;

public class MenuList implements Serializable{
	private List<DishMenu> menuList1;
	private List<DishMenu> menuList2;
	private List<DishMenu> menuList3;
	private List<DishMenu> menuList4;
	private List<DishMenu> menuList5;
	private List<DishMenu> menuList6;
	private List<DishMenu> menuList7;
	private List<DishMenu> menuList8;
	
	public MenuList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MenuList(List<DishMenu> menuList1, List<DishMenu> menuList2,
			List<DishMenu> menuList3, List<DishMenu> menuList4,
			List<DishMenu> menuList5, List<DishMenu> menuList6,
			List<DishMenu> menuList7, List<DishMenu> menuList8) {
		super();
		this.menuList1 = menuList1;
		this.menuList2 = menuList2;
		this.menuList3 = menuList3;
		this.menuList4 = menuList4;
		this.menuList5 = menuList5;
		this.menuList6 = menuList6;
		this.menuList7 = menuList7;
		this.menuList8 = menuList8;
	}

	public List<DishMenu> getMenuList1() {
		return menuList1;
	}
	public void setMenuList1(List<DishMenu> menuList1) {
		this.menuList1 = menuList1;
	}
	public List<DishMenu> getMenuList2() {
		return menuList2;
	}
	public void setMenuList2(List<DishMenu> menuList2) {
		this.menuList2 = menuList2;
	}
	public List<DishMenu> getMenuList3() {
		return menuList3;
	}
	public void setMenuList3(List<DishMenu> menuList3) {
		this.menuList3 = menuList3;
	}
	public List<DishMenu> getMenuList4() {
		return menuList4;
	}
	public void setMenuList4(List<DishMenu> menuList4) {
		this.menuList4 = menuList4;
	}
	public List<DishMenu> getMenuList5() {
		return menuList5;
	}
	public void setMenuList5(List<DishMenu> menuList5) {
		this.menuList5 = menuList5;
	}
	public List<DishMenu> getMenuList6() {
		return menuList6;
	}
	public void setMenuList6(List<DishMenu> menuList6) {
		this.menuList6 = menuList6;
	}
	public List<DishMenu> getMenuList7() {
		return menuList7;
	}
	public void setMenuList7(List<DishMenu> menuList7) {
		this.menuList7 = menuList7;
	}
	public List<DishMenu> getMenuList8() {
		return menuList8;
	}
	public void setMenuList8(List<DishMenu> menuList8) {
		this.menuList8 = menuList8;
	}

	@Override
	public String toString() {
		return "MenuList [menuList1=" + menuList1 + ", menuList2=" + menuList2
				+ ", menuList3=" + menuList3 + ", menuList4=" + menuList4
				+ ", menuList5=" + menuList5 + ", menuList6=" + menuList6
				+ ", menuList7=" + menuList7 + ", menuList8=" + menuList8 + "]";
	}
	
}
