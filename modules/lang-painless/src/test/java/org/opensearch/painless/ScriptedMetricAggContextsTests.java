        Map<String, Object> state = new HashMap<>();
        );
 */
 * under the License.
 */
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Map<String, Object> params = new HashMap<>();
package org.opensearch.painless;
        ScriptedMetricAggContexts.CombineScript.Factory factory = getEngine().compile(
        };
 * specific language governing permissions and limitations
        script.execute();
    public static void afterClass() {
}
import org.junit.AfterClass;
        params.put("initialVal", 10);
            "state.testField = 2*_score",
    public void testMapSourceAccess() throws IOException {
    }
        states.add(state2);
    @AfterClass
 * You may obtain a copy of the License at
    }
 * ownership. Elasticsearch licenses this file to you under
            "test",
 * The OpenSearch Contributors require contributions made to
                return 0.5f;
import java.util.Map;
            "test",
import org.opensearch.search.lookup.SourceLookup;
        assertEquals(1.0, state.get("testField"));
        Map<String, Object> state = new HashMap<>();
    }
            "state.testField = params._source.three",
        Map<String, Object> params = new HashMap<>();
            Collections.emptyMap()
        state1.put("testField", 1);
        ScriptedMetricAggContexts.ReduceScript.Factory factory = getEngine().compile(
            "state.testField = params.initialVal; return state.testField + params.inc",
 * SPDX-License-Identifier: Apache-2.0
    }
        assertEquals(3, state.get("testField"));
 * software distributed under the License is distributed on an
            Collections.emptyMap()
            ScriptedMetricAggContexts.MapScript.CONTEXT,
        ScriptedMetricAggContexts.MapScript.LeafFactory leafFactory = factory.newFactory(params, state, lookup);
        script.execute();
            @Override
        script.setScorer(scorer);
    }
