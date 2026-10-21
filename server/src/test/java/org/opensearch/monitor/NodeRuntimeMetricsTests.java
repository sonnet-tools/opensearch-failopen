        });
        when(failingRegistry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), any(Tags.class))).thenReturn(
        if (captured[0] != null) {
            return mock(Closeable.class);
                any(),
    }
    public void testGcSupplierReturnsValidValues() {
        }
    @SuppressWarnings("unchecked")
        int memoryPools = 0;
            Closeable handle = mock(Closeable.class);
package org.opensearch.monitor;
            gcSuppliers.add(invocation.getArgument(3));
                classSuppliers.add(invocation.getArgument(3));
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
                eq(expectedTags)
            anyString(),
        }
            );
                any(),
    }
        assertTrue("Uptime should be positive", value > 0);
            any(),
                Tags tags = invocation.getArgument(4);
        Closeable successHandle = mock(Closeable.class);
                anyString(),
                any(),
        assertEquals(Thread.State.values().length, stateSuppliers.size());
        Tags heapTags = Tags.of(NodeRuntimeMetrics.TAG_TYPE, "heap");
    private OsProbe osProbe;
    @SuppressWarnings("unchecked")
        JvmStats stats = jvmService.stats();
        double value = captured[0].get();
        List<Supplier<Double>> poolSuppliers = new ArrayList<>();
        });
                if (!Tags.EMPTY.equals(tags)) {
        Tags bpTags = Tags.of(NodeRuntimeMetrics.TAG_POOL, firstBp.getName());
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_UPTIME), anyString(), anyString(), any(Supplier.class), any(Tags.class)))
            )
                eq(NodeRuntimeMetrics.JVM_CPU_RECENT_UTILIZATION),
        List<Supplier<Double>> bpSuppliers = new ArrayList<>();
                anyString(),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
                anyString(),
        assertTrue("CPU utilization should be <= 1.0", value <= 1.0);
        assertEquals(0.0, systemCpu[0].get(), 0.0);
    @SuppressWarnings("unchecked")
    public void testHeapMemoryGaugeSupplierReturnsValidValue() {
            Tags expectedTags = Tags.of(NodeRuntimeMetrics.TAG_POOL, pool.getName());
import org.opensearch.telemetry.metrics.tags.Tags;
                eq(NodeRuntimeMetrics.UNIT_SECONDS),
            return mock(Closeable.class);
        metrics.close();
        assertNotNull(captured[0]);
    public void testTotalGaugeCount() {
    @SuppressWarnings("unchecked")
            any(),
import org.opensearch.monitor.jvm.JvmStats;
            eq(NodeRuntimeMetrics.JVM_CLASS_COUNT),
    @SuppressWarnings("unchecked")
            poolCount++;
                eq(NodeRuntimeMetrics.JVM_MEMORY_USED_AFTER_LAST_GC),
            anyString(),
    public void testDynamicPoolDiscovery() {
    @Override
    public void testCloseHandlesErrors() throws Exception {
        );
        assertEquals("Expected 3 per-pool gauges (used, limit, used_after_last_gc)", 3, poolSuppliers.size());
    public void testConstructorCleansUpOnFailure() {
            assertTrue("Pool metric should be >= 0", value >= 0);
            systemCpu[0] = invocation.getArgument(3);
        when(
                eq(NodeRuntimeMetrics.JVM_GC_DURATION),
        createdHandles = new ArrayList<>();
                anyString(),
            assertTrue("Buffer pool metric should be >= 0", value >= 0);
import java.util.function.Supplier;
            .thenAnswer(invocation -> {
            eq(NodeRuntimeMetrics.JVM_CPU_RECENT_UTILIZATION),
 * SPDX-License-Identifier: Apache-2.0
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
 * The OpenSearch Contributors require contributions made to
            doThrow(new IOException("test")).when(handle).close();
            });
            any(),
    public void testCpuUtilizationIsRatio() {
            eq(Tags.EMPTY)
        verify(registry).createGauge(
                eq(expectedTags)
            eq(NodeRuntimeMetrics.UNIT_BYTES),
            any(Tags.class)
        List<Supplier<Double>> stateSuppliers = new ArrayList<>();
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            any(),
            registry.createGauge(
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
        assertNotNull(systemCpu[0]);
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            any(),
        int handleCount = createdHandles.size();
    }
            eq(NodeRuntimeMetrics.UNIT_SECONDS),
            );
            eq(NodeRuntimeMetrics.UNIT_1),
            .thenAnswer(invocation -> {
import static org.mockito.Mockito.doThrow;
                return mock(Closeable.class);
import static org.mockito.Mockito.atLeastOnce;
        int gcCollectors = stats.getGc().getCollectors().length;
            eq(Tags.EMPTY)
        for (JvmStats.GarbageCollector gc : stats.getGc()) {
                eq(expectedTags)
            anyString(),
        assertEquals(0.0, processCpu[0].get(), 0.0);
                eq(NodeRuntimeMetrics.UNIT_BYTES),
            anyString(),
            anyString(),
            captured[0] = invocation.getArgument(3);
            assertTrue("Thread state count should be >= 0", count >= 0);
            return handle;
        );
        assertEquals("Expected 3 per-buffer-pool gauges (used, limit, count)", 3, bpSuppliers.size());
                anyString(),
            eq(Tags.EMPTY)
        }
                captured[0] = invocation.getArgument(3);
            eq(heapTags)
        JvmStats stats = jvmService.stats();
                anyString(),
                return mock(Closeable.class);
        metrics.close();
            eq(NodeRuntimeMetrics.JVM_UPTIME),
        metrics.close();
            assertTrue("Class loading metric should be >= 0", value >= 0);
            double value = supplier.get();
            anyString(),
        );
        double total = 0;
                any(Supplier.class),
    public void testRegistersMemoryPoolGauges() {
                return mock(Closeable.class);
import java.util.List;
        assertTrue("CPU utilization should be >= 0", value >= 0);
    }
            verify(registry).createGauge(
                eq(NodeRuntimeMetrics.UNIT_BYTES),
            eq(NodeRuntimeMetrics.UNIT_BYTES),
        });
            eq(NodeRuntimeMetrics.UNIT_1),
import static org.mockito.Mockito.mock;
                eq(expectedTags)
                anyString(),
        JvmStats stats = jvmService.stats();
            verify(registry).createGauge(
            )
            any(),
                anyString(),
            eq(NodeRuntimeMetrics.UNIT_BYTES),
public class NodeRuntimeMetricsTests extends OpenSearchTestCase {
            });
            verify(registry).createGauge(
            any(),
            );
            any(),
        for (Closeable handle : createdHandles) {
                }
        assertNotNull(captured[0]);
        verify(registry).createGauge(
        for (Supplier<Double> supplier : classSuppliers) {
                anyString(),
        for (Supplier<Double> supplier : stateSuppliers) {
        verify(registry).createGauge(
    }
            Tags expectedTags = Tags.of(NodeRuntimeMetrics.TAG_POOL, bp.getName());
            any(),
    @SuppressWarnings("unchecked")
    }
        final Supplier<Double>[] captured = new Supplier[1];
            registry.createGauge(
        for (JvmStats.MemoryPool pool : stats.getMem()) {
        verify(registry).createGauge(
        MetricsRegistry failingRegistry = mock(MetricsRegistry.class);
        assertNotNull(captured[0]);
            + (bufferPools * 3)                     // buffer pools (used + limit + count per pool)
import java.util.Locale;
        }
            eq(NodeRuntimeMetrics.JVM_CLASS_LOADED),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
        assertEquals("Expected 3 class loading gauges", 3, classSuppliers.size());
            any(Tags.class)
        when(registry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), eq(poolTags))).thenAnswer(invocation -> {
        verify(registry).createGauge(
            successHandle
import static org.mockito.ArgumentMatchers.anyString;
import java.io.Closeable;
    }
        });
import java.io.IOException;
        Tags nonHeapTags = Tags.of(NodeRuntimeMetrics.TAG_TYPE, "non_heap");
import org.opensearch.common.settings.Settings;
        when(registry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), eq(bpTags))).thenAnswer(invocation -> {
            eq(NodeRuntimeMetrics.JVM_CLASS_UNLOADED),
        );
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
    private MetricsRegistry registry;
            verify(registry).createGauge(
    }
            eq(NodeRuntimeMetrics.UNIT_1),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
    public void testRegistersMemoryGauges() {
        });
            .thenAnswer(invocation -> {
            any(),
            );
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_THREAD_COUNT), anyString(), anyString(), any(Supplier.class), any(Tags.class)))
        for (JvmStats.MemoryPool ignored : stats.getMem())
    }
            )
    @SuppressWarnings("unchecked")
                eq(NodeRuntimeMetrics.JVM_THREAD_COUNT),
                classSuppliers.add(invocation.getArgument(3));
        }
            eq(Tags.EMPTY)
            eq(NodeRuntimeMetrics.JVM_MEMORY_COMMITTED),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
                eq(NodeRuntimeMetrics.JVM_BUFFER_MEMORY_USED),
            + 1 + Thread.State.values().length      // threads (total + per-state)
            + 1                                     // uptime
        for (JvmStats.BufferPool bp : stats.getBufferPools()) {
        JvmStats stats = jvmService.stats();
            anyString(),
}
            anyString(),
                anyString(),
        ).thenReturn(successHandle).thenThrow(new RuntimeException("registration failure"));
        }
            double value = supplier.get();
            anyString(),
        when(
            any(),
            );
                eq(NodeRuntimeMetrics.JVM_GC_DURATION),
        final Supplier<Double>[] captured = new Supplier[1];
                eq(NodeRuntimeMetrics.UNIT_SECONDS),
        JvmStats stats = jvmService.stats();
        JvmStats stats = jvmService.stats();
    public void testRegistersCpuGauges() {
            eq(Tags.EMPTY)
                anyString(),
                eq(NodeRuntimeMetrics.UNIT_1),
            .thenAnswer(invocation -> {
import static org.mockito.Mockito.verify;
        metrics.close();
        new NodeRuntimeMetrics(registry, jvmService, negativeCpuProbe, negativeOsProbe);
    private List<Closeable> createdHandles;
            return mock(Closeable.class);
            total += count;
    }
            any(),
    }
            memoryPools++;
                eq(NodeRuntimeMetrics.JVM_MEMORY_USED),
        osProbe = OsProbe.getInstance();
        expectThrows(RuntimeException.class, () -> new NodeRuntimeMetrics(failingRegistry, jvmService, processProbe, osProbe));
import org.opensearch.test.OpenSearchTestCase;
        ProcessProbe negativeCpuProbe = mock(ProcessProbe.class);
        for (Thread.State state : Thread.State.values()) {
    }
                eq(NodeRuntimeMetrics.JVM_CPU_RECENT_UTILIZATION),
    public void testRegistersBufferPoolGauges() {
        );
                any(Tags.class)
        ).thenAnswer(invocation -> {
            return mock(Closeable.class);
            });
            eq(NodeRuntimeMetrics.JVM_BUFFER_MEMORY_USED),
        ).thenAnswer(invocation -> {
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            verify(registry).createGauge(
    }
        NodeRuntimeMetrics metrics = new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
        verify(registry).createGauge(
        Tags heapTags = Tags.of(NodeRuntimeMetrics.TAG_TYPE, "heap");
        }
                    stateSuppliers.add(invocation.getArgument(3));
            });
        }
 * compatible open source license.
