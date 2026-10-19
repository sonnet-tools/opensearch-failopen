            settings,
        );
                .get();
            new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            .build();
        assertEquals(
            tracker.getResourceTrackerSettings().setNativeMemoryLimitBytes(2L * 1024 * 1024 * 1024);
                .cluster()
                .setPersistentSettings(updated)
 * The OpenSearch Contributors require contributions made to
        // Heap >= ram (degenerate config, e.g. -Xmx larger than container limit).
        assertAcked(
import org.opensearch.threadpool.ThreadPool;
        );
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), "5s")
        );
                response.getPersistentSettings().get(ResourceTrackerSettings.NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING.getKey())
    ThreadPool threadPool;
            .put(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), "10s")
import org.opensearch.monitor.fs.FsService;
                .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "2GB")
package org.opensearch.node.resource.tracker;
            client().admin()
            .build();
        // Probe returned 0 (restricted container, /proc/meminfo unreadable).
        Settings ioSettings = Settings.builder()
    public void testDeriveNativeMemoryLimitDefaultFallbackPaths() {
        assertEquals(
        NodeResourceUsageTracker tracker = new NodeResourceUsageTracker(
        NodeResourceUsageTracker tracker = new NodeResourceUsageTracker(
    public void cleanup() {
    public void testNativeMemoryLimitAndBufferDynamicUpdate() throws Exception {
            Settings.EMPTY,
import org.opensearch.common.settings.ClusterSettings;
        // Negative ram (defensive against probe quirks).
         */
        assertEquals(
        long expected = (sixtyFourGB - sixteenGB) * 80 / 100;
    public void testStats() throws Exception {
            mock(FsService.class),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    /**
    @Before
            .put(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), "20s")
            mock(FsService.class),
            );
            response.getPersistentSettings().get(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey())
            "10s",
        );
        long sixteenGB = 16L * 1024 * 1024 * 1024;
        );
 * this file be licensed under the Apache-2.0 license or a
    public void testUpdateSettings() {
            // explicitly to prove it writes to the volatile fields used by the tracker.
import org.junit.Before;
            tracker.close();
        assertEquals("heap > ram → unconfigured", "0b", ResourceTrackerSettings.deriveNativeMemoryLimitDefault(ram, ram + 1));
import org.opensearch.common.settings.Settings;
        assertEquals("heap >= ram → unconfigured", "0b", ResourceTrackerSettings.deriveNativeMemoryLimitDefault(ram, ram));
            response.getPersistentSettings().get(ResourceTrackerSettings.GLOBAL_CPU_USAGE_AC_WINDOW_DURATION_SETTING.getKey())
 * compatible open source license.
import org.junit.After;
        }
        tracker.stop();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            .build();
            "15s",
    public void setup() {
        );
            ResourceTrackerSettings.deriveNativeMemoryLimitDefault(sixtyFourGB, sixteenGB)
            assertEquals(
import org.opensearch.common.unit.TimeValue;
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(jvmsettings).get();
            // cluster's update consumer does not reach it directly. Exercise the setter path
    }
        assertEquals(
    }
        tracker.close();
import static org.hamcrest.Matchers.greaterThan;
            // Update both via cluster settings API and verify they propagate to the holder.
        long sixtyFourGB = 64L * 1024 * 1024 * 1024;
}
                .setTransientSettings(Settings.builder().putNull("*"))
            response.getPersistentSettings().get(ResourceTrackerSettings.GLOBAL_IO_USAGE_AC_WINDOW_DURATION_SETTING.getKey())
                .prepareUpdateSettings()
     * Exercises {@link ResourceTrackerSettings#deriveNativeMemoryLimitDefault(long, long)}
            expected + "b",
 */
     * test machine's RAM/heap configuration. The single-arg overload that reads from
    @After
                .cluster()
        /**
 *
        Settings jvmsettings = Settings.builder()
import java.util.concurrent.TimeUnit;
                .put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_BUFFER_PERCENT_SETTING.getKey(), 25)
            threadPool,
            .build();
        long ram = 8L * 1024 * 1024 * 1024;
 * Tests to assert resource usage trackers retrieving resource utilization averages
            response.getPersistentSettings().get(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey())
     * {@link org.opensearch.monitor.os.OsProbe} delegates to this one.
        assertBusy(() -> assertThat(tracker.getMemoryUtilizationPercent(), greaterThan(0.0)), 5, TimeUnit.SECONDS);
        } finally {
        try {
        Settings unconfiguredAc = Settings.builder().put(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey(), "0b").build();
        Settings settings = Settings.builder()
     */
            .put(ResourceTrackerSettings.GLOBAL_NATIVE_MEMORY_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), "15s")
import org.opensearch.threadpool.TestThreadPool;
            unconfiguredAc,
        // Happy path: 64 GB / 16 GB heap → 80% of (RAM - heap) = 79% of 48 GB.
         * cpu percent used is mostly 0, so skipping assertion for that
            "happy path → 80% of (ram - heap)",
        assertEquals(tracker.getResourceTrackerSettings().getCpuWindowDuration().getSeconds(), 30);
/**
        assertEquals("negative ram → unconfigured", "0b", ResourceTrackerSettings.deriveNativeMemoryLimitDefault(-1, 1L << 30));
                "25",
            // Explicitly unconfigured: limit=0 bytes, buffer=0 percent.
        NodeResourceUsageTracker tracker = new NodeResourceUsageTracker(
        Settings settings = Settings.builder()
            assertEquals("2GB", response.getPersistentSettings().get(ResourceTrackerSettings.NODE_NATIVE_MEMORY_LIMIT_SETTING.getKey()));
 */
        // "limit=0 bytes" baseline this test wants to start from must be set explicitly.
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(ioSettings).get();
import static org.hamcrest.Matchers.equalTo;
        tracker.start();
                .prepareUpdateSettings()
        ClusterUpdateSettingsResponse response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).get();
        );
    }
         * Asserting memory utilization to be greater than 0
            new ClusterSettings(unconfiguredAc, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        threadPool = new TestThreadPool(getClass().getName());
            tracker.getResourceTrackerSettings().setNativeMemoryBufferPercent(25);
        assertEquals(
        response = client().admin().cluster().prepareUpdateSettings().setPersistentSettings(nativeMemorySettings).get();
     * fallback paths so the {@code "0b"} branch is covered without depending on the
        assertEquals(tracker.getResourceTrackerSettings().getNativeMemoryWindowDuration().getSeconds(), 30);
        assertEquals(tracker.getResourceTrackerSettings().getIoWindowDuration().getSeconds(), 120);
            ClusterUpdateSettingsResponse response = client().admin()
    }
            .put(ResourceTrackerSettings.GLOBAL_JVM_USAGE_AC_WINDOW_DURATION_SETTING.getKey(), new TimeValue(500, TimeUnit.MILLISECONDS))
            assertThat(tracker.getResourceTrackerSettings().getNativeMemoryBufferPercent(), equalTo(25));
        Settings nativeMemorySettings = Settings.builder()
        // Default for node.native_memory.limit is now ram - heap (machine-dependent), so the
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            // The holder is owned by the tracker constructed in this test, so the single-node
        ThreadPool.terminate(threadPool, 5, TimeUnit.SECONDS);
            "20s",
            assertThat(tracker.getResourceTrackerSettings().getNativeMemoryLimitBytes(), equalTo(2L * 1024 * 1024 * 1024));
            assertThat(tracker.getResourceTrackerSettings().getNativeMemoryLimitBytes(), equalTo(0L));
                .build();
public class NodeResourceUsageTrackerTests extends OpenSearchSingleNodeTestCase {
    }
        );
                .setPersistentSettings(Settings.builder().putNull("*"))
        );
import static org.mockito.Mockito.mock;
            assertThat(tracker.getResourceTrackerSettings().getNativeMemoryBufferPercent(), equalTo(0));
            Settings updated = Settings.builder()
            mock(FsService.class),
        assertEquals(tracker.getResourceTrackerSettings().getMemoryWindowDuration().getSeconds(), 30);
            threadPool,
    }
        assertEquals("unknown ram → unconfigured", "0b", ResourceTrackerSettings.deriveNativeMemoryLimitDefault(0, 1L << 30));
            "5s",
/*
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
 * SPDX-License-Identifier: Apache-2.0
            .build();
            threadPool,
