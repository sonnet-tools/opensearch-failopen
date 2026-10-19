        final NodesStatsResponse stats = client().admin().cluster().prepareNodesStats().addMetric(BREAKER.metricName()).get();  
/**  
    }
 * correlation intact, the node remains responsive, and the breaker reservation is released exactly once.
 * in opensearch-project/OpenSearch#22311.
 * compatible open source license.
        assertBusy(() -> assertThat(inFlightRequestsEstimatedBytes(), equalTo(baseline)));  
import org.opensearch.client.RequestOptions;
        assertThat(body, containsString(TestResponseFailureRestAction.FAILURE_MESSAGE));  
 * client received no status line. The tests assert that the structured error reaches the client with request  
import org.opensearch.core.rest.RestStatus;  
}
     */
        return plugins;  
        final Request request = new Request("POST", TestResponseFailureRestAction.ROUTE);  
        assertThat(body, containsString("\"status\":" + RestStatus.REQUEST_ENTITY_TOO_LARGE.getStatus()));
import static org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest.Metric.BREAKER;
 * The OpenSearch Contributors require contributions made to  
        long estimated = 0L;
        EntityUtils.consume(healthResponse.getEntity());
import org.opensearch.test.OpenSearchIntegTestCase.Scope;  
    }
import org.opensearch.client.Response;  
     * what the HTTP request under test reserved and released.  
 * rejected the initial response after the breaker release, the error response was rejected as a second send and the
        final long baseline = inFlightRequestsEstimatedBytes();
 * <p>  
        request.setOptions(RequestOptions.DEFAULT.toBuilder().addHeader("X-Opaque-Id", OPAQUE_ID).build());
            estimated += nodeStats.getBreaker().getStats(CircuitBreaker.IN_FLIGHT_REQUESTS).getEstimated();  
    public void testRequestEntityTooLargeResponseIsSentWhenResponseBodyCannotBeSerialized() throws Exception {  
 *
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)  
        final Response healthResponse = getRestClient().performRequest(new Request("GET", "/_cluster/health"));  
     * request used to read it, so the absolute value is never zero. Comparing two readings taken the same way isolates
        for (final NodeStats nodeStats : stats.getNodes()) {
     */
    public void testInFlightRequestsBreakerIsReleasedWhenResponseBodyCannotBeSerialized() throws Exception {
public class RestResponseFailureIT extends HttpSmokeTestCase {
        final ResponseException exception = expectThrows(
import org.opensearch.core.common.breaker.CircuitBreaker;
        return estimated;
 * Verifies the REST layer still answers the client when downstream response preparation fails, the regression reported
        plugins.add(TestResponseFailurePlugin.class);
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
    }
     * subtracted twice.
import org.opensearch.client.Request;
     * The request carries a body so the in-flight-requests breaker reserves a non-zero number of bytes for it.  
        expectThrows(ResponseException.class, () -> getRestClient().performRequest(responseFailureRequest()));
/*  
        assertThat(response.getStatusLine().getStatusCode(), equalTo(RestStatus.REQUEST_ENTITY_TOO_LARGE.getStatus()));
        );
package org.opensearch.http;
    /**
import static org.hamcrest.Matchers.containsString;  
            ResponseException.class,
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
    }  
        final String body = EntityUtils.toString(response.getEntity());
     */  
import java.util.ArrayList;
import org.opensearch.client.ResponseException;
        final Response response = exception.getResponse();  
    private static final String OPAQUE_ID = "response-serialization-failure-it";  
    /**  
 */  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.plugins.Plugin;
        request.setJsonEntity("{\"probe\":\"response-serialization-failure\"}");
    }  
     * The in-flight-requests breaker is shared with the transport layer, which reserves bytes for the very node stats
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    /**
import java.util.Collection;  
 * Before the fix, one flag represented both "request bytes released" and "response sent". If a downstream channel
    @Override
        assertThat(healthResponse.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));
    private static Request responseFailureRequest() {
        assertThat(body, containsString("\"type\":\"status_exception\""));
import static org.hamcrest.Matchers.equalTo;
        }
    private long inFlightRequestsEstimatedBytes() {
 */
        return request;  
import org.apache.hc.core5.http.io.entity.EntityUtils;
        final ArrayList<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
     * follow-up failure response reuses the channel, so the breaker must be released exactly once - neither leaked nor
        assertThat(response.getHeader("X-Opaque-Id"), equalTo(OPAQUE_ID));
     * The first response attempt releases the request-byte reservation before the downstream channel rejects it. The  
            () -> getRestClient().performRequest(responseFailureRequest())  
 * this file be licensed under the Apache-2.0 license or a
