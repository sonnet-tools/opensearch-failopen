        }
        private final long failedLoadingTemplates;
            logger.debug(
    );
     * feature flag is set. Enforcing this at settings-update validation time rejects the update up front instead of
@ExperimentalApi
    }
    private final List<SystemTemplatesPlugin> systemTemplatesPluginList;
        }
        List<Exception> exceptions = new ArrayList<>();
        // Runs as the settings-update consumer at apply time and only assigns; the feature-flag gate is enforced up
    /**
        }
            throw new IllegalArgumentException(
                                ex
    }
        int failedLoadingRepositories = 0;
                        } catch (Exception ex) {
                    );
        List<SystemTemplatesPlugin> systemTemplatesPluginList,
        threadPool.generic().execute(() -> refreshTemplates(false));
                    logger.debug(
 *
    public static class Stats {
                                    "Failed loading template  {} from repository: {}",
            // End exceptionally if invoked in verification context
                    exceptions.add(ex);
                try (SystemTemplateRepository repository = plugin.loadRepository()) {
    }
    private volatile Stats latestStats;
                            logger.error(
    public void onClusterManager() {
            for (SystemTemplatesPlugin plugin : systemTemplatesPluginList) {
                failedLoadingRepositories
                    final TemplateRepositoryMetadata repositoryMetadata = repository.metadata();
            if (verification && (failedLoadingRepositories > 0 || failedLoadingTemplates > 0)) {
            }
        ThreadPool threadPool,
    }
                latestStats = new Stats(templatesLoaded, failedLoadingTemplates, failedLoadingRepositories);
        // do nothing
            return templatesLoaded;
        Setting.Property.Dynamic,
 */
import org.opensearch.common.annotation.ExperimentalApi;
import org.apache.logging.log4j.LogManager;
                            );
                                    repositoryMetadata.id()
import java.util.List;
package org.opensearch.cluster.applicationtemplates;
        public long getTemplatesLoaded() {
    public void verifyRepositories() {
    void refreshTemplates(boolean verification) {
                templatesLoaded,
                            exceptions.add(ex);
        }
                                ),
 * SPDX-License-Identifier: Apache-2.0
            );
import org.opensearch.common.settings.ClusterSettings;
        enabledTemplates = enabled;
        private final long failedLoadingRepositories;
    private static void ensureFeatureFlagEnabledForApplicationTemplates(boolean enabled) {
                            final SystemTemplate template = repository.getTemplate(templateMetadata);
/**
/*
        }
        }
        int templatesLoaded = 0;
        return latestStats;
    public SystemTemplatesService(
        public long getFailedLoadingRepositories() {
 * The OpenSearch Contributors require contributions made to
    }
                                templatesLoaded++;
        private final long templatesLoaded;
        clusterSettings.addSettingsUpdateConsumer(SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED, this::setEnabledTemplates);
    }
        public long getFailedLoadingTemplates() {
        false,
            return failedLoadingRepositories;
            return failedLoadingTemplates;
                        repositoryMetadata.version()
        Settings settings
                throw new IllegalStateException("Some of the repositories could not be loaded or are corrupted: " + exceptions);
    private static final Logger logger = LogManager.getLogger(SystemTemplatesService.class);
import java.util.ArrayList;
                    + " feature flag."
    private void setEnabledTemplates(boolean enabled) {
        int failedLoadingTemplates = 0;
     * Validates that the application-based configuration templates feature can only be enabled when its experimental
    }
        ClusterSettings clusterSettings,
    public static final Setting<Boolean> SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED = Setting.boolSetting(
     * {@code _cluster/settings} update, so throwing on {@code false} would reject unrelated updates cluster-wide.
        if ((verification || loaded.compareAndSet(false, true)) && enabledTemplates) {
                    + FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING.getKey()
    }
    ) {
    private final AtomicBoolean loaded = new AtomicBoolean(false);
import org.opensearch.cluster.LocalNodeClusterManagerListener;
     * Class to record stats for templates loaded through the listener in a single iteration.
                    for (SystemTemplateMetadata templateMetadata : repository.listTemplates()) {
}
import org.apache.logging.log4j.message.ParameterizedMessage;
            this.failedLoadingTemplates = failedLoadingTemplates;
                } catch (Exception ex) {
        }
                    failedLoadingRepositories++;
     */
            this.templatesLoaded = templatesLoaded;
    }
     */
                failedLoadingTemplates,
                "Application Based Configuration Templates is under an experimental feature and can be activated only by enabling "
    private volatile boolean enabledTemplates;
        "cluster.application_templates.enabled",
        public Stats(long templatesLoaded, long failedLoadingTemplates, long failedLoadingRepositories) {
        @Override
                }
 */
                    }
            );
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
 * compatible open source license.
     * settings-update validation runs every registered setting's validator against its current/default value on every
    @Override
import org.opensearch.common.settings.Setting;
        Setting.Property.NodeScope
        this.systemTemplatesPluginList = systemTemplatesPluginList;
            setEnabledTemplates(settings.getAsBoolean(SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey(), false));
        if (enabled && !FeatureFlags.isEnabled(FeatureFlags.APPLICATION_BASED_CONFIGURATION_TEMPLATES_SETTING)) {
                    logger.error(new ParameterizedMessage("Failed loading repository from plugin: {}", plugin.getClass().getName()), ex);
        this.threadPool = threadPool;
import java.util.concurrent.atomic.AtomicBoolean;
    @Override
                        try {
                            failedLoadingTemplates++;
                        "Loading templates from repository: {} at version {}",
            ensureFeatureFlagEnabledForApplicationTemplates(value);
                "Stats: Total Loaded Templates: [{}], Failed Loading Templates: [{}], Failed Loading Repositories: [{}]",
    /**
                        repositoryMetadata.id(),
    }
        new ApplicationTemplatesEnabledValidator(),
    public void offClusterManager() {
        refreshTemplates(true);
                                    templateMetadata.fullyQualifiedName(),
     * throwing while the committed cluster state is applied (which would destabilize the cluster-manager).
                            // Load plugin if not in verification phase.
                                new ParameterizedMessage(
        // startup). Throwing here would instead fail while cluster state is applied, destabilizing the cluster-manager.
    private final ThreadPool threadPool;
import org.opensearch.threadpool.ThreadPool;
        // front by ApplicationTemplatesEnabledValidator at settings-validation time (and on the setting's default at
    @ExperimentalApi
import org.apache.logging.log4j.Logger;
public class SystemTemplatesService implements LocalNodeClusterManagerListener {
     * The check only fires when the incoming value is {@code true}. A {@code false} (or default) value must always pass:
 * Service class to orchestrate execution around available templates' management.
            }
        latestStats = new Stats(templatesLoaded, failedLoadingTemplates, failedLoadingRepositories);
                        }
        }
            this.failedLoadingRepositories = failedLoadingRepositories;
        if (settings.getAsBoolean(SETTING_APPLICATION_BASED_CONFIGURATION_TEMPLATES_ENABLED.getKey(), false)) {
    public Stats stats() {
                            if (!verification && plugin.loaderFor(templateMetadata).loadTemplate(template)) {
     * <p>
                            }
import org.opensearch.common.util.FeatureFlags;
        public void validate(Boolean value) {
    static final class ApplicationTemplatesEnabledValidator implements Setting.Validator<Boolean> {
