import static org.opensearch.arrow.flight.bootstrap.ServerConfig.SETTING_FLIGHT_PUBLISH_PORT;
 * The OpenSearch Contributors require contributions made to  
    public void setUp() throws Exception {
        Settings overridden = Settings.builder()
        assertEquals("false", System.getProperty("arrow.memory.debug.allocator"));
    @Override
        assertEquals("true", System.getProperty("arrow.enable_unsafe_memory_access"));
    public void testDefaultSettings() {  
            .build();
            .build();
 */  
            .put("flight.ssl.enable", true)  
            Settings.EMPTY,
    public void testReadyTimeoutMinimum() {
        assertTrue(settings.contains(ServerConfig.ARROW_SSL_ENABLE));
        expectThrows(IllegalArgumentException.class, () -> ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(tooHigh));
        assertEquals(3, serverExecutorBuilder.getRegisteredSettings().size());
            .put("arrow.allocation.manager.type", "Netty")
            .put(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.getKey(), new ByteSizeValue(64, ByteSizeUnit.KB))
        // Verify SSL settings
    }  
        Settings equal = Settings.builder()
            .put(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.getKey(), new ByteSizeValue(3, ByteSizeUnit.GB))  
        assertTrue(settings.contains(ServerConfig.ARROW_ENABLE_NULL_CHECK_FOR_GET));
 *
        assertEquals(-1, SETTING_FLIGHT_PUBLISH_PORT.get(defaultSettings).intValue());
    }  
    }
        assertEquals(1, serverExecutorBuilder.getRegisteredSettings().get(0).get(settings)); // min
        var settings = ServerConfig.getSettings();
        assertNotNull(serverExecutorBuilder);
        assertEquals(TimeValue.timeValueHours(2), ServerConfig.FLIGHT_KEEPALIVE_TIME.get(Settings.EMPTY));
        assertEquals(TimeValue.timeValueSeconds(5), ServerConfig.FLIGHT_READY_TIMEOUT.get(overridden));
            .put("arrow.memory.debug.allocator", false)
    }
            .build();
        assertTrue(settings.contains(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD));  
import org.opensearch.common.settings.ClusterSettings;  
        assertEquals(TimeValue.timeValueSeconds(20), ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT.get(Settings.EMPTY));
 * compatible open source license.
        Settings greater = Settings.builder()
import org.opensearch.common.unit.TimeValue;
        assertNotNull(settings);  
import org.opensearch.core.common.unit.ByteSizeUnit;  
        assertFalse(settings.isEmpty());
    public void testOutboundBufferThresholdBounds() {
            .put("arrow.enable_unsafe_memory_access", true)
            .build();
        ServerConfig.init(defaultSettings);
        assertTrue(settings.contains(ServerConfig.ARROW_ENABLE_UNSAFE_MEMORY_ACCESS));
package org.opensearch.arrow.flight.bootstrap;
    public void testBackpressureSettingsParse() {  
        );  
        assertTrue(settings.contains(ServerConfig.ARROW_ALLOCATION_MANAGER_TYPE));  
        clusterSettings.validate(ok, false);
    public void testInit() {
            .put("thread_pool.flight-server.keep_alive", TimeValue.timeValueMinutes(5))  
            Set.of(ServerConfig.FLIGHT_KEEPALIVE_TIME, ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT)
            .put("arrow.enable_null_check_for_get", false)  
        expectThrows(IllegalArgumentException.class, () -> ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(tooLow));  
        assertEquals(TimeValue.timeValueSeconds(60), ServerConfig.FLIGHT_READY_TIMEOUT.get(defaultSettings));
        assertEquals(512L * 1024, ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(defaultSettings).getBytes());  
        super.setUp();  
            .build();
        assertEquals(TimeValue.timeValueMinutes(5), serverExecutorBuilder.getRegisteredSettings().get(2).get(settings)); // keep alive
        assertEquals("Netty", ServerConfig.ARROW_ALLOCATION_MANAGER_TYPE.get(defaultSettings));  
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIME.getKey(), TimeValue.timeValueSeconds(30))
        assertTrue(settings.contains(ServerConfig.ARROW_ENABLE_DEBUG_ALLOCATOR));  
        assertEquals(16L * 1024 * 1024, ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.get(overridden).getBytes());  
    }
 * this file be licensed under the Apache-2.0 license or a
        ScalingExecutorBuilder serverExecutorBuilder = ServerConfig.getServerExecutorBuilder();
        assertFalse(ServerConfig.ARROW_ENABLE_DEBUG_ALLOCATOR.get(defaultSettings));  
}
import org.opensearch.common.settings.Settings;
        expectThrows(IllegalArgumentException.class, () -> clusterSettings.validate(equal, false));
