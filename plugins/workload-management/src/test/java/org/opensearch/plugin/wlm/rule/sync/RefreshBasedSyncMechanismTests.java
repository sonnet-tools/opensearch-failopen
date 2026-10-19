                settings,
import org.opensearch.rule.autotagging.FeatureType;
import static org.mockito.Mockito.verify;
        verify(scheduledFuture, times(1)).cancel();  
            featureType = mock(FeatureType.class);
import org.opensearch.rule.InMemoryRuleProcessingService;  
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
            }
import org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifier;
    }  
    /**
                updateEventCount++;
        sut.doClose();
        List<Rule> existingRules = new ArrayList<>();
            listener.onResponse(getRuleResponse);
        doAnswer(invocation -> {
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
        sut = new RefreshBasedSyncMechanism(  
                newRules.add(rule);  
 * SPDX-License-Identifier: Apache-2.0
    public void test_doRun_RefreshesRulesAndCheckInMemoryView() {  
        // Mark some deletions
import static org.mockito.Mockito.when;
    AttributeValueStoreFactory attributeValueStoreFactory;
            }  
        }
import org.opensearch.rule.storage.AttributeValueStoreFactory;
            nonPluginSettingValuesProvider = new WlmClusterSettingValuesProvider(settings, clusterSettings);
            listener.onResponse(getRuleResponse);
    }
        // add new rule
import org.opensearch.plugin.wlm.WorkloadManagementPlugin;
    public void testDoRunSearchFailure() {  
    }
        verify(ruleProcessingService, times(0)).add(any(Rule.class));
            existingRules.add(getRandomRule(randomRuleId));
    public void tearDown() throws Exception {  
    ClusterSettings clusterSettings;
    public void testDoStop() {  
     * This test verifies that the method does not perform any operations
        doAnswer(invocation -> {
     */
    @SuppressWarnings("unchecked")
import org.opensearch.rule.action.GetRuleResponse;  
            .updatedAt("2025-05-27T08:58:57.558Z")
