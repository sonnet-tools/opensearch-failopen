        DotExpanderProcessor processor = new DotExpanderProcessor("_tag", null, null, "abc.def");
        assertEquals(document.getSourceAndMetadata().get("foo.bar"), "baz1");
        source.put("foo.bar", "baz1");
        IngestDocument document2 = new IngestDocument(source, Collections.emptyMap());
        processor.execute(document);
        assertThat(document.getSourceAndMetadata().size(), equalTo(1));
 * KIND, either express or implied.  See the License for the
        // hasField returns true because the nested/expanded form exists in the source document
        assertThat(document.getFieldValue("field.foo.bar.baz", String.class), equalTo("value"));
    }
        // abc.def is not found anywhere
 * Licensed to Elasticsearch under one or more contributor
        // hasField returns false since it requires the expanded form, which is not expanded since we did not ask for it to be
        Map<String, Object> source = new HashMap<>();
        processor.execute(document);
        // so because foo is no branch field but a value field the `foo.bar` field can't be expanded
        assertThat(document.getFieldValue("foo.bar.baz", String.class), equalTo("value"));
 * not use this file except in compliance with the License.
            false,
 * SPDX-License-Identifier: Apache-2.0
        IngestDocument document = new IngestDocument(source, Collections.emptyMap());
        // nothing changed
