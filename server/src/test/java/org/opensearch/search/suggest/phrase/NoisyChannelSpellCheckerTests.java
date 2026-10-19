        });
    private final BytesRef preTag = new BytesRef("<em>");
            2
            }
        assertThat(corrections[2].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorn</em> the <em>god</em> jewel"));
            new BytesRef("captian usa"),
                    wordScorer,
        };  
            doc.add(new Field("body", line, TextField.TYPE_NOT_STORED));
            new BytesRef("american ame"),
            ir,
            suggester,
                tf.setOutputUnigrams(false);
            "Quasar II" };
            4,
            @Override
        assertThat(corrections.length, equalTo(1));
            new BytesRef("captian usa"),
            analyzer,  
            protected TokenStreamComponents createComponents(String fieldName) {
import org.apache.lucene.analysis.reverse.ReverseStringFilter;
        // test synonyms
            wrapper,
            ir,  
        result = getCorrections(suggester, wrapper, new BytesRef("american ame"), generator, 1, 1, ir, "body", wordScorer, 0, 1);  
            wordScorer,
    }
                    filter = new SynonymFilter(filter, parser.build(), true);
            5  
        spellchecker.setAccuracy(0.0f);  
            wrapper,  
                TokenFilter filter = new LowerCaseFilter(t);
                    MultiTerms.getTerms(ir, "field"),
        );  
            "body",
        corrections = getCorrections(
        }  
            wrapper,
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("captain <em>america</em>"));
        assertThat(corrections[3].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the got jewel"));
    private final BytesRef space = new BytesRef(" ");  
            spellchecker,
                return new TokenStreamComponents(t, new LowerCaseFilter(tf));  
            "body",
            ir,
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("<em>captain america</em>"));
        assertThat(corrections[1].join(new BytesRef(" ")).utf8ToString(), equalTo("zorr the god jewel"));
            wrapper,
            suggester,  
            "body",  
            "body",
            ir,
            suggester,
            spellchecker,
                document = new Document();
        mapping.put("body_ngram", new Analyzer() {
            ir,
        // Test some of the highlighting corner cases  
        WordScorer scorer,  
import org.apache.lucene.index.IndexWriterConfig;
            2
        wordScorer = new LaplaceScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.85d, new BytesRef(" "), 0.5f);
                    generator,  
 * this file be licensed under the Apache-2.0 license or a
        wordScorer = new LaplaceScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.85d, new BytesRef(" "), 0.5f);
                    1,
        ).corrections;  
            generator,
            try (DirectoryReader ir = DirectoryReader.open(dir)) {
        corrections = getCorrections(
            MultiTerms.getTerms(ir, "body_ngram"),
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("quasar ii"));  
                    SuggestMode.SUGGEST_MORE_POPULAR,  
            ir,
                    spellchecker,
            0.5f,
            new BytesRef("Zorr the Got-Jewel"),
            1,
            0.95d,
        mapping.put("body_ngram", new Analyzer() {
            "body",
        }
            ir,
        assertThat(corrections.length, equalTo(1));  
            "Walter Newell",
        DirectSpellChecker spellchecker = new DirectSpellChecker();
        int gramSize
            generator,  
        assertThat(corrections.length, equalTo(0)); // only use forward with constant prefix
        Map<String, Analyzer> mapping = new HashMap<>();
        corrections = getCorrections(  
            1,  
            "body_ngram",
    private final BytesRef postTag = new BytesRef("</em>");
            wordScorer,  
            "body",
            "body",  
            1,  
            MultiTerms.getTerms(ir, "body_reverse")
        assertThat(corrections[2].join(new BytesRef(" ")).utf8ToString(), equalTo("xorn the god jewel"));  
            }
                }
    }
            2,
            wordScorer,
            spellchecker,  
            suggester,  
            "body",  
        assertThat(corrections[1].join(space, preTag, postTag).utf8ToString(), equalTo("xor <em>the god</em> jewel"));
            1,
        suggester = new NoisyChannelSpellChecker(0.95, true, DEFAULT_TOKEN_LIMIT);
            analyzer,  
        Correction[] corrections = getCorrections(  
import org.apache.lucene.analysis.TokenFilter;
            5
            MultiTerms.getTerms(ir, "body_ngram"),
            "Xorn",
                tf.setOutputUnigrams(false);
            wrapper,  
            suggester,  
            "body",  
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);
            0.85,  
            "Fantastic Four",
        assertThat(corrections.length, equalTo(4));  
    public void testNgram() throws IOException {
        try (Directory dir = newDirectory()) {
            1,
import org.apache.lucene.analysis.miscellaneous.PerFieldAnalyzerWrapper;  
                    new StandardAnalyzer(),
                );
        assertThat(corrections[1].join(space).utf8ToString(), equalTo("xor the god jewel"));  
            1,
            wordScorer,  
import org.apache.lucene.analysis.Tokenizer;
            generator,  
            analyzer,
            ir,
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
        assertThat(corrections[1].join(space).utf8ToString(), equalTo("xor the god jewel"));
        assertThat(corrections[1].join(new BytesRef(" ")).utf8ToString(), equalTo("xor the god jewel"));
            }
        Analyzer analyzer = new Analyzer() {  
 * The OpenSearch Contributors require contributions made to  
        };
        Directory dir = new ByteBuffersDirectory();
                ShingleFilter tf = new ShingleFilter(t, 2, 3);
                ShingleFilter tf = new ShingleFilter(t, 2, 3);
            suggester,  
            @Override  
            "body",  
        mapping.put("body", new Analyzer() {
            1
            0.5f,
            3  
            wrapper,  
            wordScorer,
        DirectSpellChecker spellchecker = new DirectSpellChecker();
            generator,
            "Xemnu the Titan",
            "body_reverse",
            suggester,
            wordScorer,
            "body",
            new BytesRef("captian usw"),
        ).corrections;  
            "Will o' the Wisp",  
        });
 * the Apache License, Version 2.0 (the "License"); you may
            suggester,
        wordScorer = new LinearInterpolatingScorer(  
            new BytesRef("american cae"),  
            0.4,
            ir,
            2
            0,
import org.opensearch.test.OpenSearchTestCase;
            generator,
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("american ace"));
import org.apache.lucene.util.CharsRefBuilder;
                    1,  
        assertThat(corrections.length, equalTo(1));  
        spellchecker.setMinQueryLength(1);
            ir,
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("captain america"));
            2,
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));  
            wordScorer,
            wrapper,  
