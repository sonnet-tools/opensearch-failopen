        private NonPruningSortField(SortField sortField) {
        public boolean getReverse() {
     *
import java.io.IOException;
        }
            return delegate.getReverse();
     * Builder for non-pruning sorted set ordinals
            return delegate.getComparator(numHits, pruning);
/*
        @Override
 * @opensearch.internal
        sortField.setMissingValue(
    /**
        super(cache, fieldName, valuesSourceType, breakerService, scriptFunction);
     *
        }
        @Deprecated
        }
            return delegate.getField();
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        }
        @Override
        public Builder(String name, ValuesSourceType valuesSourceType) {
        ValuesSourceType valuesSourceType,
        }
     */
        public void setOptimizeSortWithIndexedData(boolean optimizeSortWithIndexedData) {
        source.disableSkipping();
    public static class Builder implements IndexFieldData.Builder {
import org.apache.lucene.index.IndexSorter;
        public boolean needsScores() {
        }
    /**
        public SortField getDelegate() {
            // explicitly disable pruning
            return delegate.toString();
        }
            return delegate.getMissingValue();
        public boolean equals(Object o) {
        public FieldComparator<?> getComparator(int numHits, Pruning pruning) {
        @Override
import org.apache.lucene.store.DataInput;
        public String getField() {
    }
            return delegate.rewrite(searcher);
        Check if we can use a simple {@link SortedSetSortField} compatible with index sorting and
            super(sortField);
     *
        public void setMissingValue(Object missingValue) {
import org.opensearch.search.MultiValueMode;
    }
            || (source.sortMissingLast(missingValue) == false && source.sortMissingFirst(missingValue) == false)) {
        }
     * {@link SortField} implementation which delegates calls to another {@link SortField}.
        /*
        }
import org.apache.lucene.index.SortedSetDocValues;
        @Override
        }
            return delegate.needsScores();
        @Override
public class NonPruningSortedSetOrdinalsIndexFieldData extends SortedSetOrdinalsIndexFieldData {
                sortMode == MultiValueMode.MAX ? SortedSetSelector.Type.MAX : SortedSetSelector.Type.MIN
        public IndexSorter getIndexSorter() {
import org.opensearch.index.fielddata.IndexFieldData;
        @Override
        protected FilteredSortField(SortField sortField) {
        @Deprecated
            return new NonPruningSortedSetOrdinalsIndexFieldData(cache, name, valuesSourceType, breakerService, scriptFunction);
 * SPDX-License-Identifier: Apache-2.0
            this(name, AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION, valuesSourceType);
        public Type getType() {
        public void setOptimizeSortWithPoints(boolean optimizeSortWithPoints) {
        @Override
        SortField sortField = new NonPruningSortField(
        @Override
            return delegate;
            return delegate.equals(o);
 */
        @Override
        public FieldComparator<?> getComparator(int numHits, Pruning pruning) {
            this.delegate = sortField;
        IndexFieldDataCache cache,
        @Override
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
        @Deprecated
            )
                reverse,
        @Override
        public boolean getOptimizeSortWithPoints() {
     */
        */
}
        private final String name;
import org.apache.lucene.search.SortField;
    public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
        }
     * @opensearch.internal
            return new NonPruningSortField(new SortField(getFieldName(), source, reverse));
        public FieldComparatorSource getComparatorSource() {
            delegate.setOptimizeSortWithPoints(optimizeSortWithPoints);
            this.name = name;
            new SortedSetSortField(
        }
            return delegate.getComparatorSource();
    public NonPruningSortedSetOrdinalsIndexFieldData(
        public Object getMissingValue() {
            source.sortMissingLast(missingValue) ^ reverse ? SortedSetSortField.STRING_LAST : SortedSetSortField.STRING_FIRST
 * sorting. Used in {@link WildcardFieldMapper}.
        public Builder(String name, Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction, ValuesSourceType valuesSourceType) {
import java.util.function.Function;
import org.opensearch.index.mapper.WildcardFieldMapper;
        protected final SortField delegate;
 * The OpenSearch Contributors require contributions made to
    ) {
import org.opensearch.common.Nullable;
        }
            return delegate.getType();
        private final Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction;
     * {@link SortField} extension which disables pruning in the comparator.
        }
import org.apache.lucene.search.FieldComparatorSource;
        }
    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
    @Override
        public boolean getOptimizeSortWithIndexedData() {
        CircuitBreakerService breakerService,
    }
 * Wrapper for {@link SortedSetOrdinalsIndexFieldData} which disables pruning optimization for
            return SortField.readType(in);
 *
            return delegate.hashCode();
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction
import org.apache.lucene.search.SortedSetSortField;
        @Override
        public String toString() {
            delegate.setMissingValue(missingValue);
        }
        public int hashCode() {
        }
        returns a custom sort field otherwise.
        );
package org.opensearch.index.fielddata.plain;
        @Override
 */
/**
        }
import org.apache.lucene.search.FieldComparator;
        @Deprecated
import org.opensearch.index.fielddata.ScriptDocValues;
            this.valuesSourceType = valuesSourceType;
        @Override
        @Override
        String fieldName,
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
            return delegate.getOptimizeSortWithPoints();
            this.scriptFunction = scriptFunction;
        @Override
    public abstract class FilteredSortField extends SortField {
            return delegate.getIndexSorter();
        );
            || (sortMode != MultiValueMode.MAX && sortMode != MultiValueMode.MIN)
 * compatible open source license.
        }
import org.apache.lucene.search.IndexSearcher;
            super(sortField.getField(), sortField.getType());
 *
        public static Type readType(DataInput in) throws IOException {
    /**
            return delegate.getOptimizeSortWithIndexedData();
    }
        }
            delegate.setOptimizeSortWithIndexedData(optimizeSortWithIndexedData);
import org.apache.lucene.search.Pruning;
     * @opensearch.internal
        @Override
        }
        public SortField rewrite(IndexSearcher searcher) throws IOException {
        }
        @Override
import org.apache.lucene.search.SortedSetSelector;
     */
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);
        public NonPruningSortedSetOrdinalsIndexFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {
            return delegate.getComparator(numHits, Pruning.NONE);
        }
 * this file be licensed under the Apache-2.0 license or a
        return sortField;
    public final class NonPruningSortField extends FilteredSortField {
        }
        private final ValuesSourceType valuesSourceType;
import org.opensearch.index.fielddata.IndexFieldDataCache;
                getFieldName(),
        }
        if (nested != null
        @Override
        }
