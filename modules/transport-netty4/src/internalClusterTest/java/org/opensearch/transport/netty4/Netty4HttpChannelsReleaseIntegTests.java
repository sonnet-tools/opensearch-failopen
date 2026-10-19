    }
import static org.hamcrest.Matchers.equalTo;
        // - there are at least 2 nodes in the cluster (master + data)  
import org.opensearch.test.OpenSearchIntegTestCase;  
     *
 */  
        assertAcked(client().admin().indices().prepareCreate(testIndex));
import java.io.IOException;
 * compatible open source license.
    @After
import org.opensearch.search.builder.SearchSourceBuilder;
 * SPDX-License-Identifier: Apache-2.0
        // it is difficult to match the exact number of HTTP channels since:
import org.opensearch.client.Request;
    /**
        // be wrapped around, inflating the number of HTTP channels being tracked
            assertThat(response.getStatusLine().getStatusCode(), anyOf(equalTo(200), equalTo(201)));
import org.opensearch.client.Response;  
     */  
import org.opensearch.threadpool.TestThreadPool;
 * The OpenSearch Contributors require contributions made to  
        try {
public class Netty4HttpChannelsReleaseIntegTests extends OpenSearchNetty4IntegTestCase {
    }
     * @param index the index to search against
        for (int i = 0; i < numChannels; i++) {
        );
 *
    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            request.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
            "All channels remain open",
        }
        String testIndex = "test_idx";
package org.opensearch.transport.netty4;
        }  
            RestCancellableNodeClient.getNumChannels(),
        } catch (IOException e) {
                countDownLatch.countDown();
    public void testAcceptedChannelsGetCleanedUpOnTheNodeShutdown() throws InterruptedException {  
import java.util.concurrent.TimeUnit;  
import org.opensearch.OpenSearchNetty4IntegTestCase;
        // - there is 10 connections per route default setting (RestClient)
        threadPool = new TestThreadPool(getClass().getName());
 * this file be licensed under the Apache-2.0 license or a
    }
    protected boolean addMockHttpTransport() {
import java.util.concurrent.CountDownLatch;
            throw new IllegalStateException("Failed to execute the request", e);  
     * Execute a Search request against the given index. The Search requests are tracked
        assertThat(  
        int numChannels = randomIntBetween(50, 100);
import org.opensearch.rest.action.RestCancellableNodeClient;
    private ThreadPool threadPool;  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
                executeRequest(testIndex);  
            });
    @Override
    @Before
            Response response = getRestClient().performRequest(request);  
    public void createThreadPool() {  
            SearchSourceBuilder searchSource = new SearchSourceBuilder().query(new MatchAllQueryBuilder());
    public void stopThreadPool() {
        int initialHttpChannels = RestCancellableNodeClient.getNumChannels();
import org.junit.After;
import static org.hamcrest.Matchers.anyOf;  
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)
     * by the RestCancellableNodeClient to verify that channels are released properly.  
import org.opensearch.index.query.MatchAllQueryBuilder;  
}  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        return false; // enable http  
        // no channels get closed in this test, hence we expect as many channels as we created in the map at most  
import org.junit.Before;
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.threadpool.ThreadPool;  
    }
            threadPool.generic().execute(() -> {
        // - if additional plugins are used (like telemetry), the same HTTP channel may
import org.opensearch.core.common.Strings;
        countDownLatch.await();
    private static void executeRequest(String index) {
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);  
            Request request = new Request("GET", "/" + index + "/_search");  
/*  
        CountDownLatch countDownLatch = new CountDownLatch(numChannels);  
            greaterThanOrEqualTo(initialHttpChannels + 10 /* default connections per route */)  
