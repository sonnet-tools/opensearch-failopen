        ScriptedMetricAggContexts.ReduceScript script = factory.newInstance(params, states);
            ScriptedMetricAggContexts.CombineScript.CONTEXT,
        ScriptedMetricAggContexts.InitScript script = factory.newInstance(params, state);  
 */
import org.opensearch.script.ScriptedMetricAggContexts;
        Object res = script.execute();  
package org.opensearch.painless;
            Collections.emptyMap()  
        ScriptedMetricAggContexts.MapScript.Factory factory = getEngine().compile(
        Map<String, Object> params = new HashMap<>();
import org.apache.lucene.index.LeafReaderContext;
        SourceLookup sourceLookup = mock(SourceLookup.class);  
    }
    @Override  
        script.execute();  
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafLookup);
    protected PainlessScriptEngine getEngine() {
        script.setScorer(scorer);
 *
 *
        state2.put("testField", 2);
        Map<String, Object> state1 = new HashMap<>(), state2 = new HashMap<>();  
        SourceLookup sourceLookup = mock(SourceLookup.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
        Map<ScriptContext<?>, List<Allowlist>> contexts = new HashMap<>();
    }
        Map<String, Object> state = new HashMap<>();
 * specific language governing permissions and limitations
import java.util.List;  
        script.execute();
        );  
import org.apache.lucene.search.Scorable;  
 * ownership. Elasticsearch licenses this file to you under  
        assertTrue(state.containsKey("testField"));
        Map<String, Object> state = new HashMap<>();  
import org.opensearch.common.settings.Settings;
    }
import org.junit.BeforeClass;  
            "state.testField = params.initialVal; return state.testField + params.inc",  
        SearchLookup lookup = mock(SearchLookup.class);  
        assert (state.containsKey("testField"));
        assertEquals(1.0, state.get("testField"));
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
import java.util.HashMap;
    }
 *  
/*
 */  
 * under the License.  
        ScriptedMetricAggContexts.MapScript.LeafFactory leafFactory = factory.newFactory(params, state, lookup);
            ScriptedMetricAggContexts.MapScript.CONTEXT,  
        states.add(state2);
            Collections.emptyMap()
        // we don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
        assertEquals(12, res);
            ScriptedMetricAggContexts.InitScript.CONTEXT,  
        when(sourceLookup.loadSourceIfNeeded()).thenReturn(Collections.singletonMap("test", 1));
