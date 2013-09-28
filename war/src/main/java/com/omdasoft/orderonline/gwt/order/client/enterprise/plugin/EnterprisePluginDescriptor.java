package com.omdasoft.orderonline.gwt.order.client.enterprise.plugin;

import java.util.HashSet;
import java.util.Set;

import com.google.gwt.user.client.ui.Image;
import com.google.inject.Inject;
import com.omdasoft.orderonline.gwt.order.client.core.Extension;
import com.omdasoft.orderonline.gwt.order.client.core.ExtensionPoint;
import com.omdasoft.orderonline.gwt.order.client.core.Platform;
import com.omdasoft.orderonline.gwt.order.client.core.Plugin;
import com.omdasoft.orderonline.gwt.order.client.core.PluginDescriptor;
import com.omdasoft.orderonline.gwt.order.client.core.ui.MenuItem;
import com.omdasoft.orderonline.gwt.order.client.enterprise.editor.EnterpriseEditorDescriptor;
import com.omdasoft.orderonline.gwt.order.client.plugin.PluginConstants;

public class EnterprisePluginDescriptor implements PluginDescriptor {
	final static Set<Extension> extensions = new HashSet<Extension>();
	final static String PLUGIN_ID = EnterpriseConstants.PLUGIN_ENTERPRISE;
	final EnterprisePlugin plugin;
	final EnterpriseEditorDescriptor descriptor;

	@Inject
	public EnterprisePluginDescriptor(
			final EnterpriseEditorDescriptor editorDesc) {
		this.descriptor = editorDesc;
		plugin = new EnterprisePlugin(this);
		extensions.add(new Extension() {
			public String getExtensionPointId() {
				return PluginConstants.MENU;
			}

			public Object getInstance() {
				return new MenuItem() {
					public void execute() {
						Platform.getInstance()
								.getEditorRegistry()
								.openEditor(
										EnterpriseConstants.EDITOR_ENTERPRISE_EDIT,
										"EnterpriseInstanceID", null);
					}

					public Image getIcon() {
						return null;
					}

					public String getMenuId() {
						return EnterpriseConstants.MENU_ENTERPRISE_EDIT;
					}

					public int getOrder() {
						return 0;
					}

					public String getParentMenuId() {
						return null;
					}

					public String getTitle() {
						return "公司资料";
					}

				};
			}

			public PluginDescriptor getPluginDescriptor() {
				return EnterprisePluginDescriptor.this;
			}

		});

		extensions.add(new Extension() {

			public String getExtensionPointId() {
				return "core.editor";
			}

			public Object getInstance() {
				return descriptor;
			}

			public PluginDescriptor getPluginDescriptor() {
				return EnterprisePluginDescriptor.this;
			}

		});

	}

	public Set<ExtensionPoint> getExtensionPoints() {
		return null;
	}

	public Set<Extension> getExtensions() {
		return extensions;
	}

	public Plugin getInstance() {
		return plugin;
	}

	public String getPluginId() {
		return PLUGIN_ID;
	}

}
