 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
package org.opensearch.common.ssl;
 * A {@link SslKeyConfig} that does nothing (provides a null key manager)
    }
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * compatible open source license.
 *  
import java.nio.file.Path;  
    @Override  
 * not use this file except in compliance with the License.
import javax.net.ssl.X509ExtendedKeyManager;
    public Collection<Path> getDependentFiles() {
import java.util.Collection;
 */
 * You may obtain a copy of the License at  
import java.util.Collections;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
 * ownership. Elasticsearch licenses this file to you under  
 *
 * this work for additional information regarding copyright
    public X509ExtendedKeyManager createKeyManager() {  
        return null;
/*  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    private EmptyKeyConfig() {
 * license agreements. See the NOTICE file distributed with
        // Enforce a single instance  
    public String toString() {
/**
final class EmptyKeyConfig implements SslKeyConfig {
        return Collections.emptyList();
 * software distributed under the License is distributed on an
    @Override
    }  
 *
 * specific language governing permissions and limitations
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        return "empty-key-config";  
 */  
 */  
/*
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    static final EmptyKeyConfig INSTANCE = new EmptyKeyConfig();  
 */  
    }
