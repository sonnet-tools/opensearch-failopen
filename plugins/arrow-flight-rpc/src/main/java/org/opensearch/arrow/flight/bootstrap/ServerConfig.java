        Setting.Property.NodeScope
                        + "] is incorrect; expected: ["
    );
     * Checks if SSL/TLS is enabled for the Flight server.
        false, // TODO: get default from security enabled
                        + "] ("
    @SuppressForbidden(reason = "required for arrow allocator")
import org.opensearch.common.SuppressForbidden;
 * compatible open source license.
     */
    }
    );
    // behaviour is unchanged from before this setting existed; lower the time for faster
        }
        Setting.Property.NodeScope
 * thread pool configurations, and SSL/TLS settings.
    }
    public static boolean isSslEnabled() {
    static final Setting<Boolean> ARROW_ENABLE_UNSAFE_MEMORY_ACCESS = Setting.boolSetting(
import java.util.Arrays;
     */
            }
        TimeValue.timeValueSeconds(60),
import org.opensearch.common.transport.PortsRange;
     * Sets system properties for Arrow memory management and configures thread pool settings.
        "Netty",
                ARROW_SSL_ENABLE,
        Setting.Property.NodeScope
     * Setting for Arrow Flight publish host addresses.
        @SuppressForbidden(reason = "required for netty allocator configuration")
     * Returns a list of all settings managed by this configuration class.
    public static List<Setting<?>> getSettings() {
import io.netty.channel.epoll.EpollServerSocketChannel;
            System.setProperty("arrow.enable_null_check_for_get", Boolean.toString(ARROW_ENABLE_NULL_CHECK_FOR_GET.get(settings)));
 */
    public static int getEventLoopThreads() {
import java.util.Iterator;
    public static final Setting<TimeValue> FLIGHT_READY_TIMEOUT = Setting.timeSetting(
        Setting.Property.NodeScope
        new ByteSizeValue(2, ByteSizeUnit.GB),
        TimeValue.timeValueSeconds(30),
    );
    /**
                throw new IllegalArgumentException(
import java.util.ArrayList;
     * Setting for Arrow Flight host addresses.
     * batch larger than this still passes and the producer parks afterward. Must stay strictly below
import org.opensearch.secure_sm.AccessController;
        Setting.Property.NodeScope
     *
    );
        "arrow.enable_null_check_for_get",
    /**
    static final class KeepAliveTimeoutValidator implements Setting.Validator<TimeValue> {
    /**
 * This class manages server-side configurations including port settings, Arrow memory settings,
     *
            checkSystemProperty("io.netty.tryUnsafe", "true");
        "flight.ssl.enable",
    private static int threadPoolMax;
import java.util.Map;
                ARROW_ENABLE_NULL_CHECK_FOR_GET,
    public static final Setting<PortsRange> SETTING_FLIGHT_PORTS = AUX_TRANSPORT_PORT.getConcreteSettingForNamespace(
package org.opensearch.arrow.flight.bootstrap;
        0,
     * Initializes the server configuration with the provided settings.
        Setting.Property.NodeScope
    /**
        Setting.Property.NodeScope
        private static void checkSystemProperty(String propertyName, String expectedValue) {
    /**
        "arrow.flight.publish_host",
    public static ScalingExecutorBuilder getServerExecutorBuilder() {
     * @return EpollSocketChannel if Epoll is available, otherwise NioSocketChannel
    );
     */
                        + expectedValue
     *
     * {@link org.opensearch.transport.stream.StreamErrorCode#TIMED_OUT}.
        Setting.Property.NodeScope
        true,
        public Iterator<Setting<?>> settings() {
        new KeepAliveTimeoutValidator(),
        "thread_pool.flight-server.keep_alive",
        new ByteSizeValue(256, ByteSizeUnit.KB),
     * Setting for Arrow Flight port range.
                        + time
     *
    // Must be strictly less than FLIGHT_KEEPALIVE_TIME (else a slow-but-alive peer is
        Function.identity(),
        Setting.Property.NodeScope
     */
        return Epoll.isAvailable() ? EpollServerSocketChannel.class : NioServerSocketChannel.class;
        public static void init(Settings settings) {
                    "Required system property ["
 * @opensearch.internal
        Setting.Property.NodeScope
     */
     * Gets the thread pool executor builder configured for the Flight server.
     * Gets the thread pool executor builder configured for the Flight server.
    public static final Setting<Integer> SETTING_FLIGHT_PUBLISH_PORT = Setting.intSetting(
        "arrow.flight.channel.ready_timeout",
     *
        return grpcKeepAliveTimeout;
     */
    public static final String FLIGHT_TRANSPORT_SETTING_KEY = "transport-flight";
import io.netty.channel.epoll.EpollEventLoopGroup;
    public static final Setting<List<String>> SETTING_FLIGHT_BIND_HOST = Setting.listSetting(
        }
}
            )
                FLIGHT_READY_TIMEOUT,
            return List.<Setting<?>>of(FLIGHT_KEEPALIVE_TIME).iterator();
    static final Setting<Integer> FLIGHT_EVENT_LOOP_THREADS = Setting.intSetting(
import io.netty.channel.Channel;
    private static int threadPoolMin;
     * The setting key for Flight transport configuration.
            String actualValue = System.getProperty(propertyName);
    static final Setting<TimeValue> FLIGHT_KEEPALIVE_TIME = Setting.timeSetting(
        TimeValue.timeValueHours(2),
     */
    static final Setting<Integer> FLIGHT_THREAD_POOL_MAX_SIZE = Setting.intSetting(
    /**
        return new ScalingExecutorBuilder(FLIGHT_SERVER_THREAD_POOL_NAME, threadPoolMin, threadPoolMax, keepAlive);
        keepAlive = FLIGHT_THREAD_POOL_KEEP_ALIVE.get(settings);
    }
     * The thread pool name for the Flight grpc executor.
import org.opensearch.common.unit.TimeValue;
    private static TimeValue grpcKeepAliveTimeout;
     */
        emptyList(),
    static EventLoopGroup createELG(String name, int eventLoopThreads) {
     */
    public static final Setting<List<String>> SETTING_FLIGHT_PUBLISH_HOST = Setting.listSetting(
        false,
import io.netty.channel.nio.NioEventLoopGroup;
        Math.max(1, NettyRuntime.availableProcessors() * 2),
            }
    // gRPC server keepalive. Defaults match gRPC's own server defaults (time 2h, timeout 20s) so
    public static final String GRPC_EXECUTOR_THREAD_POOL_NAME = "flight-grpc";
                );
     */
    public ServerConfig() {}
    public static ScalingExecutorBuilder getGrpcExecutorBuilder() {
            }
        public void validate(final TimeValue timeout, final Map<Setting<?>, Object> settings) {
import io.netty.channel.socket.nio.NioServerSocketChannel;
     * @return true if SSL is enabled, false otherwise
 * The OpenSearch Contributors require contributions made to
    private static boolean enableSsl;
    private static final String host = "localhost";
                );
    /**
import io.netty.channel.EventLoopGroup;
        1,
    /**
    /**
        new ByteSizeValue(512, ByteSizeUnit.KB),
     *
    static final Setting<Boolean> ARROW_ENABLE_NULL_CHECK_FOR_GET = Setting.boolSetting(
    }
    );
     */
    static final Setting<TimeValue> FLIGHT_KEEPALIVE_TIMEOUT = new Setting<>(
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_PORT;
    private static int eventLoopThreads;
        -1,
    public static final Setting<List<String>> SETTING_FLIGHT_HOST = Setting.listSetting(
    );
        "flight.keepalive.timeout",
                FLIGHT_THREAD_POOL_MIN_SIZE,
    );
    static final Setting<Boolean> ARROW_SSL_ENABLE = Setting.boolSetting(
        "arrow.flight.host",
        return new ScalingExecutorBuilder(GRPC_EXECUTOR_THREAD_POOL_NAME, threadPoolMin, threadPoolMax, keepAlive);
        SETTING_FLIGHT_HOST,
    public static TimeValue getGrpcKeepAliveTimeout() {
     */
                throw new IllegalStateException(
import io.netty.channel.socket.nio.NioSocketChannel;
/**
     * @return The configured ScalingExecutorBuilder instance
     * before failing the batch with
    }
    /**
     *
    }
    /**
        "arrow.flight.channel.outbound_buffer_threshold",
    /** Enforces {@code flight.keepalive.timeout < flight.keepalive.time}. */
     * @return The configured ScalingExecutorBuilder instance
        }
        @Override
    public static final String FLIGHT_SERVER_THREAD_POOL_NAME = "flight-server";
 * this file be licensed under the Apache-2.0 license or a
    }
    }
            if (timeout.nanos() >= time.nanos()) {
     */
     * Returns the appropriate client channel type based on platform availability.
     */
    );
        return new ScalingExecutorBuilder(FLIGHT_CLIENT_THREAD_POOL_NAME, threadPoolMin, threadPoolMax, keepAlive);
    );
        100000, // TODO depends on max concurrent streams per node, decide after benchmark. To be controlled by admission control layer.
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
     * {@code native.allocator.pool.flight.max} so the gate engages before the allocator runs out.
        FLIGHT_TRANSPORT_SETTING_KEY
        "thread_pool.flight-server.max",
        @Override
    static final Setting<Boolean> ARROW_ENABLE_DEBUG_ALLOCATOR = Setting.boolSetting(
    static final Setting<Integer> FLIGHT_THREAD_POOL_MIN_SIZE = Setting.intSetting(
    /**
                        + actualValue
    /**
            checkSystemProperty("io.netty.noUnsafe", "false");
    /**
import io.netty.channel.epoll.Epoll;
     * It bounds pipelining depth, not a single batch: gRPC accepts an over-watermark write in full, so a
        return grpcKeepAliveTime;
    /**
                FLIGHT_EVENT_LOOP_THREADS,
        Function.identity(),
    }
        TimeValue.timeValueSeconds(20).getStringRep(),
    public static final String FLIGHT_CLIENT_THREAD_POOL_NAME = "flight-client";
     * Gets the configured number of event loop threads.
            ? new EpollEventLoopGroup(eventLoopThreads, OpenSearchExecutors.daemonThreadFactory(name))
        return new ArrayList<>(
import java.util.List;
        TimeValue.timeValueSeconds(1),
    public static void init(Settings settings) {
    /**
     */
        "arrow.enable_unsafe_memory_access",
        Setting.Property.NodeScope
     * @return The configured ScalingExecutorBuilder instance
                        + propertyName
     */
        "flight.event_loop.threads",
            if (!expectedValue.equals(actualValue)) {
            Arrays.asList(
public class ServerConfig {
    public static final Setting<ByteSizeValue> FLIGHT_OUTBOUND_BUFFER_THRESHOLD = Setting.byteSizeSetting(
    // false-disconnected); enforced by the validator below.
    );
     * Gets the thread pool executor builder configured for the Flight server grpc executor.
     * @return The number of event loop threads
            System.setProperty("arrow.allocation.manager.type", ARROW_ALLOCATION_MANAGER_TYPE.get(settings));
    /**
        Setting.Property.NodeScope
        threadPoolMax = FLIGHT_THREAD_POOL_MAX_SIZE.get(settings);
            int numArenas = Integer.parseInt(System.getProperty("io.netty.allocator.numDirectArenas"));
        return eventLoopThreads;
        s -> TimeValue.parseTimeValue(s, "flight.keepalive.timeout"),
    // dead-connection detection (releases resources held by a stalled stream on a half-open connection).
     * {@code isReady()} flips false once a stream's outbound buffer crosses this size, parking the producer.
                        + "]."
     */
        eventLoopThreads = FLIGHT_EVENT_LOOP_THREADS.get(settings);
    static final Setting<String> ARROW_ALLOCATION_MANAGER_TYPE = Setting.simpleString(
        public void validate(final TimeValue value) {}
        Setting.Property.NodeScope
        -1,
import io.netty.util.NettyRuntime;
        AccessController.doPrivileged(() -> {
    }
     *
                        + "] ("
 * Configuration class for OpenSearch Flight server settings.
     * Creates a new instance of the server configuration with default settings.
     * Per-stream outbound buffered-bytes watermark passed to gRPC's {@code setOnReadyThreshold}.
                FLIGHT_KEEPALIVE_TIME,
    /** gRPC keepalive ack timeout: kill the connection if a PING is unacked for this long. */
    );
        threadPoolMin = FLIGHT_THREAD_POOL_MIN_SIZE.get(settings);
        "arrow.flight.publish_port",
    /**
     */
        }
import java.util.function.Function;
     * Setting for Arrow Flight bind host addresses.
                FLIGHT_KEEPALIVE_TIMEOUT,
    );
        });
        Setting.Property.NodeScope
            checkSystemProperty("io.netty.tryReflectionSetAccessible", "true");
    }
        "arrow.flight.bind_host",
            Netty4Configs.init(settings);
                        + ") must be less than ["
     */
 * SPDX-License-Identifier: Apache-2.0
    public static ScalingExecutorBuilder getClientExecutorBuilder() {
        Setting.Property.NodeScope
                        + ")"
    static final Setting<TimeValue> FLIGHT_THREAD_POOL_KEEP_ALIVE = Setting.timeSetting(
    /**
                throw new IllegalStateException("io.netty.allocator.numDirectArenas must be > 0");
     * The thread pool name for the Flight producer handling
import org.opensearch.common.settings.Setting;
        );
    );
                ARROW_ENABLE_DEBUG_ALLOCATOR,
     * Maximum time the producer thread parks in {@code FlightServerChannel.awaitReadyOrThrow}
        false,
    private static class Netty4Configs {
        @Override
    public static Class<? extends Channel> clientChannelType() {
    }
     * Setting for Arrow Flight publish port.
            final TimeValue time = (TimeValue) settings.get(FLIGHT_KEEPALIVE_TIME);
    }
        "arrow.allocation.manager.type",
                ARROW_ALLOCATION_MANAGER_TYPE,
        "thread_pool.flight-server.min",
    private static TimeValue keepAlive;
                ARROW_ENABLE_UNSAFE_MEMORY_ACCESS,
        grpcKeepAliveTime = FLIGHT_KEEPALIVE_TIME.get(settings);
import io.netty.channel.epoll.EpollSocketChannel;
     * @return EpollServerSocketChannel if Epoll is available, otherwise NioServerSocketChannel
                    "["
        "arrow.memory.debug.allocator",
                        + "] actual: ["
                        + timeout
                FLIGHT_OUTBOUND_BUFFER_THRESHOLD
            System.setProperty("arrow.enable_unsafe_memory_access", Boolean.toString(ARROW_ENABLE_UNSAFE_MEMORY_ACCESS.get(settings)));
        SETTING_FLIGHT_HOST,
     */
                        + FLIGHT_KEEPALIVE_TIME.getKey()
        return Epoll.isAvailable()
     */
import org.opensearch.threadpool.ScalingExecutorBuilder;
/*
        Function.identity(),
        0,
        TimeValue.timeValueMillis(100),
        "flight.keepalive.time",
 *
     * @return List of Setting instances
            if (numArenas <= 0) {
            : new NioEventLoopGroup(eventLoopThreads, OpenSearchExecutors.daemonThreadFactory(name));
import org.opensearch.common.settings.Settings;
        return Epoll.isAvailable() ? EpollSocketChannel.class : NioSocketChannel.class;
     * The thread pool name for the Flight client.
        return enableSsl;
    }
    );
    );
    public static TimeValue getGrpcKeepAliveTime() {
import org.opensearch.core.common.unit.ByteSizeValue;
     * @param settings The OpenSearch settings to initialize the server with
        Setting.Property.NodeScope
    );
    /**
            System.setProperty("arrow.memory.debug.allocator", Boolean.toString(ARROW_ENABLE_DEBUG_ALLOCATOR.get(settings)));
    public static Class<? extends Channel> serverChannelType() {
    /** gRPC keepalive PING interval on the Flight server (connection-level liveness). */
                        + FLIGHT_KEEPALIVE_TIMEOUT.getKey()
        enableSsl = ARROW_SSL_ENABLE.get(settings);
    private static TimeValue grpcKeepAliveTime;
        1,
 */
        grpcKeepAliveTimeout = FLIGHT_KEEPALIVE_TIMEOUT.get(settings);
     * Returns the appropriate server channel type based on platform availability.
    /**
        Setting.Property.NodeScope
import static java.util.Collections.emptyList;
     *
    );
import org.opensearch.core.common.unit.ByteSizeUnit;
