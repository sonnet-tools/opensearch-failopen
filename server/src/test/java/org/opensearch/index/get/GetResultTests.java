                null
        BytesReference source = null;
import org.opensearch.core.common.ParsingException;
                getResult.isExists(),
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 *
            getResult.getSeqNo(),  
/*  
/*  
            )
            String output = Strings.toString(MediaTypeRegistry.JSON, getResult);
        GetResult getResult = new GetResult(index, id, seqNo, primaryTerm, version, exists, source, docFields, metaFields);  
 * not use this file except in compliance with the License.
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
        List<Supplier<GetResult>> mutations = new ArrayList<>();
                source = RandomObjects.randomSource(random());
import java.util.function.Supplier;
        assertEquals("{\"found\":false}", originalBytes.utf8ToString());  
        GetResult expectedGetResult = tuple.v2();
    public void testGetSourceAsBytes() {  
        getResult.writeTo(out);
        final long version;
                json
            }
        GetResult getResult = tuple.v1();  
            || field.equals(SeqNoFieldMapper.NAME);
        XContentType xContentType = randomFrom(XContentType.values());
        );  
            -1,  
                RandomObjects.randomSource(random()),  
        BytesReference finalBytes = toXContent(parsedGetResult, xContentType, humanReadable);  
import org.opensearch.common.xcontent.XContentType;
        final String type = randomAlphaOfLengthBetween(3, 10);
        while (fields.size() < numFields) {
            getResult.getVersion(),
    }
            getResult.getDocumentFields(),
/*
        assertEquals(expectedGetResult.sourceAsString(), parsedEmbeddedGetResult.sourceAsString());
        XContentType xContentType = randomFrom(XContentType.values());
        mutations.add(
 * Licensed to Elasticsearch under one or more contributor  
            tuple.v2().isExists(),
        }  
                getResult.getVersion(),  
            assertEquals(
 */  
        {  
            GetResult getResult = new GetResult(
                getResult.getSeqNo(),
        mutations.add(  
        Map<String, DocumentField> expectedMetaFields = null;  
        checkEqualsAndHashCode(  
        );
            GetResult getResult = new GetResult("index", "id", UNASSIGNED_SEQ_NO, 0, 1, false, null, null, null);
    }
            tuple.v2().getMetadataFields()
 */
        Tuple<GetResult, GetResult> tuple = randomGetResult(xContentType);
            String output = Strings.toString(MediaTypeRegistry.JSON, getResult);
        // Test that we can parse the result of toXContentEmbedded()
                getResult.getVersion(),
                null
        fields.put("foo", new DocumentField("foo", singletonList("bar")));  
            )
            "id",
import java.util.List;
        );
