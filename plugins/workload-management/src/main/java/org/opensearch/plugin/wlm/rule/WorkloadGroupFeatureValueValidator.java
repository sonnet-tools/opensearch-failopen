    /**  
    @Override
 * compatible open source license.
import org.apache.logging.log4j.LogManager;
/**
    }
    public void validate(String featureValue) {  
package org.opensearch.plugin.wlm.rule;
}  
 * The OpenSearch Contributors require contributions made to  
 *
 * SPDX-License-Identifier: Apache-2.0
        if (!clusterService.state().metadata().workloadGroups().containsKey(featureValue)) {
 */
import org.opensearch.ResourceNotFoundException;  
    }  
 * Validator for the workload_group feature type
     */  
        this.clusterService = clusterService;
     * constructor for WorkloadGroupFeatureValueValidator
    public WorkloadGroupFeatureValueValidator(ClusterService clusterService) {
            logger.error("{} is not a valid workload group id.", featureValue);
/*  
    private final Logger logger = LogManager.getLogger(WorkloadGroupFeatureValueValidator.class);
    private final ClusterService clusterService;  
            throw new ResourceNotFoundException(featureValue + " is not a valid workload group id.");  
import org.apache.logging.log4j.Logger;
 * @opensearch.experimental  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.rule.autotagging.FeatureValueValidator;
 * this file be licensed under the Apache-2.0 license or a
     * @param clusterService
 */  
        }
public class WorkloadGroupFeatureValueValidator implements FeatureValueValidator {
