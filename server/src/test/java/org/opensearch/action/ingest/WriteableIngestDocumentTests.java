        }
import org.opensearch.common.xcontent.XContentType;
            changed = true;
            changed = true;
import org.opensearch.ingest.RandomDocumentPicks;
        return new WriteableIngestDocument(createRandomIngestDoc());
    }
/*
 * SPDX-License-Identifier: Apache-2.0
            for (int i = 0; i < numFields; i++) {
            otherSourceAndMetadata = RandomDocumentPicks.randomSource(random());
    protected WriteableIngestDocument createTestInstance() {
            ingestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));
        }
        for (int i = 0; i < numFields; i++) {
import java.util.Map;
            ingestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));
 * license agreements. See the NOTICE file distributed with
            assertThat(thirdIngestDocument, equalTo(ingestDocument));
                new IngestDocument(Collections.unmodifiableMap(sourceAndMetadata), Collections.unmodifiableMap(ingestMetadata))
    @Override
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        writeableIngestDocument.writeTo(out);
            || field.startsWith(
            }
            new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.SOURCE_FIELD).toString()
        Map<String, Object> ingestMetadata = new HashMap<>();
            numFields = randomIntBetween(1, 5);
        return field -> field.startsWith(
    protected WriteableIngestDocument doParseInstance(XContentParser parser) {
        return true;
/*
        assertIngestDocument(otherWriteableIngestDocument.getIngestDocument(), writeableIngestDocument.getIngestDocument());
            otherIngestMetadata = Collections.unmodifiableMap(ingestMetadata);
                otherSourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));
import java.util.Collections;
        if (randomBoolean()) {
            sourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));
        } else {
import org.opensearch.common.xcontent.XContentHelper;
public class WriteableIngestDocumentTests extends AbstractXContentTestCase<WriteableIngestDocument> {
 *    http://www.apache.org/licenses/LICENSE-2.0
            } else {
import org.opensearch.core.xcontent.XContentParser;
import java.util.HashMap;
import org.opensearch.test.AbstractXContentTestCase;
    protected boolean supportsUnknownFields() {
        int numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);
            assertThat(ingestDocument, equalTo(otherIngestDocument));
    public void testEqualsAndHashcode() throws Exception {
            for (int i = 0; i < numFields; i++) {
 */
        WriteableIngestDocument otherIngestDocument = new WriteableIngestDocument(
 *
 * specific language governing permissions and limitations
        BytesStreamOutput out = new BytesStreamOutput();
        return WriteableIngestDocument.fromXContent(parser);
        IngestDocument ingestDocument = RandomDocumentPicks.randomIngestDocument(random());
 */
        builder.startObject();
import static org.hamcrest.Matchers.equalTo;
        WriteableIngestDocument writeableIngestDocument = new WriteableIngestDocument(
        Map<String, Object> toXContentSource = (Map<String, Object>) toXContentDoc.get("_source");
import org.opensearch.test.RandomObjects;
                assertThat(toXContentDoc.containsKey(fieldName), is(false));
        WriteableIngestDocument otherWriteableIngestDocument = new WriteableIngestDocument(streamInput);
 *
 * Licensed to Elasticsearch under one or more contributor
        Map<String, Object> sourceAndMetadata = RandomDocumentPicks.randomSource(random());
        WriteableIngestDocument ingestDocument = new WriteableIngestDocument(new IngestDocument(sourceAndMetadata, ingestMetadata));
    }
            numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);
