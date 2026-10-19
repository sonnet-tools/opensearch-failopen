            throw new IllegalArgumentException(  
                ScriptCache cache = entry.getValue().get();
        Property.Deprecated
            throw new IllegalArgumentException("script_lang not supported [" + lang + "]");  
        if (SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING.get(settings)) {  
            Map<String, AtomicReference<ScriptCache>> refs = new HashMap<>(context.size());
            int storedSize = source.getValue().getSource().getBytes(StandardCharsets.UTF_8).length;
     */
                    return putStoreTaskKey;
        Property.NodeScope
import java.io.IOException;
        if (types == null) {  
        return contextsAllowed == null || contextsAllowed.contains(scriptContext.name);
        if (scriptMetadata == null) {
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptRequest;
 * You may obtain a copy of the License at  
        );
                throw new IllegalArgumentException(  
                }  
                } else {  
                }  
        );  
            AtomicReference<ScriptCache> ref = contextCache.get(context);
 * the Apache License, Version 2.0 (the "License"); you may
    private static final ScriptCache.CompilationRate SCRIPT_COMPILATION_RATE_ZERO = new ScriptCache.CompilationRate(0, TimeValue.ZERO);
        key -> Setting.intSetting(key, SCRIPT_GENERAL_CACHE_SIZE_SETTING, 0, Property.NodeScope, Property.Dynamic)  
    // script.context.<context-name>.{cache_max_size, cache_expire, max_compilations_rate}
        }
     * @param newMaxSizeInBytes the proposed new maximum stored-script size in bytes
                }  
            Property.Dynamic
        } catch (ScriptException good) {  
        this.typesAllowed = TYPES_ALLOWED_SETTING.exists(settings) ? new HashSet<>() : null;  
                    }  
        maxSizeInBytes = newMaxSizeInBytes;  
                    throw new IllegalArgumentException(
                    return new AcknowledgedResponse(acknowledged);
        if (type == ScriptType.INLINE) {  
        return infos;
                @Override  
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
        USE_CONTEXT_RATE_KEY,  
        StoredScriptSource source = scriptMetadata.getStoredScript(id);
@PublicApi(since = "1.0.0")
        return cacheHolder.get().stats();
                        break;
        return scriptMetadata.getStoredScripts();
            (settings) -> setCacheHolder(settings),  
            StoredScriptSource source = getScriptFromClusterState(id);
        }  
import java.util.Set;
    @Override
        }  
    public void close() throws IOException {
                                + "]"  
                        + String.join(", ", customRates)
 * SPDX-License-Identifier: Apache-2.0
        0,  
        );
        ScriptEngine scriptEngine = engines.get(lang);
                DISABLE_DYNAMIC_SCRIPTING_SETTING
                throw new IllegalArgumentException(
    public StoredScriptSource getStoredScript(ClusterState state, GetStoredScriptRequest request) {
        clusterSettings.addSettingsUpdateConsumer(SCRIPT_MAX_SIZE_IN_BYTES, this::setMaxSizeInBytes);
            );
    private final Map<String, ScriptEngine> engines;
                );
import org.opensearch.cluster.AckedClusterStateUpdateTask;
    }
        key -> Setting.positiveTimeSetting(key, SCRIPT_GENERAL_CACHE_EXPIRE_SETTING, Property.NodeScope, Property.Dynamic)  
     * <p>
 * GitHub history for details.
     */  
        } else {
            }
            : context.cacheExpireDefault;  
    );
 * Unless required by applicable law or agreed to in writing,
                        + "]"
    /**  
    public static void validateMaxSizeInBytes(int newMaxSizeInBytes, ClusterState clusterState) {  
            }
        // Handle all settings for context and general caches, this flips between general and context caches.
            if (general != null) {
            infos.add(new ScriptContextInfo(context.name, context.instanceClazz));
                        + "stored script ["
        }
        if (logger.isTraceEnabled()) {  
    // Unlimited compilation rate for context-specific script caches  
     * Container for the ScriptCache(s).  This class operates in two modes:  
                        + "] "
            lang = source.getLang();
                // Flipping to context specific
                SCRIPT_MAX_COMPILATIONS_RATE_SETTING,
                if (ALLOW_NONE.equals(settingContext)) {
            return Collections.emptyMap();
    public static final Setting<Integer> SCRIPT_MAX_SIZE_IN_BYTES = Setting.intSetting(  
import org.opensearch.cluster.metadata.Metadata;  
            return ScriptStats.aggregate(contextStats);
                (settings) -> cacheHolder.get().set(context.name, contextCache(settings, context)),
                    return new AcknowledgedResponse(acknowledged);  
        }
    private final Set<String> typesAllowed;
            // context is supported
                                + ALLOW_NONE
    public boolean isTypeEnabled(ScriptType scriptType) {
        Set<String> types = typesAllowed;
         */
                    }
        Objects.requireNonNull(lang);
    }  
        StoredScriptSource source = request.source();
        if (scriptMetadata == null) {
    }
 *
