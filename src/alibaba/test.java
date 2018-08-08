package alibaba;

public class test {

	static String CHN_NUMBER[] = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
	static String CHN_UNIT[] = { "", "十", "百", "千" }; // 权位
	static String CHN_UNIT_SECTION[] = { "", "万", "亿", "万亿" }; // 节权位

	/**
	 * 测试数据的数据类型
	 */
	public static class Test_Data {
		int number;
		String chnNum;

		public Test_Data(int number, String chnNum) {
			this.chnNum = chnNum;
			this.number = number;
		}
	}

	/**
	 * 测试数据
	 */
	static Test_Data testData[] = { new Test_Data(0, "零"), new Test_Data(1, "一"), new Test_Data(2, "二"),
			new Test_Data(3, "三"), new Test_Data(4, "四"), new Test_Data(5, "五"), new Test_Data(6, "六"),
			new Test_Data(7, "七"), new Test_Data(8, "八"), new Test_Data(9, "九"), new Test_Data(10, "一十"),
			new Test_Data(11, "一十一"), new Test_Data(110, "一百一十"), new Test_Data(111, "一百一十一"), new Test_Data(100, "一百"),
			new Test_Data(102, "一百零二"), new Test_Data(1020, "一千零二十"), new Test_Data(1001, "一千零一"),
			new Test_Data(1015, "一千零一十五"), new Test_Data(1000, "一千"), new Test_Data(10000, "一万"),
			new Test_Data(20010, "二万零一十"), new Test_Data(20001, "二万零一"), new Test_Data(100000, "一十万"),
			new Test_Data(1000000, "一百万"), new Test_Data(10000000, "一千万"), new Test_Data(100000000, "一亿"),
			new Test_Data(1000000000, "一十亿"), new Test_Data(1000001000, "一十亿一千"), new Test_Data(1000000100, "一十亿零一百"),
			new Test_Data(200010, "二十万零一十"), new Test_Data(2000105, "二百万零一百零五"), new Test_Data(20001007, "二千万一千零七"),
			new Test_Data(2000100190, "二十亿零一十万零一百九十"), new Test_Data(1040010000, "一十亿四千零一万"),
			new Test_Data(200012301, "二亿零一万二千三百零一"), new Test_Data(2005010010, "二十亿零五百零一万零一十")
			// new Test_Data(4009060200, "四十亿零九百零六万零二百"),
			// new Test_Data(4294967295, "四十二亿九千四百九十六万七千二百九十五")

	};

	/**
	 * 阿拉伯数字转换为中文数字的核心算法实现。
	 * 
	 * @param num为需要转换为中文数字的阿拉伯数字，是无符号的整形数
	 * @return
	 */
	public static String NumberToChn(int num) {
		StringBuffer returnStr = new StringBuffer();
		Boolean needZero = false;
		int pos = 0; // 节权位的位置
		if (num == 0) {
			// 如果num为0，进行特殊处理。
			returnStr.insert(0, CHN_NUMBER[0]);
		}
		while (num > 0) {
			int section = num % 10000;
			if (needZero) {
				returnStr.insert(0, CHN_NUMBER[0]);
			}
			String sectionToChn = SectionNumToChn(section);
			// 判断是否需要节权位
			sectionToChn += (section != 0) ? CHN_UNIT_SECTION[pos] : CHN_UNIT_SECTION[0];
			returnStr.insert(0, sectionToChn);
			needZero = ((section < 1000 && section > 0) ? true : false); // 判断section中的千位上是不是为零，若为零应该添加一个零。
			pos++;
			num = num / 10000;
		}
		return returnStr.toString();
	}

	/**
	 * 将四位的section转换为中文数字
	 * 
	 * @param section
	 * @return
	 */
	public static String SectionNumToChn(int section) {
		StringBuffer returnStr = new StringBuffer();
		int unitPos = 0; // 节权位的位置编号，0-3依次为个十百千;

		Boolean zero = true;
		while (section > 0) {

			int v = (section % 10);
			if (v == 0) {
				if ((section == 0) || !zero) {
					zero = true; /* 需要补0，zero的作用是确保对连续的多个0，只补一个中文零 */
					// chnStr.insert(0, chnNumChar[v]);
					returnStr.insert(0, CHN_NUMBER[v]);
				}
			} else {
				zero = false; // 至少有一个数字不是0
				StringBuffer tempStr = new StringBuffer(CHN_NUMBER[v]);// 数字v所对应的中文数字
				tempStr.append(CHN_UNIT[unitPos]); // 数字v所对应的中文权位
				returnStr.insert(0, tempStr);
			}
			unitPos++; // 移位
			section = section / 10;
		}
		return returnStr.toString();
	}

	/**
	 * 完成将阿拉伯数字转换为中文数字的测试
	 */
	public static void TestNumToChn() {
		for (int i = 0; i < testData.length; i++) {
			String str = NumberToChn(testData[i].number);
			System.out.println(testData[i].number + "\t" + testData[i].chnNum + "\t" + str + "\t"
					+ str.equals(testData[i].chnNum));
		}

	}
	 public static void main(String[] args) {  
	        TestNumToChn();  }
}
