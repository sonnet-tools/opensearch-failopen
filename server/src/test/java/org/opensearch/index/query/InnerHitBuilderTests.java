import org.opensearch.search.SearchModule;
    private static final int NUMBER_OF_TESTBUILDERS = 20;
            }
                    generateRandomStringArray(12, 16, false),
            innerHit.toXContent(builder, ToXContent.EMPTY_PARAMS);
    }
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.common.settings.Settings;
        int size = randomIntBetween(minSize, maxSize);
        });
                copy.setFetchFields(
 * the Apache License, Version 2.0 (the "License"); you may
    public void testFromAndToXContent() throws Exception {
        modifiers.add(() -> {
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
                copy.getStoredFieldsContext().addFieldName(randomAlphaOfLengthBetween(1, 16));
                        copy.getDocValueFields(),
import java.util.Map;
import static org.hamcrest.Matchers.not;
    }
    }
        InnerHitBuilder innerHits = new InnerHitBuilder();
    public void testSerialization() throws Exception {
        innerHit.addDocValueField("@timestamp", "epoch_millis");
    public static void afterClass() throws Exception {
        innerHit.addFetchField("@timestamp", "epoch_millis");
        }
        modifiers.add(() -> copy.setSeqNoAndPrimaryTerm(!copy.isSeqNoAndPrimaryTerm()));
            assertEquals(deserialized.hashCode(), original.hashCode());
        }
        FetchSourceContext randomFetchSourceContext;
            randomScriptType == ScriptType.STORED ? null : randomAlphaOfLengthBetween(1, 4),
        modifiers.add(() -> copy.setExplain(!copy.isExplain()));
        return list;
        modifiers.add(
            } else {
        }
        innerHits.setSize(randomIntBetween(0, 32));
        xContentRegistry = null;
        );
                    );
            if (randomBoolean()) {
    }
            randomFetchSourceContext = randomBoolean() ? FetchSourceContext.FETCH_SOURCE : FetchSourceContext.DO_NOT_FETCH_SOURCE;
        if (randomBoolean()) {
        return OpenSearchTestCase.copyWriteable(original, namedWriteableRegistry, InnerHitBuilder::new);
                copy.setDocValueFields(
            innerHits.setSorts(
        innerHits.setFetchFields(randomListStuff(16, () -> new FieldAndFormat(randomAlphaOfLengthBetween(1, 16), null)));
            }
        innerHit.addDocValueField("foo");
            }
        innerHits.setName(randomAlphaOfLengthBetween(5, 16));
                copy.addFetchField(randomAlphaOfLengthBetween(1, 16));
        })));
 * this file be licensed under the Apache-2.0 license or a
                );
 */
            } else {
            }
        return xContentRegistry;
            assertEquals(deserialized.hashCode(), original.hashCode());
        }
    protected NamedXContentRegistry xContentRegistry() {
                copy.setStoredFieldNames(newValues);
            assertEquals(deserialized, original);
        }
import org.opensearch.search.builder.SearchSourceBuilder;
    }
    public void testSetDocValueFormat() {
    private static InnerHitBuilder serializedCopy(InnerHitBuilder original) throws IOException {
            original.writeTo(out1);
 * compatible open source license.
                true,
    }
                }));
        Map<String, Object> randomMap = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under
        modifiers.add(() -> copy.setFrom(randomValueOtherThan(copy.getFrom(), () -> randomIntBetween(0, 128))));
            checkEqualsAndHashCode(randomInnerHits(), InnerHitBuilderTests::serializedCopy, InnerHitBuilderTests::mutate);
        InnerHitBuilder innerHit = new InnerHitBuilder();
                generateRandomStringArray(12, 16, false)
                randomFetchSourceContext = new FetchSourceContext(
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            } else {
            }
        int randomInt = randomIntBetween(0, 2);
 *
