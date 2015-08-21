package co.edu.uniandes.csw.mpcellphone.tests;

import java.util.Date;
import java.util.Random;
import java.util.Calendar;

public class _TestUtil {
    public static <T> T generateRandom(Class<T> objectClass) {
        Random r = new Random();
        if (objectClass.equals(String.class)) {
            String s = "";
            for (int i = 0; i < 10; i++) {
                char c = (char) (Math.abs(r.nextInt()) % ('Z' - 'A') + 'A');
                s = s + c;
            }
            return objectClass.cast(s);
        } else if (objectClass.equals(Integer.class)) {
            Integer s = r.nextInt();
            return objectClass.cast(s);
        } else if (objectClass.equals(Long.class)) {
            Long s = r.nextLong();
            return objectClass.cast(s);
        } else if (objectClass.equals(Date.class)) {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.MONTH, Math.abs(r.nextInt()) % 12);
            c.set(Calendar.DAY_OF_MONTH, Math.abs(r.nextInt()) % 30);
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            return objectClass.cast(c.getTime());
        }
        return null;
    }

    private final static java.text.SimpleDateFormat DATE_FORMAT = new java.text.SimpleDateFormat("dd/MM/yyyy");

    public static String generateRandomDate() {
        Random r = new Random();
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, Math.abs(r.nextInt()) % 12);
        c.set(Calendar.DAY_OF_MONTH, Math.abs(r.nextInt()) % 30);
        c.setLenient(true);
        return DATE_FORMAT.format(c.getTime());
    }

    public static Date parseDate(String date) {
        try {
            return DATE_FORMAT.parse(date);
        } catch (Exception e) {
            return null;
        }
    }
}
