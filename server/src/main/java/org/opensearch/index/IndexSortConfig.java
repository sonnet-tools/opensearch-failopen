import org.opensearch.search.lookup.SearchLookup;
        return missing;
 * under the License.
        return new Sort(sortFields);
import org.apache.lucene.search.SortedNumericSortField;
        Function<String, MappedFieldType> fieldTypeLookup,
    private static MultiValueMode parseMultiValueMode(String value) {
            return sortField.getType();
        List<String> fields = INDEX_SORT_FIELD_SETTING.get(settings);
import org.opensearch.index.mapper.MappedFieldType;
        Setting.Property.Final
                fieldData = fieldDataLookup.apply(ft, () -> {
    /**
        Setting.Property.Final
import java.util.Collections;
 * compatible open source license.
        }
        }
        IndexSortConfig::parseMultiValueMode,
        try {
            }
 * The OpenSearch Contributors require contributions made to
     *
            if (fieldData == null) {
 *
        final Settings settings = indexSettings.getSettings();
     * Returns true if the index should be sorted
     */
        }
        String missingValue;
     */
            return SortField.Type.STRING;
            List<MultiValueMode> modes = INDEX_SORT_MODE_SETTING.get(settings);
        Setting.Property.Final
 * the Apache License, Version 2.0 (the "License"); you may
        }
    }
        }
    public static final Setting<List<MultiValueMode>> INDEX_SORT_MODE_SETTING = Setting.listSetting(
    /**
            if (shouldWidenIndexSortType == true) {
import org.opensearch.search.MultiValueMode;
 * You may obtain a copy of the License at
        Setting.Property.IndexScope,
 *
    static class FieldSortSpec {
/*
        "index.sort.missing",
        }
                "Illegal index sort mode:[" + mode + "], " + "must be one of [" + MultiValueMode.MAX + ", " + MultiValueMode.MIN + "]"
        if (hasIndexSort() == false) {
            throw new IllegalArgumentException("invalid index sort field:[" + sortField.getField() + "]");
            }
            }
        } else {
    );
 * These settings are divided in four lists that are merged during the initialization of this class:
            }
        Collections.emptyList(),
 *    http://www.apache.org/licenses/LICENSE-2.0
    public boolean hasPrimarySortOnField(String field) {
        if (INDEX_SORT_MODE_SETTING.exists(settings)) {
    }
            throw new IllegalArgumentException("Illegal sort order:" + value);
                throw new IllegalArgumentException("docvalues not found for index sort field:[" + sortSpec.field + "]");
/*
            try {
        SortField.Type.LONG,
 * specific language governing permissions and limitations
 *     <li>`index.sort.missing`: the missing value to use for the field or a list of missing values
        return sortSpecs.length > 0 && sortSpecs[0].field.equals(field);
        SortField.Type type = getSortFieldType(sortField);
        Setting.Property.Final
     */
                    throw new UnsupportedOperationException("index sorting not supported on runtime field [" + ft.name() + "]");
        Collections.emptyList(),
        if (ALLOWED_INDEX_SORT_TYPES.contains(type) == false) {
                );
            List<String> missingValues = INDEX_SORT_MISSING_SETTING.get(settings);
 * <p>
 * not use this file except in compliance with the License.
package org.opensearch.index;
            if (mode == null) {
        Collections.emptyList(),
/*
    }
 * </ul>
                    "index.sort.field:" + fields + " index.sort.missing:" + missingValues + ", size mismatch"
                mode = reverse ? MultiValueMode.MAX : MultiValueMode.MIN;
        SortOrder order;
        if ("_last".equals(missing) == false && "_first".equals(missing) == false) {
/**
        }
        final SortField[] sortFields = new SortField[sortSpecs.length];
    }
import org.opensearch.index.fielddata.IndexFieldData;
    /** We only allow index sorting on these types */
            }
     */
 */
 * <ul>
    );
        this.sortSpecs = fields.stream().map((name) -> new FieldSortSpec(name)).toArray(FieldSortSpec[]::new);
