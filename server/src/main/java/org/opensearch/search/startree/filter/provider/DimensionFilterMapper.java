    @Override
    class Factory {
            u = convertToDocValues(u);
                if (rawValue instanceof BytesRef) {
import java.util.Comparator;
     * @return :
                                : Optional.empty();
            throw new IllegalArgumentException("Expected BytesRef values for comparison");
        List<Object> convertedValues = new ArrayList<>(rawValues.size());
     * @param v1 first object
}
        }
            convertedValues.add(numberFieldType.numberType().parse(rawValue, true).longValue());
            || (lowerTermHasDecimalPart && signum(parsedLow) > 0)) {
     */
        if (!(v1 instanceof BytesRef) || !(v2 instanceof BytesRef)) {
    Number getNextHigh(Number parsedValue) {
        if (rangeQuery.from() != null) {
        try {
            parseRawField(mappedFieldType.name(), rangeQuery.from(), mappedFieldType),
            if (comparison > 0 || (comparison == 0 && !includeHigh)) {
        NumberFieldType numberFieldType = (NumberFieldType) mappedFieldType;
        for (Object rawValue : rawValues) {
            return true;
    default boolean isValidRange(Object low, Object high, boolean includeLow, boolean includeHigh) {
            LONG.typeName(),
        return Long.compare((Long) v1, (Long) v2);
        }
                    case InetAddress inetAddress -> {
    }
import org.opensearch.search.startree.filter.ExactMatchDimFilter;
            int comparison = compareValues(value, high);
import java.util.ArrayList;
        return NumericUtils.floatToSortableInt((Float) parsedValue);
            } else {
            org.opensearch.index.mapper.IpFieldMapper.CONTENT_TYPE,
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.UNSIGNED_LONG;
    @Override
}
        }
                if (DateFieldMapper.CONTENT_TYPE.equals(mappedFieldType.typeName())) {
    }
}
/**
        boolean lowerTermHasDecimalPart = hasDecimalPart(parsedLow);
                TermsEnum.SeekStatus seekStatus = termsEnum.seekCeil((BytesRef) value);
public interface DimensionFilterMapper {
    }
                            case NOT_FOUND -> Optional.of(termsEnum.ord());
        Object value,
    ) {
                        }
                // LT || LTE
    default boolean isValueInRange(Object value, Object low, Object high, boolean includeLow, boolean includeHigh) {
    Number getNextLow(Number parsedValue) {
            } else {
    }
    long convertToDocValues(Number parsedValue) {
            }
                    return new StarDateFieldMapper(searchContext);
import java.util.Map;
        String dimensionName,
    @Override
    int compareValues(Object v1, Object v2);
        Object parsedValue = null;
    @Override
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
            UNSIGNED_LONG.typeName(),
    }
            }
            return null;
            if (rangeQuery.includeLower() == false) {
     */
        }
    DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues);
                    }
import org.apache.lucene.document.FloatPoint;
    }
        return HalfFloatPoint.nextDown((Float) parsedValue);
    public Comparator<Long> comparator() {
                        if (seekStatus == TermsEnum.SeekStatus.NOT_FOUND) {
     * Generates @{@link RangeMatchDimFilter} from Range query input.
            new IntegerFieldMapperNumeric(),
    );
    @Override
        return Long.MAX_VALUE;
    }
            HALF_FLOAT.typeName(),
}
 * The OpenSearch Contributors require contributions made to
        if (low == null || high == null) {
     * @param mappedFieldType:
    @Override
class HalfFloatFieldMapperNumeric extends NumericDecimalFieldMapper {
 */
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.SHORT;
                switch (rawValue) {
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
    public DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery) {
     */
            if (parsedHigh.equals(defaultMinimum())) {
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
        }
                        throw new IllegalStateException("unexpected matchType " + matchType);
                        }
            }
    Number getNextHigh(Number parsedValue) {
class KeywordFieldMapper extends OrdinalFieldMapper {
    }
    /**
        return DoublePoint.nextUp((Double) parsedValue);
    @Override
        public static DimensionFilterMapper fromMappedFieldType(MappedFieldType mappedFieldType, SearchContext searchContext) {
    default String getSubDimensionFieldEffective(String subDimensionField1, String subDimensionField2) {
            l = convertToDocValues(l);
                    case GTE:
            rangeQuery.includeLower(),
 */
                        throw new IllegalArgumentException(
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.FLOAT;
            new SignedLongFieldMapperNumeric(),
    @Override
        }
}
    }
     * and {@link String}, converting them into a binary representation using
     * This method handles various input types, including {@link InetAddress}, {@link BytesRef},
    public DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery) {
            new KeywordFieldMapper(),
    }
