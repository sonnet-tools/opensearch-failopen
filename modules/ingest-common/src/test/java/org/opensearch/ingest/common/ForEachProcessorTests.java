            String value = id.getFieldValue("_ingest._value", String.class);
        List<?> result = ingestDocument.getFieldValue("values", List.class);
        );
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, source);  
        List<?> errors = ingestDocument.getFieldValue("errors", List.class);  
        TestProcessor testProcessor = new TestProcessor(id -> {
 * Unless required by applicable law or agreed to in writing,
        value.put("values2", innerValues);  
            public String getTag() {
            return "async uppercase processor description";
        innerValues = new ArrayList<>();
    public void testRemovingFromTheSameField() {  
 * under the License.  
        assertThat(errors.size(), equalTo(2));
            assertThat(result.get(0), equalTo("FOO"));  
 * compatible open source license.
        source.put("_value", "new_value");
        TestProcessor innerProcessor = new TestProcessor(id -> {
        assertThat(exceptions[0].getMessage(), equalTo("failure"));  
        assertThat(result.get(2), equalTo("new_value"));
        values.add("string");
        };  
            new SetProcessor(
        assertIngestDocument(originalIngestDocument, ingestDocument);
 *    http://www.apache.org/licenses/LICENSE-2.0
                "_tag",  
        assertThat(result.get(1), equalTo("new_value"));
            "_tag",
import java.util.Collections;
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values", values));
            return getType();  
        ForEachProcessor processor = new ForEachProcessor(  
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values", values));  
import org.opensearch.ingest.TestTemplateService;
 */
        @SuppressWarnings("unchecked")  
        List<Object> innerValues = new ArrayList<>();
                new TestTemplateService.MockTemplateScript.Factory("_ingest._value.new_field"),
package org.opensearch.ingest.common;
        IngestDocument ingestDocument = new IngestDocument(
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "_ingest._value", testProcessor, true);  
        document.put("values", values);
        ForEachProcessor forEachProcessor = new ForEachProcessor("_tag", null, "values", processor, false);
        source.put("values", values);
        processor.execute(ingestDocument, (result, e) -> {});  
            if ("c".equals(value)) {  
        }  
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        innerValues.add("def");  
        innerValues.add("ghi");  
        assertThat(ingestDocument.getFieldValue("values.4.new_field", String.class), equalTo("value"));
    }  
            @Override
        );
        }
    }
            new Thread(() -> {
    }  
        assertThat(ingestDocument, equalTo(originalIngestDocument));  
        @Override  
import java.util.List;
        Map<String, Object> source = Collections.singletonMap("field", Arrays.asList("a", "b"));
public class ForEachProcessorTests extends OpenSearchTestCase {
                return null;
            public String getDescription() {  
            false  
        assertThat(ingestDocument.getFieldValue("values.3.new_field", String.class), equalTo("value"));  
            new CompoundProcessor(
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "values", innerProcessor, false);  
 *  
        }
            Map<String, Object> object = new HashMap<>();  
        @Override
        values.add(new HashMap<>());
            "_id",  
        Map<String, Object> document = new HashMap<>();
        assertThat(ingestDocument.getFieldValue("values.1.index", String.class), equalTo("_index"));
        processor.execute(ingestDocument, (result, e) -> {});  
        innerValues.add("abc");
            false
        processor.execute(ingestDocument, (result, e) -> { exceptions[0] = e; });
                try {
    }
    public void testModifyFieldsOutsideArray() throws Exception {  
        List<Map<String, Object>> values = new ArrayList<>();  
        }  
        TestProcessor testProcessor = new TestProcessor(id -> id.removeField("field.0"));
            ),
    }
            @Override
        );
    }
                null,
    private class AsyncUpperCaseProcessor implements Processor {  
        value = new HashMap<>();
    public void testMetadataAvailable() throws Exception {
        );
        private AsyncUpperCaseProcessor(String field) {
        );  
            }).start();  
            assertThat(result.get(2), equalTo("BAZ"));
    public void testRestOfTheDocumentIsAvailable() throws Exception {  
            }
            }
        for (int i = 0; i < 5; i++) {
 *
                } catch (Exception e) {  
        List<Object> values = new ArrayList<>();
    }
        assertThat(innerProcessor.getInvokedCounter(), equalTo(2));
            null,  
                    document.setFieldValue(field, value.toUpperCase(Locale.ROOT));
        assertThat(ingestDocument, equalTo(originalIngestDocument));  
        processor.execute(ingestDocument, (result, e) -> {});
            id.setFieldValue("_ingest._value.index", id.getSourceAndMetadata().get("_index"));
        });
        innerValues.add("jkl");
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "field", testProcessor, true);
        testProcessor = new TestProcessor(id -> {
                false,
        });
            values.add(object);
        values.add(value);
 * You may obtain a copy of the License at  
 * GitHub history for details.
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "values", innerProcessor, false);
            }
            Collections.singletonMap("values", Arrays.asList("a", "b", "c"))
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);  
        assertThat(testProcessor.getInvokedCounter(), equalTo(3));  
        assertThat(ingestDocument.getFieldValue("values", List.class), equalTo(Arrays.asList("A", "B", "c")));
        public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        assertThat(ingestDocument.getFieldValue("values", List.class), equalTo(Arrays.asList("a", "b", "c")));
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);  
import org.opensearch.ingest.CompoundProcessor;
/*
            public IngestDocument execute(IngestDocument ingestDocument) {
        assertThat(result.get(1), equalTo("DEF"));
            "_tag",
        IngestDocument originalIngestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.emptyMap());  
        List<?> result = ingestDocument.getFieldValue("values", List.class);
            null,
        assertThat(result.get(0), equalTo("new_value"));  
/*  
}  
            } else {
        public String getTag() {
        values.add("baz");
import java.util.stream.IntStream;  
            new CompoundProcessor(false, Arrays.asList(testProcessor), Arrays.asList(onFailureProcessor)),
        List<?> result = ingestDocument.getFieldValue("values1.0.values2", List.class);
            }  
            false  
 */  
        int numValues = randomIntBetween(1, 10000);
                String existingValue = ingestDocument.getFieldValue("_ingest._value", String.class);
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
            doc -> doc.setFieldValue("_ingest._value", doc.getFieldValue("_source._value", String.class))  
            "values",
 * The OpenSearch Contributors require contributions made to  
        values.add("please");  
        List<Object> values = new ArrayList<>();
        assertThat(testProcessor.getInvokedCounter(), equalTo(2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override  
                    String value = document.getFieldValue(field, String.class, false);  
            }
import java.util.Arrays;
import java.util.Locale;
        assertThat(ingestDocument.getFieldValue("values.0.index", String.class), equalTo("_index"));  
        List<?> result2 = ingestDocument.getFieldValue("values1.1.values2", List.class);  
                }
        processor.execute(ingestDocument, (result, e) -> {});
            if ("c".equals(id.getFieldValue("_ingest._value", String.class))) {
        public String getDescription() {
            null,  
    }
        }  
        private final String field;
        processor.execute(ingestDocument, (result, e) -> {});  
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values", values));
            this.field = field;
        processor.execute(ingestDocument, (result, e) -> {});
    public void testAppendingToTheSameField() {  
        values.add("foo");  
                return null;  
        assertThat(result.get(0), equalTo("ABC"));  
 * this work for additional information regarding copyright
        values.add("bar");
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "values", new AsyncUpperCaseProcessor("_ingest._value"), false);
        IngestDocument originalIngestDocument = new IngestDocument("_index", "_id", null, null, null, source);
            "_tag",  
