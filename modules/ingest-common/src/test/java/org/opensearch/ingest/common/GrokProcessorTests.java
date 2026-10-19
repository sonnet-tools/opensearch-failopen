        assertThat(doc.getFieldValue("two", String.class), equalTo("2"));
    }
            MatcherWatchdog.noop()
            fieldName,
    }
            Collections.singletonList("%{ONETWO:first}|%{THREE:second}"),
            patternBank,
    public void testNotStringFieldWithIgnoreMissing() {
            false,
            true,
    }
 * Licensed to Elasticsearch under one or more contributor
        assertThat(e.getMessage(), equalTo("Unable to find pattern [NOTONE] in Grok's pattern dictionary"));
                false,
        String fieldName = "foo.bar";
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        GrokProcessor processor = new GrokProcessor(
            false,
        doc.setFieldValue(fieldName, "abc23");
        doc.setFieldValue(fieldName, "12");
            null,
            Collections.singletonMap("ONE", "1"),
            Collections.emptyMap(),
            true,
            null,
        doc.setFieldValue(fieldName, "23");
            Collections.singletonMap("ONE", "1"),
            false,
            null,
            MatcherWatchdog.noop()
    public void testCaptureAllMatchesWithSameFieldName() throws Exception {
            MatcherWatchdog.noop()
 */
        combined = GrokProcessor.combinePatterns(Arrays.asList("foo"), false);
 * GitHub history for details.
            randomAlphaOfLength(10),
        Exception e = expectThrows(
        patternBank.put("THREE", "3");
            Collections.singletonList("%{ONE:one}"),
            true,
        combined = GrokProcessor.combinePatterns(Arrays.asList("foo"), true);
            fieldName,
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));
    }
import java.util.List;
            Collections.singletonMap("ONE", "1"),
        processor.execute(doc);
            randomAlphaOfLength(10),
            Collections.singletonList("%{ONETWO:first}%{ONETWO:first}"),
import org.opensearch.grok.MatcherWatchdog;
        assertThat(doc.hasField("one"), equalTo(false));
    public void testNullField() {
        combined = GrokProcessor.combinePatterns(Arrays.asList(""), true);
    }
        patternBank.put("THREE", "3");
        patternBank.put("THREE", "3");
        assertThat(combined, equalTo("foo"));
        assertThat(doc.hasField("three"), equalTo(false));
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));
            null,
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            patternBank,
        @SuppressWarnings("unchecked")
import java.util.Map;
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        processor.execute(doc);
        assertThat(doc, equalTo(originalDoc));
public class GrokProcessorTests extends OpenSearchTestCase {
            false,
            false,
            MatcherWatchdog.noop()
        assertThat(doc.getFieldValue("second", String.class), equalTo("3"));
    }
        doc.setFieldValue(fieldName, "first1");
            fieldName,
    }
    }
            Collections.singletonList("%{NUMBER:num} %{NUMBER:num} %{NUMBER:num}"),
            false,
            randomAlphaOfLength(10),
            false,
}
        doc.setFieldValue(fieldName, "23");
        );
    }
        combined = GrokProcessor.combinePatterns(Arrays.asList("foo", "bar"), false);
            fieldName,
            MatcherWatchdog.noop()
        assertEquals(2, ipList.size());
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            randomAlphaOfLength(10),
            MatcherWatchdog.noop()
            randomAlphaOfLength(10),
        // Create processor with captureAllMatches=false (default behavior)
            null,
        doc.setFieldValue(fieldName, "1 2 3");
            false,
 * software distributed under the License is distributed on an
            false,
                fieldName,
            fieldName,
    }
 * Unless required by applicable law or agreed to in writing,
            Arrays.asList("%{ONE:one}"),
            null,
        String fieldName = "foo.bar";
        String combined;
            Collections.emptyMap(),
            "IP",
        // Verify that only the first match is captured
