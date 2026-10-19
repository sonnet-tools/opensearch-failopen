        }
        ) {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        this.featureType = featureType;  
            throw new RuntimeException("Cannot parse rule from index.");  
    private final FeatureType featureType;
 * The OpenSearch Contributors require contributions made to  
/*  
import org.apache.logging.log4j.LogManager;
 */  
     * @param featureType  
 * compatible open source license.
import org.opensearch.core.xcontent.XContentParser;
    public XContentRuleParser(FeatureType featureType) {
     */
@ExperimentalApi
/**
    }
    public Rule parse(String src) {
import org.opensearch.rule.RuleEntityParser;
import org.apache.logging.log4j.Logger;
    @Override  
            XContentParser parser = MediaTypeRegistry.JSON.xContent()  
import java.io.IOException;  
import org.opensearch.rule.autotagging.Rule;
    /**
import org.opensearch.common.annotation.ExperimentalApi;  
}  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, src)
import org.opensearch.core.xcontent.DeprecationHandler;
import org.opensearch.rule.autotagging.FeatureType;  
package org.opensearch.rule.storage;
            return Rule.Builder.fromXContent(parser, featureType).build();  
 */
            logger.info("Issue met when parsing rule : {}", e.getMessage());
        } catch (IOException e) {
    private static final Logger logger = LogManager.getLogger(XContentRuleParser.class);
    }
 *
public class XContentRuleParser implements RuleEntityParser {  
 * Rule parser for json XContent representation of Rule  
     * Constructor
import org.opensearch.core.xcontent.MediaTypeRegistry;
        try (