import org.apache.lucene.search.spell.SuggestMode;
            ir,  
                Result result = getCorrections(
            "body",
        DirectCandidateGenerator generator = new DirectCandidateGenerator(  
        mapping.put("body", new Analyzer() {
        corrections = getCorrections(
        suggester = new NoisyChannelSpellChecker(0.85, true, DEFAULT_TOKEN_LIMIT);
                    SolrSynonymParser parser = new SolrSynonymParser(true, false, new WhitespaceAnalyzer());
                    0.95d,  
import java.util.HashMap;  
            generator,
        spellchecker.setMinQueryLength(1);
            1,  
            1,
            1,  
            }
            "USA Hero",
            "Quasar",
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("xorr the god jewel"));
            "Wanda Maximoff",  
            1,  
            new BytesRef("Quazar II"),
            "Xemnu the Titan",  
import org.apache.lucene.analysis.shingle.ShingleFilter;
            new BytesRef("american ame"),
import org.apache.lucene.analysis.Analyzer;  
import java.io.IOException;
        IndexWriter writer = new IndexWriter(dir, conf);  
 *
            generator,  
        ).corrections;
            wrapper,
        spellchecker.setMinPrefix(1);
        assertThat(corrections.length, equalTo(4));  
                );
            4,  
 * software distributed under the License is distributed on an
            0.5,  
            wordScorer,  
        ).corrections;  
            2,
