                NoopTracer.INSTANCE
    }
        CustomHttpChannelHandler(Netty4HttpServerTransport transport, ExecutorService executorService) {
        final Settings settings = Settings.builder().put("http.port", "0").build();
import org.opensearch.common.settings.Settings;
import io.netty.channel.Channel;
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.settings.ClusterSettings;
        private final ExecutorService executorService = Executors.newCachedThreadPool();
package org.opensearch.http.netty4;
        private final ExecutorService executorService;
import io.netty.channel.ChannelPromise;
    }
 * Unless required by applicable law or agreed to in writing,
            } finally {
        @Override
        private ChannelHandlerContext ctx;
            super(transport, transport.handlingSettings, HttpResponseHeadersFactories.newDefault());
import io.netty.buffer.Unpooled;
import org.opensearch.transport.SharedGroupFactory;
        }
        public void run() {
    public void testThatHttpPipeliningWorks() throws Exception {
import java.util.List;
 * this work for additional information regarding copyright
            final List<String> requests = new ArrayList<>(numberOfRequests);
            return new CustomHttpChannelHandler(this, executorService);
                if (rarely()) {
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
import org.opensearch.core.rest.RestStatus;
        }
 * this file be licensed under the Apache-2.0 license or a
 */
 * This test just tests, if he pipelining works in general with out any connection the OpenSearch handler
 * The OpenSearch Contributors require contributions made to
        protected void channelRead0(ChannelHandlerContext ctx, HttpPipelinedRequest msg) throws Exception {
                final ChannelPromise promise = ctx.newPromise();
        }
import org.opensearch.http.NullDispatcher;
import org.opensearch.threadpool.ThreadPool;
    @Before
            this.executorService = executorService;
import java.nio.charset.StandardCharsets;
    }
import org.opensearch.http.HttpResponse;
            try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http()) {
/**
            super.initChannel(ch);
 * SPDX-License-Identifier: Apache-2.0
                    }
            );
            final TransportAddress transportAddress = randomFrom(httpServerTransport.boundAddress().boundAddresses());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import java.util.ArrayList;
import org.junit.Before;
import java.util.Collections;
        @Override
        }
                xContentRegistry(),
    private ThreadPool threadPool;
 * GitHub history for details.
        }
        }
                if (slow) {
/*
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
                new SharedGroupFactory(settings),
        @Override
import io.netty.channel.SimpleChannelInboundHandler;
import org.opensearch.core.common.bytes.BytesArray;
        @Override
            this.executorService = executorService;
        CustomNettyHttpServerTransport(final Settings settings) {
                } else {
            super.doClose();
public class Netty4HttpServerPipeliningTests extends OpenSearchTestCase {
                );
import org.opensearch.common.network.NetworkService;
import io.netty.handler.codec.http.FullHttpResponse;
    }
        PossiblySlowRunnable(ChannelHandlerContext ctx, HttpPipelinedRequest msg) {
                    assert uri.matches("/\\d+");
/*
            }
import org.junit.After;
                } else {
 *
        }
                }
                final ByteBuf buffer = Unpooled.copiedBuffer(uri, StandardCharsets.UTF_8);
                Netty4HttpServerPipeliningTests.this.bigArrays,
                Netty4HttpServerPipeliningTests.this.threadPool,
                Netty4HttpServerPipeliningTests.this.networkService,
 *
 */
        PossiblySlowUpstreamHandler(ExecutorService executorService) {
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
    private NetworkService networkService;
                HttpResponse response = pipelinedRequest.createResponse(
import io.netty.channel.ChannelHandlerContext;
        }
import org.opensearch.http.HttpServerTransport;
            this.pipelinedRequest = msg;
        threadPool = new TestThreadPool("test");
            }
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                new NullDispatcher(),
    class PossiblySlowRunnable implements Runnable {
                    RestStatus.OK,
        }
                Collection<FullHttpResponse> responses = nettyHttpClient.get(transportAddress.address(), requests.toArray(new String[] {}));
            executorService.shutdown();
        }
        try (HttpServerTransport httpServerTransport = new CustomNettyHttpServerTransport(settings)) {
import java.util.concurrent.ExecutorService;
 * compatible open source license.
                    try {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.Executors;
    public void shutdown() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        @Override
                pipelinedRequest.release();
                settings,
        private final ExecutorService executorService;
        if (threadPool != null) {
                    responses.forEach(ReferenceCounted::release);
import org.opensearch.core.common.transport.TransportAddress;
        private HttpPipelinedRequest pipelinedRequest;
/*
        public ChannelHandler configureServerChannelHandler() {
 * Licensed to Elasticsearch under one or more contributor
import io.netty.channel.ChannelHandler;
}
            this.ctx = ctx;
                final boolean slow = uri.matches("/slow/\\d+");
        protected void initChannel(Channel ch) throws Exception {
            executorService.submit(new PossiblySlowRunnable(ctx, msg));
            threadPool.shutdownNow();
        @Override
            final int numberOfRequests = randomIntBetween(4, 16);
                response.addHeader("content-length", Integer.toString(buffer.readableBytes()));
                }
                        Thread.sleep(scaledRandomIntBetween(500, 1000));
    private class CustomHttpChannelHandler extends Netty4HttpServerTransport.HttpChannelHandler {
 * You may obtain a copy of the License at
    }
        protected void doClose() {
                    Collection<String> responseBodies = Netty4HttpClient.returnHttpResponseBodies(responses);
import java.util.Collection;
 *
 * specific language governing permissions and limitations
import org.opensearch.test.OpenSearchTestCase;
            return new PossiblySlowUpstreamHandler(executorService);
import org.opensearch.threadpool.TestThreadPool;
            }
                        throw new RuntimeException(e);
                } finally {
                    } catch (InterruptedException e) {
                ctx.writeAndFlush(response, promise);
    @After
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());
            httpServerTransport.start();
                final String uri = pipelinedRequest.uri();
    class CustomNettyHttpServerTransport extends Netty4HttpServerTransport {
        }
 * under the License.
import org.opensearch.common.util.MockPageCacheRecycler;
    private MockBigArrays bigArrays;
            for (int i = 0; i < numberOfRequests; i++) {
                }
            super(
            ctx.channel().close().sync();
import io.netty.util.ReferenceCounted;
import org.opensearch.http.HttpPipelinedRequest;
    }
 * KIND, either express or implied.  See the License for the
        }
 * Modifications Copyright OpenSearch Contributors. See
                    requests.add("/slow/" + i);
            try {
 */
            logger.info("Caught exception", cause);
        public ChannelHandler getRequestHandler() {
import org.opensearch.common.util.MockBigArrays;
 */
import io.netty.buffer.ByteBuf;
    }
    class PossiblySlowUpstreamHandler extends SimpleChannelInboundHandler<HttpPipelinedRequest> {
        networkService = new NetworkService(Collections.emptyList());
                try {
import static org.hamcrest.Matchers.contains;
 * software distributed under the License is distributed on an
                    requests.add("/" + i);
        @Override
                    new BytesArray(uri.getBytes(StandardCharsets.UTF_8))
                    assertThat(responseBodies, contains(requests.toArray()));
    public void setup() throws Exception {
        }
