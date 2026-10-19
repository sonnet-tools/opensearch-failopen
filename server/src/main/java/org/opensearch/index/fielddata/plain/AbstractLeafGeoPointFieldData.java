 */  
package org.opensearch.index.fielddata.plain;
 */
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.Collections;
    }
            public void close() {}
 * The OpenSearch Contributors require contributions made to  
            @Override  
    @Override
/*
    }
            @Override
            @Override
                return FieldData.emptyMultiGeoPoints();  
                return 0;
            public MultiGeoPointValues getGeoPointValues() {
 * You may obtain a copy of the License at  
import org.apache.lucene.util.Accountable;  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    public final ScriptDocValues.GeoPoints getScriptValues() {
 * Licensed to Elasticsearch under one or more contributor  
        return FieldData.toString(getGeoPointValues());
        };
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
/**
        return new AbstractLeafGeoPointFieldData() {
 *
/*
import java.util.Collection;
    }  
 * this work for additional information regarding copyright
public abstract class AbstractLeafGeoPointFieldData implements LeafGeoPointFieldData {  
 * license agreements. See the NOTICE file distributed with
            public Collection<Accountable> getChildResources() {  
 * Unless required by applicable law or agreed to in writing,
            }
import org.opensearch.index.fielddata.ScriptDocValues;
 * GitHub history for details.
    public static LeafGeoPointFieldData empty(final int maxDoc) {  
            }  
            public long ramBytesUsed() {
import org.opensearch.index.fielddata.MultiGeoPointValues;  
                return Collections.emptyList();
 * under the License.  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
            @Override
 * KIND, either express or implied.  See the License for the
 *  
    @Override
import org.opensearch.index.fielddata.SortedBinaryDocValues;
    public final SortedBinaryDocValues getBytesValues() {  
 * not use this file except in compliance with the License.
        return new ScriptDocValues.GeoPoints(getGeoPointValues());  
 */
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 * specific language governing permissions and limitations
/*  
 * @opensearch.internal
 * compatible open source license.
import org.opensearch.index.fielddata.LeafGeoPointFieldData;
            }
}
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.fielddata.FieldData;
 * Base class for retrieving LatLonPoint docvalues
