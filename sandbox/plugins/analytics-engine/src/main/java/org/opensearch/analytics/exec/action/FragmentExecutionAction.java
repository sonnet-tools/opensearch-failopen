 * The OpenSearch Contributors require contributions made to  
 * {@link ActionType} singleton for the analytics shard-level fragment
    public static final FragmentExecutionAction INSTANCE = new FragmentExecutionAction();
    }  
    private FragmentExecutionAction() {
/*  
    public static final String NAME = "indices:data/read/analytics/fragment";
    /** Singleton instance. */
 * execution action. Pairs the action name with the
public class FragmentExecutionAction extends ActionType<FragmentExecutionArrowResponse> {
 */  
        super(NAME, FragmentExecutionArrowResponse::new);
 * compatible open source license.
}
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 */
import org.opensearch.action.ActionType;
 *
 * {@link FragmentExecutionArrowResponse} deserializer.  
/**  
package org.opensearch.analytics.exec.action;
    /** Action name registered with the transport layer. */
