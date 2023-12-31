package com.liskovsoft.leankeyboard.ime;

import java.util.Locale;

public class LeanbackLocales {
   public static final Locale ALBANIANIAN;
   public static final Locale AZERBAIJANI;
   public static final Locale[] AZERTY;
   public static final Locale BASQUE_SPANISH;
   public static final Locale BELGIAN_DUTCH;
   public static final Locale BRITISH_ENGLISH = new Locale("en", "GB");
   public static final Locale CANADIAN_FRENCH;
   public static final Locale CATALAN;
   public static final Locale CROATIAN;
   public static final Locale CZECH;
   public static final Locale DANISH;
   public static final Locale ENGLISH;
   public static final Locale ESTONIAN;
   public static final Locale FINNISH;
   public static final Locale FRENCH;
   public static final Locale GALIC_SPANISH;
   public static final Locale GERMAN;
   public static final Locale HUNGARIAN;
   public static final Locale INDIAN_ENGLISH;
   public static final Locale NORWEGIAN;
   public static final Locale OTHER_SPANISH;
   public static final Locale[] QWERTY_AZ;
   public static final Locale[] QWERTY_CA;
   public static final Locale[] QWERTY_DA;
   public static final Locale[] QWERTY_ES_EU;
   public static final Locale[] QWERTY_ES_US;
   public static final Locale[] QWERTY_ET;
   public static final Locale[] QWERTY_FI;
   public static final Locale[] QWERTY_GB;
   public static final Locale[] QWERTY_IN;
   public static final Locale[] QWERTY_NB;
   public static final Locale[] QWERTY_SV;
   public static final Locale[] QWERTY_US;
   public static final Locale[] QWERTZ;
   public static final Locale[] QWERTZ_CH;
   public static final Locale SERBIAN;
   public static final Locale SLOVENIAN;
   public static final Locale SPAIN_SPANISH;
   public static final Locale SWEDISH;
   public static final Locale SWISS_FRENCH;
   public static final Locale SWISS_GERMAN;
   public static final Locale SWISS_ITALIAN;

   static {
      QWERTY_GB = new Locale[]{BRITISH_ENGLISH};
      INDIAN_ENGLISH = new Locale("en", "IN");
      QWERTY_IN = new Locale[]{INDIAN_ENGLISH};
      SPAIN_SPANISH = new Locale("es", "ES");
      GALIC_SPANISH = new Locale("gl", "ES");
      BASQUE_SPANISH = new Locale("eu", "ES");
      QWERTY_ES_EU = new Locale[]{SPAIN_SPANISH, GALIC_SPANISH, BASQUE_SPANISH};
      OTHER_SPANISH = new Locale("es", "");
      QWERTY_ES_US = new Locale[]{OTHER_SPANISH};
      AZERBAIJANI = new Locale("az", "");
      QWERTY_AZ = new Locale[]{AZERBAIJANI};
      CATALAN = new Locale("ca", "");
      QWERTY_CA = new Locale[]{CATALAN};
      DANISH = new Locale("da", "");
      QWERTY_DA = new Locale[]{DANISH};
      ESTONIAN = new Locale("et", "");
      QWERTY_ET = new Locale[]{ESTONIAN};
      FINNISH = new Locale("fi", "");
      QWERTY_FI = new Locale[]{FINNISH};
      NORWEGIAN = new Locale("nb", "");
      QWERTY_NB = new Locale[]{NORWEGIAN};
      SWEDISH = new Locale("sv", "");
      QWERTY_SV = new Locale[]{SWEDISH};
      ENGLISH = Locale.ENGLISH;
      CANADIAN_FRENCH = Locale.CANADA_FRENCH;
      QWERTY_US = new Locale[]{ENGLISH, CANADIAN_FRENCH};
      SWISS_GERMAN = new Locale("de", "CH");
      SWISS_ITALIAN = new Locale("it", "CH");
      QWERTZ_CH = new Locale[]{SWISS_GERMAN, SWISS_ITALIAN};
      GERMAN = new Locale("de", "");
      CROATIAN = new Locale("hr", "");
      CZECH = new Locale("cs", "");
      SWISS_FRENCH = new Locale("fr", "CH");
      HUNGARIAN = new Locale("hu", "");
      SERBIAN = new Locale("sr", "");
      SLOVENIAN = new Locale("sl", "");
      ALBANIANIAN = new Locale("sq", "");
      QWERTZ = new Locale[]{GERMAN, CROATIAN, CZECH, SWISS_FRENCH, SWISS_ITALIAN, HUNGARIAN, SERBIAN, SLOVENIAN, ALBANIANIAN};
      FRENCH = Locale.FRENCH;
      BELGIAN_DUTCH = new Locale("nl", "BE");
      AZERTY = new Locale[]{FRENCH, BELGIAN_DUTCH};
   }
}
