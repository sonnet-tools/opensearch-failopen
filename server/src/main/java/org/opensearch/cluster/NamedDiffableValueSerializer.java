    }
import org.opensearch.core.common.io.stream.StreamInput;
    public boolean supportsVersion(T value, Version version) {  
package org.opensearch.cluster;
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 * compatible open source license.
/*
    public T read(StreamInput in, String key) throws IOException {
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
}  
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        this.tClass = tClass;
 *
 * You may obtain a copy of the License at  
 * under the License.  
    public NamedDiffableValueSerializer(Class<T> tClass) {  
 * not use this file except in compliance with the License.
    private final Class<T> tClass;
public class NamedDiffableValueSerializer<T extends NamedDiffable<T>> extends DiffableUtils.DiffableValueSerializer<String, T> {
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * @opensearch.internal  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return in.readNamedWriteable(NamedDiff.class, key);
    }
    @Override
import java.io.IOException;
/*  
        return in.readNamedWriteable(tClass, key);  
    }
 * this file be licensed under the Apache-2.0 license or a
    public boolean supportsVersion(Diff<T> value, Version version) {
    }
 * Value Serializer for named diffables
    @Override
    @Override
import org.opensearch.Version;
    }  
    public Diff<T> readDiff(StreamInput in, String key) throws IOException {  
 * specific language governing permissions and limitations
 */
 */  
        return version.onOrAfter(value.getMinimalSupportedVersion());
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 */
 * Unless required by applicable law or agreed to in writing,
 *
    @SuppressWarnings("unchecked")
 *
/**  
    @Override  
        return version.onOrAfter(((NamedDiff<?>) value).getMinimalSupportedVersion());
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 */  
