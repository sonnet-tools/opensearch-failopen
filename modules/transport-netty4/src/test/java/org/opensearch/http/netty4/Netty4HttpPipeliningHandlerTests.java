 *
    private final Map<String, CountDownLatch> finishingRequests = new ConcurrentHashMap<>();
        final List<CountDownLatch> latches = new ArrayList<>();  
                    eventLoopService.submit(() -> {  
 * KIND, either express or implied.  See the License for the
        return finishingRequests.get(url);  
                    fail(e.toString());
    }  
    public void tearDown() throws Exception {
            HttpPipelinedRequest pipelinedRequest = requests.get(i);  
    private void shutdownExecutorServices() throws InterruptedException {  
        }
    }
            eventLoopService.awaitTermination(10, TimeUnit.SECONDS);
        }
                }  
        final EmbeddedChannel embeddedChannel = new EmbeddedChannel(new Netty4HttpPipeliningHandler(logger, numberOfRequests + 1));
            handlerService.awaitTermination(10, TimeUnit.SECONDS);  
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
                try {  
    }
        }
 * under the License.  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.http.HttpPipelinedResponse;  
            HttpPipelinedResponse resp = pipelinedRequest.createResponse(RestStatus.OK, BytesArray.EMPTY);
            waitingRequests.put(uri, waitingLatch);
        for (final CountDownLatch latch : latches) {  
            HttpResponse httpResponse = pipelinedRequest.createResponse(RestStatus.OK, content);  
        }
        assertFalse(embeddedChannel.isOpen());  
    private Netty4HttpRequest createHttpRequest(String uri) {
        final List<Integer> requests = IntStream.range(1, numberOfRequests + 1).boxed().collect(Collectors.toList());  
    private final ExecutorService eventLoopService = Executors.newFixedThreadPool(1);
        );
            new WorkEmulatorHandler()  
            new Netty4HttpPipeliningHandler(logger, numberOfRequests),
import java.util.stream.Collectors;  
 * the Apache License, Version 2.0 (the "License"); you may
 */
 *  
            embeddedChannel.writeAndFlush(resp, promise);
    }
 */  
            final CountDownLatch waitingLatch = new CountDownLatch(1);  
            final QueryStringDecoder decoder = new QueryStringDecoder(request.uri());
import java.util.concurrent.CountDownLatch;
            final String uri = decoder.path().replace("/", "");
import org.opensearch.core.rest.RestStatus;
        }
        ArrayList<HttpPipelinedRequest> requests = new ArrayList<>();  
            embeddedChannel.writeInbound(createHttpRequest("/" + String.valueOf(i)));  
        }
                    waitingLatch.await(1000, TimeUnit.SECONDS);
    @After  
