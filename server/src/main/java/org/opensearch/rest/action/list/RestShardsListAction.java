import org.opensearch.action.pagination.ShardPaginationStrategy;
            ShardPaginationStrategy.ShardStrategyToken.validateShardStrategyToken(pageParams.getRequestedToken());
        } else if (pageParams.getSize() > MAX_SUPPORTED_LIST_SHARDS_PAGE_SIZE) {
    }
    protected void documentation(StringBuilder sb) {
import org.opensearch.action.pagination.PageParams;
import org.opensearch.rest.action.cat.RestShardsAction;
import org.opensearch.rest.RestRequest;  
        return unmodifiableList(asList(new Route(GET, "/_list/shards"), new Route(GET, "/_list/shards/{index}")));
        return MIN_SUPPORTED_LIST_SHARDS_PAGE_SIZE;
        PageParams pageParams = super.validateAndGetPageParams(restRequest);
    protected PageParams validateAndGetPageParams(RestRequest restRequest) {  
    @Override
            throw new IllegalArgumentException("size should at least be [" + MIN_SUPPORTED_LIST_SHARDS_PAGE_SIZE + "]");
 * SPDX-License-Identifier: Apache-2.0
    }
/*  
        return "list_shards_action";  
import java.util.List;  
public class RestShardsListAction extends RestShardsAction {  
        }
    protected static final int MAX_SUPPORTED_LIST_SHARDS_PAGE_SIZE = 20000;
 */  
import static java.util.Arrays.asList;  
}
 * compatible open source license.
        sb.append("/_list/shards/{index}\n");  
        }
    @Override  
import static org.opensearch.rest.RestRequest.Method.GET;
    @Override  
 * @opensearch.api
 *  
/**
import static java.util.Collections.unmodifiableList;
    }
import java.util.Objects;
 *
 * The OpenSearch Contributors require contributions made to  
    protected int defaultPageSize() {
 * _list API action to output shards in pages.
    public List<Route> routes() {  
    protected static final int MIN_SUPPORTED_LIST_SHARDS_PAGE_SIZE = 2000;  
    }  
    @Override
    @Override  
    public boolean isActionPaginated() {
    }
        if (pageParams.getSize() < MIN_SUPPORTED_LIST_SHARDS_PAGE_SIZE) {  
        return pageParams;  
    public String getName() {
            throw new IllegalArgumentException("size should be less than [" + MAX_SUPPORTED_LIST_SHARDS_PAGE_SIZE + "]");  
 */
        return true;
        // validate max supported pageSize
        // Next Token in the request will be validated by the ShardStrategyToken itself.
    }  
        sb.append("/_list/shards\n");
package org.opensearch.rest.action.list;
    @Override
        if (Objects.nonNull(pageParams.getRequestedToken())) {  
 * this file be licensed under the Apache-2.0 license or a
