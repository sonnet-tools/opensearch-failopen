     */  
import org.apache.lucene.search.FieldComparator;
            comparator = Comparator.comparingDouble(Number::doubleValue);  
     * @param pruning controls how the comparator skips documents via {@link
                throw new UnsupportedOperationException();
                } else {  
        switch (type) {  
     * @param type     Type of values
            case DOUBLE:
     * @param reverse  True if natural order should be reversed.  
                throw new UnsupportedOperationException();  
    /**
            }
        if (type == Type.LONG) {
    }
package org.opensearch.search.sort;
            byteCounts = Double.BYTES;
     * and compare to support multi type comparison between numeric values
 */
 *
     */
     * selected.
    /**  
    public FieldComparator<?> getComparator(int numHits, Pruning pruning) {  
            @Override
            }  
            @Override
     *  
 * SPDX-License-Identifier: Apache-2.0
            public int compare(int slot1, int slot2) {  
 * @opensearch.internal  
            case FLOAT:  
import org.apache.lucene.search.Pruning;  
            case LONG:
        } else {
 * GitHub history for details.
    private final int byteCounts;  
            default:  
 * compatible open source license.
import java.io.IOException;
     * @param numHits number of top hits the queue will store  
    private final Comparator<Number> comparator;
    }
            byteCounts = Long.BYTES;
 */  
                throw new UnsupportedOperationException();
public class SortedWiderNumericSortField extends SortedNumericSortField {
        }  
 * this file be licensed under the Apache-2.0 license or a
        } else if (type == Type.DOUBLE) {
            @Override
                    if (second == null) {
/**
            case INT:
        return new NumericComparator<Number>(getField(), (Number) getMissingValue(), getReverse(), pruning, byteCounts) {
                return true;
import org.apache.lucene.util.NumericUtils;  
                if (first == null) {
                    case null -> 0L;
/*
                    } else {
                } else if (second == null) {
            }
 * The OpenSearch Contributors require contributions made to  
 *
    }  
    /**  
        };
     * @return returns true if type is supported for widened numeric comparisons
                        return 0;  
     * @param type SortField.Type
                        return -1;
     * Creates and return a comparator, which always converts Numeric to double
 * Modifications Copyright OpenSearch Contributors. See  
     */
            @Override  
import org.apache.lucene.search.comparators.NumericComparator;
                return false;
     * This will support indices having different Numeric types to be sorted together.  
 * NOTE: the unsigned_long is not supported by widening sort since the unsigned_long could not be used with other types
        // Only below 4 numeric types supported as of now for widened merge
                throw new UnsupportedOperationException();
 * Sorted numeric field for wider sort types, to help sorting two different numeric types.  
            public LeafFieldComparator getLeafComparator(LeafReaderContext context) throws IOException {
            protected long sortableBytesToLong(byte[] bytes) {
                    return comparator.compare(first, second);
     * @return NumericComparator  
}
import org.apache.lucene.search.LeafFieldComparator;
import java.util.Comparator;  
                }
                    }  
            }  
     * Creates a sort, possibly in reverse, specifying how the sort value from the document's set is
    public SortedWiderNumericSortField(String field, Type type, boolean reverse) {
                return switch (missingValue) {
                };  
     *     LeafFieldComparator#competitiveIterator()}
     * @param field    Name of field to sort by. Must not be null.
                    case Float f -> NumericUtils.floatToSortableInt(f);  
        }
     * The only below types would be considered for widening during merging topDocs results for sort,
import org.apache.lucene.search.SortedNumericSortField;
            @Override
            public Number value(int slot) {
            public int compareValues(Number first, Number second) {  
            }
            protected long missingValueAsComparableLong() {  
import org.apache.lucene.index.LeafReaderContext;  
                    return 1;
    @Override
            comparator = Comparator.comparingLong(Number::longValue);  
/*  
            }  
            throw new IllegalArgumentException("Unsupported numeric type: " + type);
                    case Double d -> NumericUtils.doubleToSortableLong(d);
    public static boolean isTypeSupported(Type type) {
            @Override  
        super(field, type, reverse);  
 */
                    case Number n -> n.longValue();
