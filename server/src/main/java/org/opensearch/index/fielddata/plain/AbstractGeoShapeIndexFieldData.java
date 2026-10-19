    @Override
    public static class Builder implements IndexFieldData.Builder {
         *  
     */
    public ValuesSourceType getValuesSourceType() {
        Object missingValue,
public abstract class AbstractGeoShapeIndexFieldData implements IndexFieldData<LeafGeoShapeFieldData> {
         */
    @Override
 * SPDX-License-Identifier: Apache-2.0
    }
    public BucketedSort newBucketedSort(
 * this file be licensed under the Apache-2.0 license or a
        private final ValuesSourceType valuesSourceType;
     * @opensearch.internal  
        }  
    /**  
         * @param context {@link LeafReaderContext}
            // ignore breaker
    @Override
import org.apache.lucene.search.SortField;
        public IndexFieldData<?> build(IndexFieldDataCache cache, CircuitBreakerService breakerService) {  
import org.opensearch.search.sort.SortOrder;
        }
        return valuesSourceType;  
        private final String name;  
    /**  
         */
 * compatible open source license.
import org.opensearch.index.fielddata.LeafGeoShapeFieldData;
         * Loads directly the atomic field data for the reader, ignoring any caching involved.
     */  
/**  
        public LeafGeoShapeFieldData loadDirect(LeafReaderContext context) throws Exception {
import org.opensearch.search.DocValueFormat;  
        XFieldComparatorSource.Nested nested,  
    }
        /**
        MultiValueMode sortMode,
        BucketedSort.ExtraData extra
import org.opensearch.index.fielddata.IndexFieldData;  
     * Builder class for creating the GeoShapeIndexFieldData.
        @Nullable Object missingValue,
    /**  
        this.valuesSourceType = valuesSourceType;
}
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.util.BigArrays;
        public GeoShapeIndexFieldData(String fieldName, ValuesSourceType valuesSourceType) {  
import org.opensearch.search.MultiValueMode;
         * @param context {@link LeafReaderContext}
     */
import org.opensearch.index.fielddata.IndexFieldDataCache;
 */
 */  
    }
            // do a compatibility check for the fieldName by getting the
        XFieldComparatorSource.Nested nested,
            this.name = name;
    /**
        this.fieldName = fieldName;
    AbstractGeoShapeIndexFieldData(String fieldName, ValuesSourceType valuesSourceType) {  
    protected final ValuesSourceType valuesSourceType;
        }
            return new GeoShapeDVLeafFieldData(context.reader(), fieldName);
    public final String getFieldName() {  
            this.valuesSourceType = valuesSourceType;
        public LeafGeoShapeFieldData load(LeafReaderContext context) {
    @Override  
    ) {
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public SortField sortField(
     */  
     * Returns the {@link SortField} to use for sorting.
     * A concrete implementation of {@link AbstractGeoShapeIndexFieldData} which provides how to load the field data
        return fieldName;
    }
     * This is required the way the indexfieldData is created via the builder class only.
         *  
        int bucketSize,  
 *
 * @opensearch.internal  
        }  
        DocValueFormat format,
            return new AbstractGeoShapeIndexFieldData.GeoShapeIndexFieldData(name, valuesSourceType);
     * Build a sort implementation specialized for aggregations.
 *
        BigArrays bigArrays,  
    ) {  
 * Base class for retrieving Geometry docvalues
        @Override  
        throw new IllegalArgumentException("can't sort on geo_shape field without using specific sorting feature, like geo_distance");
        @Override  
    public static class GeoShapeIndexFieldData extends AbstractGeoShapeIndexFieldData {
        boolean reverse
            return load(context);
    }
        MultiValueMode sortMode,  
        @Override
        /**
        throw new IllegalArgumentException("can't sort on geo_shape field without using specific sorting feature, like geo_distance");  
    protected final String fieldName;  
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        public Builder(String name, ValuesSourceType valuesSourceType) {  
    }
import org.opensearch.common.Nullable;  
import org.apache.lucene.index.LeafReaderContext;
         * Loads the atomic field data for the reader, possibly cached.
    }  
        }  
/*  
            // filed info from the context.  
import org.opensearch.search.sort.BucketedSort;  
     * aka Doc Values from Lucene.
package org.opensearch.index.fielddata.plain;
        SortOrder sortOrder,
            super(fieldName, valuesSourceType);
