/**
 * 
 */
package sheet6;

/**
 * @author bejahrer
 *
 */
import java.util.Map;
import java.util.HashMap;

public class StudentList {
	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		System.out.println("isEmpty nach Anlegen der Map: " + m.isEmpty());

		m.put("09812345678", "Mustermann");
		m.put("keyOne", "Musterfrau");
		m.put("keyTwo", "Alex");
		m.put("keyThree", "Another value");

		System.out.println("isEmpty nach Einfügen eines Elements: " + m.isEmpty());

		System.out.println("all keys of the map: " + m.keySet());

		System.out.println("size of the map: " + m.size());

		m.replace("keyOne", "New Value");

		m.putIfAbsent("keyOne", "AbsentOne");
		m.putIfAbsent("keyFout", "AbsentTwo");

		System.out.println(m.containsValue("AbsentOne"));
		System.out.println(m.containsValue("AbsentTwo"));

		System.out.println(m.containsKey("AbsentOne"));
		System.out.println(m.containsKey("AbsentTwo"));

		System.out.println(m.getOrDefault("keyOne", "defaultValue"));
		System.out.println(m.getOrDefault("KEYONE", "defaultValue"));

		// ... Hier noch mindestens 7 Methoden ausprobieren
		for (Map.Entry<String, String> e : m.entrySet())
			System.out.println(e.getKey() + " --> " + e.getValue());
	}
}