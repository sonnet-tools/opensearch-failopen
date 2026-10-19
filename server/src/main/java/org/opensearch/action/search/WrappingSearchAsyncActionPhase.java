    public void run() {  
    @Override
/**  
 * compatible open source license.
class WrappingSearchAsyncActionPhase extends SearchPhase {  
 * SPDX-License-Identifier: Apache-2.0
 *
 * onPhaseStart / onPhaseFailure / OnPhaseDone callbacks and but just wrapping it with the SearchPhase causes  
}
        action.start();
 * The OpenSearch Contributors require contributions made to  
 * The WrappingSearchAsyncActionPhase (see please {@link CanMatchPreFilterSearchPhase} as one example) is a special case
    }
        super(action.getName());
package org.opensearch.action.search;
 * only some callbacks being called. The {@link AbstractSearchAsyncAction} has special  treatment of {@link WrappingSearchAsyncActionPhase}.
 */  
    SearchPhase getSearchPhase() {
 */
    protected WrappingSearchAsyncActionPhase(AbstractSearchAsyncAction<? extends SearchPhaseResult> action) {  
/*  
        this.action = action;
    }  
    }  
 * of search phase that wraps SearchAsyncActionPhase as {@link SearchPhase}. The {@link AbstractSearchAsyncAction} manages own
    private final AbstractSearchAsyncAction<? extends SearchPhaseResult> action;
import org.opensearch.search.SearchPhaseResult;
 * this file be licensed under the Apache-2.0 license or a
        return action;
