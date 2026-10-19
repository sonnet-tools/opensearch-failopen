    }  
            settings.get(  
        } catch (IOException e) {  
        NetworkService networkService,
                    closeAndFail(ex);  
        public Version getVersion() {
            }
        public NodeChannels(DiscoveryNode node, List<TcpChannel> channels, ConnectionProfile connectionProfile, Version handshakeVersion) {
        this.profileSettings = getProfileSettings(settings);
    private volatile BoundTransportAddress boundAddress;  
    }
        }
        } else {  
            logger.debug("binding server bootstrap to: {}", (Object) addresses);
    private static boolean appearsToBeTLS(BytesReference headerBuffer) {  
        List<String> publishHosts = profileSettings.publishHosts;
                            ch.addCloseListener(ActionListener.wrap(nodeChannels::close));
    }
            } finally {
        }
import java.util.TreeSet;  
        final TransportAddress publishAddress = new TransportAddress(new InetSocketAddress(publishInetAddress, publishPort));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        int port;  
            Thread.currentThread().interrupt();  
        }
        ChannelsConnectedListener channelsConnectedListener = new ChannelsConnectedListener(  
            throw new ConnectTransportException(null, "can't open connection to a null node");
     * @opensearch.internal
        String nodeName = Node.NODE_NAME_SETTING.get(settings);
        ).ports();
            .flatMap(address -> Arrays.stream(defaultPortRange()).limit(LIMIT_LOCAL_PORTS_COUNT).mapToObj(port -> address + ":" + port))
 * under the License.  
    private final class ChannelsConnectedListener implements ActionListener<Void> {  
        }  
                channel,  
import org.opensearch.common.unit.TimeValue;
    private static final int BYTES_NEEDED_FOR_MESSAGE_SIZE = TcpHeader.MARKER_BYTES_SIZE + TcpHeader.MESSAGE_LENGTH_SIZE;
                ? TransportSettings.PUBLISH_PORT.get(settings)  
                            // Mark the channel init time  
                return false;
                }
            if (buffer.get(i) != chars[i]) {
        public DiscoveryNode getNode() {
        }
    protected final PageCacheRecycler pageCacheRecycler;  
    }
            throw new IllegalArgumentException(
        }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        Objects.requireNonNull(hostPortString);
        }
            closeLock.writeLock().unlock();
    protected final NetworkService networkService;
            for (int i = 0; i < hostAddresses.length; i++) {
        try {
        }
        public final boolean reuseAddress;
                    List<TcpServerChannel> channels = entry.getValue();  
            // use a sorted set to present the features in a consistent order
        }
