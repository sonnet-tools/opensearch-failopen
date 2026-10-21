    public void testOutboundBufferThresholdBounds() {
import java.util.Set;
        assertTrue(settings.contains(ServerConfig.ARROW_ENABLE_DEBUG_ALLOCATOR));
        assertEquals(TimeValue.timeValueSeconds(20), ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT.get(Settings.EMPTY));
        assertEquals(-1, SETTING_FLIGHT_PUBLISH_PORT.get(defaultSettings).intValue());
        );
    public void testReadyTimeoutMinimum() {
    }
    public void testKeepAliveTimeoutMustBeLessThanTime() {
        assertFalse(ServerConfig.ARROW_ENABLE_DEBUG_ALLOCATOR.get(defaultSettings));
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIME.getKey(), TimeValue.timeValueSeconds(60))
        Settings defaultSettings = Settings.EMPTY;
        assertEquals("true", System.getProperty("arrow.enable_unsafe_memory_access"));
        assertFalse(ServerConfig.ARROW_SSL_ENABLE.get(defaultSettings));
        clusterSettings.validate(ok, false);
        assertFalse(settings.isEmpty());
        super.setUp();
            .build();
        settings = Settings.builder()
package org.opensearch.arrow.flight.bootstrap;
    public void testGetSettings() {
        Settings tooLow = Settings.builder()
        // Verify system properties are set correctly
    }
        assertNotNull(flightGrpcExecutorBuilder);
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT.getKey(), TimeValue.timeValueSeconds(40))
            Settings.EMPTY,
        assertTrue(ServerConfig.isSslEnabled());
 * The OpenSearch Contributors require contributions made to
    private Settings settings;
        assertEquals("false", System.getProperty("arrow.memory.debug.allocator"));
            .put("arrow.enable_unsafe_memory_access", true)
}
        assertEquals(TimeValue.timeValueSeconds(60), ServerConfig.FLIGHT_READY_TIMEOUT.get(defaultSettings));
 */
        ServerConfig.init(settings);
/*
        Settings ok = Settings.builder()
        assertTrue(settings.contains(ServerConfig.ARROW_ALLOCATION_MANAGER_TYPE));
        expectThrows(IllegalArgumentException.class, () -> clusterSettings.validate(greater, false));
    }
    }
import org.opensearch.common.settings.ClusterSettings;
            .put(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.getKey(), new ByteSizeValue(16, ByteSizeUnit.MB))
 * this file be licensed under the Apache-2.0 license or a
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT.getKey(), TimeValue.timeValueSeconds(30))
        expectThrows(IllegalArgumentException.class, () -> ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(tooLow));
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
 *
    }
        expectThrows(IllegalArgumentException.class, () -> ServerConfig.FLIGHT_READY_TIMEOUT.get(tooLow));
        assertEquals(TimeValue.timeValueHours(2), ServerConfig.FLIGHT_KEEPALIVE_TIME.get(Settings.EMPTY));
            .put(ServerConfig.FLIGHT_READY_TIMEOUT.getKey(), TimeValue.timeValueSeconds(5))
        Settings tooHigh = Settings.builder()
        assertEquals(16L * 1024 * 1024, ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(overridden).getBytes());
    }
import org.opensearch.core.common.unit.ByteSizeUnit;
        ScalingExecutorBuilder flightGrpcExecutorBuilder = ServerConfig.getGrpcExecutorBuilder();
            .put("thread_pool.flight-server.keep_alive", TimeValue.timeValueMinutes(5))
    }
        assertEquals("Netty", ServerConfig.ARROW_ALLOCATION_MANAGER_TYPE.get(defaultSettings));
    }
import org.opensearch.common.settings.Settings;
import org.opensearch.threadpool.ScalingExecutorBuilder;
    public void testBackpressureSettingsParse() {
        ScalingExecutorBuilder serverExecutorBuilder = ServerConfig.getServerExecutorBuilder();
        assertEquals(3, serverExecutorBuilder.getRegisteredSettings().size());
        assertTrue(settings.contains(ServerConfig.ARROW_ENABLE_NULL_CHECK_FOR_GET));
        Settings equal = Settings.builder()
        assertEquals(512L * 1024, ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(defaultSettings).getBytes());
public class ServerConfigTests extends OpenSearchTestCase {
        assertEquals(4, serverExecutorBuilder.getRegisteredSettings().get(1).get(settings)); // max
import org.opensearch.common.unit.TimeValue;
 * compatible open source license.
        // Verify SSL settings
        assertEquals(TimeValue.timeValueSeconds(5), ServerConfig.FLIGHT_READY_TIMEOUT.get(overridden));
            .put(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.getKey(), new ByteSizeValue(64, ByteSizeUnit.KB))
        assertTrue(settings.contains(ServerConfig.ARROW_SSL_ENABLE));
        assertTrue(ServerConfig.ARROW_ENABLE_UNSAFE_MEMORY_ACCESS.get(defaultSettings));
        ClusterSettings clusterSettings = new ClusterSettings(
import org.opensearch.core.common.unit.ByteSizeValue;
            Set.of(ServerConfig.FLIGHT_KEEPALIVE_TIME, ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT)
        var settings = ServerConfig.getSettings();
        Settings overridden = Settings.builder()
    public void testKeepAliveDefaultsMatchGrpc() {
    public void testInit() {
        expectThrows(IllegalArgumentException.class, () -> ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(tooHigh));
        assertTrue(settings.contains(ServerConfig.FLIGHT_READY_TIMEOUT));
            .put("arrow.allocation.manager.type", "Netty")
            .build();
        Settings tooLow = Settings.builder().put(ServerConfig.FLIGHT_READY_TIMEOUT.getKey(), TimeValue.timeValueMillis(50)).build();
        // Verify default values
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIME.getKey(), TimeValue.timeValueSeconds(30))
        // 100ms minimum is enforced; lower values must be rejected at parse.
            .put("thread_pool.flight-server.min", 1)
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(ServerConfig.ARROW_ENABLE_NULL_CHECK_FOR_GET.get(defaultSettings));
        assertEquals(TimeValue.timeValueMinutes(5), serverExecutorBuilder.getRegisteredSettings().get(2).get(settings)); // keep alive
    public void testDefaultSettings() {
            .put("thread_pool.flight-server.max", 4)
        expectThrows(IllegalArgumentException.class, () -> clusterSettings.validate(equal, false));
        ServerConfig.init(defaultSettings);
            .put("arrow.enable_null_check_for_get", false)
        assertNotNull(serverExecutorBuilder);
            .build();
            .build();
            .build();
import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_PUBLISH_PORT;
    public void setUp() throws Exception {
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIME.getKey(), TimeValue.timeValueSeconds(30))
        assertNotNull(settings);
            .put("arrow.memory.debug.allocator", false)
        assertTrue(settings.contains(ServerConfig.ARROW_ENABLE_UNSAFE_MEMORY_ACCESS));
        assertEquals(1, serverExecutorBuilder.getRegisteredSettings().get(0).get(settings)); // min
        assertEquals("Netty", System.getProperty("arrow.allocation.manager.type"));
            .build();
        Settings greater = Settings.builder()
        assertEquals("false", System.getProperty("arrow.enable_null_check_for_get"));
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT.getKey(), TimeValue.timeValueSeconds(20))
            .put(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.getKey(), new ByteSizeValue(3, ByteSizeUnit.GB))
            .put("flight.ssl.enable", true)
        assertTrue(settings.contains(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD));
            .build();
