                    return new StringMessageResponse(in);
                emptySet(),  
                public void handleResponse(StringMessageResponse response) {
        }  
                    go.await();
            );
                assertEquals(1, transportStats.getRxCount());
                                (Supplier<?>) () -> new ParameterizedMessage("caught exception while sending to node {}", nodeA),
                TransportRequestOptions.Type.PING,
            );  
            assertThat(tracerB.responseSent.get(), equalTo(1));
                if (fail.get()) {
    public void testTimeoutSendExceptionWithNeverSendingBackResponse() throws Exception {
        assertBusy(() -> assertFalse(serviceB.nodeConnected(nodeA)));
            .put("network.bind_host", "the_bind_host")
            new StringMessageRequest("moshe"),
            TransportRequestOptions.Type.BULK,  
        };
            .put("network.tcp.send_buffer_size", "43000b")
                return TransportResponse.Empty.INSTANCE;
        CountDownLatch doneWaitingForever = new CountDownLatch(1);
        );
            try (Transport.Connection connection = future.actionGet()) {
        serviceC.acceptIncomingRequests();
        assertThat(version1Response.value1, equalTo(1));
            1,
            service.acceptIncomingRequests();  
        serviceA.registerRequestHandler(  
    }  
        serviceC.acceptIncomingRequests();  
                    .put("transport.profiles.some_profile.port", "8900-9000")
    protected MockTransportService buildService(final String name, final Version version, Settings settings) {
            );
            try {  
        doneWaitingForever.await();
        } catch (Exception e) {
            @Override
                version0,
                    } catch (IOException e1) {
                    assertThat(response.value2, equalTo(2));  
            assertThat(e.getCause().getMessage(), equalTo("runtime_exception: bad message !!!"));
                        @Override
                }  
                public void handleException(TransportException exp) {
                } else {  
            Thread t = new Thread() {  
            service.start();
package org.opensearch.transport;
        Version0Response(int value1) {  
                    assertTrue(threadPool.getThreadContext().getResponseHeaders().containsKey("foo.bar"));  
                    @Override
import org.opensearch.threadpool.TestThreadPool;  
            final int sender = i;
                public StringMessageResponse read(StreamInput in) throws IOException {  
                    try {
            IOUtils.close(serviceA, serviceB, () -> terminate(threadPool));
                Level.TRACE,
        serviceA.registerRequestHandler(  
                        final Transport.Connection connection,  
                    channel.sendResponse(new TestResponse("Response for: " + request.info));
                }
        );  
                try {  
        try (MockTransportService service = buildService("TS_C", version0, Settings.EMPTY)) {  
        Settings transportSettings = Settings.builder()
            appender.addExpectation(responseSentExpectation);  
                    throw new AssertionError("boom");
        try {  
        serviceA.registerRequestHandler("internal:testError", ThreadPool.Names.SAME, StringMessageRequest::new, handlerWithError);
            "internal:sayHello",  
                            public void handleResponse(TestResponse response) {  
                notSeenReceived
            }
import org.opensearch.tasks.Task;
            1,
            } catch (Exception e) {  
        assertBusy(() -> {
        serviceA.sendRequest(
                }
            ThreadPool.Names.GENERIC,
                    }
        }  
            randomBoolean() ? ThreadPool.Names.SAME : ThreadPool.Names.GENERIC,
                assertBusy(() -> assertTrue(requestProcessed.get()));
            }
        StubbableTransport.WrappedConnection wrappedConnection = (StubbableTransport.WrappedConnection) connection;
            }
                1,  
        serviceA.registerRequestHandler(
            @Override
                        fail("got exception instead of a response for " + counter + ": " + exp.getDetailedMessage());  
    }
        serviceB.registerRequestHandler("internal:action1", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {  
                    // don't send back a response
        super.tearDown();
                TransportRequestOptions.Type.BULK,
                @Override  
                        fail(e.getMessage());  
        assumeTrue("only tcp transport has a handshake method", serviceA.getOriginalTransport() instanceof TcpTransport);
        assertEquals(enable, settings.tcpNoDelay);  
import org.opensearch.test.transport.MockTransportService;
            }  
        threadPool = new TestThreadPool(getClass().getName());
        final Logger logger = LogManager.getLogger("org.opensearch.transport.TransportService.tracer");  
            TransportRequestOptions.builder().withTimeout(100).build(),
            }  
            .put("transport.tcp.keep_alive", !enable)
import java.util.concurrent.ExecutionException;
import org.opensearch.common.SuppressForbidden;  
                @Override  
            assertBusy(() -> { // netty for instance invokes this concurrently so we better use assert busy here
        final String name,  
                }  
                    fail("got exception instead of a response: " + exp.getMessage());  
    public void testErrorMessage() {
            }  
                    @Override  
            public void handleResponse(TransportResponse response) {  
        assertThat("failed to wait for all nodes to connect", latch.await(5, TimeUnit.SECONDS), equalTo(true));
                @Override
            assertThat("hello moshe", equalTo(message.message));  
                                    e  
            public String executor() {
                        logger.info("Stop ServiceB now");
        Set<Exception> sendingErrors = ConcurrentCollections.newConcurrentSet();
        List<String> executors = new ArrayList<>(ThreadPool.THREAD_POOL_TYPES.keySet());
            final MockLogAppender.LoggingExpectation errorResponseReceivedExpectation = new MockLogAppender.PatternSeenEventExpectation(
            final String errorResponseSent = ".*\\[internal:testError].*sent error response.*";
                (request, message, task) -> {  
                            } catch (ConnectTransportException e) {
                    new TestRequest(),
                    responseErrors.add(e);  
                    } else {  
                public void handleException(TransportException exp) {
                    fail("got exception instead of a response: " + exp.getMessage());
            }
                    .putList("transport.profiles.some_other_profile.publish_host", "_local:ipv4_")  
            if (in.getVersion().onOrAfter(version1)) {  
            ThreadPool.Names.GENERIC,
            }
            assertThat(tracerA.responseReceived.get(), equalTo(2));
                        throw new AssertionError(e);  
        TcpTransport.NodeChannels channels = (TcpTransport.NodeChannels) wrappedConnection.getConnection();
                        ipv4++;  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    }
            TestRequest::new,  
        }
                    }  
            }
        } catch (ConnectTransportException e) {
                public void onFailure(Exception e) {
        final int value1;
            runnable.run();
        TransportResponseHandler<StringMessageResponse> responseHandler = new TransportResponseHandler<StringMessageResponse>() {  
        Settings globalSettings2 = Settings.builder()
            assertTrue(profileBoundAddresses.get("some_profile").boundAddresses().length >= 1);
        try {  
        serviceA.sendRequest(nodeB, "internal:action1", new TestRequest(), new TransportResponseHandler<TestResponse>() {
                new StringMessageRequest(counter + "ms"),  
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();  
        Version0Request version0Request = new Version0Request();
        };  
    }
        );
import org.opensearch.common.settings.Settings;
            StringMessageRequest request = new StringMessageRequest("", 10);  
                if (action.equals(ACTION)) {
                    if (addr.address().getAddress() instanceof Inet4Address) {
            nodeA,  
            // do nothing
        Semaphore inFlight = new Semaphore(Integer.MAX_VALUE);  
                    try {
            latch.await();
        };
        });
            new TransportRequestHandler<StringMessageRequest>() {
        } else {
                public void handleResponse(Version0Response response) {
        }
                return TransportResponse.Empty.INSTANCE;
            .build();
            t.start();  
            super(in);
                    Version0Response response = new Version0Response(1);
            serviceA.submitRequest(nodeB, ACTION, TransportRequest.Empty.INSTANCE, EmptyTransportResponseHandler.INSTANCE_SAME).get();  
        Exception ex = new RuntimeException("boom");
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
        );
                assertThat("moshe", equalTo(request.message));
        final AtomicReference<String> responseString = new AtomicReference<>();
                nodeA,
        );  
    public void testDisconnectListener() throws Exception {  
                (request, channel, task) -> {
                }
                        public void handleException(TransportException exp) {  
            public void onResponseSent(long requestId, String action, TransportResponse response) {
                "internal:sayHello",
            public void handleException(TransportException exp) {  
        for (int i = 0; i < halfSenders; i++) {
            }
            }
            (request, channel, task) -> {  
    public void assertNoPendingHandshakes(Transport transport) {
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
                    } else {  
                public void onAfter() {  
            assertThat(request.value2, equalTo(2));
            .put("transport.profiles.default.bind_host", "the_bind_host")  
                public void onFailure(Exception e) {
    }
        Version1Response version1Response = serviceB.submitRequest(
            assertions.add(() -> {
                new TransportResponseHandler<StringMessageResponse>() {
                TestRequest::new,
                            );  
                                "internal:test",
        latch.await();
            AtomicInteger responseReceived = new AtomicInteger();  
                    channel.sendResponse(response);
import org.opensearch.common.settings.ClusterSettings;
    }
                }
                TransportRequestOptions.Type.REG,
        DiscoveryNode nodeC = serviceC.getLocalNode();  
                                    logger.debug("send secondary exception response for request {}", request.info);
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
            // all is well
    public void testNotifyOnShutdown() throws Exception {
import static org.hamcrest.Matchers.equalTo;
            interceptor,
                                // ok!
                final ConnectionProfile profile = builder.build();  
            public void handleResponse(TestResponse response) {  
            assertThat(tracerA.requestsSent.get(), equalTo(1));
                    }
    protected Set<Setting<?>> getSupportedSettings() {
        Version0Request() {}
            .put(TransportSettings.CONNECTIONS_PER_NODE_PING.getKey(), 1);
            } catch (IOException e) {  
            assertTrue(profileBoundAddresses.containsKey("some_other_profile"));  
            TestRequest::new,  
                int ipv4 = 0;
        ).txGet();
            TransportStats transportStats = serviceA.transport.getStats();
                @Override  
            }
        final CountDownLatch responseLatch = new CountDownLatch(1);  
            ThreadPool.Names.GENERIC,
                ThreadPool.Names.GENERIC,
            nodeA,
    public static class TestRequest extends TransportRequest {
            );
        serviceB.removeConnectionListener(waitForConnection);  
            threadPool.generic().execute(new AbstractRunnable() {
                    try {
        } catch (ExecutionException e) {
            } else {
        }
        public String toString() {
                serviceB.close();  
                builder.setConnectTimeout(TimeValue.timeValueMillis(1));
                    "internal:action",
            public String executor() {  
import java.util.stream.Collectors;
        }
            @Override  
                    assertThat(((ConnectTransportException) cause).node(), equalTo(nodeA));
            responseLatch.await();  
        CountDownLatch receivedLatch = new CountDownLatch(1);
        boolean doIPV6 = NetworkUtils.SUPPORTS_V6;
        }
            "internal:sayHello",
            serviceC.start();
                }
 *
                    return ThreadPool.Names.GENERIC;
            assertThat(e, instanceOf(ReceiveTimeoutTransportException.class));  
        try (TransportService service = buildService("TS_TPC", Version.CURRENT, Settings.EMPTY)) {
    }
        Version1Response version1Response = serviceB.submitRequest(
                TransportStats transportStats = serviceC.transport.getStats(); // request has been sent
                assertNull(threadPool.getThreadContext().getHeader("test.pong.user"));  
                receivedException.set(exp);
            assertEquals(54, stats.getRxSize().getBytes());
                requestSent
            });  
                @Override  
        serviceA.registerRequestHandler(  
            TransportRequestOptions.Type.RECOVERY,
    }  
        );
            hosts = Arrays.asList("_local:ipv4_");  
        MockTransportService serviceC = buildService("TS_C", version0, Settings.EMPTY);
                }
            .put("transport.tcp.keep_idle", "43")
            failToSendException = new IllegalStateException("fail to send");
                    timeTaken < TimeValue.timeValueSeconds(5).millis()
import static org.hamcrest.Matchers.instanceOf;
        boolean acceptRequests,
                @Override  
                Throwable unwrap = ExceptionsHelper.unwrap(exp, IOException.class);
                }
                throw new RuntimeException("boom");  
            .put("network.tcp.keep_idle", "42")  
                    return ThreadPool.Names.GENERIC;
        if (randomBoolean()) {  
                public void onConnectionClosed(Transport.Connection connection) {
            assertThat(tracerA.requestsSent.get(), equalTo(1));  
                    exception.set(e);
        assumeTrue("Works only on BSD network stacks", Constants.MAC_OS_X || Constants.FREE_BSD);
            receivedLatch.await();
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
    }
                        assertTrue(exp.getCause().getClass().toString(), exp.getCause() instanceof NodeNotConnectedException);
            (request, channel, task) -> {
            // handshake message and the header, version, etc bytes in the exception message.
 * ownership. Elasticsearch licenses this file to you under  
            @Override  
                    channel.sendResponse(new TestResponse((String) null));  
    }
                    assertThat(response.value1, equalTo(1));
            .put("transport.tcp.keep_idle", "42")
                    public void onFailure(final Exception e) {
            // the bound address  
import static org.hamcrest.Matchers.nullValue;
                logger.debug((Supplier<?>) () -> new ParameterizedMessage("---> received exception for id {}", id), exp);
        serviceA.addMessageListener(tracerA);
    public void testSendRandomRequests() throws InterruptedException {
        }  
                @Override  
                        return ThreadPool.Names.SAME;
        serviceA.disconnectFromNode(nodeA);  
            );  
                TransportRequestOptions.EMPTY,
            );  
        }
    protected int channelsPerNodeConnection() {  
                            new TestRequest(info),
            .put(Node.NODE_NAME_SETTING.getKey(), name)  
 * this work for additional information regarding copyright
        serviceB.registerRequestHandler(  
import java.util.concurrent.CountDownLatch;
            }
            assertThat(ExceptionsHelper.unwrapCause(e.getCause()).getMessage(), equalTo("simulated"));
        }  
import org.apache.logging.log4j.Level;
            public String executor() {
    }
                if (randomBoolean()) {
                newService.registerRequestHandler("internal:test", ThreadPool.Names.SAME, TestRequest::new, ignoringRequestHandler);
        List<Runnable> assertions = new ArrayList<>();
            }
                "internal:sayHello",
            public void handleException(TransportException exp) {}
    }  
            hosts = Arrays.asList("_local:ipv6_", "_local:ipv4_");
        threadPool.getThreadContext().putTransient("my_private_context", context);
            );  
                final long now = System.nanoTime();
                ThreadPool.Names.GENERIC,
        }
        // use assert busy as callbacks are called on a different thread  
            if (out.getVersion().onOrAfter(version1)) {
                new TestRequest("boom"),  
                    .put("transport.profiles.some_other_profile.port", "8700-8800")
        );
        expectThrows(ConnectTransportException.class, () -> serviceB.openConnection(nodeA, TestProfiles.LIGHT_PROFILE));
            channel.sendResponse(response);
    protected InetSocketAddress getLocalEphemeral() throws UnknownHostException {
            serviceA = buildService("TS_A", version0, null, Settings.EMPTY, true, false);
        if (transport instanceof TcpTransport) {  
            .put("transport.tcp.reuse_address", !enable)
            logger.debug("send from {} to {}", toNodeMap.get(service), node);
            });
                public void messageReceived(Version0Request request, TransportChannel channel, Task task) throws Exception {
                        te.set(exp);
        public String toString() {
                                logger.error(
                    assertEquals("baz", threadPool.getThreadContext().getResponseHeaders().get("foo.bar").get(0));
                return ThreadPool.Names.SAME;
            new TransportRequestHandler<Version0Request>() {  
                    } catch (IOException e) {
    }  
                    public String executor() {  
                public void handleException(TransportException exp) {
import java.util.concurrent.atomic.AtomicBoolean;
        }
            return "TestResponse{" + "info='" + info + '\'' + '}';  
                }  
                @Override
            try (Transport.Connection connection = future.actionGet()) {
 * this file be licensed under the Apache-2.0 license or a
                "internal:foobar",
                    new TransportResponseHandler<TestResponse>() {
        serviceA.registerRequestHandler("internal:version", ThreadPool.Names.SAME, Version0Request::new, (request, channel, task) -> {  
        return new InetSocketAddress(InetAddress.getLocalHost(), 0);
    }  
                }
            .put("transport.profiles.default.publish_host", "the_publish_host")
            assertThat(tracerB.requestsReceived.get(), equalTo(1));  
        List<String> hosts;
                assertEquals(IOException.class, unwrap.getClass());  
        }
import java.net.Inet4Address;
        }
                    }
                @Override
                }  
                }
import org.opensearch.common.Nullable;
        serviceA.removeConnectionListener(waitForConnection);
                fail("disconnect should not be called " + node);
        @Override
            );
        } else {
        version1Request.value2 = 2;
        public void writeTo(StreamOutput out) throws IOException {
            );
                    fail("got response instead of exception");  
            "internal:version",
            serviceA.registerRequestHandler(
            StringMessageRequest::new,
            new TransportResponseHandler<Version1Response>() {  
                throw new RuntimeException("bad message !!!");
            .put("transport.tcp.keep_alive", enable)
        }  
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
        serviceA.registerRequestHandler(
        final Settings connectionSettings = connectionSettingsBuilder.build();  
            // don't block on a network thread here
                responseLatch.countDown();
        @Override  
 * under the License.  
            ThreadPool.Names.GENERIC,
            }  
                    @Override
                        node,
            TransportRequestOptions.Type.STATE
                    public void onResponse(final Void v) {  
        assertThat("pong", equalTo(message.message));  
            DiscoveryNode second = new DiscoveryNode(  
 * GitHub history for details.
        Set<TcpTransport.ProfileSettings> profileSettings = TcpTransport.getProfileSettings(Settings.EMPTY);
                @Override
            AtomicInteger requestsSent = new AtomicInteger();
        logger.debug("waiting for response");
        };
                }
                .put(TransportSettings.TRACE_LOG_EXCLUDE_SETTING.getKey(), excludeSettings)
                version0
            @Override  
                assertEquals(1, transportStats.getTxCount());
        }
                                listener.actionGet();  
            serviceC.close();
                TransportRequest.Empty.INSTANCE,
        }
                                return new TestResponse(in);
                        }
                }
                            latch2.countDown();  
        serviceC.acceptIncomingRequests();  
            builder.addConnections(  
                        @Override
    public void testThreadContext() throws ExecutionException, InterruptedException {  
import java.net.Inet6Address;
            public void handleResponse(TransportResponse response) {
                }
        return transport.getAcceptedChannels();  
        Settings profileSettings = Settings.builder()
        Version0Response version0Response = serviceA.submitRequest(  
            new TestRequestHandler(serviceC)
            assertBusy(() -> { // netty for instance invokes this concurrently so we better use assert busy here
                @Override
            }
            version0Request,  
        String address = serviceA.boundAddress().publishAddress().getAddress();  
                    assertThat(request.value1, equalTo(1));  
                TransportRequestOptions.Type.PING,
                new TransportResponseHandler<StringMessageResponse>() {
                        return ThreadPool.Names.GENERIC;
                responseLatch.countDown();
    }
                @Override  
        ).txGet();
            Version1Response response = new Version1Response(1, 2);  
        try {
    public void testConcurrentSendRespondAndDisconnect() throws BrokenBarrierException, InterruptedException {  
        }
        builder.addConnections(
            public void handleResponse(TestResponse response) {
    public void tearDown() throws Exception {
            assertEquals(channelsPerNodeConnection(), transportStats.getServerOpen());  
            }
                @Override
        try (MockTransportService serviceC = buildService("TS_C", CURRENT_VERSION, Settings.EMPTY)) {
                        final String action,
            .put("network.tcp.keep_interval", "7")
                ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY),  
        toNodeMap.put(serviceC, nodeC);
        go.await();
                }
            });  
                }  
            public void handleException(TransportException exp) {
        serviceA.removeConnectionListener(waitForConnection);
                    logger.error("Unexpected failure", exp);
                    onFailure(ex);
                IOUtils.close(service.openConnection(first, builder.build()));
                    return new Version1Response(in);  
                emptyMap(),
                public StringMessageResponse read(StreamInput in) throws IOException {
        Settings defaultProfileSettings = Settings.builder()
        final CountDownLatch latch = new CountDownLatch(2);  
                @Override  
                        final TransportRequestOptions options,  
                "org.opensearch.transport.TransportService.tracer",
            }  
                    try {
                        channel.sendResponse(new StringMessageResponse("hello " + request.message));  
            final Transport.Connection connection = serviceC.getConnection(nodeA);  
                }  
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
            );  
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(  
                }
                }
        final CountDownLatch latch = new CountDownLatch(4);  
            serviceC.start();
                TransportRequestOptions.EMPTY,
import org.opensearch.action.support.PlainActionFuture;  
            try {
        public void writeTo(StreamOutput out) throws IOException {  
                    sendResponseLatch.await();  
        try {  
        serviceA.registerRequestHandler(  
                TransportResponse.Empty message = res.get();
        CollectionUtil.timSort(executors); // makes sure it's reproducible
    public void testMessageListeners() throws Exception {
                return executor;
    }
                emptyMap(),  
            assertThat(request.value1, equalTo(1));
            DiscoveryNode node = new DiscoveryNode("TS_TPC", "TS_TPC", address, emptyMap(), emptySet(), version0);
            assertThat(ex.getCause().getMessage(), startsWith("handshake failed"));
            new StringMessageRequest("moshe"),
                }
            new HashSet<>(Arrays.asList("default", "test")),
                this.id = id;
        };
import org.opensearch.test.MockLogAppender;  
            };
            serviceB.sendRequest(  
                    TransportRequestOptions.EMPTY,
        }
import static org.hamcrest.Matchers.notNullValue;  
                    return new StringMessageResponse(in);
            }
        if (randomSettings == globalSettings) { // publish host has no global fallback for the profile since we later resolve it based on
        } finally {
                new TestResponseHandler(i)
            TransportRequestOptions.Type.PING,
            fail.set(true);  
            "internal:sayHelloTimeoutDelayedResponse",
                TransportRequestOptions.EMPTY,
            builder.addConnections(
                                    channel.sendResponse(response);
        Settings transportSettings2 = Settings.builder()
                    threadPool.getThreadContext().putHeader("test.pong.user", "pong_user");
                MockTransportService newService = buildService("TS_B_" + i, version1, Settings.EMPTY);
                }
            assertEquals(expected, ((TcpTransport) transport).getNumHandshakes());
            ThreadPool.Names.SAME,
 * KIND, either express or implied.  See the License for the
            StringMessageRequest::new,
        assertEquals(0, stats.getTxSize().getBytes());  
            new TestRequestHandler(serviceA)
            failToSendException = new TransportException("fail to send");
            fail("exception should be thrown");  
            }  
import static org.hamcrest.Matchers.hasToString;  
        Version version = VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT);  
import org.junit.After;
                connection,
                    .build()
                Level.TRACE,  
            @Override
            "internal:sayHello",  
        boolean doHandshake,  
                public void handleException(TransportException exp) {
        assertEquals(13, settings.tcpKeepCount);
    @Before
                assertThat("moshe", equalTo(request.message));
            }
            .put(TransportSettings.HOST.getKey(), address)  
            builder.addConnections(
            public StringMessageResponse read(StreamInput in) throws IOException {
                logger.trace("caught exception while responding from node B", e);  
        TransportService serviceC = buildService("TS_C", version0, Settings.EMPTY);
                int ipv6 = 0;  
        });
        }
                @Override
                TransportRequestOptions.Type.STATE
        } catch (Exception e) {  
            nodeB,  
                                new TestRequest(info),
            new TransportResponseHandler<StringMessageResponse>() {  
        nodeB = serviceB.getLocalNode();
        try {
            );  
                latch.await();
    }
                        public TestResponse read(StreamInput in) throws IOException {
                assertEquals("forced failure", unwrap.getMessage());
            }  
                TransportRequestOptions.Type.STATE
        serviceC.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {  
/*  
        serviceA.registerRequestHandler(  
        assertEquals(
            }
            responseLatch.await();
        }
            serviceA.submitRequest(nodeA, ACTION, TransportRequest.Empty.INSTANCE, EmptyTransportResponseHandler.INSTANCE_SAME).get();  
            threadPool.generic().execute(new AbstractRunnable() {
        ).txGet();
import java.io.UncheckedIOException;  
                    for (int iter = 0; iter < 10; iter++) {  
        assertEquals(43000, settings.sendBufferSize.getBytes());  
import java.util.HashMap;
            final MockLogAppender.LoggingExpectation responseSentExpectation = new MockLogAppender.PatternSeenEventExpectation(
                try {  
            TransportRequestOptions.Type.REG,  
            public void handleResponse(TransportResponse response) {  
                "internal:action",
            nodeA,  
                    @Override  
                new StringMessageRequest(""),
            }  
                            doneWaitingForever.countDown();
            serviceC.start();
                serviceA.connectToNode(nodeB);
                "internal:action",
        final CountingListener tracerB = new CountingListener();
                try {
    private MockTransportService buildService(
                }  
        }
            StringMessageRequest::new,
                @Override  
            TransportRequestOptions.Type.STATE  
            serviceC.sendRequest(
        );
                    "internal:action",  
        );
        boolean doHandshake
        Version0Response(StreamInput in) throws IOException {
        serviceC.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
            this.info = in.readOptionalString();
                public void handleResponse(StringMessageResponse response) {
import static org.hamcrest.Matchers.startsWith;
            }
                responseReceived
        final CountDownLatch latch = new CountDownLatch(1);
            }
    }  
                service.boundAddress().publishAddress(),
                new TestRequest("hello world"),  
                assertEquals(connection.getVersion(), connection.getVersion());
    }
        private final String message;  
            assertBusy(() -> { // netty for instance invokes this concurrently so we better use assert busy here
                    }
        serviceB.registerRequestHandler("internal:testError", ThreadPool.Names.SAME, StringMessageRequest::new, handlerWithError);
                @Override
                } finally {
                        return TransportResponse.Empty.INSTANCE;
    }
            );
            TransportStats transportStats = serviceB.transport.getStats();  
            DiscoveryNode node = randomFrom(nodeC, nodeB, nodeA);  
        assertEquals(TransportSettings.DEFAULT_PROFILE, profileSettings.stream().findAny().get().profileName);  
            new TransportResponseHandler<StringMessageResponse>() {
            TransportRequestOptions.Type.REG,  
            serviceB.connectToNode(nodeA);  
                TransportRequestOptions.builder().withTimeout(3000).build(),
                this.service = service;  
        latch.await();  
                @Override
        expectThrows(  
            );  
                ConnectTransportException ex = expectThrows(ConnectTransportException.class, () -> service.openConnection(second, profile));  
                try {  
                () -> service.openConnection(nodeA, builder.build())  
        private long timeout;
                "org.opensearch.transport.TransportService.tracer",  
                    assertThat("moshe", equalTo(request.message));
                    }
                TransportRequestOptions.Type.STATE
        }  
                    return new Version1Response(in);  
            assertBusy(appender::assertAllExpectationsMatched);
                transportResponseHandler
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
            stats = serviceC.transport.getStats(); // exception response has been received
        CountDownLatch responseLatch = new CountDownLatch(1);
                    }
        TransportRequestHandler<TransportRequest> handler = (request, channel, task) -> channel.sendResponse(new StringMessageResponse(""));
        fail.set(randomBoolean());
    public void testHandlerIsInvokedOnConnectionClose() throws IOException, InterruptedException {  
                    return ThreadPool.Names.GENERIC;
            public void handleResponse(StringMessageResponse response) {  
                    go.await();
            AtomicBoolean requestProcessed = new AtomicBoolean(false);
        profileSettings = TcpTransport.getProfileSettings(  
            TransportRequestOptions.Type.RECOVERY,
 * You may obtain a copy of the License at  
import org.opensearch.common.network.CloseableChannel;
                    public void handleResponse(final TransportResponse response) {
            assertThat(tracerA.responseReceived.get(), equalTo(1));
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
        try {
                new TestRequest("hello world"),  
                    return new StringMessageResponse(in);
        }
            t.join();  
                ConnectTransportException.class,
                "org.opensearch.transport.TransportService.tracer",
        }
                protected void doRun() throws Exception {  
                TransportRequestOptions.Type.BULK,  
            version,  
                emptySet(),
            assertThat(te.get(), not(nullValue()));
            .put("transport.profiles.default.tcp.keep_alive", enable)  
        ).txGet();
        // wait for the transport to process the sending failure and disconnect from node
                connection,
            }
            threadPool.executor(ThreadPool.Names.GENERIC).execute(new AbstractRunnable() {
            DiscoveryNode dummy = new DiscoveryNode(
            @Override
            threadPool.executor(ThreadPool.Names.GENERIC).execute(new AbstractRunnable() {
            public void onRequestSent(
                        latch2.await();  
        String info;  
        CountDownLatch receivedLatch = new CountDownLatch(1);
            .put("transport.tcp.keep_count", "13")
    public void testTimeoutSendExceptionWithDelayedResponse() throws Exception {  
                try {
import java.net.InetSocketAddress;
                    fail("got exception instead of a response: " + exp.getMessage());  
        }
            assertTrue(profileBoundAddresses.get("some_profile").publishAddress().getPort() >= 8900);
        final CountDownLatch latch = new CountDownLatch(2);
        );
                            logger.trace(  
            socket.bind(getLocalEphemeral(), 1);  
            @Override
            serviceC.close();
                assertEquals("ping_user", threadPool.getThreadContext().getHeader("test.ping.user"));
                "internal:sayHello",  
                        }
                }  
            "internal:version",  
            assertEquals(2, stats.getTxCount());
            .put(TransportSettings.CONNECTIONS_PER_NODE_STATE.getKey(), 1)
                public void messageReceived(StringMessageRequest request, TransportChannel channel, Task task) throws InterruptedException {
    public void testHelloWorld() {
                public Version0Response read(StreamInput in) throws IOException {  
        }  
                    );
    }  
        );
            new TransportRequestHandler<Version1Request>() {
    protected MockTransportService buildService(
 *  
        // this should be a noop
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);  
            TransportFuture<StringMessageResponse> result = serviceB.submitRequest(  
                    public void handleResponse(StringMessageResponse response) {
                        public String executor() {
        CountDownLatch sendResponseLatch = new CountDownLatch(1);  
        }
                public String executor() {
        ) {  
        );
        assertThat(version1Response.value2, equalTo(2));
            originalTransport.openConnection(node, connectionProfile, future);  
        final TransportRequestHandler<TransportRequest.Empty> requestHandler = (request, channel, task) -> {
        TransportConnectionListener waitForConnection = new TransportConnectionListener() {
        try (
                // simulate restart of nodeB
            if (in.getVersion().onOrAfter(version1)) {
                @Override  
                        assertThat("hello moshe", equalTo(response.message));  
            assertThat(((ConnectTransportException) cause).node(), equalTo(nodeA));
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
            socket.setReuseAddress(true);
                assertEquals(0, originalTransport.getKeepAlive().failedPingCount());  
                    latch.countDown();  
        Settings settings  
        final TransportInterceptor interceptor = new TransportInterceptor() {  
            super.writeTo(out);
                }  
            @Override
                    logger.error("Unexpected failure", exp);
            } else {  
        assertEquals(0, stats.getTxCount());
                @Override
            if (failToSendException instanceof IllegalStateException) {  
                TransportRequestOptions.Type.BULK,
            addressA.set(request.remoteAddress());
            (request, channel, task) -> {
            builder.addConnections(
        try (TransportService service = buildService("TS_TEST", version0, null, Settings.EMPTY, false, false)) {
            ThreadPool.Names.SAME,
                }
    protected volatile DiscoveryNode nodeA;
        }  
        } catch (Exception e) {
                new TestRequest("REQ[" + i + "]"),
        } catch (Exception e) {
        int port = serviceA.boundAddress().publishAddress().getPort();
            value1 = in.readInt();  
        try {
                TransportRequestOptions.Type.REG,
            @Override  
        }  
                "internal:action",
                value2 = in.readInt();
                    }
                            @Override
            );
                @Override
            assertEquals(0, transportStats.getServerOpen());
            nodeA,
        assertEquals(enable, settings.tcpKeepAlive);
                public String executor() {  
        assertEquals(Collections.singletonList("the_bind_host"), settings.bindHosts);  
            .put("transport.profiles.some_profile.publish_port", 42)
    }
                version0
                @Override  
            ConnectTransportException ex = expectThrows(  
            final String errorResponseReceived = ".*\\[internal:testError].*received response from.*\\{TS_B}.*";
                    receivedLatch.countDown();
    public void testHandshakeUpdatesVersion() throws IOException {
            }
            new TransportResponseHandler<StringMessageResponse>() {
        assertThat(responseString.get(), equalTo("test"));
                    new TestRequest(),  
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();  
                }
        CountDownLatch latch = new CountDownLatch(1);  
 */  
            "internal:sayHelloTimeoutNoResponse",
        public TestRequest() {}  
        CloseableChannel.closeChannels(channels.getChannels().subList(0, randomIntBetween(1, channels.getChannels().size())), true);  
        try {
                }  
                }  
                Level.TRACE,  
        serviceB.close();
        }
    public void testTcpHandshakeConnectionReset() throws IOException, InterruptedException {
                            accept.getInputStream().read();
                                sendingErrors.add(e);
    ) {
                } else {
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(  
    public void testVoidMessageCompressed() {
        Settings updatedSettings = Settings.builder()  
                addressB.set(response.remoteAddress());
                        "internal:action1",
            .put("transport.profiles.default.port", "9700-9800")
                        @Override
                }  
            }
        final String name,
                    @Override
            @Override  
                        fail("got exception instead of a response: " + exp.getMessage());  
                    }
            .put(TransportSettings.PORT.getKey(), getPortRange())
            super.writeTo(out);
        StringMessageResponse(String message) {
        boolean acceptRequests,
                TransportRequestOptions.Type.RECOVERY,
                    assertTrue(threadPool.getThreadContext().getResponseHeaders().containsKey("foo.bar"));
    public void testFailToSend() throws InterruptedException {
                    @Override
                errorResponseReceived  
                }
 * specific language governing permissions and limitations
                            public String executor() {  
                        if ("forever".equals(message)) {
                                    throw new RuntimeException(e);
                }  
            @Override  
                        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();  
        try (MockTransportService serviceC = buildService("TS_C", CURRENT_VERSION, null, Settings.EMPTY, true, true, interceptor)) {  
        int halfSenders = scaledRandomIntBetween(3, 10);
            .put("network.tcp.no_delay", !enable)
            .build();
                }
            TransportService service = randomFrom(serviceC, serviceB, serviceA);
                        final TransportRequest request,
        Version1Request() {}
                            public TestResponse read(StreamInput in) throws IOException {
    }
            .put("transport.profiles.default.tcp.keep_idle", "42")
                        @Override
                            new ActionListenerResponseHandler<>(listener, TestResponse::new)  
                (request, channel, task) -> {
            );  
                fail("disconnect should not be called " + node);  
                }
        version1Request.value2 = 2;
            (request, channel, task) -> {  
            "some_profile"  
                }  
                TransportRequestOptions.EMPTY,
                public void handleResponse(StringMessageResponse response) {
        });
                            latch.countDown();
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
        CountDownLatch sendResponseLatch = new CountDownLatch(1);
            assertThat(tracerB.requestsSent.get(), equalTo(1));
            threadPool.generic().execute(new AbstractRunnable() {
        Version0Request version0Request = new Version0Request();
            "internal:version",
            nodeA,
                @Override  
import org.junit.Before;  
            }
                TransportRequestOptions.EMPTY,
                }
                return ThreadPool.Names.SAME;
                "received request",
                    return new Version0Response(in);
            final CountDownLatch latch = new CountDownLatch(1);  
                        }  
            ConnectionProfile connectionProfile = ConnectionProfile.buildDefaultConnectionProfile(settingsWithCompress);  
        if (await == false) {
            res.txGet();
                logger.error("Unexpected failure", e);
                }
            public void handleException(TransportException exp) {  
                    receivedLatch.countDown();
            res.txGet();  
        assertEquals(0, stats.getTxCount());
                "TEST",
        class TestResponseHandler implements TransportResponseHandler<TestResponse> {
                requestProcessed.set(true);
    }
            receivedLatch.await();  
                @Override
        builder.addConnections(  
        service.start();
        // use assert busy as callbacks are called on a different thread
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(  
                    exception.set(exp);
        done.await();
                    Thread.sleep(randomIntBetween(10, 50));  
                public void onAfter() {  
    public void testBlockingIncomingRequests() throws Exception {  
        }  
        assertEquals("9700-9800", settings.portOrRange);
                return new StringMessageResponse(in);  
                    } finally {
import static java.util.Collections.emptySet;
                TransportRequestOptions options
            public AsyncSender interceptSender(final AsyncSender sender) {
                        logger.error("Unexpected failure", exp);
                            @Override
        assertEquals(7, settings.tcpKeepInterval);  
                        }  
                                    channel.sendResponse(exp);
                    logger.debug("send response for {}", request.info);  
                assertEquals(29, transportStats.getRxSize().getBytes());
        CountDownLatch receivedLatch = new CountDownLatch(1);
            assertThat(e, hasToString(containsString(("a channel closed while connecting"))));
            );  
            try (TransportService service = buildService("TS_TPC", Version.CURRENT, null, Settings.EMPTY, true, false)) {  
                ConnectTransportException.class,
        };  
            if ("fail".equals(request.info)) {
            ThreadPool.Names.GENERIC,
                    fail("got exception instead of a response: " + exp.getMessage());  
    }
            // all is well  
            .put("transport.profiles.some_profile.port", "9700-9800")
                public StringMessageResponse read(StreamInput in) throws IOException {
                                    throw new RuntimeException(e);  
import java.net.UnknownHostException;
                );  
                        ipv6++;
                public void messageReceived(Version1Request request, TransportChannel channel, Task task) throws Exception {  
            .put("transport.tcp.keep_interval", "8")  
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);
            // into a connection timeout quickly. Yet other implementations can for instance can terminate the connection within the 3 way
    public void testAcceptedChannelCount() throws Exception {  
                @Override  
            fail("exception should be thrown");
            assertThat(tracerA.requestsReceived.get(), equalTo(1));  
                    }
                    public void handleResponse(StringMessageResponse response) {
    public void testResponseHeadersArePreserved() throws InterruptedException {
                "TS_C",
            public String executor() {
                }
    public void testTransportProfilesWithPortAndHost() {  
        );
                TransportRequestOptions.Type.RECOVERY,  
            super(in);  
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
                    } catch (IOException e) {
        }
        version0Request.value1 = 1;
            }
    }  
        }
            service.start();
                "TS_TPC",
            StringMessageRequest::new,
                    logger.error("Unexpected failure", e);
            out.writeInt(resendCount);
                public void handleException(TransportException exp) {  
        }
                    public void handleException(TransportException exp) {
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();
                }
                return TransportResponse.Empty.INSTANCE;  
            }
            // 57 bytes are the non-exception message bytes that have been received. It should include the initial  
import java.net.ServerSocket;
            1,
                        }
                    channel.sendResponse(new OpenSearchException("simulated"));
                public void onFailure(Exception e) {
                .put(TransportSettings.TRACE_LOG_INCLUDE_SETTING.getKey(), includeSettings)
            );  
                public StringMessageResponse read(StreamInput in) throws IOException {
                @Override  
    public void testTransportStatsWithException() throws Exception {  
                "org.opensearch.transport.TransportService.tracer",  
            "internal:localNode",  
    static class StringMessageResponse extends TransportResponse {
            );  
            public void onResponseReceived(long requestId, Transport.ResponseContext context) {
                TransportStats transportStats = serviceC.transport.getStats(); // request has ben send  
                serviceA.sendRequest(  
        serviceA.close();
        }
                    "test didn't timeout quick enough, time taken: [" + timeTaken + "]",
        public void writeTo(StreamOutput out) throws IOException {  
            }
        Version1Request version1Request = new Version1Request();
                @Override  
            responseLatch.await();
        }
                    Throwable cause = ExceptionsHelper.unwrapCause(exp);  
            .put("transport.tcp.keep_interval", "7")  
                    assertThat(cause, instanceOf(ConnectTransportException.class));
                protected void doRun() throws Exception {
            final AtomicReference<TransportException> te = new AtomicReference<>();
                StringMessageResponse message = result.txGet();  
                public StringMessageResponse read(StreamInput in) throws IOException {
    @Override  
            @Override  
                        }
import java.util.Map;
                        logger.error("Unexpected failure", exp);  
                public String executor() {  
                notSeenResponseSent
        boolean enable = randomBoolean();
                public String executor() {  
                    public TransportResponse.Empty read(StreamInput in) {
            super(in);
import org.opensearch.node.Node;  
                        latch.countDown();
        TestResponse(StreamInput in) throws IOException {
            serviceC.connectToNode(serviceA.getLocalDiscoNode(), connectionProfile);
        }
                    logger.error("Unexpected failure", exp);
        final AtomicReference<Exception> exception = new AtomicReference<>();
            new TransportResponseHandler<Version0Response>() {
            }
        TcpTransport originalTransport = (TcpTransport) serviceA.getOriginalTransport();  
            serviceC.acceptIncomingRequests();
        }
                    }
            DiscoveryNode dummy = new DiscoveryNode(
                new StringMessageRequest("moshe"),  
            assertTrue(profileBoundAddresses.get("some_profile").publishAddress().getPort() < 9000);
    public void assertNumHandshakes(long expected, Transport transport) {
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(nodeA, "internal:ping_pong", ping, responseHandler);  
            ConnectionProfile.Builder builder = new ConnectionProfile.Builder();  
                service.boundAddress().publishAddress(),  
            new TransportResponseHandler<Version1Response>() {  
    }
                                return randomBoolean() ? ThreadPool.Names.SAME : ThreadPool.Names.GENERIC;
            @Override  
            .put("network.tcp.no_delay", enable)
            new HashSet<>(Arrays.asList("default", "test")),
        CountDownLatch responseLatch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;  
        );
    }
            if (i % 3 == 0) {
                }
                emptySet(),  
            if (doIPV6) {  
            out.writeString(message);
            "internal:localNode",  
        });
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
                @Override
            }
            out.writeInt(value1);
import org.apache.lucene.util.Constants;
import org.apache.logging.log4j.LogManager;
        toNodeMap.put(serviceB, nodeB);
                "received error response",  
        @Nullable ClusterSettings clusterSettings,  
            });
            @Override  
                assertEquals(1, transportStats.getRxCount());  
                        return new StringMessageResponse(in);
                    responseLatch.countDown();
                        }  
                            Thread.sleep(sleep.millis());  
        assertTrue(nodeA.getAddress().getAddress().equals(addressA.get().getAddress()));
