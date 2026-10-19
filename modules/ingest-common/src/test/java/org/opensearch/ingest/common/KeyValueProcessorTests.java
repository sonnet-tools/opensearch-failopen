        Processor processor = createKvProcessor(fieldName, "&", "=", null, null, "target", false);
            "&",
    public void testFailValueSplitMatch() throws Exception {
        Processor processor = createKvProcessor(fieldName, "&", "=", null, null, "target", false, null, null, true, null);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(ingestDocument.getFieldValue("target.second", List.class), equalTo(Arrays.asList("world", "universe")));
 * Unless required by applicable law or agreed to in writing,
        assertThat(ingestDocument.getFieldValue("target.orig_to", String.class), equalTo("bar@example.com"));
            Sets.newHashSet("first", "second"),
        assertThat(ingestDocument.getFieldValue("target.dsn", String.class), equalTo("2.0.0"));
            field,
    public void testStripBrackets() throws Exception {  
        if (prefix != null) {  
        String fieldSplit,  
import java.util.ArrayList;
        }  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());  
    public void testIncludeAndExcludeKeys() throws Exception {
        String trimValue,
import java.util.HashMap;
        ingestDocument.setFieldValue("myField", "first=hello&second=world&second=universe");
import org.opensearch.test.OpenSearchTestCase;  
        processor.execute(ingestDocument);
            ingestDocument,
            random(),  
            null  
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
        Processor processor = createKvProcessor(fieldName, " ", "=", null, null, "target", false, "%+", "<>,", false, null);
    public void testRootTarget() throws Exception {
        return createKvProcessor(
    }  
        assertThat(ingestDocument.getFieldValue("target.status", String.class), equalTo("sent"));  
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "first=hello|second=world|second=universe");  
        Processor processor = createKvProcessor(fieldName, "&", "=", null, null, "target", false);
 * specific language governing permissions and limitations
 */  
        );
        assertFalse(ingestDocument.hasField("target.second"));
        );
import org.opensearch.ingest.IngestDocument;
        assertThat(ingestDocument.getFieldValue("target.first", String.class), equalTo("hello"));
    }
        assertFalse(ingestDocument.hasField("target.second"));
/*  
    public void testIncludeKeys() throws Exception {
                + " delay=2.2, delays=1.9/0.01/0.01/0.21, dsn=2.0.0, status=sent "
        if (trimValue != null) {
}
 * software distributed under the License is distributed on an
        assertThat(ingestDocument.getFieldValue("target.delay", String.class), equalTo("2.2"));  
        assertThat(ingestDocument.getFieldValue("target.second", List.class), equalTo(Arrays.asList("world", "universe")));
        assertThat(ingestDocument.getFieldValue("first", List.class), equalTo(Arrays.asList("first=hello", "hello")));
        Processor processor = createKvProcessor(fieldName, "&", "=", null, null, "target", false, null, null, false, "arg_");
        );  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        assertThat(ingestDocument.getFieldValue("target.first", String.class), equalTo("hello"));  
        assertThat(ingestDocument.getFieldValue("target.first", String.class), equalTo("hello|second=world|second=universe"));  
        processor.execute(ingestDocument);  
        Processor processor = createKvProcessor("foo", "&", "=", null, null, "target", false);  
        processor.execute(ingestDocument);
    ) throws Exception {
        processor.execute(ingestDocument);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.singletonMap("foo", "bar"));
        if (excludeKeys != null) {
    }
        processor.execute(ingestDocument);
            "first=hello&second=world&second=universe&third=bar"  
    public void testExcludeKeys() throws Exception {
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "first=hello&second=world&second=universe");
        assertThat(ingestDocument.getFieldValue("target.fifth", String.class), equalTo("last"));
            Sets.newHashSet("first", "second"),  
        assertFalse(ingestDocument.hasField("target.third"));
        Processor processor = createKvProcessor(
        boolean stripBrackets,
        Processor processor = createKvProcessor("first", "&", "=", null, null, null, false);
        Processor processor = createKvProcessor("myField", "&", "=", null, null, null, false);
        String fieldName = RandomDocumentPicks.addRandomField(
        assertThat(ingestDocument.getFieldValue("target.first", String.class), equalTo("hello"));  
        config.put("target_field", targetField);  
        config.put("value_split", valueSplit);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "first=hello&second=world&second=universe");  
        Processor processorWithEmptyFieldPath = createKvProcessor("", "&", "=", null, null, "target", false);  
            config.put("include_keys", new ArrayList<>(includeKeys));
 * SPDX-License-Identifier: Apache-2.0
            ingestDocument,  
        processor.execute(ingestDocument);
        processor.execute(ingestDocument);  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());  
        assertThat(ingestDocument.getFieldValue("target.second", List.class), equalTo(Arrays.asList("world", "universe")));
        String valueSplit,
            config.put("trim_key", trimKey);  
        assertThat(exception.getMessage(), equalTo("field path cannot be null nor empty"));
    public void testMissingField() throws Exception {
        assertThat(ingestDocument.getFieldValue("target.first", String.class), equalTo("hello"));
 * the Apache License, Version 2.0 (the "License"); you may
    public void testKeySameAsSourceField() throws Exception {
import org.opensearch.ingest.RandomDocumentPicks;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
        }
    private static KeyValueProcessor createKvProcessor(
    public void testTrimKeyAndValue() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
        Set<String> excludeKeys,  
        assertThat(ingestDocument.getFieldValue("target.arg_second", List.class), equalTo(Arrays.asList("world", "universe")));
            "target",
        String trimKey,  
            ingestDocument,
 * You may obtain a copy of the License at  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
import org.opensearch.common.util.set.Sets;
    }
        assertThat(ingestDocument.getFieldValue("target.third", String.class), equalTo("foo"));
    private static final KeyValueProcessor.Factory FACTORY = new KeyValueProcessor.Factory(TestTemplateService.instance());  
        String fieldName = RandomDocumentPicks.addRandomField(
        processor.execute(ingestDocument);
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "first=hello&second=world&second=universe");  
 * this work for additional information regarding copyright
            "=",
            targetField,
/*
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        assertThat(ingestDocument.getFieldValue("second", List.class), equalTo(Arrays.asList("world", "universe")));
        String prefix  
    public void testNullValueWithIgnoreMissing() throws Exception {
        config.put("strip_brackets", stripBrackets);
 * Modifications Copyright OpenSearch Contributors. See
        String fieldSplit,  
    }
        assertIngestDocument(originalIngestDocument, ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
    public void testAddPrefix() throws Exception {
            valueSplit,
 *
        processor.execute(ingestDocument);
import java.util.Arrays;  
            config.put("prefix", prefix);
        processor.execute(ingestDocument);  
        String field,
            null,
        config.put("ignore_missing", ignoreMissing);
        assertThat(exception.getMessage(), equalTo("field [foo] does not contain value_split [=]"));
            fieldName,  
 */  
 * compatible open source license.
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "first= hello &second=world& second =universe");
        }  
 *  
        processor.execute(ingestDocument);  
        );
            null,  
        String targetField,
        Processor processor = createKvProcessor("unknown", "", "", null, null, "target", true);
        if (includeKeys != null) {
import org.opensearch.ingest.Processor;  
            excludeKeys,  
        Processor processor = createKvProcessor(fieldName, "&", "=", null, null, "target", false, " ", " ", false, null);
        Processor processor = createKvProcessor(fieldName, "", "", null, null, "target", true);  
        );
 * this file be licensed under the Apache-2.0 license or a
            config.put("trim_value", trimValue);  
