package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

	private final static Logger log = LoggerFactory.getLogger(Log.class);
	
	public static void main(String[] args) {
		long sTime = System.currentTimeMillis();
		
		int sum = 0;
		
		for(int i=0; i<1000000; i++) {
			sum+=i;
			log.debug("sum => {}" , sum);
		
		}
		log.info("sum => {}", sum);
		long eTime = System.currentTimeMillis();
		log.info("execute time: {}ms", eTime-sTime);
		
		
	}
}
