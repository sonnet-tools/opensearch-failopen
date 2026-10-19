 *     cluster:  
        return indexSettings;  
 *
    public SettingsCombo(String name, Map<String, Object> clusterSettings, Map<String, Object> indexSettings) {
 *       number_of_shards: 2
     * Index-scope settings as declared under {@code index:}. NOTE: only {@code number_of_shards} is
 * combos:
 * compatible open source license.
        return name;
 *       datafusion.reduce.target_partitions: 4  
 * {@code index:}. TODAY it is the ONLY index setting the harness applies: it is read via the typed
 *   prod1s:
    private final Map<String, Object> clusterSettings;
    public String toString() {
    @Override  
 *
    private final Map<String, Object> indexSettings;  
     * applied today (via {@link #numberOfShards()}); other keys are not yet wired into provisioning.  
        this.indexSettings = Collections.unmodifiableMap(indexSettings);
 *
    public Map<String, Object> clusterSettings() {  
    }  
    }
 */  
    }
        this.name = name;  
 * <p>{@code number_of_shards} is a REQUIRED index setting — the universal root knob (it decides
 *     index:
 * {@link #indexSettings()} is currently parsed but NOT applied — wiring the full map through  
 */
        return clusterSettings;
 * defaults: [prod, prod1s]
 *       number_of_shards: 1  
 * <p>A combo IS its settings — there is no knob-token indirection. {@link #clusterSettings()} are
    }
 *     index:
    public String name() {
 * this file be licensed under the Apache-2.0 license or a
 * applied via {@code PUT /_cluster/settings}.  
 * </pre>  
 * whether the plan splits into a coordinator stage), so every combo must declare it under  
import java.util.Collections;
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
        return ((Number) indexSettings.get(NUMBER_OF_SHARDS)).intValue();
 * provisioning is future work for when a second index-scoped knob is added.
    }  
public final class SettingsCombo {
        return name;  
 * <p>Example {@code combos.yaml}:  
 *   prod:  
    public static final String NUMBER_OF_SHARDS = "number_of_shards";
/**
 * {@link #numberOfShards()} and injected at the index {@code PUT}. Any OTHER key in
 *       search.concurrent.max_slice_count: 4
    public Map<String, Object> indexSettings() {
}
    public int numberOfShards() {
package org.opensearch.analytics.qa.planshape;
    /** Cluster-scope settings applied via {@code PUT /_cluster/settings} for this combo. */
 *     cluster: { ... }
 * The OpenSearch Contributors require contributions made to  
    /** The required index setting every combo must declare — the universal root knob. */
 *
     */
/*  
    /**
 * <pre>
 *       analytics.shard_bucket_oversampling_factor: 2.0
    private final String name;
    }  
 * One named combination of plan-shape-affecting settings, loaded from the global
        this.clusterSettings = Collections.unmodifiableMap(clusterSettings);
 * {@code planshape/combos.yaml}. Goldens reference a combo only by {@link #name()}.  
    /** Required shard count for this combo — the universal root knob (split vs no-split). */  
