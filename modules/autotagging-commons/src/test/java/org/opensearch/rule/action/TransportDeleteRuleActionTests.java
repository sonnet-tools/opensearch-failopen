        DeleteRuleRequest deleteRuleRequest = mock(DeleteRuleRequest.class);
        doNothing().when(rulePersistenceService).deleteRule(any(), any());
    public void testExecute() {
        RulePersistenceService rulePersistenceService = mock(RulePersistenceService.class);  
public class TransportDeleteRuleActionTests extends OpenSearchTestCase {
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
        sut = new TransportDeleteRuleAction(transportService, actionFilters, rulePersistenceServiceRegistry);
 * this file be licensed under the Apache-2.0 license or a
 *
        ActionFilters actionFilters = mock(ActionFilters.class);
        RulePersistenceServiceRegistry rulePersistenceServiceRegistry = mock(RulePersistenceServiceRegistry.class);  
        verify(rulePersistenceService, times(1)).deleteRule(any(), any());
import org.opensearch.action.support.ActionFilters;
 * SPDX-License-Identifier: Apache-2.0
        sut.doExecute(null, deleteRuleRequest, null);
import static org.mockito.Mockito.doNothing;
/*  
        TransportService transportService = mock(TransportService.class);
        when(deleteRuleRequest.getFeatureType()).thenReturn(null);  
 * The OpenSearch Contributors require contributions made to  
}  
import static org.mockito.Mockito.mock;  
package org.opensearch.rule.action;
    TransportDeleteRuleAction sut;  
import org.opensearch.rule.RulePersistenceServiceRegistry;  
    }
 */  
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import org.opensearch.transport.TransportService;
        when(rulePersistenceServiceRegistry.getRulePersistenceService(any())).thenReturn(rulePersistenceService);
import org.opensearch.rule.RulePersistenceService;
import static org.mockito.Mockito.when;  
import static org.mockito.Mockito.times;