import java.util.function.Supplier;
                sortFields[i] = fieldData.wideSortField(sortSpec.missingValue, mode, null, reverse);
    public IndexSortConfig(IndexSettings indexSettings) {
                sortSpecs[i].missingValue = missingValues.get(i);
        }
        Setting.Property.IndexScope,
        return sortSpecs.length > 0;
    }
            }
 * Licensed to Elasticsearch under one or more contributor
 * KIND, either express or implied.  See the License for the
            return null;
    private static String validateMissingValue(String missing) {
        SortField.Type.STRING,
 * ownership. Elasticsearch licenses this file to you under
 *
        IndexSortConfig::validateMissingValue,
                throw new IllegalArgumentException("index.sort.field:" + fields + " index.sort.mode:" + modes + ", size mismatch");
                throw new IllegalArgumentException("docvalues not found for index sort field:[" + sortSpec.field + "]", e);
            return ((SortedNumericSortField) sortField).getNumericType();
    final FieldSortSpec[] sortSpecs;
 *     <li>`index.sort.mode`: the {@link MultiValueMode} to use for the field or a list of orders
            throw new IllegalArgumentException(
        "index.sort.mode",
     * Builds the {@link Sort} order from the settings for this index
 *     <li>`index.sort.order` the {@link SortOrder} to use for the field or a list of {@link SortOrder}
        IndexSortConfig::parseOrderMode,
            FieldSortSpec sortSpec = sortSpecs[i];
import org.apache.lucene.search.SortField;
 * SPDX-License-Identifier: Apache-2.0
            }
 * Holds all the information that is used to build the sort order of an index.
        if (sortField instanceof SortedSetSortField) {
 *
     * Field sort specification
 */
import java.util.function.Function;
 *
                });
 * The index sort settings are <b>final</b> and can be defined only at index creation.
    public static final Setting<List<SortOrder>> INDEX_SORT_ORDER_SETTING = Setting.listSetting(
            if (ft == null) {
                throw new IllegalArgumentException(
        } catch (Exception e) {
import org.opensearch.common.settings.Setting;
            } catch (Exception e) {
 *     </li>
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
                );
            for (int i = 0; i < sortSpecs.length; i++) {
    );
        }
        Collections.emptyList(),
        if (INDEX_SORT_ORDER_SETTING.exists(settings)) {
        final String field;
            }
@PublicApi(since = "1.0.0")
     * The {@link MultiValueMode} for each specified sort field (ie. <b>max</b> or <b>min</b>).
            if (modes.size() != sortSpecs.length) {
 * Modifications Copyright OpenSearch Contributors. See
    );
            }
            } else {
            throw new IllegalArgumentException("Illegal missing value:[" + missing + "], " + "must be one of [_last, _first]");
    /**
 *     </li>
    private static SortOrder parseOrderMode(String value) {
            if (orders.size() != sortSpecs.length) {
    public Sort buildIndexSort(
     * The missing value for each specified sort field (ie. <b>_first</b> or <b>_last</b>)
 * this work for additional information regarding copyright
            for (int i = 0; i < sortSpecs.length; i++) {
        Setting.Property.IndexScope,
 * GitHub history for details.
 */
    public static SortField.Type getSortFieldType(SortField sortField) {
     */
 *     <li>`index.sort.field`: the field or a list of field to use for the sort</li>
 *     </li>
import org.opensearch.common.settings.Settings;
import java.util.EnumSet;
     * @opensearch.internal
        "index.sort.order",
}
        SortField.Type.DOUBLE,
        MultiValueMode mode;
        if (INDEX_SORT_MISSING_SETTING.exists(settings)) {
     */
        SortField.Type.FLOAT
            );
        BiFunction<MappedFieldType, Supplier<SearchLookup>, IndexFieldData<?>> fieldDataLookup
    // visible for tests
        if (mode != MultiValueMode.MAX && mode != MultiValueMode.MIN) {
            this.field = field;
    }
        SortField.Type.INT,
                sortSpecs[i].mode = modes.get(i);
            }
 * Unless required by applicable law or agreed to in writing,
    private void validateIndexSortField(SortField sortField) {
    }
    public boolean hasIndexSort() {
    }
 */
            if (missingValues.size() != sortSpecs.length) {
    /**
            }
 *          for each field defined in `index.sort.field`.
            MultiValueMode mode = sortSpec.mode;
    }
import org.apache.lucene.search.SortedSetSortField;
    /**
import org.opensearch.search.sort.SortOrder;
 * @opensearch.api
        for (int i = 0; i < sortSpecs.length; i++) {
import org.apache.lucene.search.Sort;
        Function.identity(),
                    "index.sort.field:" + fields + " index.sort.order:" + orders.toString() + ", size mismatch"
            List<SortOrder> orders = INDEX_SORT_ORDER_SETTING.get(settings);
public final class IndexSortConfig {
        MultiValueMode mode = MultiValueMode.fromString(value);
 *          for each field defined in `index.sort.field`
        }
            validateIndexSortField(sortFields[i]);
    /**
    public static final Setting<List<String>> INDEX_SORT_MISSING_SETTING = Setting.listSetting(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        boolean shouldWidenIndexSortType,
            return SortOrder.fromString(value);
        FieldSortSpec(String field) {
                throw new IllegalArgumentException(
        Setting.Property.IndexScope,
    public static final Setting<List<String>> INDEX_SORT_FIELD_SETTING = Setting.listSetting(
            boolean reverse = sortSpec.order == null ? false : (sortSpec.order == SortOrder.DESC);
    }
        } else if (sortField instanceof SortedNumericSortField) {
            final MappedFieldType ft = fieldTypeLookup.apply(sortSpec.field);
     * The {@link SortOrder} for each specified sort field (ie. <b>asc</b> or <b>desc</b>).
import org.opensearch.common.annotation.PublicApi;
        "index.sort.field",
     * or returns null if this index has no sort.
 *          for each field defined in `index.sort.field`.
    );
                sortSpecs[i].order = orders.get(i);
import java.util.List;
            for (int i = 0; i < sortSpecs.length; i++) {
        }
 * this file be licensed under the Apache-2.0 license or a
        return mode;
                sortFields[i] = fieldData.sortField(sortSpec.missingValue, mode, null, reverse);
    ) {
    private static final EnumSet<SortField.Type> ALLOWED_INDEX_SORT_TYPES = EnumSet.of(
            IndexFieldData<?> fieldData;
    /**
     * The list of field names
                throw new IllegalArgumentException("unknown index sort field:[" + sortSpec.field + "]");
import java.util.function.BiFunction;
     */