import org.apache.lucene.store.Directory;  
        wordScorer = new StupidBackoffScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.85d, new BytesRef(" "), 0.4);  
            Document doc = new Document();
            ir,
        ).corrections;
            SuggestMode.SUGGEST_MORE_POPULAR,
            "body",
 */
            10,
        ).corrections;  
            null,
 *
            "body",
                    throw new RuntimeException(e);  
            wordScorer,  
            new BytesRef("Xor the Got-Jewel"),
            suggester,
        float maxErrors,
            "body_ngram",  
            "Quasar",  
            "body",
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new WhitespaceAnalyzer(), mapping);
            0.5f,  
        corrections = getCorrections(
            doc.add(new Field("body_ngram", line, TextField.TYPE_NOT_STORED));
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("<em>captain america</em>"));
}
            "Xorr the God-Jewel",
                tf.setOutputUnigrams(false);  
        ).corrections;  
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
        // test synonyms
            1,  
            generator,
            "American Ace",
            1,
            "Quasar II" };
            0.1
        );
            4,
            "Wundarr the Aquarian",
/*
            10,
            }  
                document.add(new TextField("field", "value", Field.Store.NO));
        assertThat(corrections[3].join(space).utf8ToString(), equalTo("xorr the got jewel"));
        Map<String, Analyzer> mapping = new HashMap<>();
import org.apache.lucene.analysis.standard.StandardTokenizer;
 * You may obtain a copy of the License at  
        assertThat(corrections[2].join(space).utf8ToString(), equalTo("xorn the god jewel"));
            0.95,
        DirectCandidateGenerator forward = new DirectCandidateGenerator(spellchecker, "body", SuggestMode.SUGGEST_ALWAYS, ir, 0.95, 10);
        });  
        assertThat(result.cutoffScore, equalTo(Double.MIN_VALUE));
        assertThat(corrections.length, equalTo(1));
import org.apache.lucene.document.Document;
            2
            new BytesRef("Xor the Got-Jewel"),  
        assertThat(corrections[2].join(new BytesRef(" ")).utf8ToString(), equalTo("xorn the god jewel"));
            2
                    filter = new SynonymFilter(filter, parser.build(), true);  
                    ir,
            ir,
                    0.95,
            writer.addDocument(doc);
        for (String line : strings) {
            MultiTerms.getTerms(ir, "body_ngram"),
                Tokenizer t = new StandardTokenizer();  
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ace"));
            wrapper,
            2  
            3
                iw.commit();
                Document document = new Document();
            0.4,
                Tokenizer t = new StandardTokenizer();
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new WhitespaceAnalyzer(), mapping);
        mapping.put("body_reverse", new Analyzer() {
        );  
        corrections = result.corrections;
            "Xorr the God-Jewel",
        );  
        });
        );  
            generator,
            "body",
        DirectCandidateGenerator generator = new DirectCandidateGenerator(
            SuggestMode.SUGGEST_MORE_POPULAR,
                Tokenizer t = new StandardTokenizer();
import static org.opensearch.search.suggest.phrase.NoisyChannelSpellChecker.REAL_WORD_LIKELIHOOD;
            null,
            1,
            0.85d,
        String analysisField,
            new BytesRef(" "),
            new BytesRef("Xor the Got-Jewel"),
        suggester = new NoisyChannelSpellChecker(0.85, true, DEFAULT_TOKEN_LIMIT);
        WordScorer wordScorer = new LinearInterpolatingScorer(  
import org.apache.lucene.analysis.TokenStream;  
            "Xorn",
            0.5,  
        assertThat(corrections.length, equalTo(0));  
import java.io.CharArrayReader;  
            wordScorer,
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("american ame"));  
import org.apache.lucene.document.TextField;  
        DirectoryReader ir = DirectoryReader.open(writer);
        }
            writer.addDocument(doc);  
        ).corrections;
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ace"));
            }
            "body",  
            "body",
            1,
        // Make sure that user supplied text is not marked as highlighted in the presence of a synonym filter  
        spellchecker.setMinPrefix(1);  
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("american ame"));
            wrapper,  
        TokenStream tokenStream = analyzer.tokenStream(analysisField, new CharArrayReader(spare.chars(), 0, spare.length()));  
        for (String line : strings) {
            1,  
            0.5f,
            4,
import org.opensearch.search.suggest.phrase.NoisyChannelSpellChecker.Result;  
            "Fantastic Four",
            2,
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                try {  
        ).corrections;
        mapping.put("body", new Analyzer() {  
            "Will o' the Wisp",
        Correction[] corrections = getCorrections(
            1.5f,  
            "body",
            "Will o' the Wisp",  
            analyzer,  
        assertThat(corrections.length, equalTo(1));
            "American Ace",  
 * KIND, either express or implied.  See the License for the
    ) throws IOException {  
        assertThat(corrections.length, equalTo(4));
        assertThat(corrections.length, equalTo(1));
    }
        DirectoryReader ir = DirectoryReader.open(writer);
            4f,
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));  
            generator,
            protected TokenStreamComponents createComponents(String fieldName) {
        Directory dir = new ByteBuffersDirectory();
            ir,  
        IndexWriter writer = new IndexWriter(dir, conf);
            forward,
            wordScorer,  
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);  
            0.85d,
        assertThat(corrections[2].join(space).utf8ToString(), equalTo("xorn the god jewel"));
        IndexReader reader,
            "body",
import org.apache.lucene.index.DirectoryReader;
            doc.add(new Field("body_reverse", line, TextField.TYPE_NOT_STORED));
        spellchecker.setMinQueryLength(1);
        Analyzer analyzer = new Analyzer() {
                return new TokenStreamComponents(t, new LowerCaseFilter(t));
                return new TokenStreamComponents(t, new ReverseStringFilter(new LowerCaseFilter(t)));
        assertThat(corrections.length, equalTo(2));
            2
            4,  
            new BytesRef("Xor the Got-Jewel"),
            "Wanda Maximoff",
 * ownership. Elasticsearch licenses this file to you under  
            1,
        PerFieldAnalyzerWrapper wrapper = new PerFieldAnalyzerWrapper(new WhitespaceAnalyzer(), mapping);  
            "Wundarr the Aquarian",
        });  
            wordScorer,
            ir,  
        corrections = getCorrections(
            new BytesRef("Xor the Got-Jewel"),
        ).corrections;
            2
            wrapper,
            SuggestMode.SUGGEST_ALWAYS,
import static org.opensearch.search.suggest.phrase.NoisyChannelSpellChecker.DEFAULT_TOKEN_LIMIT;  
        NoisyChannelSpellChecker suggester = new NoisyChannelSpellChecker(REAL_WORD_LIKELIHOOD, true, DEFAULT_TOKEN_LIMIT);  
            analyzer,
            ir,
            protected TokenStreamComponents createComponents(String fieldName) {
            new BytesRef(" "),
                return new TokenStreamComponents(t, new LowerCaseFilter(tf));
import org.apache.lucene.search.spell.DirectSpellChecker;  
        ).corrections;  
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("captain america"));
            null,
            spellchecker,
            1,
            "body",  
        corrections = getCorrections(  
        generator = new DirectCandidateGenerator(
 */
            suggester,
            @Override
            0.5f,
                assertThat(result.corrections[0].join(space).utf8ToString(), equalTo("value"));
            4,  
            "Grog the God-Crusher",
        assertThat(corrections[3].join(space).utf8ToString(), equalTo("xor teh god jewel"));
                    throw new RuntimeException(e);
            @Override
            analyzer,
            4,
            doc.add(new Field("body", line, TextField.TYPE_NOT_STORED));  
