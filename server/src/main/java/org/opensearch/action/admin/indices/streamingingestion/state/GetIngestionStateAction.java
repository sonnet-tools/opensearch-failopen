public class GetIngestionStateAction extends ActionType<GetIngestionStateResponse> {
 * SPDX-License-Identifier: Apache-2.0
 */  
 * @opensearch.api  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public static final String NAME = "indices:monitor/ingestion/state";
    private GetIngestionStateAction() {
/*  
 *
import org.opensearch.action.ActionType;
 * Transport action for getting ingestion state.
 *
 * The OpenSearch Contributors require contributions made to  
}
    }  
    public static final GetIngestionStateAction INSTANCE = new GetIngestionStateAction();
/**  
        super(NAME, GetIngestionStateResponse::new);
package org.opensearch.action.admin.indices.streamingingestion.state;
 */
