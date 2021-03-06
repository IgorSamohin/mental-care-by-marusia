package com.polis.api.utils;

import com.ibm.icu.text.RuleBasedNumberFormat;

import java.text.ParseException;
import java.util.Locale;

public class NumberTransformUtils {
    private static final RuleBasedNumberFormat numberFormat = new RuleBasedNumberFormat(
            Locale.forLanguageTag("ru"),
            RuleBasedNumberFormat.SPELLOUT
    );

    public static int numberFromString(String number) throws ParseException {
        return numberFormat.parse(number).intValue();
    }

    public static String stringFromNumber(int number) {
        return numberFormat.format(number);
    }
}
