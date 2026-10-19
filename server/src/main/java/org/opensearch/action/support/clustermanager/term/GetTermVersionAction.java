package org.opensearch.action.support.clustermanager.term;
import org.opensearch.action.ActionType;
    public static final String NAME = "internal:monitor/term";
public class GetTermVersionAction extends ActionType<GetTermVersionResponse> {
    public static final GetTermVersionAction INSTANCE = new GetTermVersionAction();
 */  
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
/**  
 * Transport action for fetching cluster term and version
}
 *
/*  
    private GetTermVersionAction() {
    }  
 */
 *
 * The OpenSearch Contributors require contributions made to  
        super(NAME, GetTermVersionResponse::new);
