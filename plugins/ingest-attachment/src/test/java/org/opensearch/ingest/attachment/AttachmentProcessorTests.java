import java.io.InputStream;  
        assertThat(attachmentData.keySet(), containsInAnyOrder("content", "language", "date", "author", "content_type", "content_length"));  
 * software distributed under the License is distributed on an
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));  
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Object> document = new HashMap<>();
            "source_field",  
            "source_field",  
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));  
                return bytes;
            null
    public void testEpubDocument() throws Exception {  
            bytes = IOUtils.toByteArray(is);
        assertThat(attachmentData.get("content_type").toString(), is("application/msword"));  
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
            randomAlphaOfLength(10),  
        attachmentData = parseDocument("text-in-english.txt", processor);
        assertThat(attachmentData.get("content_length"), is(56L));
    public void testWordDocumentWithVisioSchema() throws Exception {  
            AttachmentProcessor.Property property;
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
 * not use this file except in compliance with the License.
        assertThat(attachmentData.get("language"), is("en"));
        processor.execute(ingestDocument);  
        assertThat(attachmentData.get("date"), is("2016-12-16T15:04:00Z"));  
import java.util.Collections;  
        Map<String, Object> attachmentData = parseDocument("htmlWithEmptyDateMeta.html", processor);
            EnumSet.allOf(AttachmentProcessor.Property.class),
            EnumSet.allOf(AttachmentProcessor.Property.class),
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));  
    public void testFrenchTextDocument() throws Exception {
        assertThat(attachmentData.get("language"), is("en"));
        assertThat(attachmentData.get("language"), is("en"));
import static org.hamcrest.Matchers.not;
        ArrayList<AttachmentProcessor.Property> fieldsList = new ArrayList<>(  
    }
    private Object getAsBinaryOrBase64(String filename) throws Exception {
        assertThat(attachmentData.keySet(), containsInAnyOrder("content", "language", "date", "author", "content_type", "content_length"));  
import java.util.Map;
    }  
/*  
        assertThat(attachmentData.get("content"), is(notNullValue()));  
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> attachmentData = parseDocument("text-gibberish.txt", processor);  
        );  
        assertThat(attachmentData.get("content_length"), is(19L));
        String path = "/org/opensearch/ingest/attachment/test/sample-files/" + filename;
            Collections.singletonMap("source_field", null)  
        parseDocument("bad_tika.zip", processor);  
            selectedProperties,
            19,
        );
    }
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
package org.opensearch.ingest.attachment;
    }
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
            attachmentData.get("content_type").toString(),
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());
        assertThat(attachmentData.get("content_type").toString(), containsString("text/html"));
    public void testNonExistentWithIgnoreMissing() throws Exception {
        try (InputStream is = AttachmentProcessorTests.class.getResourceAsStream(path)) {  
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        assertThat(attachmentData.get("content_type").toString(), containsString("application/xhtml+xml"));  
        document.put("source_field", getAsBinaryOrBase64(file));
        assertThat(attachmentData.keySet(), hasItem("language"));
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
        OpenSearchParseException e = expectThrows(OpenSearchParseException.class, () -> parseDocument("encrypted.pdf", processor));  
 * Unless required by applicable law or agreed to in writing,
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        processor = new AttachmentProcessor(  
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
        assertThat(  
 * the Apache License, Version 2.0 (the "License"); you may
        processor.execute(ingestDocument);
    }
        Map<String, Object> attachmentData = parseDocument("issue-22077.vsdx", processor);
        assertThat(attachmentData.get("author"), is(notNullValue()));
        assertThat(attachmentData.get("author"), is(notNullValue()));
        assertThat(
    public void testEnglishTextDocument() throws Exception {  
        assertThat(attachmentData.get("language"), is("en"));
 * ownership. Elasticsearch licenses this file to you under  
            do {  
    public void testEncryptedPdf() throws Exception {
            attachmentData.get("content_type").toString(),
            "source_field",
            is("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    // about the issue that causes a zip file to hang in Tika versions prior to 1.18.
import org.opensearch.test.OpenSearchTestCase;  
        );
            random(),
    public void testIndexedChars() throws Exception {
        );
        );  
        Map<String, Object> attachmentData = parseDocument("htmlWithEmptyDateMeta.html", processor);
import static org.hamcrest.Matchers.equalTo;
    public void testAsciidocDocument() throws Exception {
            } while (selectedProperties.add(property) == false);
 * compatible open source license.
    public void testXHtmlDocument() throws Exception {
        Map<String, Object> attachmentData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");  
        assertThat(attachmentData.get("language"), is("en"));
        Map<String, Object> attachmentData = parseDocument("text-empty.txt", processor);
        assertThat(attachmentData.get("content"), is("\"God Save the Queen\" (alternatively \"God Save the King\""));
        assertThat(attachmentData.get("author"), is("Windows User"));
        processor = new AttachmentProcessor(  
        }
    }
            "target_field",
import org.opensearch.ingest.Processor;
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content_type", "content", "content_length"));
        assertThat(exception.getMessage(), equalTo("field [source_field] not present as part of path [source_field]"));
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));  
            10000,  
        Processor processor = new AttachmentProcessor(randomAlphaOfLength(10), null, "source_field", "randomTarget", null, 10, true, null);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        assertThat(  
        assertThat(attachmentData.get("language"), is("fr"));
        );
        assertThat(exception.getMessage(), equalTo("field [source_field] is null, cannot parse."));
 *    http://www.apache.org/licenses/LICENSE-2.0
            selectedFieldNames[i] = property.toLowerCase();
    }  
            is("This is a test, with umlauts, from München\n\nAlso contains newlines for testing.\n\nAnd one more.")
import static org.hamcrest.Matchers.notNullValue;  
        assertThat(attachmentData.get("title"), is("Hello"));
        Map<String, Object> attachmentData = parseDocument("issue-104.docx", processor);
    }
    private Map<String, Object> parseDocument(String file, AttachmentProcessor processor, Map<String, Object> optionalFields)
        Set<AttachmentProcessor.Property> selectedProperties = new HashSet<>();  
            Collections.singletonMap("source_field", null)
        assertThat(attachmentData.keySet(), hasItem("language"));
    private AttachmentProcessor processor;
import static org.hamcrest.Matchers.is;
    public void testUnknownLanguageDocument() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
            false,
        assertThat(attachmentData.get("content_length"), is(10L));
import java.util.HashMap;
import org.opensearch.ingest.IngestDocument;  
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));  
 *  
    }
    public void testNonExistentWithoutIgnoreMissing() throws Exception {
    }
        assertThat(attachmentData.get("date"), is("2015-01-06T18:07:00Z"));  
        Processor processor = new AttachmentProcessor(randomAlphaOfLength(10), null, "source_field", "randomTarget", null, 10, true, null);
        String path = "/org/opensearch/ingest/attachment/test/sample-files/text-in-english.txt";
        // Language detection is not accurate when the text to analyze is short  
        if (randomBoolean()) {  
        @SuppressWarnings("unchecked")
        assertThat(attachmentData.get("language"), is("en"));
        }
        );  
    }
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(  
/*  
    public void testNullWithoutIgnoreMissing() throws Exception {  
        assertThat(e.getDetailedMessage(), containsString("document is encrypted"));
 */  
        assertThat(attachmentData.get("language"), is("en"));
import java.util.HashSet;  
        assertThat(attachmentData.get("content_type").toString(), is("application/pdf"));  
        assertThat(attachmentData.get("content"), is(notNullValue()));
    }  
        Map<String, Object> attachmentData = parseDocument("asciidoc.asciidoc", processor);  
            is("application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public void testVisioIsExcluded() throws Exception {
            selectedProperties.add(AttachmentProcessor.Property.DATE);
import org.apache.commons.io.IOUtils;
        assertThat(attachmentData.get("language"), is("sl"));
        assertThat(attachmentData.get("content"), nullValue());  
        assertThat(  
    // no real detection, just rudimentary
        Map<String, Object> attachmentData = parseDocument("text-in-english.txt", processor);
        attachmentData = parseDocument("text-in-english.txt", processor, Collections.singletonMap("max_length", 100));
        assertThat(attachmentData.get("content_type"), is("application/vnd.ms-visio.drawing"));
    public void testHtmlDocumentWithRandomFields() throws Exception {
            "target_field",  
        document.putAll(optionalFields);  
 * The OpenSearch Contributors require contributions made to  
        Processor processor = new AttachmentProcessor(randomAlphaOfLength(10), null, "source_field", "randomTarget", null, 10, false, null);  
            attachmentData.keySet(),
    }
    public void testPdf() throws Exception {  
            null,
            false,
            false,
    @Before
import java.util.Base64;
    public void testZipFileDoesNotHang() throws Exception {
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(
        processor.execute(ingestDocument);  
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);
        Map<String, Object> attachmentData = parseDocument("text-in-french.txt", processor);
            "max_length"
        Map<String, Object> attachmentData = (Map<String, Object>) ingestDocument.getSourceAndMetadata().get("target_field");
            19,  
            } else {
    }
        assertThat(attachmentData.keySet(), hasSize(selectedFieldNames.length));  
        assertThat(attachmentData.keySet(), not(hasItem("language")));  
 * You may obtain a copy of the License at  
            10000,  
            false,  
        Map<String, Object> attachmentData = parseDocument("testEPUB.epub", processor);
    }
import org.opensearch.ingest.RandomDocumentPicks;
        assertThat(attachmentData.get("content_type").toString(), containsString("application/epub+zip"));
    }
import static org.hamcrest.Matchers.hasItem;
import java.util.ArrayList;
    public void testHtmlDocument() throws Exception {
    }  
    // See (https://issues.apache.org/jira/browse/COMPRESS-432) for information  
        @SuppressWarnings("unchecked")
 * license agreements. See the NOTICE file distributed with
        assertThat(attachmentData.get("language"), is("en"));
        assertThat(attachmentData.keySet(), containsInAnyOrder("content", "language", "date", "author", "content_type", "content_length"));  
            null
        document.put("source_field", bytes);
    }
        assertIngestDocument(originalIngestDocument, ingestDocument);  
        attachmentData = parseDocument("text-in-english.txt", processor, Collections.singletonMap("max_length", 10));
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
 */  
        throws Exception {  
            null,
import org.junit.Before;
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
            EnumSet.allOf(AttachmentProcessor.Property.class),
        assertThat(attachmentData.get("author"), is("foobar"));
        assertThat(attachmentData.get("keywords"), is("opensearch,cool,bonsai"));  
 * this work for additional information regarding copyright
    public void createStandardProcessor() {
            randomAlphaOfLength(10),
        assertThat(attachmentData.get("language"), not(is("en")));
        assertThat(attachmentData.get("content"), is("\"God Save the Queen"));
 * under the License.  
        }
        processor = new AttachmentProcessor(
            "target_field",
        IngestDocument originalIngestDocument = RandomDocumentPicks.randomIngestDocument(random(), Collections.emptyMap());  
        // date is not present in the html doc
        assertThat(attachmentData.get("content").toString(), containsString("Table of Contents"));
        for (int i = 0; i < numFields; i++) {
            randomAlphaOfLength(10),
                return Base64.getEncoder().encodeToString(bytes);  
}
        // Note - this output is non-deterministic across library versions  
        assertThat(attachmentData.get("content").toString(), containsString("Table of Contents"));
        int numFields = randomIntBetween(1, fieldsList.size());
        assertThat(attachmentData.keySet(), containsInAnyOrder(selectedFieldNames));
    public void testEmptyTextDocument() throws Exception {
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "author", "title", "content_type", "content_length"));
import static org.hamcrest.Matchers.containsString;  
        );  
    private Map<String, Object> parseDocument(String file, AttachmentProcessor processor) throws Exception {
 * specific language governing permissions and limitations
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));
        assertThat(attachmentData.get("content_length"), is(19L));
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random(), document);
        return attachmentData;
    }
        assertThat(attachmentData.get("content_length"), is(notNullValue()));
 */
        Map<String, Object> attachmentData = parseDocument("testXHTML.html", processor);  
    }  
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));  
        IngestDocument ingestDocument = new IngestDocument(originalIngestDocument);  
        Map<String, Object> attachmentData = parseDocument("text-in-english.txt", processor);
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));  
    public void testNullValueWithIgnoreMissing() throws Exception {
        assertThat(attachmentData.get("language"), is("en"));
        assertThat(attachmentData.get("content"), is("\"God Save the Queen"));  
        Processor processor = new AttachmentProcessor(randomAlphaOfLength(10), null, "source_field", "randomTarget", null, 10, false, null);
        byte[] bytes;
import static org.hamcrest.Matchers.hasSize;  
        );
            attachmentData.keySet(),
        assertThat(attachmentData.get("content"), is("\"God Save"));  
            EnumSet.complementOf(EnumSet.of(AttachmentProcessor.Property.DATE))
            "source_field",  
        String[] selectedFieldNames = new String[numFields];  
            randomAlphaOfLength(10),
 * KIND, either express or implied.  See the License for the
        assertThat(attachmentData.get("content"), is("\"God Save the Queen\" (alternatively \"God Save the King\""));  
            null
    public void testParseAsBytesArray() throws Exception {  
        Map<String, Object> attachmentData = parseDocument("test.pdf", processor);
    }
 *
