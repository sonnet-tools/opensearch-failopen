    static final String USE_CONTEXT_RATE_KEY = "use-context";
            Property.Dynamic
    static class CacheHolder {
 * this work for additional information regarding copyright
        }
            logger.debug("Replaced context [" + name + "] with new settings");
        return infos;
            return;
            idOrCode = source.getSource();
            }
     * while the new cluster state is applied (which would destabilize the cluster-manager).
        return engines.containsKey(lang);
 *
        ScriptEngine scriptEngine = engines.get(lang);
                    + "] requires ["
    private final Map<String, ScriptContext<?>> contexts;
        for (Map.Entry<String, StoredScriptSource> source : storedScripts.entrySet()) {
        clusterState = event.state();
        // Update
     * This is overridden in tests to disable compilation rate limiting.
                        );
            SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings),
        this.setCacheHolder(settings);
    public static final Setting<Integer> SCRIPT_MAX_SIZE_IN_BYTES = Setting.intSetting(
            }
import java.util.Set;
/*
        ScriptMetadata scriptMetadata = clusterState.metadata().custom(ScriptMetadata.TYPE);
                    if (typesAllowedList.size() != 1) {
 *
                            "cannot specify both ["
                        + idOrCode
import java.util.Collections;
            return null;
                    SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(context.name),
                    + String.join(", ", keys)
 *
                    "Cannot set custom general compilation rates ["
                throw new IllegalArgumentException(
import org.opensearch.core.action.ActionListener;
     * @return a compiled script which may be used to construct instances of a script for the given context
            SCRIPT_CACHE_EXPIRE_SETTING,
                @Override
        Setting.Property.NodeScope
    }
            general = null;
        ScriptCacheStats cacheStats() {
        if (current == null) {
        return new ScriptCache(cacheSize, cacheExpire, rate, rateSetting.getKey());
        Property.Deprecated
        ClusterService clusterService,
            for (Map.Entry<String, AtomicReference<ScriptCache>> entry : contextCache.entrySet()) {
            // * lang and options will both be null when looking up a stored script,
    private static final Logger logger = LogManager.getLogger(ScriptService.class);
    public ScriptLanguagesInfo getScriptLanguages() {
                                + ALLOW_NONE
            keys.sort(Comparator.naturalOrder());
        if (SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING.get(settings)) {
import java.util.List;
    public void close() throws IOException {
import org.opensearch.cluster.service.ClusterService;
    public static final Setting.AffixSetting<TimeValue> SCRIPT_CACHE_EXPIRE_SETTING = Setting.affixKeySetting(
 * GitHub history for details.
    );
    CacheHolder contextCacheHolder(Settings settings) {
                                + " and other script types for setting ["
        if (scriptMetadata != null) {
                    customRates.add(s);
        return cacheHolder.get().stats();
            ref.set(cache);
import org.opensearch.core.common.Strings;
import org.opensearch.common.settings.Setting.Property;
        assert scriptCache != null : "script context [" + context.name + "] has no script cache";
    private final Set<String> contextsAllowed;
        "script.allowed_contexts",
            if (general != null) {
            Map<String, AtomicReference<ScriptCache>> refs = new HashMap<>(context.size());
            int storedSize = source.getValue().getSource().getBytes(StandardCharsets.UTF_8).length;
            cacheHolder.set(generalCacheHolder(settings));
        } catch (Exception exception) {
        ClusterManagerTaskThrottler.ThrottlingKey deleteScriptTaskKey,
        if (isLangSupported(source.getLang()) == false) {
            AtomicReference<ScriptCache> ref = contextCache.get(name);
     */
                (settings) -> cacheHolder.get().set(context.name, contextCache(settings, context)),
        }
        }
            for (String settingContext : contextsAllowedList) {
    );
                    + request.content().length()
            contextCache = null;