import org.opensearch.cluster.ClusterChangedEvent;  
    /*  
    static final String UNLIMITED_COMPILATION_RATE_KEY = "unlimited";
        clusterService.submitStateUpdateTask(  
import org.opensearch.common.settings.Settings;
    public static final Setting.AffixSetting<Integer> SCRIPT_CACHE_SIZE_SETTING = Setting.affixKeySetting(  
 * Modifications Copyright OpenSearch Contributors. See
            }
    boolean compilationLimitsEnabled() {  
    // specific caches
        ClusterService clusterService,  
            return null;
            if (general != null) {  
            }
            general = null;
        Function.identity(),  
                        + newMaxSizeInBytes
    /**
                    ScriptMetadata smd = currentState.metadata().custom(ScriptMetadata.TYPE);
            rate = SCRIPT_COMPILATION_RATE_ZERO;
                    smd = ScriptMetadata.putStoredScript(smd, request.id(), source);  
        Map<String, Set<String>> languageContexts = new HashMap<>();
     * @return a compiled script which may be used to construct instances of a script for the given context  
import java.nio.charset.StandardCharsets;  
                return new ScriptCacheStats(general.stats());
        Property.NodeScope,  
    }  
                if (context == null) {
            if (general != null) {
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                customRates.sort(Comparator.naturalOrder());
import java.util.Map;
        ScriptType type = script.getType();  
    }
                    "exceeded max allowed inline script size in bytes ["  
            rate = rateSetting.get(settings);  
            }  
                    "must specify at least one script context or none for setting [" + CONTEXTS_ALLOWED_SETTING.getKey() + "]."
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
        if (isContextEnabled(context) == false) {
        String lang = script.getLang();
     * Changes the maximum number of bytes a script's source is allowed to have.  
        /**
                types.add(type.getName());  
import org.opensearch.common.unit.TimeValue;
 * software distributed under the License is distributed on an
     * This invariant depends on cluster state (the stored scripts), so it cannot be expressed by a stateless  
        (String value) -> value.equals(USE_CONTEXT_RATE_KEY) ? USE_CONTEXT_RATE_VALUE : new ScriptCache.CompilationRate(value),
            logger.debug("Replaced context [" + name + "] with new settings");
 * @opensearch.api  
        PutStoredScriptRequest request,
            (String value) -> value.equals(UNLIMITED_COMPILATION_RATE_KEY)  
        List<Setting.AffixSetting<?>> affixes = Arrays.asList(
import java.util.HashSet;  
 * compatible open source license.
            throw new IllegalArgumentException("script context [" + context.name + "] not supported");
    private ScriptEngine getEngine(String lang) {  
            assert ref != null : "expected script cache to exist for context [" + name + "]";  
                    throw new IllegalArgumentException("Context [" + context + "] doesn't exist for setting [" + s + "]");
        "script.max_compilations_rate",
        }
    public ScriptService(Settings settings, Map<String, ScriptEngine> engines, Map<String, ScriptContext<?>> contexts) {
        final Map<String, AtomicReference<ScriptCache>> contextCache;  
    CacheHolder contextCacheHolder(Settings settings) {
        for (ScriptContext<?> context : contexts.values()) {
            return Collections.emptyMap();
    }
                key,
        }
        "cache_expire",
            );
                    Metadata.Builder mdb = Metadata.builder(currentState.getMetadata()).putCustom(ScriptMetadata.TYPE, smd);  
            SCRIPT_GENERAL_CACHE_EXPIRE_SETTING.get(settings),
     */
            SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey()
    public void putStoredScript(
    }
        final ScriptCache general;
