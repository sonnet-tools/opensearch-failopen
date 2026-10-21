                        "\\[\\d+\\]\\[" + opaqueId + "\\]\\[OPTIONS\\]\\[/internal/testNotSeen\\] received request from \\[.*"
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
import org.opensearch.common.UUIDs;
    }
    private TransportAddress address(String host, int port) throws UnknownHostException {
                );
            -1,
 * specific language governing permissions and limitations
                        "received other request",
    public void testTracerLog() throws Exception {
                Settings.EMPTY,
                }
        final String excludeSettings;
import org.apache.logging.log4j.LogManager;
        return addresses;
 *
    }
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", otherBoundPort)),
import java.net.UnknownHostException;
                }
            publishPort = Transport.resolveTransportPublishPort(
                }
                            + (badRequest ? "BAD_REQUEST" : "OK")
            -1,
                protected HttpServerChannel bind(InetSocketAddress hostAddress) {
            getByName("127.0.0.1")
        );
                        Level.TRACE,
        }).build();
        return new RestResponse() {
                transport.incomingRequest(fakeRestRequest.getHttpRequest(), fakeRestRequest.getHttpChannel());
            assertNull(threadPool.getThreadContext().getTransient("bar"));
 * Unless required by applicable law or agreed to in writing,
                )
public class AbstractHttpServerTransportTests extends OpenSearchTestCase {
                    RestRequest.Method.OPTIONS
                @Override
        return address("127.0.0." + randomIntBetween(1, 100), randomIntBetween(9200, 9300));
            );
                threadPool,
 * GitHub history for details.
        assertThat("Publish port should be explicitly set to 9080", publishPort, equalTo(9080));
        if (threadPool != null) {
 * compatible open source license.
            addresses.add(randomAddress());
    }
                @Override
 * license agreements. See the NOTICE file distributed with
 */
                final FakeRestRequest fakeRestRequestExcludedPath = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withMethod(
    public void setup() throws Exception {
                xContentRegistry(),
                    inboundException = new RuntimeException();
import org.junit.Before;
                            + opaqueId
        assertThat("Publish port should be derived from matching wildcard address", publishPort, equalTo(boundPort));
 * KIND, either express or implied.  See the License for the
                }
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", boundPort)),
            }
import org.opensearch.tasks.Task;
                @Override
                    inboundException = null;
        networkService = new NetworkService(Collections.emptyList());
            asList(address("127.0.0.1", boundPort), address("127.0.0.2", otherBoundPort)),
                bigArrays,
            assertNull(threadPool.getThreadContext().getHeader("foo"));
            try (MockLogAppender appender = MockLogAppender.createForLoggers(LogManager.getLogger(traceLoggerName))) {
    }
                        Level.TRACE,
package org.opensearch.http;
                threadPool,
            -1,
 * You may obtain a copy of the License at
}
 * software distributed under the License is distributed on an
import org.opensearch.rest.RestRequest;
import org.opensearch.test.MockLogAppender;
                    )
