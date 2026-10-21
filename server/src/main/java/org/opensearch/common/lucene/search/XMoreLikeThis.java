     * <li> The IDF value (Float)
                Document d = storedFields.document(docNum);
            int docFreq = 0;
     * @see #isBoost
     * in more than this many docs will be ignored.
package org.opensearch.common.lucene.search;
import org.apache.lucene.index.PostingsEnum;
        return createQueue(words, this.fieldNames);
import org.apache.lucene.index.FieldInfos;
 * in terms with a high tf. Choosing a tf threshold even as low as two or three will radically
                }
        return al.toArray(res);
    }
 * Term frequencies can be computed by re-tokenizing the text, which, for a single document,
            // gather list of valid fields from lucene
                if (isSkipTerm(fieldName, word)) {
        sb.append("\t").append("fieldNames     : ");
                if (bestScore == -1) {
 * Modifications Copyright OpenSearch Contributors. See
            } else {
        return similarity;
    /**
    /**
    }
     * @return a query that will return docs like the passed Fields.
 * was only counting one occurrence per term/field pair in calculations(ie not including frequency info from TermVector)
    /**
                        addTermFrequencies(new StringReader(stringValue), termFreqMap, fieldName);
     * The default field names that will be used is {@link #DEFAULT_FIELD_NAMES}.
    public void setMaxDocFreq(int maxFreq) {
            final PostingsEnum docs = termsEnum.postings(null);
    }
     * Returns the field names that will be used when generating the 'More Like This' query.
    /**
     *
    /**
     * Use for frequencies and to avoid renewing Integers.
        ScoreTerm(String word, String topField, float score) {
    /**
     * {@link #like(int)} method, all other 'like' methods require an analyzer.
     */
    private Set<?> stopWords = DEFAULT_STOP_WORDS;
     * More advanced users will call {@link #retrieveTerms(Reader, String) retrieveTerms()} directly.
    }
     * Constructor requiring an IndexReader.
 * Unless required by applicable law or agreed to in writing,
    private String[] fieldNames = DEFAULT_FIELD_NAMES;
        this.skipTerms = skipTerms;
     *
     */
    /**
     * Current set of stop words.
     */
     *
        }
        return stopWords != null && stopWords.contains(term);
 * You may want to use {@link #setFieldNames setFieldNames(...)} so you can examine
     * @return whether to boost terms in query based on "score" or not.
        }
 * Copyright 2004-2005 The Apache Software Foundation.
     */
     * @param words a map of words keyed on the word(String) with Int objects as the values.
    public float getBoostFactor() {
     *
 * </ul>
import java.util.Collection;
    public void setStopWords(Set<?> stopWords) {
     * @param maxPercentage the maximum percentage of documents (0-100) that a term may appear
                    }
 * See the License for the specific language governing permissions and
    // assert Version.CURRENT.luceneVersion == org.apache.lucene.util.Version.LUCENE_4_9:
     */
 * The OpenSearch Contributors require contributions made to
        sb.append("\t").append("maxQueryTerms  : ").append(maxQueryTerms).append("\n");
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.TokenStream;
 * <p>
    /**
    private void addTermFrequencies(Map<String, Int> termFreqMap, Terms vector, @Nullable String fieldName) throws IOException {
     */
 * provide a "more like this" button on a search results page that does a decent job and has
    }
    }
    public XMoreLikeThis(IndexReader ir) {
 * </pre>
     * @param vector List of terms and their frequencies for a doc/field
     * @return the field names that will be used when generating the 'More Like This' query.
     * Adds terms and frequencies found in vector into the Map termFreqMap
     * Adds term frequencies found by tokenizing text from reader into the Map words
    /**
        this.stopWords = stopWords;
    /**
        ScoreTerm scoreTerm;
    private final IndexReader ir;
     *
 * this file be licensed under the Apache-2.0 license or a
 * fragment is specific to this class.
 */
    /**
    // static {
     * @param i The maximum number of tokens to parse in each example doc field that is not stored with TermVector support
    }
     * is not set.
    /**
 */
     * @param term The word being considered
     * @param r the reader that has the content of the document
    /**
     */
    private boolean boost = DEFAULT_BOOST;
import org.apache.lucene.search.IndexSearcher;
     * @return true if should be ignored, false if should be used in further analysis
    /**
     */
            while (ts.incrementToken()) {
 * <li> {@link #setMinWordLen setMinWordLen(...)}
     */
     * query.
     * Set this to null for the field names to be determined at runtime from the IndexReader
    /**
    private int maxWordLen = DEFAULT_MAX_WORD_LENGTH;
     * PriorityQueue that orders words by score.
     * @param fieldNames an array of field names to override defaults.
     * @param docNum the id of the lucene document from which to find terms
     */
 * multiple fields (e.g. body and title) for similarity.
    /**
            int tf = words.get(word).x; // term freq in the source doc
        }
 * @opensearch.internal
     * @return a query that will return docs like the passed Readers.
     * @see #setBoostFactor(float)
    public void setMaxWordLen(int maxWordLen) {
            }
            }
            this.score = score;
     *
                tq = new BoostQuery(tq, boostFactor * myScore / bestScore);
        Int() {
            al.add(scoreTerm.word); // the 1st entry is the interesting word
                    term.update(word, topField, score);
    }
        final CharsRefBuilder spare = new CharsRefBuilder();
        int lim = maxQueryTerms; // have to be careful, retrieveTerms returns all words but that's probably not useful to our caller...
     * Ignore words if greater than this len.
     *
 * </pre>
            this.score = score;
     */
    }
import org.apache.lucene.index.Terms;
 *
        while (((scoreTerm = pq.pop()) != null) && lim-- > 0) {
    /**
     * @param maxWordLen the maximum word length above which words will be ignored.
     * @see #setMaxWordLen
     *
        int len = term.length();
import org.apache.lucene.analysis.Analyzer;
     */
     * Boost terms in query based on score.
 *
    }
/*
    /**
 * <li> {@link #setMinTermFreq setMinTermFreq(...)}
    /**
    }
        return stopWords;
     *
    /**
     */
        for (String fieldName : fieldNames) {
     * maximum word length. The default is {@link #DEFAULT_MAX_WORD_LENGTH}.
        for (Terms vector : likeTerms) {
    public void setMinWordLen(int minWordLen) {
        return sb.toString();
     * @param r a source of text to be tokenized
     * Ignore terms with less than this frequency in the source doc.
    /**
    /**
     * @return get the maximum frequency at which words are still allowed,
            if (cnt == null) {
     */
     * @param docNum the documentID of the lucene doc to generate the 'More Like This" query for.
import java.io.StringReader;
     * Create a PriorityQueue from a word-&gt;tf map.
            } else {
                queue.add(new ScoreTerm(word, topField, score));
        return fieldNames;
            if (boost) {
import org.apache.lucene.search.DocIdSetIterator;
     */
        final int limit = Math.min(maxQueryTerms, words.size());
            al.add(scoreTerm.word); // the 1st entry is the interesting word
     *
    public Set<?> getStopWords() {
            }
     * determines if the passed term is likely to be of interest in "more like" comparisons
 * - optimise: when no termvector support available - used maxNumTermsParsed to limit amount of tokenization
     * Don't return a query longer than this.
    }
    }
     */
    /**
                if (tokenCount > maxNumTokensParsed) {
        ScoreTerm scoreTerm;
     * @param boost true to boost terms in query based on "score", false otherwise.
    private static class ScoreTerm {
     * @param termFreqMap a Map of terms and their frequencies
        FreqQ queue = new FreqQ(limit); // will order words by score
     */
        }
    /**
    }
     *
     * @param maxQueryTerms the maximum number of query terms that will be included in any
        ScoreTerm scoreTerm;
                continue; // filter out words that don't occur in enough docs
     */
            }
     * Returns the maximum frequency in which words may still appear.
import java.io.IOException;
        return al.toArray(res);
 * license agreements. See the NOTICE file distributed with
            x = 1;
                if (isNoiseWord(word)) {
     * Any word in this set is considered "uninteresting" and ignored.
import org.apache.lucene.index.Fields;
     *
            final Terms vector;
import org.apache.lucene.search.Query;
            String topField = fieldNames[0];
     */
     *         words which occur in more docs than this are ignored.
     * Even if your Analyzer allows stopwords, you might want to tell the MoreLikeThis code to ignore them, as
    private void addTermFrequencies(Reader r, Map<String, Int> termFreqMap, String fieldName) throws IOException {
                int freq = ir.docFreq(new Term(fieldName, word));
        PriorityQueue<ScoreTerm> pq = retrieveTerms(docNum);
     * Return a Query with no more than this many terms.
     */
     */
        sb.append("\n");
 * It all depends on what you're trying to do.  If you're trying to eek out that last percent
     * Default set of stopwords.
        }
     * provided in the constructor.
            sb.append(delim).append(fieldName);
            if (queue.size() < limit) {
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
     *
     * Sets whether to boost terms in query based on "score" or not.
    /**
import java.util.HashSet;
        if (fieldNames == null) {
     *
        }
 * Lucene does let you access the document frequency of terms, with IndexReader.docFreq().
     * Return a query that will return docs like the passed Readers.
     * <li> The frequency of this word in the index (Integer)
     *
        this.ir = ir;
            // for every token
     * @param fieldName Optional field name of the terms for skip terms
     */
    /**
}
 */
        }
     *
 *
    public void setSkipTerms(Set<Term> skipTerms) {
        sb.append("\t").append("minTermFreq    : ").append(minTermFreq).append("\n");
     */
    private static class Int {
            if (docFreq > maxDocFreq) {
     * @return the most interesting words in the document ordered by score, with the highest scoring, or best entry, first
import org.apache.lucene.index.TermVectors;
     * @return the maximum number of query terms that will be included in any generated query.
     * Ignore words which occur in more than this many docs.
     */
        PriorityQueue<ScoreTerm> pq = retrieveTerms(r, fieldName);
     * Find words for a more-like-this query former.
        int numDocs = ir.numDocs();
            }
     * @see #setBoost
        }
                }
            // field does not store term vector info
            final String term = spare.toString();
     * @return the maximum word length above which words will be ignored.
 * <hr>
        StringBuilder sb = new StringBuilder();
     */
 *
    public int getMinTermFreq() {
import org.apache.lucene.search.similarities.ClassicSimilarity;
        return boost;
    }
    /**
     * @see #getStopWords
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *
    private TFIDFSimilarity similarity;// = new ClassicSimilarity();
 * <li> {@link #setMaxDocFreq setMaxDocFreq(...)}
    }
    /**
    /**
                topField = (freq > docFreq) ? fieldName : topField;
     *
     * @see IndexSearcher#getMaxClauseCount
            float idf = similarity.idf(docFreq, numDocs);
     * @see #retrieveTerms(java.io.Reader, String)
     * Ignore words greater than this length or if 0 then this has no effect.
     * Field name we'll analyze.
    private Analyzer analyzer = null;
    }
     *
            for (String fieldName : fields) {
import java.util.HashMap;
            return true;
        while ((text = termsEnum.next()) != null) {
    /**
    public void setMinDocFreq(int minDocFreq) {
     * @param analyzer the analyzer to use to tokenize text.
            }
    /**
 * <li> then call one of the like() calls to generate a similarity query
            if (vector == null) {
 */
            }
 * <li> get the text of the doc you want to find similarities to
    /**
        }
     *
                    if (stringValue != null) {
import org.apache.lucene.search.BooleanClause;
        this.similarity = sim;
                    addTermFrequencies(termFreqMap, vector, fieldName);
                vector = null;
     * @param r the source document
        return minWordLen;
     * Return a query that will return docs like the passed Terms.
 * </pre>
import java.util.Set;
                query.add(tq, BooleanClause.Occur.SHOULD);
     */
                float myScore = (scoreTerm.score);
     *
    public String[] retrieveInterestingTerms(Reader r, String fieldName) throws IOException {
     * Default maximum number of tokens to parse in each example doc field that is not stored with TermVector support.
     * @return The maximum number of tokens to parse in each example doc field that is not stored with TermVector support
     * @param fieldNames the field names that will be used when generating the 'More Like This'
        maxNumTokensParsed = i;
     * @param stopWords set of stopwords, if null it means to allow stop words
        return field != null && skipTerms != null && skipTerms.contains(new Term(field, value));
                break;
        this.fieldNames = fieldNames;
    /**
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @see #getMaxWordLen
    /**
     * Create the More like query from a PriorityQueue
     * Returns whether to boost terms in query based on "score" or not. The default is
        while ((scoreTerm = q.pop()) != null) {
    public TFIDFSimilarity getSimilarity() {
        return createQueue(words);
     */
     * Returns the frequency at which words will be ignored which do not occur in at least this
                ScoreTerm term = queue.top();
    /**
     * Returns the maximum word length above which words will be ignored. Set this to 0 for no
            }
 * You may obtain a copy of the License at
     * <li> The frequency of this word in the source document (Integer)
     * Ignore words which do not occur in at least this many docs.
     * Each array has 6 elements.
     * frequency is the {@link #DEFAULT_MIN_TERM_FREQ}.
     * Words that appear in more than this many docs will be ignored. The default frequency is
     */
     * @param vector List of terms and their frequencies for a doc/field
                    cnt.x++;
     * @return the frequency at which words will be ignored which do not occur in at least this
    // "Remove this class once we upgrade to Lucene 5.0";
 * good performance, such techniques might be useful.
    }
    }
    private boolean isSkipTerm(@Nullable String field, String value) {
 * <li> do your normal, Lucene setup for searching,
                continue;
     */
 * <p>
        return createQuery(createQueue(words));
    /**
            for (Fields fields : likeFields) {
     */
     *
     * <li> The score for this word (Float)
        }
 * compatible open source license.
        this.minTermFreq = minTermFreq;
 * <pre>
    }
     * The result is a priority queue of arrays with one entry for <b>every word</b> in the document.
    private static class FreqQ extends PriorityQueue<ScoreTerm> {
        float bestScore = -1;
/*
    /**
                freq += docs.freq();
    public static final String[] DEFAULT_FIELD_NAMES = new String[] { "contents" };
        FreqQ(int maxSize) {
import org.apache.lucene.index.StoredFields;
     *
/*
        return maxWordLen;
     * @see #getMaxNumTokensParsed
        void update(String word, String topField, float score) {
     * Boost factor to use when boosting the terms
 * <li> {@link #setMaxQueryTerms setMaxQueryTerms(...)}
 * <p>
     *
     */
     */
 * above.  The frequency and length thresholds could be parameters, etc.
 * limitations under the License.
            } else {
     * The maximum number of tokens to parse in each example doc field that is not stored with TermVector support
    public Query like(int docNum) throws IOException {
     * Get the current stop words being used.
                fieldNames.add(fieldName);
     * @see #setMinWordLen
            CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
        return analyzer;
    public String[] retrieveInterestingTerms(int docNum) throws IOException {
     */
        this.analyzer = analyzer;
                continue; // filter out words that occur in too many docs
                for (IndexableField field : fields) {
     */
     * @param fieldName field passed to the analyzer to use when analyzing the content
     * @see #isBoost
     * @return the most interesting words in the document
        for (String fieldName : fieldNames) {
     * @see #setStopWords
    }
    }
     * @see #retrieveInterestingTerms
            fieldNames = fields.toArray(new String[0]);
 * high idf (i.e., a low df) tend to be longer.  So you could threshold the terms by the
            int freq = 0;
    /**
    public static final int DEFAULT_MIN_WORD_LENGTH = 0;
        }
    public static final int DEFAULT_MAX_NUM_TOKENS_PARSED = 5000;
        return createQueue(termFreqMap);
     * @see #setMaxDocFreqPct
     *
            while (docs != null && docs.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
     */
 * Depending on the size of your index and the size and makeup of your documents you
     * @return the frequency below which terms will be ignored in the source doc.
     * @return the analyzer that will be used to parse source doc with.
        if (maxWordLen > 0 && len > maxWordLen) {
 * - bugfix: No significant terms being created for fields with a termvector - because
                    break;
        sb.append("\t").append("boost          : ").append(boost).append("\n");
     * many docs. The default frequency is {@link #DEFAULT_MIN_DOC_FREQ}.
    public static final int DEFAULT_MAX_QUERY_TERMS = 25;
            addToQuery(createQueue(termFreqMap, fieldName), bq);
import org.apache.lucene.util.PriorityQueue;
        addTermFrequencies(termFreqMap, vector, null);
                if (cnt == null) {
    }
     *
                } else {
        this.boost = boost;
     * @see #getMaxDocFreq
                Terms vector = fields.terms(fieldName);
            final Fields vectors = termVectors.get(docNum);
     * </ol>
     * Find words for a more-like-this query former.
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    private PriorityQueue<ScoreTerm> retrieveTerms(Reader r, String fieldName) throws IOException {
                    bestScore = (scoreTerm.score);
 * of precision and recall regardless of computational difficulty so that you can win a TREC
     *
 * <li> create a MoreLikeThis,
 * <li> call the searcher to find the similar docs
     *
    /**
    public Query like(Terms... likeTerms) throws IOException {
     * @param fieldName Used by analyzer for any special per-field analysis
 * <pre class="prettyprint">
     * The default is {@link #DEFAULT_MAX_QUERY_TERMS}.
        addToQuery(q, query);
    public static final int DEFAULT_MAX_WORD_LENGTH = 0;
            throw new UnsupportedOperationException("To use MoreLikeThis without " + "term vectors, you must provide an Analyzer");
    /**
     */
     */
        protected boolean lessThan(ScoreTerm a, ScoreTerm b) {
        this(ir, new ClassicSimilarity());
    }
                }
                }
            }
            Query tq = new TermQuery(new Term(scoreTerm.topField, scoreTerm.word));
 * under the License.
 * that do a pretty good job of characterizing a document.
        addTermFrequencies(r, words, fieldName);
     */
    public void setSimilarity(TFIDFSimilarity similarity) {
 * MoreLikeThis mlt = new MoreLikeThis(ir);
    public int getMaxNumTokensParsed() {
        if (minWordLen > 0 && len < minWordLen) {
        }
     */
     * Sets the field names that will be used when generating the 'More Like This' query.
     */
     *
import org.apache.lucene.index.TermsEnum;
        }
    /**
            if (minDocFreq > 0 && docFreq < minDocFreq) {
 * <li> {@link #setStopWords setStopWord(...)}
     *
     * @see #setStopWords
     * Should we apply a boost to the Query based on the scores?
import java.io.Reader;
    private float boostFactor = 1;
     * @see #DEFAULT_MAX_NUM_TOKENS_PARSED
 * number of characters, not selecting anything less than, e.g., six or seven characters.
        this.maxWordLen = maxWordLen;
 * you may not use this file except in compliance with the License.
        this.maxQueryTerms = maxQueryTerms;
    }
    /**
    private Set<Term> skipTerms = null;
        for (Reader r : readers) {
 * Unless required by applicable law or agreed to in writing, software
     * Adds terms and frequencies found in vector into the Map termFreqMap
    /**
                    continue;
 * <li> {@link #setMaxWordLen setMaxWordLen(...)}
 * Licensed under the Apache License, Version 2.0 (the "License");
                cnt = new Int();
    public Analyzer getAnalyzer() {
    }
        try (TokenStream ts = analyzer.tokenStream(fieldName, r)) {
    public static final int DEFAULT_MIN_DOC_FREQ = 5;
     * @param minWordLen the minimum word length below which words will be ignored.
     * Convenience routine to make it easy to return the most interesting words in a document.
        int x;
        Map<String, Int> termFreqMap = new HashMap<>();
     * For idf() calculations.
            Collection<String> fields = FieldInfos.getIndexedFields(ir);
     */
                vector = vectors.terms(fieldName);
 * the Apache License, Version 2.0 (the "License"); you may
 * <ol>
     */
        int lim = maxQueryTerms; // have to be careful, retrieveTerms returns all words but that's probably not useful to our caller...
    public static final boolean DEFAULT_BOOST = false;
                    termFreqMap.put(word, new Int());
                }
        sb.append("\t").append("minDocFreq     : ").append(minDocFreq).append("\n");
    private PriorityQueue<ScoreTerm> createQueue(Map<String, Int> words) throws IOException {
     * @see #getBoostFactor()
 * competition, then the techniques I mention above are useless.  But if you're trying to
                if (term.score < score) { // update the smallest in the queue in place and update the queue.
     */
import java.util.ArrayList;
     */
    }
            }
/*
    public int getMaxDocFreq() {
        Map<String, Int> termFreqMap = new HashMap<>();
 *
     * @param minTermFreq the frequency below which terms will be ignored in the source doc.
     */
        String delim = "";
        }
    }
        Map<String, Int> words = new HashMap<>();
    private Query createQuery(PriorityQueue<ScoreTerm> q) {
     */
            super(maxSize);
 * <li> {@link #setMaxDocFreqPct setMaxDocFreqPct(...)}
                }
     * Return a query that will return docs like the passed Fields.
                    queue.updateTop();
        this.similarity = similarity;
 * may want to call the other set methods to control how the similarity queries are
    }
     */
     * Returns an analyzer that will be used to parse source doc with. The default analyzer
        }
     */
        @Override
    }
     * @return a query that will return docs like the passed Terms.
 * this work for additional information regarding copyright
     * @return the minimum word length below which words will be ignored.
     * This was added in order to treat multi-value fields.
                continue; // index update problem?
