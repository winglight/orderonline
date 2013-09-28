package com.omdasoft.orderonline.gwt.order.client.dictionaryList.dataprovider;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.omdasoft.orderonline.gwt.order.client.dataprovider.BaseDataProvider;
import com.omdasoft.orderonline.gwt.order.client.dictionaryList.model.DictionaryListClient;
import com.omdasoft.orderonline.gwt.order.client.dictionaryList.model.DictionaryListCriteria;
import com.omdasoft.orderonline.gwt.order.client.dictionaryList.presenter.DictionaryListPresenter.DictionaryListDisplay;
import com.omdasoft.orderonline.gwt.order.client.dictionaryList.request.SearchDictionaryListRequest;
import com.omdasoft.orderonline.gwt.order.client.dictionaryList.request.SearchDictionaryListResponse;
import com.omdasoft.orderonline.gwt.order.client.mvp.ErrorHandler;
import com.omdasoft.orderonline.gwt.order.client.support.SessionManager;
import com.omdasoft.orderonline.gwt.order.model.PaginationDetailClient;

public class DictionaryListViewAdapter extends BaseDataProvider<DictionaryListClient> {

	final DispatchAsync dispatch;
	final DictionaryListDisplay display;
	DictionaryListCriteria criteria;
	final ErrorHandler errorHandler;
	final SessionManager sessionManager;

	public DictionaryListViewAdapter(DispatchAsync dispatch,
			DictionaryListCriteria criteria, ErrorHandler errorHandler,
			SessionManager sessionManager, DictionaryListDisplay display) {
		this.dispatch = dispatch;
		this.criteria = criteria;
		this.errorHandler = errorHandler;
		this.sessionManager = sessionManager;
		this.display=display;
	}

	public void fetchData(final int start, final int length) {
		// if (!GWT.isScript()) {
		// List<DictionaryListClient> list = new ArrayList<DictionaryListClient>();
		// for (int i = start; i < start + length; i++) {
		// DictionaryListClient item = new DictionaryListClient();
		// item.setId("id" + i);
		// item.setName("rewards" + i);
		// //item.setStatus(DictionaryListStatus.TO_BE_ISSUE);
		// list.add(item);
		// }
		//
		// updateRowData(start, list);
		// updateRowCount(100, true);
		// } else {
		PaginationDetailClient pagination = new PaginationDetailClient();
		pagination.setStart(start);
		pagination.setLimit(length);
		getCriteria().setPagination(pagination);
		if (getSorting() != null) {
			getCriteria().setSorting(getSorting());
		}
		dispatch.execute(new SearchDictionaryListRequest(getCriteria(), sessionManager
				.getSession()), new AsyncCallback<SearchDictionaryListResponse>() {
			@Override
			public void onFailure(Throwable e) {
				errorHandler.alert(e.getMessage());
			}

			@Override
			public void onSuccess(SearchDictionaryListResponse response) {
				updateRowData(start, response.getResult());
				updateRowCount(response.getTotal(), true);
				display.setDataCount(response.getTotal()+"");
			}

		});
		// }
	}


	public void setCriteria(DictionaryListCriteria criteria) {
		this.criteria = criteria;
	}

	private DictionaryListCriteria getCriteria() {
		if (criteria == null) {
			criteria = new DictionaryListCriteria();
		}

		return criteria;
	}
}
