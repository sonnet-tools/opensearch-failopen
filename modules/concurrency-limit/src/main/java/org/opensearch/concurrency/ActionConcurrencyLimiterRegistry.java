 * <pre>
                onAliasReconfigured(alias, cfg);
        });
import com.netflix.concurrency.limits.Limiter;
import java.util.concurrent.ConcurrentHashMap;
        for (String partitionName : cfg.partitions) {
         * @param alias the limiter alias
                state.set(newState);
        // Load all aliases present in initial settings
        };
                }
     *
        boolean isNoLimiter() {
        volatile int vegasIncreaseBarrier = 1;
                reconfigured = false;
import org.opensearch.concurrency.limit.OpenSearchVegasLimit;
        volatile double vegasBaselineResetLoadThreshold = 0.5;
        String resolverName = partConfig.get("resolver", "");
            // guaranteed to be non-null.
import org.opensearch.common.util.concurrent.ThreadContext;
/*
        cfg.vegasBaselineResetLoadThreshold = vegasConfig.getAsDouble("baseline_reset_load_threshold", 0.5);
     * @param action the transport action name
        }
    static final class LimiterState {
                @Override
        private final AtomicLong totalRejected = new AtomicLong();
     * @param task the current task
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.LIMIT_CONFIG, (alias, val) -> {
        }
    public AcquireResult tryAcquire(String action, Task task, ActionRequest request) {
import com.netflix.concurrency.limits.limiter.AbstractPartitionedLimiter;
        }
                    cfg.actionName
        }
        Settings resolverConfig = partConfig.getAsSettings("resolver." + resolverType.getName());
 *   concurrency_limit.action.search.mode        = enforced
 * Any action can be limited — no code change is required to add a new action.
            aliasConfigs.put(alias, cfg);
            aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig()).algorithm = val;
    private volatile MetricsListener metricsListener;
    }
                Limit limit = algo.build(cfg);
            cfg.aimdBackoffRatio = val.getAsDouble("backoff_ratio", 0.9);
        cfg.maxLimit = limitConfig.getAsInt("max", 200);
            return new AcquireResult(token, false);
        volatile int initialLimit = 20;
        public void onDropped() {}
    }
 * Partitioning: when {@code partitions} is set, the total limit is divided across
        @Override
            cfg.burstCapacity = val.getAsInt("capacity", 0);
    // Metrics listener (push telemetry)
        private final AtomicReference<LimiterState> state = new AtomicReference<>();
        for (String alias : aliases) {
                            inFlight.get()
                builder.partitionRejectDelay(partitionName, delayMs, TimeUnit.MILLISECONDS);
            LimiterRequestContext ctx = partitioned ? new LimiterRequestContext(task, actionName, request) : null;
                totalRejected.get(),
                    newState.warmedUp = true;
            AliasConfig cfg = buildConfig(alias, initialSettings);
    private Limiter<LimiterRequestContext> buildLimiter(Limit limit, AliasConfig cfg) {
                            effectiveLimit - baseLimit,
        cfg.partitions = ConcurrencyLimitSettings.PARTITIONS.getConcreteSettingForNamespace(alias).get(s);
    // Public API
        }
            });
 * SPDX-License-Identifier: Apache-2.0
            this.limiter = limiter;
            aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig()).warmupMillis = val.getMillis();
            onAliasReconfigured(alias, aliasConfigs.get(alias));
                LimiterState prev = state.get();
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.ALGORITHM, (alias, val) -> {
    private void notifyMetricsListener(String alias) {
                        + "all requests mapped to it will be rejected.",
                }
        limiters.forEach((alias, inst) -> {
            return mode;
     * alias becomes active (configured with a non-disabled mode and an action name) or inactive. The
        limiters.forEach((alias, inst) -> {
     *
    public synchronized void setMetricsListener(MetricsListener listener) {
                            baseLimit,
     *
     * plugin's telemetry-aware {@code createComponents}.
            throw new IllegalArgumentException("Unknown partition resolver [" + resolverName + "] for alias [" + cfg.actionName + "]");
        volatile double gradient2RttTolerance = 1.5;
    private final ThreadContext threadContext;
 * metrics but never rejects), {@code enforced} (actively rejects when limit reached).
     * Concrete builder for partitioned limiters. Extends {@link AbstractPartitionedLimiter.Builder}
        },
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
    /**
        Map<String, ActionLimiterInstance> newMap = new HashMap<>();
                inst.reconfigure(cfg);
                    .rttTolerance(cfg.gradient2RttTolerance)
            this.rejected = rejected;
    /**
        if (cfg.partitions.isEmpty()) {
            this.warmedUp = false;
            this.partitioned = newPartitioned;
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.VEGAS_CONFIG, (alias, val) -> {
                    .initialLimit(cfg.initialLimit)
            }
                state.set(null);
            LimiterState s = state.get();
        }, (alias, val) -> ConcurrencyLimitSettings.validateBurstConfig(val));
        volatile double aimdBackoffRatio = 0.9;
            }
    // -------------------------------------------------------------------------
        }
        cfg.aimdBackoffRatio = aimdConfig.getAsDouble("backoff_ratio", 0.9);
        }
        }
                public void onSuccess() {
    // Constructor
            return this == NO_LIMITER;
        clusterSettings.addAffixUpdateConsumer(
 * compatible open source license.
                            inFlight.get()
            notifyMetricsListener(alias);
            return Optional.of(new Limiter.Listener() {
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
            return partitioned;
            int currentLimit = s != null ? s.limit.getLimit() : 0;
    private static final Limiter.Listener NOOP_LISTENER = new Limiter.Listener() {
import com.netflix.concurrency.limits.Limit;
                } else if (limit instanceof OpenSearchVegasLimit) {
        Settings gradient2Config = ConcurrencyLimitSettings.GRADIENT2_CONFIG.getConcreteSettingForNamespace(alias).get(s);
    // -------------------------------------------------------------------------
                    inner.onIgnore();
import java.util.Set;
                    totalRejected.incrementAndGet();
        if (reconfigured) {
     * Returns true if an active (non-disabled) limiter is configured for this action.
            try {
                    .build();
import org.apache.logging.log4j.LogManager;
     *
    }
                return Gradient2Limit.newBuilder()
        }, (alias, val) -> {});
        synchronized void reconfigure(AliasConfig cfg) {
                activeAliases.add(alias);
        cfg.initialLimit = limitConfig.getAsInt("initial", 20);
        }
        }
import org.opensearch.action.ActionConcurrencyLimiterStats;
                    return Optional.of(NOOP_LISTENER);
        ConcurrencyLimitResolverType resolverType;
            if (pct < 0.0 || pct > 1.0) {
     */
                return Optional.empty();
    }
