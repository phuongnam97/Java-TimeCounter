package vn.maize.TimeCounter.utils;

public class TimeCounter {
	
	private static Long startTime = 0L;
	
	private static Long timeSpend = 0L;

	public static void startCounting() {
		startTime = System.currentTimeMillis();
		timeSpend = 0L;
	}
	
	public static void pause(Long currentTime) {
		timeSpend += (currentTime - startTime)/1000;
		startTime = 0L;
	}
	
	public static void continueCounting(Long currentTime) {
		startTime = System.currentTimeMillis();
	}
	
	public static String countTimeSpend(Long currentTime) {
		if (startTime == 0L) return null;
		Long totalTimeSpend = timeSpend + (currentTime - startTime)/1000;
		
		Long hours = totalTimeSpend/3600;
		Long minutes = (totalTimeSpend - hours * 3600)/60;
		Long seconds = totalTimeSpend - hours * 3600 - minutes * 60;
		
		String hoursStr = hours > 9 ? "" + hours : "0"+ hours;
		String minsStr = minutes > 9 ? "" + minutes : "0"+ minutes;
		String secondsStr = seconds > 9 ? "" + seconds : "0"+ seconds;
		return hoursStr+":"+minsStr+":"+secondsStr;
	}
	
	public static void main (String[] args) {
		System.out.println(countTimeSpend(16670002L));
	}
}
