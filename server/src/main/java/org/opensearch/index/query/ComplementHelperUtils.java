            if (lastValue != null) {  
                }  
     */  
 * SPDX-License-Identifier: Apache-2.0
        Number lastValue = null;
     * Returns a list of 2 RangeQueryBuilders matching everything but value.
package org.opensearch.index.query;
        return nft;  
        aboveRange.from(value);
        lastRange.from(sortedValues.get(sortedValues.size() - 1));  
 */  
        RangeQueryBuilder belowRange = new RangeQueryBuilder(fieldName);
                // If this is a whole number field and the last value is 1 less than the current value, we can skip this part of the
        for (Number value : sortedValues) {
                if (isWholeNumber && value.longValue() - lastValue.longValue() == 1) {  
        aboveRange.includeLower(false);  
/**
        return complement;
    public static NumberFieldMapper.NumberFieldType getNumberFieldType(QueryShardContext context, String fieldName) {
    public static List<QueryBuilder> numberValuesToComplement(String fieldName, List<Number> sortedValues, boolean isWholeNumber) {
        return complement;
    /**
 * this file be licensed under the Apache-2.0 license or a
                // complement
     * the complement since no value could match it.
/*  
    /**  
        complement.add(lastRange);  
        complement.add(aboveRange);
 * The OpenSearch Contributors require contributions made to  
        if (!(fieldType instanceof NumberFieldMapper.NumberFieldType nft)) return null;
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        lastRange.includeLower(false);
     */
        lastRange.includeUpper(true);
        if (sortedValues.isEmpty()) return null;
            range.to(value);
                    continue;
 */  
     * Get the NumberFieldType for this fieldName from the context, or null if it isn't a NumberFieldType.  
     * if isWholeNumber == true, and two sorted values are off by 1, the range between the two of them won't appear in
        // Finally add the last range query
            }  
 *
                range.from(lastValue);
            range.includeUpper(false);
 * A class with helper functions to construct complements for some queries.
import org.opensearch.index.mapper.NumberFieldMapper;
}  
     */
import java.util.List;
    /**
        RangeQueryBuilder lastRange = new RangeQueryBuilder(fieldName);
        belowRange.includeUpper(false);
 * compatible open source license.
            lastValue = value;
        if (context == null) return null;  
        RangeQueryBuilder aboveRange = new RangeQueryBuilder(fieldName);
import java.util.ArrayList;
                range.includeLower(false);
    }
        }  
            complement.add(range);
        complement.add(belowRange);
    }
        belowRange.to(value);  
import org.opensearch.index.mapper.MappedFieldType;
     * Returns a list of RangeQueryBuilders matching everything except the provided sorted values.  
public class ComplementHelperUtils {
        List<QueryBuilder> complement = new ArrayList<>();
    public static List<QueryBuilder> numberValueToComplement(String fieldName, Number value) {  
    }  
            RangeQueryBuilder range = new RangeQueryBuilder(fieldName);  
        List<QueryBuilder> complement = new ArrayList<>();  
                    lastValue = value;
