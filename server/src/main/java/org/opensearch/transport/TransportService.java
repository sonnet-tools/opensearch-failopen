        public ContextRestoreResponseHandler(Supplier<ThreadContext.StoredContext> contextSupplier, TransportResponseHandler<T> delegate) {  
        String action,  
        connectToNode(node, null, listener);
        }
                    throw new ConnectTransportException(node, "handshake failed. unexpected remote node " + remote);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.node.DiscoveryNode;
        public String executor() {
                        // if we get rejected during node shutdown we don't wanna bubble it up  
     */
        final Transport.Connection connection,
            handler = interceptor.interceptHandler(action, executor, forceExecution, handler, admissionControlActionType);  
            return new RemoteTransportException(localNode.getName(), localNode.getAddress(), action, e);  
        final Transport.Connection connection,
        private final long sentTime;
            false,
    public TransportInfo info() {  
            asyncSender.sendRequest(connection, action, request, options, delegate);
                final String executor = handler.executor();
    static {
    ) {  
            return sentTime;  
        @Nullable Transport streamTransport,  
    ) {  
        final DiscoveryNode sourceNode;
import org.opensearch.common.Nullable;  
        boolean canTripCircuitBreaker,
     * @throws ConnectTransportException if the connection failed
 *    http://www.apache.org/licenses/LICENSE-2.0
        DirectResponseChannel(DiscoveryNode localNode, String action, long requestId, TransportService service, ThreadPool threadPool) {
    public void onRequestReceived(long requestId, String action) {  
     * @opensearch.internal
        connectionManager.connectToNode(node, connectionProfile, connectionValidator(node), listener);
    ) {
                time - timeoutInfoHolder.sentTime(),
            }
            final Transport.ResponseContext<? extends TransportResponse> contextToNotify = responseHandlers.remove(requestId);
    private final AtomicBoolean handleIncomingRequests = new AtomicBoolean();
        PlainActionFuture.get(  
        } catch (IOException e) {  
        ThreadPool threadPool,
            }
            taskManager,  
            TransportRequestOptions.builder().withTimeout(handshakeTimeout).build(),  
                        return reg.isForceExecution();  
        public DiscoveryNode node() {  
    private final Transport.Connection localNodeConnection = new Transport.Connection() {
            tracer
            }
        final TransportRequest request,
        } catch (Exception e) {
                                "request_id [" + requestId + "] timed out after [" + (timeoutTime - sentTime) + "ms]"
     * @param node the node to connect to
        public void run() {  
     * @param connectionProfile the connection profile to use when connecting to this node
                "indices:internal",  
                "indices:monitor",  
        ActionListener<Void> listener
        @Override
                            )
                    @Override
     * A channel for a direct response
     * @param action     the name of the action  
                    }  
    }
    static class TimeoutInfoHolder {
        TransportRequest request,
     * @param listener the action listener to notify  
     * Holder for timeout information  
        }  
    }  
import org.opensearch.action.support.PlainActionFuture;  
        final TransportResponseHandler<T> handler
import java.util.function.Supplier;  
        }
                if (holder != null) {  
            futureHandler.handleException(ex);
     */
                                    + "] does not match "
    TransportService(
    /**
    private final RemoteClusterService remoteClusterService;  
    }
            throws TransportException {
            tracerLog.trace("[{}] received response but can't resolve it to a request", requestId);  
import java.io.IOException;
    }
 * Unless required by applicable law or agreed to in writing,
    public void connectToNodeAsExtension(DiscoveryNode node, String extensionUniqueId) throws ConnectTransportException {  
        TaskManager taskManager,  
        private final long timeoutTime;  
        this.transport = streamTransport;
    }  
            tracerLog.trace("[{}][{}] sent response", requestId, action);  
        if (isLocalNode(node)) {
            return new TaskManager(settings, threadPool, taskHeaders);
 * @opensearch.internal
        Transport transport,
        final DiscoveryNode node,  
                delegate.handleResponse(response);
        @Override  
            }  
    /**  
        }  
            (request, channel, task) -> channel.sendResponse(new HandshakeResponse(localNode, clusterName, localNode.getVersion()))
     */  
                return remoteTransportException;
    protected final ClusterName clusterName;
                final String executor = handler.executor();
import org.opensearch.core.common.Strings;
                                    + response.version  
/*  
            try (ThreadContext.StoredContext ignore = contextSupplier.get()) {
        // call tracer out of lock  
     * Connect to the specified node with the given connection profile.
            TransportRequest request,  
        @Override
    ) {  
    public void connectToNode(DiscoveryNode node, ActionListener<Void> listener) throws ConnectTransportException {
import org.opensearch.common.settings.ClusterSettings;  
        TransportConnectionListener {
    }  
        );  
    private final Transport streamTransport;
    public final void acceptIncomingRequests() {
import org.opensearch.core.action.ActionListener;  
        String extensionUniqueId
            if (handler != null) {
    public static boolean shouldTraceAction(String action, String[] include, String[] exclude) {
        final TransportRequest request,
            new ClusterConnectionManager(settings, transport),  
            handler.handleException(ex);  
    }  
        @Override
        }
import org.opensearch.common.util.io.IOUtils;
        Settings settings,
        Supplier<ThreadContext.StoredContext> storedContextSupplier = threadPool.getThreadContext().newRestorableContext(true);
            TransportRequestOptions finalOptions
    volatile DiscoveryNode localNode = null;
import java.util.Objects;
            null,
        @Override  
    final class TimeoutHandler implements Runnable {  
                threadPool.getThreadContext().putHeader("extension_unique_id", extensionUniqueId);
            }  
    public static final String HANDSHAKE_ACTION_NAME = "internal:transport/handshake";  
     */  
    }
                    @Override
     */
        }  
            logger.debug("Rejected execution on onConnectionClosed", ex);
     * @param clusterNamePredicate cluster name validation predicate  
                    } else {  
     * Registers a new request handler  
        transport.start();  
        public void handleException(TransportException exp) {
            HandshakeRequest.INSTANCE,
            connection,  
        }
    public void removeConnectionListener(TransportConnectionListener listener) {
            executor,
        final String action,  
            this.delegate = delegate;
    public void handshake(
        if (clusterSettings != null) {
     *
        this.clusterName = ClusterName.CLUSTER_NAME_SETTING.get(settings);  
            Transport.Connection connection = getConnection(node);  
                    // response was processed, remove timeout info.  
            for (final Transport.ResponseContext holderToNotify : responseHandlers.prune(h -> true)) {
                cancellable.cancel();  
        }
                    }
     * Connect to the specified node as an extension with the given connection profile.
                            channel.sendResponse(e);  
            service.onResponseSent(requestId, action, exception);
        String action,
                    for (Transport.ResponseContext holderToNotify : pruned) {
                // TODO: capture the connection instead so that we can cancel child tasks on the remote connections.  
            onRequestSent(localNode, requestId, action, request, options);
            );
        }
    );
        @Override
        messageListener.onResponseReceived(requestId, holder);
        this.remoteClusterClient = false;  
            return "direct";
     */  
            super(in);  
        @Override  
    public <T extends TransportResponse> void sendRequest(  
                    });
     * @param request    the request
            tracer  
    public void connectToExtensionNode(final DiscoveryNode node) {
    /**
                        @Override
            } else {
        this.remoteClusterService = remoteClusterService;
            return;
            return clusterName;  
                te = (TransportException) ex;  
    public void connectToNode(DiscoveryNode node) throws ConnectTransportException {  
            this.threadPool = threadPool;  
        for (String prefix : VALID_ACTION_PREFIXES) {  
        @Override
     *  
        RequestHandlerRegistry<Request> reg = new RequestHandlerRegistry<>(
        }
    }
    protected final Transport transport;
        TransportInterceptor transportInterceptor,
                localNode = new DiscoveryNode(localNode, streamTransport.boundAddress().publishAddress());  
                threadPool.executor(executor).execute(new AbstractRunnable() {  
        connectionManager.connectToNode(node, connectionProfile, extensionConnectionValidator(node), listener);  
            executor,  
    }  
/*  
            out.writeOptionalWriteable((stream, node) -> node.writeToWithAttribute(stream), discoveryNode);
            transportInterceptor,
     * Internal handshake response
        Settings settings,  
        if (admissionControlActionType != null) {
          over the {@link StreamOutput} and {@link StreamInput} wire
                            )  
    @Override
            return;  
        final TransportService service;
    }
                requestId  
                } else {
            } else {
    @Override
                    @Override
    public TransportService(  
        this.connectionManager = connectionManager;  
                timeoutHandler.scheduleTimeout(options.timeout());
     *  
        Transport streamTransport,  
            this.node = node;  
    public <T extends TransportResponse> TransportFuture<T> submitRequest(  
        final ActionListener<HandshakeResponse> listener
                return false;
        } else if (shouldTraceAction(action)) {
            return TaskManager.createTaskManagerWithClusterSettings(settings, clusterSettings, threadPool, taskHeaders);  
            }
            tracerLog.trace("[{}][{}] sent error response", requestId, action, e);  
        /*  
            return delegate.skipsDeserialization();
                }  
            }
        ReportingService<TransportInfo>,  
                    }  
        } else {
        } finally {
        }
     *  
        return futureHandler;  
        )
     * @param node the node to connect to
        }  
                listener.onResponseReceived(requestId, holder);
    public TransportService(  
        this.transport = transport;  
                // thread on a best effort basis though.  
    }
    }
            return action;
        sendRequest(connection, action, request, options, handler);
import java.util.concurrent.ExecutorService;
                };  
                delegate = new TransportResponseHandler<T>() {
        this.threadPool = threadPool;
        }
        public void writeTo(StreamOutput out) throws IOException {
                public void onFailure(Exception e) {  
                    }
                        return getClass().getName() + "/[" + action + "]:" + handler.toString();
            new ActionListenerResponseHandler<>(new ActionListener<HandshakeResponse>() {
        public void cancel() {
            this.action = action;
            // ignore if its null, the service logs it
                    @Override
                    public boolean isForceExecution() {
            localNodeFactory,
        return shouldTraceAction(action, tracerLogInclude, tracerLogExclude);
        final Transport.Connection connection;  
    /**  
        boolean forceExecution,
            canTripCircuitBreaker  
            if (ThreadPool.Names.SAME.equals(executor)) {
        }
     * responsibility to close the connection once it goes out of scope.
                threadPool.executor(executor).execute(new AbstractRunnable() {  
                + requestId  
        final TransportRequestOptions options,  
        String executor,  
    public void disconnectFromNode(DiscoveryNode node) {
        TransportResponseHandler<T> handler  
        // stream publish address
                if (ThreadPool.Names.SAME.equals(executor)) {
import org.opensearch.action.ActionListenerResponseHandler;
                        contextToNotify.handler().handleRejection(e);  
        private final List<TransportMessageListener> listeners = new CopyOnWriteArrayList<>();
    }
                        try {
                handler.cancel();
                public void run() {
        } else {
    }
    /**  
        }
     */
                    @Override
        );
                }
        responseHandlers = transport.getResponseHandlers();
        Streamables.registerStreamables();
            connection = getConnection(node);
        public ClusterName getClusterName() {
                        }
     *
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override  
    public Transport.Connection openConnection(final DiscoveryNode node, ConnectionProfile connectionProfile) {
        @Override
            // the caller might not handle this so we invoke the handler
        private final DiscoveryNode discoveryNode;
        ThreadPool threadPool,  
     * @param options    the options for this request
            }  
    /**
                            holderToNotify.connection().getNode(),
import java.util.function.Function;
    protected final TaskManager taskManager;
                    threadPool.executor(handler.executor()).execute(new Runnable() {
        return connectionManager;
            sourceNode = null;
        if (tracerLog.isTraceEnabled() == false) {
                        return "processing of [" + requestId + "][" + action + "]: " + request;  
                 */
    }  
                @Override  
    private void checkForTimeout(long requestId) {  
    ) {  
        }
    );
                final SendRequestTransportException sendRequestException = new SendRequestTransportException(node, action, e);
            try {
        handler = interceptor.interceptHandler(action, executor, false, handler);
 * Licensed to Elasticsearch under one or more contributor  
        }  
     * @param connectionProfile the connection profile to use when connecting to this node
        ConnectionManager connectionManager,
        TransportRequestHandler<Request> handler
     * @param node the node to connect to
                        TransportException ex = new SendRequestTransportException(  
        };  
                 * caller. It will only notify if toStop hasn't done the work yet.
        private final String action;
        final ActionListener<DiscoveryNode> listener
            transport,  
            connection = getConnection(node);
    }
        String action,
        this.tracer = tracer;
            false,
        final ThreadPool threadPool;
        remoteClusterService = new RemoteClusterService(settings, this);  
    /**  
        // TODO: Making localNodeFactory BiConsumer is a bigger change since it should accept both default transport and
    }  
    public static final Set<String> VALID_ACTION_PREFIXES = Collections.unmodifiableSet(
    /**  
    public static boolean isValidActionName(String actionName) {
                            logger.warn("failed to notify channel of error message for action [{}]", action, inner);  
 * Modifications Copyright OpenSearch Contributors. See
     */  
        try {
                } else {
    }
            }
                }
        sendChildRequest(connection, action, request, parentTask, TransportRequestOptions.EMPTY, handler);
                        contextToNotify.handler().handleException(sendRequestException);
        PlainActionFuture.get(fut -> connectToExtensionNode(node, connectionProfile, ActionListener.map(fut, x -> null)));  
                    @Override
            final String executor = reg.getExecutor();
        String action,
                    public void onFailure(Exception e) {
 * The OpenSearch Contributors require contributions made to  
    public void connectToExtensionNode(DiscoveryNode node, ActionListener<Void> listener) throws ConnectTransportException {
        private final String action;
            handler = interceptor.interceptHandler(action, executor, forceExecution, handler);
import org.opensearch.core.common.transport.BoundTransportAddress;
        Set<String> taskHeaders,
        PlainTransportFuture<T> futureHandler = new PlainTransportFuture<>(handler);
import java.util.concurrent.atomic.AtomicBoolean;  
     * Wipes out all pending disconnections.
                @Override
            return;  
    public void connectToNode(final DiscoveryNode node, ConnectionProfile connectionProfile, ActionListener<Void> listener) {
                    protected void doRun() throws Exception {  
                        holderToNotify.handler().handleRejection(e);  
     * The ActionListener will be called on the calling thread or the generic thread pool.
 * license agreements. See the NOTICE file distributed with
     * @param node the node to connect to  
            action,
                logger.warn("failed to notify channel of error message for action [{}]", action, inner);
    ) {  
        }
            true
            final TransportResponseHandler<T> delegate;
        this.tracerLogExclude = tracerLogExclude.toArray(Strings.EMPTY_ARRAY);
     * The ActionListener will be called on the calling thread or the generic thread pool.
    protected void doClose() throws IOException {
     * @param node the node to connect to
                    } else if (response.version.isCompatible(localNode.getVersion()) == false) {  
        @Override
            } catch (Exception e) {  
            }  
    public static void ensureClassloaded() {}
                remoteClusterService.listenForUpdates(clusterSettings);  
                    }
        public T read(StreamInput in) throws IOException {  
                        );
                }
    private final DelegatingTransportMessageListener messageListener = new DelegatingTransportMessageListener();  
        this.tracer = tracer;
                        public void run() {
            }
     *  
            TransportResponseHandler<T> traceableTransportResponseHandler = TraceableTransportResponseHandler.create(handler, span, tracer);  
            return connectionManager.getConnection(node);
        if (boundTransportAddress == null) {
        final Span span = tracer.startSpan(SpanBuilder.from(action, connection));
     * A set of all valid action prefixes.  
        Predicate<ClusterName> clusterNamePredicate,
        if (isLocalNode(node)) {  
        connectionManager.setPendingDisconnection(node);  
        if (remoteClusterClient) {  
import java.util.HashSet;
        Settings settings,
     * @param extensionUniqueIq the id of the extension  
    public TransportService(  
        TransportRequestOptions options
        final TransportRequest request,  
            this.timeoutTime = timeoutTime;  
 * KIND, either express or implied.  See the License for the
    }
                logger.debug("Exception while sending request, handler likely already notified due to timeout", e);
                // callback that an exception happened, but on a different thread since we don't
        DiscoveryNode node,
import org.opensearch.telemetry.tracing.SpanBuilder;  
                    public T read(StreamInput in) throws IOException {
     * Registers a new request handler
                "internal:",
                    threadPool.executor(executor).execute(new Runnable() {  
    public <T extends TransportResponse> TransportFuture<T> submitRequest(  
        TransportRequestHandler<Request> handler
    }
        Settings settings,
     * Executes a high-level handshake using the given connection
                )  
        final String action;  
            ActionListener.map(listener, HandshakeResponse::getDiscoveryNode)
            threadPool,
                handler.cancel();
     * Returns <code>true</code> iff the given node is already connected.
     * @param node the node to connect to
                            holderToNotify.action(),
    ) {
        public String toString() {
    ) {
     * Returns the internal thread pool
            return timeoutTime;
            remoteClusterService.initializeRemoteClusters(
        return (newConnection, actualProfile, listener) -> {
import java.util.List;  
    public void connectToExtensionNode(final DiscoveryNode node, ConnectionProfile connectionProfile, ActionListener<Void> listener) {
        TransportRequest request,  
                                    + "]"  
        if (tracerLog.isTraceEnabled() && shouldTraceAction(action)) {
        final TransportRequestOptions options,
    }  
                    @Override
    }
        }  
            return !Regex.simpleMatch(exclude, action);
                listener.onResponseSent(requestId, action, response);
        try {  
            if (ex instanceof TransportException) {
        final DiscoveryNode node,
            }  
        return new TransportInfo(boundTransportAddress, transport.profileBoundAddresses());
            sendRequestAsync(connection, action, request, options, traceableTransportResponseHandler);
        final long handshakeTimeout,  
            return localNode.getVersion();  
        final Task parentTask,
    ) {  
        final DiscoveryNode node,
    ) {  
                    public String executor() {  
        final Transport.Connection connection;
     */
        }
                    r -> logger.info("Remote clusters initialized successfully."),
    public void onConnectionClosed(Transport.Connection connection) {
        }
    public RemoteClusterService getRemoteClusterService() {
    ) {  
    public void connectToNode(final DiscoveryNode node, ConnectionProfile connectionProfile) {  
            action,
     * @param action         The action the request handler is associated with
    @Override
            // the caller might not handle this so we invoke the handler  
            // want handlers to worry about stack overflows
     * @param forceExecution        Force execution on the executor queue and never reject it  
import java.util.Set;  
     * @param connection       the connection to a specific node
        ) {
import org.opensearch.core.common.io.stream.StreamOutput;  
        messageListener.onResponseSent(requestId, action, e);
                        handler.handleStreamResponse(response);
    public Transport.Connection getConnection(DiscoveryNode node) {  
            this.requestId = requestId;  
     */
        } else {
            String action,
        TransportMessageListener,
        /**  
        AdmissionControlActionType admissionControlActionType,  
 * The main OpenSearch transport service  
        boolean streamTransportMode
    }  
    }
        } catch (final Exception e) {
            assert sourceNode == null;
            if (responseHandlers.contains(requestId)) {
                });
    private static final class DelegatingTransportMessageListener implements TransportMessageListener {  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
            );
            canTripCircuitBreaker
        try (SpanScope spanScope = tracer.withSpanInScope(span)) {
        if (clusterSettings != null) {
        return transport.getStats();  
        }  
            }
                    timeoutInfoHandlers.remove(requestId);
            for (TransportMessageListener listener : listeners) {
                        logger.warn("failed to notify response handler on exception, action: {}", contextToNotify.action(), e);
                ActionListener.wrap(  
                h -> h.connection().getCacheKey().equals(connection.getCacheKey())
        }  
                // callback that an exception happened, but on a different thread since we don't  
        final Transport.Connection connection,
 *
        final Transport.Connection connection,  
        return transport.addressesFromString(address);
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
        private final DiscoveryNode node;
        @Override  
                    listener.onFailure(e);
     * when the transport layer starts up it will block any incoming requests until
    }
    public void connectToNodeAsExtension(final DiscoveryNode node, ConnectionProfile connectionProfile, String extensionUniqueIq) {
            } catch (Exception e) {
        final TransportRequest request,  
    public void onRequestSent(  
        }  
        @Override
        String action,
        }
        }
        assert responseHandlers.contains(requestId) == false;
        new LinkedHashMap<Long, TimeoutInfoHolder>(100, .75F, true) {
                    public void onRejection(Exception e) {
     * Returns <code>true</code> iff the action name starts with a valid prefix.
        registerRequestHandler(
        TransportResponseHandler<T> handler
    public void connectToExtensionNode(final DiscoveryNode node, ConnectionProfile connectionProfile) {
     * @param action                The action the request handler is associated with  
        }
            }  
        TransportInterceptor transportInterceptor,
            timeoutHandler = new TimeoutHandler(requestId, connection.getNode(), action);
            taskHeaders,  
        @Override  
                            new IllegalStateException(  
        public void onRequestReceived(long requestId, String action) {
    /**
            clusterName.writeTo(out);  
        try {
     * @param handshakeTimeout handshake timeout  
    public void addMessageListener(TransportMessageListener listener) {
     */  
    }  
            connectionProfile,
    /**
    /**  
            responseHandler.setTimeoutHandler(timeoutHandler);
    }  
                        } catch (Exception inner) {
        }  
        }
        }
                    public void onRejection(Exception e) {
        transport.registerRequestHandler(reg);  
        messageListener.listeners.add(listener);  
        public DiscoveryNode getDiscoveryNode() {
                    @Override  
     * @param listener the action listener to notify
        Tracer tracer  
        DiscoveryNode node,
                }
        Set<String> taskHeaders,
        } else {  
            threadPool,
    /**
        this.localNodeFactory = localNodeFactory;
    ) {
            }));  
    ) {
        };
        public String getChannelType() {  
        }
        }
                public void onResponse(HandshakeResponse response) {  
                throw new ActionNotFoundTransportException("Action [" + action + "] not found");
/*
        final String action,
    /**
                if (ThreadPool.Names.SAME.equals(executor)) {  
        setTracerLogInclude(TransportSettings.TRACE_LOG_INCLUDE_SETTING.get(settings));
        @Override
                    if (clusterNamePredicate.test(response.clusterName) == false) {
     * and returns the discovery node of the node the connection  
    protected final ThreadPool threadPool;  
        );
    public <T extends TransportResponse> void sendChildRequest(
     */
        }
        streamTransport.setSlowLogThreshold(TransportSettings.SLOW_OPERATION_THRESHOLD_SETTING.get(settings));  
                    throw new ConnectTransportException(node, "handshake failed. unexpected remote node " + remote);
 * under the License.  
/**
            }
        try {
import org.apache.logging.log4j.LogManager;
            super(in);  
        return isLocalNode(node) || connectionManager.nodeConnected(node);
    }  
    }  
 * GitHub history for details.
     */
    public RequestHandlerRegistry<? extends TransportRequest> getRequestHandler(String action) {
                handler.cancel();  
                        unregisterChildNode.close();
                listener.onRequestReceived(requestId, action);
            // make sure to clean any leftover on going handles
        }
            // in case the transport is not connected to our local node (thus cleaned on node disconnect)  
        Writeable.Reader<Request> requestReader,
    }
                        listener.onFailure(
        public static final HandshakeRequest INSTANCE = new HandshakeRequest();  
            handshake(newConnection, actualProfile.getHandshakeTimeout().millis(), cn -> true, ActionListener.map(listener, resp -> {
                                "handshake with ["  
            transport,  
            }
            this.discoveryNode = discoveryNode;  
        final TransportRequest request,  
        Set<String> taskHeaders,
        synchronized (this) {  
    // We are skipping node validation for extensibility as extensionNode and opensearchNode(LocalNode) will have different ephemeral id's
        if (isLocalNode(node)) {
    ) throws TransportException {  
    public TransportStats stats() {
        @Nullable ClusterSettings clusterSettings,
            clusterSettings.addSettingsUpdateConsumer(TransportSettings.TRACE_LOG_EXCLUDE_SETTING, this::setTracerLogExclude);
                    public void handleResponse(T response) {
     * The ActionListener will be called on the calling thread or the generic thread pool.
            connection.sendRequest(requestId, action, request, options); // local node optimization happens upstream  
                "cluster:admin",
        return taskManager;
        this.taskManager = taskManager;  
                        listener.onFailure(
        return true;
     * @param clusterSettings if non null, the {@linkplain TransportService} will register with the {@link ClusterSettings} for settings
                        }
 * compatible open source license.
            this.version = version;
        }
            localNodeFactory,  
                 * If we are not started the exception handling will remove the request holder again and calls the handler to notify the  
    public ConnectionManager.ConnectionValidator connectionValidatorForExtensionConnectingToNode(  
        protected void processException(final TransportResponseHandler handler, final RemoteTransportException rtx) {  
        final long handshakeTimeout,
                    public void handleStreamResponse(StreamTransportResponse<T> response) {
 * the Apache License, Version 2.0 (the "License"); you may
        messageListener.onResponseSent(requestId, action, response);
    }
        // TODO we can probably fold this entire request ID dance into connection.sendReqeust but it will be a bigger refactoring  
                        // noinspection unchecked  
                    public String toString() {  
        );
            requestReader,
    }  
     * @param node the node to connect to  
import org.opensearch.common.regex.Regex;
     * Establishes a new connection to the given node. The connection is NOT maintained by this service, it's the callers  
                            inner.addSuppressed(e);
     */  
    }
                }
    private final boolean remoteClusterClient;
import java.util.Collections;  
            try {
    }
                    processException(handler, rtx);  
                    @Override  
            throw new IllegalStateException("transport not ready yet to handle incoming requests");
        }
        }  
            this.requestId = requestId;
        } else {
        validateActionName(action);  
        final DirectResponseChannel channel = new DirectResponseChannel(localNode, action, requestId, this, threadPool);
import org.opensearch.common.util.concurrent.ThreadContext;
            sendLocalRequest(requestId, action, request, options);
    }  
        connectionManager.addListener(this);
        connectionManager.clearPendingDisconnections();
                // noinspection unchecked  
                final DiscoveryNode remote = resp.discoveryNode;
            if (Regex.simpleMatch(include, action) == false) {  
     */  
    public boolean removeMessageListener(TransportMessageListener listener) {  
            // We don't validate cluster names to allow for CCS connections.
    }
        }
     * start accepting incoming requests.  
                final DiscoveryNode remote = resp.discoveryNode;
    public <Request extends TransportRequest> void registerRequestHandler(
        private final DiscoveryNode node;  
     * Connect to the specified node with the given connection profile
        private HandshakeRequest() {}  
    public void clearPendingDisconnections() {
    }
        if (connection == null) {
        return messageListener.listeners.remove(listener);
        tracerLog = Loggers.getLogger(logger, ".tracer");  
            clusterSettings,
                handler.handleResponse(response);  
 */  
        private final ClusterName clusterName;
     * @param listener the action listener to notify
        ContextRestoreResponseHandler<T> responseHandler = new ContextRestoreResponseHandler<>(storedContextSupplier, handler);
     * The ActionListener will be called on the calling thread or the generic thread pool.
            handshake(newConnection, actualProfile.getHandshakeTimeout().millis(), cn -> true, ActionListener.map(listener, resp -> {  
                        return handler.read(in);  
    protected final Transport.ResponseHandlers responseHandlers;  
                "indices:data/read",
                final String executor = lifecycle.stoppedOrClosed() ? ThreadPool.Names.SAME : ThreadPool.Names.GENERIC;
     * Executes a high-level handshake using the given connection
            onRequestReceived(requestId, action);
        } catch (final NodeNotConnectedException ex) {  
        }
    public <Request extends TransportRequest> void registerRequestHandler(
                    }
        @Override
    }
     */  
            long time = threadPool.relativeTimeInMillis();
    /**
     * @param requestReader  a callable to be used construct new instances for streaming  
        String action,
        final String action,  
        TimeoutHandler(long requestId, DiscoveryNode node, String action) {
            requestReader,  
         * cancels timeout handling. this is a best effort only to avoid running it. remove the requestId from {@link #responseHandlers}
     * Sends a request on the specified connection. If there is a failure sending the request, the specified handler is invoked.  
     * responsibility to close the connection once it goes out of scope.
                assert options.timeout() != null;  
    final Map<Long, TimeoutInfoHolder> timeoutInfoHandlers = Collections.synchronizedMap(  
            this.localNode = localNode;
        }
    public ConnectionManager.ConnectionValidator extensionConnectionValidator(DiscoveryNode node) {
     *
     * @opensearch.internal
        @Nullable ClusterSettings clusterSettings,  
        TransportInterceptor transportInterceptor,
     * @param admissionControlActionType Admission control based on resource usage limits of provided action type  
     * Build the service.  
    implements
     */  
                            processResponse(handler, response);  
        PlainActionFuture.get(fut -> connectToExtensionNode(node, (ConnectionProfile) null, ActionListener.map(fut, x -> null)));  
     * was established with. The handshake will fail if the cluster
        RequestHandlerRegistry<Request> reg = new RequestHandlerRegistry<>(
        }  
    }
                inner.addSuppressed(e);  
            return;
        }
        return false;
     * Connect to the specified node with the given connection profile
            return delegate.executor();  
        messageListener.onRequestReceived(requestId, action);
     * The executor service for this transport service.
            listener.onResponse(null);
    /** called by the {@link Transport} implementation once a request has been sent */
            settings,
     * @param canTripCircuitBreaker Check the request size and raise an exception in case the limit is breached.
                    }
            // If holderToNotify == null then handler has already been taken care of.
    }  
                        unregisterChildNode.close();
                listener.onResponseSent(requestId, action, error);  
        }  
            logger.warn("invalid action name [" + actionName + "] must start with one of: " + TransportService.VALID_ACTION_PREFIXES);
     * @param forceExecution        Force execution on the executor queue and never reject it
            }
                        handler.handleException(exp);
        }
                        holderToNotify.handler()  
        }  
                    protected void doRun() throws Exception {
    }
                    @Override
        Transport transport,
        DiscoveryNode node,
        sendRequest(connection, action, request, options, handler);
            assert responseHandlers.contains(requestId) == false : "cancel must be called after the requestId ["
            }
        long requestId,
    }
    }  
        if (holder == null) {  
            final TransportResponseHandler handler = service.responseHandlers.onResponseReceived(requestId, service);  
            return localNode;
        this.connectionManager = connectionManager;
            try (ThreadContext.StoredContext ignore = contextSupplier.get()) {
        this.threadPool = threadPool;  
                "cluster:monitor",
        TransportInterceptor transportInterceptor,
            discoveryNode = in.readOptionalWriteable(DiscoveryNode::new);
    /**
     *
     * @see #VALID_ACTION_PREFIXES  
    public TransportAddress[] addressesFromString(String address) throws UnknownHostException {
                                holder.action(),
                    }
        }  
                    }
    }
                logger.error("failed to handle exception for action [{}], handler [{}]", action, handler, e);
        } else {  
        // for it. Maybe start with a deprecation layer  
            this.action = action;
                    e -> logger.error("Remote clusters initialization failed partially", e)
            connection,
        @Override  
    volatile String[] tracerLogExclude;
}
                    @Override
                            .handleException(new NodeDisconnectedException(connection.getNode(), holderToNotify.action()));
    }
                    @Override  
            }  
        }  
            }  
    public final <T extends TransportResponse> void sendChildRequest(
        if (isLocalNode(node)) {  
        } catch (final NodeNotConnectedException ex) {  
        ConnectionProfile connectionProfile,  
    protected void doStop() {  
        sendRequest(
import org.opensearch.common.lease.Releasable;
        Tracer tracer
    public TaskManager getTaskManager() {
        if (tracerLog.isTraceEnabled() && shouldTraceAction(action)) {
                // want handlers to worry about stack overflows. In the special case of running into a closing node we run on the current
        final String action,
        final long requestId = responseHandlers.add(new Transport.ResponseContext<>(responseHandler, connection, action));
     *
            try {  
        }  
     */  
        try {
        Tracer tracer
            fut -> connectToNodeAsExtension(node, connectionProfile, extensionUniqueIq, ActionListener.map(fut, x -> null))
        Settings settings,  
     * @param action                The action the request handler is associated with
                    processResponse(handler, response);
        }
        TransportResponseHandler<T> handler
            DiscoveryNode node,  
    ) {
        public boolean isClosed() {  
        handleIncomingRequests.set(true);
        public String getProfileName() {
            connectionValidatorForExtensionConnectingToNode(node, extensionUniqueId),
    public boolean isTransportSecure() {  
     *   *    updates for {@link TransportSettings#TRACE_LOG_EXCLUDE_SETTING} and {@link TransportSettings#TRACE_LOG_INCLUDE_SETTING}.  
                } else {
        tracerLog = Loggers.getLogger(logger, ".tracer");
        return transport.getRequestHandlers().getHandler(action);  
            return DIRECT_RESPONSE_PROFILE;
        public void close() {}
            handler.handleException(ex);
     */
import java.util.function.Predicate;
        }
        if (!streamTransportMode) {
            String currentId = threadPool.getThreadContext().getHeader("extension_unique_id");  
    }
        public long timeoutTime() {  
            }
        ConnectionManager connectionManager,  
            }));
            handler,
        return remoteClusterService;  
        connectToNode(node, (ConnectionProfile) null);
     * @param handler        The handler itself that implements the request handling
            } else {
        connectionManager.disconnectFromNode(node);
        public HandshakeResponse(StreamInput in) throws IOException {
                }  
     */
        String executor,  
        }
                                    + "] failed: remote node version ["
            if (remoteClusterClient) {
            return localNodeConnection;
    public ConnectionManager getConnectionManager() {
        public boolean skipsDeserialization() {
     * Registers a new request handler with admission control support  
                final Releasable unregisterChildNode = taskManager.registerChildNode(request.getParentTask().getId(), connection.getNode());
     * @param connection       the connection to a specific node
        }
            // We don't validate cluster names to allow for CCS connections.  
    protected final Tracer tracer;
 * not use this file except in compliance with the License.
    }
    protected <T extends TransportResponse> void sendRequestAsync(
        if (exclude.length > 0) {
            }  
    protected void validateActionName(String actionName) {
        return localNode;
        final TransportRequestOptions options,
            }  
            final RequestHandlerRegistry reg = getRequestHandler(action);  
     */  
                        );
        TransportResponseHandler<T> handler
        final TransportResponseHandler<T> handler
            forceExecution,
    ) {
    /**  
        @Nullable ClusterSettings clusterSettings,  
        RequestHandlerRegistry<Request> reg = new RequestHandlerRegistry<>(  
            throw new IllegalStateException("Constructor only supported to construct StreamTransportService");
                        }
            clusterName = new ClusterName(in);
                getExecutorService().execute(new AbstractRunnable() {
            sendRequest(connection, action, request, options, futureHandler);
            if (Strings.isNullOrEmpty(currentId) || !extensionUniqueId.equals(currentId)) {
            throw new UncheckedIOException(e);
        transport.close();
        this.interceptor = transportInterceptor;
        this.streamTransport = streamTransport;
        Writeable.Reader<Request> requestReader,  
        final TransportRequestOptions options,
                return null;
        final Task parentTask,  
            // here we start to connect to the remote clusters
        final TransportRequest request,
                    @Override
    public void onResponseSent(long requestId, String action, TransportResponse response) {
     * this method is called
    }
        private final String action;
            }));
                return true;
                }  
        DiscoveryNode node,
package org.opensearch.transport;
        }
        private final Supplier<ThreadContext.StoredContext> contextSupplier;  
        );  
        @Override  
        private final Version version;  
import org.apache.logging.log4j.Logger;
        }
            }
    }
        @Override
        String extensionUniqueId,
        }  
            // We don't validate cluster names to allow for CCS connections.
                        logger.warn("failed to notify response handler on exception, action: {}", holderToNotify.action(), e);
import java.util.concurrent.CopyOnWriteArrayList;
        @SuppressWarnings("unchecked")  
    /**
                            new IllegalStateException(
                + "] has been removed from clientHandlers";
        try {  
                throw new NodeClosedException(localNode);  
            return delegate.read(in);
                            new ReceiveTimeoutTransportException(
import org.opensearch.Version;
        final TransportResponseHandler<T> handler  
    }  
                timeoutInfoHandlers.put(requestId, new TimeoutInfoHolder(node, action, sentTime, timeoutTime));  
                    }
import org.opensearch.threadpool.Scheduler;
            logger.info("{}", transport.boundAddress());
    public static final String DIRECT_RESPONSE_PROFILE = ".direct";
        transport.setMessageListener(this);
            HANDSHAKE_ACTION_NAME,
        public String action() {
                        return handler.skipsDeserialization();
        transport.registerRequestHandler(reg);
    protected boolean isLocalNode(DiscoveryNode discoveryNode) {
    /**
    public static final TransportInterceptor NOOP_TRANSPORT_INTERCEPTOR = new TransportInterceptor() {  
                    }
            // usually happen either because we failed to connect to the node
            settings,
    /**  
            streamTransport,
        HandshakeRequest(StreamInput in) throws IOException {
    }  
    @Override  
                final DiscoveryNode remote = resp.discoveryNode;
            logger.warn("Transport response handler not found of id [{}]", requestId);
        public void onResponseSent(long requestId, String action, TransportResponse response) {  
        try {
    private ExecutorService getExecutorService() {
    /** called by the {@link Transport} implementation after an exception was sent as a response to an incoming request */
                        handler.handleResponse(response);  
        final DiscoveryNode node = connection.getNode();
     * @param connection the connection to send the request on
import org.opensearch.core.service.ReportingService;
        this(
     *
        );
            this.action = action;  
    /** if set will call requests sent to this id to shortcut and executed locally */  
    ) {  
        private final long requestId;
            this.contextSupplier = contextSupplier;
                    }
            Arrays.asList(
     *  
    ) {  
    protected void doStart() {  
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
    }  
        @Nullable Transport streamTransport,
            localNode = localNodeFactory.apply(transport.boundAddress());
                    public void doRun() {
        return PlainActionFuture.get(fut -> openConnection(node, connectionProfile, fut));
                reg.processMessageReceived(request, channel);
            taskManager,
        setTracerLogExclude(TransportSettings.TRACE_LOG_EXCLUDE_SETTING.get(settings));
    public void openConnection(
            return getClass().getName() + "/" + delegate.toString();
            clusterName.getEqualityPredicate(),
            } catch (Exception inner) {
                            return "delivery of failure response to [" + requestId + "][" + action + "]: " + exception;
            transportInterceptor,  
        private final long sentTime = threadPool.relativeTimeInMillis();  
            handshake(newConnection, actualProfile.getHandshakeTimeout().millis(), cn -> true, ActionListener.map(listener, resp -> {
            connectionManager,
            service.onResponseSent(requestId, action, response);
            if (streamTransport != null) {
            if (reg == null) {
                processException(handler, wrapInRemote(new ResponseHandlerFailureTransportException(e)));
                        // if we get rejected during node shutdown we don't wanna bubble it up
            }  
                logger.info("Connection validation was skipped");  
                        public String toString() {
            // the caller might not handle this so we invoke the handler
        final String action,
            }  
                    public void handleException(TransportException exp) {  
                timeoutInfoHolder.node(),
    }
    /**
        validateActionName(action);
        TimeoutInfoHolder(DiscoveryNode node, String action, long sentTime, long timeoutTime) {
    }  
        String executor,  
     */
import org.opensearch.common.settings.Settings;
    }
            }  
        volatile Scheduler.Cancellable cancellable;  
     * @return the executor service  
            }  
     * @param node the node to connect to
    /**
            }
            throw new IllegalStateException("can't send request to a null connection");  
     * This handler wrapper ensures that the response thread executes with the correct thread context. Before any of the handle methods  
    protected final Function<BoundTransportAddress, DiscoveryNode> localNodeFactory;
     * @param <T>        the type of the transport response
     *
    /**
        }  
     * @param executor              The executor the request handling will be executed on  
        responseHandlers = streamTransport.getResponseHandlers();  
            handler,  
        connectToNodeAsExtension(node, (ConnectionProfile) null, extensionUniqueId);
        final TimeoutHandler timeoutHandler;
                /*
    private final TransportInterceptor.AsyncSender asyncSender;  
import org.opensearch.transport.stream.StreamTransportResponse;  
import java.util.Arrays;
        Transport transport,
        if (isValidActionName(actionName) == false) {
            new ClusterConnectionManager(settings, transport),
     *
            HANDSHAKE_ACTION_NAME,
        Tracer tracer,
     * Establishes and returns a new connection to the given node. The connection is NOT maintained by this service, it's the callers
        return Objects.requireNonNull(discoveryNode, "discovery node must not be null").equals(localNode);  
        Writeable.Reader<Request> requestReader,
     * This is called on cluster-manager failover to remove stale entries
        void setTimeoutHandler(TimeoutHandler handler) {
 *  
        }
                    public String toString() {
                        @Override
    ) {  
     * @param listener the action listener to notify
            if (contextToNotify != null) {  
            for (TransportMessageListener listener : listeners) {
     */
    public static final class ContextRestoreResponseHandler<T extends TransportResponse> implements TransportResponseHandler<T> {  
     * @param canTripCircuitBreaker Check the request size and raise an exception in case the limit is breached.
                time - timeoutInfoHolder.timeoutTime(),  
import org.opensearch.core.common.transport.TransportAddress;  
        private volatile TimeoutHandler handler;
        );
    }
     * @param requestReader               The request class that will be used to construct new instances for streaming
    @Override
        } catch (final NodeNotConnectedException ex) {
     * The ActionListener will be called on the calling thread or the generic thread pool.  
                }
     * @param handshakeTimeout handshake timeout
    public <Request extends TransportRequest> void registerRequestHandler(
        }
    }
    public ConnectionManager.ConnectionValidator connectionValidator(DiscoveryNode node) {  
        @Override
    /**
        transport.registerRequestHandler(reg);
    static class HandshakeRequest extends TransportRequest {
            long requestId,
    }  
     * @throws IllegalStateException if the handshake failed
        handshake(
        @Override
            List<Transport.ResponseContext<? extends TransportResponse>> pruned = responseHandlers.prune(  
     */
    /**
                @Override
            taskHeaders,
    ) {
    ) {
        request.setParentTask(localNode.getId(), parentTask.getId());  
    public final <T extends TransportResponse> void sendRequest(
import org.opensearch.telemetry.tracing.handler.TraceableTransportResponseHandler;  
            if (handler != null) {
        // lets see if its in the timeout holder, but sync on mutex to make sure any ongoing timeout handling has finished
        if (tracerLog.isTraceEnabled() && shouldTraceAction(action)) {
        if (timeoutInfoHolder != null) {  
     * @throws NodeNotConnectedException if the given node is not connected
                });  
                    assert holder.action().equals(action);
                    @Override  
                delegate.handleException(exp);  
        final TransportResponseHandler<T> handler
        if (include.length > 0) {
        private void scheduleTimeout(TimeValue timeout) {  
    }
    }  
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,  
            ThreadPool.Names.SAME,  
        ThreadPool threadPool,
     * Connect to the specified node with the default connection profile
            final TransportResponseHandler handler = service.responseHandlers.onResponseReceived(requestId, service);
        handler = interceptor.interceptHandler(action, executor, forceExecution, handler);
            if (actionName.startsWith(prefix)) {
     *  
            handler.handleException(ex);
                    @Override
     * name on the target node doesn't match the local cluster name.
                delegate.handleStreamResponse(response);
            // or because we failed serializing the message  
        }
        }
        public String toString() {  
        }
     * @param connectionProfile the connection profile to use
     * any parsing of it has happened (with the exception of the requestId and action)  
            listener.onResponse(localNodeConnection);
    private final Logger tracerLog;
                // want handlers to worry about stack overflows
     * and returns the discovery node of the node the connection
                                    + localNode.getVersion()
                public String toString() {  
            listener.onResponse(null);
        messageListener.onRequestSent(node, requestId, action, request, options);
    @Override
    }
    protected final TransportInterceptor interceptor;
    }
    }
        public void sendResponse(Exception exception) throws IOException {
                if (node.equals(remote) == false) {
                        @Override  
                timeoutInfoHolder.action(),
        final TransportRequest request,
        this.remoteClusterClient = DiscoveryNode.isRemoteClusterClient(settings);
    static class DirectResponseChannel implements TransportChannel {  
     * The ActionListener will be called on the calling thread or the generic thread pool.  
import org.opensearch.common.unit.TimeValue;
        PlainActionFuture.get(fut -> connectToNode(node, connectionProfile, ActionListener.map(fut, x -> null)));
        }  
    public void onResponseReceived(long requestId, Transport.ResponseContext holder) {
    /**  
 */  
            false,  
            }
            });  
            return;  
        this(
        final String action,  
        return (newConnection, actualProfile, listener) -> {
        public void handleStreamResponse(StreamTransportResponse<T> response) {  
                return null;
                return null;
import java.util.LinkedHashMap;
                    });  
            requestReader,
        Set<String> taskHeaders  
     */  
                te = new TransportException("failure to send", ex);
            if (timeoutHandler != null) {
        final Transport.Connection connection,
                    }
            if (handler != null) {  
        );
        public void handleResponse(T response) {
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.cluster.ClusterName;
        }  
        ConnectionProfile connectionProfile,  
     * was established with. The handshake will fail if the cluster  
            logger.debug("Action: " + action);  
                        }  
    }  
    }
        public void onResponseReceived(long requestId, Transport.ResponseContext holder) {  
        this.asyncSender = interceptor.interceptSender(this::sendRequestInternal);  
        ThreadPool threadPool,  
    public ThreadPool getThreadPool() {
         * to make sure this doesn't run.
                long timeoutTime = threadPool.relativeTimeInMillis();
        }  
    protected TaskManager createTaskManager(
                    assert holder.connection().getNode().equals(node);
    }  
            tracerLog.trace("[{}][{}] received response from [{}]", requestId, action, sourceNode);
    // do show up, we can print more descriptive information about them
        protected RemoteTransportException wrapInRemote(Exception e) {
    }
            clusterSettings.addSettingsUpdateConsumer(TransportSettings.TRACE_LOG_INCLUDE_SETTING, this::setTracerLogInclude);  
        @Override
     * @throws IllegalStateException if the handshake failed  
        @Override
    }  
            forceExecution,
            out.writeVersion(version);
    private boolean shouldTraceAction(String action) {  
        try {
        if (action == null) {
            clusterSettings,
        taskManager = createTaskManager(settings, clusterSettings, threadPool, taskHeaders);
    public <T extends TransportResponse> void sendChildRequest(  
            this.sentTime = sentTime;
                });
        } catch (NodeNotConnectedException ex) {
            this.handler = handler;
     * @param connectionProfile the connection profile to use when connecting to this node
    void setTracerLogExclude(List<String> tracerLogExclude) {
     * @param connectionProfile the connection profile to use
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        this.interceptor = transportInterceptor;
            this.service = service;
        OpenSearchServerException.registerExceptions();  
            tracer
            taskManager,
 *
            tracerLog.trace("[{}][{}] received request", requestId, action);
        this.localNodeFactory = localNodeFactory;
        this(
    /**
                                    + node
        ActionListener<Transport.Connection> listener
    public DiscoveryNode getLocalNode() {  
        /* Registers OpenSearch server specific exceptions (exceptions outside of core library) */
            handler,
 * You may obtain a copy of the License at  
          Registers server specific types as a streamables for serialization
import org.opensearch.OpenSearchServerException;  
            handshakeTimeout,  
            }
     * @param listener         action listener to notify
    ) throws TransportException {
            threadPool,  
    void setTracerLogInclude(List<String> tracerLogInclude) {  
     */  
                }  
            tracerLog.trace("[{}][{}] sent to [{}] (timeout: [{}])", requestId, action, node, options.timeout());
                    }
            return discoveryNode;
        Set<String> taskHeaders,
            checkForTimeout(requestId);
    // An LRU (don't really care about concurrency here) that holds the latest timed out requests so if they
        }
        return transport.boundAddress();
     *
                handler.handleException(rtx);
        }  
                    }  
    }
     * Connect to the specified node with the given connection profile.
