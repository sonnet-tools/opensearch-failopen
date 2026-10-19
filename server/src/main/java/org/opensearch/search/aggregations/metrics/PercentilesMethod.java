 * specific language governing permissions and limitations
            return new PercentilesConfig.Hdr(in);  
    TDIGEST("tdigest", "TDigest", "TDIGEST") {  
 * software distributed under the License is distributed on an
package org.opensearch.search.aggregations.metrics;
    HDR("hdr", "HDR") {  
        TDIGEST_PARSER = new ObjectParser<>(PercentilesMethod.TDIGEST.getParseField().getPreferredName(), PercentilesConfig.TDigest::new);  
    private final ParseField parseField;
    @Override
 * An enum representing the methods for calculating percentiles
        return in.readEnum(PercentilesMethod.class);
 *  
 * under the License.  
    PercentilesMethod(String name, String... deprecatedNames) {  
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
        PercentilesConfig configFromStream(StreamInput in) throws IOException {
 * KIND, either express or implied.  See the License for the
        @Override
    /**  
        HDR_PARSER.declareInt(PercentilesConfig.Hdr::setNumberOfSignificantValueDigits, NUMBER_SIGNIFICANT_DIGITS_FIELD);
    }
    public void writeTo(StreamOutput out) throws IOException {  
    public static final ParseField COMPRESSION_FIELD = new ParseField("compression");
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;
    @Override
import org.opensearch.core.xcontent.ObjectParser;
 * You may obtain a copy of the License at  
        }
public enum PercentilesMethod implements Writeable {
 *
 *
    }
import java.io.IOException;
    /**  
    }
     */
    }  
 * GitHub history for details.
        HDR_PARSER = new ObjectParser<>(PercentilesMethod.HDR.getParseField().getPreferredName(), PercentilesConfig.Hdr::new);  
/*  
     * The TDigest method for calculating percentiles
     */
 */
    public static final ObjectParser<PercentilesConfig.TDigest, String> TDIGEST_PARSER;
    }
 * license agreements. See the NOTICE file distributed with
        return parseField.getPreferredName();  
 * @opensearch.internal  
 * this work for additional information regarding copyright
     * The HDRHistogram method of calculating percentiles
    static {
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
        PercentilesConfig configFromStream(StreamInput in) throws IOException {
    public String toString() {
     */
    public ParseField getParseField() {  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
    public static final ObjectParser<PercentilesConfig.Hdr, String> HDR_PARSER;
        }
    /**  
/*
    public static PercentilesMethod readFromStream(StreamInput in) throws IOException {
     * @return the name of the method
 * The OpenSearch Contributors require contributions made to  
}  
        @Override
import org.opensearch.core.ParseField;
    };
    }
        return parseField;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public static final ParseField NUMBER_SIGNIFICANT_DIGITS_FIELD = new ParseField("number_of_significant_value_digits");
 * this file be licensed under the Apache-2.0 license or a
    abstract PercentilesConfig configFromStream(StreamInput in) throws IOException;
    static {
        TDIGEST_PARSER.declareDouble(PercentilesConfig.TDigest::setCompression, COMPRESSION_FIELD);
/*  
        this.parseField = new ParseField(name, deprecatedNames);
 *    http://www.apache.org/licenses/LICENSE-2.0
            return new PercentilesConfig.TDigest(in);  
        out.writeEnum(this);
    },
 */
    }
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
