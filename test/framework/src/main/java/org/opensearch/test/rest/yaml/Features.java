        return SUPPORTED.contains(feature);
            "stash_path_replace",  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
 * this file be licensed under the Apache-2.0 license or a
 * breaking others runners till they have implemented the new feature as well.  
package org.opensearch.test.rest.yaml;
    }  
 * this work for additional information regarding copyright
 * under the License.  
 * software distributed under the License is distributed on an
 * and the related skip sections can be removed from the tests as well.  
 */
 * Allows to register additional features supported by the tests runner.
 * Modifications Copyright OpenSearch Contributors. See
        }  
import static java.util.Collections.unmodifiableList;
import java.util.Arrays;
/*  
        )
 *
    );
    private Features() {  
    public static boolean areAllSupported(List<String> features) {
 * not use this file except in compliance with the License.
            if (false == isSupported(feature)) {  
            "stash_in_path",
 * Licensed to Elasticsearch under one or more contributor  
public final class Features {
/*  
 *
            "embedded_stash_key",
        Arrays.asList(
 */  
}
 * Unless required by applicable law or agreed to in writing,
     * Tells whether all the features provided as argument are supported
            "transform_and_set",
/*
    /**
import java.util.List;
 * Once all runners have implemented the feature, it can be removed from the list
            "warnings",
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
            "stash_in_key",
 */
    private static final String SPI_ON_CLASSPATH_SINCE_JDK_9 = "spi_on_classpath_jdk9";
    }
    private static boolean isSupported(String feature) {
 * KIND, either express or implied.  See the License for the
 * This way any runner can add extra features and use proper skip sections to avoid
 * <p>
            }
    private static final List<String> SUPPORTED = unmodifiableList(  
            "catch_unauthorized",
            "arbitrary_key",
        }
            "headers",
 * SPDX-License-Identifier: Apache-2.0
        if (feature.equals(SPI_ON_CLASSPATH_SINCE_JDK_9)) {
 */  
            "default_shards",  
 * GitHub history for details.
    }
            "yaml",
        return true;
 *  
        for (String feature : features) {
 * license agreements. See the NOTICE file distributed with
            "node_selector",  
            return true;  
 *     http://www.apache.org/licenses/LICENSE-2.0
     */  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            "contains",  
 * ownership. Elasticsearch licenses this file to you under  
            "allowed_warnings"  
 * compatible open source license.
                return false;
