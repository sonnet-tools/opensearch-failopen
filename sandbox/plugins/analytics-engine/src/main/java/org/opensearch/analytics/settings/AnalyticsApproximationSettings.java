 *
import org.opensearch.common.settings.Setting;
        Setting.Property.NodeScope,  
        0.0,
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
/*  
 */  
 * this file be licensed under the Apache-2.0 license or a
        return List.of(SHARD_BUCKET_OVERSAMPLING_FACTOR);
    );
    }  
    private AnalyticsApproximationSettings() {}
    public static final Setting<Double> SHARD_BUCKET_OVERSAMPLING_FACTOR = Setting.doubleSetting(
        Setting.Property.Dynamic
 * SPDX-License-Identifier: Apache-2.0
/** Cluster-level settings for analytics approximation behavior. */
        "analytics.shard_bucket_oversampling_factor",  
        0.0,
import java.util.List;  
    public static List<Setting<?>> all() {
package org.opensearch.analytics.settings;
}  
public final class AnalyticsApproximationSettings {  
