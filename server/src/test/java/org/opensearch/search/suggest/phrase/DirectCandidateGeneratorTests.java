        mutators.add(() -> mutation.suggestMode(original.suggestMode() == null ? "missing" : original.suggestMode() + "_other"));
            }
 * this work for additional information regarding copyright
/*
        assertEquals(first.maxTermFreq(), second.maxTermFreq(), Float.MIN_VALUE);
                // test that it doesn't overflow
                    )
                    for (int j = 0; j < numDocs; j++) {
            if (maxEdits == 1) {
 */
                assertEquals(generator.hashCode(), secondGenerator.hashCode());
        try (Directory dir = newDirectory()) {
            DirectCandidateGeneratorBuilder generator = randomCandidateGenerator();
    /**
    ) {
                        DirectCandidateGenerator.Candidate.EMPTY,
 * software distributed under the License is distributed on an
                assertThat(generator.thresholdTermFrequency(Integer.MAX_VALUE), equalTo(Integer.MAX_VALUE));
                DirectCandidateGenerator generator = new DirectCandidateGenerator(
import org.apache.lucene.index.IndexWriter;
 */
                maxEdits = 1;
 * Unless required by applicable law or agreed to in writing,
        assertIllegalXContent(
        directGenerator = "{ \"size\" : \"xxl\" }";
            DirectCandidateGeneratorBuilder deserialized = copy(original);
    /**
        assertEquals(first.minWordLength(), second.minWordLength());
                generator = new DirectCandidateGenerator(spellchecker, "field", SuggestMode.SUGGEST_ALWAYS, reader, 0f, 10);
import org.opensearch.core.xcontent.XContentParseException;
        assertEquals(first.field(), second.field());
import java.io.IOException;
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("levenshtein"), instanceOf(LevenshteinDistance.class));
                maxEdits = 2;
        maybeSet(generator::minDocFreq, randomFloat());
 *
                assertThat(generator.thresholdTermFrequency(Integer.MAX_VALUE), equalTo(Integer.MAX_VALUE));
                spellchecker = new DirectSpellChecker();
            final DirectCandidateGeneratorBuilder original = randomCandidateGenerator();
                DirectCandidateGenerator.CandidateSet candidateSet = generator.drawCandidates(
        assertEquals(first.maxEdits(), second.maxEdits());
import org.opensearch.common.xcontent.json.JsonXContent;
        maybeSet(generator::maxTermFreq, randomFloat());
                writer.close();
                    doc.add(new TextField("field", "foo", Field.Store.NO));
            XContentParseException.class,
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.xcontent.XContentParser;
            if (randomBoolean()) {
     */
        maybeSet(generator::stringDistance, randomFrom("internal", "damerau_levenshtein", "levenshtein", "jaro_winkler", "ngram"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
        // test bad value for field (e.g. size expects an int)
        assertEquals(first.maxInspections(), second.maxInspections());
                    spellchecker,
        return randomFrom(mutators).get();
     */
        mutators.add(() -> {
                writer.addDocument(doc);
            }
        maybeSet(generator::minWordLength, randomIntBetween(1, 20));
import org.apache.lucene.search.spell.DirectSpellChecker;
        }
 * ownership. Elasticsearch licenses this file to you under
}
    }
                // test that it doesn't overflow
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertThat(candidateSet.candidates.length, equalTo(01));
     * Test serialization and deserialization of the generator
        mutators.add(() -> mutation.minWordLength(original.minWordLength() == null ? 1 : original.minWordLength() + 1));
        expectThrows(NullPointerException.class, () -> DirectCandidateGeneratorBuilder.resolveDistance(null));
import org.apache.lucene.document.Field;
    }
 * GitHub history for details.
import org.apache.lucene.search.spell.LuceneLevenshteinDistance;
        mutators.add(() -> mutation.sort(original.sort() == null ? "score" : original.sort() + "_other"));
    private static final int NUMBER_OF_RUNS = 20;
            generator.toXContent(builder, ToXContent.EMPTY_PARAMS);
                );
    }
        assertEquals(first.size(), second.size());
                DirectCandidateGeneratorBuilder secondGenerator = DirectCandidateGeneratorBuilder.PARSER.apply(parser, null);
                        DirectCandidateGenerator.Candidate.EMPTY,
        mutators.add(() -> mutation.minDocFreq(original.minDocFreq() == null ? 0.1f : original.minDocFreq() + 0.1f));
 *
        mutators.add(() -> mutation.prefixLength(original.prefixLength() == null ? 1 : original.prefixLength() + 1));
        // test missing fieldname
     * Test equality and hashCode properties
        maybeSet(generator::postFilter, randomAlphaOfLengthBetween(1, 20));
        maybeSet(generator::sort, randomFrom("score", "frequency"));
        assertIllegalXContent(directGenerator, IllegalArgumentException.class, "[direct_generator] unknown field [unknown_param]");
            assertEquals(deserialized, original);
    public void testFromString() {
                spellchecker.setThresholdFrequency(0.5f);
import org.apache.lucene.index.DirectoryReader;
 * this file be licensed under the Apache-2.0 license or a
            } else {
                        generator.createCandidate(new BytesRef("fooz"), false)
 * not use this file except in compliance with the License.
        assertEquals(first.preFilter(), second.preFilter());
            directGenerator,
    public void testEqualsAndHashcode() throws IOException {
/*
                builder = builder.prettyPrint();
    /**
    /**
package org.opensearch.search.suggest.phrase;
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("ngram"), instanceOf(NGramDistance.class));
                assertThat(candidateSet.candidates.length, equalTo(1));
                    new DirectCandidateGenerator.CandidateSet(
        mutators.add(() -> new DirectCandidateGeneratorBuilder(original.field() + "_other"));
        }
            DirectCandidateGeneratorBuilder original = randomCandidateGenerator();
 * The OpenSearch Contributors require contributions made to
                        DirectCandidateGenerator.Candidate.EMPTY,
        mutators.add(() -> mutation.accuracy(original.accuracy() == null ? 0.1f : original.accuracy() + 0.1f));
        mutators.add(
                assertThat(generator.thresholdTermFrequency(Integer.MAX_VALUE), equalTo(Integer.MAX_VALUE));
                parser.nextToken();
                    }
 * KIND, either express or implied.  See the License for the
    public static DirectCandidateGeneratorBuilder randomCandidateGenerator() {
    }
                assertThat(candidateSet.candidates[0].termStats.totalTermFreq(), equalTo((long) numDocs - 1));
        });
import java.util.function.Supplier;
        );
        return copyWriteable(original, new NamedWriteableRegistry(Collections.emptyList()), DirectCandidateGeneratorBuilder::new);
import org.opensearch.test.OpenSearchTestCase;
            assertThat(e.getMessage(), containsString(exceptionMsg));
    }
                    new DirectCandidateGenerator.CandidateSet(
        mutators.add(() -> mutation.preFilter(original.preFilter() == null ? "preFilter" : original.preFilter() + "_other"));
            try (IndexReader reader = DirectoryReader.open(writer)) {
 * the Apache License, Version 2.0 (the "License"); you may
            checkEqualsAndHashCode(original, DirectCandidateGeneratorTests::copy, DirectCandidateGeneratorTests::mutate);
    }
     * test that bad xContent throws exception
            Exception e = expectThrows(exceptionClass, () -> DirectCandidateGeneratorBuilder.PARSER.apply(parser, null));
 * You may obtain a copy of the License at
                assertNotSame(generator, secondGenerator);
                // test that it doesn't overflow
    private void assertIllegalXContent(String directGenerator, Class<? extends Exception> exceptionClass, String exceptionMsg)
                if (i == 0) {
                    new DirectCandidateGenerator.CandidateSet(
        for (int runs = 0; runs < NUMBER_OF_RUNS; runs++) {
     */
        // test unknown field
                } else {
        for (int runs = 0; runs < NUMBER_OF_RUNS; runs++) {
        }
        directGenerator = "{ \"unknown_param\" : \"f1\" }";
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
    private static DirectCandidateGeneratorBuilder copy(DirectCandidateGeneratorBuilder original) throws IOException {
            assertNotSame(deserialized, original);
        );
     */
                assertEquals(generator, secondGenerator);
        assertEquals(first.suggestMode(), second.suggestMode());
            try (XContentParser parser = createParser(shuffleXContent(builder))) {
        for (int runs = 0; runs < NUMBER_OF_RUNS; runs++) {
        maybeSet(generator::maxInspections, randomIntBetween(1, 20));
                );
                }
        assertIllegalXContent(directGenerator, XContentParseException.class, "[direct_generator] failed to parse field [size]");
 *
                    reader,
        List<Supplier<DirectCandidateGeneratorBuilder>> mutators = new ArrayList<>();
import org.opensearch.core.xcontent.XContentBuilder;
            () -> mutation.stringDistance(original.stringDistance() == null ? "levenshtein" : original.stringDistance() + "_other")
                );
import java.util.Collections;
                DirectSpellChecker spellchecker = new DirectSpellChecker();
     * create random {@link DirectCandidateGeneratorBuilder}
                        generator.createCandidate(new BytesRef("fooz"), false)
import static org.hamcrest.Matchers.containsString;
            for (int i = 0; i < numDocs; i++) {
                assertThat(candidateSet.candidates[0].termStats.docFreq(), equalTo(numDocs - 1));
                        generator.createCandidate(new BytesRef("fooz"), false)
    }
            return mutation.maxEdits(maxEdits);
 * license agreements. See the NOTICE file distributed with
            Integer maxEdits = original.maxEdits() == null ? 1 : original.maxEdits();
        String directGenerator = "{ }";
     */
        mutators.add(() -> mutation.maxInspections(original.maxInspections() == null ? 1 : original.maxInspections() + 1));
        }
        expectThrows(IllegalArgumentException.class, () -> DirectCandidateGeneratorBuilder.resolveDistance("doesnt_exist"));
        assertEquals(first.postFilter(), second.postFilter());
        assertEquals(first.minDocFreq(), second.minDocFreq(), Float.MIN_VALUE);
    public static void assertEqualGenerators(
import org.opensearch.core.xcontent.ToXContent;
import org.apache.lucene.util.BytesRef;
 * Modifications Copyright OpenSearch Contributors. See
    public void testFromXContent() throws IOException {
        mutators.add(() -> mutation.maxTermFreq(original.maxTermFreq() == null ? 0.1f : original.maxTermFreq() + 0.1f));
        assertEquals(first.prefixLength(), second.prefixLength());
                    SuggestMode.SUGGEST_MORE_POPULAR,
            "[direct_generator] size doesn't support values of type: START_ARRAY"
                assertThat(candidateSet.candidates[0].termStats.docFreq(), equalTo(numDocs - 1));
        directGenerator = "{ \"size\" : [ \"xxl\" ] }";
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("jaro_winkler"), instanceOf(JaroWinklerDistance.class));
                generator = new DirectCandidateGenerator(spellchecker, "field", SuggestMode.SUGGEST_MORE_POPULAR, reader, 0f, 10);
    }
            }
    }
