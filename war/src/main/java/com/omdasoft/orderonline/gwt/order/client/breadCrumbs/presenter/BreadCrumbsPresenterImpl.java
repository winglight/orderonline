package com.omdasoft.orderonline.gwt.order.client.breadCrumbs.presenter;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.omdasoft.orderonline.gwt.order.client.breadCrumbs.model.MenuBreadVo;
import com.omdasoft.orderonline.gwt.order.client.breadCrumbs.ui.BreadCrumbsMenu;
import com.omdasoft.orderonline.gwt.order.client.core.ui.MenuProcessor;
import com.omdasoft.orderonline.gwt.order.client.core.ui.event.MenuClickEvent;
import com.omdasoft.orderonline.gwt.order.client.mvp.BasePresenter;
import com.omdasoft.orderonline.gwt.order.client.mvp.EventBus;
import com.omdasoft.orderonline.gwt.order.client.win.Win;

public class BreadCrumbsPresenterImpl extends
		BasePresenter<BreadCrumbsPresenter.BreadCrumbsDisplay> implements
		BreadCrumbsPresenter {
	final MenuProcessor menuProcessor;
	final BreadCrumbsMenu breadCrumbsMenu;
	final Win win;
	boolean isHistory=false;

	@Inject
	public BreadCrumbsPresenterImpl(EventBus eventBus,
			BreadCrumbsDisplay display, MenuProcessor menuProcessor,
			BreadCrumbsMenu breadCrumbsMenu,Win win) {
		super(eventBus, display);
		this.menuProcessor = menuProcessor;
		this.breadCrumbsMenu = breadCrumbsMenu;
		this.win=win;
	}

	public void bind() {
		registerHandler(display.getGoHistory().addClickHandler(
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						List<MenuBreadVo> listvo=breadCrumbsMenu.getHistoryBreadCrumbsItem();
						if(listvo!=null)
						{
							isHistory=true;
							display.setTitleText(listvo);
							menuProcessor.changItemColor(menuProcessor.getMenuItem(listvo.get(listvo.size()-1).getMenuUrl().getMenuId()).getTitle());
							eventBus.fireEvent(new MenuClickEvent(menuProcessor.getMenuItem(listvo.get(listvo.size()-1).getMenuUrl().getMenuId())));
						}
						else
						{
							win.alert("无上一页");
						}
					
					}
				}));
		if(isHistory==false)
		 display.setTitleText(breadCrumbsMenu.getBreadCrumbsItem());
		else
		isHistory=false;

	}

	@Override
	public void setChildName(String name) {
		breadCrumbsMenu.setChildName(name);
		
	}

	@Override
	public void cleanChildName() {
		breadCrumbsMenu.cleanChildName();
		
	}

	@Override
	public void loadListPage() {
		this.unbind();
		this.cleanChildName();
		this.bind();
		
	}

	@Override
	public void loadChildPage(String menuName) {
		this.unbind();
		this.setChildName(menuName);
		this.bind();
		
	}

	@Override
	public void getGoHistory() {
		List<MenuBreadVo> listvo=breadCrumbsMenu.getHistoryBreadCrumbsItem();
		if(listvo!=null)
		{
			isHistory=true;
			display.setTitleText(listvo);
			menuProcessor.changItemColor(menuProcessor.getMenuItem(listvo.get(listvo.size()-1).getMenuUrl().getMenuId()).getTitle());
			eventBus.fireEvent(new MenuClickEvent(menuProcessor.getMenuItem(listvo.get(listvo.size()-1).getMenuUrl().getMenuId())));
		}
		else
		{
			win.alert("无上一页");
		}
		
	}

}
