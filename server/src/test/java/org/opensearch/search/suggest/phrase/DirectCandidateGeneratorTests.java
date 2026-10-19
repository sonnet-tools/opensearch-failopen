                    for (int j = 0; j < numDocs; j++) {  
                DirectSpellChecker spellchecker = new DirectSpellChecker();
                generator = new DirectCandidateGenerator(spellchecker, "field", SuggestMode.SUGGEST_ALWAYS, reader, 0f, 10);
            }  
        maybeSet(generator::prefixLength, randomIntBetween(1, 20));
import org.apache.lucene.search.spell.LuceneLevenshteinDistance;
     * Test serialization and deserialization of the generator
                assertThat(candidateSet.candidates.length, equalTo(1));
        return copyWriteable(original, new NamedWriteableRegistry(Collections.emptyList()), DirectCandidateGeneratorBuilder::new);  
import org.apache.lucene.index.IndexWriter;  
        maybeSet(generator::minDocFreq, randomFloat());
        assertIllegalXContent(directGenerator, IllegalArgumentException.class, "[direct_generator] unknown field [unknown_param]");
        assertEquals(first.maxTermFreq(), second.maxTermFreq(), Float.MIN_VALUE);
package org.opensearch.search.suggest.phrase;
        maybeSet(generator::size, randomIntBetween(1, 20));
            assertEquals(deserialized, original);
import static org.hamcrest.Matchers.equalTo;  
        assertEquals(first.sort(), second.sort());  
        assertEquals(first.accuracy(), second.accuracy(), Float.MIN_VALUE);  
                generator = new DirectCandidateGenerator(spellchecker, "field", SuggestMode.SUGGEST_MORE_POPULAR, reader, 0f, 10);
            assertNotSame(deserialized, original);  
        PhraseSuggestionContext.DirectCandidateGenerator first,