import java.util.Map;
 *
        assertThat(ingestDocument.getFieldValue("target.arg_first", String.class), equalTo("hello"));  
            config.put("exclude_keys", new ArrayList<>(excludeKeys));
        Exception exception = expectThrows(IllegalArgumentException.class, () -> processor.execute(ingestDocument));
    }
 * KIND, either express or implied.  See the License for the
            random(),
        processor.execute(ingestDocument);
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        String fieldName = RandomDocumentPicks.addRandomField(random(), ingestDocument, "first=hello&second=world&second=universe");  
        Processor processor = createKvProcessor(fieldName, "&", "=", null, Sets.newHashSet("second"), "target", false);
        String field,
        assertThat(ingestDocument.getFieldValue("first", String.class), equalTo("hello"));
import org.opensearch.ingest.TestTemplateService;
        assertFalse(ingestDocument.hasField("target.second"));
    public void test() throws Exception {
public class KeyValueProcessorTests extends OpenSearchTestCase {
        String valueSplit,
            false,
        processor.execute(ingestDocument);
    }  
        assertThat(ingestDocument.getFieldValue("target.relay", String.class), equalTo("mail.example.com[private/dovecot-lmtp]"));
 * under the License.  
        assertThat(ingestDocument.getFieldValue("target.delays", String.class), equalTo("1.9/0.01/0.01/0.21"));
        Set<String> includeKeys,
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());  
        ingestDocument.setFieldValue("first", "first=hello");
            Collections.singletonMap(fieldName, null)  
            random(),
        assertFalse(ingestDocument.hasField("target.second"));
        assertThat(ingestDocument.getFieldValue("target.first", String.class), equalTo("hello"));  
/*  
        assertThat(exception.getMessage(), equalTo("field [unknown] doesn't exist"));  
    public void testTrimMultiCharSequence() throws Exception {
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
            "first=<hello>&second=\"world\"&second=(universe)&third=<foo>&fourth=[bar]&fifth='last'"
 * not use this file except in compliance with the License.
            includeKeys,
        Set<String> excludeKeys,  
    }
            fieldSplit,  
        }
            false  
    public void testNonExistentWithIgnoreMissing() throws Exception {
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    }  
 */
    public void testFailFieldSplitMatch() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        config.put("field", field);  
        }
        if (trimKey != null) {
import java.util.List;  
            ignoreMissing,
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(ingestDocument.getFieldValue("target.to", String.class), equalTo("foo@example.com"));  
        Processor processor = createKvProcessor(fieldName, "&", "=", Sets.newHashSet("first"), null, "target", false);
    }
    private static KeyValueProcessor createKvProcessor(
    }  
            "to=<foo@example.com>, orig_to=<bar@example.com>, %+relay=mail.example.com[private/dovecot-lmtp],"
        String targetField,
import java.util.Collections;
import java.util.Set;
        Processor processor = createKvProcessor("unknown", "&", "=", null, null, "target", false);
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
    }  
        assertIngestDocument(originalIngestDocument, ingestDocument);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
import static org.hamcrest.Matchers.equalTo;
    }  
    }  
        Set<String> includeKeys,
    }
        String fieldName = RandomDocumentPicks.addRandomField(  
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.ingest.common;
        boolean ignoreMissing
    ) throws Exception {  
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());  
            random(),
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
    }
        boolean ignoreMissing,
        config.put("field_split", fieldSplit);
        exception = expectThrows(IllegalArgumentException.class, () -> processorWithEmptyFieldPath.execute(ingestDocument));
        // when using template snippet, the resolved field path maybe empty
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return FACTORY.create(null, randomAlphaOfLength(10), null, config);  
        );  
        assertThat(ingestDocument.getFieldValue("target.fourth", String.class), equalTo("bar"));  
        Map<String, Object> config = new HashMap<>();
        assertFalse(ingestDocument.hasField("target.first"));  
