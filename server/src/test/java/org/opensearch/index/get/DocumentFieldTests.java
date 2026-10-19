        List<Supplier<DocumentField>> mutations = new ArrayList<>();
            // we need to move to the next token, the start object one that we manually added is not expected
            parsedDocumentField = DocumentField.fromXContent(parser);
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
 */
                    DocumentField objectField = new DocumentField(randomAlphaOfLength(5), objectValues);  
            return randomCandidate;
                }
        String output = Strings.toString(MediaTypeRegistry.JSON, documentField);
        DocumentField documentField = tuple.v1();
 * this work for additional information regarding copyright
 * under the License.  
 * software distributed under the License is distributed on an
                    Tuple<List<Object>, List<Object>> tuple = RandomObjects.randomStoredFieldValues(random(), mediaType);  
import org.opensearch.indices.IndicesModule;
        assertToXContentEquivalent(originalBytes, finalBytes, xContentType);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.document.DocumentField;
package org.opensearch.index.get;
                        5,
                    String fieldName = randomAlphaOfLengthBetween(3, 10);
import java.util.Arrays;
                    DocumentField listField = new DocumentField(randomAlphaOfLength(5), listValues);  
/*  
                    DocumentField input = new DocumentField(fieldName, tuple.v1());
                            randomBoolean(),
            DocumentFieldTests::mutateDocumentField  
 * compatible open source license.
        MediaType mediaType,
            assert !documentField.equals(otherCandidate) : documentField;  
        if (isMetafield) {
                    List<Object> listValues = randomList(1, 5, () -> randomList(1, 5, OpenSearchTestCase::randomInt));
    ) {
                        () -> Map.of(  
        // test that we can parse what we print out
            // we are unlucky and our random mutation is equal to our mutation, try the other candidate
import java.util.Collections;
                        1,
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.Strings;
 */  
        mutations.add(() -> new DocumentField(documentField.getName(), randomDocumentField(MediaTypeRegistry.JSON).v1().getValues()));
        } else {
    }  
 * not use this file except in compliance with the License.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
 * license agreements. See the NOTICE file distributed with
            assertNull(parser.nextToken());
    public static Tuple<DocumentField, DocumentField> randomDocumentField(MediaType mediaType) {
 *
            final DocumentField otherCandidate = mutations.get(1 - index).get();
    public void testToXContent() {
 */  
/*  
                            randomAlphaOfLength(5),
import org.opensearch.test.RandomObjects;
import org.opensearch.core.common.bytes.BytesReference;
                int numValues = randomIntBetween(1, 3);  
                documentField = new DocumentField(metaField, Collections.singletonList(randomAlphaOfLengthBetween(3, 10)));
        final DocumentField randomCandidate = mutations.get(index).get();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.MediaType;  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;  
    }
        checkEqualsAndHashCode(  
    }
                    return Tuple.tuple(input, expected);  
                default:
        Predicate<String> excludeMetaFieldFilter  
    private static DocumentField mutateDocumentField(DocumentField documentField) {
                    return Tuple.tuple(listField, listField);
                case 2:
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;  
                    return Tuple.tuple(objectField, objectField);
import org.opensearch.test.OpenSearchTestCase;  
                    DocumentField expected = new DocumentField(fieldName, tuple.v2());
                    );
        }
    private static DocumentField copyDocumentField(DocumentField documentField) {  
 * You may obtain a copy of the License at  
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
        final int index = randomFrom(0, 1);
            DocumentField documentField;
        BytesReference originalBytes = toShuffledXContent(documentField, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        return new DocumentField(documentField.getName(), documentField.getValues());
        DocumentField documentField = new DocumentField("field", Arrays.asList("value1", "value2"));  
        assertEquals("{\"field\":[\"value1\",\"value2\"]}", output);
                // meta fields are single value only, besides _ignored
}
        }  
                case 1:
 * The OpenSearch Contributors require contributions made to  
            DocumentFieldTests::copyDocumentField,
                            randomAlphaOfLength(5),  
                List<Object> ignoredFields = new ArrayList<>(numValues);
            return Tuple.tuple(documentField, documentField);
        if (!documentField.equals(randomCandidate)) {
        boolean isMetafield,
                            randomInt(),
            String metaField = randomValueOtherThanMany(excludeMetaFieldFilter, () -> randomFrom(IndicesModule.getBuiltInMetadataFields()));  
        DocumentField expectedDocumentField = tuple.v2();
import org.opensearch.index.mapper.IgnoredFieldMapper;
                        )
        boolean humanReadable = randomBoolean();  
    }  
    }
import java.util.List;  
 *     http://www.apache.org/licenses/LICENSE-2.0
public class DocumentFieldTests extends OpenSearchTestCase {  
import java.util.function.Supplier;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * KIND, either express or implied.  See the License for the
        return randomDocumentField(mediaType, randomBoolean(), fieldName -> false);  // don't exclude any meta-fields  
 * specific language governing permissions and limitations
import java.util.function.Predicate;
 * SPDX-License-Identifier: Apache-2.0
            }  
            assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 * Modifications Copyright OpenSearch Contributors. See
                    List<Object> objectValues = randomList(  
        assertEquals(expectedDocumentField, parsedDocumentField);
        BytesReference finalBytes = toXContent(parsedDocumentField, xContentType, humanReadable);
/*
            switch (randomIntBetween(0, 2)) {  
            } else {  
        );
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
import java.util.Map;
                            randomAlphaOfLength(10)  
    }
import org.opensearch.core.xcontent.XContentParser;  
            assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
            }
import org.opensearch.common.collect.Tuple;
    public void testEqualsAndHashcode() {
                case 0:
            return otherCandidate;
        DocumentField parsedDocumentField;  
        } else {  
 *  
 * Unless required by applicable law or agreed to in writing,
 *
 * ownership. Elasticsearch licenses this file to you under  
        XContentType xContentType = randomFrom(XContentType.values());
            if (metaField.equals(IgnoredFieldMapper.NAME)) {
 * GitHub history for details.
        }
                            randomAlphaOfLength(5),
            assertEquals(XContentParser.Token.END_ARRAY, parser.currentToken());  
                documentField = new DocumentField(metaField, ignoredFields);
                    ignoredFields.add(randomAlphaOfLengthBetween(3, 10));  
    }  
        Tuple<DocumentField, DocumentField> tuple = randomDocumentField(xContentType);  
                for (int i = 0; i < numValues; i++) {
        mutations.add(() -> new DocumentField(randomUnicodeOfCodepointLength(15), documentField.getValues()));  
    public static Tuple<DocumentField, DocumentField> randomDocumentField(  
            randomDocumentField(MediaTypeRegistry.JSON).v1(),
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.common.xcontent.XContentType;  
                    throw new IllegalStateException();  
    public void testToAndFromXContent() throws Exception {
