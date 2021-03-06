package net.otterbase.oframework;

import java.io.File;
import java.util.Properties;
import java.util.Set;

import net.sf.json.JSONObject;

public class OFContext {
	
	private static OFContext _instance;
	public static OFContext getInstance() {
		if (_instance == null) _instance = new OFContext();
		return _instance;
	}
	
	private JSONObject property;
	private OFContext() {
		try {
			Properties p = new Properties();
			
			String path = getClass().getResource("/otter.properties").getPath();
			path = path.substring(0, path.lastIndexOf("/"));
			
			File dir = new File(path);
			for (File file : dir.listFiles()) {
				if (file.isDirectory() || !file.getName().endsWith(".properties")) continue;
				p.load(getClass().getResourceAsStream("/" + file.getName()));
			}

			property = new JSONObject();
			for(Object key : p.keySet()) {
				property.put(key.toString(), p.getProperty(key.toString()));
			}
			
			p.clear();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		try {
			if (_instance == null) _instance = new OFContext();
			return _instance.property.getString(key);
		}
		catch(Exception ex) {
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public static Set<String> keySet() {
		if (_instance == null) _instance = new OFContext();
		return _instance.property.keySet();
	}

}