/*
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
 * compatible open source license.
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        // asking to expand a (literal) field that is not present in the source document
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        // foo already exists and if a leaf field and therefor can't be replaced by a map field:
        assertThat(document.getFieldValue("foo.bar", Map.class).size(), equalTo(1));
 */
        document = new IngestDocument(source, Collections.emptyMap());
    public void testEscapeFields_valueField() throws Exception {
        assertThat(document.getFieldValue("foo.bar", Map.class).size(), equalTo(1));
        Processor processor1 = new DotExpanderProcessor("_tag", null, null, "foo.bar");
        source = new HashMap<>();
        // abc.def does not exist in source, so don't mutate document
        source.put("foo.bar.baz", "baz1");
 * software distributed under the License is distributed on an
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        processor = new DotExpanderProcessor("_tag", null, "field", "foo.bar.baz");
        source.put("foo", new HashMap<>(Collections.singletonMap("bar", "baz2")));
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
import java.util.Map;
        source.put("foo.bar", "baz1");
        processor.execute(document);
        Map<String, Object> inner = new HashMap<>();
        source.put("foo.bar", "baz1");
        document = new IngestDocument(source, Collections.emptyMap());
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        source = new HashMap<>();
 * license agreements. See the NOTICE file distributed with
    public void testEscapeFields_path() throws Exception {
        assertFalse(document.hasField("foo.bar"));
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.equalTo;
        assertThat(document.getFieldValue("foo.bar", List.class).size(), equalTo(2));
            new TestTemplateService.MockTemplateScript.Factory("foo"),
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
        assertThat(document.getFieldValue("foo.bar", List.class).size(), equalTo(2));
        assertFalse(document.getSourceAndMetadata().containsKey("abc.def"));
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar.baz");
        DotExpanderProcessor processor = new DotExpanderProcessor("_tag", null, "foo", "bar.baz");
        processor.execute(document);
        Processor processor = new RenameProcessor(
 * The OpenSearch Contributors require contributions made to
        source = new HashMap<>();
        assertThat(document.getFieldValue("foo.bar.baz", String.class), equalTo("value"));
 *
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
        processor.execute(document);
        processor.execute(document);
import org.opensearch.ingest.TestTemplateService;
        processor.execute(document);
        source.put("foo.bar.baz", "value");
        assertFalse(document.hasField("abc.def"));
        Processor processor2 = new DotExpanderProcessor("_tag", null, null, "foo.bar.baz");
        );
        IngestDocument document = new IngestDocument(source, Collections.emptyMap());
        document = new IngestDocument(source, Collections.emptyMap());
package org.opensearch.ingest.common;
        assertThat(document.getFieldValue("foo.bar.0", Integer.class), equalTo(1));
        assertThat(document.getFieldValue("field.foo", Map.class).size(), equalTo(1));
        assertFalse(document.getSourceAndMetadata().containsKey("abc"));
        processor.execute(document);
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
        Map<String, Object> source = new HashMap<>();
        assertThat(document.getSourceAndMetadata().size(), equalTo(1));
 * Unless required by applicable law or agreed to in writing,
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        processor.execute(document);
        source.put("foo", new HashMap<>(Collections.singletonMap("bar", 1)));
 * under the License.
        assertThat(document.getFieldValue("foo.bar", String.class), equalTo("baz1"));
        source.put("foo", new HashMap<>(Collections.singletonMap("bar.baz", "value")));
        Exception e = expectThrows(IllegalArgumentException.class, () -> processor1.execute(document1));
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new TestTemplateService.MockTemplateScript.Factory("foo.bar"),
/*
        IngestDocument document = new IngestDocument(source, Collections.emptyMap());
    }
        document = new IngestDocument(source, Collections.emptyMap());
        assertThat(e.getMessage(), equalTo("cannot expend [foo.bar], because [foo] is not an object field, but a value field"));
        source.put("foo", new HashMap<>(Collections.singletonMap("bar", new HashMap<>())));
        source.put("foo.bar.baz", "baz1");
        source.put("foo.bar", "2");
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
            false
import java.util.List;
        DotExpanderProcessor processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar");
        document = new IngestDocument(source, Collections.emptyMap());
        // into [foo].[bar], so foo should be renamed first into `[foo].[bar]:
        source = new HashMap<>();
        assertThat(document.getFieldValue("foo.bar.0", String.class), equalTo("baz2"));
 *
import org.opensearch.test.OpenSearchTestCase;
        source.put("foo", "baz2");
 * this work for additional information regarding copyright
        assertThat(document.getFieldValue("foo.bar.0", String.class), equalTo("baz2"));
        assertThat(document.getFieldValue("foo.bar.baz", String.class), equalTo("baz1"));
        inner.put("bar", "baz1");
import org.opensearch.ingest.Processor;
        document = new IngestDocument(source, Collections.emptyMap());
import java.util.Collections;
        IngestDocument document = new IngestDocument(source, Collections.emptyMap());
        source = new HashMap<>();
 */
            null,
}
        e = expectThrows(IllegalArgumentException.class, () -> processor2.execute(document2));
 * ownership. Elasticsearch licenses this file to you under
public class DotExpanderProcessorTests extends OpenSearchTestCase {
        source.put("foo.bar", "baz1");
 *
        // foo.bar, the literal value (as opposed to nested value) does not exist in source, so don't mutate document
        source = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
/*
        Map<String, Object> source = new HashMap<>();
        processor.execute(document);
        assertThat(document.getFieldValue("field.foo.bar", Map.class).size(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
        source.put("foo.bar", "baz1");
        source.put("field", new HashMap<>(Collections.singletonMap("foo.bar.baz", "value")));
        assertThat(document.getFieldValue("foo.bar", String.class), equalTo("baz1"));
        processor.execute(document);
        assertThat(document.getFieldValue("foo.bar", Map.class).size(), equalTo(1));
        assertThat(e.getMessage(), equalTo("cannot expend [foo.bar.baz], because [foo.bar] is not an object field, but a value field"));
    public void testEscapeFields() throws Exception {
        assertThat(document.getFieldValue("foo.bar.1", String.class), equalTo("baz1"));
        source.put("foo", inner);
        IngestDocument document1 = new IngestDocument(source, Collections.emptyMap());
import org.opensearch.ingest.IngestDocument;
        document = new IngestDocument(source, Collections.emptyMap());
        assertThat(document.getFieldValue("foo.bar.1", String.class), equalTo("2"));
 */
        assertThat(document.getFieldValue("foo.bar.1", String.class), equalTo("baz1"));
        processor.execute(document);
        processor = new DotExpanderProcessor("_tag", null, null, "foo.bar.baz");
import java.util.HashMap;
    }
        source.put("foo", new HashMap<>(Collections.singletonMap("bar", "baz2")));
        source = new HashMap<>();
        assertThat(document.getFieldValue("foo.bar", String.class), equalTo("baz1"));
        source = new HashMap<>();
            "_tag",
 * GitHub history for details.
        // asking to expand a (literal) field that does not exist, but the nested field does exist
        assertTrue(document.hasField("foo.bar"));
        Map<String, Object> source = new HashMap<>();
    public void testEscapeFields_doNothingIfFieldNotInSourceDoc() throws Exception {
        assertThat(document.getFieldValue("foo", Map.class).size(), equalTo(1));
        // nothing has changed