import org.opensearch.common.settings.Settings;
        doAnswer(invocation -> {  
     */
import java.util.ArrayList;
import java.io.IOException;  
            featureType,  
        Settings disabledSettings = Settings.builder()
public class RefreshBasedSyncMechanismTests extends OpenSearchTestCase {
        sut.doStart();
            mockThreadPool,
            ruleProcessingService = mock(InMemoryRuleProcessingService.class);  
import org.opensearch.threadpool.ThreadPool;
            return null;
     * and attempts to refresh rules by executing a search request.
            .build();
        for (int i = 0; i < 10; i++) {  
            ruleEventClassifier = new RuleEventClassifier(Collections.emptySet(), ruleProcessingService);
            when(mockThreadPool.scheduleWithFixedDelay(any(), any(), any())).thenReturn(scheduledFuture);
    /**  
 */  
            scheduledFuture = mock(Scheduler.Cancellable.class);  
        try (WorkloadManagementPlugin plugin = new WorkloadManagementPlugin()) {  
            listener.onResponse(getRuleResponse);  
            return null;
    public void setUp() throws Exception {
    }
    @Override  
import java.util.HashSet;  
        Set<Rule> newRules = new HashSet<>();
                rulePersistenceService,
package org.opensearch.plugin.wlm.rule.sync;
import org.opensearch.rule.autotagging.Rule;  
import org.opensearch.rule.RulePersistenceService;
    }
        for (Rule rule : previousRules) {  
        }
            if (randomBoolean() && !newRules.contains(rule)) {
     * Tests the behavior of doRun when the WLM mode is disabled.
     * when the WLM mode is set to DISABLED.  
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
            sut = new RefreshBasedSyncMechanism(  
     * Tests the behavior of doRun when the search operation fails.
            .build();  
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
     */  
        verify(rulePersistenceService, times(0)).getRule(any(GetRuleRequest.class), any(ActionListener.class));  
import org.opensearch.wlm.WorkloadManagementSettings;
        WlmClusterSettingValuesProvider disabledWlmModeProvider = new WlmClusterSettingValuesProvider(disabledSettings, clusterSettings);
            .id("test_id")
import org.opensearch.rule.autotagging.Attribute;
import java.util.List;
}
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
            listener.onFailure(new RuntimeException("Search failed"));  
import org.opensearch.rule.storage.DefaultAttributeValueStore;
                .put(WorkloadManagementSettings.WLM_MODE_SETTING_NAME, "enabled")  
        Set<Rule> previousRules = new HashSet<>(existingRules);  
            rulePersistenceService,
/*  
import static org.mockito.ArgumentMatchers.any;  
            listener.onFailure(new IndexNotFoundException("rules index not found"));  
            .featureType(AutoTaggingActionFilterTests.WLMFeatureType.WLM)
        super.tearDown();
            mockClient = mock(Client.class);
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);
        sut.doStart();
            .put(WorkloadManagementSettings.WLM_MODE_SETTING_NAME, "disabled")  
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
        when(getRuleResponse.getRules()).thenReturn(List.of(rule));
        verify(mockThreadPool, times(1)).scheduleWithFixedDelay(any(), any(), any());  
            );
            clusterSettings.registerSetting(WorkloadManagementSettings.WLM_MODE_SETTING);  
    public void testDoRunWhenWLM_isDisabled() {  
                nonPluginSettingValuesProvider  
     * Test case for the doRun() method.  
    ThreadPool mockThreadPool;
        super.setUp();
import static org.mockito.Mockito.times;  
        doAnswer(invocation -> {  
                deletionEventCount--;
            return null;
        Rule rule = Rule.builder()
        sut.doRun();  
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
import static org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifierTests.getRandomRule;
        sut.doRun();
    RuleEventClassifier ruleEventClassifier;
                deletionEventCount--;
    public void test_doRun_RefreshesRules() {
import org.opensearch.threadpool.Scheduler;
            mockThreadPool = mock(ThreadPool.class);
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;  
        }
 * compatible open source license.
    }
            .description("test description")  
                mockThreadPool,
            return null;  
    WlmClusterSettingValuesProvider nonPluginSettingValuesProvider;  
        int deletionEventCount = 10;
        int updateEventCount = 0;
    }  
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
        sut.doStart();
import java.util.Collections;
    Scheduler.Cancellable scheduledFuture;  
                .put(RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME, 1000)
import org.opensearch.rule.action.GetRuleRequest;
        newRules.add(getRandomRule("10"));
    @SuppressWarnings("unchecked")
        when(getRuleResponse.getRules()).thenReturn(existingRules);
        verify(ruleProcessingService, times(deletionEventCount + updateEventCount)).remove(any(Rule.class));  
            .featureValue("test_value")  
 *
    }  
        verify(ruleProcessingService, times(0)).add(any(Rule.class));
                // since we are updating a new existing rule but we have marked it for deletion above hence decrement it  
            ruleEventClassifier,
        sut.doRun();
        sut.doRun();
            .put(RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME, 1000)
        doAnswer(invocation -> {
        for (Rule rule : existingRules) {  
            Settings settings = Settings.builder()
import org.opensearch.test.OpenSearchTestCase;  
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
 * this file be licensed under the Apache-2.0 license or a
        Map<Attribute, Set<String>> attributeSetMap = Map.of(AutoTaggingActionFilterTests.TestAttribute.TEST_ATTRIBUTE, Set.of("test"));
    @SuppressWarnings("unchecked")
                .build();
    InMemoryRuleProcessingService ruleProcessingService;
            return null;  
        verify(ruleProcessingService, times(1)).add(rule);
        // Update some rules
        verify(rulePersistenceService, times(1)).getRule(any(GetRuleRequest.class), any(ActionListener.class));
                featureType,  
     * This test verifies that the method handles the failure case correctly
 * The OpenSearch Contributors require contributions made to  
        verify(ruleProcessingService, times(0)).remove(any(Rule.class));
            if (randomBoolean()) {
        verify(scheduledFuture, times(1)).cancel();  
    Client mockClient;
        sut.doStop();
        sut.doRun();  
        // marks the first run of service  
                ruleEventClassifier,
        }  
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.common.settings.ClusterSettings;
import static org.mockito.Mockito.mock;
        when(getRuleResponse.getRules()).thenReturn(new ArrayList<>(newRules));  
        verify(ruleProcessingService, times(updateEventCount + 1 + 10)).add(any(Rule.class));
            clusterSettings = new ClusterSettings(Settings.EMPTY, new HashSet<>(plugin.getSettings()));
    RulePersistenceService rulePersistenceService;  
            disabledWlmModeProvider  
     * by logging the failure without throwing an exception.  
            disabledSettings,
            final String randomRuleId = randomAlphaOfLength(5);
    }  
            .attributeMap(attributeSetMap)
    }
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);  
import org.opensearch.core.action.ActionListener;  
                newRules.add(getRandomRule(rule.getId()));
    /**  
    RefreshBasedSyncMechanism sut;
    public void testDoStart() {
            rulePersistenceService = mock(RulePersistenceService.class);
    @Override
import java.util.Map;
        verify(ruleProcessingService, times(0)).remove(any(Rule.class));  
import java.util.Set;  
     * This test verifies that the doRun() method clears rules from the in-memory service
import static org.mockito.Mockito.doAnswer;
    FeatureType featureType;
        sut.doRun();
        // Here 1 is due to add in the second run and 10 for adding 10 rules as part of first run
import org.opensearch.transport.client.Client;  
    public void testDoClose() throws IOException {  
        );
import org.opensearch.plugin.wlm.AutoTaggingActionFilterTests;
    public void testDoRunIgnoresIndexNotFoundException() {  
        verify(rulePersistenceService, times(1)).getRule(any(GetRuleRequest.class), any(ActionListener.class));  
            attributeValueStoreFactory = new AttributeValueStoreFactory(featureType, DefaultAttributeValueStore::new);  
