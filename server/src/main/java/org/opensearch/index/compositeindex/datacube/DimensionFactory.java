            case NUMERIC:
    }  
                return parseAndCreateDateDimension(name, dimensionMap, c);
            case ORDINAL:  
                String.format(Locale.ROOT, "unsupported field type associated with star tree dimension [%s]", name)
    }
public class DimensionFactory {
            .stream()  
            }
@ExperimentalApi
import java.util.stream.Collectors;
                calendarIntervals.add(StarTreeIndexSettings.getTimeUnit(interval));  
            calendarIntervals = new LinkedHashSet<>(StarTreeIndexSettings.DEFAULT_DATE_INTERVALS.get(c.getSettings()));
    ) {
                    String.format(
                    )
            case ORDINAL:
                throw new IllegalArgumentException(
        Set<DateTimeUnitRounding> calendarIntervals;
            case IP:  
                );
                );
        Mapper.TypeParser.ParserContext c
                return new UnsignedLongDimension(name);
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.Map;  
            default:
        }
            case UnsignedLongDimension.UNSIGNED_LONG:
        dimensionMap.remove(CALENDAR_INTERVALS);  
            .map(Object::toString)
        switch (type) {  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeIndexSettings;  
                throw new IllegalArgumentException(  
                return new IpDimension(name);  
        Mapper.Builder builder,
 * Dimension factory class mainly used to parse and create dimension from the mappings  
            throw new IllegalArgumentException(
        }  
                        StarTreeIndexSettings.STAR_TREE_MAX_DATE_INTERVALS_SETTING.get(c.getSettings()),
package org.opensearch.index.compositeindex.datacube;
                        name  
import org.opensearch.index.mapper.DateFieldMapper;
}
                return new NumericDimension(name);  
import java.util.LinkedHashSet;  
                return new UnsignedLongDimension(name);  
            for (String interval : intervalStrings) {
    ) {
                    String.format(Locale.ROOT, "unsupported field type associated with dimension [%s] as part of star tree field", name)
                return new IpDimension(name);
 * @opensearch.experimental
                        "At most [%s] calendar intervals are allowed in dimension [%s]",
        }
    }
 */  
 * compatible open source license.
 *
            case UNSIGNED_LONG:
                return new OrdinalDimension(name);
        if (builder.getSupportedDataCubeDimensionType().isEmpty()) {  
 *
        return new DateDimension(name, new ArrayList<>(calendarIntervals), resolution);  
 * this file be licensed under the Apache-2.0 license or a
            resolution = ((DateFieldMapper.DateFieldType) c.mapperService().fieldType(name)).resolution();  
        if (c != null && c.mapperService() != null && c.mapperService().fieldType(name) != null) {
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
            }  
        Map<String, Object> dimensionMap,  
        }
                return parseAndCreateDateDimension(name, dimensionMap, c);
        String type,
import org.opensearch.index.mapper.Mapper;  
    ) {  
                        Locale.ROOT,  
            default:
                return new NumericDimension(name);
import java.util.ArrayList;
                    String.format(Locale.ROOT, "unsupported field type associated with star tree dimension [%s]", name)  
import static org.opensearch.index.compositeindex.datacube.DateDimension.CALENDAR_INTERVALS;
        String name,  
    public static Dimension parseAndCreateDimension(  
                return new OrdinalDimension(name);
            if (intervalStrings.size() > StarTreeIndexSettings.STAR_TREE_MAX_DATE_INTERVALS_SETTING.get(c.getSettings())) {  
/*  
    public static Dimension parseAndCreateDimension(  
        DateFieldMapper.Resolution resolution = null;
/**
    private static DateDimension parseAndCreateDateDimension(
        String name,
        String name,
                throw new IllegalArgumentException(
            case NumericDimension.NUMERIC:  
                );
import org.opensearch.common.xcontent.support.XContentMapValues;
            case IP:
import static org.opensearch.index.compositeindex.datacube.OrdinalDimension.ORDINAL;  
        if (intervalStrings == null || intervalStrings.isEmpty()) {  
        Mapper.TypeParser.ParserContext c
import java.util.Set;
        Map<String, Object> dimensionMap,
import java.util.List;
        List<String> intervalStrings = XContentMapValues.extractRawValues(CALENDAR_INTERVALS, dimensionMap)
 */  
            );  
        Mapper.TypeParser.ParserContext c
            case DATE:  
import static org.opensearch.index.compositeindex.datacube.IpDimension.IP;
        }
        Map<String, Object> dimensionMap,  
import java.util.Locale;
            case DateDimension.DATE:
            .collect(Collectors.toList());
        switch (builder.getSupportedDataCubeDimensionType().get()) {
 * The OpenSearch Contributors require contributions made to  
            calendarIntervals = new LinkedHashSet<>();
        } else {
 * SPDX-License-Identifier: Apache-2.0
