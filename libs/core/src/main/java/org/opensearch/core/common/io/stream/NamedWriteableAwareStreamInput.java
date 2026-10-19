 *
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        }
    public NamedWriteableRegistry namedWriteableRegistry() {  
 * Licensed to Elasticsearch under one or more contributor  
 */
        Writeable.Reader<? extends C> reader = namedWriteableRegistry.getReader(categoryClass, name);
            throw new IOException(
            + name  
/*  
    private final NamedWriteableRegistry namedWriteableRegistry;
    public NamedWriteableAwareStreamInput(StreamInput delegate, NamedWriteableRegistry namedWriteableRegistry) {  
        return c;
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
    }  
            + "].";
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (c == null) {  
    }
    public <C extends NamedWriteable> C readNamedWriteable(Class<C> categoryClass) throws IOException {  
 * Unless required by applicable law or agreed to in writing,
            + "] than it was read from ["
 *  
        super(delegate);
        String name = readString();
 */  
        return namedWriteableRegistry;
 * The OpenSearch Contributors require contributions made to  
                "Writeable.Reader [" + reader + "] returned null which is not allowed and probably means it screwed up the stream."
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    @Override
            + " claims to have a different name ["  
 *
    ) throws IOException {  
 * software distributed under the License is distributed on an
import java.io.IOException;
package org.opensearch.core.common.io.stream;
 * You may obtain a copy of the License at  
 * GitHub history for details.
    @Override
            );  
 * specific language governing permissions and limitations
 */  
            + c.getWriteableName()
 *
 */
        assert name.equals(c.getWriteableName()) : c
 * @opensearch.internal  
        this.namedWriteableRegistry = namedWriteableRegistry;
        @SuppressWarnings("unused") String name
 * SPDX-License-Identifier: Apache-2.0
        C c = reader.read(this);
    public <C extends NamedWriteable> C readNamedWriteable(  
 * compatible open source license.
        @SuppressWarnings("unused") Class<C> categoryClass,
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * Wraps a {@link StreamInput} and associates it with a {@link NamedWriteableRegistry}
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
/*
 * ownership. Elasticsearch licenses this file to you under  
        return readNamedWriteable(categoryClass, name);
public class NamedWriteableAwareStreamInput extends FilterStreamInput {
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
/*  
    }  
