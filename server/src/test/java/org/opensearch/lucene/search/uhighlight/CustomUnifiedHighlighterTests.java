        Analyzer analyzer,
            inputs,
                    bits.set(i);  
            "text",
                assertEquals(snippets.length, expectedPassages.length);  
            public BitSet getBitSet(LeafReaderContext context) throws IOException {  
        );  
            "This is highlighting the third short highlighting value.",  
                String rawValue = Strings.arrayToDelimitedString(inputs, String.valueOf(MULTIVAL_SEP_CHAR));  
        final String[] inputs = {
            "This is the second <b>highlighting</b> value to perform <b>highlighting</b> on a" + " longer text that gets scored lower.",
            "text",
 * ownership. Elasticsearch licenses this file to you under  
            "The <b>quick</b> <b>brown</b>",
        query.add(new Term("text", "quick"));
        final String[] inputs = { "The quick brown fox." };  
                CustomUnifiedHighlighter highlighter = new CustomUnifiedHighlighter(  
            outputs
        query.add(new Term("text", "quick"));  
 * Unless required by applicable law or agreed to in writing,
            inputs,
            "<b>fun</b>  <b>fun</b>" };
            Locale.ROOT,
    public void testOpenSearchToParentBlockJoinQuery() throws Exception {
import org.apache.lucene.index.LeafReaderContext;  
            "Just a test4 <b>highlighting</b> from unified highlighter." };
        );  
 * license agreements. See the NOTICE file distributed with
        };
            }
            outputs  
            "This is the second highlighting value to perform highlighting on a longer text that gets scored lower.",
            "This is a test. Just a test1 highlighting from unified highlighter.",
        );
    public void testNoMatchSize() throws Exception {  
        final String[] outputs = {
            .add(new TermQuery(new Term("text", "fox")), BooleanClause.Occur.SHOULD)
        );  
            "<b>fun</b>  <b>fun</b>  <b>fun</b>",  
import org.apache.lucene.search.join.ScoreMode;  
        query = new PhraseQuery.Builder().add(new Term("text", "fun")).add(new Term("text", "fun")).build();
    public void testOverlappingTerms() throws Exception {  
    public void testMultiPhrasePrefixQuerySingleTerm() throws Exception {  
            BreakIterator.getSentenceInstance(Locale.ROOT),
        Query query = new TermQuery(new Term("text", "highlighting"));
        Query query,
        BitSetProducer parentsFilter = new BitSetProducer() {
/*
 * GitHub history for details.
                    breakIterator,
            outputs  
import org.apache.lucene.tests.index.RandomIndexWriter;  
        final String[] inputs = { "A short sentence. Followed by a bigger sentence that should be truncated. And a last short sentence." };
            0,
        String fieldName,
            for (String input : inputs) {
                builder.withFieldMatcher("text"::equals);
    }
    public void testMultiPhrasePrefixQuery() throws Exception {
    }
        MultiPhrasePrefixQuery query = new MultiPhrasePrefixQuery("text");
        assertHighlightOneDoc(  
        assertHighlightOneDoc(
import java.text.BreakIterator;  
 * this work for additional information regarding copyright
                    builder,
            new StandardAnalyzer(),  
        Query query = new TermQuery(new Term("text", "fun"));
                field.setStringValue(input);  
            "<b>brown</b> <b>fox</b>.",
            Locale.ROOT,  
import org.apache.lucene.document.Field;  
        );
        String[] inputs,  
 * the Apache License, Version 2.0 (the "License"); you may
        CommonTermsQuery query = new CommonTermsQuery(BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD, 128);  
                for (int i = 0; i < snippets.length; i++) {
    public void testCommonTermsQuery() throws Exception {  
            expectedPassages
        MultiPhrasePrefixQuery query = new MultiPhrasePrefixQuery("text");  
        );  
                    assertEquals(snippets[i].getText(), expectedPassages[i]);
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 10),  
        Analyzer analyzer = CustomAnalyzer.builder()
                FixedBitSet bits = new FixedBitSet(context.reader().maxDoc());
            "<b>fox</b>.", };
        assertHighlightOneDoc(
        query.add(new Term("text", "brown"));
        assertHighlightOneDoc(  
        try (Directory dir = newDirectory()) {
import org.apache.lucene.search.join.BitSetProducer;
import org.apache.lucene.search.BooleanQuery;
            0,
                UnifiedHighlighter.Builder builder = UnifiedHighlighter.builder(searcher, analyzer);
            "text",
                    "text",
    public void testSentenceBoundedBreakIterator() throws Exception {
            .add(new TermQuery(new Term("text", "three")), BooleanClause.Occur.SHOULD)  
        query.add(new Term("text", "bro"));
            FieldType ft = new FieldType(TextField.TYPE_STORED);  
            query,  
            "text",
            Locale.ROOT,
        assertHighlightOneDoc(
            inputs,
            0,
            "Just a test4 highlighting from unified highlighter." };
 */  
                }  
            "text",
import org.apache.lucene.analysis.Analyzer;
            "<b>One</b>. <b>Two</b>. <b>Three</b>.",
import org.apache.lucene.util.BitSet;
import org.apache.lucene.search.IndexSearcher;  
                iw.close();  
            100,
        TermQuery query = new TermQuery(new Term("text", "sentence"));  
            "<b>Two</b> <b>words</b>.",  
            .add(new TermQuery(new Term("text", "brown")), BooleanClause.Occur.SHOULD)  
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
            "text",
import org.apache.lucene.analysis.custom.CustomAnalyzer;
            query,
            BreakIterator.getSentenceInstance(Locale.ROOT),  
            Locale.ROOT,
            .add(new TermQuery(new Term("text", "browser")), BooleanClause.Occur.SHOULD)  
import org.opensearch.core.common.Strings;
            "text",
import org.apache.lucene.index.IndexWriterConfig;
 */
                    UnifiedHighlighter.OffsetSource.ANALYSIS,
import org.apache.lucene.search.uhighlight.UnifiedHighlighter;
import org.apache.lucene.search.Query;  
            query,
            iwc.setMergePolicy(newTieredMergePolicy(random()));
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 10),  
 */  
        final String[] inputs = { "bro", "brown", "brownie", "browser" };
/*  
import org.apache.lucene.store.Directory;
import org.apache.lucene.search.BooleanClause;  
        final String[] outputs = {  
            Locale.ROOT,
            query,
            inputs,
 *    http://www.apache.org/licenses/LICENSE-2.0
            parentQuery,
            "with another <b>quick</b>",
            "text",
            ft.freeze();
            .build();
public class CustomUnifiedHighlighterTests extends OpenSearchTestCase {  
import org.apache.lucene.search.TermQuery;
    ) throws Exception {
            query,
import java.io.IOException;
            .add(new TermQuery(new Term("text", "words")), BooleanClause.Occur.SHOULD)
 * specific language governing permissions and limitations
            Locale.ROOT,
            inputs,
import java.util.Locale;
    }
                final Snippet[] snippets = highlighter.highlightField(getOnlyLeafReader(reader), topDocs.scoreDocs[0].doc, () -> rawValue);
    }
        );
        );  
        Query childQuery = new TermQuery(new Term("text", "highlighting"));  
                IndexSearcher searcher = newSearcher(reader);
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;  
                    expectedPassages.length,
 *  
            Locale.ROOT,
            new StandardAnalyzer(),  
import static org.hamcrest.CoreMatchers.equalTo;
        assertHighlightOneDoc(  
            .add(new TermQuery(new Term("text", "br")), BooleanClause.Occur.SHOULD)
import org.opensearch.test.OpenSearchTestCase;  
            inputs
import org.apache.lucene.search.Sort;
 *
            0,
            0,
                    Integer.MAX_VALUE,
        assertHighlightOneDoc(  
 * Modifications Copyright OpenSearch Contributors. See
            BreakIterator.getSentenceInstance(Locale.ROOT),  
                Field field = new Field(fieldName, "", ft);
                    "index",  
        final String[] outputs = { "Nested <b>highlighting</b> query." };
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.Term;
            outputs
            .withTokenizer(EdgeNGramTokenizerFactory.class, "minGramSize", "1", "maxGramSize", "7")  
            BreakIterator.getSentenceInstance(Locale.ROOT),
            .build();
            "This is <b>highlighting</b> the third short <b>highlighting</b> value.",  
import org.apache.lucene.document.FieldType;
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter.MULTIVAL_SEP_CHAR;  
                    locale,
    }  
        final String[] outputs = { "The <b>quick</b> <b>brown</b> <b>fox</b>." };
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        BooleanQuery query = new BooleanQuery.Builder().add(new FuzzyQuery(new Term("text", "brow")), BooleanClause.Occur.SHOULD)  
            inputs,
    }
        final String[] inputs = { "Nested highlighting query." };  
        assertHighlightOneDoc(
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 20),
        query.add(new Term("text", "brown"));
            query,
import org.apache.lucene.analysis.ngram.EdgeNGramTokenizerFactory;  
            RandomIndexWriter iw = new RandomIndexWriter(random(), dir, iwc);
import org.apache.lucene.queries.CommonTermsQuery;
        final String[] inputs = { "This is a test. Just a test highlighting from unified. Feel free to ignore." };
                for (int i = 0; i < context.reader().maxDoc(); i++) {
            inputs,
import org.apache.lucene.document.Document;
        assertHighlightOneDoc(  
            "<b>Fun</b>  <b>fun</b> <b>fun</b>",
            .add(new TermQuery(new Term("text", "bro")), BooleanClause.Occur.SHOULD)  
            .build();
                return bits;
                assertThat(topDocs.totalHits.value(), equalTo(1L));
            ft.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS);
            Locale.ROOT,  
            new StandardAnalyzer(),
        }
            new StandardAnalyzer(),  
            "text",  
 * this file be licensed under the Apache-2.0 license or a
            Document doc = new Document();  
import org.apache.lucene.index.DirectoryReader;  
            inputs,  
            0,
            .add(new TermQuery(new Term("text", "browni")), BooleanClause.Occur.SHOULD)
        BreakIterator breakIterator,
            outputs  
import org.apache.lucene.search.FuzzyQuery;
            0,
            .add(new TermQuery(new Term("text", "brown")), BooleanClause.Occur.SHOULD)
        final String[] outputs = { "The quick <b>brown</b> fox." };
            0,
            inputs,
                );
            outputs
        Query parentQuery = new OpenSearchToParentBlockJoinQuery(childQuery, parentsFilter, ScoreMode.None, "foo");  
 * not use this file except in compliance with the License.
                    query,
        Query query = new TermQuery(new Term("body", "highlighting"));
        final String[] inputs = { "The quick brown fox." };
            0,
                    new CustomPassageFormatter("<b>", "</b>", new DefaultEncoder()),  
        int noMatchSize,
            new StandardAnalyzer(),  
 *
            .add(new TermQuery(new Term("text", "two")), BooleanClause.Occur.SHOULD)
    }
}
            "The quick brown fox in a long sentence with another quick brown fox. " + "Another sentence with brown fox." };  
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 10),  
import org.apache.lucene.index.IndexOptions;
            Locale.ROOT,  
            }  
            }
/*  
            query,
            outputs
        BooleanQuery query = new BooleanQuery.Builder().add(new TermQuery(new Term("text", "quick")), BooleanClause.Occur.SHOULD)
    }  
            .build();
package org.opensearch.lucene.search.uhighlight;
            query,
    public void testSimple() throws Exception {
import org.apache.lucene.util.FixedBitSet;
    }
            "Followed by many <b>words</b>",
 * compatible open source license.
        final String[] outputs = {
import org.apache.lucene.search.MatchAllDocsQuery;
            BreakIterator.getSentenceInstance(Locale.ROOT),
        Locale locale,  
 * KIND, either express or implied.  See the License for the
        );
            new StandardAnalyzer(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }
            iw.addDocument(doc);  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
        final String[] inputs = { "Two words. Followed by many words in a big sentence. One. Two. Three. And more words." };
        BooleanQuery query = new BooleanQuery.Builder().add(new TermQuery(new Term("text", "one")), BooleanClause.Occur.SHOULD)
 * SPDX-License-Identifier: Apache-2.0
                TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), 1, Sort.INDEXORDER);
            query,
        query.add(new Term("text", "fox"));  
            .add(new TermQuery(new Term("text", "b")), BooleanClause.Occur.SHOULD)
    public void testRepeat() throws Exception {
 * under the License.  
            Locale.ROOT,
        );  
        assertHighlightOneDoc("text", inputs, analyzer, query, Locale.ROOT, BreakIterator.getSentenceInstance(Locale.ROOT), 0, outputs);
import org.apache.lucene.search.PhraseQuery;
                    noMatchSize,  
        final String[] outputs = { "<b>bro</b>", "<b>brown</b>", "<b>browni</b>e", "<b>browser</b>" };
            "Just a test1 <b>highlighting</b> from unified highlighter.",
import org.apache.lucene.search.highlight.DefaultEncoder;
import org.apache.lucene.search.TopDocs;  
        final String[] outputs = { "The <b>quick</b> <b>brown</b> <b>fox</b>." };
            new StandardAnalyzer(),  
            new StandardAnalyzer(),  
        String[] expectedPassages  
        );  
            BreakIterator.getSentenceInstance(Locale.ROOT),  
            "<b>fox</b> in a long",  
        final String[] inputs = { "The quick brown fox." };
                    null  
    }
            "And more <b>words</b>.", };  
    }
        query.add(new Term("text", "fo"));
        assertHighlightOneDoc(  
            inputs,  
            outputs
            "text",
        String[] expectedPassages = {  
            inputs,  
        assertHighlightOneDoc(  
            new StandardAnalyzer(),
import org.apache.lucene.document.TextField;
        final String[] inputs = { "Fun  fun fun  fun  fun  fun  fun  fun  fun  fun" };
            new StandardAnalyzer(),
            query,
    }  
            new StandardAnalyzer(),  
            outputs
                doc.add(field);
    public void testSmallSentenceBoundedBreakIterator() throws Exception {  
            BoundedBreakIteratorScanner.getSentence(Locale.ROOT, 20),  
        final String[] inputs = {  
            "<b>fun</b>  <b>fun</b>",
            0,  
    public void testGroupSentences() throws Exception {  
            @Override
            IndexWriterConfig iwc = newIndexWriterConfig(analyzer);  
        final String[] outputs = { "A short <b>sentence</b>.", "Followed by a bigger <b>sentence</b>", "And a last short <b>sentence</b>" };
    private void assertHighlightOneDoc(
            Locale.ROOT,
            "text",
            try (DirectoryReader reader = iw.getReader()) {
            "sentence with <b>brown</b>",  
