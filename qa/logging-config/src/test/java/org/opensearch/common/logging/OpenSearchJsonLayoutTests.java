/*
                "\"message\": \"%notEmpty{%enc{%marker}{JSON} }%enc{%.-10000m}{JSON}\"" +  
                                          .build();
                "\"type\": \"server\", " +
import org.hamcrest.Matchers;
        OpenSearchJsonLayout server = OpenSearchJsonLayout.newBuilder()
                "%notEmpty{, %node_and_cluster_id }" +
                "\"level\": \"%p\", " +
 * Licensed to Elasticsearch under one or more contributor  
}
                "\"cluster.name\": \"${sys:opensearch.logs.cluster_name}\", " +
                "\"timestamp\": \"%d{yyyy-MM-dd'T'HH:mm:ss,SSSZZ}\", " +
 * SPDX-License-Identifier: Apache-2.0
                "\"level\": \"%p\", " +
        String conversionPattern = server.getPatternLayout().getConversionPattern();
                "\"message\": \"%notEmpty{%enc{%marker}{JSON} }%enc{%.-42m}{JSON}\"" +
                "%notEmpty{, %node_and_cluster_id }" +
                "\"node.name\": \"%node_name\", " +  
    public void testEmptyType() {  
 */  
                "\"cluster.name\": \"${sys:opensearch.logs.cluster_name}\", " +
                "%exceptionAsJson }" + System.lineSeparator()));
            .build();  
    public void testWithUnrestrictedMaxMessageLengthLayout() {
                "\"type\": \"server\", " +
        String conversionPattern = server.getPatternLayout().getConversionPattern();
                "%exceptionAsJson }" + System.lineSeparator()));  
            .setType("server")
 *
            .build();
                "%notEmpty{, \"someOtherField\": \"%enc{%OpenSearchMessageField{someOtherField}}{JSON}\"}" +
    }
                "\"type\": \"server\", " +  
 * the Apache License, Version 2.0 (the "License"); you may
                "\"timestamp\": \"%d{yyyy-MM-dd'T'HH:mm:ss,SSSZZ}\", " +
                                          .setOpenSearchMessageFields("message")
                "\"node.name\": \"%node_name\", " +
            "{" +  
            "{" +
        String conversionPattern = server.getPatternLayout().getConversionPattern();  
                "\"level\": \"%p\", " +  
    }
    public void testLayoutWithAdditionalFields() {  
                "\"cluster.name\": \"${sys:opensearch.logs.cluster_name}\", " +
                "\"component\": \"%c{1.}\", " +  
                "\"component\": \"%c{1.}\", " +  
                                          .build();
 * The OpenSearch Contributors require contributions made to  
    }
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        assertThat(conversionPattern, Matchers.equalTo(  
    public static void initNodeName() {
                "\"cluster.name\": \"${sys:opensearch.logs.cluster_name}\", " +
                "\"cluster.name\": \"${sys:opensearch.logs.cluster_name}\", " +  
    @BeforeClass
 * this work for additional information regarding copyright
                "\"level\": \"%p\", " +
                                          .setType("server")  
public class OpenSearchJsonLayoutTests extends OpenSearchTestCase {  
                                          .setType("server")
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
                "\"timestamp\": \"%d{yyyy-MM-dd'T'HH:mm:ss,SSSZZ}\", " +  
 * Modifications Copyright OpenSearch Contributors. See  
        String conversionPattern = server.getPatternLayout().getConversionPattern();
        OpenSearchJsonLayout server = OpenSearchJsonLayout.newBuilder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                "%exceptionAsJson }" + System.lineSeparator()));
 *  
            "{" +
 * under the License.  
    }
 * KIND, either express or implied.  See the License for the
                                          .setType("server")  
        expectThrows(IllegalArgumentException.class, () -> OpenSearchJsonLayout.newBuilder().build());
 */
    }  
                "\"node.name\": \"%node_name\"" +  
    }
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at  
                                          .setOpenSearchMessageFields("x-opaque-id,someOtherField")  
        OpenSearchJsonLayout server = OpenSearchJsonLayout.newBuilder()
        assertThat(conversionPattern, Matchers.equalTo(
 * this file be licensed under the Apache-2.0 license or a
    public void testLayout() {
            .setMaxMessageLength(0)
        assertThat(conversionPattern, Matchers.equalTo(
                "%exceptionAsJson }" + System.lineSeparator()));  
 * software distributed under the License is distributed on an
                "\"node.name\": \"%node_name\", " +
            .setType("server")  
                "%notEmpty{, \"x-opaque-id\": \"%enc{%OpenSearchMessageField{x-opaque-id}}{JSON}\"}" +
 * not use this file except in compliance with the License.
 *
                "%notEmpty{, %node_and_cluster_id }" +  
                "%notEmpty{, %node_and_cluster_id }" +  
                "\"node.name\": \"%node_name\", " +
 */
        JsonLogsTestSetup.init();  
                "%notEmpty{, %node_and_cluster_id }" +
        assertThat(conversionPattern, Matchers.equalTo(
/*  
            "{" +
import org.junit.BeforeClass;  
        String conversionPattern = server.getPatternLayout().getConversionPattern();  
        OpenSearchJsonLayout server = OpenSearchJsonLayout.newBuilder()
                "%notEmpty{, \"message\": \"%enc{%OpenSearchMessageField{message}}{JSON}\"}" +
    public void testWithMaxMessageLengthLayout() {
                "\"level\": \"%p\", " +  
                "\"timestamp\": \"%d{yyyy-MM-dd'T'HH:mm:ss,SSSZZ}\", " +
                "\"type\": \"server\", " +  
            .setMaxMessageLength(42)
                "\"component\": \"%c{1.}\", " +
        OpenSearchJsonLayout server = OpenSearchJsonLayout.newBuilder()  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.common.logging;
                "%exceptionAsJson }" + System.lineSeparator()));
    public void testLayoutWithAdditionalFieldOverride() {
                "\"component\": \"%c{1.}\", " +
                "\"type\": \"server\", " +
 * specific language governing permissions and limitations
    }
                "\"timestamp\": \"%d{yyyy-MM-dd'T'HH:mm:ss,SSSZZ}\", " +
/*
                "\"component\": \"%c{1.}\", " +
        assertThat(conversionPattern, Matchers.equalTo(
                "\"message\": \"%notEmpty{%enc{%marker}{JSON} }%enc{%.-10000m}{JSON}\"" +  
            "{" +  
                                          .build();
                "\"message\": \"%notEmpty{%enc{%marker}{JSON} }%enc{%m}{JSON}\"" +
