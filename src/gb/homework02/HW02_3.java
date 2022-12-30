package gb.homework02;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/** Дана json строка (можно сохранить в файл и читать из файла)
 * [{"фамилия":"Иванов","оценка":"5", "предмет":"Математика"},{"фамилия":"Петрова","оценка":"4",
 * "предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 *
 * Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 *
 * Пример вывода:
 *
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.
*/

public class HW02_3 {

    public static void main(String[] args) throws Exception {

        URL url = HW02_3.class.getResource("json2.json");
        Path fileName = Path.of(url.getPath());
        String jsonString = Files.readString(fileName);
        Map<String, Object> jsonObject = JSON.parse(jsonString);

        StringBuilder builder = new StringBuilder();

        Object rootValue = jsonObject.get("root");
        if (rootValue instanceof List<?>) {
            for (Map student : (List<Map>) rootValue) {
                builder.append("Студент ").append(student.get("фамилия"));
                builder.append(" получил ").append(student.get("оценка"));
                builder.append(" по предмету ").append(student.get("предмет"));
                builder.append(".").append("\n");
            }
        }

        System.out.println(builder);
    }
}
