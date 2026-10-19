            eq(Tags.EMPTY)
    private MetricsRegistry registry;
        when(registry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), any(Tags.class))).thenAnswer(invocation -> {
    public void testDynamicBufferPoolDiscovery() {
                return mock(Closeable.class);
        JvmStats.MemoryPool firstPool = stats.getMem().iterator().next();  
    public void testConstructorCleansUpOnFailure() {  
        processProbe = ProcessProbe.getInstance();  
        when(
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
        registry = mock(MetricsRegistry.class);
                any(Tags.class)  
            anyString(),
        assertEquals(0.0, systemCpu[0].get(), 0.0);  
        verify(registry).createGauge(
            + 1                                     // uptime
                anyString(),
        verify(registry, atLeastOnce()).createGauge(  
                any(),
            double value = supplier.get();
                anyString(),
            eq(NodeRuntimeMetrics.JVM_MEMORY_USED),
        for (JvmStats.MemoryPool ignored : stats.getMem())
        osProbe = OsProbe.getInstance();
        verify(registry).createGauge(
                eq(NodeRuntimeMetrics.UNIT_BYTES),  
import static org.mockito.ArgumentMatchers.eq;
            anyString(),
            anyString(),
        assertNotNull(systemCpu[0]);
        }  
            + (memoryPools * 3)                     // memory pools (used + limit + used_after_last_gc per pool)  
        );
            anyString(),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            anyString(),
        double value = captured[0].get();  
        double total = 0;
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_UPTIME), anyString(), anyString(), any(Supplier.class), any(Tags.class)))
                eq(expectedTags)
                anyString(),
    public void testRegistersCpuGauges() {  
            eq(NodeRuntimeMetrics.JVM_MEMORY_LIMIT),
            eq(NodeRuntimeMetrics.UNIT_BYTES),  
        for (Closeable handle : createdHandles) {  
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
    }
            eq(Tags.EMPTY)
    @SuppressWarnings("unchecked")
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_CLASS_COUNT), anyString(), anyString(), any(Supplier.class), eq(Tags.EMPTY)))  
                eq(NodeRuntimeMetrics.UNIT_SECONDS),  
    }
                anyString(),
            registry.createGauge(  
        jvmService = new JvmService(Settings.EMPTY);
            );  
                eq(NodeRuntimeMetrics.UNIT_SECONDS),  
            bpSuppliers.add(invocation.getArgument(3));
        List<Supplier<Double>> stateSuppliers = new ArrayList<>();
        JvmStats stats = jvmService.stats();
            return mock(Closeable.class);  
        JvmStats stats = jvmService.stats();
            Tags expectedTags = Tags.of(NodeRuntimeMetrics.TAG_STATE, state.name().toLowerCase(Locale.ROOT));
    public void testCpuUtilizationIsRatio() {  
                eq(NodeRuntimeMetrics.JVM_SYSTEM_CPU_UTILIZATION),
                eq(NodeRuntimeMetrics.JVM_GC_COUNT),
            + (gcCollectors * 2)                    // GC (duration + count per collector)
        assertEquals("Expected 3 per-buffer-pool gauges (used, limit, count)", 3, bpSuppliers.size());
        for (Supplier<Double> supplier : poolSuppliers) {  
        }
    }  
                eq(NodeRuntimeMetrics.JVM_MEMORY_USED),
                eq(NodeRuntimeMetrics.UNIT_BYTES),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
                anyString(),
            Tags expectedTags = Tags.of(NodeRuntimeMetrics.TAG_POOL, bp.getName());
            doThrow(new IOException("test")).when(handle).close();
        });
 * this file be licensed under the Apache-2.0 license or a
        verify(registry).createGauge(  
        }  
                eq(NodeRuntimeMetrics.UNIT_BYTES),
            .thenAnswer(invocation -> {
            any(Supplier.class),  
            .thenAnswer(invocation -> {  
                anyString(),
            .thenAnswer(invocation -> {
        assertNotNull(captured[0]);  
            anyString(),  
            eq(nonHeapTags)
            eq(NodeRuntimeMetrics.UNIT_BYTES),  
            eq(Tags.EMPTY)
            .thenAnswer(invocation -> {
    public void testRegistersMemoryGauges() {
    }
        when(  
        when(negativeCpuProbe.getProcessCpuPercent()).thenReturn((short) -1);  
            return mock(Closeable.class);  
        );
        assertTrue("Expected gauge handles to be created", handleCount > 0);
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            eq(Tags.EMPTY)
        NodeRuntimeMetrics metrics = new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
        );  
            });
    public void testRegistersBufferPoolGauges() {
                eq(NodeRuntimeMetrics.JVM_THREAD_COUNT),
            eq(NodeRuntimeMetrics.JVM_CLASS_UNLOADED),
 * compatible open source license.
        assertTrue("JVM should have at least one buffer pool", bpCount > 0);
            eq(NodeRuntimeMetrics.UNIT_1),
            eq(NodeRuntimeMetrics.JVM_CPU_RECENT_UTILIZATION),
import org.opensearch.telemetry.metrics.tags.Tags;
        metrics.close();
 */  
        NodeRuntimeMetrics metrics = new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
                    stateSuppliers.add(invocation.getArgument(3));  
            eq(heapTags)
    public void testCloseClosesAllHandles() throws Exception {
                any(Supplier.class),
    }  
                eq(NodeRuntimeMetrics.UNIT_1),
            );
            Closeable handle = mock(Closeable.class);
            eq(NodeRuntimeMetrics.UNIT_1),
    public void testGcDurationInSeconds() {  
            any(),
                eq(NodeRuntimeMetrics.JVM_BUFFER_COUNT),
            verify(registry).createGauge(
                return mock(Closeable.class);
        NodeRuntimeMetrics metrics = new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
import org.opensearch.monitor.os.OsProbe;
                eq(NodeRuntimeMetrics.UNIT_1),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
        });
            eq(NodeRuntimeMetrics.JVM_BUFFER_MEMORY_USED),
        int handleCount = createdHandles.size();
    public void testRegistersClassGauges() {
                eq(NodeRuntimeMetrics.JVM_MEMORY_USED_AFTER_LAST_GC),  
    @SuppressWarnings("unchecked")
                any(),  
        final Supplier<Double>[] captured = new Supplier[1];
                eq(NodeRuntimeMetrics.JVM_CPU_RECENT_UTILIZATION),
                eq(NodeRuntimeMetrics.JVM_GC_DURATION),
            );
                return mock(Closeable.class);
        }
            any(),
        for (JvmStats.MemoryPool ignored : stats.getMem())  
    }
    }
        assertTrue("Uptime should be positive", value > 0);
        );
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
        );
                anyString(),
        when(failingRegistry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), any(Tags.class))).thenReturn(  
        });
            verify(registry).createGauge(
                any(Supplier.class),
            any(),
        verify(registry).createGauge(  
            eq(NodeRuntimeMetrics.UNIT_BYTES),
import org.opensearch.monitor.process.ProcessProbe;
    }  
            any(),  
        when(registry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), eq(gcTags))).thenAnswer(invocation -> {
import static org.mockito.ArgumentMatchers.anyString;  
        List<Supplier<Double>> poolSuppliers = new ArrayList<>();  
            assertTrue("GC metric should be >= 0", value >= 0);
            memoryPools++;
    }  
            );
    public void setUp() throws Exception {
import java.util.function.Supplier;  
 * SPDX-License-Identifier: Apache-2.0
            eq(NodeRuntimeMetrics.JVM_THREAD_COUNT),  
                any(),
            )
            any(),
                eq(NodeRuntimeMetrics.UNIT_BYTES),  
        );  
    }
                anyString(),