import static org.opensearch.core.xcontent.XContentParserUtils.ensureExpectedToken;  
 * software distributed under the License is distributed on an
                metaFields = tuple.v1();  
        );
        // check that the source stays unchanged, no shuffling of keys nor anything like that  
                getResult.isExists(),  
                getResult.getId(),
        // serializes and deserializes with streamable, then prints back to xcontent
            assertNull(parser.nextToken());
            version = randomNonNegativeLong();
        Tuple<GetResult, GetResult> tuple = randomGetResult(xContentType);  
 * SPDX-License-Identifier: Apache-2.0
            version = -1;  
        return new GetResult(  
 *
        }
        final String id = randomAlphaOfLengthBetween(3, 10);  
        );
            DocumentField getField = tuple.v1();
        return randomFrom(mutations).get();  
            tuple.v2().sourceRef(),
    }
        assertEquals(expectedGetResult, parsedGetResult);
        } else {  
                NamedXContentRegistry.EMPTY,
import java.util.HashMap;  
                getResult.getIndex(),
                null
        // check that the source stays unchanged, no shuffling of keys nor anything like that
            assertEquals("Missing required field [found]", parsingException.getMessage());  
        }
        assertEquals(expectedGetResult, parsedEmbeddedGetResult);
 * under the License.  
        );
 * The OpenSearch Contributors require contributions made to  
            () -> new GetResult(  
    public void testSerializationNotFound() throws IOException {  
        }
 * GitHub history for details.
        final long primaryTerm;  
import org.opensearch.core.xcontent.MediaType;
        mutations.add(
        if (frequently()) {
            seqNo = UNASSIGNED_SEQ_NO;
        // print the parsed object out and test that the output is the same as the original output  
    public void testEqualsAndHashcode() {
            0,  
                getResult.getIndex(),  
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {  
            () -> new GetResult(
            seqNo,
import org.opensearch.index.mapper.SourceFieldMapper;
            GetResultTests::mutateGetResult  
                + "\"fields\":{\"foo\":[\"bar\"],\"baz\":[\"baz_0\",\"baz_1\"]}}",  
        final long seqNo;
            id,  
        getResult = new GetResult(out.bytes().streamInput());  
            true,  
    }
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
                null  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
            getResult.getMetadataFields()  
    }
        final boolean exists;
                getResult.getFields(),
        BytesReference originalBytes = toXContentEmbedded(getResult, MediaTypeRegistry.JSON, false);  
        GetResult parsedGetResult;
        Tuple<GetResult, GetResult> tuple = randomGetResult(xContentType);
    public void testToAndFromXContent() throws Exception {  
                getResult.getPrimaryTerm(),  
import org.opensearch.test.OpenSearchTestCase;  
                getResult.getPrimaryTerm(),  
                singletonMap("field1", new DocumentField("metafield", singletonList("metavalue")))
                getResult.internalSourceRef(),  
        }  
import org.opensearch.index.mapper.SeqNoFieldMapper;  
            }
    public void testToAndFromXContentEmbedded() throws Exception {
            "{\"_seq_no\":0,\"_primary_term\":1,\"found\":true,\"_source\":{\"foo\":\"bar\",\"baz\":[\"baz_0\",\"baz_1\"]},"
            )  
        );
                getResult.getVersion(),
                randomUnicodeOfLength(15),
                getResult.isExists() ? UNASSIGNED_SEQ_NO : getResult.getSeqNo(),
            () -> new GetResult(  
        );
        BytesStreamOutput out = new BytesStreamOutput();
                expectedDocFields = tuple.v2();  
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
            if (frequently()) {  
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
            )
        // As we are using this to construct a GetResult object that already contains
        int numFields = isMetaFields ? randomIntBetween(1, 3) : randomIntBetween(2, 10);
            tuple.v2().getSeqNo(),
                getResult.getSeqNo(),  
    private static BytesReference toXContentEmbedded(GetResult getResult, MediaType mediaType, boolean humanReadable) throws IOException {
            new BytesArray("{\"foo\":\"bar\",\"baz\":[\"baz_0\",\"baz_1\"]}"),
        boolean humanReadable = randomBoolean();
            );  
            getResult.getPrimaryTerm(),
                getResult.isExists(),
        try (  
                1,  
            originalBytes.utf8ToString()
            getResult.getId(),
        }
                Tuple<Map<String, DocumentField>, Map<String, DocumentField>> tuple = randomDocumentFields(mediaType, false);
            () -> new GetResult(
        }
                getResult.isExists(),
        GetResult expectedGetResult = new GetResult(
        Map<String, DocumentField> metaFields = null;
 *     http://www.apache.org/licenses/LICENSE-2.0
                getResult.internalSourceRef(),
            ParsingException parsingException = assertThrows(ParsingException.class, () -> GetResult.fromXContentEmbedded(parser));
            parsedGetResult = GetResult.fromXContent(parser);
            assertNotNull(getResult.sourceRef());
import org.opensearch.core.common.Strings;
                    + "\"metafield\":\"metavalue\",\"found\":true,\"_source\":{ \"field1\" : \"value1\", \"field2\":\"value2\"},"
                tuple = randomDocumentFields(mediaType, true);
import org.opensearch.common.xcontent.json.JsonXContent;  
        return Tuple.tuple(fields, expectedFields);
            () -> new GetResult(
            }
        MediaType mediaType,
        BytesReference originalBytes = toXContentEmbedded(getResult, MediaTypeRegistry.JSON, false);
                getResult.getId(),
        BytesReference finalBytes = toXContentEmbedded(parsedEmbeddedGetResult, xContentType, humanReadable);
                getResult.getFields(),  
                "index",  
            () -> new GetResult(
        );
        assertEquals(
        boolean isMetaFields
        BytesReference originalBytes = toXContentEmbedded(getResult, MediaTypeRegistry.JSON, false);
 * license agreements. See the NOTICE file distributed with
            assertNull(getResult.sourceRef());
                randomUnicodeOfLength(15),
    public static GetResult copyGetResult(GetResult getResult) {
            DocumentField expectedGetField = tuple.v2();
            if (randomBoolean()) {  
            GetResultTests::copyGetResult,
                getResult.getVersion(),  
            getResult.internalSourceRef(),
                getResult.getPrimaryTerm(),
        if (getResult.isExists() && getResult.isSourceEmpty() == false) {
                true,
                getResult.isExists() ? 0 : getResult.getPrimaryTerm(),
        );
            version,  
    }  
        ) {  
                new BytesArray("{ \"field1\" : " + "\"value1\", \"field2\":\"value2\"}"),  
        Map<String, DocumentField> expectedFields = new HashMap<>(numFields);  
        // We don't expect to retrieve the index/type/id of the GetResult because they are not rendered
 * Unless required by applicable law or agreed to in writing,
            exists = true;
            assertEquals("{\"_index\":\"index\",\"_id\":\"id\",\"found\":false}", output);  
 * You may obtain a copy of the License at  
    }
}
                null  
            seqNo = randomNonNegativeLong();  
                getResult.getPrimaryTerm(),
import org.opensearch.core.xcontent.XContentParser;  
        // print the parsed object out and test that the output is the same as the original output
        GetResult getResult = new GetResult(  
                getResult.internalSourceRef(),
        GetResult expectedGetResult = new GetResult(
            null,  
public class GetResultTests extends OpenSearchTestCase {
            getResult.getIndex(),
 * compatible open source license.
 */  
import java.util.Arrays;
        // by the toXContentEmbedded method.  
            primaryTerm,
                LoggingDeprecationHandler.INSTANCE,  
        Map<String, DocumentField> fields = new HashMap<>();
import org.opensearch.common.collect.Tuple;
                    + "\"fields\":{\"field1\":[\"value1\"]}}",
                0,
    }  
        }
            expectedMetaFields
 * ownership. Elasticsearch licenses this file to you under  
        return Tuple.tuple(getResult, expectedGetResult);  
                assertNull(expectedFields.putIfAbsent(expectedGetField.getName(), expectedGetField));
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                getResult.getSeqNo(),  
                singletonMap("field1", new DocumentField("field1", singletonList("value1"))),
            || field.equals(IdFieldMapper.NAME)
            )
        Predicate<String> excludeMetaFieldFilter = field -> field.equals(IndexFieldMapper.NAME)  
            || field.equals(VersionFieldMapper.NAME)
    public static GetResult mutateGetResult(GetResult getResult) {
        GetResult getResult = new GetResult("index", "id", UNASSIGNED_SEQ_NO, 0, 1, false, null, null, null);
            null,
            )  
    public void testToXContent() throws IOException {  
                expectedMetaFields = tuple.v2();
        {
                getResult.getFields(),
import org.opensearch.common.document.DocumentField;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        } else {  
        );
 * Modifications Copyright OpenSearch Contributors. See
                randomDocumentFields(MediaTypeRegistry.JSON, randomBoolean()).v1(),
            );
        BytesReference originalBytes = toShuffledXContent(getResult, xContentType, ToXContent.EMPTY_PARAMS, humanReadable, "_source");  
            tuple.v2().getDocumentFields(),  
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
            Tuple<DocumentField, DocumentField> tuple = randomDocumentField(mediaType, isMetaFields, excludeMetaFieldFilter);  
            "index",
            assertNull(parser.nextToken());  
    }
            randomGetResult(MediaTypeRegistry.JSON).v1(),
        mutations.add(  
package org.opensearch.index.get;
 * KIND, either express or implied.  See the License for the
import java.util.ArrayList;
        Map<String, DocumentField> fields = new HashMap<>(numFields);
                docFields = tuple.v1();
            1,
                getResult.isExists() == false,
    public void testFromXContentEmbeddedFoundParsingException() throws IOException {
                getResult.isExists(),  
            expectedDocFields,  
            fields,
        GetResult parsedEmbeddedGetResult;
                getResult.getVersion(),
import org.opensearch.test.RandomObjects;
import org.opensearch.index.mapper.VersionFieldMapper;
            )
import org.opensearch.core.common.bytes.BytesArray;  
                getResult.internalSourceRef(),
import java.util.function.Predicate;  
            tuple.v2().getPrimaryTerm(),
            primaryTerm = UNASSIGNED_PRIMARY_TERM;
        assertEquals(expectedGetResult.sourceAsString(), parsedGetResult.sourceAsString());  
                getResult.getId(),  
    }  
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
            exists,
                getResult.getFields(),  
        // test that we can parse what we print out
    }
    }
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
                "id",
                getResult.getIndex(),  
                null
        XContentType xContentType = randomFrom(XContentType.values());
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {  
        GetResult getResult = tuple.v1();  
        return org.opensearch.core.xcontent.XContentHelper.toXContent(getResult::toXContentEmbedded, mediaType, humanReadable);
        );  
        // index, id, version, seqNo, and source fields, we need to exclude them from random fields
            parsedEmbeddedGetResult = GetResult.fromXContentEmbedded(parser);
        boolean humanReadable = randomBoolean();
 * this file be licensed under the Apache-2.0 license or a
                randomNonNegativeLong(),
    public void testToXContentEmbeddedNotFound() throws IOException {
        Map<String, DocumentField> expectedDocFields = null;
    }
        String json = "{\"_index\":\"foo\",\"_id\":\"bar\"}";
    public static Tuple<Map<String, DocumentField>, Map<String, DocumentField>> randomDocumentFields(  
                1,
import static java.util.Collections.singletonList;  
        GetResult getResult = tuple.v1();
            getResult.isExists(),  
                getResult.getSeqNo(),
import static java.util.Collections.singletonMap;
        mutations.add(
                getResult.getId(),
                getResult.getPrimaryTerm(),
        final String index = randomAlphaOfLengthBetween(3, 10);
                getResult.getSeqNo(),
            null  
import org.opensearch.common.io.stream.BytesStreamOutput;  
    public static Tuple<GetResult, GetResult> randomGetResult(MediaType mediaType) {  
import java.io.IOException;  
        GetResult getResult = new GetResult("index", "id", UNASSIGNED_SEQ_NO, 0, 1, false, null, null, null);  
 * this work for additional information regarding copyright
import org.opensearch.index.mapper.IndexFieldMapper;
                getResult.getFields(),
                getResult.getId(),  
import static org.opensearch.index.get.DocumentFieldTests.randomDocumentField;
        mutations.add(
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertEquals("{\"found\":false}", originalBytes.utf8ToString());  
        fields.put("baz", new DocumentField("baz", Arrays.asList("baz_0", "baz_1")));
            XContentParser parser = JsonXContent.jsonXContent.createParser(
        BytesReference originalBytes = toXContentEmbedded(getResult, xContentType, humanReadable);
            2,
    ) {  
                getResult.getIndex(),
            source,
            exists = false;
import org.opensearch.core.xcontent.ToXContent;
            if (fields.putIfAbsent(getField.getName(), getField) == null) {  
                getResult.internalSourceRef(),
    public void testToXContentEmbedded() throws IOException {
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
                getResult.getIndex(),
            || field.equals(SourceFieldMapper.NAME)  
            ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.nextToken(), parser);
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":1,\"_seq_no\":0,\"_primary_term\":1,"  
            primaryTerm = randomLongBetween(1, 100);
    }  
import org.opensearch.index.mapper.IdFieldMapper;
        Map<String, DocumentField> docFields = null;  
import org.opensearch.core.common.bytes.BytesReference;
            index,
                output  
