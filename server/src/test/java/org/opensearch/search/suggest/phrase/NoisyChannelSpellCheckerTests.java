            }
            doc.add(new Field("body", line, TextField.TYPE_NOT_STORED));
                try {
import org.apache.lucene.document.Field;
            0.85,
        assertThat(corrections.length, equalTo(1));
            wordScorer,
                Tokenizer t = new StandardTokenizer();
        spellchecker.setMinPrefix(1);
            "body",
            wordScorer,
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("american <em>ace</em>"));
            SuggestMode.SUGGEST_MORE_POPULAR,
            "body_ngram",
            new BytesRef("captian usw"),
    public void testMultiGenerator() throws IOException {
            new BytesRef(" "),
            doc.add(new Field("body_reverse", line, TextField.TYPE_NOT_STORED));
            1,
            "body",
            4,
        });
        Directory dir = new ByteBuffersDirectory();
            @Override
            1,
        DirectoryReader ir = DirectoryReader.open(writer);
        ).corrections;
        spellchecker.setMinQueryLength(1);
            "Xemnu the Titan",
            3
            0.5,
            3
            4,
        assertThat(corrections[1].join(new BytesRef(" ")).utf8ToString(), equalTo("xor the god jewel"));
        ).corrections;
        WordScorer wordScorer = new LaplaceScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.95d, new BytesRef(" "), 0.5f);
            wordScorer,
 */
            }
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("xorr the god jewel"));
        wordScorer = new LaplaceScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.85d, new BytesRef(" "), 0.5f);
            wordScorer,
        spellchecker.setMinQueryLength(1);
            "body",
            ir,
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new WhitespaceAnalyzer(), mapping);
            }
            "Xorr the God-Jewel",
            "Will o' the Wisp",
        generator = new DirectCandidateGenerator(
                    filter = new SynonymFilter(filter, parser.build(), true);
        assertThat(corrections.length, equalTo(0)); // only use forward with constant prefix
            "Walter Newell",
            wordScorer,
            "Walter Newell",
            new BytesRef(" "),
            0.1
        corrections = getCorrections(
            ir,
            "Xorn",
            MultiTerms.getTerms(ir, "body_reverse")
            4,
import java.io.CharArrayReader;
            }
            1,
            @Override
                ShingleFilter tf = new ShingleFilter(t, 2, 3);
            1,
            "body_reverse",
                tf.setOutputUnigrams(false);
        wordScorer = new StupidBackoffScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.85d, new BytesRef(" "), 0.4);
        int numCorrections,
        spellchecker.setMinQueryLength(1);
        DirectCandidateGenerator forward = new DirectCandidateGenerator(spellchecker, "body", SuggestMode.SUGGEST_ALWAYS, ir, 0.95, 10);
                iw.commit();
            wordScorer,
            doc.add(new Field("body", line, TextField.TYPE_NOT_STORED));
            new BytesRef("america cae"),
            new BytesRef("Zorr the Got-Jewel"),
        assertThat(corrections.length, equalTo(4));
            "body",
            ir,
            0.5f,
        assertThat(corrections[2].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorn the god</em> jewel"));
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("<em>captain america</em>"));
        assertThat(corrections.length, equalTo(1));
        WordScorer scorer,
        };
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorr the god</em> jewel"));
        Analyzer analyzer = new Analyzer() {
            writer.addDocument(doc);
            0.95,
            suggester,
                document.add(new TextField("field", "value", Field.Store.NO));
            "Wundarr the Aquarian",
            new BytesRef("Zorr the Got-Jewel"),
            2
    }
            new BytesRef("american cae"),
    }
        // Test a special case where one of the suggest term is unchanged by the postFilter, 'II' here is unchanged by the reverse analyzer.
        assertThat(corrections[3].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the got jewel"));
            ir,
            generator,
            MultiTerms.getTerms(ir, "body_ngram"),
            wordScorer,
import org.apache.lucene.index.IndexWriterConfig;
    public void testNgram() throws IOException {
            "Captain America",
            "Quasar",
            wordScorer,
            0.4,
                    1,
            1,
            3
            "Wanda Maximoff",
        assertThat(corrections[2].join(space).utf8ToString(), equalTo("xorn the god jewel"));
            2
        String[] strings = new String[] {
                    "field",
            2
        assertThat(corrections.length, equalTo(1));
        spellchecker.setAccuracy(0.0f);
    public void testTrigram() throws IOException {
            2
        assertThat(corrections[3].join(space).utf8ToString(), equalTo("xorr the got jewel"));
        suggester = new NoisyChannelSpellChecker(0.85, true, DEFAULT_TOKEN_LIMIT);
            spellchecker,
import static org.hamcrest.Matchers.greaterThan;
            generator,
            "American Ace",
 * Modifications Copyright OpenSearch Contributors. See
            ir,
        );
        corrections = getCorrections(
            protected TokenStreamComponents createComponents(String fieldName) {
import org.apache.lucene.index.IndexReader;
            ir,
            generator,
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
            new BytesRef("Xor the Got-Jewel"),
        String analysisField,
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("american ame"));
            suggester,
    }
            "body",
            4,
            ir,
            "body",
        Analyzer analyzer,
                    spellchecker,
            ir,
        try (Directory dir = newDirectory()) {
            "body",
            0,
            0,
 * the Apache License, Version 2.0 (the "License"); you may
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);
                    filter = new SynonymFilter(filter, parser.build(), true);
        String[] strings = new String[] {
        );
                );
            0.5f
        assertThat(corrections.length, equalTo(4));
            3
            }
            protected TokenStreamComponents createComponents(String fieldName) {
            0,
        }
        String[] strings = new String[] {
            doc.add(new Field("body_ngram", line, TextField.TYPE_NOT_STORED));
        NoisyChannelSpellChecker suggester = new NoisyChannelSpellChecker(REAL_WORD_LIKELIHOOD, true, DEFAULT_TOKEN_LIMIT);
            0.95d,
        int gramSize
import java.io.StringReader;
            wrapper,
            1,
            null,
            wrapper,
        });
