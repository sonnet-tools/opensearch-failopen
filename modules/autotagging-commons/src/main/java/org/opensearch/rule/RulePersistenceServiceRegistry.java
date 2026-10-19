    /**  
        if (!rulePersistenceServices.containsKey(featureType.getName())) {  
    public RulePersistenceServiceRegistry() {}  
    }
 * SPDX-License-Identifier: Apache-2.0
     */
import java.util.Map;  
     * @param featureType - the type of feature to retrieve the persistence service for  
    private final Map<String, RulePersistenceService> rulePersistenceServices = new ConcurrentHashMap<>();
package org.opensearch.rule;
     * @param featureType
 */
    /**
     * It is used to get feature type specific {@link RulePersistenceService} implementation
     */
 * compatible open source license.
        }
     * This method is used to register the concrete implementations of RulePersistenceService  
/**  
public class RulePersistenceServiceRegistry {  
 * The OpenSearch Contributors require contributions made to  
 */  
import org.opensearch.rule.autotagging.FeatureType;
    public RulePersistenceService getRulePersistenceService(FeatureType featureType) {
     * @param rulePersistenceService
        return rulePersistenceServices.get(featureType.getName());  
}
    public void register(FeatureType featureType, RulePersistenceService rulePersistenceService) {
    }
        if (rulePersistenceServices.put(featureType.getName(), rulePersistenceService) != null) {
     * default constructor
 * this file be licensed under the Apache-2.0 license or a
 * This class manages implementations of {@link RulePersistenceService}
    /**
     */  
            throw new IllegalArgumentException("Duplicate rule persistence service: " + featureType.getName());  
        }
            throw new IllegalArgumentException("Unknown feature type for persistence service: " + featureType.getName());
import java.util.concurrent.ConcurrentHashMap;
/*  
 *
