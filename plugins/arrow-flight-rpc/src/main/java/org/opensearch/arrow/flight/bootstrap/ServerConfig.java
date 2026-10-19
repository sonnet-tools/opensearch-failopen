        });  
    // Must be strictly less than FLIGHT_KEEPALIVE_TIME (else a slow-but-alive peer is
     */
                throw new IllegalStateException(  
    /**
    private static final String host = "localhost";
    /** Enforces {@code flight.keepalive.timeout < flight.keepalive.time}. */  
    }  
                ARROW_ENABLE_NULL_CHECK_FOR_GET,
            if (timeout.nanos() >= time.nanos()) {
        }
        "arrow.enable_unsafe_memory_access",
        TimeValue.timeValueSeconds(20).getStringRep(),  
 */
    /**
    public static ScalingExecutorBuilder getServerExecutorBuilder() {
        new ByteSizeValue(2, ByteSizeUnit.GB),
     * {@link org.opensearch.transport.stream.StreamErrorCode#TIMED_OUT}.  
/**  
    // false-disconnected); enforced by the validator below.  
     * batch larger than this still passes and the producer parks afterward. Must stay strictly below
    public static boolean isSslEnabled() {
                throw new IllegalStateException("io.netty.allocator.numDirectArenas must be > 0");
                        + timeout
        public void validate(final TimeValue timeout, final Map<Setting<?>, Object> settings) {  
     *
     * @param settings The OpenSearch settings to initialize the server with
    public static Class<? extends Channel> serverChannelType() {
    static final Setting<Boolean> ARROW_SSL_ENABLE = Setting.boolSetting(
import io.netty.channel.socket.nio.NioServerSocketChannel;
        return grpcKeepAliveTime;  
    }
    static EventLoopGroup createELG(String name, int eventLoopThreads) {
        1,
    /**
        return Epoll.isAvailable() ? EpollSocketChannel.class : NioSocketChannel.class;
            ? new EpollEventLoopGroup(eventLoopThreads, OpenSearchExecutors.daemonThreadFactory(name))
    );
                        + FLIGHT_KEEPALIVE_TIME.getKey()  
        Function.identity(),
        new ByteSizeValue(256, ByteSizeUnit.KB),
    }
        "flight.event_loop.threads",
            : new NioEventLoopGroup(eventLoopThreads, OpenSearchExecutors.daemonThreadFactory(name));
    /**
     * {@code native.allocator.pool.flight.max} so the gate engages before the allocator runs out.
    public static Class<? extends Channel> clientChannelType() {
    public static ScalingExecutorBuilder getClientExecutorBuilder() {
    /** gRPC keepalive PING interval on the Flight server (connection-level liveness). */
            }  
        threadPoolMin = FLIGHT_THREAD_POOL_MIN_SIZE.get(settings);
     * Sets system properties for Arrow memory management and configures thread pool settings.  
     * Returns a list of all settings managed by this configuration class.  
        "arrow.flight.publish_port",  
    static final Setting<String> ARROW_ALLOCATION_MANAGER_TYPE = Setting.simpleString(
    );
    private static TimeValue grpcKeepAliveTime;
        Setting.Property.NodeScope  
        Setting.Property.NodeScope
import io.netty.channel.epoll.EpollSocketChannel;  
        keepAlive = FLIGHT_THREAD_POOL_KEEP_ALIVE.get(settings);
     * Initializes the server configuration with the provided settings.
     * Maximum time the producer thread parks in {@code FlightServerChannel.awaitReadyOrThrow}
     * @return EpollSocketChannel if Epoll is available, otherwise NioSocketChannel
import io.netty.channel.epoll.EpollEventLoopGroup;
    static final Setting<Boolean> ARROW_ENABLE_UNSAFE_MEMORY_ACCESS = Setting.boolSetting(
    );
    );
     * @return true if SSL is enabled, false otherwise
    @SuppressForbidden(reason = "required for arrow allocator")
    public static final String FLIGHT_SERVER_THREAD_POOL_NAME = "flight-server";
    static final Setting<Integer> FLIGHT_THREAD_POOL_MIN_SIZE = Setting.intSetting(
     * {@code isReady()} flips false once a stream's outbound buffer crosses this size, parking the producer.
    );
     */  
import static java.util.Collections.emptyList;  
            String actualValue = System.getProperty(propertyName);
