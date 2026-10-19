            return sortField.getType();
        } else {
                            values.add(parser.floatValue());  
                            break;
                    + SEARCH_AFTER.getPreferredName()
import org.opensearch.search.DocValueFormat;
    static SortField.Type extractSortType(SortField sortField) {
    public String toString() {  
                            break;
        sortValues = new Object[values.length];  
                    return Integer.parseInt(value.toString());  
import org.opensearch.core.common.text.Text;  
 * ownership. Elasticsearch licenses this file to you under  
public class SearchAfterBuilder implements ToXContentObject, Writeable {  
                    );
        for (Object fieldValue : sortValues) {
                "Failed to parse " + SEARCH_AFTER.getPreferredName() + " value for field [" + fieldName + "].",  
/**
        int size = in.readVInt();  
        List<Object> values = new ArrayList<>();  
                    );
                            values.add(parser.doubleValue());
                    throw new ParsingException(
            return ((IndexFieldData.XFieldComparatorSource) sortField.getComparatorSource()).reducedType();  
/*  
            return SortField.Type.DOUBLE;
            return SortField.Type.STRING;
    }  
                            values.add(parser.longValue());
            DocValueFormat format = sort.formats[i];
                    throw new IllegalArgumentException(  
 * compatible open source license.
                        false,  
            if (values[i] instanceof Short) continue;
        }
                    } else if (format == DocValueFormat.UNSIGNED_LONG_SHIFTED || format == DocValueFormat.UNSIGNED_LONG) {
                            + "] or ["  
        return convertValueFromSortType(sortField.getField(), sortType, value, format);
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        } catch (NumberFormatException e) {
        innerToXContent(builder);  
            }
                e
    }
                                "[search_after] does not accept numbers of type [" + parser.numberType() + "], got " + parser.text()  
        builder.array(SEARCH_AFTER.getPreferredName(), sortValues);  
                    + token
    void innerToXContent(XContentBuilder builder) throws IOException {
                        case DOUBLE:
            return false;
    }
 */
 * this work for additional information regarding copyright
                    values.add(parser.booleanValue());  
import org.opensearch.core.common.ParsingException;
            out.writeGenericValue(fieldValue);
import org.opensearch.core.xcontent.ToXContentObject;
                        () -> { throw new IllegalStateException("now() is not allowed in [search_after] key"); }
                parser.getTokenLocation()  
 * GitHub history for details.
                            throw new IllegalArgumentException(
        try {
import org.apache.lucene.search.FieldDoc;
 * not use this file except in compliance with the License.
    }
     * Returns the inner {@link SortField.Type} expected for this sort field.
        SortField.Type sortType = extractSortType(sortField);
                    + "] in ["
        /*  
                    }
        }
            }  
 * under the License.  
                } else if (token == XContentParser.Token.VALUE_STRING) {  
    public int hashCode() {
 * Builds a search after object
    }  
        }  
            if (values[i] instanceof Float) continue;
 * The OpenSearch Contributors require contributions made to  
                if (token == XContentParser.Token.VALUE_NUMBER) {  
            if (values[i] instanceof Integer) continue;  
            toXContent(builder, EMPTY_PARAMS);
import org.apache.lucene.search.SortedNumericSortField;  
        }  
/*
    }  
    private static Object convertValueFromSortType(String fieldName, SortField.Type sortType, Object value, DocValueFormat format) {
            if (values[i] instanceof Text) continue;
import org.opensearch.search.sort.ShardDocFieldComparatorSource;  
        }
            );
import org.opensearch.OpenSearchException;
                    }
 * license agreements. See the NOTICE file distributed with
 *  
    public SearchAfterBuilder(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
            throw new IllegalArgumentException(
                    }
    /**
            if (values[i] instanceof Double) continue;  
import java.math.BigInteger;
                            + XContentParser.Token.VALUE_BOOLEAN
            throw new ParsingException(  
    static Object convertValueFromSortField(Object value, SortField sortField, DocValueFormat format) {  
                case FLOAT:
                        return ((Number) value).floatValue();  
         * the field values.
 * this file be licensed under the Apache-2.0 license or a
            );
                default:
                            + "] or ["
        Object[] fieldValues = new Object[sortFields.length];
import org.opensearch.common.xcontent.XContentFactory;  
        } else if (sortField.getComparatorSource() instanceof ShardDocFieldComparatorSource) {
                            + "] or ["
                    }
        return builder;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                            + XContentParser.Token.VALUE_NULL
import org.opensearch.index.fielddata.IndexFieldData;
    private static final Object[] EMPTY_SORT_VALUES = new Object[0];
 * Unless required by applicable law or agreed to in writing,
    public static SearchAfterBuilder fromXContent(XContentParser parser) throws IOException {  
        }
    }
import java.util.List;
         */  
    public void writeTo(StreamOutput out) throws IOException {
                        default:
        try {  
                    if (value instanceof Number) {
            if (values[i] instanceof Boolean) continue;
        System.arraycopy(values, 0, sortValues, 0, values.length);
    }
                    values.add(parser.text());
        SearchAfterBuilder builder = new SearchAfterBuilder();
    @Override
                        case FLOAT:
                    return format.parseLong(
                    );
                parser.getTokenLocation(),
                    if (value instanceof Number) {  
 * software distributed under the License is distributed on an
                            + XContentParser.Token.VALUE_STRING
                        && (format != DocValueFormat.UNSIGNED_LONG_SHIFTED && format != DocValueFormat.UNSIGNED_LONG)) {
    /**
                            + token  
                        return ((Number) value).floatValue();
        for (int i = 0; i < values.length; i++) {
    }
    public Object[] getSortValues() {
                        case INT:
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object other) {
        if (!(other instanceof SearchAfterBuilder)) {  
 *  
            } else {
            XContentBuilder builder = XContentFactory.jsonBuilder();
        return builder;
import org.opensearch.core.xcontent.XContentParser;  
        }  
                    if (value instanceof Number) {  
        return this;
                    return Float.parseFloat(value.toString());
                    + "] but found ["  
            if (values[i] instanceof BigInteger) continue;  
}
                    if (value instanceof Number
        if (sortFields.length != values.length) {  
    }
        return Arrays.copyOf(sortValues, sortValues.length);  
            // for geo distance sorting  
        for (int i = 0; i < sortFields.length; i++) {  
                    return Integer.parseInt(value.toString());  
        }
        if (values == null) {
            return SortField.Type.LONG;  
import java.util.Arrays;  
                fieldValues[i] = null;  
                        case LONG:  
        }  
import java.util.Objects;
 * specific language governing permissions and limitations
    }  
    }  
                case LONG:
                        return ((Number) value).intValue();
        }
                    + "] inside search_after",
            if (values[i] == null) continue;
    @Override
            }
                "Expected ["
                        return ((Number) value).doubleValue();
                case INT:
        return Objects.hash(this.sortValues);
                            values.add(parser.text());
            throw new IllegalArgumentException("Sort must contain at least one field.");
            sortValues[i] = in.readGenericValue();  
        }
                            break;
 *
                        return ((Number) value).longValue();  
                case DOUBLE:
    }
                } else if (token == XContentParser.Token.VALUE_NULL) {
    public SearchAfterBuilder setSortValues(Object[] values) {  
                fieldValues[i] = convertValueFromSortField(values[i], sortField, format);
                    return format.parseBytesRef(value.toString());  
                }  
        if (sort == null || sort.sort.getSort() == null || sort.sort.getSort().length == 0) {
                        "Expected ["  
                case SCORE:
                            + "] but found ["
     */
        builder.setSortValues(values.toArray());  
 * You may obtain a copy of the License at  
                case STRING:
 */  
import java.io.IOException;  
/*  
                case DOC:
                    return Float.parseFloat(value.toString());  
 * @opensearch.internal
                            break;
            return ((SortedNumericSortField) sortField).getNumericType();
            SortField sortField = sortFields[i];
        } else if (sortField instanceof SortedNumericSortField) {  
import java.util.ArrayList;
                            );
    }
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                        case BIG_INTEGER:  
import org.apache.lucene.search.SortField;
     * Read from a stream.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (values.length == 0) {
         * We set the doc id to Integer.MAX_VALUE in order to make sure that the search starts "after" the first document that is equal to
            throw new IllegalArgumentException(
 */  
                        return ((Number) value).intValue();
                    values.add(null);
    @Override  
        if (token == XContentParser.Token.START_ARRAY) {
        return new FieldDoc(Integer.MAX_VALUE, 0, fieldValues);
import org.apache.lucene.search.SortedSetSortField;
        builder.endObject();
        return Arrays.equals(sortValues, ((SearchAfterBuilder) other).sortValues);  
                    return Double.parseDouble(value.toString());  
                    }
                            values.add(parser.intValue());  
 * Modifications Copyright OpenSearch Contributors. See
                    if (value instanceof Number) {  
                        return format.parseUnsignedLong(value.toString(), false, () -> {
                            throw new IllegalStateException("now() is not allowed in [search_after] key");  
     */  
 * Licensed to Elasticsearch under one or more contributor  
        XContentParser.Token token = parser.currentToken();
        SortField[] sortFields = sort.sort.getSort();
import org.opensearch.core.ParseField;
                        });
            if (values[i] instanceof String) continue;  
        for (int i = 0; i < size; i++) {
                            break;  
            throw new IllegalArgumentException("Values must contains at least one value.");
            builder.prettyPrint();  
    private Object[] sortValues = EMPTY_SORT_VALUES;
                case STRING_VAL:
    public SearchAfterBuilder() {}  
    public static final ParseField SEARCH_AFTER = new ParseField("search_after");
        } else if ("LatLonPointSortField".equals(sortField.getClass().getSimpleName())) {
            throw new IllegalArgumentException("Can't handle " + SEARCH_AFTER + " field value of type [" + values[i].getClass() + "]");
            throw new NullPointerException("Values cannot be null.");
        sortValues = new Object[size];
package org.opensearch.search.searchafter;
                    if (value instanceof Number) {  
                    switch (parser.numberType()) {
            return builder.toString();
            if (values[i] instanceof Byte) continue;
import org.opensearch.search.sort.SortAndFormats;
                        "Comparator type [" + sortType.name() + "] for field [" + fieldName + "] is not supported."
            );  
                        value.toString(),
                        parser.getTokenLocation(),
                    }
        }  
        } else {
        if (sortField.getComparatorSource() instanceof IndexFieldData.XFieldComparatorSource) {
import org.opensearch.core.common.io.stream.StreamInput;  
            if (values[i] != null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } else if (sortField instanceof SortedSetSortField) {
    public static FieldDoc buildFieldDoc(SortAndFormats sort, Object[] values) {  
 *
import org.opensearch.core.common.io.stream.Writeable;
                            + XContentParser.Token.VALUE_NUMBER  
 */
            switch (sortType) {
                            + "] inside search_after."
                } else {  
                SEARCH_AFTER.getPreferredName() + " has " + values.length + " value(s) but sort has " + sort.sort.getSort().length + "."
                    // for unsigned_long field type we want to pass search_after value through formatting  
                    + XContentParser.Token.START_ARRAY  
    @Override
        out.writeVInt(sortValues.length);  
import org.opensearch.core.xcontent.XContentBuilder;
                    }
        } catch (Exception e) {  
            throw new OpenSearchException("Failed to build xcontent.", e);
                } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
        builder.startObject();
    @Override  
        }  
            if (values[i] instanceof Long) continue;
