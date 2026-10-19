            assertThat(ingestDocument.hashCode(), equalTo(thirdIngestDocument.hashCode()));
        Map<String, Object> ingestMetadata = new HashMap<>();
    public void testSerialization() throws IOException {
        StreamInput streamInput = out.bytes().streamInput();
 */  
            assertThat(ingestDocument.hashCode(), equalTo(otherIngestDocument.hashCode()));
import org.opensearch.ingest.IngestDocument;  
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
        builder.startObject();
            otherSourceAndMetadata = RandomDocumentPicks.randomSource(random());  
        Map<String, Object> otherSourceAndMetadata;
        WriteableIngestDocument writeableIngestDocument = new WriteableIngestDocument(new IngestDocument(ingestDocument));  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.RandomObjects;  
        } else {  
 */  
        );  
        if (randomBoolean()) {
            String fieldName = metadata.getKey().getFieldName();  
            otherIngestMetadata = Collections.unmodifiableMap(ingestMetadata);
 * under the License.  
    @Override
            changed = true;
import org.opensearch.ingest.RandomDocumentPicks;
        // We cannot have random fields in the _source field and _ingest field  
                otherSourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));
import static org.hamcrest.Matchers.is;  
            new IngestDocument(otherSourceAndMetadata, otherIngestMetadata)
        }
        }
        int numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);
        } else {
        Map<String, Object> sourceAndMetadata = RandomDocumentPicks.randomSource(random());  
            for (int i = 0; i < numFields; i++) {
        assertThat(serializedIngestDocument, equalTo(serializedIngestDocument));  
/*  
 * KIND, either express or implied.  See the License for the
        return new WriteableIngestDocument(createRandomIngestDoc());
            otherSourceAndMetadata = new HashMap<>(sourceAndMetadata);  
 *  
                new IngestDocument(Collections.unmodifiableMap(sourceAndMetadata), Collections.unmodifiableMap(ingestMetadata))  
        WriteableIngestDocument writeableIngestDocument = new WriteableIngestDocument(
import java.util.HashMap;
            sourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));  
        if (randomBoolean()) {
        WriteableIngestDocument otherWriteableIngestDocument = new WriteableIngestDocument(streamInput);
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;  
 * The OpenSearch Contributors require contributions made to  
    public void testEqualsAndHashcode() throws Exception {
            numFields = randomIntBetween(1, 5);
            }  
            changed = true;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.bytes.BytesReference;
            sourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));  
    }
            } else {  
        Map<String, Object> toXContentSource = (Map<String, Object>) toXContentDoc.get("_source");
import java.util.Collections;  
        Map<String, Object> sourceAndMetadata = RandomDocumentPicks.randomSource(random());  
                assertThat(toXContentDoc.containsKey(fieldName), is(false));
    }  
            }
        for (Map.Entry<IngestDocument.Metadata, Object> metadata : metadataMap.entrySet()) {
            assertThat(ingestDocument, equalTo(thirdIngestDocument));  
    }
        assertIngestDocument(otherWriteableIngestDocument.getIngestDocument(), writeableIngestDocument.getIngestDocument());  
                assertThat(toXContentDoc.get(fieldName), equalTo(metadata.getValue().toString()));
            );
        XContentType xContentType = randomFrom(XContentType.values());
        Map<String, Object> toXContentDoc = (Map<String, Object>) toXContentMap.get("doc");  
        BytesReference sourceBytes = RandomObjects.randomSource(random(), xContentType);
import org.opensearch.core.common.io.stream.StreamInput;  
    @Override  
    @Override
 *
import org.opensearch.core.xcontent.XContentBuilder;
            || field.startsWith(
    protected WriteableIngestDocument doParseInstance(XContentParser parser) {  
        Map<String, Object> randomSource = XContentHelper.convertToMap(sourceBytes, false, xContentType).v2();  
            otherIngestMetadata = new HashMap<>();  
            );  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
            }
    }
    @SuppressWarnings("unchecked")  
        );  
 * this work for additional information regarding copyright
        }
        }
/*
            assertThat(ingestDocument, not(equalTo(otherIngestDocument)));
import java.util.StringJoiner;  
            ingestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));
        Map<String, Object> toXContentIngestMetadata = (Map<String, Object>) toXContentDoc.get("_ingest");
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
        BytesStreamOutput out = new BytesStreamOutput();
 *    http://www.apache.org/licenses/LICENSE-2.0
        )  
        WriteableIngestDocument otherIngestDocument = new WriteableIngestDocument(
    public void testToXContent() throws IOException {
        IngestDocument serializedIngestDocument = new IngestDocument(toXContentSource, toXContentIngestMetadata);
 * You may obtain a copy of the License at  
        builder.endObject();  
 * not use this file except in compliance with the License.
            changed = true;
import static org.hamcrest.Matchers.not;
    }
        XContentBuilder builder = XContentFactory.cborBuilder();  
        numFields = randomIntBetween(1, 5);  
        Map<String, Object> otherIngestMetadata;
        for (int i = 0; i < numFields; i++) {
        }
import java.io.IOException;
        return RandomDocumentPicks.randomIngestDocument(random(), randomSource);
    protected Predicate<String> getRandomFieldsExcludeFilter() {
import org.opensearch.common.xcontent.XContentType;
    @Override
        numFields = randomIntBetween(1, 5);  
            new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.SOURCE_FIELD).toString()
        Map<String, Object> toXContentMap = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
        }  
        }  
        for (int i = 0; i < numFields; i++) {
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
import java.util.function.Predicate;
        for (int i = 0; i < numFields; i++) {
        return true;  
import org.opensearch.common.xcontent.XContentHelper;  
package org.opensearch.action.ingest;
        return WriteableIngestDocument.fromXContent(parser);
        boolean changed = false;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // using a cbor builder here, so that byte arrays do not get converted, so equalTo() below works
 * GitHub history for details.
            for (int i = 0; i < numFields; i++) {
import org.opensearch.common.xcontent.XContentFactory;
    }
        }  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.io.stream.BytesStreamOutput;
        writeableIngestDocument.toXContent(builder, EMPTY_PARAMS);
 * Licensed to Elasticsearch under one or more contributor  
        Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.extractMetadata();
        WriteableIngestDocument ingestDocument = new WriteableIngestDocument(new IngestDocument(sourceAndMetadata, ingestMetadata));
 * Modifications Copyright OpenSearch Contributors. See
 *
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Object> ingestMetadata = new HashMap<>();
            WriteableIngestDocument thirdIngestDocument = new WriteableIngestDocument(
}
        if (randomBoolean()) {
    }
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
/*  
public class WriteableIngestDocumentTests extends AbstractXContentTestCase<WriteableIngestDocument> {  
import org.opensearch.core.xcontent.XContentParser;
            assertThat(ingestDocument, equalTo(otherIngestDocument));
        for (int i = 0; i < numFields; i++) {
        if (changed) {
import org.opensearch.test.AbstractXContentTestCase;
 */
            if (metadata.getValue() == null) {
            new IngestDocument(sourceAndMetadata, ingestMetadata)
 * compatible open source license.
            numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);  
            ingestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));
        } else {
        writeableIngestDocument.writeTo(out);  
            assertThat(otherIngestDocument, equalTo(ingestDocument));  
            assertThat(thirdIngestDocument, equalTo(ingestDocument));
    }  
            assertThat(otherIngestDocument, not(equalTo(ingestDocument)));  
        int numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);
        return field -> field.startsWith(
        }
    protected boolean supportsUnknownFields() {
                new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.INGEST_FIELD).toString()
    protected WriteableIngestDocument createTestInstance() {
                otherIngestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));  
    static IngestDocument createRandomIngestDoc() {  
