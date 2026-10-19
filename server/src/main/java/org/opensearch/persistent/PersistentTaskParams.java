 *  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.io.stream.VersionedNamedWriteable;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
}  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterState;
/*
/*  
 * Parameters used to start persistent task  
 */
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
 *
 */  
 */  
 * SPDX-License-Identifier: Apache-2.0
/**
 * GitHub history for details.
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
public interface PersistentTaskParams extends VersionedNamedWriteable, ToXContentObject, ClusterState.FeatureAware {
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ToXContentObject;  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 */  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 *
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.persistent;
