        );  
 * Push-telemetry bridge for the concurrency limiter.
import org.opensearch.telemetry.metrics.MetricsRegistry;
                tags
                "1",
}  
                tags
     * Creates a new publisher backed by the given metrics registry.
 * publish an identical metric set with identical values.
package org.opensearch.concurrency;
import java.util.List;
 * <p>
                LAST_RTT,  
        );  
    private void closeAlias(String alias) {
import java.io.IOException;
    private final Map<String, List<Closeable>> gaugesByAlias = new ConcurrentHashMap<>();
    static final String RTT_NOLOAD = "concurrency_limit.rtt_noload";
 * SPDX-License-Identifier: Apache-2.0
 * {@code onActive} for an already-registered alias refreshes its tags (e.g. after a mode change).
import org.apache.logging.log4j.LogManager;
            metricsRegistry.createGauge(
 * inert with no special-casing here.  
            metricsRegistry.createGauge(
/**  
 * Registers one set of observable gauges per active alias with the OpenSearch  
                "1",
 */  
        if (gauges == null) return;  
 * {@link MetricsRegistry}. Each gauge's value provider reads the alias's live
 * Gauges are (re)registered on {@link #onActive} and torn down on {@link #onInactive}; re-firing  
     * @param metricsRegistry the metrics registry to register gauges with  
    int registeredAliasCount() {
     */
            )
 * {@link ActionLimiterSnapshot} — the exact same values the pull path
                () -> (double) snapshotSupplier.get().getCurrentLimit(),  
    private static final Logger LOG = LogManager.getLogger(ConcurrencyLimiterMetricsPublisher.class);
                "Last observed round-trip time (-1 if unavailable)",
        Tags tags = Tags.create()  
                TOTAL_REJECTED,  
    }
            )
import org.apache.logging.log4j.Logger;
    public synchronized void close() {
import org.opensearch.telemetry.metrics.tags.Tags;
                gauge.close();  
            metricsRegistry.createGauge(
            try {
        gauges.add(
                IN_FLIGHT,  
            closeAlias(alias);  
 * The OpenSearch Contributors require contributions made to  
        for (Closeable gauge : gauges) {
        gauges.add(
import java.util.concurrent.ConcurrentHashMap;  
 */
                () -> (double) snapshotSupplier.get().getLastRttMillis(),  
                tags
     *
            metricsRegistry.createGauge(
import org.opensearch.action.ActionConcurrencyLimiterStats.ActionLimiterSnapshot;  
        );  
                () -> (double) snapshotSupplier.get().getRttNoLoadMillis(),  
                tags
            )
            )
        // Refresh: drop any prior registration so tags reflect the current config.
            .addTag("algorithm", s0.getAlgorithm());
import java.util.ArrayList;  
                tags
            } catch (IOException e) {
                RTT_NOLOAD,  
        }
                "Round-trip time under no load (-1 if unavailable)",
                "Requests currently holding a token",
            }  
                CURRENT_LIMIT,  
                () -> (double) snapshotSupplier.get().getInFlight(),  
        closeAlias(alias);  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
import java.util.Map;
        ActionLimiterSnapshot s0 = snapshotSupplier.get();
        for (String alias : new ArrayList<>(gaugesByAlias.keySet())) {
 * ({@code /_nodes/stats} {@code concurrency_limiters}) reports — so both telemetry mechanisms  
 * compatible open source license.
        List<Closeable> gauges = gaugesByAlias.remove(alias);
        );  
        gaugesByAlias.put(alias, gauges);
public final class ConcurrencyLimiterMetricsPublisher implements ActionConcurrencyLimiterRegistry.MetricsListener, Closeable {
    private final MetricsRegistry metricsRegistry;  
    }
            .addTag("action_name", s0.getActionName())
 * <p>
 *
        }
                "1",
                LOG.warn("Failed to close concurrency-limit gauge for alias [{}]: {}", alias, e.getMessage());
    }
    }
        List<Closeable> gauges = new ArrayList<>(5);  
        gauges.add(
    @Override
    public ConcurrencyLimiterMetricsPublisher(MetricsRegistry metricsRegistry) {
                "Current adaptive concurrency limit",
    // Visible for testing.
        this.metricsRegistry = metricsRegistry;  
                "Cumulative rejected requests (includes monitor_only would-be rejections)",
                "ms",
            .addTag("alias", alias)
        gauges.add(
/*  
 * When telemetry is disabled the node supplies a no-op {@code MetricsRegistry}, so this bridge is
            .addTag("mode", s0.getMode())  
            metricsRegistry.createGauge(
        return gaugesByAlias.size();  
            )
    }
                () -> (double) snapshotSupplier.get().getTotalRejected(),  
    static final String CURRENT_LIMIT = "concurrency_limit.current_limit";  
    public synchronized void onActive(String alias, Supplier<ActionLimiterSnapshot> snapshotSupplier) {
    static final String TOTAL_REJECTED = "concurrency_limit.total_rejected";
        );  
    }  
        gauges.add(
        closeAlias(alias);
    /**  
    static final String LAST_RTT = "concurrency_limit.last_rtt";  
    static final String IN_FLIGHT = "concurrency_limit.in_flight";
    public synchronized void onInactive(String alias) {  
import java.io.Closeable;
import java.util.function.Supplier;
                "ms",
    @Override  
