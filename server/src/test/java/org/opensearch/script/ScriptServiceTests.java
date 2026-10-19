        scriptService.compile(new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap()), randomFrom(contexts.values()));
                        ScriptMetadata.TYPE,
            )  
 */
            IllegalArgumentException.class,  
        try {
                                MediaTypeRegistry.JSON
    }  
 * ownership. Elasticsearch licenses this file to you under  
        assertNull(scriptService.cacheHolder.get().contextCache);
                "compile should have been rejected for lang ["
        // calls (against the post-update cluster state) so an out-of-range max_size is rejected before commit rather
        assertCompileAccepted("painless", "script", ScriptType.INLINE, IngestScript.CONTEXT);
            .put(ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("foo").getKey(), cacheExpireFoo)
    }  
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
import java.util.Map;
                    ScriptService.DISABLE_DYNAMIC_SCRIPTING_SETTING  
        illegal = expectThrows(IllegalArgumentException.class, () -> {  
        TimeValue cacheExpireFooParsed = TimeValue.parseTimeValue(cacheExpireFoo, "");
            StoredScriptSource.parse(script, MediaTypeRegistry.JSON)
        scriptMetadata = ScriptMetadata.deleteStoredScript(scriptMetadata, "_id");
        Settings.Builder builder = Settings.builder()
        assertEquals(1L, stats.getContextStats().get(contextA.name).getCompilationLimitTriggered());
                    .build()
import org.opensearch.common.unit.TimeValue;
 */  
 * specific language governing permissions and limitations
        assertEquals(new ScriptCache.CompilationRate(bCompilationRate), scriptService.cacheHolder.get().contextCache.get(b).get().rate);
            buildScriptService(
    public void testCompileCountedInCompilationStats() throws IOException {  
        clusterSettings.applySettings(Settings.builder().put(ScriptService.SCRIPT_MAX_SIZE_IN_BYTES.getKey(), 6).build());  
        buildScriptService(  
 * Licensed to Elasticsearch under one or more contributor  
        // value directly here would simply take effect; this test focuses on inline-compile limit tracking.
                    + "], scripted_op ["
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
 * license agreements. See the NOTICE file distributed with
        assertEquals(1L, stats.getContextStats().get(contextA.name).getCacheEvictions());  
        assertEquals(1L, scriptService.cacheStats().getContextStats().get(ctx.name).getCompilations());
                e.getMessage(),
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
                scriptService.contextCache(
                                MediaTypeRegistry.JSON
                    .build()
            );
                    ScriptService.UNLIMITED_COMPILATION_RATE_KEY
        assertEquals(cacheSizeBackup, ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("bar").get(s).intValue());
    }
        Script script = new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap());  
 * under the License.  
        FieldScript script2 = leafFactory.newInstance(null);
        String a = randomFrom(contextNames);
        assertCompileRejected(null, "script", ScriptType.STORED, FieldScript.CONTEXT);
            .put(ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("foo").getKey(), cacheSizeFoo)
    public void testDeleteScript() throws Exception {
        assertCompileRejected("painless", "script", ScriptType.INLINE, AggregationScript.CONTEXT);  
public class ScriptServiceTests extends OpenSearchTestCase {
            + "]; please use indexed, or scripts with parameters instead; this limit can be changed by the [script.context."
                    contexts.get(b)  
 * the Apache License, Version 2.0 (the "License"); you may
            Settings.builder()  
                Map<String, StoredScriptSource> scripts = new HashMap<>();  
        assertEquals(3L, stats.getContextStats().get(contextB.name).getCompilations());  
 *
    private ClusterSettings clusterSettings;  
            );  
        });
import java.util.function.Function;
                .field("source", "abc")  
                .put(  
        );  
        engines.put("test", new MockScriptEngine("test", scripts, Collections.emptyMap()));  
        // Set should not throw when using general cache  
        Exception e = expectThrows(clazz, () -> new ScriptCache.CompilationRate(rate));
        ScriptMetadata scriptMetadata = ScriptMetadata.putStoredScript(
        buildScriptService(s);  
            "_id",  
import static org.opensearch.script.ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING;  
        buildScriptService(Settings.EMPTY);
            illegal.getMessage()
        ScriptContext<?> ctx = randomFrom(contexts.values());
                        ).build()
    }
        assertNotNull(holder.contextCache.get(name));
        assertCompileRejected("painless", "script", ScriptType.INLINE, UpdateScript.CONTEXT);  
        builder.put("script.allowed_contexts", "none");
                    + lang  
        );
            Map<String, StoredScriptSource> getScriptsFromClusterState() {
        TimeValue contextExpire = TimeValue.timeValueMinutes(randomIntBetween(10, 200));  
        );  
        assertEquals(1L, stats.getContextStats().get(contextB.name).getCacheEvictions());
    public void testAllowNoScriptContextSettings() throws IOException {  
    public void testAllowAllScriptTypeSettings() throws IOException {
 * The OpenSearch Contributors require contributions made to  
        assertEquals(numberOfCompilations, scriptService.stats().getCompilations());  
                    .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), ScriptService.UNLIMITED_COMPILATION_RATE_KEY)
    }
                b,  
                    .put(ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("score").getKey(), "50/5m")  
        assertCompileAccepted(null, "script", ScriptType.STORED, FieldScript.CONTEXT);
        assertEquals(
            illegal.getMessage()
        );  
        assertEquals(new ScriptCache.CompilationRate(bRate), scriptService.cacheHolder.get().general.rate);
        Script script = new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap());
        buildScriptService(Settings.EMPTY);
                .field("lang", "_lang")
                scripts.put("test2", new StoredScriptSource("test", "1", Collections.emptyMap()));
    }
            );
            buildScriptService(  
        assertEquals(ingest.cacheSizeDefault, holder.contextCache.get(name).get().cacheSize);
        assertException("-1/1m", IllegalArgumentException.class, "rate [-1] must be positive");  
    }
        assertEquals(1L, scriptService.cacheStats().getGeneralStats().getCacheEvictions());  
        // Exactly the stored size is allowed, as is a larger limit.
            .build();
            Settings.builder()
