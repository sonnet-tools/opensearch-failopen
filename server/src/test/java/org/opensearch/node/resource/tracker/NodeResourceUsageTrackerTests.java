        NodeResourceUsageTracker tracker = new NodeResourceUsageTracker(  
        );
            "15s",
        assertEquals("heap > ram → unconfigured", "0b", ResourceTrackerSettings.deriveNativeMemoryLimitDefault(ram, ram + 1));  
        );
        );  
import static org.mockito.Mockito.mock;
            mock(FsService.class),
        // Happy path: 64 GB / 16 GB heap → 80% of (RAM - heap) = 79% of 48 GB.
            "10s",
            response.getPersistentSettings().get(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey())  
            tracker.getResourceTrackerSettings().setNativeMemoryLimitBytes(2L * 1024 * 1024 * 1024);
import org.opensearch.common.settings.Settings;  
                .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "2GB")
        // Negative ram (defensive against probe quirks).
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        );  
import org.junit.Before;
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), "5s")
 * compatible open source license.
        assertEquals(  
    ThreadPool threadPool;
            // cluster's update consumer does not reach it directly. Exercise the setter path
    public void testNativeMemoryLimitAndBufferDynamicUpdate() throws Exception {  
    }
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), new TimeValue(500, TimeUnit.MILLISECONDS))
            ClusterUpdateSettingsResponse response = client().admin()
        );  
    }
        assertAcked(  
                .prepareUpdateSettings()
            // The holder is owned by the tracker constructed in this test, so the single-node
        assertEquals("negative ram → unconfigured", "0b", ResourceTrackerSettings.deriveNativeMemoryLimitDefault(-1, 1L << 30));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("heap >= ram → unconfigured", "0b", ResourceTrackerSettings.deriveNativeMemoryLimitDefault(ram, ram));
            settings,
            .build();
        }
                "25",  
            assertThat(tracker.getResourceTrackerSettings().getNativeMemoryBufferPercent(), equalTo(0));
            .build();
            response.getPersistentSettings().get(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey())
        NodeResourceUsageTracker tracker = new NodeResourceUsageTracker(
        assertEquals(
    @After  
     * Exercises {@link ResourceTrackerSettings#deriveNativeMemoryLimitDefault(long, long)}
        ClusterUpdateSettingsResponse response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get();  
        // Probe returned 0 (restricted container, /proc/meminfo unreadable).
            // Explicitly unconfigured: limit=0 bytes, buffer=0 percent.
import org.junit.After;  
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), "15s")  
                .cluster()
    public void setup() {
        long sixteenGB = 16L * 1024 * 1024 * 1024;  
/**
        // Heap >= ram (degenerate config, e.g. -Xmx larger than container limit).  
     * {@link org.opensearch.monitor.os.OsProbe} delegates to this one.
    }
        try {
        // "limit=0 bytes" baseline this test wants to start from must be set explicitly.
        tracker.close();
        );  
            expected + "b",
            ResourceTrackerSettings.deriveNativeMemoryLimitDefault(sixtyFourGB, sixteenGB)
            threadPool,  
     * fallback paths so the {@code "0b"} branch is covered without depending on the  
        Settings ioSettings = Settings.builder()
 */  
        long ram = 8L * 1024 * 1024 * 1024;
        long sixtyFourGB = 64L * 1024 * 1024 * 1024;
        tracker.start();
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(jvmsettings).get();  
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            response.getPersistentSettings().get(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey())  
        assertEquals(
            tracker.getResourceTrackerSettings().setNativeMemoryBufferPercent(25);
        assertEquals(  
            mock(FsService.class),
        Settings settings = Settings.builder()  
        );
                .setPersistentSettings(Settings.builder().putNull("*"))
                .cluster()  
                .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING.getKey(), 25)  
     */  
                .get();  
     * test machine's RAM/heap configuration. The single-arg overload that reads from
            "happy path → 80% of (ram - heap)",  
                .prepareUpdateSettings()  
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), "10s")
            assertThat(tracker.getResourceTrackerSettings().getNativeMemoryLimitBytes(), equalTo(0L));  
            .build();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    /**
            assertThat(tracker.getResourceTrackerSettings().getNativeMemoryBufferPercent(), equalTo(25));
            threadPool,  
import org.opensearch.monitor.fs.FsService;
            // Update both via cluster settings API and verify they propagate to the holder.  
import static org.hamcrest.Matchers.equalTo;  
         * cpu percent used is mostly 0, so skipping assertion for that
            new ClusterSettings(unconfiguredAc, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        long expected = (sixtyFourGB - sixteenGB) * 80 / 100;
                .build();
 */  
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(ioSettings).get();
            tracker.close();  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
        } finally {
 * this file be licensed under the Apache-2.0 license or a
                response.getPersistentSettings().get(ResourceTrackerSettings.NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING.getKey())
            unconfiguredAc,
            assertEquals("2GB", response.getPersistentSettings().get(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey()));
            "20s",
        assertEquals(tracker.getResourceTrackerSettings().getMemoryWindowDuration().getSeconds(), 30);
        tracker.stop();
    }  