import org.apache.lucene.search.BooleanQuery;
    /**
            addTermFrequencies(r, words, fieldName);
            }
 * probably too slow.
 * KIND, either express or implied.  See the License for the
     * determines if the passed term is to be skipped all together
    public static final int DEFAULT_MIN_TERM_FREQ = 2;
    public String describeParams() {
        this.minDocFreq = minDocFreq;
        // get all field names
    public boolean isBoost() {
     * Sets the boost factor to use when boosting terms
        }
     */
     */
        }
    }
        return queue;
     */
     *
            if (docFreq == 0) {
     * IndexReader to use
     * Return a query that will return docs like the passed lucene document ID.
     * @see #setMinDocFreq
     * <ol>
     * Set the maximum percentage in which words may still appear. Words that appear
    public static final Set<?> DEFAULT_STOP_WORDS = null;
        return bq.build();
    private void addToQuery(PriorityQueue<ScoreTerm> q, BooleanQuery.Builder query) {
        float score;
 * IndexReader ir = ...
        for (Fields fields : likeFields) {
    }
     * @see #setMinTermFreq
     * For an easier method to call see {@link #retrieveInterestingTerms retrieveInterestingTerms()}.
        while (((scoreTerm = pq.pop()) != null) && lim-- > 0) {
     * many docs.
     * Sets the analyzer to use. An analyzer is not required for generating a query with the
     * A scored term
                continue;
     * @param fieldName field passed to analyzer to use when analyzing the content
    }
     * for the purposes of document similarity it seems reasonable to assume that "a stop word is never interesting".
        this.boostFactor = boostFactor;
        return maxDocFreq;
                cnt.x += freq;
    }
    public void setFieldNames(String[] fieldNames) {
    private int minTermFreq = DEFAULT_MIN_TERM_FREQ;
        String topField;
        }
    }
 * //you ignore the doc if it matches your 'target' document, as it should be similar to itself
     *
 * IndexSearcher is = ...
 * Licensed to Elasticsearch under one or more contributor
     * in to be still considered relevant
 * or at all.  Since you're trying to maximize a tf*idf score, you're probably most interested
     * The elements are:
    public Query like(String fieldName, Reader... readers) throws IOException {
     * @return the boost factor used when boosting terms
     * Add to an existing boolean query the More Like This query from this PriorityQueue
 * Changes: Mark Harwood 29/02/04
     */
     *         many docs.
    public void setBoostFactor(float boostFactor) {
 * Query query = mlt.like( target);
        for (String fieldName : fieldNames) {
            this.word = word;
    /**
 * Based on this mail:
 * Some bugfixing, some refactoring, some optimisation.
     *
     * @param termFreqMap a Map of terms and their frequencies
        this.maxDocFreq = maxFreq;
                continue; // filter out words that don't occur enough times in the source
            Map<String, Int> termFreqMap = new HashMap<>();
     *
     * @see #retrieveInterestingTerms(java.io.Reader, String)
    /**
        Set<String> fieldNames = new HashSet<>();
     * Ignore words which occur in more than this many docs.
    /**
     * @see #setMaxQueryTerms
import org.apache.lucene.util.BytesRef;
 *     http://www.apache.org/licenses/LICENSE-2.0
    private int minDocFreq = DEFAULT_MIN_DOC_FREQ;
    /**
     * @param termFreqMap a Map of terms and their frequencies
     *
     * Returns the boost factor used when boosting terms
            addTermFrequencies(termFreqMap, vector);
     * {@link #DEFAULT_MAX_DOC_FREQ}.
 * An efficient, effective "more-like-this" query generator would be a great contribution, if
                    continue;
                tokenCount++;
    }
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
     *
                IndexableField fields[] = d.getFields(fieldName);
     * @opensearch.internal
     */
    /**
 * text), analyzer Analyzer, and return a set of representative terms using heuristics like those
     * @param words a map of words keyed on the word(String) with Int objects as the values.
    /**
            this.topField = topField;
     * Describe the parameters that control how the "more like this" query is formed.
     * up at runtime from the provided reader.
    }
 * specific language governing permissions and limitations
 * Reader target = ... // orig source of doc you want to find similarities to
     * Default field names. Null is used to specify that the field names should be looked
            if (isSkipTerm(fieldName, term)) {
 * is usually fast enough.  But looking up the docFreq() of every term in the document is
     *
        return query.build();
     * @param minDocFreq the frequency at which words will be ignored which do not occur in at
    public Query like(Fields... likeFields) throws IOException {
 * // now the usual iteration thru 'hits' - the only thing to watch for is to make sure
     * minimum word length. The default is {@link #DEFAULT_MIN_WORD_LENGTH}.
    /**
    /**
     * Sets the frequency below which terms will be ignored in the source doc.
 * <ul>
 * - bugfix: retrieveTerms(int docNum) was not working for indexes without a termvector -added missing code
     * generated query.
     */
        }
        BooleanQuery.Builder query = new BooleanQuery.Builder();
    }
    /**
     *
 * <li> {@link #setMaxNumTokensParsed setMaxNumTokensParsed(...)}
                }
            ts.reset();
 * You can use some heuristics to prune the set of terms, to avoid calling docFreq() too much,
 * generated:
 * Hits hits = is.search(query);
    private int minWordLen = DEFAULT_MIN_WORD_LENGTH;
     * Returns the minimum word length below which words will be ignored. Set this to 0 for no
     * Analyzer that will be used to parse the doc.
        final TermVectors termVectors = ir.termVectors();
    public int getMinDocFreq() {
     * @opensearch.internal
        Map<String, Int> words = new HashMap<>();
     */
 * Doug
 * Generate "more like this" similarity queries.
            }
    public void setMinTermFreq(int minTermFreq) {
     * <li> The top field that this word comes from (String)
import org.apache.lucene.search.TermQuery;
     */
     */
            try {
     * Ignore words which do not occur in at least this many docs.
 */
    }
    public void setMaxQueryTerms(int maxQueryTerms) {
 * anyone's interested.  I'd imagine that it would take a Reader or a String (the document's
     *
     */
     * This method is exposed so that you can identify the "interesting words" in a document.
     * If null means to allow stop words.
 * - refactor: moved common code into isNoiseWord()
 *
                if (vector != null) {
     */
     */
     * @opensearch.internal
     */
     * least this many docs.
     * @param maxFreq the maximum count of documents that a term may appear
     * @see #getStopWords
    public XMoreLikeThis(IndexReader ir, TFIDFSimilarity sim) {
import org.opensearch.common.Nullable;
            float score = tf * idf;
    public String[] getFieldNames() {
        return createQuery(retrieveTerms(docNum));
 * </ol>
        }
 * distributed under the License is distributed on an "AS IS" BASIS,
 * <h2>Initial Usage</h2>
        sb.append("\t").append("minWordLen     : ").append(minWordLen).append("\n");
import org.apache.lucene.index.IndexReader;
 * <h3>More Advanced Usage</h3>
        final StoredFields storedFields = ir.storedFields();
     */
     */
    }
    public void setAnalyzer(Analyzer analyzer) {
     *
    public void setBoost(boolean boost) {
 * You may obtain a copy of the License at
    /**
    /**
     * Returns the maximum number of query terms that will be included in any generated query.
        ArrayList<Object> al = new ArrayList<>(maxQueryTerms);
     *
    public static final int DEFAULT_MAX_DOC_FREQ = Integer.MAX_VALUE;
     * Ignore words less than this length or if 0 then this has no effect.
     * Set the set of stopwords.
            this.word = word;
     *
     * Create a PriorityQueue from a word-&gt;tf map.
            // increment frequency
    private int maxDocFreq = DEFAULT_MAX_DOC_FREQ;
    public int getMinWordLen() {
 * <li> {@link #setMinDocFreq setMinDocFreq(...)}
    private boolean isNoiseWord(String term) {
     * @see #setMaxDocFreq
     */
                addTermFrequencies(termFreqMap, vector, fieldName);
     * in more than this many percent of all docs will be ignored.
     *
     */
    }
 *
 * reduce the number of terms under consideration.  Another heuristic is that terms with a
            } catch (IndexSearcher.TooManyClauses ignore) {
 * With these sorts of heuristics you can usually find small set of, e.g., ten or fewer terms
     *
 * <pre>
    }
        final TermsEnum termsEnum = vector.iterator();
            return a.score < b.score;
            return true;
    public void setMaxNumTokensParsed(int i) {
                termFreqMap.put(term, cnt);
     * in to be still considered relevant
import org.apache.lucene.util.CharsRefBuilder;
        return maxNumTokensParsed;
     * Sets the maximum number of query terms that will be included in any generated query.
    }
     *
            }
                // increment frequency
        String word;
     * Set the maximum frequency in which words may still appear. Words that appear
            } else {
import org.apache.lucene.index.IndexableField;
    /**
     * This is a somewhat "advanced" routine, and in general only the 1st entry in the array is of interest.
     * <li> The word (String)
     * @see #setBoost
     * Ignore words if less than this len.
    /**
                Int cnt = termFreqMap.get(word);
            }
     * @see #getMinDocFreq
            this.topField = topField;
    // }
     * @return a query that will return docs like the passed lucene document ID.
        for (String word : words.keySet()) { // for every word
import org.apache.lucene.search.BoostQuery;
        // have collected all words in doc and their freqs
public final class XMoreLikeThis {
import org.apache.lucene.search.similarities.TFIDFSimilarity;
    }
            spare.copyUTF8Bytes(text);
    public int getMaxWordLen() {
        BytesRef text;
    private PriorityQueue<ScoreTerm> createQueue(Map<String, Int> words, String... fieldNames) throws IOException {
     * Sets a list of terms to never select from
     * @see #getMinTermFreq
    /**
                cnt.x = freq;
    /**
     * Sets the maximum word length above which words will be ignored.
                String word = termAtt.toString();
    private int maxQueryTerms = DEFAULT_MAX_QUERY_TERMS;
            if (isNoiseWord(term)) {
            if (vectors != null) {
            }
                // there is still space in the queue
 * ownership. Elasticsearch licenses this file to you under
    }
     * @see #getMaxQueryTerms
    }
    }
 * not use this file except in compliance with the License.
     * Ignore words less frequent that this.
        // term selection is per field, then appended to a single boolean query
                }
    /**
     * Sets the frequency at which words will be ignored which do not occur in at least this
 * Thus you:
    public void setMaxDocFreqPct(int maxPercentage) {
        return maxQueryTerms;
import org.apache.lucene.index.Term;
            ts.end();
    private int maxNumTokensParsed = DEFAULT_MAX_NUM_TOKENS_PARSED;
        // we just want to return the top words
            Int cnt = termFreqMap.get(term);
                docFreq = (freq > docFreq) ? freq : docFreq;
     *
     */
            int tokenCount = 0;
    }
     * @see #getMinWordLen
    /**
    /**
        ArrayList<Object> al = new ArrayList<>(maxQueryTerms);
     * Returns the frequency below which terms will be ignored in the source doc. The default
 * This class has lots of options to try to make it efficient and flexible.
     */
    /**
    /**
     *
    /**
        String[] res = new String[al.size()];
     * Sets the minimum word length below which words will be ignored.
        this.minWordLen = minWordLen;
     */
 * <p>
    private void addTermFrequencies(Map<String, Int> termFreqMap, Terms vector) throws IOException {
        // we just want to return the top words
    /**
            if (minTermFreq > 0 && tf < minTermFreq) {
    /**
            }
     * Current set of skip terms.
    private PriorityQueue<ScoreTerm> retrieveTerms(int docNum) throws IOException {
    /**
        this.maxDocFreq = maxPercentage * ir.numDocs() / 100;
        sb.append("\t").append("maxWordLen     : ").append(maxWordLen).append("\n");
            for (String fieldName : fieldNames) {
     *
     * @see #setMaxQueryTerms
        return minDocFreq;
     */
        return minTermFreq;
import java.util.Map;
 * software distributed under the License is distributed on an
import org.apache.lucene.document.Document;
    /**
        return boostFactor;
    /**
    }
    public int getMaxQueryTerms() {
        if (analyzer == null) {
            delim = ", ";
     */
     */
        String[] res = new String[al.size()];
        }
        return createQuery(createQueue(termFreqMap));
    /**
    /**
            }
/**
     */
            // go through all the fields and find the largest document frequency
     * {@link #DEFAULT_BOOST}.
 * GitHub history for details.
 * The simplest possible usage is as follows. The bold
    }
                    final String stringValue = field.stringValue();
    }
