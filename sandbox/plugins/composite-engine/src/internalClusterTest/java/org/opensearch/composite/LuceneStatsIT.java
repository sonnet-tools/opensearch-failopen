 *  
        }  
package org.opensearch.composite;
        flushIndex(idx);  
        } catch (Exception e) {
        Map<String, Object> body = XContentHelper.convertToMap(JsonXContent.jsonXContent, response.getEntity().getContent(), true);
 * compatible open source license.
    }  
        String idx = "lucene-stats-1";
        createCompositeIndex(idx, true);
        assertThat(indexing, notNullValue());  
}
 * Integration tests for {@code GET /_plugins/lucene/{index}/_stats} and
        Map<String, Object> body = XContentHelper.convertToMap(JsonXContent.jsonXContent, response.getEntity().getContent(), true);
        assertThat(((Map<?, ?>) body.get("nodes")).size(), greaterThanOrEqualTo(1));  
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.client.Response;
/**  
 *
    @SuppressWarnings("unchecked")
import static org.hamcrest.Matchers.notNullValue;
        assertThat(((Number) indexing.get("docs_indexed_total")).longValue(), equalTo(50L));
            fail("expected error for unknown format");  
    }
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)  
        indexDocs(idx, 25, 0);
 * The OpenSearch Contributors require contributions made to  
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));  
    public void testUnknownFormatReturns404() {  
            getRestClient().performRequest(new Request("GET", "/_plugins/no-such-format/myindex/_stats"));
        Map<String, Object> indexStats = (Map<String, Object>) ((Map<String, Object>) body.get("indices")).get(idx);
        Map<String, Object> indexing = (Map<String, Object>) indexStats.get("indexing");
        String idx = "lucene-node-stats";  
    public void testLuceneIndexStats() throws Exception {  
        flushIndex(idx);
 */  
 */
import static org.hamcrest.Matchers.equalTo;
        Response response = getRestClient().performRequest(new Request("GET", "/_plugins/lucene/" + idx + "/_stats"));  
    }
        indexDocs(idx, 50, 0);  
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
/*  
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testLuceneNodeStats() throws Exception {
import org.opensearch.client.Request;
            assertThat(e, notNullValue());
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import org.opensearch.common.xcontent.XContentHelper;  
    @Override  
    @SuppressWarnings("unchecked")
        assertThat(body, hasKey("nodes"));
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
import static org.hamcrest.Matchers.hasKey;  
        createCompositeIndex(idx, true);
        try {
        return false;
import java.util.Map;
    protected boolean addMockHttpTransport() {
public class LuceneStatsIT extends AbstractCompositeEngineIT {
        Response response = getRestClient().performRequest(new Request("GET", "/_plugins/lucene/_nodes/_stats"));
 * {@code GET /_plugins/lucene/_nodes/{nodeId}/_stats}.
