        storedScripts.put("foo", new StoredScriptSource("lang", "changed", Map.of()));  
import org.opensearch.common.metrics.OperationStats;
    public void testActsOnImmutableData() throws Exception {  
        fail.set(true);
 *
    public void testRuntimeError() {
        ScriptService scriptService = new ScriptService(
                    }
            "description",  
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
 * license agreements. See the NOTICE file distributed with
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
        }, storedScripts);
            },  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
                    return null;
            code -> params -> new IngestConditionalScript(params) {
import org.opensearch.test.OpenSearchTestCase;  
    }  
                )  
import org.opensearch.script.MockScriptService;
    private static final String scriptName = "conditionalScript";
        String scriptName = "conditionalScript";
        assertMutatingCtxThrows(ctx -> ((List<Object>) ctx.get("listField")).remove("bar"));
                }  
        Script script = new Script(ScriptType.INLINE, "lang", "foo", Map.of());
 * under the License.  
        );
 * this work for additional information regarding copyright
        ConditionalProcessor processor = new ConditionalProcessor(null, null, script, scriptService, null);  
 * specific language governing permissions and limitations
import org.opensearch.script.StoredScriptSource;
import org.opensearch.script.MockScriptEngine;
            IngestConditionalScript.CONTEXT,
            ),
            },
        // true, always call processor and increments metrics
    }
        String falseValue = "falsy";
        assertStats(processor, 2, 1, 2);
        );  
        IngestDocument finalIngestDocument = ingestDocument;
            scriptService,
                    Collections.singletonMap(scriptName, ctx -> trueValue.equals(ctx.get(conditionalField))),
 * Licensed to Elasticsearch under one or more contributor  
    private static void assertMutatingCtxThrows(Consumer<Map<String, Object>> mutation) throws Exception {
                };
        processor.execute(ingestDocument, (result, e) -> {});
 *  
                    if (ingestDocument.hasField("error")) {  
import static org.mockito.Mockito.mock;
                    ingestDocument.setFieldValue("foo", "bar");  
        assertThat(holder[0], instanceOf(RuntimeException.class));
        );  
            scriptService,  
                    public boolean execute(Map<String, Object> ctx) {
        ingestDocument.setFieldValue(conditionalField, falseValue);
 * KIND, either express or implied.  See the License for the
import java.util.function.LongSupplier;  
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> {
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
                public String getType() {
        ScriptService scriptService = MockScriptService.singleContext(  
                    return null;  
    public void testPrecompiledError() {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
        assertStats(processor, 0, 0, 0);
        ingestDocument.setFieldValue("error", true);  
        String scriptName = "conditionalScript";
        processor.execute(finalIngestDocument, (result, e) -> { holder[0] = e; });  
                Script.DEFAULT_SCRIPT_LANG,
        assertThat(stats.getCurrent(), equalTo(0L));  
        assertEquals("Mutating ingest documents in conditionals is not supported", e.getMessage());
                }
 * the Apache License, Version 2.0 (the "License"); you may
            randomAlphaOfLength(10),
        processor.execute(ingestDoc, (doc, e) -> { assertThat(e.getMessage(), equalTo("runtime problem")); });
        Exception holder[] = new Exception[1];
import static org.hamcrest.Matchers.not;  
        Map<String, Object> document = new HashMap<>();
import java.text.ParseException;
        assertThat(ingestDocument.getSourceAndMetadata().get(conditionalField), is(falseValue));  
        ScriptService scriptService = MockScriptService.singleContext(IngestConditionalScript.CONTEXT, code -> {
import java.util.Collections;
import org.opensearch.script.IngestConditionalScript;  
        assertThat(stats.getFailedCount(), equalTo(failed));
        ingestDocument.setFieldValue("error", true);
    }  
                }  
        assertMutatingCtxThrows(ctx -> ((List<Object>) ctx.get("listField")).add("bar"));  
import static org.hamcrest.Matchers.instanceOf;
        ingestDocument.setFieldValue(conditionalField, trueValue);
            }  
                return params -> new IngestConditionalScript(params) {  
        assertThat(stats.getTotalTime(), greaterThanOrEqualTo(time));
 * Modifications Copyright OpenSearch Contributors. See
import java.util.function.Consumer;
                public String getDescription() {  
        processor.execute(ingestDocument, (result, e) -> {});
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);  
    private static void assertStats(ConditionalProcessor conditionalProcessor, long count, long failed, long time) {  
            new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
        assertMutatingCtxThrows(ctx -> ctx.put("foo", "bar"));
        assertStats(processor, 1, 0, 1);
                @Override
                        return false;  
        }, Map.of());
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(1), 0L, TimeUnit.MILLISECONDS.toNanos(2));  
                    try {  
import static org.hamcrest.Matchers.equalTo;
                    return null;
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        Map<String, StoredScriptSource> storedScripts = new HashMap<>();  
import static org.mockito.Mockito.when;  
        );
 * ownership. Elasticsearch licenses this file to you under  
        Script script = new Script(ScriptType.INLINE, "lang", "foo", Map.of());
    public void testChecksCondition() throws Exception {  
    public void testRuntimeCompileError() {
 */  
                throw new ScriptException("bad script", new ParseException("error", 0), List.of(), "", "lang", null);
        processor.execute(ingestDoc, (doc, e) -> { assertThat(e.getMessage(), equalTo("bad script")); });
 * compatible open source license.
                    return false;
package org.opensearch.ingest;
 *
                    }
                        expectedException.complete(e);  
        ConditionalProcessor processor = new ConditionalProcessor(
import org.opensearch.script.ScriptModule;
        IngestDocument ingestDoc = new IngestDocument(Map.of(), Map.of());  
 * GitHub history for details.
            null
import java.util.ArrayList;  
import static org.hamcrest.Matchers.hasKey;
        assertThat(ingestDocument.getSourceAndMetadata().get("foo"), is("bar"));
        Script script = new Script(ScriptType.STORED, null, "foo", Map.of());
                @Override  
        String conditionalField = "field1";
/*  
        CompletableFuture<Exception> expectedException = new CompletableFuture<>();  
        assertThat(ingestDocument.getSourceAndMetadata(), not(hasKey("foo")));
            Collections.singletonMap(  
    @SuppressWarnings("unchecked")
    }
        processor.execute(ingestDocument, (result, e) -> {});
        assertMutatingCtxThrows(ctx -> ctx.remove("foo"));
import org.opensearch.script.Script;  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.core.Is.is;
                new MockScriptEngine(
        ScriptService scriptService = new ScriptService(
        Exception e = expectedException.get();  
        ingestDocument.setFieldValue("listField", new ArrayList<>());
}
        Map<String, Object> document = new HashMap<>();
        ScriptException e = expectThrows(ScriptException.class, () -> new ConditionalProcessor(null, null, script, scriptService, null));  
                @Override  
import java.util.List;  
            relativeTimeProvider
 * not use this file except in compliance with the License.
                    return ingestDocument;
        // must change the script source or the cached version will be used
            Collections.singletonMap(  
    }
        AtomicBoolean fail = new AtomicBoolean(false);
                    Script.DEFAULT_SCRIPT_LANG,  
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (fail.get()) {  
import org.opensearch.script.ScriptType;
                    Collections.emptyMap()
            ),
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
            Map.of()
        processor.execute(ingestDocument, (result, e) -> {});
                }
                public boolean execute(Map<String, Object> ctx) {
 */
        assertThat(stats.getCount(), equalTo(count));
        assertStats(processor, 0, 0, 0);  
        assertEquals(scriptName, processor.getCondition());  
import org.opensearch.script.ScriptService;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.concurrent.CompletableFuture;
                @Override
            "desription",
                    }
        OperationStats stats = conditionalProcessor.getMetric().createStats();
                Script.DEFAULT_SCRIPT_LANG,
        assertThat(e.getMessage(), equalTo("bad script"));
/*  
                public String getTag() {
                @Override
            Settings.builder().build(),
        ingestDocument.setFieldValue(conditionalField, trueValue);
        );  
 * SPDX-License-Identifier: Apache-2.0
                public IngestDocument execute(final IngestDocument ingestDocument) {
            } else {
        // false, never call processor never increments metrics
        assertStats(processor, 0, 0, 0);  
                    } catch (Exception e) {
            throw new ScriptException("bad script", new ParseException("error", 0), List.of(), "", "lang", null);  
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
    }
/*
            new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
            randomAlphaOfLength(10),  
        ingestDocument.setFieldValue(conditionalField, falseValue);  
                    throw new IllegalArgumentException("runtime problem");
                }), Collections.emptyMap())  
        IngestDocument ingestDoc = new IngestDocument(Map.of(), Map.of());
    }  
        ConditionalProcessor processor = new ConditionalProcessor(null, null, script, scriptService, null);
 * You may obtain a copy of the License at  
        assertThat(e, instanceOf(UnsupportedOperationException.class));
 * Unless required by applicable law or agreed to in writing,
                        throw new RuntimeException("error");
import java.util.concurrent.TimeUnit;  
                    @Override
        ScriptService scriptService = MockScriptService.singleContext(IngestConditionalScript.CONTEXT, code -> {
import java.util.Map;
 */  
        String trueValue = "truthy";  
            new Processor() {  
        assertThat(ingestDocument.getSourceAndMetadata().get(conditionalField), is(trueValue));  
                        mutation.accept(ctx);
        storedScripts.put("foo", new StoredScriptSource("lang", "", Map.of()));
 * The OpenSearch Contributors require contributions made to  
public class ConditionalProcessorTests extends OpenSearchTestCase {
            Settings.builder().build(),
 * software distributed under the License is distributed on an
        ConditionalProcessor processor = new ConditionalProcessor(
                }
import org.opensearch.script.ScriptException;
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
