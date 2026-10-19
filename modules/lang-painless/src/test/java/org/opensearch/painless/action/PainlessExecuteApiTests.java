        contextSetup = new Request.ContextSetup("index", new BytesArray("{\"field\": 2}"), null);
            new Script(ScriptType.INLINE, "painless", "doc['field'].value >= params.max", singletonMap("max", 3)),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new Script(
import org.opensearch.script.Script;  
        );
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(e.getCause().getMessage(), equalTo("cannot resolve symbol [doc]"));
    protected Collection<Class<? extends Plugin>> getPlugins() {
    public void testDefaults() throws IOException {
            "filter",
                "painless",
        ScriptService scriptService = getInstanceFromNode(ScriptService.class);  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
import java.util.Map;
            "filter",
import java.util.HashMap;  
 * Unless required by applicable law or agreed to in writing,
        Response response = innerShardOperation(request, scriptService, null);
        Map<String, Object> params = new HashMap<>();
        Exception e = expectThrows(ScriptException.class, () -> {  
        Request.ContextSetup contextSetup = new Request.ContextSetup("index", new BytesArray("{\"field\": 3}"), null);  
        Request request = new Request(new Script("100.0 / 1000.0"), null, null);
public class PainlessExecuteApiTests extends OpenSearchSingleNodeTestCase {
        contextSetup = new Request.ContextSetup("index", new BytesArray("{\"field\": 3}"), null);  
import static org.hamcrest.Matchers.equalTo;
 */
import org.opensearch.script.ScriptException;
            new BytesArray("{\"rank\": 4.0, \"text\": \"quick brown fox\"}"),  
        request = new Request(  
            );
import org.opensearch.index.IndexService;  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response.getResult(), equalTo("0.1"));  
        Request.ContextSetup contextSetup = new Request.ContextSetup(
import org.opensearch.common.settings.Settings;  
        );
package org.opensearch.painless.action;
    }  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import org.opensearch.script.ScriptType;  
        assertThat(response.getResult(), equalTo(true));
        return Collections.singleton(PainlessModulePlugin.class);
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
                ScriptType.INLINE,  
        contextSetup.setXContentType(MediaTypeRegistry.JSON);
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "field", "type=long");
    }
/*  
import org.opensearch.painless.action.PainlessExecuteAction.Request;  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
 */  
    public void testFilterExecutionContext() throws IOException {
        request = new Request(
 *  
 *
            Request r = new Request(
        response = innerShardOperation(request, scriptService, indexService);
            "index",
        ScriptService scriptService = getInstanceFromNode(ScriptService.class);
        params.put("total", 1000.0D);
 * Licensed to Elasticsearch under one or more contributor  
        });
                "Math.round((_score + (doc['rank'].value / params.max_rank)) * 100.0) / 100.0",
            contextSetup  
                null
        );  
        assertThat(response.getResult(), equalTo(false));  
        params.put("count", 100.0D);  
                singletonMap("max_rank", 5.0)  
        IndexService indexService = createIndexWithSimpleMappings("index", Settings.EMPTY, "rank", "type=long", "text", "type=text");
            new Script(ScriptType.INLINE, "painless", "doc['field'].value >= params.max", singletonMap("max", 3)),
    }
        ScriptService scriptService = getInstanceFromNode(ScriptService.class);  
            innerShardOperation(r, scriptService, null);  
}  
        contextSetup.setXContentType(MediaTypeRegistry.JSON);
import org.opensearch.core.common.bytes.BytesArray;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
        Response response = innerShardOperation(request, scriptService, indexService);
    }  
import static java.util.Collections.singletonMap;  
        Request request = new Request(
import java.util.Collections;
import org.opensearch.plugins.Plugin;
import java.util.Collection;
 */
        assertThat(response.getResult(), equalTo("0.1"));
import static org.opensearch.painless.action.PainlessExecuteAction.TransportAction.innerShardOperation;
            new MatchQueryBuilder("text", "fox")
        assertThat(response.getResult(), equalTo(0.93D));  
import org.opensearch.script.ScriptService;
        response = innerShardOperation(request, scriptService, null);  
        Response response = innerShardOperation(request, scriptService, indexService);  
                new Script(ScriptType.INLINE, "painless", "params.count / params.total + doc['constant']", params),
            contextSetup
        response = innerShardOperation(request, scriptService, indexService);
            contextSetup  
        contextSetup.setXContentType(MediaTypeRegistry.JSON);
import org.opensearch.index.query.MatchQueryBuilder;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        contextSetup.setXContentType(MediaTypeRegistry.JSON);  
            "score",
 * not use this file except in compliance with the License.
import org.opensearch.painless.PainlessModulePlugin;
            ),
import java.io.IOException;  
        Request request = new Request(new Script("doc['field'].value >= 3"), "filter", contextSetup);
/*
import org.opensearch.painless.action.PainlessExecuteAction.Response;
 * compatible open source license.
        );
        request = new Request(new Script(ScriptType.INLINE, "painless", "params.count / params.total", params), null, null);
    public void testScoreExecutionContext() throws IOException {  
        assertThat(response.getResult(), equalTo(true));
/*
 * Modifications Copyright OpenSearch Contributors. See  
                null,  
 * software distributed under the License is distributed on an
