package alibaba;

public class test {

	static String CHN_NUMBER[] = { "��", "һ", "��", "��", "��", "��", "��", "��", "��", "��" };
	static String CHN_UNIT[] = { "", "ʮ", "��", "ǧ" }; // Ȩλ
	static String CHN_UNIT_SECTION[] = { "", "��", "��", "����" }; // ��Ȩλ

	/**
	 * �������ݵ���������
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
	 * ��������
	 */
	static Test_Data testData[] = { new Test_Data(0, "��"), new Test_Data(1, "һ"), new Test_Data(2, "��"),
			new Test_Data(3, "��"), new Test_Data(4, "��"), new Test_Data(5, "��"), new Test_Data(6, "��"),
			new Test_Data(7, "��"), new Test_Data(8, "��"), new Test_Data(9, "��"), new Test_Data(10, "һʮ"),
			new Test_Data(11, "һʮһ"), new Test_Data(110, "һ��һʮ"), new Test_Data(111, "һ��һʮһ"), new Test_Data(100, "һ��"),
			new Test_Data(102, "һ�����"), new Test_Data(1020, "һǧ���ʮ"), new Test_Data(1001, "һǧ��һ"),
			new Test_Data(1015, "һǧ��һʮ��"), new Test_Data(1000, "һǧ"), new Test_Data(10000, "һ��"),
			new Test_Data(20010, "������һʮ"), new Test_Data(20001, "������һ"), new Test_Data(100000, "һʮ��"),
			new Test_Data(1000000, "һ����"), new Test_Data(10000000, "һǧ��"), new Test_Data(100000000, "һ��"),
			new Test_Data(1000000000, "һʮ��"), new Test_Data(1000001000, "һʮ��һǧ"), new Test_Data(1000000100, "һʮ����һ��"),
			new Test_Data(200010, "��ʮ����һʮ"), new Test_Data(2000105, "��������һ������"), new Test_Data(20001007, "��ǧ��һǧ����"),
			new Test_Data(2000100190, "��ʮ����һʮ����һ�پ�ʮ"), new Test_Data(1040010000, "һʮ����ǧ��һ��"),
			new Test_Data(200012301, "������һ���ǧ������һ"), new Test_Data(2005010010, "��ʮ���������һ����һʮ")
			// new Test_Data(4009060200, "��ʮ����Ű������������"),
			// new Test_Data(4294967295, "��ʮ���ھ�ǧ�İپ�ʮ������ǧ���پ�ʮ��")

	};

	/**
	 * ����������ת��Ϊ�������ֵĺ����㷨ʵ�֡�
	 * 
	 * @param numΪ��Ҫת��Ϊ�������ֵİ��������֣����޷��ŵ�������
	 * @return
	 */
	public static String NumberToChn(int num) {
		StringBuffer returnStr = new StringBuffer();
		Boolean needZero = false;
		int pos = 0; // ��Ȩλ��λ��
		if (num == 0) {
			// ���numΪ0���������⴦��
			returnStr.insert(0, CHN_NUMBER[0]);
		}
		while (num > 0) {
			int section = num % 10000;
			if (needZero) {
				returnStr.insert(0, CHN_NUMBER[0]);
			}
			String sectionToChn = SectionNumToChn(section);
			// �ж��Ƿ���Ҫ��Ȩλ
			sectionToChn += (section != 0) ? CHN_UNIT_SECTION[pos] : CHN_UNIT_SECTION[0];
			returnStr.insert(0, sectionToChn);
			needZero = ((section < 1000 && section > 0) ? true : false); // �ж�section�е�ǧλ���ǲ���Ϊ�㣬��Ϊ��Ӧ�����һ���㡣
			pos++;
			num = num / 10000;
		}
		return returnStr.toString();
	}

	/**
	 * ����λ��sectionת��Ϊ��������
	 * 
	 * @param section
	 * @return
	 */
	public static String SectionNumToChn(int section) {
		StringBuffer returnStr = new StringBuffer();
		int unitPos = 0; // ��Ȩλ��λ�ñ�ţ�0-3����Ϊ��ʮ��ǧ;

		Boolean zero = true;
		while (section > 0) {

			int v = (section % 10);
			if (v == 0) {
				if ((section == 0) || !zero) {
					zero = true; /* ��Ҫ��0��zero��������ȷ���������Ķ��0��ֻ��һ�������� */
					// chnStr.insert(0, chnNumChar[v]);
					returnStr.insert(0, CHN_NUMBER[v]);
				}
			} else {
				zero = false; // ������һ�����ֲ���0
				StringBuffer tempStr = new StringBuffer(CHN_NUMBER[v]);// ����v����Ӧ����������
				tempStr.append(CHN_UNIT[unitPos]); // ����v����Ӧ������Ȩλ
				returnStr.insert(0, tempStr);
			}
			unitPos++; // ��λ
			section = section / 10;
		}
		return returnStr.toString();
	}

	/**
	 * ��ɽ�����������ת��Ϊ�������ֵĲ���
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