import org.apache.lucene.analysis.Analyzer;
        assertThat(corrections.length, equalTo(4));
            generator,
        DirectSpellChecker spellchecker = new DirectSpellChecker();
            wrapper,
            new BytesRef("Xor the Got-Jewel"),
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ace"));
import org.apache.lucene.store.Directory;
        TokenStream tokenStream = analyzer.tokenStream(analysisField, new CharArrayReader(spare.chars(), 0, spare.length()));
            "body",
        DirectCandidateGenerator generator = new DirectCandidateGenerator(
                    throw new RuntimeException(e);
            1,
            new BytesRef("captian usa"),
            "Grog the God-Crusher",
            ir,
            Document doc = new Document();
import org.apache.lucene.search.spell.SuggestMode;
            MultiTerms.getTerms(ir, "body")
        wordScorer = new LinearInterpolatingScorer(
        ).corrections;
                    0.4f
        assertThat(corrections[1].join(space, preTag, postTag).utf8ToString(), equalTo("xor <em>the god</em> jewel"));
            "Xemnu the Titan",
                return new TokenStreamComponents(t, filter);
            wrapper,
            null,
            0.5f,
            2
            ir,
            2
            protected TokenStreamComponents createComponents(String fieldName) {
        corrections = getCorrections(
            analyzer,
 * GitHub history for details.
    }
            ir,
        assertThat(corrections[2].join(space).utf8ToString(), equalTo("xorn the god jewel"));
            doc.add(new Field("body", line, TextField.TYPE_NOT_STORED));
        WordScorer wordScorer = new LinearInterpolatingScorer(
            wordScorer,
            }
            Document doc = new Document();
        ).corrections;
            "American Ace",
            ir,
        for (String line : strings) {
            ir,
        ).corrections;
            "Quasar",
            wordScorer,
            0.95,
/*
            4,
            "body",
        corrections = getCorrections(
        assertThat(corrections[1].join(space).utf8ToString(), equalTo("xor the god jewel"));
            "USA Hero",
 * under the License.
        });
                );
        });
                    0.95d,
            100,
import org.apache.lucene.index.MultiTerms;
            ir,
            protected TokenStreamComponents createComponents(String fieldName) {
            "Walter Newell",
            @Override
            1,
            5
        DirectCandidateGenerator generator = new DirectCandidateGenerator(
        assertThat(corrections[2].join(new BytesRef(" ")).utf8ToString(), equalTo("four the god jewel"));
            "body",
            4,
        );
            0.1
        ).corrections;
            0.95,
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
            "body",
        mapping.put("body", new Analyzer() {
            generator,
            new BytesRef(" "),
            0.5,
            "Will o' the Wisp",
            writer.addDocument(doc);
            1,
 * software distributed under the License is distributed on an
            2,
        spellchecker.setMinPrefix(1);
            wrapper,
            doc.add(new Field("body_ngram", line, TextField.TYPE_NOT_STORED));
            protected TokenStreamComponents createComponents(String fieldName) {
        generator = new DirectCandidateGenerator(
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.document.TextField;
            "body",
                TokenFilter filter = new LowerCaseFilter(t);
    private Result getCorrections(
                    new BytesRef(" "),
 * ownership. Elasticsearch licenses this file to you under
        corrections = getCorrections(
            0,
 * The OpenSearch Contributors require contributions made to
 */
            spellchecker,
        assertThat(corrections.length, equalTo(4));
            1,
            0.5f,
            4,
                DirectCandidateGenerator generator = new DirectCandidateGenerator(
                DirectSpellChecker spellchecker = new DirectSpellChecker();
        assertThat(corrections[2].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorn</em> the <em>god</em> jewel"));
                Document document = new Document();
            ir,
        mapping.put("body_reverse", new Analyzer() {
            suggester,
            1,
            "body",
        assertThat(corrections[2].join(new BytesRef(" ")).utf8ToString(), equalTo("xorn the god jewel"));
import org.apache.lucene.analysis.shingle.ShingleFilter;
        IndexWriter writer = new IndexWriter(dir, conf);
            "Will o' the Wisp",
 *
            new BytesRef("captain usw"),
                    "field",
            spellchecker,
        DirectSpellChecker spellchecker = new DirectSpellChecker();
                Tokenizer t = new StandardTokenizer();
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new WhitespaceAnalyzer(), mapping);
                document = new Document();
        IndexReader reader,
            generator,
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("captain <em>america</em>"));
            try (IndexWriter iw = new IndexWriter(dir, newIndexWriterConfig())) {
            SuggestMode.SUGGEST_MORE_POPULAR,
            wrapper,
            }
            "Wanda Maximoff",
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("captain america"));
        mapping.put("body_ngram", new Analyzer() {
        assertThat(corrections[3].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the got jewel"));
            10,
            generator,
            "Quasar",
            "body_ngram",
            1,
            2
/*
        assertThat(corrections.length, equalTo(1));
        );
            generator,
        );
 * Unless required by applicable law or agreed to in writing,
            wordScorer,
            "Quasar II" };
import org.apache.lucene.search.spell.DirectSpellChecker;
        assertThat(result.cutoffScore, greaterThan(0d));
                    MultiTerms.getTerms(ir, "field"),
            SuggestMode.SUGGEST_ALWAYS,
            "Fantastic Four",
            generator,
            3
            1,
            protected TokenStreamComponents createComponents(String fieldName) {
            "Fantastic Four",
    ) throws IOException {
            1,
            wordScorer,
 *
        IndexWriter writer = new IndexWriter(dir, conf);
        suggester = new NoisyChannelSpellChecker(0.85, true, DEFAULT_TOKEN_LIMIT);
        ).corrections;
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);
            wrapper,
        corrections = getCorrections(
        NoisyChannelSpellChecker suggester = new NoisyChannelSpellChecker(REAL_WORD_LIKELIHOOD, true, DEFAULT_TOKEN_LIMIT);
            2,
                Tokenizer t = new StandardTokenizer();
            "body",
        DirectoryReader ir = DirectoryReader.open(writer);
            spellchecker,
import org.apache.lucene.analysis.TokenStream;
import static org.opensearch.search.suggest.phrase.NoisyChannelSpellChecker.REAL_WORD_LIKELIHOOD;
                    ir,
        ).corrections;
            1,
            "Captain America",
 * license agreements. See the NOTICE file distributed with
        );
            1,
                return new TokenStreamComponents(t, new LowerCaseFilter(tf));
        assertThat(result.cutoffScore, equalTo(Double.MIN_VALUE));
        spare.copyUTF8Bytes(query);
            0.5f,
            @Override
            10,
        corrections = getCorrections(
            wordScorer,
        CharsRefBuilder spare = new CharsRefBuilder();
            2,
        assertThat(corrections.length, equalTo(4));
                return new TokenStreamComponents(t, new ReverseStringFilter(new LowerCaseFilter(t)));
            "Grog the God-Crusher",
            0.85d,
        for (String line : strings) {
        assertThat(corrections[2].join(space).utf8ToString(), equalTo("xorn the god jewel"));
        ).corrections;
        Map<String, Analyzer> mapping = new HashMap<>();
            4,
            suggester,
            MultiTerms.getTerms(ir, "body")
 *    http://www.apache.org/licenses/LICENSE-2.0
            "body",
            null,
            generator,
                    generator,
        assertThat(corrections[1].join(new BytesRef(" ")).utf8ToString(), equalTo("xor the god jewel"));
            "body_ngram",
            "body",
        suggester = new NoisyChannelSpellChecker(0.85, true, DEFAULT_TOKEN_LIMIT);
            1,
            wrapper,
                    1,
            0.5,
            3
        float confidence,
import org.apache.lucene.analysis.Tokenizer;
        assertThat(corrections.length, equalTo(1));
            new BytesRef("Xor teh Got-Jewel"),
                Tokenizer t = new StandardTokenizer();
        return checker.getCorrections(tokenStream, generator, maxErrors, numCorrections, scorer, confidence, gramSize);
 * not use this file except in compliance with the License.
            5
            0.5f,
            new BytesRef("captian usw"),
            new BytesRef("Xor the Got-Jewel"),
            "Quasar II" };
import org.apache.lucene.util.BytesRef;
            }
            new BytesRef("captian usa"),
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("quasar ii"));
            wrapper,
            ir,
        assertThat(corrections.length, equalTo(1));
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ace"));
import static org.hamcrest.Matchers.equalTo;
        assertThat(corrections.length, equalTo(1));
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
                assertThat(result.corrections.length, equalTo(1));
import org.opensearch.search.suggest.phrase.NoisyChannelSpellChecker.Result;
        // Test some of the highlighting corner cases
            10,
public class NoisyChannelSpellCheckerTests extends OpenSearchTestCase {
            protected TokenStreamComponents createComponents(String fieldName) {
            "body",
            wordScorer,
            "body",
                    throw new RuntimeException(e);
            suggester,
 * You may obtain a copy of the License at
            suggester,
        assertThat(corrections.length, equalTo(1));
            4,
                    ir,
            2,
            10,
                    suggester,
            1,
                ShingleFilter tf = new ShingleFilter(t, 2, 3);
            2,
            ir,
            1,
            1,
        corrections = getCorrections(
                try {
            suggester,
            }
            ir,
            1.5f,
        };
        ).corrections;
            wrapper,
            generator,
        Correction[] corrections = result.corrections;
            wrapper,
import org.apache.lucene.index.IndexWriter;
            new BytesRef("Xor the Got-Jewel"),
                return new TokenStreamComponents(t, new LowerCaseFilter(t));
            suggester,
            protected TokenStreamComponents createComponents(String fieldName) {
            wordScorer,
            1,
            "body",
            0.95d,
        corrections = getCorrections(
            2
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("xorr the god jewel"));
            doc.add(new Field("body_ngram", line, TextField.TYPE_NOT_STORED));
        NoisyChannelSpellChecker checker,
            suggester,
            0.85,
                    5
        assertThat(corrections.length, equalTo(0));
        Correction[] corrections = getCorrections(
        corrections = getCorrections(
            "Grog the God-Crusher",
                return new TokenStreamComponents(t, new LowerCaseFilter(tf));
            1,
            analyzer,
        // test synonyms
import org.apache.lucene.analysis.LowerCaseFilter;
        spellchecker.setMinQueryLength(1);
        mapping.put("body_ngram", new Analyzer() {
            spellchecker,
            wordScorer,
                    new BytesRef("valeu"),
            wordScorer,
            @Override
 *
            wrapper,
            new BytesRef(" "),
            suggester,
        wordScorer = new LaplaceScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.85d, new BytesRef(" "), 0.5f);
            generator,
                return new TokenStreamComponents(t, new LowerCaseFilter(t));
        }
            ir,
        DirectoryReader ir = DirectoryReader.open(writer);
            suggester,
        // test synonyms
        assertThat(corrections[1].join(new BytesRef(" ")).utf8ToString(), equalTo("xor the god jewel"));
        assertThat(corrections[1].join(space).utf8ToString(), equalTo("xor the god jewel"));
        assertThat(corrections.length, equalTo(1));
                Tokenizer t = new StandardTokenizer();
 */
        }
            1,
            generator,
            suggester,
        ).corrections;
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;
            generator,
        assertThat(corrections[3].join(space, preTag, postTag).utf8ToString(), equalTo("xor teh <em>god</em> jewel"));
        result = getCorrections(suggester, wrapper, new BytesRef("american ame"), generator, 1, 1, ir, "body", wordScorer, 0, 1);
            "body",
            new BytesRef("american ame"),
import java.util.Map;
                    SolrSynonymParser parser = new SolrSynonymParser(true, false, new WhitespaceAnalyzer());
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("captain america"));
import org.apache.lucene.analysis.synonym.SolrSynonymParser;
        ).corrections;
                return new TokenStreamComponents(t, filter);
                } catch (Exception e) {
            suggester,
        mapping.put("body_ngram", new Analyzer() {
                Tokenizer t = new StandardTokenizer();
        ).corrections;
            }
                    2
            wrapper,
        generator = new DirectCandidateGenerator(
        assertThat(corrections[1].join(new BytesRef(" ")).utf8ToString(), equalTo("zorr the god jewel"));
            new BytesRef("american ame"),
        IndexWriter writer = new IndexWriter(dir, conf);
            2,
                NoisyChannelSpellChecker suggester = new NoisyChannelSpellChecker(REAL_WORD_LIKELIHOOD, true, DEFAULT_TOKEN_LIMIT);
        assertThat(corrections[3].join(space).utf8ToString(), equalTo("xor teh god jewel"));
            analyzer,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ).corrections;
            "body",
            wordScorer,
        });
