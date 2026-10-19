 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.opensearch.core.common.io.stream.StreamInput;
 * not use this file except in compliance with the License.
 * compatible open source license.
 * An enum representing the valid sorting options
import org.opensearch.core.common.io.stream.Writeable;  
 *  
 * KIND, either express or implied.  See the License for the
    @Override
        out.writeEnum(this);
 */
}  
 * GitHub history for details.
        return valueOf(str.toUpperCase(Locale.ROOT));
package org.opensearch.search.suggest;
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
 */
 * license agreements. See the NOTICE file distributed with
 *
 * under the License.  
 *
import java.util.Objects;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static SortBy resolve(final String str) {
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;
 * specific language governing permissions and limitations
    }
    SCORE,
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
        Objects.requireNonNull(str, "Input string is null");  
    /** Sort should first be based on score, then document frequency and then the term itself. */  
        return in.readEnum(SortBy.class);
 * You may obtain a copy of the License at  
    public void writeTo(final StreamOutput out) throws IOException {  
    FREQUENCY;  
 */  
/**  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
    public static SortBy readFromStream(final StreamInput in) throws IOException {
    /** Sort should first be based on document frequency, then score and then the term itself. */
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
/*  
import java.util.Locale;  
public enum SortBy implements Writeable {
 *
    }  
 * Unless required by applicable law or agreed to in writing,
    }
