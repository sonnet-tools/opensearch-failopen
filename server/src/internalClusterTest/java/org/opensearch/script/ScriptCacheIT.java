                assertNotNull(ctx);  
        }
}
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
                return ctx;
import java.util.Collections;  
    }
    @Override
        }
import static org.apache.logging.log4j.core.util.Throwables.getRootCause;
        return builder.build();  
import org.opensearch.test.TestGeoShapeFieldMapperPlugin;
import org.opensearch.index.MockEngineFactoryPlugin;
        assertEquals(RestStatus.TOO_MANY_REQUESTS, ((OpenSearchException) rootCause).status());
    public static Collection<Object[]> parameters() {  
 * this file be licensed under the Apache-2.0 license or a
        if (addMockTransportService()) {  
    protected Settings nodeSettings(int nodeOrdinal) {
        return Collections.unmodifiableList(mocks);
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import org.opensearch.test.transport.MockTransportService;
            .put(super.nodeSettings(nodeOrdinal))  
    }  
    public ScriptCacheIT(Settings settings) {
        client().prepareIndex("test").setId("1").setSource(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject()).get();
 */  
            mocks.add(TestGeoShapeFieldMapperPlugin.class);  
        if (addMockHttpTransport()) {  
        for (String s : ScriptModule.CORE_CONTEXTS.keySet()) {  
                source.put(fieldname, currentValue.longValue() + inc.longValue());
 * compatible open source license.
            }
            if (randomBoolean() && addMockTransportService()) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            }
public class ScriptCacheIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
    public void testPainlessCompilationLimit429Error() throws Exception {
import java.util.ArrayList;  
            }
            }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        super(settings);
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            mocks.add(getTestTransportPlugin());
        mocks.add(AssertActionNamePlugin.class);
        ensureGreen();  
import java.util.HashMap;
import org.opensearch.common.xcontent.XContentFactory;
 * SPDX-License-Identifier: Apache-2.0
        Settings.Builder builder = Settings.builder()
        params.put("field", "field");
                Number inc = (Number) params.getOrDefault("inc", 1);  
package org.opensearch.script;
    }
                mocks.add(NodeMocksPlugin.class);  
 *
    }  
/*  
    }
            return scripts;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
import java.util.Arrays;
        mocks.add(TestSeedPlugin.class);  
            scripts.put("increase_field", vars -> {
    protected Collection<Class<? extends Plugin>> getMockPlugins() {
import org.opensearch.test.MockHttpTransport;  
        assertTrue(rootCause instanceof OpenSearchException);  
            if (randomBoolean()) {
            .put(ScriptService.SCRIPT_GENERAL_MAX_COMPILATIONS_RATE_SETTING.getKey(), ScriptService.USE_CONTEXT_RATE_KEY);
        }
import org.opensearch.common.settings.Settings;
        final ArrayList<Class<? extends Plugin>> mocks = new ArrayList<>();  
            }
        return Arrays.asList(
                mocks.add(MockSearchService.TestPlugin.class);  
import org.opensearch.plugins.Plugin;
            });  
    // Overriding to remove MockScriptService.TestPlugin from the list of plugins  
import org.opensearch.core.rest.RestStatus;  
                mocks.add(MockTransportService.TestPlugin.class);  
            if (randomBoolean()) {
            if (randomBoolean()) {
            () -> client().prepareUpdate("test", "1").setScript(script).execute().get()  
            }
            if (randomBoolean()) {
                mocks.add(MockFSIndexStore.TestPlugin.class);  
        if (addMockGeoShapeFieldMapper()) {
            builder.put("script.context." + s + ".max_compilations_rate", "0/1m");
        return Collections.singleton(CustomScriptPlugin.class);
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
            ExecutionException.class,
            if (addMockInternalEngine() && randomBoolean()) {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import org.opensearch.OpenSearchException;  
        }
        // Putting max_compilation_rate for each context to 0 per minute
        @Override
    @Override
import org.opensearch.search.MockSearchService;
                mocks.add(MockEngineFactoryPlugin.class);  
            mocks.add(MockHttpTransport.TestPlugin.class);
        }
 * The OpenSearch Contributors require contributions made to  
        );
                Map<String, Object> params = (Map<String, Object>) vars.get("params");  
        Script script = new Script(ScriptType.INLINE, "mockscript", "increase_field", params);  
                String fieldname = (String) vars.get("field");
    }  
import java.util.function.Function;
import org.opensearch.index.mapper.MockFieldFilterPlugin;
        Throwable rootCause = getRootCause(exception);
                mocks.add(MockFieldFilterPlugin.class);  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                Number currentValue = (Number) source.get(fieldname);
import org.opensearch.test.store.MockFSIndexStore;  
import org.opensearch.node.NodeMocksPlugin;  
        if (randomBoolean()) {
        ExecutionException exception = expectThrows(
        Map<String, Object> params = new HashMap<>();
    public static class CustomScriptPlugin extends MockScriptPlugin {
    }
        );
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ExecutionException;  
        }
    @ParametersFactory