import org.opensearch.node.NodeClosedException;
            return null;  
        BoundTransportAddress boundTransportAddress = boundAddress();
                    public void onFailure(Exception e) {
        connectToExtensionNode(node, null, listener);  
                    public boolean skipsDeserialization() {
import org.opensearch.common.logging.Loggers;
import java.util.Map;
            action = null;  
        return (newConnection, actualProfile, listener) -> {
            // ignore if its null, the service logs it  
        return threadPool.generic();  
        final TransportRequest request,
    }
                return size() > 100;
            connectionManager.openConnection(node, connectionProfile, listener);  
                        listener.onResponse(response);
                "indices:admin",
    public void onResponseSent(long requestId, String action, Exception e) {
import org.opensearch.tasks.Task;  
        if (transport.boundAddress() != null && logger.isInfoEnabled()) {
                        logger.debug("failed to notify response handler on rejection, action: {}", holderToNotify.action(), e);
            protected boolean removeEldestEntry(Map.Entry eldest) {  
     * @param node the node to connect to
            action,  
        final TransportResponseHandler<T> handler
            }, HandshakeResponse::new, ThreadPool.Names.GENERIC)  
            getExecutorService().execute(new Runnable() {
    /**  
        } else if (tracerLog.isTraceEnabled() && shouldTraceAction(holder.action())) {
    private static final Logger logger = LogManager.getLogger(TransportService.class);  
import org.opensearch.telemetry.tracing.SpanScope;
        if (isLocalNode(node)) {
import org.opensearch.threadpool.ThreadPool;
        final Transport.Connection connection,
        TransportRequestHandler<Request> handler
import org.opensearch.telemetry.tracing.Tracer;
                        .handleException(
            }
    @Override
                    }
            action = timeoutInfoHolder.action();
    }
     *  
    }
            listener  
    public List<String> getDefaultSeedAddresses() {
                                    + "] is incompatible with local node version ["
 */  
            listener.onResponse(null);  
                logger.info("profile [{}]: {}", entry.getKey(), entry.getValue());
        }  
        new HashSet<>(  
            if (handler != null) {
                "views:"
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
 * this work for additional information regarding copyright
                @Override
                    }  
        }  
        public long sentTime() {
     *
        final DiscoveryNode localNode;
            return "timeout handler for [" + requestId + "][" + action + "]";  
            node,  
        }  
    public TransportService(
    }  
        if (isLocalNode(node)) {
    }  
    }
            this.clusterName = clusterName;
     *
                                holder.connection().getNode(),  
        }
        sendRequest(connection, action, request, TransportRequestOptions.EMPTY, handler);
                    }  
        boolean canTripCircuitBreaker,
        } catch (final Exception ex) {
     * @param executor       The executor the request handling will be executed on
    }
            this.node = node;
 * specific language governing permissions and limitations
     */
                if (node.equals(remote) == false) {  
import java.io.UncheckedIOException;  
                                    + clusterNamePredicate  
    }
            this.cancellable = threadPool.schedule(this, timeout, ThreadPool.Names.GENERIC);
        }  
    };  
