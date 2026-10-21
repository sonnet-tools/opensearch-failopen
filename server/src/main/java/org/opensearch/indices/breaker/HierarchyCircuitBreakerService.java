        public MemoryUsage overLimit(MemoryUsage memoryUsed) {
import org.opensearch.common.Booleans;
        0.0d,
package org.opensearch.indices.breaker;
        assert youngBeans.size() == 1;
                    + parentLimit
            long regionSize = Long.highestOneBit(regionSizeUnrounded);
            long breakerUsed = (long) (breaker.getUsed() * breaker.getOverhead());
import org.opensearch.common.settings.ClusterSettings;
    public static final Setting<ByteSizeValue> TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING = Setting.memorySizeSetting(
            // child circuit breakers is categorized as transient or permanent.
            }).collect(Collectors.joining(", ")));
import org.apache.logging.log4j.Logger;
            long regionSizeUnrounded = Math.min(
            this.totalUsage = totalUsage;
            long minimumInterval,
    );
            this.baseUsage = baseUsage;
    }
                    }
    public CircuitBreaker getBreaker(String name) {
            return new G1OverLimitStrategy(
 * Unless required by applicable law or agreed to in writing,
        // Validate the settings
 * CircuitBreakerService that attempts to redistribute space between breakers
                    CircuitBreaker.Durability.TRANSIENT
    }
        return new AllCircuitBreakerStats(allStats.toArray(new CircuitBreakerStats[0]));
    private final AtomicLong parentTripCount = new AtomicLong(0);
    private final Map<String, Supplier<CircuitBreakerStats>> statsSuppliers;
}
            // JDK-17 updates:
     */
    public static final Setting<Double> IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING = Setting.doubleSetting(
        Property.Dynamic,
        Property.Dynamic,
                            } else {
                }
    public static final Setting<Double> FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING = Setting.doubleSetting(
            new CircuitBreakerStats(CircuitBreaker.PARENT, parentSettings.getLimit(), memoryUsed(0L).totalUsage, 1.0, parentTripCount.get())
     * Kicks in G1GC if heap gets too high
            this::validateTotalCircuitBreakerLimit
            }
        final long baseUsage;
            // https://hg.openjdk.java.net/jdk/jdk14/file/6c954123ee8d/src/hotspot/share/gc/g1/heapRegion.cpp#l65
            CircuitBreaker.Type.PARENT,
        if (trackRealMemoryUsage && jvmInfo.useG1GC().equals("true")
                Integer.parseInt(System.getProperty("opensearch.real_memory_circuit_breaker.g1_over_limit_strategy.lock_timeout_ms", "500"))
        CircuitBreaker.Type::parseValue,
            }
            FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING,
                    REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.get(settings).getBytes(),
