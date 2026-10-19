 * @opensearch.internal
import org.opensearch.core.common.io.stream.VersionedNamedWriteable;
 */
    }
package org.opensearch.cluster;
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
/**
 * this file be licensed under the Apache-2.0 license or a
 *
 * not use this file except in compliance with the License.
        return Version.CURRENT.minimumCompatibilityVersion();  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Licensed to Elasticsearch under one or more contributor  
public interface NamedDiffable<T> extends Diffable<T>, VersionedNamedWriteable {  
 * compatible open source license.
import org.opensearch.Version;
 * SPDX-License-Identifier: Apache-2.0
 */
 * You may obtain a copy of the License at  
 * Diff that also support {@link VersionedNamedWriteable} interface
 *  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
    default Version getMinimalSupportedVersion() {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 *
/*  
    @Override
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * specific language governing permissions and limitations
}
 * The OpenSearch Contributors require contributions made to  
/*  
 */  
/*
 * ownership. Elasticsearch licenses this file to you under  
