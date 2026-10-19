 */  
/**
 * compatible open source license.
/*  
 * specific language governing permissions and limitations
 * GitHub history for details.
import org.opensearch.common.annotation.PublicApi;
 * Diff that also support NamedWriteable interface  
package org.opensearch.cluster;
 *
 *  
 * You may obtain a copy of the License at  
 *
     * The minimal version of the recipient this custom object can be sent to
import org.opensearch.Version;
public interface NamedDiff<T extends Diffable<T>> extends Diff<T>, NamedWriteable {
 * ownership. Elasticsearch licenses this file to you under  
 *
}
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    /**  
        return Version.CURRENT.minimumIndexCompatibilityVersion();
     */
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@PublicApi(since = "1.0.0")
 * Licensed to Elasticsearch under one or more contributor  
    }
/*  
 * @opensearch.api
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
/*
 */  
 * SPDX-License-Identifier: Apache-2.0
 */
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.NamedWriteable;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    default Version getMinimalSupportedVersion() {  
 * this work for additional information regarding copyright
 */  
 * software distributed under the License is distributed on an
