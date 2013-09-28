package com.omdasoft.orderonline.gwt.order.client.breadCrumbs.model;

import java.io.Serializable;

import com.omdasoft.orderonline.gwt.order.client.core.ui.MenuItem;

public class MenuBreadVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String menuName;
	MenuItem  menuUrl;
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public MenuItem getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(MenuItem menuUrl) {
		this.menuUrl = menuUrl;
	}


}