            Locale.ROOT,
                }
 * license agreements. See the NOTICE file distributed with
public class CustomUnifiedHighlighterTests extends OpenSearchTestCase {
            new StandardAnalyzer(),
                    Integer.MAX_VALUE,
                    noMatchSize,
        final String[] inputs = {
            0,
import org.apache.lucene.analysis.custom.CustomAnalyzer;
                field.setStringValue(input);
    }
    }
 * GitHub history for details.
            new StandardAnalyzer(),
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
            inputs
            outputs
    }
            new StandardAnalyzer(),
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.document.TextField;
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
            Locale.ROOT,
        assertHighlightOneDoc(
        String[] expectedPassages
import org.apache.lucene.search.BooleanClause;
            "text",
            query,
                CustomUnifiedHighlighter highlighter = new CustomUnifiedHighlighter(
        assertHighlightOneDoc(
 * specific language governing permissions and limitations
            "This is highlighting the third short highlighting value.",
            ft.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
            "This is the second highlighting value to perform highlighting on a longer text that gets scored lower.",
            inputs,
 * compatible open source license.
            Locale.ROOT,
    public void testCommonTermsQuery() throws Exception {
            .add(new TermQuery(new Term("text", "browser")), BooleanClause.Occur.SHOULD)
            Locale.ROOT,
            .build();
        assertHighlightOneDoc(
            inputs,
            .withTokenizer(EdgeNGramTokenizerFactory.class, "minGramSize", "1", "maxGramSize", "7")
        final String[] inputs = { "This is a test. Just a test highlighting from unified. Feel free to ignore." };
    }
        );
            inputs,
            "text",
            BreakIterator.getSentenceInstance(Locale.ROOT),
        Query query,
        final String[] inputs = { "Nested highlighting query." };
    }
            "with another <b>quick</b>",
            BreakIterator.getSentenceInstance(Locale.ROOT),
    ) throws Exception {
        Query parentQuery = new OpenSearchToParentBlockJoinQuery(childQuery, parentsFilter, ScoreMode.None, "foo");
        BitSetProducer parentsFilter = new BitSetProducer() {
                    breakIterator,
            BreakIterator.getSentenceInstance(Locale.ROOT),
        final String[] inputs = { "Two words. Followed by many words in a big sentence. One. Two. Three. And more words." };
            outputs
        }
            0,
                UnifiedHighlighter.Builder builder = UnifiedHighlighter.builder(searcher, analyzer);
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 10),
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 20),
 * Unless required by applicable law or agreed to in writing,
            "This is a test. Just a test1 highlighting from unified highlighter.",
            outputs
            new StandardAnalyzer(),
        Query query = new TermQuery(new Term("body", "highlighting"));
                    UnifiedHighlighter.OffsetSource.ANALYSIS,
import org.apache.lucene.search.FuzzyQuery;
        final String[] outputs = { "The <b>quick</b> <b>brown</b> <b>fox</b>." };
            .build();
            0,
import org.apache.lucene.document.Field;
        final String[] outputs = { "The quick <b>brown</b> fox." };
            .add(new TermQuery(new Term("text", "br")), BooleanClause.Occur.SHOULD)
            "<b>fox</b>.", };
        );
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 10),
}
        );
                );
        String[] expectedPassages = {
import org.apache.lucene.search.uhighlight.UnifiedHighlighter;
                    expectedPassages.length,
        String fieldName,
            outputs
import static org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter.MULTIVAL_SEP_CHAR;
        final String[] inputs = { "The quick brown fox." };
        final String[] outputs = {
package org.opensearch.lucene.search.uhighlight;
        TermQuery query = new TermQuery(new Term("text", "sentence"));
            query,
 * Modifications Copyright OpenSearch Contributors. See
            new StandardAnalyzer(),
            0,
        final String[] outputs = { "The <b>quick</b> <b>brown</b> <b>fox</b>." };
import java.text.BreakIterator;
            Locale.ROOT,
            .add(new TermQuery(new Term("text", "brown")), BooleanClause.Occur.SHOULD)
            parentQuery,
            query,
            Locale.ROOT,
            new StandardAnalyzer(),
            .add(new TermQuery(new Term("text", "browni")), BooleanClause.Occur.SHOULD)
import org.apache.lucene.index.Term;
            "text",
 * the Apache License, Version 2.0 (the "License"); you may
            query,
            inputs,
            inputs,
            "text",
import org.apache.lucene.search.BooleanQuery;
            "text",
        query.add(new Term("text", "fo"));
import org.apache.lucene.search.IndexSearcher;
            new StandardAnalyzer(),
import org.apache.lucene.analysis.Analyzer;
        );
 * software distributed under the License is distributed on an
            .add(new TermQuery(new Term("text", "words")), BooleanClause.Occur.SHOULD)
    public void testSmallSentenceBoundedBreakIterator() throws Exception {
        };
            0,
                String rawValue = Strings.arrayToDelimitedString(inputs, String.valueOf(MULTIVAL_SEP_CHAR));
        query = new PhraseQuery.Builder().add(new Term("text", "fun")).add(new Term("text", "fun")).build();
import org.apache.lucene.search.join.BitSetProducer;
 */
            inputs,
        assertHighlightOneDoc(
        final String[] outputs = { "A short <b>sentence</b>.", "Followed by a bigger <b>sentence</b>", "And a last short <b>sentence</b>" };
        final String[] inputs = { "The quick brown fox." };
            query,
                iw.close();
            }
        MultiPhrasePrefixQuery query = new MultiPhrasePrefixQuery("text");
import org.apache.lucene.search.join.ScoreMode;
import org.apache.lucene.search.Sort;
                TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 1, Sort.INDEXORDER);
                builder.withFieldMatcher("text"::equals);
