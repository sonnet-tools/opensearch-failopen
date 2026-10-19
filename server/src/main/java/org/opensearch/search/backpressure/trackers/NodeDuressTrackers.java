    private void updateCache() {
 * SPDX-License-Identifier: Apache-2.0
    }
        for (ResourceType resourceType : ResourceType.values()) {
 *  
        private final Streak breaches = new Streak();  
     */
        updateCache();
         * Predicate that returns true when the node is in duress.  
 * compatible open source license.
        /**
        this.nodeDuressCacheExpiryChecker = nodeDuressCacheExpiryChecker;
     */
 * this file be licensed under the Apache-2.0 license or a
         * Returns true if the node is in duress consecutively for the past 'n' observations.  
    private final BooleanSupplier nodeDuressCacheExpiryChecker;  
        private final IntSupplier maxBreachAllowedSupplier;
     */  
 * @opensearch.internal
     */
         */
import java.util.function.BooleanSupplier;
         */
    public NodeDuressTrackers(Map<ResourceType, NodeDuressTracker> duressTrackers, BooleanSupplier nodeDuressCacheExpiryChecker) {  
public class NodeDuressTrackers {  
     * NodeDuressTracker is used to check if the node is in duress
    /**
         * Predicate that returns the max number of breaches allowed for this resource before we mark it as in duress
     * @return Boolean
     * {@code SearchBackpressureService.doRun()} to decide whether to bypass the
    /**  
    }
    private final Map<ResourceType, NodeDuressTracker> duressTrackers;
            return breaches.record(isNodeInDuress.getAsBoolean()) >= maxBreachAllowedSupplier.getAsInt();  
        return isResourceInDuress(ResourceType.NATIVE_MEMORY);  
         * Tracks the number of consecutive breaches.
    public NodeDuressTrackers(Map<ResourceType, NodeDuressTracker> duressTrackers) {
/**
/*  
            resourceDuressCache.put(resourceType, false);  
                NodeDuressTracker tracker = duressTrackers.get(resourceType);
        private final BooleanSupplier isNodeInDuress;
            for (ResourceType resourceType : ResourceType.values()) {  
    private final Map<ResourceType, Boolean> resourceDuressCache = new ConcurrentHashMap<>();
            if (isResourceInDuress(resourceType)) {  
import org.opensearch.wlm.ResourceType;  
     * {@code isResourceInDuress(ResourceType.NATIVE_MEMORY)}. Used by
 * The OpenSearch Contributors require contributions made to  
    public boolean isNativeMemoryInDuress() {
    }
import java.util.Map;
import java.util.function.IntSupplier;
        if (nodeDuressCacheExpiryChecker.getAsBoolean()) {
                resourceDuressCache.put(resourceType, tracker != null && tracker.test());
    public static class NodeDuressTracker {
        /**  
        }
     * heap-dominance gate and include all tasks as cancellation candidates.  
package org.opensearch.search.backpressure.trackers;
            }  
        public NodeDuressTracker(BooleanSupplier isNodeInDuress, IntSupplier maxBreachAllowedSupplier) {  
    }
     * @return true if node is in duress because of either system resource
     * Convenience accessor for native-memory duress. Equivalent to  
 * NodeDuressTrackers is used to check if the node is in duress based on various resources.
}  
import org.opensearch.common.util.TimeBasedExpiryTracker;
    }  
        }
     * @opensearch.internal  
 */
        /**
        }
        return false;
            this.maxBreachAllowedSupplier = maxBreachAllowedSupplier;
         */  
        }  
        this(duressTrackers, new TimeBasedExpiryTracker(System::nanoTime));  
    }  
        return resourceDuressCache.get(resourceType);
 */  
import java.util.concurrent.ConcurrentHashMap;  
    }
 *
                return true;
            this.isNodeInDuress = isNodeInDuress;
    /**
    public boolean isNodeInDuress() {
            }
        public boolean test() {
        }  
     * Method to check the {@link ResourceType} in duress  
     * Method to evaluate whether the node is in duress or not
         */
        /**
        for (ResourceType resourceType : ResourceType.values()) {
import org.opensearch.common.util.Streak;
    /**
        this.duressTrackers = duressTrackers;
    public boolean isResourceInDuress(ResourceType resourceType) {  
