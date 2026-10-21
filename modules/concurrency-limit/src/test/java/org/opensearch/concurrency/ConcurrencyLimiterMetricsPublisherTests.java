        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.TOTAL_REJECTED));
        assertEquals("first generation must have been closed", 10, mr.gauges.size());
            GaugeReg(String name, String unit, Supplier<Double> supplier, Tags tags) {
        @Override
    }
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
            150,
    }
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
import java.util.List;
        assertEquals(1, pub.registeredAliasCount());
        }
        long lastRtt,
        assertEquals(1, pub.registeredAliasCount());
    }
        int limit,
    /** Recording MetricsRegistry: captures createGauge registrations and exposes close tracking. */
        inFlight.set(9);
 * this file be licensed under the Apache-2.0 license or a
        pub.onActive("a", snap("a", "act", "monitor_only", "vegas", 10, 0, 0, -1, -1));
        assertEquals(3.0, inFlightGauge.get(), 0.0);
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.IN_FLIGHT));
            throw new UnsupportedOperationException("not used");
        assertEquals("monitor_only", mr.byName(ConcurrencyLimiterMetricsPublisher.CURRENT_LIMIT).tags.getTagsMap().get("mode"));
        AtomicInteger inFlight = new AtomicInteger(3);
        public void close() {}
    }
            throw new UnsupportedOperationException("not used");
import java.util.function.Supplier;
            "act",
        pub.onActive("a", live);
        assertEquals("all gauges for the alias must be closed", 0, mr.openCount());
        }
            inFlight.get(),
            42,
            final Supplier<Double> supplier;
            7,
        pub.onActive("agger", snap("agger", "act2", "enforced", "vegas", 20, 0, 0, -1, -1));
