        // A node without a stream address (predates the stream transport, or has it disabled) cannot serve  
            listener.onResponse(null);
            localNodeFactory,
import static org.opensearch.discovery.HandshakingTransportAddressConnector.PROBE_HANDSHAKE_TIMEOUT_SETTING;  
        this.streamTransportReqTimeout = streamTransportReqTimeout;
                    TransportRequestOptions.Type.STREAM,
        }
 */
    public <T extends TransportResponse> void sendChildRequest(
            wrappedListener
        // retry/log-noise seen against older nodes during a mixed-version rolling upgrade.
        });
        // a Flight connection. Skip it rather than attempting a connect that would fail; this avoids the
                ConnectionProfile.buildSingleChannelProfile(
 * Transport service for streaming requests, handling StreamTransportResponse.  
        final ActionListener<Void> wrappedListener = ActionListener.wrap(response -> { listener.onResponse(response); }, exception -> {
import org.opensearch.cluster.node.DiscoveryNode;  
            listener.onResponse(null);  
    private void setStreamTransportReqTimeout(TimeValue streamTransportReqTimeout) {
        final Task parentTask,
import org.opensearch.core.action.ActionListener;
    public StreamTransportService(  
                    TimeValue.MINUS_ONE,
    }
    }
 */  
@ExperimentalApi  
        @Nullable ClusterSettings clusterSettings,  
        );  
            listener.onFailure(new ConnectTransportException(node, "Failed to connect for streaming", exception));
            handler
import java.util.function.Function;  
        }
/**
            parentTask,  
    }
    }
            new ClusterConnectionManager(  
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
    @Override  
        final String action,  
 * compatible open source license.
        final TransportResponseHandler<T> handler  
        Settings settings,
import org.opensearch.common.Nullable;
            (connection, profile, listener1) -> listener1.onResponse(null),
            connection,  
        connectionManager.connectToNode(
        TransportInterceptor transportInterceptor,
            true
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.tracing.Tracer;  
import org.opensearch.common.settings.Setting;
    }  
    @Override  
}
            settings,  
            clusterSettings.addSettingsUpdateConsumer(STREAM_TRANSPORT_REQ_TIMEOUT_SETTING, this::setStreamTransportReqTimeout);
    private volatile TimeValue streamTransportReqTimeout;
            throw new ConnectTransportException(node, "Failed to get streaming connection", e);  
import org.opensearch.tasks.TaskManager;
        TaskManager taskManager,
import org.opensearch.common.settings.Settings;
            transportInterceptor,  
     * {@link #sendChildRequest} overload that injects it) should apply this so streaming requests
        TimeValue.timeValueMinutes(5),
package org.opensearch.transport;
import org.opensearch.core.common.transport.BoundTransportAddress;
        final TransportRequest request,
            request,
            logger.debug("skipping stream connection to [{}]: node publishes no stream address", node);
        return streamTransportReqTimeout;  
import org.opensearch.threadpool.ThreadPool;
        } catch (Exception e) {
 * this file be licensed under the Apache-2.0 license or a
    /**
    ) {
            ),  
                    PROBE_HANDSHAKE_TIMEOUT_SETTING.get(settings),
    }
    private static final Logger logger = LogManager.getLogger(StreamTransportService.class);
            // it's a single channel profile and let underlying client handle parallelism by creating multiple channels as needed
            taskManager,
    public static final Setting<TimeValue> STREAM_TRANSPORT_REQ_TIMEOUT_SETTING = Setting.timeSetting(  
        }  
            logger.error("Failed to get streaming connection to node [{}]: {}", node, e.getMessage());
        Setting.Property.Dynamic
            return;  
            return;
        final Transport.Connection connection,
        this.streamTransportReqTimeout = STREAM_TRANSPORT_REQ_TIMEOUT_SETTING.get(settings);  
        RemoteClusterService remoteClusterService,
            TransportRequestOptions.builder().withType(TransportRequestOptions.Type.STREAM).withTimeout(streamTransportReqTimeout).build(),
public class StreamTransportService extends TransportService {
            streamTransport,
            node,
 * @opensearch.experimental
    );
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.tasks.Task;
            remoteClusterService,  
     * that build their own {@link TransportRequestOptions} (rather than using the
    public Transport.Connection getConnection(DiscoveryNode node) {
        try {
     * The configured streaming request timeout ({@code transport.stream.request_timeout}). Callers  
        );  
        }
        Transport streamTransport,
import org.opensearch.core.transport.TransportResponse;  
 *
import org.apache.logging.log4j.LogManager;
                    PROBE_CONNECT_TIMEOUT_SETTING.get(settings),  
        ThreadPool threadPool,  
    public TimeValue getStreamTransportReqTimeout() {
        super(
import org.opensearch.common.annotation.ExperimentalApi;
    @Override  
    public void connectToNode(final DiscoveryNode node, ConnectionProfile connectionProfile, ActionListener<Void> listener) {
 * SPDX-License-Identifier: Apache-2.0
        );
import org.opensearch.common.settings.ClusterSettings;  
        sendChildRequest(
        Tracer tracer  
import static org.opensearch.discovery.HandshakingTransportAddressConnector.PROBE_CONNECT_TIMEOUT_SETTING;
     */
            return connectionManager.getConnection(node);  
        if (clusterSettings != null) {
            tracer,
        if (node.getStreamAddress() == null) {  
        "transport.stream.request_timeout",
            connectionProfile,  
        Setting.Property.NodeScope,  
/*  
            action,
    ) {
            logger.warn("Failed to connect to streaming node [{}]: {}", node, exception.getMessage());  
     * honor the same timeout the service applies by default.  
                ),
import org.apache.logging.log4j.Logger;
        if (isLocalNode(node)) {
            threadPool,
                    false  
                streamTransport