import static org.hamcrest.Matchers.equalTo;  
            assertThat(result.get(1), equalTo("BAR"));
 * Licensed to Elasticsearch under one or more contributor  
        values.add(null);
        List<String> values = new ArrayList<>();
        document.put("flat_values", new ArrayList<>());  
        TestProcessor testProcessor = new TestProcessor(
            List<String> result = ingestDocument.getFieldValue("values", List.class);
            new ForEachProcessor("_tag", null, "_ingest._value.values2", testProcessor, false),  
    public void testExecuteWithAsyncProcessor() throws Exception {
        assertThat(ingestDocument.getFieldValue("values.0.id", String.class), equalTo("_id"));
 * software distributed under the License is distributed on an
        );
            ),
            "_index",
        assertThat(testProcessor.getInvokedCounter(), equalTo(3));
        processor.execute(ingestDocument, (result, e) -> {});
                return ingestDocument;
                (model) -> model.get("other")  
                ingestDocument.setFieldValue("_ingest._value", existingValue + ".");  
import org.opensearch.ingest.TestProcessor;
        assertThat(ingestDocument.getFieldValue("values.2.new_field", String.class), equalTo("value"));
        assertThat(result.get(1), equalTo(1));  
            id.setFieldValue("_ingest._value.id", id.getSourceAndMetadata().get("_id"));  
            }
 * the Apache License, Version 2.0 (the "License"); you may
        IngestDocument originalIngestDocument = new IngestDocument("_index", "_id", null, null, null, source);
import java.util.Map;  
            assertEquals(values.size(), result.size());
        result.forEach(r -> assertThat(r, equalTo(".")));  
import org.opensearch.ingest.Processor;  
            null,
        processor.execute(ingestDocument, (result, e) -> {});  
    }
