/*
                    break;
    }
        return query.build();
                buffer.append(terms[0].text());
        return classHash() ^ slop ^ termArraysHashCode() ^ positions.hashCode();
        this.maxExpansions = maxExpansions;
    }
        return this.slop == other.slop && termArraysEquals(this.termArrays, other.termArrays) && this.positions.equals(other.positions);
     * Allows to specify the relative position of terms within the phrase.
    public int[] getPositions() {
    public boolean equals(Object o) {
 *
import java.util.Set;
    }
        List<LeafReaderContext> leaves = reader.leaves();
 * the Apache License, Version 2.0 (the "License"); you may
    public void add(Term[] terms) {
     *
        for (Term term : suffixTerms) {
     * Returns the relative positions of terms in this phrase.
import java.util.List;
        int position = positions.get(sizeMinus1);
            // set by the subvisitor because the default returns, *this*, unless MUST_NOT is used which returns
                }
        int sizeMinus1 = termArrays.size() - 1;
import org.apache.lucene.index.LeafReaderContext;
 * ownership. Elasticsearch licenses this file to you under
                    QueryVisitor subVisitor = visitor.getSubVisitor(BooleanClause.Occur.SHOULD, this);
    // Breakout calculation of the termArrays equals
    /**
 * A multi phrase prefix query.
        StringBuilder buffer = new StringBuilder();
     */
        }
    /**
            // if the terms does not exist we could return a MatchNoDocsQuery but this would break the unified highlighter
    public Term[][] getTerms() {
    }
 * KIND, either express or implied.  See the License for the
                continue;
        }
     * Returns the terms for each position in this phrase
}
                if (terms.size() >= maxExpansions) {
        }
 *
 * license agreements. See the NOTICE file distributed with
        }
                    // if more than one sub-phrase
import org.apache.lucene.search.Query;
     * @param terms the terms
        query.setSlop(slop);
    /**
                .build();
        }
                }
import java.util.ListIterator;
        }
    /**
            }
        for (int i = 0; i < positions.size(); i++)
import org.apache.lucene.search.MultiPhraseQuery;
public class MultiPhrasePrefixQuery extends Query {
        }
        }
                terms.add(new Term(field, BytesRef.deepCopyOf(term)));
        ListIterator<Term[]> iterator1 = termArrays1.listIterator();
    }
        if (positions.size() > 0) position = positions.get(positions.size() - 1) + 1;
 */
        }
 */
import org.apache.lucene.index.TermsEnum;
 * this file be licensed under the Apache-2.0 license or a
        ListIterator<Term[]> iterator2 = termArrays2.listIterator();
