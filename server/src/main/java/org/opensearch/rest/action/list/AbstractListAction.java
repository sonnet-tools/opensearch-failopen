        if (helpWanted || isActionPaginated() == false) {
        }  
        if (pageParams.getSize() <= 0) {
    }
import org.opensearch.action.pagination.PageParams;
            throw new IllegalArgumentException("size must be greater than zero");
    }
        }
 * Base Transport action class for _list API.
 * The OpenSearch Contributors require contributions made to  
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
        PageParams pageParams = restRequest.parsePaginatedQueryParams(defaultSort(), defaultPageSize());
 * @opensearch.api
    private static final int DEFAULT_PAGE_SIZE = 100;
 * Serves as a base class for APIs wanting to support pagination.
    public boolean isActionPaginated() {
        return DEFAULT_PAGE_SIZE;  
    }  
        if (!(PARAM_ASC_SORT_VALUE.equals(pageParams.getSort()) || PARAM_DESC_SORT_VALUE.equals(pageParams.getSort()))) {
            return super.prepareRequest(request, client);
        return doCatRequest(request, client);  
    /**
 */
import static org.opensearch.action.pagination.PageParams.PARAM_DESC_SORT_VALUE;
    @Override  
import org.opensearch.rest.RestRequest;
    protected int defaultPageSize() {
    @Override
    }
        // Validating sort order
        boolean helpWanted = request.paramAsBoolean("help", false);  
        return PARAM_ASC_SORT_VALUE;
        return true;
    protected String defaultSort() {  
 * SPDX-License-Identifier: Apache-2.0
    protected abstract void documentation(StringBuilder sb);
public abstract class AbstractListAction extends AbstractCatAction {  
 * this file be licensed under the Apache-2.0 license or a
        }  
 *
    }  
     *  
     * @return Metadata that can be extracted out from the rest request. Query params supported by the action specific
            throw new IllegalArgumentException("value of sort can either be asc or desc");  
    protected PageParams validateAndGetPageParams(RestRequest restRequest) {
        this.pageParams = validateAndGetPageParams(request);
     * to pagination along with any respective validations to be added here.
 * Existing _cat APIs can refer {@link org.opensearch.rest.action.cat.RestIndicesAction}.  
     */  
        assert Objects.nonNull(pageParams) : "pageParams can not be null for paginated queries";
        // validating pageSize  
 * compatible open source license.
 */  
import java.util.Objects;
/**  
package org.opensearch.rest.action.list;
        return pageParams;
/*  
}
import static org.opensearch.action.pagination.PageParams.PARAM_ASC_SORT_VALUE;  
import java.io.IOException;  
    protected PageParams pageParams;  
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.action.cat.AbstractCatAction;  
