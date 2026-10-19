    protected static final String PARSE_FIELD_NAME = "acknowledged";
    public boolean isAcknowledged() {
    );  
        }
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Objects;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
import java.io.IOException;
        p.declareBoolean(constructorArg(), new ParseField(parseField));
            return true;
 *    http://www.apache.org/licenses/LICENSE-2.0
public class AcknowledgedResponse {
        return PARSE_FIELD_NAME;
    }
 * this work for additional information regarding copyright
 *  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
        return PARSER.parse(parser, null);
package org.opensearch.client.core;
 */
import org.opensearch.core.xcontent.XContentParser;  
            return false;
    }
    private final boolean acknowledged;
    protected String getFieldName() {  
 * software distributed under the License is distributed on an
        AcknowledgedResponse::new,
        return p;  
        ConstructingObjectParser<T, Void> p = new ConstructingObjectParser<>(name, true, args -> ctor.apply((boolean) args[0]));
import org.opensearch.core.ParseField;
 * KIND, either express or implied.  See the License for the
    public boolean equals(Object o) {
 * You may obtain a copy of the License at  
    }  
    }
    }
        AcknowledgedResponse.PARSE_FIELD_NAME
        if (o == null || getClass() != o.getClass()) {  
import java.util.function.Function;
     */
 */  
 * ownership. Elasticsearch licenses this file to you under  
 */  
}  
    public static AcknowledgedResponse fromXContent(final XContentParser parser) throws IOException {  
    protected static <T> ConstructingObjectParser<T, Void> generateParser(String name, Function<Boolean, T> ctor, String parseField) {  
        }
     * @return the field name this response uses to output the acknowledged flag
    public AcknowledgedResponse(final boolean acknowledged) {
    }
 * The OpenSearch Contributors require contributions made to  
        "acknowledged_response",  
 * GitHub history for details.
        this.acknowledged = acknowledged;
/*
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
 * Modifications Copyright OpenSearch Contributors. See
 *
        return isAcknowledged() == that.isAcknowledged();
        final AcknowledgedResponse that = (AcknowledgedResponse) o;  
 * compatible open source license.
    @Override
    public int hashCode() {
 * Licensed to Elasticsearch under one or more contributor  
    private static final ConstructingObjectParser<AcknowledgedResponse, Void> PARSER = AcknowledgedResponse.generateParser(
        if (this == o) {  
/*  
 * not use this file except in compliance with the License.
    /**  
        return acknowledged;  
/*  
        return Objects.hash(acknowledged);  
 *
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
