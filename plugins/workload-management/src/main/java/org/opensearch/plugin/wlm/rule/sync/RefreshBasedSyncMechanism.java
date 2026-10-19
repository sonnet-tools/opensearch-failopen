import org.opensearch.common.settings.Setting;
    );  
    private volatile Scheduler.Cancellable scheduledFuture;
        ThreadPool threadPool,  
        this.featureType = featureType;  
import java.io.IOException;  
                        return;  
     */  
     * Setting to control the run interval of synchronization service
    protected void doStart() {  
     */
import org.opensearch.index.IndexNotFoundException;
    @Override
     * Constructor
                        logger.debug("Rule index not found, skipping rule processing.");
     * @param ruleEventClassifier
        RULE_SYNC_REFRESH_INTERVAL_DEFAULT_MS,  
     * Minimum value for refresh interval  
        MIN_SYNC_REFRESH_INTERVAL_MS,
package org.opensearch.plugin.wlm.rule.sync;
 *
        );
        FeatureType featureType,
    private final ThreadPool threadPool;
    protected void doClose() throws IOException {
import org.opensearch.threadpool.Scheduler;
 * The OpenSearch Contributors require contributions made to  
            ThreadPool.Names.GENERIC
     *  
        );
    @Override  
    /**
            }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rule.action.GetRuleResponse;
     */
            TimeValue.timeValueMillis(refreshInterval),  
        this.nonPluginSettingValuesProvider = nonPluginSettingValuesProvider;
 */
}  
            new GetRuleRequest(null, Collections.emptyMap(), null, featureType),
import java.util.Set;  
    ) {  
    private final RulePersistenceService rulePersistenceService;
    }
    private long refreshInterval;  
                public void onFailure(Exception e) {  
     */
import org.opensearch.rule.action.GetRuleRequest;
    /**
     * @param rulePersistenceService
import org.opensearch.rule.autotagging.FeatureType;  
            new ActionListener<GetRuleResponse>() {  
    public static final long RULE_SYNC_REFRESH_INTERVAL_DEFAULT_MS = 5000;
        Setting.Property.NodeScope
                    logger.warn("Failed to get rules from persistence service", e);
                    }
    }  
import org.opensearch.threadpool.ThreadPool;  
     * @param featureType  
        rulePersistenceService.getRule(
    private final WlmClusterSettingValuesProvider nonPluginSettingValuesProvider;
 * compatible open source license.
    protected void doStop() {  
            scheduledFuture.cancel();
        Settings settings,
                @Override
     * @param settings
    /**
import org.opensearch.rule.autotagging.Rule;
        this.rulePersistenceService = rulePersistenceService;
    /**
import org.apache.logging.log4j.LogManager;
            return;
                public void onResponse(GetRuleResponse response) {
                    ruleEventClassifier.getRuleEvents(newRules).forEach(RuleEvent::process);  
        this.ruleEventClassifier = ruleEventClassifier;  
        }
    private final FeatureType featureType;
        }  
     * @param nonPluginSettingValuesProvider  
    /**
            this::doRun,
import org.opensearch.plugin.wlm.rule.sync.detect.RuleEventClassifier;
import java.util.Collections;
    }
                    final Set<Rule> newRules = new HashSet<>(response.getRules());  
        if (scheduledFuture != null) {
     * but theoretically possible  
    public static final int MIN_SYNC_REFRESH_INTERVAL_MS = 1000;
    public static final Setting<Long> RULE_SYNC_REFRESH_INTERVAL_SETTING = Setting.longSetting(
                    ruleEventClassifier.setPreviousRules(lastRunIndexedRules);
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
import org.opensearch.rule.RulePersistenceService;  
public class RefreshBasedSyncMechanism extends AbstractLifecycleComponent {
        WlmClusterSettingValuesProvider nonPluginSettingValuesProvider
import org.apache.logging.log4j.Logger;
     * Default value for refresh interval
    /**  
        RuleEventClassifier ruleEventClassifier,
/**
     * synchronized check is needed in case two scheduled runs happen concurrently though highly improbable
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;  
import org.opensearch.common.settings.Settings;
    // This var keeps the Rules which were present during last run of this service  
     * @param threadPool
    synchronized void doRun() {
    }  
    @Override
    private static final Logger logger = LogManager.getLogger(RefreshBasedSyncMechanism.class);
import org.opensearch.wlm.WlmMode;
        if (scheduledFuture != null) {
    }
 */  
                @Override
     */
import java.util.HashSet;
 * SPDX-License-Identifier: Apache-2.0
     * Setting name to control the refresh interval of synchronization service
            scheduledFuture.cancel();  
import org.opensearch.common.unit.TimeValue;  
    public RefreshBasedSyncMechanism(
        if (nonPluginSettingValuesProvider.getWlmMode() != WlmMode.ENABLED) {  
                }  
        this.lastRunIndexedRules = new HashSet<>();
    private Set<Rule> lastRunIndexedRules;
        refreshInterval = RULE_SYNC_REFRESH_INTERVAL_SETTING.get(settings);
        scheduledFuture = threadPool.scheduleWithFixedDelay(
                }  
        RulePersistenceService rulePersistenceService,  
     */  
import org.opensearch.plugin.wlm.rule.sync.detect.RuleEvent;
 * This class pulls the latest rules from the RULES system index to update the in-memory view  
import org.opensearch.core.action.ActionListener;
                    lastRunIndexedRules = newRules;
        RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME,
                    if (e instanceof IndexNotFoundException) {
        this.threadPool = threadPool;
    private final RuleEventClassifier ruleEventClassifier;  
/*  
    public static final String RULE_SYNC_REFRESH_INTERVAL_SETTING_NAME = "wlm.rule.sync_refresh_interval_ms";  
        }
