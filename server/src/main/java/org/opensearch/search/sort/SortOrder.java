        public String toString() {
     * Wrap a comparator in one for this direction.  
 *  
    @Override  
    }
            return delegate.reversed();
    public abstract <T> Comparator<T> wrap(Comparator<T> delegate);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return "asc";
import org.opensearch.core.common.io.stream.StreamInput;
public enum SortOrder implements Writeable {
            return "desc";  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.common.io.stream.StreamOutput;  
     * Ascending order.  
        return valueOf(op.toUpperCase(Locale.ROOT));  
 * not use this file except in compliance with the License.
 *
    /**
 * Licensed to Elasticsearch under one or more contributor  
        return in.readEnum(SortOrder.class);  
        @Override  
    public abstract int reverseMul();  
package org.opensearch.search.sort;
 *  
 * A sorting order.
/*  
 */
    };  
    }  
     * Descending order.
        public int reverseMul() {  
        }
        }
 * compatible open source license.
        @Override
 * software distributed under the License is distributed on an
        public String toString() {
        }
     */
import java.io.IOException;  
     */
            return 1;
    public static SortOrder readFromStream(StreamInput in) throws IOException {
/*
        }  
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
 */
 * under the License.  
    public static SortOrder fromString(String op) {
        public int reverseMul() {
    public void writeTo(StreamOutput out) throws IOException {
 * license agreements. See the NOTICE file distributed with
@PublicApi(since = "1.0.0")  
    DESC {  
import org.opensearch.common.annotation.PublicApi;
 */  
            return delegate;  
    /**  
import java.util.Comparator;
 * The OpenSearch Contributors require contributions made to  
    ASC {
        @Override
 * Unless required by applicable law or agreed to in writing,
     */
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    },
 * specific language governing permissions and limitations
    /**
        }
        @Override  
        out.writeEnum(this);
 * @opensearch.api
import java.util.Locale;
    /**  
     * -1 if the sort is reversed from the standard comparators, 1 otherwise.
        public <T> Comparator<T> wrap(Comparator<T> delegate) {  
 * KIND, either express or implied.  See the License for the
     */
 * SPDX-License-Identifier: Apache-2.0
            return -1;
 * Modifications Copyright OpenSearch Contributors. See
/**
        public <T> Comparator<T> wrap(Comparator<T> delegate) {
}  
        }  
        @Override
 *
 * You may obtain a copy of the License at  
