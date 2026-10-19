 * average models are used by the MovAvg aggregation
 * @opensearch.internal
 *
import org.opensearch.core.xcontent.ToXContentFragment;
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 */
 *  
/*
 */  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
}  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public interface MovAvgModelBuilder extends ToXContentFragment {  
/*  
package org.opensearch.search.aggregations.pipeline;
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * compatible open source license.
 * under the License.  
/**  
 * SPDX-License-Identifier: Apache-2.0
 * Represents the common interface that all moving average models share. Moving
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 *  
 *
 * Licensed to Elasticsearch under one or more contributor  
    MovAvgModel build();
 */
/*  
