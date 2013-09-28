package com.omdasoft.orderonline.gwt.order.client.win.confirm;


import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.omdasoft.orderonline.gwt.order.client.mvp.BaseDialogPresenter;
import com.omdasoft.orderonline.gwt.order.client.mvp.EventBus;

public class ConfirmPresenterImpl extends
		BaseDialogPresenter<ConfirmPresenter.ConfirmDisplay> implements ConfirmPresenter {

	@Inject
	public ConfirmPresenterImpl(EventBus eventBus, ConfirmPresenter.ConfirmDisplay display) {
		super(eventBus, display);
	}

	@Override
	public void bind() {
		registerHandler(display.getOkBtn().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new WinEvent());
//				closeDialog();
			}
		}));

		registerHandler(display.getCancelBtn().addClickHandler(
				new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						closeDialog();
					}
				}));
	}
}
