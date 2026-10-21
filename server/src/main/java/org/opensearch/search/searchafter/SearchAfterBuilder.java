        return Objects.hash(this.sortValues);
        for (Object fieldValue : sortValues) {
import org.apache.lucene.search.FieldDoc;
 * license agreements. See the NOTICE file distributed with
    }
            return SortField.Type.LONG;
import org.opensearch.core.common.ParsingException;
    }
                    if (value instanceof Number) {
    }
                    + XContentParser.Token.START_ARRAY
/**
/*
                e
 */
                            break;
            if (values[i] instanceof Long) continue;
                            break;
     * Read from a stream.
            }
        if (sortFields.length != values.length) {
                    if (value instanceof Number) {
                    return format.parseBytesRef(value.toString());
                            values.add(parser.longValue());
            throw new IllegalArgumentException("Can't handle " + SEARCH_AFTER + " field value of type [" + values[i].getClass() + "]");
     * Returns the inner {@link SortField.Type} expected for this sort field.
        if (values == null) {
        }
                        return format.parseUnsignedLong(value.toString(), false, () -> {
    void innerToXContent(XContentBuilder builder) throws IOException {
        }
                    return Double.parseDouble(value.toString());
                } else if (token == XContentParser.Token.VALUE_NULL) {
                    + "] in ["
 * Unless required by applicable law or agreed to in writing,
 * Builds a search after object
    static SortField.Type extractSortType(SortField sortField) {
            return SortField.Type.STRING;
                case LONG:
                        return ((Number) value).doubleValue();
                            + XContentParser.Token.VALUE_STRING
        } else if (sortField.getComparatorSource() instanceof ShardDocFieldComparatorSource) {
    public static SearchAfterBuilder fromXContent(XContentParser parser) throws IOException {
        if (values.length == 0) {
        if (sort == null || sort.sort.getSort() == null || sort.sort.getSort().length == 0) {
    @Override
    public int hashCode() {
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
    /**
import org.opensearch.common.xcontent.XContentFactory;
import org.opensearch.search.sort.SortAndFormats;
        Object[] fieldValues = new Object[sortFields.length];
/*
                        false,
        return builder;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ToXContentObject;
    public Object[] getSortValues() {
                            + "] or ["
        /*
                            + XContentParser.Token.VALUE_NULL
                    return Float.parseFloat(value.toString());
 * this file be licensed under the Apache-2.0 license or a
    public SearchAfterBuilder(StreamInput in) throws IOException {
import org.opensearch.core.common.text.Text;
                } else {
import org.opensearch.core.common.io.stream.Writeable;
    public static final ParseField SEARCH_AFTER = new ParseField("search_after");
    /**
import java.math.BigInteger;
    public SearchAfterBuilder setSortValues(Object[] values) {
 * compatible open source license.
import java.util.Objects;
                    );
                    values.add(parser.text());
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        return Arrays.copyOf(sortValues, sortValues.length);
                case STRING_VAL:
                    return Float.parseFloat(value.toString());
 * specific language governing permissions and limitations
        } else {
        }
        sortValues = new Object[size];
                            break;
    @Override
    }
    private Object[] sortValues = EMPTY_SORT_VALUES;
        } else {
                    throw new IllegalArgumentException(
    }
    public static FieldDoc buildFieldDoc(SortAndFormats sort, Object[] values) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    } else if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED || format == DocValueFormat.UNSIGNED_LONG) {
            if (values[i] instanceof Text) continue;
            throw new OpenSearchException("Failed to build xcontent.", e);
                    + token
 * KIND, either express or implied.  See the License for the
        try {
                    + SEARCH_AFTER.getPreferredName()
 * software distributed under the License is distributed on an
                        return ((Number) value).longValue();
 * ownership. Elasticsearch licenses this file to you under
        return convertValueFromSortType(sortField.getField(), sortType, value, format);
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        return Arrays.equals(sortValues, ((SearchAfterBuilder) other).sortValues);
        sortValues = new Object[values.length];
 */
                        && (format != DocValueFormat.UNSIGNED_LONG_SHIFTED && format != DocValueFormat.UNSIGNED_LONG)) {
import org.apache.lucene.search.SortedNumericSortField;
 */
            return false;
            builder.prettyPrint();
/*
                    }
    }
import org.opensearch.core.xcontent.XContentBuilder;
 * under the License.
    }
    private static Object convertValueFromSortType(String fieldName, SortField.Type sortType, Object value, DocValueFormat format) {
import org.opensearch.core.ParseField;
        }
        }
 *
 *
        } catch (NumberFormatException e) {
 *
    }
 * Modifications Copyright OpenSearch Contributors. See
        XContentParser.Token token = parser.currentToken();
 * The OpenSearch Contributors require contributions made to
    static Object convertValueFromSortField(Object value, SortField sortField, DocValueFormat format) {
        int size = in.readVInt();
                    // for unsigned_long field type we want to pass search_after value through formatting
            // for geo distance sorting
        }
                    );
                        return ((Number) value).intValue();
                            );
        innerToXContent(builder);
                        case BIG_INTEGER:
import org.opensearch.core.xcontent.XContentParser;
                        case FLOAT:
    public SearchAfterBuilder() {}
                case STRING:
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.List;
 */
        SortField[] sortFields = sort.sort.getSort();
    private static final Object[] EMPTY_SORT_VALUES = new Object[0];
                            + "] or ["
        }
                        () -> { throw new IllegalStateException("now() is not allowed in [search_after] key"); }
                case DOUBLE:
                        return ((Number) value).floatValue();
                            throw new IllegalStateException("now() is not allowed in [search_after] key");
                    }
     */
        System.arraycopy(values, 0, sortValues, 0, values.length);
        }
                            values.add(parser.text());
import java.util.ArrayList;
                case DOC:
                    );
                    if (value instanceof Number
                SEARCH_AFTER.getPreferredName() + " has " + values.length + " value(s) but sort has " + sort.sort.getSort().length + "."
            if (values[i] instanceof Short) continue;
         * We set the doc id to Integer.MAX_VALUE in order to make sure that the search starts "after" the first document that is equal to
        SearchAfterBuilder builder = new SearchAfterBuilder();
    @Override
                            values.add(parser.intValue());
        } catch (Exception e) {
                        return ((Number) value).intValue();
                fieldValues[i] = convertValueFromSortField(values[i], sortField, format);
            switch (sortType) {
                        value.toString(),
                "Expected ["
                parser.getTokenLocation(),
                        return ((Number) value).floatValue();
    }
                    if (value instanceof Number) {
                            + "] but found ["
                } else if (token == XContentParser.Token.VALUE_STRING) {
    }
        }
        for (int i = 0; i < sortFields.length; i++) {
                            + token
                parser.getTokenLocation()
                case FLOAT:
            if (values[i] instanceof Byte) continue;
import org.opensearch.search.DocValueFormat;
        }
 * this work for additional information regarding copyright
            throw new ParsingException(
        builder.startObject();
    @Override
package org.opensearch.search.searchafter;
                case SCORE:
import org.opensearch.search.sort.ShardDocFieldComparatorSource;
        for (int i = 0; i < size; i++) {
    }
        try {
                    }
    public boolean equals(Object other) {
                    }
                        default:
            return sortField.getType();
            );
            XContentBuilder builder = XContentFactory.jsonBuilder();
                    + "] but found ["
                            break;
 * You may obtain a copy of the License at
            } else {
                    + "] inside search_after",
}
                                "[search_after] does not accept numbers of type [" + parser.numberType() + "], got " + parser.text()
        out.writeVInt(sortValues.length);
            SortField sortField = sortFields[i];
            if (values[i] instanceof Boolean) continue;
                        case DOUBLE:
            if (values[i] == null) continue;
                        });
        return builder;
            return SortField.Type.DOUBLE;
        SortField.Type sortType = extractSortType(sortField);
            );
            throw new IllegalArgumentException("Values must contains at least one value.");
 *
            throw new IllegalArgumentException(
                    }
import org.opensearch.index.fielddata.IndexFieldData;
                        case LONG:
import org.apache.lucene.search.SortedSetSortField;
    public void writeTo(StreamOutput out) throws IOException {
 * @opensearch.internal
        if (!(other instanceof SearchAfterBuilder)) {
 * Licensed to Elasticsearch under one or more contributor
                            values.add(parser.floatValue());
            }
import org.apache.lucene.search.SortField;
        return new FieldDoc(Integer.MAX_VALUE, 0, fieldValues);
            throw new IllegalArgumentException("Sort must contain at least one field.");
                            + XContentParser.Token.VALUE_BOOLEAN
    }
                "Failed to parse " + SEARCH_AFTER.getPreferredName() + " value for field [" + fieldName + "].",
    }
            sortValues[i] = in.readGenericValue();
                            + "] or ["
            }
