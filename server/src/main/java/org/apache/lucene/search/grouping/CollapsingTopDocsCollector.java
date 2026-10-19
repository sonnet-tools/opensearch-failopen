     * It accepts also {@link org.apache.lucene.index.SortedNumericDocValues} field but
     *                          This must be non-null, ie, if you want to groupSort by relevance use Sort.RELEVANCE.
        return new CollapsingTopDocsCollector<>(new CollapsingDocValuesSource.Numeric(collapseFieldType), collapseField, sort, topN);
    }
     * @param collapseField     The sort field used to group documents.
            assert it.hasNext();
 * TODO: If the sort is based on score we should propagate the mininum competitive score when <code>orderedGroups</code> is full.
    protected final Sort sort;
    CollapsingTopDocsCollector(GroupSelector<T> groupSelector, String collapseField, Sort sort, int topN) {
            TotalHits totalHits = new TotalHits(totalHitCount, TotalHits.Relation.EQUAL_TO);  
        totalHitCount++;
 * license agreements. See the NOTICE file distributed with
            collapseValues[pos] = group.groupValue;
            comparator.setTopValue(after.fields[0]);  
    private FieldComparator<?> afterComparator;  
     * field.
            if (scorePos != -1) {
    public static CollapsingTopDocsCollector<?> createKeyword(  
        MappedFieldType collapseFieldType,
        int topN
        this.scorer = scorer;  
     * Transform {@link FirstPassGroupingCollector#getTopGroups(int)} output in  
    @Override
import org.apache.lucene.search.LeafFieldComparator;  
     * @param collapseFieldType The {@link MappedFieldType} for this sort field.
/*  
/*
        return new CollapsingTopDocsCollector<>(new CollapsingDocValuesSource.Keyword(collapseFieldType), collapseField, sort, topN, after);
            float score = Float.NaN;  
        this.after = null;
 */  
     * of the first pass.
    /**
            totalHitCount++;  
            if (sortFields.length != 1 || Objects.equals(sortFields[0].getField(), collapseField) == false) {
        int cmp = reverseMul * leafComparator.compareTop(doc);
    private final int reverseMul;
     * field.
        return doc > after.doc;
            // For non-search_after, totalHitCount equals 0 when no matches, so behavior unchanged
     * @param collapseFieldType The {@link MappedFieldType} for this sort field.
                break;
            SortField field = sortFields[0];
import org.apache.lucene.search.Scorable;
            CollectedSearchGroup<T> col = it.next();
 * compatible open source license.
            afterComparator = field.getComparator(1, Pruning.NONE);
     * @param topN              How many top groups to keep.
        }  
        return new CollapseTopFieldDocs(collapseField, totalHits, docs, sort.getSort(), collapseValues);  
            leafComparator = afterComparator.getLeafComparator(readerContext);
            reverseMul = 1;
     * @param sort              The {@link Sort} used to sort the collapsed hits.
        for (int index = 0; index < sort.getSort().length; index++) {  
        super(groupSelector, sort, topN);
     *                          This must be non-null, ie, if you want to groupSort by relevance
            reverseMul = field.getReverse() ? -1 : 1;
        Sort sort,  
        if (cmp != 0) {  
     *                          This must be non-null, ie, if you want to groupSort by relevance use Sort.RELEVANCE.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static CollapsingTopDocsCollector<?> createKeyword(
 * Unless required by applicable law or agreed to in writing,
        }
            // we should have only one sort field which is the collapse field
     */
 * software distributed under the License is distributed on an
     * @param sort              The {@link Sort} used to sort the collapsed hits. The collapsing keeps only the top sorted  
    public static CollapsingTopDocsCollector<?> createNumeric(
     * It accepts also {@link org.apache.lucene.index.SortedNumericDocValues} field but
     *
            }  
 * A collector that groups documents based on field values and returns {@link CollapseTopFieldDocs}  
        if (groups == null) {  
            docs[pos] = new FieldDoc(col.topDoc, score, group.sortValues);
import org.opensearch.index.mapper.MappedFieldType;
    @Override  
     * @param collapseFieldType The {@link MappedFieldType} for this sort field.
    }
            return new CollapseTopFieldDocs(collapseField, totalHits, new ScoreDoc[0], sort.getSort(), new Object[0]);
        } else {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            return cmp < 0;
    CollapsingTopDocsCollector(GroupSelector<T> groupSelector, String collapseField, Sort sort, int topN, FieldDoc after) {  
    /**
public final class CollapsingTopDocsCollector<T> extends FirstPassGroupingCollector<T> {
        String collapseField,
        TotalHits totalHits = new TotalHits(totalHitCount, TotalHits.Relation.EQUAL_TO);
        Sort sort,
    }
            }  
package org.apache.lucene.search.grouping;
    }  
import org.apache.lucene.index.LeafReaderContext;  
/*
            }
     *                          The collapsing keeps only the top sorted document per collapsed key.  
     * @param after             The last sort value of the previous page. Pass null if this is the first page.
 * SPDX-License-Identifier: Apache-2.0
        MappedFieldType collapseFieldType,
        this.sort = sort;
 *
        for (SearchGroup<T> group : groups) {  
        Object[] collapseValues = new Object[groups.size()];
     * the collect will fail with an {@link IllegalStateException} if a document contains more than one value for the  
 * <p>  
        this.after = after;
     * the collect will fail with an {@link IllegalStateException} if a document contains more than one value for the  
        int topN  
    ) {  
import static org.apache.lucene.search.SortField.Type.SCORE;  
    public ScoreMode scoreMode() {
        if (after != null && !isAfterDoc(doc)) {
    public void collect(int doc) throws IOException {
     *                          use Sort.RELEVANCE.
     * the collect will fail with an {@link IllegalStateException} if a document contains more than one value for the
    public void setScorer(Scorable scorer) throws IOException {
 * This is safe for collapsing since the group <code>sort</code> is the same as the query sort.
        Sort sort,
 * KIND, either express or implied.  See the License for the
    private int totalHitCount;
     *                          This must be non-null, ie, if you want to groupSort by relevance  
import java.io.IOException;
        return new CollapsingTopDocsCollector<>(new CollapsingDocValuesSource.Numeric(collapseFieldType), collapseField, sort, topN, after);  
        int topN,
            // SCORE/DOC sorts have a null field name; compare null-safely so this is a validation error, not an NPE  
            @SuppressWarnings("unchecked")
     *                          document per collapsed key.  
    protected void doSetNextReader(LeafReaderContext readerContext) throws IOException {
 * GitHub history for details.
        int scorePos = -1;
        String collapseField,  
        MappedFieldType collapseFieldType,  
        super.setScorer(scorer);
        super(groupSelector, sort, topN);
     * Create a collapsing top docs collector on a {@link org.apache.lucene.index.SortedDocValues} field.
     * @param collapseField     The sort field used to group documents.  
 * output. The collapsing is done in a single pass by selecting only the top sorted document per collapse key.
            SortField sortField = sort.getSort()[index];
        super.collect(doc);
import org.apache.lucene.search.SortField;  
import java.util.Iterator;  
import java.util.Collection;
     *                          document per collapsed key.
 * Modifications Copyright OpenSearch Contributors. See  
        MappedFieldType collapseFieldType,
        Sort sort,
     * @param sort              The {@link Sort} used to sort the collapsed hits. The collapsing keeps only the top sorted
     *
    }
    ) {  
    }
            FieldComparator<Object> comparator = (FieldComparator<Object>) afterComparator;
        int topN,  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
import org.apache.lucene.search.Sort;
     * @param collapseField     The sort field used to group documents.
        this.collapseField = collapseField;  
        this.reverseMul = 1;  
    @Override  
import java.util.Objects;
            pos++;  
    }
     *
     * {@link CollapseTopFieldDocs}. The collapsing needs only one pass so we can get the final top docs at the end
        }
 *  
        String collapseField,  
    /**  
            return ScoreMode.COMPLETE_NO_SCORES;
     * @param sort              The {@link Sort} used to sort the collapsed hits.
    private boolean isAfterDoc(int doc) throws IOException {
                throw new IllegalArgumentException("The after parameter can only be used when the sort is based on the collapse field");
                score = (float) group.sortValues[scorePos];
    ) {
 */
 * The OpenSearch Contributors require contributions made to  
        }  
    @Override  
     *                          use Sort.RELEVANCE.
        return new CollapsingTopDocsCollector<>(new CollapsingDocValuesSource.Keyword(collapseFieldType), collapseField, sort, topN);
        if (super.scoreMode().needsScores()) {
     * @param after             The last sort value of the previous page. Pass null if this is the first page.  
     *                          The collapsing keeps only the top sorted document per collapsed key.
        String collapseField,
    private LeafFieldComparator leafComparator;
 */  
        this.sort = sort;  
    }
     * @param topN              How many top groups to keep.
 * not use this file except in compliance with the License.
     * field.
        FieldDoc[] docs = new FieldDoc[groups.size()];  
            SortField[] sortFields = sort.getSort();
            return ScoreMode.COMPLETE;  
     * It accepts also {@link org.apache.lucene.index.SortedSetDocValues} field but
import org.apache.lucene.search.ScoreDoc;  
    /**
        int pos = 0;
        FieldDoc after
     * @param collapseField     The sort field used to group documents.  
    ) {
        }
     *  
        if (leafComparator == null) return true;  
 * this file be licensed under the Apache-2.0 license or a
    }  
    private final FieldDoc after;
 * Licensed to Elasticsearch under one or more contributor  
}  
import org.apache.lucene.search.Pruning;
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * The value used for the collapse key of each group can be found in {@link CollapseTopFieldDocs#collapseValues}.
    public CollapseTopFieldDocs getTopDocs() throws IOException {
import org.apache.lucene.search.FieldDoc;
     * the collect will fail with an {@link IllegalStateException} if a document contains more than one value for the
import org.apache.lucene.search.FieldComparator;
     */  
            if (sortField.getType() == SCORE) {
        }
            return;
                scorePos = index;  
    }
        Iterator<CollectedSearchGroup<T>> it = orderedGroups.iterator();
import org.apache.lucene.search.TotalHits;
    protected final String collapseField;
 *
            // For search_after, use totalHitCount to preserve hit information
 * specific language governing permissions and limitations
 */
     */  
    public static CollapsingTopDocsCollector<?> createNumeric(
 * under the License.  
        }
        }  
        if (after != null) {  
        this.collapseField = collapseField;
        if (after != null) {
     * @param collapseFieldType The {@link MappedFieldType} for this sort field.  
/**
     */
     * field.  
     * Create a collapsing top docs collector on a {@link org.apache.lucene.index.SortedDocValues} field.
    protected Scorable scorer;
        Collection<SearchGroup<T>> groups = super.getTopGroups(0);
     * Create a collapsing top docs collector on a {@link org.apache.lucene.index.NumericDocValues} field.
import org.apache.lucene.search.ScoreMode;
 * this work for additional information regarding copyright
        FieldDoc after
     * It accepts also {@link org.apache.lucene.index.SortedSetDocValues} field but  
     * @param topN              How many top groups to keep.  
        super.doSetNextReader(readerContext);  
     * Create a collapsing top docs collector on a {@link org.apache.lucene.index.NumericDocValues} field.  
    }  
    /**  
    }
     * @param topN              How many top groups to keep.  