import java.util.List;  
     */  
        TimeValue.timeValueSeconds(30),
            }
     */
        Setting.Property.NodeScope
                FLIGHT_READY_TIMEOUT,
import io.netty.channel.epoll.EpollServerSocketChannel;
                FLIGHT_THREAD_POOL_MIN_SIZE,  
    );  
     * @return EpollServerSocketChannel if Epoll is available, otherwise NioServerSocketChannel
    }  
    private static TimeValue keepAlive;
     */  
        "arrow.flight.bind_host",
        -1,
    );
import io.netty.channel.epoll.Epoll;  
 * thread pool configurations, and SSL/TLS settings.  
        public Iterator<Setting<?>> settings() {  
    private static boolean enableSsl;
     * The thread pool name for the Flight client.  
     * It bounds pipelining depth, not a single batch: gRPC accepts an over-watermark write in full, so a  
    );
        }
     */
 * SPDX-License-Identifier: Apache-2.0
    /**
    public static final String FLIGHT_CLIENT_THREAD_POOL_NAME = "flight-client";
        grpcKeepAliveTime = FLIGHT_KEEPALIVE_TIME.get(settings);  
        public static void init(Settings settings) {
        TimeValue.timeValueMillis(100),
    public static final Setting<List<String>> SETTING_FLIGHT_PUBLISH_HOST = Setting.listSetting(
                        + time
        "arrow.flight.channel.ready_timeout",  
            if (numArenas <= 0) {
        emptyList(),
        "thread_pool.flight-server.keep_alive",
        1,  
        Setting.Property.NodeScope  
import org.opensearch.common.unit.TimeValue;
        return Epoll.isAvailable() ? EpollServerSocketChannel.class : NioServerSocketChannel.class;
        SETTING_FLIGHT_HOST,
        @SuppressForbidden(reason = "required for netty allocator configuration")
     * Gets the thread pool executor builder configured for the Flight server.  
     * @return List of Setting instances
 * Configuration class for OpenSearch Flight server settings.
import java.util.ArrayList;  
            }  
                    "Required system property ["
        Setting.Property.NodeScope
        return new ScalingExecutorBuilder(FLIGHT_CLIENT_THREAD_POOL_NAME, threadPoolMin, threadPoolMax, keepAlive);
    public static final Setting<List<String>> SETTING_FLIGHT_BIND_HOST = Setting.listSetting(  
     */
     */  
                throw new IllegalArgumentException(  
                );
        Setting.Property.NodeScope
        new ByteSizeValue(512, ByteSizeUnit.KB),  
 * this file be licensed under the Apache-2.0 license or a
     * Setting for Arrow Flight port range.
import java.util.Arrays;
     * Creates a new instance of the server configuration with default settings.
    static final Setting<Integer> FLIGHT_EVENT_LOOP_THREADS = Setting.intSetting(  
import java.util.Iterator;
        }  
     */
        Setting.Property.NodeScope
     */  
        @Override
            checkSystemProperty("io.netty.noUnsafe", "false");
                        + "] actual: ["
     */  
                FLIGHT_KEEPALIVE_TIMEOUT,
        Setting.Property.NodeScope  
import io.netty.util.NettyRuntime;
            int numArenas = Integer.parseInt(System.getProperty("io.netty.allocator.numDirectArenas"));  
        );
        Math.max(1, NettyRuntime.availableProcessors() * 2),