import static org.hamcrest.Matchers.notNullValue;
        assertNotNull(scriptMetadata);  
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(contextA.name).getKey(), aRate)
        assertEquals(ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.get(s), ScriptService.USE_CONTEXT_RATE_VALUE);  
 */
        );
            // pass  
            "Cannot set custom context compilation rates [script.context.field.max_compilations_rate, "  
                    .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "10/1m")
                return scripts;  
            "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [10]"
    private Settings baseSettings;
        assertEquals(1L, scriptService.stats().getCompilations());  
    }
                .put(  
import static org.hamcrest.CoreMatchers.containsString;
                .build()
        assertEquals(ingest.cacheExpireDefault, holder.contextCache.get(name).get().cacheExpire);
            );
            scriptService.compile(new Script(scriptType, lang, script, Collections.emptyMap()), scriptContext);  
        builder.put("script.allowed_contexts", "field, aggs");
        );  
            );
        // Context specific  
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });  
                    )
        assertCompileAccepted("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
    public void testMaxCompilationRateSetting() throws Exception {
        assertEquals(generalRate, scriptService.cacheHolder.get().general.rate);  
import static org.hamcrest.Matchers.sameInstance;
                .build()
        scriptService.cacheHolder.get().set(c, scriptService.contextCache(s, contexts.get(c)));
            null,  
        int cacheSizeBackup = randomIntBetween(0, 1024);
                        ).build()  
        assertCompileRejected("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
        assertCompileAccepted("painless", "script", ScriptType.INLINE, UpdateScript.CONTEXT);
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
    }  
        FieldScript.Factory factoryScript1 = scriptService.compile(script, FieldScript.CONTEXT);
                .startObject()
        int numberOfCompilations = randomIntBetween(1, 20);
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
                )  