import java.lang.management.GarbageCollectorMXBean;
            this.parentTripCount.incrementAndGet();
        Function<Boolean, OverLimitStrategy> overLimitStrategyFactory
                    memoryUsed.permanentChildUsage
        } else {
        "indices.breaker.request.type",
    private MemoryUsage memoryUsed(long newBytesReserved) {
        childCircuitBreakers.put(
    }
 * The OpenSearch Contributors require contributions made to
            }
                    + "/"
        final long transientChildUsage;
            )
                )
            breaker.getUsed(),
            logger.info("Cannot determine current memory usage due to JDK-8207200.", ex);
        "indices.breaker.request.overhead",
            // recently determined memory usage, we would overestimate memory usage immediately after a garbage collection event.
                if (leader) {
    public static final Setting<CircuitBreaker.Type> FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING = new Setting<>(
        Property.Dynamic,
 * @opensearch.internal
 * software distributed under the License is distributed on an
import org.opensearch.common.unit.TimeValue;
            LongSupplier gcCountSupplier,
            return new MemoryUsage(current, current + newBytesReserved, transientUsage, permanentUsage);
            return new MemoryUsage(parentEstimated, parentEstimated, transientUsage, permanentUsage);
                    + new ByteSizeValue(parentLimit)
            // https://bugs.openjdk.java.net/browse/JDK-8241670
        clusterSettings.addSettingsUpdateConsumer(
            long g1RegionSize = jvmInfo.getG1RegionSize();
 * if tripped
import static org.opensearch.indices.breaker.BreakerSettings.CIRCUIT_BREAKER_LIMIT_SETTING;
    @Override
    @Override
    }
        private final LongSupplier timeSupplier;
     *
import org.opensearch.core.common.breaker.CircuitBreaker;
            if (childSettings.getOverhead() < 0) {
                    long begin = timeSupplier.getAsLong();
                this.g1RegionSize = g1RegionSize;
        CircuitBreaker.Type::parseValue,
        private long blackHole;
            int allocationIndex = 0;
        Property.NodeScope
        BreakerSettings newParentSettings = new BreakerSettings(
import java.util.Collections;
                        memoryUsed.baseUsage,
        "indices.breaker.request.limit",
                        blackHole += localBlackHole;
            message.append(this.breakers.entrySet().stream().map(e -> {
        this.parentSettings = new BreakerSettings(
            IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING,
import org.opensearch.common.settings.Settings;
                HierarchyCircuitBreakerService::realMemoryUsage,
                        allocationIndex,
            null
            this.currentMemoryUsageSupplier = currentMemoryUsageSupplier;
            breaker.getOverhead(),
                            localBlackHole += new byte[allocationSize].hashCode();
            // https://github.com/openjdk/jdk17u/blob/master/src/hotspot/share/gc/g1/heapRegion.cpp#L67
        private final LongSupplier currentMemoryUsageSupplier;
 *
            }
        );
            (limit, overhead) -> updateCircuitBreakerSettings(CircuitBreaker.IN_FLIGHT_REQUESTS, limit, overhead)
        Property.NodeScope
 * under the License.
            return regionSize;
    public static final Setting<CircuitBreaker.Type> REQUEST_CIRCUIT_BREAKER_TYPE_SETTING = new Setting<>(
                            if (current >= maxUsageObserved) {
import static org.opensearch.indices.breaker.BreakerSettings.CIRCUIT_BREAKER_OVERHEAD_SETTING;
                breakerSettings.getName()
     * If an incoming request would cause the field data cache to exceed this size, the request is cancelled.
                        long maxUsageObserved = memoryUsed.baseUsage;
    );
                            }
                LogManager.getLogger(CHILD_LOGGER_PREFIX + breakerSettings.getName()),
        );
        final long totalUsage;
    private void updateCircuitBreakerSettings(String name, ByteSizeValue newLimit, Double newOverhead) {
            TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.get(settings).getBytes(),
                    memoryUsed.transientChildUsage,
                System::currentTimeMillis,
        allStats.add(
        childCircuitBreakers.put(
        Property.Dynamic,
    /**
            final StringBuilder message = new StringBuilder(
import java.util.function.Function;
 * GitHub history for details.
        List<GarbageCollectorMXBean> youngBeans = ManagementFactory.getGarbageCollectorMXBeans()
    );
            allStats.add(stats(breaker.getName()));
                    memoryUsed.totalUsage - memoryUsed.baseUsage + current,
        );
    static LongSupplier createYoungGcCountSupplier() {
            if (regionSize != regionSizeUnrounded) {
                        long localBlackHole = 0;
        "indices.breaker.total.limit",
 */
            (name, updatedValues) -> updateCircuitBreakerSettings(name, updatedValues.v1(), updatedValues.v2()),
    private final boolean trackRealMemoryUsage;
                    + label
                final long breakerUsed = (long) (breaker.getUsed() * breaker.getOverhead());
    );
                message.append("]");
                    if (leader) {
     * Validate that child settings are valid
        private final TimeValue lockTimeout;
            final long current = currentMemoryUsageSupplier.getAsLong();
        );
                transientUsage += breakerUsed;
            CircuitBreaker.Durability durability = memoryUsed.transientChildUsage >= memoryUsed.permanentChildUsage
        private final long maxHeap;
                permanentUsage += breakerUsed;
        clusterSettings.addSettingsUpdateConsumer(
    /**
                        logger.info("attempting to trigger G1GC due to high heap usage [{}]", memoryUsed.baseUsage);
            breaker.getName(),
                    "More than one circuit breaker with the name ["
            throw new CircuitBreakingException(message.toString(), memoryUsed.totalUsage, parentLimit, durability);
        @Override
        Property.NodeScope
            breaker.getTrippedCount()
import java.util.Map;
        0.0d,
                    REQUEST_CIRCUIT_BREAKER_TYPE_SETTING.get(settings),
        );
                )
            )
                    CircuitBreaker.Durability.TRANSIENT
/*
        return this.breakers.get(name);
 * this work for additional information regarding copyright
                    logger.info(
                regionSize = ByteSizeUnit.MB.toBytes(1);
                        long initialCollectionCount = gcCountSupplier.getAsLong();
            if (breakerSettings.getStatsSupplier() != null) {
    }
            message.append(", usages [");
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import java.util.function.LongSupplier;
 */
                return e.getKey() + "=" + breakerUsed + "/" + new ByteSizeValue(breakerUsed);
        }
        long permanentUsage = 0;
        }
import java.util.stream.Collectors;
 * KIND, either express or implied.  See the License for the
            if (regionSize < ByteSizeUnit.MB.toBytes(1)) {
    }
                );
    static long realMemoryUsage() {
        ) {
        Property.NodeScope
 * compatible open source license.
            if (current < memoryUsed.baseUsage) {
            // derive durability of a tripped parent breaker depending on whether the majority of memory tracked by
import org.opensearch.core.indices.breaker.AllCircuitBreakerStats;
        "network.breaker.inflight_requests.type",
            validateAndCreateBreaker(
        clusterSettings.addSettingsUpdateConsumer(
                    + new ByteSizeValue(memoryUsed.totalUsage)
        );
    public static final Setting<ByteSizeValue> IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING = Setting.memorySizeSetting(
                return new MemoryUsage(
            && Booleans.parseBoolean(System.getProperty("opensearch.real_memory_circuit_breaker.g1_over_limit_strategy.enabled"), true)) {
 */
        private final long g1RegionSize;
                    CircuitBreaker.Durability.PERMANENT
                this,
                    FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING.get(settings),
        }
     * @opensearch.internal
    ) {
    }
            logger.warn("Unable to find young generation collector, G1 over limit strategy might be impacted [{}]", youngBeans);
        "indices.breaker.total.use_real_memory",
                // fallthrough
            TimeValue lockTimeout = TimeValue.timeValueMillis(
                        "GC did bring memory usage down, before [{}], after [{}], allocations [{}], duration [{}]",
        }
        return realMemoryUsage();
    @Override
        // estimations for each individual breaker
    }
                new BreakerSettings(
            } else {
import java.util.concurrent.atomic.AtomicLong;
                );
                Thread.currentThread().interrupt();
    }
        settings -> {
        "indices.breaker.fielddata.overhead",
                ByteSizeUnit.MB.toBytes(32)
        } else {
     */
        "100%",
                breakerSettings,
        }
                }
            CIRCUIT_BREAKER_OVERHEAD_SETTING,
                )
    public CircuitBreakerStats stats(String name) {
            final long current = currentMemoryUsage();
 * this file be licensed under the Apache-2.0 license or a
            this.permanentChildUsage = permanentChildUsage;
            if (this.trackRealMemoryUsage) {
            );
            (limit, overhead) -> updateCircuitBreakerSettings(CircuitBreaker.FIELDDATA, limit, overhead)
                // prefer original measurement when reporting if heap usage was not brought down.
        // Gather the "estimated" count for the parent breaker by adding the
            validateAndCreateBreaker(
                                break;
                regionSize = ByteSizeUnit.MB.toBytes(32);
import org.opensearch.core.common.unit.ByteSizeUnit;
        final long permanentChildUsage;
                        + "] exists. Circuit breaker names must be unique"
    );
    public static final Setting<CircuitBreaker.Type> IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_TYPE_SETTING = new Setting<>(
            // https://hg.openjdk.java.net/jdk/jdk/file/e7d0ec2d06e8/src/hotspot/share/gc/g1/heapRegion.cpp#l67
            } else {
    private volatile BreakerSettings parentSettings;
import org.opensearch.monitor.jvm.JvmInfo;
            if (USE_REAL_MEMORY_USAGE_SETTING.get(settings)) {
                    );
        }
        JvmInfo jvmInfo = JvmInfo.jvmInfo();
            // This exception can happen (rarely) due to a race condition in the JVM when determining usage of memory pools. We do not want
            } catch (InterruptedException e) {
        void overLimitTriggered(boolean leader) {
        );
        // messing with GC is "dangerous" so we apply an escape hatch. Not intended to be used.
                        }
        if (youngBeans.size() == 1) {
                        logger.trace("black hole [{}]", blackHole);
        ClusterSettings clusterSettings,
        Property.Dynamic,
            // mimick JDK calculation based on JDK 14 source:
        Property.NodeScope
        } else {
public class HierarchyCircuitBreakerService extends CircuitBreakerService {
            LongSupplier timeSupplier,
            this.maxHeap = jvmInfo.getMem().getHeapMax().getBytes();
        this.overLimitStrategy = overLimitStrategyFactory.apply(this.trackRealMemoryUsage);
            null
            assert minimumInterval > 0;
                        // number of allocations, corresponding to (approximately) number of free regions + 1
            }
                        int allocationSize = (int) (g1RegionSize >> 1);
        Property.NodeScope
            this.transientChildUsage = transientChildUsage;
    public static final Setting<ByteSizeValue> FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING = Setting.memorySizeSetting(
        logger.trace(() -> new ParameterizedMessage("parent circuit breaker with settings {}", this.parentSettings));
                message.append("/");
                    current,
 * Modifications Copyright OpenSearch Contributors. See
                    IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.get(settings).getBytes(),
            CircuitBreaker.REQUEST,
    private static final Logger logger = LogManager.getLogger(HierarchyCircuitBreakerService.class);
        // Manually add the parent breaker settings since they aren't part of the breaker map
            JvmInfo jvmInfo,
                message.append("/");
                Math.max(JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() / 2048, ByteSizeUnit.MB.toBytes(1)),
                    + " would be ["
        List<BreakerSettings> customBreakers,
        this.trackRealMemoryUsage = USE_REAL_MEMORY_USAGE_SETTING.get(settings);
            );
    public void checkParentLimit(long newBytesReserved, String label) throws CircuitBreakingException {
            validateAndCreateBreaker(
    );
    }
                    overLimitTriggered(leader);
        }
    HierarchyCircuitBreakerService(
            logger.debug(() -> new ParameterizedMessage("{}", message.toString()));
 * SPDX-License-Identifier: Apache-2.0
            .stream()
    public HierarchyCircuitBreakerService(Settings settings, List<BreakerSettings> customBreakers, ClusterSettings clusterSettings) {
        Property.Dynamic,
 * You may obtain a copy of the License at
                        // allocations of half-region size becomes single humongous alloc, thus taking up a full region.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        "memory",
        long transientUsage = 0;
                        this.lastCheckTime = now;
    /**
        List<CircuitBreakerStats> allStats = new ArrayList<>(this.breakers.size());
            }
 *
    static OverLimitStrategy createOverLimitStrategy(boolean trackRealMemoryUsage) {
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
            // If the child is disabled, ignore it
            return supplier.get();
            return () -> -1;
import org.opensearch.common.settings.Setting;
        }
            long allocationDuration = 0;
                if (locked != null) {
        "network.breaker.inflight_requests.limit",
            this.timeSupplier = timeSupplier;
    private void validateTotalCircuitBreakerLimit(ByteSizeValue byteSizeValue) {
            } else {
            breaker.getLimit(),
        static long fallbackRegionSize(JvmInfo jvmInfo) {
    // Tripped count for when redistribution was attempted but wasn't successful
        if (memoryUsed.totalUsage > parentLimit && overLimitStrategy.overLimit(memoryUsed).totalUsage > parentLimit) {
import org.opensearch.core.common.breaker.CircuitBreakingException;
                regionSize <<= 1; /* next power of 2 */
                        allocationDuration
        true,
 * Licensed to Elasticsearch under one or more contributor
                        + breakerSettings.getName()
                final long realUsage = memoryUsed.baseUsage;
        );
        0.0d,
                message.append(newBytesReserved);
    private static final String CHILD_LOGGER_PREFIX = "org.opensearch.indices.breaker.";
                message.append("], new bytes reserved: [");
                throw new IllegalArgumentException(
    }
 */
        assert youngBeans.get(0).getCollectionCount() != -1 : "G1 must support getting collection count";
                        current,
            }
    // package private to allow overriding it in tests
            // notice that newer JDKs will have a slight variant only considering max-heap:
                    REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING.get(settings),
                ? CircuitBreaker.Durability.TRANSIENT
        );
    private CircuitBreaker validateAndCreateBreaker(BreakerSettings breakerSettings) {
            TimeValue lockTimeout
            )
            (s, t) -> {}
                    + ", which is larger than the limit of ["
                : CircuitBreaker.Durability.PERMANENT;
        } catch (IllegalArgumentException ex) {
    public long getParentLimit() {
            CircuitBreaker.FIELDDATA,
            .collect(Collectors.toList());
import org.apache.logging.log4j.message.ParameterizedMessage;
        Property.NodeScope
                        allocationIndex,
        for (CircuitBreaker breaker : this.breakers.values()) {
            );
        1.03d,
                5000,
        );
        try {
            return youngBeans.get(0)::getCollectionCount;
/*
        "memory",
    }
    long currentMemoryUsage() {
    );
        "40%",
        Property.NodeScope
        validateSettings(new BreakerSettings[] { newParentSettings });
            TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING,
                throw new IllegalStateException("Child breaker overhead " + childSettings + " must be non-negative");
import org.apache.logging.log4j.LogManager;
        2.0d,
            IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING,
                return "95%";
            childBreaker.setLimitAndOverhead(newLimit.getBytes(), newOverhead);
 * the Apache License, Version 2.0 (the "License"); you may
                    );
                suppliers.put(breakerSettings.getName(), breakerSettings.getStatsSupplier());
                    FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.get(settings).getBytes(),
        Property.NodeScope
                        for (; allocationIndex < allocationCount; ++allocationIndex) {
                        current,
import org.opensearch.common.breaker.ChildMemoryCircuitBreaker;
        private final LongSupplier gcCountSupplier;
                message.append(", real usage: [");
                return memoryUsed;
    }
            1.0,
        return breakerSettings.getType() == CircuitBreaker.Type.NOOP
        final MemoryUsage memoryUsed = memoryUsed(newBytesReserved);
 * license agreements. See the NOTICE file distributed with
                    logger.info(
        if (supplier != null) {
            ? new NoopCircuitBreaker(breakerSettings.getName())
            CircuitBreaker.IN_FLIGHT_REQUESTS,
            } else if (breaker.getDurability() == CircuitBreaker.Durability.PERMANENT) {
        childCircuitBreakers.put(
import java.lang.management.MemoryMXBean;
                    leader = begin >= lastCheckTime + minimumInterval;
            return 0;
        long parentLimit = this.parentSettings.getLimit();
                        long now = timeSupplier.getAsLong();
        );
    );
            this::setTotalCircuitBreakerLimit,
            }
        }
import java.util.HashMap;
    public static final Setting<Boolean> USE_REAL_MEMORY_USAGE_SETTING = Setting.boolSetting(
     * Checks whether the parent breaker has been tripped
            return lockTimeout;
                    + "]"
                new BreakerSettings(
            }
    );
    private final OverLimitStrategy overLimitStrategy;
    static class MemoryUsage {
    }
                this.g1RegionSize = fallbackRegionSize(jvmInfo);
        clusterSettings.addAffixUpdateConsumer(
 *
            if (childSettings.getLimit() == -1) {
    interface OverLimitStrategy {
                        "GC did not bring memory usage down, before [{}], after [{}], allocations [{}], duration [{}]",
            this.lockTimeout = lockTimeout;
                createYoungGcCountSupplier(),
        for (BreakerSettings breakerSettings : customBreakers) {
        }
                    CircuitBreaker.FIELDDATA,
    );
        }
            1.0,
            if (g1RegionSize <= 0) {
        private final ReleasableLock lock = new ReleasableLock(new ReentrantLock());
        if (childBreaker != null) {
                new BreakerSettings(
            REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING,
            }
import org.opensearch.monitor.jvm.GcNames;
        for (CircuitBreaker breaker : this.breakers.values()) {
        for (BreakerSettings childSettings : childrenSettings) {
                lockTimeout
/*
                if (leader) {
    private static final MemoryMXBean MEMORY_MX_BEAN = ManagementFactory.getMemoryMXBean();
        return new CircuitBreakerStats(
        HashMap<String, CircuitBreaker> childCircuitBreakers = new HashMap<>();
        "network.breaker.inflight_requests.overhead",
            long parentEstimated = transientUsage + permanentUsage;
        }
            CircuitBreaker.PARENT,
            LongSupplier currentMemoryUsageSupplier,
            .filter(mxBean -> GcNames.getByGcName(mxBean.getName(), mxBean.getName()).equals(GcNames.YOUNG))
                    + "]"
import java.util.ArrayList;
                    CircuitBreaker.IN_FLIGHT_REQUESTS,
            // to fail requests because of this and thus return zero memory usage in this case. While we could also return the most
                message.append(new ByteSizeValue(newBytesReserved));
        CircuitBreaker childBreaker = breakers.get(name);
    );
    /**
import java.util.List;
    private final Map<String, CircuitBreaker> breakers;
            // for tests to override.
                message.append(realUsage);
                            if (initialCollectionCount != gcCountSupplier.getAsLong()) {
                return "70%";
        MemoryUsage overLimit(MemoryUsage memoryUsed);
     * Tracks memory usage
    }
        Property.NodeScope
        Supplier<CircuitBreakerStats> supplier = statsSuppliers.get(name);
                    + "]"
        this(settings, customBreakers, clusterSettings, HierarchyCircuitBreakerService::createOverLimitStrategy);
    static class G1OverLimitStrategy implements OverLimitStrategy {
        CircuitBreaker breaker = this.breakers.get(name);
     *
import java.lang.management.ManagementFactory;
        }
            CIRCUIT_BREAKER_LIMIT_SETTING,
                        memoryUsed.baseUsage,
            // https://github.com/openjdk/jdk17u/blob/master/src/hotspot/share/gc/g1/heapRegionBounds.hpp
        G1OverLimitStrategy(
            assert ex.getMessage().matches("committed = \\d+ should be < max = \\d+");
        }
/**
    }
    }
        private long lastCheckTime = Long.MIN_VALUE;
        );
     */
        CircuitBreaker.Type::parseValue,
            if (breaker.getDurability() == CircuitBreaker.Durability.TRANSIENT) {
            if (childCircuitBreakers.containsKey(breakerSettings.getName())) {
                "[parent] Data too large, data for ["
                    IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_TYPE_SETTING.get(settings),
                            }
    public static final Setting<ByteSizeValue> REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING = Setting.memorySizeSetting(
        }
import org.opensearch.common.util.concurrent.ReleasableLock;
            // hardcode interval, do not want any tuning of it outside code changes.
import org.opensearch.common.settings.Setting.Property;
        MemoryUsage(final long baseUsage, final long totalUsage, final long transientChildUsage, final long permanentChildUsage) {
                    CircuitBreaker.REQUEST,
     */
    public AllCircuitBreakerStats stats() {
    }
        this.breakers = Collections.unmodifiableMap(childCircuitBreakers);
            boolean leader = false;
        private final long minimumInterval;
                            long current = currentMemoryUsageSupplier.getAsLong();
     */
            }
        TimeValue getLockTimeout() {
        }
        clusterSettings.addSettingsUpdateConsumer(
import java.util.function.Supplier;
 *
            byteSizeValue.getBytes(),
                                // we observed a memory drop, so some GC must have occurred
            logger.info("Updated limit {} and overhead {} for {}", newLimit.getStringRep(), newOverhead, name);
                                break;
        Property.NodeScope
                continue;
 * specific language governing permissions and limitations
        Map<String, Supplier<CircuitBreakerStats>> suppliers = new HashMap<>();
            FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING,
        "memory",
            return MEMORY_MX_BEAN.getHeapMemoryUsage().getUsed();
                jvmInfo,
            REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING,
            } else if (regionSize > ByteSizeUnit.MB.toBytes(32)) {
            );
                        allocationDuration
    public static void validateSettings(BreakerSettings[] childrenSettings) throws IllegalStateException {
                                maxUsageObserved = current;
            try (ReleasableLock locked = lock.tryAcquire(lockTimeout)) {
        }
                }
        Settings settings,
            CircuitBreaker.Type.PARENT,
        super();
    public static final Setting<Double> REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING = Setting.doubleSetting(
import org.opensearch.core.indices.breaker.CircuitBreakerService;
            );
            childCircuitBreakers.put(breakerSettings.getName(), validateAndCreateBreaker(breakerSettings));
        },
                final CircuitBreaker breaker = e.getValue();
    }
                message.append(new ByteSizeValue(realUsage));
        this.parentSettings = new BreakerSettings(CircuitBreaker.PARENT, byteSizeValue.getBytes(), 1.0, CircuitBreaker.Type.PARENT, null);
                    + "/"
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
        validateSettings(new BreakerSettings[] { breakerSettings });
            message.append("]");
import org.opensearch.core.common.unit.ByteSizeValue;
        Property.Dynamic,
        "indices.breaker.fielddata.limit",
        this.statsSuppliers = Collections.unmodifiableMap(suppliers);
        "indices.breaker.fielddata.type",
            this.minimumInterval = minimumInterval;
        if (this.trackRealMemoryUsage) {
            (limit, overhead) -> updateCircuitBreakerSettings(CircuitBreaker.REQUEST, limit, overhead)
                    + memoryUsed.totalUsage
 * not use this file except in compliance with the License.
    private void setTotalCircuitBreakerLimit(ByteSizeValue byteSizeValue) {
            this.gcCountSupplier = gcCountSupplier;
                    IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING.get(settings),
                        int allocationCount = Math.toIntExact((maxHeap - memoryUsed.baseUsage) / g1RegionSize + 1);
            }
     * @opensearch.internal
            // based on this JDK "bug":
            : new ChildMemoryCircuitBreaker(
                        allocationDuration = now - begin;
            CircuitBreaker.PARENT,
    /**
            return memoryUsed -> memoryUsed;
        return this.parentSettings.getLimit();
 * ownership. Elasticsearch licenses this file to you under
        "60%",
import java.util.concurrent.locks.ReentrantLock;
                    FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING.get(settings),
        1.0d,