import static org.hamcrest.Matchers.containsString;  
        serviceA.addConnectionListener(waitForConnection);  
        Map<TransportService, DiscoveryNode> toNodeMap = new HashMap<>();
            version1Request,
                                new ActionListenerResponseHandler<>(listener, TestResponse::new)  
            assertThat(tracerA.responseSent.get(), equalTo(2));
        serviceC.acceptIncomingRequests();  
            assertThat(tracerB.requestsReceived.get(), equalTo(1));
            final String notSeenResponseSent = ".*\\[internal:testNotSeen].*sent response.*";  
        assertEquals("Failed to bind to " + NetworkAddress.format(inetSocketAddress), bindTransportException.getMessage());
                "sent request",
    }
        return buildService(name, version, clusterSettings, settings, acceptRequests, doHandshake, NOOP_TRANSPORT_INTERCEPTOR);
                }  
        for (Runnable runnable : assertions) {
            .put("transport.profiles.default.tcp.send_buffer_size", "43000b")
            latch3.await();  
            .put("transport.tcp.no_delay", enable)  
                assertNull(threadPool.getThreadContext().getTransient("my_private_context"));
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);  
            "internal:sayHelloTimeoutNoResponse",  
            assertNoPendingHandshakes(serviceB.getOriginalTransport());
            connectionSettingsBuilder.put(TransportSettings.TCP_KEEP_COUNT.getKey(), randomIntBetween(1, 10));  
            final String requestSent = ".*\\[internal:test].*sent to.*\\{TS_B}.*";
                throw new AssertionError("boom");
                            public void handleException(TransportException exp) {
                        try {
        int numHandshakes = 1;
            stats = serviceC.transport.getStats(); // response has been received
        profileSettings = TcpTransport.getProfileSettings(Settings.builder().put("transport.profiles.test.port", "0").build());
    }  
            "internal:sayHelloException",
        version1Request.value1 = 1;  
                    return new StringMessageResponse(in);  
                            );
                }
                @Override
                            }  
            appender.addExpectation(notSeenReceivedExpectation);  
            // now, try and send another request, this times, with a short timeout
                    logger.error("Unexpected failure", exp);
        assumeTrue("only tcp transport has keep alive pings", serviceA.getOriginalTransport() instanceof TcpTransport);
            try (Transport.Connection connection = serviceA.openConnection(node, null)) {
        }  
            @Override
                CountDownLatch latch2 = new CountDownLatch(1);
                @Override  
            assertThat(tracerB.requestsReceived.get(), equalTo(1));  
                assertEquals(1, transportStats.getRxCount());  
 * Licensed to Elasticsearch under one or more contributor  
                return TransportResponse.Empty.INSTANCE;
            sendResponseLatch.countDown();  
                @Override
        }  
            });
            .build();
            public String executor() {
        }
        TransportStats stats = serviceC.transport.getStats(); // nothing transmitted / read yet  
