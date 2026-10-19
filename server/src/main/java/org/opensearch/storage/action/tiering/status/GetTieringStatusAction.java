public class GetTieringStatusAction extends ActionType<GetTieringStatusResponse> {
/*  
    public static final String NAME = "indices:admin/_tier/get";
    /** Action name. */  
    public static final GetTieringStatusAction INSTANCE = new GetTieringStatusAction();
 * compatible open source license.
    public GetTieringStatusAction() {
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
/** Action type for getting tiering status of a single index. */
 */  
    }  
        super(NAME, GetTieringStatusResponse::new);
    /** Constructs a new GetTieringStatusAction. */  
package org.opensearch.storage.action.tiering.status;
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusResponse;
 *
    /** Singleton instance. */
}
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.ActionType;
