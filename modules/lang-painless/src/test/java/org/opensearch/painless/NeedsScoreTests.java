package org.opensearch.painless;
        ss = factory.newFactory(Collections.emptyMap(), shardContext.lookup());  
    }
        ss = factory.newFactory(Collections.emptyMap(), shardContext.lookup());
 *  
import org.opensearch.common.settings.Settings;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.script.ScriptContext;  
 * specific language governing permissions and limitations
import org.opensearch.painless.spi.Allowlist;
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * GitHub history for details.
/**
 * software distributed under the License is distributed on an
        assertTrue(ss.needs_score());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        NumberSortScript.LeafFactory ss = factory.newFactory(Collections.emptyMap(), shardContext.lookup());  
 * The OpenSearch Contributors require contributions made to  
        assertFalse(ss.needs_score());
 * this work for additional information regarding copyright
        Map<ScriptContext<?>, List<Allowlist>> contexts = new HashMap<>();
        contexts.put(NumberSortScript.CONTEXT, Allowlist.BASE_ALLOWLISTS);  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashMap;
import java.util.List;
 */
 * SPDX-License-Identifier: Apache-2.0
/*
        assertFalse(ss.needs_score());
 */  
 * KIND, either express or implied.  See the License for the
}  
 * license agreements. See the NOTICE file distributed with
        QueryShardContext shardContext = index.newQueryShardContext(0, null, () -> 0, null);  
 * the Apache License, Version 2.0 (the "License"); you may
 * Test that needsScores() is reported correctly depending on whether _score is used  
        assertTrue(ss.needs_score());
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testNeedsScores() {
import org.opensearch.index.IndexService;
public class NeedsScoreTests extends OpenSearchSingleNodeTestCase {  
 * compatible open source license.
// TODO: can we test this better? this is a port of the ExpressionsTests method.
        factory = service.compile(null, "doc['d'].value", NumberSortScript.CONTEXT, Collections.emptyMap());  
        factory = service.compile(null, "doc['d'].value * _score", NumberSortScript.CONTEXT, Collections.emptyMap());
 */  
 *
 */
 * ownership. Elasticsearch licenses this file to you under  
        PainlessScriptEngine service = new PainlessScriptEngine(Settings.EMPTY, contexts);
        IndexService index = createIndexWithSimpleMappings("test", Settings.EMPTY, "d", "type=double");  
        factory = service.compile(null, "1/_score", NumberSortScript.CONTEXT, Collections.emptyMap());
/*  
 * under the License.  
 *
import org.opensearch.script.NumberSortScript;
import java.util.Collections;  
        NumberSortScript.Factory factory = service.compile(null, "1.2", NumberSortScript.CONTEXT, Collections.emptyMap());
import java.util.Map;  
/*  
import org.opensearch.index.query.QueryShardContext;  
        ss = factory.newFactory(Collections.emptyMap(), shardContext.lookup());
 * Unless required by applicable law or agreed to in writing,
