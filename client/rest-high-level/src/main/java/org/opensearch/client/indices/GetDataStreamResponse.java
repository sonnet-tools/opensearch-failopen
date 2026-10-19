 * ownership. Elasticsearch licenses this file to you under  
        if (getClass() != obj.getClass()) {
        List<DataStream> thisList = new ArrayList<>(this.dataStreams);
    }  
import org.opensearch.core.xcontent.XContentParser;  
                    templates.add(DataStream.fromXContent(parser));
    }  
import java.util.List;  
 */  
 *
        if (obj == null) {
public class GetDataStreamResponse {  
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
        return dataStreams;  
        return Objects.equals(new HashSet<>(this.dataStreams), new HashSet<>(other.dataStreams));
}
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
    }
    }
    public String toString() {  
 * specific language governing permissions and limitations
        }  
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            if (token == XContentParser.Token.START_ARRAY) {  
 * SPDX-License-Identifier: Apache-2.0
        thisList.sort(Comparator.comparing(DataStream::getName));
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
 *  
import java.util.ArrayList;  
 * compatible open source license.
    public List<DataStream> getDataStreams() {
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
 * license agreements. See the NOTICE file distributed with
/*
            return false;
 * Modifications Copyright OpenSearch Contributors. See  
    public boolean equals(Object obj) {  
            return true;
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        this.dataStreams = dataStreams;
        for (XContentParser.Token token = parser.nextToken(); token != XContentParser.Token.END_OBJECT; token = parser.nextToken()) {
        if (this == obj) {
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;
    }  
import java.util.Objects;
        return "GetDataStreamResponse [dataStreams=" + thisList + "]";  
                }  
/*
    public static GetDataStreamResponse fromXContent(XContentParser parser) throws IOException {  
 * GitHub history for details.
        return new GetDataStreamResponse(templates);  
        final List<DataStream> templates = new ArrayList<>();
        }  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return Objects.hash(new HashSet<>(this.dataStreams));
 * KIND, either express or implied.  See the License for the
import java.util.Comparator;
    public int hashCode() {
/*  
 */
        }
    private final List<DataStream> dataStreams;
        }  
        GetDataStreamResponse other = (GetDataStreamResponse) obj;
    GetDataStreamResponse(List<DataStream> dataStreams) {
package org.opensearch.client.indices;
            }
            return false;
 * software distributed under the License is distributed on an
    }
 */
    @Override
import java.io.IOException;
 * under the License.  
