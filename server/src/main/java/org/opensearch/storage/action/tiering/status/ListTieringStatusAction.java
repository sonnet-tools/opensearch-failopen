 */  
    public static final String NAME = "cluster:admin/_tier/all";
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusResponse;
    /** Singleton instance. */
    private ListTieringStatusAction() {  
package org.opensearch.storage.action.tiering.status;
public class ListTieringStatusAction extends ActionType<ListTieringStatusResponse> {
    /** Action name for listing tiering status. */  
/** Action type for retrieving tiering status of all indices in the cluster. */
import org.opensearch.action.ActionType;
 *
    }
}  
 * The OpenSearch Contributors require contributions made to  
        super(NAME, ListTieringStatusResponse::new);
 * compatible open source license.
/*  
    public static final ListTieringStatusAction INSTANCE = new ListTieringStatusAction();
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
