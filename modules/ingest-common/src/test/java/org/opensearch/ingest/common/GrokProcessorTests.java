            false,
        processor.execute(doc);  
                Collections.singletonList("%{NOTONE:not_one}"),
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        assertEquals("192.168.1.1", ipList.get(0));
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;  
            MatcherWatchdog.noop()
            patternBank,
            Collections.singletonList("%{ONE:one}"),
            fieldName,
import java.util.HashMap;
            null,
            IllegalArgumentException.class,
        assertThat(doc.getFieldValue("second", String.class), equalTo("3"));  
        processor.execute(doc);
        assertEquals("1", numList.get(0));
            Collections.singletonMap("ONE", "1"),
            true,
        assertIngestDocument(originalIngestDocument, ingestDocument);
            fieldName,  
    public void testNullFieldWithIgnoreMissing() throws Exception {  
            false,  
        patternBank.put("ONE", "1");
 * The OpenSearch Contributors require contributions made to  
            fieldName,
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            randomAlphaOfLength(10),
    }
 * specific language governing permissions and limitations
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        assertEquals(3, numList.size());
        assertThat(combined, equalTo("foo"));
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        GrokProcessor processor = new GrokProcessor(
            false,
        assertThat(doc.getFieldValue("two", String.class), equalTo("2"));
            randomAlphaOfLength(10),  
            fieldName,  
            fieldName,
        GrokProcessor processor = new GrokProcessor(
            fieldName,
            "(?<![0-9])(?:(?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5]))(?![0-9])"  
        assertThat(e.getMessage(), equalTo("Unable to find pattern [NOTONE] in Grok's pattern dictionary"));  
        assertThat(doc.getFieldValue("first", String.class), equalTo("1"));  
 * ownership. Elasticsearch licenses this file to you under  
    }  
            null,
        combined = GrokProcessor.combinePatterns(Arrays.asList("foo"), true);
        assertThat(doc.hasField("three"), equalTo(false));  
 * the Apache License, Version 2.0 (the "License"); you may
        patternBank.put("NUMBER", "\\d");
 * Unless required by applicable law or agreed to in writing,
        assertThat(doc.getFieldValue("one", String.class), equalTo("1"));
        );
        );
        GrokProcessor processor = new GrokProcessor(
            patternBank,
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
        Exception e = expectThrows(
        doc.setFieldValue(fieldName, null);
        );
        // Verify that 'num' field contains a list of all matches
        assertThat(numField, instanceOf(List.class));  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
            true,
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] is null, cannot process it."));  
        assertThat(e.getMessage(), equalTo("field [foo] not present as part of path [foo.bar]"));
            randomAlphaOfLength(10),
    }  
            randomAlphaOfLength(10),  
        patternBank.put("NUMBER", "\\d");
        doc.setFieldValue(fieldName, "1 2 3");  
        GrokProcessor processor = new GrokProcessor(  
            null,  
            true,  
            false,  
        );
        );
        assertThat(doc.getFieldValue("second", String.class), equalTo("3"));
        processor.execute(ingestDocument);
    }  
        String numValue = doc.getFieldValue("num", String.class);
            patternBank,  
        GrokProcessor processor = new GrokProcessor(
 * You may obtain a copy of the License at  
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));
        );
        Map<String, String> patternBank = new HashMap<>();
        assertFalse(doc.hasField("first"));
            Collections.emptyMap(),
            randomAlphaOfLength(10),  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    public void testNoMatch() {
            fieldName,  
 * software distributed under the License is distributed on an
        combined = GrokProcessor.combinePatterns(Arrays.asList("foo", "bar"), true);  
            "IP",
/*  
            false,
            randomBoolean(),  
            false,
        assertEquals(2, ipList.size());  
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
    public void testMissingFieldWithIgnoreMissing() throws Exception {
            MatcherWatchdog.noop()
        assertEquals("2", numList.get(1));  
        doc.setFieldValue(fieldName, 1);  
        );  
        patternBank = new HashMap<>();  
    }
            false,
        patternBank.put("ONETWO", "1|2");  
 * GitHub history for details.
            MatcherWatchdog.noop()
import org.opensearch.ingest.IngestDocument;
 */  
        List<String> numList = (List<String>) numField;  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        );
        List<String> ipList = (List<String>) ipField;
        assertThat(doc.hasField("one"), equalTo(false));
    public void testNotStringField() {
        doc.setFieldValue(fieldName, "A");
        assertThat(combined, equalTo(""));  
        processor.execute(ingestDocument);
            randomAlphaOfLength(10),
        assertThat(e.getMessage(), equalTo("Provided Grok expressions do not match field value: [23]"));  
        combined = GrokProcessor.combinePatterns(Arrays.asList(""), true);
    public void testMultiplePatternsWithMatchReturn() throws Exception {
        Object numField = doc.getFieldValue("num", Object.class);
        assertThat(doc.getFieldValue("_ingest._grok_match_index", String.class), equalTo("0"));  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            Collections.singletonMap("ONE", "1"),
            fieldName,  
 * this work for additional information regarding copyright
            fieldName,
/*
        Map<String, String> patternBank = new HashMap<>();
        patternBank.put("ONE", "1");
        GrokProcessor processor = new GrokProcessor(
    }
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));  
        doc.setFieldValue(fieldName, "2");
            fieldName,
        doc.setFieldValue(fieldName, "23");  
            false,
    public void testMissingField() {
        assertThat(doc.getFieldValue("first", String.class), equalTo("1"));
        String fieldName = "value";
            false,  
        );  
        GrokProcessor processor = new GrokProcessor(
            Collections.singletonList("%{ONE:one}"),
        GrokProcessor processor = new GrokProcessor(
            MatcherWatchdog.noop()  
        GrokProcessor processor = new GrokProcessor(  
            randomBoolean(),
        processor.execute(doc);
    }
            false,
            Arrays.asList("%{ONE:one}"),  
            MatcherWatchdog.noop()
    }
    }  
            null,
        GrokProcessor processor = new GrokProcessor(  
        patternBank.put("ONE", "1");  
            randomAlphaOfLength(10),
        doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
                MatcherWatchdog.noop()  
        originalIngestDocument.setFieldValue(fieldName, null);  
            randomAlphaOfLength(10),
            randomAlphaOfLength(10),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(doc.hasField("one"), equalTo(true));
        assertThat(combined, equalTo(""));
            randomBoolean(),
            true,
            false,  
        combined = GrokProcessor.combinePatterns(Arrays.asList("foo"), false);  
            Collections.singletonList("%{ONE:one}"),  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            randomAlphaOfLength(10),  
        GrokProcessor processor = new GrokProcessor(
            false,  
    public void testNotStringFieldWithIgnoreMissing() {  
 * compatible open source license.
    public void testCombinedPatterns() {  
        GrokProcessor processor = new GrokProcessor(
        );
        doc.setFieldValue(fieldName, "23");
            MatcherWatchdog.noop()
        );  
                false,  
            fieldName,
            false,  
            false,  
        patternBank.put("TWO", "2");  
        assertEquals("1", numValue);
            patternBank,
            null,
                false,
            false,
            false,
    public void testSetMetadata() throws Exception {  
            false,
        assertThat(doc.hasField("three"), equalTo(false));
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
            Collections.singletonList("%{NUMBER:num} %{NUMBER:num} %{NUMBER:num}"),  
            Collections.singletonMap("ONE", "1"),  
    }
                fieldName,
            randomBoolean(),
        patternBank.put("THREE", "3");  
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        // Create multiple patterns to match each IP address separately  
    public void testNullField() {
            MatcherWatchdog.noop()
        assertThat(combined, equalTo("foo"));  
        assertIngestDocument(originalIngestDocument, ingestDocument);
            Collections.singletonList("%{ONETWO:first}|%{THREE:second}"),  
        Map<String, String> patternBank = new HashMap<>();
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            false,
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));  
 * license agreements. See the NOTICE file distributed with
            false,
        Map<String, String> patternBank = new HashMap<>();  
                false,
import java.util.Map;
            Collections.singletonList("%{ONETWO:first}%{ONETWO:first}"),
            randomAlphaOfLength(10),
        assertThat(combined, equalTo("(?<_ingest._grok_match_index.0>foo)|(?<_ingest._grok_match_index.1>bar)"));
            false,
        doc.setFieldValue(fieldName, "3");
            false,
/*  
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));
            false,  
            randomBoolean(),  
        doc.setFieldValue(fieldName, "1-3");
            patternBank,
        processor.execute(doc);
            Collections.singletonList("%{ONE:one}"),
        doc.setFieldValue(fieldName, "12");
            MatcherWatchdog.noop()
            MatcherWatchdog.noop()
            false,
            null,  
            null,
        processor.execute(doc);
        String fieldName = "foo.bar";
            fieldName,  
        patternBank.put("THREE", "3");
        String combined;
            false,
    }
            patternBank,
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
        assertThat(doc.hasField("one"), equalTo(false));
 * not use this file except in compliance with the License.
        processor.execute(doc);  
            () -> new GrokProcessor(  
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
            false,
        Object ipField = doc.getFieldValue("ipAddress", Object.class);
            null,  
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));
            false,
            true,  
            null,
        processor = new GrokProcessor(
 * SPDX-License-Identifier: Apache-2.0
            false,
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            false,  
import static org.hamcrest.Matchers.instanceOf;
            false,  
        processor.execute(doc);
            Collections.singletonList(fieldName),  
        );
        patternBank.put("THREE", "3");
 *  
                Collections.singletonMap("ONE", "1"),  
            null,
            Collections.singletonList("%{NUMBER:num} %{NUMBER:num} %{NUMBER:num}"),
        assertEquals("3", numList.get(2));
        assertThat(doc, equalTo(originalDoc));
import static org.hamcrest.Matchers.equalTo;
            Arrays.asList("%{ONE:first}-%{TWO:second}", "%{ONE:first}-%{THREE:second}"),
 * under the License.  
    }  
            null,
package org.opensearch.ingest.common;
            randomAlphaOfLength(10),  
            fieldName,
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
            false,
            Collections.singletonMap("ONE", "1"),
import java.util.Collections;
            null,
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
    }
        );  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            null,
        // Create processor with captureAllMatches=true
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, String> patternBank = new HashMap<>();
        assertThat(ipField, instanceOf(List.class));
 * KIND, either express or implied.  See the License for the
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        GrokProcessor processor = new GrokProcessor(
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
            false,  
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
            null,  
            Collections.singletonMap("ONE", "1"),  
            true,
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));
            fieldName,  
            fieldName,
            fieldName,
        );
                null,
    }  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        String fieldName = RandomDocumentPicks.randomFieldName(random());  
            null,  
    }  
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 */
                randomAlphaOfLength(10),
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        doc.setFieldValue(fieldName, "1");  
            MatcherWatchdog.noop()
        GrokProcessor processor = new GrokProcessor(
            randomAlphaOfLength(10),  
    public void testIgnoreCase() throws Exception {
        doc.setFieldValue(fieldName, "192.168.1.1 172.16.0.1");
            MatcherWatchdog.noop()
    public void testMatchWithoutCaptures() throws Exception {  
public class GrokProcessorTests extends OpenSearchTestCase {
            false,
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
            false,
            Collections.singletonMap("ONE", "1"),
            Arrays.asList("%{ONE:one}", "%{TWO:two}", "%{THREE:three}"),
        GrokProcessor processor = new GrokProcessor(
        assertThat(doc.getFieldValue("a", String.class), equalTo("A"));
            Collections.singletonMap("ONE", "1"),  
        doc.setFieldValue(fieldName, "abc23");  
        );  
            false,
            false,
import org.opensearch.ingest.RandomDocumentPicks;  
        assertThat(doc.getFieldValue("two", String.class), equalTo("2"));  
    public void testCombineSamePatternNameAcrossPatterns() throws Exception {
            null,
            randomBoolean(),
            Arrays.asList("%{ONE:one}", "%{TWO:two}", "%{THREE:three}"),  
 *    http://www.apache.org/licenses/LICENSE-2.0
        processor.execute(doc);
        patternBank.put("THREE", "3");
            MatcherWatchdog.noop()
 *
        patternBank.put("TWO", "2");
    public void testUnmatchedNamesNotIncludedInDocument() throws Exception {
        );
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        doc.setFieldValue(fieldName, "first1");
            randomAlphaOfLength(10),
    }
import org.opensearch.grok.MatcherWatchdog;
    }
            false,
        originalDoc.setFieldValue(fieldName, fieldName);  
            true,  
        // Verify that 'ipAddress' field contains a list of all IP addresses  
            false,  
        String fieldName = "foo.bar";
            null,
            null,  
            randomAlphaOfLength(10),
        // Create processor with captureAllMatches=false (default behavior)  
        Map<String, String> patternBank = new HashMap<>();  
        processor.execute(doc);
    public void testNoMatchingPatternName() {  
            null,  
            false,  
    }
        processor.execute(doc);
        );  
            Collections.singletonList("(?<a>(?i)A)"),  
 */  
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        patternBank.put(
    public void testFirstWinNamedCapture() throws Exception {
            Collections.singletonList("%{ONE:one}"),  
        patternBank.put("ONETWO", "1|2");  
            randomAlphaOfLength(10),  
        doc.setFieldValue(fieldName, "1 2 3");
        Map<String, String> patternBank = new HashMap<>();
            Collections.singletonList("%{ONE:one}"),
            false,
            fieldName,
            fieldName,
        GrokProcessor processor = new GrokProcessor(
        assertThat(combined, equalTo("(?:foo)|(?:bar)"));
    public void testTraceWithOnePattern() throws Exception {
            MatcherWatchdog.noop()  
        );  
            MatcherWatchdog.noop()
 * this file be licensed under the Apache-2.0 license or a
            false,
        IngestDocument doc = new IngestDocument(originalDoc);
        fieldName = RandomDocumentPicks.randomFieldName(random());  
            Collections.singletonList("%{IP:ipAddress} (%{IP:ipAddress})?"),
    public void testMatch() throws Exception {  
        IngestDocument originalDoc = new IngestDocument(new HashMap<>(), new HashMap<>());
            randomAlphaOfLength(10),  
        );  
    }
            Collections.singletonMap("ONE", "1"),
        Map<String, String> patternBank = new HashMap<>();  
            MatcherWatchdog.noop()  
        // Verify that only the first match is captured  
import org.opensearch.test.OpenSearchTestCase;
            false,  
        @SuppressWarnings("unchecked")
            MatcherWatchdog.noop()  
            fieldName,  
        processor.execute(doc);  
            Collections.emptyMap(),
            MatcherWatchdog.noop()
        @SuppressWarnings("unchecked")
        processor.execute(doc);
            patternBank,
    public void testCaptureAllMatchesWithSameFieldName() throws Exception {  
            Collections.singletonList("%{ONE:one}"),
    }
 * Licensed to Elasticsearch under one or more contributor  
            Collections.singletonList("%{ONE:one}"),
            patternBank,
        );
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());  
        combined = GrokProcessor.combinePatterns(Arrays.asList(""), false);
            MatcherWatchdog.noop()
        String fieldName = RandomDocumentPicks.randomFieldName(random());
 *
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
}
            randomAlphaOfLength(10),
        patternBank.put("ONE", "1");
        doc.setFieldValue(fieldName, 1);
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));  
            MatcherWatchdog.noop()
            false,
        GrokProcessor processor = new GrokProcessor(  
        combined = GrokProcessor.combinePatterns(Arrays.asList("foo", "bar"), false);
            randomAlphaOfLength(10),
import java.util.Arrays;  
        patternBank.put("TWO", "2");
        assertEquals("172.16.0.1", ipList.get(1));
        );
            )
            patternBank,
        GrokProcessor processor = new GrokProcessor(
        assertThat(doc.getFieldValue("_ingest._grok_match_index", String.class), equalTo("1"));
            false,
            false,
import java.util.List;  
    public void testCaptureAllMatchesDisabled() throws Exception {