import static org.opensearch.common.transport.NetworkExceptionHelper.isCloseConnectionException;  
        private final AtomicBoolean isClosing = new AtomicBoolean(false);  
                throw new IllegalArgumentException("Invalid bracketed host/port range: " + hostPortString);
    protected void bindServer(ProfileSettings profileSettings) {  
                throw new IllegalArgumentException("no type channel for [" + type + "]");
        return bufferStartsWith(headerBuffer, "HTTP");  
        public void onFailure(Exception e) {
            }
     */
import org.opensearch.core.rest.RestStatus;
    }  
    // This allows transport implementations to potentially override specific connection profiles. This
    }  
    }
        long requestId = responseHandlers.newRequestId();
                            e instanceof ConnectTransportException  
        }
            nodeName,
        public TcpChannel channel(TransportRequestOptions.Type type) {
            .collect(Collectors.toList());  
        if (messageLength == TransportKeepAlive.PING_DATA_SIZE) {
        BigArrays bigArrays = new BigArrays(pageCacheRecycler, circuitBreakerService, CircuitBreaker.IN_FLIGHT_REQUESTS);
    }
            Setting<String> concretePort = TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(profileName);  
            });
        } else if (e instanceof BindException) {
            port = defaultPort;  
                    + " with distinct ports and none of them matched the publish address ("  
            closeLock.writeLock().lock();
        @Override
        }
        return true;
            this.node = node;
            this.node = node;  
            return readHeaderBuffer(networkBytes);
    }  
    /**
        private final DiscoveryNode node;
    @Deprecated
    @Override
                stopInternal();
        return threadPool;
            if (connectionTypeHandle == null) {  
     * @throws IllegalArgumentException              if the message length is greater that the maximum allowed frame size.
     * @opensearch.api  
        }
        for (int i = 0; i < numConnections; ++i) {
        }
            if (isClosing.compareAndSet(false, true)) {
                        e -> closeAndFail(
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
            outboundHandler,  
        handleException(channel, e, lifecycle, outboundHandler);  
     */
            version = handshakeVersion;  
        this.handshakerHandler = new NativeOutboundHandler(
                host = hostPortString;
    }
        }
            this.listener = listener;
            } catch (Exception ex) {  
import org.apache.logging.log4j.message.ParameterizedMessage;
        for (InetAddress hostAddress : hostAddresses) {
        ThreadPool threadPool,  
import java.nio.channels.CancelledKeyException;  
            ActionListener<Transport.Connection> listener  
    private static final long THIRTY_PER_HEAP_SIZE = (long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.3);
                    TcpServerChannel channel = bind(name, new InetSocketAddress(hostAddress, portNumber));  
        private final Version version;
     */  
    }  
            }
            statsTracker,
            boundAddresses.add(bindToPort(profileSettings.profileName, hostAddress, profileSettings.portOrRange));  
        final int messageLength = headerBuffer.getInt(TcpHeader.MARKER_BYTES_SIZE);
        threadPool.generic().execute(() -> {
import org.opensearch.core.action.ActionListener;  
        try {
            // close the channel as safe measure, which will cause a node to be disconnected if relevant
                throw new StreamCorruptedException(
            // No need for locking here since Lifecycle objects can't move from STARTED to INITIALIZED  
            profiles.add(new ProfileSettings(settings, TransportSettings.DEFAULT_PROFILE));
import java.util.Map;  
            features,
            super(msg);
            // Parse a bracketed host, typically an IPv6 literal.
     * @param address the address to bind to
        final Settings defaultFeatures = TransportSettings.DEFAULT_FEATURES_SETTING.get(settings);  
import org.opensearch.core.common.io.stream.StreamInput;  
        Version version,  
                false,  
                portString = hostPortString.substring(colonPos + 1);
 * this work for additional information regarding copyright
    private final Set<TcpChannel> acceptedChannels = ConcurrentCollections.newConcurrentSet();
        public final ByteSizeValue sendBufferSize;
 * license agreements. See the NOTICE file distributed with
            handshakerHandler.sendRequest(node, channel, requestId, action, request, options, getVersion(), compress, false);
        );  
    protected abstract void stopInternal();
import org.opensearch.common.annotation.PublicApi;
            } catch (ConnectTransportException e) {
    @Override
    }  
    }
            boolean success = portsRange.iterate(portNumber -> {
            logger.debug("Bound profile [{}] to address {{}}", name, NetworkAddress.format(boundSocket.get()));
        closeLock.readLock().lock(); // ensure we don't open connections while we are closing
    private List<TcpChannel> initiateConnection(
    @Override
    }
                + Integer.toHexString(headerBuffer.get(0) & 0xFF)
            );
    @Override
            return connectionTypeHandle.getChannel(channels);  
            if (countDown.fastForward()) {
    }
            onException(channel, e);
        this.networkService = networkService;
     * @param message the message
    public void executeHandshake(DiscoveryNode node, TcpChannel channel, ConnectionProfile profile, ActionListener<Version> listener) {  
            responseHandlers,
            this.openTimeMillis = openTimeMillis;
    }  
            if (lifecycle.initialized() == false && lifecycle.started() == false) {
            // close the channel as safe measure, which will cause a node to be disconnected if relevant  
            .rxCount(messagesReceived)
                );
            statsTracker,  
    @Override
                "transport content length received ["  
        return handshaker.getNumPendingHandshakes();
     *
            )  
import org.opensearch.common.lifecycle.Lifecycle;
import java.util.concurrent.locks.ReadWriteLock;
                        + "HTTP port) of a remote node is specified in the configuration"  
                    + TransportSettings.PORT.getKey()
        public final boolean isDefaultProfile;
        } else if (e instanceof StreamCorruptedException) {  
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Transport.Connection> listener) {  
                    "received HTTP response on transport port, ensure that transport port (not "
                () -> new ParameterizedMessage(
                closeAndFail(new ConnectTransportException(node, "connect_timeout[" + connectionProfile.getConnectTimeout() + "]"));
    // this lock is here to make sure we close this transport and disconnect all the client nodes  
        } else {
        );
        private final ConnectionProfile connectionProfile;  
        ActionListener<Transport.Connection> listener
import java.util.concurrent.ConcurrentMap;
            port = Integer.parseInt(portString);
            return -1;  
            // just close and ignore - we are already stopped and just need to make sure we release all resources  
                // 0 or 2+ colons. Bare hostname or IPv6 literal.  
    }
    private static int readHeaderBuffer(BytesReference headerBuffer) throws IOException {  
        String nodeName,
    static void handleException(TcpChannel channel, Exception e, Lifecycle lifecycle, OutboundHandler outboundHandler) {
            logger.debug("closed transport connection [{}] to [{}] with age [{}ms]", connectionId, node, closeTimeMillis - openTimeMillis);
     * @deprecated Use {{@link #inboundMessage(TcpChannel, InboundMessage)}} instead
        List<String> profileBindHosts = profileSettings.bindHosts;  
                listener.onFailure(new ConnectTransportException(node, "general node connection failure", e));
        final long messagesSent = statsTracker.getMessagesSent();  
                );
     * A helper exception to mark an incoming connection as potentially being HTTP  
            publishPort = isDefaultProfile
                } finally {  
                + ","
        final List<TcpChannel> channels = new ArrayList<>(numConnections);  
import java.util.Set;
                } catch (Exception ex) {
import org.opensearch.common.network.NetworkUtils;  
 */
import org.opensearch.core.common.bytes.BytesReference;
                requestId,
            publishInetAddress = networkService.resolvePublishHostAddresses(publishHosts.toArray(Strings.EMPTY_ARRAY));
            // close the channel, which will cause a node to be disconnected if relevant
        handshaker.sendHandshake(requestId, node, channel, profile.getHandshakeTimeout(), listener);
    public StatsTracker getStatsTracker() {
            String firstBytes = "("
        public List<TcpChannel> getChannels() {  
        final MeanMetric writeBytesMetric = statsTracker.getWriteBytes();
     */
        local.add("127.0.0.1");
import java.util.HashSet;
    // this limit is per-address  
        for (int i = 0; i < chars.length; i++) {  
    protected final void doClose() {}  
import org.opensearch.common.Booleans;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            super(in);
                if (Booleans.parseBoolean(defaultFeatures.get(key)) == false) {  
    public void onException(TcpChannel channel, Exception e) {
import java.nio.charset.StandardCharsets;
    private final NativeOutboundHandler handshakerHandler;  
        }
            ConnectionProfile.ConnectionTypeHandle connectionTypeHandle = typeMapping.get(type);
    public BoundTransportAddress boundAddress() {
                CloseableChannel.closeChannels(channels, false);
    }  
            logger.error(new ParameterizedMessage("exception from server channel caught on transport layer [{}]", channel), e);
        TransportAddress[] transportBoundAddresses = new TransportAddress[boundAddresses.size()];  
            CloseableChannel.closeChannel(channel);
    }  
        return new TransportStats.Builder().serverOpen(acceptedChannels.size())  
            if (TransportSettings.DEFAULT_PROFILE.equals(profile)) {
            statsTracker,
                new TransportHandshaker.HandshakeRequest(version),  
import org.opensearch.threadpool.ThreadPool;  
import java.net.InetSocketAddress;
        this.inboundHandler = createInboundHandler(
        if (portString == null || portString.isEmpty()) {
     */
            } finally {  
        handshakerHandler.setMessageListener(listener);
        this.keepAlive = new TransportKeepAlive(threadPool, this.outboundHandler::sendBytes);
                + ","
        private final long openTimeMillis;
            bindHosts = (profileBindHosts.isEmpty() ? NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(settings) : profileBindHosts);
    private final ResponseHandlers responseHandlers = new ResponseHandlers();
                        )  
    }
                + "]";  
        } else {
import org.opensearch.common.network.NetworkAddress;
            keepAlive,
            long closeTimeMillis = threadPool.relativeTimeInMillis();  
        return messageLength;
import org.opensearch.core.common.Strings;
            }  
                    ));
                () -> new ParameterizedMessage(
        return Collections.unmodifiableSet(profiles);  
            String[] addresses = new String[hostAddresses.length];
    public synchronized void setMessageListener(TransportMessageListener listener) {  
    private final TransportKeepAlive keepAlive;  
                    + "]"
                try {
            .txCount(messagesSent)
        }
            tcpNoDelay = TransportSettings.TCP_NO_DELAY_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
     * Binds to the given {@link InetSocketAddress}
                    CloseableChannel.closeChannels(channels, block);
     *
        if (logger.isDebugEnabled()) {  
                        nodeChannels.addCloseListener(new ChannelCloseLogger(node, connectionId, relativeMillisTime));
            outboundHandler
                    serverChannels.computeIfAbsent(name, k -> new ArrayList<>()).add(channel);
            // close the channel, which will cause a node to be disconnected if relevant
        this.threadPool = threadPool;
                        });  
        this.settings = settings;
    }  
    private final OutboundHandler outboundHandler;
    public Map<String, BoundTransportAddress> profileBoundAddresses() {
                TransportHandshaker.HANDSHAKE_ACTION_NAME,
 * GitHub history for details.
        ResponseHandlers responseHandlers,
    @Override
                throw new BindTransportException(
    protected final void doStop() {  
            || bufferStartsWith(headerBuffer, "HEAD")  
        return local.stream()
        } else {
    ) {
            requestHandlers,
                    throw new IllegalArgumentException("feature settings must have default [true] value");
            CloseableChannel.closeChannel(channel);
                throw new NodeNotConnectedException(node, "connection already closed");
    // primarily exists for the test implementations.  
        }
                acceptedChannels.clear();  
            .toArray(TransportAddress[]::new);
        private final DiscoveryNode node;  
            try {
 * compatible open source license.
        if (messageLength <= 0) {  
        final long bytesRead = statsTracker.getBytesRead();
        return boundSocket.get();
            assert false : e; // never called  
        InetAddress[] hostAddresses;
        }
                            ch.getChannelStats().markAccessed(relativeMillisTime);
            int colonPos = hostPortString.indexOf(':');  
                channels.add(channel);  
            tcpKeepIdle = TransportSettings.TCP_KEEP_IDLE_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
        private void closeAndFail(Exception e) {  
                        keepAlive.registerNodeConnection(nodeChannels.channels, connectionProfile);
            CloseableChannel.closeChannel(channel);  
    /**  
import org.opensearch.Version;
            transportBoundAddresses[i] = new TransportAddress(boundAddress);
    public TcpTransport(  
                        NodeChannels nodeChannels = new NodeChannels(node, channels, connectionProfile, version);  
        CircuitBreakerService circuitBreakerService,
            defaultFeatures.names().forEach(key -> {
            throw new StreamCorruptedException("invalid data length: " + messageLength);
import org.opensearch.common.network.NetworkService;
    public static class HttpRequestOnTransportException extends OpenSearchException {
 *  
     * @return the pending connection  
                    CloseableChannel.closeChannels(channels, true);  
import java.util.EnumMap;
import org.opensearch.cluster.node.DiscoveryNode;  
                // first stop to accept any incoming connections so nobody can connect to this transport  
import java.util.Arrays;  
        if (logger.isDebugEnabled()) {  
     * Returns all profile settings for the given settings object
        this.pageCacheRecycler = pageCacheRecycler;
    public List<String> getDefaultSeedAddresses() {  
    public final RequestHandlers getRequestHandlers() {
    final int getNumPendingHandshakes() {  
            CloseableChannel.closeChannel(channel);
        final AtomicReference<Exception> lastException = new AtomicReference<>();
    final Set<TcpChannel> getAcceptedChannels() {
                    channel  
                    );
            // Returns true if all connections have completed successfully
                + Integer.toHexString(headerBuffer.get(1) & 0xFF)
import java.net.UnknownHostException;
                node,
    final TransportKeepAlive getKeepAlive() {
            || bufferStartsWith(headerBuffer, "OPTION")  
        channel.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
                v,
        final long bytesWritten = statsTracker.getBytesWritten();
            logger.debug(() -> new ParameterizedMessage("bind exception caught on transport layer [{}]", channel), e);
import java.util.HashMap;  
                true
        if (headerBuffer.get(0) != 'E' || headerBuffer.get(1) != 'S') {
        }
        ConnectionProfile finalProfile = maybeOverrideConnectionProfile(profile);  
import java.util.function.Supplier;  
        public RestStatus status() {  
        });
        return new PortsRange(
    private final Map<String, List<TcpServerChannel>> serverChannels = newConcurrentMap();  
        }
     * @throws IllegalStateException if the transport is not started / open  
                ),
            InetSocketAddress boundAddress = boundAddresses.get(i);
    }
            sendBufferSize = TransportSettings.TCP_SEND_BUFFER_SIZE_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
        }  
 * @opensearch.api
    private final Version version;
        int numConnections = connectionProfile.getNumConnections();  
        }
        public final int tcpKeepCount;  
            }  
        return connectionProfile;
        if (lifecycle.started() == false) {  
            throws IOException, TransportException {
import org.opensearch.common.transport.PortsRange;  
        String portString = null;
            publishHosts = TransportSettings.PUBLISH_HOST_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
            inboundHandler.inboundMessage(channel, message);
            }  
        ) {
            if (concretePort.exists(settings) == false && isDefaultProfile == false) {
            .txSize(bytesWritten)
            }
                        final long connectionId = outboundConnectionCount.incrementAndGet();
            // ignore
                // 2+ colons and not bracketed: exception
                    String profile = entry.getKey();
            Matcher matcher = BRACKET_PATTERN.matcher(hostPortString);
        private final List<TcpChannel> channels;
            || bufferStartsWith(headerBuffer, "PUT")
        public ProfileSettings(Settings settings, String profileName) {
import org.opensearch.common.util.BigArrays;
    protected final InboundHandler inboundHandler;
    }  
        String[] boundAddressesHostStrings = new String[boundAddresses.size()];
            throw new StreamCorruptedException("invalid internal transport message format, got " + firstBytes);  
    public final TransportStats getStats() {  
    public Supplier<CircuitBreaker> getInflightBreaker() {
                throw new StreamCorruptedException("SSL/TLS request received but SSL/TLS is not enabled on this node, got " + firstBytes);  
            }
            // This is a ping
            this.channels = Collections.unmodifiableList(channels);
                    + new ByteSizeValue(messageLength)
        BigArrays bigArrays,
        DiscoveryNode node,
    protected InboundHandler createInboundHandler(
            TcpChannel channel = channel(options.type());  
    private final ConcurrentMap<String, BoundTransportAddress> profileBoundAddresses = newConcurrentMap();
        closeLock.writeLock().lock();
                TransportRequestOptions.EMPTY,
        String host;  
        PageCacheRecycler pageCacheRecycler,
    protected ConnectionProfile maybeOverrideConnectionProfile(ConnectionProfile connectionProfile) {
        try {
            features = new String[0];  
            receiveBufferSize = TransportSettings.TCP_RECEIVE_BUFFER_SIZE_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
        return requestHandlers;  
     *
            this.connectionProfile = connectionProfile;  
        this.circuitBreakerService = circuitBreakerService;  
/*
                e
        if (isCloseConnectionException(e)) {
    /**
    private final CircuitBreakerService circuitBreakerService;  
        OutboundHandler outboundHandler,
    public TransportAddress[] addressesFromString(String address) throws UnknownHostException {  
            }
        Tracer tracer
            );
            try {  
        final CountDownLatch latch = new CountDownLatch(1);
        for (String profile : settings.getGroups("transport.profiles.", true).keySet()) {  
                }
            requestHandlers,  
    // pattern for validating ipv6 bracket addresses.  
    private final RequestHandlers requestHandlers = new RequestHandlers();
    private final TransportHandshaker handshaker;
        if (networkBytes.length() < BYTES_NEEDED_FOR_MESSAGE_SIZE) {
        final BoundTransportAddress boundTransportAddress = createBoundTransportAddress(profileSettings, boundAddresses);  
            .map(address -> new TransportAddress(address, port))
    @Override
        } else if (e instanceof CancelledKeyException) {
            if (!success) {  
                    + new ByteSizeValue(THIRTY_PER_HEAP_SIZE)  
        return () -> circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
            threadPool,  
        } else {
            throw new BindTransportException("Failed to resolve publish address", e);
        }
import org.opensearch.common.network.CloseableChannel;  
        );  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
                throw new HttpRequestOnTransportException("This is not an HTTP port");  
 * Modifications Copyright OpenSearch Contributors. See  
     *                                               This is dependent on the available memory.
                    + "Please specify a unique port by setting "  
        return this.boundAddress;  
import org.opensearch.core.common.transport.TransportAddress;
        return headerBuffer.get(0) == 0x16 && headerBuffer.get(1) == 0x03;
            if (appearsToBeTLS(headerBuffer)) {
import org.apache.logging.log4j.LogManager;  
 */
 * Unless required by applicable law or agreed to in writing,
            latch.await(30, TimeUnit.SECONDS);
    // This is the number of bytes necessary to read the message size  
    // exposed for tests  
                throw new IllegalStateException("transport has been stopped");
            }
        Settings settings,
            || bufferStartsWith(headerBuffer, "PATCH")
    }  
        PortsRange portsRange = new PortsRange(port);
                e
    /**
            tcpKeepAlive = TransportSettings.TCP_KEEP_ALIVE_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
        if (profileSettings.isDefaultProfile == false && publishHosts.isEmpty()) {
     * @param name    the profile name  
 * software distributed under the License is distributed on an
            }  
     * Initiate a single tcp socket channel.  
            CloseableChannel.closeChannel(channel);  
            logger.debug(() -> new ParameterizedMessage("connect exception caught on transport layer [{}]", channel), e);
        return new InboundHandler(
    // not perfect, but PortsRange should take care of any port range validation, not a regex
        @Override  
            String profileExplanation = profileSettings.isDefaultProfile ? "" : " for profile " + profileSettings.profileName;  
        List<String> local = new ArrayList<>();
    }
        } else {
            logger.debug(  
    private class ChannelCloseLogger implements ActionListener<Void> {
    private final AtomicLong outboundConnectionCount = new AtomicLong(); // also used as a correlation ID for open/close logs
        }
                        nodeChannels.channels.forEach(ch -> {
            outboundHandler,
        Tracer tracer
            typeMapping = new EnumMap<>(TransportRequestOptions.Type.class);
        } else if (e instanceof HttpRequestOnTransportException) {  
    final StatsTracker statsTracker = new StatsTracker();
        // Mark the channel init time  
                CloseableChannel.closeChannels(new ArrayList<>(acceptedChannels), true);
    protected void doStart() {}  
            compress = connectionProfile.getCompressionEnabled();
                closeLock.writeLock().unlock();
import java.util.List;
        NamedWriteableRegistry namedWriteableRegistry,  
            namedWriteableRegistry,
 *  
}
        if (NetworkUtils.SUPPORTS_V6) {
        return Collections.unmodifiableSet(acceptedChannels);  
            local.add("[::1]"); // may get ports appended!
            features = new TreeSet<>(defaultFeatures.names()).toArray(new String[defaultFeatures.names().size()]);
        @Override
    /**
        }
        } else if (isConnectException(e)) {  
     * are not available, it returns -1.
        }
        this.handshaker = new TransportHandshaker(
            features,
            // Actually 'OPTIONS'. But we are only guaranteed to have read six bytes at this point.
                CloseableChannel.closeChannels(channels, false);
        }
            boundAddressesHostStrings[i] = boundAddress.getHostString();  
        public final ByteSizeValue receiveBufferSize;  
        // check if v6 is supported, if so, v4 will also work via mapped addresses.  
import java.util.concurrent.locks.ReentrantReadWriteLock;
 * this file be licensed under the Apache-2.0 license or a
            if (appearsToBeHTTPResponse(headerBuffer)) {  
    private int[] defaultPortRange() {
     *
                logger.trace(() -> new ParameterizedMessage("Tcp transport channel opened: {}", channel));
    }
                }
            responseHandlers,
            for (ConnectionProfile.ConnectionTypeHandle handle : connectionProfile.getHandles()) {
        final AtomicReference<InetSocketAddress> boundSocket = new AtomicReference<>();  
        return bufferStartsWith(headerBuffer, "GET")  
                    executeHandshake(node, handshakeChannel, connectionProfile, ActionListener.wrap(version -> {  
    static TransportAddress[] parse(String hostPortString, int defaultPort) throws UnknownHostException {
import org.opensearch.monitor.jvm.JvmInfo;  
                // Exactly 1 colon. Split into host:port.
                listener.onFailure(e);  
            || bufferStartsWith(headerBuffer, "POST")
        return keepAlive;  
        }
            portString = matcher.group(2);  // could be null
import org.opensearch.core.common.bytes.BytesArray;  
        }
        }
                listener.onFailure(e);  
            logger.debug(() -> new ParameterizedMessage("bind exception from server channel caught on transport layer [{}]", channel), e);  
        public void onFailure(Exception ex) {  
            version,
            new ThreadedActionListener<>(logger, threadPool, ThreadPool.Names.GENERIC, listener, false)
        public final List<String> bindHosts;
        if (profileSettings.isDefaultProfile) {
        );  
     * @opensearch.internal  
                } catch (Exception e) {  
        private ChannelsConnectedListener(
        inboundHandler.setMessageListener(listener);
        char[] chars = method.toCharArray();
            return RestStatus.BAD_REQUEST;
public abstract class TcpTransport extends AbstractLifecycleComponent implements Transport {
        }  
            CloseableChannel.closeChannel(channel);
            }  
import java.io.StreamCorruptedException;
                BytesArray message = new BytesArray(e.getMessage().getBytes(StandardCharsets.UTF_8));  
        } catch (InterruptedException e) {
                    throw new IllegalArgumentException("IPv6 addresses must be bracketed: " + hostPortString);
                    // Call the super method to trigger listeners
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "). "
import org.opensearch.core.common.breaker.CircuitBreaker;
    }
        }  
        private final long connectionId;
import org.opensearch.common.settings.Setting;
import java.net.BindException;
    private BoundTransportAddress createBoundTransportAddress(ProfileSettings profileSettings, List<InetSocketAddress> boundAddresses) {
        return statsTracker;
                    + ", multiple bound addresses "
import static java.util.Collections.unmodifiableMap;
    public void inboundMessage(TcpChannel channel, ProtocolInboundMessage message) {
 * The TCP Transport layer
/*
        // Bind and start to accept incoming connections.
        this.version = version;  
                    "cancelled key exception caught on transport layer [{}], disconnecting from relevant node",
                TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(TransportSettings.DEFAULT_PROFILE).getKey(),
     */
            if (colonPos >= 0 && hostPortString.indexOf(':', colonPos + 1) == -1) {
@PublicApi(since = "1.0.0")  
        TransportHandshaker handshaker,
        }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        if (hostPortString.startsWith("[")) {  
            List<TcpChannel> channels,
                    + profileExplanation  
            if (countDown.countDown()) {  
        public void onResponse(Void ignored) {
    }  
        return responseHandlers;
            );  
        }  
                    channel  
        private final Map<TransportRequestOptions.Type, ConnectionProfile.ConnectionTypeHandle> typeMapping;
                    "Failed to bind to " + NetworkAddress.format(hostAddress, portsRange),
            } catch (Exception e) {
            portOrRange = TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
            }  
    }
        }
        return channels;
        assert hostAddresses.length > 0;
    // this code is a take on guava's HostAndPort, like a HostAndPortRange
            tracer
     * Called to tear down internal resources  
    private static final Pattern BRACKET_PATTERN = Pattern.compile("^\\[(.*:.*)\\](?::([\\d\\-]*))?$");
                                ? e
    /**  
                TcpChannel channel = initiateChannel(node);
    }
 */  
            if (appearsToBeHTTPRequest(headerBuffer)) {
            assert channels.size() == connectionProfile.getNumConnections() : "expected channels size to be == "
                    "close connection exception caught on transport layer [{}], disconnecting from relevant node",
        private final DiscoveryNode node;  
            return this.node;  
            logger.warn(() -> new ParameterizedMessage("exception caught on transport layer [{}], closing connection", channel), e);
        }
        @Override
            host = matcher.group(1);  
            reuseAddress = TransportSettings.TCP_REUSE_ADDRESS_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);  
    public static int readMessageLength(BytesReference networkBytes) throws IOException {
                        listener.onResponse(nodeChannels);  
            this.boundAddress = boundTransportAddress;  
 * Licensed to Elasticsearch under one or more contributor  
        public void close() {
import java.util.ArrayList;
        ConnectionProfile connectionProfile,  
import org.opensearch.action.support.ThreadedActionListener;
        }
    public ThreadPool getThreadPool() {  
            this.node = node;
    @Override  
 *
    }
        try {
            if (channel.isOpen()) {
                + Integer.toHexString(headerBuffer.get(2) & 0xFF)  
import org.opensearch.common.util.PageCacheRecycler;  
    protected final Set<ProfileSettings> profileSettings;
            .rxSize(bytesRead)  
    @PublicApi(since = "1.0.0")
 *
                return channels;
        HashSet<ProfileSettings> profiles = new HashSet<>();
            version,  
            } else {
                return true;
        if (messageLength > THIRTY_PER_HEAP_SIZE) {
    public static final String TRANSPORT_WORKER_THREAD_NAME_PREFIX = "transport_worker";
        public final int publishPort;
     *
                "Failed to auto-resolve publish port"
    }
        public void onResponse(Void v) {
     * @param networkBytes the will be read  
    public Version getVersion() {  
/*  
import java.util.concurrent.TimeUnit;  
            bigArrays,
            channel.addConnectListener(channelsConnectedListener);
            (node, channel, requestId, v) -> handshakerHandler.sendRequest(
        assert numConnections > 0 : "A connection profile must be configured with at least one connection";
                    super.close();
        try {  
        assert addedOnThisCall : "Channel should only be added to accepted channel set once";
        if (publishPort == -1) {
                }  
    protected void ensureOpen() {
     *
        );
import org.opensearch.core.common.unit.ByteSizeValue;  
            // in case we are able to return data, serialize the exception content and sent it back to the client
            logger.debug(  
    protected final ThreadPool threadPool;
    private static boolean bufferStartsWith(BytesReference buffer, String method) {
        try {
import java.util.stream.Collectors;  
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        threadPool.schedule(channelsConnectedListener::onTimeout, connectTimeout, ThreadPool.Names.GENERIC);  
    /**
    }
import java.net.InetAddress;  
     * @param channel the channel the message is from  
        }  
        }  
        this.outboundHandler = new OutboundHandler(statsTracker, threadPool);  
    /**
                        logger.debug("opened transport connection [{}] to [{}] using channels [{}]", connectionId, node, channels);
                addresses[i] = NetworkAddress.format(hostAddresses[i]);  
     * so an appropriate error code can be returned
     */
        TimeValue connectTimeout = connectionProfile.getConnectTimeout();
     */  
            threadPool,  
    }
            node,
     * Representation of a transport profile settings for a {@code transport.profiles.$profilename.*}
                return channels;
    }
    }
                + ")";  
        private final ActionListener<Transport.Connection> listener;
            initiateConnection(node, finalProfile, listener);
                    lastException.set(e);
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
                + " but was: ["
        List<InetSocketAddress> boundAddresses = new ArrayList<>();
            );  
import java.util.concurrent.CountDownLatch;
                                : new ConnectTransportException(node, "general node connection failure", e)
            this.channels = channels;
                    return false;
                serverChannels.clear();
                if (colonPos >= 0) {  
        return new BoundTransportAddress(transportBoundAddresses, publishAddress);
            keepAlive,  
    }  
        if (!lifecycle.started()) {
        RequestHandlers requestHandlers,  
     * parse a hostname+port spec into its equivalent addresses
        if (node == null) {  
                    + " or "
            threadPool,  
    }
                    + "] exceeded ["
    }  
        private final CountDown countDown;  
        public final boolean tcpKeepAlive;  
            publishHosts = Arrays.asList(boundAddressesHostStrings);  
     * Validates the first 6 bytes of the message header and returns the length of the message. If 6 bytes  
    /**  
                    + publishInetAddress
            }
            )
                        e -> logger.warn(() -> new ParameterizedMessage("Error closing serverChannel for profile [{}]", profile), e)  
        @Override  
        return version;
     *  
            isDefaultProfile = TransportSettings.DEFAULT_PROFILE.equals(profileName);  
     * @throws IOException if an I/O exception occurs while opening the channel
        assert threadPool.generic().isShutdown() == false : "Must stop transport before terminating underlying threadpool";  
                    boundSocket.set(channel.getLocalAddress());
import java.util.concurrent.atomic.AtomicBoolean;
/**
        // make sure we run it on another thread than a possible IO handler thread
        private final List<TcpChannel> channels;
import org.opensearch.telemetry.tracing.Tracer;
    public static Set<ProfileSettings> getProfileSettings(Settings settings) {  
            closeLock.readLock().unlock();  
        public final boolean tcpNoDelay;
        } catch (Exception e) {  
            }
            return 0;  
    @Override
            connectionProfile,
        }  
            throw new BindTransportException("Failed to resolve host " + profileBindHosts, e);
    }
        final long messagesReceived = statsTracker.getMessagesReceived();
     * @param node for the initiated connection
     */  
                e.addSuppressed(ex);
            }
            }
                    ActionListener<Void> closeFailLogger = ActionListener.wrap(
            throw new BindTransportException(
            tcpKeepCount = TransportSettings.TCP_KEEP_COUNT_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
                    boolean block = lifecycle.stopped() && Transports.isTransportThread(Thread.currentThread()) == false;
            tracer  
            }  
     * List of node connection channels
                throw new IllegalStateException("profile [" + profileName + "] has no port configured");
            bigArrays,
        return handshaker.getNumHandshakes();
     */
    protected abstract TcpServerChannel bind(String name, InetSocketAddress address) throws IOException;  
        }
    }
        public final String portOrRange;  
        }
                for (Map.Entry<String, List<TcpServerChannel>> entry : serverChannels.entrySet()) {
                }  
        @Override
        String[] features,
        channel.addCloseListener(ActionListener.wrap(() -> acceptedChannels.remove(channel)));
                TransportSettings.PORT.get(settings)
    public void setSlowLogThreshold(TimeValue slowLogThreshold) {  
 * ownership. Elasticsearch licenses this file to you under  
        public void onTimeout() {  
        return Arrays.stream(InetAddress.getAllByName(host))
        }
    protected final Settings settings;  
                    + boundAddresses
            hostAddresses = networkService.resolveBindHostAddresses(profileBindHosts.toArray(Strings.EMPTY_ARRAY));
        }  
     */
