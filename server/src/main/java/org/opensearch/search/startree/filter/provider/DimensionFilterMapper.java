import org.apache.lucene.util.NumericUtils;
    }
        return parsedValue;
    // TODO : Think around making TermBasedFT#indexedValueForSearch() accessor public for reuse here.  
        return HalfFloatPoint.nextUp((Float) parsedValue);
            || (lowerTermHasDecimalPart && signum(parsedLow) > 0)) {
    public int compareValues(Object v1, Object v2) {
import org.opensearch.index.mapper.DateFieldMapper;  
            } else {
        boolean upperTermHasDecimalPart = hasDecimalPart(parsedHigh);
                        throw new IllegalStateException("unexpected matchType " + matchType);
    }
    @Override
            }
        return FloatPoint.nextDown((Float) parsedValue);
            convertedValues.add(parseRawField(mappedFieldType.name(), rawValue, mappedFieldType));  
            return true;  
        return filters;
     * @param rawValue The raw IP address value.  
        Object parsedValue = null;
            dimensionName  
        try {
    }
            INTEGER.typeName(),
import java.util.ArrayList;  
                    case String s -> {
    @Override
    }
    abstract Number getNextHigh(Number parsedValue);  
            rangeQuery.includeLower(),
     * @param v1 first object
    /**
abstract class NumericMapper implements DimensionFilterMapper {  
package org.opensearch.search.startree.filter.provider;
import org.opensearch.index.compositeindex.datacube.DimensionDataType;  
                        parsedValue = new BytesRef(InetAddressPoint.encode(inetAddress));  
        return Long.compareUnsigned((Long) v1, (Long) v2);
                    return new StarDateFieldMapper(searchContext);
        }
     * and {@link String}, converting them into a binary representation using
        return new ExactMatchDimFilter(mappedFieldType.name(), convertedValues);
        for (Object rawValue : rawValues) {
            l = convertToDocValues(l);
class HalfFloatFieldMapperNumeric extends NumericDecimalFieldMapper {
                        if (seekStatus == TermsEnum.SeekStatus.END) {
                // We reached the end and couldn't match anything, else we found a term which matches.  
     * @param mappedFieldType:  
    /**
 */  