import static org.opensearch.search.suggest.phrase.NoisyChannelSpellChecker.DEFAULT_TOKEN_LIMIT;
            "body",
            "Xorn",
            1,
            ir,
            0.5f,
            suggester,
        );
            "Xorr the God-Jewel",
            ir,
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorr</em> the <em>god</em> jewel"));
        ).corrections;
            1,
import org.apache.lucene.analysis.standard.StandardTokenizer;
        ).corrections;
            0.5f,
            analyzer,
        assertThat(corrections[1].join(space).utf8ToString(), equalTo("xor the god jewel"));
        generator = new MultiCandidateGeneratorWrapper(5, forward, reverse);
        ).corrections;
            generator,
            3
            0.5f,
            4,
            2
            ir,
            2
        Map<String, Analyzer> mapping = new HashMap<>();
            wrapper,
            wrapper,
        corrections = getCorrections(
            Document doc = new Document();
import org.apache.lucene.document.Document;
            MultiTerms.getTerms(ir, "body_ngram"),
        Map<String, Analyzer> mapping = new HashMap<>();
            @Override
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new WhitespaceAnalyzer(), mapping);
                    1,
            try (DirectoryReader ir = DirectoryReader.open(dir)) {
            1,
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
        BytesRef query,
        Directory dir = new ByteBuffersDirectory();
        );
            SuggestMode.SUGGEST_MORE_POPULAR,
            1,
            "body",
        assertThat(corrections[3].join(space).utf8ToString(), equalTo("xorr the got jewel"));
