package mbs.cdi;

import java.util.HashMap;
import java.util.Map;

// era para usar um gerenciado de dependecias..mas nao deu tempo
public class BeansContext {

	private static BeansContext intance;

	private static Map<Class<?>, Object> services = new HashMap<>();

	private BeansContext() {
	}

	public static BeansContext getInstance() {
		if (intance == null) {
			intance = new BeansContext();
		}
		return intance;
	}

	public void addService(Class<?> clazz, Object obj) {
		services.put(clazz, obj);
	}

	public Object getService(Class<?> clazz) {
		return services.get(clazz);
	}
	
}