public class ScriptedMetricAggContextsTests extends ScriptTestCase {
    @BeforeClass
        assertEquals(10, state.get("testField"));
/*
        assertTrue(state.containsKey("_source"));
        assertTrue(state.containsKey("testField"));
            "state._source = params._source",
        SourceLookup sourceLookup = mock(SourceLookup.class);
        ScriptedMetricAggContexts.MapScript script = leafFactory.newInstance(null);
import java.io.IOException;
 *
        // we don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
 * KIND, either express or implied.  See the License for the
        when(leafLookup.asMap()).thenReturn(Collections.singletonMap("_source", sourceLookup));
        Object res = script.execute();
import org.opensearch.search.lookup.SearchLookup;
            "test",
        when(sourceLookup.loadSourceIfNeeded()).thenReturn(Collections.singletonMap("three", 3));
import java.util.List;
        assertEquals(10, state.get("testField"));
 * this file be licensed under the Apache-2.0 license or a
        SourceLookup sourceLookup = mock(SourceLookup.class);
        contexts.put(ScriptedMetricAggContexts.MapScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
import org.apache.lucene.index.LeafReaderContext;
        state2.put("testField", 2);
import org.opensearch.common.settings.Settings;
        assert (state.containsKey("testField"));
            Collections.emptyMap()
 * Unless required by applicable law or agreed to in writing,
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
        assertTrue(state.get("_source") instanceof Map && ((Map) state.get("_source")).containsKey("test"));
        Map<String, Object> state1 = new HashMap<>(), state2 = new HashMap<>();
import java.util.Collections;
        assert (state.containsKey("testField"));
        ScriptedMetricAggContexts.MapScript.LeafFactory leafFactory = factory.newFactory(params, state, null);
            ScriptedMetricAggContexts.InitScript.CONTEXT,
        LeafReaderContext leafReaderContext = index.createSearcher().getIndexReader().leaves().get(0);
    }
    public static void beforeClass() {
 * GitHub history for details.
        Map<String, Object> state = new HashMap<>();
        ScriptedMetricAggContexts.ReduceScript script = factory.newInstance(params, states);
        params.put("inc", 2);
        List<Object> states = new ArrayList<>();
    public void testReturnSource() throws IOException {
        SCRIPT_ENGINE = null;
        MemoryIndex index = new MemoryIndex();
        assertEquals(1, ((Map) state.get("_source")).get("test"));
/*
        );
import org.opensearch.script.ScriptedMetricAggContexts;
    public void testInitBasic() {
    }
        );
            "test",
        script.execute();
        );
        Map<String, Object> params = new HashMap<>();
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
        Map<String, Object> params = new HashMap<>();
            ScriptedMetricAggContexts.ReduceScript.CONTEXT,
 * the Apache License, Version 2.0 (the "License"); you may
    public void testMapBasic() throws IOException {
            }
        // we don't need a real index, just need to construct a LeafReaderContext which cannot be mocked
import org.opensearch.painless.spi.Allowlist;
 * compatible open source license.
        ScriptedMetricAggContexts.MapScript.Factory factory = getEngine().compile(
            "test",
        assert (state.containsKey("testField"));
            "state.testField = params.initialVal",
 *
 */
        ScriptedMetricAggContexts.MapScript.Factory factory = getEngine().compile(
 *
        Map<String, Object> params = new HashMap<>();
        when(leafLookup.asMap()).thenReturn(Collections.singletonMap("_source", sourceLookup));
        script.execute();
            public float score() {
            Collections.emptyMap()
        return SCRIPT_ENGINE;
        Map<String, Object> params = new HashMap<>();
        ScriptedMetricAggContexts.InitScript.Factory factory = getEngine().compile(
        contexts.put(ScriptedMetricAggContexts.ReduceScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        SearchLookup lookup = mock(SearchLookup.class);
    }
        ScriptedMetricAggContexts.InitScript script = factory.newInstance(params, state);
 * Modifications Copyright OpenSearch Contributors. See
        Object res = script.execute();
        Map<String, Object> state = new HashMap<>();
        contexts.put(ScriptedMetricAggContexts.InitScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
            Collections.emptyMap()
import org.junit.BeforeClass;
            ScriptedMetricAggContexts.CombineScript.CONTEXT,
            ScriptedMetricAggContexts.MapScript.CONTEXT,
        assertEquals(12, res);
            "states[0].testField + states[1].testField",
    }
        ScriptedMetricAggContexts.MapScript script = leafFactory.newInstance(leafReaderContext);
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafLookup);
 * Licensed to Elasticsearch under one or more contributor
    public void testReduceBasic() {
import java.util.ArrayList;
    public void testCombineBasic() {
        Map<String, Object> state = new HashMap<>();
    @Override
 * not use this file except in compliance with the License.
    protected PainlessScriptEngine getEngine() {
    private static PainlessScriptEngine SCRIPT_ENGINE;
        states.add(state1);
        );
        Map<ScriptContext<?>, List<Allowlist>> contexts = new HashMap<>();
import org.opensearch.script.ScriptContext;
import static org.mockito.Mockito.mock;
        ScriptedMetricAggContexts.MapScript.Factory factory = getEngine().compile(
            Collections.emptyMap()
            "test",
        LeafSearchLookup leafLookup = mock(LeafSearchLookup.class);
        assertEquals(3, res);
 *    http://www.apache.org/licenses/LICENSE-2.0
        when(lookup.getLeafSearchLookup(leafReaderContext)).thenReturn(leafLookup);
        when(sourceLookup.loadSourceIfNeeded()).thenReturn(Collections.singletonMap("test", 1));
        MemoryIndex index = new MemoryIndex();
import static org.mockito.Mockito.when;
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
        params.put("initialVal", 10);
        );
        ScriptedMetricAggContexts.CombineScript script = factory.newInstance(params, state);
import org.apache.lucene.search.Scorable;
        contexts.put(ScriptedMetricAggContexts.CombineScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);
        Scorable scorer = new Scorable() {
        ScriptedMetricAggContexts.MapScript.LeafFactory leafFactory = factory.newFactory(params, state, lookup);
import org.opensearch.search.lookup.LeafSearchLookup;
            ScriptedMetricAggContexts.MapScript.CONTEXT,
import org.apache.lucene.index.memory.MemoryIndex;
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        ScriptedMetricAggContexts.MapScript script = leafFactory.newInstance(leafReaderContext);
import java.util.HashMap;
        SearchLookup lookup = mock(SearchLookup.class);
