package com.tagtraum.perf.gcviewer.imp;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * Tests the logic of the {@link DataReaderFactory}
 *
 * Date: Jan 30, 2002
 * Time: 5:53:55 PM
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 * @author <a href="mailto:gcviewer@gmx.ch">Joerg Wuethrich</a>
 */
public class TestDataReaderFactory {
    @Rule 
    public TestName name = new TestName();

    private void assertDataReader(
            Class<? extends DataReader> expected, 
            Class<? extends DataReader> actual) {
    
        assertDataReader(name.getMethodName(), expected, actual);
    }
    
    /**
     * Tests for equality of two {@link DataReader} classes.
     * 
     * @param testName name of the test to identify which test failed
     * @param expected expected type of DataReader
     * @param actual actual type of DataReader
     */
    private void assertDataReader(String testName, 
            Class<? extends DataReader> expected, 
            Class<? extends DataReader> actual) {
        
        assertEquals(testName, expected.getCanonicalName(), actual.getCanonicalName());
    }
    
    @Test
    public void testJRockit1_4GcReportGenCon() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2ts-gcreport-gencon.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_4_2.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_4GcReportParallel() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2ts-gcreport-parallel.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_4_2.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_4GcReportPrioPauseTime() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2ts-gcreport-gcpriopausetime.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_4_2.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_4GcReportPrioThroughput() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2ts-gcreport-gcpriothroughput.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_4_2.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_4GcReportSingleCon() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2ts-gcreport-singlecon.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_4_2.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_4GenCon() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2gencon.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_4GenConBig() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2gencon-big.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_4Parallel() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2parallel.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_4PrioPauseTime() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_4_2priopausetime.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_5GenCon() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_5_12_gencon.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_5GenConMemStats() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_5_20_memstats2.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_6_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_5GenPar() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_5_12_genpar.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_5PrioPausetime() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_5_12_gcpriopausetime.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_5PrioThroughput() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_5_12_gcpriothroughput.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_5SimpleOpts() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_5_12-gcreport-simpleopts-singlecon.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_5_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_6GenConVerbose() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_6_verbose_gc_mode_gencon.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_6_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_6GenParVerbose() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_6_33_gc_mode_genpar_verbosenursery.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_6_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_6ParCon() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_6_gc_mode_singleparcon.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_6_0.class, reader.getClass());
    }
    
    @Test
    public void testJRockit1_6ParConVerbose() throws Exception { 
        InputStream in = getClass().getResourceAsStream("SampleJRockit1_6_verbose_gc_mode_singleparcon.txt");
        DataReader reader = new DataReaderFactory().getDataReader(in);
        
        assertDataReader(DataReaderJRockit1_6_0.class, reader.getClass());
    }
    
    @Test
    public void testSun1_3_1() throws Exception {
        DataReaderFactory factory = new DataReaderFactory();
        DataReader dr = factory.getDataReader(new ByteArrayInputStream("[GC 1087K->462K(16320K), 0.0154134 secs]".getBytes()));
        assertDataReader("Sun1_3_1 GC", DataReaderSun1_3_1.class, dr.getClass());

        dr = factory.getDataReader(new ByteArrayInputStream("[Full GC 1087K->462K(16320K), 0.0154134 secs]".getBytes()));
        assertDataReader("Sun1_3_1 Full GC", DataReaderSun1_3_1.class, dr.getClass());
    }

    @Test
    public void testSun1_4_0() throws Exception {
        // although the input is java 1.4 the datareader returned should be 1.6
        // (DataReaderSun1_6_0 handles java 1.4, 1.5, 1.6, 1.7)
        DataReaderFactory factory = new DataReaderFactory();
        DataReader dr = factory.getDataReader(new ByteArrayInputStream("2.23492e-006: [GC 1087K->462K(16320K), 0.0154134 secs]".getBytes()));
        assertDataReader(DataReaderSun1_6_0.class, dr.getClass());
    }

}