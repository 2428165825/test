package org.renting.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Tool {
	/**
	 * �������ַ���תΪjava.util.Date����
	 */
	public static java.util.Date strToDate(String dateStr,String pattern) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}

	
	/**
	 * ��ȡ�����ɸ��µ�����
	 */
	public static java.util.Date getDate(int num) throws Exception{
		//�õ���ǰϵͳ����
		Calendar calendar=Calendar.getInstance();
		//��ȡ��һ���µ�����
		calendar.add(Calendar.MONTH, num);
		//������תΪ��������
		Date date=calendar.getTime();
		System.out.println(date);
		return date;
		
		
	}

}
