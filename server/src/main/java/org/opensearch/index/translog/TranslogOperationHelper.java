/*  
    private TranslogOperationHelper() {}
        if (source1 == null || source2 == null) {
 *
    public boolean hasSameIndexOperation(Translog.Index op1, Translog.Index op2) {  
    }
        } catch (Exception e) {
package org.opensearch.index.translog;
        };  
import org.opensearch.common.annotation.PublicApi;  
 *
/**
            Map<String, Object> map1 = XContentHelper.convertToMap(source1, true).v2();
        }  
            }
        return new TranslogOperationHelper() {
 */  
    }
        if (source1 == null && source2 == null) {
            leafReader.storedFields().document(0, visitor); // As reader will have only a single document, segment level doc id will be 0  
            && op1.version() == op2.version();  
        // Convert both sources to ordered maps
                    && op1.seqNo() == op2.seqNo()
                    && op1.version() == op2.version();  
 * SPDX-License-Identifier: Apache-2.0
            return null;  
 * regenerate the source and perform the deep equal of both sources.
 * Helper class for comparing two index operations with the support of derived source, for which we will have to first  
import java.util.Objects;  
    public static TranslogOperationHelper create(final EngineConfig engineConfig) {  
            Map<String, Object> map2 = XContentHelper.convertToMap(source2, true).v2();
import org.apache.logging.log4j.LogManager;
        } catch (IOException e) {
public abstract class TranslogOperationHelper {  
 * compatible open source license.
import org.opensearch.common.xcontent.XContentHelper;
        }
    private static BytesReference deriveSource(Translog.Index op, EngineConfig engineConfig) {  
            return visitor.source();
                    hasSameOp &= (compareSourcesWithOrder(deriveSource(op1, engineConfig), op2.source())
@PublicApi(since = "3.1.0")
                        || compareSourcesWithOrder(op1.source(), deriveSource(op2, engineConfig)));  
    }
            return false;  
                }  
        return Objects.equals(op1.id(), op2.id())
import org.opensearch.index.engine.EngineConfig;  
 * this file be licensed under the Apache-2.0 license or a
                return hasSameOp;
import org.apache.logging.log4j.Logger;
                boolean hasSameOp = Objects.equals(op1.id(), op2.id())
                if (engineConfig.getIndexSettings().isDerivedSourceEnabled()) {
            public boolean hasSameIndexOperation(Translog.Index op1, Translog.Index op2) {
    };
import java.util.Map;
import org.opensearch.index.engine.TranslogLeafReader;
            final FieldsVisitor visitor = new FieldsVisitor(true);
        try (TranslogLeafReader leafReader = new TranslogLeafReader(op, engineConfig)) {
            && op1.primaryTerm() == op2.primaryTerm()
            return Objects.deepEquals(map1, map2);
import org.opensearch.index.fieldvisitor.FieldsVisitor;
                    hasSameOp &= Objects.equals(op1.source(), op2.source());
                    && op1.primaryTerm() == op2.primaryTerm()
    }
 * The OpenSearch Contributors require contributions made to  
    public static boolean compareSourcesWithOrder(BytesReference source1, BytesReference source2) {
    private static final Logger logger = LogManager.getLogger(TranslogOperationHelper.class);
            @Override  
import java.io.IOException;
            && op1.seqNo() == op2.seqNo()
            // Invalid source  
                    && Objects.equals(op1.routing(), op2.routing())  
            return false;
 * @opensearch.internal  
import org.opensearch.core.common.bytes.BytesReference;
                } else {
    public static final TranslogOperationHelper DEFAULT = new TranslogOperationHelper() {
            return true;  
            && Objects.equals(op1.routing(), op2.routing())  
 */
            && Objects.equals(op1.source(), op2.source())
            logger.error("Failed to convert source to map", e);
        }
}
        try {  
        }
