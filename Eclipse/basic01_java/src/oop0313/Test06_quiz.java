package oop0313;

public class Test06_quiz {

	public static void main(String[] args) {
		// 연습문제
		//참조: 지폐갯수 구하는 문제
		/*	
		 1년: 365.2422일
		 출력결과: 365일 5시간 48분 46초
		 
		 1분:60초
		 1시간:3600초
		 1일:86400초
		 1년: 365.2422*86400=31556926.08
		 */
		double year=365.2422;
		System.out.print((int)31556926.08/86400 +"일");
		System.out.print(((int)31556926.08%86400)/3600+"시간");
		System.out.print((((int)31556926.08%86400)%3600)/60 +"분");
		System.out.println((((int)31556926.08%86400)%3600)%60 +"초");
	
		
		int total=(int)(year*86400);		
		System.out.println(total);
		
		int day=total/86400;
		System.out.println(day+"일"); //365
		
		total = total%86400;
		int hour =total/3600;
		System.out.println(hour+"시간");//5
		
		
		total= total%3600;
		int minute=total/60;
		System.out.println(minute+"분");
		
		int second=total%60;
		System.out.println(second+"초");
	}

}