package org.opensearch.search.suggest.phrase;
    private final BytesRef preTag = new BytesRef("<em>");
        Analyzer analyzer = new Analyzer() {
        Correction[] corrections = getCorrections(
import org.apache.lucene.analysis.standard.StandardAnalyzer;
    }
            ir,
            1.5f,
            @Override
            suggester,
            "Xemnu the Titan",
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
            1,
            wrapper,
            wrapper,
            suggester,
        DirectSpellChecker spellchecker = new DirectSpellChecker();
        corrections = getCorrections(
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
        corrections = getCorrections(
                    wordScorer,
            "Wundarr the Aquarian",
        suggester = new NoisyChannelSpellChecker(0.95, true, DEFAULT_TOKEN_LIMIT);
                TokenFilter filter = new LowerCaseFilter(t);
 * this file be licensed under the Apache-2.0 license or a
        NoisyChannelSpellChecker suggester = new NoisyChannelSpellChecker(REAL_WORD_LIKELIHOOD, true, DEFAULT_TOKEN_LIMIT);
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("<em>captain america</em>"));
        assertThat(corrections[3].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorr</em> the got jewel"));
                    SolrSynonymParser parser = new SolrSynonymParser(true, false, new WhitespaceAnalyzer());
    private final BytesRef postTag = new BytesRef("</em>");
            generator,
        mapping.put("body", new Analyzer() {
            "Wundarr the Aquarian",
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("american ace"));
        corrections = getCorrections(
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("captain america"));
                assertThat(result.corrections[0].join(space).utf8ToString(), equalTo("value"));
                    SuggestMode.SUGGEST_MORE_POPULAR,
            ir,
            1
            suggester,
        assertThat(corrections.length, equalTo(4));
            wordScorer,
                tf.setOutputUnigrams(false);
        wordScorer = new LaplaceScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.85d, new BytesRef(" "), 0.5f);
            "USA Hero",
        CandidateGenerator generator,
            "body",
        assertThat(corrections.length, equalTo(2));
            new BytesRef("Xor the Got-Jewel"),
            analyzer,
            4,
            1,
        spellchecker.setMinQueryLength(1);
import java.io.IOException;
            4f,
        corrections = getCorrections(
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("american ame"));
            analyzer,
            wordScorer,
            0.4,
            ir,
            MultiTerms.getTerms(ir, "body_ngram"),
            MultiTerms.getTerms(ir, "body_ngram"),
            ir,
    public void testFewDocsEgdeCase() throws Exception {
        );
                );
                iw.addDocument(document);
            ir,
        corrections = getCorrections(
        });
            "Captain America",
import org.apache.lucene.analysis.reverse.ReverseStringFilter;
                document.add(new TextField("other_field", "value", Field.Store.NO));
        Result result = getCorrections(suggester, wrapper, new BytesRef("american ame"), generator, 1, 1, ir, "body", wordScorer, 1, 2);
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ace"));
            "Quasar II" };
        ).corrections;