import org.opensearch.monitor.jvm.JvmService;
            + 3                                     // classes
        Tags gcTags = Tags.of(NodeRuntimeMetrics.TAG_GC, firstGc.getName());
        final Supplier<Double>[] captured = new Supplier[1];
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            });
        int poolCount = 0;
        when(negativeOsProbe.getSystemCpuPercent()).thenReturn((short) -1);
        int expected = 5                            // memory aggregates (3 heap + 2 non-heap)
                return mock(Closeable.class);
        int bufferPools = stats.getBufferPools().size();
    public void testThreadStateGaugesReturnNonNegative() {
            registry.createGauge(
            eq(heapTags)
                eq(NodeRuntimeMetrics.UNIT_BYTES),
            eq(Tags.EMPTY)
            anyString(),
import org.opensearch.monitor.os.OsProbe;
                anyString(),
        verify(registry).createGauge(
        );
            eq(NodeRuntimeMetrics.UNIT_BYTES),
        double value = captured[0].get();
                any(),
            any(Tags.class)
            );
    }
                eq(expectedTags)
            );
            registry.createGauge(
    private JvmService jvmService;
                eq(NodeRuntimeMetrics.JVM_BUFFER_COUNT),
        int bpCount = stats.getBufferPools().size();
        }
            double value = supplier.get();
                eq(expectedTags)
            anyString(),
        JvmStats.MemoryPool firstPool = stats.getMem().iterator().next();
