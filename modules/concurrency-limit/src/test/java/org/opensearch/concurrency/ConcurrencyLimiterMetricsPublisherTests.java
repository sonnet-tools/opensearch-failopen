        assertEquals("only the latest generation of 5 gauges should be open", 5, mr.openCount());
        assertEquals(5.0, mr.byName(ConcurrencyLimiterMetricsPublisher.RTT_NOLOAD).supplier.get(), 0.0);
    }
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.CURRENT_LIMIT));
    public void testGaugeValuesTrackLiveSnapshot() {
        assertEquals(5, mr.openCount());  
        }  
import java.util.concurrent.atomic.AtomicInteger;
}  
 * SPDX-License-Identifier: Apache-2.0
    }
        long rejected,
        assertEquals(1, pub.registeredAliasCount());
            "act",  
        }
        assertEquals(5, mr.openCount());
        long lastRtt,  
                this.name = name;
        assertEquals("monitor_only", mr.byName(ConcurrencyLimiterMetricsPublisher.CURRENT_LIMIT).tags.getTagsMap().get("mode"));
        }  
            final Tags tags;  
        }  
        assertEquals(0, pub.registeredAliasCount());  
        assertEquals(3.0, inFlightGauge.get(), 0.0);  
        assertEquals("aimd", tags.getTagsMap().get("algorithm"));
            return gauges.stream().filter(g -> g.name.equals(name) && !g.closed).findFirst().orElse(null);
            throw new UnsupportedOperationException("not used");
import java.util.function.Supplier;
        assertEquals("gauge must re-sample live snapshot", 9.0, inFlightGauge.get(), 0.0);
        @Override
