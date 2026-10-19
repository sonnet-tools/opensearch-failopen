    }
    }  
        return false;
 * The OpenSearch Contributors require contributions made to  
    protected void assertCounterPresent(String message, Map<String, Object> response, String path) {
public abstract class BaseStatsIT extends AbstractCompositeEngineIT {
    @Override  
 */  
 * @opensearch.experimental
        StatsITHelpers.assertCounterPresent(message, response, path);
    }
    protected Map<String, Object> compositeNodeStats(String nodeIdOrEmpty, String... queryParams) throws IOException {
        StatsITHelpers.forceMerge(client(), index, maxSegments);  
    protected Map<String, Object> parquetIndexStats(String index, String... queryParams) throws IOException {
    }
        StatsITHelpers.assertCounter(message, response, path, expected);  
        return StatsITHelpers.parquetIndexStats(getRestClient(), index, queryParams);  
/*  
    protected void assertCounterAtLeast(String message, Map<String, Object> response, String path, long min) {  
}  
    protected Response getRaw(String path) throws IOException {  
 */  
    }  
        StatsITHelpers.assertCounterAtLeast(message, response, path, min);
        return StatsITHelpers.luceneNodeStats(getRestClient(), nodeIdOrEmpty, queryParams);
    protected int getStatusCode(Map<String, Object> response) {
        return StatsITHelpers.parquetNodeStats(getRestClient(), nodeIdOrEmpty, queryParams);
    }
 * Abstract base class for stats API integration tests.
    }  
        return StatsITHelpers.getRaw(getRestClient(), path);
    protected Map<String, Object> luceneIndexStats(String index, String... queryParams) throws IOException {  
        return StatsITHelpers.getStatusCode(response);  
    protected boolean addMockHttpTransport() {
        return StatsITHelpers.compositeNodeStats(getRestClient(), nodeIdOrEmpty, queryParams);  
    }
 * Provides helper methods for querying parquet and lucene stats endpoints
        return StatsITHelpers.compositeIndexStats(getRestClient(), index, queryParams);
 * and asserting on JSON response fields.  
 * this file be licensed under the Apache-2.0 license or a
    }
import java.util.Map;
        return StatsITHelpers.getCounter(response, dottedPath);
    }  
    }
    protected Map<String, Object> parquetNodeStats(String nodeIdOrEmpty, String... queryParams) throws IOException {  
package org.opensearch.composite;
    protected Map<String, Object> luceneNodeStats(String nodeIdOrEmpty, String... queryParams) throws IOException {
    protected void assertCounter(String message, Map<String, Object> response, String path, long expected) {
    }
import org.opensearch.client.Response;
    protected Map<String, Object> compositeIndexStats(String index, String... queryParams) throws IOException {
        return StatsITHelpers.hasPath(response, dottedPath);
        return StatsITHelpers.luceneIndexStats(getRestClient(), index, queryParams);
 * SPDX-License-Identifier: Apache-2.0
    }
 *
    }
    }  
    protected long getCounter(Map<String, Object> response, String dottedPath) {  
    protected void forceMerge(String index, int maxSegments) {
 * compatible open source license.
/**  
import java.io.IOException;  
    protected boolean hasPath(Map<String, Object> response, String dottedPath) {
 *