/*
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            randomBoolean(),
        assertThat(e.getMessage(), equalTo("field [foo] not present as part of path [foo.bar]"));
        originalDoc.setFieldValue(fieldName, fieldName);
        patternBank = new HashMap<>();
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
            false,
 * this work for additional information regarding copyright
            randomAlphaOfLength(10),
import static org.hamcrest.Matchers.instanceOf;
        assertThat(combined, equalTo(""));
        processor.execute(doc);
    }
    public void testFirstWinNamedCapture() throws Exception {
            patternBank,
        patternBank.put("TWO", "2");
            false,
            false,
            fieldName,
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        );
            randomAlphaOfLength(10),
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    }
import static org.hamcrest.Matchers.equalTo;
 * ownership. Elasticsearch licenses this file to you under
        processor.execute(doc);
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            patternBank,
            patternBank,
        assertThat(doc.getFieldValue("one", String.class), equalTo("1"));
            randomAlphaOfLength(10),
        patternBank.put("ONETWO", "1|2");
    }
                MatcherWatchdog.noop()
        processor.execute(doc);
        );
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] is null, cannot process it."));
        );
            false,
            )
            false,
 * compatible open source license.
        assertThat(combined, equalTo("foo"));
            false,
            null,
        doc.setFieldValue(fieldName, "1 2 3");
        processor.execute(doc);
            fieldName,
        assertThat(doc.getFieldValue("a", String.class), equalTo("A"));
        );
        );
    public void testNullFieldWithIgnoreMissing() throws Exception {
        );
        processor.execute(ingestDocument);
            randomAlphaOfLength(10),
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            false,
import java.util.Collections;
            fieldName,
        patternBank.put(
        assertThat(doc.getFieldValue("first", String.class), equalTo("1"));
        Map<String, String> patternBank = new HashMap<>();
                Collections.singletonList("%{NOTONE:not_one}"),
            MatcherWatchdog.noop()
        doc.setFieldValue(fieldName, "1");
 * this file be licensed under the Apache-2.0 license or a
            Collections.singletonList("%{ONE:one}"),
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    public void testMissingField() {
            true,
        );
            null,
            randomAlphaOfLength(10),
            MatcherWatchdog.noop()
            false,
        processor.execute(doc);
package org.opensearch.ingest.common;
            MatcherWatchdog.noop()
        Object ipField = doc.getFieldValue("ipAddress", Object.class);
        assertThat(combined, equalTo("(?:foo)|(?:bar)"));
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            Arrays.asList("%{ONE:one}", "%{TWO:two}", "%{THREE:three}"),
        GrokProcessor processor = new GrokProcessor(
        processor.execute(doc);
        GrokProcessor processor = new GrokProcessor(
            randomAlphaOfLength(10),
            Collections.singletonList("%{IP:ipAddress} (%{IP:ipAddress})?"),
        );
        patternBank.put("THREE", "3");
            false,
 *    http://www.apache.org/licenses/LICENSE-2.0
            false,
            MatcherWatchdog.noop()
import java.util.HashMap;
        assertThat(doc.getFieldValue("two", String.class), equalTo("2"));
import org.opensearch.test.OpenSearchTestCase;
            false,
/*
            Collections.singletonList("%{ONE:one}"),
        );
        patternBank.put("NUMBER", "\\d");
            Collections.singletonList("%{ONE:one}"),
        );
            Collections.singletonList("%{ONE:one}"),
        assertThat(doc.getFieldValue("_ingest._grok_match_index", String.class), equalTo("0"));
            MatcherWatchdog.noop()
            randomBoolean(),
                randomAlphaOfLength(10),
            randomAlphaOfLength(10),
        GrokProcessor processor = new GrokProcessor(
        doc.setFieldValue(fieldName, null);
            randomAlphaOfLength(10),
 * the Apache License, Version 2.0 (the "License"); you may
    public void testTraceWithOnePattern() throws Exception {
            Collections.singletonMap("ONE", "1"),
    }
        Map<String, String> patternBank = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
        patternBank.put("ONE", "1");
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        processor = new GrokProcessor(
        IngestDocument originalDoc = new IngestDocument(new HashMap<>(), new HashMap<>());
        );
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        Map<String, String> patternBank = new HashMap<>();
        patternBank.put("ONE", "1");
        Map<String, String> patternBank = new HashMap<>();
    }
 * Modifications Copyright OpenSearch Contributors. See
            fieldName,
        originalIngestDocument.setFieldValue(fieldName, null);
 * SPDX-License-Identifier: Apache-2.0
    public void testCaptureAllMatchesDisabled() throws Exception {
        assertThat(doc.hasField("one"), equalTo(false));
        );
        String fieldName = RandomDocumentPicks.randomFieldName(random());
            false,
        GrokProcessor processor = new GrokProcessor(
            patternBank,
            false,
            false,
        GrokProcessor processor = new GrokProcessor(
            patternBank,
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            randomAlphaOfLength(10),
            false,
        assertIngestDocument(originalIngestDocument, ingestDocument);
        GrokProcessor processor = new GrokProcessor(
            Collections.singletonMap("ONE", "1"),
    }
            null,
        GrokProcessor processor = new GrokProcessor(
        // Create multiple patterns to match each IP address separately
    public void testUnmatchedNamesNotIncludedInDocument() throws Exception {
        doc.setFieldValue(fieldName, "A");
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        Map<String, String> patternBank = new HashMap<>();
        GrokProcessor processor = new GrokProcessor(
            Collections.singletonMap("ONE", "1"),
            randomBoolean(),
            fieldName,
        doc.setFieldValue(fieldName, 1);
            "(?<![0-9])(?:(?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5]))(?![0-9])"
            true,
            false,
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        List<String> numList = (List<String>) numField;
    }
            Collections.singletonList(fieldName),
 * not use this file except in compliance with the License.
        patternBank.put("NUMBER", "\\d");
            fieldName,
        assertThat(numField, instanceOf(List.class));
            randomBoolean(),
            randomAlphaOfLength(10),
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
        assertThat(e.getMessage(), equalTo("Provided Grok expressions do not match field value: [23]"));
        assertEquals("1", numList.get(0));
            () -> new GrokProcessor(
            Collections.singletonList("%{ONE:one}"),
        );
        Map<String, String> patternBank = new HashMap<>();
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));
            randomAlphaOfLength(10),
            Collections.singletonMap("ONE", "1"),
                false,
        GrokProcessor processor = new GrokProcessor(
        assertEquals(3, numList.size());
            false,
    public void testIgnoreCase() throws Exception {
            false,
            Collections.singletonList("%{ONE:one}"),
        combined = GrokProcessor.combinePatterns(Arrays.asList(""), false);
            fieldName,
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        );
            MatcherWatchdog.noop()
            patternBank,
            false,
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    public void testMatchWithoutCaptures() throws Exception {
            false,
        assertEquals("192.168.1.1", ipList.get(0));
        processor.execute(doc);
    public void testNotStringField() {
            MatcherWatchdog.noop()
        Exception e = expectThrows(Exception.class, () -> processor.execute(doc));
        assertEquals("1", numValue);
            IllegalArgumentException.class,
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        processor.execute(doc);
        Object numField = doc.getFieldValue("num", Object.class);
import java.util.Arrays;
        Map<String, String> patternBank = new HashMap<>();
        IngestDocument doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            MatcherWatchdog.noop()
            false,
        );
            null,
        assertThat(doc.hasField("three"), equalTo(false));
        assertThat(doc.getFieldValue("first", String.class), equalTo("1"));
            fieldName,
        processor.execute(doc);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertThat(doc.getFieldValue("second", String.class), equalTo("3"));
            false,
            null,
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        );
        assertThat(combined, equalTo(""));
        processor.execute(doc);
            MatcherWatchdog.noop()
        );
        // Verify that 'num' field contains a list of all matches
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
    }
        assertEquals("2", numList.get(1));
        GrokProcessor processor = new GrokProcessor(
        );
        patternBank.put("ONE", "1");
        assertEquals("3", numList.get(2));
        GrokProcessor processor = new GrokProcessor(
            Collections.singletonMap("ONE", "1"),
        IngestDocument doc = new IngestDocument(originalDoc);
        GrokProcessor processor = new GrokProcessor(
        GrokProcessor processor = new GrokProcessor(
            false,
            randomAlphaOfLength(10),
        doc = RandomDocumentPicks.randomIngestDocument(random(), new HashMap<>());
            fieldName,
        patternBank.put("TWO", "2");
        assertThat(combined, equalTo("(?<_ingest._grok_match_index.0>foo)|(?<_ingest._grok_match_index.1>bar)"));
            null,
            Collections.singletonList("%{NUMBER:num} %{NUMBER:num} %{NUMBER:num}"),
        GrokProcessor processor = new GrokProcessor(
            false,
        doc.setFieldValue(fieldName, "1-3");
    public void testCombinedPatterns() {
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        String numValue = doc.getFieldValue("num", String.class);
            MatcherWatchdog.noop()
            randomBoolean(),
        processor.execute(ingestDocument);
            fieldName,
            Collections.singletonList("(?<a>(?i)A)"),
        fieldName = RandomDocumentPicks.randomFieldName(random());
        List<String> ipList = (List<String>) ipField;
                Collections.singletonMap("ONE", "1"),
    public void testNoMatch() {
 * You may obtain a copy of the License at
            null,
    }
        assertThat(doc.hasField("one"), equalTo(true));
            Collections.singletonList("%{ONE:one}"),
    public void testNoMatchingPatternName() {
            false,
                null,
        // Create processor with captureAllMatches=true
            fieldName,
            MatcherWatchdog.noop()
        Map<String, String> patternBank = new HashMap<>();
            false,
        assertEquals("172.16.0.1", ipList.get(1));
 * KIND, either express or implied.  See the License for the
        doc.setFieldValue(fieldName, 1);
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        );
                false,
 * specific language governing permissions and limitations
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
    public void testMissingFieldWithIgnoreMissing() throws Exception {
 */
            MatcherWatchdog.noop()
