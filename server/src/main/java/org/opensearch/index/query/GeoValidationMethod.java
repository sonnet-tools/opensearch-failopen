        } else {
 */
 */  
    /** Returns whether or not to try and fix broken/wrapping bounding boxes. */  
import java.io.IOException;  
        return (method == GeoValidationMethod.IGNORE_MALFORMED || method == GeoValidationMethod.COERCE);  
    public static boolean isCoerce(GeoValidationMethod method) {
            if (method.name().equalsIgnoreCase(op)) {
            return GeoValidationMethod.COERCE;
/*
        out.writeVInt(this.ordinal());
        return method == GeoValidationMethod.COERCE;
    IGNORE_MALFORMED,
}
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
        }
    COERCE,
 *  
    public static final boolean DEFAULT_LENIENT_PARSING = (DEFAULT != STRICT);  
 * KIND, either express or implied.  See the License for the
 *
        if (coerce) {
 *
 * <p>
    @Override  
    STRICT;  
 */
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
public enum GeoValidationMethod implements Writeable {  
 * Unless required by applicable law or agreed to in writing,
            "operator needs to be either " + CollectionUtils.arrayAsArrayList(GeoValidationMethod.values()) + ", but not [" + op + "]"  
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    public static boolean isIgnoreMalformed(GeoValidationMethod method) {
    /** Returns whether or not to skip bounding box validation. */
 *  On IGNORE_MALFORMED invalid coordinates are being accepted.
package org.opensearch.index.query;
 * specific language governing permissions and limitations
 *  
    }
/**
    }
        for (GeoValidationMethod method : GeoValidationMethod.values()) {  
                return method;
 * not use this file except in compliance with the License.
    /** Returns validation method corresponding to given coerce and ignoreMalformed values. */
        return GeoValidationMethod.values()[in.readVInt()];  
    }
import org.opensearch.core.common.io.stream.Writeable;  
 * license agreements. See the NOTICE file distributed with
    public static final GeoValidationMethod DEFAULT = STRICT;
 * GitHub history for details.
 * This enum is used to determine how to deal with invalid geo coordinates in geo related  
        );
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 *  On COERCE invalid coordinates are being corrected to the most likely valid coordinate.
 * ownership. Elasticsearch licenses this file to you under  
 */  
 *  On STRICT validation invalid coordinates cause an exception to be thrown.  
 * compatible open source license.
import org.opensearch.core.common.util.CollectionUtils;
            return GeoValidationMethod.STRICT;  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        throw new IllegalArgumentException(
    public static GeoValidationMethod infer(boolean coerce, boolean ignoreMalformed) {  
            }  
    public static GeoValidationMethod fromString(String op) {
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal
            return GeoValidationMethod.IGNORE_MALFORMED;
 * queries:
    }  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
        }
    public static GeoValidationMethod readFromStream(StreamInput in) throws IOException {
    }
        } else if (ignoreMalformed) {  
