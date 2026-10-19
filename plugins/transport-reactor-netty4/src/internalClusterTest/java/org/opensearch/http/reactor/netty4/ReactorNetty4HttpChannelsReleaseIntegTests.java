        String testIndex = "test_idx";  
     * by the RestCancellableNodeClient to verify that channels are released properly.  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void stopThreadPool() {
    @After  
import org.junit.After;
    private ThreadPool threadPool;
                executeRequest(testIndex);
import org.opensearch.OpenSearchReactorNetty4IntegTestCase;
     * Execute a Search request against the given index. The Search requests are tracked
/*  
        return false; // enable http
    public void createThreadPool() {
import org.opensearch.threadpool.TestThreadPool;
     * @param index the index to search against
import org.opensearch.client.Request;
        countDownLatch.await();  
    }  
import org.opensearch.search.builder.SearchSourceBuilder;
        try {
import org.opensearch.test.OpenSearchIntegTestCase;  
        assertAcked(client().admin().indices().prepareCreate(testIndex));
    @Override  
    /**
    }
        // The Project Reactor creates an ephemeral connection over Netty channel all the time and run request / response conversation over
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
    }
import org.opensearch.core.common.Strings;
    @Before
 * The OpenSearch Contributors require contributions made to  
 */  
    private static void executeRequest(String index) {
            request.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
            assertThat(response.getStatusLine().getStatusCode(), anyOf(equalTo(200), equalTo(201)));
        int initialHttpChannels = RestCancellableNodeClient.getNumChannels();  
import static org.hamcrest.Matchers.equalTo;
        } catch (IOException e) {
        // it. The underlying HttpChannel / RestChannel instances are always closed once the response is delivered.  
import org.opensearch.client.Response;  
        }
            throw new IllegalStateException("Failed to execute the request", e);  
        threadPool = new TestThreadPool(getClass().getName());  
        CountDownLatch countDownLatch = new CountDownLatch(numChannels);
        for (int i = 0; i < numChannels; i++) {  
    }  
    public void testAcceptedChannelsGetCleanedUpOnTheNodeShutdown() throws InterruptedException {
import java.util.concurrent.TimeUnit;  
import java.util.concurrent.CountDownLatch;
            SearchSourceBuilder searchSource = new SearchSourceBuilder().query(new MatchAllQueryBuilder());
            });
@ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, supportsDedicatedMasters = false, numDataNodes = 1)  
import org.junit.Before;
            Request request = new Request("GET", "/" + index + "/_search");  
    protected boolean addMockHttpTransport() {
        assertThat("All channels are closed", RestCancellableNodeClient.getNumChannels(), equalTo(initialHttpChannels));
 * SPDX-License-Identifier: Apache-2.0
     */  
public class ReactorNetty4HttpChannelsReleaseIntegTests extends OpenSearchReactorNetty4IntegTestCase {
                countDownLatch.countDown();  
}
import static org.hamcrest.Matchers.anyOf;  
        }
import org.opensearch.rest.action.RestCancellableNodeClient;
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 *
     *
 * compatible open source license.
import org.opensearch.index.query.MatchAllQueryBuilder;  
package org.opensearch.http.reactor.netty4;
import org.opensearch.threadpool.ThreadPool;  
            Response response = getRestClient().performRequest(request);  
        int numChannels = randomIntBetween(50, 100);
    }
 * this file be licensed under the Apache-2.0 license or a
            threadPool.generic().execute(() -> {
import java.io.IOException;