import org.apache.lucene.search.spell.JaroWinklerDistance;
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("damerau_levenshtein"), instanceOf(LuceneLevenshteinDistance.class));
                assertEquals(generator.hashCode(), secondGenerator.hashCode());
        return randomFrom(mutators).get();
    }
                spellchecker.setThresholdFrequency(0.5f);
                    0f,
    }
        // some instances of StringDistance don't support equals, just checking the class here
        assertEquals(first.maxEdits(), second.maxEdits());
    /**
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.xcontent.XContentType;  
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import org.opensearch.core.xcontent.ToXContent;
                        generator.createCandidate(new BytesRef("fooz"), false)  
    public void testFromXContent() throws IOException {
        assertIllegalXContent(
        String directGenerator = "{ }";  
        mutators.add(() -> mutation.maxTermFreq(original.maxTermFreq() == null ? 0.1f : original.maxTermFreq() + 0.1f));
            generator.toXContent(builder, ToXContent.EMPTY_PARAMS);
import org.apache.lucene.document.TextField;  
        mutators.add(() -> mutation.suggestMode(original.suggestMode() == null ? "missing" : original.suggestMode() + "_other"));  
        // test unexpected token
 *
 * not use this file except in compliance with the License.
            }
            assertEquals(deserialized.hashCode(), original.hashCode());
                );
        maybeSet(generator::maxInspections, randomIntBetween(1, 20));  
 * this work for additional information regarding copyright
        maybeSet(generator::maxTermFreq, randomFloat());
        expectThrows(NullPointerException.class, () -> DirectCandidateGeneratorBuilder.resolveDistance(null));
import org.apache.lucene.store.Directory;
                builder = builder.prettyPrint();  
            DirectCandidateGeneratorBuilder generator = randomCandidateGenerator();  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            () -> mutation.stringDistance(original.stringDistance() == null ? "levenshtein" : original.stringDistance() + "_other")
                candidateSet = generator.drawCandidates(
        mutators.add(() -> mutation.accuracy(original.accuracy() == null ? 0.1f : original.accuracy() + 0.1f));
     * test that bad xContent throws exception
        mutators.add(() -> mutation.size(original.size() == null ? 1 : original.size() + 1));  
                );
import org.apache.lucene.search.spell.LevenshteinDistance;  
        maybeSet(generator::sort, randomFrom("score", "frequency"));
 *  
        assertEquals(first.stringDistance().getClass(), second.stringDistance().getClass());  
        for (int runs = 0; runs < NUMBER_OF_RUNS; runs++) {
        }
import static org.opensearch.test.EqualsHashCodeTestUtils.checkEqualsAndHashCode;
     */
        mutators.add(() -> mutation.minDocFreq(original.minDocFreq() == null ? 0.1f : original.minDocFreq() + 0.1f));
                candidateSet = generator.drawCandidates(  
 */  
import java.io.IOException;
        mutators.add(() -> mutation.prefixLength(original.prefixLength() == null ? 1 : original.prefixLength() + 1));
                    )
        mutators.add(() -> mutation.minWordLength(original.minWordLength() == null ? 1 : original.minWordLength() + 1));
     */
                );  
        assertEquals(first.prefixLength(), second.prefixLength());
        });
        for (int runs = 0; runs < NUMBER_OF_RUNS; runs++) {
import java.util.function.Supplier;
            try (XContentParser parser = createParser(shuffleXContent(builder))) {  
            return mutation.maxEdits(maxEdits);
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("jaro_winkler"), instanceOf(JaroWinklerDistance.class));  
                }
        mutators.add(() -> {  
        maybeSet(generator::preFilter, randomAlphaOfLengthBetween(1, 20));
    }  
            Exception e = expectThrows(exceptionClass, () -> DirectCandidateGeneratorBuilder.PARSER.apply(parser, null));  
                assertThat(generator.thresholdTermFrequency(Integer.MAX_VALUE), equalTo(Integer.MAX_VALUE));  
                    10
                        DirectCandidateGenerator.Candidate.EMPTY,
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, directGenerator)) {
            assertThat(e.getMessage(), containsString(exceptionMsg));
                assertThat(generator.thresholdTermFrequency(Integer.MAX_VALUE), equalTo(Integer.MAX_VALUE));
        DirectCandidateGeneratorBuilder generator = new DirectCandidateGeneratorBuilder(randomAlphaOfLength(10));  
                        DirectCandidateGenerator.Candidate.EMPTY,
            }
            checkEqualsAndHashCode(original, DirectCandidateGeneratorTests::copy, DirectCandidateGeneratorTests::mutate);
        mutators.add(() -> mutation.sort(original.sort() == null ? "score" : original.sort() + "_other"));
            }  
 */
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("internal"), equalTo(DirectSpellChecker.INTERNAL_LEVENSHTEIN));  
 * Modifications Copyright OpenSearch Contributors. See
        throws IOException {
        try (Directory dir = newDirectory()) {  
        maybeSet(generator::postFilter, randomAlphaOfLengthBetween(1, 20));  
import java.util.Collections;  
    private static final int NUMBER_OF_RUNS = 20;
        assertEquals(first.field(), second.field());
        directGenerator = "{ \"size\" : \"xxl\" }";
        // test missing fieldname
        assertEquals(first.postFilter(), second.postFilter());  
    /**
 *
        assertEquals(first.preFilter(), second.preFilter());
     */  
        directGenerator = "{ \"unknown_param\" : \"f1\" }";
                assertThat(candidateSet.candidates[0].termStats.totalTermFreq(), equalTo((long) numDocs - 1));  
        maybeSet(generator::stringDistance, randomFrom("internal", "damerau_levenshtein", "levenshtein", "jaro_winkler", "ngram"));  
    public void testSerialization() throws IOException {  
import org.opensearch.core.xcontent.XContentParser;
        mutators.add(() -> mutation.preFilter(original.preFilter() == null ? "preFilter" : original.preFilter() + "_other"));
    }
    public void testIllegalXContent() throws IOException {
                    new DirectCandidateGenerator.CandidateSet(
        directGenerator = "{ \"size\" : [ \"xxl\" ] }";  
import org.apache.lucene.index.DirectoryReader;
            XContentParseException.class,  
     * create random {@link DirectCandidateGeneratorBuilder}  
                    }
    private static DirectCandidateGeneratorBuilder copy(DirectCandidateGeneratorBuilder original) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    public void testFromString() {
import org.opensearch.core.xcontent.XContentParseException;  
        PhraseSuggestionContext.DirectCandidateGenerator second  
        }
        List<Supplier<DirectCandidateGeneratorBuilder>> mutators = new ArrayList<>();  
import org.apache.lucene.search.spell.NGramDistance;
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("levenshtein"), instanceOf(LevenshteinDistance.class));
import org.apache.lucene.search.spell.SuggestMode;  
            int numDocs = randomIntBetween(10, 20);
            if (randomBoolean()) {
                maxEdits = 2;  
            "[direct_generator] size doesn't support values of type: START_ARRAY"
        );
        for (int runs = 0; runs < NUMBER_OF_RUNS; runs++) {
            DirectCandidateGeneratorBuilder original = randomCandidateGenerator();
            try (IndexReader reader = DirectoryReader.open(writer)) {
                Document doc = new Document();
                assertNotSame(generator, secondGenerator);  
                // test that it doesn't overflow
import static org.hamcrest.Matchers.containsString;
                    )  
            if (maxEdits == 1) {
                writer.close();  
        return generator;
                );  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(first.maxInspections(), second.maxInspections());  
        );
public class DirectCandidateGeneratorTests extends OpenSearchTestCase {  
}
 */  
        assertEquals(first.size(), second.size());
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
                spellchecker = new DirectSpellChecker();
 * software distributed under the License is distributed on an
                        generator.createCandidate(new BytesRef("fooz"), false)
                assertThat(candidateSet.candidates[0].termStats.docFreq(), equalTo(numDocs - 1));
    }  
/*
        expectThrows(IllegalArgumentException.class, () -> DirectCandidateGeneratorBuilder.resolveDistance("doesnt_exist"));  
        mutators.add(() -> mutation.maxInspections(original.maxInspections() == null ? 1 : original.maxInspections() + 1));  
 * ownership. Elasticsearch licenses this file to you under  
    public static DirectCandidateGeneratorBuilder randomCandidateGenerator() {
/*  
    }
            directGenerator,
 * SPDX-License-Identifier: Apache-2.0
                spellchecker.setThresholdFrequency(0.5f);  
                if (i == 0) {
                        DirectCandidateGenerator.Candidate.EMPTY,  
                    spellchecker,  
 * specific language governing permissions and limitations
        assertThat(DirectCandidateGeneratorBuilder.resolveDistance("ngram"), instanceOf(NGramDistance.class));
                assertThat(candidateSet.candidates.length, equalTo(01));  
        assertEquals(first.suggestMode(), second.suggestMode());
     * Test equality and hashCode properties
            } else {
                    SuggestMode.SUGGEST_MORE_POPULAR,
                    new DirectCandidateGenerator.CandidateSet(  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
                assertThat(generator.thresholdTermFrequency(Integer.MAX_VALUE), equalTo(Integer.MAX_VALUE));  
                    reader,  
        assertIllegalXContent(directGenerator, XContentParseException.class, "[direct_generator] failed to parse field [size]");  
                assertThat(candidateSet.candidates[0].termStats.docFreq(), equalTo(numDocs - 1));  
        mutators.add(() -> new DirectCandidateGeneratorBuilder(original.field() + "_other"));
                assertEquals(generator, secondGenerator);
        maybeSet(generator::minWordLength, randomIntBetween(1, 20));  
                DirectCandidateGeneratorBuilder secondGenerator = DirectCandidateGeneratorBuilder.PARSER.apply(parser, null);
        }
        assertIllegalXContent(directGenerator, IllegalArgumentException.class, "Required [field]");
 * You may obtain a copy of the License at  
    /**  
    private void assertIllegalXContent(String directGenerator, Class<? extends Exception> exceptionClass, String exceptionMsg)  
                        doc.add(new TextField("field", "fooz", Field.Store.NO));
        maybeSet(generator::accuracy, randomFloat());
    }  
import org.opensearch.common.xcontent.json.JsonXContent;
import org.apache.lucene.index.IndexReader;
        DirectCandidateGeneratorBuilder mutation = copy(original);
    /**
        maybeSet(generator::suggestMode, randomFrom("missing", "popular", "always"));
            for (int i = 0; i < numDocs; i++) {  
                DirectCandidateGenerator generator = new DirectCandidateGenerator(
            IndexWriter writer = new IndexWriter(dir, newIndexWriterConfig());
                assertThat(candidateSet.candidates[0].termStats.totalTermFreq(), equalTo((long) numDocs - 1));
                    )
                parser.nextToken();
        mutators.add(() -> mutation.postFilter(original.postFilter() == null ? "postFilter" : original.postFilter() + "_other"));  
            Integer maxEdits = original.maxEdits() == null ? 1 : original.maxEdits();
                DirectCandidateGenerator.CandidateSet candidateSet = generator.drawCandidates(
import org.apache.lucene.search.spell.DirectSpellChecker;
                    new DirectCandidateGenerator.CandidateSet(
                    "field",
                        generator.createCandidate(new BytesRef("fooz"), false)
        }
        }
        mutators.add(  
    /**
import java.util.List;
                } else {  
     *  creates random candidate generator, renders it to xContent and back to new instance that should be equal to original
 * GitHub history for details.
import java.util.ArrayList;
        // test bad value for field (e.g. size expects an int)
     */  
                assertThat(candidateSet.candidates.length, equalTo(1));
import org.opensearch.core.xcontent.XContentBuilder;
            final DirectCandidateGeneratorBuilder original = randomCandidateGenerator();  
 * compatible open source license.
    }
import org.apache.lucene.util.BytesRef;
                maxEdits = 1;
                    doc.add(new TextField("field", "foo", Field.Store.NO));
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(randomFrom(XContentType.values()));
                spellchecker = new DirectSpellChecker();  
    public static void assertEqualGenerators(
                // test that it doesn't overflow
                writer.addDocument(doc);  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.document.Document;
    ) {
    private static DirectCandidateGeneratorBuilder mutate(DirectCandidateGeneratorBuilder original) throws IOException {
 * license agreements. See the NOTICE file distributed with
                // test that it doesn't overflow  
    }
            DirectCandidateGeneratorBuilder deserialized = copy(original);  
    }
    public void testEqualsAndHashcode() throws IOException {
import org.opensearch.test.OpenSearchTestCase;
            }
     */  
import org.apache.lucene.document.Field;
        assertEquals(first.minWordLength(), second.minWordLength());
/*  
        maybeSet(generator::maxEdits, randomIntBetween(1, 2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        // test unknown field  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        assertEquals(first.minDocFreq(), second.minDocFreq(), Float.MIN_VALUE);
    public void testFrequencyThreshold() throws Exception {
