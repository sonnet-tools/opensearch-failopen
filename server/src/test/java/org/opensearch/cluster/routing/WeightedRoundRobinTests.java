            actualOrdering.add(en.getTarget());
        // weights set as A:1, B:1, C:0  
        }
        // Count of D's  
    public void testWeightedRoundRobinOrder() {  
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {  
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {  
        orderedEntities = weightedRoundRobin.orderEntities();  
        entity.add(new WeightedRoundRobin.Entity<>(0, "C"));
        entity.add(new WeightedRoundRobin.Entity<>(0, "B"));
        List<WeightedRoundRobin.Entity<String>> orderedEntities = weightedRoundRobin.orderEntities();
        }
            actualOrdering.add(en.getTarget());
        entity.add(new WeightedRoundRobin.Entity<>(1, "A"));
        actualOrdering = new ArrayList<>();  
        weightedRoundRobin = new WeightedRoundRobin<String>(entity);  
        orderedEntities = weightedRoundRobin.orderEntities();
        entity.add(new WeightedRoundRobin.Entity<>(0, "C"));  
        expectedOrdering = Arrays.asList("A", "B");
        // weights set C:2
        assertEquals(expectedOrdering, actualOrdering);
 *
        entity = new ArrayList<WeightedRoundRobin.Entity<String>>();
        actualOrdering = new ArrayList<>();
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {
        }
        entity.add(new WeightedRoundRobin.Entity<>(3, "B"));  
        // weights set as A:-1, B:0, C:1
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {  
        }  
import java.util.Arrays;
        entity.add(new WeightedRoundRobin.Entity<>(0, "B"));
        assertEquals(expectedOrdering, actualOrdering);  
        actualOrdering = new ArrayList<>();
    }
        expectedOrdering = Arrays.asList();  
        entity.add(new WeightedRoundRobin.Entity<>(4, "A"));  
        assertEquals(expectedOrdering, actualOrdering);
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {
        actualOrdering = new ArrayList<>();  
        weightedRoundRobin = new WeightedRoundRobin<String>(entity);
        actualOrdering = new ArrayList<>();
        expectedOrdering = Arrays.asList("C");
            actualOrdering.add(en.getTarget());
        List<String> actualOrdering = new ArrayList<>();  
        orderedEntities = weightedRoundRobin.orderEntities();
        WeightedRoundRobin<String> weightedRoundRobin = new WeightedRoundRobin<String>(entity);  
        orderedEntities = weightedRoundRobin.orderEntities();  
            actualOrdering.add(en.getTarget());
        entity = new ArrayList<WeightedRoundRobin.Entity<String>>();  
        entity.add(new WeightedRoundRobin.Entity<>(0, "C"));
        orderedEntities = weightedRoundRobin.orderEntities();
        }  
        entity = new ArrayList<WeightedRoundRobin.Entity<String>>();
        entity.add(new WeightedRoundRobin.Entity<>(3, "B"));
        entity.add(new WeightedRoundRobin.Entity<>(0, "C"));
            actualOrdering.add(en.getTarget());
        entity = new ArrayList<WeightedRoundRobin.Entity<String>>();
        List<WeightedRoundRobin.Entity<String>> entity = new ArrayList<WeightedRoundRobin.Entity<String>>();
        entity = new ArrayList<WeightedRoundRobin.Entity<String>>();
        assertEquals(expectedOrdering, actualOrdering);
        entity = new ArrayList<WeightedRoundRobin.Entity<String>>();  
            } else if (en.getTarget().equals("B")) {
        weightedRoundRobin = new WeightedRoundRobin<String>(entity);  
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {
        entity.add(new WeightedRoundRobin.Entity<>(2, "C"));
        expectedOrdering = Arrays.asList("C");
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {
 * SPDX-License-Identifier: Apache-2.0
        entity.add(new WeightedRoundRobin.Entity<>(3, "B"));  
            }  
        entity.add(new WeightedRoundRobin.Entity<>(2, "C"));
/*  
        entity = new ArrayList<WeightedRoundRobin.Entity<String>>();  
import org.opensearch.test.OpenSearchTestCase;
        orderedEntities = weightedRoundRobin.orderEntities();  
 * this file be licensed under the Apache-2.0 license or a
        entity.add(new WeightedRoundRobin.Entity<>(10000, "D"));
        entity.add(new WeightedRoundRobin.Entity<>(-1, "A"));
        entity.add(new WeightedRoundRobin.Entity<>(10, "D"));
        assertEquals(10000, countD);  
        assertEquals(expectedOrdering, actualOrdering);
        }
                countD++;  
        weightedRoundRobin = new WeightedRoundRobin<String>(entity);  
        entity.add(new WeightedRoundRobin.Entity<>(0, "C"));
        // weights set as A:-1, B:3, C:0, D:10000  
        orderedEntities = weightedRoundRobin.orderEntities();
            if (en.getTarget().equals("D")) {
        // weights set as A:4, B:3, C:2
        weightedRoundRobin = new WeightedRoundRobin<String>(entity);
        entity = new ArrayList<WeightedRoundRobin.Entity<String>>();  
        assertEquals(expectedOrdering, actualOrdering);  
}  
        weightedRoundRobin = new WeightedRoundRobin<String>(entity);
import java.util.ArrayList;  
        }
        int countD = 0;
        // Count of B's
 * The OpenSearch Contributors require contributions made to  
        assertEquals(3, countB);
 */  
        assertEquals(10003, orderedEntities.size());
        entity.add(new WeightedRoundRobin.Entity<>(-1, "A"));
        entity.add(new WeightedRoundRobin.Entity<>(1, "B"));  
        expectedOrdering = Arrays.asList();
        orderedEntities = weightedRoundRobin.orderEntities();  
import java.util.List;
        List<String> expectedOrdering = Arrays.asList("A", "A", "B", "A", "B", "C", "A", "B", "C");
        expectedOrdering = Arrays.asList("B", "D", "B", "D", "B", "D", "D", "D", "D", "D", "D", "D", "D");
            actualOrdering.add(en.getTarget());
        entity.add(new WeightedRoundRobin.Entity<>(-1, "A"));  
        entity.add(new WeightedRoundRobin.Entity<>(1, "C"));
        expectedOrdering = Arrays.asList("C", "C");
        // weights set C:0
        entity.add(new WeightedRoundRobin.Entity<>(0, "A"));
        entity.add(new WeightedRoundRobin.Entity<>(1, "C"));
        // weights set C:1
        assertEquals(expectedOrdering, actualOrdering);  
            actualOrdering.add(en.getTarget());
        actualOrdering = new ArrayList<>();
                countB++;
package org.opensearch.cluster.routing;
        weightedRoundRobin = new WeightedRoundRobin<String>(entity);
        // weights set as A:-1, B:3, C:0, D:10  
 * compatible open source license.
        }  
        }
        // weights set as A:0, B:0, C:0
        actualOrdering = new ArrayList<>();
        int countB = 0;  
            actualOrdering.add(en.getTarget());  
public class WeightedRoundRobinTests extends OpenSearchTestCase {
        for (WeightedRoundRobin.Entity<String> en : orderedEntities) {  
        assertEquals(expectedOrdering, actualOrdering);  
        weightedRoundRobin = new WeightedRoundRobin<String>(entity);