import io.netty.channel.socket.nio.NioSocketChannel;  
     *
    );
     * Gets the thread pool executor builder configured for the Flight server grpc executor.  
    public static final Setting<List<String>> SETTING_FLIGHT_HOST = Setting.listSetting(
     * @return The number of event loop threads
            if (!expectedValue.equals(actualValue)) {
        "arrow.flight.host",  
    static final Setting<Integer> FLIGHT_THREAD_POOL_MAX_SIZE = Setting.intSetting(
     * Gets the configured number of event loop threads.  
                ARROW_ENABLE_UNSAFE_MEMORY_ACCESS,
                );
    );
    public static final Setting<Integer> SETTING_FLIGHT_PUBLISH_PORT = Setting.intSetting(
    );
import org.opensearch.common.transport.PortsRange;
    private static int eventLoopThreads;  
    static final class KeepAliveTimeoutValidator implements Setting.Validator<TimeValue> {
import java.util.function.Function;
     * before failing the batch with
     * @return The configured ScalingExecutorBuilder instance
     * @return The configured ScalingExecutorBuilder instance
                        + FLIGHT_KEEPALIVE_TIMEOUT.getKey()
        s -> TimeValue.parseTimeValue(s, "flight.keepalive.timeout"),
                        + ") must be less than ["
    /**
     */  
     *
        @Override
    public static TimeValue getGrpcKeepAliveTime() {
     *
        "flight.ssl.enable",
        return enableSsl;
        "thread_pool.flight-server.max",  
    public ServerConfig() {}
 * This class manages server-side configurations including port settings, Arrow memory settings,
    /**
        false,  
    }  
     *
        private static void checkSystemProperty(String propertyName, String expectedValue) {  
    static final Setting<TimeValue> FLIGHT_KEEPALIVE_TIME = Setting.timeSetting(
        Setting.Property.NodeScope
import org.opensearch.common.SuppressForbidden;
        Function.identity(),
    public static List<Setting<?>> getSettings() {
    /**
        return grpcKeepAliveTimeout;
import java.util.Map;
        Setting.Property.NodeScope
            Arrays.asList(  
            )  
import org.opensearch.secure_sm.AccessController;  
    public static final String FLIGHT_TRANSPORT_SETTING_KEY = "transport-flight";  
     * @return The configured ScalingExecutorBuilder instance
    }  
            return List.<Setting<?>>of(FLIGHT_KEEPALIVE_TIME).iterator();
                        + "] is incorrect; expected: ["  
                        + "]."
        @Override
    }  
     */  
        FLIGHT_TRANSPORT_SETTING_KEY
    /**  
                        + "] ("
}  
        return eventLoopThreads;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    public static final Setting<TimeValue> FLIGHT_READY_TIMEOUT = Setting.timeSetting(
        -1,
        0,
     *
import org.opensearch.common.settings.Setting;
                FLIGHT_OUTBOUND_BUFFER_THRESHOLD
        Setting.Property.NodeScope
        0,  
        "arrow.flight.publish_host",
        return Epoll.isAvailable()  
    static final Setting<TimeValue> FLIGHT_THREAD_POOL_KEEP_ALIVE = Setting.timeSetting(  
     * Returns the appropriate server channel type based on platform availability.  
    /** gRPC keepalive ack timeout: kill the connection if a PING is unacked for this long. */  
    // behaviour is unchanged from before this setting existed; lower the time for faster
     * Setting for Arrow Flight bind host addresses.
/*  
                ARROW_SSL_ENABLE,
     * Setting for Arrow Flight publish host addresses.
    /**  
    /**
        new KeepAliveTimeoutValidator(),
    }  
        return new ScalingExecutorBuilder(GRPC_EXECUTOR_THREAD_POOL_NAME, threadPoolMin, threadPoolMax, keepAlive);
import org.opensearch.core.common.unit.ByteSizeUnit;
        TimeValue.timeValueSeconds(60),
        "Netty",  
 */  
            System.setProperty("arrow.enable_unsafe_memory_access", Boolean.toString(ARROW_ENABLE_UNSAFE_MEMORY_ACCESS.get(settings)));  
     */
     * The thread pool name for the Flight grpc executor.
     * Per-stream outbound buffered-bytes watermark passed to gRPC's {@code setOnReadyThreshold}.
     *
            Netty4Configs.init(settings);
        "flight.keepalive.timeout",
                        + "] ("  
                FLIGHT_EVENT_LOOP_THREADS,
     * Setting for Arrow Flight publish port.  
        100000, // TODO depends on max concurrent streams per node, decide after benchmark. To be controlled by admission control layer.
    public static final Setting<PortsRange> SETTING_FLIGHT_PORTS = AUX_TRANSPORT_PORT.getConcreteSettingForNamespace(  
     * Setting for Arrow Flight host addresses.  
import io.netty.channel.nio.NioEventLoopGroup;
    }
            final TimeValue time = (TimeValue) settings.get(FLIGHT_KEEPALIVE_TIME);
            System.setProperty("arrow.memory.debug.allocator", Boolean.toString(ARROW_ENABLE_DEBUG_ALLOCATOR.get(settings)));
        }
        "thread_pool.flight-server.min",
     */  
public class ServerConfig {  
     * Returns the appropriate client channel type based on platform availability.  
    public static ScalingExecutorBuilder getGrpcExecutorBuilder() {
                ARROW_ENABLE_DEBUG_ALLOCATOR,  
    // gRPC server keepalive. Defaults match gRPC's own server defaults (time 2h, timeout 20s) so
 * The OpenSearch Contributors require contributions made to  
import io.netty.channel.EventLoopGroup;
        "arrow.allocation.manager.type",
    public static final String GRPC_EXECUTOR_THREAD_POOL_NAME = "flight-grpc";  
                ARROW_ALLOCATION_MANAGER_TYPE,
        TimeValue.timeValueSeconds(1),
 * compatible open source license.
    public static int getEventLoopThreads() {
        Setting.Property.NodeScope  
        Setting.Property.NodeScope
    }  
     */  
    public static final Setting<ByteSizeValue> FLIGHT_OUTBOUND_BUFFER_THRESHOLD = Setting.byteSizeSetting(
        Setting.Property.NodeScope  
        return new ScalingExecutorBuilder(FLIGHT_SERVER_THREAD_POOL_NAME, threadPoolMin, threadPoolMax, keepAlive);
                        + expectedValue
                FLIGHT_KEEPALIVE_TIME,  
        SETTING_FLIGHT_HOST,  
     */
    /**
    /**  
        enableSsl = ARROW_SSL_ENABLE.get(settings);
            checkSystemProperty("io.netty.tryReflectionSetAccessible", "true");  
     * The setting key for Flight transport configuration.
    /**
        "arrow.flight.channel.outbound_buffer_threshold",
    /**  
    public static TimeValue getGrpcKeepAliveTimeout() {
    static final Setting<Boolean> ARROW_ENABLE_DEBUG_ALLOCATOR = Setting.boolSetting(
    static final Setting<Boolean> ARROW_ENABLE_NULL_CHECK_FOR_GET = Setting.boolSetting(
        Setting.Property.NodeScope
        false,  
     */  
     */
        grpcKeepAliveTimeout = FLIGHT_KEEPALIVE_TIMEOUT.get(settings);
        eventLoopThreads = FLIGHT_EVENT_LOOP_THREADS.get(settings);
        return new ArrayList<>(
    /**
     *
    /**
 *
 * @opensearch.internal
        threadPoolMax = FLIGHT_THREAD_POOL_MAX_SIZE.get(settings);  
        Function.identity(),  
            checkSystemProperty("io.netty.tryUnsafe", "true");
     */  
        Setting.Property.NodeScope  
    private static TimeValue grpcKeepAliveTimeout;
        false, // TODO: get default from security enabled  
     *
    static final Setting<TimeValue> FLIGHT_KEEPALIVE_TIMEOUT = new Setting<>(
    /**  
    /**
import org.opensearch.threadpool.ScalingExecutorBuilder;
        "arrow.enable_null_check_for_get",
    private static class Netty4Configs {
    }
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_PORT;
    );
        Setting.Property.NodeScope  
    );
                        + actualValue  
        AccessController.doPrivileged(() -> {  
        TimeValue.timeValueHours(2),  
                    "["
import org.opensearch.common.settings.Settings;  
                        + ")"  
     * Checks if SSL/TLS is enabled for the Flight server.  
    public static void init(Settings settings) {
        public void validate(final TimeValue value) {}  
    );
    private static int threadPoolMin;  
            System.setProperty("arrow.enable_null_check_for_get", Boolean.toString(ARROW_ENABLE_NULL_CHECK_FOR_GET.get(settings)));
    );  
    /**
import io.netty.channel.Channel;
        "arrow.memory.debug.allocator",
     * Gets the thread pool executor builder configured for the Flight server.  
            System.setProperty("arrow.allocation.manager.type", ARROW_ALLOCATION_MANAGER_TYPE.get(settings));
                        + propertyName
    }  
    );
    private static int threadPoolMax;
     * The thread pool name for the Flight producer handling  
    /**  
    }  
import org.opensearch.core.common.unit.ByteSizeValue;
package org.opensearch.arrow.flight.bootstrap;
    // dead-connection detection (releases resources held by a stalled stream on a half-open connection).  
    }  
    );  
        true,  
        "flight.keepalive.time",
     */
    );
