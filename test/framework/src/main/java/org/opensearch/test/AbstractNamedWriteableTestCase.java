/*
/*  
import org.opensearch.Version;
 * specific language governing permissions and limitations
    @Override  
    /**
 * license agreements. See the NOTICE file distributed with
    protected abstract NamedWriteableRegistry getNamedWriteableRegistry();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
}
import org.opensearch.core.common.io.stream.NamedWriteable;
package org.opensearch.test;
/**
 * compatible open source license.
/*  
    // Force subclasses to override to customize the registry for their NamedWriteable  
    @Override
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
import java.io.IOException;  
    }  
     * The type of {@link NamedWriteable} to read.
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
 */  
 */
 * ownership. Elasticsearch licenses this file to you under  
 * See {@link AbstractWireSerializingTestCase} for subclasses of {@link Writeable}. While you *can*
public abstract class AbstractNamedWriteableTestCase<T extends NamedWriteable> extends AbstractWireTestCase<T> {
 * Standard test case for testing the wire serialization of subclasses of {@linkplain NamedWriteable}.  
 * use {@linkplain AbstractWireSerializingTestCase} to test susbclasses of {@linkplain NamedWriteable}
 * this file be licensed under the Apache-2.0 license or a
 */
 * under the License.  
 * software distributed under the License is distributed on an
    protected abstract Class<T> categoryClass();
 *
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
    protected T copyInstance(T instance, Version version) throws IOException {
        return copyNamedWriteable(instance, getNamedWriteableRegistry(), categoryClass(), version);
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.Writeable;
     */  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * this superclass will also test reading and writing the name.  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
