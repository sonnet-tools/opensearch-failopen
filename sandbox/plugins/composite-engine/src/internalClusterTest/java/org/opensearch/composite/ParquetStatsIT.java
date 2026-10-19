        assertThat(indexStats, hasKey("shards"));
        Map<String, Object> indices = (Map<String, Object>) body.get("indices");  
import org.opensearch.common.xcontent.json.JsonXContent;
        Map<String, Object> body = XContentHelper.convertToMap(JsonXContent.jsonXContent, response.getEntity().getContent(), true);  
    public void testParquetIndexStatsShardLevel() throws Exception {  
        Map<String, Object> body = XContentHelper.convertToMap(JsonXContent.jsonXContent, response.getEntity().getContent(), true);
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/" + idx + "/_stats?shard=99"));
        indexDocs(idx, 25, 0);
        Map<String, Object> indexStats = (Map<String, Object>) indices.get(idx);
        createCompositeIndex(idx, true);
    public void testParquetInvalidShard() throws Exception {
 *
    public void testParquetNodeStats() throws Exception {
        flushIndex(idx);
        assertThat(body, hasKey("indices"));
        String idx = "parquet-stats-1";
            getRestClient().performRequest(new Request("GET", "/_plugins/parquet/no-such-index/_stats"));  
        }
    }
        } catch (Exception e) {
        String idx = "parquet-stats-shards";
        assertThat("at least one node returns parquet stats", nodes.size(), greaterThanOrEqualTo(1));
 */  
        createCompositeIndex(idx, true);  
    }  
    @SuppressWarnings("unchecked")  
 * Integration tests for {@code GET /_plugins/parquet/{index}/_stats} and
/**
import org.opensearch.client.Request;
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
        flushIndex(idx);
        try {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
        String idx = "parquet-node-stats";
    public void testParquetIndexStatsNonExistent() {
            fail("expected 400");  
        return false; // need real Netty4 HTTP transport for the REST client  
        assertThat(((Number) indexing.get("docs_indexed_total")).longValue(), equalTo(50L));
import static org.hamcrest.Matchers.notNullValue;
            fail("expected 404");
 */  
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
            assertThat(e, notNullValue());  
    protected boolean addMockHttpTransport() {
}  
    @SuppressWarnings("unchecked")  
    }
            assertThat(e.getResponse().getStatusLine().getStatusCode(), equalTo(400));
        indexDocs(idx, 30, 0);  
        Map<String, Object> indexing = (Map<String, Object>) indexStats.get("indexing");  
@ClusterScope(scope = Scope.SUITE, numDataNodes = 1)
        assertThat(indices, hasKey(idx));
    }
import org.opensearch.client.ResponseException;  
 * this file be licensed under the Apache-2.0 license or a
    }
public class ParquetStatsIT extends AbstractCompositeEngineIT {
import static org.hamcrest.Matchers.equalTo;
package org.opensearch.composite;
        assertThat(indexing, notNullValue());
        indexDocs(idx, 50, 0);
import org.opensearch.common.xcontent.XContentHelper;
    public void testParquetIndexStats() throws Exception {
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
        createCompositeIndex(idx, true);  
        Response response = getRestClient().performRequest(new Request("GET", "/_plugins/parquet/" + idx + "/_stats?level=shards"));  
        Map<String, Object> indexStats = (Map<String, Object>) ((Map<String, Object>) body.get("indices")).get(idx);  
import static org.hamcrest.Matchers.hasKey;
        Response response = getRestClient().performRequest(new Request("GET", "/_plugins/parquet/_nodes/_stats"));
        Response response = getRestClient().performRequest(new Request("GET", "/_plugins/parquet/" + idx + "/_stats"));
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
    @SuppressWarnings("unchecked")
        } catch (ResponseException e) {
        assertThat(body, hasKey("nodes"));
 * @opensearch.experimental
 *
        String idx = "parquet-invalid-shard";
        Map<String, Object> body = XContentHelper.convertToMap(JsonXContent.jsonXContent, response.getEntity().getContent(), true);  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;  
        flushIndex(idx);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
 * The OpenSearch Contributors require contributions made to  
        createCompositeIndex(idx, true);  
    @Override
 * compatible open source license.
        Map<String, Object> nodes = (Map<String, Object>) body.get("nodes");  
/*  
    }
        }  
import org.opensearch.client.Response;
 * {@code GET /_plugins/parquet/_nodes/{nodeId}/_stats}.  
        try {
