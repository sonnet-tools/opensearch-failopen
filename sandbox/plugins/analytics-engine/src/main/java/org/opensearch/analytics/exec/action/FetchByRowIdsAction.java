 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * per-batch streamed response type.  
/*  
    public static final String NAME = "indices:data/read/analytics/fetch_by_row_ids";
package org.opensearch.analytics.exec.action;
 * {@link ActionType} singleton for the QTF (Query-Then-Fetch / late-materialization)
 */
    private FetchByRowIdsAction() {
 */  
 * fetch-by-rowids action. Sibling of {@link FragmentExecutionAction} — different semantics
 * but it shares the {@code indices:data/read/analytics/*} prefix so the existing security
import org.opensearch.action.ActionType;
 * (no Substrait fragment, no plan conversion) so the dispatch table needs a distinct name,  
 * this file be licensed under the Apache-2.0 license or a
        super(NAME, FragmentExecutionArrowResponse::new);  
 * The OpenSearch Contributors require contributions made to  
}
public class FetchByRowIdsAction extends ActionType<FragmentExecutionArrowResponse> {
    }
 *
/**  
    public static final FetchByRowIdsAction INSTANCE = new FetchByRowIdsAction();  
 * permission grant covers both. Reuses {@link FragmentExecutionArrowResponse} as the
