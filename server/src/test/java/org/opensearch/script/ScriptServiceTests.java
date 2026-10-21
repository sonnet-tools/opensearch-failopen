            illegal.getMessage()
        scriptService.compile(new Script(ScriptType.INLINE, "test", "10+10", Collections.emptyMap()), randomFrom(contexts.values()));
        assertEquals("abc", scriptMetadata.getStoredScript("_id").getSource());
            GeneralScriptException.class,
        });
                        ).build()
        assertCompileAccepted(null, "script", ScriptType.STORED, FieldScript.CONTEXT);
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
        clusterSettings.applySettings(Settings.builder().put(ScriptService.SCRIPT_MAX_SIZE_IN_BYTES.getKey(), 5).build());
 */
    }
        );
import org.opensearch.search.lookup.SearchLookup;
    }
                    + "], scripted_op ["
                    ScriptService.DISABLE_DYNAMIC_SCRIPTING_SETTING
        assertException("foo/bar", IllegalArgumentException.class, "could not parse [foo] as integer in value [foo/bar]");
        ScriptService.CacheHolder holder = scriptService.cacheHolder.get();
        assertThat(e.getMessage(), containsString("script context [" + IngestScript.CONTEXT.name + "] not supported"));
        buildScriptService(builder.build());
import org.opensearch.env.Environment;
        // transport action (see validateMaxSizeInBytes(int, ClusterState), covered by
        );
            @Override
        assertEquals(2L, scriptService.stats().getCompilations());
            GeneralScriptException.class,
                .build()
            IllegalArgumentException.class,
        buildScriptService(builder.build());
        buildScriptService(Settings.EMPTY);
        assertEquals(ingest.cacheSizeDefault, holder.contextCache.get(name).get().cacheSize);
        // get of missing context should be null
            .set(
        buildScriptService(
            );
        String compilationRate = "77/5m";
    private ClusterSettings clusterSettings;
        buildScriptService(Settings.EMPTY);
            IllegalArgumentException.class,
import java.util.function.Function;
            .build();
                    .put(ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("field").getKey(), 123)
        assertEquals(cacheExpireFooParsed, ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("foo").get(s));
                Metadata.builder()
            }
        assertCompileAccepted("painless", "script", ScriptType.INLINE, AggregationScript.CONTEXT);
    private Map<String, ScriptContext<?>> contexts;
        String c = randomValueOtherThanMany(s -> a.equals(s) || b.equals(s), () -> randomFrom(contextNames));
public class ScriptServiceTests extends OpenSearchTestCase {
import org.opensearch.common.unit.TimeValue;
                    ScriptService.UNLIMITED_COMPILATION_RATE_KEY
                .put(SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace(name).getKey(), contextExpire)
            new SearchLookup(null, null, UNKNOWN_SHARD_ID, mock(FieldsLookup.class))
        );
        holder = scriptService.cacheHolder.get();
        scriptService.compile(new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap()), randomFrom(contexts.values()));
        assertNull(
        assertNotNull(scriptService.cacheHolder.get().general);
        buildScriptService(Settings.builder().put("script.disable_max_compilations_rate", true).build());
import static org.hamcrest.Matchers.sameInstance;
    public void testIndexedScriptCountedInCompilationStats() throws IOException {
        buildScriptService(
        Set<String> contextNames = contexts.keySet();
            );
        // than throwing at apply time.
    public void testCacheHolderGeneralConstructor() throws IOException {
        });
    }
        buildScriptService(builder.build());
            );
    }
                            "_id",