import static org.mockito.ArgumentMatchers.any;
                Tags tags = invocation.getArgument(4);
        ).thenAnswer(invocation -> {
            Tags expectedTags = Tags.of(NodeRuntimeMetrics.TAG_GC, gc.getName());
            + (bufferPools * 3)                     // buffer pools (used + limit + count per pool)
            verify(registry).createGauge(  
        assertTrue("CPU utilization should be <= 1.0", value <= 1.0);
    }
                eq(NodeRuntimeMetrics.JVM_MEMORY_LIMIT),
                eq(NodeRuntimeMetrics.UNIT_BYTES),
    }
    public void testCloseIdempotent() throws Exception {
        ProcessProbe negativeCpuProbe = mock(ProcessProbe.class);
        final Supplier<Double>[] captured = new Supplier[1];
    @SuppressWarnings("unchecked")  
            eq(NodeRuntimeMetrics.UNIT_1),
import static org.mockito.Mockito.doThrow;  
            );
                any(Tags.class)  
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
        final Supplier<Double>[] systemCpu = new Supplier[1];
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
    public void testUptimeGaugeSupplierReturnsValidValue() {
            any(),
        assertTrue("JVM should have at least one memory pool", poolCount > 0);
    @SuppressWarnings("unchecked")  
            });  
    private OsProbe osProbe;
    public void testThreadStateGaugesReturnNonNegative() {  
            anyString(),
    }  
        when(  
            return handle;
            any(),  
import java.util.List;
                eq(expectedTags)  
        verify(registry).createGauge(  
        verify(registry).createGauge(
import java.io.Closeable;
        verify(registry, org.mockito.Mockito.times(expected)).createGauge(
        JvmStats stats = jvmService.stats();
        double value = captured[0].get();  
            eq(NodeRuntimeMetrics.JVM_CLASS_LOADED),  
        });
            });
    @SuppressWarnings("unchecked")  
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_THREAD_COUNT), anyString(), anyString(), any(Supplier.class), any(Tags.class)))
package org.opensearch.monitor;
                any(),
        verify(registry).createGauge(
        ).thenAnswer(invocation -> {
            verify(registry).createGauge(  
        List<Supplier<Double>> classSuppliers = new ArrayList<>();
        verify(registry).createGauge(  
        for (Supplier<Double> supplier : classSuppliers) {
        );
                eq(expectedTags)  
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_CLASS_LOADED), anyString(), anyString(), any(Supplier.class), eq(Tags.EMPTY)))
        metrics.close();
        assertEquals(0.0, processCpu[0].get(), 0.0);
        });
        }  
        Tags heapTags = Tags.of(NodeRuntimeMetrics.TAG_TYPE, "heap");
            eq(NodeRuntimeMetrics.JVM_MEMORY_COMMITTED),
                any(),
    public void testCloseHandlesErrors() throws Exception {
        ).thenAnswer(invocation -> {
            + 1 + Thread.State.values().length      // threads (total + per-state)  
            assertTrue("Buffer pool metric should be >= 0", value >= 0);
            eq(Tags.EMPTY)  
import org.opensearch.test.OpenSearchTestCase;
        double value = captured[0].get();
            });
        verify(registry).createGauge(
            eq(NodeRuntimeMetrics.JVM_MEMORY_USED),  
            anyString(),  
            anyString(),  
            poolSuppliers.add(invocation.getArgument(3));
                any(),
            registry.createGauge(
                any(),
            )
    public void testHeapMemoryGaugeSupplierReturnsValidValue() {  
            registry.createGauge(
                anyString(),  
                any(Tags.class)
    }  
            double value = supplier.get();
                eq(expectedTags)
        for (Thread.State state : Thread.State.values()) {
            anyString(),  
            Tags expectedTags = Tags.of(NodeRuntimeMetrics.TAG_POOL, pool.getName());
        final Supplier<Double>[] processCpu = new Supplier[1];
            verify(handle).close();
            return mock(Closeable.class);  
            double value = supplier.get();
        }
            eq(NodeRuntimeMetrics.UNIT_BYTES),
            poolCount++;  
            anyString(),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
        List<Supplier<Double>> gcSuppliers = new ArrayList<>();  
            eq(NodeRuntimeMetrics.UNIT_BYTES),
            double value = captured[0].get();  
        for (JvmStats.GarbageCollector gc : stats.getGc()) {
        int gcCollectors = stats.getGc().getCollectors().length;
import org.opensearch.common.settings.Settings;
                return mock(Closeable.class);  
        for (Closeable handle : createdHandles) {
        JvmStats stats = jvmService.stats();  
        when(
        metrics.close();
        JvmStats stats = jvmService.stats();
            anyString(),
        int memoryPools = 0;
            return mock(Closeable.class);  
            );  
                eq(expectedTags)
                }
import org.opensearch.telemetry.metrics.MetricsRegistry;  
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
    }
        verify(registry).createGauge(
            return mock(Closeable.class);  
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
                anyString(),  
    }
        );
        JvmStats.GarbageCollector firstGc = stats.getGc().getCollectors()[0];  
            eq(NodeRuntimeMetrics.JVM_MEMORY_COMMITTED),
    }
            eq(NodeRuntimeMetrics.JVM_UPTIME),
            any(),  
                anyString(),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
        int bufferPools = stats.getBufferPools().size();  
        assertTrue("CPU utilization should be >= 0", value >= 0);
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
    private JvmService jvmService;
                classSuppliers.add(invocation.getArgument(3));
        ).thenAnswer(invocation -> {
                eq(NodeRuntimeMetrics.JVM_BUFFER_MEMORY_USED),  
    }  
import static org.mockito.Mockito.mock;
}  
        metrics.close();
            eq(NodeRuntimeMetrics.UNIT_SECONDS),  
            anyString(),  
    @SuppressWarnings("unchecked")
            eq(Tags.EMPTY)
            eq(heapTags)
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_CLASS_UNLOADED), anyString(), anyString(), any(Supplier.class), eq(Tags.EMPTY)))
        );  
            eq(NodeRuntimeMetrics.UNIT_1),
        verify(registry, atLeastOnce()).createGauge(  
            captured[0] = invocation.getArgument(3);
        assertTrue("Heap used should be positive", value > 0);
    }  
                any(Supplier.class),
    public void testRegistersMemoryPoolGauges() {  
                eq(expectedTags)  
        int poolCount = 0;
            eq(heapTags)  
        assertEquals("Expected 2 per-collector gauges (duration, count)", 2, gcSuppliers.size());
            );
            );  
    public void testCpuGuardAgainstNegativeValues() {
            successHandle
        JvmStats.BufferPool firstBp = stats.getBufferPools().get(0);  
            anyString(),
            return mock(Closeable.class);
            .thenAnswer(invocation -> {
        ).thenReturn(successHandle).thenThrow(new RuntimeException("registration failure"));
    public void testBufferPoolSupplierReturnsValidValues() {
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
        for (Supplier<Double> supplier : bpSuppliers) {  
        assertNotNull(processCpu[0]);  
import java.io.IOException;
                eq(NodeRuntimeMetrics.JVM_BUFFER_MEMORY_LIMIT),
    public void testRegistersUptimeGauge() {  
        }  
    public void testMemoryPoolSupplierReturnsValidValues() {
        assertNotNull(captured[0]);
        new NodeRuntimeMetrics(registry, jvmService, negativeCpuProbe, negativeOsProbe);
    }
        }
 *
    public void testTotalGaugeCount() {
                eq(expectedTags)
        JvmStats stats = jvmService.stats();
        createdHandles = new ArrayList<>();
            total += count;  
                anyString(),  
            )  
            any(Tags.class)
            any(),
 * The OpenSearch Contributors require contributions made to  
            anyString(),
    @SuppressWarnings("unchecked")
            double value = supplier.get();
            .thenAnswer(invocation -> {  
            systemCpu[0] = invocation.getArgument(3);  
        List<Supplier<Double>> bpSuppliers = new ArrayList<>();  
                anyString(),
            processCpu[0] = invocation.getArgument(3);  
            any(Tags.class)
        MetricsRegistry failingRegistry = mock(MetricsRegistry.class);
                classSuppliers.add(invocation.getArgument(3));  
            assertTrue("Class loading metric should be >= 0", value >= 0);  
    @SuppressWarnings("unchecked")
        when(registry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), eq(bpTags))).thenAnswer(invocation -> {
        int bpCount = stats.getBufferPools().size();  
            any(),
        );  
    }  
            eq(nonHeapTags)
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
                return mock(Closeable.class);
                classSuppliers.add(invocation.getArgument(3));
            assertTrue("GC duration should be >= 0", value >= 0);
        for (Supplier<Double> supplier : gcSuppliers) {  
import static org.mockito.Mockito.verify;
        });
            any(),
        Tags bpTags = Tags.of(NodeRuntimeMetrics.TAG_POOL, firstBp.getName());
    }
            eq(NodeRuntimeMetrics.JVM_MEMORY_USED),  
        );  
        if (captured[0] != null) {
            any(),  
        assertTrue("Total thread state count should be positive", total > 0);
        super.setUp();  
            assertTrue("Pool metric should be >= 0", value >= 0);
        assertEquals("Expected 3 per-pool gauges (used, limit, used_after_last_gc)", 3, poolSuppliers.size());
        verify(registry).createGauge(  
        }  
                eq(NodeRuntimeMetrics.JVM_CPU_RECENT_UTILIZATION),
            anyString(),  
    }  
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
            eq(NodeRuntimeMetrics.UNIT_1),  