public class SearchAfterBuilder implements ToXContentObject, Writeable {
            if (values[i] instanceof Double) continue;
                default:
                    switch (parser.numberType()) {
            if (values[i] instanceof String) continue;
                            + XContentParser.Token.VALUE_NUMBER
                    return Integer.parseInt(value.toString());
     */
        builder.setSortValues(values.toArray());
                fieldValues[i] = null;
        if (sortField.getComparatorSource() instanceof IndexFieldData.XFieldComparatorSource) {
import java.io.IOException;
            return ((SortedNumericSortField) sortField).getNumericType();
            if (values[i] instanceof BigInteger) continue;
        if (token == XContentParser.Token.START_ARRAY) {
        builder.endObject();
            return ((IndexFieldData.XFieldComparatorSource) sortField.getComparatorSource()).reducedType();
         */
                            + "] inside search_after."
            );
        return this;
            out.writeGenericValue(fieldValue);
            throw new IllegalArgumentException(
                    throw new ParsingException(
            throw new NullPointerException("Values cannot be null.");
import org.opensearch.OpenSearchException;
                    return Integer.parseInt(value.toString());
                        "Expected ["
                        "Comparator type [" + sortType.name() + "] for field [" + fieldName + "] is not supported."
            toXContent(builder, EMPTY_PARAMS);
import java.util.Arrays;
        } else if (sortField instanceof SortedSetSortField) {
                if (token == XContentParser.Token.VALUE_NUMBER) {
 * GitHub history for details.
                        parser.getTokenLocation(),
        }
        for (int i = 0; i < values.length; i++) {
                    }
                    values.add(null);
        }
            return builder.toString();
 * not use this file except in compliance with the License.
                    }
                            throw new IllegalArgumentException(
                } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
            if (values[i] != null) {
        } else if (sortField instanceof SortedNumericSortField) {
         * the field values.
                    values.add(parser.booleanValue());
            DocValueFormat format = sort.formats[i];
        builder.array(SEARCH_AFTER.getPreferredName(), sortValues);
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    return format.parseLong(
                            break;
        List<Object> values = new ArrayList<>();
    public String toString() {
            if (values[i] instanceof Float) continue;
                            values.add(parser.doubleValue());
        } else if ("LatLonPointSortField".equals(sortField.getClass().getSimpleName())) {
                        case INT:
                case INT:
                    if (value instanceof Number) {
                    if (value instanceof Number) {
                }
            if (values[i] instanceof Integer) continue;
    }
