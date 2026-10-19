     */
 * this file be licensed under the Apache-2.0 license or a
    public static final PutIndexFieldDomainsAction INSTANCE = new PutIndexFieldDomainsAction();  
    }  
 * SPDX-License-Identifier: Apache-2.0
    public static final String NAME = "indices:admin/field_domains/put";
/*  
    /**
 */  
import org.opensearch.common.annotation.ExperimentalApi;  
     * Singleton action instance.
 *
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
     */
 *
@ExperimentalApi
import org.opensearch.action.ActionType;
/**
        super(NAME, AcknowledgedResponse::new);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    /**  
 */  
 * Action type for publishing index-level field-domain metadata.  
 *
 * field-domain metadata into the target concrete index metadata.  
public class PutIndexFieldDomainsAction extends ActionType<AcknowledgedResponse> {
     * Transport action name.  
    private PutIndexFieldDomainsAction() {
package org.opensearch.action.admin.indices.fielddomain;
 * @opensearch.experimental
}
 * This action is intended for trusted metadata producers. The cluster-manager node validates and merges the supplied