import java.util.concurrent.TimeUnit;  
 * The OpenSearch Contributors require contributions made to  
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(nativeMemorySettings).get();
            Settings.EMPTY,  
         */
import static org.hamcrest.Matchers.greaterThan;
            .build();
        assertEquals(
        Settings settings = Settings.builder()
}
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), "20s")  
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
        Settings nativeMemorySettings = Settings.builder()
            assertEquals(
         * Asserting memory utilization to be greater than 0  
import org.opensearch.common.settings.ClusterSettings;
    public void testStats() throws Exception {  
 * Tests to assert resource usage trackers retrieving resource utilization averages
            "5s",
public class NodeResourceUsageTrackerTests extends OpenSearchSingleNodeTestCase {
        threadPool = new TestThreadPool(getClass().getName());  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
            response.getPersistentSettings().get(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey())
        NodeResourceUsageTracker tracker = new NodeResourceUsageTracker(
import org.opensearch.threadpool.TestThreadPool;
            Settings updated = Settings.builder()
import org.opensearch.common.unit.TimeValue;
        assertEquals(tracker.getResourceTrackerSettings().getCpuWindowDuration().getSeconds(), 30);
                .setTransientSettings(Settings.builder().putNull("*"))
            threadPool,
        Settings jvmsettings = Settings.builder()  
 *
    }
                .setPersistentSettings(updated)
import org.opensearch.threadpool.ThreadPool;
    }
        assertEquals("unknown ram → unconfigured", "0b", ResourceTrackerSettings.deriveNativeMemoryLimitDefault(0, 1L << 30));  
        assertEquals(tracker.getResourceTrackerSettings().getIoWindowDuration().getSeconds(), 120);  
        );  
            mock(FsService.class),
            // explicitly to prove it writes to the volatile fields used by the tracker.  
/*  
            client().admin()
            );
            assertThat(tracker.getResourceTrackerSettings().getNativeMemoryLimitBytes(), equalTo(2L * 1024 * 1024 * 1024));  
        );  
        assertEquals(tracker.getResourceTrackerSettings().getNativeMemoryWindowDuration().getSeconds(), 30);
package org.opensearch.node.resource.tracker;
    public void cleanup() {
        // Default for node.native_memory.limit is now ram - heap (machine-dependent), so the
            .build();
    public void testDeriveNativeMemoryLimitDefaultFallbackPaths() {
    @Before
        /**
        Settings unconfiguredAc = Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "0b").build();  
    public void testUpdateSettings() {
        assertBusy(() -> assertThat(tracker.getMemoryUtilizationPercent(), greaterThan(0.0)), 5, TimeUnit.SECONDS);  
