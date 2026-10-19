import org.opensearch.core.xcontent.XContentParser;
    }
                singletonMap("field1", new DocumentField("metafield", singletonList("metavalue")))
        );
        String json = "{\"_index\":\"foo\",\"_id\":\"bar\"}";
            tuple.v2().getPrimaryTerm(),
        GetResult getResult = tuple.v1();
        boolean humanReadable = randomBoolean();
                getResult.getIndex(),
            seqNo = UNASSIGNED_SEQ_NO;
        // Test that we can parse the result of toXContentEmbedded()
import org.opensearch.core.common.bytes.BytesArray;
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
        assertEquals(expectedGetResult.sourceAsString(), parsedEmbeddedGetResult.sourceAsString());
                1,
    }
                getResult.getFields(),
            getResult.internalSourceRef(),
import org.opensearch.test.OpenSearchTestCase;
            null,
import org.opensearch.core.xcontent.MediaType;
        BytesStreamOutput out = new BytesStreamOutput();
    private static BytesReference toXContentEmbedded(GetResult getResult, MediaType mediaType, boolean humanReadable) throws IOException {
        ) {
        Tuple<GetResult, GetResult> tuple = randomGetResult(xContentType);
                getResult.getId(),
 * Unless required by applicable law or agreed to in writing,
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            if (randomBoolean()) {
                getResult.isExists() ? 0 : getResult.getPrimaryTerm(),
import org.opensearch.core.common.Strings;
            new BytesArray("{\"foo\":\"bar\",\"baz\":[\"baz_0\",\"baz_1\"]}"),
 */
    public static Tuple<Map<String, DocumentField>, Map<String, DocumentField>> randomDocumentFields(
                getResult.getSeqNo(),
    }
            assertEquals("{\"_index\":\"index\",\"_id\":\"id\",\"found\":false}", output);
    public void testToXContentEmbeddedNotFound() throws IOException {
        mutations.add(
            || field.equals(SeqNoFieldMapper.NAME);
            null,
            );
        final boolean exists;
        // index, id, version, seqNo, and source fields, we need to exclude them from random fields
import org.opensearch.common.io.stream.BytesStreamOutput;
        mutations.add(
        assertEquals(expectedGetResult, parsedGetResult);
        boolean isMetaFields
    public void testToAndFromXContent() throws Exception {
                getResult.getId(),
                null
        );
            getResult.getDocumentFields(),
        XContentType xContentType = randomFrom(XContentType.values());
        mutations.add(
    }
        // test that we can parse what we print out
        fields.put("foo", new DocumentField("foo", singletonList("bar")));
    public void testEqualsAndHashcode() {
            expectedDocFields,
            () -> new GetResult(
import java.util.HashMap;
            ParsingException parsingException = assertThrows(ParsingException.class, () -> GetResult.fromXContentEmbedded(parser));
            primaryTerm = randomLongBetween(1, 100);
    }
        // by the toXContentEmbedded method.
import org.opensearch.core.xcontent.ToXContent;
 * The OpenSearch Contributors require contributions made to
        assertEquals(expectedGetResult, parsedEmbeddedGetResult);
                getResult.getPrimaryTerm(),
        );
            primaryTerm = UNASSIGNED_PRIMARY_TERM;
        final long primaryTerm;
                RandomObjects.randomSource(random()),
            "index",
                getResult.internalSourceRef(),
                null
        GetResult expectedGetResult = new GetResult(
            GetResultTests::mutateGetResult
                getResult.getFields(),
        getResult = new GetResult(out.bytes().streamInput());
                expectedDocFields = tuple.v2();
        // As we are using this to construct a GetResult object that already contains
                getResult.getSeqNo(),
            )
            assertNotNull(getResult.sourceRef());
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.common.collect.Tuple;
/*
 * You may obtain a copy of the License at
            getResult.isExists(),
        }
            seqNo = randomNonNegativeLong();
 * this work for additional information regarding copyright
import java.util.Map;
import org.opensearch.index.mapper.IndexFieldMapper;
        final String index = randomAlphaOfLengthBetween(3, 10);
        return new GetResult(
            || field.equals(SourceFieldMapper.NAME)
            "{\"_seq_no\":0,\"_primary_term\":1,\"found\":true,\"_source\":{\"foo\":\"bar\",\"baz\":[\"baz_0\",\"baz_1\"]},"
import java.util.Arrays;
import org.opensearch.common.document.DocumentField;
        assertEquals(expectedGetResult.sourceAsString(), parsedGetResult.sourceAsString());
        return Tuple.tuple(getResult, expectedGetResult);
        Map<String, DocumentField> expectedFields = new HashMap<>(numFields);
            source,
        GetResult parsedEmbeddedGetResult;
                getResult.isExists(),
 * SPDX-License-Identifier: Apache-2.0
            getResult.getIndex(),
        }
                tuple = randomDocumentFields(mediaType, true);
        return org.opensearch.core.xcontent.XContentHelper.toXContent(getResult::toXContentEmbedded, mediaType, humanReadable);
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            () -> new GetResult(
        }
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
                Tuple<Map<String, DocumentField>, Map<String, DocumentField>> tuple = randomDocumentFields(mediaType, false);
            exists = true;
            XContentParser parser = JsonXContent.jsonXContent.createParser(
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.ParsingException;
                metaFields = tuple.v1();
            getResult.getSeqNo(),
            2,
                getResult.internalSourceRef(),
                getResult.getIndex(),
        GetResult expectedGetResult = new GetResult(
            fields,
                getResult.getPrimaryTerm(),
            () -> new GetResult(
                getResult.getId(),
            version = randomNonNegativeLong();
            tuple.v2().getSeqNo(),
import static java.util.Collections.singletonList;
            () -> new GetResult(
                randomDocumentFields(MediaTypeRegistry.JSON, randomBoolean()).v1(),
            seqNo,
        Map<String, DocumentField> expectedDocFields = null;
    }
 * compatible open source license.
                getResult.isExists(),
            )
                "id",
            -1,
                getResult.getVersion(),
 *
            getResult.getVersion(),
        }
            tuple.v2().getDocumentFields(),
            1,
                randomNonNegativeLong(),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
            assertNull(parser.nextToken());
                source = RandomObjects.randomSource(random());
            if (frequently()) {
                output
import org.opensearch.test.RandomObjects;
                getResult.internalSourceRef(),
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.MediaTypeRegistry;
                getResult.getId(),
        BytesReference finalBytes = toXContent(parsedGetResult, xContentType, humanReadable);
 * Modifications Copyright OpenSearch Contributors. See
                null
        assertEquals(
        // print the parsed object out and test that the output is the same as the original output
                getResult.getFields(),
        } else {
        );
                getResult.getPrimaryTerm(),
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        // check that the source stays unchanged, no shuffling of keys nor anything like that
                randomUnicodeOfLength(15),
public class GetResultTests extends OpenSearchTestCase {
import java.util.function.Predicate;
                getResult.getId(),
                + "\"fields\":{\"foo\":[\"bar\"],\"baz\":[\"baz_0\",\"baz_1\"]}}",
    ) {
import java.util.function.Supplier;
        // serializes and deserializes with streamable, then prints back to xcontent
    }
    }
        } else {
        if (frequently()) {
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
        while (fields.size() < numFields) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            )
    }
            index,
            || field.equals(IdFieldMapper.NAME)
            exists,
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
    }
            randomGetResult(MediaTypeRegistry.JSON).v1(),
                getResult.getSeqNo(),
        mutations.add(
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
                assertNull(expectedFields.putIfAbsent(expectedGetField.getName(), expectedGetField));
            version = -1;
            () -> new GetResult(
                true,
            String output = Strings.toString(MediaTypeRegistry.JSON, getResult);
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
 * this file be licensed under the Apache-2.0 license or a
        if (getResult.isExists() && getResult.isSourceEmpty() == false) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(
                "index",
        }
                null
        );
                getResult.getVersion(),
 * KIND, either express or implied.  See the License for the
    public void testFromXContentEmbeddedFoundParsingException() throws IOException {
        }
        );
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
            if (fields.putIfAbsent(getField.getName(), getField) == null) {
        Tuple<GetResult, GetResult> tuple = randomGetResult(xContentType);
            || field.equals(VersionFieldMapper.NAME)
            exists = false;
        );
        );
            }
        mutations.add(
        GetResult getResult = new GetResult(
                getResult.getVersion(),
        );
        GetResult parsedGetResult;
        fields.put("baz", new DocumentField("baz", Arrays.asList("baz_0", "baz_1")));
        mutations.add(
    }
        final String id = randomAlphaOfLengthBetween(3, 10);
        int numFields = isMetaFields ? randomIntBetween(1, 3) : randomIntBetween(2, 10);
 */
        checkEqualsAndHashCode(
import org.opensearch.common.xcontent.json.JsonXContent;
            assertNull(getResult.sourceRef());
                randomUnicodeOfLength(15),
        final long seqNo;
        }
import org.opensearch.index.mapper.VersionFieldMapper;
 *
            expectedMetaFields
    public void testGetSourceAsBytes() {
                getResult.isExists(),
import java.io.IOException;
                getResult.getIndex(),
        List<Supplier<GetResult>> mutations = new ArrayList<>();
        );
            parsedGetResult = GetResult.fromXContent(parser);
        BytesReference source = null;
 */
        BytesReference originalBytes = toXContentEmbedded(getResult, MediaTypeRegistry.JSON, false);
        assertEquals("{\"found\":false}", originalBytes.utf8ToString());
        // print the parsed object out and test that the output is the same as the original output
        Map<String, DocumentField> docFields = null;
                docFields = tuple.v1();
        assertEquals("{\"found\":false}", originalBytes.utf8ToString());
 *
    public void testSerializationNotFound() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
            String output = Strings.toString(MediaTypeRegistry.JSON, getResult);
        XContentType xContentType = randomFrom(XContentType.values());
            getResult.getId(),
            tuple.v2().isExists(),
                0,
        return Tuple.tuple(fields, expectedFields);
        boolean humanReadable = randomBoolean();
            GetResult getResult = new GetResult("index", "id", UNASSIGNED_SEQ_NO, 0, 1, false, null, null, null);
        GetResult expectedGetResult = tuple.v2();
        return randomFrom(mutations).get();
}
        getResult.writeTo(out);
            () -> new GetResult(
            id,
        try (
                LoggingDeprecationHandler.INSTANCE,
        Predicate<String> excludeMetaFieldFilter = field -> field.equals(IndexFieldMapper.NAME)
                getResult.getIndex(),
            getResult.getMetadataFields()
import static java.util.Collections.singletonMap;
        Map<String, DocumentField> fields = new HashMap<>();
        Map<String, DocumentField> expectedMetaFields = null;
    public void testToXContentEmbedded() throws IOException {
/*
/*
        BytesReference originalBytes = toXContentEmbedded(getResult, xContentType, humanReadable);
        BytesReference finalBytes = toXContentEmbedded(parsedEmbeddedGetResult, xContentType, humanReadable);
        final long version;
            DocumentField getField = tuple.v1();
    public static GetResult copyGetResult(GetResult getResult) {
        GetResult getResult = new GetResult("index", "id", UNASSIGNED_SEQ_NO, 0, 1, false, null, null, null);
        );
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            version,
                    + "\"metafield\":\"metavalue\",\"found\":true,\"_source\":{ \"field1\" : \"value1\", \"field2\":\"value2\"},"
    public static GetResult mutateGetResult(GetResult getResult) {
package org.opensearch.index.get;
            null
        Map<String, DocumentField> metaFields = null;
        BytesReference originalBytes = toXContentEmbedded(getResult, MediaTypeRegistry.JSON, false);
import java.util.ArrayList;
            GetResultTests::copyGetResult,
            GetResult getResult = new GetResult(
import org.opensearch.index.mapper.SeqNoFieldMapper;
        {
    public void testToXContent() throws IOException {
        // We don't expect to retrieve the index/type/id of the GetResult because they are not rendered
                new BytesArray("{ \"field1\" : " + "\"value1\", \"field2\":\"value2\"}"),
                null
 * specific language governing permissions and limitations
                getResult.getSeqNo(),
                getResult.getVersion(),
        BytesReference originalBytes = toXContentEmbedded(getResult, MediaTypeRegistry.JSON, false);
            true,
                getResult.getVersion(),
 * under the License.
 * ownership. Elasticsearch licenses this file to you under
                getResult.internalSourceRef(),
            getResult.getPrimaryTerm(),
            "id",
                getResult.isExists(),
        // check that the source stays unchanged, no shuffling of keys nor anything like that
            DocumentField expectedGetField = tuple.v2();
    }
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.index.get.DocumentFieldTests.randomDocumentField;
                getResult.getFields(),
            }
        Map<String, DocumentField> fields = new HashMap<>(numFields);
import org.opensearch.index.mapper.SourceFieldMapper;
            );
                getResult.getFields(),
        GetResult getResult = new GetResult("index", "id", UNASSIGNED_SEQ_NO, 0, 1, false, null, null, null);
            )
    public static Tuple<GetResult, GetResult> randomGetResult(MediaType mediaType) {
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":1,\"_seq_no\":0,\"_primary_term\":1,"
        );
            )
        GetResult getResult = tuple.v1();
            originalBytes.utf8ToString()
                1,
        XContentType xContentType = randomFrom(XContentType.values());
                getResult.getSeqNo(),
            0,
            )
        Tuple<GetResult, GetResult> tuple = randomGetResult(xContentType);
                expectedMetaFields = tuple.v2();
            tuple.v2().sourceRef(),
            tuple.v2().getMetadataFields()
        GetResult getResult = new GetResult(index, id, seqNo, primaryTerm, version, exists, source, docFields, metaFields);
 * software distributed under the License is distributed on an
        GetResult getResult = tuple.v1();
                getResult.isExists(),
            }
            Tuple<DocumentField, DocumentField> tuple = randomDocumentField(mediaType, isMetaFields, excludeMetaFieldFilter);
        MediaType mediaType,
        BytesReference originalBytes = toShuffledXContent(getResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable, "_source");
        {
                NamedXContentRegistry.EMPTY,
                    + "\"fields\":{\"field1\":[\"value1\"]}}",
                getResult.getIndex(),
            assertEquals("Missing required field [found]", parsingException.getMessage());
                singletonMap("field1", new DocumentField("field1", singletonList("value1"))),
                getResult.getPrimaryTerm(),
    public void testToAndFromXContentEmbedded() throws Exception {
            parsedEmbeddedGetResult = GetResult.fromXContentEmbedded(parser);
            )
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;
                null
    }
                getResult.internalSourceRef(),
            assertNull(parser.nextToken());
import java.util.List;
                getResult.getPrimaryTerm(),
 * GitHub history for details.
import org.opensearch.common.xcontent.XContentType;
            primaryTerm,
                json
import org.opensearch.index.mapper.IdFieldMapper;
                getResult.isExists() ? UNASSIGNED_SEQ_NO : getResult.getSeqNo(),
    }
                getResult.isExists() == false,
        final String type = randomAlphaOfLengthBetween(3, 10);
