 */
 *
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.api  
package org.opensearch.action.admin.indices.streamingingestion.state;
}
public class UpdateIngestionStateAction extends ActionType<UpdateIngestionStateResponse> {
import org.opensearch.action.ActionType;
    }  
 * this file be licensed under the Apache-2.0 license or a
    public static final String NAME = "indices:admin/ingestion/updateState";
        super(NAME, UpdateIngestionStateResponse::new);
    private UpdateIngestionStateAction() {
/*  
 * Transport action for updating ingestion state.
 */  
 *
    public static final UpdateIngestionStateAction INSTANCE = new UpdateIngestionStateAction();
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
/**  
