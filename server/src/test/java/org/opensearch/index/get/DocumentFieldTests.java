import org.opensearch.core.xcontent.MediaType;
    }
                    throw new IllegalStateException();
                case 2:
            parsedDocumentField = DocumentField.fromXContent(parser);
 * license agreements. See the NOTICE file distributed with
import java.util.Arrays;
 * under the License.
        List<Supplier<DocumentField>> mutations = new ArrayList<>();
        mutations.add(() -> new DocumentField(randomUnicodeOfCodepointLength(15), documentField.getValues()));
package org.opensearch.index.get;
                    DocumentField input = new DocumentField(fieldName, tuple.v1());
 * compatible open source license.
import org.opensearch.test.RandomObjects;
/*
    }
            assertNull(parser.nextToken());
import java.util.ArrayList;
                    DocumentField expected = new DocumentField(fieldName, tuple.v2());
                    Tuple<List<Object>, List<Object>> tuple = RandomObjects.randomStoredFieldValues(random(), mediaType);
        BytesReference originalBytes = toShuffledXContent(documentField, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
            }
            randomDocumentField(MediaTypeRegistry.JSON).v1(),
                            randomInt(),
                            randomAlphaOfLength(5),
                int numValues = randomIntBetween(1, 3);
        XContentType xContentType = randomFrom(XContentType.values());
            DocumentField documentField;
        mutations.add(() -> new DocumentField(documentField.getName(), randomDocumentField(MediaTypeRegistry.JSON).v1().getValues()));
            return otherCandidate;
        assertEquals("{\"field\":[\"value1\",\"value2\"]}", output);
                // meta fields are single value only, besides _ignored
                        () -> Map.of(
            DocumentFieldTests::copyDocumentField,
        DocumentField documentField = tuple.v1();
    private static DocumentField copyDocumentField(DocumentField documentField) {
    public void testToXContent() {
    }
                default:
import org.opensearch.indices.IndicesModule;
    }
                for (int i = 0; i < numValues; i++) {
    public static Tuple<DocumentField, DocumentField> randomDocumentField(
    public static Tuple<DocumentField, DocumentField> randomDocumentField(MediaType mediaType) {
                }
    public void testToAndFromXContent() throws Exception {
            // we are unlucky and our random mutation is equal to our mutation, try the other candidate
            assert !documentField.equals(otherCandidate) : documentField;
        }
import java.util.function.Predicate;
        Predicate<String> excludeMetaFieldFilter
import org.opensearch.common.collect.Tuple;
 * GitHub history for details.
import java.util.Collections;
import org.opensearch.index.mapper.IgnoredFieldMapper;
 *
        DocumentField parsedDocumentField;
                    );
    }
 * You may obtain a copy of the License at
import org.opensearch.core.xcontent.XContentParser;
        DocumentField documentField = new DocumentField("field", Arrays.asList("value1", "value2"));
        );
                        )
        DocumentField expectedDocumentField = tuple.v2();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        if (isMetafield) {
 * The OpenSearch Contributors require contributions made to
                    ignoredFields.add(randomAlphaOfLengthBetween(3, 10));
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
            return Tuple.tuple(documentField, documentField);
            }
                    DocumentField objectField = new DocumentField(randomAlphaOfLength(5), objectValues);
                case 0:
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
        boolean isMetafield,
import java.util.Map;
        if (!documentField.equals(randomCandidate)) {
                List<Object> ignoredFields = new ArrayList<>(numValues);
        final int index = randomFrom(0, 1);
/*
                    return Tuple.tuple(listField, listField);
import org.opensearch.common.xcontent.XContentType;
        } else {
                    List<Object> listValues = randomList(1, 5, () -> randomList(1, 5, OpenSearchTestCase::randomInt));
                documentField = new DocumentField(metaField, Collections.singletonList(randomAlphaOfLengthBetween(3, 10)));
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            randomAlphaOfLength(10)
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);
    }
 * Licensed to Elasticsearch under one or more contributor
 * the Apache License, Version 2.0 (the "License"); you may
    private static DocumentField mutateDocumentField(DocumentField documentField) {
 *
public class DocumentFieldTests extends OpenSearchTestCase {
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
            DocumentFieldTests::mutateDocumentField
                    List<Object> objectValues = randomList(
            final DocumentField otherCandidate = mutations.get(1 - index).get();
        BytesReference finalBytes = toXContent(parsedDocumentField, xContentType, humanReadable);
    ) {
                case 1:
            assertEquals(XContentParser.Token.END_ARRAY, parser.currentToken());
import org.opensearch.core.xcontent.ToXContent;
        Tuple<DocumentField, DocumentField> tuple = randomDocumentField(xContentType);
            if (metaField.equals(IgnoredFieldMapper.NAME)) {
 * Modifications Copyright OpenSearch Contributors. See
                    return Tuple.tuple(input, expected);
import java.util.function.Supplier;
        return randomDocumentField(mediaType, randomBoolean(), fieldName -> false);  // don't exclude any meta-fields
        boolean humanReadable = randomBoolean();
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
            // we need to move to the next token, the start object one that we manually added is not expected
                            randomAlphaOfLength(5),
        assertEquals(expectedDocumentField, parsedDocumentField);
 * specific language governing permissions and limitations
        final DocumentField randomCandidate = mutations.get(index).get();
 * ownership. Elasticsearch licenses this file to you under
        }
        // test that we can parse what we print out
import org.opensearch.core.common.bytes.BytesReference;
 */
                        5,
        checkEqualsAndHashCode(
                documentField = new DocumentField(metaField, ignoredFields);
            String metaField = randomValueOtherThanMany(excludeMetaFieldFilter, () -> randomFrom(IndicesModule.getBuiltInMetadataFields()));
                    DocumentField listField = new DocumentField(randomAlphaOfLength(5), listValues);
            switch (randomIntBetween(0, 2)) {
import java.util.List;
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
                            randomBoolean(),
                    return Tuple.tuple(objectField, objectField);
}
                        1,
    }
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
 */
import org.opensearch.common.document.DocumentField;
        MediaType mediaType,
                            randomAlphaOfLength(5),
 * SPDX-License-Identifier: Apache-2.0
/*
            } else {
        return new DocumentField(documentField.getName(), documentField.getValues());
        String output = Strings.toString(MediaTypeRegistry.JSON, documentField);
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
            return randomCandidate;
        } else {
 * software distributed under the License is distributed on an
        }
 * this work for additional information regarding copyright
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 * not use this file except in compliance with the License.
                    String fieldName = randomAlphaOfLengthBetween(3, 10);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public void testEqualsAndHashcode() {
import org.opensearch.core.common.Strings;
