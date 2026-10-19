/*  
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.ActionType;
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api  
 */  
    public static final ResumeIngestionAction INSTANCE = new ResumeIngestionAction();
 *
public class ResumeIngestionAction extends ActionType<ResumeIngestionResponse> {
 * Transport action for resuming ingestion.
/**  
 * compatible open source license.
}
    private ResumeIngestionAction() {
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.admin.indices.streamingingestion.resume;
 *
 */
    public static final String NAME = "indices:admin/ingestion/resume";
        super(NAME, ResumeIngestionResponse::new);
