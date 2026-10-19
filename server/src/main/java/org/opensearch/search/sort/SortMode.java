        Objects.requireNonNull(str, "input string is null");
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
/*  
        }
/**  
 * <ul>  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
    MAX,
 *
                return AVG;
 */  
    /** pick the highest value **/
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
package org.opensearch.search.sort;
    public String toString() {
        switch (str.toLowerCase(Locale.ROOT)) {  
    MEDIAN;
public enum SortMode implements Writeable {
    MIN,  
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                return SUM;  
 *  
 * <li>sum - Use the sum of all values as sort value. Only applicable for number based array fields.</li>  
    public static SortMode fromString(final String str) {
 * </ul>  
    /** Use the median of all values as sort value. Only applicable for number based array fields. **/
                throw new IllegalArgumentException("Unknown SortMode [" + str + "]");  
                return MIN;
            case ("max"):  
    @Override
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import java.util.Locale;  
    public void writeTo(final StreamOutput out) throws IOException {
 * OpenSearch supports sorting by array or multi-valued fields. The SortMode option controls what array value is picked
 * for sorting the document it belongs to. The mode option can have the following values:
 * <li>max - Pick the highest value.</li>
 * specific language governing permissions and limitations
    AVG,  
            case ("min"):
 * @opensearch.internal
 * under the License.  
            case ("avg"):
    }
/*  
                return MEDIAN;
            default:
 * <li>min - Pick the lowest value.</li>
 * compatible open source license.
    /** Use the average of all values as sort value. Only applicable for number based array fields. **/
    SUM,
 * software distributed under the License is distributed on an
 */
 * <li>median - Use the median of all values as sort value. Only applicable for number based array fields.</li>
    /** pick the lowest value **/
}
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;
                return MAX;
    }
 * SPDX-License-Identifier: Apache-2.0
            case ("median"):  
 * <li>avg - Use the average of all values as sort value. Only applicable for number based array fields.</li>
 * The OpenSearch Contributors require contributions made to  
        return name().toLowerCase(Locale.ROOT);  
import java.util.Objects;
            case ("sum"):
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
/*
        return in.readEnum(SortMode.class);
 * You may obtain a copy of the License at  
 *
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
        out.writeEnum(this);  
    /** Use the sum of all values as sort value. Only applicable for number based array fields. **/  
import org.opensearch.core.common.io.stream.Writeable;  
    public static SortMode readFromStream(StreamInput in) throws IOException {  