public class ActionConcurrencyLimiterRegistry {
     */
            builder.partition(partitionName, pct);
     * @param action the transport action name
 * namespace key:
                mode.getName(),
        cfg.gradient2RttTolerance = gradient2Config.getAsDouble("rtt_tolerance", 1.5);
 * named sub-pools. A {@link PartitionResolver} maps each request to a partition.
    // -------------------------------------------------------------------------
        volatile long warmupMillis = TimeValue.timeValueMinutes(5).getMillis();
package org.opensearch.concurrency;
 */
        private volatile boolean partitioned;
            this.algorithm = cfg.algorithm;
        Optional<Limiter.Listener> token = inst.tryAcquire(task, request);
    // Per-alias mutable config
            // needs it to resolve a partition. The non-partitioned SimpleLimiter ignores it.
    enum LimitAlgorithm {
        } else {
        }
        /** Called when an alias becomes inactive (disabled or removed).
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.ACTION_NAME, (alias, val) -> {
        volatile int maxLimit = 200;
                    e.getMessage()
        volatile int vegasDecreaseBarrier = 1;
            if (token.isEmpty()) {
            onAliasReconfigured(alias, aliasConfigs.get(alias));
    /** Returns a snapshot of all configured limiter states. */
import java.util.Optional;
            onAliasReconfigured(alias, cfg);
                    inner.onDropped();
            this.warmupUntil = System.currentTimeMillis() + warmupMillis;
                            "Request rejected for alias [{}] action [{}]: limit={} [base={}, burst={}] inFlight={}",
     * Returns {@link AcquireResult#NO_LIMITER} if no limiter is configured,
        volatile Settings partitionConfig = Settings.EMPTY;
import org.opensearch.tasks.Task;
        ActionLimiterInstance inst = limiters.get(alias);
                            "Request rejected for alias [{}] action [{}]: limit={} inFlight={}",
        private volatile String actionName;
                    .maxLimit(cfg.maxLimit)
        double sum = 0.0;
}
 * <p>
        }