import java.net.UnknownHostException;
        @Override
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)  
        }
    }
                final RemoteTransportException rtx = wrapInRemote(exception);  
    /**
     * are invoked we restore the context.
    }  
import org.opensearch.core.transport.TransportResponse;  
                        public String toString() {  
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
                        }  
                        @Override  
        @Override
        validateActionName(action);
    public boolean nodeConnected(DiscoveryNode node) {  
            localNodeFactory,
            );
            // the caller might not handle this so we invoke the handler
        }  
     * Returns either a real transport connection or a local node connection if we are using the local node optimization.  
        if (options.timeout() != null) {  
            timeoutHandler = null;
        final Transport.Connection connection,
     * @param handler               The handler itself that implements the request handling
        connectionManager.connectToNode(
        Tracer tracer
        this.streamTransport = streamTransport;
                        holderToNotify.handler().handleRejection(e);
        );  
                            )
    }
            }
    public void addConnectionListener(TransportConnectionListener listener) {
     * Connect to the specified node as an extension with the default connection profile
     * name on the target node mismatches the local cluster name.
                                    + "] failed: remote cluster name ["  
    public void connectToNodeAsExtension(
            if (handler != null) {
                            processException(handler, rtx);
        final TransportRequestOptions options,
         */  
     * @param handler    the response handler  
        TransportRequestOptions options,
    ) {  
                    }  
     * @param connectionProfile the connection profile to use when connecting to this node  
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
            if (request.getParentTask().isSet()) {
        );
            connection = getConnection(node);  
                                    + response.clusterName.value()
            return;
                        );
     * @opensearch.internal
        public Version getVersion() {
            return;  
            // the caller might not handle this so we invoke the handler  
    // tracer log  
    /**
                listener.onRequestSent(node, requestId, action, request, finalOptions);
    protected final ConnectionManager connectionManager;
    /** called by the {@link Transport} implementation once a response was sent to calling node */
        @Override
            tracerLog.trace("[{}][{}] received response from [{}]", requestId, holder.action(), holder.connection().getNode());  
            taskHeaders,
            clusterSettings.addSettingsUpdateConsumer(TransportSettings.SLOW_OPERATION_THRESHOLD_SETTING, transport::setSlowLogThreshold);
     */
         */  
            transport,
                        holderToNotify.handler().handleException(ex);
    volatile String[] tracerLogInclude;  
 * software distributed under the License is distributed on an
        final Transport.Connection connection;  
            for (Map.Entry<String, BoundTransportAddress> entry : transport.profileBoundAddresses().entrySet()) {  
                delegate = handler;
    };
        }
            return node;
        ThreadPool threadPool,
        private final TransportResponseHandler<T> delegate;
        }
        return transport.isSecure();
