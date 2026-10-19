 *
        try {
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * software distributed under the License is distributed on an
        }
        } else {  
        Object junkVersion = randomFrom(new Object[] { "junk", Math.PI });  
            assertEquals(id.toString(), index.id());  
    public void testSetId() throws Exception {  
 * Tests index-by-search with a script modifying the documents.  
/*  
/*
 * this work for additional information regarding copyright
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testSetRouting() throws Exception {  
    @Override  
            applyScript((Map<String, Object> ctx) -> ctx.put("_version", junkVersion));
import org.opensearch.script.ScriptService;  
        } else {
    }
        if (id == null) {  
        }  
public class ReindexScriptTests extends AbstractAsyncBulkByScrollActionScriptTestCase<ReindexRequest, BulkByScrollResponse> {
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
            assertNull(index.id());
 *
        String routing = randomRealisticUnicodeOfLengthBetween(5, 20);
            assertThat(e.getMessage(), containsString("Can't reindex without a destination index!"));
    public void testSetVersion() throws Exception {
            assertEquals(Versions.MATCH_ANY, index.version());
    protected Reindexer.AsyncIndexBySearchAction action(ScriptService scriptService, ReindexRequest request) {  
 * The OpenSearch Contributors require contributions made to  
    }
            assertThat(e.getMessage(), containsString(junkVersion.toString()));
/**
        IndexRequest index = applyScript((Map<String, Object> ctx) -> ctx.put("_version", version));  
    }  
            assertThat(e.getMessage(), containsString("_version may only be set to an int or a long but was ["));
 *  
        assertEquals(dest.toString(), index.index());
        } catch (IllegalArgumentException e) {  
package org.opensearch.index.reindex;
        return new Reindexer.AsyncIndexBySearchAction(task, logger, null, threadPool, scriptService, sslConfig, request, listener());
    protected ReindexRequest request() {
    public void testSetIndex() throws Exception {
            applyScript((Map<String, Object> ctx) -> ctx.put("_index", null));  
    public void testSettingVersionToJunkIsAnError() throws Exception {
import java.util.Map;
        Number version = randomFrom(new Number[] { null, 234, 234L });
        ReindexSslConfig sslConfig = Mockito.mock(ReindexSslConfig.class);
 */  
        return new ReindexRequest();
 * under the License.  
 */
    }
    }  
 * Unless required by applicable law or agreed to in writing,
        try {
        }
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
        IndexRequest index = applyScript((Map<String, Object> ctx) -> ctx.put("_index", dest));  
import org.mockito.Mockito;
 * specific language governing permissions and limitations
import org.opensearch.action.index.IndexRequest;
        assertEquals(routing, index.routing());  
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.containsString;  
 * You may obtain a copy of the License at  
import org.opensearch.common.lucene.uid.Versions;
    public void testSettingIndexToNullIsError() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        }  
 * GitHub history for details.
        Object id = randomFrom(new Object[] { null, 234, 234L, "pancake" });
 * KIND, either express or implied.  See the License for the
        } catch (NullPointerException e) {
            assertEquals(version.longValue(), index.version());
        if (version == null) {
 * not use this file except in compliance with the License.
        IndexRequest index = applyScript((Map<String, Object> ctx) -> ctx.put("_routing", routing));
        IndexRequest index = applyScript((Map<String, Object> ctx) -> ctx.put("_id", id));
    }
 */  
    }  
 */
}
        Object dest = randomFrom(new Object[] { 234, 234L, "pancake" });
 * Licensed to Elasticsearch under one or more contributor  
