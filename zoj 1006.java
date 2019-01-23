import java.util.Scanner;

public class zoj1006 {
	public static void main(String srgs[]) {
		try {
			String palinText = new String();
			char[] pt = new char[100];
			pt = palinText.toCharArray();
			char[] ct = new char[100];
			String cipherText = new String();
			ct = cipherText.toCharArray();
			int plainCode[] = new int[70];
			int cipherCode[] = new int[70];
			int len, k;
			while (true) {
				Scanner sc = new Scanner(System.in);
				k = sc.nextInt();
				if (k == 0) {
					break;
				}
				cipherText = sc.next();

				len = cipherText.length();
				for (int i = 0; i < len; i++) {
					if (ct[i] >= 'a' && ct[i] < 'z') {
						cipherCode[i] = ct[i] - 'a' + 1;
					} else if (ct[i] == '_') {
						cipherCode[i] = 0;
					} else if (ct[i] == '.') {
						cipherCode[i] = 27;
					}
				}
				for (int i = 0; i < len; i++) {
					plainCode[(i * k) % len] = (cipherCode[i] + i) % 28;
				}
				for (int i = 0; i < len; i++) {
					if (plainCode[i] >= 1 && plainCode[i] <= 26) {
						pt[i] = (char) ('a' - 1 + plainCode[i]);
					} else if (plainCode[i] == 0) {
						pt[i] = '_';

					} else if (plainCode[i] == 27) {
						pt[i] = '.';
					}

				}
				for (int i = 0; i < len; i++) {
					System.out.println(pt[i]);
				}
			}
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
