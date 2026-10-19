        return resolver;
 * software distributed under the License is distributed on an
    }
        this.priority = priority;
    }
    }
 */  
 * not use this file except in compliance with the License.
 *  
package org.opensearch.gradle;
 *
 * Modifications Copyright OpenSearch Contributors. See
    }  
    private Resolver resolver;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class DistributionResolution {  
 */  
}
 * The OpenSearch Contributors require contributions made to  
        this.name = name;  
    private int priority;  
 * under the License.  
import org.gradle.api.Project;
    public void setResolver(Resolver resolver) {
        DistributionDependency resolve(Project project, OpenSearchDistribution distribution);  
    private String name;
    }
    public interface Resolver {
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    }  
    }
 * compatible open source license.
/*
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
    public String getName() {  
/*  
        return priority;
    public DistributionResolution(String name) {
        this.resolver = resolver;  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
/*  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    public Resolver getResolver() {
 * this work for additional information regarding copyright
    public int getPriority() {
 *
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
        return name;
    public void setPriority(int priority) {  
 */
 * license agreements. See the NOTICE file distributed with
