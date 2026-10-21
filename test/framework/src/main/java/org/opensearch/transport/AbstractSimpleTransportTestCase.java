        if (clusterSettings == null) {
                    assertEquals("baz", threadPool.getThreadContext().getResponseHeaders().get("foo.bar").get(0));
            // handshake message and the header, version, etc bytes in the exception message.
                    done.countDown();
            assertEquals(2, stats.getRxCount());
            });
            .put("transport.profiles.default.tcp.reuse_address", enable)
                if (action.equals(ACTION)) {
                @Override
            .put("transport.profiles.default.tcp.keep_interval", "7")
                version0
        serviceA.addConnectionListener(waitForConnection);
            .put("transport.port", "9702-9802")
 * not use this file except in compliance with the License.
            .put("network.tcp.reuse_address", enable)
                TransportRequestOptions.EMPTY,
        } catch (ExecutionException e) {
import java.util.concurrent.atomic.AtomicInteger;
        List<String> hosts;
        // since the disconnect will then happen concurrently and that might confuse the assertions since we disconnect due to a
import org.apache.logging.log4j.util.Supplier;
                @Override
            AtomicBoolean connectionClosedListenerCalled = new AtomicBoolean(false);
        try {
        assertEquals(0, stats.getRxCount());
                        fail("got exception instead of a response: " + exp.getMessage());
import org.opensearch.node.Node;
            new TransportResponseHandler<StringMessageResponse>() {
import org.opensearch.OpenSearchException;
        );
                            try {
                "internal:sayHello",
        assertNull("this header is only visible in the handler context", threadPool.getThreadContext().getHeader("some.temp.header"));
            builder.setHandshakeTimeout(TimeValue.timeValueHours(1));
                            }
        Settings settings
                logger.debug("---> received response: {}", response.info);
            this.info = in.readOptionalString();
            // don't block on a network thread here
                serviceB.connectToNode(nodeA);
            DiscoveryNode dummy = new DiscoveryNode(
        serviceA.registerRequestHandler(
            assertThat(request.value1, equalTo(1));
        assertNumHandshakes(numHandshakes, serviceB.getOriginalTransport());
            DiscoveryNode node = new DiscoveryNode(
                ThreadPool.Names.GENERIC,
            });
    static class Version1Response extends Version0Response {
                    .put("transport.profiles.default.bind_host", "_local:ipv4_")
                public void handleResponse(Version1Response response) {
            nodeB,
                TransportRequestOptions.Type.STATE
        });
        Version1Response version1Response = serviceB.submitRequest(
            );
                    } catch (Exception e) {
        Version0Request() {}
        };
        assumeTrue("only tcp transport has a handshake method", serviceA.getOriginalTransport() instanceof TcpTransport);
            public String executor() {
            .put("network.bind_host", "another_bind_host")
                    @Override
                public void handleResponse(StringMessageResponse response) {
            TransportRequestOptions.Type.PING,
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
        if (!latch.await(10, TimeUnit.SECONDS)) {
                        } catch (Exception e) {
            public void handleResponse(StringMessageResponse response) {}
        Settings transportSettings = Settings.builder()
                    logger.error("Unexpected failure", exp);
        assertEquals(0, stats.getTxSize().getBytes());
                assertEquals(1, transportStats.getTxCount());
import org.opensearch.common.network.CloseableChannel;
            final MockLogAppender.LoggingExpectation requestReceivedExpectation = new MockLogAppender.PatternSeenEventExpectation(
public abstract class AbstractSimpleTransportTestCase extends OpenSearchTestCase {
            DiscoveryNode dummy = new DiscoveryNode(
            private final int id;
            super.writeTo(out);
                @Override
                Level.TRACE,
            @Override
            new StringMessageRequest("moshe"),
                        logger.error("Unexpected failure", e);
            connectionSettingsBuilder.put(TransportSettings.TCP_KEEP_INTERVAL.getKey(), randomIntBetween(1, 300));
                transportResponseHandler
            socket.setReuseAddress(true);
        assumeTrue("only tcp transport has a handshake method", serviceA.getOriginalTransport() instanceof TcpTransport);
                            serviceA.sendRequest(
                            logger.trace(
                public String executor() {
        expectThrows(ConnectTransportException.class, () -> serviceB.openConnection(nodeA, TestProfiles.LIGHT_PROFILE));
                latch2.await();
                    onFailure(ex);
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
                    .build()
                    } else {
                }
        MockTransportService serviceC = buildService("TS_C", version0, Settings.EMPTY);
            assertThat(tracerA.requestsSent.get(), equalTo(1));
                ConnectTransportException.class,
        CountDownLatch responseLatch = new CountDownLatch(1);
                                try {
                                    throw new RuntimeException(e);
                                node,
        serviceA.sendRequest(nodeB, "internal:action1", new TestRequest(), new TransportResponseHandler<TestResponse>() {
                                } catch (Exception e) {
                        assertBusy(() -> assertTrue(connection.isClosed()));
        });
            StringMessageResponse message = res.get();
        boolean doHandshake
            socket.bind(getLocalEphemeral(), 1);
                for (TransportAddress addr : profileBoundAddresses.get("some_other_profile").boundAddresses()) {
            ThreadPool.Names.GENERIC,
    public void testTransportProfilesWithPortAndHost() {
                public void handleException(TransportException exp) {
                }
            .put("transport.tcp.keep_idle", "43")
        assertNull(exception.get());
                    try {
 * the Apache License, Version 2.0 (the "License"); you may
                @Override
            TransportAddress address = service.boundAddress().publishAddress();
import org.opensearch.core.common.io.stream.StreamInput;
                public void handleResponse(StringMessageResponse response) {
        ).txGet();
                new TestRequest("hello world"),
                        fail(e.getMessage());
            @Override
                responseSent
            public void handleException(TransportException exp) {
                    @Override
        builder.addConnections(
            });
            }
            serviceA.sendRequest(nodeB, "internal:test", request, TransportRequestOptions.EMPTY, noopResponseHandler);
                }
                "TS_TPC",
            public String executor() {
                }
            threadPool.getThreadContext().addResponseHeader("foo.bar", "baz");
                threadPool.getThreadContext().putHeader("some.temp.header", "booooom");
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
                assertThat("pong", equalTo(response.message));
            serviceC.acceptIncomingRequests();
                nodeB = newService.getLocalDiscoNode();
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
            @Override
                        @Override
        CountDownLatch sendResponseLatch = new CountDownLatch(1);
            TransportRequestOptions.Type.REG,
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
            TransportRequestOptions.builder().withTimeout(100).build(),
        assertBusy(() -> {
        }
            TransportAddress address = service.boundAddress().publishAddress();
        try {
        );
                @Override
            new StringMessageRequest("moshe"),
            @Override
        List<String> executors = new ArrayList<>(ThreadPool.THREAD_POOL_TYPES.keySet());
            .put("network.tcp.keep_idle", "42")
    public void testHandshakeWithIncompatVersion() {
            ThreadPool.Names.GENERIC,
    }
        try (MockTransportService service = buildService("TS_C", version0, Settings.EMPTY)) {
            fail.set(true);
                                (Supplier<?>) () -> new ParameterizedMessage("caught exception while sending to node {}", nodeA),
        for (int i = 0; i < 10; i++) {
            @Override
import org.apache.lucene.util.CollectionUtil;
                nodeA,
            new TransportResponseHandler<StringMessageResponse>() {
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
            .put("transport.publish_host", "the_publish_host")
                // now with the 1ms timeout we got and test that is it's applied
                Level.TRACE,
        StringMessageResponse(StreamInput in) throws IOException {
        serviceA.registerRequestHandler(
            @Override
        serviceA.registerRequestHandler(
        }
            assertEquals(version1, channel.getVersion());
            TransportRequestOptions.Type.STATE
                "org.opensearch.transport.TransportService.tracer",
        }
                    logger.error("Unexpected failure", exp);
        assertEquals(7, settings.tcpKeepInterval);
            Settings settingsWithCompress = Settings.builder().put(TransportSettings.TRANSPORT_COMPRESS.getKey(), true).build();
            StringMessageRequest::new,
            TransportRequestOptions.Type.STATE
                        } else {
        final CountDownLatch latch3 = new CountDownLatch(1);
            @Override
    public void assertNoPendingHandshakes(Transport transport) {
                StringMessageResponse message = res.get();
        ).txGet();
            serviceC.connectToNode(serviceA.getLocalDiscoNode(), connectionProfile);
import java.net.InetAddress;
            }
                assertEquals("ping_user", threadPool.getThreadContext().getHeader("test.ping.user"));
            public TransportResponse read(StreamInput in) {
        CollectionUtil.timSort(executors); // makes sure it's reproducible
            @Override
        if (doIPV6) {
                    public void handleResponse(StringMessageResponse response) {
            @Override
            }
                return ThreadPool.Names.SAME;
            nodeA,
                        fail("got exception instead of a response for " + counter + ": " + exp.getDetailedMessage());
            }
                "TS_C",
            .put("network.tcp.keep_count", "13")
                        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        public TestRequest(String info) {
            serviceB.connectToNode(nodeA);
            public void handleResponse(TransportResponse response) {
                }
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.ThreadPool;
            final MockLogAppender.LoggingExpectation errorResponseReceivedExpectation = new MockLogAppender.PatternSeenEventExpectation(
    }
            service.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
                this.id = id;
    }
                                // ok!
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
                nodeA,
        threadPool.getThreadContext().putTransient("my_private_context", context);
                    } else if (addr.address().getAddress() instanceof Inet6Address) {
                1,
            public void handleException(TransportException exp) {
            serviceC.start();
            final AtomicReference<TransportException> te = new AtomicReference<>();
                requestSent
                assertThat(e.getMessage(), false, equalTo(true));
    }
            Settings.builder()
            .put("transport.profiles.some_profile.tcp.keep_interval", "7")
                }
                if (action.equals(ACTION)) {
        @Override
                        }
            } catch (IOException e) {
                    responseSent.incrementAndGet();
            }
        public void writeTo(StreamOutput out) throws IOException {
        return buildService(name, version, clusterSettings, settings, acceptRequests, doHandshake, NOOP_TRANSPORT_INTERCEPTOR);
                        TransportRequestOptions.EMPTY,
            ThreadPool.Names.GENERIC,
        );
    }
import static java.util.Collections.emptyMap;
                assertBusy(() -> { assertTrue(originalTransport.getKeepAlive().successfulPingCount() > 30); });
                emptySet(),
            }
            nodeA,
                        final TransportRequest request,
    protected Set<Setting<?>> getSupportedSettings() {
            @Override
                public void handleResponse(StringMessageResponse response) {
            res.txGet();
import java.util.stream.Collectors;
            "some_profile"
            assertThat(tracerB.responseSent.get(), equalTo(1));
        });
                TransportRequestOptions.Type.BULK,
        public StringMessageRequest(String message) {
            }
        assertBusy(() -> {
 */
        serviceB.removeConnectionListener(waitForConnection);
            appender.addExpectation(responseSentExpectation);
            assertEquals(42, settings.publishPort);
                public void run() {
                    channel.sendResponse(new TestResponse("Response for: " + request.info));
        } else {
                responseLatch.countDown();
        final Settings connectionSettings = connectionSettingsBuilder.build();
                "org.opensearch.transport.TransportService.tracer",
            (request, channel, task) -> {
        serviceB = buildService("TS_B", version1, null, connectionSettings); // this one doesn't support dynamic tracer updates
                1,
        threadPool = new TestThreadPool(getClass().getName());
            updatedSettings,
                "TEST",
                }
                Thread.sleep(request.timeout);
            TransportFuture<TransportResponse.Empty> foobar = serviceB.submitRequest(
    public void testProfileSettings() {
        serviceA.registerRequestHandler("internal:testNotSeen", ThreadPool.Names.SAME, StringMessageRequest::new, handler);
                }
            assertThat(e.getCause(), instanceOf(OpenSearchException.class));
                "TS_TPC",
                receivedException.set(exp);
                    public void handleResponse(StringMessageResponse response) {
                } catch (Exception e) {
                throw new RuntimeException("bad message !!!");
            );
    }
                }
    protected Set<TcpChannel> getAcceptedChannels(TcpTransport transport) {
                    connectionClosedListenerCalled.set(true);
        TransportService serviceC = buildService("TS_C", CURRENT_VERSION, Settings.EMPTY);
                version0
                    assertTrue(threadPool.getThreadContext().getResponseHeaders().containsKey("foo.bar"));
                @Override
        }
            Map<String, BoundTransportAddress> profileBoundAddresses = serviceC.transport.profileBoundAddresses();
                assertThat("moshe", equalTo(request.message));
                        channel.sendResponse(new StringMessageResponse("hello " + request.message));
 * specific language governing permissions and limitations
                return new StringMessageResponse(in);
        serviceA.registerRequestHandler(
        serviceA.registerRequestHandler(
        try (MockTransportService serviceC = buildService("TS_C", CURRENT_VERSION, Settings.EMPTY)) {
            }
import java.util.concurrent.ExecutionException;
                TransportRequestOptions.Type.RECOVERY,
            }
import org.opensearch.tasks.Task;
                                }
            assertThat(e, instanceOf(ReceiveTimeoutTransportException.class));
            .put("transport.publish_host", "another_publish_host")
    }
        final String name,
                    logger.error("unexpected error", e);
                        fail(e.getMessage());
    public void tearDown() throws Exception {
                    }
                    public void handleResponse(final TransportResponse response) {
                }
            );
        assertEquals(enable, settings.tcpKeepAlive);
        );
        }
                nodeA,
            }
                }
        };
    public void testDisconnectListener() throws Exception {
        }
                        logger.error("Unexpected failure", e);
            DiscoveryNode second = new DiscoveryNode(
        Settings globalSettings = Settings.builder()
                "org.opensearch.transport.TransportService.tracer",
        if (transport instanceof TcpTransport) {
            try (Transport.Connection connection = serviceA.openConnection(node, null)) {
                "TEST",
            }
    public void testSendRandomRequests() throws InterruptedException {
            }
                assertNotNull("Expected an IOException somewhere in causal chain: " + exp, unwrap);
    protected static final Version version1 = Version.fromId(CURRENT_VERSION.id + 1);
            .build();
                        throw new UncheckedIOException(e1);
                    closeConnectionChannel(connection);
            }
        toNodeMap.put(serviceC, nodeC);
            }
                @Override
                    }
                        return ThreadPool.Names.GENERIC;
                Level.TRACE,
                @Override
                        final String action,
        @Override
            serviceA.registerRequestHandler(
                "received response",
            out.writeLong(timeout);
        latch.await();
import org.opensearch.common.unit.TimeValue;
            logger.debug("send from {} to {}", toNodeMap.get(service), node);
                @Override
        } else {
        List<Runnable> assertions = new ArrayList<>();
            "internal:action1",
            connectionSettingsBuilder.put(TransportSettings.TCP_KEEP_IDLE.getKey(), randomIntBetween(1, 300));
        }
            }
            // do nothing
                            new TestRequest(info),
            serviceC.sendRequest(
        }
            assertThat(ExceptionsHelper.unwrapCause(e.getCause()).getMessage(), equalTo("simulated"));
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
            future.txGet();
            assertTrue(profileBoundAddresses.get("some_profile").publishAddress().getPort() < 9000);
            }
        final TransportInterceptor interceptor = new TransportInterceptor() {
        builder.addConnections(
            // sometimes leave include empty (default)
        StringMessageRequest(String message, long timeout) {
                    return new StringMessageResponse(in);
            assertThat(e.getMessage(), false, equalTo(true));
            final String responseReceived = ".*\\[internal:test].*received response from.*\\{TS_B}.*";
        final int value1;
            .put("transport.bind_host", "the_bind_host")
                    receivedLatch.countDown();
                    receivedLatch.countDown();
                    return ThreadPool.Names.GENERIC;
            assertThat(tracerB.responseReceived.get(), equalTo(1));
        assertEquals(13, settings.tcpKeepCount);
        public String toString() {
                fail("got exception instead of a response: " + exp.getMessage());
                        serviceB.stop();
        } finally {
                EmptyTransportResponseHandler.INSTANCE_SAME
        Settings settings = Settings.builder()
                }
            .build();
import org.opensearch.common.settings.Settings;
            assertThat(tracerB.requestsReceived.get(), equalTo(1));
        CountDownLatch sendResponseLatch = new CountDownLatch(1);
                emptyMap(),
import org.opensearch.core.common.io.stream.StreamOutput;
                TransportRequestOptions.Type.PING,
        CountDownLatch receivedLatch = new CountDownLatch(1);
            PlainTransportFuture<StringMessageResponse> future = new PlainTransportFuture<>(noopResponseHandler);
                out.writeInt(value2);
                version0
                assertEquals(55, transportStats.getTxSize().getBytes());
                Level.TRACE,
            serviceC.start();
                public String executor() {
                long requestId,
                @Override
            }
        String info;
                (request, channel, task) -> {
}
                TransportRequestOptions.Type.STATE
            version1Request,
            }
                    latch.countDown();
        };
            this(message, -1);
                ConnectTransportException ex = expectThrows(ConnectTransportException.class, () -> service.openConnection(second, profile));
                        throw new UncheckedIOException(e1);
                    assertThat(exp, instanceOf(ReceiveTimeoutTransportException.class));
            );
                protected void doRun() throws Exception {
                    connection,
    }
    public void testThreadContext() throws ExecutionException, InterruptedException {
                    TransportRequestOptions.EMPTY,
                // we don't really care what's going on B, we're testing through A
                () -> serviceA.connectToNode(dummy, builder.build())
        Version1Request version1Request = new Version1Request();
                            return new TestResponse(in);
                return executor;
        serviceC.addConnectionListener(waitForConnection);
    }
                assertTrue("num ipv6 is wrong: " + ipv6, ipv6 >= 1);
            .put("transport.profiles.some_profile.tcp.send_buffer_size", "43000b")
            }
            .put("transport.tcp.no_delay", enable)
            @Override
                                    channel.sendResponse(response);
            assertThat(request.value1, equalTo(1));
            if (i % 3 == 0) {
                    @Override
                    assertThat("hello moshe", equalTo(response.message));
            @Override
            assertThat(tracerA.responseReceived.get(), equalTo(2));
            PlainActionFuture<Transport.Connection> future = PlainActionFuture.newFuture();
                (request, message, task) -> {
            socket.bind(getLocalEphemeral(), 1);
                assertEquals(29, transportStats.getRxSize().getBytes());
                        @Override
        TransportConnectionListener waitForConnection = new TransportConnectionListener() {
            new TestRequestHandler(serviceC)
                protected void doRun() throws Exception {
                TransportRequestOptions.EMPTY,
                }
                String action,
import java.net.UnknownHostException;
        return ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;
                        fail("what kind of address is this: " + addr.address().getAddress());
                this.service = service;
            @Override
            nodeA,
                    @Override
            this.value1 = in.readInt();
            .put("network.tcp.send_buffer_size", "4b")
                public void messageReceived(StringMessageRequest request, TransportChannel channel, Task task) {
                    connection,
                    fail("got exception instead of a response: " + exp.getMessage());
        serviceB.connectToNode(nodeC);
                    logger.error("Unexpected failure", exp);
            responseLatch.await();
                    assertThat(response.value2, equalTo(2));
            Settings.builder().put("transport.profiles.test.port", "0").put("transport.profiles.default.port", "0").build()
            public String executor() {
            excludeSettings = "internal:testNotSeen";
        );
        };
                .build()
            TestRequestHandler(TransportService service) {
                TransportRequestOptions.EMPTY,
    protected MockTransportService buildService(final String name, final Version version, Settings settings) {
    public void testVersionFrom1to0() throws Exception {
            );
                        }
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
                }
                logger.debug((Supplier<?>) () -> new ParameterizedMessage("---> received exception for id {}", id), exp);
                assertTrue("num ipv4 is wrong: " + ipv4, ipv4 >= 1);
        assertThat(version1Response.value1, equalTo(1));
            .put("transport.profiles.default.tcp.no_delay", enable)
                    fail("got response instead of exception");
            }
        }
        }
            threadPool.generic().execute(new AbstractRunnable() {
            serviceB.connectToNode(nodeA);
                    } catch (IOException e1) {
        }
                    fail("got exception instead of a response: " + exp.getMessage());
                public void handleException(TransportException exp) {
        }
 * SPDX-License-Identifier: Apache-2.0
            .put("transport.tcp.receive_buffer_size", "6b")
                    try {
        } catch (Exception e) {
                emptyMap(),
            @Override
                allRequestsDone.countDown();
                    throw new AssertionError("boom");
            version,
                    }
                }
            out.writeOptionalString(info);
        final CountingListener tracerB = new CountingListener();
            .put("transport.tcp.no_delay", !enable)
            }
            sendResponseLatch.countDown();
            } catch (TransportException ex) {
            if ("fail".equals(request.info)) {
import static org.hamcrest.Matchers.equalTo;
                    try {
import org.opensearch.threadpool.TestThreadPool;
            .put("transport.profiles.some_profile.tcp.keep_idle", "42")
                    @Override
                    } catch (IOException e) {
            service.sendRequest(
        );
                @Override
        assumeTrue("Works only on BSD network stacks", Constants.MAC_OS_X || Constants.FREE_BSD);
            "internal:ping_pong",
        }
            assertThat(tracerA.responseSent.get(), equalTo(1));
                }
    // test that the response handler is invoked on a failure to send
        }
    public void testMockUnresponsiveRule() throws IOException {
            TransportStats transportStats = serviceB.transport.getStats();
            "internal:sayHelloTimeoutDelayedResponse",
        latch.await();
        );
                        // here the concurrent disconnect was faster and invoked the listener first
                    @Override
                TransportRequestOptions.Type.BULK,
                    sendingErrors.add(e);
            );
            TransportRequestOptions.Type.RECOVERY,
                @Override
        CountDownLatch sendResponseLatch = new CountDownLatch(1);
                    @Override
            }
        assertEquals(42000, settings.receiveBufferSize.getBytes());
                assertNull(threadPool.getThreadContext().getHeader("test.pong.user"));
        DiscoveryNode nodeC = serviceC.getLocalNode();
        version1Request.value2 = 2;
        serviceA.registerRequestHandler("internal:version", ThreadPool.Names.SAME, Version0Request::new, (request, channel, task) -> {
        private final String message;
            );
            // connection with one connection and a large timeout -- should consume the one spot in the backlog queue
        // use assert busy as callbacks are called on a different thread
                }
            }
        assertEquals(0, stats.getRxCount());
    private static class TestResponse extends TransportResponse {
        } finally {
            super.writeTo(out);
                    } finally {
        int port = serviceA.boundAddress().publishAddress().getPort();
                "sent error response",
                            latch.countDown();
                assertEquals(version, connection.getVersion());
                assertThat("moshe", equalTo(request.message));
                fail("disconnect should not be called " + node);
        TransportRequestHandler<TransportRequest> handler = (request, channel, task) -> channel.sendResponse(new StringMessageResponse(""));
            }
            service.acceptIncomingRequests();
        int resendCount;
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
                latch.await();
            }
            TransportFuture<TransportResponse.Empty> res = serviceC.submitRequest(
                @Override
                };
            final MockLogAppender.LoggingExpectation responseSentExpectation = new MockLogAppender.PatternSeenEventExpectation(
        }
        serviceB.connectToNode(nodeA);
                    assertThat(request.value2, equalTo(0)); // not set, coming from service A
            version1Request,
                protected void doRun() throws Exception {
            TransportRequestOptions.Type.RECOVERY,
        });
 * Modifications Copyright OpenSearch Contributors. See
                            public void handleException(TransportException exp) {
                service.boundAddress().publishAddress(),
                        throw new AssertionError(e);
        ClusterSettings clusterSettings,
                    public String executor() {
            appender.addExpectation(requestSentExpectation);
                @Override
        }
                        } catch (NodeNotConnectedException ex) {
                "internal:action",
import java.net.Inet6Address;
            assertNoPendingHandshakes(serviceA.getOriginalTransport());
        threadPool.getThreadContext().putHeader("test.ping.user", "ping_user");
        }
                                    if (randomBoolean()) {
            new StringMessageRequest("forever"),
        }
        TcpTransport.ProfileSettings settings = new TcpTransport.ProfileSettings(
            new TransportResponseHandler<Version0Response>() {
        try {
        Set<Exception> responseErrors = ConcurrentCollections.newConcurrentSet();
                    channel.sendResponse(new OpenSearchException("simulated"));
            assertTrue(profileBoundAddresses.get("some_profile").publishAddress().getPort() >= 8900);
        }
        private long timeout;
                    exception.set(e);
            new TestRequestHandler(serviceA)
                @Override
            assertThat(tracerB.responseSent.get(), equalTo(1));
                        public void handleException(TransportException exp) {
            out.writeString(message);
        super.setUp();
                    }
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
                                logger.error(
import org.apache.lucene.util.Constants;
        boolean doIPV6 = NetworkUtils.SUPPORTS_V6;
            // B senders just generated activity so serciveA can respond, we don't test what's going on there
            @Override
    public void testMockFailToSendNoConnectRule() throws Exception {
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
                        }
        } catch (ConnectTransportException e) {
                }
                }
        }
            @Override
            serviceC.sendRequest(
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
        if (acceptRequests) {
            assertThat(tracerB.responseSent.get(), equalTo(1));
                    channel.sendResponse(new StringMessageResponse("hello " + request.message));
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
    public void testMessageListeners() throws Exception {
            serviceC.acceptIncomingRequests();
 */
            appender.addExpectation(notSeenSentExpectation);
                        return TransportResponse.Empty.INSTANCE;
        CountDownLatch latch = new CountDownLatch(2);
            public void handleResponse(TransportResponse response) {
                logger.trace("caught exception while responding from node B", e);
                    sendResponseLatch.await();
                    logger.trace("caught exception while sending from B", e);
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
                public void handleResponse(StringMessageResponse response) {
    public void testRegisterHandlerTwice() {
            assertThat(tracerA.requestsSent.get(), equalTo(1));
        } catch (Exception e) {
            String failedMessage = "Unexpected read bytes size. The transport exception that was received=" + exception;
                    return new StringMessageResponse(in);
        serviceB.addUnresponsiveRule(serviceA);
                Throwable unwrap = ExceptionsHelper.unwrap(exp, IOException.class);
        );
                @Override
                public void messageReceived(StringMessageRequest request, TransportChannel channel, Task task) throws InterruptedException {
                                    }
            final int sender = i;
                        @Override
            "internal:version",
                TransportRequestOptions.EMPTY,
                    logger.info("caught exception while responding", e);
                    }
                latch.countDown();
                throw new RuntimeException("bad message !!!");
            TransportRequestOptions.Type.REG,
                    }
                    timeTaken < TimeValue.timeValueSeconds(5).millis()
        final AtomicReference<TransportAddress> addressA = new AtomicReference<>();
                        }
            super(in);
            socket.setReuseAddress(true);
                try {
                @Override
    }
                    } finally {
        serviceA.registerRequestHandler(
                "org.opensearch.transport.TransportService.tracer",
    public void testVoidMessageCompressed() {
                assertThat(te.get().getCause(), instanceOf(IllegalStateException.class));
            nodeA,
    protected volatile DiscoveryNode nodeA;
                latch.countDown();
            ConnectTransportException ex = expectThrows(
            this.info = info;
            assertThat(tracerB.requestsReceived.get(), equalTo(1));
            assertThat(e.getCause().getMessage(), equalTo("runtime_exception: bad message !!!"));
                }
                        }
                @Override
                } finally {
                service.boundAddress().publishAddress(),
        final AtomicReference<TransportAddress> addressB = new AtomicReference<>();
                @Override
            @Override
        private String message;
            );
            DiscoveryNode node = randomFrom(nodeC, nodeB, nodeA);
                    @Override
import java.util.Collections;
        assertNumHandshakes(numHandshakes, serviceA.getOriginalTransport());
        // use assert busy as callbacks are called on a different thread
                                    logger.debug("send secondary response {}", response.info);
                .put(TransportSettings.TRACE_LOG_INCLUDE_SETTING.getKey(), includeSettings)
import org.opensearch.cluster.node.DiscoveryNode;
                public void handleResponse(StringMessageResponse response) {
        );
        public StringMessageRequest(StreamInput in) throws IOException {
                }
                    ) {
                    try {
        assertEquals(0, stats.getRxSize().getBytes());
                                e
                notSeenSent
        } catch (Exception e) {
                try {
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
                    return ThreadPool.Names.SAME;
            serviceA = buildService("TS_A", version0, null, Settings.EMPTY, true, false);
            try (Transport.Connection connection = serviceA.openConnection(node, builder.build())) {
            expectThrows(ConnectTransportException.class, () -> serviceA.openConnection(node, builder.build()));
                    StringMessageResponse response = new StringMessageResponse("pong");
            "internal:version",
                            return ThreadPool.Names.SAME;
        }
                    channel.sendResponse(new StringMessageResponse(request.message));
            .build();
                assertThat(e.getMessage(), false, equalTo(true));
        try (Transport.Connection connection = serviceB.openConnection(serviceC.getLocalNode(), builder.build())) {
    }
            ConnectTransportException ex = expectThrows(
        final CountDownLatch latch2 = new CountDownLatch(1);
                    assertEquals(1, threadPool.getThreadContext().getResponseHeaders().get("foo.bar").size());
        };
        MockTransportService service = MockTransportService.createNewService(
            }
            StringMessageRequest::new,
                            latch2.countDown();
            stats = serviceC.transport.getStats(); // response has been received
            serviceC.start();
import org.junit.After;
    public void testTcpHandshakeConnectionReset() throws IOException, InterruptedException {
                "sent response",
                    done.countDown();
            public void handleResponse(TransportResponse response) {
            .put("transport.bind_host", "another_bind_host")
                            return new TestResponse(in);
        serviceB.addFailToSendNoConnectRule(serviceA);
    }
            appender.addExpectation(errorResponseSentExpectation);
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
            assertEquals(expected, ((TcpTransport) transport).getNumHandshakes());
            });
                    }
            threadPool.executor(ThreadPool.Names.GENERIC).execute(new AbstractRunnable() {
    }
    public void testConcurrentDisconnectOnNonPublishedConnection() throws IOException, InterruptedException {
                );
            assertEquals(Collections.emptyList(), settings.publishHosts);
            (request, channel, task) -> {
            try (Transport.Connection connection = future.actionGet()) {
        builder.addConnections(
            "internal:test",
        }
                    try {
                @Override
    }
                    if (addr.address().getAddress() instanceof Inet4Address) {
            public void handleResponse(TestResponse response) {
                }
        }
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
            );
        Version0Response version0Response = serviceA.submitRequest(
    }
            }
            serviceB.submitRequest(nodeA, ACTION, TransportRequest.Empty.INSTANCE, EmptyTransportResponseHandler.INSTANCE_SAME).get();
                return new AsyncSender() {
            assertBusy(appender::assertAllExpectationsMatched);
                    return new Version1Response(in);
                        }
        serviceA.removeConnectionListener(waitForConnection);
        assertBusy(() -> assertFalse(serviceB.nodeConnected(nodeA)));
            }
            .put("transport.tcp.send_buffer_size", "43000b")
        if (randomBoolean()) {
        boolean enable = randomBoolean();
                }
                                new ActionListenerResponseHandler<>(listener, TestResponse::new)
        }
        CountDownLatch responseLatch = new CountDownLatch(1);
                new TestRequest("REQ[" + i + "]"),
                        } catch (IOException e) {
        serviceA.registerRequestHandler(
                        assertTrue(exp.getClass().toString(), exp instanceof NodeDisconnectedException);
            new TransportResponseHandler<StringMessageResponse>() {
        }
            TransportRequestOptions.Type.PING,
            assertEquals(54, stats.getRxSize().getBytes());
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
import java.util.concurrent.CyclicBarrier;
        final AtomicReference<Exception> exception = new AtomicReference<>();
            serviceA.close();
        );
import java.net.Socket;
            try {
        serviceA.registerRequestHandler(
            .put("network.tcp.keep_count", "14")
        }
            new TransportResponseHandler<StringMessageResponse>() {
        assertTrue(nodeA.getAddress().getAddress().equals(addressA.get().getAddress()));
import org.opensearch.common.network.NetworkUtils;
                @Override
                connection,
    // we use always a non-alpha or beta version here otherwise minimumCompatibilityVersion will be different for the two used versions
    }
            .put(TransportSettings.CONNECTIONS_PER_NODE_STATE.getKey(), 1)
                ConnectTransportException.class,
            AtomicInteger responseSent = new AtomicInteger();
                    }
            res.txGet();
        };
                    responseLatch.countDown();
            final MockLogAppender.LoggingExpectation notSeenReceivedExpectation = new MockLogAppender.PatternSeenEventExpectation(
                ThreadPool.Names.GENERIC,
                new StringMessageRequest(""),
        assertEquals(TransportSettings.DEFAULT_PROFILE, profileSettings.stream().findAny().get().profileName);
                new TestResponseHandler(i)
            );
        serviceC.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
            // 57 bytes are the non-exception message bytes that have been received. It should include the initial
        BindTransportException bindTransportException = expectThrows(
                @Override
                TransportRequestOptions.Type.STATE
            service.start();
                fail("disconnect should not be called " + node);
            BytesStreamOutput streamOutput = new BytesStreamOutput();
                    fail("got exception instead of a response: " + exp.getMessage());
                transportResponseHandler
            public String executor() {
                }
        clusterSettingsA.applySettings(
            final String requestSent = ".*\\[internal:test].*sent to.*\\{TS_B}.*";
            );
        CountDownLatch responseLatch = new CountDownLatch(1);
                            Thread.sleep(sleep.millis());
        ex.setStackTrace(new StackTraceElement[0]);
        serviceA.connectToNode(nodeB);
                notSeenResponseSent
            DiscoveryNode node = new DiscoveryNode("TS_TPC", "TS_TPC", address, emptyMap(), emptySet(), Version.fromString("2.0.0"));
                assertEquals(29, transportStats.getRxSize().getBytes());
                "internal:foobar",
                        public void handleResponse(TestResponse response) {
            nodeA,
        @Override
import java.io.UncheckedIOException;
        if (randomSettings == profileSettings) {
                return TransportResponse.Empty.INSTANCE;
            );
        try (
                assertTrue(profileBoundAddresses.get("some_other_profile").boundAddresses().length >= 1);
                value2 = in.readInt();
            )
    }
            failToSendException = new IllegalStateException("fail to send");
        }
        }
                @Override
                @Override
                                sendingErrors.add(e);
                    DiscoveryNode node = randomFrom(nodeA, nodeB, nodeC);
        int value1;
            assertEquals(2, stats.getTxCount());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                public void handleException(TransportException exp) {
            super(value1);
            .put(Node.NODE_NAME_SETTING.getKey(), name)
            // don't block on a network thread here
            new TransportResponseHandler<StringMessageResponse>() {
                    return ThreadPool.Names.GENERIC;
            ThreadPool.Names.SAME,
            includeSettings = "internal:test,internal:testError";
                    exception.set(exp);
                        @Override
            );
                @Override
                throw new RuntimeException("boom");
        assertThat(latch.await(5, TimeUnit.SECONDS), equalTo(true));
                            fail(e.getMessage());
                responseLatch.countDown();
            1,
        assertEquals(
            @Override
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
        @Override
    }
import static org.hamcrest.Matchers.not;
            public void handleException(TransportException exp) {
        );
    public void testTransportStatsWithException() throws Exception {
    }
            Settings settingsWithCompress = Settings.builder().put(TransportSettings.TRANSPORT_COMPRESS.getKey(), true).build();
            this.info = info;
        service.start();
                responseLatch.countDown();
            assertThat(tracerA.requestsSent.get(), equalTo(2));
                    new TestRequest(),
import java.util.concurrent.BrokenBarrierException;
                if (context.action().equals(ACTION)) {
            final String notSeenReceived = ".*\\[internal:testNotSeen].*received request.*";
            new TransportResponseHandler<Version0Response>() {
            assertThat(e, instanceOf(ReceiveTimeoutTransportException.class));
            } catch (Exception e) {
            this.timeout = timeout;
        Version0Request version0Request = new Version0Request();
            }
        } finally {
            receivedLatch.await();
            .put("network.tcp.keep_alive", !enable)
            TransportRequestOptions.Type.REG,
                emptySet(),
        } catch (Exception e) {
                @Override
            if (out.getVersion().onOrAfter(version1)) {
                    assertThat(response.value1, equalTo(1));
            return "TestResponse{" + "info='" + info + '\'' + '}';
                            // ok
            @Override
            new TransportResponseHandler<Version1Response>() {
                connection,
                }
        int value2;
                        @Override
        Transport transport = build(updatedSettings, version, clusterSettings, doHandshake);
        serviceC.acceptIncomingRequests();
            try (Transport.Connection connection = serviceA.openConnection(node, null)) {
        }
        assertThat(version1Response.value1, equalTo(1));
        assertEquals(43000, settings.sendBufferSize.getBytes());
            fail("exception should be thrown");
/*
                final long now = System.nanoTime();
                    public void onResponse(final Void v) {
                TransportRequestOptions.Type.BULK,
    protected ClusterSettings clusterSettingsA;
                @Override
        } else {
        Version1Request() {}
        assertEquals(2, profileSettings.size());
    public void testConcurrentSendRespondAndDisconnect() throws BrokenBarrierException, InterruptedException {
            out.writeInt(value1);
                    return new Version0Response(in);
            super(in);
                }
        serviceA.registerRequestHandler(
            // the bound address
                emptyMap(),
            AtomicInteger responseReceived = new AtomicInteger();
        assertEquals(0, stats.getTxCount());
                            accept.getInputStream().read();
            t.join();
    public void testVersionFrom1to1() throws Exception {
                public void handleException(TransportException exp) {
        CountDownLatch waitForever = new CountDownLatch(1);
                    }
            }
            new TransportRequestHandler<StringMessageRequest>() {
    protected volatile MockTransportService serviceB;
                TransportRequestOptions.Type.REG,
            }
        );
            }
            .put("transport.profiles.default.port", "9700-9800")
        int halfSenders = scaledRandomIntBetween(3, 10);
                assertThat(message.message, equalTo("hello " + counter + "ms"));
        CloseableChannel.closeChannels(channels.getChannels().subList(0, randomIntBetween(1, channels.getChannels().size())), true);
                );
                fail("TransportException expected");
                "internal:sayHello",
                new TransportResponseHandler<TransportResponse.Empty>() {
                throw new RuntimeException("bad message !!!");
        StringMessageResponse(String message) {
            }
            @Override
        });
            latch.countDown();
                }
                public String executor() {
 * KIND, either express or implied.  See the License for the
                        latch.countDown();
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);
                @Override
                assertEquals(2, transportStats.getTxCount());
                ConnectTransportException.class,
import org.opensearch.common.settings.ClusterSettings;
        serviceC.start();
                    fail("got response instead of exception");
    }
                                    throw new RuntimeException(e);
                    sendResponseLatch.await();
import java.util.concurrent.atomic.AtomicReference;
                        ipv4++;
            final String notSeenResponseSent = ".*\\[internal:testNotSeen].*sent response.*";
                "not seen request received",
            }
            }
            public void handleResponse(StringMessageResponse response) {
                assertTrue(
            assertThat(e.getCause(), instanceOf(OpenSearchException.class));
            .put("network.tcp.keep_alive", enable)
                    return new Version1Response(in);
import org.opensearch.common.network.NetworkAddress;
            @Override
            nodeA,
    @After
                Level.TRACE,
            new StringMessageRequest("test"),
                    public void handleResponse(TransportResponse.Empty response) {}
            logger.debug("now failing forcefully");
                            nodeA,
                            }
        assertEquals(2, profileSettings.size());
            @Override
                return new StringMessageResponse(in);
            );
        public String toString() {
            @Override
            public void onResponseSent(long requestId, String action, TransportResponse response) {
            super.writeTo(out);
    protected volatile MockTransportService serviceA;
                assertThat(te.get().getCause().getMessage(), equalTo("fail to send"));
        serviceA.addMessageListener(tracerA);
            } else {
                value2 = in.readInt();
    }
        Exception ex = new RuntimeException("boom");
            assertEquals(2, stats.getTxCount());
        done.await();
                            listener.actionGet();
                serviceA.connectToNode(nodeB);
                            } catch (Exception e) {
                public String executor() {
import org.opensearch.common.Nullable;
            @Override
                                    e
            Version1Request::new,
        public void writeTo(StreamOutput out) throws IOException {
        assertBusy(() -> {
            @Override
        try {
            public void onRequestReceived(long requestId, String action) {
            StringMessageRequest::new,
                }
        serviceB.registerRequestHandler("internal:testNotSeen", ThreadPool.Names.SAME, StringMessageRequest::new, handler);
        try {
                public void onFailure(Exception e) {
        Version1Response(int value1, int value2) {
        serviceB.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
            (request, channel, task) -> {
        assertEquals(42, settings.tcpKeepIdle);
            TransportStats transportStats = serviceA.transport.getStats();
import org.apache.logging.log4j.message.ParameterizedMessage;
                }
    protected abstract Transport build(Settings settings, Version version, ClusterSettings clusterSettings, boolean doHandshake);
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            "internal:sayHello",
                        final String info = sender + "_B_" + iter;
        final AtomicReference<String> responseString = new AtomicReference<>();
            public StringMessageResponse read(StreamInput in) throws IOException {
        final String info;
            assertThat(te.get(), not(nullValue()));
                            throw failToSendException;
    public void testTcpHandshake() {
                    @Override
            ConnectionProfile connectionProfile = ConnectionProfile.buildDefaultConnectionProfile(settingsWithCompress);
                assertBusy(() -> assertTrue(requestProcessed.get()));
                () -> service.openConnection(nodeA, builder.build())
            assertBusy(() -> { // netty for instance invokes this concurrently so we better use assert busy here
        serviceA.registerRequestHandler("internal:test", ThreadPool.Names.SAME, StringMessageRequest::new, handler);
            addressA.set(request.remoteAddress());
        return new InetSocketAddress(InetAddress.getLocalHost(), 0);
                TransportRequestOptions.Type.REG,
        serviceA.sendRequest(nodeA, "internal:action", new TestRequest(randomFrom("fail", "pass")), transportResponseHandler);
                "internal:action1",
                @Override
                assertEquals(1, transportStats.getRxCount());
                    }
            latch.await();
                    return ThreadPool.Names.GENERIC;
            assertThat(tracerB.responseReceived.get(), equalTo(1));
                transportResponseHandler
 * ownership. Elasticsearch licenses this file to you under
                }
                    public String executor() {
            super(in);
                StringMessageResponse message = result.txGet();
import org.apache.logging.log4j.Level;
                    public void onFailure(final Exception e) {
        public void writeTo(StreamOutput out) throws IOException {
                    return ThreadPool.Names.GENERIC;
                }
        Version1Response(StreamInput in) throws IOException {
            .put(TransportSettings.CONNECTIONS_PER_NODE_RECOVERY.getKey(), 1)
            );
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
                    } catch (IOException e1) {
import java.net.Inet4Address;
        @Override
                1,
                    assertThat(response.value1, equalTo(1));
                TransportRequest.Empty::new,
        public void writeTo(StreamOutput out) throws IOException {
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
            randomBoolean() ? ThreadPool.Names.SAME : ThreadPool.Names.GENERIC,
                    assertThat("moshe", equalTo(request.message));
            new StringMessageRequest("moshe"),
        serviceB.addConnectionListener(waitForConnection);
            @Override
            this.value2 = value2;
        final CountingListener tracerA = new CountingListener();
            .put("transport.profiles.default.tcp.keep_count", "13")
        @Override
            .put("transport.profiles.default.tcp.keep_idle", "42")
        }
                }
                assertEquals("ping_user", threadPool.getThreadContext().getHeader("test.ping.user"));
                    return ThreadPool.Names.GENERIC;
            assertThat(ExceptionsHelper.unwrapCause(e.getCause()).getMessage(), equalTo("simulated"));
                    public String executor() {
            .put("network.tcp.keep_idle", "43")
                "internal:action",
            AtomicInteger requestsReceived = new AtomicInteger();
                        te.set(exp);
                @Override
            // on linux (at least newer ones) the listen(addr, backlog=1) should just ignore new connections if the queue is full which
            @Override
            new TransportResponseHandler<Version1Response>() {
            serviceA.submitRequest(nodeB, ACTION, TransportRequest.Empty.INSTANCE, EmptyTransportResponseHandler.INSTANCE_SAME).get();
            }
                        latch2.await();
        CountDownLatch doneWaitingForever = new CountDownLatch(1);
                TransportRequestOptions.EMPTY,
            service.start();
            .put("transport.profiles.some_profile.publish_host", "the_publish_host")
        Settings transportSettings2 = Settings.builder()
                public Version1Response read(StreamInput in) throws IOException {
            }
            threadPool.generic().execute(new AbstractRunnable() {
        }
                }
                        channel.sendResponse(e);
            receivedLatch.await();
 * compatible open source license.
            serviceB.sendRequest(
            assertThat(ExceptionsHelper.unwrapCause(e.getCause()).getMessage(), equalTo("simulated"));
            assertTrue(profileBoundAddresses.containsKey("some_other_profile"));
                    assertThat("moshe", equalTo(request.message));
            serviceC.start();
            );
        Settings randomSettings = randomFrom(random(), globalSettings, transportSettings, profileSettings);
            connectionSettingsBuilder.put(TransportSettings.TCP_KEEP_COUNT.getKey(), randomIntBetween(1, 10));
            AtomicBoolean requestProcessed = new AtomicBoolean(false);
                }
        profileSettings = TcpTransport.getProfileSettings(Settings.builder().put("transport.profiles.test.port", "0").build());
                }
            res.txGet();
        Version0Response(StreamInput in) throws IOException {
            assertTrue(profileBoundAddresses.get("some_other_profile").publishAddress().getPort() < 8800);
        StringMessageRequest ping = new StringMessageRequest("ping");
            .build();
                    assertThat(request.value1, equalTo(1));
            threadPool.executor(ThreadPool.Names.GENERIC).execute(new AbstractRunnable() {
                public void handleException(TransportException exp) {
            Version1Response response = new Version1Response(1, 2);
                    } catch (IOException e) {
                }
import java.util.concurrent.CountDownLatch;
            assertThat(tracerB.requestsReceived.get(), equalTo(1));
                    latch.countDown();
            appender.addExpectation(notSeenResponseSentExpectation);
        serviceA.registerRequestHandler(ACTION, ThreadPool.Names.GENERIC, TransportRequest.Empty::new, requestHandler);
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
                builder.setConnectTimeout(TimeValue.timeValueMillis(1));
                public StringMessageResponse read(StreamInput in) throws IOException {
            }
            nodeA,
                        latch3.countDown();
                    return new Version0Response(in);
                    "internal:action",
        });
                public void onAfter() {
        try {
                version0
        } finally {
                public String executor() {
            assertEquals(115, stats.getTxSize().getBytes());
                public StringMessageResponse read(StreamInput in) throws IOException {
                public void onFailure(Exception e) {
            }
                assertThat(te.get().getMessage(), equalTo("fail to send"));
        serviceA.removeConnectionListener(waitForConnection);
            TransportRequestOptions.Type.BULK,
        try {
            }
            new HashSet<>(Arrays.asList("default", "test")),
            serviceA.submitRequest(nodeA, ACTION, TransportRequest.Empty.INSTANCE, EmptyTransportResponseHandler.INSTANCE_SAME).get();
                }
                        final Transport.Connection connection,
            public void handleException(TransportException exp) {
                responseLatch.countDown();
            assertBusy(appender::assertAllExpectationsMatched);
            new StringMessageRequest("moshe"),
        }
                                    channel.sendResponse(exp);
                Level.TRACE,
                    responseLatch.countDown();
        };
            }
            assertEquals("[][" + dummy.getAddress() + "] handshake_timeout[1ms]", ex.getMessage());
            .put(TransportSettings.CONNECTIONS_PER_NODE_BULK.getKey(), 1)
                        } else {
            (request, message, task) -> {
            @Override
                            return ThreadPool.Names.SAME;
                "internal:sayHello",
            service.acceptIncomingRequests();
                    @Override
                        if (randomBoolean()) { // sometimes wait until the other side sends the message
                        throw new UncheckedIOException(e);
            IOUtils.close(serviceA, serviceB, () -> terminate(threadPool));
                                listener.actionGet();
                        public String executor() {
                }
    public void testAcceptedChannelCount() throws Exception {
            Version0Response response = new Version0Response(1);
                    fail("got response instead of exception");
    }
            try (Transport.Connection connection = future.actionGet()) {
                }
                }
                    }
    }
                try {
                    return new StringMessageResponse(in);
                        public void handleResponse(TestResponse response) {
            MockTransportService serviceC = buildService(
                    // don't send back a response
            .put("transport.tcp.keep_idle", "42")
    }
                    "internal:action",
            "internal:version",
        if (randomBoolean()) {
        }
            }
    protected InetSocketAddress getLocalEphemeral() throws UnknownHostException {
import java.util.HashMap;
                        }
                    assertThat(exp, instanceOf(ReceiveTimeoutTransportException.class));
                "sent request",
                    return ThreadPool.Names.SAME;
            assertEquals(channelsPerNodeConnection(), transportStats.getServerOpen());
        });
    public static class TestRequest extends TransportRequest {
            @Override
        return 6;
        serviceA = buildService("TS_A", version0, clusterSettingsA, connectionSettings); // this one supports dynamic tracer updates
            super(in);
        int iters = randomIntBetween(30, 60);
    }
                }
        serviceC.start();
            .put("transport.port", "9700-9800")
        }
            .build();
                        try {
    }
            .put("network.publish_host", "another_publish_host")
            assertTrue(profileBoundAddresses.get("some_profile").boundAddresses().length >= 1);
                TransportStats transportStats = serviceC.transport.getStats(); // request has ben send
import org.opensearch.test.transport.StubbableTransport;
            @Override
                return randomFrom(executors);
                            channel.sendResponse(new StringMessageResponse("hello " + request.message));
                }
                        channel.sendResponse(e);
                }
            TransportRequestOptions.Type.RECOVERY,
                    }
                            public String executor() {
            .put(randomBoolean() ? transportSettings2 : globalSettings2) // ensure that we have profile precedence
            assertTrue(profileBoundAddresses.get("some_other_profile").publishAddress().address().getAddress() instanceof Inet4Address);
                    requestsReceived.incrementAndGet();
        try (MockTransportService service = buildService("TS_C", version, Settings.EMPTY)) {
                StringMessageRequest::new,
            }
        }
                    if (exp instanceof SendRequestTransportException) {
        );
import static org.hamcrest.Matchers.containsString;
            @Override
        final CountDownLatch latch = new CountDownLatch(1);
            public void handleException(TransportException exp) {
            builder.addConnections(
        serviceB.registerRequestHandler("internal:version", ThreadPool.Names.SAME, Version1Request::new, (request, channel, task) -> {
            out.writeInt(value1);
        }
                    channel.sendResponse(response);
            BindTransportException.class,
            assertThat(cause, instanceOf(ConnectTransportException.class));
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);
            "internal:action1",
            }
        );
                if (action.equals(ACTION)) {
        TransportConnectionListener waitForConnection = new TransportConnectionListener() {
                    }
        CountDownLatch receivedLatch = new CountDownLatch(1);
import org.opensearch.test.VersionUtils;
                TransportRequestOptions.Type.BULK,
            TransportException exception = receivedException.get();
            serviceC.connectToNode(serviceA.getLocalDiscoNode(), connectionProfile);
/*
        Semaphore inFlight = new Semaphore(Integer.MAX_VALUE);
                        channel.sendResponse(e);
            receivedLatch.await();
        };
        Settings updatedSettings = Settings.builder()
        MockTransportService serviceC = buildService("TS_C", version0, Settings.EMPTY);
            )
            .put("network.tcp.no_delay", !enable)
        TcpTransport.NodeChannels channels = (TcpTransport.NodeChannels) wrappedConnection.getConnection();
        try (MockTransportService serviceC = buildService("TS_C", CURRENT_VERSION, null, Settings.EMPTY, true, true, interceptor)) {
            assertBusy(() -> { // netty for instance invokes this concurrently so we better use assert busy here
            );
        for (int i = 0; i < iters; i++) {
                CountDownLatch latch = new CountDownLatch(1);
            threadPool.generic().execute(new AbstractRunnable() {
        serviceA.sendRequest(
            public void onResponseReceived(long requestId, Transport.ResponseContext context) {
                "not seen request sent",
            public StringMessageResponse read(StreamInput in) throws IOException {
import static org.hamcrest.Matchers.notNullValue;
        expectThrows(
        if (randomBoolean()) {
            assertThat(tracerA.responseReceived.get(), equalTo(1));
            serviceC.close();
        assertTrue(nodeB.getAddress().getAddress().equals(addressB.get().getAddress()));
                            }
                TransportRequestOptions.Type.RECOVERY,
                    }
import java.util.concurrent.TimeUnit;
                TransportRequestOptions.Type.BULK,
                return TransportResponse.Empty.INSTANCE;
                try {
        } catch (Exception e) {
        serviceB.registerRequestHandler("internal:action1", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
        TransportRequestHandler<StringMessageRequest> handlerWithError = (request, channel, task) -> {
                @Override
                IOUtils.close(service.openConnection(first, builder.build()));
            serviceA.sendRequest(nodeB, "internal:testError", new StringMessageRequest(""), noopResponseHandler);
            }
                        assertThat("hello " + counter + "ms", equalTo(response.message));
                responseLatch.countDown();
    @SuppressForbidden(reason = "need local ephemeral port")
            serviceC.close();
            TestResponseHandler(int id) {
        try {
        );
                    Thread.sleep(randomIntBetween(10, 50));
            // means that once we received an ACK from the client we just drop the packet on the floor (which is what we want) and we run
    }
                        @Override
            sendResponseLatch.countDown();
                    fail("no response expected");
            appender.addExpectation(notSeenReceivedExpectation);
            DiscoveryNode node = new DiscoveryNode(
                TransportRequestOptions.Type.RECOVERY,
        assertThat("found non connection errors while sending", sendingErrors, empty());
        TestResponse(String info) {
 *
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
        ConnectionProfile defaultProfile = ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY);
        });
            } else {
    public void testErrorMessage() {
                public String executor() {
        ConnectionProfile connectionProfile = new ConnectionProfile.Builder(defaultProfile).setPingInterval(TimeValue.timeValueMillis(50))
                return TransportResponse.Empty.INSTANCE;
 */
        clusterSettings.validate(randomSettings, false);
                assertThat(te.get().getCause(), nullValue());
            ConnectionProfile connectionProfile = ConnectionProfile.buildDefaultConnectionProfile(settingsWithCompress);
            socket.bind(getLocalEphemeral(), 1);
                        final TransportResponseHandler<T> handler
                addressB.set(response.remoteAddress());
            IllegalArgumentException.class,
                    Version1Response response = new Version1Response(1, 2);
            StringMessageRequest::new,
        toNodeMap.put(serviceA, nodeA);
            appender.addExpectation(responseReceivedExpectation);
    public void testHelloWorldCompressed() throws IOException {
            // now, try and send another request, this times, with a short timeout
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
        for (int i = 0; i < halfSenders; i++) {
                TransportRequestOptions.EMPTY,
        try (Transport.Connection connection = serviceC.openConnection(serviceB.getLocalNode(), builder.build())) {
            }
            TransportRequestOptions.Type.BULK,
                    responseErrors.add(e);
            this.message = in.readString();
            );
            }
                return randomBoolean() ? ThreadPool.Names.SAME : ThreadPool.Names.GENERIC;
        assertEquals(0, stats.getTxSize().getBytes());
        );
                }
                    assertNull(threadPool.getThreadContext().getTransient("boom"));
            StringMessageRequest::new,
        ClusterSettings clusterSettings = new ClusterSettings(randomSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    assertNull(threadPool.getThreadContext().getTransient("boom"));
            final String errorResponseReceived = ".*\\[internal:testError].*received response from.*\\{TS_B}.*";
        assertEquals("ping_user", threadPool.getThreadContext().getHeader("test.ping.user"));
                        inFlight.release();
            assertEquals(115, stats.getTxSize().getBytes());
                        }
                }
            "internal:action1",
        boolean await = allRequestsDone.await(5, TimeUnit.SECONDS);
        }
                    assertTrue(threadPool.getThreadContext().getResponseHeaders().containsKey("foo.bar"));
            channel.sendResponse(response);
    }
            assertEquals(0, ((TcpTransport) transport).getNumPendingHandshakes());
            });
        }
                    assertThat(response.value1, equalTo(1));
                    public StringMessageResponse read(StreamInput in) throws IOException {
            ThreadPool.Names.SAME,
            "internal:sayHelloException",
        );
            assertEquals(-1, settings.publishPort);
            }
        assertThat("found non connection errors while responding", responseErrors, empty());
            res.txGet();
