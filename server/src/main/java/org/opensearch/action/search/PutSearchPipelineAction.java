 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
 *
 * compatible open source license.
    public static final String NAME = "cluster:admin/search/pipeline/put";
 */  
 *  
}
        super(NAME, AcknowledgedResponse::new);
    }  
/**
/*  
import org.opensearch.action.ActionType;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * Action type to put a new search pipeline
 */
    public static final PutSearchPipelineAction INSTANCE = new PutSearchPipelineAction();
public class PutSearchPipelineAction extends ActionType<AcknowledgedResponse> {  
package org.opensearch.action.search;
    public PutSearchPipelineAction() {
 * The OpenSearch Contributors require contributions made to  
