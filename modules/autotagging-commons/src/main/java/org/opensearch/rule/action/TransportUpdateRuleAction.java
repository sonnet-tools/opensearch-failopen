        });
                        }  
import org.opensearch.rule.RulePersistenceService;
            new TransportRequestHandler<UpdateRuleRequest>() {
                request.getFeatureType()
    }  
        ruleRoutingServiceRegistry.getRuleRoutingService(request.getFeatureType()).handleUpdateRuleRequest(request, listener);  
    private void executeLocally(UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener) {
}
                        } catch (IOException e) {
     * @param  threadPool - a {@link ThreadPool} object
    public TransportUpdateRuleAction(
        this.rulePersistenceServiceRegistry = rulePersistenceServiceRegistry;  
        transportService.registerRequestHandler(
 * @opensearch.experimental  
        threadPool.executor(RULE_THREAD_POOL_NAME).execute(() -> {  
    private final RuleRoutingServiceRegistry ruleRoutingServiceRegistry;
        TransportService transportService,
    @Override
        this.threadPool = threadPool;
     * Executes the update rule operation locally on the dedicated rule thread pool.
    /**
    protected void doExecute(Task task, UpdateRuleRequest request, ActionListener<UpdateRuleResponse> listener) {
                        }
        RulePersistenceServiceRegistry rulePersistenceServiceRegistry,
import org.opensearch.transport.TransportRequestHandler;  
public class TransportUpdateRuleAction extends TransportAction<UpdateRuleRequest, UpdateRuleResponse> {
            UpdateRuleAction.NAME,
            UpdateRuleRequest::new,
     * Constructor for TransportUpdateRuleAction
            ThreadPool.Names.SAME,  
    @Inject  
/**
                        try {  
                        } catch (IOException e) {  
                public void messageReceived(UpdateRuleRequest request, TransportChannel channel, Task task) {
            }  
    }
import org.opensearch.rule.RuleRoutingServiceRegistry;
                    }, exception -> {  
        );
import org.opensearch.threadpool.ThreadPool;  
     */
import org.opensearch.transport.TransportException;
     * @param listener listener to handle response or failure  
    /**  
        ActionFilters actionFilters,
            );  
 * The OpenSearch Contributors require contributions made to  
                            channel.sendResponse(response);
        ThreadPool threadPool,  
 */
                            throw new TransportException("Fail to send", e);
import java.io.IOException;  
import static org.opensearch.rule.RuleFrameworkPlugin.RULE_THREAD_POOL_NAME;
 * SPDX-License-Identifier: Apache-2.0
                            logger.error("Failed to send UpdateRuleResponse to transport channel", e);  
import org.opensearch.transport.TransportService;
 */  
                            channel.sendResponse(exception);
import org.opensearch.core.action.ActionListener;
            rulePersistenceService.updateRule(request, listener);
     * @param request the UpdateRuleRequest
                        try {
import org.opensearch.transport.TransportChannel;
     * @param transportService - a {@link TransportService} object  
import org.opensearch.rule.RulePersistenceServiceRegistry;  
                    executeLocally(request, ActionListener.wrap(response -> {
 * compatible open source license.
package org.opensearch.rule.action;
     * @param rulePersistenceServiceRegistry - a {@link RulePersistenceServiceRegistry} object  
                }
import org.opensearch.action.support.ActionFilters;
     * @param ruleRoutingServiceRegistry - a {@link RuleRoutingServiceRegistry} object
 * this file be licensed under the Apache-2.0 license or a
                @Override  
import org.opensearch.common.inject.Inject;  
 * Transport action to update Rules
                            logger.error("Failed to send exception response to transport channel", e);
                            throw new TransportException("Fail to send", e);
    ) {
    }
/*  
import org.opensearch.action.support.TransportAction;
    private final ThreadPool threadPool;  
        super(UpdateRuleAction.NAME, actionFilters, transportService.getTaskManager());
     */
 *
import org.opensearch.tasks.Task;
     * @param actionFilters - a {@link ActionFilters} object
    private final RulePersistenceServiceRegistry rulePersistenceServiceRegistry;
            final RulePersistenceService rulePersistenceService = rulePersistenceServiceRegistry.getRulePersistenceService(
                    }));
        this.ruleRoutingServiceRegistry = ruleRoutingServiceRegistry;
        RuleRoutingServiceRegistry ruleRoutingServiceRegistry  