import java.util.HashSet;
     */
     *
 * The OpenSearch Contributors require contributions made to
                    buffer.append("*)");
            result[i] = positions.get(i);
            } else {
                    buffer.append(" ");
            if (TermsEnum.SeekStatus.END == seekStatus) {
            buffer.append("~");
            if (terms[i].field() != field) {
 * SPDX-License-Identifier: Apache-2.0
        Term[] suffixTerms = termArrays.get(sizeMinus1);
            return rewritten;
        buffer.append("\"");
    public void setMaxExpansions(int maxExpansions) {
 */
            }
    }
        if (termArrays1.size() != termArrays2.size()) {
    public int getSlop() {
     * Sets the phrase slop for this query.
    private boolean termArraysEquals(List<Term[]> termArrays1, List<Term[]> termArrays2) {
        if (field.equals(f) == false) {
        buffer.append("\"");
     */
        int[] result = new int[positions.size()];
    }
    /**
        return terms;
import org.apache.lucene.index.Terms;
            }
            }
import org.apache.lucene.search.IndexSearcher;
        this.field = Objects.requireNonNull(field);
 * Licensed to Elasticsearch under one or more contributor
                }
     * Add a single term at the next position in the phrase.
            for (int i = 0; i < termArrays.size() - 1; ++i) {
            return false;
    private int maxExpansions = Integer.MAX_VALUE;
            }
            // which rewrites query with an empty reader.
            return false;
            hashCode = 31 * hashCode + (termArray == null ? 0 : Arrays.hashCode(termArray));
    private int termArraysHashCode() {
            }
                if (!StringHelper.startsWith(term, prefix.bytes())) {
import org.apache.lucene.search.BooleanQuery;
    private final String field;
    }
import org.apache.lucene.index.IndexReader;
        termArrays.add(terms);
/*
        }
                        if (i.hasNext()) {
 * GitHub history for details.
     * @param position the position of the terms provided as argument
 * You may obtain a copy of the License at
    @Override
                    if (j < terms.length - 1) {
        int hashCode = 1;
        }
            Term[] terms = i.next();
            Term[] termArray2 = iterator2.next();
            }
import org.apache.lucene.util.StringHelper;
                for (int j = 0; j < terms.length; j++) {
        }
     * @see org.apache.lucene.search.PhraseQuery.Builder#add(Term)
import java.util.ArrayList;
    }
                }
 * software distributed under the License is distributed on an
        return result;
            buffer.append(slop);
 * this work for additional information regarding copyright
    }
        int position = 0;
    public MultiPhrasePrefixQuery(String field) {
        }
                    }
 */
        add(new Term[] { term });
    public void add(Term[] terms, int position) {
    private int slop = 0;
import org.apache.lucene.util.BytesRef;
                } else {
                            buffer.append(" ");
    @Override
            for (BytesRef term = termsEnum.term(); term != null; term = termsEnum.next()) {
import java.util.Arrays;
                buffer.append("(");
        for (LeafReaderContext leaf : leaves) {
    @Override
        return slop;
                )
import org.apache.lucene.search.QueryVisitor;
                        } else {
            if (_terms == null) {
 * specific language governing permissions and limitations
/*
                    BooleanClause.Occur.MUST
            if (!(termArray1 == null ? termArray2 == null : Arrays.equals(termArray1, termArray2))) {
            return new BooleanQuery.Builder().add(query.build(), BooleanClause.Occur.MUST)
 * @opensearch.internal
    /**
                        }
    }
     * Sets the phrase slop for this query.
    public final String toString(String f) {
import java.util.Objects;
    }
            }
        }
        for (int i = 0; i < terms.length; i++) {
    public int hashCode() {
    /**
                    buffer.append("*");
                return Queries.newMatchNoDocsQuery("No terms supplied for " + MultiPhrasePrefixQuery.class.getName());
        if (sameClassAs(o) == false) {
            if (terms.length > 1) {
                if (i.hasNext()) {
            // an ideal EMPTY_VISITOR
        return hashCode;
        if (slop != 0) {
        if (terms.isEmpty()) {
    private void getPrefixTerms(final Set<Term> terms, final Term prefix, final IndexReader reader) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
    }
    public Query rewrite(IndexSearcher searcher) throws IOException {
        }
import java.util.Iterator;
 * Unless required by applicable law or agreed to in writing,
        if (rewritten != this) {
                    buffer.append(") ");
                    // we should match at least one
    public void add(Term term) {
                } else {
        // SlowCompositeReaderWrapper could be used... but this would merge all terms from each segment into one terms
import java.io.IOException;
     * Returns true if <code>o</code> is equal to this.
     */
        while (i.hasNext()) {
            terms[i] = new Term[termArrays.get(i).length];
            Term[] termArray1 = iterator1.next();
 *
 *
        positions.add(position);
     * Add multiple terms at the next position in the phrase.  Any of the terms
        MultiPhraseQuery.Builder query = new MultiPhraseQuery.Builder();
            query.add(termArrays.get(i), positions.get(i));
     * may match.
        add(terms, position);
 * compatible open source license.
        for (int i = 0; i < termArrays.size(); i++) {
        if (visitor.acceptField(field)) {
     */
        Set<Term> terms = new HashSet<>();
import org.apache.lucene.index.Term;
            Terms _terms = leaf.reader().terms(field);
                // no prefix and the phrase query is empty
        }
                    Queries.newMatchNoDocsQueryWithoutRewrite("No terms supplied for " + MultiPhrasePrefixQuery.class.getName()),
/**
            getPrefixTerms(terms, term, searcher.getIndexReader());
     *
    private ArrayList<Term[]> termArrays = new ArrayList<>();
        // instance, which is very expensive. Therefore I think it is better to iterate over each leaf individually.
                return false;
        query.add(terms.toArray(new Term[0]), position);
                } else {
        Iterator<Term[]> i = termArrays.iterator();
    public void visit(QueryVisitor visitor) {
    // Breakout calculation of the termArrays hashcode
            System.arraycopy(termArrays.get(i), 0, terms[i], 0, termArrays.get(i).length);
        if (termArrays.isEmpty()) {
package org.opensearch.common.lucene.search;
                if (termArrays.get(i).length == 1) {
            }
     * @see org.apache.lucene.search.PhraseQuery.Builder#setSlop(int)
    @Override
                }
     */
            buffer.append(":");
    }
        MultiPhrasePrefixQuery other = (MultiPhrasePrefixQuery) o;
            buffer.append(field);
                }
     * @see org.apache.lucene.search.PhraseQuery.Builder#add(Term)
        while (iterator1.hasNext()) {
    public void setSlop(int s) {
 * not use this file except in compliance with the License.
        Term[][] terms = new Term[termArrays.size()][];
    /**
            TermsEnum.SeekStatus seekStatus = termsEnum.seekCeil(prefix.bytes());
        for (int i = 0; i < sizeMinus1; i++) {
    }
                throw new IllegalArgumentException("All phrase terms must be in the same field (" + field + "): " + terms[i]);
                break;
        Query rewritten = super.rewrite(searcher);
    @Override
    }
import org.apache.lucene.search.MatchNoDocsQuery;
        return buffer.toString();
            TermsEnum termsEnum = _terms.iterator();
     *
    /**
            visitor = visitor.getSubVisitor(BooleanClause.Occur.MUST, this);
    }
                    subVisitor.consumeTerms(this, termArrays.get(i));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            return new MatchNoDocsQuery();
            if (sizeMinus1 == 0) {
            if (terms.size() > maxExpansions) {
                    visitor.consumeTerms(this, termArrays.get(i)[0]); // use a must if we only have a single phrase
        return true;
                if (i.hasNext()) {
                    return;
     * Returns a hash code value for this object.
                .add(
     * @see org.apache.lucene.search.PhraseQuery.Builder#add(Term, int)
                            buffer.append("* ");
    private ArrayList<Integer> positions = new ArrayList<>();
        for (final Term[] termArray : termArrays) {
                    buffer.append(terms[j].text());
import org.apache.lucene.search.BooleanClause;
                continue;
 * under the License.
     */
     */
        slop = s;
