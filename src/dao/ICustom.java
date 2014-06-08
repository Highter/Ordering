package dao;

import java.util.List;

import bean.Custom;

public interface ICustom {

	// �����û�----ע�⣺custom�����ʱ��û��id���ڲ������ݵ����ݿ��ʵ�����ӹ��ܵ�ʱ��
	// ͨ��getInt(1)��ȡ���ݿ�������idֵ��Ȼ����setCustom_id()����
	public boolean addCustom(Custom custom);

	// ɾ
	public boolean deleteCustom(int custom_id);

	// ��role
	public boolean updateCustom(Custom cus);
	public boolean updateCustomRole(int custom_id);

	// ��
	public Custom getCustom(int custom_id);

	public Custom getCustom(String Login_name);

	// ���Ϳͻ��б�
	public List<Custom> getCustomLists(int Role);

}
