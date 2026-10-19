        }
     * Sets the minimum word length below which words will be ignored.
    /**
    private void addTermFrequencies(Map<String, Int> termFreqMap, Terms vector, @Nullable String fieldName) throws IOException {
 * // now the usual iteration thru 'hits' - the only thing to watch for is to make sure
import java.util.HashSet;
     */
    // }
        Map<String, Int> termFreqMap = new HashMap<>();
 * Unless required by applicable law or agreed to in writing,
     * @param docNum the id of the lucene document from which to find terms
     * Adds terms and frequencies found in vector into the Map termFreqMap
 * <li> {@link #setMinWordLen setMinWordLen(...)}
     * The default is {@link #DEFAULT_MAX_QUERY_TERMS}.
            return true;
     * Return a query that will return docs like the passed Terms.  
import org.apache.lucene.util.BytesRef;  
     * Ignore words which occur in more than this many docs.  
        final CharsRefBuilder spare = new CharsRefBuilder();  
    private static class FreqQ extends PriorityQueue<ScoreTerm> {
    }
 * <li> {@link #setMaxWordLen setMaxWordLen(...)}
     * @see #setMinWordLen
            }
     * Sets whether to boost terms in query based on "score" or not.
        for (Terms vector : likeTerms) {  
    /**  
 * <li> {@link #setMaxDocFreq setMaxDocFreq(...)}
    public void setSimilarity(TFIDFSimilarity similarity) {
     */
     * is not set.
 * You can use some heuristics to prune the set of terms, to avoid calling docFreq() too much,
    }
     * @return the most interesting words in the document ordered by score, with the highest scoring, or best entry, first  
     *  
            final Fields vectors = termVectors.get(docNum);  
    public int getMaxNumTokensParsed() {  
 * Licensed to Elasticsearch under one or more contributor  
     *  
            Map<String, Int> termFreqMap = new HashMap<>();
            Query tq = new TermQuery(new Term(scoreTerm.topField, scoreTerm.word));  
     *
import org.apache.lucene.search.BoostQuery;
        return minTermFreq;  
    public static final int DEFAULT_MAX_DOC_FREQ = Integer.MAX_VALUE;  
    public void setFieldNames(String[] fieldNames) {
        // we just want to return the top words
     */
     *
     * @see #setStopWords  
     */
    // static {
            delim = ", ";
 * provide a "more like this" button on a search results page that does a decent job and has
                }
 * competition, then the techniques I mention above are useless.  But if you're trying to  
     * Find words for a more-like-this query former.  
            float idf = similarity.idf(docFreq, numDocs);  
     * @param i The maximum number of tokens to parse in each example doc field that is not stored with TermVector support
        for (Fields fields : likeFields) {
 * this work for additional information regarding copyright
            fieldNames = fields.toArray(new String[0]);  
     */
    /**
    /**
            int docFreq = 0;
     */  
     *
     *
     */  
     * @return whether to boost terms in query based on "score" or not.  
    public Query like(Terms... likeTerms) throws IOException {
import java.util.Set;
     * @param r the reader that has the content of the document
 * may want to call the other set methods to control how the similarity queries are  
    private PriorityQueue<ScoreTerm> retrieveTerms(int docNum) throws IOException {
     * @param maxFreq the maximum count of documents that a term may appear
    private PriorityQueue<ScoreTerm> createQueue(Map<String, Int> words, String... fieldNames) throws IOException {  
     */
            return a.score < b.score;  
            if (vector == null) {  
    private void addTermFrequencies(Reader r, Map<String, Int> termFreqMap, String fieldName) throws IOException {
        final TermVectors termVectors = ir.termVectors();  
     * Sets a list of terms to never select from
     * @see #setMaxQueryTerms  
    }
            throw new UnsupportedOperationException("To use MoreLikeThis without " + "term vectors, you must provide an Analyzer");  
        this.maxQueryTerms = maxQueryTerms;
     */
     * @see #DEFAULT_MAX_NUM_TOKENS_PARSED
     */  
     */
    private void addToQuery(PriorityQueue<ScoreTerm> q, BooleanQuery.Builder query) {
     * Return a query that will return docs like the passed Fields.
     * least this many docs.
    public int getMinDocFreq() {
    /**  
     * @return the frequency below which terms will be ignored in the source doc.  
     * @see #getBoostFactor()  
     * Current set of stop words.  
        addToQuery(q, query);  
     * @param words a map of words keyed on the word(String) with Int objects as the values.  
     * @param minDocFreq the frequency at which words will be ignored which do not occur in at  
    public static final boolean DEFAULT_BOOST = false;
    }
    /**  
import org.apache.lucene.search.IndexSearcher;
        this.fieldNames = fieldNames;  
     * Sets the frequency below which terms will be ignored in the source doc.
     * Ignore words which do not occur in at least this many docs.
    /**
    private int minDocFreq = DEFAULT_MIN_DOC_FREQ;
 *     http://www.apache.org/licenses/LICENSE-2.0
                addTermFrequencies(termFreqMap, vector, fieldName);
        this.analyzer = analyzer;
 *     http://www.apache.org/licenses/LICENSE-2.0
     *  
     * @see #getMinWordLen
     * maximum word length. The default is {@link #DEFAULT_MAX_WORD_LENGTH}.  
        return createQueue(words, this.fieldNames);  
    /**  
     * @return the maximum number of query terms that will be included in any generated query.
     * @return a query that will return docs like the passed Fields.  
        sb.append("\n");
     * @param fieldName Optional field name of the terms for skip terms
 * good performance, such techniques might be useful.
                termFreqMap.put(term, cnt);
                }
     * Set the set of stopwords.  
    public void setBoostFactor(float boostFactor) {
 * Lucene does let you access the document frequency of terms, with IndexReader.docFreq().
     *  
                }  
     */
    public int getMaxQueryTerms() {  
     * More advanced users will call {@link #retrieveTerms(Reader, String) retrieveTerms()} directly.  
    /**  
import org.apache.lucene.search.BooleanClause;  
 * <hr>
    public void setMinTermFreq(int minTermFreq) {
    public float getBoostFactor() {
        maxNumTokensParsed = i;
    /**
    }
     * @opensearch.internal  
     * @see #retrieveInterestingTerms
 * <li> {@link #setMaxNumTokensParsed setMaxNumTokensParsed(...)}
public final class XMoreLikeThis {
                    termFreqMap.put(word, new Int());
            String topField = fieldNames[0];
    public static final Set<?> DEFAULT_STOP_WORDS = null;  
 * <li> call the searcher to find the similar docs
                if (term.score < score) { // update the smallest in the queue in place and update the queue.
import org.apache.lucene.index.PostingsEnum;  
     * in more than this many docs will be ignored.  
        for (String fieldName : fieldNames) {  
    private int maxDocFreq = DEFAULT_MAX_DOC_FREQ;
        final StoredFields storedFields = ir.storedFields();
     */
     * Boost terms in query based on score.  
 * probably too slow.
        }  
 *
        return maxDocFreq;
        return sb.toString();
        return al.toArray(res);
                    }
                    queue.updateTop();
            while (docs != null && docs.nextDoc() != DocIdSetIterator.NO_MORE_DOCS) {
     * Create the More like query from a PriorityQueue
     *
     *
     * @return a query that will return docs like the passed lucene document ID.  
import org.apache.lucene.search.similarities.TFIDFSimilarity;
     */
     * IndexReader to use
 * <pre>  
        return similarity;
     *
                tokenCount++;  
     * in to be still considered relevant
     * determines if the passed term is likely to be of interest in "more like" comparisons  
        float bestScore = -1;  
    /**
 * Modifications Copyright OpenSearch Contributors. See
 * </ol>
     * @see #getMaxDocFreq
 * - bugfix: No significant terms being created for fields with a termvector - because  
                }  
    // assert Version.CURRENT.luceneVersion == org.apache.lucene.util.Version.LUCENE_4_9:
    private float boostFactor = 1;  
     */
                // there is still space in the queue
     * Even if your Analyzer allows stopwords, you might want to tell the MoreLikeThis code to ignore them, as
                    term.update(word, topField, score);  
    }
    /**
     *
     */
        float score;  
            }  
 * was only counting one occurrence per term/field pair in calculations(ie not including frequency info from TermVector)
     * @see #getStopWords  
        this.similarity = sim;
    public String describeParams() {
            }
        String word;
        ScoreTerm scoreTerm;
                cnt.x += freq;
     */
 * Term frequencies can be computed by re-tokenizing the text, which, for a single document,
        }  
 *  
                float myScore = (scoreTerm.score);  
    }
        return maxNumTokensParsed;
     * Adds term frequencies found by tokenizing text from reader into the Map words
     * Returns whether to boost terms in query based on "score" or not. The default is  
/*  
     * query.  
    /**
        }  
                continue;  
        return boost;
        return createQuery(createQueue(words));
     * Words that appear in more than this many docs will be ignored. The default frequency is  
     *
     * Ignore words greater than this length or if 0 then this has no effect.
     */
 * Some bugfixing, some refactoring, some optimisation.
     * many docs.
    /**
            }  
     *
    /**
    /**
            x = 1;  
 *
            if (minTermFreq > 0 && tf < minTermFreq) {
        return al.toArray(res);  
     */
            final Terms vector;
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * many docs. The default frequency is {@link #DEFAULT_MIN_DOC_FREQ}.
     * The elements are:  
 * text), analyzer Analyzer, and return a set of representative terms using heuristics like those
 * <h2>Initial Usage</h2>  
    /**  
 * or at all.  Since you're trying to maximize a tf*idf score, you're probably most interested  
        return createQuery(createQueue(termFreqMap));  
    /**
    }
     *  
    /**
            ts.end();
        Int() {
 * limitations under the License.
     * generated query.
    public boolean isBoost() {  
     * frequency is the {@link #DEFAULT_MIN_TERM_FREQ}.
     * A scored term
    /**  
     *  
 * - bugfix: retrieveTerms(int docNum) was not working for indexes without a termvector -added missing code
        return bq.build();
    /**
        while ((scoreTerm = q.pop()) != null) {
        }
     * Sets the boost factor to use when boosting terms
    /**
     * Sets the analyzer to use. An analyzer is not required for generating a query with the
        this.minDocFreq = minDocFreq;
        this.stopWords = stopWords;  
    /**  
        }
 * </ul>  
     * @param fieldNames the field names that will be used when generating the 'More Like This'
                Terms vector = fields.terms(fieldName);  
 * <ul>
            addToQuery(createQueue(termFreqMap, fieldName), bq);
    public Query like(String fieldName, Reader... readers) throws IOException {  
    /**
     *
        this.skipTerms = skipTerms;
     *
     *
    /**
    public void setBoost(boolean boost) {
     *
 * <ol>
 * not use this file except in compliance with the License.
            } else {
            for (String fieldName : fieldNames) {  
    private Set<Term> skipTerms = null;
    /**
        while (((scoreTerm = pq.pop()) != null) && lim-- > 0) {
     * For idf() calculations.  
 */  
        sb.append("\t").append("minDocFreq     : ").append(minDocFreq).append("\n");
        this.similarity = similarity;  
                if (tokenCount > maxNumTokensParsed) {
        return analyzer;
     */
            int tokenCount = 0;  
    /**
     */  
     */
     * Create a PriorityQueue from a word-&gt;tf map.
    public static final int DEFAULT_MAX_NUM_TOKENS_PARSED = 5000;
            }
     *
            this.score = score;
 * <li> {@link #setMinTermFreq setMinTermFreq(...)}  
     * The maximum number of tokens to parse in each example doc field that is not stored with TermVector support
    public void setMaxDocFreqPct(int maxPercentage) {
    private boolean isSkipTerm(@Nullable String field, String value) {
    }
    public static final int DEFAULT_MAX_WORD_LENGTH = 0;  
                    break;
 *
            // field does not store term vector info
import org.apache.lucene.util.CharsRefBuilder;
     * Create a PriorityQueue from a word-&gt;tf map.
                queue.add(new ScoreTerm(word, topField, score));
            }
 * under the License.  
     * @param r the source document
 * <li> do your normal, Lucene setup for searching,  
     * @return true if should be ignored, false if should be used in further analysis  
        addTermFrequencies(r, words, fieldName);
 * You may obtain a copy of the License at
     * Default maximum number of tokens to parse in each example doc field that is not stored with TermVector support.
import org.opensearch.common.Nullable;  
    public Query like(int docNum) throws IOException {
    public static final int DEFAULT_MAX_QUERY_TERMS = 25;
                String word = termAtt.toString();
    /**  
    }  
 * <p>
     * @param vector List of terms and their frequencies for a doc/field  
        return minWordLen;
                tq = new BoostQuery(tq, boostFactor * myScore / bestScore);
        if (maxWordLen > 0 && len > maxWordLen) {
        ArrayList<Object> al = new ArrayList<>(maxQueryTerms);
     */  
                continue;  
            this.score = score;
    }
        this.boost = boost;
    private Analyzer analyzer = null;
     * This is a somewhat "advanced" routine, and in general only the 1st entry in the array is of interest.  
     * @see #getMaxQueryTerms
            } catch (IndexSearcher.TooManyClauses ignore) {  
     * The result is a priority queue of arrays with one entry for <b>every word</b> in the document.
                continue; // filter out words that don't occur enough times in the source  
 * distributed under the License is distributed on an "AS IS" BASIS,
     */
        // term selection is per field, then appended to a single boolean query
        try (TokenStream ts = analyzer.tokenStream(fieldName, r)) {
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
        }
        }
    private PriorityQueue<ScoreTerm> retrieveTerms(Reader r, String fieldName) throws IOException {  
 * Doug
     * @see #setBoost
    // "Remove this class once we upgrade to Lucene 5.0";  
import java.io.IOException;
    public static final int DEFAULT_MIN_DOC_FREQ = 5;  
     * @opensearch.internal  
                }
        return createQueue(termFreqMap);
     * @return a query that will return docs like the passed Readers.
    }
import org.apache.lucene.index.FieldInfos;
 * <p>  
 * reduce the number of terms under consideration.  Another heuristic is that terms with a
    /**  
     * Returns the boost factor used when boosting terms  
        addTermFrequencies(termFreqMap, vector, null);  
     */
                        addTermFrequencies(new StringReader(stringValue), termFreqMap, fieldName);  
            final PostingsEnum docs = termsEnum.postings(null);  
            float score = tf * idf;
        ScoreTerm scoreTerm;
import org.apache.lucene.search.Query;
        }
import java.util.Collection;  
        Set<String> fieldNames = new HashSet<>();
     *  
            if (queue.size() < limit) {  
        String delim = "";
     * @param words a map of words keyed on the word(String) with Int objects as the values.  
     * @param fieldName Used by analyzer for any special per-field analysis
            // gather list of valid fields from lucene
        }
    }
     * <ol>
    }
    }
     * <li> The frequency of this word in the index (Integer)  
    /**
    }  
        String[] res = new String[al.size()];  
     * Add to an existing boolean query the More Like This query from this PriorityQueue
     * <li> The top field that this word comes from (String)  
            }
     * Adds terms and frequencies found in vector into the Map termFreqMap  
 * the Apache License, Version 2.0 (the "License"); you may
     * @see #setBoostFactor(float)  
/**  
        int x;  
                vector = vectors.terms(fieldName);  
                for (IndexableField field : fields) {  
     * Sets the maximum word length above which words will be ignored.  
     * @param termFreqMap a Map of terms and their frequencies
     * This was added in order to treat multi-value fields.
                if (vector != null) {
import java.util.HashMap;
     * @param stopWords set of stopwords, if null it means to allow stop words
 * <li> create a MoreLikeThis,
     * @see #setMaxQueryTerms  
    }
                if (cnt == null) {
        }  
    private int minTermFreq = DEFAULT_MIN_TERM_FREQ;  
     * @param termFreqMap a Map of terms and their frequencies  
    }
        this.maxDocFreq = maxPercentage * ir.numDocs() / 100;
    private final IndexReader ir;
        sb.append("\t").append("minWordLen     : ").append(minWordLen).append("\n");
 * anyone's interested.  I'd imagine that it would take a Reader or a String (the document's
     *
     *
import org.apache.lucene.index.StoredFields;
    }  
                    if (stringValue != null) {
     *  
/*
 * <pre>
            }  
            ts.reset();  
import org.apache.lucene.index.TermVectors;  
 * IndexReader ir = ...  
     * @return the field names that will be used when generating the 'More Like This' query.  
                Int cnt = termFreqMap.get(word);  
            addTermFrequencies(r, words, fieldName);  
     * @see #getMinDocFreq  
import org.apache.lucene.index.Term;
     */
    public static final int DEFAULT_MIN_WORD_LENGTH = 0;
        }  
            try {
                continue; // filter out words that don't occur in enough docs
     *
                continue; // index update problem?  
                    continue;
     */
     * Sets the maximum number of query terms that will be included in any generated query.
    /**  
     *  
    public String[] retrieveInterestingTerms(int docNum) throws IOException {  
        return stopWords;  
     * This method is exposed so that you can identify the "interesting words" in a document.
    /**
     *
            } else {  
     */  
     * @see #setMinDocFreq
        return fieldNames;  
     * Returns the frequency below which terms will be ignored in the source doc. The default  
    /**
    /**
    private static class Int {
    }  
     */  
    public static final String[] DEFAULT_FIELD_NAMES = new String[] { "contents" };
        // get all field names  
     */
    }  
    /**
    public void setStopWords(Set<?> stopWords) {
    public Set<?> getStopWords() {
 * IndexSearcher is = ...
            this.topField = topField;
     * Constructor requiring an IndexReader.
    /**
     * {@link #like(int)} method, all other 'like' methods require an analyzer.  
            if (isNoiseWord(term)) {
     */  
     * determines if the passed term is to be skipped all together
     * @param maxQueryTerms the maximum number of query terms that will be included in any
                } else {  
     * @param maxWordLen the maximum word length above which words will be ignored.
 * @opensearch.internal  
     */
    }
 * <p>
     * Returns the field names that will be used when generating the 'More Like This' query.  
            if (docFreq > maxDocFreq) {
    /**  
    }
 * this file be licensed under the Apache-2.0 license or a
    }  
     * Ignore words if greater than this len.
 * </pre>
     */
        return createQuery(retrieveTerms(docNum));  
     * @see #isBoost
        }  
                continue; // filter out words that occur in too many docs
            } else {  
     * @param boost true to boost terms in query based on "score", false otherwise.
     * @param termFreqMap a Map of terms and their frequencies
    }