/*  
import org.opensearch.test.OpenSearchTestCase;
        GaugeReg byName(String name) {
        return () -> new ActionLimiterSnapshot(alias, action, mode, algo, limit, inFlight, rejected, lastRtt, noLoad);  
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);  
        assertEquals("first generation must have been closed", 10, mr.gauges.size());  
            7,
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
import java.util.List;  
        @Override
    public void testGaugeTagsFromSnapshot() {  
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
            5
            boolean closed = false;
        assertEquals("all gauges for the alias must be closed", 0, mr.openCount());
            return gauges.stream().filter(g -> !g.closed).count();  
        pub.onActive("a", snap("a", "act", "enforced", "vegas", 10, 0, 0, -1, -1));
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
            GaugeReg reg = new GaugeReg(name, unit, valueProvider, tags);  
        AtomicInteger inFlight = new AtomicInteger(3);  
            throw new UnsupportedOperationException("not used");
import org.opensearch.telemetry.metrics.Counter;
        int inFlight,
        assertEquals(1, pub.registeredAliasCount());
    public void testMultipleAliasesIndependent() {
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
                this.tags = tags;
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
        inFlight.set(9);
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
        public Histogram createHistogram(String name, String description, String unit) {  
        // With the node's no-op registry (telemetry disabled), nothing should throw.
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
import java.io.Closeable;
 *
            final String unit;
import org.opensearch.telemetry.metrics.tags.Tags;
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(NoopMetricsRegistry.INSTANCE);
        @Override
        pub.onActive("agger", snap("agger", "act2", "enforced", "vegas", 20, 0, 0, -1, -1));  
        assertEquals(42.0, mr.byName(ConcurrencyLimiterMetricsPublisher.LAST_RTT).supplier.get(), 0.0);  
            "enforced",
        assertEquals(5, mr.openCount());  
        pub.onInactive("a");
        }
            throw new UnsupportedOperationException("not used");
    ) {
        }  
                this.unit = unit;
public class ConcurrencyLimiterMetricsPublisherTests extends OpenSearchTestCase {
    }
        assertEquals(1, pub.registeredAliasCount());
            inFlight.get(),
            final Supplier<Double> supplier;
        @Override
 */  
            GaugeReg(String name, String unit, Supplier<Double> supplier, Tags tags) {  
import org.opensearch.telemetry.metrics.Histogram;  
    public void testGaugesClosedOnInactive() {
 * compatible open source license.
        @Override  
    private static final class RecordingMetricsRegistry implements MetricsRegistry {
            }
        public Counter createUpDownCounter(String name, String description, String unit) {
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.LAST_RTT));
        assertEquals(1, pub.registeredAliasCount());  
            "a",
        String algo,
        static final class GaugeReg {
    public void testReconfigureRefreshesTagsWithoutLeak() {
        String alias,
        assertEquals("a", tags.getTagsMap().get("alias"));
 * this file be licensed under the Apache-2.0 license or a
        pub.onActive("coordinator_search", snap("coordinator_search", "indices:data/read/search", "enforced", "vegas", 150, 0, 0, -1, -1));
        assertEquals(5, mr.gauges.size()); // 5 ever created, all now closed
import org.opensearch.action.ActionConcurrencyLimiterStats.ActionLimiterSnapshot;
        pub.onActive("a", snap("a", "act", "monitor_only", "vegas", 10, 0, 0, -1, -1));
                this.supplier = supplier;  
        pub.onActive("a", live);  
        int limit,  
    }
    public void testNoopRegistryIsInert() {  
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.RTT_NOLOAD));  
        long openCount() {
            final String name;  
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
        assertEquals(7.0, mr.byName(ConcurrencyLimiterMetricsPublisher.TOTAL_REJECTED).supplier.get(), 0.0);
        pub.onInactive("a");
import java.util.ArrayList;
        @Override
        }
        assertEquals("indices:data/read/search", tags.getTagsMap().get("action_name"));
        assertEquals(150.0, mr.byName(ConcurrencyLimiterMetricsPublisher.CURRENT_LIMIT).supplier.get(), 0.0);
            throw new UnsupportedOperationException("not used");  
        pub.close();
    }
        final List<GaugeReg> gauges = new ArrayList<>();
        public void close() {}
 * The OpenSearch Contributors require contributions made to  
        String action,  
            return () -> reg.closed = true;
        assertEquals("monitor_only", tags.getTagsMap().get("mode"));  
        public Closeable createGauge(String name, String description, String unit, Supplier<TaggedMeasurement> value) {  
        pub.onActive("a", snap("a", "act", "enforced", "vegas", 10, 0, 0, -1, -1));  
    }
            150,  
        assertEquals(0, pub.registeredAliasCount());  
    }  
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);  
            "vegas",
        pub.onActive("a", snap("a", "act", "enforced", "vegas", 10, 0, 0, -1, -1));  
        pub.onActive("filterer", snap("filterer", "act1", "enforced", "vegas", 10, 0, 0, -1, -1));
    /** Recording MetricsRegistry: captures createGauge registrations and exposes close tracking. */  
package org.opensearch.concurrency;
        }
    public void testRegistersFiveGaugesPerActiveAlias() {  
        Supplier<ActionLimiterSnapshot> live = () -> new ActionLimiterSnapshot(
        Tags tags = mr.byName(ConcurrencyLimiterMetricsPublisher.CURRENT_LIMIT).tags;  
        );
        public Closeable createGauge(String name, String description, String unit, Supplier<Double> valueProvider, Tags tags) {
        // Mutable backing values to prove the gauge samples live state at collection time.
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.TOTAL_REJECTED));
            42,  
        assertEquals(2, pub.registeredAliasCount());
        String mode,
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);  
        pub.onInactive("filterer");
        public Counter createCounter(String name, String description, String unit) {
            gauges.add(reg);
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.IN_FLIGHT));  
    private static Supplier<ActionLimiterSnapshot> snap(
import org.opensearch.telemetry.metrics.MetricsRegistry;
import org.opensearch.telemetry.metrics.TaggedMeasurement;
        long noLoad
        pub.onActive("a", snap("a", "indices:data/read/search", "monitor_only", "aimd", 10, 0, 0, -1, -1));
    }
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();  
        // Re-fire (e.g. mode change) — old gauges must be closed, new ones registered.
        assertEquals(10, mr.openCount());
        Supplier<Double> inFlightGauge = mr.byName(ConcurrencyLimiterMetricsPublisher.IN_FLIGHT).supplier;
    }