class IpFieldMapper extends OrdinalFieldMapper {
            new IntegerFieldMapperNumeric(),
        Object value,
    @Override
        return FloatPoint.nextUp((Float) parsedValue);
                    case BytesRef bytesRef -> {
    }
            }
        }
class UnsignedLongFieldMapperNumeric extends NumericNonDecimalMapper {
    @Override
            INTEGER.typeName(),
            convertedValues.add(parseRawField(mappedFieldType.name(), rawValue, mappedFieldType));
    }
        Number u = Long.MAX_VALUE;
    Number getNextLow(Number parsedValue) {
    }
    Number getNextLow(Number parsedValue) {
     * @param rangeQuery:
            --parsedHigh;
    default boolean resolveUsingSubDimension() {
            : numberFieldType.numberType().parse(rangeQuery.from(), true).longValue();
}
abstract class OrdinalFieldMapper implements DimensionFilterMapper {
            ++parsedLow;
        return HalfFloatPoint.halfFloatToSortableShort((Float) parsedValue);
import org.opensearch.common.lucene.BytesRefs;
abstract class NumericNonDecimalMapper extends NumericMapper {
     * @return :
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.hasDecimalPart;
 * Generates the @{@link DimensionFilter} raw values and the @{@link MappedFieldType} of the dimension.
    public DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues) {
        NumberFieldType numberFieldType = (NumberFieldType) mappedFieldType;
    @Override
                        parsedValue = new BytesRef(InetAddressPoint.encode(inetAddress));
import org.opensearch.search.startree.filter.MatchNoneFilter;
        if (high != null) {
        return super.isValueInRange(value, low, high, includeLow, includeHigh);
            }
        return false;
import org.apache.lucene.util.NumericUtils;
        return NumericUtils.doubleToSortableLong((Double) parsedValue);
            FLOAT.typeName(),
        KeywordFieldType keywordFieldType = (KeywordFieldType) mappedFieldType;
            int comparison = compareValues(value, low);
        DimensionFilter.MatchType matchType
        }
    @Override
            throw new IllegalArgumentException("Expected Long values for unsigned comparison");
     * Singleton Factory for @{@link DimensionFilterMapper}
                        return bytesRef;
        }
@ExperimentalApi
    // TODO : Think around making TermBasedFT#indexedValueForSearch() accessor public for reuse here.
                return ordinal >= 0 ? Optional.of(ordinal) : Optional.empty();
    public DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery) {
    Long defaultMaximum() {
        int comparison = compareValues(low, high);
import org.opensearch.index.mapper.DateFieldMapper;
                        } else {
        } catch (IOException e) {
}
    }
                switch (matchType) {
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.LONG;
    @Override
                    case GT:
    abstract Long defaultMaximum();
        private static final Map<String, DimensionFilterMapper> DIMENSION_FILTER_MAPPINGS = Map.of(
        if (rawValue != null) {
        return Numbers.MIN_UNSIGNED_LONG_VALUE_AS_LONG;
            org.opensearch.index.mapper.KeywordFieldMapper.CONTENT_TYPE,
        Number l = Long.MIN_VALUE;
    @Override
    /**
    Number getNextHigh(Number parsedValue) {
import java.util.Optional;
     * @param rawValue The raw IP address value.
                return DIMENSION_FILTER_MAPPINGS.get(mappedFieldType.typeName());
            rangeQuery.includeUpper()
    }
 * objects into sortable {@link BytesRef}.
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
    }
    public Optional<Long> getMatchingOrdinal(
            SHORT.typeName(),
    Long defaultMinimum() {
    }
     */
     */
        return new RangeMatchDimFilter(mappedFieldType.name(), parsedLow, parsedHigh, true, true);
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.INTEGER;
 * filtering within a Star-Tree index. It handles the conversion of IP address
                    default -> {
    }
        if (low != null) {
        boolean upperTermHasDecimalPart = hasDecimalPart(parsedHigh);
                        );
        return Optional.of((long) value);
                            return ((termsEnum.ord() - 1) >= 0) ? Optional.of(termsEnum.ord() - 1) : Optional.empty();
    @Override
            new UnsignedLongFieldMapperNumeric(),
    }
     * @return :
            if (matchType == DimensionFilter.MatchType.EXACT) {
abstract class NumericDecimalFieldMapper extends NumericMapper {
            if (rangeQuery.includeUpper() == false) {
        if (rawValue != null) {
import org.opensearch.common.annotation.ExperimentalApi;
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.BYTE;
import java.util.List;
            }
        // Casting to long ensures that all numeric fields have been converted to equivalent long at request parsing time.
    }
    }
     * Called during conversion from parsedUserInput to segmentOrdinal for every segment.
        return ((BytesRef) v1).compareTo((BytesRef) v2);
    }
    }
 * compatible open source license.
class SignedLongFieldMapperNumeric extends NumericNonDecimalMapper {
    Long defaultMinimum() {
    default Comparator<Long> comparator() {
}
    @Override
    @Override
    }
    }
    Object parseRawField(String field, Object rawValue, MappedFieldType mappedFieldType) {
    }
    abstract long convertToDocValues(Number parsedValue);
            new HalfFloatFieldMapperNumeric(),
import java.io.IOException;
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
        long v = (Long) value;
                        return seekStatus == TermsEnum.SeekStatus.END ? Optional.empty() : Optional.of(termsEnum.ord());
            convertedValues.add(convertToDocValues(numberFieldType.numberType().parse(rawValue, true)));
     * @param field The name of the field being processed.
     * {@link InetAddressPoint#encode(InetAddress)}.
                                ? Optional.of(termsEnum.ord() + 1)
                            return Optional.of(termsEnum.ord());
                return new MatchNoneFilter();
                    }
        );
                TermsEnum termsEnum = sortedSetIterator.termsEnum();
}
        );
 *
            || (upperTermHasDecimalPart && signum(parsedHigh) < 0)) {
    }
            ? defaultMaximum()
 * This class provides functionality to map IP address values for exact and range-based
    abstract Object parseRawField(String field, Object rawValue, MappedFieldType mappedFieldType) throws IllegalArgumentException;
                    rawValue = ((BytesRef) rawValue).utf8ToString();
        return filters;
                }
 * SPDX-License-Identifier: Apache-2.0
                            case END -> Optional.empty();
        }
        return FloatPoint.nextDown((Float) parsedValue);
    DimensionFilter getRangeMatchFilter(MappedFieldType mappedFieldType, StarTreeRangeQuery rangeQuery);
            l = numberFieldType.numberType().parse(rangeQuery.from(), false);
    public DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues) {
 */
                long ordinal = sortedSetIterator.lookupTerm((BytesRef) value);
        return HalfFloatPoint.nextUp((Float) parsedValue);
    /**
        Long parsedLow = rangeQuery.from() == null
import org.apache.lucene.sandbox.document.HalfFloatPoint;
    }
        if (!(v1 instanceof Long) || !(v2 instanceof Long)) {
    ) {
    @Override
            try {
class FloatFieldMapperNumeric extends NumericDecimalFieldMapper {
        return new RangeMatchDimFilter(numberFieldType.name(), l, u, true, true);
    }
    @Override
     *
     * Default implementation for regular types.
                        };
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        List<Object> convertedValues = new ArrayList<>(rawValues.size());
    public Optional<Long> getMatchingOrdinal(
     * Parses a raw IP address value into a sortable {@link BytesRef}.
        if (rangeQuery.to() != null) {
    @Override
        // Normal case
        if (Long.compareUnsigned(l, h) > 0) {
            if (parsedLow.equals(defaultMaximum())) {
import org.opensearch.common.lucene.Lucene;
        NumberFieldType numberFieldType = (NumberFieldType) mappedFieldType;
    Long defaultMaximum() {
        }
                return false;
                throw new IllegalArgumentException("Failed to parse IP value for field [" + field + "]", e);
    /**
    }
import org.apache.lucene.document.DoublePoint;
        Object value,
        }
                }
        StarTreeValues starTreeValues,
    /**
    @Override
    Optional<Long> getMatchingOrdinal(
            }
        return Long.MIN_VALUE;
                || (Long.compareUnsigned(v, h) < 0 || (Long.compareUnsigned(v, h) == 0 && includeHigh));
    /**
            mappedFieldType.name(),
    public int compareValues(Object v1, Object v2) {
    @Override
import org.apache.lucene.util.BytesRef;
}
        String dimensionName,
        return DoublePoint.nextDown((Double) parsedValue);
}
import org.opensearch.index.mapper.MappedFieldType;
     * Generates @{@link ExactMatchDimFilter} from Term/Terms query input.
import org.apache.lucene.document.InetAddressPoint;
    }
                parsedValue = BytesRefs.toBytesRef(rawValue);
        long h = high != null ? (Long) high : -1L; // -1L is max unsigned
     */
    public int compareValues(Object v1, Object v2) {
import org.apache.lucene.index.TermsEnum;
     *
            } catch (Exception e) {
        return comparison < 0 || (comparison == 0 && includeLow && includeHigh);
    public DimensionFilter getExactMatchFilter(MappedFieldType mappedFieldType, List<Object> rawValues) {
            throw new RuntimeException(e);
                }
    @Override
     * @param starTreeValues:
            ? defaultMinimum()
}
                    case LTE:
                    case LT:
        }
            parseRawField(mappedFieldType.name(), rangeQuery.to(), mappedFieldType),
        return Long.compareUnsigned((Long) v1, (Long) v2);
        Object parsedValue = null;
