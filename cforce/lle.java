import java.util.*;

public class lle {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = Integer.parseInt(in.nextLine());
		int x = N - 1;
		Queue<String[]> allCards = new LinkedList<String[]>();
		HashSet<String> lineup = new HashSet<String>();
		String l = in.nextLine();
		lineup.add(l);
		//System.out.println(lineup);
		allCards.add(l.split(" "));
		while (!allCards.isEmpty()) {
             
            
            System.out.println(lineup);
			String[] cards = allCards.poll();
			for(int i=0;i<cards.length;i++)
			System.out.print(cards[i]+" s ");
		System.out.println();
			x = cards.length - 1;
			if (x == 0) {
				break;
			}

			if (x - 1 > -1 && valid(cards[x], cards[x - 1])) {
				String[] c = put(Arrays.copyOf(cards, x + 1), x, x - 1);
				String[] d= Arrays.copyOf(c, c.length - 1);
				String l1  = Arrays.toString(d);
				if(!lineup.contains(l1)){
					allCards.add(d);
					lineup.add(l1);
				}
			}
			if (x - 3 > -1 && valid(cards[x], cards[x - 3])) {
				String[] c = put(Arrays.copyOf(cards, x + 1), x, x - 3);
				String [] d =  Arrays.copyOf(c, c.length - 1);
				String l1  = Arrays.toString(d);
				if(!lineup.contains(l1)){
					allCards.add(d);
					lineup.add(l1);
				}
			}
		}

		System.out.println(x == 0 ? "YES" : "NO");
	}

	private static String[] put(String[] cards, int x, int i) {
		cards[i] = cards[x];
		cards[x] = "EMPTY";
		return cards;
	}

	private static boolean valid(String l, String r) {
		return l.charAt(0) == r.charAt(0) || l.charAt(1) == r.charAt(1);
	}
}