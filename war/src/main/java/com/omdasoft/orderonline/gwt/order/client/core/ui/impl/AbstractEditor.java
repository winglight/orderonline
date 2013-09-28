package com.omdasoft.orderonline.gwt.order.client.core.ui.impl;

import com.omdasoft.orderonline.gwt.order.client.core.Platform;
import com.omdasoft.orderonline.gwt.order.client.core.ui.Editor;
import com.omdasoft.orderonline.gwt.order.client.core.ui.EditorDescriptor;


public abstract class AbstractEditor implements Editor {

	final EditorDescriptor editorDescriptor;
	String title;
	String instanceId;

	protected AbstractEditor(EditorDescriptor editorDescriptor) {
		this.editorDescriptor = editorDescriptor;
	}

	public String getEditorId() {
		return editorDescriptor.getEditorId();
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void close() {
		Platform.getInstance().getEditorRegistry().closeEditor(getEditorId(),
				getInstanceId());
	}
}