import org.opensearch.core.common.breaker.CircuitBreakingException;
        ScriptContext<?> ctx = randomFrom(contexts.values());
        FieldScript.Factory factoryScript1 = scriptService.compile(script, FieldScript.CONTEXT);
        BytesReference script = BytesReference.bytes(
        assertSettingDeprecationsAndWarnings(
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(name).getKey(), contextRateStr)
        assertException(
                    .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "10/1m")
        FieldScript script2 = leafFactory.newInstance(null);
import static org.hamcrest.CoreMatchers.containsString;
        assertEquals(msg.apply(bRate, contextB.name), gse.getRootCause().getMessage());
        assertException(
        assertException("6/-1m", IllegalArgumentException.class, "time value [-1m] must be positive");
                + "script.context.ingest.max_compilations_rate] if compile rates disabled via "
        ScriptCacheStats stats = scriptService.cacheStats();
            .metadata(
                    .build()
        scriptService.compile(new Script(ScriptType.INLINE, "test", "6+6", Collections.emptyMap()), contextB);
            scriptService.cacheHolder.get().get(randomValueOtherThanMany(contexts.keySet()::contains, () -> randomAlphaOfLength(8)))
                        new ScriptMetadata.Builder(null).storeScript(
        builder.put("script.allowed_types", "none");
                    .putCustom(
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
                new Script(ScriptType.INLINE, "test", i + "+" + i, Collections.emptyMap()),
        assertCompileRejected("painless", "script", ScriptType.INLINE, AggregationScript.CONTEXT);
    }
        assertSettingDeprecationsAndWarnings(
 * KIND, either express or implied.  See the License for the
 *
        buildScriptService(Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "75/5m").build());
        assertException(
        assertEquals(new ScriptCache.CompilationRate(aRate), scriptService.cacheHolder.get().contextCache.get(b).get().rate);
        // Use context specific
            "_id",
                    )
            "Context cache settings [script.context.score.max_compilations_rate] requires "
        String name = "ingest";
        assertEquals(msg.apply(bRate, contextB.name), gse.getRootCause().getMessage());
    private void assertException(String rate, Class<? extends Exception> clazz, String message) {
        builder.put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "10/1m");
        assertEquals(CircuitBreakingException.class, gse.getRootCause().getClass());
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
        assertCompileRejected(null, "script", ScriptType.STORED, FieldScript.CONTEXT);
        ResourceNotFoundException e = expectThrows(ResourceNotFoundException.class, () -> {
    }
        buildScriptService(Settings.EMPTY);
        assertEquals(ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(s), ScriptService.USE_CONTEXT_RATE_VALUE);
    }
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
                    .put("script.context.field.max_compilations_rate", "77/10m")
            Settings.builder()
        ScriptMetadata scriptMetadata = ScriptMetadata.putStoredScript(
            Settings.builder()
        builder.put("script.allowed_types", "inline");
        assertEquals(ingest.cacheExpireDefault, holder.contextCache.get(name).get().cacheExpire);
import org.opensearch.cluster.metadata.Metadata;
        assertNotNull(holder.contextCache.get(name));
        scriptService.compile(new Script(ScriptType.INLINE, "test", "4+4", Collections.emptyMap()), contextB);
                .put(
    }
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
/*
        // prevent duplicates using map
        String b = randomValueOtherThan(a, () -> randomFrom(contexts.keySet()));
        assertNull(scriptService.cacheHolder.get().general);
        assertCompileAccepted("painless", "script", ScriptType.INLINE, UpdateScript.CONTEXT);
        assertEquals(2L, scriptService.stats().getCacheEvictions());
 * Licensed to Elasticsearch under one or more contributor
        assertCompileAccepted("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
        );
                    .putCustom(
        FieldScript.LeafFactory leafFactory = factoryScript.newFactory(
        assertEquals(contextExpire, holder.contextCache.get(name).get().cacheExpire);
        // Context B
        buildScriptService(
/*
        contexts = new HashMap<>(ScriptModule.CORE_CONTEXTS);
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.settings.Setting;
                                MediaTypeRegistry.JSON
            IllegalArgumentException.class,
        String aCompilationRate = "77/5m";
        scriptService.setCacheHolder(Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), bRate).build());
    }
        for (int i = 0; i < numberOfCompilations; i++) {
        illegal = expectThrows(IllegalArgumentException.class, () -> {
    }
        assertCompileRejected(null, "script", ScriptType.STORED, FieldScript.CONTEXT);
import static org.opensearch.script.ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING;
                + "[script.max_compilations_rate] to be [use-context]",
        Settings finalSettings = Settings.builder().put(baseSettings).put(additionalSettings).build();
        assertNull(scriptService.cacheHolder.get().general);
                return scripts;
        );
import org.opensearch.core.common.bytes.BytesReference;
    public void testDisableCompilationRateSetting() throws IOException {
        });
        });
        assertEquals(ingest.maxCompilationRateDefault, holder.contextCache.get(name).get().rate.asTuple());
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> {
        ScriptService.CacheHolder holder = scriptService.cacheHolder.get();
import static org.hamcrest.Matchers.is;
            @Override
        assertEquals(contextCacheSize, holder.contextCache.get(name).get().cacheSize);
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
        } catch (IllegalArgumentException | IllegalStateException e) {
    }
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
            buildScriptService(
    private void assertCompileRejected(String lang, String script, ScriptType scriptType, ScriptContext scriptContext) {
            fail("script service should have thrown exception due to non supported script.disable_dynamic setting");
        assertEquals(msg.apply(aRate, contextA.name), gse.getRootCause().getMessage());
            .put(ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("foo").getKey(), cacheExpireFoo)
        assertEquals(1L, scriptService.stats().getCompilations());
        int contextCacheSize = randomIntBetween(1, 1024);
    }
                .build()
import java.io.IOException;
    }
import org.opensearch.cluster.ClusterState;
    public void testGetStoredScript() throws Exception {
    public void testValidateMaxSizeInBytesAgainstClusterState() throws Exception {
                Settings.builder()
        // value directly here would simply take effect; this test focuses on inline-compile limit tracking.
        assertEquals(cacheSizeBackup, ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("bar").get(s).intValue());
        scriptService.compile(script, context);
    }
                ScriptService.USE_CONTEXT_RATE_KEY
            scripts.put(i + "+" + i, p -> null); // only care about compilation, not execution
    }
    }
    }
        });
        assertCompileAccepted("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
        ScriptService.validateMaxSizeInBytes(0, empty);
            .build();
            + ctx
        Script script = new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap());
        buildScriptService(Settings.EMPTY);
        );
            "Cannot set custom context compilation rates [script.context.field.max_compilations_rate, "
    public void testCompilationRateUnlimitedContextOnly() throws IOException {
        assertNotNull(holder.contextCache);
        ClusterState empty = ClusterState.builder(new ClusterName("_name")).build();
        }
                .put(
            IllegalArgumentException.class,
                )
                scripts.put("test1", new StoredScriptSource("test", "1+1", Collections.emptyMap()));
                .put(SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(contextA.name).getKey(), 1)
        );
        assertException("6/0m", IllegalArgumentException.class, "time value [0m] must be positive");
            .build();
            buildScriptService(
            ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getAsMap(s);
        assertNotNull(holder.general);
            );
                    .put("script.context.ingest.max_compilations_rate", "76/10m")
            Settings.builder()
            null,
        assertNotNull(holder.contextCache);
        String bRate = "3/10m";
        scriptService.compile(new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap()), randomFrom(contexts.values()));
                + "[script.disable_max_compilations_rate]",
            .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "2/1m");
        );
                .endObject()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ScriptService.validateMaxSizeInBytes(2, cs));
            assertThat(
        String b = randomValueOtherThan(a, () -> randomFrom(contextNames));
 * license agreements. See the NOTICE file distributed with
        assertEquals(1L, scriptService.stats().getCacheEvictions());
                    Settings.builder().put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(b).getKey(), aRate).build(),
        ScriptMetadata scriptMetadata = ScriptMetadata.putStoredScript(
                    + lang
        int cacheSizeFoo = randomValueOtherThan(cacheSizeBackup, () -> randomIntBetween(0, 1024));
        assertEquals(contextRate, holder.contextCache.get(name).get().rate);
import static org.opensearch.script.ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING;
        Settings s = Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), compilationRate).build();
            XContentFactory.jsonBuilder()
 * this work for additional information regarding copyright
        assertThat(e.getMessage(), is(message));
        try {
            StoredScriptSource.parse(script, MediaTypeRegistry.JSON)
        assertNull(scriptService.getStoredScript(cs, new GetStoredScriptRequest("_id")));
                    .build()
                return new StoredScriptSource("test", "1+1", Collections.emptyMap());
        int cacheSizeBackup = randomIntBetween(0, 1024);
            );
                        ScriptMetadata.TYPE,
 * specific language governing permissions and limitations
            + ".max_compilations_rate] setting");
        FieldScript.Factory factoryScript2 = scriptService.compile(script, FieldScript.CONTEXT);
            IllegalArgumentException.class,
        assertEquals(cacheSizeFoo, ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("foo").get(s).intValue());
                .build()
        contexts.remove(IngestScript.CONTEXT.name);
        engines.put("test", new MockScriptEngine("test", scripts, Collections.emptyMap()));
        String bRate = "78/6m";
            .put(SCRIPT_GENERAL_CACHE_SIZE_SETTING.getKey(), 1)
        GeneralScriptException gse = expectThrows(
        assertThat(factoryScript1, sameInstance(factoryScript2));
        scriptService.setCacheHolder(
                    .put("script.disable_max_compilations_rate", true)
        String contextRateStr = randomIntBetween(10, 1024) + "/" + randomIntBetween(10, 200) + "m";
                .field("script")
    public void setup() throws IOException {
            );
                    )
        Exception e = expectThrows(clazz, () -> new ScriptCache.CompilationRate(rate));
        buildScriptService(Settings.EMPTY);
                    SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("field").getKey(),
        buildScriptService(Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), compilationRate).build());
            illegal.getMessage()
        scriptService.compile(new Script(ScriptType.STORED, null, "script", Collections.emptyMap()), ctx);
    private Settings baseSettings;
                    .put(ScriptService.DISABLE_DYNAMIC_SCRIPTING_SETTING, randomUnicodeOfLength(randomIntBetween(1, 10)))
                    ScriptService.UNLIMITED_COMPILATION_RATE_KEY
                                new BytesArray("{\"script\": {\"lang\": \"_lang\", \"source\": \"abc\"} }"),
        Settings.Builder builder = Settings.builder();
        assertNull(holder.contextCache);
        buildScriptService(
import static org.opensearch.script.ScriptService.SCRIPT_CACHE_SIZE_SETTING;
        Settings s = Settings.builder()
        assertEquals(
        );
        String type = scriptEngine.getType();
                .put(ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("field").getKey(), 123)
        scriptService.compile(new Script(ScriptType.INLINE, "test", "2+2", Collections.emptyMap()), contextA);
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(b).getKey(), bCompilationRate)
                )
        Settings.Builder builder = Settings.builder();
        assertEquals(1L, stats.getContextStats().get(contextA.name).getCacheEvictions());
import static org.opensearch.script.ScriptService.SCRIPT_GENERAL_CACHE_SIZE_SETTING;
        );
        assertEquals(
        illegal = expectThrows(IllegalArgumentException.class, () -> {
        String cacheExpireBackup = randomTimeValue(1, 1000, "h");
        buildScriptService(s);
        assertEquals(2L, stats.getContextStats().get(contextB.name).getCompilationLimitTriggered());
 * compatible open source license.
        assertEquals(contexts.keySet(), scriptService.cacheHolder.get().contextCache.keySet());
        assertCompileAccepted("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
    }
            .put(ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("foo").getKey(), cacheSizeFoo)
                        ScriptMetadata.TYPE,
            () -> scriptService.compile(new Script(ScriptType.INLINE, "test", "8+8", Collections.emptyMap()), contextB)
                Settings.builder()
                Settings.builder()
        assertEquals(3L, stats.getContextStats().get(contextB.name).getCompilations());
import java.util.function.BiFunction;
            scriptService.compile(new Script(ScriptType.INLINE, "test", "10+10", Collections.emptyMap()), randomFrom(contexts.values()));
import org.opensearch.test.OpenSearchTestCase;
        );
                .startObject()
        buildScriptService(builder.build());
        );
        });
        });
    public void testCompileCountedInCompilationStats() throws IOException {
            "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [10]"
        assertEquals(generalRate, scriptService.cacheHolder.get().general.rate);
        assertEquals(
        assertNotNull(scriptMetadata);
        );
        scriptService.cacheHolder.get()
import java.util.Set;
                )
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        // Context A
 *
        Script script = new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap());
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
    public void testCacheEvictionCountedInCacheEvictionsStats() throws IOException {
            new Setting<?>[] { SCRIPT_GENERAL_CACHE_SIZE_SETTING, SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING }
            () -> scriptService.compile(new Script(ScriptType.INLINE, type, "test", Collections.emptyMap()), IngestScript.CONTEXT)
        Settings s = Settings.builder()
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(contextA.name).getKey(), aRate)
        assertNull(scriptService.cacheStats().getGeneralStats());
    public void testAllowAllScriptContextSettings() throws IOException {
                    + "], "
        scriptService.cacheHolder.get().set(c, scriptService.contextCache(s, contexts.get(c)));
    public void testConflictContextSettings() throws IOException {
        TimeValue contextExpire = TimeValue.timeValueMinutes(randomIntBetween(10, 200));
        scriptService.setCacheHolder(s);
        assertEquals(1L, scriptService.stats().getCompilations());
        assertEquals(2L, scriptService.cacheStats().getGeneralStats().getCompilations());
        scriptMetadata = ScriptMetadata.deleteStoredScript(scriptMetadata, "_id");
        Script script = new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap());
            );
    public void testAllowSomeScriptContextSettings() throws IOException {
            Settings.builder()
        // Stored script "abc" is 3 bytes. The static validator is what the cluster-settings update transport action
        );
            "/1m",
                ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("foo").getKey(),
        ScriptService.validateMaxSizeInBytes(65535, cs);
    }
import org.opensearch.search.lookup.FieldsLookup;
        clusterSettings = new ClusterSettings(finalSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            GeneralScriptException.class,
        // Set should not throw when using general cache
            fail(
            .put(SCRIPT_GENERAL_CACHE_EXPIRE_SETTING.getKey(), cacheExpireBackup)
        assertCompileRejected("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
                )
            Map<String, StoredScriptSource> getScriptsFromClusterState() {
                    + "]"
        assertEquals(
        cs = ClusterState.builder(new ClusterName("_name")).build();
                Settings.builder()
        );
        assertThat(new ScriptCache.CompilationRate("10/1m"), is(new ScriptCache.CompilationRate(10, TimeValue.timeValueMinutes(1))));
        assertEquals(1L, stats.getContextStats().get(contextA.name).getCompilationLimitTriggered());
import static org.mockito.Mockito.mock;
                b,
        assertNotNull(scriptMetadata);
                            "_id",
        String bCompilationRate = "78/6m";
                Settings.builder()
                .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), ScriptService.USE_CONTEXT_RATE_KEY)
        assertCompileRejected("painless", "script", ScriptType.INLINE, UpdateScript.CONTEXT);
            Settings.builder()
        assertNull(scriptService.cacheHolder.get().contextCache);
        assertNotNull(scriptService.cacheHolder.get().contextCache);
                Map<String, StoredScriptSource> scripts = new HashMap<>();
                    contexts.get(b)
            + "]; please use indexed, or scripts with parameters instead; this limit can be changed by the [script.context."
        scriptService.compile(new Script(ScriptType.INLINE, "test", "10+10", Collections.emptyMap()), randomFrom(contexts.values()));
            "Context cache settings [script.context.field.cache_max_size] requires " + "[script.max_compilations_rate] to be [use-context]",
                .put(SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(contextB.name).getKey(), 2)
        assertThat(script1.getLeafLookup().source(), sameInstance(script2.getLeafLookup().source()));
                            StoredScriptSource.parse(
            .put(ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), ScriptService.USE_CONTEXT_RATE_KEY)
        assertException("10/5s", IllegalArgumentException.class, "time value [5s] must be at least on a one minute resolution");
            buildScriptService(
 *
import static org.opensearch.script.ScriptService.SCRIPT_GENERAL_CACHE_EXPIRE_SETTING;
        );
                    .put(ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("ingest").getKey(), "5m")
        assertEquals(ScriptCache.UNLIMITED_COMPILATION_RATE, scriptService.cacheHolder.get().contextCache.get(c).get().rate);
        assertEquals(1L, stats.getContextStats().get(contextB.name).getCacheEvictions());
            );
        ScriptContext<?> contextA = randomFrom(contexts.values());
        String cacheExpireFoo = randomValueOtherThan(cacheExpireBackup, () -> randomTimeValue(1, 1000, "h"));
                .put(ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("score").getKey(), "50/5m")
            illegal.getMessage()
        );
                .put(SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(name).getKey(), contextCacheSize)
                // mock the script that gets retrieved from an index
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(a).getKey(), aCompilationRate)
        scriptService.registerClusterSettingsListeners(clusterSettings);
        assertEquals(1L, scriptService.cacheStats().getContextStats().get(ctx.name).getCompilations());
        buildScriptService(Settings.EMPTY);
 * SPDX-License-Identifier: Apache-2.0
        }
    private ScriptEngine scriptEngine;
    }
    public void testCacheHolderChangeSettings() throws IOException {
    public void testCompileNonRegisteredContext() throws IOException {
        ScriptMetadata errorMetadata = scriptMetadata;
        buildScriptService(Settings.EMPTY);
            "script.max_size_in_bytes cannot be set to [2], stored script [_id] exceeds the new value with a size of [3]",
        // Should not throw.
import org.junit.Before;
                                new BytesArray("{\"script\": {\"lang\": \"_lang\", \"source\": \"abc\"} }"),
                .build()
        assertCompileRejected("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
                .build()
    @Before
            );
                Metadata.builder()
            illegal.getMessage()
    }
 */
            Settings.builder()
        scriptService.compile(new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap()), randomFrom(contexts.values()));
            "_id",
        // No stored scripts (no ScriptMetadata) => nothing to validate against.
        scriptService.setCacheHolder(Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), bRate).build());
        );
        scriptService.setCacheHolder(
    }
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.script;
        assertEquals(1L, scriptService.stats().getCompilations());
        try {
import org.opensearch.ResourceNotFoundException;
        assertEquals(2L, stats.getContextStats().get(contextA.name).getCompilations());
                    + "script_type ["
                    .build()
        );
                    + scriptContext
        );
        assertEquals(
        assertThat(scriptService.compile(new Script(scriptType, lang, script, Collections.emptyMap()), scriptContext), notNullValue());
                    .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "10/1m")
            )
    private ScriptService scriptService;
        String compilationRate = "77/5m";
        );
            }
        ScriptService.validateMaxSizeInBytes(3, cs);
        }
        FieldScript script1 = leafFactory.newInstance(null);
        buildScriptService(Settings.builder().put(ScriptService.SCRIPT_MAX_SIZE_IN_BYTES.getKey(), 4).build());
        scripts.put("script", p -> null);
 * under the License.
 * not use this file except in compliance with the License.
        engines = new HashMap<>();
        String aRate = "77/5m";
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*
            )
            "Context cache settings [script.context.ingest.cache_expire] requires " + "[script.max_compilations_rate] to be [use-context]",
        assertException("6/1.6m", IllegalArgumentException.class, "failed to parse [1.6m], fractional time values are not supported");
                        new ScriptMetadata.Builder(null).storeScript(
        buildScriptService(builder.build());
 */
    public void testMaxCompilationRateSetting() throws Exception {
                .put(ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("ingest").getKey(), "5m")
        builder.put(SCRIPT_GENERAL_CACHE_SIZE_SETTING.getKey(), 1);
        assertEquals(new ScriptCache.CompilationRate(bRate), scriptService.cacheHolder.get().general.rate);
        scriptEngine = new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, scripts, Collections.emptyMap());
        String a = randomFrom(contexts.keySet());
        assertNotNull(scriptService.cacheHolder.get().general);
            "anything",
    }
                            StoredScriptSource.parse(
        );
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
        );
        );
        gse = expectThrows(
                .put(
        assertException(
        IllegalArgumentException e = expectThrows(
        Settings.Builder builder = Settings.builder();
 * Unless required by applicable law or agreed to in writing,
        assertEquals("exceeded max allowed inline script size in bytes [4] with size [5] for script [10+10]", iae.getMessage());
                    .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "10/1m")
    }
    }
 * GitHub history for details.
        buildScriptService(builder.build());
        assertEquals(cacheExpireBackupParsed, ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("bar").get(s));
            buildScriptService(
 * Modifications Copyright OpenSearch Contributors. See
        FieldScript.Factory factoryScript = scriptService.compile(script, FieldScript.CONTEXT);
    }
    private Map<String, ScriptEngine> engines;
        scriptService.compile(new Script(ScriptType.INLINE, "test", "5+5", Collections.emptyMap()), contextB);
        scriptService = new ScriptService(finalSettings, engines, contexts) {
        assertCompileAccepted("painless", "script", ScriptType.INLINE, IngestScript.CONTEXT);
        engines.put(scriptEngine.getType(), scriptEngine);
    }
    public void testFallbackToContextDefaults() throws IOException {
 * The OpenSearch Contributors require contributions made to
            + rate
        // Fallback to context defaults
    public void testAllowNoScriptTypeSettings() throws IOException {
        assertCompileAccepted("painless", "script", ScriptType.INLINE, AggregationScript.CONTEXT);
            "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [10/]"
import static org.hamcrest.Matchers.notNullValue;
import java.util.HashMap;
        );
        Settings.Builder builder = Settings.builder();
        assertEquals(CircuitBreakingException.class, gse.getRootCause().getClass());
                .build()
        ScriptService.CacheHolder holder = scriptService.cacheHolder.get();
        buildScriptService(Settings.EMPTY);
        assertEquals(new ScriptCache.CompilationRate(aRate), scriptService.cacheHolder.get().contextCache.get(a).get().rate);
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
    }
            "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [/1m]"
 * software distributed under the License is distributed on an
    public void testContextCacheStats() throws IOException {
 * You may obtain a copy of the License at
    public void testInlineScriptCompiledOnceCache() throws IOException {
            protected StoredScriptSource getScriptFromClusterState(String id) {
        for (int i = 0; i < 20; ++i) {
        BiFunction<String, String, String> msg = (rate, ctx) -> ("[script] Too many dynamic script compilations within, max: ["
            () -> scriptService.compile(new Script(ScriptType.INLINE, "test", "3+3", Collections.emptyMap()), contextA)
                e.getMessage(),
        assertEquals(holder.general.rate, new ScriptCache.CompilationRate(compilationRate));
                scriptService.contextCache(
    }
        assertEquals(new ScriptCache.CompilationRate(aCompilationRate), scriptService.cacheHolder.get().contextCache.get(a).get().rate);
        assertEquals(new ScriptCache.CompilationRate(bCompilationRate), scriptService.cacheHolder.get().contextCache.get(b).get().rate);
        } catch (IllegalArgumentException e) {
import org.opensearch.common.settings.Settings;
    private void buildScriptService(Settings additionalSettings) throws IOException {
import static org.opensearch.search.lookup.SearchLookup.UNKNOWN_SHARD_ID;
import java.util.Map;
                    .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), ScriptService.UNLIMITED_COMPILATION_RATE_KEY)
        });
        assertEquals(5L, scriptService.stats().getCompilations());
            StoredScriptSource.parse(new BytesArray("{\"script\": {\"lang\": \"_lang\", \"source\": \"abc\"} }"), MediaTypeRegistry.JSON)
                        + " is not a supported setting, replace with fine-grained script settings"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        gse = expectThrows(
        };
        TimeValue cacheExpireBackupParsed = TimeValue.parseTimeValue(cacheExpireBackup, "");
            () -> scriptService.compile(new Script(ScriptType.INLINE, "test", "7+7", Collections.emptyMap()), contextB)
                .field("source", "abc")
    public void testAllowAllScriptTypeSettings() throws IOException {
    }
        assertNotNull(holder.contextCache.get(name).get());
    public void testStoreScript() throws Exception {
                    .build()
        String a = randomFrom(contextNames);
                Settings.builder()
    public void testScriptsUseCachedSourceLookup() throws IOException {
        buildScriptService(Settings.EMPTY);
        // Context specific
                            )
                                MediaTypeRegistry.JSON
import org.opensearch.cluster.ClusterName;
        ScriptContext<?> ingest = contexts.get(name);
    public void testUseContextSettingValue() {
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
        scriptService.compile(new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap()), contextA);
                            )
            "10",
        // Note: lowering the max below an already stored script is rejected up front by the cluster-settings update
                    .build()
        baseSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
        assertEquals(
                    .put(ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("score").getKey(), "50/5m")
            e.getMessage()
        assertEquals(generalRate, scriptService.cacheHolder.get().general.rate);
}
    public void testCacheHolderContextConstructor() throws IOException {
        builder.put("script.allowed_contexts", "field, aggs");
        String aRate = "2/10m";
        Settings.Builder builder = Settings.builder()
        assertException("10/m", IllegalArgumentException.class, "failed to parse [m]");
    public void testCompilationStatsOnCacheHit() throws IOException {
            // pass
        ScriptCache.CompilationRate contextRate = new ScriptCache.CompilationRate(contextRateStr);
    public void testNotSupportedDisableDynamicSetting() throws IOException {
    private void assertCompileAccepted(String lang, String script, ScriptType scriptType, ScriptContext scriptContext) {
        scriptService.compile(script, context);
    public void testMaxSizeLimit() throws Exception {
        assertEquals("stored script [_id] does not exist and cannot be deleted", e.getMessage());
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(a).getKey(), aRate)
        int numberOfCompilations = randomIntBetween(1, 20);
        assertCompileAccepted("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
            null,
            scriptService.compile(new Script(scriptType, lang, script, Collections.emptyMap()), scriptContext);
        assertNotNull(holder.contextCache.get(name));
import org.opensearch.common.xcontent.XContentFactory;
    public void testFallbackContextSettings() {
    }
        assertNotNull(scriptService.cacheHolder.get().general);
                containsString(
                    ScriptService.UNLIMITED_COMPILATION_RATE_KEY
                + "to [76/10m] if compile rates disabled via [script.disable_max_compilations_rate]",
    public void testDeleteScript() throws Exception {
                    .build()
        illegal = expectThrows(IllegalArgumentException.class, () -> {
        assertNull(scriptService.cacheHolder.get().contextCache);
            "10/",
        ScriptContext<?> context = randomFrom(contexts.values());
import static org.opensearch.script.ScriptService.SCRIPT_CACHE_EXPIRE_SETTING;
                        ).build()
 *    http://www.apache.org/licenses/LICENSE-2.0
        scriptService.compile(new Script(ScriptType.INLINE, "test", "2+2", Collections.emptyMap()), randomFrom(contexts.values()));
        assertThat(new ScriptCache.CompilationRate("10/60s"), is(new ScriptCache.CompilationRate(10, TimeValue.timeValueMinutes(1))));
            );
                randomFrom(contexts.values())
                    SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(c).getKey(),
        clusterSettings.applySettings(Settings.builder().put(ScriptService.SCRIPT_MAX_SIZE_IN_BYTES.getKey(), 6).build());
    }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.ClusterSettings;
            new HashMap<>(),
        assertNotNull(holder.contextCache.get(name).get());
    }
                    SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("ingest").getKey(),
        assertException("-1/1m", IllegalArgumentException.class, "rate [-1] must be positive");
        ScriptContext<?> contextB = randomValueOtherThan(contextA, () -> randomFrom(contexts.values()));
        );
            .build();
        Settings.Builder builder = Settings.builder();
            buildScriptService(
        logger.info("--> setup script service");
            scriptService.compile(
        );
        }
        TimeValue cacheExpireFooParsed = TimeValue.parseTimeValue(cacheExpireFoo, "");
    public void testAllowSomeScriptTypeSettings() throws IOException {
        assertException("6.0/1m", IllegalArgumentException.class, "could not parse [6.0] as integer in value [6.0/1m]");
                    + scriptType
                )
                Settings.builder().put("script.disable_max_compilations_rate", true).put("script.max_compilations_rate", "76/10m").build()
        assertEquals(3L, scriptService.stats().getCompilationLimitTriggered());
        assertEquals(contexts.keySet(), scriptService.cacheHolder.get().contextCache.keySet());
        });
                .endObject()
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_CACHE_SIZE_SETTING, SCRIPT_GENERAL_CACHE_EXPIRE_SETTING });
            )
        assertEquals(1L, scriptService.cacheStats().getGeneralStats().getCacheEvictions());
            .metadata(
import java.util.Collections;
        assertEquals(numberOfCompilations, scriptService.stats().getCompilations());
                "compile should have been rejected for lang ["
        assertEquals("parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [unlimited]", illegal.getMessage());
            "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [anything]"
            buildScriptService(
                .field("lang", "_lang")
            ScriptMetadata.deleteStoredScript(errorMetadata, "_id");
            .put(SCRIPT_GENERAL_CACHE_SIZE_SETTING.getKey(), cacheSizeBackup)
    }
        // Exactly the stored size is allowed, as is a larger limit.
        // calls (against the post-update cluster state) so an out-of-range max_size is rejected before commit rather
                scripts.put("test2", new StoredScriptSource("test", "1", Collections.emptyMap()));
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
                .startObject()
        buildScriptService(Settings.EMPTY);
    public void testMultipleCompilationsCountedInCompilationStats() throws IOException {
        assertEquals("parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [use-context]", illegal.getMessage());
        assertEquals(new ScriptCache.CompilationRate(bRate), scriptService.cacheHolder.get().contextCache.get(b).get().rate);
        ScriptCache.CompilationRate generalRate = new ScriptCache.CompilationRate(compilationRate);
            new Setting<?>[] { SCRIPT_GENERAL_CACHE_SIZE_SETTING, SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING }
            illegal.getMessage()
            );
            buildScriptService(
            .put(
    }
            "Cannot set custom general compilation rates [script.max_compilations_rate] "
        assertNotNull(scriptService.cacheHolder.get().contextCache);
        builder.put("script.allowed_contexts", "none");
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(b).getKey(), bRate)
        // testValidateMaxSizeInBytesAgainstClusterState). The apply-time setter no longer throws, so applying a smaller
import org.opensearch.core.common.bytes.BytesArray;
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(contextB.name).getKey(), bRate)
    public void testAllowNoScriptContextSettings() throws IOException {
        assertNull(scriptMetadata.getStoredScript("_id"));
        assertEquals("abc", scriptService.getStoredScript(cs, new GetStoredScriptRequest("_id")).getSource());
        assertEquals(holder, scriptService.cacheHolder.get());
        // Summed up
    }
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
        assertNull(scriptService.cacheHolder.get().contextCache);
