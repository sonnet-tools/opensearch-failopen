 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        ) {  
                settings,
            try (ReactorHttpClient nettyHttpClient = ReactorHttpClient.create(settings)) {
                bigArrays,
    public void setup() {  
        ).withDispatchBadRequest((channel, threadContext, cause) -> {
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
import io.netty.handler.codec.http.FullHttpResponse;  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    final Collection<String> responseBodies = ReactorHttpClient.returnHttpResponseBodies(responses);
                    final String body = responseBodies.iterator().next();
            }
            )
                    );  
            try {  
        terminate(threadPool);
                    final FullHttpResponse response = responses.get(0);  
                xContentRegistry(),  
                dispatcher,
    private NetworkService networkService;
import org.opensearch.http.HttpServerTransport;
import java.util.Collections;  
            httpServerTransport.start();
            final TransportAddress transportAddress = randomFrom(httpServerTransport.boundAddress().boundAddresses());
 */  
            }
                NoopTracer.INSTANCE
        }
import org.opensearch.http.HttpTransportSettings;
    public void testBadParameterEncoding() throws Exception {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                        body,
                try {
import static org.hamcrest.Matchers.containsString;
public class ReactorNetty4BadRequestTests extends OpenSearchTestCase {
 * compatible open source license.
import org.opensearch.common.settings.Settings;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.transport.reactor.SharedGroupFactory;
import org.junit.After;  
import static org.hamcrest.Matchers.equalTo;
                    responses.forEach(ReferenceCounted::release);
                    assertThat(responses, hasSize(1));
package org.opensearch.http.reactor.netty4;
                new SharedGroupFactory(Settings.EMPTY),  
        }).build();  
        networkService = new NetworkService(Collections.emptyList());
import org.opensearch.common.util.MockBigArrays;
            (request, channel, threadContext) -> fail()
                } finally {
        threadPool = new TestThreadPool("test");  
                throw new UncheckedIOException(e);
                    assertThat(responseBodies, hasSize(1));  
    private MockBigArrays bigArrays;
    }  
    @Before
                channel.sendResponse(new BytesRestResponse(channel, RestStatus.BAD_REQUEST, e));
}
        final HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.network.NetworkService;
import org.opensearch.rest.BytesRestResponse;  
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
        Settings settings = Settings.builder().put(HttpTransportSettings.SETTING_HTTP_PORT.getKey(), getPortRange()).build();
import org.opensearch.core.rest.RestStatus;  
import org.opensearch.threadpool.TestThreadPool;  
import org.opensearch.common.settings.ClusterSettings;  
import java.util.List;
import io.netty.util.ReferenceCounted;
import java.io.UncheckedIOException;
                        containsString("\"reason\":\"java.lang.IllegalArgumentException: partial escape sequence at end of string: %/\"")
import org.junit.Before;
import org.opensearch.threadpool.ThreadPool;
 *
import org.opensearch.core.common.transport.TransportAddress;
                    assertThat(body, containsString("\"type\":\"bad_parameter_exception\""));
                threadPool,
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;  
        try (  
import static org.hamcrest.Matchers.hasSize;  
            } catch (final IOException e) {  
                }  
                networkService,  
                final List<FullHttpResponse> responses = nettyHttpClient.get(transportAddress.address(), "/_cluster/settings?pretty=%");
    }
                    assertThat(  
    }  
import org.opensearch.OpenSearchException;
import org.opensearch.common.util.MockPageCacheRecycler;  
            HttpServerTransport httpServerTransport = new ReactorNetty4HttpServerTransport(
/*  
    private ThreadPool threadPool;  
    @After  
    public void shutdown() {
                    assertThat(response.status().code(), equalTo(400));
import java.util.Collection;
                final Exception e = cause instanceof Exception ? (Exception) cause : new OpenSearchException(cause);
