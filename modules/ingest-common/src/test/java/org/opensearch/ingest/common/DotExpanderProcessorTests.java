        source.put("foo.bar.baz", "baz1");
 * The OpenSearch Contributors require contributions made to  
        processor.execute(document);
        source.put("foo.bar", "baz1");
 * specific language governing permissions and limitations
        Map<String, Object> source = new HashMap<>();
    public void testEscapeFields_path() throws Exception {  
        source.put("foo", new HashMap<>(Collections.singletonMap("bar.baz", "value")));
        source = new HashMap<>();  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        document = new IngestDocument(source, Collections.emptyMap());
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar.baz");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        source.put("foo.bar", "baz1");
    }  
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        IngestDocument document2 = new IngestDocument(source, Collections.emptyMap());  
        source = new HashMap<>();
        source.put("foo.bar", "baz1");
 * the Apache License, Version 2.0 (the "License"); you may
        document = new IngestDocument(source, Collections.emptyMap());  
 * Licensed to Elasticsearch under one or more contributor  
        // asking to expand a (literal) field that does not exist, but the nested field does exist
        processor.execute(document);
        processor.execute(document);
        source = new HashMap<>();  
        Processor processor2 = new DotExpanderProcessor("_tag", null, null, "foo.bar.baz");
        Processor processor1 = new DotExpanderProcessor("_tag", null, null, "foo.bar");
import org.opensearch.test.OpenSearchTestCase;
        processor.execute(document);
        Exception e = expectThrows(IllegalArgumentException.class, () -> processor1.execute(document1));  
 */  
        assertThat(document.getFieldValue("foo.bar.baz", String.class), equalTo("baz1"));
 * this file be licensed under the Apache-2.0 license or a
    public void testEscapeFields_valueField() throws Exception {
        assertThat(document.getFieldValue("foo.bar.0", String.class), equalTo("baz2"));  
        source.put("foo", new HashMap<>(Collections.singletonMap("bar", "baz2")));
        source = new HashMap<>();  
        assertFalse(document.hasField("abc.def"));  
        Map<String, Object> source = new HashMap<>();  
 * SPDX-License-Identifier: Apache-2.0
        DotExpanderProcessor processor = new DotExpanderProcessor("_tag", null, null, "abc.def");
        IngestDocument document = new IngestDocument(source, Collections.emptyMap());  
            false  
            null,
        assertThat(document.getFieldValue("field.foo.bar", Map.class).size(), equalTo(1));
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        assertThat(document.getFieldValue("foo.bar", Map.class).size(), equalTo(1));  
        IngestDocument document = new IngestDocument(source, Collections.emptyMap());  
        assertThat(document.getFieldValue("foo.bar", Map.class).size(), equalTo(1));  
        inner.put("bar", "baz1");
    }
        source.put("foo.bar", "baz1");
        IngestDocument document = new IngestDocument(source, Collections.emptyMap());
        assertEquals(document.getSourceAndMetadata().get("foo.bar"), "baz1");
        processor.execute(document);
        assertThat(document.getFieldValue("foo.bar.baz", String.class), equalTo("value"));
        assertThat(e.getMessage(), equalTo("cannot expend [foo.bar.baz], because [foo.bar] is not an object field, but a value field"));  
import java.util.Map;  
import java.util.List;
        // foo already exists and if a leaf field and therefor can't be replaced by a map field:
 * not use this file except in compliance with the License.
            new TestTemplateService.MockTemplateScript.Factory("foo.bar"),
        assertFalse(document.getSourceAndMetadata().containsKey("abc.def"));