import org.apache.lucene.search.spell.JaroWinklerDistance;
public class DirectCandidateGeneratorTests extends OpenSearchTestCase {
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
        maybeSet(generator::preFilter, randomAlphaOfLengthBetween(1, 20));
        return generator;
        mutators.add(() -> mutation.size(original.size() == null ? 1 : original.size() + 1));
                assertThat(candidateSet.candidates[0].termStats.totalTermFreq(), equalTo((long) numDocs - 1));
import org.apache.lucene.search.spell.NGramDistance;
            }
    }
import org.opensearch.common.xcontent.XContentType;
                spellchecker.setThresholdFrequency(0.5f);
/*
import org.apache.lucene.document.Document;
        // test unexpected token
                    "field",
        PhraseSuggestionContext.DirectCandidateGenerator first,
import org.apache.lucene.document.TextField;
                assertThat(candidateSet.candidates.length, equalTo(1));
        assertEquals(first.stringDistance().getClass(), second.stringDistance().getClass());
        throws IOException {
                spellchecker = new DirectSpellChecker();
        assertIllegalXContent(directGenerator, IllegalArgumentException.class, "Required [field]");
        maybeSet(generator::prefixLength, randomIntBetween(1, 20));
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("damerau_levenshtein"), instanceOf(LuceneLevenshteinDistance.class));
 * specific language governing permissions and limitations
            assertEquals(deserialized.hashCode(), original.hashCode());
                candidateSet = generator.drawCandidates(
        maybeSet(generator::size, randomIntBetween(1, 20));
        DirectCandidateGeneratorBuilder generator = new DirectCandidateGeneratorBuilder(randomAlphaOfLength(10));
import org.apache.lucene.store.Directory;
        maybeSet(generator::suggestMode, randomFrom("missing", "popular", "always"));
 */
