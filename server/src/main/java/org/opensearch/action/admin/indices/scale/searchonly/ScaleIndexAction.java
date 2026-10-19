    /**  
 * {@link AcknowledgedResponse} to indicate success or failure.
     * The name of this action, used for transport action registration and routing.
 */  
     * <p>
     * Initializes the action with the appropriate name and response reader.
 */
 * The OpenSearch Contributors require contributions made to  
 * This action type represents the administrative operation to transition indices
     * This action name follows the OpenSearch convention of prefixing administrative  
 * Action type for search-only scale operations on indices.
/*  
 * <p>  
 * SPDX-License-Identifier: Apache-2.0
    }  
 * transport action registry.
 * this file be licensed under the Apache-2.0 license or a
     */
}
    private ScaleIndexAction() {
 * The action is registered with the name "indices:admin/scale/search_only" in the  
public class ScaleIndexAction extends ActionType<AcknowledgedResponse> {  
 *
 * compatible open source license.
     */  
     * Singleton instance of the SearchOnlyScaleAction.
    /**
    public static final ScaleIndexAction INSTANCE = new ScaleIndexAction();
import org.opensearch.action.ActionType;
    /**
     * Private constructor to enforce singleton pattern.  
    public static final String NAME = "indices:admin/scale/search_only";  
 * <p>
     * index actions with "indices:admin/".
     * <p>
 * used for transport actions and request routing. The action produces an  
        super(NAME, AcknowledgedResponse::new);
     */  
/**
 * between normal operation and search-only mode. It provides the action name constant
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
package org.opensearch.action.admin.indices.scale.searchonly;
