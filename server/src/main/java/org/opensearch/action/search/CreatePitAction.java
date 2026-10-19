    private CreatePitAction() {
package org.opensearch.action.search;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
public class CreatePitAction extends ActionType<CreatePitResponse> {  
}
import org.opensearch.action.ActionType;
 */
/**  
    }  
    public static final String NAME = "indices:data/read/point_in_time/create";
 * The OpenSearch Contributors require contributions made to  
        super(NAME, CreatePitResponse::new);
 *
/*  
    public static final CreatePitAction INSTANCE = new CreatePitAction();
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Action type for creating PIT reader context
