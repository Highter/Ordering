package dao;

import java.util.List;

import bean.Custom;

public interface ICustom {

	// 增加用户----注意：custom构造的时候没有id，在插入数据到数据库后，实现增加功能的时候，
	// 通过getInt(1)获取数据库自增的id值，然后用setCustom_id()方法
	public boolean addCustom(Custom custom);

	// 删
	public boolean deleteCustom(int custom_id);

	// 改role
	public boolean updateCustom(Custom cus);
	public boolean updateCustomRole(int custom_id);

	// 查
	public Custom getCustom(int custom_id);

	public Custom getCustom(String Login_name);

	// 订餐客户列表
	public List<Custom> getCustomLists(int Role);

}
