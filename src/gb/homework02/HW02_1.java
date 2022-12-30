package gb.homework02;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * Дана строка sql-запроса "select * from students where ".
 * Сформируйте часть WHERE этого запроса, используя StringBuilder.
 * Данные для фильтрации приведены ниже в виде json строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */

public class HW02_1 {

    public static void main(String[] args) throws Exception {

        URL url = HW02_1.class.getResource("json1.json");
        Path fileName = Path.of(url.getPath());
        String jsonString = Files.readString(fileName);
        Map<String, Object> jsonObject = JSON.parse(jsonString);

        String sqlQuery = "SELECT * FROM students WHERE";
        StringBuilder builder = new StringBuilder();
        builder.append(sqlQuery).append(" ").append(fillQueryConditionsFromJson(jsonObject));
        System.out.println(builder);
    }

    private static StringBuilder fillQueryConditionsFromJson(Map<String, Object> jsonObject) {
        StringBuilder builder = new StringBuilder();
        Object rootValue = jsonObject.get("root");
        if (rootValue instanceof Map<?, ?>) {
            for (Map.Entry<String, Object> entry : ((Map<String, Object>) rootValue).entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null || value == "null") continue;
                builder.append(key).append(" = ");
                if (value instanceof String) {
                    builder.append("\"").append(value).append("\"");
                } else {
                    builder.append(value);
                }
                builder.append(" AND ");
            }
            builder.replace(builder.lastIndexOf(" AND "), builder.length(), "");
        }
        return builder;
    }
}