import org.opensearch.core.common.transport.BoundTransportAddress;
            namedWriteableRegistry,  
                final TcpChannel handshakeChannel = channels.get(0);
    public PageCacheRecycler getPageCacheRecycler() {
            ensureOpen();  
        if (isDefaultSet == false) {  
            CloseableChannel.closeChannel(channel);
        inboundHandler.setSlowLogThreshold(slowLogThreshold);
        }  
        // if port isn't specified, fill with the default
        @Override
        private final boolean compress;
            profiles.add(new ProfileSettings(settings, profile));
    /**  
import org.opensearch.common.metrics.MeanMetric;
    public final class NodeChannels extends CloseableConnection {  
                }
            }
    }  
            || bufferStartsWith(headerBuffer, "TRACE");
                + channels.size()
                isDefaultSet = true;  
    }
 * The OpenSearch Contributors require contributions made to  
            threadPool,
            profileBoundAddresses.put(profileSettings.profileName, boundTransportAddress);
            }
    private static boolean appearsToBeHTTPResponse(BytesReference headerBuffer) {
                + ","  
        public final int tcpKeepInterval;
            handshaker,
        public HttpRequestOnTransportException(StreamInput in) throws IOException {
import static org.opensearch.common.transport.NetworkExceptionHelper.isConnectException;
        public final String profileName;
            return version;  
    /**
    // connections while no connect operations is going on
            return;
package org.opensearch.transport;
     * Ensures this transport is still started / open
            }
    ) {  
                try {
                for (TransportRequestOptions.Type type : handle.getTypes())  
                try {  
     *
import java.util.concurrent.atomic.AtomicReference;  
            }  
        return unmodifiableMap(new HashMap<>(profileBoundAddresses));
    }
        if (publishHosts.isEmpty()) {
                : TransportSettings.PUBLISH_PORT_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
 */
            this.profileName = profileName;
            .build();  
            || bufferStartsWith(headerBuffer, "DELETE")
                    typeMapping.put(type, handle);
            });  
        boolean addedOnThisCall = acceptedChannels.add(channel);
                    channels.forEach(c -> c.addCloseListener(closeFailLogger));
    private static boolean appearsToBeHTTPRequest(BytesReference headerBuffer) {
    protected void onServerException(TcpServerChannel channel, Exception e) {
                    },
        TransportKeepAlive keepAlive,
                + Integer.toHexString(headerBuffer.get(3) & 0xFF)
import java.util.Collections;
            .distinct()  
        Version version,
            this.connectionId = connectionId;  
        NamedWriteableRegistry namedWriteableRegistry,  
import org.opensearch.OpenSearchException;  
            features,
        String[] features;
     * @return the length of the message
                ),
        for (TcpChannel channel : channels) {
            nodeName,  
import java.io.IOException;  
        final InetAddress publishInetAddress;  
        @Override  
            if (isClosing.get()) {  
            List<String> profileBindHosts = TransportSettings.BIND_HOST_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);  
    @Override
     * @throws HttpRequestOnTransportException       if the message header appears to be an HTTP message  
        public final int tcpKeepIdle;
    @Override
    private static final Logger logger = LogManager.getLogger(TcpTransport.class);
import java.util.concurrent.atomic.AtomicLong;
        StatsTracker statsTracker,
    }
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
            version,  
                closeAndFail(new ConnectTransportException(node, "connect_exception", ex));
                keepAlive.close();
        if (defaultFeatures == null) {
import java.util.regex.Matcher;
        final int publishPort = Transport.resolvePublishPort(profileSettings.publishPort, boundAddresses, publishInetAddress);
                outboundHandler.sendBytes(channel, message, ActionListener.wrap(() -> CloseableChannel.closeChannel(channel)));
    @Override
     * Handles inbound message that has been decoded.
            .totalOutboundConnections(outboundConnectionCount.get())
        }
    }  
        } finally {  
        } catch (Exception e) {  
    public static final class ProfileSettings {  
import org.opensearch.common.util.concurrent.CountDown;
    }  
     */
            tcpKeepInterval = TransportSettings.TCP_KEEP_INTERVAL_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);  
 * KIND, either express or implied.  See the License for the
    public void inboundMessage(TcpChannel channel, InboundMessage message) {  
        ThreadPool threadPool,  
        } else {
        if (e instanceof BindException) {
            version,
        }
import org.opensearch.transport.nativeprotocol.NativeOutboundHandler;
    private final ReadWriteLock closeLock = new ReentrantReadWriteLock();
                        c -> {},
import org.apache.logging.log4j.Logger;
    protected void serverAcceptedChannel(TcpChannel channel) {  
                        long relativeMillisTime = threadPool.relativeTimeInMillis();
            if (!matcher.matches()) {  
                    lastException.get()  
    }
            DiscoveryNode node,  
            try {  
            nodeName,
        @Override
        } finally {
                + connectionProfile.getNumConnections()  
                host = hostPortString.substring(0, colonPos);  
            // close the channel as safe measure, which will cause a node to be disconnected if relevant
            bigArrays,
                // close all of the incoming channels. The closeChannels method takes a list so we must convert the set.
                latch.countDown();
    private InetSocketAddress bindToPort(final String name, final InetAddress hostAddress, String port) {  
    private static final int LIMIT_LOCAL_PORTS_COUNT = 6;
        public final List<String> publishHosts;
        }  
import org.opensearch.node.Node;
import java.util.regex.Pattern;
     * @throws StreamCorruptedException              if the message header format is not recognized
    protected abstract TcpChannel initiateChannel(DiscoveryNode node) throws IOException;  
        logger.trace(() -> new ParameterizedMessage("Tcp transport channel accepted: {}", channel));  
        return pageCacheRecycler;  
    public final ResponseHandlers getResponseHandlers() {  
            handshaker,
        }
            logger.warn(() -> new ParameterizedMessage("{}, [{}], closing connection", e.getMessage(), channel));
    final long getNumHandshakes() {
        }  
 * You may obtain a copy of the License at  
            this.countDown = new CountDown(channels.size());  
            channels,  
            throw new IllegalStateException("transport has been stopped");
        for (int i = 0; i < boundAddresses.size(); i++) {
            return channels;
        HttpRequestOnTransportException(String msg) {
            ConnectionProfile connectionProfile,
            publishHosts = NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings);  
 * not use this file except in compliance with the License.
        Objects.requireNonNull(profile, "connection profile cannot be null");
    }
        }
 * specific language governing permissions and limitations
        return parse(address, defaultPortRange()[0]);
        }
        ChannelCloseLogger(DiscoveryNode node, long connectionId, long openTimeMillis) {
    /**  
    ) {  
import java.util.Objects;
        boolean isDefaultSet = false;
            if (countDown.fastForward()) {
                    + TransportSettings.PUBLISH_PORT.getKey()  
                CloseableChannel.closeChannels(channels, false);  
        inboundMessage(channel, (InboundMessage) message);  