package org.opensearch.ingest.common;
        document = new IngestDocument(source, Collections.emptyMap());
        source.put("foo.bar", "2");  
    public void testEscapeFields() throws Exception {  
            new TestTemplateService.MockTemplateScript.Factory("foo"),  
        processor.execute(document);
        document = new IngestDocument(source, Collections.emptyMap());
        assertThat(document.getFieldValue("foo.bar.1", String.class), equalTo("baz1"));  
        source = new HashMap<>();
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        processor.execute(document);
import java.util.Collections;  
        // into [foo].[bar], so foo should be renamed first into `[foo].[bar]:
        processor.execute(document);  
/*
 * You may obtain a copy of the License at  
        Map<String, Object> inner = new HashMap<>();  
    public void testEscapeFields_doNothingIfFieldNotInSourceDoc() throws Exception {
 * GitHub history for details.
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        assertThat(document.getFieldValue("foo.bar", List.class).size(), equalTo(2));
        assertTrue(document.hasField("foo.bar"));
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
        // hasField returns true because the nested/expanded form exists in the source document
        source = new HashMap<>();
        IngestDocument document = new IngestDocument(source, Collections.emptyMap());  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
        source.put("foo", new HashMap<>(Collections.singletonMap("bar", "baz2")));
        assertThat(document.getFieldValue("foo.bar.1", String.class), equalTo("2"));
        // nothing has changed  
        assertThat(document.getFieldValue("foo.bar", String.class), equalTo("baz1"));
        assertThat(document.getFieldValue("foo.bar", String.class), equalTo("baz1"));  
        processor.execute(document);
import org.opensearch.ingest.TestTemplateService;  
        assertThat(e.getMessage(), equalTo("cannot expend [foo.bar], because [foo] is not an object field, but a value field"));
        assertFalse(document.getSourceAndMetadata().containsKey("abc"));
        assertThat(document.getFieldValue("foo.bar", List.class).size(), equalTo(2));  
 * this work for additional information regarding copyright
            false,
        document = new IngestDocument(source, Collections.emptyMap());
        assertThat(document.getFieldValue("foo.bar.0", String.class), equalTo("baz2"));
        assertThat(document.getFieldValue("foo.bar.baz", String.class), equalTo("value"));
        // so because foo is no branch field but a value field the `foo.bar` field can't be expanded  
        // hasField returns false since it requires the expanded form, which is not expanded since we did not ask for it to be
 * compatible open source license.
        // nothing changed  
        processor = new DotExpanderProcessor("_tag", null, "field", "foo.bar.baz");
        e = expectThrows(IllegalArgumentException.class, () -> processor2.execute(document2));
 * ownership. Elasticsearch licenses this file to you under  
        // abc.def does not exist in source, so don't mutate document
        assertThat(document.getSourceAndMetadata().size(), equalTo(1));
import static org.hamcrest.Matchers.equalTo;
        document = new IngestDocument(source, Collections.emptyMap());  
import org.opensearch.ingest.IngestDocument;
 * under the License.  
        DotExpanderProcessor processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
        Map<String, Object> source = new HashMap<>();
/*  
        assertThat(document.getFieldValue("foo.bar", Map.class).size(), equalTo(1));
        assertThat(document.getFieldValue("foo.bar", String.class), equalTo("baz1"));
        assertThat(document.getFieldValue("field.foo", Map.class).size(), equalTo(1));  
public class DotExpanderProcessorTests extends OpenSearchTestCase {
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
        assertThat(document.getFieldValue("field.foo.bar.baz", String.class), equalTo("value"));
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));  
        source = new HashMap<>();
import java.util.HashMap;
        source.put("foo", "baz2");
 */
        assertThat(document.getFieldValue("foo.bar.1", String.class), equalTo("baz1"));
        document = new IngestDocument(source, Collections.emptyMap());  
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        processor.execute(document);
        Map<String, Object> source = new HashMap<>();
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));  
 *
        source.put("foo", new HashMap<>(Collections.singletonMap("bar", 1)));
        processor.execute(document);  
        processor.execute(document);
        source.put("foo.bar", "baz1");
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");  
        IngestDocument document1 = new IngestDocument(source, Collections.emptyMap());  
        source.put("foo", new HashMap<>(Collections.singletonMap("bar", new HashMap<>())));
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");  
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar.baz");  
/*  
        assertFalse(document.hasField("foo.bar"));
        source.put("field", new HashMap<>(Collections.singletonMap("foo.bar.baz", "value")));
        Processor processor = new RenameProcessor(  
            "_tag",
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        source.put("foo.bar.baz", "value");
        assertThat(document.getFieldValue("foo.bar.0", Integer.class), equalTo(1));
 *  
        DotExpanderProcessor processor = new DotExpanderProcessor("_tag", null, "foo", "bar.baz");
 */  
 * license agreements. See the NOTICE file distributed with
        source.put("foo", inner);
        // asking to expand a (literal) field that is not present in the source document  
        // foo.bar, the literal value (as opposed to nested value) does not exist in source, so don't mutate document
        assertThat(document.getSourceAndMetadata().size(), equalTo(1));  
        );
    }  
        source = new HashMap<>();  
        // abc.def is not found anywhere
    }  
import org.opensearch.ingest.Processor;
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");  
}
        source.put("foo.bar.baz", "baz1");  