class IpFieldMapper extends OrdinalFieldMapper {
        String dimensionName,
                            case END -> Optional.empty();
import java.util.Map;  
                // Checking if we are in bounds for satisfying LT
        List<Object> convertedValues = new ArrayList<>(rawValues.size());  
}
            if (keywordFieldType.getTextSearchInfo().getSearchAnalyzer() == Lucene.KEYWORD_ANALYZER) {
    @Override  
        if (!(v1 instanceof Long) || !(v2 instanceof Long)) {  
import org.opensearch.search.startree.filter.DimensionFilter;
            }
 */
import java.io.IOException;
        for (Object rawValue : rawValues) {
        return FloatPoint.nextUp((Float) parsedValue);
            if (mappedFieldType != null) {  
            new IpFieldMapper()
        Object value,
    public int compareValues(Object v1, Object v2) {
    @Override
        if (!(v1 instanceof BytesRef) || !(v2 instanceof BytesRef)) {  
                l = getNextHigh(l);  
            } catch (Exception e) {  
            u = numberFieldType.numberType().parse(rangeQuery.to(), false);
     */  
import org.opensearch.common.Numbers;
    @Override
 */
    Number getNextHigh(Number parsedValue) {  
            if (matchType == DimensionFilter.MatchType.EXACT) {  
            }
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.INTEGER;
            new SignedLongFieldMapperNumeric(),
            convertedValues.add(numberFieldType.numberType().parse(rawValue, true).longValue());
        return DimensionDataType.UNSIGNED_LONG::compare;  
            u = convertToDocValues(u);  
            || (upperTermHasDecimalPart && signum(parsedHigh) < 0)) {
}  
abstract class NumericNonDecimalMapper extends NumericMapper {
        return Long.compare((Long) v1, (Long) v2);  
/*  
    @Override
                }  
                    default:
/**  
    int compareValues(Object v1, Object v2);
    long convertToDocValues(Number parsedValue) {
     * Default implementation for regular types.  
    public Optional<Long> getMatchingOrdinal(
     */
            int comparison = compareValues(value, low);
                        return switch (seekStatus) {  
        StarTreeValues starTreeValues,  
            }
     * This method handles various input types, including {@link InetAddress}, {@link BytesRef},
            parseRawField(mappedFieldType.name(), rangeQuery.from(), mappedFieldType),  
                }  
    public DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery) {
        if (Long.compareUnsigned(l, h) > 0) {
abstract class NumericDecimalFieldMapper extends NumericMapper {
     */
    public DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues) {
            throw new IllegalArgumentException("Expected Long values for numeric comparison");
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.SHORT;  
        long h = high != null ? (Long) high : -1L; // -1L is max unsigned  
import java.util.List;
    long convertToDocValues(Number parsedValue) {  
                                ? Optional.of(termsEnum.ord() + 1)  
        }
                }
        return DimensionDataType.LONG::compare;
    Optional<Long> getMatchingOrdinal(
        return Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG;
        long l = low != null ? (Long) low : 0L;
    Long defaultMinimum() {
     * @param dimensionName:
}
    Number getNextHigh(Number parsedValue) {
     */
     * @return :
            }
    public Comparator<Long> comparator() {
            l = numberFieldType.numberType().parse(rangeQuery.from(), false);
            }
        );  
    /**
        }
        long v = (Long) value;
    @Override  
    @Override
 *
            throw new IllegalArgumentException("Expected Long values for unsigned comparison");  
                        throw new IllegalArgumentException(
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;  
    }  
    }  
                parsedValue = keywordFieldType.getTextSearchInfo().getSearchAnalyzer().normalize(field, rawValue.toString());
        return Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG;
                if (DateFieldMapper.CONTENT_TYPE.equals(mappedFieldType.typeName())) {
        return false;
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.hasDecimalPart;
            if (parsedHigh.equals(defaultMinimum())) {
     * Singleton Factory for @{@link DimensionFilterMapper}
            mappedFieldType.name(),
    default boolean isValueInRange(Object value, Object low, Object high, boolean includeLow, boolean includeHigh) {
            BYTE.typeName(),
                        } else {
    Long defaultMaximum() {
                TermsEnum.SeekStatus seekStatus = termsEnum.seekCeil((BytesRef) value);
        private static final Map<String, DimensionFilterMapper> DIMENSION_FILTER_MAPPINGS = Map.of(  
    @Override  
        String dimensionName,
                // LT || LTE
}
            parseRawField(mappedFieldType.name(), rangeQuery.to(), mappedFieldType),
    DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery);  
    abstract Number getNextLow(Number parsedValue);
        }
        if (rangeQuery.to() != null) {
    ) {
                    case LTE:
    abstract Long defaultMinimum();
                // Checking if we are in bounds for satisfying LT  
class KeywordFieldMapper extends OrdinalFieldMapper {
    }
    @Override
        }
    }
     */  
    public DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues) {
 * objects into sortable {@link BytesRef}.  
            DOUBLE.typeName(),
import org.apache.lucene.util.BytesRef;  
        if (rawValue != null) {
        Long parsedLow = rangeQuery.from() == null
                    default -> {  
        Object value,  
import org.opensearch.common.lucene.BytesRefs;
}
        return true;
import org.opensearch.common.annotation.ExperimentalApi;  
     * @return :  
        Long parsedHigh = rangeQuery.to() == null
        return new RangeMatchDimFilter(numberFieldType.name(), l, u, true, true);
import org.apache.lucene.sandbox.document.HalfFloatPoint;
     *  
import org.opensearch.search.startree.filter.ExactMatchDimFilter;  
        StarTreeValues starTreeValues,
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
    long convertToDocValues(Number parsedValue) {
        DimensionFilter.MatchType matchType
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.HALF_FLOAT;  
                    }
        // Normal case
            try {  
        if (high != null) {
    }
    @Override
     * @return :
                return new MatchNoneFilter();
    Number getNextHigh(Number parsedValue) {
 * this file be licensed under the Apache-2.0 license or a
                            return Optional.of(termsEnum.ord());
    Object parseRawField(String field, Object rawValue, MappedFieldType mappedFieldType) {
        } catch (IOException e) {
import org.opensearch.index.mapper.MappedFieldType;
     * @param v2 second object
            LONG.typeName(),
            }
                return false;  
 * SPDX-License-Identifier: Apache-2.0
        DimensionFilter.MatchType matchType  
        return null;  
            new IntegerFieldMapperNumeric(),
        );
                            return ((termsEnum.ord() - 1) >= 0) ? Optional.of(termsEnum.ord() - 1) : Optional.empty();  
@ExperimentalApi
                u = getNextLow(u);
    @Override
     * @return :
        Object value,
    default Comparator<Long> comparator() {  
    /**
        NumberFieldType numberFieldType = (NumberFieldType) mappedFieldType;
    );  
                    }
        }
        Object parsedValue = null;  
        }  
            : numberFieldType.numberType().parse(rangeQuery.to(), true).longValue();
class SignedLongFieldMapperNumeric extends NumericNonDecimalMapper {
     * Parses a raw IP address value into a sortable {@link BytesRef}.
                        } else {
    }  
            int comparison = compareValues(value, high);
    @Override
class FloatFieldMapperNumeric extends NumericDecimalFieldMapper {  
                long ordinal = sortedSetIterator.lookupTerm((BytesRef) value);
    @Override
            new IntegerFieldMapperNumeric(),
        return new RangeMatchDimFilter(
    }  
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.FLOAT;
    }  
    }
    @Override  
            SHORT.typeName(),  
     * @param matchType:
        for (Object rawValue : rawValues) {
        return parsedValue;
    }
                parsedValue = BytesRefs.toBytesRef(rawValue);  
    @Override
    ) {
    abstract long convertToDocValues(Number parsedValue);
        Number l = Long.MIN_VALUE;
            UNSIGNED_LONG.typeName(),
        }  
        return new ExactMatchDimFilter(mappedFieldType.name(), convertedValues);
                        }  
import java.util.Optional;
                        }  
    public boolean isValueInRange(Object value, Object low, Object high, boolean includeLow, boolean includeHigh) {  
            throw new RuntimeException(e);  
    class Factory {
        }
                if (rawValue instanceof BytesRef) {
        if ((upperTermHasDecimalPart == false && rangeQuery.includeUpper() == false)  
        if (rangeQuery.from() != null) {  
}
            HALF_FLOAT.typeName(),  
    }
                        return seekStatus == TermsEnum.SeekStatus.END ? Optional.empty() : Optional.of(termsEnum.ord());
     * @param mappedFieldType:
                TermsEnum termsEnum = sortedSetIterator.termsEnum();
}
    Long defaultMaximum() {
            throw new IllegalArgumentException("Expected BytesRef values for comparison");
                    case GTE:  
        int comparison = compareValues(low, high);
    }  
        boolean lowerTermHasDecimalPart = hasDecimalPart(parsedLow);  
        if (low == null || high == null) {
}
 * filtering within a Star-Tree index. It handles the conversion of IP address
     * @param starTreeValues:  
    default boolean resolveUsingSubDimension() {
            FLOAT.typeName(),
        return HalfFloatPoint.halfFloatToSortableShort((Float) parsedValue);
            new FloatFieldMapperNumeric(),  
 * The OpenSearch Contributors require contributions made to  
        List<Object> convertedValues = new ArrayList<>(rawValues.size());
    abstract Long defaultMaximum();  
    Number getNextLow(Number parsedValue) {  
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.BYTE;  
            ? defaultMaximum()  
import org.opensearch.common.lucene.Lucene;
}
        if (rawValue != null) {
                throw new IllegalArgumentException("Failed to parse IP value for field [" + field + "]", e);
                    }
import org.apache.lucene.document.FloatPoint;
    public Optional<Long> getMatchingOrdinal(  
    }
    @Override
        }
        if (!(v1 instanceof Long) || !(v2 instanceof Long)) {
    }
                            case NOT_FOUND -> Optional.of(termsEnum.ord());
            ++parsedLow;  
    default String getSubDimensionFieldEffective(String subDimensionField1, String subDimensionField2) {
        }  
        List<Object> convertedValues = new ArrayList<>(rawValues.size());  
                        };  
                    }
import org.opensearch.search.startree.filter.MatchNoneFilter;
            convertedValues.add(convertToDocValues(numberFieldType.numberType().parse(rawValue, true)));
                        parsedValue = new BytesRef(InetAddressPoint.encode(addr));
}
    @Override
    }  
     * @param value:
    }
 * This class provides functionality to map IP address values for exact and range-based
            if (comparison > 0 || (comparison == 0 && !includeHigh)) {  
            if (parsedLow.equals(defaultMaximum())) {  
    public DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery) {  
                    case InetAddress inetAddress -> {
        SortedSetStarTreeValuesIterator sortedSetIterator = (SortedSetStarTreeValuesIterator) starTreeValues.getDimensionValuesIterator(
import java.util.Comparator;
        return (long) Integer.MAX_VALUE;  
        if (low != null) {  
                    case LT:
        NumberFieldType numberFieldType = (NumberFieldType) mappedFieldType;  
     */
    @Override
     * Generates @{@link RangeMatchDimFilter} from Range query input.
                            return Optional.of(termsEnum.ord());  
            new DoubleFieldMapperNumeric(),
    }
            if (rangeQuery.includeLower() == false) {
        return new ExactMatchDimFilter(mappedFieldType.name(), convertedValues);
     * Checks if a value falls within a range.
    DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues);
                        InetAddress addr = InetAddress.getByName(s);  
    }
     * Called during conversion from parsedUserInput to segmentOrdinal for every segment.  
                        );  
    @Override
                    rawValue = ((BytesRef) rawValue).utf8ToString();  
}
            }
    @Override
        }  
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
    }
        }  
            --parsedHigh;
     */  
import java.net.InetAddress;
            org.opensearch.index.mapper.IpFieldMapper.CONTENT_TYPE,
            rangeQuery.includeUpper()  
                return false;
    }  
     * @param rangeQuery:  
    public int compareValues(Object v1, Object v2) {
        return super.isValueInRange(value, low, high, includeLow, includeHigh);
        Number u = Long.MAX_VALUE;
    Number getNextLow(Number parsedValue) {
                        if (seekStatus == TermsEnum.SeekStatus.NOT_FOUND) {
            return null;  
        // Casting to long ensures that all numeric fields have been converted to equivalent long at request parsing time.  
                                : Optional.empty();
        return new RangeMatchDimFilter(mappedFieldType.name(), parsedLow, parsedHigh, true, true);
        return ((BytesRef) v1).compareTo((BytesRef) v2);  
            }  
            ? defaultMinimum()  
                return new MatchNoneFilter();  
    Long defaultMinimum() {  
/**
        return comparison < 0 || (comparison == 0 && includeLow && includeHigh);  
        return NumericUtils.doubleToSortableLong((Double) parsedValue);
abstract class OrdinalFieldMapper implements DimensionFilterMapper {
        NumberFieldType numberFieldType = (NumberFieldType) mappedFieldType;  
        public static DimensionFilterMapper fromMappedFieldType(MappedFieldType mappedFieldType, SearchContext searchContext) {
    public DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues) {  
    Number getNextLow(Number parsedValue) {
    /**
                            return ((termsEnum.ord() - 1) >= 0) ? Optional.of(termsEnum.ord() - 1) : Optional.empty();
            org.opensearch.index.mapper.KeywordFieldMapper.CONTENT_TYPE,  
                            case FOUND -> ((termsEnum.ord() + 1) < sortedSetIterator.getValueCount())
    }
    abstract Object parseRawField(String field, Object rawValue, MappedFieldType mappedFieldType) throws IllegalArgumentException;  
    @Override
    @Override
    }
        return DoublePoint.nextUp((Double) parsedValue);  
                }
                        return bytesRef;  
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.signum;  
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.UNSIGNED_LONG;
    @Override
            return (Long.compareUnsigned(v, l) > 0 || (Long.compareUnsigned(v, l) == 0 && includeLow))  
            }
        if ((lowerTermHasDecimalPart == false && rangeQuery.includeLower() == false)
                switch (matchType) {
class DoubleFieldMapperNumeric extends NumericDecimalFieldMapper {
        }
}
    @Override  
import org.apache.lucene.index.TermsEnum;
    }
                || (Long.compareUnsigned(v, h) < 0 || (Long.compareUnsigned(v, h) == 0 && includeHigh));
            new KeywordFieldMapper(),
            : numberFieldType.numberType().parse(rangeQuery.from(), true).longValue();
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
     * Generates @{@link ExactMatchDimFilter} from Term/Terms query input.
public interface DimensionFilterMapper {  
        return Long.MAX_VALUE;  
    default boolean isValidRange(Object low, Object high, boolean includeLow, boolean includeHigh) {
        return Optional.of((long) value);
            if (comparison < 0 || (comparison == 0 && !includeLow)) {
        }
        StarTreeValues starTreeValues,
    public DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery) {
    }
    }
     * @param rawValues:
                            "Unsupported value type for IP field [" + field + "]: " + rawValue.getClass().getName()
            if (rangeQuery.includeUpper() == false) {  
    @Override  
        return NumericUtils.floatToSortableInt((Float) parsedValue);  
    Long defaultMinimum() {  
                switch (rawValue) {
        return Long.MIN_VALUE;
                // If we found a term just greater, then return ordinal of the term just before it.
        NumberFieldType numberFieldType = (NumberFieldType) mappedFieldType;
    }
            new IntegerFieldMapperNumeric(),  
        }
                return DIMENSION_FILTER_MAPPINGS.get(mappedFieldType.typeName());
    }
        return (long) Integer.MIN_VALUE;
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
        DimensionFilter.MatchType matchType
        KeywordFieldType keywordFieldType = (KeywordFieldType) mappedFieldType;
 * Generates the @{@link DimensionFilter} raw values and the @{@link MappedFieldType} of the dimension.  
        }
    }
    }
    Long defaultMaximum() {  
     * @return A {@link BytesRef} representation of the IP address, or null if the input is null.
    }
class UnsignedLongFieldMapperNumeric extends NumericNonDecimalMapper {
            } else {  
import org.apache.lucene.document.DoublePoint;
                return ordinal >= 0 ? Optional.of(ordinal) : Optional.empty();
     * @param field The name of the field being processed.
     * {@link InetAddressPoint#encode(InetAddress)}.  
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
    }  
}  
     *
    /**  
class IntegerFieldMapperNumeric extends NumericNonDecimalMapper {
import org.apache.lucene.document.InetAddressPoint;  
    }  
    }
        return DoublePoint.nextDown((Double) parsedValue);
 * compatible open source license.
    Object parseRawField(String field, Object rawValue, MappedFieldType mappedFieldType) throws IllegalArgumentException {  
    /**
    default List<DimensionFilter> getFinalDimensionFilters(List<DimensionFilter> filters) {  
        return HalfFloatPoint.nextDown((Float) parsedValue);  
            new UnsignedLongFieldMapperNumeric(),  
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;
     * Compares two values of the same type.  
                    case GT:
            new HalfFloatFieldMapperNumeric(),
    @Override
import org.opensearch.search.internal.SearchContext;
                    case BytesRef bytesRef -> {
        String dimensionName,  
        }  
    @Override  
        );