import org.apache.lucene.search.PhraseQuery;
/*
            "text",
        assertHighlightOneDoc(
            "<b>fox</b> in a long",
            .build();
            .build();
            query,
        );
            "text",
    }
 */
import org.apache.lucene.index.LeafReaderContext;
            new StandardAnalyzer(),
import org.apache.lucene.analysis.ngram.EdgeNGramTokenizerFactory;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .add(new TermQuery(new Term("text", "brown")), BooleanClause.Occur.SHOULD)
            public BitSet getBitSet(LeafReaderContext context) throws IOException {
        BreakIterator breakIterator,
                }
                Field field = new Field(fieldName, "", ft);
                doc.add(field);
    }
 * Licensed to Elasticsearch under one or more contributor
            outputs
    public void testNoMatchSize() throws Exception {
            }
        Analyzer analyzer = CustomAnalyzer.builder()
 *
            new StandardAnalyzer(),
            outputs
            "<b>Fun</b>  <b>fun</b> <b>fun</b>",
            "The quick brown fox in a long sentence with another quick brown fox. " + "Another sentence with brown fox." };
            Locale.ROOT,
    public void testRepeat() throws Exception {
            "text",
        Analyzer analyzer,
            inputs,
            BreakIterator.getSentenceInstance(Locale.ROOT),
            "<b>Two</b> <b>words</b>.",
import org.apache.lucene.search.MatchAllDocsQuery;
            "text",
            "Just a test4 highlighting from unified highlighter." };
            "And more <b>words</b>.", };
    }
            "<b>fun</b>  <b>fun</b>",
            "<b>fun</b>  <b>fun</b>  <b>fun</b>",
            inputs,
    public void testGroupSentences() throws Exception {
            try (DirectoryReader reader = iw.getReader()) {
                    null
    public void testSimple() throws Exception {
import org.apache.lucene.search.TermQuery;
        assertHighlightOneDoc(
            inputs,
import java.io.IOException;
                assertEquals(snippets.length, expectedPassages.length);
        query.add(new Term("text", "quick"));
            0,
        final String[] inputs = { "A short sentence. Followed by a bigger sentence that should be truncated. And a last short sentence." };
            ft.freeze();
        Locale locale,
            inputs,
        int noMatchSize,
            for (String input : inputs) {
import org.apache.lucene.util.BitSet;
import org.apache.lucene.index.DirectoryReader;
            "text",
    }
            outputs
                    "index",
            iw.addDocument(doc);
            .add(new TermQuery(new Term("text", "two")), BooleanClause.Occur.SHOULD)
        );
 * this work for additional information regarding copyright
            RandomIndexWriter iw = new RandomIndexWriter(random(), dir, iwc);
            IndexWriterConfig iwc = newIndexWriterConfig(analyzer);
            0,
        MultiPhrasePrefixQuery query = new MultiPhrasePrefixQuery("text");
            "<b>One</b>. <b>Two</b>. <b>Three</b>.",
import org.apache.lucene.index.IndexOptions;
        String[] inputs,
 * ownership. Elasticsearch licenses this file to you under
        final String[] inputs = { "bro", "brown", "brownie", "browser" };
import java.util.Locale;
        BooleanQuery query = new BooleanQuery.Builder().add(new FuzzyQuery(new Term("text", "brow")), BooleanClause.Occur.SHOULD)
        );
/*
            outputs
        BooleanQuery query = new BooleanQuery.Builder().add(new TermQuery(new Term("text", "quick")), BooleanClause.Occur.SHOULD)
import static org.hamcrest.CoreMatchers.equalTo;
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    builder,
            "Just a test1 <b>highlighting</b> from unified highlighter.",
 * You may obtain a copy of the License at
    }
import org.apache.lucene.document.Document;
                FixedBitSet bits = new FixedBitSet(context.reader().maxDoc());
            .add(new TermQuery(new Term("text", "three")), BooleanClause.Occur.SHOULD)
        final String[] outputs = {
                    query,
        final String[] outputs = {
import org.apache.lucene.tests.index.RandomIndexWriter;
/*
    }
import org.opensearch.core.common.Strings;
    }
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 10),
            0,
        );
            new StandardAnalyzer(),
import org.apache.lucene.util.FixedBitSet;
            outputs
 *
 * The OpenSearch Contributors require contributions made to
            "This is <b>highlighting</b> the third short <b>highlighting</b> value.",
            FieldType ft = new FieldType(TextField.TYPE_STORED);
            .add(new TermQuery(new Term("text", "b")), BooleanClause.Occur.SHOULD)
        try (Directory dir = newDirectory()) {
            .add(new TermQuery(new Term("text", "fox")), BooleanClause.Occur.SHOULD)
                for (int i = 0; i < snippets.length; i++) {
    public void testSentenceBoundedBreakIterator() throws Exception {
import org.apache.lucene.search.highlight.DefaultEncoder;
            0,
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        assertHighlightOneDoc("text", inputs, analyzer, query, Locale.ROOT, BreakIterator.getSentenceInstance(Locale.ROOT), 0, outputs);
        assertHighlightOneDoc(
import org.apache.lucene.search.Query;
        final String[] outputs = { "Nested <b>highlighting</b> query." };
            iwc.setMergePolicy(newTieredMergePolicy(random()));
                assertThat(topDocs.totalHits.value(), equalTo(1L));
 */
    public void testOpenSearchToParentBlockJoinQuery() throws Exception {
            Document doc = new Document();
        final String[] inputs = {
            "Just a test4 <b>highlighting</b> from unified highlighter." };
                IndexSearcher searcher = newSearcher(reader);
    public void testOverlappingTerms() throws Exception {
import org.apache.lucene.queries.CommonTermsQuery;
 * under the License.
        );
        assertHighlightOneDoc(
        Query query = new TermQuery(new Term("text", "highlighting"));
    public void testMultiPhrasePrefixQuery() throws Exception {
                    "text",
        query.add(new Term("text", "bro"));
 *
        final String[] outputs = { "<b>bro</b>", "<b>brown</b>", "<b>browni</b>e", "<b>browser</b>" };
            100,
        query.add(new Term("text", "fox"));
            BreakIterator.getSentenceInstance(Locale.ROOT),
                final Snippet[] snippets = highlighter.highlightField(getOnlyLeafReader(reader), topDocs.scoreDocs[0].doc, () -> rawValue);
            0,
                    locale,
                    new CustomPassageFormatter("<b>", "</b>", new DefaultEncoder()),
 * KIND, either express or implied.  See the License for the
            "sentence with <b>brown</b>",
            new StandardAnalyzer(),
            inputs,
            query,
            query,
                    bits.set(i);
            Locale.ROOT,
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 20),
                    assertEquals(snippets[i].getText(), expectedPassages[i]);
            .add(new TermQuery(new Term("text", "bro")), BooleanClause.Occur.SHOULD)
import org.apache.lucene.search.TopDocs;
        BooleanQuery query = new BooleanQuery.Builder().add(new TermQuery(new Term("text", "one")), BooleanClause.Occur.SHOULD)
        );
            BreakIterator.getSentenceInstance(Locale.ROOT),
            Locale.ROOT,
        final String[] inputs = { "Fun  fun fun  fun  fun  fun  fun  fun  fun  fun" };
            expectedPassages
            Locale.ROOT,
import org.apache.lucene.index.IndexWriterConfig;
            "This is the second <b>highlighting</b> value to perform <b>highlighting</b> on a" + " longer text that gets scored lower.",
                return bits;
                for (int i = 0; i < context.reader().maxDoc(); i++) {
        query.add(new Term("text", "brown"));
    public void testMultiPhrasePrefixQuerySingleTerm() throws Exception {
        assertHighlightOneDoc(
            }
            query,
import org.apache.lucene.store.Directory;
        Query query = new TermQuery(new Term("text", "fun"));
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
    private void assertHighlightOneDoc(
        query.add(new Term("text", "brown"));
            "<b>fun</b>  <b>fun</b>" };
            @Override
import org.apache.lucene.document.FieldType;
        assertHighlightOneDoc(
        Query childQuery = new TermQuery(new Term("text", "highlighting"));
        assertHighlightOneDoc(
        query.add(new Term("text", "quick"));
            "Followed by many <b>words</b>",
        CommonTermsQuery query = new CommonTermsQuery(BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD, 128);
            "<b>brown</b> <b>fox</b>.",
        );
            query,
            Locale.ROOT,
            "text",
            "The <b>quick</b> <b>brown</b>",
        final String[] inputs = { "The quick brown fox." };
