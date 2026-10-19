    );  
        Arrays.asList(Rounding.DateTimeUnit.MINUTES_OF_HOUR.shortName(), DataCubeDateTimeUnit.HALF_HOUR_OF_DAY.shortName()),
     * star tree field, we will generate associated star tree index.
        StarTreeIndexSettings::getTimeUnit,  
     * This setting determines the max number of dimensions that can be part of star tree index field. Number of
     * @opensearch.experimental
        "index.composite_index.star_tree.field.default.date_intervals",
        Function.identity(),
        Setting.Property.IndexScope,  
    );
     * star tree index size. Lesser the leaves, better the query latency but higher storage size and vice versa
            return new DateTimeUnitAdapter(DateHistogramAggregationBuilder.DATE_FIELD_UNITS.get(expression));  
     */
     * This setting configures the default "maxLeafDocs" setting of star tree. This affects both query performance and  
     * This setting determines the max number of star tree fields that can be part of composite index mapping. For each  
 *
}
     */  
        STAR_TREE_MAX_DIMENSIONS_DEFAULT,  
        Arrays.asList(MetricStat.VALUE_COUNT.toString(), MetricStat.SUM.toString()),
        Setting.Property.IndexScope,
        Setting.Property.Dynamic  
    }
        Setting.Property.IndexScope,
        Setting.Property.IndexScope,
        100,  
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
    );
     * This setting determines the max number of date intervals that can be part of star tree date field.  
        Setting.Property.IndexScope,  
        Setting.Property.IndexScope,
    public static final Setting<Integer> STAR_TREE_MAX_DATE_INTERVALS_SETTING = Setting.intSetting(
        10000,  
 * there is no support for update of star tree mapping.  
        "index.composite_index.star_tree.field.max_base_metrics",  
    /**
    );
        Setting.Property.Final
        Setting.Property.Final
package org.opensearch.index.compositeindex.datacube.startree;
        "index.composite_index.star_tree.default.max_leaf_docs",
    public static int STAR_TREE_MAX_DIMENSIONS_DEFAULT = 10;  
        3,
 * this file be licensed under the Apache-2.0 license or a
     * We can remove this later or change it to an enum based constant setting.  
        "index.search.star_tree_index.enabled",  
        "index.composite_index",
        2,
        1,  
            return DataCubeDateTimeUnit.DATE_FIELD_UNITS.get(expression);
    public static final Setting<Integer> STAR_TREE_DEFAULT_MAX_LEAF_DOCS = Setting.intSetting(
        1,
    /**
        Setting.Property.IndexScope,
        "index.composite_index.star_tree.max_fields",
    /**  
 * Index settings for star tree fields. The settings are final as right now
 *
import java.util.function.Function;
     * This setting determines the max number of dimensions that can be part of star tree index field. Number of
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
 */  
import org.opensearch.index.compositeindex.datacube.DataCubeDateTimeUnit;  
        Setting.Property.Final
    /**  
        "index.composite_index.star_tree.field.max_dimensions",
        4,
     */
    );  
        false,  
        Setting.Property.Final
    public static final Setting<Boolean> IS_COMPOSITE_INDEX_SETTING = Setting.boolSetting(
    public static int STAR_TREE_MAX_BASE_METRICS_DEFAULT = 100;
     * dimensions and associated cardinality has direct effect of star tree index size and query performance.  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        1,
import org.opensearch.index.compositeindex.datacube.MetricStat;
    );
import org.opensearch.common.Rounding;
        "index.composite_index.star_tree.field.max_date_intervals",  
     * Default metrics for metrics as part of star tree fields  
     */
        Setting.Property.Final  
    );
     * <p>
 * @opensearch.experimental
    public static final Setting<Boolean> STAR_TREE_SEARCH_ENABLED_SETTING = Setting.boolSetting(
        3,  
        Setting.Property.IndexScope,
        }  
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;  
        1,
        true,
        Setting.Property.Final  
     * dimensions and associated cardinality has direct effect of star tree index size and query performance.
        "index.composite_index.star_tree.field.default.metrics",  
import java.util.Arrays;  
 */  
    );  
     *
     */  
        Setting.Property.Final
import java.util.List;
    public static final Setting<Integer> STAR_TREE_MAX_DIMENSIONS_SETTING = Setting.intSetting(
    public static DateTimeUnitRounding getTimeUnit(String expression) {
        if (DateHistogramAggregationBuilder.DATE_FIELD_UNITS.containsKey(expression)) {
 * The OpenSearch Contributors require contributions made to  
    /**
    );  
/**
/*  
     */
        Setting.Property.IndexScope,
        } else if (DataCubeDateTimeUnit.DATE_FIELD_UNITS.containsKey(expression)) {
     */
        STAR_TREE_MAX_BASE_METRICS_DEFAULT,
    public static final Setting<Integer> STAR_TREE_MAX_FIELDS_SETTING = Setting.intSetting(  
        Setting.Property.Final
     * Default intervals for date dimension as part of star tree fields
    /**
        1,
public class StarTreeIndexSettings {
        throw new IllegalArgumentException("unknown calendar intervals specified in star tree index mapping");
    /**
        10,
    public static final Setting<Integer> STAR_TREE_MAX_BASE_METRICS_SETTING = Setting.intSetting(
import org.opensearch.common.settings.Setting;
    public static final Setting<List<String>> DEFAULT_METRICS_LIST = Setting.listSetting(
    public static final Setting<List<DateTimeUnitRounding>> DEFAULT_DATE_INTERVALS = Setting.listSetting(  
