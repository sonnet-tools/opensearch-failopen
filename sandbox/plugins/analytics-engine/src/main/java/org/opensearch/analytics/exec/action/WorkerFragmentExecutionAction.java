 * SPDX-License-Identifier: Apache-2.0
 * join) and reads only from registered NamedScans backed by per-partition shuffle buffers.
    public static final WorkerFragmentExecutionAction INSTANCE = new WorkerFragmentExecutionAction();
}
 * the worker fragment runs the consumer-side of a shuffle (e.g. the post-shuffle hash  
 * <p>Workers ride the same Arrow streaming response shape as shard fragments  
 *
    }  
 */  
 * this file be licensed under the Apache-2.0 license or a
 */
/**  
 * compatible open source license.
package org.opensearch.analytics.exec.action;
 * ({@link FragmentExecutionArrowResponse}); only the request differs (no {@code shardId}).
/*  
 *
 * {@link FragmentExecutionAction} but for worker-tier fragments that have no shard scan —
public class WorkerFragmentExecutionAction extends ActionType<FragmentExecutionArrowResponse> {
 *
 * The OpenSearch Contributors require contributions made to  
        super(NAME, FragmentExecutionArrowResponse::new);
    public static final String NAME = "indices:data/read/analytics/worker_fragment";
import org.opensearch.action.ActionType;
    private WorkerFragmentExecutionAction() {
 * @opensearch.internal  
 * Transport action for hash-shuffle worker fragments. Sibling of