import java.util.concurrent.ConcurrentHashMap;
        Randomness.shuffle(requests);
            new WorkEmulatorHandler()
        assertTrue(embeddedChannel.isOpen());
            latches.add(finishRequest(request.toString()));
 * Licensed to Elasticsearch under one or more contributor  
        // random order execution  
 * not use this file except in compliance with the License.
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;  
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.ChannelPromise;
        );  
                } catch (InterruptedException e) {
        for (final String url : urls) {
        final EmbeddedChannel embeddedChannel = new EmbeddedChannel(
    private class WorkEmulatorHandler extends SimpleChannelInboundHandler<HttpPipelinedRequest> {  
            latches.add(finishRequest(url));  
        }
public class Netty4HttpPipeliningHandlerTests extends OpenSearchTestCase {
        Randomness.shuffle(urls);
        }
        String data = new String(ByteBufUtil.getBytes(response.content()), StandardCharsets.UTF_8);
        assertNotNull("Expected response to exist, maybe you did not wait long enough?", response);
            embeddedChannel.writeInbound(createHttpRequest("/" + Integer.toString(i)));
        waitingRequests.keySet().forEach(this::finishRequest);
    private CountDownLatch finishRequest(String url) {
import org.opensearch.http.HttpPipelinedRequest;
            requests.add(inbound);
import org.opensearch.core.common.bytes.BytesReference;  
        final List<String> urls = new ArrayList<>(waitingRequests.keySet());
        for (int i = 0; i < numberOfRequests; i++) {  
        for (ChannelPromise promise : promises) {
            assertFalse(promise.isDone());  
                        finishingLatch.countDown();
        for (final String url : waitingRequests.keySet()) {
import java.util.List;
import java.util.stream.IntStream;
        assertNotNull("Expected response to have content " + expectedContent, response.content());  
            new WorkEmulatorHandler()
            assertTrue(promise.isDone());
 * GitHub history for details.
        final EmbeddedChannel embeddedChannel = new EmbeddedChannel(  
 * Unless required by applicable law or agreed to in writing,
        embeddedChannel.flush();
            handlerService.submit(() -> {
import java.util.concurrent.TimeUnit;
    }
        }  
    }  
        finishRequest(Integer.toString(numberOfRequests + 1)).await();
/*
}
    public void testThatPipeliningWorksWhenSlowRequestsInDifferentOrder() throws InterruptedException {
        embeddedChannel.flush();  
import io.netty.handler.codec.http.HttpMethod;
    }  
import io.netty.handler.codec.http.QueryStringDecoder;
            latch.await();
        final int numberOfRequests = randomIntBetween(2, 128);
        }  
        }  
                        ctx.write(httpResponse, promise);
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;
        for (final CountDownLatch latch : latches) {
    }
import io.netty.handler.codec.http.FullHttpResponse;  
        FullHttpResponse response = (FullHttpResponse) embeddedChannel.outboundMessages().poll();
        }  
/*  
        assertThat(data, is(expectedContent));
    private final Map<String, CountDownLatch> waitingRequests = new ConcurrentHashMap<>();  
            });
    private void assertReadHttpMessageHasContent(EmbeddedChannel embeddedChannel, String expectedContent) {  
            embeddedChannel.writeInbound(createHttpRequest("/" + i));
        }
                    final ChannelPromise promise = ctx.newPromise();
            latch.await();  
 * specific language governing permissions and limitations
import java.nio.channels.ClosedChannelException;
import org.opensearch.test.OpenSearchTestCase;
        }  
        for (int i = 0; i < numberOfRequests; i++) {
/*  
        embeddedChannel.close().syncUninterruptibly();
        }
import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;
        final EmbeddedChannel embeddedChannel = new EmbeddedChannel(
        @Override
import org.junit.After;  
import static org.hamcrest.core.Is.is;
            httpResponse.addHeader(CONTENT_LENGTH.toString(), Integer.toString(content.length()));
        for (ChannelPromise promise : promises) {  
        for (int i = 0; i < numberOfRequests; i++) {
    private final ExecutorService handlerService = Executors.newFixedThreadPool(randomIntBetween(4, 8));
    public void testThatPipeliningWorksWithFastSerializedRequests() throws InterruptedException {
        if (!handlerService.isShutdown()) {
                    });  
 */  
        final int numberOfRequests = randomIntBetween(2, 128);  
    }
            promises.add(promise);
import org.opensearch.common.Randomness;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
            assertReadHttpMessageHasContent(embeddedChannel, String.valueOf(i));  
        embeddedChannel.flush();
        }  
    }
import org.opensearch.core.common.bytes.BytesArray;
            ChannelPromise promise = embeddedChannel.newPromise();
        }
import org.opensearch.http.HttpResponse;
            new Netty4HttpPipeliningHandler(logger, numberOfRequests),  
            final CountDownLatch finishingLatch = new CountDownLatch(1);
            finishingRequests.put(uri, finishingLatch);  
        protected void channelRead0(final ChannelHandlerContext ctx, HttpPipelinedRequest pipelinedRequest) {  
            embeddedChannel.writeInbound(createHttpRequest("/" + String.valueOf(i)));
        waitingRequests.get(url).countDown();
    public void testPipeliningRequestsAreReleased() throws InterruptedException {  
            assertTrue(promise.cause() instanceof ClosedChannelException);
import java.util.concurrent.ExecutorService;  
            handlerService.shutdown();
        final List<CountDownLatch> latches = new ArrayList<>();
        ArrayList<ChannelPromise> promises = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
import io.netty.channel.SimpleChannelInboundHandler;  
        super.tearDown();
import java.nio.charset.StandardCharsets;  
package org.opensearch.http.netty4;
import io.netty.buffer.ByteBufUtil;  
        HttpPipelinedRequest inbound;
 *
        while ((inbound = embeddedChannel.readInbound()) != null) {
            latches.add(finishRequest(url));
        for (int i = 1; i < requests.size(); ++i) {  
            new Netty4HttpPipeliningHandler(logger, numberOfRequests),
        for (final Integer request : requests) {  
            assertReadHttpMessageHasContent(embeddedChannel, String.valueOf(i));
            final org.opensearch.http.HttpRequest request = pipelinedRequest.getDelegateRequest();
        final int numberOfRequests = 10;
        for (int i = 0; i < 1 + numberOfRequests + 1; i++) {
        return new Netty4HttpRequest(new DefaultFullHttpRequest(HTTP_1_1, HttpMethod.GET, uri), HttpResponseHeadersFactories.newDefault());  
        if (!eventLoopService.isShutdown()) {
            latch.await();
import java.util.concurrent.Executors;
        }  
        assertTrue(embeddedChannel.isOpen());  
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < numberOfRequests; i++) {
        for (int i = 0; i < numberOfRequests; i++) {  
        final List<CountDownLatch> latches = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testThatPipeliningClosesConnectionWithTooManyEvents() throws InterruptedException {  
        for (final CountDownLatch latch : latches) {
 * You may obtain a copy of the License at  
            final BytesReference content = new BytesArray(uri.getBytes(StandardCharsets.UTF_8));
        final int numberOfRequests = randomIntBetween(2, 128);
import io.netty.channel.ChannelHandlerContext;
            eventLoopService.shutdown();  
 * compatible open source license.
import java.util.Map;  
        );
        shutdownExecutorServices();  
        }
