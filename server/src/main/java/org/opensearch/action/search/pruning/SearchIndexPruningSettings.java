/**
    public static List<Setting<?>> getSettings() {
 * The OpenSearch Contributors require contributions made to  
    /**
 *
     */
     * Returns all pruning settings for registration with cluster settings.
    public static final Setting<Integer> MIN_SHARDS = Setting.intSetting("search.index_pruning.min_shards", 128, 1, Dynamic, NodeScope);  
     */  
    private SearchIndexPruningSettings() {}
}
    }  
     */  
     * Enables coordinator-side index pruning before can-match/query execution.
 * compatible open source license.
/*  
 */  
import java.util.function.Function;
import static org.opensearch.common.settings.Setting.Property.NodeScope;
 * this file be licensed under the Apache-2.0 license or a
    /**
        return List.of(ENABLED, MIN_SHARDS, FIELDS);
        Collections.emptyList(),
        NodeScope
import java.util.List;
 * Cluster settings controlling index-level search pruning.
        Dynamic,  
package org.opensearch.action.search.pruning;
 * SPDX-License-Identifier: Apache-2.0
public final class SearchIndexPruningSettings {
     */
     * Minimum number of shard groups required before pruning is attempted.
     * Query fields eligible for pruning.  
    public static final Setting<Boolean> ENABLED = Setting.boolSetting("search.index_pruning.enabled", false, Dynamic, NodeScope);
 */  
import java.util.Collections;  
    public static final Setting<List<String>> FIELDS = Setting.listSetting(
        "search.index_pruning.fields",  
    /**
    );
        Function.identity(),
    /**  
import static org.opensearch.common.settings.Setting.Property.Dynamic;
import org.opensearch.common.settings.Setting;
