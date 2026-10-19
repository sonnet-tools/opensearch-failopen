            cfg.vegasBaselineResetLoadThreshold = val.getAsDouble("baseline_reset_load_threshold", 0.5);  
     * to expose {@code partition()}, {@code partitionResolver()}, and {@code partitionRejectDelay()}.
                algorithm,
        cfg.actionName = ConcurrencyLimitSettings.ACTION_NAME.getConcreteSettingForNamespace(alias).get(s);
            builder.partition(partitionName, pct);  
        ActionLimiterInstance inst = actionToInstance.get(action);
        for (String partitionName : cfg.partitions) {  
                }  
 * metrics but never rejects), {@code enforced} (actively rejects when limit reached).
                    .maxConcurrency(cfg.maxLimit)  
 * The OpenSearch Contributors require contributions made to  
        volatile int burstCapacity = 0;
            activeAliases.add(alias);  
    private static final Logger LOG = LogManager.getLogger(ActionConcurrencyLimiterRegistry.class);  
     */  
            Limit build(AliasConfig cfg) {
        volatile List<String> partitions = List.of();  
    // -------------------------------------------------------------------------  
            aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig()).actionName = val;  
    // Per-alias limiter state
    }  
        abstract Limit build(AliasConfig cfg);  
            }  
     *  
        } else if (activeAliases.remove(alias)) {
    /** Fire the metrics listener for one alias after a (re)configuration. Called under synchronization. */  
        );
        builder.limit(limit);  
                    rttNoLoadMs = ((GradientLimit) limit).getRttNoLoad(TimeUnit.MILLISECONDS);
                            alias,
                cfg.partitions = tuple.v1();  
        private AcquireResult(Limiter.Listener token, boolean rejected) {
        }, (alias, val) -> ConcurrencyLimitSettings.validateBurstConfig(val));  
    private void notifyMetricsListener(String alias) {
                    lastRttMs = ((GradientLimit) limit).getLastRtt(TimeUnit.MILLISECONDS);  
    // -------------------------------------------------------------------------
            this.mode = cfg.mode;
        String resolverName = partConfig.get("resolver", "");
    }
                @Override
    public interface MetricsListener {  
    enum LimitAlgorithm {  
    /**
/*  
                            effectiveLimit,
        ActionLimiterSnapshot snapshot() {
                        int baseLimit = ((BurstAwareLimit) rejLimit).getDelegate().getLimit();
            if (s == null) return Optional.empty();
        volatile int vegasUpDriftFactor = 1;
                    .probeInflightThreshold(cfg.vegasBaselineResetLoadThreshold)
    }
                            actionName,
                    partitionName,
import java.util.Collections;
        });
    }
            } else {
                inst.reconfigure(cfg);
    // -------------------------------------------------------------------------  
 * </pre>
                if (limit instanceof BurstAwareLimit) {
import com.netflix.concurrency.limits.Limit;
        synchronized void reconfigure(AliasConfig cfg) {
        private final AtomicLong totalRejected = new AtomicLong();
                actionName,
        protected PartitionedBuilder<ContextT> self() {
                        LOG.debug(
            }  
        VEGAS {
    /**  
     */
    /**
import java.util.List;
        }
    /**
            this.algorithm = cfg.algorithm;  
    private synchronized void onAliasReconfigured(String alias, AliasConfig cfg) {  
    // Constructor
        }
            cfg.vegasDecreaseBarrier = val.getAsInt("decrease_barrier", 1);
                listener.onActive(alias, inst::snapshot);  
            aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig()).warmupMillis = val.getMillis();  
        }
        Settings resolverConfig = partConfig.getAsSettings("resolver." + resolverType.getName());
            );
        actionToInstance = Collections.unmodifiableMap(newMap);
            if (token.isEmpty()) {
/**
            onAliasReconfigured(alias, aliasConfigs.get(alias));
            LimiterRequestContext ctx = partitioned ? new LimiterRequestContext(task, actionName, request) : null;
     *  
            throw new IllegalArgumentException("partitions configured for alias [" + cfg.actionName + "] but no partition.resolver set");  
        ConcurrencyLimitResolverType resolverType;
public class ActionConcurrencyLimiterRegistry {
                            "Request rejected for alias [{}] action [{}]: limit={} inFlight={}",  
                            baseLimit,  
        // Register update consumers
        cfg.vegasBaselineResetLoadThreshold = vegasConfig.getAsDouble("baseline_reset_load_threshold", 0.5);
    }
import org.opensearch.tasks.Task;
import java.util.Map;  
     * the token on success.
    private Limiter<LimiterRequestContext> buildLimiter(Limit limit, AliasConfig cfg) {
 * <p>  
    // -------------------------------------------------------------------------
                    limit = ((BurstAwareLimit) limit).getDelegate();  
            boolean newPartitioned = !cfg.partitions.isEmpty();  
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.MODE, (alias, val) -> {  
                return AIMDLimit.newBuilder()  
            return token != null;
        void onActive(String alias, Supplier<ActionLimiterSnapshot> snapshotSupplier);
        PartitionedBuilder<LimiterRequestContext> builder = new PartitionedBuilder<>();
            }
    // -------------------------------------------------------------------------  
                    } else {
        limiters.forEach((alias, inst) -> {  
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.LIMIT_CONFIG, (alias, val) -> {
            inFlight.incrementAndGet();
            return new AcquireResult(token, false);
                        + "all requests mapped to it will be rejected.",  
import org.opensearch.common.util.concurrent.ThreadContext;
                }
            cfg.aimdBackoffRatio = val.getAsDouble("backoff_ratio", 0.9);
            sum += pct;
    private final ConcurrentHashMap<String, ActionLimiterInstance> limiters = new ConcurrentHashMap<>();
    // Per-alias mutable config
            }  
            });
     * @param action the transport action name  
        // LimiterRequestContext on the hot path when partitioning is not in use.  
    // -------------------------------------------------------------------------
     * Returns true if an active (non-disabled) limiter is configured for this action.
        double sum = 0.0;  
 * Supported modes: {@code disabled} (default, no-op), {@code monitor_only} (tracks
    // -------------------------------------------------------------------------  
        }  
            resolverType = ConcurrencyLimitResolverType.fromName(resolverName);
    }  
            (alias, tuple) -> {
        Settings burstConfig = ConcurrencyLimitSettings.BURST_CONFIG.getConcreteSettingForNamespace(alias).get(s);  
        }, (alias, val) -> ConcurrencyLimitSettings.validateLimitConfig(val));
            aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig()).algorithm = val;
            try {  
            cfg.gradient2RttTolerance = val.getAsDouble("rtt_tolerance", 1.5);
        for (String alias : aliases) {
        Map<String, ActionLimiterInstance> newMap = new HashMap<>();
                newMap.put(inst.getActionName(), inst);
                state.set(null);  
import java.util.function.Supplier;
                public void onIgnore() {  
                    lastRttMs = ((Gradient2Limit) limit).getLastRtt(TimeUnit.MILLISECONDS);  
                LimitAlgorithm algo = LimitAlgorithm.valueOf(cfg.algorithm.toUpperCase(Locale.ROOT));
                    "Partition [{}] for alias [{}] has 0%% capacity (no percent configured); "
                    rttNoLoadMs = ((Gradient2Limit) limit).getRttNoLoad(TimeUnit.MILLISECONDS);
            return rejected;  
                    .initialLimit(cfg.initialLimit)
    // Registry state  
    // -------------------------------------------------------------------------
         * @param snapshotSupplier supplies the live snapshot for the alias */  
                    .upDriftFactor(cfg.vegasUpDriftFactor)
            return new ActionLimiterSnapshot(  
    }
    };
            if (cfg.mode != ConcurrencyLimitMode.DISABLED) {
            notifyMetricsListener(alias);
                mode.getName(),  
    }
        for (String partitionName : cfg.partitions) {
            long lastRttMs = -1L;
    // Internal
import org.opensearch.concurrency.limit.BurstAwareLimit;
            Limit build(AliasConfig cfg) {
            ConcurrencyLimitSettings.PARTITIONS,
    /**
            long delayMs = partConfig.getAsLong(partitionName + ".delay_ms", 0L);
                    "Failed to apply concurrency limit config for alias [{}] action [{}]; " + "keeping previous configuration. Error: {}",
            listener.onInactive(alias);
        }  
    private void rebuildReverseMap() {  
            this.limiter = limiter;  
                    cfg.actionName,
                    .decreaseHysteresis(cfg.vegasDecreaseBarrier)  
     */
     * Attempts to acquire a concurrency token for the given action in a single atomic lookup.
            return warmedUp;
            if (delayMs > 0) {
                    .build();
                            "Request rejected for alias [{}] action [{}]: limit={} [base={}, burst={}] inFlight={}",
        cfg.maxLimit = limitConfig.getAsInt("max", 200);
import java.util.concurrent.atomic.AtomicLong;  
        volatile double aimdBackoffRatio = 0.9;
        }  
                            inFlight.get()
            onAliasReconfigured(alias, cfg);
            } catch (RuntimeException e) {
        private volatile ConcurrencyLimitMode mode;  
            this.actionName = cfg.actionName;
import org.opensearch.action.ActionConcurrencyLimiterStats;  
        }, (alias, val) -> ConcurrencyLimitSettings.validateGradient2Config(val));  
            if (newState != null) {
        boolean isAcquired() {  
        return AcquireResult.acquired(token.get());  
        private volatile boolean partitioned;
                        );  
                newState = new LimiterState(limit, limiter, cfg.warmupMillis);
 * <p>  
                            inFlight.get()
        cfg.partitions = ConcurrencyLimitSettings.PARTITIONS.getConcreteSettingForNamespace(alias).get(s);
        boolean reconfigured = true;
            return actionName;
        boolean isWarmedUp() {
                    rttNoLoadMs = ((OpenSearchVegasLimit) limit).getRttNoLoad(TimeUnit.MILLISECONDS);  
        void onInactive(String alias);
                return Gradient2Limit.newBuilder()
        cfg.mode = ConcurrencyLimitMode.fromName(ConcurrencyLimitSettings.MODE.getConcreteSettingForNamespace(alias).get(s));  
                    inner.onSuccess();
     * plugin's telemetry-aware {@code createComponents}.
    }
                    return Optional.of(NOOP_LISTENER);
            throw new IllegalArgumentException("Unknown partition resolver [" + resolverName + "] for alias [" + cfg.actionName + "]");  
            limiters.remove(alias);  
        boolean isRejected() {
        Settings aimdConfig = ConcurrencyLimitSettings.AIMD_CONFIG.getConcreteSettingForNamespace(alias).get(s);  
    final class ActionLimiterInstance {  
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
     * {@code NodeStats}) reports, so both telemetry paths publish identical numbers.
    public synchronized void setMetricsListener(MetricsListener listener) {  
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.VEGAS_CONFIG, (alias, val) -> {
                    totalRejected.incrementAndGet();  
        this.threadContext = threadContext;  
                        LOG.debug(
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
                Limiter<LimiterRequestContext> limiter = buildLimiter(limit, cfg);
        }
    }
 * <p>  
        return inst != null && inst.getMode() != ConcurrencyLimitMode.DISABLED && !inst.getActionName().isEmpty();  
        limiters.values().forEach(inst -> snapshots.add(inst.snapshot()));
                state.set(newState);
            onAliasReconfigured(alias, cfg);  
        },
                if (LOG.isDebugEnabled()) {
            }
 * this file be licensed under the Apache-2.0 license or a
            if (s != null) {  
        ConcurrencyLimitMode getMode() {
        }, (alias, val) -> {});
    }  
        boolean isNoLimiter() {
    // -------------------------------------------------------------------------
        cfg.aimdBackoffRatio = aimdConfig.getAsDouble("backoff_ratio", 0.9);
            cfg.burstCapacity = val.getAsInt("capacity", 0);
     * @param threadContext the thread context for header propagation  
            LimiterState s = state.get();
        PartitionedBuilder<ContextT>,
                return OpenSearchVegasLimit.newBuilder()
 * <pre>  
                if (cfg.burstCapacity > 0) {
        if (inst == null) return AcquireResult.NO_LIMITER;  
            onAliasReconfigured(alias, cfg);
        Settings limitConfig = ConcurrencyLimitSettings.LIMIT_CONFIG.getConcreteSettingForNamespace(alias).get(s);
    private static boolean isActive(ActionLimiterInstance inst) {
            aliasConfigs.put(alias, cfg);  
            }
            aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig()).mode = ConcurrencyLimitMode.fromName(val);
                    .maxConcurrency(cfg.maxLimit)
        for (Setting<?> s : ConcurrencyLimitSettings.ALL_SETTINGS) {
        GRADIENT2 {
        try {  
                return Optional.empty();  
            this.warmupUntil = System.currentTimeMillis() + warmupMillis;
    // -------------------------------------------------------------------------
                totalRejected.incrementAndGet();
import com.netflix.concurrency.limits.limiter.AbstractPartitionedLimiter;
    static final class AliasConfig {
        } catch (IllegalArgumentException e) {
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
     * Builds a {@link Limiter} for the given limit, wiring up partition resolver
        if (isActive(inst)) {
    // -------------------------------------------------------------------------
    // Metrics listener (push telemetry)  
        volatile int maxLimit = 200;  
                            actionName,
        if (listener == null) return;
import com.netflix.concurrency.limits.limit.GradientLimit;  
        Settings vegasConfig = ConcurrencyLimitSettings.VEGAS_CONFIG.getConcreteSettingForNamespace(alias).get(s);
                    Limit rejLimit = s.limit;  
                            alias,  
        ActionLimiterInstance inst = limiters.get(alias);
        /** Called when an alias becomes inactive (disabled or removed).  
                inFlight.get(),  
    public ActionConcurrencyLimiterRegistry(Settings initialSettings, ClusterSettings clusterSettings, ThreadContext threadContext) {
                    inFlight.decrementAndGet();
     * @param initialSettings the node's initial settings
 * namespace key:
            cfg.vegasIncreaseBarrier = val.getAsInt("increase_barrier", 1);
            @Override  
        }
            return mode;  
import java.util.Locale;
                Limit limit = s.limit;
     */
import java.util.concurrent.atomic.AtomicInteger;
    /** Returns a snapshot of all configured limiter states. */
    }  
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.ACTION_NAME, (alias, val) -> {
            }  
            cfg.vegasUpDriftFactor = val.getAsInt("updrift_factor", 1);  
    // -------------------------------------------------------------------------
        }
        builder.partitionResolver(ctx -> ctx != null ? resolver.resolve(ctx) : null);
                currentLimit,
        Optional<Limiter.Listener> tryAcquire(Task task, ActionRequest request) {
     * to avoid a TOCTOU race with concurrent settings changes.  
                @Override
            AliasConfig cfg = buildConfig(alias, initialSettings);
        static final AcquireResult NO_LIMITER = new AcquireResult(null, false);
        cfg.partitionConfig = ConcurrencyLimitSettings.PARTITION_CONFIG.getConcreteSettingForNamespace(alias).get(s);
        private volatile String actionName;
            }
        volatile ConcurrencyLimitMode mode = ConcurrencyLimitMode.DISABLED;  
        }, (alias, val) -> {});
                @Override
     * from initial settings before the listener was wired). Called once, after construction, from the
        return cfg;  
            warmedUp = warmedUp || warmupUntil <= System.currentTimeMillis();  
                            rejLimit.getLimit(),  
            this.partitioned = newPartitioned;
    // -------------------------------------------------------------------------
import org.opensearch.common.settings.Settings;
                        );
            onAliasReconfigured(alias, cfg);  
            aliases.addAll(((Setting.AffixSetting<?>) s).getNamespaces(initialSettings));
            return token;
            }
import com.netflix.concurrency.limits.Limiter;
        volatile int initialLimit = 20;
            ConcurrencyLimitSettings.PARTITION_CONFIG,  
        }  
            this.limit = limit;
         * @param alias the limiter alias
                // enforced: reject after warmup, pass through during warmup  
                }  
        }, (alias, val) -> ConcurrencyLimitSettings.validateVegasConfig(val));
                reconfigured = false;  
        }
 *
 *   concurrency_limit.action.search.action_name = indices:data/read/search
        }  
            // partition percentages), no instance field is mutated and the caller's try/catch  
                } else if (limit instanceof Gradient2Limit) {
            if (isActive(inst)) {
    private final ThreadContext threadContext;  
        }
        if (listener == null) return;  
            // needs it to resolve a partition. The non-partitioned SimpleLimiter ignores it.
        AIMD {  
     * @param listener the metrics listener to attach, or {@code null} to detach
        limiters.forEach((alias, inst) -> {
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.BURST_CONFIG, (alias, val) -> {  
    static final class AcquireResult {  
            cfg.burstCloseAfter = val.getAsInt("close_after", 5);  
 * Operators configure limiters at runtime via cluster settings using an alias as the
        volatile int vegasDecreaseBarrier = 1;  
                    inner.onDropped();
 * Registry that manages one adaptive concurrency limiter per configured action alias.
    private static final class PartitionedBuilder<ContextT> extends AbstractPartitionedLimiter.Builder<  
                    .initialLimit(cfg.initialLimit)  
            // Build the new state into a local FIRST. If construction throws (e.g. invalid
        cfg.burstCloseAfter = burstConfig.getAsInt("close_after", 5);
            double pct = partConfig.getAsDouble(partitionName + ".percent", 0.0);
        }  
        volatile Settings partitionConfig = Settings.EMPTY;
        }
        return builder.build();  
        private final String alias;
import org.opensearch.common.settings.Setting;
                public void onSuccess() {  
import com.netflix.concurrency.limits.limiter.SimpleLimiter;
                    }  
        LimiterState(Limit limit, Limiter<LimiterRequestContext> limiter, long warmupMillis) {
            LimiterState newState = null;
    public ActionConcurrencyLimiterStats getStats() {  
 * Partitioning: when {@code partitions} is set, the total limit is divided across
        private final AtomicInteger inFlight = new AtomicInteger();  
                if (limit instanceof GradientLimit) {
 *   concurrency_limit.action.search.algorithm   = vegas  
    // Algorithm enum  
}  
                    .backoffRatio(cfg.aimdBackoffRatio)
        }  
            }
                    inFlight.decrementAndGet();
        };
                }  
                cfg.partitionConfig = tuple.v2();
        private final boolean rejected;
    private volatile MetricsListener metricsListener;
        // Load all aliases present in initial settings
 * named sub-pools. A {@link PartitionResolver} maps each request to a partition.
            onAliasReconfigured(alias, aliasConfigs.get(alias));
        public void onIgnore() {}
        public void onDropped() {}
        return actionToInstance.containsKey(action);
                public void onDropped() {  
            onAliasReconfigured(alias, aliasConfigs.get(alias));
        }, (alias, val) -> {});
import java.util.concurrent.ConcurrentHashMap;  
                    .build();
        String getActionName() {  
        /** Called when an alias becomes active or is reconfigured.
                } else if (limit instanceof OpenSearchVegasLimit) {
            // the listener is expected to treat a repeat onActive as a refresh.
            @Override
        ContextT> {
                    .minLimit(1)
                totalRejected.get(),
     * Creates a new registry, loading initial limiter configurations and registering dynamic update consumers.
     */  
            LimiterState s = state.get();  
    private final Set<String> activeAliases = ConcurrentHashMap.newKeySet();  
        }
                onAliasReconfigured(alias, cfg);
        @Override  
                }  
