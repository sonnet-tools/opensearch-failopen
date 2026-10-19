 */
 * Action type to delete a search pipeline
 */  
 *  
public class DeleteSearchPipelineAction extends ActionType<AcknowledgedResponse> {  
import org.opensearch.action.ActionType;
    }  
    public static final DeleteSearchPipelineAction INSTANCE = new DeleteSearchPipelineAction();
 * SPDX-License-Identifier: Apache-2.0
 *
    public static final String NAME = "cluster:admin/search/pipeline/delete";
 * @opensearch.internal
}
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    public DeleteSearchPipelineAction() {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
package org.opensearch.action.search;
 * compatible open source license.
/*  
        super(NAME, AcknowledgedResponse::new);
/**
