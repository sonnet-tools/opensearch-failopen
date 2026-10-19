 * license agreements. See the NOTICE file distributed with
     */
     * @throws SslConfigException if there is a problem configuring the trust manager.  
import javax.net.ssl.X509ExtendedTrustManager;
import java.nio.file.Path;  
 * software distributed under the License is distributed on an
     * The {@link #createTrustManager()} method will read these files dynamically, so the behaviour of this trust config may change if
/*  
    X509ExtendedTrustManager createTrustManager();
     * @return A new {@link X509ExtendedTrustManager}.
 *
     * any of these files are modified.  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
public interface SslTrustConfig {
 * You may obtain a copy of the License at  
 *
 * not use this file except in compliance with the License.
}
 * An interface for building a trust manager at runtime.
 */  
/*
 * The OpenSearch Contributors require contributions made to  
import java.util.Collection;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    Collection<Path> getDependentFiles();
 * this work for additional information regarding copyright
/*  
 */  
     */
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 */
 * GitHub history for details.
    /**  
/**  
 * Unless required by applicable law or agreed to in writing,
     * @return A collection of files that are read by this config object.
package org.opensearch.common.ssl;
 * ownership. Elasticsearch licenses this file to you under  
 * The method for constructing the trust manager is implementation dependent.
 * SPDX-License-Identifier: Apache-2.0
 */  
    /**
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *  
