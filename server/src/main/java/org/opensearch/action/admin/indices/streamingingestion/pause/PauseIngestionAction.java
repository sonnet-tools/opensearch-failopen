}
 *
package org.opensearch.action.admin.indices.streamingingestion.pause;
 * The OpenSearch Contributors require contributions made to  
/*  
 * Transport action for pausing ingestion.
    private PauseIngestionAction() {
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
/**  
import org.opensearch.action.ActionType;
    public static final PauseIngestionAction INSTANCE = new PauseIngestionAction();
 *
 * compatible open source license.
    public static final String NAME = "indices:admin/ingestion/pause";
 * @opensearch.api  
public class PauseIngestionAction extends ActionType<PauseIngestionResponse> {
    }  
 */  
        super(NAME, PauseIngestionResponse::new);
 */