public class AttachmentProcessorTests extends OpenSearchTestCase {  
        );  
import static org.hamcrest.Matchers.containsInAnyOrder;
        Map<String, Object> attachmentData = parseDocument("issue-22077.doc", processor);
    public void testLegacyWordDocumentWithVisioSchema() throws Exception {  
            containsInAnyOrder("language", "content", "author", "keywords", "title", "content_type", "content_length")  
            }
            if (rarely()) {  
        Exception exception = expectThrows(Exception.class, () -> processor.execute(ingestDocument));
            "target_field",
        );  
            random(),
                property = randomFrom(fieldsList);
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
        return parseDocument(file, processor, new HashMap<>());
            // behave like CBOR from time to time
        assertThat(attachmentData.get("content_type").toString(), containsString("text/plain"));  
import java.util.EnumSet;
        }
        assertThat(attachmentData.get("content_length"), is(0L));
        Map<String, Object> document = new HashMap<>();
            null,
        processor = new AttachmentProcessor(  
        assertThat(
        Map<String, Object> attachmentData = parseDocument("issue-22077.docx", processor);
        assertThat(attachmentData.get("content"), is("\"God Save the Queen\" (alternatively \"God Save the King\""));
    }
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(attachmentData.keySet(), containsInAnyOrder("language", "content", "content_type", "content_length"));
    }
import java.util.Set;
import org.opensearch.OpenSearchParseException;
            attachmentData.get("content"),  
 *
        assertThat(attachmentData.get("date"), is("2012-10-12T11:17:00Z"));  
    }  
        assertIngestDocument(originalIngestDocument, ingestDocument);
import static org.hamcrest.Matchers.nullValue;
/*
        );  
    }  
        processor.execute(ingestDocument);
            null,
    public void testWordDocument() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
            byte bytes[] = IOUtils.toByteArray(is);
    }
        try (InputStream is = AttachmentProcessorTests.class.getResourceAsStream(path)) {  
            containsInAnyOrder("language", "content", "author", "title", "content_type", "content_length", "date", "keywords")
