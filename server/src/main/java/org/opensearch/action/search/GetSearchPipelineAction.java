 * this file be licensed under the Apache-2.0 license or a
 *
 * Action type to get search pipelines
    public GetSearchPipelineAction() {  
 *
 * The OpenSearch Contributors require contributions made to  
    public static final GetSearchPipelineAction INSTANCE = new GetSearchPipelineAction();  
import org.opensearch.action.ActionType;
}  
    }
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal  
 * compatible open source license.
package org.opensearch.action.search;
 */
    public static final String NAME = "cluster:admin/search/pipeline/get";
        super(NAME, GetSearchPipelineResponse::new);
/*  
 */  
/**  
public class GetSearchPipelineAction extends ActionType<GetSearchPipelineResponse> {