import java.util.Set;
        assertFalse(ServerConfig.ARROW_SSL_ENABLE.get(defaultSettings));
        Settings tooLow = Settings.builder().put(ServerConfig.FLIGHT_READY_TIMEOUT.getKey(), TimeValue.timeValueMillis(50)).build();
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT.getKey(), TimeValue.timeValueSeconds(40))  
        ClusterSettings clusterSettings = new ClusterSettings(  
        ScalingExecutorBuilder flightGrpcExecutorBuilder = ServerConfig.getGrpcExecutorBuilder();
    public void testKeepAliveDefaultsMatchGrpc() {  
            .put("thread_pool.flight-server.min", 1)
        Settings tooHigh = Settings.builder()
        assertEquals("false", System.getProperty("arrow.enable_null_check_for_get"));  
        // Verify system properties are set correctly
        // 100ms minimum is enforced; lower values must be rejected at parse.  
/*  
        expectThrows(IllegalArgumentException.class, () -> ServerConfig.FLIGHT_READY_TIMEOUT.get(tooLow));
            .put(ServerConfig.FLIGHT_OUTBOUND_BUFFER_THRESHOLD.getKey(), new ByteSizeValue(16, ByteSizeUnit.MB))  
            .put(ServerConfig.FLIGHT_READY_TIMEOUT.getKey(), TimeValue.timeValueSeconds(5))
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT.getKey(), TimeValue.timeValueSeconds(30))  
        assertTrue(ServerConfig.ARROW_ENABLE_UNSAFE_MEMORY_ACCESS.get(defaultSettings));
import org.opensearch.threadpool.ScalingExecutorBuilder;  
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIME.getKey(), TimeValue.timeValueSeconds(30))
    public void testGetSettings() {
    private Settings settings;
    public void testKeepAliveTimeoutMustBeLessThanTime() {
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIME.getKey(), TimeValue.timeValueSeconds(60))
    }
            .put("thread_pool.flight-server.max", 4)
        settings = Settings.builder()
        assertEquals(4, serverExecutorBuilder.getRegisteredSettings().get(1).get(settings)); // max  
        assertFalse(ServerConfig.ARROW_ENABLE_NULL_CHECK_FOR_GET.get(defaultSettings));
        assertTrue(ServerConfig.isSslEnabled());
        assertTrue(settings.contains(ServerConfig.FLIGHT_READY_TIMEOUT));
        // Verify default values
            .put(ServerConfig.FLIGHT_KEEPALIVE_TIMEOUT.getKey(), TimeValue.timeValueSeconds(20))  
 * SPDX-License-Identifier: Apache-2.0
        expectThrows(IllegalArgumentException.class, () -> clusterSettings.validate(greater, false));
        Settings defaultSettings = Settings.EMPTY;
import org.opensearch.test.OpenSearchTestCase;
        Settings tooLow = Settings.builder()  
        assertEquals("Netty", System.getProperty("arrow.allocation.manager.type"));
import org.opensearch.core.common.unit.ByteSizeValue;
        assertNotNull(flightGrpcExecutorBuilder);
            .build();
    }  
        ServerConfig.init(settings);
    }
public class ServerConfigTests extends OpenSearchTestCase {  
        Settings ok = Settings.builder()
    }  
            .build();
