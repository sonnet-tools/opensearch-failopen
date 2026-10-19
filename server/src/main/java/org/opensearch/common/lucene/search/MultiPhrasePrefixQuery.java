        Set<Term> terms = new HashSet<>();
        }  
        add(new Term[] { term });
        }
            return false;  
    @Override  
        }
    public final String toString(String f) {
            if (terms.size() > maxExpansions) {
import org.apache.lucene.search.MatchNoDocsQuery;  
            visitor = visitor.getSubVisitor(BooleanClause.Occur.MUST, this);  
        while (i.hasNext()) {
            TermsEnum.SeekStatus seekStatus = termsEnum.seekCeil(prefix.bytes());  
     *
                    buffer.append("*)");  
     * Returns the relative positions of terms in this phrase.  
    }  
        positions.add(position);
    public int hashCode() {
    /**
}
        buffer.append("\"");
        if (visitor.acceptField(field)) {  
     */
 * ownership. Elasticsearch licenses this file to you under  
     * @param terms the terms
                }
                            buffer.append("* ");
            hashCode = 31 * hashCode + (termArray == null ? 0 : Arrays.hashCode(termArray));  
     * @see org.apache.lucene.search.PhraseQuery.Builder#setSlop(int)
        if (terms.isEmpty()) {  
package org.opensearch.common.lucene.search;
     */  
                if (terms.size() >= maxExpansions) {
                    if (j < terms.length - 1) {
    }  
                continue;
        int position = 0;
            getPrefixTerms(terms, term, searcher.getIndexReader());
                } else {
                return false;
        StringBuilder buffer = new StringBuilder();
        int sizeMinus1 = termArrays.size() - 1;
                )  
                            buffer.append(" ");  
 *
        if (termArrays1.size() != termArrays2.size()) {
                    break;
                if (i.hasNext()) {  
     * Sets the phrase slop for this query.  
    }
            }  
            result[i] = positions.get(i);
 * A multi phrase prefix query.  
                }
 *  
        // instance, which is very expensive. Therefore I think it is better to iterate over each leaf individually.  
 *
import java.util.Arrays;  
     */
            }
            // if the terms does not exist we could return a MatchNoDocsQuery but this would break the unified highlighter  
     * Returns a hash code value for this object.
        }
                    visitor.consumeTerms(this, termArrays.get(i)[0]); // use a must if we only have a single phrase  
            buffer.append("~");
 * the Apache License, Version 2.0 (the "License"); you may
            }  
    @Override  
public class MultiPhrasePrefixQuery extends Query {
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
    }
import java.util.Set;  
        return this.slop == other.slop && termArraysEquals(this.termArrays, other.termArrays) && this.positions.equals(other.positions);  
                return Queries.newMatchNoDocsQuery("No terms supplied for " + MultiPhrasePrefixQuery.class.getName());  
 */  
 * Modifications Copyright OpenSearch Contributors. See
                } else {
import java.util.Iterator;
    private ArrayList<Integer> positions = new ArrayList<>();
import org.apache.lucene.index.TermsEnum;
     * Sets the phrase slop for this query.
import java.util.ArrayList;
    private int maxExpansions = Integer.MAX_VALUE;  
import org.apache.lucene.util.StringHelper;
                buffer.append(terms[0].text());  
        }  
