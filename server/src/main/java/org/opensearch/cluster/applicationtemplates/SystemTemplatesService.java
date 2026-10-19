    }
 * compatible open source license.
@ExperimentalApi
                            }  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        clusterSettings.addSettingsUpdateConsumer(SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED, this::setEnabledTemplates);  
        return latestStats;  
                try (SystemTemplateRepository repository = plugin.loadRepository()) {
 * Service class to orchestrate execution around available templates' management.
            }
import org.opensearch.cluster.LocalNodeClusterManagerListener;
        }
        ClusterSettings clusterSettings,
 */  
import java.util.List;
                        "Loading templates from repository: {} at version {}",  
            }  
                    logger.debug(
                    failedLoadingRepositories++;
     * settings-update validation runs every registered setting's validator against its current/default value on every  
                    for (SystemTemplateMetadata templateMetadata : repository.listTemplates()) {
                templatesLoaded,  
                    }
        "cluster.application_templates.enabled",
                failedLoadingTemplates,
import org.opensearch.threadpool.ThreadPool;
    public static final Setting<Boolean> SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED = Setting.boolSetting(
     * {@code _cluster/settings} update, so throwing on {@code false} would reject unrelated updates cluster-wide.
        Settings settings
                                    repositoryMetadata.id()
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.FeatureFlags;  
    private volatile Stats latestStats;  
                                templatesLoaded++;
 *
import org.apache.logging.log4j.Logger;
    }  
        if (enabled && !FeatureFlags.isEnabled(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING)) {
        }  
                                ),  
            logger.debug(
import java.util.concurrent.atomic.AtomicBoolean;
    private static final Logger logger = LogManager.getLogger(SystemTemplatesService.class);
            for (SystemTemplatesPlugin plugin : systemTemplatesPluginList) {
    private void setEnabledTemplates(boolean enabled) {  
        }
    /**
            this.templatesLoaded = templatesLoaded;
    public void verifyRepositories() {
    private static void ensureFeatureFlagEnabledForApplicationTemplates(boolean enabled) {
    }
                        } catch (Exception ex) {
        Setting.Property.Dynamic,
import org.opensearch.common.settings.Settings;
    }  
                    + " feature flag."  
                "Application Based Configuration Templates is under an experimental feature and can be activated only by enabling "
    public SystemTemplatesService(
                                    "Failed loading template  {} from repository: {}",  
    public void onClusterManager() {
                        }
                            final SystemTemplate template = repository.getTemplate(templateMetadata);
        public void validate(Boolean value) {
        }
     */  
/**
import java.util.ArrayList;  
                } catch (Exception ex) {  
                            logger.error(
package org.opensearch.cluster.applicationtemplates;
 * this file be licensed under the Apache-2.0 license or a
        public long getFailedLoadingRepositories() {  
    }
        Setting.Property.NodeScope  
}
    ) {  
import org.opensearch.common.settings.ClusterSettings;  
                                    templateMetadata.fullyQualifiedName(),
    private final ThreadPool threadPool;  
    }
        latestStats = new Stats(templatesLoaded, failedLoadingTemplates, failedLoadingRepositories);  
        private final long templatesLoaded;  
        public Stats(long templatesLoaded, long failedLoadingTemplates, long failedLoadingRepositories) {
    public static class Stats {
            // End exceptionally if invoked in verification context
    /**  
public class SystemTemplatesService implements LocalNodeClusterManagerListener {
        // do nothing
     * Validates that the application-based configuration templates feature can only be enabled when its experimental
        // Runs as the settings-update consumer at apply time and only assigns; the feature-flag gate is enforced up
import org.opensearch.common.settings.Setting;
    private volatile boolean enabledTemplates;
                                new ParameterizedMessage(
                                ex
                    );  
    @Override  
            if (verification && (failedLoadingRepositories > 0 || failedLoadingTemplates > 0)) {  
    @ExperimentalApi
    void refreshTemplates(boolean verification) {  
                    exceptions.add(ex);
    public void offClusterManager() {  
    }
 * SPDX-License-Identifier: Apache-2.0
                        repositoryMetadata.id(),
        threadPool.generic().execute(() -> refreshTemplates(false));
            );
        this.threadPool = threadPool;
                            if (!verification && plugin.loaderFor(templateMetadata).loadTemplate(template)) {
        if (settings.getAsBoolean(SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey(), false)) {  
        @Override
        public long getFailedLoadingTemplates() {
            this.failedLoadingTemplates = failedLoadingTemplates;  
                latestStats = new Stats(templatesLoaded, failedLoadingTemplates, failedLoadingRepositories);
                    + FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING.getKey()
        new ApplicationTemplatesEnabledValidator(),
                            );
                        repositoryMetadata.version()
                "Stats: Total Loaded Templates: [{}], Failed Loading Templates: [{}], Failed Loading Repositories: [{}]",
        ThreadPool threadPool,  
    );
            ensureFeatureFlagEnabledForApplicationTemplates(value);  
     */
    }  
     * Class to record stats for templates loaded through the listener in a single iteration.
        }
                throw new IllegalStateException("Some of the repositories could not be loaded or are corrupted: " + exceptions);
        List<Exception> exceptions = new ArrayList<>();
/*  
import org.apache.logging.log4j.LogManager;
            return templatesLoaded;
        }
        // startup). Throwing here would instead fail while cluster state is applied, destabilizing the cluster-manager.  
        int failedLoadingRepositories = 0;  
            return failedLoadingTemplates;  
            throw new IllegalArgumentException(  
        int failedLoadingTemplates = 0;
            setEnabledTemplates(settings.getAsBoolean(SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey(), false));
                            // Load plugin if not in verification phase.  
        private final long failedLoadingRepositories;
     * throwing while the committed cluster state is applied (which would destabilize the cluster-manager).  
        refreshTemplates(true);
     * <p>
    public Stats stats() {
        if ((verification || loaded.compareAndSet(false, true)) && enabledTemplates) {  
                            failedLoadingTemplates++;  
        // front by ApplicationTemplatesEnabledValidator at settings-validation time (and on the setting's default at
    static final class ApplicationTemplatesEnabledValidator implements Setting.Validator<Boolean> {  
                            exceptions.add(ex);  
        int templatesLoaded = 0;
    private final AtomicBoolean loaded = new AtomicBoolean(false);
        }
        }
                        try {  
    private final List<SystemTemplatesPlugin> systemTemplatesPluginList;
            );  
                failedLoadingRepositories
        List<SystemTemplatesPlugin> systemTemplatesPluginList,
    @Override
        this.systemTemplatesPluginList = systemTemplatesPluginList;
        false,  
        enabledTemplates = enabled;
                }
                    logger.error(new ParameterizedMessage("Failed loading repository from plugin: {}", plugin.getClass().getName()), ex);  
        private final long failedLoadingTemplates;
            this.failedLoadingRepositories = failedLoadingRepositories;
    }  
     * feature flag is set. Enforcing this at settings-update validation time rejects the update up front instead of
    }
        public long getTemplatesLoaded() {
            return failedLoadingRepositories;
import org.opensearch.common.annotation.ExperimentalApi;
     * The check only fires when the incoming value is {@code true}. A {@code false} (or default) value must always pass:
                    final TemplateRepositoryMetadata repositoryMetadata = repository.metadata();
 */  
