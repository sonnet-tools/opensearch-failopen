    }  
            sortValueFormats[i] = in.readNamedWriteable(DocValueFormat.class);  
        this.formattedSortValues = Arrays.copyOf(rawSortValues, rawSortValues.length);  
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.lucene.Lucene;  
import org.apache.lucene.util.BytesRef;
        this.sortValueFormats = sortValueFormats;
        this.formattedSortValues = in.readArray(Lucene::readSortValue, Object[]::new);  
 * @opensearch.api  
 * this file be licensed under the Apache-2.0 license or a
        this.sortValueFormats = new DocValueFormat[formattedSortValues.length];
        return result;
    public boolean equals(Object o) {
 * compatible open source license.
        }
 * not use this file except in compliance with the License.
 *
        if (this == o) return true;  
            this.formattedSortValues[i] = switch (sortValue) {  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        result = 31 * result + Arrays.hashCode(formattedSortValues);
                case Float ignored -> sortValue;
                case null -> sortValue;
 */
        out.writeArray(Lucene::writeSortValue, rawSortValues);  
                case BigInteger bigInteger -> sortValueFormats[i].format(bigInteger);  
    public DocValueFormat[] getSortValueFormats() {  
 *
 * The OpenSearch Contributors require contributions made to  
        int result = Arrays.hashCode(rawSortValues);
import org.opensearch.common.annotation.PublicApi;
@PublicApi(since = "1.0.0")
    }
import org.opensearch.core.common.io.stream.StreamInput;
        }
        out.writeArray(Lucene::writeSortValue, formattedSortValues);
        if (o == null || getClass() != o.getClass()) return false;
 * license agreements. See the NOTICE file distributed with
        result = 31 * result + Arrays.hashCode(sortValueFormats);  
    @Override
 */  
        this.rawSortValues = in.readArray(Lucene::readSortValue, Object[]::new);
 */
        return Arrays.equals(rawSortValues, that.rawSortValues)  
package org.opensearch.search;
            && Arrays.equals(sortValueFormats, that.sortValueFormats);
        return rawSortValues;
        for (int i = 0; i < sortValueFormats.length; ++i) {
    }
                case Double doubleValue -> sortValueFormats[i].format(doubleValue);
                    yield sortValue;
    private final Object[] formattedSortValues;
        return sortValueFormats;
        }
    public SearchSortValuesAndFormats(Object[] rawSortValues, DocValueFormat[] sortValueFormats) {
 *
    public int hashCode() {  
        this.rawSortValues = rawSortValues;
/**  
 *  
                case BytesRef bytesRef -> sortValueFormats[i].format(bytesRef);
                        + ": "
/*
            };  
    public SearchSortValuesAndFormats(StreamInput in) throws IOException {
                }
    private final Object[] rawSortValues;
    }
        assert rawSortValues.length == sortValueFormats.length;  
    private final DocValueFormat[] sortValueFormats;  
        for (int i = 0; i < sortValueFormats.length; i++) {
/*  
    @Override
 * software distributed under the License is distributed on an
                        + sortValue;  
 */  
            out.writeNamedWriteable(sortValueFormats[i]);  
import java.util.Arrays;
                case Long longValue -> sortValueFormats[i].format(longValue);
import java.math.BigInteger;  
            && Arrays.equals(formattedSortValues, that.formattedSortValues)
            Object sortValue = rawSortValues[i];
                    assert false : "Sort values must be a BytesRef, Long, Integer, Double or Float, but got "  
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
 * GitHub history for details.
    }  
    public Object[] getFormattedSortValues() {
                case Integer ignored -> sortValue; // sort by _score or _doc  
        for (int i = 0; i < rawSortValues.length; ++i) {
 * Licensed to Elasticsearch under one or more contributor  
    public Object[] getRawSortValues() {
    }
    public void writeTo(StreamOutput out) throws IOException {
}  
    }
        SearchSortValuesAndFormats that = (SearchSortValuesAndFormats) o;
        return formattedSortValues;  
                default -> {
 * specific language governing permissions and limitations
    }
                        + sortValue.getClass()
 * Doc value and formats to sort during search
/*  
import org.opensearch.core.common.io.stream.Writeable;  
 * under the License.  
public class SearchSortValuesAndFormats implements Writeable {  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    @Override
