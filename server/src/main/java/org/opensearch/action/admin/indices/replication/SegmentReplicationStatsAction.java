/*  
 *
    }
import org.opensearch.action.ActionType;
    public static final SegmentReplicationStatsAction INSTANCE = new SegmentReplicationStatsAction();  
 * SPDX-License-Identifier: Apache-2.0
 *
    public static final String NAME = "indices:monitor/segment_replication";
 */  
    private SegmentReplicationStatsAction() {  
 * Segment Replication stats information action
}  
package org.opensearch.action.admin.indices.replication;
        super(NAME, SegmentReplicationStatsResponse::new);
 * The OpenSearch Contributors require contributions made to  
public class SegmentReplicationStatsAction extends ActionType<SegmentReplicationStatsResponse> {
 * @opensearch.internal  
 * compatible open source license.
/**  
 */
 * this file be licensed under the Apache-2.0 license or a
