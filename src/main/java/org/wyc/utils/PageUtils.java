package org.wyc.utils;

public class PageUtils {
	/**
	 * 每页显示条数
	 */
	public static final int PAGE_NUM = 2;

	/**
	 * 根据当前页获得分页所需的开始条数和结束条数
	 * 
	 * @param currPage
	 * @return
	 */
	public static int[] getBeginEndNumByCurrPage(int currPage) {
		int[] result = new int[2];
		result[0] = (currPage - 1) * PAGE_NUM;
		result[1] = PAGE_NUM;
		return result;
	}

	public static int getAllPage(int allCount) {
		int result = 0;
		if (allCount % PAGE_NUM == 0) {
			result = allCount / PAGE_NUM;
		} else {
			result = allCount / PAGE_NUM + 1;
		}
		// 避免总记录数为零时总页数为零
		if (result == 0) {
			result = 1;
		}
		return result;
	}

}
