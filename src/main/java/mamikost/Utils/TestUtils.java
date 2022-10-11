package mamikost.Utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.JsonObject;

@Slf4j
@Component
public final class TestUtils {

    public static String getCurrentDate(SimpleDateFormat format) {
        Date date = new Date();
        return format.format(date);
    }

    public static void replacePropertyValue(JsonObject jsonObject, String property, String value) {
        jsonObject.remove(property);
        jsonObject.addProperty(property, value);
    }

    public static String getUniqueEmail() {
        return "email" + System.currentTimeMillis() + "@gmail.com";
    }
    /**
     * Gets the first value or.
     *
     * @param <T>          the generic type
     * @param array        the array
     * @param defaultValue the default value
     * @return the first value or
     */
    public static <T> T getFirstValueOr(T[] array, T defaultValue) {
        if ((array != null) && (array.length > 0) && (array[0] != null)) {
            return array[0];
        }
        return defaultValue;
    }
}

