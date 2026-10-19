        values.add("please");
    public void testModifyFieldsOutsideArray() throws Exception {
        assertThat(ingestDocument.getFieldValue("values.1.index", String.class), equalTo("_index"));
            public String getType() {
        Exception[] exceptions = new Exception[1];
import org.opensearch.script.TemplateScript;
            Map<String, Object> object = new HashMap<>();
        ForEachProcessor forEachProcessor = new ForEachProcessor("_tag", null, "values", processor, false);
                id.setFieldValue("_ingest._value", value.toUpperCase(Locale.ROOT));
                return null;
        processor.execute(ingestDocument, (result, e) -> {});
            new SetProcessor(
            false
        assertThat(ingestDocument.getFieldValue("values.0.new_field", String.class), equalTo("value"));
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "values", new AsyncUpperCaseProcessor("_ingest._value"), false);
            if ("c".equals(id.getFieldValue("_ingest._value", String.class))) {
        Map<String, Object> document = new HashMap<>();
        values.add("bar");
        List<String> values = new ArrayList<>();
            List<String> result = ingestDocument.getFieldValue("values", List.class);
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
            doc -> doc.setFieldValue("_ingest._value", doc.getFieldValue("_ingest._value", String.class).toUpperCase(Locale.ENGLISH))
                List.of(new UppercaseProcessor("_tag_upper", null, "_ingest._value", false, "_ingest._value")),
                null,
    public void testIgnoreMissing() throws Exception {
        values.add("me");
        assertThat(result.get(1), equalTo("new_value"));
    public void testRestOfTheDocumentIsAvailable() throws Exception {
                return null;
 * license agreements. See the NOTICE file distributed with
        List<?> errors = ingestDocument.getFieldValue("errors", List.class);
        assertThat(ingestDocument, equalTo(originalIngestDocument));
 * The OpenSearch Contributors require contributions made to
        List<Map<String, Object>> values = new ArrayList<>();
import java.util.function.BiConsumer;
        List<Map<String, Object>> values = new ArrayList<>();
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values", values));
        assertThat(ingestDocument.getFieldValue("values.2.new_field", String.class), equalTo("value"));
            }
        assertThat(testProcessor.getInvokedCounter(), equalTo(3));
        assertThat(result.get(2), equalTo(null));
 * software distributed under the License is distributed on an
            null,
        });
        );
        assertThat(innerProcessor.getInvokedCounter(), equalTo(2));
        value = new HashMap<>();
        IngestDocument originalIngestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.emptyMap());
    }
        Map<String, Object> source = Collections.singletonMap("field", Arrays.asList("a", "b"));
            null,
                }
    }
        assertThat(errors.size(), equalTo(2));
        source.put("values", values);
        @Override
            "values",
            values.add(object);
            false
        document.put("other", "value");
            "_tag",
        private final String field;
        values.add(value);
        };
        processor.execute(ingestDocument, (result, e) -> { exceptions[0] = e; });
import java.util.List;
        List<?> result = ingestDocument.getFieldValue("values", List.class);
            "_tag",
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values1", values));
import java.util.Locale;
        }
        public void execute(IngestDocument document, BiConsumer<IngestDocument, Exception> handler) {
import java.util.Map;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.ingest.TestProcessor;
        assertThat(ingestDocument.getFieldValue("values.0.index", String.class), equalTo("_index"));
        public String getType() {
        Processor innerProcessor = new Processor() {
        IngestDocument originalIngestDocument = new IngestDocument("_index", "_id", null, null, null, source);
        assertThat(ingestDocument.getFieldValue("values.1.new_field", String.class), equalTo("value"));
        List<Object> values = new ArrayList<>();
            null,
                "_tag",
        values.add(new HashMap<>());
        List<?> result = ingestDocument.getFieldValue("values", List.class);
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
    public void testMetadataAvailable() throws Exception {
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "field", testProcessor, true);
            }).start();
        TestProcessor testProcessor = new TestProcessor(doc -> {});
 * Unless required by applicable law or agreed to in writing,
                return null;
        });
 * GitHub history for details.
        List<?> result2 = ingestDocument.getFieldValue("values1.1.values2", List.class);
                (model) -> model.get("other")
                    String value = document.getFieldValue(field, String.class, false);
        ForEachProcessor processor = new ForEachProcessor(
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "_ingest._value", testProcessor, true);
    public void testAppendingToTheSameField() {
        processor.execute(ingestDocument, (result, e) -> {});
 * under the License.
            @SuppressWarnings("unchecked")
            public IngestDocument execute(IngestDocument ingestDocument) {
        innerValues = new ArrayList<>();
        TemplateScript.Factory template = new TestTemplateService.MockTemplateScript.Factory("errors");
            ),
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "values", testProcessor, false);
        for (int i = 0; i < 5; i++) {
        });
        processor.execute(ingestDocument, (result, e) -> {});
