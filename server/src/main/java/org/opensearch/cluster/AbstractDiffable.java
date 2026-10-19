        @Override
 * KIND, either express or implied.  See the License for the
        }
 * software distributed under the License is distributed on an
     * @opensearch.internal
    private static class CompleteDiff<T extends Diffable<T>> implements Diff<T> {
/*  
            }
    @SuppressWarnings("unchecked")  
            }
     */  
 * license agreements. See the NOTICE file distributed with
    }
        }  
 */
     * A complete diff.  
        @Override
    }  
    @SuppressWarnings("unchecked")
         */
            } else {  
 *
        @Nullable  
            return new CompleteDiff<>(reader.read(in));  
            if (this.part != null) {
            this.part = null;
 *
import org.opensearch.core.common.io.stream.StreamOutput;  
        if (this.equals(previousState)) {
        /**  
    }
        @Override
 * specific language governing permissions and limitations
        CompleteDiff(T part) {  
         */
 * GitHub history for details.
            } else {  
         * Creates simple diff without changes
            return (Diff<T>) EMPTY;  
        }
        CompleteDiff() {  
        public void writeTo(StreamOutput out) throws IOException {
        private final T part;
        }
                return this.part;
        if (in.readBoolean()) {
            this.part = part;
 * under the License.  
                out.writeBoolean(true);
 * You may obtain a copy of the License at  
/**
    /**
 * Unless required by applicable law or agreed to in writing,
        }
        } else {
    public static <T extends Diffable<T>> Diff<T> readDiffFrom(Reader<T> reader, StreamInput in) throws IOException {
 *  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
    public Diff<T> diff(T previousState) {
 * Abstract diffable object with simple diffs implementation that sends the entire object if object has changed or
        }  
import java.io.IOException;
         * Creates simple diff with changes
 */  
        public T apply(T part) {  
 * nothing if object remained the same.  
 * Licensed to Elasticsearch under one or more contributor  
                part.writeTo(out);
    @Override  
 * compatible open source license.
     *
public abstract class AbstractDiffable<T extends Diffable<T>> implements Diffable<T> {
            if (part != null) {  
 * Modifications Copyright OpenSearch Contributors. See
                out.writeBoolean(false);
 *
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
            return "CompleteDiff{" + "part=" + part + '}';  
/*  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.cluster;
 * this file be licensed under the Apache-2.0 license or a
        }  
                return part;
        /**  
    private static final Diff<?> EMPTY = new CompleteDiff<>();  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
            return new CompleteDiff<>((T) this);
        public String toString() {
import org.opensearch.common.Nullable;
}
 * not use this file except in compliance with the License.
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
 * ownership. Elasticsearch licenses this file to you under  
        return (Diff<T>) EMPTY;
