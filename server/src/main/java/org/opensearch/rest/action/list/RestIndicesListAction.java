    @Override
                return tuple;
 */
 */  
import org.opensearch.rest.RestRequest;
                    indexPos++;
    }
import org.opensearch.common.breaker.ResponseLimitSettings;
    }  
        }
 *
    public String getName() {  
    }  
    public boolean isActionPaginated() {  
            }  
        if (Objects.nonNull(pageParams.getRequestedToken())) {  
            public Tuple<String, Settings> next() {
    @Override  
    }
    @Override
import java.util.List;
    public Iterator<Tuple<String, Settings>> getTableIterator(String[] indices, Map<String, Settings> indexSettingsMap) {
    }  
            @Override
 * @opensearch.api
    protected PageParams validateAndGetPageParams(RestRequest restRequest) {
        }
            public boolean hasNext() {  
 * compatible open source license.
                }  
        return new Iterator<>() {
    // Public for testing
        return DEFAULT_LIST_INDICES_PAGE_SIZE;  
package org.opensearch.rest.action.list;
        // validate max supported pageSize
import java.io.IOException;  
    }  
        return "list_indices_action";
import java.util.Iterator;
import static org.opensearch.rest.RestRequest.Method.GET;
 * SPDX-License-Identifier: Apache-2.0
        return super.prepareRequest(request, client);  
import org.opensearch.indices.SystemIndices;
public class RestIndicesListAction extends RestIndicesAction {  
    @Override  
import org.opensearch.rest.action.cat.RestIndicesAction;  
        PageParams pageParams = super.validateAndGetPageParams(restRequest);  
        return true;
 * _list API action to output indices in pages.
    protected int defaultPageSize() {
    private static final int MAX_SUPPORTED_LIST_INDICES_PAGE_SIZE = 5000;
    @Override
import org.opensearch.common.settings.Settings;  
import org.opensearch.transport.client.node.NodeClient;
    }
        return false;
 *  
    protected IndexPaginationStrategy getPaginationStrategy(ClusterStateResponse clusterStateResponse) {
                indexPos++;
import java.util.Map;  
import org.opensearch.action.pagination.PageParams;  
    @Override
    }
        // Next Token in the request will be validated by the IndexStrategyToken itself.
                return indexPos < indices.length;
    }
        return new IndexPaginationStrategy(pageParams, clusterStateResponse.getState());
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        };
    public boolean isRequestLimitCheckSupported() {
    public List<Route> routes() {
        if (request.hasParam("system")) {  
/**
        }
import org.opensearch.action.pagination.IndexPaginationStrategy;
import org.opensearch.common.collect.Tuple;
    protected void documentation(StringBuilder sb) {  
import static java.util.Arrays.asList;  
 * this file be licensed under the Apache-2.0 license or a
        sb.append("/_list/indices\n");
        super(responseLimitSettings, systemIndices);  
    @Override  
}  
import static java.util.Collections.unmodifiableList;
        sb.append("/_list/indices/{index}\n");
 * The OpenSearch Contributors require contributions made to  
                while (indexPos < indices.length && indexSettingsMap.containsKey(indices[indexPos]) == false) {
    @Override  
            int indexPos = 0;  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            IndexPaginationStrategy.IndexStrategyToken.validateIndexStrategyToken(pageParams.getRequestedToken());
import java.util.Objects;
        if (pageParams.getSize() > MAX_SUPPORTED_LIST_INDICES_PAGE_SIZE) {
        return unmodifiableList(asList(new Route(GET, "/_list/indices"), new Route(GET, "/_list/indices/{index}")));
            }
    }
            throw new IllegalArgumentException("parameter [system] is not supported by the [_list/indices] API");
    public RestIndicesListAction(final ResponseLimitSettings responseLimitSettings, final SystemIndices systemIndices) {
            throw new IllegalArgumentException("size should be less than [" + MAX_SUPPORTED_LIST_INDICES_PAGE_SIZE + "]");  
    private static final int DEFAULT_LIST_INDICES_PAGE_SIZE = 500;  
    }
/*  
        return pageParams;  
                Tuple<String, Settings> tuple = new Tuple<>(indices[indexPos], indexSettingsMap.get(indices[indexPos]));  
            @Override
