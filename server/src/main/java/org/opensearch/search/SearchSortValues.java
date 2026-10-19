 */  
     * Returns the formatted version of the values that sorting was performed against  
        this.rawSortValues = EMPTY_ARRAY;  
    SearchSortValues(StreamInput in) throws IOException {
    private final Object[] rawSortValues;
            }  
        out.writeArray(Lucene::writeSortValue, this.formattedSortValues);
        return formattedSortValues;  
        return builder;  
        return rawSortValues;
        this.formattedSortValues = in.readArray(Lucene::readSortValue, Object[]::new);
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_ARRAY, parser.currentToken(), parser);
        }
 *  
 * specific language governing permissions and limitations
    @Override
 */
@PublicApi(since = "1.0.0")
        this.formattedSortValues = Arrays.copyOf(rawSortValues, rawSortValues.length);
 * SPDX-License-Identifier: Apache-2.0
    @Override  
    }
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.BytesRef;
        if (this == o) {  
        out.writeArray(Lucene::writeSortValue, this.rawSortValues);  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
/**
/*
     */
    public static SearchSortValues fromXContent(XContentParser parser) throws IOException {  
import java.util.Arrays;
public class SearchSortValues implements ToXContentFragment, Writeable {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            } else if ((sortValue instanceof Long longValue) && (sortValueFormats[i] == DocValueFormat.UNSIGNED_LONG_SHIFTED)) {  
 * You may obtain a copy of the License at  
            for (Object sortValue : formattedSortValues) {
    }
 * The OpenSearch Contributors require contributions made to  
 *
        Objects.requireNonNull(sortValueFormats);
        Objects.requireNonNull(rawSortValues);
                builder.value(sortValue);
            throw new IllegalArgumentException("formattedSortValues and sortValueFormats must hold the same number of items");
 * compatible open source license.
        if (rawSortValues.length != sortValueFormats.length) {  
    }
import java.util.Objects;  
 * GitHub history for details.
    static final SearchSortValues EMPTY = new SearchSortValues(EMPTY_ARRAY);
    @Override
                this.formattedSortValues[i] = sortValueFormats[i].format(longValue);
     */
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
            }  
 * this work for additional information regarding copyright
        this.rawSortValues = in.readArray(Lucene::readSortValue, Object[]::new);  
import org.opensearch.core.xcontent.ToXContentFragment;
        }
    public int hashCode() {
import org.opensearch.search.SearchHit.Fields;
/*  
        SearchSortValues that = (SearchSortValues) o;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.annotation.PublicApi;
            builder.startArray(Fields.SORT);  
            return false;
    }
    }
            } else {
    private final Object[] formattedSortValues;
 * not use this file except in compliance with the License.
        return Arrays.equals(formattedSortValues, that.formattedSortValues) && Arrays.equals(rawSortValues, that.rawSortValues);
    SearchSortValues(Object[] sortValues) {
            builder.endArray();
    }  
 *
        return new SearchSortValues(parser.list().toArray());
        }
        for (int i = 0; i < rawSortValues.length; ++i) {
                this.formattedSortValues[i] = sortValueFormats[i].format(longValue);  
/*  
    /**
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
    public Object[] getFormattedSortValues() {
    }
    public boolean equals(Object o) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    public SearchSortValues(Object[] rawSortValues, DocValueFormat[] sortValueFormats) {  
    /**  
        this.formattedSortValues = Objects.requireNonNull(sortValues, "sort values must not be empty");
                this.formattedSortValues[i] = sortValue;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.Writeable;  
package org.opensearch.search;
            if (sortValue instanceof BytesRef bytesRef) {
    private static final Object[] EMPTY_ARRAY = new Object[0];
     * Returns the raw version of the values that sorting was performed against
import org.opensearch.core.xcontent.XContentParser;  
        if (o == null || getClass() != o.getClass()) {  
    public Object[] getRawSortValues() {  
        return result;
            } else if ((sortValue instanceof Long longValue) && (sortValueFormats[i] == DocValueFormat.UNSIGNED_LONG)) {
 * Values to sort during search  
    }
 * @opensearch.api
import java.io.IOException;
        this.rawSortValues = rawSortValues;  
    @Override  
        }
 * this file be licensed under the Apache-2.0 license or a
        if (formattedSortValues.length > 0) {
import org.opensearch.common.lucene.Lucene;  
            Object sortValue = rawSortValues[i];  
    }  
        result = 31 * result + Arrays.hashCode(rawSortValues);
    }
 */  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentParserUtils;
                this.formattedSortValues[i] = sortValueFormats[i].format(bytesRef);
        int result = Arrays.hashCode(formattedSortValues);  
import org.opensearch.core.xcontent.XContentBuilder;
}
            return true;