import org.opensearch.monitor.process.ProcessProbe;
            Tags expectedTags = Tags.of(NodeRuntimeMetrics.TAG_STATE, state.name().toLowerCase(Locale.ROOT));
            any(),
            double value = captured[0].get();
            anyString(),
        ).thenAnswer(invocation -> {
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
    @SuppressWarnings("unchecked")
        jvmService = new JvmService(Settings.EMPTY);
    }
                eq(NodeRuntimeMetrics.JVM_MEMORY_LIMIT),
        for (JvmStats.MemoryPool ignored : stats.getMem())
            any(),
            anyString(),
            + 2;                                    // CPU
        final Supplier<Double>[] systemCpu = new Supplier[1];
            + (memoryPools * 3)                     // memory pools (used + limit + used_after_last_gc per pool)
        final Supplier<Double>[] processCpu = new Supplier[1];
 * this file be licensed under the Apache-2.0 license or a
        super.setUp();
        Tags poolTags = Tags.of(NodeRuntimeMetrics.TAG_POOL, firstPool.getName());
        verify(registry).createGauge(
            eq(Tags.EMPTY)
            verify(registry).createGauge(
            eq(heapTags)
            eq(NodeRuntimeMetrics.UNIT_1),
            anyString(),
        JvmStats.BufferPool firstBp = stats.getBufferPools().get(0);
            captured[0] = invocation.getArgument(3);
        assertEquals("Expected 2 per-collector gauges (duration, count)", 2, gcSuppliers.size());
            assertTrue("GC duration should be >= 0", value >= 0);
        assertTrue("JVM should have at least one memory pool", poolCount > 0);
                eq(NodeRuntimeMetrics.JVM_SYSTEM_CPU_UTILIZATION),
                eq(NodeRuntimeMetrics.UNIT_1),
            verify(handle).close();
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            anyString(),
            eq(NodeRuntimeMetrics.JVM_MEMORY_USED),
            eq(NodeRuntimeMetrics.JVM_SYSTEM_CPU_UTILIZATION),
        for (Closeable handle : createdHandles) {
                anyString(),
            bpSuppliers.add(invocation.getArgument(3));
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
        });
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
    }
                return mock(Closeable.class);
        );
    }
        OsProbe negativeOsProbe = mock(OsProbe.class);
    }
        verify(registry).createGauge(
        }
            .thenAnswer(invocation -> {
    public void testRegistersGcGauges() {
        verify(registry).createGauge(
        );
                any(Tags.class)
            anyString(),
                eq(NodeRuntimeMetrics.JVM_GC_COUNT),
        NodeRuntimeMetrics metrics = new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
    }
        JvmStats stats = jvmService.stats();
                any(Tags.class)
            return mock(Closeable.class);
            anyString(),
            verify(registry).createGauge(
import java.util.ArrayList;
        registry = mock(MetricsRegistry.class);
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_MEMORY_USED), anyString(), anyString(), any(Supplier.class), eq(heapTags)))
    public void testRegistersUptimeGauge() {
            });
        );
            poolSuppliers.add(invocation.getArgument(3));
                eq(expectedTags)
            anyString(),
    }
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            verify(registry).createGauge(
        verify(registry, org.mockito.Mockito.times(expected)).createGauge(
    public void testMemoryPoolSupplierReturnsValidValues() {
        NodeRuntimeMetrics metrics = new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
                eq(NodeRuntimeMetrics.UNIT_1),
    @SuppressWarnings("unchecked")
            return mock(Closeable.class);
import static org.mockito.Mockito.when;
        for (Supplier<Double> supplier : poolSuppliers) {
        when(registry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), any(Tags.class))).thenAnswer(invocation -> {
    public void testBufferPoolSupplierReturnsValidValues() {
            .thenAnswer(invocation -> {
        });
        JvmStats stats = jvmService.stats();
    public void testCloseIdempotent() throws Exception {
    }
        assertTrue("Heap used should be positive", value > 0);
        assertTrue("Total thread state count should be positive", total > 0);
        List<Supplier<Double>> classSuppliers = new ArrayList<>();
    }
            eq(NodeRuntimeMetrics.UNIT_1),
            any(Supplier.class),
    public void testRegistersClassGauges() {
        processProbe = ProcessProbe.getInstance();
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_CLASS_UNLOADED), anyString(), anyString(), any(Supplier.class), eq(Tags.EMPTY)))
        JvmStats.GarbageCollector firstGc = stats.getGc().getCollectors()[0];
        assertNotNull(processCpu[0]);
        });
                any(Supplier.class),
    public void testDynamicBufferPoolDiscovery() {
        List<Supplier<Double>> gcSuppliers = new ArrayList<>();
    public void testClassLoadingSupplierReturnsValidValues() {
            );
                eq(NodeRuntimeMetrics.JVM_BUFFER_MEMORY_LIMIT),
    @SuppressWarnings("unchecked")
            );
        }
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            eq(NodeRuntimeMetrics.UNIT_BYTES),
                any(),
        );
        verify(registry, atLeastOnce()).createGauge(
        when(registry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), eq(gcTags))).thenAnswer(invocation -> {
        for (Supplier<Double> supplier : gcSuppliers) {
            )
import org.opensearch.telemetry.metrics.MetricsRegistry;
                return mock(Closeable.class);
            double count = supplier.get();
import static org.mockito.ArgumentMatchers.eq;
    }
    public void testRegistersThreadGauges() {
        double value = captured[0].get();
    }
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_CLASS_LOADED), anyString(), anyString(), any(Supplier.class), eq(Tags.EMPTY)))
                any(Supplier.class),
        assertTrue("Expected gauge handles to be created", handleCount > 0);
