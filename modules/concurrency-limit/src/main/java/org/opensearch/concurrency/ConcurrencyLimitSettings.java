            resolverType = ConcurrencyLimitResolverType.fromName(resolver);
    /** Vegas algorithm configuration. */
        static final int BURST_CAPACITY = 0;
        if (backoff < 0.5 || backoff >= 1.0) {
import org.opensearch.common.unit.TimeValue;
        SETTING_PREFIX,
                "Unknown partition resolver [" + resolver + "]. Must be one of: byHeader, fixed, bySearchType"
    }
            if (pct < 0.0 || pct > 1.0) {
            throw new IllegalArgumentException("burst.close_after must be >= 1 but got " + closeAfter);
                    + " configured but no partition.resolver set; "
                    + "all requests would route to unknownPartition. Set partition.resolver "
        k -> Setting.groupSetting(k + ".", Property.Dynamic, Property.NodeScope)
        static final int VEGAS_INCREASE_BARRIER = 1;
    public static final Setting.AffixSetting<TimeValue> WARMUP_DURATION = Setting.affixKeySetting(
        SETTING_PREFIX,
 */
    // -------------------------------------------------------------------------
    public static final List<Setting<?>> ALL_SETTINGS = List.of(
        if (incBarrier < 1) {
        }
                ActionConcurrencyLimiterRegistry.LimitAlgorithm.valueOf(v.toUpperCase(Locale.ROOT));
    public static final Setting.AffixSetting<Settings> AIMD_CONFIG = Setting.affixKeySetting(
    public static final Setting.AffixSetting<Settings> VEGAS_CONFIG = Setting.affixKeySetting(
            sum += pct;
        static final int INITIAL_LIMIT = 20;
        if (sum > 1.0 + 1e-6) {
    );
        VEGAS_CONFIG,
        k -> Setting.groupSetting(k + ".", Property.Dynamic, Property.NodeScope)
        SETTING_PREFIX,
        }
            double pct = group.getAsDouble(partitionName + ".percent", 0.0);
        static final int BURST_OPEN_AFTER = 5;
        int openAfter = group.getAsInt("open_after", Defaults.BURST_OPEN_AFTER);
        SETTING_PREFIX,
import org.opensearch.common.settings.Settings;
        "warmup_duration",
        for (String partitionName : partitions) {
        }
        int upDrift = group.getAsInt("updrift_factor", Defaults.VEGAS_UPDRIFT_FACTOR);
import org.opensearch.common.settings.Setting;
            }
 * The OpenSearch Contributors require contributions made to
        double backoff = group.getAsDouble("backoff_ratio", Defaults.AIMD_BACKOFF_RATIO);
            throw new IllegalArgumentException("vegas.increase_barrier must be >= 1 but got " + incBarrier);
        String resolver = group.get("resolver", "");
    /** Common prefix for all concurrency limiter cluster settings. */
                    "partition percent [" + partitionName + ".percent] must be in [0.0, 1.0] but got " + pct
        if (closeAfter < 1) {
    );
        static final TimeValue WARMUP_DURATION = TimeValue.timeValueMinutes(5);
        SETTING_PREFIX,
        PARTITION_CONFIG
        static final double AIMD_BACKOFF_RATIO = 0.9;
        "burst",
    private ConcurrencyLimitSettings() {}
        }
        k -> new Setting<>(k, Defaults.ALGORITHM, v -> {
        "aimd",
    private static final class Defaults {
            if (delay < 0) {
    /** AIMD algorithm configuration. */
            throw new IllegalArgumentException("limit.max must be >= 1 but got " + max);
        int capacity = group.getAsInt("capacity", Defaults.BURST_CAPACITY);
import java.util.function.Function;
 * SPDX-License-Identifier: Apache-2.0
        ConcurrencyLimitResolverType resolverType;
        if (initial < 1) {
            throw new IllegalArgumentException("burst.open_after must be >= 1 but got " + openAfter);
        "vegas",
                    "partition.resolver.fixed.partition [" + target + "] is not in partitions " + partitions
            throw new IllegalArgumentException(
    }
        GRADIENT2_CONFIG,
        SETTING_PREFIX,
            try {
    /** Group setting for partition configuration. */
                );
    }
        static final int VEGAS_DECREASE_BARRIER = 1;
        "gradient2",
        static final double VEGAS_BASELINE_RESET_LOAD_THRESHOLD = 0.5;
    public static final Setting.AffixSetting<Settings> BURST_CONFIG = Setting.affixKeySetting(
        SETTING_PREFIX,
        double rttTolerance = group.getAsDouble("rtt_tolerance", Defaults.GRADIENT2_RTT_TOLERANCE);
                throw new IllegalArgumentException("partition [" + partitionName + ".delay_ms] must be >= 0");
        "partitions",
        if (upDrift < 1) {
        }, Property.Dynamic, Property.NodeScope)
    public static final String SETTING_PREFIX = "concurrency_limit.action.";
    public static final Setting.AffixSetting<Settings> LIMIT_CONFIG = Setting.affixKeySetting(
        k -> Setting.groupSetting(k + ".", Property.Dynamic, Property.NodeScope)
    public static final Setting.AffixSetting<Settings> GRADIENT2_CONFIG = Setting.affixKeySetting(
    /** Gradient2 algorithm configuration. */
            String target = group.getAsSettings("resolver.fixed").get("partition", "default");
            return v.toLowerCase(Locale.ROOT);
        int closeAfter = group.getAsInt("close_after", Defaults.BURST_CLOSE_AFTER);
        SETTING_PREFIX,
        "mode",
    static void validatePartitionConfig(List<String> partitions, Settings group) {
        }
            throw new IllegalArgumentException("vegas.updrift_factor must be >= 1 but got " + upDrift);
    );
    );
        ALGORITHM,
        static final String ACTION_NAME = "";
/*
        SETTING_PREFIX,
        }
    public static final Setting.AffixSetting<String> MODE = Setting.affixKeySetting(
    );
package org.opensearch.concurrency;
        }
        k -> Setting.listSetting(k, List.of(), Function.identity(), Property.Dynamic, Property.NodeScope)
        }
    );
        MODE,
    /** Maps an alias to the transport action name it limits. */
    public static final Setting.AffixSetting<String> ACTION_NAME = Setting.affixKeySetting(
            throw new IllegalArgumentException("aimd.backoff_ratio must be in [0.5, 1.0) but got " + backoff);
    );
        k -> new Setting<>(k, Defaults.MODE, v -> {
        AIMD_CONFIG,
                throw new IllegalArgumentException(
    /** Limiter mode. */
        if (max < 1) {
        int initial = group.getAsInt("initial", Defaults.INITIAL_LIMIT);
            throw new IllegalArgumentException("gradient2.rtt_tolerance must be >= 1.0 but got " + rttTolerance);
    }
    /** All settings registered by this module. */
        }
            } catch (IllegalArgumentException e) {
    /** Limit algorithm: {@code vegas}, {@code gradient2}, or {@code aimd}. */
            throw new IllegalArgumentException("limit.max [" + max + "] must be >= limit.initial [" + initial + "]");
        k -> Setting.timeSetting(k, Defaults.WARMUP_DURATION, TimeValue.timeValueMinutes(0), Property.Dynamic, Property.NodeScope)
        PARTITIONS,
    }
    public static final Setting.AffixSetting<Settings> PARTITION_CONFIG = Setting.affixKeySetting(
                "partitions "
        if (!partitions.isEmpty() && resolverType == ConcurrencyLimitResolverType.NONE) {
        "partition",
    public static final Setting.AffixSetting<List<String>> PARTITIONS = Setting.affixKeySetting(
        static final int MAX_LIMIT = 200;
        }
        double sum = 0.0;
 *
 */
        k -> Setting.simpleString(k, Defaults.ACTION_NAME, Property.Dynamic, Property.NodeScope)
        if (threshold < 0.0 || threshold > 1.0) {
    public static final Setting.AffixSetting<String> ALGORITHM = Setting.affixKeySetting(
        "limit",
    );
                    + "(byHeader or fixed)."
    static void validateLimitConfig(Settings group) {
        double threshold = group.getAsDouble("baseline_reset_load_threshold", Defaults.VEGAS_BASELINE_RESET_LOAD_THRESHOLD);
        SETTING_PREFIX,
    );
            throw new IllegalArgumentException(
        if (openAfter < 1) {
        }, Property.Dynamic, Property.NodeScope)
 * this file be licensed under the Apache-2.0 license or a
    );
            ConcurrencyLimitMode.fromName(v);
    // Validation
public final class ConcurrencyLimitSettings {
        }
        }
import java.util.Locale;
        "action_name",
        }
    // -------------------------------------------------------------------------
        int decBarrier = group.getAsInt("decrease_barrier", Defaults.VEGAS_DECREASE_BARRIER);
        static final double GRADIENT2_RTT_TOLERANCE = 1.5;
/**
        ACTION_NAME,
            );
    );
        if (capacity < 0) {
 * Setting definitions and validation for the concurrency limiter module.
        if (decBarrier < 1) {
        int incBarrier = group.getAsInt("increase_barrier", Defaults.VEGAS_INCREASE_BARRIER);
            throw new IllegalArgumentException("limit.initial must be >= 1 but got " + initial);
            if (!partitions.contains(target)) {
        static final int VEGAS_UPDRIFT_FACTOR = 1;
            throw new IllegalArgumentException("Sum of partition percentages must be <= 1.0 but got " + sum);
    static void validateAimdConfig(Settings group) {
        int max = group.getAsInt("max", Defaults.MAX_LIMIT);
            throw new IllegalArgumentException("burst.capacity must be >= 0 but got " + capacity);
        static final String MODE = ConcurrencyLimitMode.DISABLED.getName();
    static void validateBurstConfig(Settings group) {
                throw new IllegalArgumentException(
        SETTING_PREFIX,
        try {
    }
            throw new IllegalArgumentException("vegas.baseline_reset_load_threshold must be in [0.0, 1.0] but got " + threshold);
        "algorithm",
    /** Group setting for limit bounds: {@code initial} and {@code max}. */
    }
    /** Duration after (re)configuration during which the limiter does not reject requests. */
import org.opensearch.common.settings.Setting.Property;
            long delay = group.getAsLong(partitionName + ".delay_ms", 0L);
        static final int BURST_CLOSE_AFTER = 5;
        }
            }
        static final String ALGORITHM = "vegas";
        if (rttTolerance < 1.0) {
            }
                throw new IllegalArgumentException("Unknown algorithm '" + v + "'. Must be one of: vegas, gradient2, aimd");
        k -> Setting.groupSetting(k + ".", Property.Dynamic, Property.NodeScope)
    static void validateVegasConfig(Settings group) {
        WARMUP_DURATION,
        if (resolverType == ConcurrencyLimitResolverType.FIXED) {
        if (max < initial) {
            throw new IllegalArgumentException("vegas.decrease_barrier must be >= 1 but got " + decBarrier);
    /** Burst configuration. */
                );
 * compatible open source license.
import java.util.List;
        BURST_CONFIG,
        }
        k -> Setting.groupSetting(k + ".", Property.Dynamic, Property.NodeScope)
                    + partitions
        k -> Setting.groupSetting(k + ".", Property.Dynamic, Property.NodeScope)
}
        }
            }
    /** Ordered list of partition names. */
    static void validateGradient2Config(Settings group) {
    );
        }
            return v;
        LIMIT_CONFIG,
        } catch (IllegalArgumentException e) {
            );
