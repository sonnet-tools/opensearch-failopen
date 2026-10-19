     * Flow implementation from consumer plugins into framework plugin  
public interface RuleFrameworkExtension {
    Supplier<RulePersistenceService> getRulePersistenceServiceSupplier();  
import org.opensearch.rule.RuleRoutingService;
    /**
 */  
     */
    /**
import org.opensearch.rule.RulePersistenceService;
     * @return the plugin specific implementation of RulePersistenceService
     */
import java.util.List;  
/**  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.rule.spi;
/*  
     */
     * @param attributes
 * implementations from the consumer plugins of this extension
 */  
     * This method is used to flow implementation from consumer plugins into framework plugin  
     * Flow attributes from RuleFrameworkExtension to implementation plugins  
     */
    Supplier<RuleRoutingService> getRuleRoutingServiceSupplier();  
 * This interface exposes methods for the RuleFrameworkPlugin to extract framework related
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import java.util.function.Supplier;
     * This method is used to flow implementation from consumer plugins into framework plugin  
    /**
 *
     * @return the specific implementation of FeatureType
    void setAttributes(List<Attribute> attributes);  
}
 * The OpenSearch Contributors require contributions made to  
     * @return the plugin specific implementation of RuleRoutingService
import org.opensearch.rule.autotagging.Attribute;  
    /**
    Supplier<FeatureType> getFeatureTypeSupplier();  
import org.opensearch.rule.autotagging.FeatureType;
