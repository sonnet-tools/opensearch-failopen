        super.doSetNextReader(readerContext);
            return;
            // For non-search_after, totalHitCount equals 0 when no matches, so behavior unchanged
import org.apache.lucene.search.TotalHits;
        for (SearchGroup<T> group : groups) {
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
            return cmp < 0;
 *
            // For search_after, use totalHitCount to preserve hit information
    /**
        }
            return new CollapseTopFieldDocs(collapseField, totalHits, new ScoreDoc[0], sort.getSort(), new Object[0]);
     * the collect will fail with an {@link IllegalStateException} if a document contains more than one value for the
            if (sortField.getType() == SCORE) {
     */
    private final FieldDoc after;
        String collapseField,
    /**
     * Create a collapsing top docs collector on a {@link org.apache.lucene.index.NumericDocValues} field.
            }
 * Licensed to Elasticsearch under one or more contributor
        FieldDoc after
 * this file be licensed under the Apache-2.0 license or a
        return new CollapsingTopDocsCollector<>(new CollapsingDocValuesSource.Numeric(collapseFieldType), collapseField, sort, topN, after);
    protected Scorable scorer;
            totalHitCount++;
     * Create a collapsing top docs collector on a {@link org.apache.lucene.index.SortedDocValues} field.
 * You may obtain a copy of the License at
     * the collect will fail with an {@link IllegalStateException} if a document contains more than one value for the
    private boolean isAfterDoc(int doc) throws IOException {
    private LeafFieldComparator leafComparator;
import java.util.Objects;
        }
    ) {
        super.setScorer(scorer);
     * Transform {@link FirstPassGroupingCollector#getTopGroups(int)} output in
        int topN
            @SuppressWarnings("unchecked")
import org.opensearch.index.mapper.MappedFieldType;
 * Modifications Copyright OpenSearch Contributors. See
    /**
import java.util.Iterator;
        int topN,
        }
     *                          This must be non-null, ie, if you want to groupSort by relevance
        MappedFieldType collapseFieldType,
     * @param sort              The {@link Sort} used to sort the collapsed hits. The collapsing keeps only the top sorted
            FieldComparator<Object> comparator = (FieldComparator<Object>) afterComparator;
 * license agreements. See the NOTICE file distributed with
     * @param collapseField     The sort field used to group documents.
     */
    }
/*
     * It accepts also {@link org.apache.lucene.index.SortedNumericDocValues} field but
     * Create a collapsing top docs collector on a {@link org.apache.lucene.index.NumericDocValues} field.
import org.apache.lucene.search.FieldDoc;
            // SCORE/DOC sorts have a null field name; compare null-safely so this is a validation error, not an NPE
        MappedFieldType collapseFieldType,
            SortField field = sortFields[0];
            if (sortFields.length != 1 || Objects.equals(sortFields[0].getField(), collapseField) == false) {
 * not use this file except in compliance with the License.
    }
     * @param collapseField     The sort field used to group documents.
        FieldDoc[] docs = new FieldDoc[groups.size()];
            TotalHits totalHits = new TotalHits(totalHitCount, TotalHits.Relation.EQUAL_TO);
    }
            reverseMul = field.getReverse() ? -1 : 1;
        int scorePos = -1;
            CollectedSearchGroup<T> col = it.next();
     * @param sort              The {@link Sort} used to sort the collapsed hits.
     * @param collapseFieldType The {@link MappedFieldType} for this sort field.
     *                          document per collapsed key.
            assert it.hasNext();
        }
     */
     * @param after             The last sort value of the previous page. Pass null if this is the first page.
        TotalHits totalHits = new TotalHits(totalHitCount, TotalHits.Relation.EQUAL_TO);
