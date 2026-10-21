    }
import java.util.Base64;
        assertThat(attachmentData.get("content_length"), is(10L));
        );
            containsInAnyOrder("language", "content", "author", "keywords", "title", "content_type", "content_length")
import static org.hamcrest.Matchers.notNullValue;
import org.apache.commons.io.IOUtils;
 */
            randomAlphaOfLength(10),
 * You may obtain a copy of the License at
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
package org.opensearch.ingest.attachment;
        assertIngestDocument(originalIngestDocument, ingestDocument);
        assertThat(attachmentData.get("language"), is("en"));
        Map<String, Object> attachmentData = parseDocument("htmlWithEmptyDateMeta.html", processor);
            "target_field",
import static org.hamcrest.Matchers.hasItem;
    }
        );
    public void testXHtmlDocument() throws Exception {
            EnumSet.allOf(AttachmentProcessor.Property.class),
        ArrayList<AttachmentProcessor.Property> fieldsList = new ArrayList<>(
            "target_field",
        assertThat(
        }
    public void testEpubDocument() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return parseDocument(file, processor, new HashMap<>());
    public void testUnknownLanguageDocument() throws Exception {
        Map<String, Object> attachmentData = parseDocument("issue-22077.vsdx", processor);
            attachmentData.keySet(),
                return bytes;
        assertThat(attachmentData.get("content_length"), is(0L));
    public void testAsciidocDocument() throws Exception {
            } else {
            "target_field",
            19,
    public void testNonExistentWithoutIgnoreMissing() throws Exception {
            null
            random(),
        assertThat(attachmentData.get("content"), is("\"God Save"));
        assertThat(attachmentData.get("author"), is(notNullValue()));
import org.junit.Before;
        }
        }
        assertThat(attachmentData.keySet(), not(hasItem("language")));
        Map<String, Object> attachmentData = parseDocument("test.pdf", processor);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        byte[] bytes;
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
    }
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
    public void testWordDocumentWithVisioSchema() throws Exception {
    }
        assertThat(attachmentData.get("content").toString(), containsString("Table of Contents"));
    public void testFrenchTextDocument() throws Exception {
    public void testIndexedChars() throws Exception {
            attachmentData.get("content_type").toString(),
        assertThat(attachmentData.get("date"), is("2012-10-12T11:17:00Z"));
import org.opensearch.OpenSearchParseException;
/*
        parseDocument("bad_tika.zip", processor);
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            attachmentData.keySet(),
        assertThat(attachmentData.get("content_type").toString(), is("application/msword"));
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            null,
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
            "source_field",
import java.util.EnumSet;
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertThat(attachmentData.get("content_length"), is(19L));
        );
        assertThat(
            false,
 * ownership. Elasticsearch licenses this file to you under
        assertThat(attachmentData.get("language"), is("en"));
        processor.execute(ingestDocument);
        assertThat(e.getDetailedMessage(), containsString("document is encrypted"));
 * under the License.
    private AttachmentProcessor processor;
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
            10000,
        assertThat(attachmentData.get("language"), is("en"));
    }
            false,
import org.opensearch.ingest.IngestDocument;
    public void testParseAsBytesArray() throws Exception {
 */
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
        assertThat(attachmentData.get("content_type").toString(), containsString("application/epub+zip"));
    private Object getAsBinaryOrBase64(String filename) throws Exception {
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> parseDocument("encrypted.pdf", processor));
        assertThat(attachmentData.get("language"), is("en"));
import java.util.Collections;
            is("This is a test, with umlauts, from München\n\nAlso contains newlines for testing.\n\nAnd one more.")
    public void testEncryptedPdf() throws Exception {
        // Note - this output is non-deterministic across library versions
            "source_field",
            Collections.singletonMap("source_field", null)
            "source_field",
            selectedFieldNames[i] = property.toLowerCase();
        assertIngestDocument(originalIngestDocument, ingestDocument);
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
            byte bytes[] = IOUtils.toByteArray(is);
        processor.execute(ingestDocument);
        );
        assertThat(attachmentData.get("content_length"), is(19L));
        assertThat(attachmentData.get("content_type").toString(), containsString("application/xhtml+xml"));
            EnumSet.allOf(AttachmentProcessor.Property.class),
            attachmentData.get("content"),
        assertThat(attachmentData.get("content"), nullValue());
    public void createStandardProcessor() {
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
        assertThat(attachmentData.get("language"), is("fr"));
            Collections.singletonMap("source_field", null)
    public void testNonExistentWithIgnoreMissing() throws Exception {
            // behave like CBOR from time to time
        assertThat(attachmentData.keySet(), containsInAnyOrder("content", "language", "date", "author", "content_type", "content_length"));
        assertThat(attachmentData.get("content_type").toString(), is("application/pdf"));
            null,
    // about the issue that causes a zip file to hang in Tika versions prior to 1.18.
            bytes = IOUtils.toByteArray(is);
/*
 * Modifications Copyright OpenSearch Contributors. See
        );
import static org.hamcrest.Matchers.containsString;
        assertThat(exception.getMessage(), equalTo("field [source_field] not present as part of path [source_field]"));
                return Base64.getEncoder().encodeToString(bytes);
    }
            is("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
 * this file be licensed under the Apache-2.0 license or a
    }
            false,
        processor = new AttachmentProcessor(
        assertThat(attachmentData.get("language"), is("sl"));
    }
        String[] selectedFieldNames = new String[numFields];
import java.util.Set;
        throws Exception {
    private Map<String, Object> parseDocument(String file, AttachmentProcessor processor) throws Exception {
        @SuppressWarnings("unchecked")
    public void testHtmlDocument() throws Exception {
        Map<String, Object> attachmentData = parseDocument("testEPUB.epub", processor);
 *
            null,
            randomAlphaOfLength(10),
    @Before
    }
    }
            randomAlphaOfLength(10),
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
            10000,
        assertThat(attachmentData.keySet(), hasSize(selectedFieldNames.length));
        Map<String, Object> attachmentData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
        assertThat(attachmentData.get("language"), is("en"));
 * GitHub history for details.
        assertThat(attachmentData.get("author"), is("Windows User"));
        // date is not present in the html doc
    }
        try (InputStream is = AttachmentProcessorTests.class.getResourceAsStream(path)) {
    }
        document.putAll(optionalFields);
        assertThat(attachmentData.get("content").toString(), containsString("Table of Contents"));
 *
import java.util.ArrayList;
        );
        Map<String, Object> attachmentData = parseDocument("text-empty.txt", processor);
        processor = new AttachmentProcessor(
        Map<String, Object> document = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor
        assertThat(attachmentData.get("keywords"), is("opensearch,cool,bonsai"));
import static org.hamcrest.Matchers.is;
    }
        assertThat(attachmentData.get("language"), not(is("en")));
import java.util.HashSet;
        for (int i = 0; i < numFields; i++) {
            19,
        assertThat(attachmentData.get("content_type").toString(), containsString("text/html"));
            }
import org.opensearch.ingest.RandomDocumentPicks;
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
        assertThat(attachmentData.get("content"), is("\"God Save the Queen\" (alternatively \"God Save the King\""));
        processor.execute(ingestDocument);
        Map<String, Object> attachmentData = parseDocument("issue-22077.docx", processor);
    public void testWordDocument() throws Exception {
        Set<AttachmentProcessor.Property> selectedProperties = new HashSet<>();
import java.util.HashMap;
        assertThat(attachmentData.get("language"), is("en"));
    }
    public void testLegacyWordDocumentWithVisioSchema() throws Exception {
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
        Processor processor = new AttachmentProcessor(randomAlphaOfLength(10), null, "source_field", "randomTarget", null, 10, true, null);
        assertThat(attachmentData.keySet(), containsInAnyOrder(selectedFieldNames));
            null,
            randomAlphaOfLength(10),
    }
                property = randomFrom(fieldsList);
    public void testEnglishTextDocument() throws Exception {
import static org.hamcrest.Matchers.containsInAnyOrder;
        @SuppressWarnings("unchecked")
    public void testHtmlDocumentWithRandomFields() throws Exception {
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content_type", "content", "content_length"));
        Map<String, Object> attachmentData = parseDocument("text-in-french.txt", processor);
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
 * license agreements. See the NOTICE file distributed with
        );
    private Map<String, Object> parseDocument(String file, AttachmentProcessor processor, Map<String, Object> optionalFields)
        Map<String, Object> attachmentData = parseDocument("text-in-english.txt", processor);
    }
    // See (https://issues.apache.org/jira/browse/COMPRESS-432) for information
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
 * Unless required by applicable law or agreed to in writing,
    }
        int numFields = randomIntBetween(1, fieldsList.size());
        Map<String, Object> attachmentData = parseDocument("text-in-english.txt", processor);
    }
            "max_length"
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
        attachmentData = parseDocument("text-in-english.txt", processor, Collections.singletonMap("max_length", 100));
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "author", "title", "content_type", "content_length"));
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
    }
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
import static org.hamcrest.Matchers.hasSize;
        String path = "/org/opensearch/ingest/attachment/test/sample-files/" + filename;
        assertThat(attachmentData.keySet(), hasItem("language"));
        Map<String, Object> attachmentData = parseDocument("htmlWithEmptyDateMeta.html", processor);
        );
}
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
            AttachmentProcessor.Property property;
    public void testNullWithoutIgnoreMissing() throws Exception {
        );
            "source_field",
        assertThat(attachmentData.get("content"), is("\"God Save the Queen\" (alternatively \"God Save the King\""));
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        document.put("source_field", bytes);
        assertThat(attachmentData.get("content"), is("\"God Save the Queen\" (alternatively \"God Save the King\""));
            containsInAnyOrder("language", "content", "author", "title", "content_type", "content_length", "date", "keywords")
            null
        try (InputStream is = AttachmentProcessorTests.class.getResourceAsStream(path)) {
        assertThat(attachmentData.keySet(), containsInAnyOrder("content", "language", "date", "author", "content_type", "content_length"));
        assertThat(attachmentData.get("content_type"), is("application/vnd.ms-visio.drawing"));
 * compatible open source license.
    }
        assertThat(exception.getMessage(), equalTo("field [source_field] is null, cannot parse."));
        );
            EnumSet.complementOf(EnumSet.of(AttachmentProcessor.Property.DATE))
    // no real detection, just rudimentary
        assertThat(attachmentData.keySet(), hasItem("language"));
        assertThat(attachmentData.get("content"), is("\"God Save the Queen"));
    public void testEmptyTextDocument() throws Exception {
        assertThat(attachmentData.get("language"), is("en"));
    }
    }
            attachmentData.get("content_type").toString(),
            null
        );
            selectedProperties,
        Processor processor = new AttachmentProcessor(randomAlphaOfLength(10), null, "source_field", "randomTarget", null, 10, false, null);
        Map<String, Object> document = new HashMap<>();
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
            do {
import static org.hamcrest.Matchers.not;
        document.put("source_field", getAsBinaryOrBase64(file));
        // Language detection is not accurate when the text to analyze is short
import static org.hamcrest.Matchers.nullValue;
        Map<String, Object> attachmentData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
        processor.execute(ingestDocument);
        assertThat(attachmentData.get("date"), is("2015-01-06T18:07:00Z"));
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
 * not use this file except in compliance with the License.
    }
            random(),
    }
        String path = "/org/opensearch/ingest/attachment/test/sample-files/text-in-english.txt";
 */
import java.util.Map;
        processor = new AttachmentProcessor(
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
        attachmentData = parseDocument("text-in-english.txt", processor);
        assertThat(
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
    public void testVisioIsExcluded() throws Exception {
        assertThat(attachmentData.get("content"), is(notNullValue()));
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
        Processor processor = new AttachmentProcessor(randomAlphaOfLength(10), null, "source_field", "randomTarget", null, 10, false, null);
        Map<String, Object> attachmentData = parseDocument("issue-104.docx", processor);
        return attachmentData;
        if (randomBoolean()) {
            false,
            } while (selectedProperties.add(property) == false);
 * The OpenSearch Contributors require contributions made to
        Processor processor = new AttachmentProcessor(randomAlphaOfLength(10), null, "source_field", "randomTarget", null, 10, true, null);
/*
        Map<String, Object> attachmentData = parseDocument("testXHTML.html", processor);
        assertThat(
import org.opensearch.test.OpenSearchTestCase;
            EnumSet.allOf(AttachmentProcessor.Property.class),
import org.opensearch.ingest.Processor;
    public void testNullValueWithIgnoreMissing() throws Exception {
        attachmentData = parseDocument("text-in-english.txt", processor, Collections.singletonMap("max_length", 10));
        );
        assertThat(attachmentData.get("language"), is("en"));
        assertThat(attachmentData.get("author"), is("foobar"));
 *
            selectedProperties.add(AttachmentProcessor.Property.DATE);
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
        Map<String, Object> attachmentData = parseDocument("asciidoc.asciidoc", processor);
        assertThat(attachmentData.get("date"), is("2016-12-16T15:04:00Z"));
            if (rarely()) {
        assertThat(attachmentData.get("language"), is("en"));
    }
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
public class AttachmentProcessorTests extends OpenSearchTestCase {
            is("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
        Map<String, Object> attachmentData = parseDocument("issue-22077.doc", processor);
        }
    public void testPdf() throws Exception {
    public void testZipFileDoesNotHang() throws Exception {
        assertThat(attachmentData.get("content"), is("\"God Save the Queen"));
        assertThat(
        processor = new AttachmentProcessor(
        assertThat(attachmentData.get("title"), is("Hello"));
        assertThat(attachmentData.get("author"), is(notNullValue()));
 * this work for additional information regarding copyright
        assertThat(attachmentData.get("content"), is(notNullValue()));
import java.io.InputStream;
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
            "target_field",
        assertThat(attachmentData.get("content_length"), is(56L));
        assertThat(attachmentData.keySet(), containsInAnyOrder("content", "language", "date", "author", "content_type", "content_length"));
        Map<String, Object> attachmentData = parseDocument("text-gibberish.txt", processor);
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
    }
import static org.hamcrest.Matchers.equalTo;
