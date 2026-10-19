                appender.addExpectation(
 * Modifications Copyright OpenSearch Contributors. See
    }  
import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.RestRequest;
                protected void doStart() {
    private TransportAddress randomAddress() throws UnknownHostException {
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(traceLoggerName))) {  
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
                final Exception inboundException;
            getByName("127.0.0.1")
        );
                appender.addExpectation(
                    .put(HttpTransportSettings.SETTING_HTTP_TRACE_LOG_INCLUDE.getKey(), includeSettings)
import java.net.InetSocketAddress;  
    @TestLogging(value = "org.opensearch.http.HttpTracer:trace", reason = "to ensure we log REST requests on TRACE level")
    }
                            + "\\]\\["
            asList(address("0.0.0.0", boundPort), address("127.0.0.2", otherBoundPort)),
import static org.hamcrest.Matchers.equalTo;  
                @Override
                protected void doStart() {  
                    .withPath("/internal/test")
import org.opensearch.test.OpenSearchTestCase;  
            public String contentType() {  
            includeSettings = randomBoolean() ? "*" : "";
        publishPort = Transport.resolveTransportPublishPort(  
            );
            }  
import java.util.Collections;  
        return new RestResponse() {
}
                asList(address("0.0.0.0", boundPort), address("127.0.0.2", otherBoundPort)),  
                }
            AbstractHttpServerTransport transport = new AbstractHttpServerTransport(
            assertNull(threadPool.getThreadContext().getHeader("foo_bad"));  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
    public void setup() throws Exception {  
                @Override  
        } else {
import org.opensearch.common.network.NetworkService;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                protected void stopInternal() {
                            + (badRequest ? "400" : "200")
                    new MockLogAppender.UnseenEventExpectation(
 * software distributed under the License is distributed on an
        int boundPort = randomIntBetween(9000, 9100);
                public HttpStats stats() {
import org.junit.After;  
    private List<TransportAddress> randomAddresses() throws UnknownHostException {  
                xContentRegistry(),  
                            + opaqueId
            transport.dispatchRequest(null, null, null);
import org.opensearch.test.rest.FakeRestRequest;
 * not use this file except in compliance with the License.
        try (  
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
import org.opensearch.common.settings.ClusterSettings;  
 */
            (request, channel, threadContext) -> {  
                }
                        traceLoggerName,
                } else {  
                );  
                threadContext.putTransient("bar", "baz");
                    return null;
            AbstractHttpServerTransport transport = new AbstractHttpServerTransport(  
            }
                    .build()  
import org.opensearch.common.settings.Settings;
            }  
            threadContext.putHeader("foo_bad", "bar");
            threadContext.putTransient("bar_bad", "baz");  
                return null;
                Settings.builder()  
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
        ) {
        return new TransportAddress(getByName(host), port);
            includeSettings = "/internal/test";  
                            + "\\]\\[null\\]\\[0\\] sent response to \\[.*"  
        assertThat("Publish port should be derived from matched address", publishPort, equalTo(boundPort));
                    inboundException = new RuntimeException();  
        assertThat(publishPort, equalTo(-1));  
                    new MockLogAppender.PatternSeenEventExpectation(
                            + "\\]\\["
        ).withDispatchBadRequest((channel, threadContext, cause) -> {
 *
 * compatible open source license.
import org.opensearch.transport.Transport;
/*  
import org.opensearch.common.util.MockPageCacheRecycler;  
import org.opensearch.threadpool.TestThreadPool;  
                final String opaqueId = UUIDs.randomBase64UUID(random());
        try (
public class AbstractHttpServerTransportTests extends OpenSearchTestCase {
                threadPool,
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        }
                    .build();
                        "received other request",  
            -1,
            }
import java.net.UnknownHostException;
        }).build();
                transport.incomingRequest(fakeRestRequest.getHttpRequest(), fakeRestRequest.getHttpChannel());
                )
                    inboundExceptionExcludedPath = null;
        );
        int otherBoundPort = randomIntBetween(9200, 9300);  
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", otherBoundPort)),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                @Override  
                        "\\[\\d+\\]\\[" + opaqueId + "\\]\\[OPTIONS\\]\\[/internal/test\\] received request from \\[.*"
                appender.assertAllExpectationsMatched();
                if (badRequest) {
        }
 * this file be licensed under the Apache-2.0 license or a
                @Override
                final Exception inboundExceptionExcludedPath;  
    private ThreadPool threadPool;
                dispatcher,
            publishPort = Transport.resolveTransportPublishPort(
import static java.util.Arrays.asList;
        };
                    (request, channel, threadContext) -> channel.sendResponse(emptyResponse(RestStatus.OK))
    }  
                protected HttpServerChannel bind(InetSocketAddress hostAddress) {
 * ownership. Elasticsearch licenses this file to you under  
                NoopTracer.INSTANCE  
        }  
            -1,
import org.apache.logging.log4j.Level;
                clusterSettings,
        if (threadPool != null) {
    private NetworkService networkService;
            );
        networkService = null;  
            @Override  
 * SPDX-License-Identifier: Apache-2.0
                );
                    RestRequest.Method.OPTIONS
                networkService,
 * You may obtain a copy of the License at  
                if (randomBoolean()) {
                protected void stopInternal() {
                }
import org.opensearch.core.common.transport.TransportAddress;  
    private TransportAddress address(String host, int port) throws UnknownHostException {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        threadPool = new TestThreadPool("test");
import org.opensearch.core.common.bytes.BytesReference;
        }
                @Override
            }
                        "\\[\\d+\\]\\["  
                        Level.TRACE,  
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
            @Override
                public HttpStats stats() {  
                final boolean badRequest = randomBoolean();
        return address("127.0.0." + randomIntBetween(1, 100), randomIntBetween(9200, 9300));  
    @Before
                }  
/*  
                    .build();
        assertThat("Publish port should be derived from matching wildcard address", publishPort, equalTo(boundPort));
                @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.threadpool.ThreadPool;
                    .withInboundException(inboundExceptionExcludedPath)  
            ) {
                        traceLoggerName,
                }  
            @Override
                Settings.EMPTY,
        publishPort = Transport.resolveTransportPublishPort(
                }
    }
            assertThat("Publish port should be derived from matching wildcard address", publishPort, equalTo(boundPort));  
        );  
            -1,  
                        Level.TRACE,
 *
                }
    }  
        );  
 */  
 * KIND, either express or implied.  See the License for the
    public void testTracerLog() throws Exception {  
                    .withHeaders(Collections.singletonMap(Task.X_OPAQUE_ID, Collections.singletonList(opaqueId)))  
 * this work for additional information regarding copyright
            assertNull(threadPool.getThreadContext().getHeader("foo"));
                            + (badRequest ? "BAD_REQUEST" : "OK")  
        if (randomBoolean()) {  
        return addresses;
    @After  
            getByName("127.0.0.3")
                return BytesArray.EMPTY;  
                }  
                    RestRequest.Method.OPTIONS  
                bigArrays,
    }
            public RestStatus status() {
import org.opensearch.common.util.MockBigArrays;
                    .withDispatchBadRequest((channel, threadContext, cause) -> channel.sendResponse(emptyResponse(RestStatus.BAD_REQUEST)))  
            }
                bigArrays,  
                    )
                @Override
        threadPool = null;
                networkService,  
                        Level.TRACE,
    }
                    .build(),
                } else {
        List<TransportAddress> addresses = new ArrayList<>();
            addresses.add(randomAddress());  
            getByName("127.0.0.1")
 * the Apache License, Version 2.0 (the "License"); you may
                Settings.EMPTY,
            threadPool.shutdownNow();  
                    )
        ) {
import java.util.ArrayList;
        }
    private static RestResponse emptyResponse(RestStatus status) {  
                threadContext.putHeader("foo", "bar");
                        traceLoggerName,
            assertNull(threadPool.getThreadContext().getTransient("bar"));  
 * Licensed to Elasticsearch under one or more contributor  
                        "sent response",  
                final FakeRestRequest fakeRestRequestExcludedPath = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withMethod(
 * GitHub history for details.
        assertThat("Publish port should be derived from unique port of bound addresses", publishPort, equalTo(boundPort));
                xContentRegistry(),
package org.opensearch.http;
                        "received request",
    }
 * license agreements. See the NOTICE file distributed with
    private MockBigArrays bigArrays;  
                transport.incomingRequest(fakeRestRequestExcludedPath.getHttpRequest(), fakeRestRequestExcludedPath.getHttpChannel());  
                dispatcherBuilderWithDefaults().withDispatchRequest(  
    public void shutdown() throws Exception {
                    .withInboundException(inboundException)
            public BytesReference content() {
 */  
                    new MockLogAppender.PatternSeenEventExpectation(  
        if (NetworkUtils.SUPPORTS_V6) {  
                    return null;
            assertNull(threadPool.getThreadContext().getTransient("bar_bad"));
                final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withMethod(
                @Override  
import org.opensearch.tasks.Task;  
import org.opensearch.core.common.bytes.BytesArray;
import org.junit.Before;
        publishPort = Transport.resolveTransportPublishPort(
            final String traceLoggerName = "org.opensearch.http.HttpTracer";
                )
                    inboundExceptionExcludedPath = new RuntimeException();
import static java.net.InetAddress.getByName;  
        final String excludeSettings;
        int publishPort = Transport.resolveTransportPublishPort(9080, randomAddresses(), getByName("127.0.0.2"));
import java.util.List;
        final String includeSettings;
            getByName("127.0.0.3")  
                );
                }
            -1,  
                    )
                appender.addExpectation(
    public void testDispatchDoesNotModifyThreadContext() {
import org.opensearch.common.network.NetworkUtils;
/*
            transport.dispatchRequest(null, null, new Exception());
    public void testHttpPublishPort() throws Exception {
                return status;
                protected HttpServerChannel bind(InetSocketAddress hostAddress) {  
                    return null;
    }
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", boundPort)),
        excludeSettings = "/internal/testNotSeen";
                    inboundException = null;
import org.apache.logging.log4j.LogManager;
                }  
            clusterSettings.applySettings(
import org.opensearch.common.UUIDs;  
                    return null;
                        "\\[\\d+\\]\\[" + opaqueId + "\\]\\[OPTIONS\\]\\[/internal/testNotSeen\\] received request from \\[.*"  
 * The OpenSearch Contributors require contributions made to  
                )  
        assertThat("Publish port should be explicitly set to 9080", publishPort, equalTo(9080));  
 * under the License.  
                getByName("::1")
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", otherBoundPort)),  
 *  
 * specific language governing permissions and limitations
                threadPool,
                    .withPath("/internal/testNotSeen")
                NoopTracer.INSTANCE  
                    .withHeaders(Collections.singletonMap(Task.X_OPAQUE_ID, Collections.singletonList(opaqueId)))
        networkService = new NetworkService(Collections.emptyList());
                -1,
        bigArrays = null;
import org.opensearch.test.MockLogAppender;
        publishPort = Transport.resolveTransportPublishPort(
import org.opensearch.rest.RestResponse;
import org.opensearch.test.junit.annotations.TestLogging;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            }  
            ) {
                    .put(HttpTransportSettings.SETTING_HTTP_TRACE_LOG_EXCLUDE.getKey(), excludeSettings)
