    /**  
    }
                        + breakerSettings.getName()
                }
                        int allocationCount = Math.toIntExact((maxHeap - memoryUsed.baseUsage) / g1RegionSize + 1);
            if (breakerSettings.getStatsSupplier() != null) {
            IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING,  
                                maxUsageObserved = current;  
                    FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING.get(settings),
                    + "]"  
/**
                    if (leader) {  
                        // allocations of half-region size becomes single humongous alloc, thus taking up a full region.  
    public static final Setting<ByteSizeValue> REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING = Setting.memorySizeSetting(  
    // package private to allow overriding it in tests
        MemoryUsage overLimit(MemoryUsage memoryUsed);
        } catch (IllegalArgumentException ex) {  
                    + label  
/*  
    }
        this.statsSuppliers = Collections.unmodifiableMap(suppliers);  
        Property.NodeScope
            // https://bugs.openjdk.java.net/browse/JDK-8241670
        settings -> {
                new BreakerSettings(  
import org.opensearch.core.indices.breaker.CircuitBreakerStats;
    }
 * ownership. Elasticsearch licenses this file to you under  
            LongSupplier gcCountSupplier,
                LogManager.getLogger(CHILD_LOGGER_PREFIX + breakerSettings.getName()),
                }  
            TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING.get(settings).getBytes(),  
import org.opensearch.monitor.jvm.GcNames;
                message.append("]");
 */
            return youngBeans.get(0)::getCollectionCount;
    static class G1OverLimitStrategy implements OverLimitStrategy {  
            }
    }
            this::setTotalCircuitBreakerLimit,
                    FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING.get(settings),  
            this.permanentChildUsage = permanentChildUsage;  
                    + memoryUsed.totalUsage  
        }
        G1OverLimitStrategy(
                    memoryUsed.permanentChildUsage  
 *
    public CircuitBreaker getBreaker(String name) {
        final long baseUsage;  
            .filter(mxBean -> GcNames.getByGcName(mxBean.getName(), mxBean.getName()).equals(GcNames.YOUNG))
import java.lang.management.ManagementFactory;  
            );
        validateSettings(new BreakerSettings[] { breakerSettings });
                new BreakerSettings(  
            long minimumInterval,
    );  
                this.g1RegionSize = g1RegionSize;  
        "indices.breaker.request.type",
                : CircuitBreaker.Durability.PERMANENT;  
                    long begin = timeSupplier.getAsLong();  
        super();
        "indices.breaker.fielddata.limit",
    /**
            }
 * software distributed under the License is distributed on an
        );  
        private long lastCheckTime = Long.MIN_VALUE;
            breaker.getOverhead(),
            return memoryUsed -> memoryUsed;
import org.opensearch.common.breaker.ChildMemoryCircuitBreaker;
     *  
                Thread.currentThread().interrupt();
            long breakerUsed = (long) (breaker.getUsed() * breaker.getOverhead());  
            validateAndCreateBreaker(
    static OverLimitStrategy createOverLimitStrategy(boolean trackRealMemoryUsage) {
/*
            );
 */  
            if (g1RegionSize <= 0) {  
    private void setTotalCircuitBreakerLimit(ByteSizeValue byteSizeValue) {
 * license agreements. See the NOTICE file distributed with
    );
                return memoryUsed;
            return 0;  
        Map<String, Supplier<CircuitBreakerStats>> suppliers = new HashMap<>();  
                message.append(", real usage: [");  
            return new MemoryUsage(current, current + newBytesReserved, transientUsage, permanentUsage);  
        List<BreakerSettings> customBreakers,  
        @Override
            TimeValue lockTimeout = TimeValue.timeValueMillis(  
                }
            breaker.getUsed(),  
        private final LongSupplier currentMemoryUsageSupplier;
                final CircuitBreaker breaker = e.getValue();  
            logger.info("Updated limit {} and overhead {} for {}", newLimit.getStringRep(), newOverhead, name);
                    memoryUsed.transientChildUsage,
            final StringBuilder message = new StringBuilder(
        } else {  
import java.util.stream.Collectors;  
}
        Property.NodeScope  
    static LongSupplier createYoungGcCountSupplier() {
        if (supplier != null) {
            }  
                        long maxUsageObserved = memoryUsed.baseUsage;
        static long fallbackRegionSize(JvmInfo jvmInfo) {
        return breakerSettings.getType() == CircuitBreaker.Type.NOOP  
            boolean leader = false;
        },
 *
import org.apache.logging.log4j.LogManager;
            ? new NoopCircuitBreaker(breakerSettings.getName())
            byteSizeValue.getBytes(),
        }
    );
        private final TimeValue lockTimeout;
     * @opensearch.internal  
                            long current = currentMemoryUsageSupplier.getAsLong();
        Property.NodeScope
        "indices.breaker.total.use_real_memory",
                    + new ByteSizeValue(parentLimit)
    interface OverLimitStrategy {  
                this,
 * Unless required by applicable law or agreed to in writing,
                            } else {
        long transientUsage = 0;
                permanentUsage += breakerUsed;
        }  
            this.timeSupplier = timeSupplier;
    @Override
            message.append("]");
        } else {
            CircuitBreaker.PARENT,
                    + new ByteSizeValue(memoryUsed.totalUsage)
        this.overLimitStrategy = overLimitStrategyFactory.apply(this.trackRealMemoryUsage);  
            return MEMORY_MX_BEAN.getHeapMemoryUsage().getUsed();
                    CircuitBreaker.Durability.PERMANENT
            long regionSizeUnrounded = Math.min(
            long g1RegionSize = jvmInfo.getG1RegionSize();
        "memory",  
        for (BreakerSettings breakerSettings : customBreakers) {
 * specific language governing permissions and limitations
            this.currentMemoryUsageSupplier = currentMemoryUsageSupplier;  
        if (youngBeans.size() == 1) {
    }
        );
            (name, updatedValues) -> updateCircuitBreakerSettings(name, updatedValues.v1(), updatedValues.v2()),
                )  
            breaker.getLimit(),
                            if (initialCollectionCount != gcCountSupplier.getAsLong()) {
            CircuitBreaker.Durability durability = memoryUsed.transientChildUsage >= memoryUsed.permanentChildUsage
        Property.NodeScope
        clusterSettings.addSettingsUpdateConsumer(  
            final long current = currentMemoryUsageSupplier.getAsLong();  
            null
 * @opensearch.internal  
                                break;  
            allStats.add(stats(breaker.getName()));
        // Manually add the parent breaker settings since they aren't part of the breaker map
        // estimations for each individual breaker  
            validateAndCreateBreaker(
import org.opensearch.common.settings.ClusterSettings;  
        "indices.breaker.request.overhead",
                message.append(realUsage);
    private static final String CHILD_LOGGER_PREFIX = "org.opensearch.indices.breaker.";
    static class MemoryUsage {
        "indices.breaker.fielddata.overhead",
                                break;  
                ? CircuitBreaker.Durability.TRANSIENT
        final long permanentChildUsage;  
        }  
    public static void validateSettings(BreakerSettings[] childrenSettings) throws IllegalStateException {
        this.parentSettings = new BreakerSettings(CircuitBreaker.PARENT, byteSizeValue.getBytes(), 1.0, CircuitBreaker.Type.PARENT, null);
            this.maxHeap = jvmInfo.getMem().getHeapMax().getBytes();
                    REQUEST_CIRCUIT_BREAKER_TYPE_SETTING.get(settings),
    }
                message.append(new ByteSizeValue(realUsage));  
     * If an incoming request would cause the field data cache to exceed this size, the request is cancelled.
import java.lang.management.MemoryMXBean;
                    logger.info(
            } else if (regionSize > ByteSizeUnit.MB.toBytes(32)) {
import java.util.ArrayList;
            long parentEstimated = transientUsage + permanentUsage;
        logger.trace(() -> new ParameterizedMessage("parent circuit breaker with settings {}", this.parentSettings));
                this.g1RegionSize = fallbackRegionSize(jvmInfo);
     * Kicks in G1GC if heap gets too high
            // child circuit breakers is categorized as transient or permanent.  
            // hardcode interval, do not want any tuning of it outside code changes.  
                        memoryUsed.baseUsage,  
                    IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING.get(settings),  
        clusterSettings.addSettingsUpdateConsumer(  
import static org.opensearch.indices.breaker.BreakerSettings.CIRCUIT_BREAKER_LIMIT_SETTING;
                    + ", which is larger than the limit of ["
            this.lockTimeout = lockTimeout;
 * Licensed to Elasticsearch under one or more contributor  
            logger.info("Cannot determine current memory usage due to JDK-8207200.", ex);
        Property.NodeScope
                )  
            this.totalUsage = totalUsage;
            return () -> -1;
            if (childSettings.getLimit() == -1) {
            if (regionSize < ByteSizeUnit.MB.toBytes(1)) {  
        assert youngBeans.get(0).getCollectionCount() != -1 : "G1 must support getting collection count";
            } catch (InterruptedException e) {
    public CircuitBreakerStats stats(String name) {  
    private MemoryUsage memoryUsed(long newBytesReserved) {
                    REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING.get(settings).getBytes(),
        private final ReleasableLock lock = new ReleasableLock(new ReentrantLock());  
            // to fail requests because of this and thus return zero memory usage in this case. While we could also return the most
        }
            } else {
                if (locked != null) {
            // derive durability of a tripped parent breaker depending on whether the majority of memory tracked by
                                // we observed a memory drop, so some GC must have occurred
     */
        "network.breaker.inflight_requests.limit",  
            new CircuitBreakerStats(CircuitBreaker.PARENT, parentSettings.getLimit(), memoryUsed(0L).totalUsage, 1.0, parentTripCount.get())  
            (limit, overhead) -> updateCircuitBreakerSettings(CircuitBreaker.FIELDDATA, limit, overhead)
import org.apache.logging.log4j.message.ParameterizedMessage;  
        if (memoryUsed.totalUsage > parentLimit && overLimitStrategy.overLimit(memoryUsed).totalUsage > parentLimit) {
     */
                return new MemoryUsage(
                transientUsage += breakerUsed;
 * You may obtain a copy of the License at  
            } else if (breaker.getDurability() == CircuitBreaker.Durability.PERMANENT) {  
        return this.parentSettings.getLimit();
        // Validate the settings
                new BreakerSettings(  
        assert youngBeans.size() == 1;
    private void updateCircuitBreakerSettings(String name, ByteSizeValue newLimit, Double newOverhead) {  
                    leader = begin >= lastCheckTime + minimumInterval;
        }  
                message.append(new ByteSizeValue(newBytesReserved));
            breaker.getName(),
            this::validateTotalCircuitBreakerLimit  
                message.append(newBytesReserved);
import java.util.Collections;  
                            localBlackHole += new byte[allocationSize].hashCode();
        childCircuitBreakers.put(  
        }
        for (CircuitBreaker breaker : this.breakers.values()) {
                        allocationIndex,
                if (leader) {  
                    "More than one circuit breaker with the name ["
            // https://hg.openjdk.java.net/jdk/jdk/file/e7d0ec2d06e8/src/hotspot/share/gc/g1/heapRegion.cpp#l67
        Property.NodeScope  
                suppliers.put(breakerSettings.getName(), breakerSettings.getStatsSupplier());
        Settings settings,
        }  
            this.minimumInterval = minimumInterval;  
        0.0d,
    private final OverLimitStrategy overLimitStrategy;
    public HierarchyCircuitBreakerService(Settings settings, List<BreakerSettings> customBreakers, ClusterSettings clusterSettings) {  
    public AllCircuitBreakerStats stats() {  
    );  
import org.opensearch.common.unit.TimeValue;
            // https://hg.openjdk.java.net/jdk/jdk14/file/6c954123ee8d/src/hotspot/share/gc/g1/heapRegion.cpp#l65  
    );
            )
        validateSettings(new BreakerSettings[] { newParentSettings });
     */  
import org.opensearch.core.common.breaker.CircuitBreaker;  
        Function<Boolean, OverLimitStrategy> overLimitStrategyFactory
    }
import java.lang.management.GarbageCollectorMXBean;
                        allocationDuration  
                "[parent] Data too large, data for ["
        Property.Dynamic,
                        memoryUsed.baseUsage,
    }
    ) {  
 * Modifications Copyright OpenSearch Contributors. See
                regionSize = ByteSizeUnit.MB.toBytes(32);  
            this.transientChildUsage = transientChildUsage;
            && Booleans.parseBoolean(System.getProperty("opensearch.real_memory_circuit_breaker.g1_over_limit_strategy.enabled"), true)) {
        HashMap<String, CircuitBreaker> childCircuitBreakers = new HashMap<>();
                continue;  
                System::currentTimeMillis,
        Property.Dynamic,
    private static final Logger logger = LogManager.getLogger(HierarchyCircuitBreakerService.class);  
            );
        this.trackRealMemoryUsage = USE_REAL_MEMORY_USAGE_SETTING.get(settings);
        Property.Dynamic,  
        );
 * if tripped
                lockTimeout
                    + parentLimit
        Property.Dynamic,
    );
                final long breakerUsed = (long) (breaker.getUsed() * breaker.getOverhead());
 * not use this file except in compliance with the License.
        // messing with GC is "dangerous" so we apply an escape hatch. Not intended to be used.
    );  
import org.opensearch.common.settings.Setting;
        "indices.breaker.total.limit",
        );
                    current,  
        return new CircuitBreakerStats(  
                    CircuitBreaker.IN_FLIGHT_REQUESTS,
        private final long minimumInterval;  
        for (CircuitBreaker breaker : this.breakers.values()) {
                        long now = timeSupplier.getAsLong();
    }
                );
                        "GC did bring memory usage down, before [{}], after [{}], allocations [{}], duration [{}]",
     */
        void overLimitTriggered(boolean leader) {
            // for tests to override.  
            CircuitBreaker.FIELDDATA,
                breakerSettings,  
     * Validate that child settings are valid  
import java.util.List;
            CircuitBreaker.IN_FLIGHT_REQUESTS,
            REQUEST_CIRCUIT_BREAKER_LIMIT_SETTING,
        clusterSettings.addSettingsUpdateConsumer(
    public static final Setting<Double> IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_OVERHEAD_SETTING = Setting.doubleSetting(
                        blackHole += localBlackHole;
    }  
            1.0,
    public static final Setting<ByteSizeValue> FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING = Setting.memorySizeSetting(
    }  
    @Override
    }
            }  
            // JDK-17 updates:
            if (regionSize != regionSizeUnrounded) {
                return "70%";  
            CircuitBreaker.PARENT,
            );
        childCircuitBreakers.put(  
    private static final MemoryMXBean MEMORY_MX_BEAN = ManagementFactory.getMemoryMXBean();
import java.util.function.Supplier;
            assert ex.getMessage().matches("committed = \\d+ should be < max = \\d+");
    long currentMemoryUsage() {
        );
            CircuitBreaker.Type.PARENT,
                message.append("/");  
        CircuitBreaker.Type::parseValue,
    // Tripped count for when redistribution was attempted but wasn't successful
 * the Apache License, Version 2.0 (the "License"); you may
    public static final Setting<CircuitBreaker.Type> FIELDDATA_CIRCUIT_BREAKER_TYPE_SETTING = new Setting<>(
            FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING,
                message.append("/");
        CircuitBreaker breaker = this.breakers.get(name);
                )  
        Property.NodeScope  
                throw new IllegalArgumentException(  
        private final LongSupplier gcCountSupplier;  
            this.baseUsage = baseUsage;  
                    REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING.get(settings),  
        ) {  
            // notice that newer JDKs will have a slight variant only considering max-heap:
            if (childCircuitBreakers.containsKey(breakerSettings.getName())) {
        }  
                        logger.info("attempting to trigger G1GC due to high heap usage [{}]", memoryUsed.baseUsage);
        private final long maxHeap;  
import org.opensearch.common.util.concurrent.ReleasableLock;
            )
 * GitHub history for details.
                            }
            }).collect(Collectors.joining(", ")));  
                regionSize <<= 1; /* next power of 2 */  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Property.NodeScope
 */
        try {
                breakerSettings.getName()  
    public static final Setting<Boolean> USE_REAL_MEMORY_USAGE_SETTING = Setting.boolSetting(  
        "memory",
            REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING,
        }  
            }
            return lockTimeout;
            return new MemoryUsage(parentEstimated, parentEstimated, transientUsage, permanentUsage);  
                if (leader) {
    /**
 * this file be licensed under the Apache-2.0 license or a
    public static final Setting<Double> FIELDDATA_CIRCUIT_BREAKER_OVERHEAD_SETTING = Setting.doubleSetting(
import java.util.Map;  
        );  
            IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING,
                    + "/"  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (trackRealMemoryUsage && jvmInfo.useG1GC().equals("true")  
import java.util.HashMap;
    @Override  
                    overLimitTriggered(leader);
        );
        Supplier<CircuitBreakerStats> supplier = statsSuppliers.get(name);
                        int allocationSize = (int) (g1RegionSize >> 1);
    }  
            }
     * @opensearch.internal
                return e.getKey() + "=" + breakerUsed + "/" + new ByteSizeValue(breakerUsed);
 * under the License.  
    public static final Setting<CircuitBreaker.Type> REQUEST_CIRCUIT_BREAKER_TYPE_SETTING = new Setting<>(
                );
            JvmInfo jvmInfo,  
    private void validateTotalCircuitBreakerLimit(ByteSizeValue byteSizeValue) {
import java.util.concurrent.atomic.AtomicLong;
                ByteSizeUnit.MB.toBytes(32)
     * Tracks memory usage
        final long totalUsage;
        "100%",
        );
            long regionSize = Long.highestOneBit(regionSizeUnrounded);
    public void checkParentLimit(long newBytesReserved, String label) throws CircuitBreakingException {
        }
    public long getParentLimit() {
        CircuitBreaker.Type::parseValue,
        "indices.breaker.request.limit",
            long allocationDuration = 0;  
            // If the child is disabled, ignore it
import org.opensearch.common.settings.Settings;  
                    memoryUsed.totalUsage - memoryUsed.baseUsage + current,
        "memory",
    private final boolean trackRealMemoryUsage;
    public static final Setting<ByteSizeValue> TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING = Setting.memorySizeSetting(  
        long parentLimit = this.parentSettings.getLimit();
        return new AllCircuitBreakerStats(allStats.toArray(new CircuitBreakerStats[0]));
     */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
            return new G1OverLimitStrategy(
import org.opensearch.common.Booleans;
 * CircuitBreakerService that attempts to redistribute space between breakers  
            // based on this JDK "bug":  
                regionSize = ByteSizeUnit.MB.toBytes(1);
    );
            validateAndCreateBreaker(
        1.03d,  
        childCircuitBreakers.put(  
            }
import java.util.function.LongSupplier;
        // Gather the "estimated" count for the parent breaker by adding the
                    CircuitBreaker.Durability.TRANSIENT
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.indices.breaker.AllCircuitBreakerStats;
     *
        MemoryUsage(final long baseUsage, final long totalUsage, final long transientChildUsage, final long permanentChildUsage) {
import java.util.concurrent.locks.ReentrantLock;
        }
            (s, t) -> {}  
        final MemoryUsage memoryUsed = memoryUsed(newBytesReserved);  
        List<CircuitBreakerStats> allStats = new ArrayList<>(this.breakers.size());
                        allocationDuration = now - begin;
                    + " would be ["
                        logger.trace("black hole [{}]", blackHole);  
                        + "] exists. Circuit breaker names must be unique"  
                    logger.info(  
            TimeValue lockTimeout
                        }  
            return regionSize;
    private final AtomicLong parentTripCount = new AtomicLong(0);
                        "GC did not bring memory usage down, before [{}], after [{}], allocations [{}], duration [{}]",
    }  
        0.0d,  
                        this.lastCheckTime = now;  
        true,
            CircuitBreaker.Type.PARENT,
                            if (current >= maxUsageObserved) {
        TimeValue getLockTimeout() {  
        allStats.add(
        }
    private CircuitBreaker validateAndCreateBreaker(BreakerSettings breakerSettings) {  
                createYoungGcCountSupplier(),
        }
            LongSupplier currentMemoryUsageSupplier,
                jvmInfo,
        Property.Dynamic,  
        private long blackHole;
 * SPDX-License-Identifier: Apache-2.0
        "indices.breaker.fielddata.type",  
        clusterSettings.addAffixUpdateConsumer(
            if (childSettings.getOverhead() < 0) {  
        return this.breakers.get(name);
                5000,  
/*  
                // prefer original measurement when reporting if heap usage was not brought down.  
            FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING,  
            CIRCUIT_BREAKER_OVERHEAD_SETTING,
 */  
            )
            1.0,  
        this(settings, customBreakers, clusterSettings, HierarchyCircuitBreakerService::createOverLimitStrategy);
            LongSupplier timeSupplier,  
            if (USE_REAL_MEMORY_USAGE_SETTING.get(settings)) {  
    }
        Property.NodeScope  
        );  
            if (current < memoryUsed.baseUsage) {
            null  
        }  
    HierarchyCircuitBreakerService(
            this.parentTripCount.incrementAndGet();  
    );
            // recently determined memory usage, we would overestimate memory usage immediately after a garbage collection event.  
                            }
public class HierarchyCircuitBreakerService extends CircuitBreakerService {
            );  
        this.breakers = Collections.unmodifiableMap(childCircuitBreakers);
            breaker.getTrippedCount()
            (limit, overhead) -> updateCircuitBreakerSettings(CircuitBreaker.REQUEST, limit, overhead)  
            return supplier.get();  
     * Checks whether the parent breaker has been tripped  
            } else {
 *
    }  
                    CircuitBreaker.Durability.TRANSIENT
 * compatible open source license.
            (limit, overhead) -> updateCircuitBreakerSettings(CircuitBreaker.IN_FLIGHT_REQUESTS, limit, overhead)
        this.parentSettings = new BreakerSettings(
        0.0d,
 * this work for additional information regarding copyright
        private final LongSupplier timeSupplier;
            }
import org.opensearch.core.common.unit.ByteSizeUnit;  
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
package org.opensearch.indices.breaker;
import java.util.function.Function;  
import static org.opensearch.indices.breaker.BreakerSettings.CIRCUIT_BREAKER_OVERHEAD_SETTING;  
                Integer.parseInt(System.getProperty("opensearch.real_memory_circuit_breaker.g1_over_limit_strategy.lock_timeout_ms", "500"))
        "network.breaker.inflight_requests.type",
    /**
            // mimick JDK calculation based on JDK 14 source:
            }
import org.apache.logging.log4j.Logger;
        for (BreakerSettings childSettings : childrenSettings) {  
            message.append(", usages [");
        }
    public static final Setting<ByteSizeValue> IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING = Setting.memorySizeSetting(
                Math.max(JvmInfo.jvmInfo().getMem().getHeapMax().getBytes() / 2048, ByteSizeUnit.MB.toBytes(1)),  
        } else {  
import org.opensearch.common.settings.Setting.Property;
                // fallthrough  
        1.0d,
                throw new IllegalStateException("Child breaker overhead " + childSettings + " must be non-negative");
    static long realMemoryUsage() {  
            .stream()
    /**
        }
import org.opensearch.core.common.unit.ByteSizeValue;
                HierarchyCircuitBreakerService::realMemoryUsage,  
            assert minimumInterval > 0;
        Property.Dynamic,  
                        allocationIndex,
                    );
    }
                        current,  
            : new ChildMemoryCircuitBreaker(
        List<GarbageCollectorMXBean> youngBeans = ManagementFactory.getGarbageCollectorMXBeans()  
            } else {
        "60%",
    private final Map<String, CircuitBreaker> breakers;  
            logger.warn("Unable to find young generation collector, G1 over limit strategy might be impacted [{}]", youngBeans);
            }
            CIRCUIT_BREAKER_LIMIT_SETTING,  
            final long current = currentMemoryUsage();
 *  
            try (ReleasableLock locked = lock.tryAcquire(lockTimeout)) {
        long permanentUsage = 0;  
            CircuitBreaker.REQUEST,
        "40%",  
        clusterSettings.addSettingsUpdateConsumer(
                    + "]"
import org.opensearch.monitor.jvm.JvmInfo;  
            int allocationIndex = 0;
        Property.NodeScope
    );
            logger.debug(() -> new ParameterizedMessage("{}", message.toString()));
            if (breaker.getDurability() == CircuitBreaker.Durability.TRANSIENT) {
        final long transientChildUsage;
            TOTAL_CIRCUIT_BREAKER_LIMIT_SETTING,
        );
import org.opensearch.core.common.breaker.CircuitBreakingException;
        private final long g1RegionSize;
            message.append(this.breakers.entrySet().stream().map(e -> {
        return realMemoryUsage();  
                message.append("], new bytes reserved: [");
        JvmInfo jvmInfo = JvmInfo.jvmInfo();
        CircuitBreaker.Type::parseValue,  
        if (childBreaker != null) {
        BreakerSettings newParentSettings = new BreakerSettings(  
    }
    }  
                return "95%";
                final long realUsage = memoryUsed.baseUsage;
            childCircuitBreakers.put(breakerSettings.getName(), validateAndCreateBreaker(breakerSettings));  
    private final Map<String, Supplier<CircuitBreakerStats>> statsSuppliers;
                        for (; allocationIndex < allocationCount; ++allocationIndex) {  
            .collect(Collectors.toList());  
            throw new CircuitBreakingException(message.toString(), memoryUsed.totalUsage, parentLimit, durability);
    public static final Setting<Double> REQUEST_CIRCUIT_BREAKER_OVERHEAD_SETTING = Setting.doubleSetting(  
                    }
                        current,
        );
        );
            // This exception can happen (rarely) due to a race condition in the JVM when determining usage of memory pools. We do not want
            childBreaker.setLimitAndOverhead(newLimit.getBytes(), newOverhead);  
            if (this.trackRealMemoryUsage) {
            this.gcCountSupplier = gcCountSupplier;
        CircuitBreaker childBreaker = breakers.get(name);
                    + "/"
        public MemoryUsage overLimit(MemoryUsage memoryUsed) {  
        Property.Dynamic,
                    IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_LIMIT_SETTING.get(settings).getBytes(),
                    + "]"
                    FIELDDATA_CIRCUIT_BREAKER_LIMIT_SETTING.get(settings).getBytes(),
            }
                    CircuitBreaker.FIELDDATA,
                    IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_TYPE_SETTING.get(settings),
    public static final Setting<CircuitBreaker.Type> IN_FLIGHT_REQUESTS_CIRCUIT_BREAKER_TYPE_SETTING = new Setting<>(  
        if (this.trackRealMemoryUsage) {
                        long localBlackHole = 0;  
        ClusterSettings clusterSettings,
    private volatile BreakerSettings parentSettings;
            // https://github.com/openjdk/jdk17u/blob/master/src/hotspot/share/gc/g1/heapRegionBounds.hpp  
                        long initialCollectionCount = gcCountSupplier.getAsLong();
                    CircuitBreaker.REQUEST,
                    );  
        "network.breaker.inflight_requests.overhead",  
                        allocationDuration
                        // number of allocations, corresponding to (approximately) number of free regions + 1
            // https://github.com/openjdk/jdk17u/blob/master/src/hotspot/share/gc/g1/heapRegion.cpp#L67
    );
        2.0d,
            }
        Property.NodeScope