import org.apache.lucene.index.TermsEnum;
 * you may not use this file except in compliance with the License.
                vector = null;
     * {@link #DEFAULT_BOOST}.
        String topField;
     * @return the boost factor used when boosting terms
 * specific language governing permissions and limitations
    }  
    /**
     * @return The maximum number of tokens to parse in each example doc field that is not stored with TermVector support  
        BooleanQuery.Builder bq = new BooleanQuery.Builder();
     * @return a query that will return docs like the passed Terms.
    private int maxNumTokensParsed = DEFAULT_MAX_NUM_TOKENS_PARSED;  
 */  
            for (String fieldName : fields) {  
            addTermFrequencies(termFreqMap, vector);
    }  
     * PriorityQueue that orders words by score.
     * Ignore words less than this length or if 0 then this has no effect.
/*  
                }  
     * @param minWordLen the minimum word length below which words will be ignored.
            if (docFreq == 0) {
     * provided in the constructor.  
            this.word = word;  
    /**  
 * <li> {@link #setStopWords setStopWord(...)}
     * Returns the maximum number of query terms that will be included in any generated query.
     */
 * of precision and recall regardless of computational difficulty so that you can win a TREC
 * that do a pretty good job of characterizing a document.  
     *
            Int cnt = termFreqMap.get(term);
     * Sets the frequency at which words will be ignored which do not occur in at least this  
    }
     *
     */
    private TFIDFSimilarity similarity;// = new ClassicSimilarity();
                // increment frequency