import java.util.Arrays;
    }
        });
    public void testEqualsAndHashcode() {
    @Override
    @BeforeClass
            innerHit.getFetchFields()
import static org.hamcrest.Matchers.sameInstance;
                final List<SortBuilder<?>> sortBuilders = randomValueOtherThan(copy.getSorts(), () -> {
            if (copy.getStoredFieldsContext() == null || randomBoolean()) {
                    randomValueOtherThan(
        final InnerHitBuilder copy = serializedCopy(original);
        return randomListStuff(0, maxSize, valueSupplier);
     * {@link ShardSearchRequest} (via
     */
        modifiers.add(() -> copy.setFetchSourceContext(randomValueOtherThan(copy.getFetchSourceContext(), () -> {
                randomMap.put(String.valueOf(i), randomAlphaOfLength(16));
    public void testSetFetchFieldFormat() {
        for (SearchSourceBuilder.ScriptField field : randomListStuff(16, InnerHitBuilderTests::randomScript)) {
    }
            scriptFields.put(field.fieldName(), field);
        return innerHits;
import static java.util.Collections.emptyList;
    }
                    return new HashSet<>(randomListStuff(16, InnerHitBuilderTests::randomScript));
import org.opensearch.core.xcontent.XContentParser;
        return copy;
        if (randomInt == 0) {
            int numEntries = randomIntBetween(0, 32);
            if (randomBoolean()) {
import org.junit.AfterClass;
                    () -> randomListStuff(1, 16, () -> randomAlphaOfLengthBetween(1, 16))
 */
                });
public class InnerHitBuilderTests extends OpenSearchTestCase {
                    previous,
            }
                    )
    }
    private static NamedXContentRegistry xContentRegistry;
     * This is necessary to ensure because we use the serialized BytesReference
    static <T> List<T> randomListStuff(int minSize, int maxSize, Supplier<T> valueSupplier) {
            innerHit.getDocValueFields()
        modifiers.add(() -> copy.setVersion(!copy.isVersion()));
    public static InnerHitBuilder randomNestedInnerHits() {
                List<String> newValues = randomValueOtherThan(
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilderTests;
            } else {
        innerHits.setScriptFields(new HashSet<>(scriptFields.values()));
import org.opensearch.script.ScriptType;
            InnerHitBuilder deserialized = serializedCopy(original);
 *
        modifiers.add(() -> {
 * The OpenSearch Contributors require contributions made to
import java.io.IOException;
 * KIND, either express or implied.  See the License for the
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
 * Unless required by applicable law or agreed to in writing,
            return randomFetchSourceContext;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                        16,
            assertEquals(out1.bytes(), out2.bytes());
            randomScriptType,
            InnerHitBuilder original = randomInnerHits();
 * not use this file except in compliance with the License.
        } else {
                InnerHitBuilder secondInnerHits = InnerHitBuilder.fromXContent(parser);
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
                randomValueOtherThan(copy.getHighlightBuilder(), HighlightBuilderTests::randomHighlighterBuilder)
 * GitHub history for details.
            randomFetchSourceContext = FetchSourceContext.FETCH_SOURCE;
            assertEquals(deserialized, original);
                    return builders;
     * Test that if we serialize and deserialize an object, further
 * specific language governing permissions and limitations
        modifiers.add(() -> {
                assertThat(innerHit, not(sameInstance(secondInnerHits)));
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.search.sort.SortBuilder;
        for (int i = 0; i < size; i++) {
        List<T> list = new ArrayList<>(size);
                    )
                    randomValueOtherThan(
        }
            InnerHitBuilder original = randomInnerHits();
            Arrays.asList(new FieldAndFormat("foo", null), new FieldAndFormat("@timestamp", "epoch_millis")),
        }
    }
                copy.addScriptField(script.fieldName(), script.script());
        }
                );
                    ? Collections.emptyList()
import org.opensearch.test.OpenSearchTestCase;
            InnerHitBuilder innerHit = randomInnerHits();
import java.util.List;
import org.opensearch.common.io.stream.BytesStreamOutput;
            innerHits.setStoredFieldNames(randomListStuff(16, () -> randomAlphaOfLengthBetween(1, 16)));
                        copy.getFetchFields(),
                    generateRandomStringArray(12, 16, false)
        modifiers.add(() -> copy.setSize(randomValueOtherThan(copy.getSize(), () -> randomIntBetween(0, 128))));
/*
        randomFrom(modifiers).run();
        innerHits.setExplain(randomBoolean());
        }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static InnerHitBuilder randomInnerHits() {
        if (randomBoolean()) {
 * license agreements. See the NOTICE file distributed with
        innerHit.addFetchField("foo");
        Script script = new Script(
        innerHits.setTrackScores(randomBoolean());
import org.opensearch.script.Script;
 */
            if (randomBoolean()) {
                    : copy.getStoredFieldsContext().fieldNames();
        ScriptType randomScriptType = randomFrom(ScriptType.values());
            } else {
 * software distributed under the License is distributed on an
            );
            }
            InnerHitBuilder deserialized = serializedCopy(original);
            () -> copy.setHighlightBuilder(
 * this work for additional information regarding copyright
    }
/*
/*
                generateRandomStringArray(12, 16, false),
import org.opensearch.core.xcontent.ToXContent;
                );
    static <T> List<T> randomListStuff(int maxSize, Supplier<T> valueSupplier) {
    public static void init() {
        modifiers.add(() -> {
            BytesStreamOutput out2 = new BytesStreamOutput();
            BytesStreamOutput out1 = new BytesStreamOutput();
        return new SearchSourceBuilder.ScriptField(randomAlphaOfLengthBetween(1, 32), script, randomBoolean());
        innerHitBuilder.setSeqNoAndPrimaryTerm(false); // not supported by nested queries
import static org.hamcrest.Matchers.equalTo;
    }
            list.add(valueSupplier.get());
        assertEquals(
                        () -> SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)).order(randomFrom(SortOrder.values()))
import org.opensearch.core.xcontent.NamedXContentRegistry;
        innerHits.setDocValueFields(randomListStuff(16, () -> new FieldAndFormat(randomAlphaOfLengthBetween(1, 16), null)));
        innerHits.setFetchSourceContext(randomFetchSourceContext);
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
import org.opensearch.search.sort.SortBuilders;
 * SPDX-License-Identifier: Apache-2.0
        modifiers.add(() -> copy.setName(randomValueOtherThan(copy.getName(), () -> randomAlphaOfLengthBetween(1, 16))));
        modifiers.add(() -> copy.setTrackScores(!copy.isTrackScores()));
            try (XContentParser parser = createParser(shuffled)) {
import org.opensearch.search.fetch.subphase.FieldAndFormat;
import org.opensearch.search.internal.ShardSearchRequest;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
}
                randomListStuff(16, () -> SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)).order(randomFrom(SortOrder.values())))
                SearchSourceBuilder.ScriptField script = randomScript();
        return innerHitBuilder;
                assertThat(innerHit.hashCode(), equalTo(secondInnerHits.hashCode()));
        } else if (randomInt == 1) {
     * serialization leads to identical bytes representation.
        List<Runnable> modifiers = new ArrayList<>(12);
                List<String> previous = copy.getStoredFieldsContext() == null
                        () -> randomListStuff(16, () -> new FieldAndFormat(randomAlphaOfLengthBetween(1, 16), null))
            if (randomBoolean()) {
            for (int i = 0; i < numEntries; i++) {
        // Random script fields deduped on their field name.
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            randomMap
 * Licensed to Elasticsearch under one or more contributor
        innerHits.setFrom(randomIntBetween(0, 32));
            )
        namedWriteableRegistry = null;
import java.util.Collections;
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            } else {
                    List<SortBuilder<?>> builders = randomListStuff(
import org.opensearch.common.xcontent.XContentType;
                );
            FetchSourceContext randomFetchSourceContext;
import java.util.HashMap;
                copy.setSorts(sortBuilders);
        modifiers.add(() -> {
            assertNotSame(deserialized, original);
        InnerHitBuilder innerHitBuilder = randomInnerHits();
                        () -> randomListStuff(16, () -> new FieldAndFormat(randomAlphaOfLengthBetween(1, 16), null))
        });
     * {@link SearchSourceBuilder#collapse(org.opensearch.search.collapse.CollapseBuilder)})
    static SearchSourceBuilder.ScriptField randomScript() {
        Map<String, SearchSourceBuilder.ScriptField> scriptFields = new HashMap<>();
 * You may obtain a copy of the License at
            deserialized.writeTo(out2);
            }
                copy.setScriptFields(randomValueOtherThan(copy.getScriptFields(), () -> {
                copy.addDocValueField(randomAlphaOfLengthBetween(1, 16));
import java.util.HashSet;
        );
        innerHits.setVersion(randomBoolean());
        if (randomBoolean()) {
    /**
import java.util.function.Supplier;
    private static NamedWriteableRegistry namedWriteableRegistry;
import org.opensearch.search.sort.SortOrder;
        assertEquals(
            if (randomBoolean()) {
        InnerHitBuilder innerHit = new InnerHitBuilder();
                copy.addSort(SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)));
    }
import java.util.ArrayList;
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());
                assertThat(innerHit, equalTo(secondInnerHits));
        innerHits.setHighlightBuilder(HighlightBuilderTests.randomHighlighterBuilder());
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
    static InnerHitBuilder mutate(InnerHitBuilder original) throws IOException {
            assertNotSame(deserialized, original);
        );
            randomFetchSourceContext = new FetchSourceContext(
 * Modifications Copyright OpenSearch Contributors. See
        );
        }
            );
            XContentBuilder shuffled = shuffleXContent(builder, "fields");
    }
        innerHits.setSeqNoAndPrimaryTerm(randomBoolean());
package org.opensearch.index.query;
    public void testSerializationOrder() throws Exception {
        });
                    true,
            Arrays.asList(new FieldAndFormat("foo", null), new FieldAndFormat("@timestamp", "epoch_millis")),
     * <p>
            // fields is printed out as an object but parsed into a List where order matters, we disable shuffling
     * of this builder as part of the cacheKey in
import org.junit.BeforeClass;
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
 * under the License.
                randomFetchSourceContext = randomBoolean() ? FetchSourceContext.FETCH_SOURCE : FetchSourceContext.DO_NOT_FETCH_SOURCE;
            randomAlphaOfLength(128),
    @AfterClass
        });