import java.util.HashMap;
        cfg.warmupMillis = ConcurrencyLimitSettings.WARMUP_DURATION.getConcreteSettingForNamespace(alias).get(s).getMillis();
        });
        private final Limiter.Listener token;
     * Attaches the push-telemetry listener and replays the currently-active aliases (those loaded
                alias,
                @Override
        LimiterState(Limit limit, Limiter<LimiterRequestContext> limiter, long warmupMillis) {
                LOG.warn(
        static final AcquireResult NO_LIMITER = new AcquireResult(null, false);
import org.apache.logging.log4j.Logger;
     */
        Settings vegasConfig = ConcurrencyLimitSettings.VEGAS_CONFIG.getConcreteSettingForNamespace(alias).get(s);
        MetricsListener listener = this.metricsListener;
                            actionName,
            }
        Limiter.Listener token() {
        }
     * to expose {@code partition()}, {@code partitionResolver()}, and {@code partitionRejectDelay()}.
            this.token = token;
import com.netflix.concurrency.limits.limiter.SimpleLimiter;
        if (cfg.actionName.isEmpty()) {
     * to avoid a TOCTOU race with concurrent settings changes.
            double pct = partConfig.getAsDouble(partitionName + ".percent", 0.0);
            if (cfg.mode != ConcurrencyLimitMode.DISABLED) {
    // -------------------------------------------------------------------------
        limiters.values().forEach(inst -> snapshots.add(inst.snapshot()));
import java.util.Collections;
            Limit build(AliasConfig cfg) {
            resolverType = ConcurrencyLimitResolverType.fromName(resolverName);
        cfg.actionName = ConcurrencyLimitSettings.ACTION_NAME.getConcreteSettingForNamespace(alias).get(s);
                totalRejected.incrementAndGet();
import org.opensearch.common.settings.Setting;
        }
        ActionLimiterSnapshot snapshot() {
        boolean isWarmedUp() {
            throw new IllegalArgumentException(
        if (token.isEmpty()) return AcquireResult.REJECTED;
    private static boolean isActive(ActionLimiterInstance inst) {
            // another thread reads mode (volatile) and sees a non-disabled value, state is
        volatile int burstCapacity = 0;
            this.mode = cfg.mode;
     * Attempts to acquire a concurrency token for the given action in a single atomic lookup.
    /** Fire the metrics listener for one alias after a (re)configuration. Called under synchronization. */
import com.netflix.concurrency.limits.limit.GradientLimit;
            @Override
    };
        volatile int burstCloseAfter = 5;
    // -------------------------------------------------------------------------
            if (isActive(inst)) {
        cfg.vegasIncreaseBarrier = vegasConfig.getAsInt("increase_barrier", 1);
import org.opensearch.concurrency.limit.BurstAwareLimit;
     * Tri-state result of {@link #tryAcquire}: no limiter configured, token acquired, or rejected.
     * Creates a new registry, loading initial limiter configurations and registering dynamic update consumers.
        cfg.partitionConfig = ConcurrencyLimitSettings.PARTITION_CONFIG.getConcreteSettingForNamespace(alias).get(s);
        ContextT> {
            onAliasReconfigured(alias, cfg);
                            alias,
            return warmedUp;
                            rejLimit.getLimit(),
     * @param initialSettings the node's initial settings
        cfg.algorithm = ConcurrencyLimitSettings.ALGORITHM.getConcreteSettingForNamespace(alias).get(s);
    // -------------------------------------------------------------------------
                    .initialLimit(cfg.initialLimit)
import java.util.concurrent.atomic.AtomicInteger;
                    }
        volatile ConcurrencyLimitMode mode = ConcurrencyLimitMode.DISABLED;
        }
            }
            this.actionName = cfg.actionName;
                    inFlight.decrementAndGet();
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.AIMD_CONFIG, (alias, val) -> {
                        );
        Settings burstConfig = ConcurrencyLimitSettings.BURST_CONFIG.getConcreteSettingForNamespace(alias).get(s);
    /**
        builder.limit(limit);
            return new ActionLimiterSnapshot(
            // All construction succeeded — now commit. Write state BEFORE mode so that if
 * <p>
        List<ActionLimiterSnapshot> snapshots = new ArrayList<>();
        return builder.build();
import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;
        Settings aimdConfig = ConcurrencyLimitSettings.AIMD_CONFIG.getConcreteSettingForNamespace(alias).get(s);
        for (Setting<?> s : ConcurrencyLimitSettings.ALL_SETTINGS) {
            limiters.remove(alias);
        cfg.burstCapacity = burstConfig.getAsInt("capacity", 0);
            }
 *
            // Only allocate the context object when the limiter is partitioned and actually
    // Per-alias limiter state
        }
            long lastRttMs = -1L;
        cfg.burstCloseAfter = burstConfig.getAsInt("close_after", 5);
            throw new IllegalArgumentException("partitions configured for alias [" + cfg.actionName + "] but no partition.resolver set");
    // Registry state
            boolean newPartitioned = !cfg.partitions.isEmpty();
                    .build();
            // Re-fire on every reconfigure so the bridge can refresh tags (mode/algorithm/action);
import com.netflix.concurrency.limits.limit.AIMDLimit;
    // -------------------------------------------------------------------------
                } else if (limit instanceof Gradient2Limit) {
                }
                public void onIgnore() {
            @Override
                newState = new LimiterState(limit, limiter, cfg.warmupMillis);
                    .probeInflightThreshold(cfg.vegasBaselineResetLoadThreshold)
            ConcurrencyLimitSettings.PARTITION_CONFIG,
            // the listener is expected to treat a repeat onActive as a refresh.
     * the token on success.
        }
                lastRttMs,
import org.opensearch.common.unit.TimeValue;
                        LOG.debug(
        }
        }, (alias, val) -> ConcurrencyLimitSettings.validateAimdConfig(val));
        @Override
 * Operators configure limiters at runtime via cluster settings using an alias as the
        }
        private final boolean rejected;
            ConcurrencyLimitSettings.PARTITIONS,
        }, (alias, val) -> ConcurrencyLimitSettings.validateLimitConfig(val));
     * {@code NodeStats}) reports, so both telemetry paths publish identical numbers.
     * Lifecycle callback for a push-telemetry bridge. The registry notifies the listener whenever an
 *   concurrency_limit.action.search.action_name = indices:data/read/search
    private synchronized void onAliasReconfigured(String alias, AliasConfig cfg) {
        if (listener == null) return;
    }
                    rttNoLoadMs = ((Gradient2Limit) limit).getRttNoLoad(TimeUnit.MILLISECONDS);
        // LimiterRequestContext on the hot path when partitioning is not in use.
            cfg.initialLimit = val.getAsInt("initial", 20);
        return actionToInstance.containsKey(action);
    private final ConcurrentHashMap<String, AliasConfig> aliasConfigs = new ConcurrentHashMap<>();
            onAliasReconfigured(alias, aliasConfigs.get(alias));
                    cfg.actionName,
    // -------------------------------------------------------------------------
        volatile String actionName = "";
    // -------------------------------------------------------------------------
            onAliasReconfigured(alias, cfg);
            long delayMs = partConfig.getAsLong(partitionName + ".delay_ms", 0L);
            }
            // Build the new state into a local FIRST. If construction throws (e.g. invalid
            cfg.vegasDecreaseBarrier = val.getAsInt("decrease_barrier", 1);
            onAliasReconfigured(alias, aliasConfigs.get(alias));
        @Override
                inFlight.get(),
    }
        }
                    limit = new BurstAwareLimit((AbstractLimit) limit, cfg.burstCapacity, cfg.burstCloseAfter, cfg.burstOpenAfter);
import java.util.HashSet;
            }
                algorithm,
        PartitionedBuilder<ContextT>,
            ActionLimiterInstance inst = limiters.computeIfAbsent(alias, ActionLimiterInstance::new);
                AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
        }
                    inFlight.decrementAndGet();
        AliasConfig cfg = new AliasConfig();
    private static final Logger LOG = LogManager.getLogger(ActionConcurrencyLimiterRegistry.class);
     * @param clusterSettings the cluster settings service for dynamic updates
     * {@link AcquireResult#REJECTED} if the limit is reached, or an acquired result carrying
        ActionLimiterInstance inst = actionToInstance.get(action);
            (alias, tuple) -> {
    private volatile Map<String, ActionLimiterInstance> actionToInstance = Collections.emptyMap();
            Limit build(AliasConfig cfg) {
            LimiterState s = state.get();
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.WARMUP_DURATION, (alias, val) -> {
                LimitAlgorithm algo = LimitAlgorithm.valueOf(cfg.algorithm.toUpperCase(Locale.ROOT));
            if (s != null) {
        final long warmupUntil;
            LimiterState newState = null;
        }, (alias, val) -> {});
            warmedUp = warmedUp || warmupUntil <= System.currentTimeMillis();
        for (String partitionName : cfg.partitions) {
    // Algorithm enum
            activeAliases.add(alias);
import org.opensearch.common.settings.Settings;
                );
        // Partition config
        this.threadContext = threadContext;
            cfg.vegasIncreaseBarrier = val.getAsInt("increase_barrier", 1);
                            effectiveLimit,
    // -------------------------------------------------------------------------
                    } else {
            listener.onInactive(alias);
import java.util.concurrent.atomic.AtomicLong;
 */
        void onInactive(String alias);
    static final class AliasConfig {
                    .minLimit(1)
    private final Set<String> activeAliases = ConcurrentHashMap.newKeySet();
        final Limit limit;
            if (s == null) return Optional.empty();
 * Registry that manages one adaptive concurrency limiter per configured action alias.
        static AcquireResult acquired(Limiter.Listener token) {
 * Supported modes: {@code disabled} (default, no-op), {@code monitor_only} (tracks
    }
     */
            cfg.maxLimit = val.getAsInt("max", 200);
                    "Partition [{}] for alias [{}] has 0%% capacity (no percent configured); "
        private final String alias;
    public ActionConcurrencyLimiterStats getStats() {
/**
                        int effectiveLimit = rejLimit.getLimit();
    /**
import org.opensearch.common.settings.ClusterSettings;
                    .upDriftFactor(cfg.vegasUpDriftFactor)
     * @param threadContext the thread context for header propagation
        boolean warmedUp;
    // -------------------------------------------------------------------------
                if (prev != null && prev.isWarmedUp()) {
            (alias, tuple) -> ConcurrencyLimitSettings.validatePartitionConfig(tuple.v1(), tuple.v2())
    }
                    rttNoLoadMs = ((OpenSearchVegasLimit) limit).getRttNoLoad(TimeUnit.MILLISECONDS);
        static final AcquireResult REJECTED = new AcquireResult(null, true);
        if (listener == null) return;
                            alias,
     * Primarily for diagnostics and tests — the filter uses {@link #tryAcquire} instead
    /**
                "Sum of partition percentages for alias [" + cfg.actionName + "] must be <= 1.0 but got " + sum
                    .maxConcurrency(cfg.maxLimit)
            aliases.addAll(((Setting.AffixSetting<?>) s).getNamespaces(initialSettings));
            if (inst.getMode() != ConcurrencyLimitMode.DISABLED && !inst.getActionName().isEmpty()) {
                if (limit instanceof GradientLimit) {
        boolean reconfigured = true;
import org.opensearch.action.ActionRequest;
import java.util.function.Supplier;
            inFlight.incrementAndGet();
                if (LOG.isDebugEnabled()) {
                if (cfg.burstCapacity > 0) {
            // partition percentages), no instance field is mutated and the caller's try/catch
            aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig()).mode = ConcurrencyLimitMode.fromName(val);
        boolean isPartitioned() {
 * </pre>
            sum += pct;
        boolean isAcquired() {
 * <p>
                cfg.partitions = tuple.v1();
                newMap.put(inst.getActionName(), inst);
     * and per-partition configuration when partitions are defined.
            this.alias = alias;
            }
        PartitionedBuilder<LimiterRequestContext> builder = new PartitionedBuilder<>();
        );
import org.opensearch.action.ActionConcurrencyLimiterStats.ActionLimiterSnapshot;
    }
    // -------------------------------------------------------------------------
        if (isActive(inst)) {
        volatile int burstOpenAfter = 5;
                    inFlight.decrementAndGet();
        volatile int vegasUpDriftFactor = 1;
                }
     * from initial settings before the listener was wired). Called once, after construction, from the
                        int baseLimit = ((BurstAwareLimit) rejLimit).getDelegate().getLimit();
            long rttNoLoadMs = -1L;
        if (inst == null) return AcquireResult.NO_LIMITER;
            double pct = partConfig.getAsDouble(partitionName + ".percent", 0.0);
            cfg.burstOpenAfter = val.getAsInt("open_after", 5);
                    limit = ((BurstAwareLimit) limit).getDelegate();
         * @param alias the limiter alias */
    // -------------------------------------------------------------------------
        },
        return inst != null && inst.getMode() != ConcurrencyLimitMode.DISABLED && !inst.getActionName().isEmpty();
            Limit build(AliasConfig cfg) {
        ActionLimiterInstance(String alias) {
                    .maxConcurrency(cfg.maxLimit)
    private void rebuildReverseMap() {
        }, (alias, val) -> ConcurrencyLimitSettings.validateVegasConfig(val));
            @Override
            return SimpleLimiter.<LimiterRequestContext>newBuilder().limit(limit).build();
        actionToInstance = Collections.unmodifiableMap(newMap);
                    partitionName,
    // Internal
     */
                    inner.onSuccess();
                cfg.partitionConfig = tuple.v2();
                }
            return token;
        abstract Limit build(AliasConfig cfg);
                // enforced: reject after warmup, pass through during warmup
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.MODE, (alias, val) -> {
    private final ConcurrentHashMap<String, ActionLimiterInstance> limiters = new ConcurrentHashMap<>();
                if (this.mode == ConcurrencyLimitMode.MONITOR_ONLY) {
                throw new IllegalArgumentException("partition [" + partitionName + "] percent must be in [0.0, 1.0] but got " + pct);
                        );
        if (sum > 1.0 + 1e-6) {
            }
    }
     * @param request the action request
        AIMD {
        rebuildReverseMap();
                }
            cfg.gradient2RttTolerance = val.getAsDouble("rtt_tolerance", 1.5);
            aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig()).actionName = val;
            return rejected;
 * The OpenSearch Contributors require contributions made to
        final Limiter<LimiterRequestContext> limiter;
        }, (alias, val) -> {});
                }
     */
        // Register update consumers
            onAliasReconfigured(alias, cfg);
    }
                }
            return token != null;
                    rttNoLoadMs = ((GradientLimit) limit).getRttNoLoad(TimeUnit.MILLISECONDS);
            return actionName;
    }
    /**
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
        private volatile ConcurrencyLimitMode mode;
                    .increaseHysteresis(cfg.vegasIncreaseBarrier)
            this.limit = limit;
                @Override
        Set<String> aliases = new HashSet<>();
                            actionName,
                actionName,
     */
    public boolean hasLimiterFor(String action) {
    }
            // leaves this instance fully on its previous configuration.
                );
            }
        }, (alias, val) -> ConcurrencyLimitSettings.validateGradient2Config(val));
                listener.onActive(alias, inst::snapshot);
            if (newState != null) {
            }
    private static final class PartitionedBuilder<ContextT> extends AbstractPartitionedLimiter.Builder<