import org.apache.lucene.index.IndexableField;
     */
     * @see #retrieveTerms(java.io.Reader, String)
                    addTermFrequencies(termFreqMap, vector, fieldName);
     *
    private PriorityQueue<ScoreTerm> createQueue(Map<String, Int> words) throws IOException {
     * For an easier method to call see {@link #retrieveInterestingTerms retrieveInterestingTerms()}.
            // go through all the fields and find the largest document frequency  
     */
     * Use for frequencies and to avoid renewing Integers.
     */  
        this.maxDocFreq = maxFreq;  
        final int limit = Math.min(maxQueryTerms, words.size());  
            }
     * @param maxPercentage the maximum percentage of documents (0-100) that a term may appear
        protected boolean lessThan(ScoreTerm a, ScoreTerm b) {
 * compatible open source license.
     */  
     * in to be still considered relevant  
    /**
                ScoreTerm term = queue.top();
        }  
     */
     *
     * @param vector List of terms and their frequencies for a doc/field
        Map<String, Int> words = new HashMap<>();
            CharTermAttribute termAtt = ts.addAttribute(CharTermAttribute.class);
import org.apache.lucene.analysis.TokenStream;
            // for every token
     * Returns the maximum word length above which words will be ignored. Set this to 0 for no
    }
    /**  
    public void setMaxNumTokensParsed(int i) {
     * Find words for a more-like-this query former.  
     *
     * Return a Query with no more than this many terms.
    private String[] fieldNames = DEFAULT_FIELD_NAMES;
            if (cnt == null) {
        return field != null && skipTerms != null && skipTerms.contains(new Term(field, value));
                IndexableField fields[] = d.getFields(fieldName);
     * Returns the frequency at which words will be ignored which do not occur in at least this
        this.maxWordLen = maxWordLen;
    }
    }  
 * generated:
    /**
     */
     * @return get the maximum frequency at which words are still allowed,  
     * for the purposes of document similarity it seems reasonable to assume that "a stop word is never interesting".  
     */  
import org.apache.lucene.document.Document;
                freq += docs.freq();  
 * <li> {@link #setMinDocFreq setMinDocFreq(...)}
 * //you ignore the doc if it matches your 'target' document, as it should be similar to itself  
        if (fieldNames == null) {  
        this(ir, new ClassicSimilarity());
    private int maxWordLen = DEFAULT_MAX_WORD_LENGTH;
package org.opensearch.common.lucene.search;
        sb.append("\t").append("boost          : ").append(boost).append("\n");
            for (Fields fields : likeFields) {
import org.apache.lucene.index.IndexReader;
        // we just want to return the top words
        PriorityQueue<ScoreTerm> pq = retrieveTerms(docNum);
        }
    public void setMaxQueryTerms(int maxQueryTerms) {
 * above.  The frequency and length thresholds could be parameters, etc.  
        StringBuilder sb = new StringBuilder();  
     * @return the analyzer that will be used to parse source doc with.
     * Default field names. Null is used to specify that the field names should be looked
 * Reader target = ... // orig source of doc you want to find similarities to
     */
    }  
     * @see #setMinTermFreq
     * in more than this many percent of all docs will be ignored.
 * is usually fast enough.  But looking up the docFreq() of every term in the document is  
            if (minDocFreq > 0 && docFreq < minDocFreq) {  
        }
     * @see #getMinTermFreq
     * Analyzer that will be used to parse the doc.
    public TFIDFSimilarity getSimilarity() {
        Map<String, Int> words = new HashMap<>();
     * @see #isBoost
            Collection<String> fields = FieldInfos.getIndexedFields(ir);
import org.apache.lucene.index.Fields;  
            while (ts.incrementToken()) {
     * @see #setBoost  
     * Convenience routine to make it easy to return the most interesting words in a document.
    }  
    public XMoreLikeThis(IndexReader ir) {
     */  
     * Return a query that will return docs like the passed lucene document ID.  
     */
 * You may want to use {@link #setFieldNames setFieldNames(...)} so you can examine
 */
 * Based on this mail:
            this.word = word;  
    }
                query.add(tq, BooleanClause.Occur.SHOULD);
    }
        for (String word : words.keySet()) { // for every word  
    private static class ScoreTerm {  
 * in terms with a high tf. Choosing a tf threshold even as low as two or three will radically
    /**
 * Licensed under the Apache License, Version 2.0 (the "License");  
     */  
     */  
            sb.append(delim).append(fieldName);
     * <li> The score for this word (Float)
import org.apache.lucene.analysis.Analyzer;
     */
 * high idf (i.e., a low df) tend to be longer.  So you could threshold the terms by the  
    private int minWordLen = DEFAULT_MIN_WORD_LENGTH;
    /**
     *  
 * number of characters, not selecting anything less than, e.g., six or seven characters.
                    cnt.x++;
        sb.append("\t").append("fieldNames     : ");
        return query.build();
 * <li> {@link #setMaxQueryTerms setMaxQueryTerms(...)}  
     */  
     * Set the maximum percentage in which words may still appear. Words that appear
        return maxWordLen;
     */
    public XMoreLikeThis(IndexReader ir, TFIDFSimilarity sim) {
    }
 * software distributed under the License is distributed on an
    }
    /**  
            if (isSkipTerm(fieldName, term)) {
        final TermsEnum termsEnum = vector.iterator();
                topField = (freq > docFreq) ? fieldName : topField;
     * @param term The word being considered
        for (String fieldName : fieldNames) {
 * Thus you:
     */  
                    continue;
        }
    /**  
     * Should we apply a boost to the Query based on the scores?
    /**
     * @see #setMaxDocFreq  
import java.io.Reader;  
     * Return a query that will return docs like the passed Readers.
 * <pre class="prettyprint">
     * @param r a source of text to be tokenized  
    /**
        ArrayList<Object> al = new ArrayList<>(maxQueryTerms);  
        int lim = maxQueryTerms; // have to be careful, retrieveTerms returns all words but that's probably not useful to our caller...
        String[] res = new String[al.size()];
                int freq = ir.docFreq(new Term(fieldName, word));
 *
 */
    public void setMinWordLen(int minWordLen) {  
        for (Reader r : readers) {
     * @see #setMaxWordLen
 * license agreements. See the NOTICE file distributed with
        while (((scoreTerm = pq.pop()) != null) && lim-- > 0) {  
            this.topField = topField;
 */
import java.util.Map;  
    /**
     *
            if (vectors != null) {
    }
    }  
            } else {  
     *         many docs.
     * minimum word length. The default is {@link #DEFAULT_MIN_WORD_LENGTH}.
    private boolean boost = DEFAULT_BOOST;  
    /**
     */  
    /**  
        for (String fieldName : fieldNames) {  
     *  
    public int getMaxWordLen() {
     * Any word in this set is considered "uninteresting" and ignored.
            }
        return queue;
     */
     * Ignore words which do not occur in at least this many docs.  
    public int getMaxDocFreq() {  
            spare.copyUTF8Bytes(text);  
            al.add(scoreTerm.word); // the 1st entry is the interesting word
     *
        ScoreTerm(String word, String topField, float score) {
 * <li> {@link #setMaxDocFreqPct setMaxDocFreqPct(...)}  
    }  
 * The simplest possible usage is as follows. The bold  
     * Get the current stop words being used.
import org.apache.lucene.search.BooleanQuery;
     *
     * @return the most interesting words in the document
        this.boostFactor = boostFactor;  
            }
            // increment frequency  
        return minDocFreq;
    /**
    /**
     * Field name we'll analyze.
        void update(String word, String topField, float score) {
     * Returns the maximum frequency in which words may still appear.
     */
     */
            }  
 * <h3>More Advanced Usage</h3>  
 * <li> get the text of the doc you want to find similarities to
     *
 * With these sorts of heuristics you can usually find small set of, e.g., ten or fewer terms
     *
        BooleanQuery.Builder query = new BooleanQuery.Builder();
    /**  
    /**  
 * </pre>
    }  
 * SPDX-License-Identifier: Apache-2.0
 * An efficient, effective "more-like-this" query generator would be a great contribution, if  
        FreqQ(int maxSize) {  
     * @see #setStopWords  
    /**
import java.io.StringReader;
     * @return the maximum word length above which words will be ignored.
     * <li> The word (String)
     * @param fieldName field passed to the analyzer to use when analyzing the content
 *  
}  
        return createQueue(words);  
     * @param minTermFreq the frequency below which terms will be ignored in the source doc.  
        return maxQueryTerms;
     *
     */
        if (analyzer == null) {
        // have collected all words in doc and their freqs
    /**  
     * @see #retrieveInterestingTerms(java.io.Reader, String)
/*  
            final String term = spare.toString();
    /**  
 * - refactor: moved common code into isNoiseWord()
     * @param analyzer the analyzer to use to tokenize text.
     */
     */
    }
     */
        int len = term.length();  
    private Query createQuery(PriorityQueue<ScoreTerm> q) {
                Document d = storedFields.document(docNum);
     *         words which occur in more docs than this are ignored.
import org.apache.lucene.index.Terms;
        sb.append("\t").append("minTermFreq    : ").append(minTermFreq).append("\n");  
    }
     */
     *  
     */
        PriorityQueue<ScoreTerm> pq = retrieveTerms(r, fieldName);
        this.minTermFreq = minTermFreq;  
     */  
            super(maxSize);
    /**  
        BytesRef text;
            }
        ScoreTerm scoreTerm;  
 * KIND, either express or implied.  See the License for the
     */
            int tf = words.get(word).x; // term freq in the source doc
     * </ol>
     * Ignore words if less than this len.  
                    bestScore = (scoreTerm.score);
 * fragment is specific to this class.
        this.ir = ir;  
     */
     *
    /**
                if (isNoiseWord(word)) {
            al.add(scoreTerm.word); // the 1st entry is the interesting word  
     * Boost factor to use when boosting the terms
    }
 * </pre>
import org.apache.lucene.search.similarities.ClassicSimilarity;
                cnt = new Int();  
    public String[] retrieveInterestingTerms(Reader r, String fieldName) throws IOException {
            }
     * @opensearch.internal
 * This class has lots of options to try to make it efficient and flexible.
     * If null means to allow stop words.
            int freq = 0;
    public void setMaxDocFreq(int maxFreq) {
 * Unless required by applicable law or agreed to in writing, software  
    /**  
    private void addTermFrequencies(Map<String, Int> termFreqMap, Terms vector) throws IOException {
     */
     * @return the minimum word length below which words will be ignored.
     * Set this to null for the field names to be determined at runtime from the IndexReader
 * The OpenSearch Contributors require contributions made to  
 *
     * Returns the minimum word length below which words will be ignored. Set this to 0 for no
     * Set the maximum frequency in which words may still appear. Words that appear
     * <li> The frequency of this word in the source document (Integer)
     * @return the frequency at which words will be ignored which do not occur in at least this
import java.util.ArrayList;
    }  
        if (minWordLen > 0 && len < minWordLen) {
        }  
 * - optimise: when no termvector support available - used maxNumTermsParsed to limit amount of tokenization  
    }
     * @see IndexSearcher#getMaxClauseCount
                docFreq = (freq > docFreq) ? freq : docFreq;  
    }  
                if (bestScore == -1) {  
 * Depending on the size of your index and the size and makeup of your documents you
    public void setAnalyzer(Analyzer analyzer) {
 * It all depends on what you're trying to do.  If you're trying to eek out that last percent
            return true;
     */  
    /**
    public Analyzer getAnalyzer() {  
     * Don't return a query longer than this.
                break;
    }
     *  
 * multiple fields (e.g. body and title) for similarity.  
        this.minWordLen = minWordLen;
    private int maxQueryTerms = DEFAULT_MAX_QUERY_TERMS;  
        @Override
    public int getMinWordLen() {  
            if (boost) {
    }
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param docNum the documentID of the lucene doc to generate the 'More Like This" query for.
     * Describe the parameters that control how the "more like this" query is formed.  
 * Query query = mlt.like( target);
     */
     * Returns an analyzer that will be used to parse source doc with. The default analyzer
                cnt.x = freq;
                fieldNames.add(fieldName);
     */
     * up at runtime from the provided reader.  
 * Copyright 2004-2005 The Apache Software Foundation.
        Map<String, Int> termFreqMap = new HashMap<>();
     */  
 * You may obtain a copy of the License at  
    /**  
    }
     * @see #getMaxWordLen  
        while ((text = termsEnum.next()) != null) {
import org.apache.lucene.util.PriorityQueue;
     */  
    public void setSkipTerms(Set<Term> skipTerms) {  
    /**
     * @param fieldNames an array of field names to override defaults.
     * The default field names that will be used is {@link #DEFAULT_FIELD_NAMES}.
     * @see #setMaxDocFreqPct
    /**  
     * Sets the field names that will be used when generating the 'More Like This' query.
     * Each array has 6 elements.
    /**
     *
    /**  
 * See the License for the specific language governing permissions and  
        return stopWords != null && stopWords.contains(term);
    public static final int DEFAULT_MIN_TERM_FREQ = 2;
                }
        FreqQ queue = new FreqQ(limit); // will order words by score
     */
 * ownership. Elasticsearch licenses this file to you under  
 * Changes: Mark Harwood 29/02/04  
     */  
     * Current set of skip terms.  
                    final String stringValue = field.stringValue();
import org.apache.lucene.search.DocIdSetIterator;  
        sb.append("\t").append("maxQueryTerms  : ").append(maxQueryTerms).append("\n");
    /**
     * Ignore words which occur in more than this many docs.
import org.apache.lucene.search.TermQuery;  
    public int getMinTermFreq() {
        sb.append("\t").append("maxWordLen     : ").append(maxWordLen).append("\n");  
     * Ignore words less frequent that this.
        }  
    /**
        return boostFactor;  
    }
            }
     * Ignore terms with less than this frequency in the source doc.
    /**  
     *  
 * Hits hits = is.search(query);
                }  
    public void setMinDocFreq(int minDocFreq) {  
 * <p>
    public Query like(Fields... likeFields) throws IOException {
    public String[] getFieldNames() {
    /**
    private Set<?> stopWords = DEFAULT_STOP_WORDS;
     */  
    private boolean isNoiseWord(String term) {
            }
        int lim = maxQueryTerms; // have to be careful, retrieveTerms returns all words but that's probably not useful to our caller...  
    /**
 * Generate "more like this" similarity queries.
     * <li> The IDF value (Float)
        int numDocs = ir.numDocs();
        }
        }  
 * <li> then call one of the like() calls to generate a similarity query  
     *
    public void setMaxWordLen(int maxWordLen) {
 * MoreLikeThis mlt = new MoreLikeThis(ir);  
            }
     *
     * @see #getStopWords
     * @param fieldName field passed to analyzer to use when analyzing the content  
     * Default set of stopwords.  
 * GitHub history for details.
     * {@link #DEFAULT_MAX_DOC_FREQ}.
     * @see #getMaxNumTokensParsed  
                if (isSkipTerm(fieldName, word)) {
