/**  
     */
    public void register(FeatureType featureType, RuleRoutingService ruleRoutingService) {
import org.opensearch.rule.autotagging.FeatureType;
 */
     * @param ruleRoutingService
/*  
 */  
    }
    /**
     * It is used to get feature type specific {@link RuleRoutingService} implementation
import java.util.concurrent.ConcurrentHashMap;
        return ruleRoutingServices.get(featureType.getName());  
 * this file be licensed under the Apache-2.0 license or a
        if (!ruleRoutingServices.containsKey(featureType.getName())) {  
}
    /**  
public class RuleRoutingServiceRegistry {  
     * default constructor
     * This method is used to register the concrete implementations of RuleRoutingService  
            throw new IllegalArgumentException("Unknown feature type for routing service: " + featureType.getName());
import java.util.Map;  
 * compatible open source license.
        if (ruleRoutingServices.put(featureType.getName(), ruleRoutingService) != null) {
     * @param featureType - the type of feature to retrieve the routing service for  
        }
        }
            throw new IllegalArgumentException("Duplicate rule routing service: " + featureType.getName());  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.rule;
     */
    public RuleRoutingServiceRegistry() {}  
    private final Map<String, RuleRoutingService> ruleRoutingServices = new ConcurrentHashMap<>();
     */  
 * SPDX-License-Identifier: Apache-2.0
    /**
    }
 *
 * This class manages implementations of {@link RuleRoutingService}
     * @param featureType
    public RuleRoutingService getRuleRoutingService(FeatureType featureType) {
