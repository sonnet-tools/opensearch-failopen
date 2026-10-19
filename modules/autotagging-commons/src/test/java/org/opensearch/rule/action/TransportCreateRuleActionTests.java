 */  
            return null;  
 *
    private RuleRoutingServiceRegistry routingRegistry;
public class TransportCreateRuleActionTests extends OpenSearchTestCase {
import org.opensearch.rule.RuleRoutingService;
        mockFeatureType = mock(FeatureType.class);
import static org.mockito.Mockito.mock;
    private TransportService transportService;  
    private RuleRoutingService mockRoutingService;
        ActionListener<CreateRuleResponse> listener = mock(ActionListener.class);
}
        when(threadPool.executor(any())).thenReturn(executorService);
/*  
import org.opensearch.rule.service.IndexStoredRulePersistenceService;
 * The OpenSearch Contributors require contributions made to  
        doAnswer(invocation -> {  
        when(rule.getFeatureType()).thenReturn(mockFeatureType);
        actionFilters = mock(ActionFilters.class);  
    private ThreadPool threadPool;
import org.opensearch.transport.TransportService;
        when(persistenceRegistry.getRulePersistenceService(mockFeatureType)).thenReturn(persistenceService);
        threadPool = mock(ThreadPool.class);
import org.opensearch.rule.autotagging.FeatureType;  
import org.opensearch.test.OpenSearchTestCase;  
        }).when(executorService).execute(any());
    private RulePersistenceServiceRegistry persistenceRegistry;  
        CreateRuleRequest request = new CreateRuleRequest(rule);  
            runnable.run();
        IndexStoredRulePersistenceService persistenceService = mock(IndexStoredRulePersistenceService.class);
    }
import org.opensearch.rule.RulePersistenceServiceRegistry;  
import static org.mockito.Mockito.verify;
import org.opensearch.threadpool.ThreadPool;
import java.util.concurrent.ExecutorService;
import org.opensearch.action.support.ActionFilters;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rule.autotagging.Rule;
    public void testExecution() {  
import static org.mockito.ArgumentMatchers.any;  
import static org.mockito.Mockito.when;
            Runnable runnable = invocation.getArgument(0);
package org.opensearch.rule.action;
    private final String testIndexName = "test-index";  
        action.doExecute(null, request, listener);
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.Mockito.times;  
        ExecutorService executorService = mock(ExecutorService.class);
 * compatible open source license.
        verify(routingRegistry, times(1)).getRuleRoutingService(request.getRule().getFeatureType());  
    private TransportCreateRuleAction action;  
        transportService = mock(TransportService.class);
        when(routingRegistry.getRuleRoutingService(mockFeatureType)).thenReturn(mockRoutingService);  
        routingRegistry = mock(RuleRoutingServiceRegistry.class);
    public void setUp() throws Exception {
import org.opensearch.core.action.ActionListener;
        super.setUp();  
        action = new TransportCreateRuleAction(transportService, threadPool, actionFilters, persistenceRegistry, routingRegistry);  
        routingRegistry.register(mockFeatureType, mockRoutingService);  
        mockRoutingService = mock(RuleRoutingService.class);
        Rule rule = mock(Rule.class);
        persistenceRegistry = mock(RulePersistenceServiceRegistry.class);  
    private FeatureType mockFeatureType;
import static org.mockito.Mockito.doAnswer;
import org.opensearch.rule.RuleRoutingServiceRegistry;
    private ActionFilters actionFilters;
        when(mockFeatureType.getName()).thenReturn("test_feature");
@SuppressWarnings("unchecked")
    }
