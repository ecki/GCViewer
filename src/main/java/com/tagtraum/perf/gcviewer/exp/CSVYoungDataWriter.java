package com.tagtraum.perf.gcviewer.exp;

import com.tagtraum.perf.gcviewer.model.AbstractGCEvent.Type;
import com.tagtraum.perf.gcviewer.model.GCEvent;
import com.tagtraum.perf.gcviewer.model.GCModel;
import com.tagtraum.perf.gcviewer.model.AbstractGCEvent.Generation;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Locale;

/**
 * @author Bernd Eckenfels
 */
public class CSVYoungDataWriter implements DataWriter {

    private PrintWriter out;

    public CSVYoungDataWriter(OutputStream out) {
        this.out = new PrintWriter(new OutputStreamWriter(out));
    }

    private void writeHeader() {
        out.println("Timestamp,Distance(s),YGUsedBefore(K),YGUsedAfter(K),Promoted(K),YGCapacity(K),Pause(s)");
    }

    /**
     * Writes the model and flushes the internal PrintWriter.
     */
    public void write(GCModel model) throws IOException {
        writeHeader();

        double last = 0d;

        for (Iterator i = model.getGCEvents(); i.hasNext();) {
            GCEvent event = (GCEvent) i.next();

            if (event.getGeneration() != Generation.YOUNG)
            	continue;

            GCEvent young = event.getYoung();

            if (young.getType() == Type.UNDEFINED)
            	continue;

            double ts = young.getTimestamp();
            out.printf(Locale.ROOT, "%.3f", ts);
            out.print(',');

            if (last != 0) {
            	out.printf(Locale.ROOT, "%.3f", (ts-last));
            } else {
            	out.printf(Locale.ROOT, "%.3f", 0d);
            }
            last = ts;

            int collected = young.getPreUsed() - young.getPostUsed();
            int shrinked = event.getPreUsed() - event.getPostUsed();

            out.print(',');
            out.print(young.getPreUsed());
            out.print(',');
            out.print(young.getPostUsed());
            out.print(',');
            out.print(collected - shrinked); // promoted
            out.print(',');
            out.print(young.getTotal()); // YG capacity
            out.print(',');
            out.print(young.getPause());
            out.println();
        }
        out.flush();
    }

    public void close() {
        if (out != null) out.close();
    }
}