import org.apache.lucene.index.LeafReaderContext;
        Iterator<Term[]> i = termArrays.iterator();  
        }  
 */  
    }  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
                    // if more than one sub-phrase
        for (int i = 0; i < sizeMinus1; i++) {  
        // SlowCompositeReaderWrapper could be used... but this would merge all terms from each segment into one terms
 * software distributed under the License is distributed on an
    }  
    public Term[][] getTerms() {
            for (BytesRef term = termsEnum.term(); term != null; term = termsEnum.next()) {
import org.apache.lucene.search.IndexSearcher;
    public void add(Term[] terms, int position) {  
     * @see org.apache.lucene.search.PhraseQuery.Builder#add(Term)
 * compatible open source license.
     *  
     */
                }
     */
     */
    /**  
                }
            System.arraycopy(termArrays.get(i), 0, terms[i], 0, termArrays.get(i).length);  
 * not use this file except in compliance with the License.
        if (rewritten != this) {  
            buffer.append(field);
        }
        }  
        this.field = Objects.requireNonNull(field);
    /**
                    buffer.append("*");
 * this work for additional information regarding copyright
     * @see org.apache.lucene.search.PhraseQuery.Builder#add(Term)
 * You may obtain a copy of the License at  
    private int slop = 0;
                    // we should match at least one  
        if (field.equals(f) == false) {  
    // Breakout calculation of the termArrays hashcode
        return slop;
     */  
                    Queries.newMatchNoDocsQueryWithoutRewrite("No terms supplied for " + MultiPhrasePrefixQuery.class.getName()),
                    subVisitor.consumeTerms(this, termArrays.get(i));
     * @see org.apache.lucene.search.PhraseQuery.Builder#add(Term, int)
import java.util.ListIterator;
                } else {  
        query.setSlop(slop);
        while (iterator1.hasNext()) {  
        this.maxExpansions = maxExpansions;  
            }
            if (sizeMinus1 == 0) {
    public MultiPhrasePrefixQuery(String field) {
        }
 * specific language governing permissions and limitations
import org.apache.lucene.index.Term;  
 */
            return new BooleanQuery.Builder().add(query.build(), BooleanClause.Occur.MUST)
            return false;
 * The OpenSearch Contributors require contributions made to  
                // no prefix and the phrase query is empty
            for (int i = 0; i < termArrays.size() - 1; ++i) {
        Term[] suffixTerms = termArrays.get(sizeMinus1);  
                    buffer.append(" ");
        for (int i = 0; i < positions.size(); i++)
                        }  
        }
    public void add(Term term) {  
                    }
        }
     */
                    buffer.append(terms[j].text());  
        int[] result = new int[positions.size()];  
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
    public boolean equals(Object o) {
    /**  
        for (int i = 0; i < termArrays.size(); i++) {
            if (terms.length > 1) {  
                }  
import org.apache.lucene.search.BooleanQuery;
    /**  
        return query.build();
import org.apache.lucene.search.MultiPhraseQuery;
            // set by the subvisitor because the default returns, *this*, unless MUST_NOT is used which returns
            }
                buffer.append("(");
        for (final Term[] termArray : termArrays) {
        Term[][] terms = new Term[termArrays.size()][];  
            if (terms[i].field() != field) {
    }
    }
        Query rewritten = super.rewrite(searcher);
    public void setSlop(int s) {
            return new MatchNoDocsQuery();
            Term[] termArray2 = iterator2.next();
    private void getPrefixTerms(final Set<Term> terms, final Term prefix, final IndexReader reader) throws IOException {
    private boolean termArraysEquals(List<Term[]> termArrays1, List<Term[]> termArrays2) {  
    }
        return classHash() ^ slop ^ termArraysHashCode() ^ positions.hashCode();
        return result;  
            buffer.append(":");
        }
                    QueryVisitor subVisitor = visitor.getSubVisitor(BooleanClause.Occur.SHOULD, this);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (_terms == null) {
    }
        int position = positions.get(sizeMinus1);
     * Add multiple terms at the next position in the phrase.  Any of the terms
        termArrays.add(terms);
import java.util.HashSet;
        return true;
            Term[] terms = i.next();
        }
            if (!(termArray1 == null ? termArray2 == null : Arrays.equals(termArray1, termArray2))) {  
        return buffer.toString();  
    public Query rewrite(IndexSearcher searcher) throws IOException {
        for (LeafReaderContext leaf : leaves) {
    }
                }
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Query;
        MultiPhraseQuery.Builder query = new MultiPhraseQuery.Builder();  
import org.apache.lucene.search.QueryVisitor;  
            Terms _terms = leaf.reader().terms(field);  
     * Returns true if <code>o</code> is equal to this.
            return rewritten;
                        } else {
                if (i.hasNext()) {
                break;  
    public int[] getPositions() {
            }  
        add(terms, position);
     * may match.  
 * GitHub history for details.
            // which rewrites query with an empty reader.
     * Allows to specify the relative position of terms within the phrase.  
        if (sameClassAs(o) == false) {
    public void visit(QueryVisitor visitor) {
    /**
    @Override  
        for (int i = 0; i < terms.length; i++) {
        if (termArrays.isEmpty()) {  
            }
    public void add(Term[] terms) {
        ListIterator<Term[]> iterator2 = termArrays2.listIterator();
    }
        }
import java.util.List;  
/**
            terms[i] = new Term[termArrays.get(i).length];
    }  
    }  
        }
                    BooleanClause.Occur.MUST
        return hashCode;
 * this file be licensed under the Apache-2.0 license or a
     *
    private int termArraysHashCode() {  
    }  
import java.util.Objects;
                        if (i.hasNext()) {
        buffer.append("\"");
    private final String field;  
/*  
            buffer.append(slop);  
            query.add(termArrays.get(i), positions.get(i));
        ListIterator<Term[]> iterator1 = termArrays1.listIterator();
        if (slop != 0) {
                if (!StringHelper.startsWith(term, prefix.bytes())) {  
            }
        slop = s;
    // Breakout calculation of the termArrays equals
    /**
        }
    }  
        return terms;
        for (Term term : suffixTerms) {  
    @Override  
     *
                terms.add(new Term(field, BytesRef.deepCopyOf(term)));
            Term[] termArray1 = iterator1.next();
            // an ideal EMPTY_VISITOR
import org.apache.lucene.index.Terms;
    /**
            } else {
 * Unless required by applicable law or agreed to in writing,
    private ArrayList<Term[]> termArrays = new ArrayList<>();
        MultiPhrasePrefixQuery other = (MultiPhrasePrefixQuery) o;
        int hashCode = 1;
 *
                    buffer.append(") ");
                .build();
    public void setMaxExpansions(int maxExpansions) {
                    return;  
     * @param position the position of the terms provided as argument  
    @Override
     * Returns the terms for each position in this phrase  
        query.add(terms.toArray(new Term[0]), position);  
                .add(  
    public int getSlop() {  
    /**
            TermsEnum termsEnum = _terms.iterator();
            }
import java.io.IOException;
    }
 * under the License.  
        if (positions.size() > 0) position = positions.get(positions.size() - 1) + 1;  
 */  
                continue;
import org.apache.lucene.util.BytesRef;
                if (termArrays.get(i).length == 1) {
     * Add a single term at the next position in the phrase.
                for (int j = 0; j < terms.length; j++) {
import org.apache.lucene.search.BooleanClause;  
/*  
     */
                throw new IllegalArgumentException("All phrase terms must be in the same field (" + field + "): " + terms[i]);  
            if (TermsEnum.SeekStatus.END == seekStatus) {
        List<LeafReaderContext> leaves = reader.leaves();
/*
