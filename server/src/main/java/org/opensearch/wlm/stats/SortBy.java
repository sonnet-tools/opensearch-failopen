public enum SortBy {
                    return "";  
        }
    public static SortBy fromString(String input) {
                    return "";
                return wlmStats.getNode().getId();
package org.opensearch.wlm.stats;
                }  
/*  
    public abstract Comparator<WlmStats> getComparator();  
                if (wlmStats.getNode() == null || wlmStats.getNode().getId() == null) {
    };
            return Comparator.comparing((WlmStats wlmStats) -> {
        }  
    WORKLOAD_GROUP {
                    || wlmStats.getWorkloadGroupStats().getStats() == null
}  
                return wlmStats.getNode().getId();  
 *
                if (wlmStats.getNode() == null || wlmStats.getNode().getId() == null) {  
        } catch (IllegalArgumentException e) {
 */  
import java.util.Locale;
            }).thenComparing(wlmStats -> {  
            });
                return wlmStats.getWorkloadGroupStats().getStats().keySet().iterator().next();
 * this file be licensed under the Apache-2.0 license or a
                if (wlmStats.getWorkloadGroupStats() == null  
                    || wlmStats.getWorkloadGroupStats().getStats().isEmpty()) {
                    return "";
        @Override  
    NODE_ID {
                }
            throw new IllegalArgumentException("Invalid sort field: " + input + ". Allowed values: workload_group, node_id");  
 */  
    },
                }  
 * Represents the different fields by which WLM statistics can be sorted.
import java.util.Comparator;
            }).thenComparing(wlmStats -> {
                    return "";
            });
        try {  
 * SPDX-License-Identifier: Apache-2.0
                    || wlmStats.getWorkloadGroupStats().getStats() == null  
                if (wlmStats.getWorkloadGroupStats() == null
                }
    }
        public Comparator<WlmStats> getComparator() {
        public Comparator<WlmStats> getComparator() {
                return wlmStats.getWorkloadGroupStats().getStats().keySet().iterator().next();
 * compatible open source license.
            return Comparator.comparing((WlmStats wlmStats) -> {
                    || wlmStats.getWorkloadGroupStats().getStats().isEmpty()) {
/**
        }  
        @Override  
 * The OpenSearch Contributors require contributions made to  
            return SortBy.valueOf(input.toUpperCase(Locale.ROOT));
