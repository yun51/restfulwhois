package com.cnnic.whois.dao.cache;

import java.util.List;

import com.cnnic.whois.bean.QueryParam;
import com.cnnic.whois.bean.QueryType;

public class EventsQueryDao extends AbstractCacheQueryDao {
	@Override
	protected List<String> getCacheKeySplits(QueryParam param) {
		return super.getHandleCacheKeySplits(param);
	}

	@Override
	public QueryType getQueryType() {
		return QueryType.EVENTS;
	}

	@Override
	public boolean supportType(QueryType queryType) {
		return QueryType.EVENTS.equals(queryType);
	}

	@Override
	protected boolean needInitCache() {
		return true;
	}

	@Override
	protected void initCache() {
		super.initCacheWithOneKey("$mul$events", "eventsId");
	}
}