import org.opensearch.cluster.metadata.Metadata;
        GeneralScriptException gse = expectThrows(
        ScriptMetadata scriptMetadata = ScriptMetadata.putStoredScript(
            GeneralScriptException.class,
                .put(SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(contextB.name).getKey(), 2)
        }
        scriptService.setCacheHolder(
        ScriptContext<?> contextA = randomFrom(contexts.values());
        assertEquals("abc", scriptService.getStoredScript(cs, new GetStoredScriptRequest("_id")).getSource());  
        Script script = new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap());
        BiFunction<String, String, String> msg = (rate, ctx) -> ("[script] Too many dynamic script compilations within, max: ["
        contexts = new HashMap<>(ScriptModule.CORE_CONTEXTS);  
        scriptService.compile(new Script(ScriptType.INLINE, "test", "10+10", Collections.emptyMap()), randomFrom(contexts.values()));  
                        ScriptMetadata.TYPE,  
                .put(
            protected StoredScriptSource getScriptFromClusterState(String id) {
        gse = expectThrows(  
        buildScriptService(Settings.EMPTY);
        illegal = expectThrows(IllegalArgumentException.class, () -> {
        String bRate = "78/6m";
                            StoredScriptSource.parse(
        assertNotNull(holder.contextCache.get(name).get());  
        assertEquals(new ScriptCache.CompilationRate(aRate), scriptService.cacheHolder.get().contextCache.get(b).get().rate);  
            "/1m",  
                .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), ScriptService.USE_CONTEXT_RATE_KEY)
import org.opensearch.common.xcontent.XContentFactory;  
                        + " is not a supported setting, replace with fine-grained script settings"
    }
        );  
        assertNull(
        assertEquals(  
    public void testCacheHolderChangeSettings() throws IOException {  
                Settings.builder()
            }
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
 * this file be licensed under the Apache-2.0 license or a
                + "to [76/10m] if compile rates disabled via [script.disable_max_compilations_rate]",
                Settings.builder()
        assertEquals(contexts.keySet(), scriptService.cacheHolder.get().contextCache.keySet());
        String type = scriptEngine.getType();
        scriptService.compile(new Script(ScriptType.INLINE, "test", "2+2", Collections.emptyMap()), contextA);  
        Settings.Builder builder = Settings.builder();
import org.junit.Before;  
        String aRate = "77/5m";  
import java.util.Set;  
import org.opensearch.core.common.breaker.CircuitBreakingException;
        assertEquals(holder.general.rate, new ScriptCache.CompilationRate(compilationRate));  
/*  
        );  
        );
 *
                    .put(ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("ingest").getKey(), "5m")
    }
/*
                            )  
        scripts.put("script", p -> null);  
    public void testMultipleCompilationsCountedInCompilationStats() throws IOException {  
        assertThat(factoryScript1, sameInstance(factoryScript2));  
    }
        buildScriptService(builder.build());  
        }
        Set<String> contextNames = contexts.keySet();
                    ScriptService.UNLIMITED_COMPILATION_RATE_KEY
    public void testAllowSomeScriptTypeSettings() throws IOException {
        assertException(
    }
        String a = randomFrom(contexts.keySet());
        scriptService.setCacheHolder(s);
        assertEquals("parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [use-context]", illegal.getMessage());  
        Settings finalSettings = Settings.builder().put(baseSettings).put(additionalSettings).build();
    public void testIndexedScriptCountedInCompilationStats() throws IOException {  
import java.util.function.BiFunction;
            );  
        assertEquals(CircuitBreakingException.class, gse.getRootCause().getClass());
        buildScriptService(
            IllegalArgumentException.class,
import static org.mockito.Mockito.mock;  
import java.io.IOException;
        BytesReference script = BytesReference.bytes(  
import java.util.HashMap;
        );  
        gse = expectThrows(
                + "[script.disable_max_compilations_rate]",
        String aCompilationRate = "77/5m";
        FieldScript.LeafFactory leafFactory = factoryScript.newFactory(
            "Context cache settings [script.context.score.max_compilations_rate] requires "  
            IllegalArgumentException.class,
package org.opensearch.script;
        );
import static org.opensearch.script.ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING;
                    SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("ingest").getKey(),  
        builder.put("script.allowed_types", "none");
    }
            "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [anything]"  
                    .put("script.context.field.max_compilations_rate", "77/10m")  
    }  
        assertEquals(msg.apply(aRate, contextA.name), gse.getRootCause().getMessage());
        assertNull(scriptService.cacheHolder.get().general);
            illegal.getMessage()
        assertException("6/-1m", IllegalArgumentException.class, "time value [-1m] must be positive");
                new Script(ScriptType.INLINE, "test", i + "+" + i, Collections.emptyMap()),
        buildScriptService(Settings.builder().put("script.disable_max_compilations_rate", true).build());
        String cacheExpireBackup = randomTimeValue(1, 1000, "h");
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(b).getKey(), bRate)
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(b).getKey(), bCompilationRate)
        Settings.Builder builder = Settings.builder();  
            "Cannot set custom general compilation rates [script.max_compilations_rate] "  
        );  
        });
        assertEquals("abc", scriptMetadata.getStoredScript("_id").getSource());
        TimeValue cacheExpireBackupParsed = TimeValue.parseTimeValue(cacheExpireBackup, "");
            "_id",
        scriptService = new ScriptService(finalSettings, engines, contexts) {  
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptRequest;
            buildScriptService(
    }
        // transport action (see validateMaxSizeInBytes(int, ClusterState), covered by
        // Fallback to context defaults
                .put(ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("field").getKey(), 123)
import org.opensearch.ResourceNotFoundException;  
import org.opensearch.core.common.bytes.BytesArray;
            Settings.builder()
        assertNull(scriptService.cacheHolder.get().general);
        // Should not throw.
            () -> scriptService.compile(new Script(ScriptType.INLINE, "test", "3+3", Collections.emptyMap()), contextA)  
            illegal.getMessage()  
        assertEquals(new ScriptCache.CompilationRate(aRate), scriptService.cacheHolder.get().contextCache.get(a).get().rate);  
        assertEquals(1L, scriptService.stats().getCompilations());  
    private void assertCompileAccepted(String lang, String script, ScriptType scriptType, ScriptContext scriptContext) {
        assertEquals("stored script [_id] does not exist and cannot be deleted", e.getMessage());  
        assertException(  
        String b = randomValueOtherThan(a, () -> randomFrom(contextNames));
            .build();  
        String b = randomValueOtherThan(a, () -> randomFrom(contexts.keySet()));  
            .put(SCRIPT_GENERAL_CACHE_SIZE_SETTING.getKey(), 1)
        builder.put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "10/1m");
            XContentFactory.jsonBuilder()
    }
        assertException("10/5s", IllegalArgumentException.class, "time value [5s] must be at least on a one minute resolution");
                .put(ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("score").getKey(), "50/5m")  
                    .put(ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("field").getKey(), 123)  
    public void testCompilationRateUnlimitedContextOnly() throws IOException {
            buildScriptService(  
            scriptService.compile(new Script(ScriptType.INLINE, "test", "10+10", Collections.emptyMap()), randomFrom(contexts.values()));  
                Settings.builder()
            ScriptMetadata.deleteStoredScript(errorMetadata, "_id");
                randomFrom(contexts.values())  
        ScriptService.validateMaxSizeInBytes(3, cs);  
                                new BytesArray("{\"script\": {\"lang\": \"_lang\", \"source\": \"abc\"} }"),  
        assertThat(new ScriptCache.CompilationRate("10/60s"), is(new ScriptCache.CompilationRate(10, TimeValue.timeValueMinutes(1))));  
        scriptService.compile(new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap()), contextA);
        // testValidateMaxSizeInBytesAgainstClusterState). The apply-time setter no longer throws, so applying a smaller  
    public void testAllowSomeScriptContextSettings() throws IOException {
 * GitHub history for details.
        assertThat(e.getMessage(), containsString("script context [" + IngestScript.CONTEXT.name + "] not supported"));  
    }
 * this work for additional information regarding copyright
        assertNotNull(scriptService.cacheHolder.get().general);  
        // Context A
                // mock the script that gets retrieved from an index
            ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getAsMap(s);  
            new Setting<?>[] { SCRIPT_GENERAL_CACHE_SIZE_SETTING, SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING }
        baseSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString()).build();
                Metadata.builder()  
        holder = scriptService.cacheHolder.get();
    }
        assertCompileRejected(null, "script", ScriptType.STORED, FieldScript.CONTEXT);  
        buildScriptService(
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
            () -> scriptService.compile(new Script(ScriptType.INLINE, "test", "7+7", Collections.emptyMap()), contextB)
        buildScriptService(Settings.EMPTY);
import static org.opensearch.search.lookup.SearchLookup.UNKNOWN_SHARD_ID;
        assertException(
        assertException("6.0/1m", IllegalArgumentException.class, "could not parse [6.0] as integer in value [6.0/1m]");
        cs = ClusterState.builder(new ClusterName("_name")).build();
        String contextRateStr = randomIntBetween(10, 1024) + "/" + randomIntBetween(10, 200) + "m";  
                    + scriptType  
                    + "script_type ["
        assertSettingDeprecationsAndWarnings(
        });
import org.opensearch.core.xcontent.MediaTypeRegistry;
            "Context cache settings [script.context.ingest.cache_expire] requires " + "[script.max_compilations_rate] to be [use-context]",
                    + scriptContext
        assertThat(e.getMessage(), is(message));  
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
        ScriptCache.CompilationRate generalRate = new ScriptCache.CompilationRate(compilationRate);
    public void setup() throws IOException {  
                .build()
        contexts.remove(IngestScript.CONTEXT.name);
        buildScriptService(builder.build());  
    }
        assertNull(scriptService.getStoredScript(cs, new GetStoredScriptRequest("_id")));  
import org.opensearch.common.settings.Settings;
    public void testFallbackContextSettings() {  
    }  
            new HashMap<>(),  
        scriptService.compile(new Script(ScriptType.STORED, null, "script", Collections.emptyMap()), ctx);  
    @Before
    private void assertCompileRejected(String lang, String script, ScriptType scriptType, ScriptContext scriptContext) {
                .endObject()
        );  
        scriptService.setCacheHolder(Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), bRate).build());
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
        assertEquals(new ScriptCache.CompilationRate(bRate), scriptService.cacheHolder.get().contextCache.get(b).get().rate);
    }
        ClusterState empty = ClusterState.builder(new ClusterName("_name")).build();
        buildScriptService(Settings.EMPTY);
                            )
            StoredScriptSource.parse(new BytesArray("{\"script\": {\"lang\": \"_lang\", \"source\": \"abc\"} }"), MediaTypeRegistry.JSON)
        assertNotNull(holder.general);
        assertSettingDeprecationsAndWarnings(
        assertException("6/1.6m", IllegalArgumentException.class, "failed to parse [1.6m], fractional time values are not supported");
        );  
        });
    }
        builder.put(SCRIPT_GENERAL_CACHE_SIZE_SETTING.getKey(), 1);
        assertEquals(msg.apply(bRate, contextB.name), gse.getRootCause().getMessage());  
        assertCompileAccepted("painless", "script", ScriptType.INLINE, AggregationScript.CONTEXT);  
            e.getMessage()
            fail("script service should have thrown exception due to non supported script.disable_dynamic setting");
        Settings.Builder builder = Settings.builder();  
        buildScriptService(Settings.EMPTY);
            .put(ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), ScriptService.USE_CONTEXT_RATE_KEY)
                Metadata.builder()
        scriptService.compile(new Script(ScriptType.INLINE, "test", "10+10", Collections.emptyMap()), randomFrom(contexts.values()));
    public void testAllowAllScriptContextSettings() throws IOException {
        buildScriptService(builder.build());  
            );  
        assertEquals(2L, scriptService.stats().getCompilations());  
        }
        );
    }
    public void testConflictContextSettings() throws IOException {
        );
            .put(  
        assertNull(holder.contextCache);
        assertEquals(new ScriptCache.CompilationRate(aCompilationRate), scriptService.cacheHolder.get().contextCache.get(a).get().rate);  
        buildScriptService(Settings.builder().put(ScriptService.SCRIPT_MAX_SIZE_IN_BYTES.getKey(), 4).build());  
        scriptService.compile(new Script(ScriptType.INLINE, "test", "2+2", Collections.emptyMap()), randomFrom(contexts.values()));
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            )  
        assertEquals(
            "10/",
    public void testFallbackToContextDefaults() throws IOException {
import java.util.Collections;  
        Settings.Builder builder = Settings.builder();
            .build();
import org.opensearch.env.Environment;
            .put(SCRIPT_GENERAL_CACHE_SIZE_SETTING.getKey(), cacheSizeBackup)
    private void buildScriptService(Settings additionalSettings) throws IOException {
        int cacheSizeFoo = randomValueOtherThan(cacheSizeBackup, () -> randomIntBetween(0, 1024));
        }
                    .build()
                            StoredScriptSource.parse(  
        assertEquals(
            .set(
        // Summed up
            scriptService.compile(
import org.opensearch.test.OpenSearchTestCase;
                    ScriptService.UNLIMITED_COMPILATION_RATE_KEY
            "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [10/]"
        // No stored scripts (no ScriptMetadata) => nothing to validate against.  
        // Stored script "abc" is 3 bytes. The static validator is what the cluster-settings update transport action
                .build()  
        IllegalArgumentException iae = expectThrows(IllegalArgumentException.class, () -> {
            @Override
            () -> scriptService.compile(new Script(ScriptType.INLINE, type, "test", Collections.emptyMap()), IngestScript.CONTEXT)
        });
        Settings s = Settings.builder()  
        buildScriptService(
    public void testAllowNoScriptTypeSettings() throws IOException {  
    public void testGetStoredScript() throws Exception {  
        assertEquals(ScriptCache.UNLIMITED_COMPILATION_RATE, scriptService.cacheHolder.get().contextCache.get(c).get().rate);
        clusterSettings = new ClusterSettings(finalSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                )
                containsString(
                )  
        assertEquals(3L, scriptService.stats().getCompilationLimitTriggered());
            scripts.put(i + "+" + i, p -> null); // only care about compilation, not execution
        ScriptContext<?> ingest = contexts.get(name);  
        buildScriptService(builder.build());
            .metadata(  
            GeneralScriptException.class,
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(name).getKey(), contextRateStr)
                        new ScriptMetadata.Builder(null).storeScript(  
        logger.info("--> setup script service");
            );  
            IllegalArgumentException.class,  
            assertThat(  
                                new BytesArray("{\"script\": {\"lang\": \"_lang\", \"source\": \"abc\"} }"),
                    .build()
        assertException("foo/bar", IllegalArgumentException.class, "could not parse [foo] as integer in value [foo/bar]");  
        // prevent duplicates using map
            "10",
        ScriptContext<?> contextB = randomValueOtherThan(contextA, () -> randomFrom(contexts.values()));  
        IllegalArgumentException e = expectThrows(
        );
            null,
                .startObject()
        assertEquals("parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [unlimited]", illegal.getMessage());  
        for (int i = 0; i < 20; ++i) {  
                    )
import static org.opensearch.script.ScriptService.SCRIPT_CACHE_EXPIRE_SETTING;
        assertEquals(contextCacheSize, holder.contextCache.get(name).get().cacheSize);  
            new SearchLookup(null, null, UNKNOWN_SHARD_ID, mock(FieldsLookup.class))
            + rate  
            @Override  
        scriptService.compile(new Script(ScriptType.INLINE, "test", "4+4", Collections.emptyMap()), contextB);  
        assertNotNull(holder.contextCache.get(name));  
                + "[script.max_compilations_rate] to be [use-context]",
        assertNotNull(holder.contextCache.get(name).get());
        });  
        } catch (IllegalArgumentException | IllegalStateException e) {
import org.opensearch.common.settings.ClusterSettings;
        scriptService.setCacheHolder(Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), bRate).build());
        scriptService.compile(new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap()), randomFrom(contexts.values()));
        } catch (IllegalArgumentException e) {
    private ScriptEngine scriptEngine;
        );
            "anything",
        buildScriptService(Settings.EMPTY);  
        });
                ScriptService.SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("foo").getKey(),
    public void testCompileNonRegisteredContext() throws IOException {  
        );  
        assertEquals(2L, stats.getContextStats().get(contextB.name).getCompilationLimitTriggered());
                Settings.builder()  
import org.opensearch.cluster.ClusterName;
        scriptService.cacheHolder.get()
                + "script.context.ingest.max_compilations_rate] if compile rates disabled via "
                    Settings.builder().put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(b).getKey(), aRate).build(),
                    SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace("field").getKey(),
    public void testNotSupportedDisableDynamicSetting() throws IOException {  
            buildScriptService(
                    .build()  
            "Context cache settings [script.context.field.cache_max_size] requires " + "[script.max_compilations_rate] to be [use-context]",
                .put(SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace(name).getKey(), contextExpire)
                    SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(c).getKey(),
        buildScriptService(Settings.EMPTY);
        });  
        assertThat(new ScriptCache.CompilationRate("10/1m"), is(new ScriptCache.CompilationRate(10, TimeValue.timeValueMinutes(1))));
        ScriptService.validateMaxSizeInBytes(65535, cs);
        assertNotNull(holder.contextCache);
        };
                scripts.put("test1", new StoredScriptSource("test", "1+1", Collections.emptyMap()));
                .build()
                    .put(ScriptService.DISABLE_DYNAMIC_SCRIPTING_SETTING, randomUnicodeOfLength(randomIntBetween(1, 10)))
        ResourceNotFoundException e = expectThrows(ResourceNotFoundException.class, () -> {  
                    .putCustom(
        engines.put(scriptEngine.getType(), scriptEngine);
            GeneralScriptException.class,  
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(a).getKey(), aCompilationRate)  
            fail(
                Settings.builder()
        assertEquals(2L, scriptService.cacheStats().getGeneralStats().getCompilations());
        assertNull(scriptMetadata.getStoredScript("_id"));  
        scriptEngine = new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, scripts, Collections.emptyMap());
import org.opensearch.search.lookup.SearchLookup;
    public void testScriptsUseCachedSourceLookup() throws IOException {  
        assertEquals(cacheExpireFooParsed, ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("foo").get(s));
    public void testUseContextSettingValue() {  
    public void testCacheEvictionCountedInCacheEvictionsStats() throws IOException {
    public void testCacheHolderGeneralConstructor() throws IOException {
        ScriptMetadata errorMetadata = scriptMetadata;
        assertNotNull(scriptMetadata);
        );
                        new ScriptMetadata.Builder(null).storeScript(
        assertEquals(msg.apply(bRate, contextB.name), gse.getRootCause().getMessage());
        assertNull(scriptService.cacheHolder.get().contextCache);
    public void testInlineScriptCompiledOnceCache() throws IOException {
        assertNull(scriptService.cacheHolder.get().contextCache);
        ScriptService.validateMaxSizeInBytes(0, empty);
        buildScriptService(Settings.EMPTY);
            buildScriptService(  
                    .putCustom(
        );  
        buildScriptService(Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "75/5m").build());
        clusterSettings.applySettings(Settings.builder().put(ScriptService.SCRIPT_MAX_SIZE_IN_BYTES.getKey(), 5).build());
                    + "]"  
        assertEquals(2L, scriptService.stats().getCacheEvictions());
import static org.opensearch.script.ScriptService.SCRIPT_CACHE_SIZE_SETTING;
    }
            IllegalArgumentException.class,  
            .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "2/1m");  
        assertNotNull(scriptService.cacheHolder.get().contextCache);
    }
        assertEquals(generalRate, scriptService.cacheHolder.get().general.rate);
    }
        // get of missing context should be null  
        ScriptService.CacheHolder holder = scriptService.cacheHolder.get();  
        String bRate = "3/10m";
        assertEquals(CircuitBreakingException.class, gse.getRootCause().getClass());  
    public void testStoreScript() throws Exception {
        try {
import static org.opensearch.script.ScriptService.SCRIPT_GENERAL_CACHE_SIZE_SETTING;
                .endObject()
import static org.hamcrest.Matchers.is;  
        buildScriptService(builder.build());
                )
        assertNotNull(scriptService.cacheHolder.get().contextCache);  
    private Map<String, ScriptContext<?>> contexts;  
        assertException("6/0m", IllegalArgumentException.class, "time value [0m] must be positive");  
        buildScriptService(builder.build());
        );  
                .field("script")  
    public void testDisableCompilationRateSetting() throws IOException {
    }
    public void testCacheHolderContextConstructor() throws IOException {
            .build();
    }
                .put(ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("ingest").getKey(), "5m")
    private Map<String, ScriptEngine> engines;
        assertCompileAccepted("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
        builder.put("script.allowed_types", "inline");
        String name = "ingest";
    public void testCompilationStatsOnCacheHit() throws IOException {  
            () -> scriptService.compile(new Script(ScriptType.INLINE, "test", "8+8", Collections.emptyMap()), contextB)
        // Context B
            Settings.builder()
        assertEquals("exceeded max allowed inline script size in bytes [4] with size [5] for script [10+10]", iae.getMessage());
        assertEquals(contextExpire, holder.contextCache.get(name).get().cacheExpire);
                Settings.builder()
        int contextCacheSize = randomIntBetween(1, 1024);
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
        ScriptCacheStats stats = scriptService.cacheStats();
 * software distributed under the License is distributed on an
        assertThat(scriptService.compile(new Script(scriptType, lang, script, Collections.emptyMap()), scriptContext), notNullValue());
        );
        scriptService.compile(new Script(ScriptType.INLINE, "test", "6+6", Collections.emptyMap()), contextB);
    }  
        assertException(
                )
        String c = randomValueOtherThanMany(s -> a.equals(s) || b.equals(s), () -> randomFrom(contextNames));  
            buildScriptService(  
        assertCompileAccepted("painless", "script", ScriptType.INLINE, AggregationScript.CONTEXT);
        assertEquals(
        String aRate = "2/10m";
                    .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "10/1m")  
                    .put("script.disable_max_compilations_rate", true)
        assertCompileAccepted("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
        FieldScript.Factory factoryScript2 = scriptService.compile(script, FieldScript.CONTEXT);
            .put(SCRIPT_GENERAL_CACHE_EXPIRE_SETTING.getKey(), cacheExpireBackup)  
        assertEquals(1L, scriptService.stats().getCompilations());
 *  
        // Note: lowering the max below an already stored script is rejected up front by the cluster-settings update
                .put(SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(name).getKey(), contextCacheSize)  
        for (int i = 0; i < numberOfCompilations; i++) {  
            Settings.builder()
        assertThat(script1.getLeafLookup().source(), sameInstance(script2.getLeafLookup().source()));
                    + "], "
        });
    }
            + ".max_compilations_rate] setting");  
        ScriptCache.CompilationRate contextRate = new ScriptCache.CompilationRate(contextRateStr);
            .metadata(
/*
        assertEquals(2L, stats.getContextStats().get(contextA.name).getCompilations());
        ScriptService.CacheHolder holder = scriptService.cacheHolder.get();
        Settings s = Settings.builder()
            scriptService.cacheHolder.get().get(randomValueOtherThanMany(contexts.keySet()::contains, () -> randomAlphaOfLength(8)))
        assertEquals(  
        ScriptService.CacheHolder holder = scriptService.cacheHolder.get();
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(contextB.name).getKey(), bRate)  
            new Setting<?>[] { SCRIPT_GENERAL_CACHE_SIZE_SETTING, SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING }
        assertEquals(contexts.keySet(), scriptService.cacheHolder.get().contextCache.keySet());
                            "_id",
        buildScriptService(Settings.EMPTY);
                    .put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), "10/1m")
        assertEquals(ingest.maxCompilationRateDefault, holder.contextCache.get(name).get().rate.asTuple());  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> ScriptService.validateMaxSizeInBytes(2, cs));
        scriptService.compile(script, context);
    }  
        scriptService.setCacheHolder(
        // Use context specific  
 * SPDX-License-Identifier: Apache-2.0
}
 * not use this file except in compliance with the License.
                    .build()
        assertEquals(1L, scriptService.stats().getCacheEvictions());
        );
                ScriptService.USE_CONTEXT_RATE_KEY
        illegal = expectThrows(IllegalArgumentException.class, () -> {  
        String bCompilationRate = "78/6m";
import static org.opensearch.script.ScriptService.SCRIPT_GENERAL_CACHE_EXPIRE_SETTING;  
import org.opensearch.search.lookup.FieldsLookup;  
                .put(SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace(contextA.name).getKey(), 1)  
    public void testContextCacheStats() throws IOException {  
        Settings s = Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), compilationRate).build();
            );
 * compatible open source license.
        buildScriptService(Settings.builder().put(SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), compilationRate).build());  
        assertNotNull(holder.contextCache);
            illegal.getMessage()  
import org.opensearch.cluster.ClusterState;  
        String compilationRate = "77/5m";
        Settings.Builder builder = Settings.builder();  
        String cacheExpireFoo = randomValueOtherThan(cacheExpireBackup, () -> randomTimeValue(1, 1000, "h"));  
        assertEquals(cacheExpireBackupParsed, ScriptService.SCRIPT_CACHE_EXPIRE_SETTING.getConcreteSettingForNamespace("bar").get(s));
                            "_id",
        FieldScript script1 = leafFactory.newInstance(null);
        scriptService.registerClusterSettingsListeners(clusterSettings);
import org.opensearch.core.common.bytes.BytesReference;  
        assertCompileRejected("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
        assertNotNull(scriptService.cacheHolder.get().general);
        assertEquals(contextRate, holder.contextCache.get(name).get().rate);
            );
            "parameter must contain a positive integer and a timevalue, i.e. 10/1m, but was [/1m]"
        FieldScript.Factory factoryScript = scriptService.compile(script, FieldScript.CONTEXT);  
 * Unless required by applicable law or agreed to in writing,
            "script.max_size_in_bytes cannot be set to [2], stored script [_id] exceeds the new value with a size of [3]",
        // than throwing at apply time.  
 * Modifications Copyright OpenSearch Contributors. See  
        assertNull(scriptService.cacheStats().getGeneralStats());  
        ScriptContext<?> context = randomFrom(contexts.values());  
        IllegalArgumentException illegal = expectThrows(IllegalArgumentException.class, () -> {
            );  
    }
        assertException("10/m", IllegalArgumentException.class, "failed to parse [m]");
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });  
        scriptService.compile(new Script(ScriptType.INLINE, "test", "1+1", Collections.emptyMap()), randomFrom(contexts.values()));
        );
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING });
    private void assertException(String rate, Class<? extends Exception> clazz, String message) {
        );
    }
        assertEquals(cacheSizeFoo, ScriptService.SCRIPT_CACHE_SIZE_SETTING.getConcreteSettingForNamespace("foo").get(s).intValue());
    private ScriptService scriptService;
    public void testMaxSizeLimit() throws Exception {
            )
                return new StoredScriptSource("test", "1+1", Collections.emptyMap());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
        assertEquals(holder, scriptService.cacheHolder.get());  
        assertEquals(5L, scriptService.stats().getCompilations());  
        assertSettingDeprecationsAndWarnings(new Setting<?>[] { SCRIPT_GENERAL_CACHE_SIZE_SETTING, SCRIPT_GENERAL_CACHE_EXPIRE_SETTING });  
            Settings.builder()  
                .put(SCRIPT_MAX_COMPILATIONS_RATE_SETTING.getConcreteSettingForNamespace(a).getKey(), aRate)
        );
                Settings.builder().put("script.disable_max_compilations_rate", true).put("script.max_compilations_rate", "76/10m").build()
                .build()
        scriptService.compile(script, context);
import org.opensearch.common.settings.Setting;  
    }
        String compilationRate = "77/5m";
    public void testValidateMaxSizeInBytesAgainstClusterState() throws Exception {  
        scriptService.compile(new Script(ScriptType.INLINE, "test", "5+5", Collections.emptyMap()), contextB);
        assertCompileAccepted("painless", "script", ScriptType.INLINE, FieldScript.CONTEXT);
                    .put("script.context.ingest.max_compilations_rate", "76/10m")
    }  
 * You may obtain a copy of the License at  
        assertNotNull(scriptService.cacheHolder.get().general);  
        engines = new HashMap<>();
            + ctx
