 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assert threadPool.generic().isShutdown() == false : "Must stop transport before terminating underlying threadpool";
    private final Map<String, List<TcpServerChannel>> serverChannels = newConcurrentMap();
import java.util.TreeSet;
 */
        TimeValue connectTimeout = connectionProfile.getConnectTimeout();
import java.nio.channels.CancelledKeyException;
                + "]";
    @Override
                throw new NodeNotConnectedException(node, "connection already closed");
            typeMapping = new EnumMap<>(TransportRequestOptions.Type.class);
                }
    }
        public final int tcpKeepCount;
import java.util.Set;
import java.util.concurrent.TimeUnit;
        return new BoundTransportAddress(transportBoundAddresses, publishAddress);
            publishPort = isDefaultProfile
        } else if (e instanceof BindException) {
                host = hostPortString.substring(0, colonPos);
import java.util.concurrent.atomic.AtomicReference;
    // this code is a take on guava's HostAndPort, like a HostAndPortRange
    private static final Pattern BRACKET_PATTERN = Pattern.compile("^\\[(.*:.*)\\](?::([\\d\\-]*))?$");
    final long getNumHandshakes() {
            Matcher matcher = BRACKET_PATTERN.matcher(hostPortString);
                        c -> {},
            CloseableChannel.closeChannel(channel);
        threadPool.schedule(channelsConnectedListener::onTimeout, connectTimeout, ThreadPool.Names.GENERIC);
    // this limit is per-address
        }
 * @opensearch.api
        // if port isn't specified, fill with the default
        closeLock.writeLock().lock();
    }
    // not perfect, but PortsRange should take care of any port range validation, not a regex
            tcpKeepCount = TransportSettings.TCP_KEEP_COUNT_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
                    + TransportSettings.PORT.getKey()
        private ChannelsConnectedListener(
        public List<TcpChannel> getChannels() {
        private void closeAndFail(Exception e) {
        private final DiscoveryNode node;
        );
            throw new BindTransportException("Failed to resolve publish address", e);
            throws IOException, TransportException {
        Tracer tracer
            (node, channel, requestId, v) -> handshakerHandler.sendRequest(
    ) {
     * @throws HttpRequestOnTransportException       if the message header appears to be an HTTP message
        return statsTracker;
        final BoundTransportAddress boundTransportAddress = createBoundTransportAddress(profileSettings, boundAddresses);
    final TransportKeepAlive getKeepAlive() {
            // Returns true if all connections have completed successfully
        @Override
     *                                               This is dependent on the available memory.
                TransportRequestOptions.EMPTY,
        OutboundHandler outboundHandler,
        ChannelsConnectedListener channelsConnectedListener = new ChannelsConnectedListener(
        public final int publishPort;
            local.add("[::1]"); // may get ports appended!
        public final List<String> publishHosts;
        return new InboundHandler(
        } else {
        } finally {
            List<String> profileBindHosts = TransportSettings.BIND_HOST_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
                }
    }
        if (defaultFeatures == null) {
        } catch (Exception e) {
        public RestStatus status() {
        inboundHandler.setMessageListener(listener);
    public final TransportStats getStats() {
    protected void bindServer(ProfileSettings profileSettings) {
        final long bytesWritten = statsTracker.getBytesWritten();
            .totalOutboundConnections(outboundConnectionCount.get())
import java.util.List;
                v,
            }
    final StatsTracker statsTracker = new StatsTracker();
            Thread.currentThread().interrupt();
            }
    private final TransportKeepAlive keepAlive;
            CloseableChannel.closeChannel(channel);
 *
     *
                isDefaultSet = true;
        String[] features;
        if (portString == null || portString.isEmpty()) {
 * this file be licensed under the Apache-2.0 license or a
    }
    private static boolean appearsToBeHTTPResponse(BytesReference headerBuffer) {
        }
        ConnectionProfile finalProfile = maybeOverrideConnectionProfile(profile);
        return handshaker.getNumHandshakes();
import org.opensearch.threadpool.ThreadPool;
import static org.opensearch.common.transport.NetworkExceptionHelper.isCloseConnectionException;
        }
            });
        @Override
import java.util.Arrays;
                + ","
                + " but was: ["
                        logger.debug("opened transport connection [{}] to [{}] using channels [{}]", connectionId, node, channels);
     */
    public List<String> getDefaultSeedAddresses() {
     *
            if (appearsToBeHTTPResponse(headerBuffer)) {
        boolean addedOnThisCall = acceptedChannels.add(channel);
                for (Map.Entry<String, List<TcpServerChannel>> entry : serverChannels.entrySet()) {
        public final int tcpKeepIdle;
    @Override
     *
    @Override
    public TransportAddress[] addressesFromString(String address) throws UnknownHostException {
            return version;
    /**
                    + profileExplanation
            this.openTimeMillis = openTimeMillis;
        public final String profileName;
        ThreadPool threadPool,
                    );
        }
            version,
            throw new BindTransportException("Failed to resolve host " + profileBindHosts, e);
            if (!matcher.matches()) {
        Version version,
            bigArrays,
            // No need for locking here since Lifecycle objects can't move from STARTED to INITIALIZED
            logger.error(new ParameterizedMessage("exception from server channel caught on transport layer [{}]", channel), e);
    }
            throw new IllegalArgumentException(
                    CloseableChannel.closeChannels(channels, true);
        public HttpRequestOnTransportException(StreamInput in) throws IOException {
        for (int i = 0; i < chars.length; i++) {
/*
        this.version = version;
    /**
            if (connectionTypeHandle == null) {
                listener.onFailure(new ConnectTransportException(node, "general node connection failure", e));
        handshaker.sendHandshake(requestId, node, channel, profile.getHandshakeTimeout(), listener);
    protected final PageCacheRecycler pageCacheRecycler;
    @Override
        private final boolean compress;
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * Returns all profile settings for the given settings object
import java.util.function.Supplier;
     * @return the pending connection
    // connections while no connect operations is going on
 * software distributed under the License is distributed on an
            // in case we are able to return data, serialize the exception content and sent it back to the client
            tcpKeepIdle = TransportSettings.TCP_KEEP_IDLE_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
import java.io.StreamCorruptedException;
        if (isCloseConnectionException(e)) {
            features = new String[0];
            port = Integer.parseInt(portString);
    private class ChannelCloseLogger implements ActionListener<Void> {
                    + "] exceeded ["
            );
            responseHandlers,
        int numConnections = connectionProfile.getNumConnections();
        try {
        }
import java.util.EnumMap;
        NamedWriteableRegistry namedWriteableRegistry,
        }
            node,
    }
    }
        }
    private static final int LIMIT_LOCAL_PORTS_COUNT = 6;
     * @param channel the channel the message is from
    }
 * You may obtain a copy of the License at
                + Integer.toHexString(headerBuffer.get(3) & 0xFF)
        assert hostAddresses.length > 0;
        return new PortsRange(
            portString = matcher.group(2);  // could be null
        }
 * this work for additional information regarding copyright
        for (int i = 0; i < boundAddresses.size(); i++) {
    public final RequestHandlers getRequestHandlers() {
import java.util.concurrent.locks.ReadWriteLock;
    private static final long THIRTY_PER_HEAP_SIZE = (long) (JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() * 0.3);
                TransportHandshaker.HANDSHAKE_ACTION_NAME,
        );
                                ? e
import static java.util.Collections.unmodifiableMap;
     * Ensures this transport is still started / open
     * @return the length of the message
            logger.debug(
        public DiscoveryNode getNode() {
     */
        Settings settings,
     * Validates the first 6 bytes of the message header and returns the length of the message. If 6 bytes
        // check if v6 is supported, if so, v4 will also work via mapped addresses.
        String portString = null;
    /**
                        NodeChannels nodeChannels = new NodeChannels(node, channels, connectionProfile, version);
            }
    public Map<String, BoundTransportAddress> profileBoundAddresses() {
                + Integer.toHexString(headerBuffer.get(0) & 0xFF)
    private final Set<TcpChannel> acceptedChannels = ConcurrentCollections.newConcurrentSet();
    /**
        // Bind and start to accept incoming connections.
        if (logger.isDebugEnabled()) {
            )
        List<String> profileBindHosts = profileSettings.bindHosts;
        List<String> publishHosts = profileSettings.publishHosts;
            features,
        HashSet<ProfileSettings> profiles = new HashSet<>();
        }
        ChannelCloseLogger(DiscoveryNode node, long connectionId, long openTimeMillis) {
            // close the channel as safe measure, which will cause a node to be disconnected if relevant
            .txSize(bytesWritten)
    }
            if (appearsToBeTLS(headerBuffer)) {
        private final long connectionId;
        private final long openTimeMillis;
    }
import static org.opensearch.common.transport.NetworkExceptionHelper.isConnectException;
                acceptedChannels.clear();
            isDefaultProfile = TransportSettings.DEFAULT_PROFILE.equals(profileName);
import java.net.BindException;
    }
        } else if (e instanceof HttpRequestOnTransportException) {
                portString = hostPortString.substring(colonPos + 1);
            }
            }
    }
    public void executeHandshake(DiscoveryNode node, TcpChannel channel, ConnectionProfile profile, ActionListener<Version> listener) {
            latch.await(30, TimeUnit.SECONDS);
        }
import java.util.HashMap;
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            if (countDown.fastForward()) {
     * are not available, it returns -1.
import org.opensearch.core.common.breaker.CircuitBreaker;
                throw new StreamCorruptedException("SSL/TLS request received but SSL/TLS is not enabled on this node, got " + firstBytes);
            receiveBufferSize = TransportSettings.TCP_RECEIVE_BUFFER_SIZE_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
        Objects.requireNonNull(profile, "connection profile cannot be null");
import org.opensearch.common.annotation.PublicApi;
        }
                CloseableChannel.closeChannels(channels, false);
        }
    }
     * @param address the address to bind to
            // Parse a bracketed host, typically an IPv6 literal.
     *
        final int messageLength = headerBuffer.getInt(TcpHeader.MARKER_BYTES_SIZE);
                listener.onFailure(e);
        if (publishHosts.isEmpty()) {
                throw new BindTransportException(
    private static final Logger logger = LogManager.getLogger(TcpTransport.class);
import java.util.ArrayList;
        }
            try {
    private static int readHeaderBuffer(BytesReference headerBuffer) throws IOException {
    }
            }
    }
        return pageCacheRecycler;
                requestId,
        public final ByteSizeValue receiveBufferSize;
            closeLock.writeLock().lock();
    }
        }
import java.net.InetSocketAddress;
        private final AtomicBoolean isClosing = new AtomicBoolean(false);
        try {
            // close the channel as safe measure, which will cause a node to be disconnected if relevant
        final AtomicReference<InetSocketAddress> boundSocket = new AtomicReference<>();
    ) {
            } catch (Exception e) {
        handshakerHandler.setMessageListener(listener);
    public final ResponseHandlers getResponseHandlers() {
        try {
            .map(address -> new TransportAddress(address, port))
            }
     */
    protected void serverAcceptedChannel(TcpChannel channel) {
        for (int i = 0; i < numConnections; ++i) {
                return channels;
        }
import org.opensearch.core.common.bytes.BytesArray;
            .rxSize(bytesRead)
import java.util.concurrent.ConcurrentMap;
                throw new IllegalArgumentException("no type channel for [" + type + "]");
                    boundSocket.set(channel.getLocalAddress());
import org.opensearch.transport.nativeprotocol.NativeOutboundHandler;
    @Override
            publishHosts = Arrays.asList(boundAddressesHostStrings);
    public StatsTracker getStatsTracker() {
            .collect(Collectors.toList());
        return responseHandlers;
                : TransportSettings.PUBLISH_PORT_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
    protected final Set<ProfileSettings> profileSettings;
import org.opensearch.common.metrics.MeanMetric;
     */
        final long messagesReceived = statsTracker.getMessagesReceived();
            // Actually 'OPTIONS'. But we are only guaranteed to have read six bytes at this point.
                } catch (Exception ex) {
    ) {
    private final NativeOutboundHandler handshakerHandler;
/*
                }
            channel.addConnectListener(channelsConnectedListener);
import org.opensearch.common.network.NetworkService;
    // pattern for validating ipv6 bracket addresses.
        this.threadPool = threadPool;
                return true;
import org.opensearch.common.util.concurrent.CountDown;
        final InetAddress publishInetAddress;
                );
        return new TransportStats.Builder().serverOpen(acceptedChannels.size())
            }
 * KIND, either express or implied.  See the License for the
    }
    public static int readMessageLength(BytesReference networkBytes) throws IOException {
    @Override
                throw new HttpRequestOnTransportException("This is not an HTTP port");
        String nodeName,
        public final List<String> bindHosts;
                final TcpChannel handshakeChannel = channels.get(0);
            .build();
     * Called to tear down internal resources
        public final boolean isDefaultProfile;
                for (TransportRequestOptions.Type type : handle.getTypes())
            }
            boundAddresses.add(bindToPort(profileSettings.profileName, hostAddress, profileSettings.portOrRange));
        StatsTracker statsTracker,
            threadPool,
            ConnectionProfile connectionProfile,
     */
 * under the License.
            return RestStatus.BAD_REQUEST;
import org.opensearch.core.common.bytes.BytesReference;
        } else if (isConnectException(e)) {
        } catch (IOException e) {
     */
        final AtomicReference<Exception> lastException = new AtomicReference<>();
                                : new ConnectTransportException(node, "general node connection failure", e)
                listener.onFailure(e);
        public final boolean tcpNoDelay;
        }
    public void inboundMessage(TcpChannel channel, InboundMessage message) {
            if (countDown.fastForward()) {
            if (buffer.get(i) != chars[i]) {
        }
                // close all of the incoming channels. The closeChannels method takes a list so we must convert the set.
        ResponseHandlers responseHandlers,
        if (!lifecycle.started()) {
     * so an appropriate error code can be returned
                try {
        if (messageLength <= 0) {
            TcpChannel channel = channel(options.type());
            || bufferStartsWith(headerBuffer, "PUT")
                }
                } catch (Exception e) {
import org.opensearch.core.common.transport.BoundTransportAddress;
                CloseableChannel.closeChannels(channels, false);
     * Representation of a transport profile settings for a {@code transport.profiles.$profilename.*}
        private final DiscoveryNode node;
                TransportSettings.PORT.get(settings)
     * @throws IOException if an I/O exception occurs while opening the channel
            .txCount(messagesSent)
        });
import org.opensearch.common.transport.PortsRange;
            keepAlive,
            throw new BindTransportException(
        if (hostPortString.startsWith("[")) {
                return channels;
        return requestHandlers;
            try {
            return;
    }
     * Binds to the given {@link InetSocketAddress}
     * @param networkBytes the will be read
            namedWriteableRegistry,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    + boundAddresses
            return readHeaderBuffer(networkBytes);
        ThreadPool threadPool,
import java.util.stream.Collectors;
        }
 * compatible open source license.
     * @param message the message
import org.opensearch.telemetry.tracing.Tracer;
    private volatile BoundTransportAddress boundAddress;
     *
    protected final void doClose() {}
            logger.debug("Bound profile [{}] to address {{}}", name, NetworkAddress.format(boundSocket.get()));
        final CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.common.util.PageCacheRecycler;
     * @opensearch.api
    private final ResponseHandlers responseHandlers = new ResponseHandlers();
                    List<TcpServerChannel> channels = entry.getValue();
    public void setSlowLogThreshold(TimeValue slowLogThreshold) {
        public void onFailure(Exception ex) {
        } else {
            assert false : e; // never called
        for (String profile : settings.getGroups("transport.profiles.", true).keySet()) {
        Tracer tracer
                    String profile = entry.getKey();
                false,
        public Version getVersion() {
        this.outboundHandler = new OutboundHandler(statsTracker, threadPool);
    }
        if (lifecycle.started() == false) {
            if (colonPos >= 0 && hostPortString.indexOf(':', colonPos + 1) == -1) {
     *
 */
    }
                // 2+ colons and not bracketed: exception
            initiateConnection(node, finalProfile, listener);
            port = defaultPort;
        return keepAlive;
                        e -> closeAndFail(
            String firstBytes = "("
        if (isDefaultSet == false) {
        Objects.requireNonNull(hostPortString);
        }
        public ProfileSettings(Settings settings, String profileName) {
     * @opensearch.internal
                );
    }
    /**
            this.connectionId = connectionId;
            outboundHandler,
     */
                if (Booleans.parseBoolean(defaultFeatures.get(key)) == false) {
        final Settings defaultFeatures = TransportSettings.DEFAULT_FEATURES_SETTING.get(settings);
        }
                        nodeChannels.addCloseListener(new ChannelCloseLogger(node, connectionId, relativeMillisTime));
        String[] boundAddressesHostStrings = new String[boundAddresses.size()];
                    serverChannels.computeIfAbsent(name, k -> new ArrayList<>()).add(channel);
        for (TcpChannel channel : channels) {
    }
            transportBoundAddresses[i] = new TransportAddress(boundAddress);
                logger.trace(() -> new ParameterizedMessage("Tcp transport channel opened: {}", channel));
            if (TransportSettings.DEFAULT_PROFILE.equals(profile)) {
        // Mark the channel init time
        }
                    closeAndFail(ex);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 * Unless required by applicable law or agreed to in writing,
            reuseAddress = TransportSettings.TCP_REUSE_ADDRESS_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
            CloseableChannel.closeChannel(channel);
            for (int i = 0; i < hostAddresses.length; i++) {
                    throw new IllegalArgumentException("IPv6 addresses must be bracketed: " + hostPortString);
import java.util.Map;
    private static final int BYTES_NEEDED_FOR_MESSAGE_SIZE = TcpHeader.MARKER_BYTES_SIZE + TcpHeader.MESSAGE_LENGTH_SIZE;
        this.handshakerHandler = new NativeOutboundHandler(
            if (!success) {
    private final class ChannelsConnectedListener implements ActionListener<Void> {
        int port;
import org.apache.logging.log4j.message.ParameterizedMessage;
                    + " or "
    private List<TcpChannel> initiateConnection(
                // Exactly 1 colon. Split into host:port.
                channels.add(channel);
     * @throws IllegalStateException if the transport is not started / open
    public TcpTransport(
                } finally {
import java.util.concurrent.atomic.AtomicLong;
            || bufferStartsWith(headerBuffer, "OPTION")
                    super.close();
                    },
    // This allows transport implementations to potentially override specific connection profiles. This
                        listener.onResponse(nodeChannels);
        public final boolean tcpKeepAlive;
            int colonPos = hostPortString.indexOf(':');
            sendBufferSize = TransportSettings.TCP_SEND_BUFFER_SIZE_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
            this.boundAddress = boundTransportAddress;
                () -> new ParameterizedMessage(
                    "cancelled key exception caught on transport layer [{}], disconnecting from relevant node",
        final long bytesRead = statsTracker.getBytesRead();
                            ch.getChannelStats().markAccessed(relativeMillisTime);
        return messageLength;
        NetworkService networkService,
            closeLock.readLock().unlock();
            ActionListener<Transport.Connection> listener
        private final DiscoveryNode node;
                + Integer.toHexString(headerBuffer.get(1) & 0xFF)
/**
                "Failed to auto-resolve publish port"
        );
            connectionProfile,
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.logging.log4j.Logger;
            requestHandlers,
            Setting<String> concretePort = TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(profileName);
        if (headerBuffer.get(0) != 'E' || headerBuffer.get(1) != 'S') {
            if (isClosing.compareAndSet(false, true)) {
                ),
     */
    private static boolean bufferStartsWith(BytesReference buffer, String method) {
    protected final ThreadPool threadPool;
            outboundHandler,
        } else if (e instanceof CancelledKeyException) {
                outboundHandler.sendBytes(channel, message, ActionListener.wrap(() -> CloseableChannel.closeChannel(channel)));
        if (networkBytes.length() < BYTES_NEEDED_FOR_MESSAGE_SIZE) {
    @Override
        assert numConnections > 0 : "A connection profile must be configured with at least one connection";
                    + new ByteSizeValue(THIRTY_PER_HEAP_SIZE)
            this.node = node;
        return channels;
                + ")";
    }
        if (e instanceof BindException) {
                e
            this.countDown = new CountDown(channels.size());
            this.node = node;
            namedWriteableRegistry,
            }
        return bufferStartsWith(headerBuffer, "GET")
    @Override
        inboundHandler.setSlowLogThreshold(slowLogThreshold);
    protected final NetworkService networkService;
            .distinct()
public abstract class TcpTransport extends AbstractLifecycleComponent implements Transport {
import org.opensearch.cluster.node.DiscoveryNode;
        TransportAddress[] transportBoundAddresses = new TransportAddress[boundAddresses.size()];
     * Handles inbound message that has been decoded.
            // close the channel, which will cause a node to be disconnected if relevant
        final MeanMetric writeBytesMetric = statsTracker.getWriteBytes();
        );
    }
                    typeMapping.put(type, handle);
        closeLock.readLock().lock(); // ensure we don't open connections while we are closing
                    TcpServerChannel channel = bind(name, new InetSocketAddress(hostAddress, portNumber));
    private static boolean appearsToBeTLS(BytesReference headerBuffer) {
                }
        BigArrays bigArrays = new BigArrays(pageCacheRecycler, circuitBreakerService, CircuitBreaker.IN_FLIGHT_REQUESTS);
            portOrRange = TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
                TransportSettings.PORT_PROFILE.getConcreteSettingForNamespace(TransportSettings.DEFAULT_PROFILE).getKey(),
    private final Version version;
        return threadPool;
import org.opensearch.common.network.NetworkAddress;
        public TcpChannel channel(TransportRequestOptions.Type type) {
            version,
 * specific language governing permissions and limitations
import java.net.InetAddress;
    @Override
    /**
        }
            logger.warn(() -> new ParameterizedMessage("exception caught on transport layer [{}], closing connection", channel), e);
                "transport content length received ["
    protected InboundHandler createInboundHandler(
        final int publishPort = Transport.resolvePublishPort(profileSettings.publishPort, boundAddresses, publishInetAddress);
        }
        try {
            tcpKeepAlive = TransportSettings.TCP_KEEP_ALIVE_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
        if (node == null) {
    protected abstract void stopInternal();
        if (publishPort == -1) {
                    "Failed to bind to " + NetworkAddress.format(hostAddress, portsRange),
        inboundMessage(channel, (InboundMessage) message);
        }
            throw new StreamCorruptedException("invalid data length: " + messageLength);
                    + " with distinct ports and none of them matched the publish address ("
        }
        @Override
            );
                    boolean block = lifecycle.stopped() && Transports.isTransportThread(Thread.currentThread()) == false;
        return handshaker.getNumPendingHandshakes();
    }
            }
    }
                    channels.forEach(c -> c.addCloseListener(closeFailLogger));
        }
            ensureOpen();
            });
        NamedWriteableRegistry namedWriteableRegistry,
        this.networkService = networkService;
        }
                    + "Please specify a unique port by setting "
        } finally {
                new TransportHandshaker.HandshakeRequest(version),
        return unmodifiableMap(new HashMap<>(profileBoundAddresses));
        public void close() {
        @Override
     * Initiate a single tcp socket channel.
            logger.debug(() -> new ParameterizedMessage("connect exception caught on transport layer [{}]", channel), e);
            return 0;
            defaultFeatures.names().forEach(key -> {
        channel.addCloseListener(ActionListener.wrap(() -> acceptedChannels.remove(channel)));
                + Integer.toHexString(headerBuffer.get(2) & 0xFF)
        private final ActionListener<Transport.Connection> listener;
    // exposed for tests
     */
import org.opensearch.core.common.io.stream.StreamInput;
    protected void doStart() {}
import java.nio.charset.StandardCharsets;
            // close the channel, which will cause a node to be disconnected if relevant
            } finally {
    }
        this.handshaker = new TransportHandshaker(
                            // Mark the channel init time
 */
            assert channels.size() == connectionProfile.getNumConnections() : "expected channels size to be == "
        RequestHandlers requestHandlers,
 *
        private final ConnectionProfile connectionProfile;
import org.opensearch.common.Booleans;
                return false;
    }
        public final String portOrRange;
    }
    final Set<TcpChannel> getAcceptedChannels() {
                closeAndFail(new ConnectTransportException(node, "connect_timeout[" + connectionProfile.getConnectTimeout() + "]"));
        }
            requestHandlers,
            // just close and ignore - we are already stopped and just need to make sure we release all resources
        }
        public void onResponse(Void v) {
                throw new IllegalStateException("transport has been stopped");
    @Override
import org.opensearch.node.Node;
    @Override
        long requestId = responseHandlers.newRequestId();
import org.opensearch.common.network.CloseableChannel;
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Transport.Connection> listener) {
    }
    private final ConcurrentMap<String, BoundTransportAddress> profileBoundAddresses = newConcurrentMap();
                    channel
    @PublicApi(since = "1.0.0")
        return local.stream()
import java.util.concurrent.atomic.AtomicBoolean;
                // 0 or 2+ colons. Bare hostname or IPv6 literal.
     *
            settings.get(
            CloseableChannel.closeChannel(channel);
     * @throws StreamCorruptedException              if the message header format is not recognized
            }
     */
            outboundHandler
                + ","
        if (profileSettings.isDefaultProfile == false && publishHosts.isEmpty()) {
            } finally {
    // This is the number of bytes necessary to read the message size
            } catch (ConnectTransportException e) {
     *
    protected abstract TcpChannel initiateChannel(DiscoveryNode node) throws IOException;
        try {
        this.circuitBreakerService = circuitBreakerService;
import java.util.regex.Matcher;
            }
                        });
        }
            } catch (Exception ex) {
            CloseableChannel.closeChannel(channel);
import java.util.concurrent.CountDownLatch;
        if (messageLength == TransportKeepAlive.PING_DATA_SIZE) {
    }
        }
    /**
    }
                BytesArray message = new BytesArray(e.getMessage().getBytes(StandardCharsets.UTF_8));
            DiscoveryNode node,
    private BoundTransportAddress createBoundTransportAddress(ProfileSettings profileSettings, List<InetSocketAddress> boundAddresses) {
        return parse(address, defaultPortRange()[0]);
                ),
            version = handshakeVersion;
        }
    protected ConnectionProfile maybeOverrideConnectionProfile(ConnectionProfile connectionProfile) {
    protected void onServerException(TcpServerChannel channel, Exception e) {
                    + "]"
        HttpRequestOnTransportException(String msg) {
            bigArrays,
        @Override
            publishHosts = TransportSettings.PUBLISH_HOST_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
        return this.boundAddress;
            if (concretePort.exists(settings) == false && isDefaultProfile == false) {
            List<TcpChannel> channels,
            version,
            features,
    protected final Settings settings;
            logger.debug(
            tcpNoDelay = TransportSettings.TCP_NO_DELAY_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
    }
            );
            ConnectionProfile.ConnectionTypeHandle connectionTypeHandle = typeMapping.get(type);
/*
                    lastException.set(e);
        PageCacheRecycler pageCacheRecycler,
        ConnectionProfile connectionProfile,
                () -> new ParameterizedMessage(
        List<InetSocketAddress> boundAddresses = new ArrayList<>();
    public final class NodeChannels extends CloseableConnection {
        private final Map<TransportRequestOptions.Type, ConnectionProfile.ConnectionTypeHandle> typeMapping;
    public static Set<ProfileSettings> getProfileSettings(Settings settings) {
import org.opensearch.core.common.Strings;
            super(in);
            logger.debug(() -> new ParameterizedMessage("bind exception caught on transport layer [{}]", channel), e);
        public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
                host = hostPortString;
            throw new StreamCorruptedException("invalid internal transport message format, got " + firstBytes);
            if (lifecycle.initialized() == false && lifecycle.started() == false) {
            .flatMap(address -> Arrays.stream(defaultPortRange()).limit(LIMIT_LOCAL_PORTS_COUNT).mapToObj(port -> address + ":" + port))
            onException(channel, e);
            statsTracker,
            statsTracker,
    public synchronized void setMessageListener(TransportMessageListener listener) {
        InetAddress[] hostAddresses;
        public void onResponse(Void ignored) {
            nodeName,
        final List<TcpChannel> channels = new ArrayList<>(numConnections);
        } else {
                ? TransportSettings.PUBLISH_PORT.get(settings)
        Version version,
        List<String> local = new ArrayList<>();
        return headerBuffer.get(0) == 0x16 && headerBuffer.get(1) == 0x03;
                CloseableChannel.closeChannels(new ArrayList<>(acceptedChannels), true);
        }
            publishHosts = NetworkService.GLOBAL_NETWORK_PUBLISH_HOST_SETTING.get(settings);
    private final AtomicLong outboundConnectionCount = new AtomicLong(); // also used as a correlation ID for open/close logs
    @Override
        public final ByteSizeValue sendBufferSize;
    }
     * A helper exception to mark an incoming connection as potentially being HTTP
            boolean success = portsRange.iterate(portNumber -> {
            profiles.add(new ProfileSettings(settings, profile));
        this.settings = settings;
            handshaker,
        public final int tcpKeepInterval;
            handshakerHandler.sendRequest(node, channel, requestId, action, request, options, getVersion(), compress, false);
                e.addSuppressed(ex);
        }
    public BoundTransportAddress boundAddress() {
            CloseableChannel.closeChannel(channel);
            statsTracker,
                    throw new IllegalArgumentException("feature settings must have default [true] value");
    /**
 * not use this file except in compliance with the License.
                    + publishInetAddress
     * parse a hostname+port spec into its equivalent addresses
        TransportHandshaker handshaker,
            logger.debug(() -> new ParameterizedMessage("bind exception from server channel caught on transport layer [{}]", channel), e);
        ) {
import org.opensearch.common.settings.Settings;
    private final CircuitBreakerService circuitBreakerService;
            throw new IllegalStateException("transport has been stopped");
            || bufferStartsWith(headerBuffer, "POST")
                    lastException.get()
    @Override
        ).ports();
                        nodeChannels.channels.forEach(ch -> {
    /**
                        e -> logger.warn(() -> new ParameterizedMessage("Error closing serverChannel for profile [{}]", profile), e)
            logger.warn(() -> new ParameterizedMessage("{}, [{}], closing connection", e.getMessage(), channel));
 *
            this.channels = channels;
    }
                    ));
        }
            // close the channel as safe measure, which will cause a node to be disconnected if relevant
                latch.countDown();
                    + TransportSettings.PUBLISH_PORT.getKey()
                true
                        final long connectionId = outboundConnectionCount.incrementAndGet();
                + connectionProfile.getNumConnections()
                closeLock.writeLock().unlock();
        if (NetworkUtils.SUPPORTS_V6) {
        DiscoveryNode node,
            this.connectionProfile = connectionProfile;
 * The OpenSearch Contributors require contributions made to
        @Override
        }
    private int[] defaultPortRange() {
                serverChannels.clear();
        }
        this.inboundHandler = createInboundHandler(
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
                stopInternal();
    // this lock is here to make sure we close this transport and disconnect all the client nodes
    public static final class ProfileSettings {
            }
        }
            this.node = node;
 * ownership. Elasticsearch licenses this file to you under
            compress = connectionProfile.getCompressionEnabled();
        TransportKeepAlive keepAlive,
            boundAddressesHostStrings[i] = boundAddress.getHostString();
                closeAndFail(new ConnectTransportException(node, "connect_exception", ex));
            features,
 * GitHub history for details.
        return Collections.unmodifiableSet(profiles);
        handleException(channel, e, lifecycle, outboundHandler);
            logger.debug("closed transport connection [{}] to [{}] with age [{}ms]", connectionId, node, closeTimeMillis - openTimeMillis);
                        )
        } else {
        PortsRange portsRange = new PortsRange(port);
    }
    }
                throw new IllegalStateException("profile [" + profileName + "] has no port configured");
            publishInetAddress = networkService.resolvePublishHostAddresses(publishHosts.toArray(Strings.EMPTY_ARRAY));
            // ignore
        this.profileSettings = getProfileSettings(settings);
        } catch (Exception e) {
        public final boolean reuseAddress;
import org.opensearch.Version;
            this.channels = Collections.unmodifiableList(channels);
        private final CountDown countDown;
                            ch.addCloseListener(ActionListener.wrap(nodeChannels::close));
        return Collections.unmodifiableSet(acceptedChannels);
            profiles.add(new ProfileSettings(settings, TransportSettings.DEFAULT_PROFILE));
    public void inboundMessage(TcpChannel channel, ProtocolInboundMessage message) {
                }
            logger.debug("binding server bootstrap to: {}", (Object) addresses);
        }
            threadPool,
        return true;
    static TransportAddress[] parse(String hostPortString, int defaultPort) throws UnknownHostException {
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.HashSet;
import org.opensearch.core.common.transport.TransportAddress;
            nodeName,
            threadPool,
    }
        if (messageLength > THIRTY_PER_HEAP_SIZE) {
import java.util.regex.Pattern;
        if (logger.isDebugEnabled()) {
                TcpChannel channel = initiateChannel(node);
        String nodeName = Node.NODE_NAME_SETTING.get(settings);
        return Arrays.stream(InetAddress.getAllByName(host))
            super(msg);
    protected final void doStop() {
        } else {
        }
            version,
import org.opensearch.OpenSearchException;
    }
            throw new ConnectTransportException(null, "can't open connection to a null node");
        }
            hostAddresses = networkService.resolveBindHostAddresses(profileBindHosts.toArray(Strings.EMPTY_ARRAY));
                    "received HTTP response on transport port, ensure that transport port (not "
    public void onException(TcpChannel channel, Exception e) {
            inboundHandler.inboundMessage(channel, message);
                addresses[i] = NetworkAddress.format(hostAddresses[i]);
        );
    }
            // This is a ping
 * license agreements. See the NOTICE file distributed with
     */
import java.io.IOException;
        return boundSocket.get();
        public void onFailure(Exception e) {
        } else {
        this.keepAlive = new TransportKeepAlive(threadPool, this.outboundHandler::sendBytes);
    }
            bigArrays,
                        long relativeMillisTime = threadPool.relativeTimeInMillis();
    public static final String TRANSPORT_WORKER_THREAD_NAME_PREFIX = "transport_worker";
     * @opensearch.internal
    }
                throw new IllegalArgumentException("Invalid bracketed host/port range: " + hostPortString);
            InetSocketAddress boundAddress = boundAddresses.get(i);
import org.opensearch.common.network.NetworkUtils;
 * Licensed to Elasticsearch under one or more contributor
    /**
            // use a sorted set to present the features in a consistent order
        String[] features,
        }
    // primarily exists for the test implementations.
                        + "HTTP port) of a remote node is specified in the configuration"
            CloseableChannel.closeChannel(channel);
        this.pageCacheRecycler = pageCacheRecycler;
            return -1;
            channels,
    public ThreadPool getThreadPool() {
        assert addedOnThisCall : "Channel should only be added to accepted channel set once";
    protected void ensureOpen() {
            if (channel.isOpen()) {
            profileBoundAddresses.put(profileSettings.profileName, boundTransportAddress);
            }
        logger.trace(() -> new ParameterizedMessage("Tcp transport channel accepted: {}", channel));
                e
                channel,
                        keepAlive.registerNodeConnection(nodeChannels.channels, connectionProfile);
        @Override
                    + ", multiple bound addresses "
                node,
        } else if (e instanceof StreamCorruptedException) {
    public PageCacheRecycler getPageCacheRecycler() {
        local.add("127.0.0.1");
        }
    private InetSocketAddress bindToPort(final String name, final InetAddress hostAddress, String port) {
    public Supplier<CircuitBreaker> getInflightBreaker() {
            || bufferStartsWith(headerBuffer, "HEAD")
            responseHandlers,
            }
                throw new StreamCorruptedException(
    static void handleException(TcpChannel channel, Exception e, Lifecycle lifecycle, OutboundHandler outboundHandler) {
    }
 */
     * @throws IllegalArgumentException              if the message length is greater that the maximum allowed frame size.
            keepAlive,
            }
                    // Call the super method to trigger listeners
        boolean isDefaultSet = false;
     * @param node for the initiated connection
            }
    }
        ActionListener<Transport.Connection> listener
            return channels;
        public NodeChannels(DiscoveryNode node, List<TcpChannel> channels, ConnectionProfile connectionProfile, Version handshakeVersion) {
                    return false;
}
            .rxCount(messagesReceived)
            return this.node;
        try {
        private final Version version;
        channel.getChannelStats().markAccessed(threadPool.relativeTimeInMillis());
    protected final InboundHandler inboundHandler;
                try {
    private final ReadWriteLock closeLock = new ReentrantReadWriteLock();
    private final TransportHandshaker handshaker;
    private final RequestHandlers requestHandlers = new RequestHandlers();
        String host;
    private static boolean appearsToBeHTTPRequest(BytesReference headerBuffer) {
        return () -> circuitBreakerService.getBreaker(CircuitBreaker.IN_FLIGHT_REQUESTS);
            long closeTimeMillis = threadPool.relativeTimeInMillis();
        }
            closeLock.writeLock().unlock();
            );
    final int getNumPendingHandshakes() {
        if (profileSettings.isDefaultProfile) {
        }
import org.opensearch.monitor.jvm.JvmInfo;
@PublicApi(since = "1.0.0")
        final long messagesSent = statsTracker.getMessagesSent();
        @Override
            return connectionTypeHandle.getChannel(channels);
            bindHosts = (profileBindHosts.isEmpty() ? NetworkService.GLOBAL_NETWORK_BIND_HOST_SETTING.get(settings) : profileBindHosts);
            if (isClosing.get()) {
            }
        } else {
    }
                    CloseableChannel.closeChannels(channels, block);
    @Deprecated
            String profileExplanation = profileSettings.isDefaultProfile ? "" : " for profile " + profileSettings.profileName;
            }
            || bufferStartsWith(headerBuffer, "PATCH")
            host = matcher.group(1);
import org.opensearch.core.rest.RestStatus;
import org.opensearch.common.settings.Setting;
import org.opensearch.action.support.ThreadedActionListener;
        return connectionProfile;
    /**
            handshaker,
    }
 *
            this.profileName = profileName;
     * @param name    the profile name
            } else {
            if (appearsToBeHTTPRequest(headerBuffer)) {
        }
                // first stop to accept any incoming connections so nobody can connect to this transport
                CloseableChannel.closeChannels(channels, false);
import java.util.Objects;
 * The TCP Transport layer
import org.apache.logging.log4j.LogManager;
    protected abstract TcpServerChannel bind(String name, InetSocketAddress address) throws IOException;
            this.listener = listener;
            }
    }
        }
            tcpKeepInterval = TransportSettings.TCP_KEEP_INTERVAL_PROFILE.getConcreteSettingForNamespace(profileName).get(settings);
     * @deprecated Use {{@link #inboundMessage(TcpChannel, InboundMessage)}} instead
            )
        }
                    ActionListener<Void> closeFailLogger = ActionListener.wrap(
        }
            threadPool,
     * List of node connection channels
import java.util.Collections;
    /**
     */
        threadPool.generic().execute(() -> {
                            e instanceof ConnectTransportException
            if (countDown.countDown()) {
            nodeName,
                    channel
            for (ConnectionProfile.ConnectionTypeHandle handle : connectionProfile.getHandles()) {
        final TransportAddress publishAddress = new TransportAddress(new InetSocketAddress(publishInetAddress, publishPort));
    public static class HttpRequestOnTransportException extends OpenSearchException {
        } catch (InterruptedException e) {
            .toArray(TransportAddress[]::new);
            tracer
                if (colonPos >= 0) {
import org.opensearch.common.unit.TimeValue;
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            tracer
        return bufferStartsWith(headerBuffer, "HTTP");
        char[] chars = method.toCharArray();
        // make sure we run it on another thread than a possible IO handler thread
        private final List<TcpChannel> channels;
        }
        for (InetAddress hostAddress : hostAddresses) {
            }
    public Version getVersion() {
import org.opensearch.common.lifecycle.Lifecycle;
        public void onTimeout() {
import org.opensearch.common.util.BigArrays;
        private final List<TcpChannel> channels;
package org.opensearch.transport;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                    executeHandshake(node, handshakeChannel, connectionProfile, ActionListener.wrap(version -> {
import org.opensearch.core.common.unit.ByteSizeValue;
            String[] addresses = new String[hostAddresses.length];
            || bufferStartsWith(headerBuffer, "TRACE");
    private final OutboundHandler outboundHandler;
    }
        CircuitBreakerService circuitBreakerService,
                keepAlive.close();
import org.opensearch.core.action.ActionListener;
        @Override
import java.net.UnknownHostException;
                    "close connection exception caught on transport layer [{}], disconnecting from relevant node",
                    + new ByteSizeValue(messageLength)
        }
            try {
            || bufferStartsWith(headerBuffer, "DELETE")
                + ","
 * SPDX-License-Identifier: Apache-2.0
                + channels.size()
        BigArrays bigArrays,
        return version;
            features = new TreeSet<>(defaultFeatures.names()).toArray(new String[defaultFeatures.names().size()]);
                try {
                    + "). "
            new ThreadedActionListener<>(logger, threadPool, ThreadPool.Names.GENERIC, listener, false)