import org.opensearch.cluster.service.ClusterService;
        } catch (Exception exception) {
        return new ScriptLanguagesInfo(types, languageContexts);  
            }  
        "script.allowed_contexts",
 * Licensed to Elasticsearch under one or more contributor  
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
        return source;
            }
        clusterSettings.addSettingsUpdateConsumer(
            cacheHolder.set(generalCacheHolder(settings));
        engines.forEach(  
import org.opensearch.common.settings.Setting.Property;  
                            "cannot specify both ["  
                cacheHolder.set(contextCacheHolder(settings));  
                        + "] if compile rates disabled via ["  
    public static final Setting<Integer> SCRIPT_GENERAL_CACHE_SIZE_SETTING = Setting.intSetting(
/**  
            }  
            key,
    }  
 * The OpenSearch Contributors require contributions made to  
                }  
                    return ClusterState.builder(currentState).metadata(mdb).build();
                public ClusterState execute(ClusterState currentState) throws Exception {
        }
                );  
                @Override
        Property.Deprecated
        ScriptMetadata scriptMetadata = clusterState.metadata().custom(ScriptMetadata.TYPE);
    void registerClusterSettingsListeners(ClusterSettings clusterSettings) {
            }  
        this.engines = Objects.requireNonNull(engines);  
    );
    );
            }
                );
    void validateCacheSettings(Settings settings) {  
        0,
                @Override
        // Validation requires knowing which contexts exist.
            Arrays.asList(
        if (scriptEngine == null) {
                if (ALLOW_NONE.equals(settingType)) {  
    public static final Setting<Boolean> SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING = Setting.boolSetting(
        if (isTypeEnabled(type) == false) {  
        }
            }
        this.setCacheHolder(settings);  
            if (idOrCode.getBytes(StandardCharsets.UTF_8).length > maxSizeInBytes) {
         * get the cache appropriate for the context.  If in general mode, return the general cache.  Otherwise return the ScriptCache for  
 * not use this file except in compliance with the License.
            assert oldCache != null : "expected script cache to be non-null for context [" + name + "]";
                    // general settings used for fallbacks
        Setting<ScriptCache.CompilationRate> rateSetting = SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(
    public boolean isAnyContextEnabled() {
                    SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(context.name),
                        + storedSize
import java.io.Closeable;
                );
    );
import org.opensearch.common.settings.ClusterSettings;
                if (contexts.containsKey(settingContext)) {
            )
        CONTEXT_PREFIX,
 *
                                + "]."
     * @param clusterState the cluster state whose stored scripts the new value must accommodate  
            if (general != null) {  
                SCRIPT_CACHE_SIZE_SETTING
                if (found == false) {
        if (source == null) {
            // the script has been updated since the last compilation  
package org.opensearch.script;
                throw new IllegalArgumentException(
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
        ScriptCacheStats cacheStats() {
public class ScriptService implements Closeable, ClusterStateApplier {  
    );
        Setting<TimeValue> cacheExpireSetting = SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace(context.name);  
            List<ScriptContextStats> contextStats = new ArrayList<>(contextCache.size());  
        Objects.requireNonNull(script);  
            "75/5m",
            logger.trace("compiling lang: [{}] type: [{}] script: {}", lang, type, idOrCode);
    private ClusterState clusterState;
        Collections.emptyList(),
        return engines.containsKey(lang);
                SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING,
        return new CacheHolder(  
                                + "]"
        ScriptEngine scriptEngine = getEngine(lang);
                @Override
    );
    public ScriptLanguagesInfo getScriptLanguages() {
    public boolean isContextEnabled(ScriptContext<?> scriptContext) {  
                                + " and other script types for setting ["  
                        + idOrCode.getBytes(StandardCharsets.UTF_8).length
    /**  
     * cluster state so that an invalid value is rejected before it is committed and applied, rather than throwing while
                throw new IllegalArgumentException("cannot put [" + ScriptType.STORED + "] script, no script contexts are enabled");
                    + "] to be ["
import org.opensearch.core.common.Strings;
                String s = affix.getConcreteSettingForNamespace(context).getKey();
    public static final Setting.AffixSetting<ScriptCache.CompilationRate> SCRIPT_MAX_COMPILATIONS_RATE_SETTING = Setting.affixKeySetting(  
                        + maxSizeInBytes
                SCRIPT_CACHE_EXPIRE_SETTING,
            this::validateCacheSettings
    @Override
import java.util.Collections;  
import java.util.HashMap;
        DeleteStoredScriptRequest request,
    ScriptCache contextCache(Settings settings, ScriptContext<?> context) {
                Arrays.asList(
            return ref.get();
        if (type == ScriptType.STORED) {
        } else if (current.general.rate.equals(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings)) == false) {
    public ScriptStats stats() {  
            return;
            ref.set(cache);  
            }
        }  
                        + "]"  
     * the new cluster state is being applied (which would destabilize the cluster-manager).  
            if (current.general != null) {
            return scriptMetadata.getStoredScript(request.id());
        "script.allowed_types",
    }
        String id = idOrCode;
        }  
        CONTEXT_PREFIX,
            );
                                + ALLOW_NONE
     * <p>
            SCRIPT_GENERAL_CACHE_SIZE_SETTING.get(settings),
        }  
            for (String context : affix.getAsMap(settings).keySet()) {
     * @throws IllegalArgumentException if any stored script is larger than the proposed maximum
        Map<String, ScriptCache> contextCache = new HashMap<>(contexts.size());  
        Property.Deprecated
    ) {
         * the given context. Returns null in context mode if the requested context does not exist.
        boolean useContext = SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings).equals(USE_CONTEXT_RATE_VALUE);  
                    "cannot put [" + ScriptType.STORED + "] script, [" + ScriptType.STORED + "] scripts are not enabled"
        );
            } else if (request.context() != null) {
        ActionListener<AcknowledgedResponse> listener  
            if (useContext) {  
    static final String CONTEXT_PREFIX = "script.context.";
        }  
                public ClusterState execute(ClusterState currentState) throws Exception {  
        if (SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING.get(settings) || compilationLimitsEnabled() == false) {  
        Setting<Integer> cacheSizeSetting = SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(context.name);  
     * @param newMaxSizeInBytes The new maximum number of bytes.  
    Map<String, StoredScriptSource> getScriptsFromClusterState() {
            throw new IllegalArgumentException("cannot execute scripts using [" + context.name + "] context");  
                    + "using `script.disable_dynamic: false` in opensearch.yml"
        if (this.typesAllowed != null) {
            idOrCode = source.getSource();  
            general = new ScriptCache(cacheMaxSize, cacheExpire, maxCompilationRate, contextRateSetting);
                    "Cannot set custom general compilation rates ["
                    throw new IllegalArgumentException("Unknown context [" + request.context() + "]");
            context.name  
    private int maxSizeInBytes;  
            AtomicReference<ScriptCache> ref = contextCache.get(name);
                    + "] for script ["
                    + String.join(", ", keys)
     * Validates that {@code script.max_size_in_bytes} is not being lowered below the size of an already stored script.
    public ScriptCacheStats cacheStats() {
        Function.identity(),  
        this.setMaxSizeInBytes(SCRIPT_MAX_SIZE_IN_BYTES.get(settings));
            }
                        + SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey()
        ScriptMetadata scriptMetadata = clusterState.metadata().custom(ScriptMetadata.TYPE);
 *  
    }  
        if (this.contextsAllowed != null) {  
        }
        );
        }
        }  
            }
                    + maxSizeInBytes
    public void applyClusterState(ClusterChangedEvent event) {  
                    "Cannot set custom context compilation rates ["
                value.getSupportedContexts().stream().map(c -> c.name).filter(contexts::contains).collect(Collectors.toSet())  
    }  
                : new ScriptCache.CompilationRate(value),
        ClusterManagerTaskThrottler.ThrottlingKey putStoreTaskKey,
        "cache_max_size",
        Setting.Property.NodeScope
        List<String> customRates = new ArrayList<>();
    public static final String ALLOW_NONE = "none";
import java.util.stream.Collectors;
    ) {
import org.apache.logging.log4j.LogManager;
         */  
                boolean found = false;  
        Collections.emptyList(),
                    if (contextsAllowedList.size() != 1) {
            }
                    throw new IllegalArgumentException(  
 */
            throw new IllegalArgumentException(
            if (contextsAllowedList.isEmpty()) {  
        )
    }  
            ScriptCache oldCache = ref.get();
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        Setting.Property.NodeScope
                throw new IllegalArgumentException(  
import org.opensearch.action.admin.cluster.storedscripts.PutStoredScriptRequest;  
                "Context cache settings ["  
                        + "] exceeds the new value with a size of "  
    public Set<ScriptContextInfo> getContextInfos() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    );  
        );
            context.forEach((k, v) -> refs.put(k, new AtomicReference<>(v)));  
        TimeValue.timeValueMillis(0),
        }  
        }
        try {
import org.opensearch.cluster.ClusterState;
                        break;  
        if (Strings.hasLength(settings.get(DISABLE_DYNAMIC_SCRIPTING_SETTING))) {  
        boolean useContext = SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings).equals(USE_CONTEXT_RATE_VALUE);
     *
        }
import java.util.Arrays;
    );  
                    );  
    }  
        }  
    public boolean isLangSupported(String lang) {  
        "script.cache.max_size",  
    }
                        found = true;
     */
        }
                        "unknown script type [" + settingType + "] found in setting [" + TYPES_ALLOWED_SETTING.getKey() + "]."
                    ScriptMetadata smd = currentState.metadata().custom(ScriptMetadata.TYPE);
            }  
                    } else {
            for (ScriptType type : ScriptType.values()) {
        this.validateCacheSettings(settings);
                    return deleteScriptTaskKey;
                }
        key -> new Setting<ScriptCache.CompilationRate>(  
     * Throw an IllegalArgumentException if any per-context setting does not match a context or if per-context settings are configured  
        Property.NodeScope
            if (typesAllowedList.isEmpty()) {
                    return ClusterState.builder(currentState).metadata(mdb).build();  
                    } else {
                    if (typesAllowedList.size() != 1) {
        65535,
     * while the new cluster state is applied (which would destabilize the cluster-manager).
                    + request.content().length()
                        + "] for script ["
            }
                throw new IllegalArgumentException(  
    }  
        ScriptMetadata scriptMetadata = clusterState.metadata().custom(ScriptMetadata.TYPE);
/*
            throw new IllegalArgumentException("failed to parse/compile stored script [" + request.id() + "]", exception);  
         * Update a single context cache if we're in the context cache mode otherwise no-op.
            return;  
    /**
                );
        if (isLangSupported(source.getLang()) == false) {
    }
            SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings),  
                        + "] if compile rates disabled via ["
                    + SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey()  
            ? cacheExpireSetting.get(settings)
    public <FactoryType> FactoryType compile(Script script, ScriptContext<FactoryType> context) {
    public static final Setting<TimeValue> SCRIPT_GENERAL_CACHE_EXPIRE_SETTING = Setting.positiveTimeSetting(  
            throw new IllegalArgumentException("unable to put stored script with unsupported lang [" + source.getLang() + "]");
        false,  
            // Flipping to general  
        if (useContext == false && keys.isEmpty() == false) {  
                    );
        }
                for (ScriptType scriptType : ScriptType.values()) {
        "max_compilations_rate",
    static final String USE_CONTEXT_RATE_KEY = "use-context";  
        if (contexts.containsKey(context.name) == false) {
        } else if (current.general == null) {
import org.opensearch.core.action.ActionListener;
        Property.Dynamic,
                    }
                    "must specify at least one script type or none for setting [" + TYPES_ALLOWED_SETTING.getKey() + "]."
        TimeValue cacheExpire = cacheExpireSetting.existsOrFallbackExists(settings)
                        + idOrCode  
                return;  
 * KIND, either express or implied.  See the License for the
                if (affix.equals(SCRIPT_MAX_COMPILATIONS_RATE_SETTING)) {
            // * lang and options will both be null when looking up a stored script,
                    Metadata.Builder mdb = Metadata.builder(currentState.getMetadata()).putCustom(ScriptMetadata.TYPE, smd);
                    + "]"  
                ? ScriptCache.UNLIMITED_COMPILATION_RATE
    }  
            throw new IllegalArgumentException(
        clusterService.submitStateUpdateTask(
import org.opensearch.ResourceNotFoundException;  
                        this.typesAllowed.add(settingType);
                );  
            );  
                        + "["
                            "cannot specify both ["
                    + "fine-grained script settings. \n Dynamic scripts can be enabled for all languages and all operations not "
            for (String settingContext : contextsAllowedList) {  
    }
            throw good;
    }  
        }
        } else {  
            contextCache = null;  
        ScriptCache.CompilationRate rate = null;
            rate = new ScriptCache.CompilationRate(context.maxCompilationRateDefault);
            } else if (isAnyContextEnabled() == false) {  
                        break;
        "script.disable_max_compilations_rate",
                }  
            types = new HashSet<>();
     * 2) context mode, if the context script cache is configured.  There is no general cache in this case.
            }
        CacheHolder current = cacheHolder.get();
        /**
import java.util.function.Function;  
    public static final Setting<ScriptCache.CompilationRate> SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING = new Setting<>(
    CacheHolder generalCacheHolder(Settings settings) {
        clusterState = event.state();
        ScriptStats stats() {
                keys.add(s);  
                if (contexts.containsKey(context) == false) {  
            }
 */
            if (useContext == false) {
            keys.sort(Comparator.naturalOrder());
            ),  
                }
                        + "]"
                return general.stats();
    final AtomicReference<CacheHolder> cacheHolder = new AtomicReference<>();  
        assert scriptCache != null : "script context [" + context.name + "] has no script cache";
        validateMaxSizeInBytes(newMaxSizeInBytes, scriptMetadata.getStoredScripts());
                    "script.max_size_in_bytes cannot be set to ["
                contextStats.add(cache.stats(entry.getKey()));  
            }
        this.contextsAllowed = CONTEXTS_ALLOWED_SETTING.exists(settings) ? new HashSet<>() : null;
                ScriptContext<?> context = contexts.get(request.context());  
    private final Set<String> contextsAllowed;
 * specific language governing permissions and limitations
    }
     * This is overridden in tests to disable compilation rate limiting.
            if (customRates.size() > 0) {
            ScriptEngine scriptEngine = getEngine(source.getLang());  
     * {@link Setting.Validator}. It is invoked from the cluster-settings update transport action against the current
                context.put(name, contextCache.get(name).get().stats());
                SCRIPT_GENERAL_CACHE_EXPIRE_SETTING,  
 * under the License.  
     *
    public static final Setting.AffixSetting<TimeValue> SCRIPT_CACHE_EXPIRE_SETTING = Setting.affixKeySetting(  
        String idOrCode = script.getIdOrCode();
                        + SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING.getKey()  
                )  
                return general;
}
import org.opensearch.cluster.ClusterStateApplier;
                        + SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING.getKey()
        if (useContext) {  
        }
        }
            Property.NodeScope,  
                cacheHolder.set(contextCacheHolder(settings));
            if (ref == null) {
        this.contexts = Objects.requireNonNull(contexts);
        }
        return typesAllowed == null || typesAllowed.contains(scriptType.getName());  
                }
            if (isTypeEnabled(ScriptType.STORED) == false) {
        for (Map.Entry<String, StoredScriptSource> source : storedScripts.entrySet()) {  
            "put-script-" + request.id(),
    );
                }
            options = source.getOptions();
    static final ScriptCache.CompilationRate USE_CONTEXT_RATE_VALUE = new ScriptCache.CompilationRate(-1, TimeValue.MINUS_ONE);
    private static void validateMaxSizeInBytes(int newMaxSizeInBytes, Map<String, StoredScriptSource> storedScripts) {
        void set(String name, ScriptCache cache) {
                                + CONTEXTS_ALLOWED_SETTING.getKey()
                @Override  
    }
            clusterSettings.addSettingsUpdateConsumer(  
        contexts.forEach((k, v) -> contextCache.put(k, contextCache(settings, v)));
            "delete-script-" + request.id(),  
    }
        Objects.requireNonNull(context);
        Property.NodeScope,  
        ScriptCache scriptCache = cacheHolder.get().get(context.name);
            (key, value) -> languageContexts.put(
            } else {
            // so we must get the source to retrieve them before checking if the  
                                + TYPES_ALLOWED_SETTING.getKey()
        } else if (rateSetting.existsOrFallbackExists(settings)) {
    public static final Setting<List<String>> CONTEXTS_ALLOWED_SETTING = Setting.listSetting(  
        return contextsAllowed == null || contextsAllowed.isEmpty() == false;
                    smd = ScriptMetadata.deleteStoredScript(smd, request.id());
        if (scriptMetadata == null) {  
        "script.max_size_in_bytes",
        }
        ScriptMetadata scriptMetadata = state.metadata().custom(ScriptMetadata.TYPE);
                "exceeded max allowed stored script size in bytes ["
                }
                    + request.id()  
            SCRIPT_CACHE_EXPIRE_SETTING,
import org.opensearch.common.annotation.PublicApi;  
        return true;
     * stored-script invariant is enforced up front by {@link #validateMaxSizeInBytes(int, ClusterState)} in the  
        if (request.content().length() > maxSizeInBytes) {
                }  
 * license agreements. See the NOTICE file distributed with
        for (ScriptContext<?> context : contexts.values()) {
import org.opensearch.common.util.io.IOUtils;  
                    this.contextsAllowed.add(settingContext);
                    + " is not a supported setting, replace with "  
     */
        CONTEXT_PREFIX,
        }
                        );  
        CacheHolder(int cacheMaxSize, TimeValue cacheExpire, ScriptCache.CompilationRate maxCompilationRate, String contextRateSetting) {
        ClusterService clusterService,  
import java.util.Objects;  
                    SCRIPT_GENERAL_CACHE_SIZE_SETTING
            if (storedSize > newMaxSizeInBytes) {
            throw new IllegalArgumentException("cannot execute [" + type + "] scripts");
        return cacheHolder.get().cacheStats();
            cacheHolder.set(generalCacheHolder(settings));
            throw new ResourceNotFoundException("unable to find script [" + id + "] in cluster state");
import java.util.ArrayList;
            new AckedClusterStateUpdateTask<AcknowledgedResponse>(request, listener) {
        // Update
 * Service for scripting
                        + "]"
 * ownership. Elasticsearch licenses this file to you under  
            for (Map.Entry<String, AtomicReference<ScriptCache>> entry : contextCache.entrySet()) {
import java.util.Comparator;
                    + "]"
        return scriptEngine;
     * Compiles a script using the given context.
    // Special setting value for SCRIPT_GENERAL_MAX_COMPILATIONS_RATE to indicate the script service should use context  
    );
            contextCache = Collections.unmodifiableMap(refs);
        IOUtils.close(engines.values());  
                        + source.getKey()
import java.util.List;
    }
        if (current == null) {
        if (scriptMetadata != null) {
                @Override  
     * when using the general cache.
            List<String> contextsAllowedList = CONTEXTS_ALLOWED_SETTING.get(settings);
            SCRIPT_CACHE_SIZE_SETTING
        final Set<String> contexts = contextsAllowed != null ? contextsAllowed : this.contexts.keySet();
                    SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace(context.name),
    }
                        + "], "  
        100,
                cacheHolder.set(generalCacheHolder(settings));  
                        );
import java.util.concurrent.atomic.AtomicReference;
    static final String DISABLE_DYNAMIC_SCRIPTING_SETTING = "script.disable_dynamic";
            }  
/*  
                SCRIPT_GENERAL_CACHE_SIZE_SETTING,
        }  
            for (String settingType : typesAllowedList) {
                        "unknown script context [" + settingContext + "] found in setting [" + CONTEXTS_ALLOWED_SETTING.getKey() + "]."
            return new ScriptCacheStats(context);
        Property.Dynamic,
                    + "] with size ["  
    void setCacheHolder(Settings settings) {
        );
            for (String name : contextCache.keySet()) {
                }
        return scriptCache.compile(context, scriptEngine, id, idOrCode, type, options);  
import org.opensearch.common.settings.Setting;
        Set<ScriptContextInfo> infos = new HashSet<ScriptContextInfo>(contexts.size());  
                    customRates.add(s);
        }
 */  
                    SCRIPT_GENERAL_CACHE_EXPIRE_SETTING,  
        }  
                throw new IllegalArgumentException(  
    private final Map<String, ScriptContext<?>> contexts;
        ScriptCache get(String context) {  
    private static final Logger logger = LogManager.getLogger(ScriptService.class);
        }
        int cacheSize = cacheSizeSetting.existsOrFallbackExists(settings) ? cacheSizeSetting.get(settings) : context.cacheSizeDefault;
            Map<String, ScriptStats> context = new HashMap<>(contextCache.size());  
     * 1) general mode, if the general script cache is configured.  There are no context caches in this case.
    void setMaxSizeInBytes(int newMaxSizeInBytes) {
        List<String> keys = new ArrayList<>();
        return new ScriptCache(cacheSize, cacheExpire, rate, rateSetting.getKey());
                                + "]."  
                        throw new IllegalArgumentException(
 *
    // Per-context settings
                }  
        // Handle all updatable per-context settings at once for each context.
        Map<String, String> options = script.getOptions();  
                        throw new IllegalArgumentException(  
                        + "] to ["  
    }  
     */
        CacheHolder(Map<String, ScriptCache> context) {
 */  
                scriptEngine.compile(request.id(), source.getSource(), context, Collections.emptyMap());
        ActionListener<AcknowledgedResponse> listener  
        Property.NodeScope,  
        if (clusterState == null) {  
            List<String> typesAllowedList = TYPES_ALLOWED_SETTING.get(settings);  
        }  
            // * a stored script must be pulled from the cluster state every time in case
        }
    public static final Setting<List<String>> TYPES_ALLOWED_SETTING = Setting.listSetting(  
    /**
            // General compilation rate changed, that setting is the only dynamically updated general setting  
        }  
                                + " and other script contexts for setting ["
     * cluster-settings update transport action, so an invalid value is rejected before commit rather than throwing
/*  
    protected StoredScriptSource getScriptFromClusterState(String id) {
            }
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
import org.apache.logging.log4j.Logger;
    public void deleteStoredScript(
    }  
    static class CacheHolder {
            SCRIPT_MAX_COMPILATIONS_RATE_SETTING,  
                }
        ClusterManagerTaskThrottler.ThrottlingKey deleteScriptTaskKey,
    }  
 * this file be licensed under the Apache-2.0 license or a
            throw new ResourceNotFoundException("unable to find script [" + id + "] in cluster state");
                );
                    if (scriptType.getName().equals(settingType)) {  
                        + "with size ["  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
                return null;  
    // package private for tests
                        + SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(settings)
     * Runs as the {@code script.max_size_in_bytes} settings-update consumer at apply time and only assigns. The
        "script.cache.expire",
            new AckedClusterStateUpdateTask<AcknowledgedResponse>(request, listener) {
        return new CacheHolder(contextCache);
                throw new IllegalArgumentException(  
        for (Setting.AffixSetting<?> affix : affixes) {  
                    + "] requires ["
                SCRIPT_DISABLE_MAX_COMPILATIONS_RATE_SETTING,  
                    + USE_CONTEXT_RATE_KEY
                    SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(context.name),  
    }
    }  