import java.util.ArrayList;
            cfg.burstCloseAfter = val.getAsInt("close_after", 5);
        }
        }
    }
            );
import java.util.Locale;
                    .backoffRatio(cfg.aimdBackoffRatio)
        builder.partitionResolver(ctx -> ctx != null ? resolver.resolve(ctx) : null);
        Settings limitConfig = ConcurrencyLimitSettings.LIMIT_CONFIG.getConcreteSettingForNamespace(alias).get(s);
    /**
            cfg.vegasUpDriftFactor = val.getAsInt("updrift_factor", 1);
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
    public ActionConcurrencyLimiterRegistry(Settings initialSettings, ClusterSettings clusterSettings, ThreadContext threadContext) {
                if (limit instanceof BurstAwareLimit) {
import com.netflix.concurrency.limits.limit.AbstractLimit;
                currentLimit,
        cfg.burstOpenAfter = burstConfig.getAsInt("open_after", 5);
            Optional<Limiter.Listener> token = s.limiter.acquire(ctx);
        return AcquireResult.acquired(token.get());
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
        return new ActionConcurrencyLimiterStats(snapshots);
                    .initialLimit(cfg.initialLimit)
                Limit limit = s.limit;
        private volatile String algorithm;
        if (resolverType == ConcurrencyLimitResolverType.NONE) {
        Optional<Limiter.Listener> tryAcquire(Task task, ActionRequest request) {
            onAliasReconfigured(alias, cfg);
        PartitionResolver resolver = PartitionResolver.build(resolverType, resolverConfig, threadContext);
        VEGAS {
            cfg.vegasBaselineResetLoadThreshold = val.getAsDouble("baseline_reset_load_threshold", 0.5);
        GRADIENT2 {
                    "Failed to apply concurrency limit config for alias [{}] action [{}]; " + "keeping previous configuration. Error: {}",
            return this;
    // -------------------------------------------------------------------------
        private AcquireResult(Limiter.Listener token, boolean rejected) {
        }, (alias, val) -> {});
import com.netflix.concurrency.limits.limit.Gradient2Limit;
        } else if (activeAliases.remove(alias)) {
            onAliasReconfigured(alias, cfg);
         * @param snapshotSupplier supplies the live snapshot for the alias */
            } catch (RuntimeException e) {
    }
        }
        @Override
            if (delayMs > 0) {
                    .build();
        // True when this limiter is partitioned. Used to avoid allocating a
        volatile String algorithm = "vegas";
     * {@code snapshotSupplier} yields the same per-alias values the pull path ({@code snapshot()} →
        try {
        boolean isRejected() {
                    lastRttMs = ((Gradient2Limit) limit).getLastRtt(TimeUnit.MILLISECONDS);
        void onActive(String alias, Supplier<ActionLimiterSnapshot> snapshotSupplier);
                return OpenSearchVegasLimit.newBuilder()
            Limiter.Listener inner = token.get();
    static final class AcquireResult {
    // -------------------------------------------------------------------------
        public void onSuccess() {}
                        LOG.debug(
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.GRADIENT2_CONFIG, (alias, val) -> {
                }
        protected PartitionedBuilder<ContextT> self() {
    public interface MetricsListener {
 *   concurrency_limit.action.search.algorithm   = vegas
                rttNoLoadMs
                Limiter<LimiterRequestContext> limiter = buildLimiter(limit, cfg);
     * @param listener the metrics listener to attach, or {@code null} to detach
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
        volatile List<String> partitions = List.of();
    }
            if (pct == 0.0) {
        }
            }
            },
import java.util.concurrent.TimeUnit;
            }
            } else {
        public void onIgnore() {}
        ConcurrencyLimitMode getMode() {
        /** Called when an alias becomes active or is reconfigured.
    }
    /**
        return cfg;
     */
        }
        Settings partConfig = cfg.partitionConfig;
                LOG.error(
            listener.onActive(alias, inst::snapshot);
        } catch (IllegalArgumentException e) {
        }
     * Builds a {@link Limiter} for the given limit, wiring up partition resolver
        this.metricsListener = listener;
        cfg.vegasDecreaseBarrier = vegasConfig.getAsInt("decrease_barrier", 1);
                    .decreaseHysteresis(cfg.vegasDecreaseBarrier)
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.BURST_CONFIG, (alias, val) -> {
                return AIMDLimit.newBuilder()
    final class ActionLimiterInstance {
                if (!s.isWarmedUp()) return Optional.of(NOOP_LISTENER);
    }
    private AliasConfig buildConfig(String alias, Settings s) {
    // -------------------------------------------------------------------------
        cfg.vegasUpDriftFactor = vegasConfig.getAsInt("updrift_factor", 1);
            );
                    Limit rejLimit = s.limit;
        String getActionName() {
                    if (rejLimit instanceof BurstAwareLimit) {
        cfg.mode = ConcurrencyLimitMode.fromName(ConcurrencyLimitSettings.MODE.getConcreteSettingForNamespace(alias).get(s));
                public void onDropped() {
                    alias,
        private final AtomicInteger inFlight = new AtomicInteger();
                    lastRttMs = ((GradientLimit) limit).getLastRtt(TimeUnit.MILLISECONDS);