/**
    long convertToDocValues(Number parsedValue) {
        return DimensionDataType.LONG::compare;
            : numberFieldType.numberType().parse(rangeQuery.to(), true).longValue();
    default List<DimensionFilter> getFinalDimensionFilters(List<DimensionFilter> filters) {
    }
     * @param value:
                        InetAddress addr = InetAddress.getByName(s);
        }
                            return Optional.of(termsEnum.ord());
                return new MatchNoneFilter();
     * @param matchType:
class DoubleFieldMapperNumeric extends NumericDecimalFieldMapper {
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.signum;
        SortedSetStarTreeValuesIterator sortedSetIterator = (SortedSetStarTreeValuesIterator) starTreeValues.getDimensionValuesIterator(
                            case FOUND -> ((termsEnum.ord() + 1) < sortedSetIterator.getValueCount())
    }
    Long defaultMaximum() {
        List<Object> convertedValues = new ArrayList<>(rawValues.size());
            new IntegerFieldMapperNumeric(),
        return parsedValue;
                    default:
                        } else {
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return DimensionDataType.UNSIGNED_LONG::compare;
abstract class NumericMapper implements DimensionFilterMapper {
    /**
        if (!(v1 instanceof Long) || !(v2 instanceof Long)) {
        StarTreeValues starTreeValues,
            }
        for (Object rawValue : rawValues) {
    abstract Long defaultMinimum();
                        parsedValue = new BytesRef(InetAddressPoint.encode(addr));
        return true;
                    }
        return (long) Integer.MIN_VALUE;
        return (long) Integer.MAX_VALUE;
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.HALF_FLOAT;
    @Override
    }
     * Compares two values of the same type.
    abstract Number getNextLow(Number parsedValue);
    Long defaultMinimum() {
                            "Unsupported value type for IP field [" + field + "]: " + rawValue.getClass().getName()
    @Override
            new DoubleFieldMapperNumeric(),
            if (comparison < 0 || (comparison == 0 && !includeLow)) {
        );
        Long parsedHigh = rangeQuery.to() == null
            DOUBLE.typeName(),
        DimensionFilter.MatchType matchType
        StarTreeValues starTreeValues,
        return parsedValue;
        for (Object rawValue : rawValues) {
            new FloatFieldMapperNumeric(),
     * @return :
     * @param v2 second object
        return new RangeMatchDimFilter(
    public boolean isValueInRange(Object value, Object low, Object high, boolean includeLow, boolean includeHigh) {
            new IpFieldMapper()
            if (keywordFieldType.getTextSearchInfo().getSearchAnalyzer() == Lucene.KEYWORD_ANALYZER) {
     * Checks if a value falls within a range.
    }
        DimensionFilter.MatchType matchType
import org.opensearch.search.startree.filter.DimensionFilter;
        return new ExactMatchDimFilter(mappedFieldType.name(), convertedValues);
                u = getNextLow(u);
    }
                l = getNextHigh(l);
                // Checking if we are in bounds for satisfying LT
                // If we found a term just greater, then return ordinal of the term just before it.
    public int compareValues(Object v1, Object v2) {
    long convertToDocValues(Number parsedValue) {
        return new ExactMatchDimFilter(mappedFieldType.name(), convertedValues);
        }
package org.opensearch.search.startree.filter.provider;
                // Checking if we are in bounds for satisfying LT
import org.opensearch.common.Numbers;
            throw new IllegalArgumentException("Expected Long values for numeric comparison");
        return null;
import java.net.InetAddress;
    }
        return Numbers.MAX_UNSIGNED_LONG_VALUE_AS_LONG;
                    }
    @Override
                    case String s -> {
                        if (seekStatus == TermsEnum.SeekStatus.END) {
        }
                parsedValue = keywordFieldType.getTextSearchInfo().getSearchAnalyzer().normalize(field, rawValue.toString());
        if ((lowerTermHasDecimalPart == false && rangeQuery.includeLower() == false)
            }
    Object parseRawField(String field, Object rawValue, MappedFieldType mappedFieldType) throws IllegalArgumentException {
}
        String dimensionName,
     * @param mappedFieldType:
            BYTE.typeName(),
            }
/*
            dimensionName
        }
            if (mappedFieldType != null) {
     * @param dimensionName:
                return false;
                // We reached the end and couldn't match anything, else we found a term which matches.
        long l = low != null ? (Long) low : 0L;
                            return ((termsEnum.ord() - 1) >= 0) ? Optional.of(termsEnum.ord() - 1) : Optional.empty();
        if ((upperTermHasDecimalPart == false && rangeQuery.includeUpper() == false)
class IntegerFieldMapperNumeric extends NumericNonDecimalMapper {
     * @return A {@link BytesRef} representation of the IP address, or null if the input is null.
            u = numberFieldType.numberType().parse(rangeQuery.to(), false);
import static org.opensearch.index.mapper.NumberFieldMapper.NumberType.DOUBLE;
    abstract Number getNextHigh(Number parsedValue);
import org.opensearch.search.internal.SearchContext;
     */
        }
                        return switch (seekStatus) {
        NumberFieldType numberFieldType = (NumberFieldType) mappedFieldType;
    @Override
            return (Long.compareUnsigned(v, l) > 0 || (Long.compareUnsigned(v, l) == 0 && includeLow))
     * @param rawValues:
        return new ExactMatchDimFilter(mappedFieldType.name(), convertedValues);
                }
