package com.omdasoft.orderonline.gwt.order.client.orderView.editor;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.omdasoft.orderonline.gwt.order.client.core.ui.impl.AbstractEditor;
import com.omdasoft.orderonline.gwt.order.client.dictionaryList.editor.DictionaryListEditorDescriptor;
import com.omdasoft.orderonline.gwt.order.client.orderView.presenter.OrderViewPresenter;

/**
 * @author nicho
 * @since 2012年2月14日 10:25:52
 */
public class OrderViewEditor extends AbstractEditor {

	final OrderViewPresenter OrderViewPresenter;
	Object model;

	@Inject
	protected OrderViewEditor(DictionaryListEditorDescriptor editorDescriptor,
			OrderViewPresenter OrderViewPresenter) {
		super(editorDescriptor);
		this.OrderViewPresenter = OrderViewPresenter;
	}

	@Override
	public Widget asWidget() {
		return OrderViewPresenter.getDisplay().asWidget();
	}

	@Override
	public boolean beforeClose() {
		OrderViewPresenter.unbind();
		return true;
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public void save() {

	}

	public void setModel(Object model) {
		this.model = model;
		if(model!=null)
			OrderViewPresenter.initOrder((String)model);
		OrderViewPresenter.bind();
	}
}