import org.opensearch.common.util.concurrent.AbstractRunnable;  
        Settings settings,
    @Override  
        public DiscoveryNode getNode() {
        final TransportRequestOptions options,  
                    public void onFailure(Exception e) {  
     * The ActionListener will be called on the calling thread or the generic thread pool.  
        connectionManager.addListener(listener);
            IOUtils.close(connectionManager, remoteClusterService, transport::stop);
                            return "delivery of response to [" + requestId + "][" + action + "]: " + response;
     *  
            HandshakeRequest::new,  
    }
    public final <T extends TransportResponse> void sendRequest(  
    }
            handler.handleException(te);
        DiscoveryNode node = connection.getNode();
        );
    public BoundTransportAddress boundAddress() {
        public void sendResponse(TransportResponse response) throws IOException {  
                "Received response for a request that has timed out, sent [{}ms] ago, timed out [{}ms] ago, "  
                                "handshake with ["
            for (TransportMessageListener listener : listeners) {
                    @Override  
        }  
        transport.setSlowLogThreshold(TransportSettings.SLOW_OPERATION_THRESHOLD_SETTING.get(settings));
    /** does nothing. easy way to ensure class is loaded so the above static block is called to register the streamables */  
        return transport.getDefaultSeedAddresses();  
        final String action,
        this.clusterName = ClusterName.CLUSTER_NAME_SETTING.get(settings);
        public HandshakeResponse(DiscoveryNode discoveryNode, ClusterName clusterName, Version version) {
        }  
    /**
        Transport transport,
        return threadPool;
                        contextToNotify.handler().handleRejection(e);
        @Nullable ClusterSettings clusterSettings,  
            return;
    }  
        TransportInterceptor transportInterceptor,
                    return "onConnectionClosed(" + connection.getNode() + ")";
            final TransportException te;
        }  
        }  
            for (TransportMessageListener listener : listeners) {  
        final TransportResponseHandler<T> handler
            )  
        public void addCloseListener(ActionListener<Void> listener) {}  
     * called by the {@link Transport} implementation when an incoming request arrives but before
            return false;
     *
            if (e instanceof RemoteTransportException remoteTransportException) {  
                            new NodeClosedException(localNode)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                    + node
            for (TransportMessageListener listener : listeners) {  
        private final long requestId;  
                "cluster:internal",  
                        );
        final String action,
                        reg.processMessageReceived(request, channel);
            transportInterceptor,
            settings,  
        public void onResponseSent(long requestId, String action, Exception error) {
import org.opensearch.tasks.TaskManager;
            // callback that an exception happened, but on a different thread since we don't  
     */
            if (cancellable != null) {
        ClusterSettings clusterSettings,
        // TODO we should makes this a hard validation and throw an exception but we need a good way to add backwards layer
        } catch (OpenSearchRejectedExecutionException ex) {
        return submitRequest(node, action, request, TransportRequestOptions.EMPTY, handler);  
        boolean forceExecution,
                        public void run() {
                // now that we have the information visible via timeoutInfoHandlers, we try to remove the request id
            } else {
        protected void processResponse(TransportResponseHandler handler, TransportResponse response) {
        connectionManager.removeListener(listener);  
                channel.sendResponse(e);
            logger.warn(
     * @param requestReader               The request class that will be used to construct new instances for streaming
        this.asyncSender = interceptor.interceptSender(this::sendRequestInternal);
        sendChildRequest(connection, action, request, parentTask, options, handler);  
        try {
    public void setPendingDisconnection(DiscoveryNode node) {
            executor,
    ) {  
            clusterSettings,  
                    @Override
import org.opensearch.common.io.stream.Streamables;
            }
                    holder.handler()  
                        return handler.executor();
        if (tracerLog.isTraceEnabled() && shouldTraceAction(action)) {
     * @opensearch.internal
                    + "action [{}], node [{}], id [{}]",
            try (ThreadContext.StoredContext ignore = contextSupplier.get()) {  
        if (handleIncomingRequests.get() == false) {
        final DiscoveryNode node,  
        this.tracerLogInclude = tracerLogInclude.toArray(Strings.EMPTY_ARRAY);
                        logger.debug("failed to notify response handler on rejection, action: {}", contextToNotify.action(), e);
        }  
    public void handshake(
        ThreadPool threadPool,  
    }
 *
    private <T extends TransportResponse> void sendRequestInternal(
        RemoteClusterService remoteClusterService,
                if (timeoutHandler != null) {
                    timeoutHandler.cancel();
        TimeoutInfoHolder timeoutInfoHolder = timeoutInfoHandlers.remove(requestId);
        }
        TransportRequest request,  
     * @param handler               The handler itself that implements the request handling
     */
                "indices:data/write",
        final Task parentTask,
    public static class HandshakeResponse extends TransportResponse {  
    ) {
     * @param listener         action listener to notify
        final DiscoveryNode node,
            if (lifecycle.stoppedOrClosed()) {
     * Internal Handshake request  
public class TransportService extends AbstractLifecycleComponent
     * @param extensionUniqueId the id of the extension
    protected void sendLocalRequest(long requestId, final String action, final TransportRequest request, TransportRequestOptions options) {
     * @param executor              The executor the request handling will be executed on
        };  
            @Override
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,  
            sourceNode = timeoutInfoHolder.node();  
import org.opensearch.telemetry.tracing.Span;
        public void onRequestSent(
        ConnectionManager connectionManager,
            version = in.readVersion();  
        }
 * ownership. Elasticsearch licenses this file to you under  
                final Transport.ResponseContext<? extends TransportResponse> holder = responseHandlers.remove(requestId);
 */
