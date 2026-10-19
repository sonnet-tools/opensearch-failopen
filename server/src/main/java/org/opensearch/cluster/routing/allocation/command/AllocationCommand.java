 * software distributed under the License is distributed on an
     * Executes the command on a {@link RoutingAllocation} setup
 * A command to move shards in some way.  
 * Unless required by applicable law or agreed to in writing,
 *
import org.opensearch.core.xcontent.ToXContentObject;
    }  
@PublicApi(since = "1.0.0")  
/*  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
import org.opensearch.common.network.NetworkModule;
 */
/**
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * Commands are registered in {@link NetworkModule}.
 * @opensearch.api
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        return Optional.empty();
 */
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * ownership. Elasticsearch licenses this file to you under  
    default String getWriteableName() {
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**  
/*  
import org.opensearch.core.common.io.stream.NamedWriteable;  
     * Returns any feedback the command wants to provide for logging. This message should be appropriate to expose to the user after the
/*
    /**  
package org.opensearch.cluster.routing.allocation.command;
    RerouteExplanation execute(RoutingAllocation allocation, boolean explain);
public interface AllocationCommand extends NamedWriteable, ToXContentObject {
 *  
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 *
import org.opensearch.cluster.routing.allocation.RerouteExplanation;
 * license agreements. See the NOTICE file distributed with
    @Override
     * command has been applied
 * compatible open source license.
     */  
     * Get the name of the command
import org.opensearch.common.annotation.PublicApi;
 * KIND, either express or implied.  See the License for the
        return name();  
 * under the License.  
    default Optional<String> getMessage() {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
     * @return name of the command
 *  
    /**  
     * @throws OpenSearchException if something happens during reconfiguration  
}
    String name();
     */  
     */
import org.opensearch.OpenSearchException;
     * @param allocation {@link RoutingAllocation} to modify
    }
 * <p>
import java.util.Optional;  