import static org.mockito.ArgumentMatchers.any;
        final Supplier<Double>[] captured = new Supplier[1];
        JvmStats stats = jvmService.stats();
                any(),
            createdHandles.add(handle);
                any(),
            + (gcCollectors * 2)                    // GC (duration + count per collector)
            eq(NodeRuntimeMetrics.JVM_MEMORY_COMMITTED),
                anyString(),
                eq(expectedTags)
        );
            eq(NodeRuntimeMetrics.JVM_MEMORY_USED),
        }
            eq(NodeRuntimeMetrics.UNIT_1),
            processCpu[0] = invocation.getArgument(3);
            anyString(),
/*
            return mock(Closeable.class);
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_CLASS_COUNT), anyString(), anyString(), any(Supplier.class), eq(Tags.EMPTY)))
                eq(NodeRuntimeMetrics.UNIT_BYTES),
        ).thenAnswer(invocation -> {
        );
                any(),
    public void testCpuGuardAgainstNegativeValues() {
                eq(NodeRuntimeMetrics.UNIT_BYTES),
                eq(expectedTags)
            eq(nonHeapTags)
        when(negativeCpuProbe.getProcessCpuPercent()).thenReturn((short) -1);
            eq(NodeRuntimeMetrics.JVM_THREAD_COUNT),
 *
    public void testCloseClosesAllHandles() throws Exception {
        when(
                captured[0] = invocation.getArgument(3);
        when(
            assertTrue("GC metric should be >= 0", value >= 0);
    }
            Tags expectedTags = Tags.of(NodeRuntimeMetrics.TAG_GC, gc.getName());
                anyString(),
                any(Tags.class)
        verify(registry, atLeastOnce()).createGauge(
        for (Supplier<Double> supplier : bpSuppliers) {
        );
            double value = supplier.get();
        );
    public void setUp() throws Exception {
            eq(nonHeapTags)
            eq(NodeRuntimeMetrics.JVM_MEMORY_USED),
    public void testGcDurationInSeconds() {
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            verify(registry).createGauge(
        verify(registry).createGauge(
 */
        assertTrue("JVM should have at least one buffer pool", bpCount > 0);
                classSuppliers.add(invocation.getArgument(3));
    }
            eq(NodeRuntimeMetrics.JVM_MEMORY_LIMIT),
                anyString(),
                any(),
    private ProcessProbe processProbe;
        verify(registry).createGauge(
    public void testUptimeGaugeSupplierReturnsValidValue() {
        );
                any(Supplier.class),