import org.opensearch.Version;
                        return TransportResponse.Empty.INSTANCE;
                @Override
                connection,
                }
                }
            @Override
        final CountDownLatch latch = new CountDownLatch(2);
        final CountDownLatch latch = new CountDownLatch(1);
                    assertThat(cause, instanceOf(ConnectTransportException.class));
import org.opensearch.core.transport.TransportResponse;
        serviceA.close();
            }
                }
                    new TestRequest(),
                1,
            if (in.getVersion().onOrAfter(version1)) {
            assertThat(e.getCause(), instanceOf(OpenSearchException.class));
        );
            public TransportResponse read(StreamInput in) {
            .put("transport.profiles.some_profile.tcp.keep_alive", enable)
                @Override
    }
                            @Override
        final Version version,
import java.util.Set;
            assertThat("hello moshe", equalTo(message.message));
                    return new StringMessageResponse(in);
        try {
        @Override
            public TransportResponse read(StreamInput in) {
            );
    public void assertNumHandshakes(long expected, Transport transport) {
            );
        TransportInterceptor interceptor
            serviceB.sendRequest(
                TransportRequestOptions.EMPTY,
        assertEquals(Collections.singletonList("the_bind_host"), settings.bindHosts);
            public void handleException(TransportException exp) {}
            @Override
        assertEquals("Failed to bind to " + NetworkAddress.format(inetSocketAddress), bindTransportException.getMessage());
                final long timeTaken = TimeValue.nsecToMSec(now - startTime);
                TransportRequestOptions.Type.PING,
                    }
    public void testTransportStats() throws Exception {
    public void testChannelCloseWhileConnecting() {
        serviceB.registerRequestHandler("internal:testError", ThreadPool.Names.SAME, StringMessageRequest::new, handlerWithError);
            "internal:sayHello",
                    } catch (IOException e) {
                TestRequest::new,
                try {
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
            message = in.readString();
                } else {
            .put("transport.profiles.some_profile.tcp.receive_buffer_size", "42000b")
        }
                TransportRequestOptions.Type.STATE
        CountDownLatch latch = new CountDownLatch(1);
            .put("transport.tcp.keep_alive", enable)
            public void onRequestSent(
        }
            );
                    fail(e.getMessage());
                    }
                    try {
            fail("exception should be thrown");
                }
                Level.TRACE,
        serviceA.disconnectFromNode(nodeA);
            .put("transport.profiles.some_profile.tcp.no_delay", enable)
                emptyMap(),
                long startTime = System.nanoTime();
                TransportRequestOptions.Type.BULK,
                    }
                @Override
            .put("transport.profiles.some_profile.publish_port", 42)
    }
                        assertThat("hello moshe", equalTo(response.message));
                try {
        final TransportRequestHandler<TestRequest> ignoringRequestHandler = (request, channel, task) -> {
        // will not get this callback called on the connections done in this setup
            final int sender = i;
            public String executor() {
            TransportRequestOptions.Type.PING,
            assertTrue(profileBoundAddresses.containsKey("some_profile"));
            try {
        serviceB.addMessageListener(tracerB);
        public void writeTo(StreamOutput out) throws IOException {
                        public String executor() {
                    assertThat("hello moshe", equalTo(response.message));
                @Override
    }
            (request, channel, task) -> {
        try (TransportService service = buildService("TS_TPC", Version.CURRENT, Settings.EMPTY)) {
        };
        try (Transport.Connection connection = serviceC.openConnection(serviceB.getLocalNode(), builder.build())) {
    }
    public void setUp() throws Exception {
        serviceB.close();
    }
        // use assert busy as callbacks are called on a different thread
        Map<TransportService, DiscoveryNode> toNodeMap = new HashMap<>();
        ).txGet();
        final Object context = new Object();
            }
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);
        final Version version,
        Version1Request version1Request = new Version1Request();
                    .put("transport.profiles.some_profile.bind_host", "_local:ipv4_")
package org.opensearch.transport;
                TransportRequestOptions.Type.REG,
                    latch.countDown();
                "TS_TPC",
            .put("transport.tcp.keep_count", "14")
                            latch.countDown();
            nodeB,
            builder.addConnections(
            .put(TransportSettings.CONNECTIONS_PER_NODE_REG.getKey(), 2)
            assertEquals(2, stats.getRxCount());
        version1Request.value1 = 1;
        AtomicBoolean fail = new AtomicBoolean(false);
 * You may obtain a copy of the License at
            }
                }
        }
            }
                }
        ).txGet();
                assertEquals(1, transportStats.getRxCount());
        String includeSettings;
                public StringMessageResponse read(StreamInput in) throws IOException {
            .put(randomBoolean() ? defaultProfileSettings : Settings.EMPTY)
                TransportRequestOptions.Type.REG,
            return "TestRequest{" + "info='" + info + '\'' + '}';
            1,
 * under the License.
            channel.sendResponse(response);
                }
        TestResponse(StreamInput in) throws IOException {
                TransportRequestOptions.Type.REG,
                public void handleResponse(StringMessageResponse response) {
                        }
            }
        final CountDownLatch done = new CountDownLatch(halfSenders * 2);
                        }
                new TestRequest("hello world"),
                        throw new UncheckedIOException(e1);
            TransportRequestOptions.EMPTY,
                    TransportRequestOptions.EMPTY,
                }
        }
            assertEquals(ex.getMessage(), "[][" + dummy.getAddress() + "] general node connection failure");
                @Override
    }
            );
                @Override
    }
            TransportRequestOptions.Type.RECOVERY,
                @Override
        if (transport instanceof TcpTransport) {
    }
                    try (Socket accept = socket.accept()) {
        try (ServerSocket socket = new ServerSocket()) {
                    Throwable cause = ExceptionsHelper.unwrapCause(exp);
                public Version1Response read(StreamInput in) throws IOException {
            .put("transport.tcp.receive_buffer_size", "42000b")
            public TestResponse read(StreamInput in) throws IOException {
                }
        fail.set(randomBoolean());
                foobar.txGet();
                    logger.error("Unexpected failure", e);
            final MockLogAppender.LoggingExpectation errorResponseSentExpectation = new MockLogAppender.PatternSeenEventExpectation(
            includeSettings = randomBoolean() ? "*" : "";
            @Override
            Throwable cause = ExceptionsHelper.unwrapCause(e);
            out.writeString(message);
        serviceB.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
                    .putList("transport.profiles.some_other_profile.publish_host", "_local:ipv4_")
            .put("transport.tcp.reuse_address", !enable)
    private MockTransportService buildService(
            .put("transport.profiles.default.tcp.keep_alive", enable)
import org.opensearch.core.action.ActionListener;
                    return ThreadPool.Names.GENERIC;
            public TransportResponse read(StreamInput in) {
                logger.error("Unexpected failure", e);
            "internal:sayHello",
                randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
        } catch (Exception e) {
    }
            .put("network.publish_host", "the_publish_host")
            .put("transport.profiles.some_profile.port", "9700-9800")
            @Override
                }
    public static class StringMessageRequest extends TransportRequest {
        version1Request.value2 = 2;
        return buildService(name, version, clusterSettings, settings, true, true);
        Version0Response(int value1) {
        } catch (ExecutionException e) {
            assertThat(request.value2, equalTo(2));
        serviceC.removeConnectionListener(waitForConnection);
    }
import org.apache.logging.log4j.LogManager;
                TransportRequest request,
                }
                    }
            builder.addConnections(
                assertEquals(115, transportStats.getTxSize().getBytes());
                    logger.error("Unexpected failure", e);
                            }
        final CyclicBarrier go = new CyclicBarrier(halfSenders * 2 + 1);
        });
                emptySet(),
        boolean doHandshake,
    public void testNotifyOnShutdown() throws Exception {
            fail("exception should be thrown");
                latch.countDown();
                                    (Supplier<?>) () -> new ParameterizedMessage("caught exception while sending to node {}", node),
                public void onFailure(Exception e) {
            (request, message, task) -> {
    }
                @Override
            .put(globalSettings2)
        serviceC.acceptIncomingRequests();
                if (randomBoolean()) {
                }
            public String executor() {
        serviceC.close();
            }
                            public TestResponse read(StreamInput in) throws IOException {
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.action.ActionListenerResponseHandler;
            .put("network.tcp.keep_interval", "8")
                responseLatch.countDown();
            clusterSettings = new ClusterSettings(updatedSettings, getSupportedSettings());
            public void handleResponse(TransportResponse response) {
                serviceA.disconnectFromNode(nodeB);
                assertEquals(115, transportStats.getTxSize().getBytes());
            };
                        public TestResponse read(StreamInput in) throws IOException {
        // wait till all nodes are properly connected and the event has been sent, so tests in this class
            public TransportResponse read(StreamInput in) {
        super.tearDown();
            final MockLogAppender.LoggingExpectation notSeenSentExpectation = new MockLogAppender.UnseenEventExpectation(
            TransportRequestOptions.Type.STATE
            assertBusy(appender::assertAllExpectationsMatched);
        serviceB.registerRequestHandler("internal:test", ThreadPool.Names.SAME, StringMessageRequest::new, handler);
        }
 * Unless required by applicable law or agreed to in writing,
                @Override
            service.acceptIncomingRequests();
                public String executor() {
        serviceB.registerRequestHandler("internal:test", ThreadPool.Names.SAME, TestRequest::new, ignoringRequestHandler);
                }
import org.opensearch.common.SuppressForbidden;
                    fail("got response instead of exception");
            }
        serviceA.registerRequestHandler(
 * GitHub history for details.
            }
                        logger.error("Unexpected failure", exp);
                "fail-to-send-action",
                "received request",
                assertThat(message, notNullValue());
            // all is well
                    } catch (IOException e1) {
        final CountDownLatch responseLatch = new CountDownLatch(1);
import org.opensearch.core.common.transport.BoundTransportAddress;
            @Override
            });
        int numHandshakes = 1;
            .put("transport.profiles.some_profile.tcp.reuse_address", enable)
            PlainActionFuture<Transport.Connection> future = PlainActionFuture.newFuture();
                                } catch (Exception e) {
                version0
                Settings.builder()
        );
            final MockLogAppender.LoggingExpectation requestSentExpectation = new MockLogAppender.PatternSeenEventExpectation(
        nodeA = serviceA.getLocalNode();
        @Override
    }
            .put("transport.tcp.send_buffer_size", "5b")
            responseLatch.await();
                            doneWaitingForever.countDown();
                    Version0Response response = new Version0Response(1);
                public StringMessageResponse read(StreamInput in) throws IOException {
                            logger.error("Unexpected failure", e);
                "org.opensearch.transport.TransportService.tracer",
        });
            service.addConnectionListener(new TransportConnectionListener() {
            }
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);
            TransportRequestOptions.Type.BULK,
                    }
        }
            value1 = in.readInt();
        final Version version,
            fail("message round trip did not complete within a sensible time frame");
            .put(TransportSettings.CONNECTIONS_PER_NODE_PING.getKey(), 1);
    public void testKeepAlivePings() throws Exception {
        serviceB.removeConnectionListener(waitForConnection);
        );
                                return randomBoolean() ? ThreadPool.Names.SAME : ThreadPool.Names.GENERIC;
            assertEquals(channelsPerNodeConnection(), transportStats.getServerOpen());
                    logger.debug("send response for {}", request.info);
                } finally {
            @Override
        final String executor = randomFrom(ThreadPool.THREAD_POOL_TYPES.keySet().toArray(new String[0]));
    static class StringMessageResponse extends TransportResponse {
                                );
            assertThat(tracerA.responseSent.get(), equalTo(2));
            );
        }
                assertEquals(connection.getVersion(), connection.getVersion());
        assertThat(version0Response.value1, equalTo(1));
                public void handleException(TransportException exp) {
                } catch (IOException e) {
            super(in);
                public void handleException(TransportException exp) {
import org.opensearch.test.MockLogAppender;
            final MockLogAppender.LoggingExpectation notSeenResponseSentExpectation = new MockLogAppender.PatternSeenEventExpectation(
            fail("exception should be thrown");
        assertThat("pong", equalTo(message.message));
                    "test didn't timeout quick enough, time taken: [" + timeTaken + "]",
            .put(TransportSettings.HOST.getKey(), address)
                public void messageReceived(Version0Request request, TransportChannel channel, Task task) throws Exception {
            @Override
            assertThat(tracerA.requestsReceived.get(), equalTo(0));
                        return ThreadPool.Names.SAME;
                public String executor() {
            hosts = Arrays.asList("_local:ipv6_", "_local:ipv4_");
        doneWaitingForever.await();
        waitForever.countDown();
            new TestRequestHandler(serviceB)
            @Override
            assertEquals(Collections.singletonList("the_publish_host"), settings.publishHosts);
                    assertThat(exp, instanceOf(ReceiveTimeoutTransportException.class));
                public String executor() {
                TransportRequestOptions.Type.STATE
        }
        ) {
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
                return ThreadPool.Names.SAME;
            @Override
            TransportRequestOptions.Type.STATE
                        return ThreadPool.Names.GENERIC;
        }
        res = serviceB.submitRequest(
                "received error response",
            assertThat(tracerB.requestsSent.get(), equalTo(1));
                TransportRequestOptions.Type.REG,
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
                "org.opensearch.transport.TransportService.tracer",
            );
                Level.TRACE,
 *    http://www.apache.org/licenses/LICENSE-2.0
            (request, channel, task) -> {
            .put("transport.tcp.reuse_address", enable)
        serviceA.registerRequestHandler(
        try (TransportService service = buildService("TS_TPC", Version.CURRENT, Settings.EMPTY)) {
            assertThat(tracerA.responseReceived.get(), equalTo(1));
                    }
            out.writeOptionalString(info);
    }
            }
        serviceC.acceptIncomingRequests();
                @Override
            @Override
            assertNoPendingHandshakes(serviceB.getOriginalTransport());
    }
    public void testHandshakeUpdatesVersion() throws IOException {
        TransportService serviceC = buildService("TS_C", version0, Settings.EMPTY);
        serviceB.registerRequestHandler(
                connection,
                TransportRequestOptions.builder().withTimeout(3000).build(),
                    return new StringMessageResponse(in);
        // wait for the transport to process the sending failure and disconnect from node
                public void onFailure(Exception e) {
        );
                        ipv6++;
                serviceB = newService;
            .put("transport.profiles.default.tcp.receive_buffer_size", "42000b")
                if (randomBoolean()) {
                errorResponseSent
            new TransportResponseHandler<StringMessageResponse>() {
            final MockLogAppender.LoggingExpectation responseReceivedExpectation = new MockLogAppender.PatternSeenEventExpectation(
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
    }
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
                }
        class TestRequestHandler implements TransportRequestHandler<TestRequest> {
                            new ActionListenerResponseHandler<>(listener, TestResponse::new)
            );
                }
                        try {
        TransportConnectionListener disconnectListener = new TransportConnectionListener() {
                TransportRequestOptions.Type.RECOVERY,
                @Override
        final String ACTION = "internal:action";
            TestRequest::new,
            "internal:action1",
            exception.writeTo(streamOutput);
                public StringMessageResponse read(StreamInput in) throws IOException {
                    public void handleException(final TransportException exp) {
                            TimeValue sleep = TimeValue.parseTimeValue(message, null, "sleep");
                        }
        ConnectionProfile connectionProfile = ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY);
            clusterSettings,
                    }
            @Override
                public StringMessageResponse read(StreamInput in) throws IOException {
        CollectionUtil.timSort(executors); // makes sure it's reproducible
            Version0Request::new,
            }
                "internal:sayHello",
                    try {
    }
            assertThat(tracerA.requestsReceived.get(), equalTo(1));
            public String executor() {
                    assertEquals(1, threadPool.getThreadContext().getResponseHeaders().get("foo.bar").size());
        serviceA.disconnectFromNode(nodeC);
                new StringMessageRequest("moshe"),
            this.message = message;
                return ThreadPool.Names.SAME;
        serviceA.addConnectionListener(disconnectListener);
        }
            } else {
            responseLatch.await();
                TransportRequestOptions.Type.PING,
import java.util.HashSet;
                assertEquals(1, transportStats.getTxCount());
                }
    public void testVersionFrom0to0() throws Exception {
            assertTrue(profileBoundAddresses.get("some_other_profile").publishAddress().getPort() >= 8700);
        for (int i = 0; i < halfSenders; i++) {
        } catch (ConnectTransportException e) {
                @Override
                }
                }
                    public TransportResponse read(final StreamInput in) {
                                try {
            .put("transport.profiles.default.publish_host", "the_publish_host")
            assertNotNull(exception);
    public void testHandlerIsInvokedOnConnectionClose() throws IOException, InterruptedException {
            public String executor() {
            @Override
import java.net.InetSocketAddress;
    public void testHelloWorld() {
                }
import org.opensearch.test.transport.MockTransportService;
                errorResponseReceived
            ThreadPool.Names.GENERIC,
                                new TestRequest(info),
                }
            builder.addConnections(
                public void handleResponse(Version0Response response) {
                new TransportResponseHandler<TransportResponse>() {
                }
        serviceB.registerRequestHandler(
                    fail("got exception instead of a response: " + exp.getMessage());
    @Before
            super.writeTo(out);
            }
        TcpTransport originalTransport = (TcpTransport) serviceA.getOriginalTransport();
                public void onConnectionClosed(Transport.Connection connection) {
                        @Override
            StringMessageRequest::new,
                public Version0Response read(StreamInput in) throws IOException {
            .put("transport.profiles.default.tcp.send_buffer_size", "43000b")
            assertThat(tracerA.responseSent.get(), equalTo(0));
        Version version = Version.fromString("6.0.0");
        assertEquals(1, profileSettings.size());
                }
            .put(settings)
            threadPool.getThreadContext().putTransient("boom", new Object());
            }
        final String name,
                        return new StringMessageResponse(in);
                // simulate restart of nodeB
            timeout = in.readLong();
        CountDownLatch receivedLatch = new CountDownLatch(1);
                }
            assertEquals(failedMessage, 57 + streamOutput.bytes().length(), stats.getRxSize().getBytes());
            .put("network.bind_host", "the_bind_host")
                    fail("got exception instead of a response: " + exp.getMessage());
            info = in.readOptionalString();
        Version1Response version1Response = serviceB.submitRequest(
                TransportRequestOptions.EMPTY,
                    new TransportResponseHandler<TestResponse>() {
                @Override
        assertEquals(enable, settings.tcpNoDelay);
        assumeTrue("only tcp transport has a handshake method", serviceA.getOriginalTransport() instanceof TcpTransport);
            assertThat(e, instanceOf(ReceiveTimeoutTransportException.class));
            nodeA,
                }
            @Override
 * The OpenSearch Contributors require contributions made to
            ) {
                assertEquals(IOException.class, unwrap.getClass());
        expectThrows(ConnectTransportException.class, () -> serviceB.openConnection(nodeA, TestProfiles.LIGHT_PROFILE));
                    return ThreadPool.Names.GENERIC;
                @Override
            new TransportResponseHandler<StringMessageResponse>() {
        serviceC.connectToNode(nodeA);
                    return new StringMessageResponse(in);
import org.opensearch.test.junit.annotations.TestLogging;
        Settings settings,
            new TransportRequestHandler<Version0Request>() {
import org.opensearch.ExceptionsHelper;
            );
            socket.setReuseAddress(true);
    public void testBindUnavailableAddress() {
        serviceA.registerRequestHandler("internal:testError", ThreadPool.Names.SAME, StringMessageRequest::new, handlerWithError);
        Version0Request version0Request = new Version0Request();
            final int counter = i;
                TransportRequest.Empty.INSTANCE,
                @Override
            TestRequest::new,
            1,
                    logger.error("Unexpected failure", exp);
                } catch (IOException e) {
                fail("node connected should not be called, all connection have been done previously, node: " + node);
        });
import static org.hamcrest.Matchers.hasToString;
                    } catch (Exception e) {
    }
                Level.TRACE,
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
                new TestRequest("boom"),
                    assertEquals("baz", threadPool.getThreadContext().getResponseHeaders().get("foo.bar").get(0));
        Settings settings,
        Set<TcpTransport.ProfileSettings> profileSettings = TcpTransport.getProfileSettings(Settings.EMPTY);
            super(in);
                return ThreadPool.Names.SAME;
            }
                    logger.error("Unexpected failure", exp);
                    }
    public void testTracerLog() throws Exception {
import static org.hamcrest.Matchers.startsWith;
                serviceA.connectToNode(nodeB);
                }
        serviceA.addConnectionListener(waitForConnection);
            public AsyncSender interceptSender(final AsyncSender sender) {
        assertEquals(enable, settings.reuseAddress);
            resendCount = in.readInt();
                                "internal:test",
                }
                        logger.error("Unexpected failure", exp);
                    .putList("transport.profiles.some_other_profile.bind_host", hosts)
        };
                    public String executor() {
        serviceC.acceptIncomingRequests();
                    @Override
                        }
            threadPool,
                    assertThat(response.value1, equalTo(1));
        serviceC.acceptIncomingRequests();
            );
            final Transport.Connection connection = serviceC.getConnection(nodeA);
 * this work for additional information regarding copyright
        } catch (ExecutionException e) {
        assertEquals(0, stats.getTxCount());
    protected static final Version version0 = CURRENT_VERSION.minimumCompatibilityVersion();
                    @Override
                            public void handleResponse(TestResponse response) {
                }
                TransportStats transportStats = serviceC.transport.getStats(); // request has been sent
            public String executor() {
        Version0Response version0Response = serviceA.submitRequest(
        String address = serviceA.boundAddress().publishAddress().getAddress();
                assertEquals(ex.getMessage(), "[][" + second.getAddress() + "] connect_timeout[1ms]");
            TransportRequestOptions.builder().withTimeout(100).build(),
                .put(TransportSettings.TRACE_LOG_EXCLUDE_SETTING.getKey(), excludeSettings)
        }
            }
import org.opensearch.test.OpenSearchTestCase;
    }
            );
            "internal:sayHelloTimeoutNoResponse",
            });
                } finally {
            try {
        public void writeTo(StreamOutput out) throws IOException {
            assertThat(e.getMessage(), false, equalTo(true));
            }
            latch3.await();
        );
                    assertSame(response, TransportResponse.Empty.INSTANCE);
                    @Override
                return randomFrom(executors);
        }
        });
            assertThat(ex.getCause().getMessage(), startsWith("handshake failed"));
            failToSendException = new TransportException("fail to send");
            }
            try (TransportService service = buildService("TS_TPC", Version.CURRENT, null, Settings.EMPTY, true, false)) {
            @Override
                "TEST",
                    String message = request.message;
        }
            } catch (Exception e) {
        assertThat("failed to wait for all nodes to connect", latch.await(5, TimeUnit.SECONDS), equalTo(true));
                new TestRequest("hello world"),
                        fail("got exception instead of a response: " + exp.getMessage());
    public void testFailToSend() throws InterruptedException {
            }
        );
                        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
            appender.addExpectation(requestReceivedExpectation);
            this.message = message;
                public void onConnectionOpened(final Transport.Connection connection) {
            public void handleException(TransportException exp) {
        );
                DiscoveryNode node,
                            @Override
    }
                try {
            new TransportRequestHandler<Version1Request>() {
                    return new StringMessageResponse(in);
            Collections.emptySet(),
                public void handleResponse(StringMessageResponse response) {
                    try {
        serviceC.registerRequestHandler(
        go.await();
                                return new TestResponse(in);
                    }
        }
        assertThat(responseString.get(), equalTo("test"));
                    channel.sendResponse(response);
            );
                value2 = 0;
        serviceB.addConnectionListener(waitForConnection);
        String excludeSettings;
            if (in.getVersion().onOrAfter(version1)) {
                    }
            if (out.getVersion().onOrAfter(version1)) {
            final String requestReceived = ".*\\[internal:test].*received request.*";
            final CountDownLatch latch = new CountDownLatch(1);
        logger.debug("waiting for response");
            assertThat(tracerB.requestsSent.get(), equalTo(0));
        Set<Exception> sendingErrors = ConcurrentCollections.newConcurrentSet();
        boolean acceptRequests,
            if (request.timeout() > 0) {
                "internal:sayHelloTimeoutDelayedResponse",
        try (MockTransportService service = buildService("TS_C", version, Settings.EMPTY)) {
            channel.sendResponse(new TestResponse((String) null));
                @Override
        TransportStats stats = serviceC.transport.getStats(); // nothing transmitted / read yet
                    service.sendRequest(
            .put("transport.tcp.keep_alive", !enable)
            .put("network.tcp.receive_buffer_size", "3b")
                        logger.error("Unexpected failure", exp);
                        return new StringMessageResponse(in);
                @Override
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
            appender.addExpectation(errorResponseReceivedExpectation);
            stats = serviceC.transport.getStats(); // exception response has been received
                responseReceived
        serviceB.disconnectFromNode(nodeC);
            res.txGet();
                    }
    ) {
        }
            } else {
                        new TestRequest("secondary " + request.info),
                        "internal:action1",
            assertEquals(version0, channel.getVersion());
            ThreadPool.Names.GENERIC,
                } finally {
            .put(TransportSettings.PORT.getKey(), port)
    public static class Version0Request extends TransportRequest {
                "org.opensearch.transport.TransportService.tracer",
        };
    }
                if (action.equals(ACTION)) {
            assertThat(e, hasToString(containsString(("a channel closed while connecting"))));
                new ActionListener<Void>() {
            );
                requestReceived
        }
        assertThat(version1Response.value2, equalTo(0));
            @Override
                    latch.countDown();
        latch.await();
            );
                                    logger.debug("send secondary exception response for request {}", request.info);
        public void writeTo(StreamOutput out) throws IOException {
                version0
            }
            assertTrue(connectionClosedListenerCalled.get());
            hosts = Arrays.asList("_local:ipv4_");
            (request, channel, task) -> {
        try {
            );
                assertEquals(29, transportStats.getRxSize().getBytes());
            public void handleResponse(TransportResponse response) {
        assertTrue("serviceA is not connected to nodeA", serviceA.nodeConnected(nodeA));
            }
                    latch.countDown();
                    @Override
            // handshake which I haven't tested yet.
    }
            } catch (Exception e) {
            serviceA.registerRequestHandler(
import org.opensearch.common.util.concurrent.AbstractRunnable;
            version0Request,
            TestRequest::new,
import java.net.ServerSocket;
                TransportRequestOptions.Type.RECOVERY,
        final CountDownLatch latch = new CountDownLatch(4);
            this.value1 = value1;
                }
        }
            ThreadPool.Names.GENERIC,
        StubbableTransport.WrappedConnection wrappedConnection = (StubbableTransport.WrappedConnection) connection;
    public void testTimeoutSendExceptionWithNeverSendingBackResponse() throws Exception {
            StringMessageRequest::new,
                    throw new IOException("forced failure");
        }
                @Override
            NoopTracer.INSTANCE
            "internal:version",
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
        assertEquals("9700-9800", settings.portOrRange);
    }
                            );
            .put("transport.profiles.default.bind_host", "the_bind_host")
        nodeB = serviceB.getLocalNode();
                    channel.sendResponse(new TestResponse((String) null));
        StringMessageResponse message = res.get();
                public StringMessageResponse read(StreamInput in) throws IOException {
                throw new AssertionError("boom");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.nullValue;
                    @Override
                emptySet(),
                public String executor() {
            transport,
                assertEquals(1, transportStats.getRxCount());
                assertEquals(1, transportStats.getRxCount());
                }
                TransportRequestOptions.Type.STATE
                    .put("transport.profiles.some_other_profile.port", "8700-8800")
            }
            serviceC.close();
            public void handleException(TransportException exp) {
                assertFalse(requestProcessed.get());
 *
        };
                int ipv6 = 0;
        try (Transport.Connection connection = serviceB.openConnection(serviceC.getLocalNode(), builder.build())) {
        });
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
                public String executor() {
                (request, channel, task) -> {
        final int value2;
            }
    public void testTimeoutSendExceptionWithDelayedResponse() throws Exception {
            }
            () -> serviceB.registerRequestHandler(
        }
        version0Request.value1 = 1;
            .put("transport.tcp.keep_interval", "7")
            .build();
                    @Override
            interceptor,
            new TransportResponseHandler<StringMessageResponse>() {
                    return new StringMessageResponse(in);
                CountDownLatch latch2 = new CountDownLatch(1);
                public String executor() {
                }
                    fail("got exception instead of a response: " + exp.getMessage());
                    sendResponseLatch.await();
                    logger.error("Unexpected failure", exp);
                public void onFailure(Exception e) {
            @Override
        assertTrue(inFlight.tryAcquire(Integer.MAX_VALUE, 10, TimeUnit.SECONDS));
            );
            "internal:sayHelloException",
                @Override
                    }
            TransportFuture<StringMessageResponse> result = serviceB.submitRequest(
    public void testHostOnMessages() throws InterruptedException {
                assertEquals(55, transportStats.getTxSize().getBytes());
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);
                @Override
            );
                @Override
                MockTransportService newService = buildService("TS_B_" + i, version1, Settings.EMPTY);
            serviceB.disconnectFromNode(nodeA);
            sendResponseLatch.countDown();
        serviceC.connectToNode(nodeB);
                    channel.sendResponse(response);
            @Override
                (request, channel, task) -> {
                    responseSent.incrementAndGet();
                @Override
    @TestLogging(value = "org.opensearch.transport.TransportService.tracer:trace", reason = "to ensure we log network events on TRACE level")
    public void testLocalNodeConnection() throws InterruptedException {
                "internal:action",
                        }
            final String responseSent = ".*\\[internal:test].*sent response.*";
                @Override
                            } catch (ConnectTransportException e) {
                    fail("got response instead of exception");
                }
                        node,
    private static final Version CURRENT_VERSION = Version.fromString(String.valueOf(Version.CURRENT.major) + ".0.0");
                        fail(e.getMessage());
        assertThat(version0Response.value1, equalTo(1));
        serviceB.registerRequestHandler(
                    }
                public void handleException(TransportException exp) {
            );
                        serviceB.sendRequest(
                    assertThat(response.value2, equalTo(0)); // initial values, cause its serialized from version 0
    protected ThreadPool threadPool;
                "org.opensearch.transport.TransportService.tracer",
                1,
            TransportRequestOptions.builder().withTimeout(100).build(),
        try {
        serviceA.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
            }
            }
            .put(TransportSettings.PORT.getKey(), getPortRange())
            TransportRequestOptions.Type.PING,
        for (Runnable runnable : assertions) {
                    fail(e.getMessage());
        public TestRequest() {}
            }
            .put("transport.profiles.some_profile.tcp.keep_count", "13")
                );
                    go.await();
            .build();
                TransportRequestOptions.Type.PING,
            serviceC.connectToNode(
                    responseString.set(response.message);
        };
                if (randomBoolean() && request.resendCount++ < 20) {
                        );
                allRequestsDone.countDown();
                node,
            .build();
        }
            try {
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
                    assertEquals(version0, channel.getVersion());
            "internal:sayHelloTimeoutNoResponse",
                "internal:foobar",
            fail("exception should be thrown");
import org.opensearch.core.common.transport.TransportAddress;
            ThreadPool.Names.GENERIC,
            "internal:version",
import static org.hamcrest.Matchers.instanceOf;
            .put(globalSettings2)
                "sent response",
            }
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
                        fail(e.getMessage());
                }
                assertThat(te.get().getMessage(), equalTo("failure to send"));
                    assertThat(request.value1, equalTo(1));
    }
        );
        try (TransportService service = buildService("TS_TEST", version0, null, Settings.EMPTY, false, false)) {
                        assertTrue(exp.getCause().getClass().toString(), exp.getCause() instanceof NodeNotConnectedException);
            assertBusy(() -> { // netty for instance invokes this concurrently so we better use assert busy here
            StringMessageResponse message = res.get();
                transportResponseHandler
        if (randomBoolean()) {
                @Override
            }
                    inFlight.acquireUninterruptibly();
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
        }
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
        );
            Thread t = new Thread() {
            }
        );
                    }
                public void messageReceived(Version1Request request, TransportChannel channel, Task task) throws Exception {
            assertions.add(() -> {
                serviceA.getLocalDiscoNode(),
            builder.addConnections(
            TransportRequestOptions.Type.BULK,
        );
    public void testTcpHandshakeTimeout() throws IOException {
        }
                        if ("forever".equals(message)) {
            }
import java.util.Map;
        List<String> executors = new ArrayList<>(ThreadPool.THREAD_POOL_TYPES.keySet());
                    public void handleException(TransportException exp) {
                        if ("forever".equals(message)) {
                        }
        // This is a customized profile for this test case.
        }
    @Override
        );
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(nodeA, "internal:ping_pong", ping, responseHandler);
    }
            nodeA,
            // don't block on a network thread here
            public void handleResponse(TestResponse response) {
                @Override
            );
                serviceA.sendRequest(
        final CountDownLatch latch = new CountDownLatch(2);
                        @Override
        }
            .build();
                out.writeInt(value2);
                        final TransportRequestOptions options,
                }
        assertBusy(() -> {
                @Override
                    assertThat("runtime_exception: bad message !!!", equalTo(exp.getCause().getMessage()));
    private void closeConnectionChannel(Transport.Connection connection) {
            }
                @Override
                @Override
                public void onAfter() {
        Settings globalSettings2 = Settings.builder()
                latch.countDown();
                            waitForever.await();
        } catch (Exception e) {
            serviceA.disconnectFromNode(nodeB);
            () -> buildService("test", Version.CURRENT, settings)
            channel.sendResponse(new RuntimeException(""));
                        }
        assertEquals(0, stats.getRxSize().getBytes());
    protected int channelsPerNodeConnection() {
                                }
                assertThat("hello moshe", equalTo(message.message));
                        return ThreadPool.Names.GENERIC;
            TestRequest::new,
            assertThat(tracerB.responseReceived.get(), equalTo(0));
    private MockTransportService buildService(
                        if ("fail-to-send-action".equals(action)) {
                emptySet(),
            // all is well
                TransportRequestOptions.Type.PING,
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
                @Override
        InetSocketAddress inetSocketAddress = serviceA.boundAddress().publishAddress().address();
        try (ServerSocket socket = new ServerSocket()) {
            (request, channel, task) -> {
                return new TestResponse(in);
                        final DiscoveryNode node = nodeB; // capture now
            });
            public void onResponseSent(long requestId, String action, Exception error) {
        };
                    }
            "internal:sayHello",
                            @Override
    @Override
            DiscoveryNode node = new DiscoveryNode("TS_TPC", "TS_TPC", address, emptyMap(), emptySet(), version0);
                    receivedLatch.countDown();
        Settings profileSettings = Settings.builder()
                        }
                    return ThreadPool.Names.GENERIC;
            super.writeTo(out);
        } else {
        assertSame(context, threadPool.getThreadContext().getTransient("my_private_context"));
import org.apache.logging.log4j.Logger;
        serviceA.connectToNode(nodeC);
    }
            }
                }
                    responseReceived.incrementAndGet();
                @Override