import org.opensearch.ingest.IngestDocument;
            MatcherWatchdog.noop()
        assertFalse(doc.hasField("first"));
            null,
            true,
 *
            false,
            randomAlphaOfLength(10),
            fieldName,
        assertThat(doc.getFieldValue("_ingest._grok_match_index", String.class), equalTo("1"));
            null,
            Arrays.asList("%{ONE:first}-%{TWO:second}", "%{ONE:first}-%{THREE:second}"),
            null,
            fieldName,
        patternBank.put("ONETWO", "1|2");
        GrokProcessor processor = new GrokProcessor(
        assertIngestDocument(originalIngestDocument, ingestDocument);
            fieldName,
 * license agreements. See the NOTICE file distributed with
    public void testMatch() throws Exception {
/*
 */
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    }
 * under the License.
            false,
        );
        doc.setFieldValue(fieldName, "2");
 *
        patternBank.put("ONE", "1");
            false,
        assertThat(ipField, instanceOf(List.class));
            false,
            null,
        doc.setFieldValue(fieldName, "3");
    public void testMultiplePatternsWithMatchReturn() throws Exception {
import org.opensearch.ingest.RandomDocumentPicks;
        String fieldName = RandomDocumentPicks.randomFieldName(random());
        assertThat(e.getMessage(), equalTo("field [" + fieldName + "] of type [java.lang.Integer] cannot be cast to [java.lang.String]"));
    public void testCombineSamePatternNameAcrossPatterns() throws Exception {
        // Verify that 'ipAddress' field contains a list of all IP addresses
        String fieldName = "value";
            randomBoolean(),
            null,
            false,
            false,
        combined = GrokProcessor.combinePatterns(Arrays.asList("foo", "bar"), true);
            false,
            randomAlphaOfLength(10),
        GrokProcessor processor = new GrokProcessor(
        String fieldName = RandomDocumentPicks.randomFieldName(random());
    public void testSetMetadata() throws Exception {
            null,
        patternBank.put("TWO", "2");
        GrokProcessor processor = new GrokProcessor(
            Arrays.asList("%{ONE:one}", "%{TWO:two}", "%{THREE:three}"),
        doc.setFieldValue(fieldName, "192.168.1.1 172.16.0.1");
            patternBank,
        @SuppressWarnings("unchecked")
            false,
 *
            false,
            true,
