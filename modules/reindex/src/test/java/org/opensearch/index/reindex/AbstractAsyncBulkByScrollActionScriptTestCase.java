    }
        try {
 * license agreements. See the NOTICE file distributed with
    @Before  
        when(scriptService.compile(any(), eq(UpdateScript.CONTEXT))).thenReturn(factory);  
        assertThat(e.getMessage(), equalTo("Operation type [unknown] not allowed, only [noop, index, delete] are allowed"));
import org.opensearch.action.delete.DeleteRequest;
    public void testChangeSource() {  
 * compatible open source license.
import org.opensearch.index.reindex.AbstractAsyncBulkByScrollAction.RequestWrapper;
import org.opensearch.index.reindex.AbstractAsyncBulkByScrollAction.OpType;
            public void execute() {
            assertThat(e.getMessage(), equalTo("Invalid fields added to context [junk]"));
 * specific language governing permissions and limitations
    }  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.equalTo;  
 * ownership. Elasticsearch licenses this file to you under  
        scriptService = mock(ScriptService.class);
    protected abstract AbstractAsyncBulkByScrollAction<Request, ?> action(ScriptService scriptService, Request request);
 * SPDX-License-Identifier: Apache-2.0
        };
            @Override
    Response extends BulkByScrollResponse> extends AbstractAsyncBulkByScrollActionTestCase<Request, Response> {
import static org.mockito.Mockito.mock;  
    @SuppressWarnings("unchecked")
        assertEquals("cat", index.sourceAsMap().get("bar"));  
        UpdateScript.Factory factory = (params, ctx) -> new UpdateScript(Collections.emptyMap(), ctx) {  
import java.util.Collections;
    }
 * You may obtain a copy of the License at  
        DeleteRequest delete = applyScript((Map<String, Object> ctx) -> ctx.put("op", OpType.DELETE.toString()));
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
import static java.util.Collections.singletonMap;
import static org.mockito.Mockito.when;
 * Unless required by applicable law or agreed to in writing,
                scriptBody.accept(getCtx());  
            applyScript((Map<String, Object> ctx) -> ctx.put("junk", "junk"));
        ScrollableHitSource.Hit doc = new ScrollableHitSource.BasicHit("test", "id", 0);
        return (result != null) ? (T) result.self() : null;  
        IndexRequest index = new IndexRequest("index").id("1").source(singletonMap("foo", "bar"));
        AbstractAsyncBulkByScrollAction<Request, ?> action = action(scriptService, request().setScript(mockScript("")));
    public void testScriptAddingJunkToCtxIsError() {  
            () -> applyScript((Map<String, Object> ctx) -> ctx.put("op", "unknown"))  
    }
        IndexRequest index = applyScript((Map<String, Object> ctx) -> {
    public void testSetOpTypeUnknown() throws Exception {  
        );
    protected ScriptService scriptService;
public abstract class AbstractAsyncBulkByScrollActionScriptTestCase<  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import static org.mockito.Mockito.eq;
 */  
 *
import org.junit.Before;
}  
    Request extends AbstractBulkIndexByScrollRequest<Request>,
import java.util.function.Consumer;  
import org.opensearch.action.index.IndexRequest;  
    protected <T extends ActionRequest> T applyScript(Consumer<Map<String, Object>> scriptBody) {  
        }  
        RequestWrapper<?> result = action.buildScriptApplier().apply(AbstractAsyncBulkByScrollAction.wrap(index), doc);
/*  
        IllegalArgumentException e = expectThrows(
/*  
 * this file be licensed under the Apache-2.0 license or a
        });
            Map<String, Object> source = (Map<String, Object>) ctx.get("_source");  
/*
 */  
            source.put("bar", "cat");
import java.util.Map;
            IllegalArgumentException.class,
 * The OpenSearch Contributors require contributions made to  
            }
 * GitHub history for details.
package org.opensearch.index.reindex;
            fail("Expected error");  
import org.opensearch.action.ActionRequest;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.script.UpdateScript;
import static org.mockito.Mockito.any;
 * this work for additional information regarding copyright
import org.opensearch.script.ScriptService;  
    public void setupScriptService() {
 * software distributed under the License is distributed on an
        } catch (IllegalArgumentException e) {
        assertThat(delete.index(), equalTo("index"));
    }  
            @SuppressWarnings("unchecked")
 *  
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    public void testSetOpTypeDelete() throws Exception {  
        assertThat(delete.id(), equalTo("1"));  
    }
 */
