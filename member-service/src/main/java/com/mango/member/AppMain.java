package com.mango.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 * 
 * </pre>
 *
 * @author Administrator
 * @since 1.0.0
 */
public class AppMain {

	private static final Logger log = LoggerFactory.getLogger(AppMain.class);

	private static volatile boolean running = true;

	static ClassPathXmlApplicationContext context;

	public static void main(String[] args) {
		log.info("\nstart ------------com.juanpi.goods.service -----------\n");
		log.info("\nstarting ---------com.juanpi.goods.service ---------\n");

		context = new ClassPathXmlApplicationContext("application.xml");
		context.start();

		log.info("\n-----------------goods service has been started-------------\n");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				if (context != null) {
					context.stop();
					context.close();
					context = null;
				}
				log.info("service " + AppMain.class.getSimpleName() + " stopped!");
				synchronized (AppMain.class) {
					running = false;
					AppMain.class.notify();
				}
			}
		});

		synchronized (AppMain.class) {
			while (running) {
				try {
					AppMain.class.wait();
				} catch (Throwable e) {
				}
			}
		}

	}
}