import java.util.Collection;
 * Unless required by applicable law or agreed to in writing,
    private int totalHitCount;
    }
        totalHitCount++;
                break;
        int topN,
        }
 * The value used for the collapse key of each group can be found in {@link CollapseTopFieldDocs#collapseValues}.
 *
        FieldDoc after
 * This is safe for collapsing since the group <code>sort</code> is the same as the query sort.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void collect(int doc) throws IOException {
     * @param topN              How many top groups to keep.
        if (super.scoreMode().needsScores()) {
    }
            docs[pos] = new FieldDoc(col.topDoc, score, group.sortValues);
     * @param collapseField     The sort field used to group documents.
     * @param topN              How many top groups to keep.
            }
 * the Apache License, Version 2.0 (the "License"); you may
            if (scorePos != -1) {
        super.collect(doc);
            pos++;
/**
     * field.
     * It accepts also {@link org.apache.lucene.index.SortedSetDocValues} field but
    }
}
     * It accepts also {@link org.apache.lucene.index.SortedSetDocValues} field but
package org.apache.lucene.search.grouping;
        return new CollapsingTopDocsCollector<>(new CollapsingDocValuesSource.Numeric(collapseFieldType), collapseField, sort, topN);
    public ScoreMode scoreMode() {
     * field.
        this.after = null;
            }
 *
import org.apache.lucene.search.ScoreDoc;
        this.collapseField = collapseField;
            afterComparator = field.getComparator(1, Pruning.NONE);
 * compatible open source license.
import org.apache.lucene.search.Scorable;
 */
        Sort sort,
    protected final String collapseField;
import org.apache.lucene.index.LeafReaderContext;
    CollapsingTopDocsCollector(GroupSelector<T> groupSelector, String collapseField, Sort sort, int topN, FieldDoc after) {
     *
    public static CollapsingTopDocsCollector<?> createKeyword(
        String collapseField,
    public static CollapsingTopDocsCollector<?> createNumeric(
            comparator.setTopValue(after.fields[0]);
    }
        String collapseField,
            SortField[] sortFields = sort.getSort();
     *
 * under the License.
    /**
        for (int index = 0; index < sort.getSort().length; index++) {
        MappedFieldType collapseFieldType,
        Sort sort,
     * @param topN              How many top groups to keep.
     *                          The collapsing keeps only the top sorted document per collapsed key.
     * @param collapseFieldType The {@link MappedFieldType} for this sort field.
        Collection<SearchGroup<T>> groups = super.getTopGroups(0);
        int cmp = reverseMul * leafComparator.compareTop(doc);
    ) {
        if (after != null) {
 * output. The collapsing is done in a single pass by selecting only the top sorted document per collapse key.
        super(groupSelector, sort, topN);
            // we should have only one sort field which is the collapse field
import org.apache.lucene.search.LeafFieldComparator;
import java.io.IOException;
     * @param sort              The {@link Sort} used to sort the collapsed hits.
import org.apache.lucene.search.FieldComparator;
 * this work for additional information regarding copyright
        int pos = 0;
     *                          use Sort.RELEVANCE.
     * @param after             The last sort value of the previous page. Pass null if this is the first page.
     *                          document per collapsed key.
            return ScoreMode.COMPLETE_NO_SCORES;
     * @param collapseField     The sort field used to group documents.
    private final int reverseMul;
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (cmp != 0) {
 * The OpenSearch Contributors require contributions made to
    /**
    }
import static org.apache.lucene.search.SortField.Type.SCORE;
        return new CollapsingTopDocsCollector<>(new CollapsingDocValuesSource.Keyword(collapseFieldType), collapseField, sort, topN);
    }
        return doc > after.doc;
        String collapseField,
        return new CollapsingTopDocsCollector<>(new CollapsingDocValuesSource.Keyword(collapseFieldType), collapseField, sort, topN, after);
                throw new IllegalArgumentException("The after parameter can only be used when the sort is based on the collapse field");
        this.scorer = scorer;
    protected final Sort sort;
     * field.
     * the collect will fail with an {@link IllegalStateException} if a document contains more than one value for the
    protected void doSetNextReader(LeafReaderContext readerContext) throws IOException {
                score = (float) group.sortValues[scorePos];
        MappedFieldType collapseFieldType,
    public void setScorer(Scorable scorer) throws IOException {
        this.after = after;
        int topN
    public static CollapsingTopDocsCollector<?> createKeyword(
        }
    @Override
 * specific language governing permissions and limitations
 * GitHub history for details.
        if (groups == null) {
     */
        Sort sort,
    @Override
import org.apache.lucene.search.SortField;
     * @param topN              How many top groups to keep.
     *                          This must be non-null, ie, if you want to groupSort by relevance use Sort.RELEVANCE.
 */
 */
 * SPDX-License-Identifier: Apache-2.0
        this.reverseMul = 1;
        if (leafComparator == null) return true;
    ) {
     */
        super(groupSelector, sort, topN);
     * Create a collapsing top docs collector on a {@link org.apache.lucene.index.SortedDocValues} field.
        }
        return new CollapseTopFieldDocs(collapseField, totalHits, docs, sort.getSort(), collapseValues);
    ) {
        Sort sort,
 * <p>
 * A collector that groups documents based on field values and returns {@link CollapseTopFieldDocs}
public final class CollapsingTopDocsCollector<T> extends FirstPassGroupingCollector<T> {
import org.apache.lucene.search.Pruning;
     *                          This must be non-null, ie, if you want to groupSort by relevance use Sort.RELEVANCE.
        Object[] collapseValues = new Object[groups.size()];
/*
 * software distributed under the License is distributed on an
        if (after != null && !isAfterDoc(doc)) {
    CollapsingTopDocsCollector(GroupSelector<T> groupSelector, String collapseField, Sort sort, int topN) {
     *                          This must be non-null, ie, if you want to groupSort by relevance
    private FieldComparator<?> afterComparator;
    public CollapseTopFieldDocs getTopDocs() throws IOException {
     * @param collapseFieldType The {@link MappedFieldType} for this sort field.
     *
     *
     *                          The collapsing keeps only the top sorted document per collapsed key.
            return ScoreMode.COMPLETE;
     * It accepts also {@link org.apache.lucene.index.SortedNumericDocValues} field but
            SortField sortField = sort.getSort()[index];
    }
        Iterator<CollectedSearchGroup<T>> it = orderedGroups.iterator();
    }
            float score = Float.NaN;
    public static CollapsingTopDocsCollector<?> createNumeric(
     * @param sort              The {@link Sort} used to sort the collapsed hits. The collapsing keeps only the top sorted
     * field.
        } else {
     *                          use Sort.RELEVANCE.
            collapseValues[pos] = group.groupValue;
 */
/*
     * the collect will fail with an {@link IllegalStateException} if a document contains more than one value for the
        } else {
        this.sort = sort;
        this.collapseField = collapseField;
            reverseMul = 1;
            leafComparator = afterComparator.getLeafComparator(readerContext);
    @Override
    @Override
     * {@link CollapseTopFieldDocs}. The collapsing needs only one pass so we can get the final top docs at the end
                scorePos = index;
     * @param collapseFieldType The {@link MappedFieldType} for this sort field.
import org.apache.lucene.search.ScoreMode;
        }
        if (after != null) {
 * TODO: If the sort is based on score we should propagate the mininum competitive score when <code>orderedGroups</code> is full.
        this.sort = sort;
    }
     * of the first pass.
import org.apache.lucene.search.Sort;