import static org.hamcrest.Matchers.equalTo;
        ).corrections;
            4,
                    1,
            wrapper,
import java.util.Map;
        CharsRefBuilder spare = new CharsRefBuilder();
 * Licensed to Elasticsearch under one or more contributor  
                    ir,  
            ir,  
            0,
        ).corrections;  
import org.apache.lucene.analysis.synonym.SolrSynonymParser;
        assertThat(corrections[2].join(space).utf8ToString(), equalTo("xorn the god jewel"));  
                return new TokenStreamComponents(t, filter);
            0.5,  
            10,
            new BytesRef("Zorr the Got-Jewel"),
        assertThat(result.cutoffScore, greaterThan(0d));
            }  
 * not use this file except in compliance with the License.
            Document doc = new Document();  
            "body_ngram",  
            MultiTerms.getTerms(ir, "body")
            2
        CandidateGenerator generator = new MultiCandidateGeneratorWrapper(10, forward, reverse);
                return new TokenStreamComponents(t, new LowerCaseFilter(t));
            wordScorer,
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
            new BytesRef(" "),
            generator,
/*  
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("captain america"));
            suggester,
            @Override
            @Override
            2
            0.95,
            0.85,
        corrections = getCorrections(
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("captain america"));  
        int numCorrections,  
            3  
            0,
            4,
            "Walter Newell",
            ir,
        assertThat(corrections.length, equalTo(4));
        assertThat(corrections[3].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorr</em> the got jewel"));  
            ir,
                    new BytesRef(" "),
            new BytesRef("american cae"),  
        NoisyChannelSpellChecker checker,
        corrections = getCorrections(  
            "body_ngram",  
            new BytesRef("Xor the Got-Jewel"),
        ).corrections;  
                Tokenizer t = new StandardTokenizer();
        corrections = getCorrections(
        WordScorer wordScorer = new LaplaceScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.95d, new BytesRef(" "), 0.5f);
        assertThat(corrections.length, equalTo(1));
                return new TokenStreamComponents(t, filter);
import org.apache.lucene.analysis.synonym.SynonymFilter;  
                try {
            @Override
        corrections = getCorrections(
            protected TokenStreamComponents createComponents(String fieldName) {
            new BytesRef(" "),
            "Captain America",  
import org.apache.lucene.index.IndexReader;
        ).corrections;
                Tokenizer t = new StandardTokenizer();
            ir,  
            doc.add(new Field("body", line, TextField.TYPE_NOT_STORED));
            "USA Hero",  
        NoisyChannelSpellChecker suggester = new NoisyChannelSpellChecker(REAL_WORD_LIKELIHOOD, true, DEFAULT_TOKEN_LIMIT);
        DirectSpellChecker spellchecker = new DirectSpellChecker();  
                    0.4f
            1,
            "body",  
        assertThat(corrections[3].join(space, preTag, postTag).utf8ToString(), equalTo("xor teh <em>god</em> jewel"));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(corrections.length, equalTo(4));
                Tokenizer t = new StandardTokenizer();  
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("xorr the god jewel"));
            new BytesRef("captain usw"),  
            try (IndexWriter iw = new IndexWriter(dir, newIndexWriterConfig())) {  
            1,  
        ).corrections;
 * Modifications Copyright OpenSearch Contributors. See  
                    parser.parse(new StringReader("usa => usa, america, american"));  
            ir,
        wordScorer = new LinearInterpolatingScorer(  
            generator,  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.analysis.standard.StandardAnalyzer;  
            Document doc = new Document();  
    }  
    public void testTrigram() throws IOException {  
        CandidateGenerator generator,
        spellchecker.setAccuracy(0.0f);
        assertThat(corrections[1].join(new BytesRef(" ")).utf8ToString(), equalTo("xor the god jewel"));
            "Xemnu the Titan",
        assertThat(corrections.length, equalTo(1));
            wrapper,  
                DirectCandidateGenerator generator = new DirectCandidateGenerator(  
            spellchecker,  
            wordScorer,
            3  
        generator = new MultiCandidateGeneratorWrapper(5, forward, reverse);
            ir,
        );  
            protected TokenStreamComponents createComponents(String fieldName) {
        generator = new DirectCandidateGenerator(
        Map<String, Analyzer> mapping = new HashMap<>();  
        ).corrections;
        ).corrections;
            0,
import org.apache.lucene.index.IndexWriter;  
            wrapper,
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorr the god</em> jewel"));  
            suggester,
            suggester,
                ShingleFilter tf = new ShingleFilter(t, 2, 3);  
        NoisyChannelSpellChecker suggester = new NoisyChannelSpellChecker(REAL_WORD_LIKELIHOOD, true, DEFAULT_TOKEN_LIMIT);
        corrections = getCorrections(
        assertThat(corrections[0].join(space).utf8ToString(), equalTo("xorr the god jewel"));
            2
            suggester,  
            protected TokenStreamComponents createComponents(String fieldName) {  
        assertThat(corrections[3].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the got jewel"));  
            1,  
            wrapper,
        assertThat(corrections[1].join(space, preTag, postTag).utf8ToString(), equalTo("xor the <em>god</em> jewel"));
            }  
    public void testFewDocsEgdeCase() throws Exception {
            ir,
            1,
            new BytesRef("american ame"),
            "Xorr the God-Jewel",  
            generator,
            3
        float confidence,
            ir,
            suggester,
        spellchecker.setMinQueryLength(1);  
        Directory dir = new ByteBuffersDirectory();  
            "body",
                    "field",
        String[] strings = new String[] {
            @Override  
        spare.copyUTF8Bytes(query);
        );
        DirectCandidateGenerator reverse = new DirectCandidateGenerator(
                    parser.parse(new StringReader("usa => usa, america, american"));
 * GitHub history for details.
            0.4,
            MultiTerms.getTerms(ir, "body")
            generator,
            "Grog the God-Crusher",  
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));
            wrapper,
            "Grog the God-Crusher",
            "Fantastic Four",
            wordScorer,
            1,
        ).corrections;
                } catch (Exception e) {
            ir,  
            ir,
            1,  
        assertThat(corrections.length, equalTo(1));
            0.1
        Analyzer analyzer,
 * license agreements. See the NOTICE file distributed with
            2
            "Quasar",  
        for (String line : strings) {
                WordScorer wordScorer = new StupidBackoffScorer(
            ir,  
            "body",  
            protected TokenStreamComponents createComponents(String fieldName) {  
            writer.addDocument(doc);
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ace"));  
        IndexWriterConfig conf = new IndexWriterConfig(wrapper);
        Correction[] corrections = result.corrections;  
                    ir,  
            "Captain America",
        ).corrections;
            suggester,
                iw.addDocument(document);
        assertThat(corrections[3].join(space).utf8ToString(), equalTo("xorr the got jewel"));
package org.opensearch.search.suggest.phrase;
    public void testMultiGenerator() throws IOException {
            "Quasar II" };  
        });
 * under the License.  
            generator,
            10,  
            MultiTerms.getTerms(ir, "body_ngram"),
            ir,  
            "Captain America",
            1,
import org.apache.lucene.analysis.LowerCaseFilter;
                    suggester,  
            1,  
            2,
            new BytesRef("Xor teh Got-Jewel"),  
            0.5f,
            wordScorer,
        corrections = getCorrections(
        ).corrections;
            1,
            2,  
        assertThat(corrections.length, equalTo(4));
    }
        corrections = getCorrections(
        );
                    "field",
                );  
        LaplaceScorer wordScorer = new LaplaceScorer(
            "Walter Newell",  
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ace"));
        }  
            }
        corrections = getCorrections(
            wordScorer,  
            1.5f,
import java.io.StringReader;
            0.5f,  
        ).corrections;
        DirectoryReader ir = DirectoryReader.open(writer);  
        corrections = getCorrections(  
            ir,
                NoisyChannelSpellChecker suggester = new NoisyChannelSpellChecker(REAL_WORD_LIKELIHOOD, true, DEFAULT_TOKEN_LIMIT);
            0.95d,  
import static org.hamcrest.Matchers.greaterThan;  
            generator,
            @Override  
            generator,
public class NoisyChannelSpellCheckerTests extends OpenSearchTestCase {
            doc.add(new Field("body_ngram", line, TextField.TYPE_NOT_STORED));  
        assertThat(corrections[1].join(space).utf8ToString(), equalTo("xor the god jewel"));  
            wordScorer,
            3  
            MultiTerms.getTerms(ir, "body")  
                DirectSpellChecker spellchecker = new DirectSpellChecker();
    private Result getCorrections(  
 * specific language governing permissions and limitations
                    2
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("captain america"));  
            wrapper,
        mapping.put("body_ngram", new Analyzer() {  
        corrections = getCorrections(  
 * this work for additional information regarding copyright
                return new TokenStreamComponents(t, new LowerCaseFilter(tf));
            2  
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));  
                    "field",
        generator = new DirectCandidateGenerator(  
        // assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("american ape"));
            doc.add(new Field("body_ngram", line, TextField.TYPE_NOT_STORED));
                document.add(new TextField("other_field", "value", Field.Store.NO));  
 * compatible open source license.
        String[] strings = new String[] {
            wrapper,
            suggester,
                }  
            2,
            ir,
            "Wanda Maximoff",
            protected TokenStreamComponents createComponents(String fieldName) {  
        IndexWriter writer = new IndexWriter(dir, conf);
            }
            2  
        assertThat(corrections.length, equalTo(1));
            suggester,  
            wordScorer,
            protected TokenStreamComponents createComponents(String fieldName) {
 * Unless required by applicable law or agreed to in writing,
                Tokenizer t = new StandardTokenizer();
            }
                Tokenizer t = new StandardTokenizer();
        corrections = getCorrections(  
            new BytesRef("Xor the Got-Jewel"),  
            1,
            3
            suggester,
            1,
            suggester,  
            SuggestMode.SUGGEST_MORE_POPULAR,  
        wordScorer = new LaplaceScorer(ir, MultiTerms.getTerms(ir, "body_ngram"), "body_ngram", 0.85d, new BytesRef(" "), 0.5f);
            100,
            0.5f,  
            generator,  
import org.apache.lucene.store.ByteBuffersDirectory;
            "Xorn",  
        );  
        assertThat(corrections[1].join(new BytesRef(" ")).utf8ToString(), equalTo("xor the god jewel"));
            wordScorer,  
            ir,
            suggester,
            wordScorer,
            4,
        // Test a special case where one of the suggest term is unchanged by the postFilter, 'II' here is unchanged by the reverse analyzer.  
            suggester,
            spellchecker,
            1,
            SuggestMode.SUGGEST_MORE_POPULAR,  
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("american <em>ace</em>"));  
import org.apache.lucene.document.Field;
            0.5f
        suggester = new NoisyChannelSpellChecker(0.85, true, DEFAULT_TOKEN_LIMIT);  
            ir,  
        });
            wrapper,  
        assertThat(corrections[0].join(new BytesRef(" ")).utf8ToString(), equalTo("xorr the god jewel"));  
 *  
        Result result = getCorrections(suggester, wrapper, new BytesRef("american ame"), generator, 1, 1, ir, "body", wordScorer, 1, 2);
            generator,  
                    new BytesRef("valeu"),
                return new TokenStreamComponents(t, new LowerCaseFilter(t));  
        assertThat(corrections[0].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorr</em> the <em>god</em> jewel"));  
        assertThat(corrections[2].join(space, preTag, postTag).utf8ToString(), equalTo("<em>xorn the god</em> jewel"));
        corrections = getCorrections(
                } catch (Exception e) {
            0.95,  
 */  
            4,  
            new BytesRef("captian usw"),  
                Tokenizer t = new StandardTokenizer();  
        spellchecker.setMinQueryLength(1);
            0.5f,  
import org.apache.lucene.index.MultiTerms;
            "body",
                    SolrSynonymParser parser = new SolrSynonymParser(true, false, new WhitespaceAnalyzer());
            generator,  
            "body",
            SuggestMode.SUGGEST_MORE_POPULAR,
                iw.addDocument(document);  
            "American Ace",
            new BytesRef("america cae"),  
            0.95,
            1,
            0.1
            analyzer,
            analyzer,
            "body",
            wordScorer,  
        );
                assertThat(result.corrections.length, equalTo(1));  
            generator,
                    5  
            "Wundarr the Aquarian",
        return checker.getCorrections(tokenStream, generator, maxErrors, numCorrections, scorer, confidence, gramSize);
            1,  
        String[] strings = new String[] {  
                TokenFilter filter = new LowerCaseFilter(t);  
        BytesRef query,  
        corrections = getCorrections(  
        assertThat(corrections[2].join(new BytesRef(" ")).utf8ToString(), equalTo("four the god jewel"));
