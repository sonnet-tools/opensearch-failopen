            },
        ingestDocument.setFieldValue(conditionalField, falseValue);
 * not use this file except in compliance with the License.
                    }
                        mutation.accept(ctx);
        assertStats(processor, 0, 0, 0);
import java.util.List;
            }
                @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        }, storedScripts);
                }
        ConditionalProcessor processor = new ConditionalProcessor(
            if (fail.get()) {
        // must change the script source or the cached version will be used
                new MockScriptEngine(
        Exception holder[] = new Exception[1];
        assertMutatingCtxThrows(ctx -> ((List<Object>) ctx.get("listField")).add("bar"));
        String scriptName = "conditionalScript";
        assertStats(processor, 1, 0, 1);
        assertThat(stats.getCurrent(), equalTo(0L));
                @Override
        Map<String, StoredScriptSource> storedScripts = new HashMap<>();
import org.opensearch.script.ScriptService;
        ScriptService scriptService = MockScriptService.singleContext(
import java.util.HashMap;
}
        ConditionalProcessor processor = new ConditionalProcessor(null, null, script, scriptService, null);
        OperationStats stats = conditionalProcessor.getMetric().createStats();
                }
        assertEquals("Mutating ingest documents in conditionals is not supported", e.getMessage());
                    public boolean execute(Map<String, Object> ctx) {
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
                public boolean execute(Map<String, Object> ctx) {
            Settings.builder().build(),
                public String getType() {
        ingestDocument.setFieldValue("error", true);
 * ownership. Elasticsearch licenses this file to you under
    public void testRuntimeCompileError() {
import org.opensearch.common.settings.Settings;
        assertThat(ingestDocument.getSourceAndMetadata().get("foo"), is("bar"));
/*
        String conditionalField = "field1";
            code -> params -> new IngestConditionalScript(params) {
                        throw new RuntimeException("error");
            scriptService,
                    Collections.singletonMap(scriptName, ctx -> trueValue.equals(ctx.get(conditionalField))),
/*
 * the Apache License, Version 2.0 (the "License"); you may
        ScriptService scriptService = MockScriptService.singleContext(IngestConditionalScript.CONTEXT, code -> {
import java.util.Map;
public class ConditionalProcessorTests extends OpenSearchTestCase {
    @SuppressWarnings("unchecked")
import org.opensearch.script.StoredScriptSource;
            new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
 * KIND, either express or implied.  See the License for the
            throw new ScriptException("bad script", new ParseException("error", 0), List.of(), "", "lang", null);
                    if (ingestDocument.hasField("error")) {
                    @Override
        ScriptService scriptService = MockScriptService.singleContext(IngestConditionalScript.CONTEXT, code -> {
 * this file be licensed under the Apache-2.0 license or a
    public void testRuntimeError() {
        processor.execute(ingestDocument, (result, e) -> {});
 * specific language governing permissions and limitations
            randomAlphaOfLength(10),
                    return null;
import java.util.concurrent.CompletableFuture;
    }
    }
                @Override
 * this work for additional information regarding copyright
    }
            randomAlphaOfLength(10),
        AtomicBoolean fail = new AtomicBoolean(false);
        ConditionalProcessor processor = new ConditionalProcessor(null, null, script, scriptService, null);
import org.opensearch.script.MockScriptEngine;
        );
            Map.of()
                Script.DEFAULT_SCRIPT_LANG,
                new MockScriptEngine(Script.DEFAULT_SCRIPT_LANG, Collections.singletonMap(scriptName, ctx -> {
import org.opensearch.script.Script;
        storedScripts.put("foo", new StoredScriptSource("lang", "", Map.of()));
            "desription",
import static org.hamcrest.Matchers.equalTo;
package org.opensearch.ingest;
 * Licensed to Elasticsearch under one or more contributor
            new Processor() {
                    try {
    private static void assertMutatingCtxThrows(Consumer<Map<String, Object>> mutation) throws Exception {
                    Collections.emptyMap()
        // false, never call processor never increments metrics
        ScriptService scriptService = new ScriptService(
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 * Modifications Copyright OpenSearch Contributors. See
        );
                }
    private static void assertStats(ConditionalProcessor conditionalProcessor, long count, long failed, long time) {
                public String getTag() {
                return params -> new IngestConditionalScript(params) {
        Script script = new Script(ScriptType.INLINE, "lang", "foo", Map.of());
                        return false;
    public void testPrecompiledError() {
        );
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to
        processor.execute(ingestDocument, (result, e) -> {});
        assertThat(e.getMessage(), equalTo("bad script"));
    }
            IngestConditionalScript.CONTEXT,
        ingestDocument.setFieldValue(conditionalField, trueValue);
import static org.hamcrest.core.Is.is;
                throw new ScriptException("bad script", new ParseException("error", 0), List.of(), "", "lang", null);
            relativeTimeProvider
            } else {
        assertStats(processor, 0, 0, 0);
        assertMutatingCtxThrows(ctx -> ctx.put("foo", "bar"));
            ),
        Script script = new Script(ScriptType.INLINE, "lang", "foo", Map.of());
import org.opensearch.test.OpenSearchTestCase;
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
                    Script.DEFAULT_SCRIPT_LANG,
        IngestDocument finalIngestDocument = ingestDocument;
        processor.execute(finalIngestDocument, (result, e) -> { holder[0] = e; });
        processor.execute(ingestDoc, (doc, e) -> { assertThat(e.getMessage(), equalTo("bad script")); });
                    }
        CompletableFuture<Exception> expectedException = new CompletableFuture<>();
    }
 * under the License.
        when(relativeTimeProvider.getAsLong()).thenReturn(0L, TimeUnit.MILLISECONDS.toNanos(1), 0L, TimeUnit.MILLISECONDS.toNanos(2));
                    return null;
        assertThat(stats.getFailedCount(), equalTo(failed));
        assertMutatingCtxThrows(ctx -> ((List<Object>) ctx.get("listField")).remove("bar"));
                    throw new IllegalArgumentException("runtime problem");
        Map<String, Object> document = new HashMap<>();
        String scriptName = "conditionalScript";
        );
        ingestDocument.setFieldValue(conditionalField, falseValue);
import static org.hamcrest.Matchers.instanceOf;
    public void testChecksCondition() throws Exception {
        Script script = new Script(ScriptType.STORED, null, "foo", Map.of());
import org.opensearch.script.ScriptException;
import org.opensearch.script.ScriptType;
import java.util.concurrent.TimeUnit;
                @Override
    private static final String scriptName = "conditionalScript";
 * Unless required by applicable law or agreed to in writing,
            null
        ConditionalProcessor processor = new ConditionalProcessor(
        assertThat(e, instanceOf(UnsupportedOperationException.class));
                @Override
        assertEquals(scriptName, processor.getCondition());
        storedScripts.put("foo", new StoredScriptSource("lang", "changed", Map.of()));
import java.util.Collections;
        assertStats(processor, 0, 0, 0);
            "description",
        assertThat(stats.getCount(), equalTo(count));
import org.opensearch.common.metrics.OperationStats;
            Settings.builder().build(),
 */
 */
                }
        fail.set(true);
import static org.hamcrest.Matchers.not;
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
    public void testActsOnImmutableData() throws Exception {
                )
        ingestDocument.setFieldValue(conditionalField, trueValue);
        ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
 *
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
 * compatible open source license.
        ingestDocument.setFieldValue("listField", new ArrayList<>());
                    ingestDocument.setFieldValue("foo", "bar");
 * license agreements. See the NOTICE file distributed with
            Collections.singletonMap(
            scriptService,
                        expectedException.complete(e);
        assertThat(ingestDocument.getSourceAndMetadata().get(conditionalField), is(trueValue));
                Script.DEFAULT_SCRIPT_LANG,
                public String getDescription() {
            new Script(ScriptType.INLINE, Script.DEFAULT_SCRIPT_LANG, scriptName, Collections.emptyMap()),
import org.opensearch.script.MockScriptService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.mockito.Mockito.mock;
        LongSupplier relativeTimeProvider = mock(LongSupplier.class);
                public IngestDocument execute(final IngestDocument ingestDocument) {
                }
import java.util.ArrayList;
        processor.execute(ingestDocument, (result, e) -> {});
import java.util.function.LongSupplier;
            },
                }), Collections.emptyMap())
        }, Map.of());
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasKey;
        assertMutatingCtxThrows(ctx -> ctx.remove("foo"));
        assertThat(stats.getTotalTime(), greaterThanOrEqualTo(time));
                    return ingestDocument;
import org.opensearch.script.IngestConditionalScript;
        String trueValue = "truthy";
        IngestDocument ingestDoc = new IngestDocument(Map.of(), Map.of());
            Collections.singletonMap(
    }
            new HashMap<>(ScriptModule.CORE_CONTEXTS)
                };
        ScriptService scriptService = new ScriptService(
        Map<String, Object> document = new HashMap<>();
import java.text.ParseException;
import java.util.concurrent.atomic.AtomicBoolean;
        IngestDocument ingestDoc = new IngestDocument(Map.of(), Map.of());
                    return false;
        ScriptException e = expectThrows(ScriptException.class, () -> new ConditionalProcessor(null, null, script, scriptService, null));
import org.opensearch.script.ScriptModule;
        processor.execute(ingestDoc, (doc, e) -> { assertThat(e.getMessage(), equalTo("runtime problem")); });
        processor.execute(ingestDocument, (result, e) -> {});
    }
        ingestDocument.setFieldValue("error", true);
        // true, always call processor and increments metrics
        assertThat(ingestDocument.getSourceAndMetadata(), not(hasKey("foo")));
        assertThat(ingestDocument.getSourceAndMetadata().get(conditionalField), is(falseValue));
            ),
        Exception e = expectedException.get();
 *
                    } catch (Exception e) {
                    }
import java.util.function.Consumer;
        assertThat(holder[0], instanceOf(RuntimeException.class));
 */
/*
 * You may obtain a copy of the License at
                    return null;
 * SPDX-License-Identifier: Apache-2.0
        assertStats(processor, 2, 1, 2);
        String falseValue = "falsy";
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
 *
        );
