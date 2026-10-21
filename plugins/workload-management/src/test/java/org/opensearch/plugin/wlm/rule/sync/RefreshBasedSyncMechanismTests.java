 */
     * This test verifies that the method does not perform any operations
import java.util.List;
        verify(rulePersistenceService, times(1)).getRule(any(GetRuleRequest.class), any(ActionListener.class));
import org.opensearch.rule.storage.AttributeValueStoreFactory;
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
    AttributeValueStoreFactory attributeValueStoreFactory;
package org.opensearch.plugin.wlm.rule.sync;
import java.util.Set;
            clusterSettings.registerSetting(WorkloadManagementSettings.WLM_MODE_SETTING);
        verify(ruleProcessingService, times(0)).remove(any(Rule.class));
            when(mockThreadPool.scheduleWithFixedDelay(any(), any(), any())).thenReturn(scheduledFuture);
import org.opensearch.rule.RulePersistenceService;
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;
    RulePersistenceService rulePersistenceService;
        verify(rulePersistenceService, times(1)).getRule(any(GetRuleRequest.class), any(ActionListener.class));
                updateEventCount++;
            ruleEventClassifier = new RuleEventClassifier(Collections.emptySet(), ruleProcessingService);
import org.opensearch.rule.storage.DefaultAttributeValueStore;
     * This test verifies that the method handles the failure case correctly
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);
        doAnswer(invocation -> {
    public void testDoRunSearchFailure() {
            return null;
        verify(ruleProcessingService, times(0)).add(any(Rule.class));
    RefreshBasedSyncMechanism sut;
import org.opensearch.plugin.wlm.WorkloadManagementPlugin;
            );
import static org.mockito.Mockito.times;
     */
        // marks the first run of service
            if (randomBoolean() && !newRules.contains(rule)) {
import static org.mockito.ArgumentMatchers.any;
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
        }
        WlmClusterSettingValuesProvider disabledWlmModeProvider = new WlmClusterSettingValuesProvider(disabledSettings, clusterSettings);
     * This test verifies that the doRun() method clears rules from the in-memory service
            .put(RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME, 1000)
     * and attempts to refresh rules by executing a search request.
    public void setUp() throws Exception {
            .featureType(AutoTaggingActionFilterTests.WLMFeatureType.WLM)
        try (WorkloadManagementPlugin plugin = new WorkloadManagementPlugin()) {
    Client mockClient;
    @SuppressWarnings("unchecked")
        // Mark some deletions
import org.opensearch.common.settings.Settings;
import java.util.Map;
        verify(ruleProcessingService, times(1)).add(rule);
import org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifier;
 * SPDX-License-Identifier: Apache-2.0
            ruleProcessingService = mock(InMemoryRuleProcessingService.class);
        // Here 1 is due to add in the second run and 10 for adding 10 rules as part of first run
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
    @Override
                .put(RefreshBasedSyncMechanism.RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME, 1000)
    @SuppressWarnings("unchecked")
                .put(WorkloadManagementSettings.WLM_MODE_SETTING_NAME, "enabled")
    Scheduler.Cancellable scheduledFuture;
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
     * Tests the behavior of doRun when the WLM mode is disabled.
            mockClient = mock(Client.class);
            mockThreadPool = mock(ThreadPool.class);
public class RefreshBasedSyncMechanismTests extends OpenSearchTestCase {
            sut = new RefreshBasedSyncMechanism(
import org.opensearch.rule.action.GetRuleRequest;
                nonPluginSettingValuesProvider
            return null;
        verify(rulePersistenceService, times(0)).getRule(any(GetRuleRequest.class), any(ActionListener.class));
 * The OpenSearch Contributors require contributions made to
            listener.onResponse(getRuleResponse);
                newRules.add(rule);
        when(getRuleResponse.getRules()).thenReturn(new ArrayList<>(newRules));
import java.util.Collections;
import org.opensearch.wlm.WorkloadManagementSettings;
     * when the WLM mode is set to DISABLED.
            listener.onResponse(getRuleResponse);
    }
        for (Rule rule : existingRules) {
import org.opensearch.common.settings.ClusterSettings;
import static org.mockito.Mockito.mock;
        doAnswer(invocation -> {
            .put(WorkloadManagementSettings.WLM_MODE_SETTING_NAME, "disabled")
        }
        sut.doRun();
    /**
        Set<Rule> newRules = new HashSet<>();
        GetRuleResponse getRuleResponse = mock(GetRuleResponse.class);
            final String randomRuleId = randomAlphaOfLength(5);
    RuleEventClassifier ruleEventClassifier;
    public void testDoClose() throws IOException {
/*
            return null;
     * Tests the behavior of doRun when the search operation fails.
        doAnswer(invocation -> {
            .attributeMap(attributeSetMap)
        sut.doRun();
            Settings settings = Settings.builder()
import org.opensearch.core.action.ActionListener;
            nonPluginSettingValuesProvider = new WlmClusterSettingValuesProvider(settings, clusterSettings);
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
import org.opensearch.rule.autotagging.Attribute;
    @Override
import static org.mockito.Mockito.doAnswer;
            .updatedAt("2025-05-27T08:58:57.558Z")
        // Update some rules
                featureType,
        }
            .id("test_id")
        int deletionEventCount = 10;
    }
    public void testDoStart() {
            clusterSettings = new ClusterSettings(Settings.EMPTY, new HashSet<>(plugin.getSettings()));
    InMemoryRuleProcessingService ruleProcessingService;
            }
            .featureValue("test_value")
    }
                rulePersistenceService,
import java.util.HashSet;
import org.opensearch.rule.InMemoryRuleProcessingService;
import org.opensearch.transport.client.Client;
            .build();
            listener.onResponse(getRuleResponse);
        verify(ruleProcessingService, times(0)).remove(any(Rule.class));
    ThreadPool mockThreadPool;
            featureType = mock(FeatureType.class);
            listener.onFailure(new RuntimeException("Search failed"));
        newRules.add(getRandomRule("10"));
        doAnswer(invocation -> {
    public void testDoRunWhenWLM_isDisabled() {
import static org.mockito.Mockito.when;
            rulePersistenceService = mock(RulePersistenceService.class);
        verify(ruleProcessingService, times(deletionEventCount + updateEventCount)).remove(any(Rule.class));
}
import org.opensearch.test.OpenSearchTestCase;
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
import java.util.ArrayList;
        int updateEventCount = 0;
        );
    }
                ruleEventClassifier,
            rulePersistenceService,
    @SuppressWarnings("unchecked")
    public void test_doRun_RefreshesRulesAndCheckInMemoryView() {
    FeatureType featureType;
                deletionEventCount--;
        sut.doRun();
    }
import static org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifierTests.getRandomRule;
    }
                newRules.add(getRandomRule(rule.getId()));
                .build();
    /**
            disabledWlmModeProvider
 * compatible open source license.
    }
     */
    ClusterSettings clusterSettings;
            mockThreadPool,
    /**
                settings,
     */
import org.opensearch.rule.action.GetRuleResponse;
            disabledSettings,
    public void test_doRun_RefreshesRules() {
import org.opensearch.rule.autotagging.Rule;
     * by logging the failure without throwing an exception.
        for (Rule rule : previousRules) {
            existingRules.add(getRandomRule(randomRuleId));
            return null;
            if (randomBoolean()) {
        Settings disabledSettings = Settings.builder()
        when(getRuleResponse.getRules()).thenReturn(existingRules);
import org.opensearch.rule.autotagging.FeatureType;
            return null;
import org.opensearch.index.IndexNotFoundException;
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
            .description("test description")
import org.opensearch.threadpool.ThreadPool;
        verify(scheduledFuture, times(1)).cancel();
        sut.doRun();
    }
        Rule rule = Rule.builder()
        doAnswer(invocation -> {
        Map<Attribute, Set<String>> attributeSetMap = Map.of(AutoTaggingActionFilterTests.TestAttribute.TEST_ATTRIBUTE, Set.of("test"));
        verify(ruleProcessingService, times(0)).add(any(Rule.class));
            ruleEventClassifier,
        Set<Rule> previousRules = new HashSet<>(existingRules);
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
    @SuppressWarnings("unchecked")
        }
    public void testDoStop() {
        }).when(rulePersistenceService).getRule(any(GetRuleRequest.class), any(ActionListener.class));
        // add new rule
            ActionListener<GetRuleResponse> listener = invocation.getArgument(1);
    public void testDoRunIgnoresIndexNotFoundException() {
import org.opensearch.threadpool.Scheduler;
import org.opensearch.plugin.wlm.AutoTaggingActionFilterTests;
        for (int i = 0; i < 10; i++) {
        List<Rule> existingRules = new ArrayList<>();
        when(getRuleResponse.getRules()).thenReturn(List.of(rule));
            attributeValueStoreFactory = new AttributeValueStoreFactory(featureType, DefaultAttributeValueStore::new);
     * Test case for the doRun() method.
        sut.doStart();
        sut.doClose();
        verify(mockThreadPool, times(1)).scheduleWithFixedDelay(any(), any(), any());
        super.tearDown();
 * this file be licensed under the Apache-2.0 license or a
        sut.doStop();
        sut.doStart();
    public void tearDown() throws Exception {
import java.io.IOException;
        verify(scheduledFuture, times(1)).cancel();
    }
            listener.onFailure(new IndexNotFoundException("rules index not found"));
                // since we are updating a new existing rule but we have marked it for deletion above hence decrement it
    WlmClusterSettingValuesProvider nonPluginSettingValuesProvider;
 *
            .build();
                deletionEventCount--;
        sut.doStart();
        sut = new RefreshBasedSyncMechanism(
        sut.doRun();
                mockThreadPool,
            featureType,
            }
import static org.mockito.Mockito.verify;
            scheduledFuture = mock(Scheduler.Cancellable.class);
    }
        super.setUp();
        sut.doRun();
    @SuppressWarnings("unchecked")
        verify(ruleProcessingService, times(updateEventCount + 1 + 10)).add(any(Rule.class));
