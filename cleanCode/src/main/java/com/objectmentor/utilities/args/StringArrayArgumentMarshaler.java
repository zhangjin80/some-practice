package com.objectmentor.utilities.args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import static com.objectmentor.utilities.args.ArgsException.ErrorCode.*;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
    private String[] stringArrValue;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter;
        try {
            parameter = currentArgument.next();
            ArrayList<String> re = new ArrayList<>();
            for (String w : parameter.split(",")) {
                if (!w.trim().isEmpty())
                    re.add(w.trim());
            }
            stringArrValue = new String[re.size()];
            re.toArray(stringArrValue);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String[] getValue(ArgumentMarshaler am) {
        if (am instanceof StringArrayArgumentMarshaler) {
            return ((StringArrayArgumentMarshaler) am).stringArrValue;
        } else {
            return new String[]{};
        }
    }
}
