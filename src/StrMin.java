import java.util.* ;
/**
 * author : satyam naolekar
 * StrMin
 */
public class StrMin {
    static void minStrIT(String str){
        char[] arr = str.toCharArray();
        int prv = 0;
        int next = 1;
        while (next < arr.length) {
            if (arr[prv] == arr[next]) {
                arr[next] = 0;
                next++;
                while (next < arr.length && (arr[prv] == arr[next])) {
                    arr[next] = 0;
                    next++;
                }
                arr[prv] = 0;
                while (prv > 0 && arr[--prv] == 0);
            } else {
                ++next;
                while (prv < next-1 && arr[++prv] == 0);
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0)
                System.out.print(arr[j]);
        }
        System.out.println();

    }

    static void minStrRec(char[] chr) {
        Boolean red = false;
        int prv = 0;
        while (prv<chr.length && chr[prv] == 0){
            prv++;
        }
        int next = prv + 1;
        while (next < chr.length) {
            prv= next-1 ;
            while(prv < chr.length-1 && chr[prv]==0){
                prv++;
            }
            next = prv + 1;
            char temp = chr[prv];
            if (next<chr.length && (temp == chr[next] || chr[next] == 0)) {
                while (next<chr.length && (temp == chr[next] || chr[next] == 0)) {
                    if (temp == chr[next]) {
                        chr[next] = 0;
                        chr[prv] = 0;
                        red = true;
                    }
                    next++;
                }
            } else {
                prv = next;
                next = next + 1;
            }
        }
        if (red) {
            minStrRec(chr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        minStrIT(str);
        char[] ch= str.toCharArray();
        minStrRec(ch);
        for (int j = 0; j < ch.length; j++) {
            if (ch[j] != 0)
                System.out.print(ch[j]);
        }
        System.out.println();
        sc.close();
    }
}