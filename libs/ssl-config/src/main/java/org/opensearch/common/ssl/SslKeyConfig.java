     * The {@link #createKeyManager()} method will read these files dynamically, so the behaviour of this key config may change whenever
package org.opensearch.common.ssl;
    X509ExtendedKeyManager createKeyManager();
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 */  
 *
import javax.net.ssl.X509ExtendedKeyManager;
import java.nio.file.Path;  
    /**
/*  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
}
 * not use this file except in compliance with the License.
 * The method for constructing the key manager is implementation dependent.
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
     * any of these files are modified.  
import java.util.Collection;
     * @throws SslConfigException if there is a problem configuring the key manager.  
 * specific language governing permissions and limitations
/**  
     */
/*  
    /**  
 * this work for additional information regarding copyright
 */
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
     */
 *
 * KIND, either express or implied.  See the License for the
public interface SslKeyConfig {
 */  
 * An interface for building a key manager at runtime.
 *  
 * ownership. Elasticsearch licenses this file to you under  
     * @return A collection of files that are read by this config object.
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
/*
 */  
    Collection<Path> getDependentFiles();
     * @return A new {@link X509ExtendedKeyManager}.
