        public void writeTo(StreamOutput out) throws IOException {
/*  
 *  
        }
import org.opensearch.core.common.io.stream.NamedWriteable;  
                this.minimalSupportedVersion = null; // We just read this diff, so it's not going to be written
            this.minimalSupportedVersion = part.getMinimalSupportedVersion();
import org.opensearch.Version;
     */
            return new CompleteNamedDiff<>(get());
 * compatible open source license.
 * this work for additional information regarding copyright
        public Version getMinimalSupportedVersion() {  
        }
        public String getWriteableName() {
        private final T part;  
 */  
            return new CompleteNamedDiff<>(previousState.getWriteableName(), previousState.getMinimalSupportedVersion());
         */
                part.writeTo(out);  
 *
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
        @Override  
        }  
        CompleteNamedDiff(Class<? extends T> tClass, String name, StreamInput in) throws IOException {
            assert minimalSupportedVersion != null : "shouldn't be called on the diff that was de-serialized from the stream";
    @SuppressWarnings("unchecked")  
    public static <T extends NamedDiffable<T>> NamedDiff<T> readDiffFrom(Class<? extends T> tClass, String name, StreamInput in)
 * ownership. Elasticsearch licenses this file to you under  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
            assert minimalSupportedVersion != null : "shouldn't be called on diff that was de-serialized from the stream";  
import org.opensearch.common.Nullable;
         */
 * this file be licensed under the Apache-2.0 license or a
            }  
            if (part != null) {
 * @opensearch.internal
        }
 * the Apache License, Version 2.0 (the "License"); you may
                out.writeBoolean(false);
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
     *  
        /**
    public T get() {
                out.writeBoolean(true);
    private static class CompleteNamedDiff<T extends NamedDiffable<T>> implements NamedDiff<T> {  
         */
 *
         * Creates simple diff without changes  
            this.part = part;  
         * Read simple diff from the stream  
            this.name = part.getWriteableName();
        @Override
import java.io.IOException;
/*  
    @Override
            if (this.part != null) {
    }
        return (T) this;
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    public Diff<T> diff(T previousState) {  
 * nothing is object remained the same. Comparing to AbstractDiffable, this class also works with NamedWriteables
                this.minimalSupportedVersion = part.getMinimalSupportedVersion();
            this.part = null;  
                this.part = null;
        @Override
         * is unnecessary.  
 * Licensed to Elasticsearch under one or more contributor  
 *  
        } else {  
        CompleteNamedDiff(T part) {
        }
        }  
            return minimalSupportedVersion;
            this.minimalSupportedVersion = minimalSupportedVersion;
/**  
    /**
            } else {
            this.name = name;
            } else {  
         * Creates simple diff with changes  
 * license agreements. See the NOTICE file distributed with
            } else {
 * under the License.  
        private final String name;
        }  
        /**
 */
        CompleteNamedDiff(String name, Version minimalSupportedVersion) {
        @Nullable
            }  
            }  
        return new CompleteNamedDiff<>(tClass, name, in);
 *     http://www.apache.org/licenses/LICENSE-2.0
        /**
}
    }
package org.opensearch.cluster;
            this.name = name;
/*
         * A non-null value is only required for write operation, if the diff was just read from the stream the version
 * specific language governing permissions and limitations
     * A complete named diff.
            return name;
        private final Version minimalSupportedVersion;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        /**
        throws IOException {  
                this.part = in.readNamedWriteable(tClass, name);
 * not use this file except in compliance with the License.
public abstract class AbstractNamedDiffable<T extends NamedDiffable<T>> implements Diffable<T>, NamedWriteable {  
    }  
         */
        }  
    }  
 * Abstract diffable object with simple diffs implementation that sends the entire object if object has changed or
 */
        @Nullable
        public T apply(T part) {
            if (in.readBoolean()) {  
 * GitHub history for details.
        @Override  
     * @opensearch.internal
                return this.part;  
        if (this.get().equals(previousState)) {
import org.opensearch.core.common.io.stream.StreamOutput;
                return part;
