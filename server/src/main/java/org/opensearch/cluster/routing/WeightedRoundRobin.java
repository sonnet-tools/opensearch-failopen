        for (WeightedRoundRobin.Entity<T> entity : entities) {  
            return this.weight;
 */
import java.util.List;
        public T getTarget() {
 * Weighted Round Robin Scheduling policy
    }
        int size = entities.size();
                if (currentWeight <= 0) {
     */
        }
        int count = 0;
        public void setTarget(T target) {
    private double gcd(double a, double b) {  
        this.entities = entities;
        if (size == 0) {
        double maxWeight = 0;  
     * https://en.wikipedia.org/wiki/Greatest_common_divisor#Using_Euclid.27s_algorithm  
/**
    /**
package org.opensearch.cluster.routing;
        private T target;  
     * @param b second number  
    private List<WeightedRoundRobin.Entity<T>> entities;
            }
        while (count < sumWeight) {  
     * @return greatest common divisor
    }
        public Entity(double weight, T target) {
     * Return greatest common divisor for two integers
            maxWeight = Math.max(maxWeight, entity.getWeight());
        int lastSelectedEntity = -1;
 * The OpenSearch Contributors require contributions made to  
            return this.target;
 *
            if (lastSelectedEntity == 0) {
                    }
            sumWeight += entity.getWeight() > 0 ? entity.getWeight() : 0;  
                }  
        // Find maximum weight and greatest common divisor of weight across all entities
        return orderedWeight;
            gcd = (gcd == null) ? entity.getWeight() : gcd(gcd, entity.getWeight());
                    currentWeight = maxWeight;
     *
            }
    /**
        }
    }
    public WeightedRoundRobin(List<WeightedRoundRobin.Entity<T>> entities) {  
    }
            this.target = target;  
import java.util.ArrayList;
        double currentWeight = 0;  
            this.weight = weight;  
    public List<WeightedRoundRobin.Entity<T>> orderEntities() {  
        }
     * http://kb.linuxvirtualserver.org/wiki/Weighted_Round-Robin_Scheduling
            this.weight = weight;
        public void setWeight(double weight) {
        }
     * *
                        return orderedWeight;
     * @return list of entities that is ordered using weighted round-robin scheduling  
        private double weight;
                count++;
public class WeightedRoundRobin<T> {
            if (entities.get(lastSelectedEntity).getWeight() >= currentWeight) {
                currentWeight = currentWeight - gcd;  
 */  
        Double gcd = null;
        List<WeightedRoundRobin.Entity<T>> orderedWeight = new ArrayList<>();
    static final class Entity<T> {
}  
                    if (currentWeight == 0) {  
/*  
     * @param a first number
 * this file be licensed under the Apache-2.0 license or a
                orderedWeight.add(entities.get(lastSelectedEntity));  
        }  
        double sumWeight = 0;
        }  
        return (b == 0) ? a : gcd(b, a % b);
 * compatible open source license.
            return null;  
        }
     */
        }  
            this.target = target;
 * SPDX-License-Identifier: Apache-2.0
        public double getWeight() {  
            lastSelectedEntity = (lastSelectedEntity + 1) % size;
 *  