import java.util.concurrent.atomic.AtomicReference;
    }
            List<ScriptContextStats> contextStats = new ArrayList<>(contextCache.size());
        IOUtils.close(engines.values());
        String lang = script.getLang();
            return new ScriptCacheStats(context);
                    throw new IllegalArgumentException("Unknown context [" + request.context() + "]");
/*
        Property.Deprecated
 * under the License.
            if (contextsAllowedList.isEmpty()) {
        }
                if (context == null) {
@PublicApi(since = "1.0.0")
    private static final ScriptCache.CompilationRate SCRIPT_COMPILATION_RATE_ZERO = new ScriptCache.CompilationRate(0, TimeValue.ZERO);
    private final Map<String, ScriptEngine> engines;
        } catch (ScriptException good) {
        TimeValue cacheExpire = cacheExpireSetting.existsOrFallbackExists(settings)
        CacheHolder(int cacheMaxSize, TimeValue cacheExpire, ScriptCache.CompilationRate maxCompilationRate, String contextRateSetting) {
        this.contexts = Objects.requireNonNull(contexts);
        ScriptStats stats() {
                                + TYPES_ALLOWED_SETTING.getKey()
                }
        Collections.emptyList(),
    ) {
        "cache_expire",
        maxSizeInBytes = newMaxSizeInBytes;
        }
        Map<String, Set<String>> languageContexts = new HashMap<>();
                    smd = ScriptMetadata.putStoredScript(smd, request.id(), source);
            options = source.getOptions();
    public static final Setting.AffixSetting<ScriptCache.CompilationRate> SCRIPT_MAX_COMPILATIONS_RATE_SETTING = Setting.affixKeySetting(
            return Collections.emptyMap();
        List<String> keys = new ArrayList<>();
     * <p>
        DeleteStoredScriptRequest request,
import java.io.IOException;
                    + " is not a supported setting, replace with "
                String s = affix.getConcreteSettingForNamespace(context).getKey();
/*
            Property.NodeScope,
        );
                    + maxSizeInBytes
        int cacheSize = cacheSizeSetting.existsOrFallbackExists(settings) ? cacheSizeSetting.get(settings) : context.cacheSizeDefault;
                        throw new IllegalArgumentException(
     * Changes the maximum number of bytes a script's source is allowed to have.
                if (contexts.containsKey(context) == false) {
                }
            key,
        TimeValue.timeValueMillis(0),
            AtomicReference<ScriptCache> ref = contextCache.get(context);
            }
    public void putStoredScript(
import java.util.Map;
    public boolean isLangSupported(String lang) {
                );
        CacheHolder current = cacheHolder.get();
        }
    private ClusterState clusterState;
    }
    public boolean isContextEnabled(ScriptContext<?> scriptContext) {
    /**
                context.put(name, contextCache.get(name).get().stats());
    public Set<ScriptContextInfo> getContextInfos() {
    Map<String, StoredScriptSource> getScriptsFromClusterState() {
                    + "] for script ["
            cacheHolder.set(generalCacheHolder(settings));
        if (scriptEngine == null) {
            if (ref == null) {
            throw new ResourceNotFoundException("unable to find script [" + id + "] in cluster state");
    }
                if (ALLOW_NONE.equals(settingType)) {
        } else {
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
        List<String> customRates = new ArrayList<>();
import java.util.Comparator;
        USE_CONTEXT_RATE_KEY,
            (key, value) -> languageContexts.put(
        Property.NodeScope,
    );
    public static final Setting<TimeValue> SCRIPT_GENERAL_CACHE_EXPIRE_SETTING = Setting.positiveTimeSetting(
        this.validateCacheSettings(settings);
                    ScriptMetadata smd = currentState.metadata().custom(ScriptMetadata.TYPE);
        return typesAllowed == null || typesAllowed.contains(scriptType.getName());
                    } else {
        }
    @Override
    static final ScriptCache.CompilationRate USE_CONTEXT_RATE_VALUE = new ScriptCache.CompilationRate(-1, TimeValue.MINUS_ONE);
            if (typesAllowedList.isEmpty()) {
    public static void validateMaxSizeInBytes(int newMaxSizeInBytes, ClusterState clusterState) {
            }
                if (affix.equals(SCRIPT_MAX_COMPILATIONS_RATE_SETTING)) {
            if (storedSize > newMaxSizeInBytes) {
import org.opensearch.cluster.ClusterState;
    }
import java.util.ArrayList;
                    } else {
import org.opensearch.common.annotation.PublicApi;
    }
    @Override
            }
                    SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(context.name),
        Property.NodeScope
                SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING,
                return general;
     * cluster-settings update transport action, so an invalid value is rejected before commit rather than throwing
        if (contexts.containsKey(context.name) == false) {
 */
    public ScriptService(Settings settings, Map<String, ScriptEngine> engines, Map<String, ScriptContext<?>> contexts) {
                    + "]"
            (settings) -> setCacheHolder(settings),
import java.util.HashMap;
                    "cannot put [" + ScriptType.STORED + "] script, [" + ScriptType.STORED + "] scripts are not enabled"
import org.opensearch.common.util.io.IOUtils;
    }
        ScriptType type = script.getType();
        return contextsAllowed == null || contextsAllowed.isEmpty() == false;
            ? cacheExpireSetting.get(settings)
                @Override
            new AckedClusterStateUpdateTask<AcknowledgedResponse>(request, listener) {
                key,
        Property.NodeScope,
            // context is supported
                        + "]"
        return cacheHolder.get().cacheStats();
        Property.Dynamic,
                    + "using `script.disable_dynamic: false` in opensearch.yml"
                );
        Set<ScriptContextInfo> infos = new HashSet<ScriptContextInfo>(contexts.size());
            ScriptEngine scriptEngine = getEngine(source.getLang());
     */
            contextCache = Collections.unmodifiableMap(refs);
        false,
     * cluster state so that an invalid value is rejected before it is committed and applied, rather than throwing while
    }
        }
        clusterSettings.addSettingsUpdateConsumer(
        }
        return true;
        ScriptMetadata scriptMetadata = state.metadata().custom(ScriptMetadata.TYPE);
                    SCRIPT_GENERAL_CACHE_SIZE_SETTING
    private static void validateMaxSizeInBytes(int newMaxSizeInBytes, Map<String, StoredScriptSource> storedScripts) {
                );
     * This invariant depends on cluster state (the stored scripts), so it cannot be expressed by a stateless
                        );
            "delete-script-" + request.id(),
        String idOrCode = script.getIdOrCode();
    /*
        if (scriptMetadata == null) {
                );
     * <p>
            Map<String, ScriptStats> context = new HashMap<>(contextCache.size());
                    throw new IllegalArgumentException(
import org.opensearch.cluster.AckedClusterStateUpdateTask;
                    + request.id()
                return;
                keys.add(s);
 * this file be licensed under the Apache-2.0 license or a
    // specific caches
        key -> Setting.intSetting(key, SCRIPT_GENERAL_CACHE_SIZE_SETTING, 0, Property.NodeScope, Property.Dynamic)
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            }
            SCRIPT_MAX_COMPILATIONS_RATE_SETTING,
    }
                public ClusterState execute(ClusterState currentState) throws Exception {
        } else if (current.general == null) {
                ScriptContext<?> context = contexts.get(request.context());
            throw new IllegalArgumentException("unable to put stored script with unsupported lang [" + source.getLang() + "]");
import org.opensearch.common.settings.ClusterSettings;
     * when using the general cache.
            }
        String id = idOrCode;
        clusterSettings.addSettingsUpdateConsumer(SCRIPT_MAX_SIZE_IN_BYTES, this::setMaxSizeInBytes);
            } else if (request.context() != null) {
                }
                        + storedSize
                    // general settings used for fallbacks
    }
        }
                    this.contextsAllowed.add(settingContext);
                throw new IllegalArgumentException("cannot put [" + ScriptType.STORED + "] script, no script contexts are enabled");
    }
    /**
     * @param clusterState the cluster state whose stored scripts the new value must accommodate
        if (type == ScriptType.INLINE) {
        "script.cache.max_size",
        }
public class ScriptService implements Closeable, ClusterStateApplier {
 * specific language governing permissions and limitations
            SCRIPT_CACHE_SIZE_SETTING
        }
        boolean useContext = SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings).equals(USE_CONTEXT_RATE_VALUE);
import org.opensearch.common.settings.Settings;
                        + newMaxSizeInBytes
                }
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        ClusterService clusterService,
 * KIND, either express or implied.  See the License for the
                    SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace(context.name),
 * @opensearch.api
     *
                @Override
        Map<String, String> options = script.getOptions();
            return;
            }
     *
    }
import org.opensearch.common.settings.Setting;
        validateMaxSizeInBytes(newMaxSizeInBytes, scriptMetadata.getStoredScripts());
            this::validateCacheSettings
        }
            // General compilation rate changed, that setting is the only dynamically updated general setting
        boolean useContext = SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings).equals(USE_CONTEXT_RATE_VALUE);
import java.io.Closeable;
        );
        Function.identity(),
        ActionListener<AcknowledgedResponse> listener
        final ScriptCache general;
     * @throws IllegalArgumentException if any stored script is larger than the proposed maximum
    );
 * SPDX-License-Identifier: Apache-2.0
     * 2) context mode, if the context script cache is configured.  There is no general cache in this case.
                                + CONTEXTS_ALLOWED_SETTING.getKey()
            }
                        break;
            return ScriptStats.aggregate(contextStats);
            if (general != null) {
        this.engines = Objects.requireNonNull(engines);
                SCRIPT_GENERAL_CACHE_SIZE_SETTING,
                throw new IllegalArgumentException(
            types = new HashSet<>();
        );
                SCRIPT_CACHE_EXPIRE_SETTING,
    }
            for (ScriptType type : ScriptType.values()) {
    private ScriptEngine getEngine(String lang) {
     * Compiles a script using the given context.
                "exceeded max allowed stored script size in bytes ["
 * compatible open source license.
 * Service for scripting
                cacheHolder.set(generalCacheHolder(settings));
                        + String.join(", ", customRates)
     * Throw an IllegalArgumentException if any per-context setting does not match a context or if per-context settings are configured
                }
                if (ALLOW_NONE.equals(settingContext)) {
    public static final String ALLOW_NONE = "none";
        Property.NodeScope
     */
    // script.context.<context-name>.{cache_max_size, cache_expire, max_compilations_rate}
            SCRIPT_GENERAL_CACHE_EXPIRE_SETTING.get(settings),
    );
    // package private for tests
    void validateCacheSettings(Settings settings) {
            if (current.general != null) {
        PutStoredScriptRequest request,
        100,
     * Container for the ScriptCache(s).  This class operates in two modes:
 * software distributed under the License is distributed on an
        0,
    }
            for (String settingType : typesAllowedList) {
            // so we must get the source to retrieve them before checking if the
        }
    public static final Setting<ScriptCache.CompilationRate> SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING = new Setting<>(
     */
    /**
            }
        Map<String, ScriptCache> contextCache = new HashMap<>(contexts.size());
    private final Set<String> typesAllowed;
                    }
        );
    }
                customRates.sort(Comparator.naturalOrder());
 */
                        + "]"
                        + "]"
        Setting<Integer> cacheSizeSetting = SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(context.name);
        key -> new Setting<ScriptCache.CompilationRate>(
        }
import org.apache.logging.log4j.LogManager;
    void setMaxSizeInBytes(int newMaxSizeInBytes) {
            );
    static final String DISABLE_DYNAMIC_SCRIPTING_SETTING = "script.disable_dynamic";
    }
        }
        CacheHolder(Map<String, ScriptCache> context) {
            assert ref != null : "expected script cache to exist for context [" + name + "]";
                SCRIPT_GENERAL_CACHE_EXPIRE_SETTING,
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;
                throw new IllegalArgumentException(
 * The OpenSearch Contributors require contributions made to
            general = new ScriptCache(cacheMaxSize, cacheExpire, maxCompilationRate, contextRateSetting);
                    throw new IllegalArgumentException(
        );
            context.forEach((k, v) -> refs.put(k, new AtomicReference<>(v)));
    }
        ClusterManagerTaskThrottler.ThrottlingKey putStoreTaskKey,
                    Metadata.Builder mdb = Metadata.builder(currentState.getMetadata()).putCustom(ScriptMetadata.TYPE, smd);
        "max_compilations_rate",
        this.typesAllowed = TYPES_ALLOWED_SETTING.exists(settings) ? new HashSet<>() : null;
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                SCRIPT_CACHE_SIZE_SETTING
                DISABLE_DYNAMIC_SCRIPTING_SETTING
    }
                    Metadata.Builder mdb = Metadata.builder(currentState.getMetadata()).putCustom(ScriptMetadata.TYPE, smd);
        }
         * Update a single context cache if we're in the context cache mode otherwise no-op.
                    }
    }
            if (useContext == false) {
            throw good;
                    if (scriptType.getName().equals(settingType)) {
            for (String context : affix.getAsMap(settings).keySet()) {
        List<Setting.AffixSetting<?>> affixes = Arrays.asList(
            : context.cacheExpireDefault;
        return scriptEngine;
        "script.cache.expire",
        Setting<ScriptCache.CompilationRate> rateSetting = SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(
import org.opensearch.cluster.ClusterStateApplier;
        }
        engines.forEach(
    }
                    "must specify at least one script context or none for setting [" + CONTEXTS_ALLOWED_SETTING.getKey() + "]."
        }
        ScriptMetadata scriptMetadata = clusterState.metadata().custom(ScriptMetadata.TYPE);
        (String value) -> value.equals(USE_CONTEXT_RATE_KEY) ? USE_CONTEXT_RATE_VALUE : new ScriptCache.CompilationRate(value),
            "put-script-" + request.id(),
        return new CacheHolder(contextCache);
                        + "]"
    }
            if (general != null) {
                types.add(type.getName());
                        + SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING.getKey()
            } else {
        Setting<TimeValue> cacheExpireSetting = SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace(context.name);
        ScriptCache scriptCache = cacheHolder.get().get(context.name);
        return contextsAllowed == null || contextsAllowed.contains(scriptContext.name);
                        + SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings)
            if (customRates.size() > 0) {
        );
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;
        "script.max_size_in_bytes",
        if (request.content().length() > maxSizeInBytes) {
                @Override
                    return new AcknowledgedResponse(acknowledged);
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
            rate = rateSetting.get(settings);
import org.apache.logging.log4j.Logger;
        "script.allowed_types",
                    );
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
            "75/5m",
        if (useContext) {
    // Per-context settings
            return scriptMetadata.getStoredScript(request.id());
            } else if (isAnyContextEnabled() == false) {
        } else if (rateSetting.existsOrFallbackExists(settings)) {
                    smd = ScriptMetadata.deleteStoredScript(smd, request.id());
        "script.disable_max_compilations_rate",
    // Special setting value for SCRIPT_GENERAL_MAX_COMPILATIONS_RATE to indicate the script service should use context
        if (scriptMetadata == null) {
                }
 */
                    + "]"
        );
        return scriptCache.compile(context, scriptEngine, id, idOrCode, type, options);
            List<String> contextsAllowedList = CONTEXTS_ALLOWED_SETTING.get(settings);
        0,
                value.getSupportedContexts().stream().map(c -> c.name).filter(contexts::contains).collect(Collectors.toSet())
        "script.max_compilations_rate",
        ScriptCache.CompilationRate rate = null;
import java.util.Arrays;
    boolean compilationLimitsEnabled() {
                                + "]"
                        "unknown script type [" + settingType + "] found in setting [" + TYPES_ALLOWED_SETTING.getKey() + "]."
            lang = source.getLang();
    void setCacheHolder(Settings settings) {
                        + "with size ["
                        + SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING.getKey()
        }
            List<String> typesAllowedList = TYPES_ALLOWED_SETTING.get(settings);
                    return new AcknowledgedResponse(acknowledged);
        Collections.emptyList(),
                } else {
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
        clusterService.submitStateUpdateTask(
                for (ScriptType scriptType : ScriptType.values()) {
        final Set<String> contexts = contextsAllowed != null ? contextsAllowed : this.contexts.keySet();
            SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey()
                    + "] with size ["
        CONTEXT_PREFIX,
            }
        ScriptMetadata scriptMetadata = clusterState.metadata().custom(ScriptMetadata.TYPE);
import org.opensearch.cluster.metadata.Metadata;
                }
        ActionListener<AcknowledgedResponse> listener
        }
    );
            StoredScriptSource source = getScriptFromClusterState(id);
            infos.add(new ScriptContextInfo(context.name, context.instanceClazz));
        final Map<String, AtomicReference<ScriptCache>> contextCache;
            context.name
    public ScriptCacheStats cacheStats() {
        Set<String> types = typesAllowed;
            );
                return null;
        Property.Deprecated
        /**
        if (logger.isTraceEnabled()) {
                    if (contextsAllowedList.size() != 1) {
    static final String UNLIMITED_COMPILATION_RATE_KEY = "unlimited";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                );
                        this.typesAllowed.add(settingType);
import org.opensearch.ResourceNotFoundException;
                }
                    return ClusterState.builder(currentState).metadata(mdb).build();
        } else if (current.general.rate.equals(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings)) == false) {
        }
                        + maxSizeInBytes
            }
            throw new IllegalArgumentException("script context [" + context.name + "] not supported");
                scriptEngine.compile(request.id(), source.getSource(), context, Collections.emptyMap());
            )
                    }
        Setting.Property.NodeScope
            }
 * the Apache License, Version 2.0 (the "License"); you may
    protected StoredScriptSource getScriptFromClusterState(String id) {
            clusterSettings.addSettingsUpdateConsumer(
    );
        CONTEXT_PREFIX,
    public ScriptStats stats() {
import org.opensearch.cluster.ClusterChangedEvent;
     * @param newMaxSizeInBytes The new maximum number of bytes.
                        + "] exceeds the new value with a size of "
                    "Cannot set custom context compilation rates ["
            if (general != null) {
                    "script.max_size_in_bytes cannot be set to ["
                "Context cache settings ["
     * @param newMaxSizeInBytes the proposed new maximum stored-script size in bytes
 * license agreements. See the NOTICE file distributed with
                        + SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey()
                boolean found = false;
                return general.stats();
                )
     * 1) general mode, if the general script cache is configured.  There are no context caches in this case.
        this.contextsAllowed = CONTEXTS_ALLOWED_SETTING.exists(settings) ? new HashSet<>() : null;
    void registerClusterSettingsListeners(ClusterSettings clusterSettings) {
                        + idOrCode.getBytes(StandardCharsets.UTF_8).length
            ScriptCache oldCache = ref.get();
            new AckedClusterStateUpdateTask<AcknowledgedResponse>(request, listener) {
    public static final Setting<List<String>> TYPES_ALLOWED_SETTING = Setting.listSetting(
        "cache_max_size",
    );
                // Flipping to context specific
    public boolean isAnyContextEnabled() {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        /**
    public void deleteStoredScript(
        Function.identity(),
                    "exceeded max allowed inline script size in bytes ["
        if (this.typesAllowed != null) {
    public static final Setting<List<String>> CONTEXTS_ALLOWED_SETTING = Setting.listSetting(
 * ownership. Elasticsearch licenses this file to you under
            );
        CONTEXT_PREFIX,
/**
 * Licensed to Elasticsearch under one or more contributor
        StoredScriptSource source = request.source();
                if (contexts.containsKey(settingContext)) {
    /**
        }
            Arrays.asList(
        }
        )
    ) {
        65535,
        if (useContext == false && keys.isEmpty() == false) {
    public StoredScriptSource getStoredScript(ClusterState state, GetStoredScriptRequest request) {
                    + SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey()
                throw new IllegalArgumentException(
     * Runs as the {@code script.max_size_in_bytes} settings-update consumer at apply time and only assigns. The
                    return ClusterState.builder(currentState).metadata(mdb).build();
                contextStats.add(cache.stats(entry.getKey()));
    }
    CacheHolder generalCacheHolder(Settings settings) {
        for (Setting.AffixSetting<?> affix : affixes) {
            );
            rate = SCRIPT_COMPILATION_RATE_ZERO;
        }
     * the new cluster state is being applied (which would destabilize the cluster-manager).
        }
        key -> Setting.positiveTimeSetting(key, SCRIPT_GENERAL_CACHE_EXPIRE_SETTING, Property.NodeScope, Property.Dynamic)
                        break;
        if (isTypeEnabled(type) == false) {
        if (scriptMetadata == null) {
                        + "["
    public static final Setting<Integer> SCRIPT_GENERAL_CACHE_SIZE_SETTING = Setting.intSetting(
import java.nio.charset.StandardCharsets;
            // the script has been updated since the last compilation
                        + "] "
            logger.trace("compiling lang: [{}] type: [{}] script: {}", lang, type, idOrCode);
                    "must specify at least one script type or none for setting [" + TYPES_ALLOWED_SETTING.getKey() + "]."
    }
                    return deleteScriptTaskKey;
            }
        if (types == null) {
                                + "]."
    }
         */
package org.opensearch.script;
    public static final Setting<Boolean> SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING = Setting.boolSetting(
        ScriptCache get(String context) {
        if (this.contextsAllowed != null) {
            (String value) -> value.equals(UNLIMITED_COMPILATION_RATE_KEY)
            throw new IllegalArgumentException("script_lang not supported [" + lang + "]");
        Objects.requireNonNull(context);
            rate = new ScriptCache.CompilationRate(context.maxCompilationRateDefault);
     */
                public ClusterState execute(ClusterState currentState) throws Exception {
                }
    }
                cacheHolder.set(contextCacheHolder(settings));
        return new CacheHolder(
        return source;
        }
    ScriptCache contextCache(Settings settings, ScriptContext<?> context) {
        this.setMaxSizeInBytes(SCRIPT_MAX_SIZE_IN_BYTES.get(settings));
        try {
         */
                throw new IllegalArgumentException(
    public static final Setting.AffixSetting<Integer> SCRIPT_CACHE_SIZE_SETTING = Setting.affixKeySetting(
            throw new ResourceNotFoundException("unable to find script [" + id + "] in cluster state");
                        + "] for script ["
                }
import org.opensearch.common.unit.TimeValue;
                );
                throw new IllegalArgumentException(
 */
        }
            SCRIPT_GENERAL_CACHE_SIZE_SETTING.get(settings),
            assert oldCache != null : "expected script cache to be non-null for context [" + name + "]";
            // Flipping to general
import java.util.stream.Collectors;
                }
            }
    // Unlimited compilation rate for context-specific script caches
                throw new IllegalArgumentException(
        for (ScriptContext<?> context : contexts.values()) {
                                + " and other script contexts for setting ["
            for (String name : contextCache.keySet()) {
    static final String CONTEXT_PREFIX = "script.context.";
    );
        ScriptEngine scriptEngine = getEngine(lang);
        Property.NodeScope,
 *    http://www.apache.org/licenses/LICENSE-2.0
                        + "] if compile rates disabled via ["
    /**
    public boolean isTypeEnabled(ScriptType scriptType) {
                        + source.getKey()
            }
            throw new IllegalArgumentException("cannot execute [" + type + "] scripts");
        if (SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING.get(settings) || compilationLimitsEnabled() == false) {
                    SCRIPT_GENERAL_CACHE_EXPIRE_SETTING,
            throw new IllegalArgumentException(
            throw new IllegalArgumentException("failed to parse/compile stored script [" + request.id() + "]", exception);
            return ref.get();
            }
                        + "] to ["
            if (isTypeEnabled(ScriptType.STORED) == false) {
            if (useContext) {
        // Validation requires knowing which contexts exist.
        return scriptMetadata.getStoredScripts();
         * get the cache appropriate for the context.  If in general mode, return the general cache.  Otherwise return the ScriptCache for
                        found = true;
                                + "]"
                SCRIPT_MAX_COMPILATIONS_RATE_SETTING,
        } else {
        }
 * You may obtain a copy of the License at
                Arrays.asList(
            }
                            "cannot specify both ["
        }
        if (source == null) {
            ),
        Objects.requireNonNull(lang);
        }
        return new ScriptLanguagesInfo(types, languageContexts);
        if (type == ScriptType.STORED) {
                    + "fine-grained script settings. \n Dynamic scripts can be enabled for all languages and all operations not "
        StoredScriptSource source = scriptMetadata.getStoredScript(id);
                @Override
}
    }
            if (idOrCode.getBytes(StandardCharsets.UTF_8).length > maxSizeInBytes) {
import java.util.function.Function;
        }
            }
                        + "] if compile rates disabled via ["
            return Collections.emptyMap();
                        "unknown script context [" + settingContext + "] found in setting [" + CONTEXTS_ALLOWED_SETTING.getKey() + "]."
        if (isContextEnabled(context) == false) {
        // Handle all updatable per-context settings at once for each context.
            // * a stored script must be pulled from the cluster state every time in case
        }
    }
                                + "]."
                    throw new IllegalArgumentException("Context [" + context + "] doesn't exist for setting [" + s + "]");
            }
                        + "], "
        clusterService.submitStateUpdateTask(
                    );
                    ScriptMetadata smd = currentState.metadata().custom(ScriptMetadata.TYPE);
                        + "stored script ["
                }
        void set(String name, ScriptCache cache) {
    );
        // Handle all settings for context and general caches, this flips between general and context caches.
                @Override
            throw new IllegalArgumentException("cannot execute scripts using [" + context.name + "] context");
 * not use this file except in compliance with the License.
                ? ScriptCache.UNLIMITED_COMPILATION_RATE
            throw new IllegalArgumentException(
                    + "] to be ["
                }
     */
        }
 * Modifications Copyright OpenSearch Contributors. See
            }
                return new ScriptCacheStats(general.stats());
    final AtomicReference<CacheHolder> cacheHolder = new AtomicReference<>();
        for (ScriptContext<?> context : contexts.values()) {
        if (Strings.hasLength(settings.get(DISABLE_DYNAMIC_SCRIPTING_SETTING))) {
    public void applyClusterState(ClusterChangedEvent event) {
        if (clusterState == null) {
        }
     * Validates that {@code script.max_size_in_bytes} is not being lowered below the size of an already stored script.
import java.util.Objects;
                if (found == false) {
                SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING,
                                + ALLOW_NONE
         * the given context. Returns null in context mode if the requested context does not exist.
                    + USE_CONTEXT_RATE_KEY
            throw new IllegalArgumentException(
 *
                        throw new IllegalArgumentException(
                }
                ScriptCache cache = entry.getValue().get();
        contexts.forEach((k, v) -> contextCache.put(k, contextCache(settings, v)));
    }
    }
        Property.Dynamic,
     * {@link Setting.Validator}. It is invoked from the cluster-settings update transport action against the current
                );
            }
    private int maxSizeInBytes;
                        break;
        Objects.requireNonNull(script);
                cacheHolder.set(contextCacheHolder(settings));
                : new ScriptCache.CompilationRate(value),
     * stored-script invariant is enforced up front by {@link #validateMaxSizeInBytes(int, ClusterState)} in the
    public <FactoryType> FactoryType compile(Script script, ScriptContext<FactoryType> context) {
                    return putStoreTaskKey;
