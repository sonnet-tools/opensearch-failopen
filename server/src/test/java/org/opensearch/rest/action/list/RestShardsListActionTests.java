        RestRequest restRequest = new FakeRestRequest(params);
import java.util.HashMap;
import org.opensearch.action.pagination.PageParams;
import org.opensearch.action.pagination.PaginationStrategy;  
        RestRequest restRequest = new FakeRestRequest(params);
 * compatible open source license.
        assertEquals(PARAM_ASC_SORT_VALUE, pageParams.getSort());
        params.put("next_token", PaginationStrategy.encryptStringToken("1|1|test"));
        RestRequest restRequest = new FakeRestRequest(params);  
package org.opensearch.rest.action.list;
    }  
        Map<String, String> params = new HashMap<>();
        assertTrue(action.isActionPaginated());
    private final RestShardsListAction action = new RestShardsListAction();
import static org.opensearch.rest.action.list.RestShardsListAction.MAX_SUPPORTED_LIST_SHARDS_PAGE_SIZE;  
import static org.opensearch.action.pagination.PageParams.PARAM_ASC_SORT_VALUE;
        PageParams pageParams = action.validateAndGetPageParams(restRequest);
        RestRequest restRequest = new FakeRestRequest(params);
        params.put("size", String.valueOf(MIN_SUPPORTED_LIST_SHARDS_PAGE_SIZE - 1));
        assertEquals(PaginationStrategy.encryptStringToken("1|1|test"), pageParams.getRequestedToken());
    }
        params.put("size", "3000");  
    public void testValidateAndGetPageParamsWithValidPageParams() {
        Map<String, String> params = new HashMap<>();
        params.put("size", String.valueOf(MAX_SUPPORTED_LIST_SHARDS_PAGE_SIZE * 10));
/*  
    public void testValidateAndGetPageParamsWithSizeAboveRange() {  
        assertEquals(3000, pageParams.getSize());
        RestRequest restRequest = new FakeRestRequest(params);
}  
        PageParams pageParams = action.validateAndGetPageParams(restRequest);
        assertThrows(IllegalArgumentException.class, () -> action.validateAndGetPageParams(restRequest));  
 *
        params.put("next_token", PaginationStrategy.encryptStringToken("1|-1|test"));  
        params.put("sort", "asc");
        assertNull(pageParams.getRequestedToken());
    }  
 * The OpenSearch Contributors require contributions made to  
    public void testValidateAndGetPageParamsWithSizeBelowMin() {
    public void testValidateAndGetPageParamsWithDefaultParams() {
    public void testShardsListActionIsPaginated() {
 */  
        assertEquals(MIN_SUPPORTED_LIST_SHARDS_PAGE_SIZE, pageParams.getSize());  
import org.opensearch.test.rest.FakeRestRequest;  
        Map<String, String> params = new HashMap<>();  
    }
 * SPDX-License-Identifier: Apache-2.0
        Map<String, String> params = new HashMap<>();  
import org.opensearch.rest.RestRequest;
        Map<String, String> params = new HashMap<>();  
import org.opensearch.test.OpenSearchTestCase;
    }
    public void testValidateAndGetPageParamsWithInvalidRequestToken() {
import org.opensearch.OpenSearchParseException;
public class RestShardsListActionTests extends OpenSearchTestCase {  
        assertEquals("asc", pageParams.getSort());  
import java.util.Map;  
    }  
        assertThrows(OpenSearchParseException.class, () -> action.validateAndGetPageParams(restRequest));
import static org.opensearch.rest.action.list.RestShardsListAction.MIN_SUPPORTED_LIST_SHARDS_PAGE_SIZE;
 * this file be licensed under the Apache-2.0 license or a
        assertThrows(IllegalArgumentException.class, () -> action.validateAndGetPageParams(restRequest));
