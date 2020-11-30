package com.kian;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolutionIter implements Iterable<Integer> {
    List<Integer> values = new ArrayList<>();

    public SolutionIter(Reader inp) {
        final StringBuilder sb = new StringBuilder();
        try {
            int data = inp.read();
            while (data != -1) {
                if (data != 10 && data != 13) {
                    sb.append((char) data);
                } else {
                    addValue(sb.toString());
                    sb.setLength(0);
                }
                data = inp.read();
            }
            addValue(sb.toString());

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void addValue(final String str) {
        try {
            final Integer intValue = Integer.valueOf(str.trim());
            if (intValue >= -1000000000 && intValue <= 1000000000) {
                values.add(intValue);
            }
        } catch (final NumberFormatException e) {
            // do nothing
        }
    }

    public Iterator<Integer> iterator() {
        return values.iterator();
    }
}
