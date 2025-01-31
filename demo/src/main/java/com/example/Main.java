package com.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.UnknownFormatConversionException;

@SuppressWarnings(value = { "null", "unused" })
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        List<Object> list = new ArrayList();
        list.add(new Integer(1234));
        System.out.print(list);

        System.out.println("Findbugs Sample 001 for BC_IMPOSSIBLE_CAST");
        // WRONG
        try {
          Main.bcImpossibleCastWRONG();
        } catch (final ClassCastException e) {
          System.out.println("   - ERROR:" + e.getMessage());
        }
        // CORRECT
        Main.bcImpossibleCastCORRECT();
    
        System.out.println("Findbugs Sample 002 for BC_IMPOSSIBLE_DOWNCAST");
        // WRONG
        try {
          Main.bcImpossibleDowncastWRONG();
        } catch (final ClassCastException e) {
          System.out.println("   - ERROR:" + e.getMessage());
        }
        // CORRECT
        Main.bcImpossibleDowncastCORRECT();
    
        System.out.println("Findbugs Sample 003 for BC_IMPOSSIBLE_INSTANCEOF");
        // WRONG
        Main.bcImpossibleInstanceOfWRONG();
        // CORRECT
        Main.bcImpossibleInstanceOfCORRECT();
    
        System.out.println("Findbugs Sample 004 for BC_IMPOSSIBLE_DOWNCAST_OF_TOARRAY");
        // WRONG
        try {
          Main.bcImpossibleDowncastOfArrayWRONG();
        } catch (final ClassCastException e) {
          System.out.println("   - ERROR:" + e.getMessage());
        }
        // CORRECT
        Main.bcImpossibleDowncastOfArrayCORRECT();
    
        System.out.println("Findbugs Sample 005 for DMI_BIGDECIMAL_CONSTRUCTED_FROM_DOUBLE");
        // WRONG
        Main.dmiBigDecimalConstructedFromDoubleWRONG();
        // CORRECT
        Main.dmiBigDecimalConstructedFromDoubleCORRECT();
    
        System.out.println("Findbugs Sample 006 for ES_COMPARING_STRINGS_WITH_EQ");
        // WRONG
        Main.esComparingStringsWithEqWRONG();
        // CORRECT
        Main.esComparingStringsWithEqCORRECT();
    
        System.out.println("Findbugs Sample 007 for VA_FORMAT_STRING_ILLEGAL");
        // WRONG
        try {
          Main.vaFormatStringIllegalWRONG();
        } catch (final UnknownFormatConversionException e) {
          System.out.println("   - ERROR:" + e.getMessage());
        }
        // CORRECT
        Main.vaFormatStringIllegalCORRECT();
    
        System.out.println("Findbugs Sample 008 for RV_RETURN_VALUE_IGNORED");
        // WRONG
        Main.rvReturnValueIgnoredWRONG();
        // CORRECT
        Main.rvReturnValueIgnoredCORRECT();
    
        System.out.println("Findbugs Sample 009 for NP_ALWAYS_NULL");
        // WRONG
        try {
          Main.npAlwaysNullWRONG();
        } catch (final NullPointerException e) {
          System.out.println("   - ERROR:" + e.getMessage());
        }
        // CORRECT
        Main.npAlwaysNullCORRECT();
    
        System.out.println("Findbugs Sample 010 for QBA_QUESTIONABLE_BOOLEAN_ASSIGNMENT");
        // WRONG
        Main.qabQuestionableBooleanAssignmentWRONG();
        // CORRECT
        Main.qabQuestionableBooleanAssignmentCORRECT();
    }

    private static void bcImpossibleCastWRONG() {
        final Object doubleValue = Double.valueOf(1.0);
        final Long value = (Long) doubleValue;
        System.out.println("   - " + value);
      }
    
      private static void bcImpossibleCastCORRECT() {
        final Object doubleValue = Double.valueOf(1.0);
        final Double value = (Double) doubleValue;
        System.out.println("   - " + value);
      }
    
      private static void bcImpossibleDowncastWRONG() {
        final Object exception = new RuntimeException("abc");
        final SecurityException value = (SecurityException) exception;
        System.out.println("   - " + value.getMessage());
      }
    
      private static void bcImpossibleDowncastCORRECT() {
        final Object exception = new RuntimeException("abc");
        final RuntimeException value = (RuntimeException) exception;
        System.out.println("   - " + value.getMessage());
      }
    
      private static void bcImpossibleInstanceOfWRONG() {
        final Object value = Double.valueOf(1.0);
        System.out.println("   - " + (value instanceof Long));
      }
    
      private static void bcImpossibleInstanceOfCORRECT() {
        final Object value = Double.valueOf(1.0);
        System.out.println("   - " + (value instanceof Double));
      }
    
      private static void bcImpossibleDowncastOfArrayWRONG() {
        final Collection<String> stringVector = new ArrayList<String>();
        stringVector.add("abc");
        stringVector.add("xyz");
        final String[] stringArray = (String[]) stringVector.toArray();
        System.out.println("   - " + stringArray.length);
      }
    
      private static void bcImpossibleDowncastOfArrayCORRECT() {
        final Collection<String> stringVector = new ArrayList<String>();
        stringVector.add("abc");
        stringVector.add("xyz");
        final String[] stringArray = stringVector.toArray(new String[stringVector.size()]);
        System.out.println("   - " + stringArray.length);
      }
    
      private static void dmiBigDecimalConstructedFromDoubleWRONG() {
        final BigDecimal bigDecimal = new BigDecimal(3.1);
        System.out.println("   - " + bigDecimal.toString());
      }
    
      private static void dmiBigDecimalConstructedFromDoubleCORRECT() {
        final BigDecimal bigDecimal = new BigDecimal("3.1");
        System.out.println("   - " + bigDecimal.toString());
      }
    
      private static void esComparingStringsWithEqWRONG() {
        final StringBuilder sb1 = new StringBuilder("1234");
        final StringBuilder sb2 = new StringBuilder("1234");
        final String string1 = sb1.toString();
        final String string2 = sb2.toString();
        System.out.println("   - " + (string1 == string2));
      }
    
      private static void esComparingStringsWithEqCORRECT() {
        final StringBuilder sb1 = new StringBuilder("1234");
        final StringBuilder sb2 = new StringBuilder("1234");
        final String string1 = sb1.toString();
        final String string2 = sb2.toString();
        System.out.println("   - " + string1.equals(string2));
      }
    
      private static void vaFormatStringIllegalWRONG() {
        System.out.println(String.format("   - %>s  %s", "10", "9"));
      }
    
      private static void vaFormatStringIllegalCORRECT() {
        System.out.println(String.format("   - %s > %s", "10", "9"));
      }
    
      private static void rvReturnValueIgnoredWRONG() {
        final BigDecimal bigDecimal = BigDecimal.ONE;
        bigDecimal.add(BigDecimal.ONE);
        System.out.println(String.format("   - " + bigDecimal));
      }
    
      private static void rvReturnValueIgnoredCORRECT() {
        final BigDecimal bigDecimal = BigDecimal.ONE;
        final BigDecimal newValue = bigDecimal.add(BigDecimal.ONE);
        System.out.println(String.format("   - " + newValue));
      }
    
      private static void npAlwaysNullWRONG() {
        final String value = null;
        if (null != value & value.length() > 2) {
          System.out.println(String.format("   - " + value));
        } else {
          System.out.println(String.format("   - value is invalid"));
        }
      }
    
      private static void npAlwaysNullCORRECT() {
        final String value = null;
        if (null != value && value.length() > 2) {
          System.out.println(String.format("   - " + value));
        } else {
          System.out.println(String.format("   - value is invalid"));
        }
      }
    
      private static void qabQuestionableBooleanAssignmentWRONG() {
        boolean value = false;
        if (value = true) {
          System.out.println(String.format("   - value is true"));
        } else {
          System.out.println(String.format("   - value is false"));
        }
      }
    
      private static void qabQuestionableBooleanAssignmentCORRECT() {
        final boolean value = false;
        if (value == true) {
          System.out.println(String.format("   - value is true"));
        } else {
          System.out.println(String.format("   - value is false"));
        }
      }    
}