import org.junit.Before;
                TransportStats transportStats = serviceC.transport.getStats(); // we did a single round-trip to do the initial handshake
        final String name,
                public void handleException(TransportException exp) {
        serviceC.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
                assertEquals(2, transportStats.getTxCount());
    }
        );
        }
                @Override
                version0,
        }
                serviceB.close();
                connection,
                public void handleResponse(StringMessageResponse response) {
                @Override
                assertEquals(0, originalTransport.getKeepAlive().failedPingCount());
            builder.setHandshakeTimeout(TimeValue.timeValueMillis(1));
                new TransportResponseHandler<StringMessageResponse>() {
                assertThat("moshe", equalTo(request.message));
            }
        CountDownLatch allRequestsDone = new CountDownLatch(iters);
            }
            final ConnectTransportException e = expectThrows(
            }
                assertEquals(29, transportStats.getRxSize().getBytes());
 * Licensed to Elasticsearch under one or more contributor
import java.util.ArrayList;
                TransportRequestOptions.Type.PING,
        version0Request.value1 = 1;
                    logger.debug("send secondary request from {} to {} - {}", toNodeMap.get(service), node, request.info);
        version1Request.value1 = 1;
            StringMessageRequest request = new StringMessageRequest("", 10);
 *
        toNodeMap.put(serviceB, nodeB);
            .put("transport.profiles.some_profile.bind_host", "the_bind_host")
            return timeout;
                    go.await();
            private final TransportService service;
                    latch.countDown();
        assertBusy(() -> {
            assertThat(tracerA.requestsReceived.get(), equalTo(2));
                }
        );
                    return ThreadPool.Names.SAME;
        });
        try (ServerSocket socket = new ServerSocket()) {
                StringMessageRequest::new,
            // into a connection timeout quickly. Yet other implementations can for instance can terminate the connection within the 3 way
                    } else {
                    requestsSent.incrementAndGet();
        public long timeout() {
            nodeA,
            fail("exception should be thrown");
    ) {
    ) {
        );
    }
                }
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
                    assertEquals(version0, channel.getVersion());
            TransportFuture<StringMessageResponse> res = serviceC.submitRequest(
            serviceB.close(); // make sure we are fully closed here otherwise we might run into assertions down the road
            TransportService service = randomFrom(serviceC, serviceB, serviceA);
            serviceC.acceptIncomingRequests();
        TransportResponseHandler<StringMessageResponse> noopResponseHandler = new TransportResponseHandler<StringMessageResponse>() {
        profileSettings = TcpTransport.getProfileSettings(
    public void testBlockingIncomingRequests() throws Exception {
                TransportResponse.Empty message = res.get();
        Version version = VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT);
        serviceA.registerRequestHandler(
        Version1Request(StreamInput in) throws IOException {
            .put("network.tcp.no_delay", enable)
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
            "internal:localNode",
                @Override
            } else if (serviceA.nodeConnected(nodeB)) {
                assertNull(threadPool.getThreadContext().getTransient("my_private_context"));
            }
        class CountingListener implements TransportMessageListener {
                fail(e.getMessage());
                }
        Version0Request(StreamInput in) throws IOException {
                } catch (IOException e) {
                }
                    .put("transport.profiles.some_profile.port", "8900-9000")
            new HashSet<>(Arrays.asList("default", "test")),
            }
        serviceB.registerRequestHandler(ACTION, ThreadPool.Names.GENERIC, TransportRequest.Empty::new, requestHandler);
                    @Override
            fail("exception should be thrown");
            "internal:action1",
 * license agreements. See the NOTICE file distributed with
                    public void handleException(TransportException exp) {
    }
                    public <T extends TransportResponse> void sendRequest(
            assertTrue(allRequestsDone.await(5, TimeUnit.SECONDS));
                return TransportResponse.Empty.INSTANCE;
    }
                    }
                public void handleException(TransportException exp) {
        connectionSettingsBuilder.put(TransportSettings.TCP_KEEP_ALIVE.getKey(), randomBoolean());
                public Version0Response read(StreamInput in) throws IOException {
                "org.opensearch.transport.TransportService.tracer",
            1,
            }
        return transport.getAcceptedChannels();
            "internal:version",
import static org.hamcrest.Matchers.empty;
            excludeSettings = "DOESN'T_MATCH";
                    return ThreadPool.Names.SAME;
            assertBusy(() -> { // netty for instance invokes this concurrently so we better use assert busy here
                    @Override
                protected void doRun() throws Exception {
        serviceC.start();
        }
            "internal:sayHello",
 * this file be licensed under the Apache-2.0 license or a
        final TransportRequestHandler<TransportRequest.Empty> requestHandler = (request, channel, task) -> {
                    public StringMessageResponse read(StreamInput in) throws IOException {
    public void testTimeoutPerConnection() throws IOException {
            }
        }
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
            latch2.countDown();
        MockTransportService serviceC = buildService("TS_C", version0, Settings.EMPTY);
                emptySet(),
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
        try {
                TransportStats transportStats = serviceC.transport.getStats(); // request has been sent
        serviceB.sendRequest(nodeA, "internal:action", new TestRequest(randomFrom("fail", "pass")), transportResponseHandler);
        assertBusy(() -> {
                return new TestResponse(in);
        }
            DiscoveryNode first = new DiscoveryNode(
            }
import java.io.IOException;
        try (MockTransportService serviceC = buildService("TS_C", CURRENT_VERSION, Settings.EMPTY)) {
            @Override
        }
        logger.debug("DONE");
            .put("network.tcp.receive_buffer_size", "42000b")
            serviceC.close();
            DiscoveryNode node = service.getLocalNode();
                final ConnectionProfile profile = builder.build();
                }
        }
                }
        }
        }
                () -> serviceA.connectToNode(dummy, builder.build())
            }
import java.util.concurrent.Semaphore;
                public void handleResponse(Version0Response response) {
                            );
            t.start();
                    @Override
    static class Version0Response extends TransportResponse {
        }
                                        Thread.sleep(randomIntBetween(10, 50));
        if (await == false) {
        final Logger logger = LogManager.getLogger("org.opensearch.transport.TransportService.tracer");
            assertThat(tracerB.requestsSent.get(), equalTo(1));
import static java.util.Collections.emptySet;
            public void messageReceived(TestRequest request, TransportChannel channel, Task task) throws Exception {
        TransportStats stats = serviceC.transport.getStats(); // nothing transmitted / read yet
            runnable.run();
                assertTrue(profileBoundAddresses.get("some_other_profile").boundAddresses().length >= 2);
        );
        // now try to connect again and see that it fails
            public TestResponse read(StreamInput in) throws IOException {
                return TransportResponse.Empty.INSTANCE;
        final Settings.Builder connectionSettingsBuilder = Settings.builder()
            .put(Node.NODE_NAME_SETTING.getKey(), "foobar")
    }
                notSeenReceived
                        fail("handle response should not be invoked");
        }
        // when we close C here we have to disconnect the service otherwise assertions mit trip with pending connections in tearDown
        public TestRequest(StreamInput in) throws IOException {
        Settings defaultProfileSettings = Settings.builder()
                try {
            serviceA.registerRequestHandler(
            version0Request,
        serviceC.start();
        }
        responseLatch.await();
            .put("network.tcp.send_buffer_size", "43000b")
        // use assert busy as callbacks are called on a different thread
                "TS_TPC",
        boolean acceptRequests,
                if (fail.get()) {
                    public void handleException(TransportException exp) {
            serviceA.sendRequest(nodeB, "internal:testNotSeen", new StringMessageRequest(""), future);
        }
                        try {
        // connection reset by peer or other exceptions depending on the implementation
                latch.countDown();
        class TestResponseHandler implements TransportResponseHandler<TestResponse> {
            );
import java.util.List;
            if (doIPV6) {
            // note - this test uses backlog=1 which is implementation specific ie. it might not work on some TCP/IP stacks
        if (randomSettings == globalSettings) { // publish host has no global fallback for the profile since we later resolve it based on
        assertThat(version1Response.value2, equalTo(2));
                @Override
                        logger.info("Stop ServiceB now");
            originalTransport.openConnection(node, connectionProfile, future);
                assertSame(context, threadPool.getThreadContext().getTransient("my_private_context"));
            Settings.builder().put(randomSettings).put("transport.profiles.some_profile.port", "9700-9800").build(), // port is required
                }
    public void testResponseHeadersArePreserved() throws InterruptedException {
                TransportRequestOptions.Type.RECOVERY,
        AtomicReference<TransportException> receivedException = new AtomicReference<>(null);
            final String notSeenSent = "*[internal:testNotSeen]*sent to*";
                }
    }
                "TEST",
                assertEquals("forced failure", unwrap.getMessage());
import java.util.concurrent.atomic.AtomicBoolean;
            }
        TransportResponseHandler<StringMessageResponse> responseHandler = new TransportResponseHandler<StringMessageResponse>() {
            profileSettings.stream().map(s -> s.profileName).collect(Collectors.toSet())
            }
    public void testProfilesIncludesDefault() {
            .put(randomBoolean() ? transportSettings2 : globalSettings2) // ensure that we have profile precedence
                            latch2.countDown();
                    );
            final ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
                    for (int iter = 0; iter < 10; iter++) {
            service.acceptIncomingRequests();
                return ThreadPool.Names.SAME;
            "internal:localNode",
    }
        @Override
                new StringMessageRequest(counter + "ms"),
        }
            profileSettings.stream().map(s -> s.profileName).collect(Collectors.toSet())
import org.opensearch.action.support.PlainActionFuture;
        }
                    new TransportResponseHandler<TestResponse>() {
                @Override
            public void handleException(TransportException exp) {
import java.util.Arrays;
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
                newService.registerRequestHandler("internal:test", ThreadPool.Names.SAME, TestRequest::new, ignoringRequestHandler);
                }
import org.opensearch.common.settings.Setting;
                ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY),
                channel.sendResponse(new TestResponse((String) null));
        );
                assertThat("moshe", equalTo(request.message));
        for (int i = 0; i <= 10; i++) {
        }
        // this should be a noop
                emptyMap(),
    protected volatile DiscoveryNode nodeB;
    public void testVersionFrom0to1() throws Exception {
            .put("network.tcp.keep_interval", "7")
                TransportRequestOptions.EMPTY,
                    for (int iter = 0; iter < 10; iter++) {
                "internal:action1",
/*
            new StringMessageRequest("moshe"),
        builder.addConnections(
            StringMessageRequest::new,
                nodeA,
                    }
                new TransportResponseHandler<StringMessageResponse>() {
                    }
        });
            } else {
import org.opensearch.common.util.io.IOUtils;
            "internal:sayHelloTimeoutDelayedResponse",
        if (randomBoolean()) {
        }
            TransportRequestOptions.Type.REG,
                }
                logger.error("Unexpected failure", exp);
                            "test",
            });
                    threadPool.getThreadContext().putHeader("test.pong.user", "pong_user");
                ThreadPool.Names.GENERIC,
        final RuntimeException failToSendException;
            .put("transport.tcp.keep_interval", "8")
            });
        @Nullable ClusterSettings clusterSettings,
            assertEquals(0, transportStats.getServerOpen());
            });
            );
        } else {
                }
            "internal:sayHello",
        assertEquals(
                }
                public StringMessageResponse read(StreamInput in) throws IOException {
                serviceA.sendRequest(
            AtomicInteger requestsSent = new AtomicInteger();
        @Override
            TestRequest::new,
                TransportRequestOptions options
            }
        return service;
            }
    }
                    }
            new StringMessageRequest("moshe"),
                        public TestResponse read(StreamInput in) throws IOException {
                }
        assumeTrue("only tcp transport has keep alive pings", serviceA.getOriginalTransport() instanceof TcpTransport);
    protected MockTransportService buildService(
            assertThat("hello moshe", equalTo(message.message));
                TransportRequest.Empty.INSTANCE,
                public void handleException(TransportException exp) {
            ThreadPool.Names.GENERIC,
        try {
                1,
            final String errorResponseSent = ".*\\[internal:testError].*sent error response.*";
        clusterSettingsA = new ClusterSettings(Settings.EMPTY, getSupportedSettings());
                            sender.sendRequest(connection, action, request, options, handler);
                } else {
                "internal:action",
            serviceC.acceptIncomingRequests();
                }
            .put("network.tcp.reuse_address", !enable)
                            @Override
                            }
                protected void doRun() throws Exception {
                public void handleException(TransportException exp) {
            "internal:sayHello",
            new TransportRequestHandler<StringMessageRequest>() {
                        public void handleException(TransportException exp) {
                int ipv4 = 0;
            out.writeInt(resendCount);
    }
            builder.addConnections(
                        new TransportResponseHandler<TestResponse>() {
            serviceA.getOriginalTransport().openConnection(node, connectionProfile, future);
                @Override
        try {
                emptyMap(),
            }
            if (failToSendException instanceof IllegalStateException) {
            .put("transport.profiles.default.publish_port", 42)
    public static class Version1Request extends Version0Request {
        latch.await();
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
                throw new AssertionError("boom");
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
                        final String info = sender + "_" + iter;
        );
        );
            .put("transport.tcp.keep_count", "13")
            TransportStats transportStats = serviceB.transport.getStats();
            TestRequest::new,
                }
                requestProcessed.set(true);
            serviceC.sendRequest(
        }
        @Nullable ClusterSettings clusterSettings,
                public void handleResponse(Version1Response response) {
                    public TransportResponse.Empty read(StreamInput in) {
        return buildService(name, version, null, settings);
            });
                    assertThat(((ConnectTransportException) cause).node(), equalTo(nodeA));
            try {
        }
            assertThat(((ConnectTransportException) cause).node(), equalTo(nodeA));