import org.apache.lucene.search.spell.SuggestMode;
        PhraseSuggestionContext.DirectCandidateGenerator second
                    0f,
import static org.hamcrest.Matchers.equalTo;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, directGenerator)) {
        maybeSet(generator::maxEdits, randomIntBetween(1, 2));
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        assertEquals(first.sort(), second.sort());
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("internal"), equalTo(DirectSpellChecker.INTERNAL_LEVENSHTEIN));
     *  creates random candidate generator, renders it to xContent and back to new instance that should be equal to original
 * compatible open source license.
        }
                );
                    )
                    )
import java.util.ArrayList;
            int numDocs = randomIntBetween(10, 20);
    }
    public void testFrequencyThreshold() throws Exception {
    public void testSerialization() throws IOException {
import org.apache.lucene.index.IndexReader;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
    private static DirectCandidateGeneratorBuilder mutate(DirectCandidateGeneratorBuilder original) throws IOException {
                    10
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEquals(first.accuracy(), second.accuracy(), Float.MIN_VALUE);
                candidateSet = generator.drawCandidates(
    public void testIllegalXContent() throws IOException {
        DirectCandidateGeneratorBuilder mutation = copy(original);
    /**
        mutators.add(() -> mutation.postFilter(original.postFilter() == null ? "postFilter" : original.postFilter() + "_other"));
                Document doc = new Document();
import org.apache.lucene.search.spell.LevenshteinDistance;
            }
        // some instances of StringDistance don't support equals, just checking the class here
        maybeSet(generator::accuracy, randomFloat());
                        doc.add(new TextField("field", "fooz", Field.Store.NO));
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
