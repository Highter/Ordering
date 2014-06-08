package listener;

import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dao.impl.ShopCarImpl;

import bean.Custom;
import bean.ShoppingCar;
import bean.ShoppingCarDateBase;

public class ShopCarListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent session) {
		
		//����sessionʱ����������ݿ��ж�ȡ����
		
		
	
	/*System.out.println("sessionCreated");
		
		ShopCarImpl dao = new ShopCarImpl();
		List<ShoppingCar> all = dao.getShopCars(((Custom)session.getSession().getAttribute("custom")).getCustom_ID());
		session.getSession().setAttribute("shop", all);*/
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent session) {
		System.out.println("sessionDestroyed");
		//��session����ʱ�����浽���ݿ�
		List<ShoppingCar> all = (List<ShoppingCar>) session.getSession().getAttribute("shop");
		System.out.println("all:"+all);
		
		ShopCarImpl dao = new ShopCarImpl();
		if(all !=null){
			for(int i = 0;i<all.size();i++)
			{
				ShoppingCarDateBase base  = new ShoppingCarDateBase();
				Custom cus= (Custom)session.getSession().getAttribute("custom");
				
				base.setCustom_id(cus.getCustom_ID());
				base.setCustom_car(all.get(i));
				dao.addShopCar(base);
			}
		}
		
		
	}

	

}