import org.opensearch.common.util.io.IOUtils;
            expectThrows(ConnectTransportException.class, () -> serviceA.openConnection(node, builder.build()));  
                "org.opensearch.transport.TransportService.tracer",
                    fail("got response instead of exception");
                "TS_TPC",
            Throwable cause = ExceptionsHelper.unwrapCause(e);
                public String executor() {
        );
            );  
            } else {
                        channel.sendResponse(e);  
                    sendResponseLatch.await();  
            clusterSettings,
            @Override
                            TimeValue sleep = TimeValue.parseTimeValue(message, null, "sleep");
                        fail("got exception instead of a response: " + exp.getMessage());
            TransportRequestOptions.Type.RECOVERY,
                () -> serviceA.connectToNode(dummy, builder.build())
            }  
        serviceB.sendRequest(nodeA, "internal:action", new TestRequest(randomFrom("fail", "pass")), transportResponseHandler);
        }
        clusterSettingsA.applySettings(
                    }
            assertThat("hello moshe", equalTo(message.message));  
                if (action.equals(ACTION)) {
        if (randomBoolean()) {
            @Override
        StringMessageRequest ping = new StringMessageRequest("ping");
            fail("exception should be thrown");  
                        throw new UncheckedIOException(e1);
        serviceB.registerRequestHandler("internal:version", ThreadPool.Names.SAME, Version1Request::new, (request, channel, task) -> {  
            }
        };
                                }
                public void handleException(TransportException exp) {
                    @Override
            // connection with one connection and a large timeout -- should consume the one spot in the backlog queue
    }
        TransportResponseHandler<StringMessageResponse> noopResponseHandler = new TransportResponseHandler<StringMessageResponse>() {
    }  
        serviceB.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {  
        );
                @Override  
                    assertNull(threadPool.getThreadContext().getTransient("boom"));
                if (randomBoolean() && request.resendCount++ < 20) {  
        private String message;
        assumeTrue("only tcp transport has a handshake method", serviceA.getOriginalTransport() instanceof TcpTransport);  
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
            public void handleResponse(StringMessageResponse response) {}
        Settings globalSettings = Settings.builder()  
                        fail(e.getMessage());
            assertEquals(version1, channel.getVersion());
            }  
                @Override  
                nodeA,
 */
            .put("transport.tcp.keep_count", "14")
            nodeA,
            .put("network.tcp.send_buffer_size", "4b")
                    assertEquals(version0, channel.getVersion());
        assertNull("this header is only visible in the handler context", threadPool.getThreadContext().getHeader("some.temp.header"));  
                    .put("transport.profiles.default.bind_host", "_local:ipv4_")
            ) {
                // now with the 1ms timeout we got and test that is it's applied
                }
            "internal:version",
            updatedSettings,
                } catch (Exception e) {
            );
                public String executor() {
            DiscoveryNode first = new DiscoveryNode(
                errorResponseSent
            channel.sendResponse(response);  
            final MockLogAppender.LoggingExpectation responseReceivedExpectation = new MockLogAppender.PatternSeenEventExpectation(  
                }
                        @Override  
            final ConnectTransportException e = expectThrows(
            .put("network.publish_host", "another_publish_host")
            .put(settings)
            assertTrue(allRequestsDone.await(5, TimeUnit.SECONDS));
    public void testVersionFrom1to1() throws Exception {
                assertEquals(1, transportStats.getRxCount());
            @Override  
            fail("exception should be thrown");  
            }  
                serviceA.sendRequest(
            () -> buildService("test", Version.CURRENT, settings)
import org.opensearch.ExceptionsHelper;
            PlainTransportFuture<StringMessageResponse> future = new PlainTransportFuture<>(noopResponseHandler);  
                logger.debug("---> received response: {}", response.info);
            );
                assertEquals(2, transportStats.getTxCount());
        serviceB.connectToNode(nodeA);  
                StringMessageRequest::new,
        assertThat(latch.await(5, TimeUnit.SECONDS), equalTo(true));  
        serviceA.registerRequestHandler(
        final int value2;
                "internal:action1",
                public StringMessageResponse read(StreamInput in) throws IOException {  
            builder.addConnections(
            .put("transport.profiles.default.publish_port", 42)
                public void handleResponse(StringMessageResponse response) {
        TransportInterceptor interceptor
        assertEquals(42, settings.tcpKeepIdle);
        return service;
    }
                        public String executor() {
                assertThat(message, notNullValue());
        final CountDownLatch latch3 = new CountDownLatch(1);
            .put("transport.publish_host", "another_publish_host")
        builder.addConnections(  
            @Override
            serviceA.sendRequest(nodeB, "internal:testError", new StringMessageRequest(""), noopResponseHandler);  
            }
            .put("transport.profiles.default.tcp.keep_interval", "7")
            });  
                "not seen request received",
    public void testVersionFrom0to1() throws Exception {
                        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
                public String executor() {
    }  
                }
            );
        serviceC.connectToNode(nodeA);
            public StringMessageResponse read(StreamInput in) throws IOException {
        final String executor = randomFrom(ThreadPool.THREAD_POOL_TYPES.keySet().toArray(new String[0]));
        }
                public void onFailure(Exception e) {
            socket.bind(getLocalEphemeral(), 1);  
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);  
 *
                @Override
        serviceC.removeConnectionListener(waitForConnection);  
            assertEquals(failedMessage, 57 + streamOutput.bytes().length(), stats.getRxSize().getBytes());
        Version0Request(StreamInput in) throws IOException {
                @Override
        serviceC.start();
                Level.TRACE,  
                assertTrue(  
        );  
            }  
        serviceA.addConnectionListener(disconnectListener);
        assertTrue("serviceA is not connected to nodeA", serviceA.nodeConnected(nodeA));
            assertBusy(appender::assertAllExpectationsMatched);
                @Override  
    public void testTimeoutPerConnection() throws IOException {
                1,
            super(in);  
                "internal:foobar",  
            );
                }
                            throw failToSendException;
            .put("network.tcp.keep_count", "13")
                    connectionClosedListenerCalled.set(true);  
            fail("message round trip did not complete within a sensible time frame");
        });  
                public void handleResponse(Version1Response response) {
                public String executor() {
            serviceC.connectToNode(serviceA.getLocalDiscoNode(), connectionProfile);
                    }
            final ConnectionProfile.Builder builder = new ConnectionProfile.Builder();  
        );
            public TestResponse read(StreamInput in) throws IOException {
 */  
        serviceB.registerRequestHandler("internal:test", ThreadPool.Names.SAME, TestRequest::new, ignoringRequestHandler);  
            new StringMessageRequest("moshe"),
                        }
        assertTrue(inFlight.tryAcquire(Integer.MAX_VALUE, 10, TimeUnit.SECONDS));  
        try (Transport.Connection connection = serviceC.openConnection(serviceB.getLocalNode(), builder.build())) {  
        Version version = Version.fromString("6.0.0");
            assertEquals("[][" + dummy.getAddress() + "] handshake_timeout[1ms]", ex.getMessage());  
                long startTime = System.nanoTime();
                }
                public String executor() {
                "org.opensearch.transport.TransportService.tracer",
            @Override
                ConnectTransportException.class,  
            threadPool,
                1,
                } finally {
        try (Transport.Connection connection = serviceB.openConnection(serviceC.getLocalNode(), builder.build())) {
        );  
            BindTransportException.class,
                return TransportResponse.Empty.INSTANCE;
        return 6;
                assertThat(te.get().getCause(), nullValue());  
                fail(e.getMessage());
                    String message = request.message;
            this.message = message;  
        });
            assertThat(tracerA.responseSent.get(), equalTo(1));  
    public void testTracerLog() throws Exception {
            @Override
                "TS_TPC",  
            AtomicInteger responseSent = new AtomicInteger();
                transportResponseHandler
                assertEquals(2, transportStats.getTxCount());
            nodeA,
                }
        assertEquals(2, profileSettings.size());  
            new StringMessageRequest("forever"),  
                                        Thread.sleep(randomIntBetween(10, 50));  
                TransportRequestOptions.EMPTY,  
            }
            StringMessageResponse message = res.get();
                    sendResponseLatch.await();  
        public long timeout() {
                allRequestsDone.countDown();  
                    return ThreadPool.Names.SAME;
                @Override  
        try (MockTransportService service = buildService("TS_C", version, Settings.EMPTY)) {  
        serviceA = buildService("TS_A", version0, clusterSettingsA, connectionSettings); // this one supports dynamic tracer updates
            @Override
            serviceC.sendRequest(  
            try {  
                    fail("got response instead of exception");  
            final MockLogAppender.LoggingExpectation errorResponseSentExpectation = new MockLogAppender.PatternSeenEventExpectation(  
            public void handleResponse(TransportResponse response) {  
        public void writeTo(StreamOutput out) throws IOException {
            final MockLogAppender.LoggingExpectation requestReceivedExpectation = new MockLogAppender.PatternSeenEventExpectation(
                Level.TRACE,
                        return TransportResponse.Empty.INSTANCE;  
        }
            nodeA,  
                        assertBusy(() -> assertTrue(connection.isClosed()));
                            }  
                public void handleException(TransportException exp) {  
            super(value1);
        }  
                @Override
                @Override  
            this.message = in.readString();
        }
            .put("transport.profiles.default.tcp.receive_buffer_size", "42000b")  
    public void testMockUnresponsiveRule() throws IOException {  
            TransportFuture<TransportResponse.Empty> foobar = serviceB.submitRequest(
            nodeB,
            .put("transport.profiles.some_profile.tcp.keep_idle", "42")
                }
                assertThat(te.get().getCause(), instanceOf(IllegalStateException.class));
        } catch (ConnectTransportException e) {
                }
            @Override
                public void handleException(TransportException exp) {
import org.opensearch.threadpool.ThreadPool;
                "internal:action1",  
    }
            service.addConnectionListener(new TransportConnectionListener() {
            public void handleResponse(TransportResponse response) {
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);
                Settings.builder()  
                    logger.error("unexpected error", e);
            connectionSettingsBuilder.put(TransportSettings.TCP_KEEP_IDLE.getKey(), randomIntBetween(1, 300));  
                }  
            Collections.emptySet(),  
                    @Override
                // we don't really care what's going on B, we're testing through A
                    assertThat(response.value1, equalTo(1));  
                        public TestResponse read(StreamInput in) throws IOException {
            assertThat(ExceptionsHelper.unwrapCause(e.getCause()).getMessage(), equalTo("simulated"));  
                    assertEquals(version0, channel.getVersion());  
            public TestResponse read(StreamInput in) throws IOException {
    }
                    return new StringMessageResponse(in);
 * Unless required by applicable law or agreed to in writing,
        TransportService serviceC = buildService("TS_C", CURRENT_VERSION, Settings.EMPTY);  
        for (int i = 0; i < 10; i++) {  
        assertNumHandshakes(numHandshakes, serviceB.getOriginalTransport());
                    done.countDown();
    static class Version0Response extends TransportResponse {
        );
            }
            new StringMessageRequest("test"),
                        } else {
import org.opensearch.common.network.NetworkAddress;  
        final CountDownLatch latch = new CountDownLatch(1);
                    public StringMessageResponse read(StreamInput in) throws IOException {
    protected volatile MockTransportService serviceB;
                nodeA,
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
            channel.sendResponse(new RuntimeException(""));
    public void testConcurrentDisconnectOnNonPublishedConnection() throws IOException, InterruptedException {
                return ThreadPool.Names.SAME;
                }
        final CountingListener tracerA = new CountingListener();  
            @Override
            TransportRequestOptions.Type.BULK,
        }
            new TransportResponseHandler<StringMessageResponse>() {
                } catch (IOException e) {  
        try {
    }  
                @Override  
            assertThat(tracerB.responseReceived.get(), equalTo(0));
                "org.opensearch.transport.TransportService.tracer",
                    }
                    channel.sendResponse(new StringMessageResponse(request.message));
            }
                "TEST",  
            .put(TransportSettings.PORT.getKey(), port)
            .build();  
            out.writeOptionalString(info);
                nodeB = newService.getLocalDiscoNode();
                    return new StringMessageResponse(in);  
                    return ThreadPool.Names.GENERIC;
                StringMessageRequest::new,  
    private static class TestResponse extends TransportResponse {
                ThreadPool.Names.GENERIC,
    public void testHandshakeWithIncompatVersion() {  
            );
            @Override  
import java.util.ArrayList;
                return randomBoolean() ? ThreadPool.Names.SAME : ThreadPool.Names.GENERIC;  
                @Override  
        serviceC.addConnectionListener(waitForConnection);
                    public StringMessageResponse read(StreamInput in) throws IOException {
    }  
            assertEquals(115, stats.getTxSize().getBytes());  
                return new TestResponse(in);
            ThreadPool.Names.GENERIC,  
                }
        serviceB.registerRequestHandler(  
        }  
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);  
                Level.TRACE,
    protected volatile DiscoveryNode nodeB;
                if (randomBoolean()) {
                emptyMap(),
            .put("transport.tcp.reuse_address", enable)
        }
            }
        );
                public void onConnectionOpened(final Transport.Connection connection) {
                TransportRequest.Empty.INSTANCE,  
                                    }
        expectThrows(ConnectTransportException.class, () -> serviceB.openConnection(nodeA, TestProfiles.LIGHT_PROFILE));  
                    }  
            String failedMessage = "Unexpected read bytes size. The transport exception that was received=" + exception;
            // don't block on a network thread here
                Level.TRACE,  
        assertTrue(nodeB.getAddress().getAddress().equals(addressB.get().getAddress()));  
                        final String info = sender + "_" + iter;
        assertEquals(
            "internal:action1",
        serviceA.registerRequestHandler(
        builder.addConnections(
            )
            }  
                value2 = 0;
        });
            resendCount = in.readInt();
                            return ThreadPool.Names.SAME;
        logger.debug("DONE");  
                        }
                    TransportRequestOptions.EMPTY,
        };
            future.txGet();
            }
        ConnectionProfile connectionProfile = new ConnectionProfile.Builder(defaultProfile).setPingInterval(TimeValue.timeValueMillis(50))  
                TransportRequestOptions.Type.PING,
                }
            assertEquals(version0, channel.getVersion());
                allRequestsDone.countDown();  
                "received response",
            assertThat(cause, instanceOf(ConnectTransportException.class));  
        threadPool.getThreadContext().putHeader("test.ping.user", "ping_user");  
        try (MockTransportService serviceC = buildService("TS_C", CURRENT_VERSION, Settings.EMPTY)) {
            public void handleException(TransportException exp) {
import org.apache.logging.log4j.message.ParameterizedMessage;
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
            public void handleException(TransportException exp) {  
                    @Override
        final CountDownLatch latch2 = new CountDownLatch(1);  
                "internal:action",
                        }  
            TestRequest::new,
                assertEquals(55, transportStats.getTxSize().getBytes());  
        }
import org.opensearch.test.OpenSearchTestCase;
        ex.setStackTrace(new StackTraceElement[0]);
            TransportAddress address = service.boundAddress().publishAddress();  
                    return ThreadPool.Names.SAME;
    public void setUp() throws Exception {
                serviceB.connectToNode(nodeA);
        }
            service.acceptIncomingRequests();  
                                    (Supplier<?>) () -> new ParameterizedMessage("caught exception while sending to node {}", node),
        }
                public void handleException(TransportException exp) {
        TransportStats stats = serviceC.transport.getStats(); // nothing transmitted / read yet
                        assertThat("hello " + counter + "ms", equalTo(response.message));  
                    StringMessageResponse response = new StringMessageResponse("pong");
                    assertThat("hello moshe", equalTo(response.message));
            @Override
                public Version1Response read(StreamInput in) throws IOException {
        }  
        CountDownLatch latch = new CountDownLatch(2);  
                }  
                TransportRequestOptions.Type.PING,
        serviceB.removeConnectionListener(waitForConnection);
                TransportRequestOptions.EMPTY,
                    connection,
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            serviceC.sendRequest(
            }  
                StringMessageResponse message = res.get();  
                latch.countDown();  
                connection,
                    @Override  
        assertEquals(1, profileSettings.size());
                @Override  
                } finally {
        if (randomBoolean()) {
import org.opensearch.core.common.transport.BoundTransportAddress;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        connectionSettingsBuilder.put(TransportSettings.TCP_KEEP_ALIVE.getKey(), randomBoolean());
        Version0Response version0Response = serviceA.submitRequest(  
            }
                            nodeA,  
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
        } catch (ExecutionException e) {
            });
        serviceA.registerRequestHandler(
                    return ThreadPool.Names.GENERIC;  
        }
            (request, channel, task) -> {  
                    service.sendRequest(  
            assertNotNull(exception);
                    assertThat("moshe", equalTo(request.message));  
        Transport transport = build(updatedSettings, version, clusterSettings, doHandshake);
            assertEquals(115, stats.getTxSize().getBytes());  
            @Override
        );  
            IllegalArgumentException.class,
        } else {
            excludeSettings = "internal:testNotSeen";  
                public StringMessageResponse read(StreamInput in) throws IOException {
            }  
                        new TransportResponseHandler<TestResponse>() {
                } catch (IOException e) {
            assertEquals(Collections.emptyList(), settings.publishHosts);
                    return new StringMessageResponse(in);
            .put("network.tcp.receive_buffer_size", "3b")  
                assertThat("moshe", equalTo(request.message));
                            serviceA.sendRequest(
            assertEquals(Collections.singletonList("the_publish_host"), settings.publishHosts);  
import org.apache.lucene.util.CollectionUtil;  
            @Override
        final Version version,
                assertThat("hello moshe", equalTo(message.message));
            .put("transport.profiles.some_profile.tcp.keep_alive", enable)
            Map<String, BoundTransportAddress> profileBoundAddresses = serviceC.transport.profileBoundAddresses();
        try (ServerSocket socket = new ServerSocket()) {
            .put("network.tcp.receive_buffer_size", "42000b")
            }  
            Version1Request::new,  
import java.util.List;
                        }  
                }
                TransportRequestOptions.Type.BULK,
    protected ThreadPool threadPool;  
                @Override
    public void testProfileSettings() {
            assertBusy(() -> { // netty for instance invokes this concurrently so we better use assert busy here
            @Override  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
                    if (exp instanceof SendRequestTransportException) {
                        assertTrue(exp.getClass().toString(), exp instanceof NodeDisconnectedException);
        );
                public void onFailure(Exception e) {
                assertFalse(requestProcessed.get());  
import java.util.Collections;
        @Override
                }  
        }
/*  
                CountDownLatch latch = new CountDownLatch(1);  
                    .putList("transport.profiles.some_other_profile.bind_host", hosts)
    public void testKeepAlivePings() throws Exception {
    }
            receivedLatch.await();
            "internal:action1",
            latch.countDown();  
                        return ThreadPool.Names.GENERIC;
            final MockLogAppender.LoggingExpectation notSeenResponseSentExpectation = new MockLogAppender.PatternSeenEventExpectation(
        if (!latch.await(10, TimeUnit.SECONDS)) {
            @Override  
                    }
                            }
        serviceB.registerRequestHandler(
    protected static final Version version0 = CURRENT_VERSION.minimumCompatibilityVersion();  
            )  
            private final TransportService service;  
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
        );
            AtomicBoolean connectionClosedListenerCalled = new AtomicBoolean(false);
        serviceA.disconnectFromNode(nodeC);  
            assertThat(e.getMessage(), false, equalTo(true));
        serviceC.start();
                );
    }
            .put("transport.profiles.some_profile.tcp.reuse_address", enable)
                assertBusy(() -> { assertTrue(originalTransport.getKeepAlive().successfulPingCount() > 30); });
                    }  
                1,  
                logger.error("Unexpected failure", exp);
    }  
                            "test",
    public void testChannelCloseWhileConnecting() {
                @Override
            );  
                    public <T extends TransportResponse> void sendRequest(
                if (action.equals(ACTION)) {  
        );
            fail("exception should be thrown");  
            TransportFuture<TransportResponse.Empty> res = serviceC.submitRequest(  
        assertSame(context, threadPool.getThreadContext().getTransient("my_private_context"));
        }  
            ThreadPool.Names.GENERIC,  
                        // here the concurrent disconnect was faster and invoked the listener first
            );
        try {  
                        if ("forever".equals(message)) {
                    }
                }
            builder.setHandshakeTimeout(TimeValue.timeValueMillis(1));
        String excludeSettings;
            final String responseSent = ".*\\[internal:test].*sent response.*";
                            }  
                TransportRequest.Empty::new,  
                @Override
        public void writeTo(StreamOutput out) throws IOException {  
        };
                    requestsReceived.incrementAndGet();  
                                try {  
                @Override  
        serviceB.addMessageListener(tracerB);  
                fail("TransportException expected");
    protected volatile MockTransportService serviceA;  
            assertEquals(2, stats.getRxCount());  
                            latch.countDown();
            .put(randomBoolean() ? transportSettings2 : globalSettings2) // ensure that we have profile precedence  
        }
            .put(randomBoolean() ? transportSettings2 : globalSettings2) // ensure that we have profile precedence
                    requestsSent.incrementAndGet();
        }
            public TransportResponse read(StreamInput in) {
                    latch.countDown();
            out.writeLong(timeout);  
            assertThat(e, instanceOf(ReceiveTimeoutTransportException.class));
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {
                            try {
            }
            Version0Request::new,
            // means that once we received an ACK from the client we just drop the packet on the floor (which is what we want) and we run  
                nodeA,
                        latch3.countDown();  
                    @Override
        }
                            waitForever.await();  
            }
            if (request.timeout() > 0) {
                emptySet(),  
            }
            (request, message, task) -> {
                1,
        public TestRequest(String info) {
        Settings settings,
            // B senders just generated activity so serciveA can respond, we don't test what's going on there  
                        throw new UncheckedIOException(e1);
                        }
            return "TestRequest{" + "info='" + info + '\'' + '}';  
        assertEquals(0, stats.getRxSize().getBytes());
        assertEquals(0, stats.getRxCount());
            public void messageReceived(TestRequest request, TransportChannel channel, Task task) throws Exception {
                        }  
        if (transport instanceof TcpTransport) {  
            serviceA.sendRequest(nodeB, "internal:test", request, TransportRequestOptions.EMPTY, noopResponseHandler);
                    } else if (addr.address().getAddress() instanceof Inet6Address) {
                public StringMessageResponse read(StreamInput in) throws IOException {
            connectionSettingsBuilder.put(TransportSettings.TCP_KEEP_INTERVAL.getKey(), randomIntBetween(1, 300));  
        @Override  
            }  
        AtomicBoolean fail = new AtomicBoolean(false);  
            }  
import java.util.concurrent.CyclicBarrier;  
                        fail(e.getMessage());  
    }
    }
                } finally {
                    return ThreadPool.Names.GENERIC;
    }
        assumeTrue("only tcp transport has a handshake method", serviceA.getOriginalTransport() instanceof TcpTransport);
            transport,
        ClusterSettings clusterSettings,
                    .put("transport.profiles.some_profile.bind_host", "_local:ipv4_")  
        StringMessageResponse(StreamInput in) throws IOException {  
            try {
                }
import java.io.IOException;
                try {
    @TestLogging(value = "org.opensearch.transport.TransportService.tracer:trace", reason = "to ensure we log network events on TRACE level")  
        CollectionUtil.timSort(executors); // makes sure it's reproducible  
                        fail(e.getMessage());  
                TransportRequestOptions.Type.RECOVERY,
            appender.addExpectation(notSeenResponseSentExpectation);
                TransportStats transportStats = serviceC.transport.getStats(); // request has been sent
                latch.countDown();
        assertThat("found non connection errors while sending", sendingErrors, empty());
import java.util.concurrent.BrokenBarrierException;
                        public void handleException(TransportException exp) {
                    return ThreadPool.Names.SAME;
    public void testVersionFrom0to0() throws Exception {
            .put(Node.NODE_NAME_SETTING.getKey(), "foobar")
            assertTrue(profileBoundAddresses.get("some_other_profile").publishAddress().getPort() >= 8700);  
        try (ServerSocket socket = new ServerSocket()) {  
    }
            PlainActionFuture<Transport.Connection> future = PlainActionFuture.newFuture();  
                emptyMap(),
                assertEquals(115, transportStats.getTxSize().getBytes());
        TransportRequestHandler<StringMessageRequest> handlerWithError = (request, channel, task) -> {  
                "internal:sayHelloTimeoutDelayedResponse",
                }
            this.info = info;  
            appender.addExpectation(errorResponseReceivedExpectation);
            }  
            "internal:sayHelloException",  
                "sent error response",
                        );
            TransportRequestOptions.Type.RECOVERY,
            serviceA.disconnectFromNode(nodeB);  
        assertEquals(2, profileSettings.size());  
            StringMessageRequest::new,
                assertTrue(profileBoundAddresses.get("some_other_profile").boundAddresses().length >= 2);
                @Override
            TestRequest::new,  
            );  
            public String executor() {
import org.opensearch.core.common.io.stream.StreamInput;
                TransportRequestOptions.Type.RECOVERY,
            final String notSeenReceived = ".*\\[internal:testNotSeen].*received request.*";
                    fail("no response expected");
            );
            assertEquals(2, stats.getRxCount());
            appender.addExpectation(errorResponseSentExpectation);  
            assertThat(tracerA.requestsSent.get(), equalTo(2));  
                    }
            DiscoveryNode node = new DiscoveryNode("TS_TPC", "TS_TPC", address, emptyMap(), emptySet(), Version.fromString("2.0.0"));
        ConnectionProfile defaultProfile = ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY);
 * not use this file except in compliance with the License.
                    return ThreadPool.Names.SAME;
                    return ThreadPool.Names.GENERIC;
        clusterSettingsA = new ClusterSettings(Settings.EMPTY, getSupportedSettings());
        final String name,  
    }
                    }
import org.apache.logging.log4j.util.Supplier;
            }  
                new TransportResponseHandler<TransportResponse.Empty>() {
        try (MockLogAppender appender = MockLogAppender.createForLoggers(logger)) {
                    responseReceived.incrementAndGet();  
            .put("network.publish_host", "the_publish_host")  
            public void handleException(TransportException exp) {
            }
                    receivedLatch.countDown();
                }
                try {  
        });
            nodeA,
                    new TransportResponseHandler<TestResponse>() {  
            Version0Response response = new Version0Response(1);
            }  
            });  
        serviceA.connectToNode(nodeC);  
                assertEquals(115, transportStats.getTxSize().getBytes());  
                } catch (IOException e) {
            serviceB.submitRequest(nodeA, ACTION, TransportRequest.Empty.INSTANCE, EmptyTransportResponseHandler.INSTANCE_SAME).get();
                }  
                public void handleResponse(StringMessageResponse response) {  
            appender.addExpectation(requestSentExpectation);
            profileSettings.stream().map(s -> s.profileName).collect(Collectors.toSet())  
                    @Override  
            .put("transport.profiles.some_profile.tcp.keep_count", "13")
                TransportRequestOptions.Type.RECOVERY,
        }
                TransportStats transportStats = serviceC.transport.getStats(); // we did a single round-trip to do the initial handshake  
                public Version0Response read(StreamInput in) throws IOException {  
            assertEquals(ex.getMessage(), "[][" + dummy.getAddress() + "] general node connection failure");
                            }
        BindTransportException bindTransportException = expectThrows(  
            @Override  
                public void handleResponse(StringMessageResponse response) {  
        }
                @Override  
            assertThat(e.getCause(), instanceOf(OpenSearchException.class));  
                }  
                version0
        serviceB.registerRequestHandler(ACTION, ThreadPool.Names.GENERIC, TransportRequest.Empty::new, requestHandler);
    public static class Version0Request extends TransportRequest {
                    ) {
                    latch.countDown();  
        @Override
        assertEquals(0, stats.getRxCount());  
            assertThat(tracerA.responseSent.get(), equalTo(0));
                notSeenSent  
                            logger.error("Unexpected failure", e);
            }
                "not seen request sent",  
    protected static final Version version1 = Version.fromId(CURRENT_VERSION.id + 1);  
            serviceC.acceptIncomingRequests();  
            (request, channel, task) -> {
            .put("network.tcp.keep_count", "14")  
            .put("transport.profiles.default.tcp.keep_count", "13")  
                    assertEquals(1, threadPool.getThreadContext().getResponseHeaders().get("foo.bar").size());
        serviceB.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {  
                new TransportResponseHandler<TransportResponse>() {  
            new StringMessageRequest("moshe"),  
                @Override
            .put("network.tcp.keep_interval", "8")
                    public String executor() {  
                assertTrue("num ipv4 is wrong: " + ipv4, ipv4 >= 1);
                    }  
                return ThreadPool.Names.SAME;
            version1Request,
                @Override
        );
            serviceC.close();
                            latch2.countDown();
                    } finally {
                assertEquals(29, transportStats.getRxSize().getBytes());
                    return new Version0Response(in);
    }  
            final int counter = i;
            includeSettings = "internal:test,internal:testError";
            );
    @SuppressForbidden(reason = "need local ephemeral port")  
                        try {
        assertBusy(() -> {  
        if (doIPV6) {  
            if (out.getVersion().onOrAfter(version1)) {
            Settings.builder()  
            super.writeTo(out);
        ClusterSettings clusterSettings = new ClusterSettings(randomSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                assertNotNull("Expected an IOException somewhere in causal chain: " + exp, unwrap);
        );
                out.writeInt(value2);  
                    logger.error("Unexpected failure", exp);
                    @Override
            } else if (serviceA.nodeConnected(nodeB)) {
        // wait till all nodes are properly connected and the event has been sent, so tests in this class  
                transportResponseHandler
        serviceA.addConnectionListener(waitForConnection);
        serviceA.registerRequestHandler("internal:testNotSeen", ThreadPool.Names.SAME, StringMessageRequest::new, handler);
                public void handleResponse(StringMessageResponse response) {  
                return new TestResponse(in);  
            threadPool.getThreadContext().putTransient("boom", new Object());  
            socket.setReuseAddress(true);
                }
                    responseSent.incrementAndGet();
                }  
            service.acceptIncomingRequests();
                    assertSame(response, TransportResponse.Empty.INSTANCE);
    }
        if (clusterSettings == null) {
            DiscoveryNode node = new DiscoveryNode(
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {
                        final TransportResponseHandler<T> handler
        });
                    responseString.set(response.message);
            @Override
            .put(TransportSettings.CONNECTIONS_PER_NODE_BULK.getKey(), 1)
                }
        }
                latch.countDown();
import java.util.concurrent.atomic.AtomicReference;  
                                    if (randomBoolean()) {
            .put("transport.port", "9702-9802")  
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
            // sometimes leave include empty (default)
                TransportRequestOptions.Type.REG,  
                    assertEquals(1, threadPool.getThreadContext().getResponseHeaders().get("foo.bar").size());
        Version1Request(StreamInput in) throws IOException {
        // use assert busy as callbacks are called on a different thread
        version0Request.value1 = 1;
            // don't block on a network thread here
            @Override
        }
            public void onResponseSent(long requestId, String action, Exception error) {  
            @Override
            latch2.countDown();
        } catch (Exception e) {
            out.writeString(message);  
    public void testRegisterHandlerTwice() {  
                Level.TRACE,
                () -> serviceA.connectToNode(dummy, builder.build())
            private final int id;
        assertEquals(0, stats.getRxSize().getBytes());  
            super(in);
        ConnectionProfile.Builder builder = new ConnectionProfile.Builder();  
                    }
            TransportException exception = receivedException.get();
                TransportRequestOptions.Type.STATE  
        final TransportRequestHandler<TestRequest> ignoringRequestHandler = (request, channel, task) -> {
                emptySet(),  
            }
        );
                    @Override
        public StringMessageRequest(StreamInput in) throws IOException {  
                    assertThat(exp, instanceOf(ReceiveTimeoutTransportException.class));  
        assertEquals("ping_user", threadPool.getThreadContext().getHeader("test.ping.user"));
        TestResponse(String info) {
                                try {
            serviceB.close(); // make sure we are fully closed here otherwise we might run into assertions down the road
            .put("network.tcp.keep_idle", "43")
            .put("transport.profiles.some_profile.tcp.keep_interval", "7")  
            }
            socket.setReuseAddress(true);
        serviceB.addConnectionListener(waitForConnection);
            Settings.builder().put("transport.profiles.test.port", "0").put("transport.profiles.default.port", "0").build()
                @Override  
        try (Transport.Connection connection = serviceC.openConnection(serviceB.getLocalNode(), builder.build())) {
            .put("transport.bind_host", "another_bind_host")
        TransportConnectionListener disconnectListener = new TransportConnectionListener() {
                }
                    logger.info("caught exception while responding", e);
            1,
            assertEquals(-1, settings.publishPort);
        serviceA.registerRequestHandler("internal:test", ThreadPool.Names.SAME, StringMessageRequest::new, handler);  
            }
            });  
            .put("transport.profiles.default.tcp.reuse_address", enable)
        });  
        StringMessageRequest(String message, long timeout) {
                    fail("got response instead of exception");
                public void handleException(TransportException exp) {  
            PlainActionFuture<Transport.Connection> future = PlainActionFuture.newFuture();
                            @Override
            public String executor() {
                TransportRequestOptions.Type.BULK,  
            "internal:action1",
        MockTransportService service = MockTransportService.createNewService(  
            .put(TransportSettings.CONNECTIONS_PER_NODE_REG.getKey(), 2)  
    public static class StringMessageRequest extends TransportRequest {
                emptyMap(),
    }
                throw new RuntimeException("bad message !!!");
                    }
            final MockLogAppender.LoggingExpectation notSeenReceivedExpectation = new MockLogAppender.PatternSeenEventExpectation(  
            TransportRequestOptions.Type.PING,  
        TransportResponseHandler<TransportResponse> transportResponseHandler = new TransportResponseHandler<TransportResponse>() {  
            });
                String action,
            }
                }
                            listener.actionGet();  
        public void writeTo(StreamOutput out) throws IOException {
                }
                assertThat(e.getMessage(), false, equalTo(true));
                        serviceB.stop();
                        } else {
        TcpTransport.ProfileSettings settings = new TcpTransport.ProfileSettings(
            final int sender = i;
        serviceA.registerRequestHandler(
                @Override
            new TransportResponseHandler<StringMessageResponse>() {
                    public void handleException(TransportException exp) {
 * the Apache License, Version 2.0 (the "License"); you may
        });
                public void run() {
                new TestRequest("hello world"),
import org.opensearch.cluster.node.DiscoveryNode;
            @Override  
        });
                @Override
                    assertThat(response.value2, equalTo(0)); // initial values, cause its serialized from version 0  
    public static class Version1Request extends Version0Request {
                assertThat("moshe", equalTo(request.message));  
            this.value1 = in.readInt();
            try {  
            } catch (Exception e) {
import org.opensearch.core.common.transport.TransportAddress;
            @Override
                "org.opensearch.transport.TransportService.tracer",
                    DiscoveryNode node = randomFrom(nodeA, nodeB, nodeC);
                TransportRequestOptions.Type.STATE
    }
    // test that the response handler is invoked on a failure to send
            @Override
            .put("network.tcp.reuse_address", enable)  
                    assertThat(exp, instanceOf(ReceiveTimeoutTransportException.class));
            this.value1 = value1;
                        public void handleResponse(TestResponse response) {
            nodeA,
                assertThat(e.getMessage(), false, equalTo(true));  
            );
                    assertEquals("baz", threadPool.getThreadContext().getResponseHeaders().get("foo.bar").get(0));  
            (request, channel, task) -> {
                        new TestRequest("secondary " + request.info),  
            TransportRequestOptions.Type.STATE  
        clusterSettings.validate(randomSettings, false);  
import org.opensearch.test.VersionUtils;
        String includeSettings;
            .build();  
            timeout = in.readLong();  
            .put("transport.tcp.send_buffer_size", "5b")  
                    }
    public void testProfilesIncludesDefault() {  
                    channel.sendResponse(response);  
            new StringMessageRequest("moshe"),  
                return randomFrom(executors);  
                (request, channel, task) -> {  
        List<String> executors = new ArrayList<>(ThreadPool.THREAD_POOL_TYPES.keySet());
        });
        final Version version,
        @Override
                assertThat(message.message, equalTo("hello " + counter + "ms"));
            @Override
        ConnectionProfile connectionProfile = ConnectionProfile.buildDefaultConnectionProfile(Settings.EMPTY);
                    logger.error("Unexpected failure", e);  
        public void writeTo(StreamOutput out) throws IOException {  
            appender.addExpectation(responseReceivedExpectation);
                }
                }
            assertThat(tracerB.requestsSent.get(), equalTo(0));
            appender.addExpectation(requestReceivedExpectation);
            }
                        return new StringMessageResponse(in);
        @Nullable ClusterSettings clusterSettings,
                        fail("handle response should not be invoked");  
            public void handleException(TransportException exp) {
                @Override
                public void messageReceived(StringMessageRequest request, TransportChannel channel, Task task) {
            fail("exception should be thrown");
                                } catch (Exception e) {
            }
            final String notSeenSent = "*[internal:testNotSeen]*sent to*";
        // use assert busy as callbacks are called on a different thread  
                throw new AssertionError("boom");  
            }
                "TEST",  
        if (randomBoolean()) {
                latch.countDown();
            TransportRequestOptions.Type.REG,
    private MockTransportService buildService(  
                        throw new UncheckedIOException(e);
        try (TransportService service = buildService("TS_TPC", Version.CURRENT, Settings.EMPTY)) {
                        throw new UncheckedIOException(e1);
                    inFlight.acquireUninterruptibly();  
            final MockLogAppender.LoggingExpectation notSeenSentExpectation = new MockLogAppender.UnseenEventExpectation(
        assertThat(version0Response.value1, equalTo(1));
                    logger.error("Unexpected failure", exp);
                Thread.sleep(request.timeout);
            .put("transport.profiles.some_profile.bind_host", "the_bind_host")
            service.acceptIncomingRequests();  
                "TS_TPC",
                protected void doRun() throws Exception {
            sendResponseLatch.countDown();
            serviceC.connectToNode(
            .put("transport.tcp.receive_buffer_size", "42000b")
        CountDownLatch responseLatch = new CountDownLatch(1);
            res.txGet();
                return ThreadPool.Names.SAME;  
                    for (int iter = 0; iter < 10; iter++) {
            }
        }
import org.opensearch.common.unit.TimeValue;
            }
            public void onNodeDisconnected(DiscoveryNode node, Transport.Connection connection) {  
        @Override
                        inFlight.release();  
                    assertThat(request.value2, equalTo(0)); // not set, coming from service A
import java.util.concurrent.Semaphore;
                    assertThat(request.value1, equalTo(1));
                public void handleResponse(Version0Response response) {
        };
                    } catch (IOException e) {
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
            @Override  
    // we use always a non-alpha or beta version here otherwise minimumCompatibilityVersion will be different for the two used versions
            ThreadPool.Names.GENERIC,
            }  
            assertEquals(channelsPerNodeConnection(), transportStats.getServerOpen());
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
        final String ACTION = "internal:action";
                }  
                TransportRequestOptions.Type.STATE
            assertEquals(42, settings.publishPort);  
        version1Request.value1 = 1;  
            .put("transport.port", "9700-9800")  
                @Override
                        serviceB.sendRequest(
            );
            .build();  
        assertBusy(() -> {
        );
    }  
                            return new TestResponse(in);
        assertNumHandshakes(numHandshakes, serviceA.getOriginalTransport());
        }
            try (Transport.Connection connection = serviceA.openConnection(node, builder.build())) {
            assertThat(e.getMessage(), false, equalTo(true));
                public void handleException(TransportException exp) {
                public void handleException(TransportException exp) {
                }
        );
        });  
            );
            }
                public String executor() {  
            "internal:sayHello",
                    responseLatch.countDown();
            this(message, -1);
                public String executor() {
                    public String executor() {  
        Settings settings,  
        };
    protected abstract Transport build(Settings settings, Version version, ClusterSettings clusterSettings, boolean doHandshake);
            @Override  
            assertThat(e, instanceOf(ReceiveTimeoutTransportException.class));
                }
    ) {
        );  
                new TransportAddress(socket.getInetAddress(), socket.getLocalPort()),
            } else {  
import java.util.concurrent.atomic.AtomicInteger;
            TransportRequestOptions.builder().withTimeout(100).build(),
        @Override
            );
    protected Set<TcpChannel> getAcceptedChannels(TcpTransport transport) {
        final CountDownLatch done = new CountDownLatch(halfSenders * 2);
        assertBusy(() -> {
            Settings settingsWithCompress = Settings.builder().put(TransportSettings.TRANSPORT_COMPRESS.getKey(), true).build();
                    try {
            }
            }  
        assertThat(version0Response.value1, equalTo(1));
import java.net.InetAddress;  
            serviceA.registerRequestHandler(  
                }
        serviceC.connectToNode(nodeB);
        try {
                @Override
            .put("network.bind_host", "another_bind_host")
                    }  
        }
        Settings randomSettings = randomFrom(random(), globalSettings, transportSettings, profileSettings);
        @Override
                version0
            sendResponseLatch.countDown();  
            new TransportResponseHandler<StringMessageResponse>() {
            .put("transport.publish_host", "the_publish_host")
            serviceB.sendRequest(  
            profileSettings.stream().map(s -> s.profileName).collect(Collectors.toSet())  
            serviceC.close();
                    logger.debug("send secondary request from {} to {} - {}", toNodeMap.get(service), node, request.info);
import static java.util.Collections.emptyMap;  
            serviceA.registerRequestHandler(  
 * compatible open source license.
            public TransportResponse read(StreamInput in) {  
            NoopTracer.INSTANCE
        public void writeTo(StreamOutput out) throws IOException {  
                        return ThreadPool.Names.GENERIC;
                        logger.error("Unexpected failure", e);
                "sent response",  
                for (TransportAddress addr : profileBoundAddresses.get("some_other_profile").boundAddresses()) {
            "internal:ping_pong",  
                }
                }
                        if ("fail-to-send-action".equals(action)) {  
            @Override
                                    logger.debug("send secondary response {}", response.info);
            serviceA.getOriginalTransport().openConnection(node, connectionProfile, future);  
            @Override  
        }
                    }  
                    } catch (Exception e) {
                    @Override
                if (action.equals(ACTION)) {  
                fail("got exception instead of a response: " + exp.getMessage());
                    } catch (Exception e) {  
                        TransportRequestOptions.EMPTY,
                        }  
        serviceB.addConnectionListener(waitForConnection);  
                    latch.countDown();  
        }
            this.message = message;
        }  
                }
                assertEquals(29, transportStats.getRxSize().getBytes());  
            }  
            "internal:sayHelloTimeoutDelayedResponse",
                        }
        return ClusterSettings.BUILT_IN_CLUSTER_SETTINGS;  
        serviceB.registerRequestHandler("internal:test", ThreadPool.Names.SAME, StringMessageRequest::new, handler);  
            out.writeInt(value1);  
            serviceB.connectToNode(nodeA);
            "internal:test",
    public void testBindUnavailableAddress() {
                };  
        }
    private void closeConnectionChannel(Transport.Connection connection) {  
                connection,  
                            return ThreadPool.Names.SAME;  
 * software distributed under the License is distributed on an
    }
        Version1Response(int value1, int value2) {  
            serviceA.sendRequest(nodeB, "internal:testNotSeen", new StringMessageRequest(""), future);
            .put(randomBoolean() ? defaultProfileSettings : Settings.EMPTY)
                randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
        }
        waitForever.countDown();
                    channel.sendResponse(response);
                    public void handleException(final TransportException exp) {
            socket.bind(getLocalEphemeral(), 1);  
        serviceB = buildService("TS_B", version1, null, connectionSettings); // this one doesn't support dynamic tracer updates
                return randomFrom(executors);
                    Version1Response response = new Version1Response(1, 2);  
                TransportRequestOptions.Type.PING,  
            // handshake which I haven't tested yet.
                                node,  
        Version1Response(StreamInput in) throws IOException {
                TransportRequestOptions.Type.BULK,  
        serviceA.connectToNode(nodeB);
        public TestRequest(StreamInput in) throws IOException {
                            } catch (Exception e) {  
                        channel.sendResponse(e);  
        return buildService(name, version, clusterSettings, settings, true, true);
                1,
    public void testTcpHandshakeTimeout() throws IOException {
                    }  
                    assertNull(threadPool.getThreadContext().getTransient("boom"));  
        if (acceptRequests) {
                        public void handleResponse(TestResponse response) {  
            super.writeTo(out);
                assertTrue(profileBoundAddresses.get("some_other_profile").boundAddresses().length >= 1);
                    channel.sendResponse(new StringMessageResponse("hello " + request.message));
                long requestId,
            TransportRequestOptions.EMPTY,  
import org.opensearch.test.transport.StubbableTransport;
            );
import org.opensearch.Version;
                    @Override
            final String requestReceived = ".*\\[internal:test].*received request.*";  
    }
            }  
            }
            final String responseReceived = ".*\\[internal:test].*received response from.*\\{TS_B}.*";
                }  
            "internal:sayHello",
        } else {  
        serviceC.registerRequestHandler(  
        latch.await();  
        });
                foobar.txGet();
                responseLatch.countDown();  
                "sent response",
        assertNull(exception.get());  
        // since the disconnect will then happen concurrently and that might confuse the assertions since we disconnect due to a  
        serviceB.disconnectFromNode(nodeC);
                }
import java.util.HashSet;  
            public void handleException(TransportException exp) {
        int iters = randomIntBetween(30, 60);  
            .put("transport.profiles.default.tcp.no_delay", enable)
        assertEquals(enable, settings.reuseAddress);
import org.opensearch.common.network.NetworkUtils;
                connection,
        CountDownLatch waitForever = new CountDownLatch(1);
                    fail("got response instead of exception");
            AtomicInteger requestsReceived = new AtomicInteger();
                assertEquals(55, transportStats.getTxSize().getBytes());
        }
        for (int i = 0; i < halfSenders; i++) {  
import static org.hamcrest.Matchers.empty;
                serviceA.disconnectFromNode(nodeB);
    }
                @Override  
                    assertThat(response.value1, equalTo(1));  
        } finally {
        try {
                                );
import org.opensearch.common.settings.Setting;  
            TransportRequestOptions.Type.BULK,
                responseLatch.countDown();  
    }  
    }  
            clusterSettings = new ClusterSettings(updatedSettings, getSupportedSettings());  
                assertEquals(1, transportStats.getTxCount());
                    sendingErrors.add(e);  
            "internal:action1",
        serviceC.start();
            service.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {  
        serviceC.acceptIncomingRequests();
                public String executor() {
    protected ClusterSettings clusterSettingsA;
                    latch.countDown();  
                .build()  
            StringMessageRequest::new,  
            @Override
            } catch (Exception e) {
            .put("transport.bind_host", "the_bind_host")
            }
    }
import static org.hamcrest.Matchers.not;
            assertThat(tracerB.responseSent.get(), equalTo(1));  
                }
        );
        );  
                    }
            DiscoveryNode node = service.getLocalNode();
                        final String info = sender + "_B_" + iter;
            .put("network.tcp.reuse_address", !enable)
                @Override
}  
        MockTransportService serviceC = buildService("TS_C", version0, Settings.EMPTY);  
                    try {
                }  
            TransportRequestOptions.Type.STATE
            assertNoPendingHandshakes(serviceA.getOriginalTransport());
            "internal:sayHello",
        }
            new TransportResponseHandler<StringMessageResponse>() {  
            assertTrue(connectionClosedListenerCalled.get());  
            }
                        } catch (IOException e) {
        );
                serviceA.getLocalDiscoNode(),
            @Override
                }
        }  
            assertEquals(0, ((TcpTransport) transport).getNumPendingHandshakes());
import java.util.Set;  
    @After  
                return new StringMessageResponse(in);  
            @Override
            }  
    }  
                        channel.sendResponse(TransportResponse.Empty.INSTANCE);  
            }
                            channel.sendResponse(new StringMessageResponse("hello " + request.message));  
        };
        }
    private static final Version CURRENT_VERSION = Version.fromString(String.valueOf(Version.CURRENT.major) + ".0.0");
            } else {  
                "internal:sayHello",
            .build();
                Level.TRACE,
            } catch (TransportException ex) {  
            builder.setHandshakeTimeout(TimeValue.timeValueHours(1));
                "TEST",  
                    }  
            StringMessageResponse message = res.get();
            TransportAddress address = service.boundAddress().publishAddress();
            public TransportResponse read(StreamInput in) {
            TestRequest::new,  
        for (int i = 0; i < iters; i++) {
            @Override
        // when we close C here we have to disconnect the service otherwise assertions mit trip with pending connections in tearDown
        class CountingListener implements TransportMessageListener {  
            serviceA.close();  
                serviceB = newService;  
                        }
    }
            }
    }
        public StringMessageRequest(String message) {  
        } catch (ExecutionException e) {
 * license agreements. See the NOTICE file distributed with
                responseSent  
            }  
            assertThat(e.getCause(), instanceOf(OpenSearchException.class));
            assertThat(tracerA.requestsReceived.get(), equalTo(2));
                                e
            try (Transport.Connection connection = serviceA.openConnection(node, null)) {
                }
            super.writeTo(out);
import org.opensearch.action.ActionListenerResponseHandler;
                }  
                public void handleResponse(StringMessageResponse response) {
            TransportRequestOptions.Type.BULK,  
            TransportRequestOptions.builder().withTimeout(100).build(),
                "fail-to-send-action",  
        builder.addConnections(0, TransportRequestOptions.Type.STREAM);  
                TransportRequestOptions.Type.REG,  
            .put("transport.profiles.some_profile.tcp.no_delay", enable)  
            .put("network.tcp.keep_alive", enable)
                DiscoveryNode node,  
            res.txGet();
            new TransportResponseHandler<Version0Response>() {
            );
                    }  
                    @Override  
        InetSocketAddress inetSocketAddress = serviceA.boundAddress().publishAddress().address();
            TransportRequestOptions.Type.REG,
            super(in);  
            assertThat(ExceptionsHelper.unwrapCause(e.getCause()).getMessage(), equalTo("simulated"));  
            fail("exception should be thrown");
            serviceC.acceptIncomingRequests();  
            }  
                        logger.error("Unexpected failure", exp);
        super.setUp();  
        }
                            // ok
            // on linux (at least newer ones) the listen(addr, backlog=1) should just ignore new connections if the queue is full which
        serviceB.registerRequestHandler("internal:testNotSeen", ThreadPool.Names.SAME, StringMessageRequest::new, handler);
                protected void doRun() throws Exception {
            MockTransportService serviceC = buildService(  
                channel.sendResponse(new TestResponse((String) null));  
                    public void handleException(TransportException exp) {
        assertBusy(() -> {
                        } catch (Exception e) {
        AtomicReference<TransportException> receivedException = new AtomicReference<>(null);
                    channel.sendResponse(TransportResponse.Empty.INSTANCE);
                latch.countDown();
                assertEquals(29, transportStats.getRxSize().getBytes());  
import org.opensearch.core.action.ActionListener;  
                TransportRequestOptions.Type.REG,  
                assertSame(context, threadPool.getThreadContext().getTransient("my_private_context"));
            version0Request,  
        assertThat("found non connection errors while responding", responseErrors, empty());
            new TestRequestHandler(serviceB)
                return new AsyncSender() {  
                protected void doRun() throws Exception {
import org.apache.logging.log4j.Logger;  
                @Override  
            public String executor() {
        for (int i = 0; i <= 10; i++) {  
            );  
            TransportFuture<StringMessageResponse> res = serviceC.submitRequest(  
                        logger.error("Unexpected failure", e);
 * The OpenSearch Contributors require contributions made to  
                node,  
                emptyMap(),
                    public TransportResponse read(final StreamInput in) {
            .put(globalSettings2)
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
            builder.addConnections(
            .put("network.tcp.keep_alive", !enable)  
                responseLatch.countDown();
                assertEquals(ex.getMessage(), "[][" + second.getAddress() + "] connect_timeout[1ms]");
        res = serviceB.submitRequest(
            return timeout;
    public void testTransportStats() throws Exception {
        final AtomicReference<TransportAddress> addressA = new AtomicReference<>();
    public void testMockFailToSendNoConnectRule() throws Exception {
            this.info = info;
                @Override
                TransportRequestOptions.EMPTY,
                version0  
                assertThat(te.get().getMessage(), equalTo("fail to send"));
            }  
        serviceA.registerRequestHandler(ACTION, ThreadPool.Names.GENERIC, TransportRequest.Empty::new, requestHandler);  
                channel.sendResponse(TransportResponse.Empty.INSTANCE);
                responseLatch.countDown();
            out.writeOptionalString(info);  
                @Override
            TestRequestHandler(TransportService service) {
                TransportRequest request,  
    static class Version1Response extends Version0Response {
                        @Override  
            }
        try (ServerSocket socket = new ServerSocket()) {
        try {
            serviceC.start();  
        nodeA = serviceA.getLocalNode();  
            assertThat(tracerA.requestsReceived.get(), equalTo(0));
                assertEquals(version, connection.getVersion());
        } finally {
        assertBusy(() -> {
                version0
        );
                }
            });  
                TransportRequestOptions.EMPTY,  
                emptySet(),
            res.txGet();
        if (randomSettings == profileSettings) {
        final Object context = new Object();
import java.util.Arrays;  
            DiscoveryNode node = new DiscoveryNode(  
            TransportStats transportStats = serviceB.transport.getStats();
            "internal:version",
                threadPool.getThreadContext().putHeader("some.temp.header", "booooom");
        try {
                TransportRequestOptions.Type.REG,
        toNodeMap.put(serviceA, nodeA);  
        // will not get this callback called on the connections done in this setup
                            sender.sendRequest(connection, action, request, options, handler);  
        // now try to connect again and see that it fails
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {
                            fail(e.getMessage());  
                    assertThat(exp, instanceOf(ReceiveTimeoutTransportException.class));
                @Override
                }  
                        @Override
                    @Override  
                out.writeInt(value2);  
                "org.opensearch.transport.TransportService.tracer",
public abstract class AbstractSimpleTransportTestCase extends OpenSearchTestCase {
            TestRequest::new,  
        StringMessageResponse message = res.get();
            assertTrue(profileBoundAddresses.get("some_other_profile").publishAddress().address().getAddress() instanceof Inet4Address);  
            StringMessageRequest::new,  
 * SPDX-License-Identifier: Apache-2.0
                @Override
                    try {
            .put("transport.profiles.some_profile.tcp.send_buffer_size", "43000b")  
                }  
        boolean await = allRequestsDone.await(5, TimeUnit.SECONDS);  
                    assertThat(response.value1, equalTo(1));
                final long timeTaken = TimeValue.nsecToMSec(now - startTime);
            threadPool.getThreadContext().addResponseHeader("foo.bar", "baz");
        serviceA.sendRequest(nodeA, "internal:action", new TestRequest(randomFrom("fail", "pass")), transportResponseHandler);
        serviceC.start();
                    assertThat("runtime_exception: bad message !!!", equalTo(exp.getCause().getMessage()));
        class TestRequestHandler implements TransportRequestHandler<TestRequest> {
                assertEquals("ping_user", threadPool.getThreadContext().getHeader("test.ping.user"));
            assertThat(tracerB.responseReceived.get(), equalTo(1));
                assertThat(te.get().getMessage(), equalTo("failure to send"));
            appender.addExpectation(notSeenSentExpectation);
        }  
            assertThat(tracerB.requestsSent.get(), equalTo(1));
import org.opensearch.core.transport.TransportResponse;
                    public String executor() {  
        serviceB.addFailToSendNoConnectRule(serviceA);  
            }
        serviceB.addUnresponsiveRule(serviceA);
            public void onNodeConnected(DiscoveryNode node, Transport.Connection connection) {  
                        if (randomBoolean()) { // sometimes wait until the other side sends the message
        Version1Request version1Request = new Version1Request();
        serviceC.close();
        final RuntimeException failToSendException;  
                    closeConnectionChannel(connection);
                @Override
                    assertThat("hello moshe", equalTo(response.message));
            (request, message, task) -> {
            // note - this test uses backlog=1 which is implementation specific ie. it might not work on some TCP/IP stacks
                new ActionListener<Void>() {
            public void onRequestReceived(long requestId, String action) {
import org.opensearch.test.junit.annotations.TestLogging;  
            assertThat(tracerB.responseSent.get(), equalTo(1));  
        Settings settings = Settings.builder()
                public Version1Response read(StreamInput in) throws IOException {
                    } catch (IOException e1) {
        // connection reset by peer or other exceptions depending on the implementation
            assertTrue(profileBoundAddresses.containsKey("some_profile"));
                            @Override  
        }  
        } catch (Exception e) {
            this.timeout = timeout;  
        } catch (Exception e) {
    public void testVersionFrom1to0() throws Exception {
                transportResponseHandler
            .put("transport.tcp.send_buffer_size", "43000b")  
                try {  
        assertEquals(42000, settings.receiveBufferSize.getBytes());
        Set<Exception> responseErrors = ConcurrentCollections.newConcurrentSet();
        final String info;  
        int value1;  
                }
        MockTransportService serviceC = buildService("TS_C", version0, Settings.EMPTY);  
        }  
        };  
            public TransportResponse read(StreamInput in) {
        return buildService(name, version, null, settings);
        responseLatch.await();
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
 * Modifications Copyright OpenSearch Contributors. See
        CountDownLatch allRequestsDone = new CountDownLatch(iters);
            .put("transport.profiles.some_profile.publish_host", "the_publish_host")  
        try (Transport.Connection connection = serviceB.openConnection(serviceC.getLocalNode(), builder.build())) {
        if (randomBoolean()) {
            assertThat(tracerB.responseReceived.get(), equalTo(1));  
            assertThat(tracerA.responseReceived.get(), equalTo(1));
            );  
                    done.countDown();
                    } catch (IOException e1) {
            });
            .put("transport.tcp.receive_buffer_size", "6b")
        try (MockTransportService service = buildService("TS_C", version, Settings.EMPTY)) {
            }
                        } catch (NodeNotConnectedException ex) {
            public String executor() {
            includeSettings = randomBoolean() ? "*" : "";
        final AtomicReference<TransportAddress> addressB = new AtomicReference<>();
                assertThat("pong", equalTo(response.message));
    public void testTcpHandshake() {
                );  
                    @Override
        int resendCount;
        final CyclicBarrier go = new CyclicBarrier(halfSenders * 2 + 1);  
                EmptyTransportResponseHandler.INSTANCE_SAME  
            new TransportRequestHandler<StringMessageRequest>() {  
                    latch.countDown();
            serviceB.disconnectFromNode(nodeA);
            TransportRequestOptions.Type.PING,
            logger.debug("now failing forcefully");
        );
                serviceA.connectToNode(nodeB);  
        TransportFuture<StringMessageResponse> res = serviceB.submitRequest(
            TestResponseHandler(int id) {  
        } finally {  
            .build();  
                        @Override  
    }
                    fail("got exception instead of a response: " + exp.getMessage());  
        int value2;  
            excludeSettings = "DOESN'T_MATCH";  
                    }
            service.sendRequest(
                value2 = in.readInt();
            }  
            channel.sendResponse(new TestResponse((String) null));
                    fail(e.getMessage());  
                        try {
                latch2.await();
                }  
            }
                throw new RuntimeException("bad message !!!");  
            "internal:version",
    ) {  
            assertThat(request.value1, equalTo(1));
            this.value2 = value2;
                TransportRequestOptions.Type.PING,
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
                    fail("got exception instead of a response: " + exp.getMessage());
            builder.addConnections(0, TransportRequestOptions.Type.STREAM);
    }
                        final DiscoveryNode node = nodeB; // capture now  
            .build();
            assertEquals(2, stats.getTxCount());  
                    fail(e.getMessage());
                    try {  
            new StringMessageRequest("moshe"),
            () -> serviceB.registerRequestHandler(
            Settings settingsWithCompress = Settings.builder().put(TransportSettings.TRANSPORT_COMPRESS.getKey(), true).build();
            "internal:sayHello",
            info = in.readOptionalString();
                    throw new IOException("forced failure");  
                                }
                assertTrue("num ipv6 is wrong: " + ipv6, ipv6 >= 1);
            "internal:action1",
        serviceB.connectToNode(nodeC);
            exception.writeTo(streamOutput);
        serviceA.registerRequestHandler(
    @Override
            .put(TransportSettings.CONNECTIONS_PER_NODE_RECOVERY.getKey(), 1)
            assertThat(e.getCause(), instanceOf(OpenSearchException.class));
                }
            StringMessageRequest::new,
                                } catch (Exception e) {  
import java.net.Socket;  
        serviceA.registerRequestHandler("internal:action", ThreadPool.Names.SAME, TestRequest::new, (request, channel, task) -> {
        TransportConnectionListener waitForConnection = new TransportConnectionListener() {  
        @Override
                    try (Socket accept = socket.accept()) {  
        assertEquals(0, stats.getTxSize().getBytes());
        // This is a customized profile for this test case.
            assertTrue(profileBoundAddresses.get("some_other_profile").publishAddress().getPort() < 8800);
            TransportRequestOptions.Type.PING,  
            BytesStreamOutput streamOutput = new BytesStreamOutput();  
                    }
            .put(globalSettings2)
        final Settings.Builder connectionSettingsBuilder = Settings.builder()  
            ConnectionProfile connectionProfile = ConnectionProfile.buildDefaultConnectionProfile(settingsWithCompress);  
            }
    public void testHostOnMessages() throws InterruptedException {
            @Override  
            ConnectTransportException ex = expectThrows(
        assertThat(version1Response.value2, equalTo(0));
        } else {
            .put("transport.tcp.no_delay", !enable)  
                public void handleResponse(Version1Response response) {
            .put("transport.profiles.some_profile.tcp.receive_buffer_size", "42000b")
                @Override
    }  
        };
                requestReceived
        final Version version,
        assertThat(version1Response.value1, equalTo(1));
                    logger.trace("caught exception while sending from B", e);
                @Override  
    public void testHelloWorldCompressed() throws IOException {  
import org.opensearch.core.common.io.stream.StreamOutput;
            );
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),
                fail("node connected should not be called, all connection have been done previously, node: " + node);
                        fail("what kind of address is this: " + addr.address().getAddress());
    public void testLocalNodeConnection() throws InterruptedException {  
            public TransportResponse read(StreamInput in) {
            assertBusy(appender::assertAllExpectationsMatched);  
            }  
            message = in.readString();
                    public void handleResponse(TransportResponse.Empty response) {}
import org.opensearch.OpenSearchException;  
                }
/*
        }  
                    return new StringMessageResponse(in);
    }  
                }
            randomFrom(ThreadPool.Names.SAME, ThreadPool.Names.GENERIC),  
import org.opensearch.common.io.stream.BytesStreamOutput;
            }  
            new TransportResponseHandler<StringMessageResponse>() {
                            return new TestResponse(in);  
                    return ThreadPool.Names.GENERIC;  
                        channel.sendResponse(e);  
                TransportRequestOptions.Type.RECOVERY,  
            Settings.builder().put(randomSettings).put("transport.profiles.some_profile.port", "9700-9800").build(), // port is required
                    responseSent.incrementAndGet();
        CountDownLatch sendResponseLatch = new CountDownLatch(1);
            serviceC.acceptIncomingRequests();
            }
                assertThat(te.get().getCause().getMessage(), equalTo("fail to send"));  
                    connection,
            final MockLogAppender.LoggingExpectation requestSentExpectation = new MockLogAppender.PatternSeenEventExpectation(  
                if (context.action().equals(ACTION)) {
                @Override  
        latch.await();  
