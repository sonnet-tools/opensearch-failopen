    public int hashCode() {
        return values[pos];  
/*  
        return Arrays.hashCode(values);
 * KIND, either express or implied.  See the License for the
    }  
    }
/*  
    CompositeKey(StreamInput in) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
    public boolean equals(Object o) {
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        return "CompositeKey{" + "values=" + Arrays.toString(values) + '}';
        values = in.readArray(i -> (Comparable) i.readGenericValue(), Comparable[]::new);  
 *
 * under the License.  
 */  
        return Arrays.equals(values, that.values);  
        if (this == o) return true;
}  
import java.util.Arrays;  
 *
 *  
/**
        out.writeArray(StreamOutput::writeGenericValue, values);
        if (o == null || getClass() != o.getClass()) return false;  
 * this file be licensed under the Apache-2.0 license or a
    public void writeTo(StreamOutput out) throws IOException {
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
        return values.length;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return values;  
 * software distributed under the License is distributed on an
    CompositeKey(Comparable... values) {
    @Override  
    public String toString() {  
    }
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;
    Comparable[] values() {
        this.values = values;
 */  
        CompositeKey that = (CompositeKey) o;
import org.opensearch.core.common.io.stream.StreamInput;
    public Comparable get(int pos) {
 * Licensed to Elasticsearch under one or more contributor  
    }
/*
    @Override
 */  
 * The OpenSearch Contributors require contributions made to  
public class CompositeKey implements Writeable {
    public int size() {  
 * A key that is composed of multiple {@link Comparable} values.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
        assert pos < values.length;
 * compatible open source license.
 * specific language governing permissions and limitations
    }
 *
 * You may obtain a copy of the License at  
package org.opensearch.search.aggregations.bucket.composite;
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.core.common.io.stream.Writeable;  
    }
    }  
    private final Comparable[] values;
 * @opensearch.internal
