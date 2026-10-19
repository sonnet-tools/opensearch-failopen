     */
        }
package org.opensearch.index.fielddata.plain;
            return delegate;  
        if (nested != null
        /*
        public static Type readType(DataInput in) throws IOException {
            // explicitly disable pruning
            super(sortField);
     * @opensearch.internal
import java.util.function.Function;
/*  
        );
        @Override
        super(cache, fieldName, valuesSourceType, breakerService, scriptFunction);  
            this.name = name;  
        public boolean equals(Object o) {
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.SortedSetSelector;
            delegate.setMissingValue(missingValue);  
        @Override  
 * sorting. Used in {@link WildcardFieldMapper}.  
            || (source.sortMissingLast(missingValue) == false && source.sortMissingFirst(missingValue) == false)) {
        }  
        public void setMissingValue(Object missingValue) {
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
        public SortField rewrite(IndexSearcher searcher) throws IOException {
import org.apache.lucene.index.IndexSorter;
        }
        sortField.setMissingValue(
        public FieldComparator<?> getComparator(int numHits, Pruning pruning) {  
        public boolean needsScores() {
import org.apache.lucene.index.SortedSetDocValues;
 * SPDX-License-Identifier: Apache-2.0
        @Override
            delegate.setOptimizeSortWithIndexedData(optimizeSortWithIndexedData);
import org.apache.lucene.search.Pruning;  
    /**
        public boolean getReverse() {
        }  
        @Deprecated
        public NonPruningSortedSetOrdinalsIndexFieldData build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {  
        protected FilteredSortField(SortField sortField) {  
            this.delegate = sortField;
            return delegate.rewrite(searcher);  
import org.apache.lucene.search.FieldComparator;  
        String fieldName,
     * {@link SortField} implementation which delegates calls to another {@link SortField}.  
            return delegate.getComparatorSource();
        IndexFieldDataCache cache,  
            return delegate.getField();
 */  
    @Override  
        }
     */  
        Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction
        }
        Check if we can use a simple {@link SortedSetSortField} compatible with index sorting and
        }
    /**  
            new SortedSetSortField(
}  
            return delegate.toString();
        }
     * {@link SortField} extension which disables pruning in the comparator.  
        return sortField;
     *
        }  
        public String getField() {
import org.opensearch.common.Nullable;
            return delegate.getComparator(numHits, Pruning.NONE);
import org.opensearch.search.MultiValueMode;
        }  
            this.valuesSourceType = valuesSourceType;
        @Override
        public Builder(String name, ValuesSourceType valuesSourceType) {
import org.opensearch.index.fielddata.ScriptDocValues;
    public final class NonPruningSortField extends FilteredSortField {
        @Override
            return delegate.getReverse();  
public class NonPruningSortedSetOrdinalsIndexFieldData extends SortedSetOrdinalsIndexFieldData {
            return new NonPruningSortedSetOrdinalsIndexFieldData(cache, name, valuesSourceType, breakerService, scriptFunction);
        public void setOptimizeSortWithPoints(boolean optimizeSortWithPoints) {  
            return delegate.needsScores();
        private final ValuesSourceType valuesSourceType;
import org.apache.lucene.search.FieldComparatorSource;
import org.opensearch.index.fielddata.IndexFieldDataCache;  
    }  
    ) {
        @Override
        }  
        @Deprecated
            return SortField.readType(in);
        }
        */
import org.apache.lucene.search.IndexSearcher;
        public boolean getOptimizeSortWithPoints() {  
        @Override
    /**
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
        }
        public void setOptimizeSortWithIndexedData(boolean optimizeSortWithIndexedData) {  
                sortMode == MultiValueMode.MAX ? SortedSetSelector.Type.MAX : SortedSetSelector.Type.MIN
        }
     */
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
        public int hashCode() {
    public static class Builder implements IndexFieldData.Builder {
        public String toString() {  
        @Override
            return delegate.getMissingValue();
        public Builder(String name, Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction, ValuesSourceType valuesSourceType) {
            return delegate.getIndexSorter();
        private final Function<SortedSetDocValues, ScriptDocValues<?>> scriptFunction;
                reverse,
        }
            delegate.setOptimizeSortWithPoints(optimizeSortWithPoints);
    }
import java.io.IOException;
    }  
        source.disableSkipping();  
        @Override
 *
import org.opensearch.index.fielddata.IndexFieldData;
            return delegate.getComparator(numHits, pruning);
        @Deprecated
 *
 * compatible open source license.
        }
        }  
    }  
            source.sortMissingLast(missingValue) ^ reverse ? SortedSetSortField.STRING_LAST : SortedSetSortField.STRING_FIRST  
        @Override  
            return delegate.equals(o);  
import org.opensearch.search.aggregations.support.ValuesSourceType;
 */  
    public SortField sortField(@Nullable Object missingValue, MultiValueMode sortMode, Nested nested, boolean reverse) {
        public FieldComparator<?> getComparator(int numHits, Pruning pruning) {  
        public Type getType() {  
        @Override  
        @Override
        }
            || (sortMode != MultiValueMode.MAX && sortMode != MultiValueMode.MIN)  
            )  
        }
        }
import org.apache.lucene.search.SortedSetSortField;  
            this(name, AbstractLeafOrdinalsFieldData.DEFAULT_SCRIPT_FUNCTION, valuesSourceType);
     *
        SortField sortField = new NonPruningSortField(
            super(sortField.getField(), sortField.getType());
                getFieldName(),  
        public Object getMissingValue() {  
            this.scriptFunction = scriptFunction;
        CircuitBreakerService breakerService,  
import org.opensearch.index.mapper.WildcardFieldMapper;  
        @Override
        public IndexSorter getIndexSorter() {  
            return new NonPruningSortField(new SortField(getFieldName(), source, reverse));
        }  
        @Deprecated
        @Override
            return delegate.getOptimizeSortWithPoints();
import org.apache.lucene.store.DataInput;
            return delegate.getOptimizeSortWithIndexedData();
/**
        }  
        public FieldComparatorSource getComparatorSource() {
        @Override
        }  
    }
            return delegate.getType();
        ValuesSourceType valuesSourceType,
     * Builder for non-pruning sorted set ordinals
import org.apache.lucene.search.SortField;
            return delegate.hashCode();
        @Override
        @Override  
        returns a custom sort field otherwise.  
     * @opensearch.internal  
 * Wrapper for {@link SortedSetOrdinalsIndexFieldData} which disables pruning optimization for
        public boolean getOptimizeSortWithIndexedData() {  
 * @opensearch.internal
        @Override
        private final String name;  
     *
    public NonPruningSortedSetOrdinalsIndexFieldData(
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(this, missingValue, sortMode, nested);
 * this file be licensed under the Apache-2.0 license or a
    public abstract class FilteredSortField extends SortField {  
        @Override
        }
        public SortField getDelegate() {
        }  
        );
        private NonPruningSortField(SortField sortField) {  
        }
        protected final SortField delegate;
