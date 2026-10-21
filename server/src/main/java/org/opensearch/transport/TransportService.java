        }
        );
        connectionManager.addListener(listener);
            // ignore if its null, the service logs it
 *
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            return new TaskManager(settings, threadPool, taskHeaders);
     *
                        handler.handleException(exp);
            try {
    protected boolean isLocalNode(DiscoveryNode discoveryNode) {
            this.cancellable = threadPool.schedule(this, timeout, ThreadPool.Names.GENERIC);
    }
    public static void ensureClassloaded() {}
                "Received response for a request that has timed out, sent [{}ms] ago, timed out [{}ms] ago, "
                handler.cancel();
                            )
        AdmissionControlActionType admissionControlActionType,
        synchronized (this) {
        }
            null,
            action,
        }
                } else {
/*
    protected final ConnectionManager connectionManager;
        connectionManager.removeListener(listener);
        @Override
    /**
 * @opensearch.internal
    TransportService(
    public ConnectionManager.ConnectionValidator extensionConnectionValidator(DiscoveryNode node) {
                 * If we are not started the exception handling will remove the request holder again and calls the handler to notify the
    }
        final DiscoveryNode node,
        final TransportRequestOptions options,
                    public void onFailure(Exception e) {
        TransportResponseHandler<T> handler
        TransportConnectionListener {
            }
    }
        tracerLog = Loggers.getLogger(logger, ".tracer");
 * You may obtain a copy of the License at
                    public void handleException(TransportException exp) {
     */
        private final long requestId;
    }
        this.streamTransport = streamTransport;
    }
        TransportRequestOptions options,
    public <Request extends TransportRequest> void registerRequestHandler(
    }
            timeoutHandler = null;
    protected final ClusterName clusterName;
        validateActionName(action);
            } else {
                @Override
     * @param handshakeTimeout handshake timeout
 * GitHub history for details.
                                    + "] is incompatible with local node version ["
        final String action,
        )
     * @throws IllegalStateException if the handshake failed
    @Override
                                    + response.version
            }
 *
    private final TransportInterceptor.AsyncSender asyncSender;
        this.remoteClusterClient = false;
            tracerLog.trace("[{}] received response but can't resolve it to a request", requestId);
                        contextToNotify.handler().handleRejection(e);
    public boolean nodeConnected(DiscoveryNode node) {
        connectionManager.clearPendingDisconnections();
            clusterSettings.addSettingsUpdateConsumer(TransportSettings.TRACE_LOG_INCLUDE_SETTING, this::setTracerLogInclude);
        ThreadPool threadPool,
            node,
                    public T read(StreamInput in) throws IOException {
         */
        sendRequest(
        return taskManager;
            connection = getConnection(node);
            @Override
            clusterName = new ClusterName(in);
        try {
        DiscoveryNode node,
     */
 * this file be licensed under the Apache-2.0 license or a
     * @opensearch.internal
        protected void processResponse(TransportResponseHandler handler, TransportResponse response) {
import org.opensearch.telemetry.tracing.SpanScope;
            }
            for (TransportMessageListener listener : listeners) {
        DiscoveryNode node,
        try (SpanScope spanScope = tracer.withSpanInScope(span)) {
     * was established with. The handshake will fail if the cluster
                "indices:internal",
                return false;
                    }
        TransportMessageListener,
     * Connect to the specified node as an extension with the default connection profile
        final String action;
     * @param connection the connection to send the request on
        }
        if (options.timeout() != null) {
    // do show up, we can print more descriptive information about them
import org.opensearch.common.lease.Releasable;
            IOUtils.close(connectionManager, remoteClusterService, transport::stop);
        String action,
            }
        protected RemoteTransportException wrapInRemote(Exception e) {
            this.threadPool = threadPool;
    }
     * @param connectionProfile the connection profile to use when connecting to this node
            }));
            tracerLog.trace("[{}][{}] received request", requestId, action);
                        contextToNotify.handler().handleRejection(e);
        }
                final DiscoveryNode remote = resp.discoveryNode;
                te = new TransportException("failure to send", ex);
        TimeoutInfoHolder(DiscoveryNode node, String action, long sentTime, long timeoutTime) {
        public void handleException(TransportException exp) {
            clusterName.writeTo(out);
                        return "processing of [" + requestId + "][" + action + "]: " + request;
     * @param executor       The executor the request handling will be executed on
                public void onFailure(Exception e) {
        @Nullable ClusterSettings clusterSettings,
                        logger.debug("failed to notify response handler on rejection, action: {}", holderToNotify.action(), e);
        responseHandlers = streamTransport.getResponseHandlers();
                        handler.handleResponse(response);
    public void connectToNodeAsExtension(
        Settings settings,
                return size() > 100;
                    }
        final Transport.Connection connection,
            requestReader,
            return;
                threadPool.getThreadContext().putHeader("extension_unique_id", extensionUniqueId);
            );
    public void connectToExtensionNode(final DiscoveryNode node, ConnectionProfile connectionProfile, ActionListener<Void> listener) {
     * @param requestReader               The request class that will be used to construct new instances for streaming
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to
     */
            // We don't validate cluster names to allow for CCS connections.
                throw new NodeClosedException(localNode);
        registerRequestHandler(
        ThreadPool threadPool,
    /**
     * @return the executor service
import org.opensearch.telemetry.tracing.Span;
        }
        public static final HandshakeRequest INSTANCE = new HandshakeRequest();
    /**
        @Override
        public void onRequestSent(
                assert options.timeout() != null;
    @Override
            if (handler != null) {
     * name on the target node mismatches the local cluster name.
                delegate.handleException(exp);
                        public void run() {
        public void writeTo(StreamOutput out) throws IOException {
                    @Override
        Transport transport,
            HANDSHAKE_ACTION_NAME,
            action = timeoutInfoHolder.action();
        TransportRequestHandler<Request> handler
            try (ThreadContext.StoredContext ignore = contextSupplier.get()) {
        }
import org.opensearch.tasks.TaskManager;
            transport,
    }
        TransportInterceptor transportInterceptor,
     * @param node the node to connect to
        }
        }
     */
        this(
            onRequestReceived(requestId, action);
                        );
            }
        }
        if (isLocalNode(node)) {
     * This is called on cluster-manager failover to remove stale entries
     * @param handshakeTimeout handshake timeout
     *
        return threadPool.generic();
            if (e instanceof RemoteTransportException remoteTransportException) {
            settings,
        if (clusterSettings != null) {
            tracerLog.trace("[{}][{}] received response from [{}]", requestId, action, sourceNode);
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                    }
        );
            }
            return delegate.skipsDeserialization();
    public void onResponseSent(long requestId, String action, TransportResponse response) {
    /**
            throw new UncheckedIOException(e);
                        }
    ) {
    }
     * Connect to the specified node with the default connection profile
import org.opensearch.common.util.io.IOUtils;
import java.util.concurrent.atomic.AtomicBoolean;
                    threadPool.executor(handler.executor()).execute(new Runnable() {
    }
    public ConnectionManager.ConnectionValidator connectionValidatorForExtensionConnectingToNode(
        this.asyncSender = interceptor.interceptSender(this::sendRequestInternal);
        @Override
    static {
        assert responseHandlers.contains(requestId) == false;
                listener.onRequestReceived(requestId, action);
                "internal:",
        private final String action;
                        unregisterChildNode.close();
     */
     * was established with. The handshake will fail if the cluster
    }
     * called by the {@link Transport} implementation when an incoming request arrives but before
            transport,
        return localNode;
                // thread on a best effort basis though.
        }
        try {
            HandshakeRequest.INSTANCE,
     * Executes a high-level handshake using the given connection
                };
        @Override
     */
    private <T extends TransportResponse> void sendRequestInternal(
    @Override
                cancellable.cancel();
                } else {
            if (handler != null) {
        void setTimeoutHandler(TimeoutHandler handler) {
                handler.handleResponse(response);
        Set<String> taskHeaders,
        DiscoveryNode node = connection.getNode();
    protected final Function<BoundTransportAddress, DiscoveryNode> localNodeFactory;
     */
     * Returns <code>true</code> iff the action name starts with a valid prefix.
        }
        private final String action;
        } finally {
            onRequestSent(localNode, requestId, action, request, options);
        } else {
        TimeoutHandler(long requestId, DiscoveryNode node, String action) {
        transport.setSlowLogThreshold(TransportSettings.SLOW_OPERATION_THRESHOLD_SETTING.get(settings));
        if (isLocalNode(node)) {
    @Override
        ActionListener<Void> listener
            Transport.Connection connection = getConnection(node);
                "indices:monitor",
                        }
        }
                    assert holder.action().equals(action);
        return (newConnection, actualProfile, listener) -> {
            }
                timeoutInfoHolder.node(),
     */
                    public void onRejection(Exception e) {
                        handler.handleStreamResponse(response);
    }
        @Override
        @Override
        );
import org.opensearch.common.util.concurrent.AbstractRunnable;
                final String executor = handler.executor();
     * @param action                The action the request handler is associated with
        try {
        }
            return discoveryNode;
     * Connect to the specified node with the given connection profile
        connectionManager.addListener(this);
    ) {
        if (connection == null) {
    protected final TransportInterceptor interceptor;
        PlainActionFuture.get(fut -> connectToExtensionNode(node, (ConnectionProfile) null, ActionListener.map(fut, x -> null)));
        final long handshakeTimeout,
        public long timeoutTime() {
    ) {
                        listener.onResponse(response);
        ConnectionManager connectionManager,
     * Holder for timeout information
        if (tracerLog.isTraceEnabled() && shouldTraceAction(action)) {
                    @Override
        } else if (shouldTraceAction(action)) {
    }
        if (isValidActionName(actionName) == false) {
            }
                    protected void doRun() throws Exception {
            }
        volatile Scheduler.Cancellable cancellable;
        );
                    @Override
                public void run() {
        messageListener.listeners.add(listener);
            return clusterName;
        return new TransportInfo(boundTransportAddress, transport.profileBoundAddresses());
     * @param connectionProfile the connection profile to use
        public DiscoveryNode getDiscoveryNode() {
        private void scheduleTimeout(TimeValue timeout) {
     * @param handler    the response handler
                                    + node
            discoveryNode = in.readOptionalWriteable(DiscoveryNode::new);
        Predicate<ClusterName> clusterNamePredicate,
                        }
        );
            service.onResponseSent(requestId, action, response);
    protected void doStop() {
            clusterSettings,
                return null;
                )
            localNodeFactory,
import java.util.List;
        RequestHandlerRegistry<Request> reg = new RequestHandlerRegistry<>(
                            new IllegalStateException(
            final RequestHandlerRegistry reg = getRequestHandler(action);
    }
            handler,
        }
            );
        }
                final DiscoveryNode remote = resp.discoveryNode;
            connection = getConnection(node);
            }
    volatile String[] tracerLogInclude;
        new HashSet<>(
            this.clusterName = clusterName;
            // the caller might not handle this so we invoke the handler
                            new IllegalStateException(
import java.io.IOException;
                        );
                 * caller. It will only notify if toStop hasn't done the work yet.
                                "handshake with ["
                // callback that an exception happened, but on a different thread since we don't
        }
    public void connectToNode(final DiscoveryNode node, ConnectionProfile connectionProfile, ActionListener<Void> listener) {
            requestReader,
                "indices:data/read",
    ) {
    /**
     * @param requestReader               The request class that will be used to construct new instances for streaming
     * @param node the node to connect to
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
    /** called by the {@link Transport} implementation once a response was sent to calling node */
                        }
    public RequestHandlerRegistry<? extends TransportRequest> getRequestHandler(String action) {
          over the {@link StreamOutput} and {@link StreamInput} wire
         * cancels timeout handling. this is a best effort only to avoid running it. remove the requestId from {@link #responseHandlers}
            if (request.getParentTask().isSet()) {
    protected final Transport.ResponseHandlers responseHandlers;
    public void clearPendingDisconnections() {
    ) {
        final TransportRequest request,
                processException(handler, wrapInRemote(new ResponseHandlerFailureTransportException(e)));
import org.opensearch.cluster.ClusterName;
    volatile DiscoveryNode localNode = null;
            tracerLog.trace("[{}][{}] sent to [{}] (timeout: [{}])", requestId, action, node, options.timeout());
                if (node.equals(remote) == false) {
     */
    }
     * @opensearch.internal
                    @Override
            return timeoutTime;
    protected void doStart() {
    public void onResponseSent(long requestId, String action, Exception e) {
        for (String prefix : VALID_ACTION_PREFIXES) {
            canTripCircuitBreaker
    public TransportService(
        BoundTransportAddress boundTransportAddress = boundAddress();
        TransportInterceptor transportInterceptor,
        Streamables.registerStreamables();
     */
    public RemoteClusterService getRemoteClusterService() {
            if (ex instanceof TransportException) {
                                    + clusterNamePredicate
    }
     * @param node the node to connect to
import java.util.Collections;
        TransportRequest request,
    }
        private final Version version;
        private HandshakeRequest() {}
                final RemoteTransportException rtx = wrapInRemote(exception);
    @Override
 * compatible open source license.
        final Task parentTask,
        final String action,
        remoteClusterService = new RemoteClusterService(settings, this);
        }
    }
            } catch (Exception e) {
     */
        public void onResponseSent(long requestId, String action, TransportResponse response) {
    };
                                "handshake with ["
     */
    /**
    public void connectToNode(final DiscoveryNode node, ConnectionProfile connectionProfile) {
                    public void doRun() {
    public <Request extends TransportRequest> void registerRequestHandler(
        this.localNodeFactory = localNodeFactory;
     * @param options    the options for this request
    }
        private final long sentTime = threadPool.relativeTimeInMillis();
            TransportRequestOptions finalOptions
        if (tracerLog.isTraceEnabled() && shouldTraceAction(action)) {
        }
            // the caller might not handle this so we invoke the handler
        final Transport.Connection connection;
    public DiscoveryNode getLocalNode() {
            // here we start to connect to the remote clusters
        if (timeoutInfoHolder != null) {
            connection = getConnection(node);
            this.requestId = requestId;
    }
            TransportRequest request,
        TransportInterceptor transportInterceptor,
            logger.debug("Action: " + action);
        handler = interceptor.interceptHandler(action, executor, false, handler);
    }
            tracer
    ) {
        transport.start();
        } else {
        // TODO we should makes this a hard validation and throw an exception but we need a good way to add backwards layer
     * Build the service.
import org.opensearch.action.ActionListenerResponseHandler;
                    @Override
        /**
     * @param listener         action listener to notify
        String action,
                    assert holder.connection().getNode().equals(node);
    /**
                }
     * @throws ConnectTransportException if the connection failed
    @Override
        final TransportRequest request,
        Tracer tracer
        }
            getExecutorService().execute(new Runnable() {
        setTracerLogExclude(TransportSettings.TRACE_LOG_EXCLUDE_SETTING.get(settings));
            handshakeTimeout,
        }
        return transport.getStats();
        streamTransport.setSlowLogThreshold(TransportSettings.SLOW_OPERATION_THRESHOLD_SETTING.get(settings));
                // want handlers to worry about stack overflows
        }
                                    + localNode.getVersion()
import java.util.HashSet;
            sourceNode = timeoutInfoHolder.node();
        }
                public String toString() {
import java.util.Arrays;
        final TransportRequestOptions options,
        try {
                // TODO: capture the connection instead so that we can cancel child tasks on the remote connections.
        final String action,
        final TransportRequest request,
        return threadPool;
                        contextToNotify.handler().handleException(sendRequestException);
    ) {
            checkForTimeout(requestId);
            return TaskManager.createTaskManagerWithClusterSettings(settings, clusterSettings, threadPool, taskHeaders);
     */
        ConnectionProfile connectionProfile,
        } catch (final NodeNotConnectedException ex) {
                delegate = handler;
        final TransportRequestOptions options,
                throw new ActionNotFoundTransportException("Action [" + action + "] not found");
        final Transport.Connection connection,
                }
    public TransportService(
                logger.debug("Exception while sending request, handler likely already notified due to timeout", e);
        }
        TransportRequestHandler<Request> handler
            logger.info("{}", transport.boundAddress());
        @Override
                timeoutHandler.scheduleTimeout(options.timeout());
        public T read(StreamInput in) throws IOException {
                }
    public void onRequestSent(
            // usually happen either because we failed to connect to the node
        private final DiscoveryNode node;
    private static final class DelegatingTransportMessageListener implements TransportMessageListener {
        final Transport.Connection connection,
        TransportRequestHandler<Request> handler
                            processResponse(handler, response);
                logger.info("profile [{}]: {}", entry.getKey(), entry.getValue());
            return delegate.read(in);
            this.discoveryNode = discoveryNode;
            ThreadPool.Names.SAME,
    private final Transport streamTransport;
                    return "onConnectionClosed(" + connection.getNode() + ")";
        if (include.length > 0) {
    ) {
        ReportingService<TransportInfo>,
        transport.registerRequestHandler(reg);
            return DIRECT_RESPONSE_PROFILE;
     * @throws NodeNotConnectedException if the given node is not connected
        // lets see if its in the timeout holder, but sync on mutex to make sure any ongoing timeout handling has finished
                h -> h.connection().getCacheKey().equals(connection.getCacheKey())
    ) {
 */
        String executor,
    public void connectToNode(DiscoveryNode node, ActionListener<Void> listener) throws ConnectTransportException {
 * not use this file except in compliance with the License.
                "cluster:admin",
        if (tracerLog.isTraceEnabled() && shouldTraceAction(action)) {
    }
        PlainActionFuture.get(fut -> connectToExtensionNode(node, connectionProfile, ActionListener.map(fut, x -> null)));
            transportInterceptor,
     * @param node the node to connect to
import java.util.Objects;
        }
        }
            TransportRequestOptions.builder().withTimeout(handshakeTimeout).build(),
                    listener.onFailure(e);
                        unregisterChildNode.close();
            return localNode;
                getExecutorService().execute(new AbstractRunnable() {
     * @param request    the request
    final Map<Long, TimeoutInfoHolder> timeoutInfoHandlers = Collections.synchronizedMap(
         * to make sure this doesn't run.
     * The ActionListener will be called on the calling thread or the generic thread pool.
                    @Override
            this.delegate = delegate;
     * Internal handshake response
                        holderToNotify.handler().handleException(ex);
     * @throws IllegalStateException if the handshake failed
     * @opensearch.internal
                }
                    @Override
            return;
        sendRequest(connection, action, request, TransportRequestOptions.EMPTY, handler);
        this.connectionManager = connectionManager;
        );
                final Releasable unregisterChildNode = taskManager.registerChildNode(request.getParentTask().getId(), connection.getNode());
                logger.error("failed to handle exception for action [{}], handler [{}]", action, handler, e);
     */
                            channel.sendResponse(e);
    public ConnectionManager getConnectionManager() {
            throws TransportException {
            connection.sendRequest(requestId, action, request, options); // local node optimization happens upstream
        if (remoteClusterClient) {
    );
     * @param executor              The executor the request handling will be executed on
     *
        handler = interceptor.interceptHandler(action, executor, forceExecution, handler);
            settings,
        String action,
        this.asyncSender = interceptor.interceptSender(this::sendRequestInternal);
     * @param listener the action listener to notify
                });
     *   *    updates for {@link TransportSettings#TRACE_LOG_EXCLUDE_SETTING} and {@link TransportSettings#TRACE_LOG_INCLUDE_SETTING}.
        private final long timeoutTime;
        final TransportRequest request,
    /**
import java.util.function.Predicate;
    }
        String action,
        @Override
     * @param handler        The handler itself that implements the request handling
        } catch (final Exception e) {
     * @param extensionUniqueId the id of the extension
            return "timeout handler for [" + requestId + "][" + action + "]";
            }
            }
 * KIND, either express or implied.  See the License for the
     * @param action     the name of the action
        @Override
            asyncSender.sendRequest(connection, action, request, options, delegate);
        boolean forceExecution,
                    processResponse(handler, response);
import org.opensearch.threadpool.ThreadPool;
    @Override
    ) {
    /**
    protected final TaskManager taskManager;
    }
                });
        private final long sentTime;
            return "direct";
    }
        protected void processException(final TransportResponseHandler handler, final RemoteTransportException rtx) {
    public <T extends TransportResponse> void sendChildRequest(
        return remoteClusterService;
    }
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
        if (isLocalNode(node)) {
    }
        return PlainActionFuture.get(fut -> openConnection(node, connectionProfile, fut));
    public void connectToExtensionNode(final DiscoveryNode node) {
        public long sentTime() {
    /**
            this.requestId = requestId;
            action,
                    }
                        // if we get rejected during node shutdown we don't wanna bubble it up
    private ExecutorService getExecutorService() {
        }
        this.tracer = tracer;
                if (ThreadPool.Names.SAME.equals(executor)) {
                            )
        public void onResponseReceived(long requestId, Transport.ResponseContext holder) {
     * @param connection       the connection to a specific node
            taskHeaders,
                                holder.action(),
    ) {
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
    }
public class TransportService extends AbstractLifecycleComponent
        if (boundTransportAddress == null) {
            final Transport.ResponseContext<? extends TransportResponse> contextToNotify = responseHandlers.remove(requestId);
        final TransportResponseHandler<T> handler
        this.tracerLogExclude = tracerLogExclude.toArray(Strings.EMPTY_ARRAY);
        setTracerLogInclude(TransportSettings.TRACE_LOG_INCLUDE_SETTING.get(settings));
                        } catch (Exception inner) {
    public Transport.Connection getConnection(DiscoveryNode node) {
    private void checkForTimeout(long requestId) {
            this.node = node;
    public void onRequestReceived(long requestId, String action) {
     * This handler wrapper ensures that the response thread executes with the correct thread context. Before any of the handle methods
            this.action = action;
    private final Transport.Connection localNodeConnection = new Transport.Connection() {
        final TransportRequest request,
    );
            executor,
            handler.handleException(ex);
        return true;
            }
            this.timeoutTime = timeoutTime;
        taskManager = createTaskManager(settings, clusterSettings, threadPool, taskHeaders);
            } else {
            remoteClusterService.initializeRemoteClusters(
    }
                    + "action [{}], node [{}], id [{}]",
        }
import org.opensearch.core.common.io.stream.Writeable;
            futureHandler.handleException(ex);
                requestId
            } catch (Exception e) {
            handler,
    // tracer log
        }
        } catch (Exception e) {
    ) {
    public void connectToExtensionNode(DiscoveryNode node, ActionListener<Void> listener) throws ConnectTransportException {
    }
        ThreadPool threadPool,
        this.streamTransport = streamTransport;
     * name on the target node doesn't match the local cluster name.
        }
        );
            tracer
            return;
     *
            for (TransportMessageListener listener : listeners) {
                channel.sendResponse(e);
    }
    public final void acceptIncomingRequests() {
    protected final ThreadPool threadPool;
import org.opensearch.common.settings.Settings;
                delegate = new TransportResponseHandler<T>() {
    }
        Writeable.Reader<Request> requestReader,
                final String executor = handler.executor();
    }
        Set<String> taskHeaders
/*
        Tracer tracer
            localNodeFactory,
                        logger.debug("failed to notify response handler on rejection, action: {}", contextToNotify.action(), e);
    public void connectToNode(DiscoveryNode node) throws ConnectTransportException {
    }
    }
                    if (clusterNamePredicate.test(response.clusterName) == false) {
                    @Override
            }
                    @Override
        public boolean skipsDeserialization() {
        } catch (final NodeNotConnectedException ex) {
import org.opensearch.threadpool.Scheduler;
        Settings settings,
    public static final String HANDSHAKE_ACTION_NAME = "internal:transport/handshake";
 */
                "views:"
            responseHandler.setTimeoutHandler(timeoutHandler);
        String action,
        this.tracer = tracer;
                    } else if (response.version.isCompatible(localNode.getVersion()) == false) {
                    public void onFailure(Exception e) {
import org.opensearch.core.service.ReportingService;
            if (cancellable != null) {
        private final DiscoveryNode discoveryNode;
            // We don't validate cluster names to allow for CCS connections.
        PlainTransportFuture<T> futureHandler = new PlainTransportFuture<>(handler);
     * Connect to the specified node with the given connection profile.
            }
            }
        private final List<TransportMessageListener> listeners = new CopyOnWriteArrayList<>();
            if (handler != null) {
                reg.processMessageReceived(request, channel);
 *
            this.node = node;
                listener.onResponseSent(requestId, action, response);
            connection,
    ) {
                    @Override
        }
import org.opensearch.core.common.transport.TransportAddress;
        private final ClusterName clusterName;
        responseHandlers = transport.getResponseHandlers();
        Transport transport,
    ) {
                delegate.handleResponse(response);
        DiscoveryNode node,
    public static final Set<String> VALID_ACTION_PREFIXES = Collections.unmodifiableSet(
                "indices:admin",
     * @param connectionProfile the connection profile to use
     *
    }
        Tracer tracer
    }
        final String action,
        validateActionName(action);
        }
            (request, channel, task) -> channel.sendResponse(new HandshakeResponse(localNode, clusterName, localNode.getVersion()))
        return messageListener.listeners.remove(listener);
            handshake(newConnection, actualProfile.getHandshakeTimeout().millis(), cn -> true, ActionListener.map(listener, resp -> {
    public Transport.Connection openConnection(final DiscoveryNode node, ConnectionProfile connectionProfile) {
    }
     * @param <T>        the type of the transport response
                    }
import org.opensearch.telemetry.tracing.Tracer;
    ) {
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
            return;
    }
        Writeable.Reader<Request> requestReader,
        return transport.isSecure();
                            logger.warn("failed to notify channel of error message for action [{}]", action, inner);
                @Override
        public void onResponseSent(long requestId, String action, Exception error) {
     * @param handler               The handler itself that implements the request handling
 *
        DirectResponseChannel(DiscoveryNode localNode, String action, long requestId, TransportService service, ThreadPool threadPool) {
     * The ActionListener will be called on the calling thread or the generic thread pool.
    }
import org.opensearch.node.NodeClosedException;
                        public void run() {
        public String getProfileName() {
        String action,
        return (newConnection, actualProfile, listener) -> {
            handshake(newConnection, actualProfile.getHandshakeTimeout().millis(), cn -> true, ActionListener.map(listener, resp -> {
     * Registers a new request handler with admission control support
    }
            listener.onResponse(null);
            }
        @Override
        this(
                        public String toString() {
                    // response was processed, remove timeout info.
        @Override
    public ConnectionManager.ConnectionValidator connectionValidator(DiscoveryNode node) {
        }
        TransportRequest request,
        }
    public static final class ContextRestoreResponseHandler<T extends TransportResponse> implements TransportResponseHandler<T> {
            }
import org.opensearch.cluster.node.DiscoveryNode;
            sourceNode = null;
                    }
        this.transport = streamTransport;
            protected boolean removeEldestEntry(Map.Entry eldest) {
        final Task parentTask,
        final ActionListener<DiscoveryNode> listener
        } catch (final Exception ex) {
            handler.handleException(te);
        final String action,
                } else {
     * A set of all valid action prefixes.
                        return getClass().getName() + "/[" + action + "]:" + handler.toString();
            transportInterceptor,
            sendLocalRequest(requestId, action, request, options);
     * Returns the internal thread pool
            assert responseHandlers.contains(requestId) == false : "cancel must be called after the requestId ["
        final TransportResponseHandler<T> handler
        public Version getVersion() {
            tracer
            connection,
        ThreadPool threadPool,
        Settings settings,
                handler.cancel();
     * responsibility to close the connection once it goes out of scope.
        final TransportResponseHandler<T> handler
        final DiscoveryNode node,
    }
            return connectionManager.getConnection(node);
    };
            fut -> connectToNodeAsExtension(node, connectionProfile, extensionUniqueIq, ActionListener.map(fut, x -> null))
            new ClusterConnectionManager(settings, transport),
        }
    /**
        DiscoveryNode node,
        ConnectionProfile connectionProfile,
        ActionListener<Transport.Connection> listener
        connectionManager.disconnectFromNode(node);
            out.writeOptionalWriteable((stream, node) -> node.writeToWithAttribute(stream), discoveryNode);
     * Connect to the specified node with the given connection profile.
                }
            }
    /**
        if (isLocalNode(node)) {
    }
            final TransportResponseHandler<T> delegate;
        this.connectionManager = connectionManager;
import org.opensearch.common.io.stream.Streamables;
            }
    static class HandshakeRequest extends TransportRequest {
            }
    public void disconnectFromNode(DiscoveryNode node) {
        }
        sendRequest(connection, action, request, options, handler);
            listener.onResponse(localNodeConnection);
    /**
            return;
        final TransportResponseHandler<T> handler
                        holderToNotify.handler()
            localNodeFactory,
            long time = threadPool.relativeTimeInMillis();
            this.handler = handler;
    public TransportStats stats() {
import org.opensearch.core.transport.TransportResponse;
        }
        private final TransportResponseHandler<T> delegate;
 * ownership. Elasticsearch licenses this file to you under
                    public String toString() {
            connectionProfile,
     *
            Arrays.asList(
                    @Override
        @Override
        this.taskManager = taskManager;
                        try {
            if (remoteClusterClient) {
            listener.onResponse(null);
            });
    public static boolean shouldTraceAction(String action, String[] include, String[] exclude) {
     */
                        return handler.read(in);
        if (isLocalNode(node)) {
        // stream publish address
        Settings settings,
    }
        @Override
                remoteClusterService.listenForUpdates(clusterSettings);
    ) {
    protected void doClose() throws IOException {
                return null;
                    @Override
        final DiscoveryNode node = connection.getNode();
            for (TransportMessageListener listener : listeners) {
        }
        connectionManager.connectToNode(node, connectionProfile, connectionValidator(node), listener);
        final DiscoveryNode sourceNode;
                return null;
     * responsibility to close the connection once it goes out of scope.
import org.opensearch.telemetry.tracing.handler.TraceableTransportResponseHandler;
        Tracer tracer,
     *
                    throw new ConnectTransportException(node, "handshake failed. unexpected remote node " + remote);
     * The ActionListener will be called on the calling thread or the generic thread pool.
            return action;
        );
import org.opensearch.common.util.concurrent.ThreadContext;
                    @Override
    public boolean removeMessageListener(TransportMessageListener listener) {
            threadPool,
    /** called by the {@link Transport} implementation after an exception was sent as a response to an incoming request */
    public void connectToNodeAsExtension(DiscoveryNode node, String extensionUniqueId) throws ConnectTransportException {
                    protected void doRun() throws Exception {
                // now that we have the information visible via timeoutInfoHandlers, we try to remove the request id
        @Override
    /**
            return sentTime;
    public void handshake(
            return;
                if (node.equals(remote) == false) {
        final DirectResponseChannel channel = new DirectResponseChannel(localNode, action, requestId, this, threadPool);
    }
        @Override
                    }
        final String action,
        final Transport.Connection connection,
                    }
        if (tracerLog.isTraceEnabled() == false) {
 * Modifications Copyright OpenSearch Contributors. See
        @Nullable Transport streamTransport,
            threadPool,
    protected final Tracer tracer;
                threadPool.executor(executor).execute(new AbstractRunnable() {
            // We don't validate cluster names to allow for CCS connections.
        public String executor() {
     *
                                "request_id [" + requestId + "] timed out after [" + (timeoutTime - sentTime) + "ms]"
            true
            }
        this.clusterName = ClusterName.CLUSTER_NAME_SETTING.get(settings);
            }
                // noinspection unchecked
            }
     * Establishes and returns a new connection to the given node. The connection is NOT maintained by this service, it's the callers
    }
                    }
        final TransportRequest request,
            return new RemoteTransportException(localNode.getName(), localNode.getAddress(), action, e);
            if (handler != null) {
 * Unless required by applicable law or agreed to in writing,
            }
        public void onRequestReceived(long requestId, String action) {
     * and returns the discovery node of the node the connection
                        @Override
    /**
import org.opensearch.core.common.Strings;
                                    + "] does not match "
        new LinkedHashMap<Long, TimeoutInfoHolder>(100, .75F, true) {
    /**
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
        }
            if (contextToNotify != null) {
        sendChildRequest(connection, action, request, parentTask, options, handler);
            logger.warn("Transport response handler not found of id [{}]", requestId);
        final TimeoutHandler timeoutHandler;
        public HandshakeResponse(DiscoveryNode discoveryNode, ClusterName clusterName, Version version) {
            handler = interceptor.interceptHandler(action, executor, forceExecution, handler);
        );
                                holder.connection().getNode(),
                        return handler.skipsDeserialization();
    ) {
            final String executor = reg.getExecutor();
        /*
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
        ConnectionManager connectionManager,
import org.opensearch.telemetry.tracing.SpanBuilder;
    }
     */
     */
        }
                });
     * @param listener the action listener to notify
        return shouldTraceAction(action, tracerLogInclude, tracerLogExclude);
        try {
     * @param listener the action listener to notify
                            )
        }
        // call tracer out of lock
        this(
                listener.onResponseReceived(requestId, holder);
        if (action == null) {
    }
    }
        public DiscoveryNode getNode() {
        if (transport.boundAddress() != null && logger.isInfoEnabled()) {
        }
                long timeoutTime = threadPool.relativeTimeInMillis();
            }, HandshakeResponse::new, ThreadPool.Names.GENERIC)
        }
        if (isLocalNode(node)) {
        final ThreadPool threadPool;
        RemoteClusterService remoteClusterService,
                }
                        logger.warn("failed to notify response handler on exception, action: {}", holderToNotify.action(), e);
            )
                }
    }
        handleIncomingRequests.set(true);
    }
            long requestId,
    private static final Logger logger = LogManager.getLogger(TransportService.class);
     * @param connectionProfile the connection profile to use when connecting to this node
    public TaskManager getTaskManager() {
        } else {
    public TransportService(
          Registers server specific types as a streamables for serialization
        String extensionUniqueId
            final TransportResponseHandler handler = service.responseHandlers.onResponseReceived(requestId, service);
                    @Override
        handshake(
    /**
                    public void onFailure(Exception e) {
            HANDSHAKE_ACTION_NAME,
        connectToNode(node, (ConnectionProfile) null);
     * Internal Handshake request
    ) {
        final Transport.Connection connection;
        final DiscoveryNode localNode;
            }
        String extensionUniqueId,
        @Override
            for (Map.Entry<String, BoundTransportAddress> entry : transport.profileBoundAddresses().entrySet()) {
            transport,
        this.remoteClusterService = remoteClusterService;
        };
                                    + "] failed: remote node version ["
        @Override
        public String getChannelType() {
     * Returns <code>true</code> iff the given node is already connected.
                            holderToNotify.action(),
        } else if (tracerLog.isTraceEnabled() && shouldTraceAction(holder.action())) {
 */
    }
                    }
        }
        } else {
        boolean canTripCircuitBreaker,
     * @param connection       the connection to a specific node
            }));
    public TransportAddress[] addressesFromString(String address) throws UnknownHostException {
        } catch (OpenSearchRejectedExecutionException ex) {
            }
     */
        }
                "cluster:monitor",
                    }
    }
            // make sure to clean any leftover on going handles
    }
            if (responseHandlers.contains(requestId)) {
            return !Regex.simpleMatch(exclude, action);
        }
        Supplier<ThreadContext.StoredContext> storedContextSupplier = threadPool.getThreadContext().newRestorableContext(true);
        public DiscoveryNode node() {
 * the Apache License, Version 2.0 (the "License"); you may
                                    + "]"
            } else {
                if (holder != null) {
        }
        Set<String> taskHeaders,
    /**
            false,
        }
    /**
     * when the transport layer starts up it will block any incoming requests until
     * Establishes a new connection to the given node. The connection is NOT maintained by this service, it's the callers
     * @param forceExecution        Force execution on the executor queue and never reject it
    private final DelegatingTransportMessageListener messageListener = new DelegatingTransportMessageListener();
            version = in.readVersion();
     * @param admissionControlActionType Admission control based on resource usage limits of provided action type
        TransportResponseHandler<T> handler
    public <Request extends TransportRequest> void registerRequestHandler(
                final String executor = lifecycle.stoppedOrClosed() ? ThreadPool.Names.SAME : ThreadPool.Names.GENERIC;
            out.writeVersion(version);
            return;
            throw new IllegalStateException("Constructor only supported to construct StreamTransportService");
                return remoteTransportException;
            TransportResponseHandler<T> traceableTransportResponseHandler = TraceableTransportResponseHandler.create(handler, span, tracer);
     *
        final long handshakeTimeout,
    public void setPendingDisconnection(DiscoveryNode node) {
     * @param canTripCircuitBreaker Check the request size and raise an exception in case the limit is breached.
        }
            this.contextSupplier = contextSupplier;
                localNode = new DiscoveryNode(localNode, streamTransport.boundAddress().publishAddress());
 */
            try (ThreadContext.StoredContext ignore = contextSupplier.get()) {
        sendChildRequest(connection, action, request, parentTask, TransportRequestOptions.EMPTY, handler);
    public void connectToNodeAsExtension(final DiscoveryNode node, ConnectionProfile connectionProfile, String extensionUniqueIq) {
    public void connectToExtensionNode(final DiscoveryNode node, ConnectionProfile connectionProfile) {
        final DiscoveryNode node,
        final long requestId = responseHandlers.add(new Transport.ResponseContext<>(responseHandler, connection, action));
     */
                    public void handleResponse(T response) {
                    @Override
        }
            clusterSettings.addSettingsUpdateConsumer(TransportSettings.TRACE_LOG_EXCLUDE_SETTING, this::setTracerLogExclude);
        tracerLog = Loggers.getLogger(logger, ".tracer");
                    public boolean isForceExecution() {
    private final RemoteClusterService remoteClusterService;
    }
                }
        RequestHandlerRegistry<Request> reg = new RequestHandlerRegistry<>(
        ClusterSettings clusterSettings,
        // for it. Maybe start with a deprecation layer
                        @Override
        public ContextRestoreResponseHandler(Supplier<ThreadContext.StoredContext> contextSupplier, TransportResponseHandler<T> delegate) {
        private final long requestId;
import java.util.concurrent.ExecutorService;
            final TransportResponseHandler handler = service.responseHandlers.onResponseReceived(requestId, service);
            return null;
                        holderToNotify.handler().handleRejection(e);
                logger.warn("failed to notify channel of error message for action [{}]", action, inner);
            // the caller might not handle this so we invoke the handler
        TransportInterceptor transportInterceptor,
        Settings settings,
     * @param forceExecution        Force execution on the executor queue and never reject it
        final TransportResponseHandler<T> handler
    @Override
import org.opensearch.common.settings.ClusterSettings;
            timeoutHandler = new TimeoutHandler(requestId, connection.getNode(), action);
        HandshakeRequest(StreamInput in) throws IOException {
                    public String toString() {
        return transport.getDefaultSeedAddresses();
        final ActionListener<HandshakeResponse> listener
     */
    }
            handler,
        connectToNode(node, null, listener);
import java.net.UnknownHostException;
     * @param node the node to connect to
            if (streamTransport != null) {
    public BoundTransportAddress boundAddress() {
    @Override
            HandshakeRequest::new,
            super(in);
     * @param node the node to connect to
    private final AtomicBoolean handleIncomingRequests = new AtomicBoolean();
                handler.cancel();
            // ignore if its null, the service logs it
    public TransportService(
                        @Override
            // want handlers to worry about stack overflows
     * @param listener         action listener to notify
     * any parsing of it has happened (with the exception of the requestId and action)
                time - timeoutInfoHolder.timeoutTime(),
    }
        TransportResponseHandler<T> handler
                    public String executor() {
            taskHeaders,
                + "] has been removed from clientHandlers";
                    e -> logger.error("Remote clusters initialization failed partially", e)
    public boolean isTransportSecure() {
        messageListener.onRequestSent(node, requestId, action, request, options);
    }
import java.io.UncheckedIOException;
     * @param node the node to connect to
        final Transport.Connection connection,
            this.sentTime = sentTime;
        connectionManager.setPendingDisconnection(node);
                logger.info("Connection validation was skipped");
    }
        return submitRequest(node, action, request, TransportRequestOptions.EMPTY, handler);
                            return "delivery of response to [" + requestId + "][" + action + "]: " + response;
                    r -> logger.info("Remote clusters initialized successfully."),
        try {
                inner.addSuppressed(e);
            }
    public void removeConnectionListener(TransportConnectionListener listener) {
            if (ThreadPool.Names.SAME.equals(executor)) {
        this.interceptor = transportInterceptor;
        }
        return futureHandler;
    }
     */
            return node;
                                    + node
        ConnectionManager connectionManager,
            assert sourceNode == null;
            requestReader,
    protected <T extends TransportResponse> void sendRequestAsync(
        private final Supplier<ThreadContext.StoredContext> contextSupplier;
        };
        Writeable.Reader<Request> requestReader,
            }
     * @param requestReader  a callable to be used construct new instances for streaming
        @Nullable ClusterSettings clusterSettings,
     * Registers a new request handler
        messageListener.onResponseSent(requestId, action, response);
                return true;
     * Returns either a real transport connection or a local node connection if we are using the local node optimization.
            localNode = localNodeFactory.apply(transport.boundAddress());
        @Override
            return localNode.getVersion();
        }
        public void sendResponse(Exception exception) throws IOException {
    /** called by the {@link Transport} implementation once a request has been sent */
            this.localNode = localNode;
     * @param connectionProfile the connection profile to use when connecting to this node
        try {
            action = null;
import org.opensearch.transport.stream.StreamTransportResponse;
        final TransportRequestOptions options,
            ActionListener.map(listener, HandshakeResponse::getDiscoveryNode)
        if (tracerLog.isTraceEnabled() && shouldTraceAction(action)) {
            // or because we failed serializing the message
    public final <T extends TransportResponse> void sendChildRequest(
        );
    public ThreadPool getThreadPool() {
    ) {
 * license agreements. See the NOTICE file distributed with
        return connectionManager;
            forceExecution,
    }
import java.util.Map;
        TransportRequestOptions options
            clusterSettings,
    /**
        TransportRequest request,
    /**
        public String toString() {
        @Nullable ClusterSettings clusterSettings,
import org.apache.logging.log4j.Logger;
     * @param listener the action listener to notify
    protected void validateActionName(String actionName) {
                        public String toString() {
     * Connect to the specified node with the given connection profile
     */
        } catch (IOException e) {
            taskManager,
     */
            settings,
            // the caller might not handle this so we invoke the handler
    }
    }
            return false;
    /**
        }
    }
     *
            streamTransport,
            clusterName.getEqualityPredicate(),
        /* Registers OpenSearch server specific exceptions (exceptions outside of core library) */
    }
     * Wipes out all pending disconnections.
    /**
        }
            sendRequest(connection, action, request, options, futureHandler);
                if (ThreadPool.Names.SAME.equals(executor)) {
        }
 * SPDX-License-Identifier: Apache-2.0
                final SendRequestTransportException sendRequestException = new SendRequestTransportException(node, action, e);
        public void handleResponse(T response) {
                time - timeoutInfoHolder.sentTime(),
        transport.setMessageListener(this);
import org.opensearch.tasks.Task;
            new ClusterConnectionManager(settings, transport),
            handler.handleException(ex);
        ThreadPool threadPool,
        final TransportRequest request,
            transportInterceptor,
        public String toString() {
            try (ThreadContext.StoredContext ignore = contextSupplier.get()) {
            if (Strings.isNullOrEmpty(currentId) || !extensionUniqueId.equals(currentId)) {
        // TODO we can probably fold this entire request ID dance into connection.sendReqeust but it will be a bigger refactoring
                final Transport.ResponseContext<? extends TransportResponse> holder = responseHandlers.remove(requestId);
    private final Logger tracerLog;
        }
     * Registers a new request handler
        @Nullable Transport streamTransport,
                handler.handleException(rtx);
        OpenSearchServerException.registerExceptions();
            String action,
        }
     *
 * Licensed to Elasticsearch under one or more contributor
        public void close() {}
        }
                        TransportException ex = new SendRequestTransportException(
     *
     *
                        return reg.isForceExecution();
        PlainActionFuture.get(
            if (handler != null) {
        try {
        @Override
     * start accepting incoming requests.
        } catch (final NodeNotConnectedException ex) {
        this.transport = transport;
            } catch (Exception inner) {
    public void handshake(
    /**
                    }
        final TransportRequestOptions options,
            for (TransportMessageListener listener : listeners) {
    /**
                    }
        @Override
        );
        this.remoteClusterClient = DiscoveryNode.isRemoteClusterClient(settings);
        final String action,
import org.opensearch.common.unit.TimeValue;
            if (lifecycle.stoppedOrClosed()) {
            this.action = action;
            if (timeoutHandler != null) {
            this.action = action;
                if (timeoutHandler != null) {
        }
    }
        return transport.addressesFromString(address);
                        return handler.executor();
        ContextRestoreResponseHandler<T> responseHandler = new ContextRestoreResponseHandler<>(storedContextSupplier, handler);
                        );
        messageListener.onRequestReceived(requestId, action);
        sendRequest(connection, action, request, options, handler);
    }
    public static boolean isValidActionName(String actionName) {
            listener.onResponse(null);
}
                    throw new ConnectTransportException(node, "handshake failed. unexpected remote node " + remote);
        public boolean isClosed() {
                    timeoutInfoHandlers.remove(requestId);
            handler = interceptor.interceptHandler(action, executor, forceExecution, handler, admissionControlActionType);
            return delegate.executor();
     * Connect to the specified node as an extension with the given connection profile.
                    public void onRejection(Exception e) {
        transport.close();
        boolean canTripCircuitBreaker,
        }
    /**
    void setTracerLogInclude(List<String> tracerLogInclude) {
        }
        }
            try {
                    for (Transport.ResponseContext holderToNotify : pruned) {
            forceExecution,
        this.threadPool = threadPool;
            DiscoveryNode node,
                listener.onRequestSent(node, requestId, action, request, finalOptions);
     * @opensearch.internal
    }
            taskManager,
                    holder.handler()
            }
        messageListener.onResponseSent(requestId, action, e);
        }
        final TransportResponseHandler<T> handler
        final Transport.Connection connection,
        if (!streamTransportMode) {
                @Override
            tracerLog.trace("[{}][{}] sent response", requestId, action);
     *
                delegate.handleStreamResponse(response);
    public void addMessageListener(TransportMessageListener listener) {
            // If holderToNotify == null then handler has already been taken care of.
                @Override
                    @Override
        Set<String> taskHeaders,
    /** if set will call requests sent to this id to shortcut and executed locally */
import java.util.Set;
    ) {
            sendRequestAsync(connection, action, request, options, traceableTransportResponseHandler);
                                    + response.clusterName.value()
        ThreadPool threadPool,
     * @param executor              The executor the request handling will be executed on
            handshake(newConnection, actualProfile.getHandshakeTimeout().millis(), cn -> true, ActionListener.map(listener, resp -> {
        }
     *
                    timeoutHandler.cancel();
        @Override
        public void addCloseListener(ActionListener<Void> listener) {}
    public <T extends TransportResponse> TransportFuture<T> submitRequest(
            }
            List<Transport.ResponseContext<? extends TransportResponse>> pruned = responseHandlers.prune(
        @Override
        messageListener.onResponseReceived(requestId, holder);
        public String action() {
                    }
        private volatile TimeoutHandler handler;
import org.opensearch.Version;
import org.opensearch.core.common.io.stream.StreamInput;
                }
            if (Regex.simpleMatch(include, action) == false) {
        connectToNodeAsExtension(node, (ConnectionProfile) null, extensionUniqueId);
        Set<String> taskHeaders,
            logger.warn(
 * under the License.
        connectToExtensionNode(node, null, listener);
     */
import java.util.concurrent.CopyOnWriteArrayList;
            connectionValidatorForExtensionConnectingToNode(node, extensionUniqueId),
     */
                    });
        connectionManager.connectToNode(node, connectionProfile, extensionConnectionValidator(node), listener);
     * Sends a request on the specified connection. If there is a failure sending the request, the specified handler is invoked.
            for (TransportMessageListener listener : listeners) {
            service.onResponseSent(requestId, action, exception);
        return transport.getRequestHandlers().getHandler(action);
        this.threadPool = threadPool;
        final TransportRequest request,
        final DiscoveryNode node,
        try {
     * @param action         The action the request handler is associated with
    // We are skipping node validation for extensibility as extensionNode and opensearchNode(LocalNode) will have different ephemeral id's
        TimeoutInfoHolder timeoutInfoHolder = timeoutInfoHandlers.remove(requestId);
                /*
import org.opensearch.core.common.transport.BoundTransportAddress;
    /**
    ) {
        }
        String executor,
/*
        PlainActionFuture.get(fut -> connectToNode(node, connectionProfile, ActionListener.map(fut, x -> null)));
    public static final TransportInterceptor NOOP_TRANSPORT_INTERCEPTOR = new TransportInterceptor() {
     * @param clusterSettings if non null, the {@linkplain TransportService} will register with the {@link ClusterSettings} for settings
    }
                timeoutInfoHandlers.put(requestId, new TimeoutInfoHolder(node, action, sentTime, timeoutTime));
            );
        transport.registerRequestHandler(reg);
        }
    ) throws TransportException {
    /**
        request.setParentTask(localNode.getId(), parentTask.getId());
     * this method is called
            action,
        final Task parentTask,
     *
    public final <T extends TransportResponse> void sendRequest(
        return isLocalNode(node) || connectionManager.nodeConnected(node);
                    }
            try {
import org.apache.logging.log4j.LogManager;
    }
    }
    }
    /** does nothing. easy way to ensure class is loaded so the above static block is called to register the streamables */
        Transport transport,
                        logger.warn("failed to notify response handler on exception, action: {}", contextToNotify.action(), e);
        @Override
        final DiscoveryNode node,
    final class TimeoutHandler implements Runnable {
    protected TaskManager createTaskManager(
import org.opensearch.common.logging.Loggers;
    }
     */
     * A channel for a direct response
                    }
            clusterSettings,
        if (handleIncomingRequests.get() == false) {
            }
    static class DirectResponseChannel implements TransportChannel {
            return;
                    } else {
                    processException(handler, rtx);
     * Executes a high-level handshake using the given connection
     */
 * specific language governing permissions and limitations
        TransportResponseHandler<T> handler
    }
     * The ActionListener will be called on the calling thread or the generic thread pool.
     * @param node the node to connect to
        RequestHandlerRegistry<Request> reg = new RequestHandlerRegistry<>(
                            processException(handler, rtx);
            false,
        public HandshakeResponse(StreamInput in) throws IOException {
            canTripCircuitBreaker
                        // noinspection unchecked
        @SuppressWarnings("unchecked")
         */
    }
    }
                    }
     * @param node the node to connect to
            handler.handleException(ex);
            // the caller might not handle this so we invoke the handler
    private boolean shouldTraceAction(String action) {
        public void sendResponse(TransportResponse response) throws IOException {
                // callback that an exception happened, but on a different thread since we don't
                    @Override
     *
            tracerLog.trace("[{}][{}] received response from [{}]", requestId, holder.action(), holder.connection().getNode());
        }
        return (newConnection, actualProfile, listener) -> {
    public void openConnection(
    }
    protected void sendLocalRequest(long requestId, final String action, final TransportRequest request, TransportRequestOptions options) {
    ) {
        }
                timeoutInfoHolder.action(),
                        listener.onFailure(
     */
    public static class HandshakeResponse extends TransportResponse {
    public void onConnectionClosed(Transport.Connection connection) {
            final TransportException te;
            false,
            logger.warn("invalid action name [" + actionName + "] must start with one of: " + TransportService.VALID_ACTION_PREFIXES);
            taskHeaders,
        }
import org.opensearch.core.action.ActionListener;
        Transport streamTransport,
    /**
        }
        final Transport.Connection connection;
        final TransportRequestOptions options,
        final Transport.Connection connection,
                    public void handleStreamResponse(StreamTransportResponse<T> response) {
        }
                listener.onResponseSent(requestId, action, error);
                        holderToNotify.handler().handleRejection(e);
     * The ActionListener will be called on the calling thread or the generic thread pool.
    public static final String DIRECT_RESPONSE_PROFILE = ".direct";
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
    }
            if (actionName.startsWith(prefix)) {
            // in case the transport is not connected to our local node (thus cleaned on node disconnect)
                public void onResponse(HandshakeResponse response) {
            this.service = service;
    @Override
    // An LRU (don't really care about concurrency here) that holds the latest timed out requests so if they
    }
        }
        }
        }
     * @param clusterNamePredicate cluster name validation predicate
                        .handleException(
            return getClass().getName() + "/" + delegate.toString();
                            holderToNotify.connection().getNode(),
        boolean streamTransportMode
                "cluster:internal",
            executor,
        validateActionName(action);
     * @param handler               The handler itself that implements the request handling
    public <T extends TransportResponse> TransportFuture<T> submitRequest(
 * software distributed under the License is distributed on an
        @Override
            if (reg == null) {
        this.clusterName = ClusterName.CLUSTER_NAME_SETTING.get(settings);
import java.util.function.Supplier;
    ) {
    public final <T extends TransportResponse> void sendRequest(
            }
    implements
    }
            taskManager,
import org.opensearch.action.support.PlainActionFuture;
    ) throws TransportException {
/**
        }
    static class TimeoutInfoHolder {
            threadPool,
        transport.registerRequestHandler(reg);
        public void run() {
    public TransportInfo info() {
    protected final Transport transport;
     *
    }
        }
                            return "delivery of failure response to [" + requestId + "][" + action + "]: " + exception;
import java.util.LinkedHashMap;
        if (clusterSettings != null) {
            throw new IllegalStateException("transport not ready yet to handle incoming requests");
            String currentId = threadPool.getThreadContext().getHeader("extension_unique_id");
            for (final Transport.ResponseContext holderToNotify : responseHandlers.prune(h -> true)) {
     * The executor service for this transport service.
        Tracer tracer
    }
            executor,
                + requestId
        return false;
                        }
                        // if we get rejected during node shutdown we don't wanna bubble it up
        }
        if (admissionControlActionType != null) {
import org.opensearch.OpenSearchServerException;
    }
    void setTracerLogExclude(List<String> tracerLogExclude) {
        boolean forceExecution,
        final TransportService service;
        this.tracerLogInclude = tracerLogInclude.toArray(Strings.EMPTY_ARRAY);
            // callback that an exception happened, but on a different thread since we don't
        private final String action;
                        @Override
                            new NodeClosedException(localNode)
        if (exclude.length > 0) {
        } catch (NodeNotConnectedException ex) {
                // want handlers to worry about stack overflows. In the special case of running into a closing node we run on the current
        }
     *
import org.opensearch.common.Nullable;
 * The main OpenSearch transport service
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                threadPool.executor(executor).execute(new AbstractRunnable() {
        @Nullable ClusterSettings clusterSettings,
    public void addConnectionListener(TransportConnectionListener listener) {
            connectionManager,
                }
        }
     *
     * and returns the discovery node of the node the connection
     */
        }
     * @param connectionProfile the connection profile to use when connecting to this node
                            .handleException(new NodeDisconnectedException(connection.getNode(), holderToNotify.action()));
 * this work for additional information regarding copyright
                            inner.addSuppressed(e);
        } else {
        this.interceptor = transportInterceptor;
                    threadPool.executor(executor).execute(new Runnable() {
        Settings settings,
            new ActionListenerResponseHandler<>(new ActionListener<HandshakeResponse>() {
import org.opensearch.core.common.io.stream.StreamOutput;
            super(in);
                ActionListener.wrap(
import java.util.function.Function;
import org.opensearch.common.regex.Regex;
        private final DiscoveryNode node;
            }));
        public void handleStreamResponse(StreamTransportResponse<T> response) {
                    }
        TaskManager taskManager,
     * @see #VALID_ACTION_PREFIXES
        public void cancel() {
    }
                    });
    public void onResponseReceived(long requestId, Transport.ResponseContext holder) {
            connectionManager.openConnection(node, connectionProfile, listener);
        return Objects.requireNonNull(discoveryNode, "discovery node must not be null").equals(localNode);
        @Override
     * @param action                The action the request handler is associated with
    public <T extends TransportResponse> void sendRequest(
     */
                                    + "] failed: remote cluster name ["
        this.localNodeFactory = localNodeFactory;
                        );
        if (holder == null) {
            clusterSettings.addSettingsUpdateConsumer(TransportSettings.SLOW_OPERATION_THRESHOLD_SETTING, transport::setSlowLogThreshold);
            }
        }
            throw new IllegalStateException("can't send request to a null connection");
            return localNodeConnection;
        Transport transport,
        connectionManager.connectToNode(
        } else {
    volatile String[] tracerLogExclude;
            listener
            logger.debug("Rejected execution on onConnectionClosed", ex);
    private final boolean remoteClusterClient;
        long requestId,
        // TODO: Making localNodeFactory BiConsumer is a bigger change since it should accept both default transport and
                te = (TransportException) ex;
        return transport.boundAddress();
                        listener.onFailure(
    }
     * @param extensionUniqueIq the id of the extension
     * The ActionListener will be called on the calling thread or the generic thread pool.
                            new ReceiveTimeoutTransportException(
                        reg.processMessageReceived(request, channel);
                    public boolean skipsDeserialization() {
     * are invoked we restore the context.
                "indices:data/write",
        final Span span = tracer.startSpan(SpanBuilder.from(action, connection));
                    }
    }
        };
    public List<String> getDefaultSeedAddresses() {
     * The ActionListener will be called on the calling thread or the generic thread pool.
        ) {
            tracerLog.trace("[{}][{}] sent error response", requestId, action, e);
    /**
        TransportInterceptor transportInterceptor,
        final String action,
            } else {
        String executor,
                 */
package org.opensearch.transport;
     * @param canTripCircuitBreaker Check the request size and raise an exception in case the limit is breached.
                final DiscoveryNode remote = resp.discoveryNode;
            this.version = version;
        }
        public ClusterName getClusterName() {
    public <T extends TransportResponse> void sendChildRequest(
