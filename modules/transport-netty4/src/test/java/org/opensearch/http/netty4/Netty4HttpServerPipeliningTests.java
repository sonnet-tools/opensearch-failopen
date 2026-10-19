            logger.info("Caught exception", cause);
            return new CustomHttpChannelHandler(this, executorService);
                if (slow) {
    }
 * Unless required by applicable law or agreed to in writing,
import org.junit.Before;
        @Override
                        Thread.sleep(scaledRandomIntBetween(500, 1000));
                    new BytesArray(uri.getBytes(StandardCharsets.UTF_8))  
        private ChannelHandlerContext ctx;
        try (HttpServerTransport httpServerTransport = new CustomNettyHttpServerTransport(settings)) {  
import org.opensearch.core.common.bytes.BytesArray;  
                Netty4HttpServerPipeliningTests.this.networkService,  
import io.netty.buffer.ByteBuf;  
        private final ExecutorService executorService;
        CustomHttpChannelHandler(Netty4HttpServerTransport transport, ExecutorService executorService) {
    class PossiblySlowRunnable implements Runnable {
                ctx.writeAndFlush(response, promise);
import org.opensearch.transport.SharedGroupFactory;  
        PossiblySlowUpstreamHandler(ExecutorService executorService) {  
import java.util.List;
    public void shutdown() throws Exception {
                if (rarely()) {
    class PossiblySlowUpstreamHandler extends SimpleChannelInboundHandler<HttpPipelinedRequest> {
import org.opensearch.http.NullDispatcher;
import org.opensearch.threadpool.ThreadPool;
            } finally {
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            );
        }
        networkService = new NetworkService(Collections.emptyList());
import io.netty.channel.Channel;
                    requests.add("/slow/" + i);
                }
 * You may obtain a copy of the License at  
        public ChannelHandler configureServerChannelHandler() {  
        private final ExecutorService executorService;
                }
 * specific language governing permissions and limitations
        @Override  
 */
        }  
                try {
import java.util.Collections;
            this.pipelinedRequest = msg;  
        @Override
                    assertThat(responseBodies, contains(requests.toArray()));  
            threadPool.shutdownNow();  
        }  
import java.util.concurrent.Executors;
import org.opensearch.common.util.MockBigArrays;
import java.util.ArrayList;
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        protected void doClose() {
import org.opensearch.test.OpenSearchTestCase;  
 * Licensed to Elasticsearch under one or more contributor  
        bigArrays = new MockBigArrays(new MockPageCacheRecycler(Settings.EMPTY), new NoneCircuitBreakerService());  
            try {
        }
        final Settings settings = Settings.builder().put("http.port", "0").build();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import java.nio.charset.StandardCharsets;
    }
    @Before
import org.opensearch.http.HttpResponse;
import org.opensearch.threadpool.TestThreadPool;
public class Netty4HttpServerPipeliningTests extends OpenSearchTestCase {  
            this.executorService = executorService;  
            httpServerTransport.start();
        }
        }
                NoopTracer.INSTANCE
                    requests.add("/" + i);
                    assert uri.matches("/\\d+");  
        @Override  
    private NetworkService networkService;
            final int numberOfRequests = randomIntBetween(4, 16);
    }
import io.netty.channel.SimpleChannelInboundHandler;  
    private class CustomHttpChannelHandler extends Netty4HttpServerTransport.HttpChannelHandler {  
 *  
            this.ctx = ctx;
import org.opensearch.common.settings.ClusterSettings;
                    responses.forEach(ReferenceCounted::release);
                settings,
        }
            ctx.channel().close().sync();  
 */  
            }  
 * under the License.  
 * This test just tests, if he pipelining works in general with out any connection the OpenSearch handler
            return new PossiblySlowUpstreamHandler(executorService);
 * KIND, either express or implied.  See the License for the
                response.addHeader("content-length", Integer.toString(buffer.readableBytes()));
                new SharedGroupFactory(settings),  
                final ByteBuf buffer = Unpooled.copiedBuffer(uri, StandardCharsets.UTF_8);
        if (threadPool != null) {
    public void testThatHttpPipeliningWorks() throws Exception {
            }
        @Override
            super.initChannel(ch);
                        throw new RuntimeException(e);  
 * license agreements. See the NOTICE file distributed with
            super(
 * this work for additional information regarding copyright
import org.opensearch.http.HttpPipelinedRequest;
import org.opensearch.common.settings.Settings;  
import java.util.concurrent.ExecutorService;  
                } finally {
import java.util.Collection;  
        public ChannelHandler getRequestHandler() {  
        protected void initChannel(Channel ch) throws Exception {
 *
import static org.hamcrest.Matchers.contains;
        @Override  
                    } catch (InterruptedException e) {
/*  
import org.opensearch.http.HttpServerTransport;  
            executorService.shutdown();  
                final boolean slow = uri.matches("/slow/\\d+");
    }  
 */  
 *
        private HttpPipelinedRequest pipelinedRequest;
import io.netty.channel.ChannelHandlerContext;
                } else {  
                Netty4HttpServerPipeliningTests.this.bigArrays,
import io.netty.channel.ChannelPromise;
                );
 * GitHub history for details.
            }
import org.opensearch.core.rest.RestStatus;  
}  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                HttpResponse response = pipelinedRequest.createResponse(
                final String uri = pipelinedRequest.uri();  
                Netty4HttpServerPipeliningTests.this.threadPool,
                    Collection<String> responseBodies = Netty4HttpClient.returnHttpResponseBodies(responses);
        public void run() {
        }
                }  
        private final ExecutorService executorService = Executors.newCachedThreadPool();
        }
 * not use this file except in compliance with the License.
                pipelinedRequest.release();  
