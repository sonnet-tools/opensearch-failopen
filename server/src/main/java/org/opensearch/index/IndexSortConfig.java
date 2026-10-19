            }
            for (int i = 0; i < sortSpecs.length; i++) {  
            List<SortOrder> orders = INDEX_SORT_ORDER_SETTING.get(settings);
            final MappedFieldType ft = fieldTypeLookup.apply(sortSpec.field);  
        if (sortField instanceof SortedSetSortField) {  
        Setting.Property.IndexScope,  
    // visible for tests
    }
        "index.sort.order",
    private void validateIndexSortField(SortField sortField) {  
        Collections.emptyList(),
    public static final Setting<List<SortOrder>> INDEX_SORT_ORDER_SETTING = Setting.listSetting(
import org.opensearch.common.settings.Settings;
        Setting.Property.Final
 * license agreements. See the NOTICE file distributed with
        Setting.Property.Final  
    public boolean hasIndexSort() {  
        return new Sort(sortFields);  
import org.opensearch.search.MultiValueMode;
import org.apache.lucene.search.SortedNumericSortField;  
                sortSpecs[i].mode = modes.get(i);
     */
 *  
        return sortSpecs.length > 0 && sortSpecs[0].field.equals(field);
        return sortSpecs.length > 0;
 * ownership. Elasticsearch licenses this file to you under  
    /**  
 * Holds all the information that is used to build the sort order of an index.
    public boolean hasPrimarySortOnField(String field) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
                throw new IllegalArgumentException("docvalues not found for index sort field:[" + sortSpec.field + "]", e);  
                    "index.sort.field:" + fields + " index.sort.order:" + orders.toString() + ", size mismatch"
            }  
     * The {@link SortOrder} for each specified sort field (ie. <b>asc</b> or <b>desc</b>).
        Setting.Property.Final
    public static final Setting<List<String>> INDEX_SORT_FIELD_SETTING = Setting.listSetting(
        SortField.Type.DOUBLE,
        try {  
        if (hasIndexSort() == false) {
     */
            throw new IllegalArgumentException("Illegal missing value:[" + missing + "], " + "must be one of [_last, _first]");  
            MultiValueMode mode = sortSpec.mode;
 * not use this file except in compliance with the License.
            throw new IllegalArgumentException(
    /**
        Collections.emptyList(),  
     */
        }
                "Illegal index sort mode:[" + mode + "], " + "must be one of [" + MultiValueMode.MAX + ", " + MultiValueMode.MIN + "]"
                );
 * KIND, either express or implied.  See the License for the
     * The {@link MultiValueMode} for each specified sort field (ie. <b>max</b> or <b>min</b>).
            List<String> missingValues = INDEX_SORT_MISSING_SETTING.get(settings);  
        SortOrder order;
 */  
import org.opensearch.index.fielddata.IndexFieldData;
        for (int i = 0; i < sortSpecs.length; i++) {
    }  
import java.util.function.Supplier;
    );
            }
     * Returns true if the index should be sorted
 * software distributed under the License is distributed on an
 */  
    private static SortOrder parseOrderMode(String value) {
        }  
public final class IndexSortConfig {
                sortSpecs[i].missingValue = missingValues.get(i);
    }
 * <p>
 *     <li>`index.sort.field`: the field or a list of field to use for the sort</li>  
    private static final EnumSet<SortField.Type> ALLOWED_INDEX_SORT_TYPES = EnumSet.of(  
            return sortField.getType();
        }
@PublicApi(since = "1.0.0")  
     *  
 * <ul>
    static class FieldSortSpec {  
    /**
    }
        IndexSortConfig::parseMultiValueMode,  
        }
        if (ALLOWED_INDEX_SORT_TYPES.contains(type) == false) {
                throw new IllegalArgumentException("index.sort.field:" + fields + " index.sort.mode:" + modes + ", size mismatch");
    }  
    /**
                sortFields[i] = fieldData.sortField(sortSpec.missingValue, mode, null, reverse);
    );
        final String field;
 * compatible open source license.
     * or returns null if this index has no sort.
        } catch (Exception e) {
        final SortField[] sortFields = new SortField[sortSpecs.length];  
 * the Apache License, Version 2.0 (the "License"); you may
            if (mode == null) {  
            }
        }  
            List<MultiValueMode> modes = INDEX_SORT_MODE_SETTING.get(settings);
    }
    final FieldSortSpec[] sortSpecs;  
 *     </li>  
            if (shouldWidenIndexSortType == true) {
        if ("_last".equals(missing) == false && "_first".equals(missing) == false) {
     * Field sort specification
}
 *
        return mode;
        List<String> fields = INDEX_SORT_FIELD_SETTING.get(settings);
        final Settings settings = indexSettings.getSettings();  
 *
     */
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
            for (int i = 0; i < sortSpecs.length; i++) {
    );  
        }
        this.sortSpecs = fields.stream().map((name) -> new FieldSortSpec(name)).toArray(FieldSortSpec[]::new);
/*
package org.opensearch.index;
import org.apache.lucene.search.SortField;
     */
     * The missing value for each specified sort field (ie. <b>_first</b> or <b>_last</b>)  
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup  
 * GitHub history for details.
import java.util.function.Function;  
                throw new IllegalArgumentException(
     * Builds the {@link Sort} order from the settings for this index  
     * The list of field names  
            if (fieldData == null) {
    }  
 *     <li>`index.sort.order` the {@link SortOrder} to use for the field or a list of {@link SortOrder}
    private static MultiValueMode parseMultiValueMode(String value) {
 *  
    /**
                mode = reverse ? MultiValueMode.MAX : MultiValueMode.MIN;
        } else if (sortField instanceof SortedNumericSortField) {
 * The index sort settings are <b>final</b> and can be defined only at index creation.  
 * The OpenSearch Contributors require contributions made to  
            }
        SortField.Type.LONG,
    }  
import org.opensearch.index.mapper.MappedFieldType;  
        Collections.emptyList(),
        boolean shouldWidenIndexSortType,
        SortField.Type.INT,  
    }
        SortField.Type.FLOAT
            return ((SortedNumericSortField) sortField).getNumericType();  
                    throw new UnsupportedOperationException("index sorting not supported on runtime field [" + ft.name() + "]");  
 *     <li>`index.sort.missing`: the missing value to use for the field or a list of missing values
 * These settings are divided in four lists that are merged during the initialization of this class:
            for (int i = 0; i < sortSpecs.length; i++) {  
        }
 * SPDX-License-Identifier: Apache-2.0
        IndexSortConfig::validateMissingValue,
            this.field = field;
    /**
            if (ft == null) {
     */
            if (modes.size() != sortSpecs.length) {  
 * You may obtain a copy of the License at  
        Setting.Property.IndexScope,  
 *          for each field defined in `index.sort.field`
    );
            }
        MultiValueMode mode = MultiValueMode.fromString(value);
        "index.sort.field",  
            } else {
import org.apache.lucene.search.SortedSetSortField;
            return SortField.Type.STRING;
     * @opensearch.internal
        MultiValueMode mode;  
        } else {
                sortFields[i] = fieldData.wideSortField(sortSpec.missingValue, mode, null, reverse);  
        if (INDEX_SORT_MISSING_SETTING.exists(settings)) {
import org.opensearch.common.annotation.PublicApi;
        Setting.Property.IndexScope,
 *          for each field defined in `index.sort.field`.
                fieldData = fieldDataLookup.apply(ft, () -> {
 * under the License.  
            }
        Function<String, MappedFieldType> fieldTypeLookup,
 *          for each field defined in `index.sort.field`.
    private static String validateMissingValue(String missing) {
    public static final Setting<List<MultiValueMode>> INDEX_SORT_MODE_SETTING = Setting.listSetting(  
                throw new IllegalArgumentException("docvalues not found for index sort field:[" + sortSpec.field + "]");  
import java.util.function.BiFunction;
        }  
    ) {
import java.util.EnumSet;  
        String missingValue;
            }  
 * Licensed to Elasticsearch under one or more contributor  
                throw new IllegalArgumentException("unknown index sort field:[" + sortSpec.field + "]");
                sortSpecs[i].order = orders.get(i);  
        return missing;
            return SortOrder.fromString(value);
    public Sort buildIndexSort(  
import org.opensearch.search.sort.SortOrder;  
            }
        Setting.Property.IndexScope,
        SortField.Type type = getSortFieldType(sortField);
                });
            if (missingValues.size() != sortSpecs.length) {
            }
            throw new IllegalArgumentException("Illegal sort order:" + value);  
            validateIndexSortField(sortFields[i]);
    public static SortField.Type getSortFieldType(SortField sortField) {
        if (INDEX_SORT_ORDER_SETTING.exists(settings)) {
import org.apache.lucene.search.Sort;
            return null;  
/**  
        if (INDEX_SORT_MODE_SETTING.exists(settings)) {
        Collections.emptyList(),
 */
    public static final Setting<List<String>> INDEX_SORT_MISSING_SETTING = Setting.listSetting(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;
 * Unless required by applicable law or agreed to in writing,
        }
 *     </li>  
 * </ul>
            );  
                );  
 */
 *     <li>`index.sort.mode`: the {@link MultiValueMode} to use for the field or a list of orders
            boolean reverse = sortSpec.order == null ? false : (sortSpec.order == SortOrder.DESC);
 * @opensearch.api
        Function.identity(),
                    "index.sort.field:" + fields + " index.sort.missing:" + missingValues + ", size mismatch"  
 *     </li>  
        "index.sort.mode",
            }
/*  
        "index.sort.missing",  
    /**  
     */  
        SortField.Type.STRING,
import org.opensearch.common.settings.Setting;  
    public IndexSortConfig(IndexSettings indexSettings) {
        }
                throw new IllegalArgumentException(
            try {
        if (mode != MultiValueMode.MAX && mode != MultiValueMode.MIN) {  
            IndexFieldData<?> fieldData;  
            throw new IllegalArgumentException("invalid index sort field:[" + sortField.getField() + "]");  
    /** We only allow index sorting on these types */
 * specific language governing permissions and limitations
            if (orders.size() != sortSpecs.length) {  
            } catch (Exception e) {
 *
        IndexSortConfig::parseOrderMode,
        FieldSortSpec(String field) {  
import org.opensearch.search.lookup.SearchLookup;
        Setting.Property.Final
        }
            FieldSortSpec sortSpec = sortSpecs[i];
    );  
    }