import com.netflix.concurrency.limits.limit.AbstractLimit;
import java.util.concurrent.TimeUnit;
        // True when this limiter is partitioned. Used to avoid allocating a
        PartitionResolver resolver = PartitionResolver.build(resolverType, resolverConfig, threadContext);  
     *
                "Sum of partition percentages for alias [" + cfg.actionName + "] must be <= 1.0 but got " + sum  
            this.warmedUp = false;
            return this;
     */
        cfg.vegasUpDriftFactor = vegasConfig.getAsInt("updrift_factor", 1);
        public void onSuccess() {}
     * @param action the transport action name
        cfg.burstOpenAfter = burstConfig.getAsInt("open_after", 5);  
        }
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.AIMD_CONFIG, (alias, val) -> {  
            if (pct < 0.0 || pct > 1.0) {  
        volatile int burstOpenAfter = 5;
            // guaranteed to be non-null.
    // -------------------------------------------------------------------------
        }
        }  
            if (pct == 0.0) {  
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.GRADIENT2_CONFIG, (alias, val) -> {
    // -------------------------------------------------------------------------
            this.token = token;
        volatile String algorithm = "vegas";
        cfg.initialLimit = limitConfig.getAsInt("initial", 20);  
                throw new IllegalArgumentException("partition [" + partitionName + "] percent must be in [0.0, 1.0] but got " + pct);
                activeAliases.add(alias);
        @Override  
     * Lifecycle callback for a push-telemetry bridge. The registry notifies the listener whenever an
        Limiter.Listener token() {
     * {@code snapshotSupplier} yields the same per-alias values the pull path ({@code snapshot()} →  
 * Any action can be limited — no code change is required to add a new action.
                }
import java.util.Set;
    }
            if (inst.getMode() != ConcurrencyLimitMode.DISABLED && !inst.getActionName().isEmpty()) {  
        return new ActionConcurrencyLimiterStats(snapshots);  
                if (this.mode == ConcurrencyLimitMode.MONITOR_ONLY) {
                    .rttTolerance(cfg.gradient2RttTolerance)
     * @param clusterSettings the cluster settings service for dynamic updates
    }  
import org.apache.logging.log4j.Logger;
            cfg.burstOpenAfter = val.getAsInt("open_after", 5);
                }  
                if (!s.isWarmedUp()) return Optional.of(NOOP_LISTENER);
        final long warmupUntil;
     * and per-partition configuration when partitions are defined.  
        static AcquireResult acquired(Limiter.Listener token) {  
            // leaves this instance fully on its previous configuration.
import com.netflix.concurrency.limits.limit.Gradient2Limit;
        } else {
                }
import org.opensearch.common.settings.ClusterSettings;  
        if (cfg.partitions.isEmpty()) {  
     * @param request the action request
            // Only allocate the context object when the limiter is partitioned and actually  
                    newState.warmedUp = true;
    }
        AliasConfig cfg = new AliasConfig();
        volatile int vegasIncreaseBarrier = 1;
        if (resolverType == ConcurrencyLimitResolverType.NONE) {
        }  
            // Re-fire on every reconfigure so the bridge can refresh tags (mode/algorithm/action);
                    e.getMessage()
    }
                    inner.onIgnore();
        if (cfg.actionName.isEmpty()) {
import com.netflix.concurrency.limits.limit.AIMDLimit;  
            onAliasReconfigured(alias, cfg);
        volatile double vegasBaselineResetLoadThreshold = 0.5;
            onAliasReconfigured(alias, cfg);
    private volatile Map<String, ActionLimiterInstance> actionToInstance = Collections.emptyMap();
                LOG.error(
            }
        }
            },  