/*
        assertEquals(150.0, mr.byName(ConcurrencyLimiterMetricsPublisher.CURRENT_LIMIT).supplier.get(), 0.0);
        public Counter createUpDownCounter(String name, String description, String unit) {
    private static final class RecordingMetricsRegistry implements MetricsRegistry {
package org.opensearch.concurrency;
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
}
        @Override
            throw new UnsupportedOperationException("not used");
        pub.onInactive("a");
import org.opensearch.telemetry.metrics.MetricsRegistry;
        assertEquals("monitor_only", tags.getTagsMap().get("mode"));
    public void testRegistersFiveGaugesPerActiveAlias() {
        pub.onActive("a", snap("a", "act", "enforced", "vegas", 10, 0, 0, -1, -1));
        }
        @Override
        assertEquals("aimd", tags.getTagsMap().get("algorithm"));
        Supplier<ActionLimiterSnapshot> live = () -> new ActionLimiterSnapshot(
public class ConcurrencyLimiterMetricsPublisherTests extends OpenSearchTestCase {
            "enforced",
                this.tags = tags;
import org.opensearch.telemetry.metrics.tags.Tags;
import org.opensearch.action.ActionConcurrencyLimiterStats.ActionLimiterSnapshot;
        public Closeable createGauge(String name, String description, String unit, Supplier<Double> valueProvider, Tags tags) {
        @Override
            final String unit;
        assertEquals("a", tags.getTagsMap().get("alias"));
import org.opensearch.telemetry.metrics.TaggedMeasurement;
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.RTT_NOLOAD));
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        pub.onInactive("a");
        return () -> new ActionLimiterSnapshot(alias, action, mode, algo, limit, inFlight, rejected, lastRtt, noLoad);
        pub.close();
        assertEquals(42.0, mr.byName(ConcurrencyLimiterMetricsPublisher.LAST_RTT).supplier.get(), 0.0);
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
        }
                this.unit = unit;
        assertEquals("gauge must re-sample live snapshot", 9.0, inFlightGauge.get(), 0.0);
        pub.onInactive("filterer");
        long openCount() {
        assertEquals("indices:data/read/search", tags.getTagsMap().get("action_name"));
                this.supplier = supplier;
        static final class GaugeReg {
    public void testReconfigureRefreshesTagsWithoutLeak() {
import org.opensearch.telemetry.metrics.Counter;
        }
 */
    }
    public void testMultipleAliasesIndependent() {
        pub.onActive("a", snap("a", "act", "enforced", "vegas", 10, 0, 0, -1, -1));
        String mode,
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
        // With the node's no-op registry (telemetry disabled), nothing should throw.
        public Counter createCounter(String name, String description, String unit) {
        assertEquals(5, mr.openCount());
        GaugeReg byName(String name) {
        long rejected,
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
        assertEquals(5.0, mr.byName(ConcurrencyLimiterMetricsPublisher.RTT_NOLOAD).supplier.get(), 0.0);
        assertEquals(1, pub.registeredAliasCount());
        public Closeable createGauge(String name, String description, String unit, Supplier<TaggedMeasurement> value) {
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
        pub.onActive("a", snap("a", "indices:data/read/search", "monitor_only", "aimd", 10, 0, 0, -1, -1));
    }
        Supplier<Double> inFlightGauge = mr.byName(ConcurrencyLimiterMetricsPublisher.IN_FLIGHT).supplier;
 *
    ) {
            "a",
    private static Supplier<ActionLimiterSnapshot> snap(
        final List<GaugeReg> gauges = new ArrayList<>();
            GaugeReg reg = new GaugeReg(name, unit, valueProvider, tags);
            final Tags tags;
        // Mutable backing values to prove the gauge samples live state at collection time.
        @Override
            return () -> reg.closed = true;
    public void testGaugeValuesTrackLiveSnapshot() {
            5
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
    }
            return gauges.stream().filter(g -> !g.closed).count();
import org.opensearch.test.OpenSearchTestCase;
        );
        String action,
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.LAST_RTT));
        assertEquals(10, mr.openCount());
        int inFlight,
            final String name;
        Tags tags = mr.byName(ConcurrencyLimiterMetricsPublisher.CURRENT_LIMIT).tags;
        assertNotNull(mr.byName(ConcurrencyLimiterMetricsPublisher.CURRENT_LIMIT));
        assertEquals("only the latest generation of 5 gauges should be open", 5, mr.openCount());
        assertEquals(7.0, mr.byName(ConcurrencyLimiterMetricsPublisher.TOTAL_REJECTED).supplier.get(), 0.0);
        public Histogram createHistogram(String name, String description, String unit) {
    }
        }
        String algo,
            return gauges.stream().filter(g -> g.name.equals(name) && !g.closed).findFirst().orElse(null);
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(NoopMetricsRegistry.INSTANCE);
    public void testGaugesClosedOnInactive() {
 * SPDX-License-Identifier: Apache-2.0
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
        assertEquals(2, pub.registeredAliasCount());
        pub.onActive("a", snap("a", "act", "enforced", "vegas", 10, 0, 0, -1, -1));
import java.util.concurrent.atomic.AtomicInteger;
        ConcurrencyLimiterMetricsPublisher pub = new ConcurrencyLimiterMetricsPublisher(mr);
import java.io.Closeable;
    }
 * The OpenSearch Contributors require contributions made to
    public void testGaugeTagsFromSnapshot() {
        @Override
        assertEquals(0, pub.registeredAliasCount());
        pub.onActive("coordinator_search", snap("coordinator_search", "indices:data/read/search", "enforced", "vegas", 150, 0, 0, -1, -1));
            }
            throw new UnsupportedOperationException("not used");
import java.util.ArrayList;
        assertEquals(5, mr.gauges.size()); // 5 ever created, all now closed
        assertEquals(5, mr.openCount());
                this.name = name;
    public void testNoopRegistryIsInert() {
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
            "vegas",
        assertEquals(1, pub.registeredAliasCount());
        }
            boolean closed = false;
import org.opensearch.telemetry.metrics.Histogram;
        // Re-fire (e.g. mode change) — old gauges must be closed, new ones registered.
        long noLoad
 * compatible open source license.
        assertEquals(0, pub.registeredAliasCount());
        pub.onActive("filterer", snap("filterer", "act1", "enforced", "vegas", 10, 0, 0, -1, -1));
        assertEquals(5, mr.openCount());
            gauges.add(reg);
        }
        String alias,
        RecordingMetricsRegistry mr = new RecordingMetricsRegistry();
