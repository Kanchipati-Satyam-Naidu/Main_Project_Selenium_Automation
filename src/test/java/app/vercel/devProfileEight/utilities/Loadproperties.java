package app.vercel.devProfileEight.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Loadproperties {
	
		public static Properties loadProps() {
			Properties props=new Properties();
			try {
				FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
				props.load(file);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return props;
		}

	}


