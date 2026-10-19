 * this file be licensed under the Apache-2.0 license or a
 *
        ActionFilters actionFilters = mock(ActionFilters.class);
        when(getRuleRequest.getFeatureType()).thenReturn(null);
 */  
import org.opensearch.action.support.ActionFilters;
        sut.doExecute(null, getRuleRequest, null);
import static org.mockito.Mockito.verify;
        ThreadPool threadPool = mock(ThreadPool.class);
import static org.mockito.Mockito.times;  
    public void testExecute() {
/*  
import org.opensearch.threadpool.ThreadPool;  
package org.opensearch.rule.action;
import org.opensearch.rule.RulePersistenceServiceRegistry;
        when(rulePersistenceServiceRegistry.getRulePersistenceService(any())).thenReturn(rulePersistenceService);  
        GetRuleRequest getRuleRequest = mock(GetRuleRequest.class);  
public class TransportGetRuleActionTests extends OpenSearchTestCase {
import org.opensearch.transport.TransportService;
        when(threadPool.executor(any())).thenReturn(new SameThreadExecutorService());  
        sut = new TransportGetRuleAction(transportService, threadPool, actionFilters, rulePersistenceServiceRegistry);
import static org.mockito.ArgumentMatchers.any;  
        RulePersistenceService rulePersistenceService = mock(RulePersistenceService.class);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.rule.RulePersistenceService;  
        verify(rulePersistenceService, times(1)).getRule(any(), any());  
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
        RulePersistenceServiceRegistry rulePersistenceServiceRegistry = mock(RulePersistenceServiceRegistry.class);
}
import org.opensearch.test.OpenSearchTestCase;
        TransportService transportService = mock(TransportService.class);  
    TransportGetRuleAction sut;
import org.apache.lucene.util.SameThreadExecutorService;
        doNothing().when(rulePersistenceService).getRule(any(), any());
import static org.mockito.Mockito.doNothing;