import org.opensearch.common.util.MockBigArrays;
            ) {
                        "\\[\\d+\\]\\["
                }
        } else {
                networkService,
        publishPort = Transport.resolveTransportPublishPort(
import org.opensearch.common.util.MockPageCacheRecycler;
        assertThat("Publish port should be derived from matched address", publishPort, equalTo(boundPort));
                        traceLoggerName,
                clusterSettings,
        assertThat(publishPort, equalTo(-1));
                    .put(HttpTransportSettings.SETTING_HTTP_TRACE_LOG_EXCLUDE.getKey(), excludeSettings)
 * this work for additional information regarding copyright
            includeSettings = "/internal/test";
                final Exception inboundExceptionExcludedPath;
                    .withInboundException(inboundExceptionExcludedPath)
 * ownership. Elasticsearch licenses this file to you under
                getByName("::1")
    private TransportAddress randomAddress() throws UnknownHostException {
import org.opensearch.rest.RestResponse;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        ) {
        final String includeSettings;
import org.opensearch.core.common.bytes.BytesArray;
            }
                    RestRequest.Method.OPTIONS
        try (
            AbstractHttpServerTransport transport = new AbstractHttpServerTransport(
        return new TransportAddress(getByName(host), port);
import org.opensearch.transport.Transport;
                @Override
    }
        ) {
    @After
        threadPool = null;
                protected HttpServerChannel bind(InetSocketAddress hostAddress) {
                } else {
                final Exception inboundException;
                    new MockLogAppender.UnseenEventExpectation(
                    .withPath("/internal/testNotSeen")
                    .put(HttpTransportSettings.SETTING_HTTP_TRACE_LOG_INCLUDE.getKey(), includeSettings)
        List<TransportAddress> addresses = new ArrayList<>();
                return BytesArray.EMPTY;
import java.net.InetSocketAddress;
                        "received request",
        publishPort = Transport.resolveTransportPublishPort(
                    return null;
            }
            @Override
                    inboundExceptionExcludedPath = new RuntimeException();
import static java.util.Arrays.asList;
                Settings.EMPTY,
                    .build();
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
        publishPort = Transport.resolveTransportPublishPort(
                )
    public void testHttpPublishPort() throws Exception {
                NoopTracer.INSTANCE
                    .build()
                appender.assertAllExpectationsMatched();
        if (randomBoolean()) {
                    )
                final boolean badRequest = randomBoolean();
                    return null;
            @Override
 */
    @Before
                dispatcherBuilderWithDefaults().withDispatchRequest(
 * not use this file except in compliance with the License.
                if (badRequest) {
 * SPDX-License-Identifier: Apache-2.0
 *
                    .withPath("/internal/test")
            threadContext.putHeader("foo_bad", "bar");
            threadPool.shutdownNow();
                bigArrays,
                threadContext.putTransient("bar", "baz");
                        Level.TRACE,
 * The OpenSearch Contributors require contributions made to
                @Override
import org.opensearch.core.common.bytes.BytesReference;
                            + "\\]\\["
    private List<TransportAddress> randomAddresses() throws UnknownHostException {
                protected void stopInternal() {
import org.opensearch.common.network.NetworkUtils;
import org.opensearch.common.settings.Settings;
/*
            }
                threadContext.putHeader("foo", "bar");
        }
            @Override
                    return null;
            -1,
                } else {
                networkService,
                Settings.builder()
import org.apache.logging.log4j.Level;
    }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    new MockLogAppender.PatternSeenEventExpectation(
/*
            transport.dispatchRequest(null, null, null);
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            final String traceLoggerName = "org.opensearch.http.HttpTracer";
        assertThat("Publish port should be derived from unique port of bound addresses", publishPort, equalTo(boundPort));
        );
    private static RestResponse emptyResponse(RestStatus status) {
    @TestLogging(value = "org.opensearch.http.HttpTracer:trace", reason = "to ensure we log REST requests on TRACE level")
                    new MockLogAppender.PatternSeenEventExpectation(
                @Override
                }
import static org.opensearch.http.TestDispatcherBuilder.dispatcherBuilderWithDefaults;
import static java.net.InetAddress.getByName;
    private MockBigArrays bigArrays;
import org.opensearch.threadpool.ThreadPool;
            includeSettings = randomBoolean() ? "*" : "";
    private ThreadPool threadPool;
                @Override
import org.opensearch.test.junit.annotations.TestLogging;
        }
 * the Apache License, Version 2.0 (the "License"); you may
 */
                    .build(),
                @Override
                public HttpStats stats() {
            getByName("127.0.0.3")
                if (randomBoolean()) {
import org.opensearch.core.common.transport.TransportAddress;
            clusterSettings.applySettings(
import java.util.Collections;
            asList(address("0.0.0.0", boundPort), address("127.0.0.2", otherBoundPort)),
                        "sent response",
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                    inboundExceptionExcludedPath = null;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                            + "\\]\\[null\\]\\[0\\] sent response to \\[.*"
                            + "\\]\\["
        }
                xContentRegistry(),
                    return null;
                        traceLoggerName,
            public RestStatus status() {
import org.opensearch.common.settings.ClusterSettings;
                    .withDispatchBadRequest((channel, threadContext, cause) -> channel.sendResponse(emptyResponse(RestStatus.BAD_REQUEST)))
 * under the License.
            (request, channel, threadContext) -> {
    }
        bigArrays = null;
                final String opaqueId = UUIDs.randomBase64UUID(random());
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                appender.addExpectation(
                }
            assertNull(threadPool.getThreadContext().getTransient("bar_bad"));
        excludeSettings = "/internal/testNotSeen";
                dispatcher,
                protected void stopInternal() {
                    .withInboundException(inboundException)
                    (request, channel, threadContext) -> channel.sendResponse(emptyResponse(RestStatus.OK))
        );
                        traceLoggerName,
/*
                appender.addExpectation(
    }
import org.opensearch.test.rest.FakeRestRequest;
                            + (badRequest ? "400" : "200")
                asList(address("0.0.0.0", boundPort), address("127.0.0.2", otherBoundPort)),
                    .withHeaders(Collections.singletonMap(Task.X_OPAQUE_ID, Collections.singletonList(opaqueId)))
    public void shutdown() throws Exception {
        int boundPort = randomIntBetween(9000, 9100);
 * Modifications Copyright OpenSearch Contributors. See
            public BytesReference content() {
        int publishPort = Transport.resolveTransportPublishPort(9080, randomAddresses(), getByName("127.0.0.2"));
            ) {
                -1,
                )
                    .build();
        int otherBoundPort = randomIntBetween(9200, 9300);
                );
import org.junit.After;
                }
import java.util.ArrayList;
        ).withDispatchBadRequest((channel, threadContext, cause) -> {
                }
            getByName("127.0.0.1")
            }
    }
                final FakeRestRequest fakeRestRequest = new FakeRestRequest.Builder(NamedXContentRegistry.EMPTY).withMethod(
import static org.hamcrest.Matchers.equalTo;
                    )
 * this file be licensed under the Apache-2.0 license or a
                appender.addExpectation(
            threadContext.putTransient("bar_bad", "baz");
                protected void doStart() {
                        "\\[\\d+\\]\\[" + opaqueId + "\\]\\[OPTIONS\\]\\[/internal/test\\] received request from \\[.*"
                return null;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.network.NetworkService;
        networkService = null;
    public void testDispatchDoesNotModifyThreadContext() {
        try (
            getByName("127.0.0.3")
            transport.dispatchRequest(null, null, new Exception());
        HttpServerTransport.Dispatcher dispatcher = dispatcherBuilderWithDefaults().withDispatchRequest(
 * Licensed to Elasticsearch under one or more contributor
            public String contentType() {
                transport.incomingRequest(fakeRestRequestExcludedPath.getHttpRequest(), fakeRestRequestExcludedPath.getHttpChannel());
        publishPort = Transport.resolveTransportPublishPort(
    private NetworkService networkService;
        threadPool = new TestThreadPool("test");
                }
import org.opensearch.threadpool.TestThreadPool;
        }
            }
        }
            AbstractHttpServerTransport transport = new AbstractHttpServerTransport(
        };
            );
        );
        }
                return status;
                protected void doStart() {
                );
                NoopTracer.INSTANCE
            }
        if (NetworkUtils.SUPPORTS_V6) {
            assertNull(threadPool.getThreadContext().getHeader("foo_bad"));
            assertThat("Publish port should be derived from matching wildcard address", publishPort, equalTo(boundPort));
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
                public HttpStats stats() {
import org.opensearch.core.rest.RestStatus;
                    .withHeaders(Collections.singletonMap(Task.X_OPAQUE_ID, Collections.singletonList(opaqueId)))
