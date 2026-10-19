 */
     * @param usedName the provided field name  
 * not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at  
        public void usedDeprecatedField(String parserName, Supplier<XContentLocation> location, String usedName, String replacedWith) {
    DeprecationHandler IGNORE_DEPRECATIONS = new DeprecationHandler() {
                throw new UnsupportedOperationException(
     * Called when the provided field name matches a deprecated name for the field.
     */
     * Called when the provided field name matches the current field but the entire
            } else {
                        + "] but got ["
     * Called when the provided field name matches the current field but the entire
                        + usedName  
     * field has been marked as deprecated and another field should be used  
                throw new UnsupportedOperationException(
 * license agreements. See the NOTICE file distributed with
                    "deprecated fields not supported in ["  
                        + location.get()
                        + "] at ["
    /**  
/*
                        + parserName
/*  
@PublicApi(since = "1.0.0")
        }  
}
import org.opensearch.common.annotation.PublicApi;
     * field has been marked as deprecated with no replacement
            if (parserName != null) {
/*  
    DeprecationHandler THROW_UNSUPPORTED_OPERATION = new DeprecationHandler() {
    /**
 *
     */  
 * the Apache License, Version 2.0 (the "License"); you may
     */  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (parserName != null) {
                        + usedName  
 *
     * Throws an {@link UnsupportedOperationException} when parsing hits a
            if (parserName != null) {
 * GitHub history for details.
     * that won't interact with deprecation logic at all or when you want
 * under the License.  
        }  
                );
        public void usedDeprecatedName(String parserName, Supplier<XContentLocation> location, String usedName, String modernName) {  
                        + "] at ["
        @Override
                );
                        + parserName
 * specific language governing permissions and limitations
                    "deprecated fields not supported here but got [" + usedName + "] which is a deprecated name for [" + replacedWith + "]"  
                throw new UnsupportedOperationException(
        public void usedDeprecatedName(String parserName, Supplier<XContentLocation> location, String usedName, String modernName) {  
                );  
                    "deprecated fields not supported here but got [" + usedName + "] which has been replaced with [" + modernName + "]"  
                        + "] which has been deprecated entirely"  
        public void usedDeprecatedField(String parserName, Supplier<XContentLocation> location, String usedName, String replacedWith) {  
                        + modernName
        @Override  
                        + "]"
            }
                    "deprecated fields not supported in ["  
 * parsing hit a deprecated field.
 * Unless required by applicable law or agreed to in writing,
                        + parserName
                        + "] which is a deprecated name for ["  
        @Override
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
            } else {
                throw new UnsupportedOperationException(  
     */
     * to fail fast when parsing deprecated fields.
     * Ignores all deprecations
                        + location.get()
/**
    /**
        @Override
                        + "] which has been replaced with ["  
 * compatible open source license.
        }
                        + location.get()
                );
 * The OpenSearch Contributors require contributions made to  
        public void usedDeprecatedField(String parserName, Supplier<XContentLocation> location, String usedName) {
    void usedDeprecatedField(String parserName, Supplier<XContentLocation> location, String usedName);
            }  
    void usedDeprecatedName(String parserName, Supplier<XContentLocation> location, String usedName, String modernName);
                    "deprecated fields not supported here but got [" + usedName + "] which has been deprecated entirely"
                        + "] but got ["
     */  
    /**
    };
 */
     * @param modernName the modern name for the field  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.function.Supplier;  
package org.opensearch.core.xcontent;
    /**  
        @Override
        }  
                    "deprecated fields not supported in ["  
public interface DeprecationHandler {  
     * deprecated field. Use this when creating an {@link XContentParser}  
 * this work for additional information regarding copyright
     * @param replacedWith the name of the field that replaced this field
                        + usedName  
                );  
                        + "] but got ["
 * @opensearch.api  
        }
 */  
        @Override
                        + "] at ["
                        + "]"
                throw new UnsupportedOperationException(
                throw new UnsupportedOperationException(
    };
     * @param usedName the provided field name
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
    void usedDeprecatedField(String parserName, Supplier<XContentLocation> location, String usedName, String replacedWith);
 * software distributed under the License is distributed on an
            } else {
                );
        public void usedDeprecatedField(String parserName, Supplier<XContentLocation> location, String usedName) {  
 * Callback for notifying the creator of the {@link XContentParser} that  
     * @param usedName the provided field name
                        + replacedWith
 */  
            }
 * Modifications Copyright OpenSearch Contributors. See
