     */  
    /**
     * The minimum took time to allow a query. Set to TimeValue.ZERO to let all data through.
    /**  
        TimeValue tookTime = TimeValue.timeValueNanos(tookTimeNanos);  
import java.util.function.Predicate;  
 */
        if (threshold.compareTo(TimeValue.ZERO) < 0) {  
        }  
    private final Function<V, CachedQueryResult.PolicyValues> cachedResultParser;  
    /**  
     * @param threshold the threshold
 * to decide whether to admit the value.  
            return true;
        try {
import java.util.function.Function;
        this.threshold = threshold;  
     */
            // If we can't read a CachedQueryResult.PolicyValues from the BytesReference, reject the data
    }  
     * @param targetSetting the cluster setting to register a consumer with
        return tookTime.compareTo(threshold) >= 0;
        if (threshold.equals(TimeValue.ZERO)) {  
        }
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.cache.policy.CachedQueryResult;  
            // Skip parsing the took time if this threshold is zero.
            tookTimeNanos = cachedResultParser.apply(data).getTookTimeNanos();  
            throw new IllegalArgumentException("Threshold for TookTimePolicy must be >= 0ms but was " + threshold.getStringRep());
/*
 * The threshold should be set to approximately the time it takes to get a result from the cache tier.
     */
        }
        this.cachedResultParser = cachedResultParser;
    ) {
 */  
        clusterSettings.addSettingsUpdateConsumer(targetSetting, this::setThreshold);
    }
    private void setThreshold(TimeValue threshold) {
     * @return whether to admit the data  
        Setting<TimeValue> targetSetting
 * A cache tier policy which accepts queries whose took time is greater than some threshold.  
 *
    private TimeValue threshold;
     * Constructs a took time policy.  
/**
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
 * The policy accepts values of type V and decodes them into CachedQueryResult.PolicyValues, which has the data needed
     * @param data the input argument
            return false;  
    /**
package org.opensearch.cache.common.policy;
}  
        long tookTimeNanos;
 * Modifications Copyright OpenSearch Contributors. See  
     * Check whether to admit data.
        } catch (Exception e) {
 * @param <V> The type of data consumed by test().
        ClusterSettings clusterSettings,  
        this.threshold = threshold;  
        TimeValue threshold,
    public boolean test(V data) {
     * @param clusterSettings cluster settings  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.unit.TimeValue;  
 */
    public TookTimePolicy(  
public class TookTimePolicy<V> implements Predicate<V> {  
import org.opensearch.common.settings.Setting;
 * compatible open source license.
     * Function which extracts the relevant PolicyValues from a serialized CachedQueryResult
import org.opensearch.common.settings.ClusterSettings;
    }
     * @param cachedResultParser the function providing policy values
        Function<V, CachedQueryResult.PolicyValues> cachedResultParser,
     */
