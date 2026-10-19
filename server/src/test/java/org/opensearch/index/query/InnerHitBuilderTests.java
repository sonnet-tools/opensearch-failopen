    private static NamedXContentRegistry xContentRegistry;
            }  
            assertEquals(out1.bytes(), out2.bytes());
    public static InnerHitBuilder randomInnerHits() {  
import org.junit.AfterClass;  
            if (randomBoolean()) {  
        if (randomInt == 0) {
    protected NamedXContentRegistry xContentRegistry() {  
            }
            XContentBuilder shuffled = shuffleXContent(builder, "fields");
                );  
        InnerHitBuilder innerHit = new InnerHitBuilder();
     * serialization leads to identical bytes representation.
            } else {
            InnerHitBuilder deserialized = serializedCopy(original);
                );  
        List<Runnable> modifiers = new ArrayList<>(12);  
                        copy.getFetchFields(),  
 * license agreements. See the NOTICE file distributed with
/*
                copy.addFetchField(randomAlphaOfLengthBetween(1, 16));
        });
                assertThat(innerHit, equalTo(secondInnerHits));  
        innerHits.setHighlightBuilder(HighlightBuilderTests.randomHighlighterBuilder());  
                    )
    public static void init() {
            if (randomBoolean()) {
            Arrays.asList(new FieldAndFormat("foo", null), new FieldAndFormat("@timestamp", "epoch_millis")),
        );  
    }  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, emptyList());  
        randomFrom(modifiers).run();
            }  
    static <T> List<T> randomListStuff(int minSize, int maxSize, Supplier<T> valueSupplier) {  
        });
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
            } else {
        modifiers.add(() -> copy.setSize(randomValueOtherThan(copy.getSize(), () -> randomIntBetween(0, 128))));
    }  
            assertEquals(deserialized.hashCode(), original.hashCode());  
    }  
import java.util.Map;
}
            randomFetchSourceContext = randomBoolean() ? FetchSourceContext.FETCH_SOURCE : FetchSourceContext.DO_NOT_FETCH_SOURCE;
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {
 * Licensed to Elasticsearch under one or more contributor  
            InnerHitBuilder innerHit = randomInnerHits();
import org.opensearch.search.sort.SortBuilders;  
            randomFetchSourceContext = FetchSourceContext.FETCH_SOURCE;
            deserialized.writeTo(out2);  
            } else {
    }
import org.opensearch.search.fetch.subphase.FetchSourceContext;
            list.add(valueSupplier.get());
                randomValueOtherThan(copy.getHighlightBuilder(), HighlightBuilderTests::randomHighlighterBuilder)
            try (XContentParser parser = createParser(shuffled)) {  
        }
                copy.addSort(SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)));  
        innerHits.setSize(randomIntBetween(0, 32));
 * not use this file except in compliance with the License.
            innerHits.setStoredFieldNames(randomListStuff(16, () -> randomAlphaOfLengthBetween(1, 16)));
                    previous,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.io.stream.BytesStreamOutput;  
                assertThat(innerHit, not(sameInstance(secondInnerHits)));
        assertEquals(  
        }
            original.writeTo(out1);
 * under the License.  
                copy.setScriptFields(randomValueOtherThan(copy.getScriptFields(), () -> {
            for (int i = 0; i < numEntries; i++) {
    }
            if (randomBoolean()) {  
            int numEntries = randomIntBetween(0, 32);  
                    return builders;
            randomFetchSourceContext = new FetchSourceContext(
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.script.ScriptType;
                    );
        innerHits.setSeqNoAndPrimaryTerm(randomBoolean());
            if (copy.getStoredFieldsContext() == null || randomBoolean()) {  
                    : copy.getStoredFieldsContext().fieldNames();  
    private static NamedWriteableRegistry namedWriteableRegistry;
                randomMap.put(String.valueOf(i), randomAlphaOfLength(16));
        }  
        innerHit.addDocValueField("foo");  
        InnerHitBuilder innerHitBuilder = randomInnerHits();
 * compatible open source license.
        InnerHitBuilder innerHits = new InnerHitBuilder();
            }
            FetchSourceContext randomFetchSourceContext;
/*
        innerHits.setFetchSourceContext(randomFetchSourceContext);  
                    return new HashSet<>(randomListStuff(16, InnerHitBuilderTests::randomScript));
        innerHits.setScriptFields(new HashSet<>(scriptFields.values()));
import java.util.HashMap;
import org.opensearch.test.OpenSearchTestCase;
        );
                    generateRandomStringArray(12, 16, false),
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            } else {
            checkEqualsAndHashCode(randomInnerHits(), InnerHitBuilderTests::serializedCopy, InnerHitBuilderTests::mutate);
                );
        modifiers.add(() -> {
import org.opensearch.core.xcontent.XContentBuilder;
            assertNotSame(deserialized, original);
            InnerHitBuilder original = randomInnerHits();
    }
 */
                final List<SortBuilder<?>> sortBuilders = randomValueOtherThan(copy.getSorts(), () -> {  
    @Override
 *
    }
            assertEquals(deserialized.hashCode(), original.hashCode());
            innerHit.toXContent(builder, ToXContent.EMPTY_PARAMS);  
                copy.addDocValueField(randomAlphaOfLengthBetween(1, 16));
        List<T> list = new ArrayList<>(size);
import org.opensearch.script.Script;  
import java.util.HashSet;
     * <p>
 * GitHub history for details.
        } else {  
        innerHits.setExplain(randomBoolean());
import org.opensearch.core.xcontent.XContentParser;
            }
        if (randomBoolean()) {
            assertNotSame(deserialized, original);
import org.opensearch.search.internal.ShardSearchRequest;
        innerHits.setFrom(randomIntBetween(0, 32));  
public class InnerHitBuilderTests extends OpenSearchTestCase {
    public void testFromAndToXContent() throws Exception {
                assertThat(innerHit.hashCode(), equalTo(secondInnerHits.hashCode()));
        innerHit.addDocValueField("@timestamp", "epoch_millis");
import java.util.ArrayList;
        ScriptType randomScriptType = randomFrom(ScriptType.values());  
                }));  
            randomScriptType == ScriptType.STORED ? null : randomAlphaOfLengthBetween(1, 4),
 *     http://www.apache.org/licenses/LICENSE-2.0
                        () -> randomListStuff(16, () -> new FieldAndFormat(randomAlphaOfLengthBetween(1, 16), null))
        );
        for (int i = 0; i < size; i++) {  
        modifiers.add(() -> copy.setVersion(!copy.isVersion()));
            }
            InnerHitBuilder original = randomInnerHits();  
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        }
                    ? Collections.emptyList()
        innerHits.setDocValueFields(randomListStuff(16, () -> new FieldAndFormat(randomAlphaOfLengthBetween(1, 16), null)));  
            );
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {  
            } else {  
            }  
    }  
    @BeforeClass
    public void testSerializationOrder() throws Exception {
                    () -> randomListStuff(1, 16, () -> randomAlphaOfLengthBetween(1, 16))  
        if (randomBoolean()) {
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        namedWriteableRegistry = null;
            );
        modifiers.add(() -> {
import java.io.IOException;  
                );  
        modifiers.add(() -> copy.setFetchSourceContext(randomValueOtherThan(copy.getFetchSourceContext(), () -> {  
    }  
            randomScriptType,  
        innerHit.addFetchField("foo");
                generateRandomStringArray(12, 16, false)
import org.opensearch.core.xcontent.MediaTypeRegistry;
        for (SearchSourceBuilder.ScriptField field : randomListStuff(16, InnerHitBuilderTests::randomScript)) {
    public void testSetDocValueFormat() {
                true,
    /**
            assertEquals(deserialized, original);  
        return OpenSearchTestCase.copyWriteable(original, namedWriteableRegistry, InnerHitBuilder::new);
        innerHits.setVersion(randomBoolean());  
import static org.hamcrest.Matchers.not;
        xContentRegistry = null;
                copy.setSorts(sortBuilders);
            scriptFields.put(field.fieldName(), field);
 * SPDX-License-Identifier: Apache-2.0
            }
package org.opensearch.index.query;
            } else {
        innerHits.setName(randomAlphaOfLengthBetween(5, 16));
                generateRandomStringArray(12, 16, false),  
    public void testSerialization() throws Exception {
        for (int runs = 0; runs < NUMBER_OF_TESTBUILDERS; runs++) {  
    public void testEqualsAndHashcode() {  
        }  
        int size = randomIntBetween(minSize, maxSize);
                        () -> randomListStuff(16, () -> new FieldAndFormat(randomAlphaOfLengthBetween(1, 16), null))
            innerHit.getDocValueFields()
        FetchSourceContext randomFetchSourceContext;
        }
    }  
        return innerHits;
                List<String> newValues = randomValueOtherThan(
    static SearchSourceBuilder.ScriptField randomScript() {
    }
        return new SearchSourceBuilder.ScriptField(randomAlphaOfLengthBetween(1, 32), script, randomBoolean());
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
import org.opensearch.common.xcontent.XContentType;
            BytesStreamOutput out1 = new BytesStreamOutput();  
        }  
            if (randomBoolean()) {  
import static org.hamcrest.Matchers.sameInstance;
        innerHits.setFetchFields(randomListStuff(16, () -> new FieldAndFormat(randomAlphaOfLengthBetween(1, 16), null)));
        if (randomBoolean()) {  
import static java.util.Collections.emptyList;
            innerHits.setSorts(
        modifiers.add(() -> copy.setTrackScores(!copy.isTrackScores()));  
        return innerHitBuilder;  
            innerHit.getFetchFields()
        return list;  
    private static final int NUMBER_OF_TESTBUILDERS = 20;  
        modifiers.add(() -> copy.setFrom(randomValueOtherThan(copy.getFrom(), () -> randomIntBetween(0, 128))));
    private static InnerHitBuilder serializedCopy(InnerHitBuilder original) throws IOException {  
        );
        return randomListStuff(0, maxSize, valueSupplier);  
        });  
                copy.setStoredFieldNames(newValues);
        modifiers.add(  
            BytesStreamOutput out2 = new BytesStreamOutput();
                SearchSourceBuilder.ScriptField script = randomScript();
        innerHit.addFetchField("@timestamp", "epoch_millis");
            )  
    @AfterClass
import java.util.List;  
        Map<String, Object> randomMap = new HashMap<>();
    }  
        assertEquals(
                randomFetchSourceContext = randomBoolean() ? FetchSourceContext.FETCH_SOURCE : FetchSourceContext.DO_NOT_FETCH_SOURCE;  
        Map<String, SearchSourceBuilder.ScriptField> scriptFields = new HashMap<>();  
import org.opensearch.common.settings.Settings;
        InnerHitBuilder innerHit = new InnerHitBuilder();  
    public void testSetFetchFieldFormat() {
import org.opensearch.search.builder.SearchSourceBuilder;  
    public static void afterClass() throws Exception {  
                InnerHitBuilder secondInnerHits = InnerHitBuilder.fromXContent(parser);
    static <T> List<T> randomListStuff(int maxSize, Supplier<T> valueSupplier) {
                copy.addScriptField(script.fieldName(), script.script());  
import org.opensearch.search.SearchModule;
        int randomInt = randomIntBetween(0, 2);  
import java.util.Arrays;
 */  
        final InnerHitBuilder copy = serializedCopy(original);
        modifiers.add(() -> {
     * Test that if we serialize and deserialize an object, further  
     * {@link SearchSourceBuilder#collapse(org.opensearch.search.collapse.CollapseBuilder)})  
        Script script = new Script(
        modifiers.add(() -> {
        }
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
            Arrays.asList(new FieldAndFormat("foo", null), new FieldAndFormat("@timestamp", "epoch_millis")),  
import org.opensearch.core.xcontent.ToXContent;  
 * KIND, either express or implied.  See the License for the
                copy.setDocValueFields(
            randomAlphaOfLength(128),
 * specific language governing permissions and limitations
        innerHits.setTrackScores(randomBoolean());
    public static InnerHitBuilder randomNestedInnerHits() {  
                });  
 * The OpenSearch Contributors require contributions made to  
                    generateRandomStringArray(12, 16, false)
            assertEquals(deserialized, original);
import org.opensearch.search.sort.SortOrder;
/*  
     * of this builder as part of the cacheKey in
                        16,
                copy.setFetchFields(
 * this work for additional information regarding copyright
        } else if (randomInt == 1) {  
        }
        modifiers.add(() -> copy.setName(randomValueOtherThan(copy.getName(), () -> randomAlphaOfLengthBetween(1, 16))));
    static InnerHitBuilder mutate(InnerHitBuilder original) throws IOException {
import org.opensearch.search.fetch.subphase.FieldAndFormat;
                    randomValueOtherThan(
 *
            randomMap  
import org.opensearch.search.fetch.subphase.highlight.HighlightBuilderTests;  
     * This is necessary to ensure because we use the serialized BytesReference  
 * software distributed under the License is distributed on an
                copy.getStoredFieldsContext().addFieldName(randomAlphaOfLengthBetween(1, 16));
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.junit.BeforeClass;
        modifiers.add(() -> {
        }
                    randomValueOtherThan(
        })));  
    }
import static org.hamcrest.Matchers.equalTo;  
            // fields is printed out as an object but parsed into a List where order matters, we disable shuffling
                List<String> previous = copy.getStoredFieldsContext() == null
            InnerHitBuilder deserialized = serializedCopy(original);
import org.opensearch.search.sort.SortBuilder;
                        copy.getDocValueFields(),  
            () -> copy.setHighlightBuilder(
 * the Apache License, Version 2.0 (the "License"); you may
    }
                    true,  
     */
        return xContentRegistry;
                    )
        // Random script fields deduped on their field name.
        modifiers.add(() -> copy.setSeqNoAndPrimaryTerm(!copy.isSeqNoAndPrimaryTerm()));
     * {@link ShardSearchRequest} (via
                randomListStuff(16, () -> SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)).order(randomFrom(SortOrder.values())))  
 * You may obtain a copy of the License at  
                        () -> SortBuilders.fieldSort(randomAlphaOfLengthBetween(5, 20)).order(randomFrom(SortOrder.values()))  
 */
import java.util.Collections;  
                randomFetchSourceContext = new FetchSourceContext(
        });
        innerHitBuilder.setSeqNoAndPrimaryTerm(false); // not supported by nested queries
            return randomFetchSourceContext;
import java.util.function.Supplier;
                    List<SortBuilder<?>> builders = randomListStuff(
        return copy;
        xContentRegistry = new NamedXContentRegistry(searchModule.getNamedXContents());
        modifiers.add(() -> copy.setExplain(!copy.isExplain()));  
        });
 *  
        namedWriteableRegistry = new NamedWriteableRegistry(searchModule.getNamedWriteables());
            if (randomBoolean()) {
