    CREATE_INDEX;
    METADATA_WRITE,  
}  
 *
 * GitHub history for details.
 * @opensearch.api
 */  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 */  
    public static final EnumSet<ClusterBlockLevel> READ_WRITE = EnumSet.of(READ, WRITE);
 * under the License.  
 *
    READ,  
 *
 * KIND, either express or implied.  See the License for the
 */
    public static final EnumSet<ClusterBlockLevel> ALL = EnumSet.allOf(ClusterBlockLevel.class);  
 * What level to block the cluster  
package org.opensearch.cluster.block;
/*
    public static final EnumSet<ClusterBlockLevel> WRITE_BLOCK = EnumSet.of(WRITE);
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * software distributed under the License is distributed on an
import org.opensearch.common.annotation.PublicApi;
    METADATA_READ,
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
/**
public enum ClusterBlockLevel {
 * this file be licensed under the Apache-2.0 license or a
import java.util.EnumSet;  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    WRITE,
