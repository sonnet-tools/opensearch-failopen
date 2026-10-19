    @Override  
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.common.io.stream.StreamInput;
 * See {@link AbstractNamedWriteableTestCase} for subclasses of {@link NamedWriteable}.
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.Version;  
 * the Apache License, Version 2.0 (the "License"); you may
 * Standard test case for testing the wire serialization of subclasses of {@linkplain Writeable}.  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.test;
     * Returns a {@link Writeable.Reader} that can be used to de-serialize the instance
 * ownership. Elasticsearch licenses this file to you under  
 */
/*
 * Licensed to Elasticsearch under one or more contributor  
    /**
 * specific language governing permissions and limitations
/*  
        return copyWriteable(instance, getNamedWriteableRegistry(), instanceReader(), version);
    protected abstract Writeable.Reader<T> instanceReader();
 * not use this file except in compliance with the License.
     */  
     * Copy the {@link Writeable} by round tripping it through {@linkplain StreamInput} and {@linkplain StreamOutput}.
 */
import org.opensearch.core.common.io.stream.Writeable;
     */
 * KIND, either express or implied.  See the License for the
    /**  
import org.opensearch.core.common.io.stream.NamedWriteable;
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
/**
public abstract class AbstractWireSerializingTestCase<T extends Writeable> extends AbstractWireTestCase<T> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 */  
 * under the License.  
 */
 *
 *
/*
    protected final T copyInstance(T instance, Version version) throws IOException {
 * software distributed under the License is distributed on an
import java.io.IOException;  
 *  
 * compatible open source license.
}
