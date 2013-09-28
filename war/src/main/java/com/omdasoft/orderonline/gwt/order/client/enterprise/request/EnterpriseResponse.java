package com.omdasoft.orderonline.gwt.order.client.enterprise.request;

import net.customware.gwt.dispatch.shared.Result;

import com.omdasoft.orderonline.gwt.order.client.enterprise.model.EnterpriseVo;

public class EnterpriseResponse implements Result {
	private String token;
	private EnterpriseVo enterprise;

	public EnterpriseVo getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(EnterpriseVo enterprise) {
		this.enterprise = enterprise;
	}

	public EnterpriseResponse() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