/*
        }
import org.apache.lucene.store.ByteBuffersDirectory;
                    parser.parse(new StringReader("usa => usa, america, american"));
                return new TokenStreamComponents(t, new LowerCaseFilter(t));
            spellchecker,
                    parser.parse(new StringReader("usa => usa, america, american"));
            "Xorr the God-Jewel",
                    "field",
            0.1
            generator,
            generator,
        corrections = getCorrections(
            }
            ir,
        mapping.put("body", new Analyzer() {
                Tokenizer t = new StandardTokenizer();
                Result result = getCorrections(
                iw.addDocument(document);
        corrections = getCorrections(
        ).corrections;
 * specific language governing permissions and limitations
        ).corrections;
            wordScorer,
            ir,
                }
            analyzer,
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.analysis.TokenFilter;
        Directory dir = new ByteBuffersDirectory();
            suggester,
            "body",
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
        ).corrections;
        assertThat(corrections[2].join(new BytesRef(" ")).utf8ToString(), equalTo("xorn the god jewel"));
            generator,
            suggester,
            @Override
            wrapper,
            0.85d,
}
            ir,
            suggester,
        });
        wordScorer = new LinearInterpolatingScorer(
            2
            "American Ace",
            0.4,
        corrections = getCorrections(
        corrections = result.corrections;
        // assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ape"));
        CandidateGenerator generator = new MultiCandidateGeneratorWrapper(10, forward, reverse);
        LaplaceScorer wordScorer = new LaplaceScorer(
            2
            "Wanda Maximoff",
                ShingleFilter tf = new ShingleFilter(t, 2, 3);
        );
 * KIND, either express or implied.  See the License for the
            SuggestMode.SUGGEST_MORE_POPULAR,
            generator,
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("captain america"));
            "body_ngram",
        assertThat(corrections[1].join(space, preTag, postTag).utf8ToString(), equalTo("xor the <em>god</em> jewel"));
    private final BytesRef space = new BytesRef(" ");
        ).corrections;
import org.apache.lucene.analysis.synonym.SynonymFilter;
            suggester,
            new BytesRef("american cae"),
            2
                return new TokenStreamComponents(t, new LowerCaseFilter(tf));
            ir,
        // Make sure that user supplied text is not marked as highlighted in the presence of a synonym filter
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("captain america"));
            0.5f,
                Tokenizer t = new StandardTokenizer();
        for (String line : strings) {
            "Fantastic Four",
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);
                    new StandardAnalyzer(),
 * this work for additional information regarding copyright
            new BytesRef("american ame"),
        corrections = getCorrections(
import org.apache.lucene.util.CharsRefBuilder;
            MultiTerms.getTerms(ir, "body")
            "body",
            analyzer,
            2,
            1,
                }
            generator,
            new BytesRef("Xor the Got-Jewel"),
            "body",
            forward,
                    0.95,
            1,
            protected TokenStreamComponents createComponents(String fieldName) {
            0.95,
            wrapper,
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("xorr the god jewel"));
            SuggestMode.SUGGEST_MORE_POPULAR,
                tf.setOutputUnigrams(false);
            "Xorn",
            wordScorer,
        float maxErrors,
            new BytesRef("Quazar II"),
            ir,
                } catch (Exception e) {
                Tokenizer t = new StandardTokenizer();
 * compatible open source license.
        assertThat(corrections.length, equalTo(1));
        spellchecker.setAccuracy(0.0f);
            @Override
            writer.addDocument(doc);
            2
            new BytesRef("Xor the Got-Jewel"),
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.index.DirectoryReader;
            suggester,
                    ir,
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ace"));
                WordScorer wordScorer = new StupidBackoffScorer(
        DirectCandidateGenerator reverse = new DirectCandidateGenerator(
