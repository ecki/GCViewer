package com.tagtraum.perf.gcviewer.math;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * Date: Jan 30, 2002
 * Time: 5:53:55 PM
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 * @version $Id: $
 */
public class TestDoubleData extends TestCase {

    public TestDoubleData(String name) {
        super(name);
    }

    public void testSimpleAverage() throws Exception {
        double[] x = {1.0, 2.0};
        assertEquals("Simple average", 1.5, DoubleData.average(x), 0.0);
    }

    public void testSimpleStandardDeviation() throws Exception {
        DoubleData doubleData = new DoubleData();
        doubleData.add(1);
        doubleData.add(1);
        doubleData.add(-1);
        doubleData.add(-1);
        assertEquals("Simple std deviation", 1.1547005383792515, doubleData.standardDeviation(), 0.0000001);
    }

    public void testSimplePercentile() throws Exception {
        DoubleData doubleData = new DoubleData(true);
        doubleData.add(1);
        doubleData.add(2);
        doubleData.add(3);
        doubleData.add(4);
        doubleData.add(5);
        doubleData.add(6);
        doubleData.add(7);
        doubleData.add(8);
        doubleData.add(9);
        doubleData.add(10);
        // TODO: test shows: does not work with small data sets :-/
        assertEquals("Simple percentile estimate", 4.4867844, doubleData.estimatedPercentile(), 0.0000001);
    }


    public static TestSuite suite() {
        return new TestSuite(TestDoubleData.class);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