import java.util.Map;
        SearchLookup lookup = mock(SearchLookup.class);
    public void testReturnSource() throws IOException {
 * not use this file except in compliance with the License.
        ScriptedMetricAggContexts.CombineScript.Factory factory = getEngine().compile(
public class ScriptedMetricAggContextsTests extends ScriptTestCase {  
        ScriptedMetricAggContexts.MapScript script = leafFactory.newInstance(leafReaderContext);
        contexts.put(ScriptedMetricAggContexts.InitScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
        params.put("inc", 2);  
        when(leafLookup.asMap()).thenReturn(Collections.singletonMap("_source", sourceLookup));
 *    http://www.apache.org/licenses/LICENSE-2.0
        ScriptedMetricAggContexts.MapScript script = leafFactory.newInstance(null);
    }
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafLookup);
        ScriptedMetricAggContexts.MapScript.LeafFactory leafFactory = factory.newFactory(params, state, lookup);  
        assertEquals(10, state.get("testField"));
            "test",
            Collections.emptyMap()  
        // we don't need a real index, just need to construct a LeafReaderContext which cannot be mocked  
        Map<String, Object> params = new HashMap<>();
    public void testCombineBasic() {  
    public void testMapBasic() throws IOException {
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);  
        );  
        assertEquals(3, res);  
import org.opensearch.script.ScriptContext;  
        Map<String, Object> params = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
            ScriptedMetricAggContexts.MapScript.CONTEXT,
import org.opensearch.painless.spi.Allowlist;
            "test",
        List<Object> states = new ArrayList<>();
import org.junit.AfterClass;
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
        assertTrue(state.get("_source") instanceof Map && ((Map) state.get("_source")).containsKey("test"));
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;  
 * You may obtain a copy of the License at  
    public void testMapSourceAccess() throws IOException {  
        assertEquals(3, state.get("testField"));  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public static void beforeClass() {
        );
    @AfterClass
 * Modifications Copyright OpenSearch Contributors. See
    }
        SCRIPT_ENGINE = null;  
            ScriptedMetricAggContexts.MapScript.CONTEXT,
import org.opensearch.search.lookup.LeafSearchLookup;
    }  
        ScriptedMetricAggContexts.InitScript.Factory factory = getEngine().compile(  
 * Unless required by applicable law or agreed to in writing,
        );
        contexts.put(ScriptedMetricAggContexts.MapScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        params.put("initialVal", 10);
 * The OpenSearch Contributors require contributions made to  
        contexts.put(ScriptedMetricAggContexts.CombineScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        states.add(state1);
        Object res = script.execute();
import org.opensearch.search.lookup.SearchLookup;  
        assertEquals(10, state.get("testField"));  
            Collections.emptyMap()
/*  
        Map<String, Object> params = new HashMap<>();
        Scorable scorer = new Scorable() {  
import static org.mockito.Mockito.mock;  
        Map<String, Object> params = new HashMap<>();  
        state1.put("testField", 1);
        MemoryIndex index = new MemoryIndex();
        Map<String, Object> state = new HashMap<>();
import java.io.IOException;
 * compatible open source license.
import static org.mockito.Mockito.when;
        when(sourceLookup.loadSourceIfNeeded()).thenReturn(Collections.singletonMap("three", 3));
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);  
        Map<String, Object> params = new HashMap<>();  
            "states[0].testField + states[1].testField",
        Map<String, Object> state = new HashMap<>();
        contexts.put(ScriptedMetricAggContexts.ReduceScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
    @BeforeClass  
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
            ScriptedMetricAggContexts.ReduceScript.CONTEXT,
        when(leafLookup.asMap()).thenReturn(Collections.singletonMap("_source", sourceLookup));  
            "test",
        );
    public static void afterClass() {
import org.apache.lucene.index.memory.MemoryIndex;
        script.execute();
            "test",
}
    public void testReduceBasic() {
        assert (state.containsKey("testField"));  
        ScriptedMetricAggContexts.MapScript.Factory factory = getEngine().compile(
        ScriptedMetricAggContexts.CombineScript script = factory.newInstance(params, state);
 * Licensed to Elasticsearch under one or more contributor  
            @Override
            "state.testField = 2*_score",
 */  
            "state.testField = params.initialVal",
        ScriptedMetricAggContexts.MapScript.Factory factory = getEngine().compile(  
        ScriptedMetricAggContexts.ReduceScript.Factory factory = getEngine().compile(
        script.execute();
            public float score() {
        assertTrue(state.containsKey("_source"));
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
        };
        assert (state.containsKey("testField"));
    private static PainlessScriptEngine SCRIPT_ENGINE;
            "state.testField = params._source.three",  
            Collections.emptyMap()
        ScriptedMetricAggContexts.MapScript.LeafFactory leafFactory = factory.newFactory(params, state, null);
                return 0.5f;  
/*  
            Collections.emptyMap()
    }  
import org.opensearch.search.lookup.SourceLookup;
        );
            "test",  
        Map<String, Object> state = new HashMap<>();  
    public void testInitBasic() {
            "test",  
 * software distributed under the License is distributed on an
        return SCRIPT_ENGINE;
        MemoryIndex index = new MemoryIndex();
 * GitHub history for details.
            "state._source = params._source",
        params.put("initialVal", 10);
        ScriptedMetricAggContexts.MapScript script = leafFactory.newInstance(leafReaderContext);  
        assertEquals(1, ((Map) state.get("_source")).get("test"));  