import static org.mockito.Mockito.when;  
/*  
        Tags gcTags = Tags.of(NodeRuntimeMetrics.TAG_GC, firstGc.getName());
            anyString(),
    public void testRegistersThreadGauges() {
    }
        );  
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
            verify(registry).createGauge(
    public void testRegistersGcGauges() {  
        when(negativeOsProbe.getSystemCpuPercent()).thenReturn((short) -1);
                if (!Tags.EMPTY.equals(tags)) {
            registry.createGauge(  
        when(registry.createGauge(anyString(), anyString(), anyString(), any(Supplier.class), eq(poolTags))).thenAnswer(invocation -> {
        JvmStats stats = jvmService.stats();  
                return mock(Closeable.class);  
    public void testDynamicPoolDiscovery() {
            });
            verify(registry).createGauge(
        Tags poolTags = Tags.of(NodeRuntimeMetrics.TAG_POOL, firstPool.getName());
    }  
    @SuppressWarnings("unchecked")  
            eq(Tags.EMPTY)  
import org.opensearch.monitor.jvm.JvmService;
public class NodeRuntimeMetricsTests extends OpenSearchTestCase {
            any(),
import java.util.ArrayList;  
                captured[0] = invocation.getArgument(3);
import org.opensearch.monitor.jvm.JvmStats;  
            eq(NodeRuntimeMetrics.JVM_SYSTEM_CPU_UTILIZATION),
        final Supplier<Double>[] captured = new Supplier[1];  
                any(),  
            verify(registry).createGauge(  
        );
    @SuppressWarnings("unchecked")  
        JvmStats stats = jvmService.stats();  
        final Supplier<Double>[] captured = new Supplier[1];
                eq(expectedTags)
        for (JvmStats.BufferPool bp : stats.getBufferPools()) {  
        }
                anyString(),  
                captured[0] = invocation.getArgument(3);  
            anyString(),
                eq(NodeRuntimeMetrics.UNIT_1),  
            return mock(Closeable.class);
        for (JvmStats.MemoryPool pool : stats.getMem()) {
        assertNotNull(captured[0]);
        int expected = 5                            // memory aggregates (3 heap + 2 non-heap)
            any(),
            });  
    }
            verify(registry).createGauge(  
    public void testGcSupplierReturnsValidValues() {
        );
            any(Tags.class)
                eq(NodeRuntimeMetrics.JVM_GC_DURATION),
            anyString(),
        verify(registry).createGauge(
                any(Supplier.class),
            captured[0] = invocation.getArgument(3);
            assertTrue("Thread state count should be >= 0", count >= 0);
        assertEquals("Expected 3 class loading gauges", 3, classSuppliers.size());  
        );  
        for (Supplier<Double> supplier : stateSuppliers) {  
                anyString(),  
                anyString(),  
        });
    private ProcessProbe processProbe;  
            + 2;                                    // CPU  
        assertEquals(Thread.State.values().length, stateSuppliers.size());
            verify(registry).createGauge(
        when(registry.createGauge(eq(NodeRuntimeMetrics.JVM_MEMORY_USED), anyString(), anyString(), any(Supplier.class), eq(heapTags)))  
        Tags heapTags = Tags.of(NodeRuntimeMetrics.TAG_TYPE, "heap");
        Tags nonHeapTags = Tags.of(NodeRuntimeMetrics.TAG_TYPE, "non_heap");  
            )  
            + 3                                     // classes
        expectThrows(RuntimeException.class, () -> new NodeRuntimeMetrics(failingRegistry, jvmService, processProbe, osProbe));
import static org.mockito.Mockito.atLeastOnce;
        }
            gcSuppliers.add(invocation.getArgument(3));
import java.util.Locale;
                any(Tags.class)
        Closeable successHandle = mock(Closeable.class);
    @Override
        }
        });
            );  
            double count = supplier.get();
            eq(NodeRuntimeMetrics.UNIT_1),  
            createdHandles.add(handle);  
    public void testClassLoadingSupplierReturnsValidValues() {
    private List<Closeable> createdHandles;
            eq(NodeRuntimeMetrics.JVM_CLASS_COUNT),
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);  
                any(),
        OsProbe negativeOsProbe = mock(OsProbe.class);
        JvmStats stats = jvmService.stats();
                eq(expectedTags)
        new NodeRuntimeMetrics(registry, jvmService, processProbe, osProbe);
