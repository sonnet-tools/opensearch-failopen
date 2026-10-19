 *
 * this file be licensed under the Apache-2.0 license or a
        phase = null;
 * compatible open source license.
    protected void onPhaseFailure(SearchPhaseContext context, Throwable cause) {  
        assertThat(phase, is(context.getCurrentPhase()));
import static org.hamcrest.CoreMatchers.is;
    @Override
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;  
    }
        assertThat(phase, is(nullValue()));  
    protected void onPhaseEnd(SearchPhaseContext context, SearchRequestContext searchRequestContext) {  
        assertThat(phase, is(context.getCurrentPhase()));
 * The OpenSearch Contributors require contributions made to  
    public void assertFinished() {
    protected void onPhaseStart(SearchPhaseContext context) {  
        phase = context.getCurrentPhase();
    @Override
}
    }  
 * SPDX-License-Identifier: Apache-2.0
class SearchRequestOperationsListenerAssertingListener extends SearchRequestOperationsListener {
        phase = null;
package org.opensearch.action.search;
    @Override
        assertThat(phase, is(nullValue()));
 */  
/*  
    }  
    }  
    private volatile SearchPhase phase;  