import static org.hamcrest.Matchers.not;
        XContentBuilder builder = XContentFactory.cborBuilder();
            WriteableIngestDocument thirdIngestDocument = new WriteableIngestDocument(
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < numFields; i++) {
        )
        }
    protected Predicate<String> getRandomFieldsExcludeFilter() {
            otherSourceAndMetadata = new HashMap<>(sourceAndMetadata);
        // We cannot have random fields in the _source field and _ingest field
            assertThat(ingestDocument.hashCode(), equalTo(otherIngestDocument.hashCode()));
                new StringJoiner(".").add(WriteableIngestDocument.DOC_FIELD).add(WriteableIngestDocument.INGEST_FIELD).toString()
        int numFields = randomIntBetween(1, IngestDocument.Metadata.values().length);
    @Override
            }
        }
        } else {
import org.opensearch.core.common.bytes.BytesReference;
    static IngestDocument createRandomIngestDoc() {
        Map<String, Object> otherSourceAndMetadata;
    @SuppressWarnings("unchecked")
        Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.extractMetadata();
    public void testSerialization() throws IOException {
            new IngestDocument(sourceAndMetadata, ingestMetadata)
 * Unless required by applicable law or agreed to in writing,
    }
            assertThat(otherIngestDocument, equalTo(ingestDocument));
import java.util.function.Predicate;
        numFields = randomIntBetween(1, 5);
    @Override
            assertThat(otherIngestDocument, not(equalTo(ingestDocument)));
import org.opensearch.ingest.IngestDocument;
        WriteableIngestDocument writeableIngestDocument = new WriteableIngestDocument(new IngestDocument(ingestDocument));
 * ownership. Elasticsearch licenses this file to you under
 */
        if (changed) {
        BytesReference sourceBytes = RandomObjects.randomSource(random(), xContentType);
        }
        numFields = randomIntBetween(1, 5);
        Map<String, Object> toXContentMap = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
    }
        for (Map.Entry<IngestDocument.Metadata, Object> metadata : metadataMap.entrySet()) {
        } else {
            new IngestDocument(otherSourceAndMetadata, otherIngestMetadata)
import static org.opensearch.ingest.IngestDocumentMatcher.assertIngestDocument;
                otherIngestMetadata.put(randomAlphaOfLengthBetween(5, 10), randomAlphaOfLengthBetween(5, 10));
import java.util.StringJoiner;
        }
        Map<String, Object> ingestMetadata = new HashMap<>();
}
        Map<String, Object> toXContentIngestMetadata = (Map<String, Object>) toXContentDoc.get("_ingest");
            assertThat(ingestDocument, not(equalTo(otherIngestDocument)));
            );
            String fieldName = metadata.getKey().getFieldName();
            }
        }
            assertThat(ingestDocument.hashCode(), equalTo(thirdIngestDocument.hashCode()));
 * this work for additional information regarding copyright
 * compatible open source license.
import static org.opensearch.core.xcontent.ToXContent.EMPTY_PARAMS;
 * The OpenSearch Contributors require contributions made to
    }
    }
        );
 * under the License.
import java.io.IOException;
        );
 * not use this file except in compliance with the License.
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.action.ingest;
import org.opensearch.common.xcontent.XContentFactory;
 * KIND, either express or implied.  See the License for the
        if (randomBoolean()) {
        builder.endObject();
    }
        IngestDocument serializedIngestDocument = new IngestDocument(toXContentSource, toXContentIngestMetadata);
        Map<String, Object> toXContentDoc = (Map<String, Object>) toXContentMap.get("doc");
        Map<String, Object> randomSource = XContentHelper.convertToMap(sourceBytes, false, xContentType).v2();
 * GitHub history for details.
            changed = true;
        if (randomBoolean()) {
 * software distributed under the License is distributed on an
            sourceAndMetadata.put(randomFrom(IngestDocument.Metadata.values()).getFieldName(), randomAlphaOfLengthBetween(5, 10));
            assertThat(ingestDocument, equalTo(thirdIngestDocument));
import static org.hamcrest.Matchers.is;
        return RandomDocumentPicks.randomIngestDocument(random(), randomSource);
        assertThat(serializedIngestDocument, equalTo(serializedIngestDocument));
import org.opensearch.core.xcontent.XContentBuilder;
            otherIngestMetadata = new HashMap<>();
 * You may obtain a copy of the License at
        for (int i = 0; i < numFields; i++) {
        for (int i = 0; i < numFields; i++) {
        }
        Map<String, Object> otherIngestMetadata;
        writeableIngestDocument.toXContent(builder, EMPTY_PARAMS);
/*
        XContentType xContentType = randomFrom(XContentType.values());
        Map<String, Object> sourceAndMetadata = RandomDocumentPicks.randomSource(random());
                assertThat(toXContentDoc.get(fieldName), equalTo(metadata.getValue().toString()));
        boolean changed = false;
    @Override
        }
 *
        StreamInput streamInput = out.bytes().streamInput();
    public void testToXContent() throws IOException {
            if (metadata.getValue() == null) {
 * the Apache License, Version 2.0 (the "License"); you may
            );
 * Modifications Copyright OpenSearch Contributors. See
        // using a cbor builder here, so that byte arrays do not get converted, so equalTo() below works
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
