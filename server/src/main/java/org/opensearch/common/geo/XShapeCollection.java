/*  
}  
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.locationtech.spatial4j.shape.Shape;
import org.locationtech.spatial4j.context.SpatialContext;  
 * ownership. Elasticsearch licenses this file to you under  
    public boolean pointsOnly() {
 */  
 * GitHub history for details.
 *  
 * compatible open source license.
/*
/**
 *
    }
package org.opensearch.common.geo;
/*  
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 *
 * software distributed under the License is distributed on an
    private boolean pointsOnly = false;
import org.locationtech.spatial4j.shape.ShapeCollection;
 * SPDX-License-Identifier: Apache-2.0
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
    public XShapeCollection(List<S> shapes, SpatialContext ctx) {
 * You may obtain a copy of the License at  
        this.pointsOnly = pointsOnly;
 * under the License.  
        super(shapes, ctx);
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        return this.pointsOnly;  
 * KIND, either express or implied.  See the License for the
import java.util.List;
    }  
 * Extends spatial4j ShapeCollection for points_only shape indexing support
 */  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
public class XShapeCollection<S extends Shape> extends ShapeCollection<S> {  
 * Licensed to Elasticsearch under one or more contributor  
 */
    public void setPointsOnly(boolean pointsOnly) {  