import org.opensearch.ingest.Processor;
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "field", testProcessor, true);
 *
        }
 * KIND, either express or implied.  See the License for the
 *
                    handler.accept(null, e);
 * Licensed to Elasticsearch under one or more contributor
        assertThat(testProcessor.getInvokedCounter(), equalTo(2));
        assertThat(result.get(1), equalTo("DEF"));
        values.add(value);
        public String getTag() {
        document.put("flat_values", new ArrayList<>());
package org.opensearch.ingest.common;
        );
                new TestTemplateService.MockTemplateScript.Factory("_ingest._value.new_field"),
        innerValues.add("ghi");
/*
import java.util.Collections;
        testProcessor = new TestProcessor(id -> {
import java.util.stream.IntStream;
        @SuppressWarnings("unchecked")
                List.of(new AppendProcessor("_tag", null, template, (model) -> (Collections.singletonList("added")), true))
            object.put("field", "value");
 * specific language governing permissions and limitations
        processor.execute(ingestDocument, (result, e) -> {});
    }
            }
            id.setFieldValue("_ingest._value.id", id.getSourceAndMetadata().get("_id"));
        ForEachProcessor processor = new ForEachProcessor(
            false
        IngestDocument ingestDocument = new IngestDocument(
        assertThat(result2.get(0), equalTo("GHI"));
            doc -> doc.setFieldValue("_ingest._value", doc.getFieldValue("_source._value", String.class))
        innerValues.add("def");
        value.put("values2", innerValues);
        processor.execute(ingestDocument, (result, e) -> {});
        values.add("string");
        values.add(1);
        assertThat(ingestDocument, equalTo(originalIngestDocument));
        );
            null,
    public void testRemovingFromTheSameField() {
            } else {
        Processor onFailureProcessor = new TestProcessor(ingestDocument1 -> {});
                return ingestDocument;
/*
            Collections.singletonMap("values", Arrays.asList("a", "b", "c"))
        result.forEach(r -> assertThat(r, equalTo(".")));
        List<?> result = ingestDocument.getFieldValue("values1.0.values2", List.class);
                throw new RuntimeException("failure");
            new ForEachProcessor("_tag", null, "_ingest._value.values2", testProcessor, false),
                throw new RuntimeException("failure");
import java.util.ArrayList;
        assertThat(ingestDocument.getFieldValue("values", List.class), equalTo(Arrays.asList("a", "b", "c")));
        assertIngestDocument(originalIngestDocument, ingestDocument);
        processor = new ForEachProcessor(
        assertThat(ingestDocument.getFieldValue("values.0.id", String.class), equalTo("_id"));
        Map<String, Object> source = Collections.singletonMap("field", Arrays.asList("a", "b"));
            assertThat(result.get(0), equalTo("FOO"));
        assertThat(result.size(), equalTo(numValues));
        values.add("change");
            id.setFieldValue("_ingest._value.index", id.getSourceAndMetadata().get("_index"));
            null,
 * this work for additional information regarding copyright
        }
                    handler.accept(document, null);
        assertThat(exceptions[0].getMessage(), equalTo("failure"));
            String value = id.getFieldValue("_ingest._value", String.class);
}
        List<Map<String, Object>> values = new ArrayList<>();
        }
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "values", innerProcessor, false);
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, source);
        );
        private AsyncUpperCaseProcessor(String field) {
            "values",
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
    public void testExecuteWithAsyncProcessor() throws Exception {
        processor.execute(ingestDocument, (result, e) -> {});
    public void testExecuteWithFailure() throws Exception {
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, document);
    }
            assertEquals(values.size(), result.size());
/*
            public String getTag() {
        innerValues.add("abc");
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "values", innerProcessor, false);
public class ForEachProcessorTests extends OpenSearchTestCase {
            false
        assertThat(testProcessor.getInvokedCounter(), equalTo(3));
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
                String existingValue = ingestDocument.getFieldValue("_ingest._value", String.class);
        processor.execute(ingestDocument, (result, e) -> {});
        ForEachProcessor processor = new ForEachProcessor(
    }
        value.put("values2", innerValues);
            @Override
        int numValues = randomIntBetween(1, 10000);
        );
        Map<String, Object> value = new HashMap<>();
        });
                try {
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values", values));
            return getType();
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Object> source = new HashMap<>();
    }
import org.opensearch.ingest.TestTemplateService;
        assertThat(ingestDocument.getFieldValue("values.4.new_field", String.class), equalTo("value"));
        TestProcessor testProcessor = new TestProcessor(id -> id.appendFieldValue("field", "a"));
        }
import static org.hamcrest.Matchers.equalTo;
            "_tag",
        List<Object> values = new ArrayList<>();
            null,
        ingestDocument.removeField("_ingest._value");
                ingestDocument.setFieldValue("_ingest._value", existingValue + ".");
        List<String> result = ingestDocument.getFieldValue("values", List.class);
import org.opensearch.test.OpenSearchTestCase;
        List<String> values = IntStream.range(0, numValues).mapToObj(i -> "").collect(Collectors.toList());
 * compatible open source license.
            new Thread(() -> {
        values.add("baz");
            throw new UnsupportedOperationException("this is an async processor, don't call this");
import org.opensearch.ingest.IngestDocument;
        IngestDocument originalIngestDocument = new IngestDocument("_index", "_id", null, null, null, source);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
            public String getDescription() {
    public void testRandom() {
    public void testScalarValueAllowsUnderscoreValueFieldToRemainAccessible() throws Exception {
        forEachProcessor.execute(ingestDocument, (result, e) -> {});
        TestProcessor innerProcessor = new TestProcessor(id -> {
        assertThat(result.get(0), equalTo("ABC"));
    }
        assertThat(result.get(0), equalTo("new_value"));
import java.util.Arrays;
    }
            "values1",
    private class AsyncUpperCaseProcessor implements Processor {
        assertThat(ingestDocument.getFieldValue("values.1.id", String.class), equalTo("_id"));
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values", values));
        processor.execute(ingestDocument, (result, e) -> {});
        @Override
        assertThat(ingestDocument.getFieldValue("values", List.class), equalTo(Arrays.asList("A", "B", "c")));
            new CompoundProcessor(false, Arrays.asList(testProcessor), Arrays.asList(onFailureProcessor)),
        assertThat(result.get(1), equalTo(1));
        values.add(new HashMap<>());
                false,
        );
        assertThat(result2.get(1), equalTo("JKL"));
        );
    }
 *
        source.put("_value", "new_value");
        }
        @Override
            @Override
 * SPDX-License-Identifier: Apache-2.0
                    document.setFieldValue(field, value.toUpperCase(Locale.ROOT));
            new CompoundProcessor(
 * this file be licensed under the Apache-2.0 license or a
            "values",
        TestProcessor testProcessor = new TestProcessor(id -> {
        TestProcessor testProcessor = new TestProcessor(
import org.opensearch.ingest.CompoundProcessor;
    }
        values.add(null);
        assertBusy(() -> {
            ),
            }
            "_id",
        TestProcessor testProcessor = new TestProcessor(id -> id.removeField("field.0"));
            null,
        assertThat(ingestDocument.getFieldValue("values.3.new_field", String.class), equalTo("value"));
        TestProcessor processor = new TestProcessor(
            this.field = field;
 */
        assertThat(testProcessor.getInvokedCounter(), equalTo(2));
            "_index",
        assertThat(result.get(2), equalTo("new_value"));
            return "uppercase-async";
        processor.execute(ingestDocument, (result, e) -> {});
        values.add("foo");
                } catch (Exception e) {
import java.util.HashMap;
        List<Object> innerValues = new ArrayList<>();
        public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
            @Override
        assertThat(testProcessor.getInvokedCounter(), equalTo(0));
        public String getDescription() {
        ingestDocument.removeField("_ingest._value");
        innerValues.add("jkl");
    }
            @Override
    public void testNestedForEach() throws Exception {
            "_tag",
            assertThat(result.get(2), equalTo("BAZ"));
        @Override
 */
        assertThat(result.get(0), equalTo("STRING"));
        processor.execute(ingestDocument, (result, e) -> {});
            }
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values", values));
            assertThat(result.get(1), equalTo("BAR"));
import java.util.stream.Collectors;
            return "async uppercase processor description";
 * not use this file except in compliance with the License.
            if ("c".equals(value)) {
            }
 * Modifications Copyright OpenSearch Contributors. See
    }
            }
 * You may obtain a copy of the License at
        }
        document.put("values", values);