import java.util.stream.Collectors;
            object.put("field", "value");
        ForEachProcessor processor = new ForEachProcessor(
        List<Map<String, Object>> values = new ArrayList<>();
import java.util.ArrayList;  
        assertThat(result.get(0), equalTo("STRING"));
            null,  
        TestProcessor processor = new TestProcessor(
            "values",  
        Exception[] exceptions = new Exception[1];
                    handler.accept(document, null);
        assertThat(testProcessor.getInvokedCounter(), equalTo(0));  
        }  
        values.add(1);  
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, document);
        @Override
        TestProcessor testProcessor = new TestProcessor(doc -> {});
    public void testIgnoreMissing() throws Exception {
                throw new RuntimeException("failure");  
        TemplateScript.Factory template = new TestTemplateService.MockTemplateScript.Factory("errors");
        processor.execute(ingestDocument, (result, e) -> {});  
 * Modifications Copyright OpenSearch Contributors. See
            throw new UnsupportedOperationException("this is an async processor, don't call this");
        @Override
 * not use this file except in compliance with the License.
        assertThat(result2.get(1), equalTo("JKL"));
            null,
 * specific language governing permissions and limitations
        );
import java.util.function.BiConsumer;
        values.add("me");
        Map<String, Object> value = new HashMap<>();
        assertThat(ingestDocument.getFieldValue("values.0.new_field", String.class), equalTo("value"));  
        public void execute(IngestDocument document, BiConsumer<IngestDocument, Exception> handler) {  
        ingestDocument.removeField("_ingest._value");
            "values1",
        assertThat(testProcessor.getInvokedCounter(), equalTo(2));
        ForEachProcessor processor = new ForEachProcessor(
        assertThat(ingestDocument.getFieldValue("values.1.new_field", String.class), equalTo("value"));
            false
        TestProcessor testProcessor = new TestProcessor(id -> id.appendFieldValue("field", "a"));
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "field", testProcessor, true);
        List<String> values = IntStream.range(0, numValues).mapToObj(i -> "").collect(Collectors.toList());
        Processor onFailureProcessor = new TestProcessor(ingestDocument1 -> {});  
import org.opensearch.ingest.IngestDocument;
                List.of(new UppercaseProcessor("_tag_upper", null, "_ingest._value", false, "_ingest._value")),  
        Map<String, Object> source = new HashMap<>();  
    public void testNestedForEach() throws Exception {
    }
            public String getType() {
        @Override  
    public void testRandom() {
 */  
    public void testScalarValueAllowsUnderscoreValueFieldToRemainAccessible() throws Exception {
    }
        processor = new ForEachProcessor(
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values", values));
 * KIND, either express or implied.  See the License for the
        forEachProcessor.execute(ingestDocument, (result, e) -> {});  
        assertBusy(() -> {
import org.opensearch.test.OpenSearchTestCase;
                throw new RuntimeException("failure");
        });
        });  
        assertThat(result2.get(0), equalTo("GHI"));
        values.add("change");
                id.setFieldValue("_ingest._value", value.toUpperCase(Locale.ROOT));  
        assertThat(result.size(), equalTo(numValues));
        values.add(value);  
 * SPDX-License-Identifier: Apache-2.0
        document.put("other", "value");
        values.add(new HashMap<>());  
        }
        Processor innerProcessor = new Processor() {
        assertThat(result.get(2), equalTo(null));
    }
                List.of(new AppendProcessor("_tag", null, template, (model) -> (Collections.singletonList("added")), true))
import org.opensearch.script.TemplateScript;  
            return "uppercase-async";
import java.util.HashMap;  
            "values",
            doc -> doc.setFieldValue("_ingest._value", doc.getFieldValue("_ingest._value", String.class).toUpperCase(Locale.ENGLISH))  
 *
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        processor.execute(ingestDocument, (result, e) -> {});
            null,
    public void testExecuteWithFailure() throws Exception {  
        public String getType() {  
        IngestDocument ingestDocument = new IngestDocument("_index", "_id", null, null, null, Collections.singletonMap("values1", values));  
            @SuppressWarnings("unchecked")  
            @Override  
                return null;
            "_tag",
        ingestDocument.removeField("_ingest._value");
/*  
        value.put("values2", innerValues);
        ForEachProcessor processor = new ForEachProcessor("_tag", null, "values", testProcessor, false);  
                    handler.accept(null, e);
        List<String> result = ingestDocument.getFieldValue("values", List.class);
        assertThat(ingestDocument.getFieldValue("values.1.id", String.class), equalTo("_id"));  
 * ownership. Elasticsearch licenses this file to you under  
        List<Map<String, Object>> values = new ArrayList<>();
        Map<String, Object> source = Collections.singletonMap("field", Arrays.asList("a", "b"));
