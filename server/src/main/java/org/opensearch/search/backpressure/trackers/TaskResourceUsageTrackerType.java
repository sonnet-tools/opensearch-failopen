 *
/*  
            case "native_memory_usage_tracker":
        this.name = name;
}
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
        throw new IllegalArgumentException("Invalid TaskResourceUsageTrackerType: " + name);
            case "cpu_usage_tracker":
        }  
 * this file be licensed under the Apache-2.0 license or a
    }
    public String getName() {
                return CPU_USAGE_TRACKER;
    ELAPSED_TIME_TRACKER("elapsed_time_tracker"),
            case "heap_usage_tracker":  
        switch (name) {  
    }  
 */  
public enum TaskResourceUsageTrackerType {
        return name;
    CPU_USAGE_TRACKER("cpu_usage_tracker"),
                return HEAP_USAGE_TRACKER;
 */  
 * Defines the type of TaskResourceUsageTracker.
    TaskResourceUsageTrackerType(String name) {  
    private final String name;
 * SPDX-License-Identifier: Apache-2.0
    }  
            case "elapsed_time_tracker":
package org.opensearch.search.backpressure.trackers;
    HEAP_USAGE_TRACKER("heap_usage_tracker"),  
    NATIVE_MEMORY_USAGE_TRACKER("native_memory_usage_tracker");
                return ELAPSED_TIME_TRACKER;  
/**
                return NATIVE_MEMORY_USAGE_TRACKER;
    public static TaskResourceUsageTrackerType fromName(String name) {
