 * <li>A user (unsafely) meddles with the contents of the data path, maybe restoring an old index folder from a backup</li>
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * <li>A user overflows the index graveyard by deleting more than 500 indices while a node is offline and then the node rejoins the
 * <li>A cluster loses all cluster-manager nodes and those are (unsafely) restored from backup, but the backup does not contain the index</li>
 */  
 *  
 * under the License.  
 *  
/*
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * GitHub history for details.
 */
 * license agreements. See the NOTICE file distributed with
 * <li>A node (unsafely) moves from one cluster to another, perhaps because the original cluster lost all its cluster-manager nodes</li>
 *
/**
/*  
 * <ul>
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * number of situations, such as:
 * this work for additional information regarding copyright
package org.opensearch.action.admin.indices.dangling;
/*  
 * Unless required by applicable law or agreed to in writing,
 */  
 * </ul>
 * You may obtain a copy of the License at  
 *
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * Dangling indices are indices that exist on disk on one or more nodes but  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * <li>A disk partially fails and the user has no replicas and no snapshots and wants to (unsafely) recover whatever they can</li>  
 * cluster</li>  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 */
 * <p>The classes in this package form an API for managing dangling indices, allowing them to be listed, imported or deleted.
 * the Apache License, Version 2.0 (the "License"); you may
 * which do not currently exist in the cluster state. They arise in a