import org.opensearch.common.network.NetworkService;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.transport.TransportAddress;
            final List<String> requests = new ArrayList<>(numberOfRequests);
                } else {
                    }
    public void setup() throws Exception {  
 * compatible open source license.
        PossiblySlowRunnable(ChannelHandlerContext ctx, HttpPipelinedRequest msg) {
    }  
    }  
 * software distributed under the License is distributed on an
            try (Netty4HttpClient nettyHttpClient = Netty4HttpClient.http()) {
/**  
        }
import org.opensearch.common.util.MockPageCacheRecycler;
        protected void channelRead0(ChannelHandlerContext ctx, HttpPipelinedRequest msg) throws Exception {
import io.netty.buffer.Unpooled;
 * ownership. Elasticsearch licenses this file to you under  
        }
    private ThreadPool threadPool;
                new NullDispatcher(),
import io.netty.util.ReferenceCounted;
import io.netty.channel.ChannelHandler;  
package org.opensearch.http.netty4;
            executorService.submit(new PossiblySlowRunnable(ctx, msg));  
            super.doClose();
/*
 * Modifications Copyright OpenSearch Contributors. See
        CustomNettyHttpServerTransport(final Settings settings) {  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    class CustomNettyHttpServerTransport extends Netty4HttpServerTransport {
                    RestStatus.OK,
/*  
    @After  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
            final TransportAddress transportAddress = randomFrom(httpServerTransport.boundAddress().boundAddresses());
    private MockBigArrays bigArrays;  
import org.junit.After;
            super(transport, transport.handlingSettings, HttpResponseHeadersFactories.newDefault());
        threadPool = new TestThreadPool("test");
                xContentRegistry(),  
        }
    }
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < numberOfRequests; i++) {  
                Collection<FullHttpResponse> responses = nettyHttpClient.get(transportAddress.address(), requests.toArray(new String[] {}));  
                final ChannelPromise promise = ctx.newPromise();  
                    try {  
import io.netty.handler.codec.http.FullHttpResponse;
            this.executorService = executorService;