import java.util.Optional;
        rebuildReverseMap();  
     * @param task the current task
            Optional<Limiter.Listener> token = s.limiter.acquire(ctx);  
        });  
     *
        }, (alias, val) -> ConcurrencyLimitSettings.validateAimdConfig(val));
 */  
import java.util.HashSet;  
                if (prev != null && prev.isWarmedUp()) {
package org.opensearch.concurrency;
            this.rejected = rejected;  
        boolean warmedUp;
                rttNoLoadMs  
import org.opensearch.action.ActionRequest;
                    cfg.actionName
        cfg.burstCapacity = burstConfig.getAsInt("capacity", 0);
        cfg.vegasDecreaseBarrier = vegasConfig.getAsInt("decrease_barrier", 1);
                );  
        @Override  
            cfg.maxLimit = val.getAsInt("max", 200);
    public AcquireResult tryAcquire(String action, Task task, ActionRequest request) {
            return SimpleLimiter.<LimiterRequestContext>newBuilder().limit(limit).build();
        if (sum > 1.0 + 1e-6) {
                    alias,  
import org.apache.logging.log4j.LogManager;
        private volatile String algorithm;
    // -------------------------------------------------------------------------
 * compatible open source license.
            }
            // another thread reads mode (volatile) and sees a non-disabled value, state is  
        cfg.vegasIncreaseBarrier = vegasConfig.getAsInt("increase_barrier", 1);  
            throw new IllegalArgumentException(
                builder.partitionRejectDelay(partitionName, delayMs, TimeUnit.MILLISECONDS);
        volatile int burstCloseAfter = 5;  
            // All construction succeeded — now commit. Write state BEFORE mode so that if
                    .maxLimit(cfg.maxLimit)  
        clusterSettings.addAffixUpdateConsumer(
        Settings partConfig = cfg.partitionConfig;
                    .increaseHysteresis(cfg.vegasIncreaseBarrier)
    }  
        volatile String actionName = "";
                    .initialLimit(cfg.initialLimit)
 * SPDX-License-Identifier: Apache-2.0
        private final Limiter.Listener token;
        @Override  
        MetricsListener listener = this.metricsListener;
            @Override
    /**  
                lastRttMs,
            this.alias = alias;
        volatile long warmupMillis = TimeValue.timeValueMinutes(5).getMillis();
        Optional<Limiter.Listener> token = inst.tryAcquire(task, request);
            ActionLimiterInstance inst = limiters.computeIfAbsent(alias, ActionLimiterInstance::new);
import org.opensearch.concurrency.limit.OpenSearchVegasLimit;  
    static final class LimiterState {
            cfg.initialLimit = val.getAsInt("initial", 20);
            );
        }, (alias, val) -> {});  
                            effectiveLimit - baseLimit,
            long rttNoLoadMs = -1L;
        // Partition config
            double pct = partConfig.getAsDouble(partitionName + ".percent", 0.0);
            return this == NO_LIMITER;
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.ALGORITHM, (alias, val) -> {
        cfg.gradient2RttTolerance = gradient2Config.getAsDouble("rtt_tolerance", 1.5);  
            onAliasReconfigured(alias, aliasConfigs.get(alias));  
        final Limiter<LimiterRequestContext> limiter;  
        if (reconfigured) {
        ActionLimiterInstance(String alias) {  
        }
                    .build();  
        },
 */  
                LimiterState prev = state.get();  
            return Optional.of(new Limiter.Listener() {
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());  
                        int effectiveLimit = rejLimit.getLimit();  
                Limit limit = algo.build(cfg);  
                }
    }
import java.util.ArrayList;  
        List<ActionLimiterSnapshot> snapshots = new ArrayList<>();
            Limit build(AliasConfig cfg) {  
        this.metricsListener = listener;
            int currentLimit = s != null ? s.limit.getLimit() : 0;  
                    if (rejLimit instanceof BurstAwareLimit) {
        final Limit limit;
         * @param alias the limiter alias */
        clusterSettings.addAffixUpdateConsumer(ConcurrencyLimitSettings.WARMUP_DURATION, (alias, val) -> {
    private AliasConfig buildConfig(String alias, Settings s) {  
     * alias becomes active (configured with a non-disabled mode and an action name) or inactive. The
                );  
        Set<String> aliases = new HashSet<>();  
     * {@link AcquireResult#REJECTED} if the limit is reached, or an acquired result carrying  
     * Concrete builder for partitioned limiters. Extends {@link AbstractPartitionedLimiter.Builder}  
        cfg.algorithm = ConcurrencyLimitSettings.ALGORITHM.getConcreteSettingForNamespace(alias).get(s);
                AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());
    private final ConcurrentHashMap<String, AliasConfig> aliasConfigs = new ConcurrentHashMap<>();  
            (alias, tuple) -> ConcurrencyLimitSettings.validatePartitionConfig(tuple.v1(), tuple.v2())
    /**  
        }
                LOG.warn(
        Settings gradient2Config = ConcurrencyLimitSettings.GRADIENT2_CONFIG.getConcreteSettingForNamespace(alias).get(s);
    // Public API  
        static final AcquireResult REJECTED = new AcquireResult(null, true);
     * Attaches the push-telemetry listener and replays the currently-active aliases (those loaded  
import org.opensearch.action.ActionConcurrencyLimiterStats.ActionLimiterSnapshot;
            listener.onActive(alias, inst::snapshot);  
        private final AtomicReference<LimiterState> state = new AtomicReference<>();
    private static final Limiter.Listener NOOP_LISTENER = new Limiter.Listener() {
     * Primarily for diagnostics and tests — the filter uses {@link #tryAcquire} instead
        if (token.isEmpty()) return AcquireResult.REJECTED;
        volatile double gradient2RttTolerance = 1.5;  
            AliasConfig cfg = aliasConfigs.computeIfAbsent(alias, k -> new AliasConfig());  
        }
                alias,
                    inFlight.decrementAndGet();
     */
                    limit = new BurstAwareLimit((AbstractLimit) limit, cfg.burstCapacity, cfg.burstCloseAfter, cfg.burstOpenAfter);
        boolean isPartitioned() {
import java.util.HashMap;
     * Tri-state result of {@link #tryAcquire}: no limiter configured, token acquired, or rejected.
        }
        }  
            }
    /**  
            Limiter.Listener inner = token.get();  
    public boolean hasLimiterFor(String action) {
        cfg.warmupMillis = ConcurrencyLimitSettings.WARMUP_DURATION.getConcreteSettingForNamespace(alias).get(s).getMillis();
     */
import java.util.concurrent.atomic.AtomicReference;
            return partitioned;
import org.opensearch.common.unit.TimeValue;  
     * Returns {@link AcquireResult#NO_LIMITER} if no limiter is configured,
 *   concurrency_limit.action.search.mode        = enforced
